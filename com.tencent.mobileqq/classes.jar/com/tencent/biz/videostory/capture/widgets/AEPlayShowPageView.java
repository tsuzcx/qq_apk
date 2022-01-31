package com.tencent.biz.videostory.capture.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import bajq;
import bgya;
import bhci;
import bhcm;
import java.util.List;
import wrn;
import wrq;
import wus;
import wvw;
import wvx;

public class AEPlayShowPageView
  extends FrameLayout
{
  private static final wrq jdField_a_of_type_Wrq = a(1);
  private static final wrq b = a(2);
  private int jdField_a_of_type_Int = 2;
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private List<bgya> jdField_a_of_type_JavaUtilList;
  private wrn jdField_a_of_type_Wrn;
  private wus jdField_a_of_type_Wus;
  
  public AEPlayShowPageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, @NonNull wus paramwus, int paramInt2, @NonNull List<bgya> paramList)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    a(paramwus, paramInt2, paramList);
    a(paramContext);
  }
  
  public AEPlayShowPageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @NonNull wus paramwus, int paramInt, @NonNull List<bgya> paramList)
  {
    this(paramContext, paramAttributeSet, 0, paramwus, paramInt, paramList);
  }
  
  public AEPlayShowPageView(@NonNull Context paramContext, @NonNull wus paramwus, int paramInt, @NonNull List<bgya> paramList)
  {
    this(paramContext, null, paramwus, paramInt, paramList);
  }
  
  private static wrq a(int paramInt)
  {
    int j = bajq.a(10.0F);
    int k = bajq.a(4.0F);
    int m = (int)(k * 0.96F);
    if (paramInt == 1) {}
    for (int i = bajq.a() - j * 2 - k * 2;; i = (bajq.a() - j * 2 - k * 4) / 2)
    {
      int n = (int)(i * 0.96F * 59.0F / 34.0F);
      wrq localwrq = new wrq();
      localwrq.jdField_a_of_type_Int = (i + k * 2);
      localwrq.b = (m * 2 + n);
      localwrq.c = k;
      localwrq.d = m;
      if (paramInt == 1) {
        localwrq.d = j;
      }
      return localwrq;
    }
  }
  
  private void a(@NonNull Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131492966, this, true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131296635));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new wvw(this));
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(paramContext, 1, 1, false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
      if (this.jdField_a_of_type_Int != 1) {
        break label168;
      }
    }
    label168:
    for (wrq localwrq = new wrq(jdField_a_of_type_Wrq);; localwrq = new wrq(b))
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new wvx(this, localwrq));
      this.jdField_a_of_type_Wrn = new wrn(paramContext, this.jdField_a_of_type_Wus, localwrq, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Wrn);
      a(this.jdField_a_of_type_JavaUtilList);
      return;
      this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(paramContext, 2, 1, false);
      break;
    }
  }
  
  private void a(@NonNull wus paramwus, int paramInt, @NonNull List<bgya> paramList)
  {
    this.jdField_a_of_type_Wus = paramwus;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Wrn.a();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(paramInt);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new AEPlayShowPageView.3(this, paramInt));
    }
  }
  
  public void a(@NonNull List<bgya> paramList)
  {
    if (this.jdField_a_of_type_Wrn != null) {
      this.jdField_a_of_type_Wrn.a(paramList);
    }
  }
  
  public void b()
  {
    int i = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
    int j = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findLastVisibleItemPosition();
    if ((this.jdField_a_of_type_JavaUtilList == null) || (i < 0) || (j < 0)) {}
    for (;;)
    {
      return;
      while ((i < this.jdField_a_of_type_JavaUtilList.size()) && (i <= j))
      {
        bgya localbgya = (bgya)this.jdField_a_of_type_JavaUtilList.get(i);
        bhcm.a().c(localbgya.e);
        bhcm.a().b(i + 1);
        bhci.a().e(localbgya.a);
        i += 1;
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollTo(0, paramInt);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Wrn.b();
  }
  
  public void setTabId(String paramString)
  {
    this.jdField_a_of_type_Wrn.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.widgets.AEPlayShowPageView
 * JD-Core Version:    0.7.0.1
 */