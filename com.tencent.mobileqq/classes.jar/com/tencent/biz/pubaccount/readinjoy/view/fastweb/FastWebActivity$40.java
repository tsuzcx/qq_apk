package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentMixDataManager;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentMixDataManager.BiuAndCommentListener;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentRespData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebAnimationUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$40
  implements RIJBiuAndCommentMixDataManager.BiuAndCommentListener
{
  FastWebActivity$40(FastWebActivity paramFastWebActivity) {}
  
  public void a(RIJBiuAndCommentRespData paramRIJBiuAndCommentRespData)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onBiuAndCommentSend fastWeb");
    if (paramRIJBiuAndCommentRespData == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(paramRIJBiuAndCommentRespData.a()))
    {
      QLog.d("FastWebActivity", 1, localObject);
      if ((paramRIJBiuAndCommentRespData == null) || (paramRIJBiuAndCommentRespData.a() != 0)) {
        break;
      }
      if (FastWebActivity.a(this.a) != null)
      {
        localObject = FastWebActivity.a(this.a);
        ((FastWebArticleInfo)localObject).b += 1L;
        FastWebActivity.a(this.a).a(this.a, FastWebActivity.a(this.a), this.a.a);
      }
      RIJBiuAndCommentMixDataManager.a(paramRIJBiuAndCommentRespData.c(), paramRIJBiuAndCommentRespData.a(), paramRIJBiuAndCommentRespData.c(), paramRIJBiuAndCommentRespData.b(), paramRIJBiuAndCommentRespData.a(), paramRIJBiuAndCommentRespData.d(), paramRIJBiuAndCommentRespData.e(), paramRIJBiuAndCommentRespData.a());
      if ((paramRIJBiuAndCommentRespData.c() == 1) && (!FastWebActivity.g(this.a)))
      {
        FastWebActivity.e(this.a, true);
        FastWebAnimationUtils.a(this.a);
      }
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131712856), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.40
 * JD-Core Version:    0.7.0.1
 */