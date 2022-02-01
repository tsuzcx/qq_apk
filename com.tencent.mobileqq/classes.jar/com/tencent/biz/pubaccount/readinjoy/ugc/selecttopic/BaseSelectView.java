package com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.mvp.ListContract.IListView;
import com.tencent.biz.pubaccount.readinjoy.mvp.ListPresenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectView;", "BEAN", "HOLDER", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter$BaseSelectViewHolder;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/IOnActivityResult;", "Lcom/tencent/biz/pubaccount/readinjoy/mvp/ListContract$IListView;", "context", "Landroid/app/Activity;", "listPresenter", "Lcom/tencent/biz/pubaccount/readinjoy/mvp/ListPresenter;", "(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/readinjoy/mvp/ListPresenter;)V", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter;", "getAdapter", "()Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter;", "errorLayout", "Landroid/view/View;", "isLoadingMore", "", "listView", "Landroid/widget/ListView;", "loadingLayout", "onScrollListener", "com/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectView$onScrollListener$1", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectView$onScrollListener$1;", "rightActionBtn", "Landroid/widget/TextView;", "rightActionText", "", "getRightActionText", "()Ljava/lang/String;", "selectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bean", "", "getSelectCallback", "()Lkotlin/jvm/functions/Function1;", "setSelectCallback", "(Lkotlin/jvm/functions/Function1;)V", "selectTip", "getSelectTip", "selectTipView", "addItemToTop", "(Ljava/lang/Object;)V", "handleRightActionClick", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttachedToWindow", "onDetachedFromWindow", "setCenterEmpty", "setCenterError", "errorCode", "errorMsg", "setCenterHide", "setCenterLoading", "setFooterError", "setFooterHasMore", "setFooterHide", "setFooterLoading", "setFooterNoMore", "setHeaderError", "setHeaderLoading", "setHeaderSuccess", "setListData", "allList", "", "isAppend", "setTotal", "total", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class BaseSelectView<BEAN, HOLDER extends BaseSelectAdapter.BaseSelectViewHolder>
  extends RelativeLayout
  implements ListContract.IListView<BEAN>, IOnActivityResult
{
  private View jdField_a_of_type_AndroidViewView;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final ListPresenter<BEAN, ListContract.IListView<BEAN>> jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListPresenter;
  private BaseSelectView.onScrollListener.1 jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelecttopicBaseSelectView$onScrollListener$1;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  @Nullable
  private Function1<? super BEAN, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  @NotNull
  private final String jdField_b_of_type_JavaLangString;
  
  public BaseSelectView(@NotNull Activity paramActivity, @NotNull ListPresenter<BEAN, ListContract.IListView<BEAN>> paramListPresenter)
  {
    super((Context)paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListPresenter = paramListPresenter;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelecttopicBaseSelectView$onScrollListener$1 = new BaseSelectView.onScrollListener.1(this);
    LayoutInflater.from((Context)paramActivity).inflate(2131560391, (ViewGroup)this, true);
    paramActivity = findViewById(2131377705);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "findViewById(R.id.selectTipView)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramActivity);
    paramActivity = findViewById(2131366407);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "findViewById(R.id.errorLayout)");
    this.jdField_a_of_type_AndroidViewView = paramActivity;
    paramActivity = findViewById(2131377059);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "findViewById(R.id.rightActionBtn)");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramActivity);
    paramActivity = findViewById(2131370459);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "findViewById(R.id.listView)");
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)paramActivity);
    paramActivity = findViewById(2131370725);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "findViewById(R.id.loadingLayout)");
    this.jdField_b_of_type_AndroidViewView = paramActivity;
    this.jdField_a_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)new BaseSelectView.1(this));
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  @NotNull
  public abstract BaseSelectAdapter<BEAN, HOLDER> a();
  
  @NotNull
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @Nullable
  public final Function1<BEAN, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
  }
  
  public void a() {}
  
  public final void a(BEAN paramBEAN)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramBEAN);
    localArrayList.addAll((Collection)a().a());
    a().a((List)localArrayList);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  @NotNull
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)a());
    if (((CharSequence)b()).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)b());
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)new BaseSelectView.onAttachedToWindow.1(this));
      }
      this.jdField_a_of_type_AndroidWidgetListView.setAdapter((ListAdapter)a());
      this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener((AdapterView.OnItemClickListener)new BaseSelectView.onAttachedToWindow.2(this));
      this.jdField_a_of_type_AndroidWidgetListView.setOnScrollListener((AbsListView.OnScrollListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelecttopicBaseSelectView$onScrollListener$1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListPresenter.a((ListContract.IListView)this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListPresenter.b();
      return;
    }
  }
  
  public void onDetachedFromWindow()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListPresenter.a();
    super.onDetachedFromWindow();
  }
  
  public void setCenterEmpty()
  {
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void setCenterError(int paramInt, @Nullable String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void setCenterHide()
  {
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void setCenterLoading()
  {
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void setFooterError(int paramInt, @Nullable String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void setFooterHasMore()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void setFooterHide() {}
  
  public void setFooterLoading()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void setFooterNoMore()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void setHeaderError(int paramInt, @Nullable String paramString) {}
  
  public void setHeaderLoading() {}
  
  public void setHeaderSuccess() {}
  
  public void setListData(@NotNull List<? extends BEAN> paramList, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "allList");
    a().a(paramList);
  }
  
  public final void setSelectCallback(@Nullable Function1<? super BEAN, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public void setTotal(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic.BaseSelectView
 * JD-Core Version:    0.7.0.1
 */