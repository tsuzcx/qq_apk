package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.AdapterView.OnItemClickListener;
import azvv;
import com.tencent.biz.pubaccount.readinjoy.view.widget.DisableSlideHorizontalListView;
import java.util.ArrayList;
import qne;
import qnf;
import qnh;

public class ChannelClassificationListView<T extends qnh>
  extends DisableSlideHorizontalListView
{
  private int jdField_a_of_type_Int;
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener;
  private ArrayList<T> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ChannelClassificationListView<T>.qnf jdField_a_of_type_Qnf;
  
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
    this.jdField_a_of_type_Qnf = new qnf(this, null);
    setAdapter(this.jdField_a_of_type_Qnf);
    setDividerWidth(azvv.a(getContext(), 10.0F));
    setOnScrollStateChangedListener(new qne(this));
  }
  
  public void setData(int paramInt, ArrayList<T> paramArrayList)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Qnf.notifyDataSetChanged();
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