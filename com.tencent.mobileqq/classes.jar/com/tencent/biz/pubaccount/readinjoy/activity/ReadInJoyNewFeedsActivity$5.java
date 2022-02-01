package com.tencent.biz.pubaccount.readinjoy.activity;

import android.app.Activity;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;

class ReadInJoyNewFeedsActivity$5
  implements Runnable
{
  ReadInJoyNewFeedsActivity$5(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity, GuideData paramGuideData, String paramString, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.a == null)
    {
      FrameLayout localFrameLayout = (FrameLayout)this.this$0.getActivity().getWindow().getDecorView();
      this.this$0.a = new ReadInJoySkinGuideView(0, this.this$0, this.this$0.app, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.id, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, new ReadInJoyNewFeedsActivity.5.1(this, localFrameLayout), new ReadInJoyNewFeedsActivity.5.2(this, localFrameLayout));
      if (this.this$0.a() == 0) {
        localFrameLayout.addView(this.this$0.a, -1, -1);
      }
    }
    else
    {
      return;
    }
    ReadInJoyNewFeedsActivity.a(this.this$0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity.5
 * JD-Core Version:    0.7.0.1
 */