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
    String str5;
    Object localObject1;
    Object localObject3;
    String str2;
    Object localObject4;
    Object localObject2;
    String str1;
    String str3;
    String str4;
    int m;
    long l;
    int k;
    switch (paramVideoInfoRsp.video_src_type.get())
    {
    default: 
      str5 = null;
      localObject1 = null;
      localObject3 = null;
      str2 = null;
      localObject4 = null;
      localObject2 = null;
      str1 = null;
      str3 = null;
      str4 = null;
      m = 1;
      l = 0L;
      paramVideoInfoRsp = null;
      k = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = m;
      this.jdField_a_of_type_JavaLangString = ((String)localObject4);
      this.jdField_b_of_type_JavaLangString = str5;
      this.jdField_c_of_type_JavaLangString = str4;
      this.jdField_d_of_type_JavaLangString = str3;
      this.e = str2;
      this.f = str1;
      this.g = ((String)localObject3);
      this.h = ((String)localObject2);
      this.i = ((String)localObject1);
      this.jdField_b_of_type_Int = k;
      this.j = paramVideoInfoRsp;
      this.jdField_a_of_type_Long = l;
      this.jdField_d_of_type_Int = 0;
      return;
      m = 0;
      localObject1 = (WTogetherCommon.QQFileInfo)paramVideoInfoRsp.qqfile_info.get();
      localObject4 = paramVideoInfoRsp.title.get();
      str5 = ((WTogetherCommon.QQFileInfo)localObject1).file_uuid.get();
      str4 = ((WTogetherCommon.QQFileInfo)localObject1).file_id.get();
      paramVideoInfoRsp = null;
      k = 0;
      localObject1 = null;
      localObject2 = null;
      localObject3 = null;
      str1 = null;
      str2 = null;
      str3 = null;
      l = 0L;
      continue;
      localObject1 = (WTogetherCommon.DirectUrlInfo)paramVideoInfoRsp.direct_url_info.get();
      localObject4 = paramVideoInfoRsp.title.get();
      str3 = ((WTogetherCommon.DirectUrlInfo)localObject1).url.get();
      str2 = ((WTogetherCommon.DirectUrlInfo)localObject1).cookie.get();
      l = ((WTogetherCommon.DirectUrlInfo)localObject1).media_format.get();
      str5 = null;
      localObject2 = null;
      str1 = null;
      k = 0;
      localObject3 = null;
      paramVideoInfoRsp = null;
      localObject1 = null;
      m = 1;
      str4 = null;
      continue;
      localObject2 = paramVideoInfoRsp.title.get();
      localObject3 = (WTogetherCommon.OnlineResourceInfo)paramVideoInfoRsp.online_resource_info.get();
      paramVideoInfoRsp = ((WTogetherCommon.OnlineResourceInfo)localObject3).platform_id.get();
      localObject1 = ((WTogetherCommon.OnlineResourceInfo)localObject3).sdtform_id.get();
      k = ((WTogetherCommon.OnlineResourceInfo)localObject3).is_pay.get();
      localObject3 = (WTogetherCommon.PlayInfo)((WTogetherCommon.OnlineResourceInfo)localObject3).play_info.get();
      m = ((WTogetherCommon.PlayInfo)localObject3).player_mode.get();
      int n = ((WTogetherCommon.PlayInfo)localObject3).player_params.type.get();
      localObject3 = (WTogetherCommon.PlayerParams)((WTogetherCommon.PlayInfo)localObject3).player_params.get();
      Object localObject5;
      if (n == 0)
      {
        if (m == 0) {}
        for (m = 2;; m = 1)
        {
          localObject3 = (WTogetherCommon.UrlParams)((WTogetherCommon.PlayerParams)localObject3).url_params.get();
          str3 = ((WTogetherCommon.UrlParams)localObject3).url.get();
          l = ((WTogetherCommon.UrlParams)localObject3).media_format.get();
          str4 = null;
          localObject3 = paramVideoInfoRsp;
          str1 = null;
          localObject4 = localObject2;
          str5 = null;
          paramVideoInfoRsp = null;
          localObject5 = null;
          str2 = null;
          localObject2 = localObject3;
          localObject3 = localObject5;
          break;
        }
      }
      if (n == 1)
      {
        localObject3 = (WTogetherCommon.TxvlivePlayerParams)((WTogetherCommon.PlayerParams)localObject3).txvlive_player_params.get();
        str1 = ((WTogetherCommon.TxvlivePlayerParams)localObject3).vid.get();
        localObject3 = ((WTogetherCommon.TxvlivePlayerParams)localObject3).livepid.get();
        str3 = null;
        str4 = null;
        m = 4;
        localObject5 = null;
        str2 = null;
        localObject4 = localObject2;
        str5 = null;
        localObject2 = paramVideoInfoRsp;
        l = 0L;
        paramVideoInfoRsp = (WTogetherCommon.VideoInfoRsp)localObject3;
        localObject3 = localObject5;
      }
      else if (n == 2)
      {
        localObject3 = (WTogetherCommon.TxPlayerParams)((WTogetherCommon.PlayerParams)localObject3).tx_player_params.get();
        str1 = ((WTogetherCommon.TxPlayerParams)localObject3).vid.get();
        localObject3 = ((WTogetherCommon.TxPlayerParams)localObject3).cid.get();
        str3 = null;
        str4 = null;
        m = 3;
        str2 = null;
        localObject4 = localObject2;
        str5 = null;
        l = 0L;
        localObject5 = null;
        localObject2 = paramVideoInfoRsp;
        paramVideoInfoRsp = localObject5;
      }
      else
      {
        localObject3 = (WTogetherCommon.TxPlayerParams)((WTogetherCommon.PlayerParams)localObject3).tx_player_params.get();
        str1 = ((WTogetherCommon.TxPlayerParams)localObject3).vid.get();
        localObject3 = ((WTogetherCommon.TxPlayerParams)localObject3).cid.get();
        str3 = null;
        str4 = null;
        m = 3;
        str2 = null;
        localObject4 = localObject2;
        str5 = null;
        l = 0L;
        localObject5 = null;
        localObject2 = paramVideoInfoRsp;
        paramVideoInfoRsp = localObject5;
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      if (this.jdField_d_of_type_Int != 0) {
        return this.jdField_d_of_type_Int;
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
    boolean bool = true;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      bool = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool;
          } while (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
          return false;
        } while (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString));
        return false;
      } while ((!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.h)) && (!TextUtils.isEmpty(this.i)));
      return false;
    } while ((!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.h)) && (!TextUtils.isEmpty(this.i)) && (!TextUtils.isEmpty(this.j)));
    return false;
  }
  
  public boolean a(WTogetherCommon.VideoInfoRsp paramVideoInfoRsp)
  {
    boolean bool = false;
    if (paramVideoInfoRsp != null) {
      bool = equals(new WTFileInfo(paramVideoInfoRsp));
    }
    return bool;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return this.jdField_b_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Int == 3) {
      return this.f;
    }
    if (this.jdField_a_of_type_Int == 4) {
      return this.f + "_" + this.j;
    }
    return "0";
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return this.jdField_a_of_type_Int + "_" + this.jdField_b_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Int == 3) {
      return this.jdField_a_of_type_Int + "_" + this.f;
    }
    if (this.jdField_a_of_type_Int == 4) {
      return this.jdField_a_of_type_Int + "_" + this.f + "_" + this.j;
    }
    return this.jdField_a_of_type_Int + "_" + this.jdField_d_of_type_JavaLangString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof WTFileInfo))
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
    return "WTFileInfo{videoSrcType: " + this.jdField_a_of_type_Int + ", uuid: " + this.jdField_b_of_type_JavaLangString + ", fileId: " + this.jdField_c_of_type_JavaLangString + ", fileName: " + this.jdField_a_of_type_JavaLangString + ", url: " + this.jdField_d_of_type_JavaLangString + ", cookie: " + this.e + ", vid: " + this.f + ", cid: " + this.g + ", platForm: " + this.h + ", sdtForm: " + this.i + ", isPay: " + this.jdField_b_of_type_Int + ", livePid: " + this.j + ", mediaFormat: " + this.jdField_a_of_type_Long + ", seq: " + this.jdField_c_of_type_Int + ", videoSrcTypeExtra: " + this.jdField_d_of_type_Int + "}";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.data.WTFileInfo
 * JD-Core Version:    0.7.0.1
 */