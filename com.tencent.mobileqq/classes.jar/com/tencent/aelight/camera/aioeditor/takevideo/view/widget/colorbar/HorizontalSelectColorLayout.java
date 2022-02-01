package com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.strategy.StrokeStrategy;
import com.tencent.aelight.camera.struct.editor.HorizontalStroke;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class HorizontalSelectColorLayout
  extends RelativeLayout
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  HorizontalSelectColorLayout.OnStrokeSelectedListener jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout$OnStrokeSelectedListener;
  HorizontalSelectColorLayout.OnUndoViewClickListener jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout$OnUndoViewClickListener;
  HorizontalSelectColorLayout.SelectColorAdapter jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout$SelectColorAdapter;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  ArrayList<HorizontalStroke> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean;
  boolean b = false;
  
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
    LayoutInflater.from(getContext()).inflate(2131561684, this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)super.findViewById(2131364813));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setStayDisplayOffsetZero(true);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(new HorizontalSelectColorLayout.1(this));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemSelectedListener(new HorizontalSelectColorLayout.2(this));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout$SelectColorAdapter = new HorizontalSelectColorLayout.SelectColorAdapter(this, getContext());
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout$SelectColorAdapter);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131380163));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new HorizontalSelectColorLayout.3(this));
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Long > System.currentTimeMillis()) {
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout$SelectColorAdapter.a(paramInt);
    this.jdField_a_of_type_Int = paramInt;
    HorizontalSelectColorLayout.OnStrokeSelectedListener localOnStrokeSelectedListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout$OnStrokeSelectedListener;
    if (localOnStrokeSelectedListener != null) {
      localOnStrokeSelectedListener.a(a());
    }
  }
  
  public HorizontalStroke a()
  {
    return (HorizontalStroke)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
  }
  
  public void setAnimationEndTime(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setEditDialogMode(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setOnStrokeSelectedListener(HorizontalSelectColorLayout.OnStrokeSelectedListener paramOnStrokeSelectedListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout$OnStrokeSelectedListener = paramOnStrokeSelectedListener;
  }
  
  public void setOnUndoViewClickListener(HorizontalSelectColorLayout.OnUndoViewClickListener paramOnUndoViewClickListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout$OnUndoViewClickListener = paramOnUndoViewClickListener;
  }
  
  public void setSelectedStroke(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        HorizontalStroke localHorizontalStroke = (HorizontalStroke)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localHorizontalStroke.jdField_a_of_type_Int == paramInt1) && (localHorizontalStroke.b == paramInt2))
        {
          a(i);
          if (i <= 5) {
            break;
          }
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.smoothScrollToPosition(i);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void setSelectedStrokeWithColor(int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        HorizontalStroke localHorizontalStroke = (HorizontalStroke)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localHorizontalStroke.jdField_a_of_type_Int == 0) && (localHorizontalStroke.b == paramInt))
        {
          a(i);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void setStrokeStrategy(StrokeStrategy paramStrokeStrategy, boolean paramBoolean, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    ((ImageView)localObject).setVisibility(i);
    localObject = super.findViewById(2131380164);
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
    localObject = super.findViewById(2131379013);
    View localView = super.findViewById(2131363751);
    if (paramInt == 1)
    {
      ((View)localObject).setVisibility(0);
    }
    else if (paramInt == 2)
    {
      localView.setVisibility(0);
    }
    else if (paramInt == 3)
    {
      ((View)localObject).setVisibility(0);
      localView.setVisibility(0);
    }
    if (paramStrokeStrategy != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      paramStrokeStrategy.a(this.jdField_a_of_type_JavaUtilArrayList, getContext());
      paramStrokeStrategy = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout$SelectColorAdapter;
      if (paramStrokeStrategy != null) {
        paramStrokeStrategy.a(this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    else
    {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.HorizontalSelectColorLayout
 * JD-Core Version:    0.7.0.1
 */