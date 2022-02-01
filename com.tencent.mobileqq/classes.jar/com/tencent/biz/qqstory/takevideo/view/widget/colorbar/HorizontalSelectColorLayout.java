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
import zlq;
import zlr;
import zls;
import zlt;
import zlu;
import zlv;
import zlz;
import zma;

public class HorizontalSelectColorLayout
  extends RelativeLayout
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  ArrayList<zma> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  zlt jdField_a_of_type_Zlt;
  public zlu a;
  zlv jdField_a_of_type_Zlv;
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
    LayoutInflater.from(getContext()).inflate(2131561754, this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)super.findViewById(2131364687));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setStayDisplayOffsetZero(true);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(new zlq(this));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemSelectedListener(new zlr(this));
    this.jdField_a_of_type_Zlv = new zlv(this, getContext());
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Zlv);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131380396));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new zls(this));
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getContext().getString(2131691647));
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Long > System.currentTimeMillis()) {}
    do
    {
      return;
      this.jdField_a_of_type_Zlv.a(paramInt);
      this.jdField_a_of_type_Int = paramInt;
    } while (this.jdField_a_of_type_Zlt == null);
    this.jdField_a_of_type_Zlt.a(a());
  }
  
  public zma a()
  {
    return (zma)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
  }
  
  public void setAnimationEndTime(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setOnStrokeSelectedListener(zlt paramzlt)
  {
    this.jdField_a_of_type_Zlt = paramzlt;
  }
  
  public void setOnUndoViewClickListener(zlu paramzlu)
  {
    this.jdField_a_of_type_Zlu = paramzlu;
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
        zma localzma = (zma)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localzma.jdField_a_of_type_Int == 0) && (localzma.b == paramInt)) {
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
  
  public void setStrokeStrategy(zlz paramzlz, boolean paramBoolean, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    int i;
    label35:
    View localView;
    if (paramBoolean)
    {
      i = 0;
      ((ImageView)localObject).setVisibility(i);
      localObject = super.findViewById(2131380397);
      if (!paramBoolean) {
        break label135;
      }
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = super.findViewById(2131379173);
      localView = super.findViewById(2131363626);
      if (paramInt != 0) {
        break label142;
      }
      ((View)localObject).setVisibility(0);
      label68:
      if (paramzlz == null) {
        break label176;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      paramzlz.a(this.jdField_a_of_type_JavaUtilArrayList, getContext());
      if (this.jdField_a_of_type_Zlv != null) {
        this.jdField_a_of_type_Zlv.a(this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    for (;;)
    {
      super.setBackgroundColor(super.getContext().getResources().getColor(2131166453));
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