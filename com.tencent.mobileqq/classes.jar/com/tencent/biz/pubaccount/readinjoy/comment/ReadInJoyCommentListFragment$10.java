package com.tencent.biz.pubaccount.readinjoy.comment;

import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentMixDataManager;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentMixDataManager.BiuAndCommentListener;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentRespData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class ReadInJoyCommentListFragment$10
  implements RIJBiuAndCommentMixDataManager.BiuAndCommentListener
{
  ReadInJoyCommentListFragment$10(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void a(RIJBiuAndCommentRespData paramRIJBiuAndCommentRespData)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onBiuAndCommentSend fragment");
    if (paramRIJBiuAndCommentRespData == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(paramRIJBiuAndCommentRespData.a()))
    {
      QLog.d("ReadInJoyCommentListFragment", 1, localObject);
      if ((paramRIJBiuAndCommentRespData == null) || (paramRIJBiuAndCommentRespData.a() != 0)) {
        break;
      }
      RIJBiuAndCommentMixDataManager.a(paramRIJBiuAndCommentRespData.c(), paramRIJBiuAndCommentRespData.a(), paramRIJBiuAndCommentRespData.c(), paramRIJBiuAndCommentRespData.b(), paramRIJBiuAndCommentRespData.a(), paramRIJBiuAndCommentRespData.d(), paramRIJBiuAndCommentRespData.e(), paramRIJBiuAndCommentRespData.a());
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131712856), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment.10
 * JD-Core Version:    0.7.0.1
 */