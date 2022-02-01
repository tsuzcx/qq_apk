package com.tencent.biz.pubaccount.util;

import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.qqstory.view.WeShiGuideDialog;

final class VideoFeedsWeiShiUtils$1
  implements View.OnSystemUiVisibilityChangeListener
{
  public void onSystemUiVisibilityChange(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWeShiGuideDialog.getWindow().getDecorView().setSystemUiVisibility(5894);
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof VideoFeedsPlayActivity)) {
      VideoFeedsHelper.b(this.jdField_a_of_type_AndroidAppActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.VideoFeedsWeiShiUtils.1
 * JD-Core Version:    0.7.0.1
 */