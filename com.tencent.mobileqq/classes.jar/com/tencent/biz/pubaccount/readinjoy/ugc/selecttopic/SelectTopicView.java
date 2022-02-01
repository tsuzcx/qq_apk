package com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import olh;
import org.jetbrains.annotations.NotNull;
import pnn;
import pqg;
import qjl;
import qjt;
import rth;
import rze;
import sby;
import sci;
import scj;
import sck;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicView;", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectView;", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ColumnInfo;", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicView$MyTopicViewHolder;", "context", "Landroid/support/v4/app/FragmentActivity;", "listPresenter", "Lcom/tencent/biz/pubaccount/readinjoy/mvp/ListPresenter;", "Lcom/tencent/biz/pubaccount/readinjoy/mvp/ListContract$IListView;", "(Landroid/support/v4/app/FragmentActivity;Lcom/tencent/biz/pubaccount/readinjoy/mvp/ListPresenter;)V", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter;", "getAdapter", "()Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter;", "getContext", "()Landroid/support/v4/app/FragmentActivity;", "createTopicListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "topicInfo", "", "rightActionText", "", "getRightActionText", "()Ljava/lang/String;", "selectTip", "getSelectTip", "topicAdapter", "com/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicView$topicAdapter$1", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicView$topicAdapter$1;", "handleRightActionClick", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttachedToWindow", "onDetachedFromWindow", "Companion", "MyTopicViewHolder", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class SelectTopicView
  extends BaseSelectView<ColumnInfo, scj>
{
  public static final sci a;
  @NotNull
  private final FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private final Function1<ColumnInfo, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  private final sck jdField_a_of_type_Sck;
  
  static
  {
    jdField_a_of_type_Sci = new sci(null);
  }
  
  public SelectTopicView(@NotNull FragmentActivity paramFragmentActivity, @NotNull qjt<ColumnInfo, qjl<ColumnInfo>> paramqjt)
  {
    super((Activity)paramFragmentActivity, paramqjt);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_Sck = new sck(this, (Context)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = ((Function1)new SelectTopicView.createTopicListener.1(this));
  }
  
  @NotNull
  public String a()
  {
    String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131717828);
    Intrinsics.checkExpressionValueIsNotNull(str, "context.resources.getStr…joy_publish_to_topic_tip)");
    return str;
  }
  
  @NotNull
  public sby<ColumnInfo, scj> a()
  {
    return (sby)this.jdField_a_of_type_Sck;
  }
  
  public void a()
  {
    rth.a((Context)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 4);
    QQAppInterface localQQAppInterface = pnn.a();
    if (localQQAppInterface != null)
    {
      olh.a("0X800AC60", new pqg().a("uin", localQQAppInterface.getCurrentAccountUin()).a("source", Integer.valueOf(1)).a());
      return;
    }
    QLog.e("SelectTopicView", 1, "handleRightActionClick, app == null");
  }
  
  @NotNull
  public String b()
  {
    if (rth.h())
    {
      String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131717669);
      Intrinsics.checkExpressionValueIsNotNull(str, "context.resources.getStr…ate_column_entry_wording)");
      return str;
    }
    return "";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    rze.a(this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
  }
  
  protected void onDetachedFromWindow()
  {
    rze.b(this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
    super.onDetachedFromWindow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic.SelectTopicView
 * JD-Core Version:    0.7.0.1
 */