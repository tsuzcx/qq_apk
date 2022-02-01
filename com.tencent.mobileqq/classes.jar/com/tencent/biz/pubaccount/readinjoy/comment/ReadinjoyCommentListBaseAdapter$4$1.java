package com.tencent.biz.pubaccount.readinjoy.comment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.util.NetworkState;

class ReadinjoyCommentListBaseAdapter$4$1
  implements DialogInterface.OnClickListener
{
  ReadinjoyCommentListBaseAdapter$4$1(ReadinjoyCommentListBaseAdapter.4 param4, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkState.isNetSupport())
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter$4.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$ReportCommentDialogClickListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter$4.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$ReportCommentDialogClickListener.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramInt);
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter$4.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.a, 1, HardCodeUtil.a(2131699712), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadinjoyCommentListBaseAdapter.4.1
 * JD-Core Version:    0.7.0.1
 */