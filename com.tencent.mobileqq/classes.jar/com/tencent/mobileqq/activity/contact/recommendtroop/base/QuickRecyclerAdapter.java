package com.tencent.mobileqq.activity.contact.recommendtroop.base;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class QuickRecyclerAdapter<T>
  extends RecyclerView.Adapter<ViewHolder>
{
  private int jdField_a_of_type_Int;
  private SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  protected View a;
  protected ItemViewDelegateManager a;
  protected QuickRecyclerAdapter.OnItemClickListener a;
  private QuickRecyclerAdapter.OnLoadMoreListener jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseQuickRecyclerAdapter$OnLoadMoreListener;
  protected List<T> a;
  protected boolean a;
  protected int b;
  protected Context b;
  private SparseArray<View> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_b_of_type_AndroidViewView;
  protected int c = -1;
  
  public QuickRecyclerAdapter(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseItemViewDelegateManager = new ItemViewDelegateManager();
  }
  
  private QuickRecyclerAdapter<T> a(QuickRecyclerAdapter.OnLoadMoreListener paramOnLoadMoreListener)
  {
    if (paramOnLoadMoreListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseQuickRecyclerAdapter$OnLoadMoreListener = paramOnLoadMoreListener;
    }
    return this;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public QuickRecyclerAdapter a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public QuickRecyclerAdapter a(ItemViewDelegate<T> paramItemViewDelegate)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseItemViewDelegateManager.a(paramItemViewDelegate);
    return this;
  }
  
  public ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 2147483646)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        return ViewHolder.a(paramViewGroup.getContext(), this.jdField_a_of_type_AndroidViewView);
      }
      return ViewHolder.a(paramViewGroup.getContext(), paramViewGroup, this.jdField_b_of_type_Int);
    }
    if ((paramInt == 2147483645) && (a()))
    {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        return ViewHolder.a(paramViewGroup.getContext(), this.jdField_b_of_type_AndroidViewView);
      }
      return ViewHolder.a(paramViewGroup.getContext(), paramViewGroup, this.jdField_a_of_type_Int);
    }
    if ((paramInt >= 1000000) && (this.jdField_a_of_type_AndroidUtilSparseArray != null) && (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null)) {
      return ViewHolder.a(paramViewGroup.getContext(), (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
    }
    if ((paramInt >= 2000000) && (this.jdField_b_of_type_AndroidUtilSparseArray != null) && (this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt) != null)) {
      return ViewHolder.a(paramViewGroup.getContext(), (View)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt));
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseItemViewDelegateManager.a(paramInt).a();
    ViewHolder localViewHolder = b(this.jdField_b_of_type_AndroidContentContext, paramViewGroup, i);
    a(localViewHolder, localViewHolder.a());
    a(paramViewGroup, localViewHolder, paramInt);
    return localViewHolder;
  }
  
  public T a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    do
    {
      return null;
      paramInt -= b();
    } while (paramInt >= this.jdField_a_of_type_JavaUtilList.size());
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  protected void a(ViewGroup paramViewGroup, ViewHolder paramViewHolder, int paramInt)
  {
    if (!d(paramInt)) {
      return;
    }
    paramViewHolder.a().setOnClickListener(new QuickRecyclerAdapter.2(this, paramViewHolder));
    paramViewHolder.a().setOnLongClickListener(new QuickRecyclerAdapter.3(this, paramViewHolder));
  }
  
  public void a(QuickRecyclerAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseQuickRecyclerAdapter$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void a(QuickRecyclerAdapter.OnLoadMoreListener paramOnLoadMoreListener)
  {
    if (a()) {
      return;
    }
    a(paramOnLoadMoreListener);
    this.jdField_a_of_type_Boolean = true;
    notifyDataSetChanged();
  }
  
  public void a(ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if ((a(paramViewHolder.getLayoutPosition())) || (b(paramViewHolder.getLayoutPosition())) || (c(paramViewHolder.getLayoutPosition())) || (b()))
    {
      paramViewHolder = paramViewHolder.itemView.getLayoutParams();
      if ((paramViewHolder != null) && ((paramViewHolder instanceof StaggeredGridLayoutManager.LayoutParams))) {
        ((StaggeredGridLayoutManager.LayoutParams)paramViewHolder).setFullSpan(true);
      }
    }
  }
  
  public void a(ViewHolder paramViewHolder, int paramInt)
  {
    if ((a(paramInt)) || (b(paramInt)) || (b())) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      if (c(paramInt))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseQuickRecyclerAdapter$OnLoadMoreListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseQuickRecyclerAdapter$OnLoadMoreListener.a();
        }
      }
      else {
        a(paramViewHolder, a(paramInt));
      }
    }
  }
  
  public void a(ViewHolder paramViewHolder, View paramView) {}
  
  public void a(ViewHolder paramViewHolder, T paramT)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseItemViewDelegateManager.a(paramViewHolder, paramT, paramViewHolder.getAdapterPosition());
  }
  
  public void a(List<T> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (b())
      {
        notifyItemRemoved(this.c);
        notifyDataSetChanged();
      }
      int i = b();
      int j = a();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyItemRangeInserted(i + j, paramList.size());
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && ((this.jdField_b_of_type_AndroidViewView != null) || (this.jdField_a_of_type_Int != 0));
  }
  
  protected boolean a(int paramInt)
  {
    return paramInt < b();
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return this.jdField_a_of_type_AndroidUtilSparseArray.size();
    }
    return 0;
  }
  
  public ViewHolder b(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return ViewHolder.a(paramContext, paramViewGroup, paramInt);
  }
  
  public void b()
  {
    if (a())
    {
      a(null);
      this.jdField_a_of_type_Boolean = false;
      notifyDataSetChanged();
    }
  }
  
  protected boolean b()
  {
    return ((this.jdField_a_of_type_AndroidViewView != null) || (this.jdField_b_of_type_Int != 0)) && (a() == 0);
  }
  
  protected boolean b(int paramInt)
  {
    return (paramInt >= a() + b() + e()) && (paramInt < a() + b() + e() + c());
  }
  
  public int c()
  {
    if (this.jdField_b_of_type_AndroidUtilSparseArray != null) {
      return this.jdField_b_of_type_AndroidUtilSparseArray.size();
    }
    return 0;
  }
  
  protected boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseItemViewDelegateManager.a() > 0;
  }
  
  protected boolean c(int paramInt)
  {
    return (a()) && (paramInt == a() + b() + e() + c());
  }
  
  protected int d()
  {
    if (a()) {
      return 1;
    }
    return 0;
  }
  
  protected boolean d(int paramInt)
  {
    return true;
  }
  
  protected int e()
  {
    if (b()) {
      return 1;
    }
    return 0;
  }
  
  public int getItemCount()
  {
    return b() + c() + a() + e() + d();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (a(paramInt)) {
      return this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(paramInt);
    }
    if ((b()) && ((this.c == -1) || (paramInt == this.c)))
    {
      this.c = paramInt;
      return 2147483646;
    }
    if (b(paramInt)) {
      return this.jdField_b_of_type_AndroidUtilSparseArray.keyAt(paramInt - b() - a() - e());
    }
    if (c(paramInt)) {
      return 2147483645;
    }
    if (c()) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseItemViewDelegateManager.a(a(paramInt), paramInt);
    }
    return super.getItemViewType(paramInt);
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager))
    {
      paramRecyclerView = (GridLayoutManager)paramRecyclerView;
      paramRecyclerView.setSpanSizeLookup(new QuickRecyclerAdapter.1(this, paramRecyclerView));
      paramRecyclerView.setSpanCount(paramRecyclerView.getSpanCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.recommendtroop.base.QuickRecyclerAdapter
 * JD-Core Version:    0.7.0.1
 */