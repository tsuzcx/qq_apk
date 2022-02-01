package com.tencent.biz.troopgift;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;

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
    GridListViewPager.1 local1 = new GridListViewPager.1(this, getContext());
    local1.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    local1.setVerticalSpacing(0);
    local1.setHorizontalSpacing(10);
    local1.setColumnWidth(this.jdField_a_of_type_Int / this.b - 40);
    local1.setNumColumns(this.b);
    Object localObject = getContext().getResources();
    local1.setPadding(AIOUtils.b(5.0F, (Resources)localObject), AIOUtils.b(1.0F, (Resources)localObject), AIOUtils.b(5.0F, (Resources)localObject), AIOUtils.b(1.0F, (Resources)localObject));
    local1.setGravity(1);
    local1.setSelector(new ColorDrawable(0));
    localObject = new GridListAdapter(getContext(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel);
    ((GridListAdapter)localObject).a(paramArrayList);
    ((GridListAdapter)localObject).a(this.jdField_a_of_type_JavaLangString);
    local1.setAdapter((ListAdapter)localObject);
    local1.setOnItemClickListener(this);
    ((GridListAdapter)localObject).notifyDataSetChanged();
    return local1;
  }
  
  public ArrayList<Object> a(int paramInt)
  {
    if (paramInt == this.d - 1) {
      return a(this.jdField_a_of_type_JavaUtilArrayList, this.b * this.c * paramInt, this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i = this.b;
    int j = this.c;
    return a(localArrayList, i * j * paramInt, (paramInt + 1) * (i * j));
  }
  
  public void a()
  {
    ArrayList localArrayList = ((absMultiViewPager.ViewPagerAdapter)getAdapter()).a();
    int i = 0;
    while (i < localArrayList.size())
    {
      ((GridListAdapter)((GridView)localArrayList.get(i)).getAdapter()).notifyDataSetChanged();
      i += 1;
    }
  }
  
  public void setGridGiftIcon(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setGridSize(int paramInt1, int paramInt2)
  {
    if (this.b != paramInt1)
    {
      this.b = paramInt1;
      paramInt1 = 1;
    }
    else
    {
      paramInt1 = 0;
    }
    if (this.c != paramInt2)
    {
      this.c = paramInt2;
      paramInt1 = 1;
    }
    if (paramInt1 != 0) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopgift.GridListViewPager
 * JD-Core Version:    0.7.0.1
 */