package com.tencent.biz;

import android.content.Context;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class PoiMapActivity$PoiTab
{
  final int jdField_a_of_type_Int = 1;
  public TextView a;
  public PoiMapActivity.PoiItemAdapter a;
  public PoiMapActivity.TabView a;
  public XListView a;
  final int b;
  final int c = 3;
  final int d = 4;
  public int e;
  public int f;
  public int g;
  
  public PoiMapActivity$PoiTab(PoiMapActivity paramPoiMapActivity, Context paramContext, String paramString, int paramInt)
  {
    this.jdField_b_of_type_Int = 2;
    this.e = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((PoiMapActivity)paramContext).findViewById(2131372907));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramPoiMapActivity.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView = new PoiMapActivity.TabView(paramPoiMapActivity, paramContext, paramString, paramInt);
    this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(paramContext);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter = new PoiMapActivity.PoiItemAdapter(paramPoiMapActivity);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new PoiMapActivity.PoiTab.1(this, paramPoiMapActivity));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new PoiMapActivity.PoiTab.2(this, paramPoiMapActivity));
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131694940));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131694938));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131693575));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPoiMapActivity.c)
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(paramInt, paramBoolean);
      return;
    }
    if ((this.e == 0) && (paramInt > 0) && (!this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPoiMapActivity.g)) {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.g = false;
    }
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(paramInt, paramBoolean);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(paramString);
  }
  
  public void a(ArrayList<PoiMapActivity.POI> paramArrayList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      a(3);
      return;
    }
    if (paramArrayList == null)
    {
      a(1);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(paramArrayList, paramBoolean1, paramInt);
    if (this.jdField_a_of_type_ComTencentBizPoiMapActivity.l == this.e)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      a(4);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.getCount() > 0)
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
        a(4);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
    }
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView.setSelect(paramBoolean);
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("POI list update isfirst = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("PoiMapActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.f != this.jdField_a_of_type_ComTencentBizPoiMapActivity.h) || (this.g != this.jdField_a_of_type_ComTencentBizPoiMapActivity.i) || (!paramBoolean))
    {
      if (paramBoolean)
      {
        a(2);
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_JavaUtilArrayList.clear();
        localObject = this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter;
        ((PoiMapActivity.PoiItemAdapter)localObject).jdField_b_of_type_Int = 0;
        ((PoiMapActivity.PoiItemAdapter)localObject).jdField_b_of_type_Boolean = false;
        ((PoiMapActivity.PoiItemAdapter)localObject).notifyDataSetChanged();
      }
      localObject = this.jdField_a_of_type_ComTencentBizPoiMapActivity;
      ((PoiMapActivity)localObject).a(((PoiMapActivity)localObject).h, this.jdField_a_of_type_ComTencentBizPoiMapActivity.i, "", this.jdField_a_of_type_ComTencentBizPoiMapActivity.b[this.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView.jdField_a_of_type_Int], this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_b_of_type_Int, 20);
      this.f = this.jdField_a_of_type_ComTencentBizPoiMapActivity.h;
      this.g = this.jdField_a_of_type_ComTencentBizPoiMapActivity.i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.PoiTab
 * JD-Core Version:    0.7.0.1
 */