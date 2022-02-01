package com.tencent.biz.pubaccount.readinjoy.view;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyFastWebBottomSocialViewNew$1$1
  implements ViewBase.OnClickListener
{
  ReadInJoyFastWebBottomSocialViewNew$1$1(ReadInJoyFastWebBottomSocialViewNew.1 param1) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    for (;;)
    {
      FastWebArticleInfo localFastWebArticleInfo;
      try
      {
        String str = paramViewBase.getEventAttachedData();
        int i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
        paramViewBase = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.b;
        localFastWebArticleInfo = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.a;
        switch (i)
        {
        case 1004: 
          if (TextUtils.isEmpty(str)) {
            return;
          }
          RIJJumpUtils.a(this.a.jdField_a_of_type_AndroidContentContext, str);
          return;
        }
      }
      catch (Exception paramViewBase)
      {
        QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "findClickableViewListener error!  msg=" + paramViewBase);
        return;
      }
      ReadInJoyFastWebBottomSocialViewNew.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew, this.a.jdField_a_of_type_AndroidContentContext, paramViewBase, localFastWebArticleInfo);
      return;
      ReadInJoyFastWebBottomSocialViewNew.b(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew, this.a.jdField_a_of_type_AndroidContentContext, paramViewBase, localFastWebArticleInfo);
      return;
      ReadInJoyFastWebBottomSocialViewNew.c(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew, this.a.jdField_a_of_type_AndroidContentContext, paramViewBase, localFastWebArticleInfo);
      return;
      ReadInJoyFastWebBottomSocialViewNew.d(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew, this.a.jdField_a_of_type_AndroidContentContext, paramViewBase, localFastWebArticleInfo);
      return;
      ReadInJoyFastWebBottomSocialViewNew.e(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew, this.a.jdField_a_of_type_AndroidContentContext, paramViewBase, localFastWebArticleInfo);
      return;
      ReadInJoyFastWebBottomSocialViewNew.f(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew, this.a.jdField_a_of_type_AndroidContentContext, paramViewBase, localFastWebArticleInfo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew.1.1
 * JD-Core Version:    0.7.0.1
 */