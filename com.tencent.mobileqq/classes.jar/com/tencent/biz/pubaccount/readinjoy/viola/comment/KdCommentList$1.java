package com.tencent.biz.pubaccount.readinjoy.viola.comment;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONObject;
import pac;
import pap;

class KdCommentList$1
  implements Runnable
{
  KdCommentList$1(KdCommentList paramKdCommentList, JSONObject paramJSONObject1, JSONObject paramJSONObject2, View paramView) {}
  
  public void run()
  {
    KdCommentList.access$002(this.this$0, new pap().a(KdCommentList.access$100(this.this$0, this.jdField_a_of_type_OrgJsonJSONObject, this.b).toString(), this.this$0, this.this$0));
    if ((this.this$0.getInstance() != null) && ((this.this$0.getInstance().getActivity() instanceof FragmentActivity)) && (KdCommentList.access$000(this.this$0) != null))
    {
      ((FragmentActivity)this.this$0.getInstance().getActivity()).getSupportFragmentManager().beginTransaction().add(this.jdField_a_of_type_AndroidViewView.getId(), KdCommentList.access$000(this.this$0)).commitAllowingStateLoss();
      pac.a().a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.comment.KdCommentList.1
 * JD-Core Version:    0.7.0.1
 */