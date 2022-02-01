package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import tgf;
import tjf;

public class BaseData
  implements Parcelable
{
  public static final Parcelable.Creator<BaseData> CREATOR = new tgf();
  public final float a;
  public FastWebArticleInfo a;
  public float b;
  public ArticleInfo b;
  public boolean d;
  public final int r;
  public int s = -1;
  public int t = -1;
  
  public BaseData(int paramInt)
  {
    this.jdField_b_of_type_Float = -1000.0F;
    this.r = paramInt;
    this.jdField_a_of_type_Float = a(this);
  }
  
  public BaseData(Parcel paramParcel)
  {
    this.jdField_b_of_type_Float = -1000.0F;
    this.r = paramParcel.readInt();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)paramParcel.readParcelable(ArticleInfo.class.getClassLoader()));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = ((FastWebArticleInfo)paramParcel.readParcelable(FastWebArticleInfo.class.getClassLoader()));
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.s = paramParcel.readInt();
    this.t = paramParcel.readInt();
  }
  
  public static float a(BaseData paramBaseData)
  {
    switch (paramBaseData.r)
    {
    }
    do
    {
      return -1000.0F;
      return 1.0F;
      return 1.5F;
      return 2.0F;
      return 3.0F;
      return paramBaseData.jdField_b_of_type_Float;
      return tjf.a(paramBaseData, false);
      return tjf.a(paramBaseData, true);
      return 9.0F;
      return 10.0F;
      return 11.0F;
    } while (!(paramBaseData instanceof ProteusItemData));
    return paramBaseData.jdField_b_of_type_Float;
  }
  
  public boolean b(BaseData paramBaseData)
  {
    if (paramBaseData == null) {}
    while (a(this) - a(paramBaseData) < 0.0F) {
      return true;
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.r);
    paramParcel.writeParcelable(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 0);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, 0);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeInt(this.s);
    paramParcel.writeInt(this.t);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData
 * JD-Core Version:    0.7.0.1
 */