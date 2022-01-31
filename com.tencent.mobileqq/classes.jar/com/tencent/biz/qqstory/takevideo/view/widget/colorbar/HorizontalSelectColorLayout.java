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
import vvj;
import vvk;
import vvl;
import vvm;
import vvn;
import vvo;
import vvs;
import vvt;

public class HorizontalSelectColorLayout
  extends RelativeLayout
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  ArrayList<vvt> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  vvm jdField_a_of_type_Vvm;
  public vvn a;
  vvo jdField_a_of_type_Vvo;
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
    LayoutInflater.from(getContext()).inflate(2131561270, this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)super.findViewById(2131364363));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setStayDisplayOffsetZero(true);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(new vvj(this));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemSelectedListener(new vvk(this));
    this.jdField_a_of_type_Vvo = new vvo(this, getContext());
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Vvo);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131378608));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new vvl(this));
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getContext().getString(2131691915));
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Long > System.currentTimeMillis()) {}
    do
    {
      return;
      this.jdField_a_of_type_Vvo.a(paramInt);
      this.jdField_a_of_type_Int = paramInt;
    } while (this.jdField_a_of_type_Vvm == null);
    this.jdField_a_of_type_Vvm.a(a());
  }
  
  public vvt a()
  {
    return (vvt)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
  }
  
  public void setAnimationEndTime(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setOnStrokeSelectedListener(vvm paramvvm)
  {
    this.jdField_a_of_type_Vvm = paramvvm;
  }
  
  public void setOnUndoViewClickListener(vvn paramvvn)
  {
    this.jdField_a_of_type_Vvn = paramvvn;
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
        vvt localvvt = (vvt)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localvvt.jdField_a_of_type_Int == 0) && (localvvt.b == paramInt)) {
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
  
  public void setStrokeStrategy(vvs paramvvs, boolean paramBoolean, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    int i;
    label35:
    View localView;
    if (paramBoolean)
    {
      i = 0;
      ((ImageView)localObject).setVisibility(i);
      localObject = super.findViewById(2131378609);
      if (!paramBoolean) {
        break label135;
      }
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = super.findViewById(2131377572);
      localView = super.findViewById(2131363369);
      if (paramInt != 0) {
        break label142;
      }
      ((View)localObject).setVisibility(0);
      label68:
      if (paramvvs == null) {
        break label176;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      paramvvs.a(this.jdField_a_of_type_JavaUtilArrayList, getContext());
      if (this.jdField_a_of_type_Vvo != null) {
        this.jdField_a_of_type_Vvo.a(this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    for (;;)
    {
      super.setBackgroundColor(super.getContext().getResources().getColor(2131166327));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout
 * JD-Core Version:    0.7.0.1
 */