package com.tencent.biz.qqstory.takevideo.view.widget.colorbar;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import zbj;
import zbk;
import zbl;
import zbm;
import zbn;
import zbo;
import zbs;
import zbt;

public class HorizontalSelectColorLayout
  extends RelativeLayout
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  ArrayList<zbt> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  zbm jdField_a_of_type_Zbm;
  public zbn a;
  zbo jdField_a_of_type_Zbo;
  public boolean a;
  
  public HorizontalSelectColorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public HorizontalSelectColorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131561700, this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)super.findViewById(2131364805));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setStayDisplayOffsetZero(true);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(new zbj(this));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemSelectedListener(new zbk(this));
    this.jdField_a_of_type_Zbo = new zbo(this, getContext());
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Zbo);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131380455));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new zbl(this));
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getContext().getString(2131691776));
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Long > System.currentTimeMillis()) {}
    do
    {
      return;
      this.jdField_a_of_type_Zbo.a(paramInt);
      this.jdField_a_of_type_Int = paramInt;
    } while (this.jdField_a_of_type_Zbm == null);
    this.jdField_a_of_type_Zbm.a(a());
  }
  
  public zbt a()
  {
    return (zbt)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
  }
  
  public void setAnimationEndTime(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setOnStrokeSelectedListener(zbm paramzbm)
  {
    this.jdField_a_of_type_Zbm = paramzbm;
  }
  
  public void setOnUndoViewClickListener(zbn paramzbn)
  {
    this.jdField_a_of_type_Zbn = paramzbn;
  }
  
  public void setSelectedStrokeWithColor(int paramInt)
  {
    int i;
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        zbt localzbt = (zbt)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localzbt.jdField_a_of_type_Int == 0) && (localzbt.b == paramInt)) {
          a(i);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void setStrokeStrategy(zbs paramzbs, boolean paramBoolean, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    int i;
    label35:
    View localView;
    if (paramBoolean)
    {
      i = 0;
      ((ImageView)localObject).setVisibility(i);
      localObject = super.findViewById(2131380456);
      if (!paramBoolean) {
        break label135;
      }
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = super.findViewById(2131379237);
      localView = super.findViewById(2131363727);
      if (paramInt != 0) {
        break label142;
      }
      ((View)localObject).setVisibility(0);
      label68:
      if (paramzbs == null) {
        break label176;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      paramzbs.a(this.jdField_a_of_type_JavaUtilArrayList, getContext());
      if (this.jdField_a_of_type_Zbo != null) {
        this.jdField_a_of_type_Zbo.a(this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    for (;;)
    {
      super.setBackgroundColor(super.getContext().getResources().getColor(2131166486));
      return;
      i = 8;
      break;
      label135:
      i = 8;
      break label35;
      label142:
      if (paramInt == 1)
      {
        localView.setVisibility(0);
        break label68;
      }
      if (paramInt != 2) {
        break label68;
      }
      ((View)localObject).setVisibility(0);
      localView.setVisibility(0);
      break label68;
      label176:
      setVisibility(8);
    }
  }
  
  public void setUndoViewEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout
 * JD-Core Version:    0.7.0.1
 */