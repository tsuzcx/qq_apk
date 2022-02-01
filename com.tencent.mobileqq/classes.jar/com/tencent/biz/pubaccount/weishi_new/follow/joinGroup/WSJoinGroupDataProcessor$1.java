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
    Object localObject = new WeakReference(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowJoinGroupWSJoinGroupDataProcessor$DataCallback);
    if ((paramWeishiTask != null) && (paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest != null))
    {
      if (!TextUtils.equals(paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest.b, WSJoinGroupDataProcessor.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newFollowJoinGroupWSJoinGroupDataProcessor))) {
        return;
      }
      localObject = (WSJoinGroupDataProcessor.DataCallback)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if (!((WSJoinGroupDataProcessor.DataCallback)localObject).a()) {
          return;
        }
        ((WSJoinGroupDataProcessor.DataCallback)localObject).c();
        if (paramWeishiTask.a())
        {
          if ((paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stQQGroupDetailRsp))
          {
            paramWeishiTask = (stQQGroupDetailRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
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
              ((WSJoinGroupDataProcessor.DataCallback)localObject).a(this.jdField_a_of_type_JavaLangString, paramWeishiTask.signature);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.WSJoinGroupDataProcessor.1
 * JD-Core Version:    0.7.0.1
 */