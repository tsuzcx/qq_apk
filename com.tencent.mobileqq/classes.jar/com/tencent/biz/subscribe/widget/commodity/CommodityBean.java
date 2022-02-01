package com.tencent.biz.subscribe.widget.commodity;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanGood;
import aalj;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import org.json.JSONObject;

public class CommodityBean
  implements Parcelable
{
  public static final Parcelable.Creator<CommodityBean> CREATOR = new aalj();
  public String mAlias = "";
  public String mImg = "";
  public long mItemID;
  public long mPrice;
  public String mTitle = "";
  public String mUrl = "";
  
  public CommodityBean() {}
  
  public CommodityBean(Parcel paramParcel)
  {
    this.mTitle = paramParcel.readString();
    this.mItemID = paramParcel.readLong();
    this.mPrice = paramParcel.readLong();
    this.mImg = paramParcel.readString();
    this.mUrl = paramParcel.readString();
    this.mAlias = paramParcel.readString();
  }
  
  public CommodityBean(JSONObject paramJSONObject)
  {
    this.mTitle = paramJSONObject.getString("title");
    if (paramJSONObject.has("itemId")) {
      this.mItemID = Long.valueOf(checkNumString(paramJSONObject.getString("itemId"))).longValue();
    }
    this.mImg = paramJSONObject.getString("img");
    this.mPrice = Long.valueOf(checkNumString(paramJSONObject.getString("price"))).longValue();
    this.mUrl = paramJSONObject.getString("url");
    if (paramJSONObject.has("alias")) {
      this.mAlias = paramJSONObject.getString("alias");
    }
  }
  
  private String checkNumString(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "0";
    }
    return str;
  }
  
  public CertifiedAccountMeta.StYouZanGood convertToYouzanGood()
  {
    CertifiedAccountMeta.StYouZanGood localStYouZanGood = new CertifiedAccountMeta.StYouZanGood();
    localStYouZanGood.title.set(this.mTitle);
    localStYouZanGood.itemID.set(this.mItemID);
    localStYouZanGood.price.set(this.mPrice);
    localStYouZanGood.img.set(this.mImg);
    localStYouZanGood.url.set(this.mUrl);
    if (this.mAlias != null) {
      localStYouZanGood.alias.set(this.mAlias);
    }
    return localStYouZanGood;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mTitle);
    paramParcel.writeLong(this.mItemID);
    paramParcel.writeLong(this.mPrice);
    paramParcel.writeString(this.mImg);
    paramParcel.writeString(this.mUrl);
    paramParcel.writeString(this.mAlias);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.commodity.CommodityBean
 * JD-Core Version:    0.7.0.1
 */