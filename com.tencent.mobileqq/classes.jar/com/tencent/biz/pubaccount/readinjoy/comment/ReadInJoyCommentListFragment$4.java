package com.tencent.biz.pubaccount.readinjoy.comment;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.CommentAnchor;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.OnCommentListLoadListener;
import com.tencent.biz.qrcode.util.QRUtils;
import java.util.List;

class ReadInJoyCommentListFragment$4
  implements ReadInJoyCommentDataManager.OnCommentListLoadListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  ReadInJoyCommentListFragment$4(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    QLog.d("ReadInJoyCommentListFragment", 1, "onCommentListLoad anchor");
    if (!paramBoolean1) {}
    do
    {
      return;
      paramList = ReadInJoyCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment).a().a();
    } while (paramList == null);
    if (!TextUtils.isEmpty(paramList.b))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.f();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(true, paramList.a, paramList.b);
    }
    for (;;)
    {
      paramList.a(false);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.f();
    }
  }
  
  public void onCommentStateError(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      if (paramInt == 1001) {
        QRUtils.a(1, 2131718139);
      }
    } while (paramInt != 1003);
    QRUtils.a(1, 2131718147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment.4
 * JD-Core Version:    0.7.0.1
 */