package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListAdapter;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.CommentAnchor;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.OnCommentListLoadListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.FastWebMergeAdapter;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class FastWebActivity$13
  implements ReadInJoyCommentDataManager.OnCommentListLoadListener
{
  FastWebActivity$13(FastWebActivity paramFastWebActivity, String paramString1, String paramString2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<CommentViewItem> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    QLog.d("FastWebActivity", 2, "onCommentListLoad");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.getIntent().removeExtra("intent_key_anchor_data");
    if (!paramBoolean1) {
      QRUtils.a(1, 2131718147);
    }
    do
    {
      return;
      paramList = FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity).a().a();
    } while (paramList == null);
    if (!TextUtils.isEmpty(paramList.b))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.a(true, this.jdField_a_of_type_JavaLangString, this.b, 2130772354, 0);
      FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity, 1000L);
    }
    for (;;)
    {
      paramList = new FastWebActivity.13.1(this);
      FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity).registerDataSetObserver(paramList);
      ThreadManager.getUIHandler().postDelayed(new FastWebActivity.13.2(this, paramList), 2000L);
      return;
      FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity, 100L);
    }
  }
  
  public void onCommentStateError(int paramInt)
  {
    if (paramInt == 1001) {
      QRUtils.a(1, 2131718139);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.13
 * JD-Core Version:    0.7.0.1
 */