package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import tap;
import tar;
import tat;
import tau;
import tav;

public class ReadInJoyNavigationGridview
  extends LinearLayout
{
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private List<ChannelCoverInfo> jdField_a_of_type_JavaUtilList;
  private tap jdField_a_of_type_Tap;
  private tau jdField_a_of_type_Tau;
  private tav jdField_a_of_type_Tav;
  private boolean jdField_a_of_type_Boolean;
  
  public ReadInJoyNavigationGridview(Context paramContext, tav paramtav)
  {
    super(paramContext);
    a(paramContext);
    this.jdField_a_of_type_Tau = new tau(this);
    this.jdField_a_of_type_Tav = paramtav;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131560284, this));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371825));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371826);
    this.jdField_a_of_type_Tap = new tap(paramContext);
    this.jdField_a_of_type_AndroidWidgetGridView.setPadding(this.jdField_a_of_type_AndroidWidgetGridView.getPaddingLeft(), ImmersiveUtils.getStatusBarHeight(paramContext), this.jdField_a_of_type_AndroidWidgetGridView.getPaddingRight(), this.jdField_a_of_type_AndroidWidgetGridView.getPaddingBottom());
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Tap);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new tat(this));
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_Tap.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Tap.getCount();
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetGridView;
  }
  
  public List<ChannelCoverInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_Tau.removeMessages(1);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setChannelButtonListener(tar paramtar)
  {
    this.jdField_a_of_type_Tap.a(paramtar);
  }
  
  public void setNaviBarAdapterDataSet(List<ChannelCoverInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Tau.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview
 * JD-Core Version:    0.7.0.1
 */