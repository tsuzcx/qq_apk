package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.os.Bundle;
import android.widget.LinearLayout;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfos;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.oidb_0xc2f.GetFollowUserRecommendListRsp;
import tencent.im.oidb.oidb_0xc2f.RspBody;

class ReadInJoySocializeRecommendFollowView$9
  extends ProtoUtils.AppProtocolObserver
{
  ReadInJoySocializeRecommendFollowView$9(ReadInJoySocializeRecommendFollowView paramReadInJoySocializeRecommendFollowView) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, "requestRecommendList onResult, errorCode = " + paramInt);
    }
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      try
      {
        paramBundle = new oidb_0xc2f.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        ReadInJoySocializeRecommendFollowView.a(this.a).mRecommendFollowInfos = RecommendFollowInfos.a((oidb_0xc2f.GetFollowUserRecommendListRsp)paramBundle.msg_get_follow_user_recommend_list_rsp.get());
        if ((ReadInJoySocializeRecommendFollowView.a(this.a).mRecommendFollowInfos.a != null) && (ReadInJoySocializeRecommendFollowView.a(this.a).mRecommendFollowInfos.a.size() >= 3))
        {
          ReadInJoySocializeRecommendFollowView.a(this.a).a(ReadInJoySocializeRecommendFollowView.a(this.a).mRecommendFollowInfos.a);
          ReadInJoySocializeRecommendFollowView.a(this.a).isShowRecommendList = true;
          ReadInJoySocializeRecommendFollowView.a(this.a);
          ReadInJoySocializeRecommendFollowView.a(this.a).post(new ReadInJoySocializeRecommendFollowView.9.1(this));
          return;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("ReadInJoySocializeRecommendFollowView", 2, "requestRecommendList onResult, size < 3");
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("ReadInJoySocializeRecommendFollowView", 1, "requestRecommendList onResult(), exception = " + paramArrayOfByte.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.9
 * JD-Core Version:    0.7.0.1
 */