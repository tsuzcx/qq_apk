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
import vjb;

public class WSPushVideoModel
  implements Parcelable
{
  public static final Parcelable.Creator<WSPushVideoModel> CREATOR = new vjb();
  private int a;
  public String a;
  private int b;
  public String b;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  private String f;
  
  public WSPushVideoModel() {}
  
  public WSPushVideoModel(Parcel paramParcel)
  {
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
  }
  
  protected static WSPushVideoModel a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      WSPushVideoModel localWSPushVideoModel = new WSPushVideoModel();
      localWSPushVideoModel.jdField_c_of_type_JavaLangString = paramJSONObject.optString("video_id");
      localWSPushVideoModel.jdField_a_of_type_JavaLangString = paramJSONObject.optString("video_url");
      localWSPushVideoModel.jdField_b_of_type_JavaLangString = paramJSONObject.optString("video_cover_url");
      localWSPushVideoModel.e = paramJSONObject.optString("person_avatar");
      localWSPushVideoModel.jdField_d_of_type_JavaLangString = paramJSONObject.optString("person_id");
      localWSPushVideoModel.f = paramJSONObject.optString("person_nick");
      localWSPushVideoModel.jdField_c_of_type_Int = paramJSONObject.optInt("duration");
      localWSPushVideoModel.jdField_b_of_type_Int = paramJSONObject.optInt("video_width");
      localWSPushVideoModel.jdField_a_of_type_Int = paramJSONObject.optInt("video_height");
      localWSPushVideoModel.jdField_d_of_type_Int = paramJSONObject.optInt("card_type");
      return localWSPushVideoModel;
    }
    return null;
  }
  
  public stSimpleMetaFeed a(String paramString)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = new stSimpleMetaFeed();
    localstSimpleMetaFeed.id = paramString;
    localstSimpleMetaFeed.video_url = this.jdField_a_of_type_JavaLangString;
    paramString = new ArrayList();
    stMetaUgcImage localstMetaUgcImage1 = new stMetaUgcImage();
    localstMetaUgcImage1.url = this.jdField_b_of_type_JavaLangString;
    stMetaUgcImage localstMetaUgcImage2 = new stMetaUgcImage();
    localstMetaUgcImage2.url = this.jdField_b_of_type_JavaLangString;
    paramString.add(localstMetaUgcImage1);
    paramString.add(localstMetaUgcImage2);
    localstSimpleMetaFeed.images = paramString;
    paramString = new stMetaUgcVideoSeg();
    paramString.file_id = this.jdField_c_of_type_JavaLangString;
    paramString.duration = this.jdField_c_of_type_Int;
    paramString.height = this.jdField_a_of_type_Int;
    paramString.width = this.jdField_b_of_type_Int;
    localstSimpleMetaFeed.video = paramString;
    localstSimpleMetaFeed.video_type = 0;
    localstSimpleMetaFeed.videoPoolType = 0;
    paramString = new stFloatingLayerCardStyle();
    paramString.cardType = this.jdField_d_of_type_Int;
    paramString.commentHidden = false;
    paramString.dingHidden = false;
    paramString.shareHidden = false;
    localstSimpleMetaFeed.floatingLayerCardStyle = paramString;
    localstSimpleMetaFeed.traceId = "";
    paramString = new stSimpleMetaPerson();
    paramString.avatar = this.e;
    paramString.id = this.jdField_d_of_type_JavaLangString;
    paramString.medal = 0;
    paramString.nick = this.f;
    localstSimpleMetaFeed.poster = paramString;
    localstSimpleMetaFeed.isLoop = true;
    return localstSimpleMetaFeed;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.WSPushVideoModel
 * JD-Core Version:    0.7.0.1
 */