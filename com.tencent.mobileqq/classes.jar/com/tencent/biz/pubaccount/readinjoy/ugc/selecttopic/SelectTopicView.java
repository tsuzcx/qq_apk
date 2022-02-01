package com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.mvp.ListContract.IListView;
import com.tencent.biz.pubaccount.readinjoy.mvp.ListPresenter;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.CreateTopicDispatcher;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicView;", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectView;", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ColumnInfo;", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicView$MyTopicViewHolder;", "context", "Landroid/support/v4/app/FragmentActivity;", "listPresenter", "Lcom/tencent/biz/pubaccount/readinjoy/mvp/ListPresenter;", "Lcom/tencent/biz/pubaccount/readinjoy/mvp/ListContract$IListView;", "(Landroid/support/v4/app/FragmentActivity;Lcom/tencent/biz/pubaccount/readinjoy/mvp/ListPresenter;)V", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter;", "getAdapter", "()Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter;", "getContext", "()Landroid/support/v4/app/FragmentActivity;", "createTopicListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "topicInfo", "", "rightActionText", "", "getRightActionText", "()Ljava/lang/String;", "selectTip", "getSelectTip", "topicAdapter", "com/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicView$topicAdapter$1", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicView$topicAdapter$1;", "handleRightActionClick", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttachedToWindow", "onDetachedFromWindow", "Companion", "MyTopicViewHolder", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class SelectTopicView
  extends BaseSelectView<ColumnInfo, SelectTopicView.MyTopicViewHolder>
{
  public static final SelectTopicView.Companion a;
  @NotNull
  private final FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private final SelectTopicView.topicAdapter.1 jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelecttopicSelectTopicView$topicAdapter$1;
  private final Function1<ColumnInfo, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelecttopicSelectTopicView$Companion = new SelectTopicView.Companion(null);
  }
  
  public SelectTopicView(@NotNull FragmentActivity paramFragmentActivity, @NotNull ListPresenter<ColumnInfo, ListContract.IListView<ColumnInfo>> paramListPresenter)
  {
    super((Activity)paramFragmentActivity, paramListPresenter);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelecttopicSelectTopicView$topicAdapter$1 = new SelectTopicView.topicAdapter.1(this, (Context)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = ((Function1)new SelectTopicView.createTopicListener.1(this));
  }
  
  @NotNull
  public BaseSelectAdapter<ColumnInfo, SelectTopicView.MyTopicViewHolder> a()
  {
    return (BaseSelectAdapter)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelecttopicSelectTopicView$topicAdapter$1;
  }
  
  @NotNull
  public String a()
  {
    String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131718331);
    Intrinsics.checkExpressionValueIsNotNull(str, "context.resources.getStr…joy_publish_to_topic_tip)");
    return str;
  }
  
  public void a()
  {
    RIJUgcUtils.a((Context)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 4);
    Object localObject = RIJQQAppInterfaceUtil.a();
    if (localObject != null)
    {
      localObject = new RIJTransMergeKanDianReport.ReportR5Builder().a("uin", ((QQAppInterface)localObject).getCurrentAccountUin()).a("source", Integer.valueOf(1)).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AC60", (String)localObject);
      return;
    }
    QLog.e("SelectTopicView", 1, "handleRightActionClick, app == null");
  }
  
  @NotNull
  public String b()
  {
    if (RIJUgcUtils.h())
    {
      String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131718171);
      Intrinsics.checkExpressionValueIsNotNull(str, "context.resources.getStr…ate_column_entry_wording)");
      return str;
    }
    return "";
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    CreateTopicDispatcher.a(this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
  }
  
  public void onDetachedFromWindow()
  {
    CreateTopicDispatcher.b(this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
    super.onDetachedFromWindow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic.SelectTopicView
 * JD-Core Version:    0.7.0.1
 */