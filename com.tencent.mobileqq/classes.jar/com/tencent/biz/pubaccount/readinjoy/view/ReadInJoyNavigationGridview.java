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
import qrt;
import qrv;
import qrx;
import qry;
import qrz;

public class ReadInJoyNavigationGridview
  extends LinearLayout
{
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private List<ChannelCoverInfo> jdField_a_of_type_JavaUtilList;
  private qrt jdField_a_of_type_Qrt;
  private qry jdField_a_of_type_Qry;
  private qrz jdField_a_of_type_Qrz;
  private boolean jdField_a_of_type_Boolean;
  
  public ReadInJoyNavigationGridview(Context paramContext, qrz paramqrz)
  {
    super(paramContext);
    a(paramContext);
    this.jdField_a_of_type_Qry = new qry(this);
    this.jdField_a_of_type_Qrz = paramqrz;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131494408, this));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131305003));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131305004);
    this.jdField_a_of_type_Qrt = new qrt(paramContext);
    this.jdField_a_of_type_AndroidWidgetGridView.setPadding(this.jdField_a_of_type_AndroidWidgetGridView.getPaddingLeft(), ImmersiveUtils.getStatusBarHeight(paramContext), this.jdField_a_of_type_AndroidWidgetGridView.getPaddingRight(), this.jdField_a_of_type_AndroidWidgetGridView.getPaddingBottom());
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Qrt);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new qrx(this));
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_Qrt.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Qrt.getCount();
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
    this.jdField_a_of_type_Qry.removeMessages(1);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setChannelButtonListener(qrv paramqrv)
  {
    this.jdField_a_of_type_Qrt.a(paramqrv);
  }
  
  public void setNaviBarAdapterDataSet(List<ChannelCoverInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Qry.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview
 * JD-Core Version:    0.7.0.1
 */