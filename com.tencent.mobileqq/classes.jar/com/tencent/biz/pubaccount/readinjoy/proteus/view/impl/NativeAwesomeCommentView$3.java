package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.res.Resources;
import android.text.SpannableString;
import android.widget.TextView;
import com.tencent.biz.ui.CenteredImageSpan;
import com.tencent.image.URLDrawable.DownloadListener;

class NativeAwesomeCommentView$3
  implements URLDrawable.DownloadListener
{
  NativeAwesomeCommentView$3(NativeAwesomeCommentView paramNativeAwesomeCommentView, SpannableString paramSpannableString) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    CenteredImageSpan localCenteredImageSpan = new CenteredImageSpan(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAwesomeCommentView.getResources().getDrawable(2130842936));
    this.jdField_a_of_type_AndroidTextSpannableString.setSpan(localCenteredImageSpan, 0, 1, 17);
    NativeAwesomeCommentView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAwesomeCommentView).setText(this.jdField_a_of_type_AndroidTextSpannableString);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAwesomeCommentView.3
 * JD-Core Version:    0.7.0.1
 */