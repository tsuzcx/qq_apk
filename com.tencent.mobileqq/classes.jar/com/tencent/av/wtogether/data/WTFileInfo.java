package com.tencent.av.wtogether.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_av_together.common.WTogetherCommon.DirectUrlInfo;
import trpc.qq_av_together.common.WTogetherCommon.OnlineResourceInfo;
import trpc.qq_av_together.common.WTogetherCommon.PlayInfo;
import trpc.qq_av_together.common.WTogetherCommon.PlayerParams;
import trpc.qq_av_together.common.WTogetherCommon.QQFileInfo;
import trpc.qq_av_together.common.WTogetherCommon.TxPlayerParams;
import trpc.qq_av_together.common.WTogetherCommon.TxvlivePlayerParams;
import trpc.qq_av_together.common.WTogetherCommon.UrlParams;
import trpc.qq_av_together.common.WTogetherCommon.VideoInfoRsp;

public class WTFileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WTFileInfo> CREATOR = new WTFileInfo.1();
  public final int a;
  public final long a;
  public final String a;
  public final int b;
  public final String b;
  public int c;
  public final String c;
  public int d;
  public final String d;
  public final String e;
  public final String f;
  public final String g;
  public final String h;
  public final String i;
  public final String j;
  
  protected WTFileInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.j = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
  }
  
  public WTFileInfo(WTogetherCommon.VideoInfoRsp paramVideoInfoRsp)
  {
    int m = paramVideoInfoRsp.video_src_type.get();
    int k = 3;
    String str = null;
    Object localObject1;
    Object localObject2;
    Object localObject6;
    Object localObject7;
    long l;
    Object localObject8;
    Object localObject5;
    Object localObject3;
    Object localObject4;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          localObject1 = null;
          localObject2 = localObject1;
          localObject6 = localObject2;
          localObject7 = localObject6;
          l = 0L;
          k = 1;
          m = 0;
        }
        int i1;
        for (;;)
        {
          localObject8 = null;
          localObject5 = null;
          paramVideoInfoRsp = null;
          localObject3 = null;
          localObject4 = localObject3;
          break label519;
          localObject2 = paramVideoInfoRsp.title.get();
          paramVideoInfoRsp = (WTogetherCommon.OnlineResourceInfo)paramVideoInfoRsp.online_resource_info.get();
          localObject6 = paramVideoInfoRsp.platform_id.get();
          localObject7 = paramVideoInfoRsp.sdtform_id.get();
          m = paramVideoInfoRsp.is_pay.get();
          paramVideoInfoRsp = (WTogetherCommon.PlayInfo)paramVideoInfoRsp.play_info.get();
          int n = paramVideoInfoRsp.player_mode.get();
          i1 = paramVideoInfoRsp.player_params.type.get();
          paramVideoInfoRsp = (WTogetherCommon.PlayerParams)paramVideoInfoRsp.player_params.get();
          if (i1 != 0) {
            break;
          }
          if (n == 0) {
            k = 2;
          } else {
            k = 1;
          }
          localObject1 = (WTogetherCommon.UrlParams)paramVideoInfoRsp.url_params.get();
          paramVideoInfoRsp = ((WTogetherCommon.UrlParams)localObject1).url.get();
          l = ((WTogetherCommon.UrlParams)localObject1).media_format.get();
          localObject1 = localObject2;
          localObject2 = paramVideoInfoRsp;
        }
        if (i1 == 1)
        {
          k = 4;
          paramVideoInfoRsp = (WTogetherCommon.TxvlivePlayerParams)paramVideoInfoRsp.txvlive_player_params.get();
          localObject4 = paramVideoInfoRsp.vid.get();
          localObject8 = paramVideoInfoRsp.livepid.get();
        }
        for (localObject5 = null;; localObject5 = localObject1)
        {
          l = 0L;
          Object localObject9 = null;
          paramVideoInfoRsp = null;
          localObject3 = null;
          localObject1 = localObject2;
          localObject2 = localObject9;
          break;
          if (i1 == 2)
          {
            localObject1 = (WTogetherCommon.TxPlayerParams)paramVideoInfoRsp.tx_player_params.get();
            paramVideoInfoRsp = ((WTogetherCommon.TxPlayerParams)localObject1).vid.get();
            localObject1 = ((WTogetherCommon.TxPlayerParams)localObject1).cid.get();
          }
          else
          {
            localObject1 = (WTogetherCommon.TxPlayerParams)paramVideoInfoRsp.tx_player_params.get();
            paramVideoInfoRsp = ((WTogetherCommon.TxPlayerParams)localObject1).vid.get();
            localObject1 = ((WTogetherCommon.TxPlayerParams)localObject1).cid.get();
          }
          localObject8 = null;
          localObject4 = paramVideoInfoRsp;
        }
      }
      localObject4 = (WTogetherCommon.DirectUrlInfo)paramVideoInfoRsp.direct_url_info.get();
      localObject1 = paramVideoInfoRsp.title.get();
      localObject2 = ((WTogetherCommon.DirectUrlInfo)localObject4).url.get();
      localObject3 = ((WTogetherCommon.DirectUrlInfo)localObject4).cookie.get();
      l = ((WTogetherCommon.DirectUrlInfo)localObject4).media_format.get();
      paramVideoInfoRsp = null;
      localObject6 = paramVideoInfoRsp;
      localObject7 = localObject6;
      localObject8 = localObject7;
      k = 1;
      m = 0;
      localObject4 = localObject8;
      localObject5 = localObject4;
    }
    else
    {
      localObject2 = (WTogetherCommon.QQFileInfo)paramVideoInfoRsp.qqfile_info.get();
      localObject1 = paramVideoInfoRsp.title.get();
      str = ((WTogetherCommon.QQFileInfo)localObject2).file_uuid.get();
      paramVideoInfoRsp = ((WTogetherCommon.QQFileInfo)localObject2).file_id.get();
      localObject2 = null;
      localObject5 = localObject2;
      localObject6 = localObject5;
      localObject7 = localObject6;
      localObject8 = localObject7;
      l = 0L;
      m = 0;
      localObject3 = localObject8;
      localObject4 = localObject3;
      k = 0;
    }
    label519:
    this.jdField_a_of_type_Int = k;
    this.jdField_a_of_type_JavaLangString = ((String)localObject1);
    this.jdField_b_of_type_JavaLangString = str;
    this.jdField_c_of_type_JavaLangString = paramVideoInfoRsp;
    this.jdField_d_of_type_JavaLangString = ((String)localObject2);
    this.e = ((String)localObject3);
    this.f = ((String)localObject4);
    this.g = localObject5;
    this.h = ((String)localObject6);
    this.i = ((String)localObject7);
    this.jdField_b_of_type_Int = m;
    this.j = ((String)localObject8);
    this.jdField_a_of_type_Long = l;
    this.jdField_d_of_type_Int = 0;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      int k = this.jdField_d_of_type_Int;
      if (k != 0) {
        return k;
      }
      return 1;
    }
    return 2;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    int k = this.jdField_a_of_type_Int;
    boolean bool2 = false;
    boolean bool1;
    if (k != 0)
    {
      if ((k != 1) && (k != 2))
      {
        if (k != 3)
        {
          if (k != 4) {
            return false;
          }
          bool1 = bool2;
          if (TextUtils.isEmpty(this.f)) {
            return bool1;
          }
          bool1 = bool2;
          if (TextUtils.isEmpty(this.h)) {
            return bool1;
          }
          bool1 = bool2;
          if (TextUtils.isEmpty(this.i)) {
            return bool1;
          }
          bool1 = bool2;
          if (TextUtils.isEmpty(this.j)) {
            return bool1;
          }
        }
        for (;;)
        {
          return true;
          bool1 = bool2;
          if (TextUtils.isEmpty(this.f)) {
            break;
          }
          bool1 = bool2;
          if (TextUtils.isEmpty(this.h)) {
            break;
          }
          bool1 = bool2;
          if (TextUtils.isEmpty(this.i)) {
            break;
          }
        }
      }
      bool1 = TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString);
    }
    else
    {
      bool1 = TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString);
    }
    bool1 ^= true;
    return bool1;
  }
  
  public boolean a(WTogetherCommon.VideoInfoRsp paramVideoInfoRsp)
  {
    if (paramVideoInfoRsp != null) {
      return equals(new WTFileInfo(paramVideoInfoRsp));
    }
    return false;
  }
  
  public String b()
  {
    int k = this.jdField_a_of_type_Int;
    if (k == 0) {
      return this.jdField_b_of_type_JavaLangString;
    }
    if (k == 3) {
      return this.f;
    }
    if (k == 4)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.f);
      localStringBuilder.append("_");
      localStringBuilder.append(this.j);
      return localStringBuilder.toString();
    }
    return "0";
  }
  
  public String c()
  {
    int k = this.jdField_a_of_type_Int;
    if (k == 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("_");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      return localStringBuilder.toString();
    }
    if (k == 3)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("_");
      localStringBuilder.append(this.f);
      return localStringBuilder.toString();
    }
    if (k == 4)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("_");
      localStringBuilder.append(this.f);
      localStringBuilder.append("_");
      localStringBuilder.append(this.j);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("_");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof WTFileInfo;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (WTFileInfo)paramObject;
      bool1 = bool2;
      if (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int)
      {
        bool1 = bool2;
        if (TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString))
        {
          bool1 = bool2;
          if (TextUtils.equals(this.jdField_c_of_type_JavaLangString, paramObject.jdField_c_of_type_JavaLangString))
          {
            bool1 = bool2;
            if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString))
            {
              bool1 = bool2;
              if (TextUtils.equals(this.jdField_d_of_type_JavaLangString, paramObject.jdField_d_of_type_JavaLangString))
              {
                bool1 = bool2;
                if (TextUtils.equals(this.e, paramObject.e))
                {
                  bool1 = bool2;
                  if (TextUtils.equals(this.f, paramObject.f))
                  {
                    bool1 = bool2;
                    if (TextUtils.equals(this.g, paramObject.g))
                    {
                      bool1 = bool2;
                      if (TextUtils.equals(this.h, paramObject.h))
                      {
                        bool1 = bool2;
                        if (TextUtils.equals(this.i, paramObject.i))
                        {
                          bool1 = bool2;
                          if (this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int)
                          {
                            bool1 = bool2;
                            if (TextUtils.equals(this.j, paramObject.j))
                            {
                              bool1 = bool2;
                              if (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long) {
                                bool1 = true;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WTFileInfo{videoSrcType: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", uuid: ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", fileId: ");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(", fileName: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", url: ");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(", cookie: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", vid: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", cid: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", platForm: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", sdtForm: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", isPay: ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", livePid: ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", mediaFormat: ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", seq: ");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", videoSrcTypeExtra: ");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.j);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.data.WTFileInfo
 * JD-Core Version:    0.7.0.1
 */