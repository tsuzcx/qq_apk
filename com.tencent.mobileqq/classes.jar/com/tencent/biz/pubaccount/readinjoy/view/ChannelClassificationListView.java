package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.AdapterView.OnItemClickListener;
import baxn;
import com.tencent.biz.pubaccount.readinjoy.view.widget.DisableSlideHorizontalListView;
import java.util.ArrayList;
import qzk;
import qzl;
import qzn;

public class ChannelClassificationListView<T extends qzn>
  extends DisableSlideHorizontalListView
{
  private int jdField_a_of_type_Int;
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener;
  private ArrayList<T> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ChannelClassificationListView<T>.qzl jdField_a_of_type_Qzl;
  
  public ChannelClassificationListView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ChannelClassificationListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Qzl = new qzl(this, null);
    setAdapter(this.jdField_a_of_type_Qzl);
    setDividerWidth(baxn.a(getContext(), 10.0F));
    setOnScrollStateChangedListener(new qzk(this));
  }
  
  public void setData(int paramInt, ArrayList<T> paramArrayList)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Qzl.notifyDataSetChanged();
  }
  
  public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView
 * JD-Core Version:    0.7.0.1
 */