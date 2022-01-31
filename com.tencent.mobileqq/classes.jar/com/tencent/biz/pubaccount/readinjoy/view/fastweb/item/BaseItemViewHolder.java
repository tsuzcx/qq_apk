package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;

public abstract class BaseItemViewHolder
{
  public View a;
  public BaseData a;
  public OnItemClickListener a;
  
  public BaseItemViewHolder(View paramView, BaseData paramBaseData)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = paramBaseData;
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = paramBaseData2;
    b(paramBaseData1, paramBaseData2, paramBoolean);
  }
  
  public void a(OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemOnItemClickListener = paramOnItemClickListener;
  }
  
  public void a(String paramString, Bitmap paramBitmap) {}
  
  public abstract void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.BaseItemViewHolder
 * JD-Core Version:    0.7.0.1
 */