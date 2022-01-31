package com.tencent.biz.qqstory.takevideo.view.widget.colorbar;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.strategy.StrokeStrategy;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.HorizontalStroke;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import oki;
import okj;
import okk;
import okl;

public class HorizontalSelectColorLayout
  extends RelativeLayout
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  HorizontalSelectColorLayout.OnStrokeSelectedListener jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$OnStrokeSelectedListener;
  public HorizontalSelectColorLayout.OnUndoViewClickListener a;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  okl jdField_a_of_type_Okl;
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
    LayoutInflater.from(getContext()).inflate(2130970705, this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)super.findViewById(2131371652));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setStayDisplayOffsetZero(true);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(new oki(this));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemSelectedListener(new okj(this));
    this.jdField_a_of_type_Okl = new okl(this, getContext());
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Okl);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131371653));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new okk(this));
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getContext().getString(2131433432));
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Long > System.currentTimeMillis()) {}
    do
    {
      return;
      this.jdField_a_of_type_Okl.a(paramInt);
      this.jdField_a_of_type_Int = paramInt;
    } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$OnStrokeSelectedListener == null);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$OnStrokeSelectedListener.a(a());
  }
  
  public HorizontalStroke a()
  {
    return (HorizontalStroke)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
  }
  
  public void setAnimationEndTime(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setOnStrokeSelectedListener(HorizontalSelectColorLayout.OnStrokeSelectedListener paramOnStrokeSelectedListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$OnStrokeSelectedListener = paramOnStrokeSelectedListener;
  }
  
  public void setOnUndoViewClickListener(HorizontalSelectColorLayout.OnUndoViewClickListener paramOnUndoViewClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$OnUndoViewClickListener = paramOnUndoViewClickListener;
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
        HorizontalStroke localHorizontalStroke = (HorizontalStroke)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localHorizontalStroke.jdField_a_of_type_Int == 0) && (localHorizontalStroke.b == paramInt)) {
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
  
  public void setStrokeStrategy(StrokeStrategy paramStrokeStrategy, boolean paramBoolean, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    int i;
    label35:
    View localView;
    if (paramBoolean)
    {
      i = 0;
      ((ImageView)localObject).setVisibility(i);
      localObject = super.findViewById(2131371654);
      if (!paramBoolean) {
        break label135;
      }
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = super.findViewById(2131369673);
      localView = super.findViewById(2131363241);
      if (paramInt != 0) {
        break label142;
      }
      ((View)localObject).setVisibility(0);
      label68:
      if (paramStrokeStrategy == null) {
        break label176;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      paramStrokeStrategy.b(this.jdField_a_of_type_JavaUtilArrayList, getContext());
      if (this.jdField_a_of_type_Okl != null) {
        this.jdField_a_of_type_Okl.a(this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    for (;;)
    {
      super.setBackgroundColor(super.getContext().getResources().getColor(2131493770));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout
 * JD-Core Version:    0.7.0.1
 */