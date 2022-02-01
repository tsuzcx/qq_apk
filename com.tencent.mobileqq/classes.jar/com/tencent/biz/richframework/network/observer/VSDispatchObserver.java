package com.tencent.biz.richframework.network.observer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.util.StringUtils;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class VSDispatchObserver
{
  private static final int CALL_BACK_REMOVED_CODE = -100004;
  private static final int FINAL_RSP_NULL_CODE = -100003;
  private static final int FROM_MSG_NULL_CODE = -100002;
  private static final String NETWORK_ERROR_HINT = "网络错误";
  public static final int TIMEOUT_CODE = -100001;
  private final ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, VSDispatchObserver.onVSRspCallBack>> mCallBackCollectMap = new ConcurrentHashMap();
  private Handler mMainHandler;
  
  private void doOnReceiveCallBack(BaseRequest paramBaseRequest, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack, long paramLong, String paramString, boolean paramBoolean, Object paramObject)
  {
    if (((!paramBoolean) || (paramLong != 0L)) && (paramBaseRequest.isNeedRetry(paramLong)) && (paramBaseRequest.getRetryCount() > 0))
    {
      paramBaseRequest.setEnableCache(false);
      paramBaseRequest.setRetryCount(paramBaseRequest.getRetryCount() - 1);
      VSNetworkHelper.getInstance().sendRequest(paramBaseRequest, paramonVSRspCallBack);
      RFLog.e("VSNetworkHelper", RFLog.USR, "VSDispatchObserver: Start Retry Request: CmdName:" + paramBaseRequest.getCmdName() + " | ReTry TraceId:" + paramBaseRequest.getTraceId() + " | ReTry SeqId:" + paramBaseRequest.getCurrentSeq());
      return;
    }
    paramonVSRspCallBack.onReceive(paramBaseRequest, paramBoolean, paramLong, paramString, paramObject);
  }
  
  private void parseResponse(int paramInt, boolean paramBoolean, BaseRequest paramBaseRequest, byte[] paramArrayOfByte)
  {
    Object localObject1 = (ConcurrentHashMap)this.mCallBackCollectMap.get(Integer.valueOf(paramInt));
    if (localObject1 == null)
    {
      RFLog.e("VSNetworkHelper", RFLog.USR, "VSDispatchObserver: onReceive: cmdCallback has All Removed");
      return;
    }
    if (paramBaseRequest == null)
    {
      RFLog.e("VSNetworkHelper", RFLog.USR, "VSDispatchObserver: onReceive: request is null");
      return;
    }
    if (((ConcurrentHashMap)localObject1).get(Integer.valueOf(paramBaseRequest.getCurrentSeq())) == null)
    {
      RFLog.e("VSNetworkHelper", RFLog.USR, "VSDispatchObserver: onReceive: CmdName:" + paramBaseRequest.getCmdName() + " | TraceId:" + paramBaseRequest.getTraceId() + " | cmdCallback SeqId:" + paramBaseRequest.getCurrentSeq() + " is Null or has Removed");
      return;
    }
    long l1 = System.currentTimeMillis();
    localObject1 = (VSDispatchObserver.onVSRspCallBack)((ConcurrentHashMap)localObject1).remove(Integer.valueOf(paramBaseRequest.getCurrentSeq()));
    if (localObject1 == null)
    {
      RFLog.e("VSNetworkHelper", RFLog.USR, "VSDispatchObserver: onReceive: CmdName:" + paramBaseRequest.getCmdName() + " | TraceId:" + paramBaseRequest.getTraceId() + " | cmdCallback SeqId:" + paramBaseRequest.getCurrentSeq() + " onVSRspCallBack is Null or removed");
      return;
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      Object localObject2;
      long l2;
      Object localObject3;
      try
      {
        localObject2 = paramBaseRequest.parseResponseHeadInfo(paramArrayOfByte);
        l2 = ((Long)localObject2[0]).longValue();
        paramArrayOfByte = (String)localObject2[1];
        localObject2 = (byte[])localObject2[2];
        localObject3 = paramBaseRequest.decode((byte[])localObject2);
        if (localObject3 == null)
        {
          getMainThreadHandler().post(new VSDispatchObserver.2(this, paramBaseRequest, (VSDispatchObserver.onVSRspCallBack)localObject1, l2, paramArrayOfByte, l1));
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        getMainThreadHandler().post(new VSDispatchObserver.4(this, paramBaseRequest, (VSDispatchObserver.onVSRspCallBack)localObject1, l1, paramArrayOfByte));
        return;
      }
      getMainThreadHandler().post(new VSDispatchObserver.3(this, paramBoolean, paramBaseRequest, l2, (byte[])localObject2, (VSDispatchObserver.onVSRspCallBack)localObject1, paramArrayOfByte, localObject3, l1));
      return;
    }
    getMainThreadHandler().post(new VSDispatchObserver.5(this, paramBaseRequest, (VSDispatchObserver.onVSRspCallBack)localObject1, l1));
  }
  
  private void saveCache(BaseRequest paramBaseRequest, byte[] paramArrayOfByte)
  {
    if (StringUtils.isEmpty(paramBaseRequest.getRequestKey()))
    {
      RFLog.w("VSNetworkHelper| Protocol Cache", RFLog.USR, "requestKey is empty");
      return;
    }
    RFThreadManager.execute(new VSDispatchObserver.6(this, paramBaseRequest, paramArrayOfByte), RFThreadManager.Normal);
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
      RFLog.i("VSNetworkHelper", RFLog.USR, String.format("cancel Request Context Success contextHashcode:%d, seq:%d", new Object[] { Integer.valueOf(paramContext.hashCode()), Integer.valueOf(paramInt) }));
      return;
    }
    if ((localConcurrentHashMap != null) && (localConcurrentHashMap.remove(Integer.valueOf(paramInt)) != null))
    {
      RFLog.i("VSNetworkHelper", RFLog.USR, String.format("cancel Request Seq Success contextHashcode:%d, seq:%d", new Object[] { Integer.valueOf(paramContext.hashCode()), Integer.valueOf(paramInt) }));
      return;
    }
    RFLog.w("VSNetworkHelper", RFLog.USR, String.format("cancel Request failed not found request callback contextHashcode:%d, seq:%d", new Object[] { Integer.valueOf(paramContext.hashCode()), Integer.valueOf(paramInt) }));
  }
  
  public Handler getMainThreadHandler()
  {
    if (this.mMainHandler == null) {
      this.mMainHandler = new Handler(Looper.getMainLooper());
    }
    return this.mMainHandler;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, BaseRequest paramBaseRequest, byte[] paramArrayOfByte)
  {
    if (VSNetworkHelper.isValidLog(paramBaseRequest.getCmdName())) {
      RFLog.i("VSNetworkHelper", RFLog.CLR, "onReceive Info:CmdName:" + paramBaseRequest.getCmdName() + " | TraceId:" + paramBaseRequest.getTraceId() + " | seqNum:" + paramBaseRequest.getCurrentSeq() + " | network cost:" + (System.currentTimeMillis() - paramBaseRequest.getSendTimeStamp()));
    }
    RFThreadManager.execute(new VSDispatchObserver.1(this, paramInt, paramBoolean, paramBaseRequest, paramArrayOfByte), RFThreadManager.Normal);
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
  
  public void sendCacheToTargetCallBack(BaseRequest paramBaseRequest, Object paramObject)
  {
    getMainThreadHandler().post(new VSDispatchObserver.7(this, paramBaseRequest, paramObject));
  }
  
  public void setCallBack(BaseRequest paramBaseRequest, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack)
  {
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.mCallBackCollectMap.get(Integer.valueOf(paramBaseRequest.getContextHashCode()));
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (localConcurrentHashMap2 == null)
    {
      localConcurrentHashMap1 = new ConcurrentHashMap();
      this.mCallBackCollectMap.put(Integer.valueOf(paramBaseRequest.getContextHashCode()), localConcurrentHashMap1);
    }
    try
    {
      localConcurrentHashMap1.put(Integer.valueOf(paramBaseRequest.getNewSeq()), paramonVSRspCallBack);
      return;
    }
    catch (Exception paramBaseRequest)
    {
      paramBaseRequest.printStackTrace();
      if (RFApplication.isDebug()) {
        throw new RuntimeException(paramBaseRequest);
      }
      RFLog.e("VSNetworkHelper", RFLog.USR, "setCallBack exception occur!" + paramBaseRequest.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver
 * JD-Core Version:    0.7.0.1
 */