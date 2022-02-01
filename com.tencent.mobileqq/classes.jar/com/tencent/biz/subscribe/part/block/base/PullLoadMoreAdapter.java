package com.tencent.biz.subscribe.part.block.base;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public abstract class PullLoadMoreAdapter<E>
  extends BaseListViewAdapter<E>
  implements RefreshHeaderView.OnRefreshListener
{
  private static String jdField_g_of_type_JavaLangString = "PullLoadMoreAdapter";
  protected final Handler a;
  public RecyclerView.LayoutManager a;
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  protected RecyclerView a;
  private View jdField_a_of_type_AndroidViewView;
  private RefreshHeaderView jdField_a_of_type_ComTencentBizSubscribePartBlockBaseRefreshHeaderView;
  protected String a;
  private boolean jdField_a_of_type_Boolean = false;
  protected String b;
  private boolean b;
  protected String c;
  private boolean c;
  protected String d;
  private boolean d;
  protected String e;
  private boolean e;
  protected String f;
  private boolean f;
  private boolean jdField_g_of_type_Boolean = true;
  
  public PullLoadMoreAdapter()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131702322);
    this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131702396);
    this.jdField_c_of_type_JavaLangString = HardCodeUtil.a(2131702395);
    this.jdField_d_of_type_JavaLangString = HardCodeUtil.a(2131697952);
    this.jdField_e_of_type_JavaLangString = HardCodeUtil.a(2131708844);
    this.jdField_f_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    this.jdField_c_of_type_Boolean = true;
  }
  
  public int a(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_b_of_type_Boolean) {
      i = paramInt - 1;
    }
    return i;
  }
  
  protected abstract RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt);
  
  public RefreshHeaderView a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseRefreshHeaderView;
  }
  
  public void a(RecyclerView.LayoutManager paramLayoutManager)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = paramLayoutManager;
  }
  
  protected abstract void a(RecyclerView.ViewHolder paramViewHolder, int paramInt);
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool;
    label62:
    int i;
    if (d())
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = paramBoolean2;
      this.jdField_d_of_type_Boolean = paramBoolean1;
      if (!paramBoolean2) {
        break label173;
      }
      str = this.jdField_d_of_type_JavaLangString;
      this.jdField_f_of_type_JavaLangString = str;
      if ((StringUtil.a(this.jdField_f_of_type_JavaLangString)) && ((!paramBoolean2) || (this.jdField_a_of_type_AndroidViewView == null))) {
        break label180;
      }
      bool = true;
      this.jdField_f_of_type_Boolean = bool;
      if (!paramBoolean1)
      {
        if (NetworkUtils.isNetworkAvailable(BaseApplication.getContext())) {
          break label186;
        }
        i = 1;
        label83:
        if (i == 0) {
          break label191;
        }
      }
    }
    label173:
    label180:
    label186:
    label191:
    for (String str = this.jdField_c_of_type_JavaLangString;; str = this.jdField_b_of_type_JavaLangString)
    {
      this.jdField_f_of_type_JavaLangString = str;
      this.jdField_f_of_type_Boolean = this.jdField_g_of_type_Boolean;
      ThreadManager.getUIHandler().post(new PullLoadMoreAdapter.1(this));
      QLog.i(jdField_g_of_type_JavaLangString, 1, String.format("onLoadMoreCompleted: hashCode:%d ,isSuccess:%b, isFinish:%b, isShow:%b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.jdField_f_of_type_Boolean) }));
      return;
      str = "";
      break;
      bool = false;
      break label62;
      i = 0;
      break label83;
    }
  }
  
  public int b()
  {
    int i = 0;
    if (this.jdField_b_of_type_Boolean) {
      i = 1;
    }
    int j = i;
    if (this.jdField_c_of_type_Boolean) {
      j = i + 1;
    }
    return j;
  }
  
  protected RecyclerView.ViewHolder b(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseRefreshHeaderView == null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseRefreshHeaderView = new RefreshHeaderView(paramViewGroup.getContext());
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseRefreshHeaderView.setMinimumHeight(1);
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseRefreshHeaderView.setOnRefreshListener(this);
    }
    return new PullLoadMoreAdapter.RefreshViewHolder(this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseRefreshHeaderView);
  }
  
  public void b() {}
  
  protected void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof PullLoadMoreAdapter.LoadMoreViewHolder))
    {
      paramViewHolder = (PullLoadMoreAdapter.LoadMoreViewHolder)paramViewHolder;
      if (!this.jdField_f_of_type_Boolean)
      {
        PullLoadMoreAdapter.LoadMoreViewHolder.a(paramViewHolder).setVisibility(8);
        if (this.jdField_a_of_type_AndroidViewView != null) {
          PullLoadMoreAdapter.LoadMoreViewHolder.a(paramViewHolder).setVisibility(8);
        }
        QLog.i(jdField_g_of_type_JavaLangString, 1, "onBindProgressViewHolder hideLoadingFooter");
      }
    }
    else
    {
      return;
    }
    boolean bool;
    ProgressBar localProgressBar;
    if ((this.jdField_e_of_type_Boolean) && (getItemCount() > c()))
    {
      bool = true;
      PullLoadMoreAdapter.LoadMoreViewHolder.a(paramViewHolder).setIndeterminate(bool);
      localProgressBar = PullLoadMoreAdapter.LoadMoreViewHolder.a(paramViewHolder);
      if (!bool) {
        break label146;
      }
    }
    label146:
    for (paramInt = 0;; paramInt = 8)
    {
      localProgressBar.setVisibility(paramInt);
      if ((this.jdField_a_of_type_AndroidViewView == null) || (!this.jdField_a_of_type_Boolean)) {
        break label152;
      }
      PullLoadMoreAdapter.LoadMoreViewHolder.a(paramViewHolder).setVisibility(8);
      PullLoadMoreAdapter.LoadMoreViewHolder.a(paramViewHolder).setVisibility(0);
      QLog.i(jdField_g_of_type_JavaLangString, 1, "onBindProgressViewHolder show CustomNoMoreDataView");
      return;
      bool = false;
      break;
    }
    label152:
    PullLoadMoreAdapter.LoadMoreViewHolder.a(paramViewHolder).setVisibility(0);
    PullLoadMoreAdapter.LoadMoreViewHolder.a(paramViewHolder).setText(this.jdField_f_of_type_JavaLangString);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      PullLoadMoreAdapter.LoadMoreViewHolder.a(paramViewHolder).setVisibility(8);
    }
    QLog.i(jdField_g_of_type_JavaLangString, 1, "onBindProgressViewHolder show progress text:" + this.jdField_f_of_type_JavaLangString);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseRefreshHeaderView != null)
    {
      this.jdField_e_of_type_Boolean = c();
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseRefreshHeaderView.setRefreshing(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected int c()
  {
    return 1;
  }
  
  protected RecyclerView.ViewHolder c(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new PullLoadMoreAdapter.LoadMoreViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560843, paramViewGroup, false));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      PullLoadMoreAdapter.LoadMoreViewHolder.a(paramViewGroup).addView(this.jdField_a_of_type_AndroidViewView);
    }
    return paramViewGroup;
  }
  
  protected abstract void c();
  
  public void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseRefreshHeaderView != null) {
      return this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseRefreshHeaderView.b();
    }
    return false;
  }
  
  public boolean d()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void f()
  {
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    this.jdField_f_of_type_Boolean = true;
    notifyItemChanged(getItemCount() - 1);
  }
  
  protected void g()
  {
    int j;
    try
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager == null) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager();
      }
      if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager instanceof LinearLayoutManager))
      {
        if (((LinearLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).findLastVisibleItemPosition() < this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager.getItemCount() - 3) {
          return;
        }
        c();
        return;
      }
      if (!(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager instanceof StaggeredGridLayoutManager)) {
        return;
      }
      StaggeredGridLayoutManager localStaggeredGridLayoutManager = (StaggeredGridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
      j = localStaggeredGridLayoutManager.getColumnCountForAccessibility(null, null);
      if (j == 1)
      {
        arrayOfInt = new int[1];
        localStaggeredGridLayoutManager.findLastVisibleItemPositions(arrayOfInt);
        if (arrayOfInt[0] < localStaggeredGridLayoutManager.getItemCount() - 3) {
          return;
        }
        c();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    int[] arrayOfInt = new int[j];
    localException.findLastVisibleItemPositions(arrayOfInt);
    int i = arrayOfInt[(j - 1)];
    if (arrayOfInt.length == 2) {
      if (arrayOfInt[1] < arrayOfInt[0]) {
        break label185;
      }
    }
    label185:
    for (i = arrayOfInt[1]; i >= localException.getItemCount() - b() - 3 * j; i = arrayOfInt[0])
    {
      c();
      return;
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size() + b();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_b_of_type_Boolean) && (paramInt == 0)) {
      return -10000;
    }
    if (a(paramInt) < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return 0;
    }
    return -99999;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = paramRecyclerView.getLayoutManager();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new PullLoadMoreAdapter.2(this));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder == null) || (paramInt >= getItemCount()) || ((this.jdField_b_of_type_Boolean) && (paramInt == 0))) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      if (-99999 == getItemViewType(paramInt)) {
        b(paramViewHolder, paramInt);
      } else {
        a(paramViewHolder, a(paramInt));
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == -99999) {
      return c(paramViewGroup, paramInt);
    }
    if (paramInt == -10000)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = b(paramViewGroup, paramInt);
      return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    }
    return a(paramViewGroup, paramInt);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseRefreshHeaderView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseRefreshHeaderView.d();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.base.PullLoadMoreAdapter
 * JD-Core Version:    0.7.0.1
 */