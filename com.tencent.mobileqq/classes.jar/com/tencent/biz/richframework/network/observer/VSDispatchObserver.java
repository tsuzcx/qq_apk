package com.tencent.biz.richframework.network.observer;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import bgau;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.observer.BusinessObserver;
import xvv;

public class VSDispatchObserver
  implements BusinessObserver
{
  private static final int CALL_BACK_REMOVED_CODE = -100004;
  private static final int FINAL_RSP_NULL_CODE = -100003;
  private static final int FROM_MSG_NULL_CODE = -100002;
  public static final int TIMEOUT_CODE = -100001;
  private final String NETWORK_ERROR_HINT = "网络错误";
  private final ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, VSDispatchObserver.onVSRspCallBack>> mCallBackCollectMap = new ConcurrentHashMap();
  private Handler mMainHandler;
  
  private void doOnReceiveCallBack(VSBaseRequest paramVSBaseRequest, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack, long paramLong, String paramString, boolean paramBoolean, MessageMicro paramMessageMicro)
  {
    if (((!paramBoolean) || (paramLong != 0L)) && (paramVSBaseRequest.isNeedRetry(paramLong)) && (paramVSBaseRequest.getRetryCount() > 0))
    {
      paramVSBaseRequest.setEnableCache(false);
      paramVSBaseRequest.setRetryCount(paramVSBaseRequest.getRetryCount() - 1);
      VSNetworkHelper.getInstance().sendRequest(paramVSBaseRequest, paramonVSRspCallBack);
      QLog.e("VSNetworkHelper", 1, "VSDispatchObserver: Start Retry Request: CmdName:" + paramVSBaseRequest.getCmdName() + " | ReTry TraceId:" + paramVSBaseRequest.getTraceId() + " | ReTry SeqId:" + paramVSBaseRequest.getCurrentSeq());
      return;
    }
    paramonVSRspCallBack.onReceive(paramVSBaseRequest, paramBoolean, paramLong, paramString, paramMessageMicro);
  }
  
  private void parseResponse(int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject2 = (ConcurrentHashMap)this.mCallBackCollectMap.get(Integer.valueOf(paramInt));
    if (localObject2 == null)
    {
      QLog.e("VSNetworkHelper", 1, "VSDispatchObserver: onReceive: cmdCallback has All Removed");
      return;
    }
    VSBaseRequest localVSBaseRequest = (VSBaseRequest)paramBundle.getSerializable("key_request_data");
    if (localVSBaseRequest == null)
    {
      QLog.e("VSNetworkHelper", 1, "VSDispatchObserver: onReceive: request is null");
      return;
    }
    paramBundle.getLong("key_network_time_cost");
    if (((ConcurrentHashMap)localObject2).get(Integer.valueOf(localVSBaseRequest.getCurrentSeq())) == null)
    {
      QLog.e("VSNetworkHelper", 1, "VSDispatchObserver: onReceive: CmdName:" + localVSBaseRequest.getCmdName() + " | TraceId:" + localVSBaseRequest.getTraceId() + " | cmdCallback SeqId:" + localVSBaseRequest.getCurrentSeq() + " is Null or has Removed");
      return;
    }
    Object localObject1 = (FromServiceMsg)paramBundle.getParcelable("key_response_msg");
    long l1 = paramBundle.getLong("key_send_timestamp");
    paramBundle = (VSDispatchObserver.onVSRspCallBack)((ConcurrentHashMap)localObject2).remove(Integer.valueOf(localVSBaseRequest.getCurrentSeq()));
    if (paramBundle == null)
    {
      QLog.e("VSNetworkHelper", 1, "VSDispatchObserver: onReceive: CmdName:" + localVSBaseRequest.getCmdName() + " | TraceId:" + localVSBaseRequest.getTraceId() + " | cmdCallback SeqId:" + localVSBaseRequest.getCurrentSeq() + " onVSRspCallBack is Null or removed");
      return;
    }
    if (localObject1 != null)
    {
      long l2;
      MessageMicro localMessageMicro;
      try
      {
        localObject2 = localVSBaseRequest.parseResponseWrapper(bgau.b(((FromServiceMsg)localObject1).getWupBuffer()));
        l2 = ((Long)localObject2[0]).longValue();
        localObject1 = (String)localObject2[1];
        localObject2 = ((ByteStringMicro)localObject2[2]).toByteArray();
        localMessageMicro = localVSBaseRequest.decode((byte[])localObject2);
        if (localMessageMicro == null)
        {
          getMainThreadHandler().post(new VSDispatchObserver.2(this, localVSBaseRequest, paramBundle, l2, (String)localObject1, l1));
          return;
        }
      }
      catch (Exception localException)
      {
        getMainThreadHandler().post(new VSDispatchObserver.4(this, localVSBaseRequest, paramBundle, l1, localException));
        return;
      }
      getMainThreadHandler().post(new VSDispatchObserver.3(this, paramBoolean, l2, localVSBaseRequest, (byte[])localObject2, paramBundle, localException, localMessageMicro, l1));
      return;
    }
    getMainThreadHandler().post(new VSDispatchObserver.5(this, localVSBaseRequest, paramBundle, l1));
  }
  
  private void saveCache(VSBaseRequest paramVSBaseRequest, byte[] paramArrayOfByte)
  {
    if (StringUtil.isEmpty(paramVSBaseRequest.getRequestKey()))
    {
      xvv.d("VSNetworkHelper| Protocol Cache", "requestKey is empty");
      return;
    }
    ThreadManagerV2.executeOnSubThread(new VSDispatchObserver.6(this, paramVSBaseRequest, paramArrayOfByte));
  }
  
  public void cancelAllRequest(Context paramContext)
  {
    cancelRequest(paramContext, -1);
  }
  
  public void cancelRequest(Context paramContext, int paramInt)
  {
    if (paramContext == null) {}
    while (this.mCallBackCollectMap.get(Integer.valueOf(paramContext.hashCode())) == null) {
      return;
    }
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.mCallBackCollectMap.get(Integer.valueOf(paramContext.hashCode()));
    if ((localConcurrentHashMap != null) && (paramInt == -1))
    {
      localConcurrentHashMap.clear();
      QLog.i("VSNetworkHelper", 1, String.format("cancel Request Context Success contextHashcode:%d, seq:%d", new Object[] { Integer.valueOf(paramContext.hashCode()), Integer.valueOf(paramInt) }));
      return;
    }
    if ((localConcurrentHashMap != null) && (localConcurrentHashMap.remove(Integer.valueOf(paramInt)) != null))
    {
      QLog.i("VSNetworkHelper", 1, String.format("cancel Request Seq Success contextHashcode:%d, seq:%d", new Object[] { Integer.valueOf(paramContext.hashCode()), Integer.valueOf(paramInt) }));
      return;
    }
    QLog.w("VSNetworkHelper", 1, String.format("cancel Request failed not found request callback contextHashcode:%d, seq:%d", new Object[] { Integer.valueOf(paramContext.hashCode()), Integer.valueOf(paramInt) }));
  }
  
  public Handler getMainThreadHandler()
  {
    if (this.mMainHandler == null) {
      this.mMainHandler = new Handler(Looper.getMainLooper());
    }
    return this.mMainHandler;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    ThreadManagerV2.excute(new VSDispatchObserver.1(this, paramInt, paramBundle, paramBoolean), 16, null, false);
  }
  
  public void release()
  {
    try
    {
      Iterator localIterator = this.mCallBackCollectMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.mCallBackCollectMap.get(Integer.valueOf(i));
        if (localConcurrentHashMap != null) {
          localConcurrentHashMap.clear();
        }
      }
    }
    finally {}
  }
  
  public void sendCacheToTargetCallBack(VSBaseRequest paramVSBaseRequest, MessageMicro paramMessageMicro)
  {
    getMainThreadHandler().post(new VSDispatchObserver.7(this, paramVSBaseRequest, paramMessageMicro));
  }
  
  public void setCallBack(VSBaseRequest paramVSBaseRequest, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack)
  {
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.mCallBackCollectMap.get(Integer.valueOf(paramVSBaseRequest.getContextHashCode()));
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (localConcurrentHashMap2 == null)
    {
      localConcurrentHashMap1 = new ConcurrentHashMap();
      this.mCallBackCollectMap.put(Integer.valueOf(paramVSBaseRequest.getContextHashCode()), localConcurrentHashMap1);
    }
    try
    {
      localConcurrentHashMap1.put(Integer.valueOf(paramVSBaseRequest.getNewSeq()), paramonVSRspCallBack);
      return;
    }
    catch (Exception paramVSBaseRequest)
    {
      paramVSBaseRequest.printStackTrace();
      QLog.e("VSNetworkHelper", 1, "setCallBack exception occur!" + paramVSBaseRequest.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver
 * JD-Core Version:    0.7.0.1
 */