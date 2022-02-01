package com.tencent.biz.pubaccount.readinjoy.comment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import cooperation.readinjoy.ReadInJoyHelper;

final class CommentProteusUtil$2
  implements DialogInterface.OnClickListener
{
  CommentProteusUtil$2(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, CommentViewItem paramCommentViewItem) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter != null)
      {
        paramDialogInterface = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.a();
        if (paramDialogInterface != null)
        {
          paramDialogInterface.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.notifyDataSetChanged();
        }
      }
      ReadInJoyHelper.a("family_comment_card_hide_timestamp", Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.CommentProteusUtil.2
 * JD-Core Version:    0.7.0.1
 */