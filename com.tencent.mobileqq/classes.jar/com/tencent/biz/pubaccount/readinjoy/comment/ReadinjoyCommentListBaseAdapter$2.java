package com.tencent.biz.pubaccount.readinjoy.comment;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadinjoyCommentListBaseAdapter$2
  implements ActionSheet.OnButtonClickListener
{
  ReadinjoyCommentListBaseAdapter$2(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, CommentViewItem paramCommentViewItem, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.a();
      if (paramView != null) {
        paramView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.c);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadinjoyCommentListBaseAdapter.2
 * JD-Core Version:    0.7.0.1
 */