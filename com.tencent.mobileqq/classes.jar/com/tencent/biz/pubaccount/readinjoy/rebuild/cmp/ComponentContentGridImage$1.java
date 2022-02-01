package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.ArticleBasicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.LongContentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class ComponentContentGridImage$1
  implements AdapterView.OnItemClickListener
{
  ComponentContentGridImage$1(ComponentContentGridImage paramComponentContentGridImage) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((ComponentContentGridImage.a(this.a) == 62) || (ComponentContentGridImage.a(this.a) == 63) || (ComponentContentGridImage.a(this.a) == 64) || (ComponentContentGridImage.a(this.a) == 65))
    {
      if (ComponentContentGridImage.a(this.a) != null) {
        ComponentContentGridImage.a(this.a).a(paramInt);
      }
      return;
    }
    if ((Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0) == 1) && (((ReadInJoyModelImpl)this.a.a).a().mSocialFeedInfo != null) && (((ReadInJoyModelImpl)this.a.a).a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (((ReadInJoyModelImpl)this.a.a).a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a) && (((ReadInJoyModelImpl)this.a.a).a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo != null)) {
      try
      {
        RIJJumpUtils.a(this.a.getContext(), ((ReadInJoyModelImpl)this.a.a).a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo.a.c, null);
        return;
      }
      catch (Exception paramAdapterView)
      {
        QLog.e("ComponentContentGridImage", 1, paramAdapterView.getLocalizedMessage());
        return;
      }
    }
    ComponentContentGridImage.a(this.a, paramInt, ComponentContentGridImage.a(this.a).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage.1
 * JD-Core Version:    0.7.0.1
 */