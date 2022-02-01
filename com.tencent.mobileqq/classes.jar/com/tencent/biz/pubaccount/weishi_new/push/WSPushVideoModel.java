package com.tencent.biz.pubaccount.weishi_new.push;

import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import org.json.JSONObject;

public class WSPushVideoModel
  implements Parcelable
{
  public static final Parcelable.Creator<WSPushVideoModel> CREATOR = new WSPushVideoModel.1();
  public String a;
  public String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public WSPushVideoModel() {}
  
  protected WSPushVideoModel(Parcel paramParcel)
  {
    this.c = paramParcel.readString();
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readInt();
  }
  
  protected static WSPushVideoModel a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      WSPushVideoModel localWSPushVideoModel = new WSPushVideoModel();
      localWSPushVideoModel.c = paramJSONObject.optString("video_id");
      localWSPushVideoModel.a = paramJSONObject.optString("video_url");
      localWSPushVideoModel.b = paramJSONObject.optString("video_cover_url");
      localWSPushVideoModel.e = paramJSONObject.optString("person_avatar");
      localWSPushVideoModel.d = paramJSONObject.optString("person_id");
      localWSPushVideoModel.f = paramJSONObject.optString("person_nick");
      localWSPushVideoModel.i = paramJSONObject.optInt("duration");
      localWSPushVideoModel.h = paramJSONObject.optInt("video_width");
      localWSPushVideoModel.g = paramJSONObject.optInt("video_height");
      localWSPushVideoModel.j = paramJSONObject.optInt("card_type");
      return localWSPushVideoModel;
    }
    return null;
  }
  
  public stSimpleMetaFeed a(String paramString)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = new stSimpleMetaFeed();
    localstSimpleMetaFeed.id = paramString;
    localstSimpleMetaFeed.video_url = this.a;
    paramString = new ArrayList();
    stMetaUgcImage localstMetaUgcImage1 = new stMetaUgcImage();
    localstMetaUgcImage1.url = this.b;
    stMetaUgcImage localstMetaUgcImage2 = new stMetaUgcImage();
    localstMetaUgcImage2.url = this.b;
    paramString.add(localstMetaUgcImage1);
    paramString.add(localstMetaUgcImage2);
    localstSimpleMetaFeed.images = paramString;
    paramString = new stMetaUgcVideoSeg();
    paramString.file_id = this.c;
    paramString.duration = this.i;
    paramString.height = this.g;
    paramString.width = this.h;
    localstSimpleMetaFeed.video = paramString;
    localstSimpleMetaFeed.video_type = 0;
    localstSimpleMetaFeed.videoPoolType = 0;
    paramString = new stFloatingLayerCardStyle();
    paramString.cardType = this.j;
    paramString.commentHidden = false;
    paramString.dingHidden = false;
    paramString.shareHidden = false;
    localstSimpleMetaFeed.floatingLayerCardStyle = paramString;
    localstSimpleMetaFeed.traceId = "";
    paramString = new stSimpleMetaPerson();
    paramString.avatar = this.e;
    paramString.id = this.d;
    paramString.medal = 0;
    paramString.nick = this.f;
    localstSimpleMetaFeed.poster = paramString;
    return localstSimpleMetaFeed;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.WSPushVideoModel
 * JD-Core Version:    0.7.0.1
 */