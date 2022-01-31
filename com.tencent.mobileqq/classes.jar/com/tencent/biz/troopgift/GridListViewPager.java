package com.tencent.biz.troopgift;

import aepi;
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
import yvb;
import yvd;

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
    yvd localyvd = new yvd(this, getContext());
    localyvd.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localyvd.setVerticalSpacing(0);
    localyvd.setHorizontalSpacing(10);
    localyvd.setColumnWidth(this.jdField_a_of_type_Int / this.b - 40);
    localyvd.setNumColumns(this.b);
    Object localObject = getContext().getResources();
    localyvd.setPadding(aepi.a(5.0F, (Resources)localObject), aepi.a(1.0F, (Resources)localObject), aepi.a(5.0F, (Resources)localObject), aepi.a(1.0F, (Resources)localObject));
    localyvd.setGravity(1);
    localyvd.setSelector(new ColorDrawable(0));
    localObject = new yvb(getContext(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel);
    ((yvb)localObject).a(paramArrayList);
    ((yvb)localObject).a(this.jdField_a_of_type_JavaLangString);
    localyvd.setAdapter((ListAdapter)localObject);
    localyvd.setOnItemClickListener(this);
    ((yvb)localObject).notifyDataSetChanged();
    return localyvd;
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
      ((yvb)((GridView)localArrayList.get(i)).getAdapter()).notifyDataSetChanged();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.troopgift.GridListViewPager
 * JD-Core Version:    0.7.0.1
 */