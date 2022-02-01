package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListAdapter;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadinjoyCommentListBaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ReadInJoyCommentPopUpWindow
  extends PopupWindow
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = Color.parseColor("#376099");
  protected Activity a;
  private View jdField_a_of_type_AndroidViewView;
  private ReadinjoyCommentListBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter;
  private ReadInJoyCommentPopUpWindow.OnCommentTypeChangedListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiReadInJoyCommentPopUpWindow$OnCommentTypeChangedListener;
  private boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidAppActivity.getWindowManager().removeView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Boolean = false;
    dismiss();
    int i;
    switch (paramView.getId())
    {
    case 2131364740: 
    default: 
      i = 3;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiReadInJoyCommentPopUpWindow$OnCommentTypeChangedListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiReadInJoyCommentPopUpWindow$OnCommentTypeChangedListener.b(i);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.c();
        if ((i == 3) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter instanceof ReadInJoyCommentListAdapter))) {
          ((ReadInJoyCommentListAdapter)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter).g();
        }
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 3;
      continue;
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.ReadInJoyCommentPopUpWindow
 * JD-Core Version:    0.7.0.1
 */