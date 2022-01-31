package com.tencent.biz.troopgift;

import aciy;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.util.ArrayList;
import wmt;
import wmv;

public class GridListViewPager
  extends absMultiViewPager
{
  protected int a;
  public TroopGiftPanel a;
  protected String a;
  protected int b = 4;
  protected int c = 2;
  
  public GridListViewPager(Context paramContext)
  {
    super(paramContext);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.jdField_a_of_type_Int = Math.min(paramContext.heightPixels, paramContext.widthPixels);
  }
  
  public GridListViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.jdField_a_of_type_Int = Math.min(paramContext.heightPixels, paramContext.widthPixels);
  }
  
  public int a()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size() / (this.b * this.c);
    int i = j;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() % (this.b * this.c) > 0) {
      i = j + 1;
    }
    return i;
  }
  
  public View a(int paramInt)
  {
    return a(paramInt, a(paramInt));
  }
  
  public View a(int paramInt, ArrayList<Object> paramArrayList)
  {
    wmv localwmv = new wmv(this, getContext());
    localwmv.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localwmv.setVerticalSpacing(0);
    localwmv.setHorizontalSpacing(10);
    localwmv.setColumnWidth(this.jdField_a_of_type_Int / this.b - 40);
    localwmv.setNumColumns(this.b);
    Object localObject = getContext().getResources();
    localwmv.setPadding(aciy.a(5.0F, (Resources)localObject), aciy.a(1.0F, (Resources)localObject), aciy.a(5.0F, (Resources)localObject), aciy.a(1.0F, (Resources)localObject));
    localwmv.setGravity(1);
    localwmv.setSelector(new ColorDrawable(0));
    localObject = new wmt(getContext(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel);
    ((wmt)localObject).a(paramArrayList);
    ((wmt)localObject).a(this.jdField_a_of_type_JavaLangString);
    localwmv.setAdapter((ListAdapter)localObject);
    localwmv.setOnItemClickListener(this);
    ((wmt)localObject).notifyDataSetChanged();
    return localwmv;
  }
  
  public ArrayList<Object> a(int paramInt)
  {
    if (paramInt == this.d - 1) {
      return a(this.jdField_a_of_type_JavaUtilArrayList, this.b * this.c * paramInt, this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    return a(this.jdField_a_of_type_JavaUtilArrayList, this.b * this.c * paramInt, (paramInt + 1) * (this.b * this.c));
  }
  
  public void a()
  {
    ArrayList localArrayList = ((absMultiViewPager.ViewPagerAdapter)getAdapter()).a();
    int i = 0;
    while (i < localArrayList.size())
    {
      ((wmt)((GridView)localArrayList.get(i)).getAdapter()).notifyDataSetChanged();
      i += 1;
    }
  }
  
  public void setGridGiftIcon(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setGridSize(int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = 0;
    if (this.b != paramInt1)
    {
      this.b = paramInt1;
      i = 1;
    }
    if (this.c != paramInt2) {
      this.c = paramInt2;
    }
    for (paramInt1 = j;; paramInt1 = i)
    {
      if (paramInt1 != 0) {
        b();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.troopgift.GridListViewPager
 * JD-Core Version:    0.7.0.1
 */