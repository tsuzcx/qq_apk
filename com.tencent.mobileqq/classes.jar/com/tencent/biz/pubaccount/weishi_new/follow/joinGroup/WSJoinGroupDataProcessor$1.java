package com.tencent.biz.pubaccount.weishi_new.follow.joinGroup;

import UserGrowth.stQQGroupDetailRsp;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.lang.ref.WeakReference;

class WSJoinGroupDataProcessor$1
  implements IWeishiServiceListener
{
  WSJoinGroupDataProcessor$1(WSJoinGroupDataProcessor paramWSJoinGroupDataProcessor, WSJoinGroupDataProcessor.DataCallback paramDataCallback, String paramString) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    Object localObject = new WeakReference(this.a);
    if ((paramWeishiTask != null) && (paramWeishiTask.g != null))
    {
      if (!TextUtils.equals(paramWeishiTask.g.d, WSJoinGroupDataProcessor.a(this.c))) {
        return;
      }
      localObject = (WSJoinGroupDataProcessor.DataCallback)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if (!((WSJoinGroupDataProcessor.DataCallback)localObject).d()) {
          return;
        }
        ((WSJoinGroupDataProcessor.DataCallback)localObject).c();
        if (paramWeishiTask.b())
        {
          if ((paramWeishiTask.m instanceof stQQGroupDetailRsp))
          {
            paramWeishiTask = (stQQGroupDetailRsp)paramWeishiTask.m;
            if (paramWeishiTask.status == 0)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("doTask: stQQGroupDetailRsp response :  msg = ");
              localStringBuilder.append(paramWeishiTask.msg);
              localStringBuilder.append(", code = ");
              localStringBuilder.append(paramWeishiTask.status);
              localStringBuilder.append("; signature = ");
              localStringBuilder.append(paramWeishiTask.signature);
              WSLog.e("WSJoinGroupDataProcessor", localStringBuilder.toString());
              ((WSJoinGroupDataProcessor.DataCallback)localObject).a(this.b, paramWeishiTask.signature);
              return;
            }
          }
          WSLog.e("WSJoinGroupDataProcessor", "doTask: stQQGroupDetailRsp response : response is not instanceof stQQGroupDetailRsp");
          ((WSJoinGroupDataProcessor.DataCallback)localObject).a();
          return;
        }
        WSLog.e("WSJoinGroupDataProcessor", "doTask: stQQGroupDetailRsp response : !task.succeeded()");
        ((WSJoinGroupDataProcessor.DataCallback)localObject).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.WSJoinGroupDataProcessor.1
 * JD-Core Version:    0.7.0.1
 */