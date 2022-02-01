package com.tencent.biz;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;

public class PoiMapActivity$PoiItemAdapter
  extends BaseAdapter
{
  public int a;
  protected TextView a;
  public ArrayList<PoiMapActivity.POI> a;
  public boolean a;
  public int b;
  public boolean b;
  
  public PoiMapActivity$PoiItemAdapter(PoiMapActivity paramPoiMapActivity)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public PoiMapActivity.POI a(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_Boolean) {
      i = paramInt + 1;
    }
    if ((i >= this.jdField_a_of_type_JavaUtilArrayList.size()) || (i < 0)) {
      return null;
    }
    return (PoiMapActivity.POI)this.jdField_a_of_type_JavaUtilArrayList.get(i);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {}
    PoiMapActivity.POI localPOI;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt == this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Int = paramInt;
        notifyDataSetChanged();
      } while ((paramInt == -1) || (!paramBoolean));
      localPOI = a(paramInt);
    } while (localPOI == null);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.l = localPOI.a;
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.m = localPOI.jdField_b_of_type_JavaLangString;
    PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity, localPOI.f);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_b_of_type_JavaLangString = localPOI.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.j = localPOI.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.k = localPOI.jdField_c_of_type_Int;
    PoiMapActivity.g(this.jdField_a_of_type_ComTencentBizPoiMapActivity).b();
    PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity).animateCamera(CameraUpdateFactory.newLatLng(new LatLng(localPOI.jdField_b_of_type_Int / 1000000.0D, localPOI.jdField_c_of_type_Int / 1000000.0D)));
  }
  
  public void a(String paramString)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void a(ArrayList<PoiMapActivity.POI> paramArrayList, boolean paramBoolean, int paramInt)
  {
    if (paramInt == this.jdField_b_of_type_Int)
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_b_of_type_Int += 1;
      notifyDataSetChanged();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    int j = 1;
    int i = 1;
    if (this.jdField_a_of_type_Boolean)
    {
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (this.jdField_b_of_type_Boolean) {}
      for (;;)
      {
        return i + (j - 1);
        i = 0;
      }
    }
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (this.jdField_b_of_type_Boolean) {}
    for (i = j;; i = 0) {
      return i + k;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      localObject1 = new PoiMapActivity.PoiItemViewHolder(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPoiMapActivity).inflate(2131560089, null);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_b_of_type_AndroidViewView = paramView.findViewById(2131377935);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377934));
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372127));
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362229));
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_c_of_type_AndroidViewView = paramView.findViewById(2131377721);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_d_of_type_AndroidViewView = paramView.findViewById(2131371874);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365723);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377933));
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380071));
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375216));
      paramView.setTag(localObject1);
      if ((paramInt != this.jdField_a_of_type_JavaUtilArrayList.size()) && ((!this.jdField_a_of_type_Boolean) || (paramInt != this.jdField_a_of_type_JavaUtilArrayList.size() - 1))) {
        break label247;
      }
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_d_of_type_AndroidViewView.setVisibility(0);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (Object localObject1 = paramView;; localObject1 = null)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject1 = (PoiMapActivity.PoiItemViewHolder)paramView.getTag();
      break;
      label247:
      localObject2 = a(paramInt);
      if ((paramInt == 0) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetTextView = ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView;
      }
      if (localObject2 != null) {
        break label285;
      }
    }
    label285:
    ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_d_of_type_AndroidViewView.setVisibility(8);
    ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_b_of_type_AndroidViewView.setVisibility(8);
    ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
    ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
    ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(this.jdField_a_of_type_ComTencentBizPoiMapActivity.d);
    ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((PoiMapActivity.POI)localObject2).a);
    ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((PoiMapActivity.POI)localObject2).jdField_b_of_type_JavaLangString);
    Object localObject2 = ((PoiMapActivity.POI)localObject2).a + ((PoiMapActivity.POI)localObject2).jdField_b_of_type_JavaLangString;
    if (paramInt == this.jdField_a_of_type_Int)
    {
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.g);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.g);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    for (localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131694953);; localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131694954))
    {
      paramView.setContentDescription((CharSequence)localObject1);
      localObject1 = paramView;
      break;
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_b_of_type_Int);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_Int);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_c_of_type_AndroidViewView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.PoiItemAdapter
 * JD-Core Version:    0.7.0.1
 */