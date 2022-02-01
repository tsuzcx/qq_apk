package com.tencent.av.wtogether.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import myq;
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
  public static final Parcelable.Creator<WTFileInfo> CREATOR = new myq();
  public final int a;
  public final long a;
  public final String a;
  public int b;
  public final String b;
  public int c;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  public final String g;
  public final String h;
  public final String i;
  
  public WTFileInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
  }
  
  public WTFileInfo(WTogetherCommon.VideoInfoRsp paramVideoInfoRsp)
  {
    String str3;
    Object localObject2;
    Object localObject4;
    Object localObject5;
    String str1;
    String str2;
    int j;
    long l;
    Object localObject1;
    Object localObject3;
    switch (paramVideoInfoRsp.video_src_type.get())
    {
    default: 
      str3 = null;
      localObject2 = null;
      localObject4 = null;
      localObject5 = null;
      str1 = null;
      str2 = null;
      j = 1;
      l = 0L;
      localObject1 = null;
      paramVideoInfoRsp = null;
      localObject3 = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = j;
      this.jdField_a_of_type_JavaLangString = ((String)localObject5);
      this.jdField_b_of_type_JavaLangString = str3;
      this.jdField_c_of_type_JavaLangString = str2;
      this.d = str1;
      this.e = ((String)localObject4);
      this.f = ((String)localObject3);
      this.g = ((String)localObject2);
      this.h = ((String)localObject1);
      this.i = paramVideoInfoRsp;
      this.jdField_a_of_type_Long = l;
      this.jdField_c_of_type_Int = 0;
      return;
      j = 0;
      localObject1 = (WTogetherCommon.QQFileInfo)paramVideoInfoRsp.qqfile_info.get();
      localObject5 = paramVideoInfoRsp.title.get();
      str3 = ((WTogetherCommon.QQFileInfo)localObject1).file_uuid.get();
      str2 = ((WTogetherCommon.QQFileInfo)localObject1).file_id.get();
      paramVideoInfoRsp = null;
      localObject1 = null;
      localObject2 = null;
      localObject3 = null;
      localObject4 = null;
      str1 = null;
      l = 0L;
      continue;
      localObject1 = (WTogetherCommon.DirectUrlInfo)paramVideoInfoRsp.direct_url_info.get();
      localObject5 = paramVideoInfoRsp.title.get();
      str1 = ((WTogetherCommon.DirectUrlInfo)localObject1).url.get();
      localObject4 = ((WTogetherCommon.DirectUrlInfo)localObject1).cookie.get();
      l = ((WTogetherCommon.DirectUrlInfo)localObject1).media_format.get();
      str3 = null;
      localObject3 = null;
      localObject1 = null;
      paramVideoInfoRsp = null;
      localObject2 = null;
      j = 1;
      str2 = null;
      continue;
      localObject2 = paramVideoInfoRsp.title.get();
      localObject3 = (WTogetherCommon.OnlineResourceInfo)paramVideoInfoRsp.online_resource_info.get();
      localObject1 = ((WTogetherCommon.OnlineResourceInfo)localObject3).platform_id.get();
      paramVideoInfoRsp = ((WTogetherCommon.OnlineResourceInfo)localObject3).sdtform_id.get();
      localObject3 = (WTogetherCommon.PlayInfo)((WTogetherCommon.OnlineResourceInfo)localObject3).play_info.get();
      j = ((WTogetherCommon.PlayInfo)localObject3).player_mode.get();
      int k = ((WTogetherCommon.PlayInfo)localObject3).player_params.type.get();
      localObject3 = (WTogetherCommon.PlayerParams)((WTogetherCommon.PlayInfo)localObject3).player_params.get();
      Object localObject6;
      if (k == 0)
      {
        if (j == 0) {}
        for (j = 2;; j = 1)
        {
          localObject3 = (WTogetherCommon.UrlParams)((WTogetherCommon.PlayerParams)localObject3).url_params.get();
          str1 = ((WTogetherCommon.UrlParams)localObject3).url.get();
          l = ((WTogetherCommon.UrlParams)localObject3).media_format.get();
          str2 = null;
          localObject4 = null;
          localObject5 = localObject2;
          str3 = null;
          localObject6 = null;
          localObject2 = paramVideoInfoRsp;
          paramVideoInfoRsp = null;
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject4;
          localObject4 = localObject6;
          break;
        }
      }
      String str4;
      if (k == 1)
      {
        localObject3 = (WTogetherCommon.TxvlivePlayerParams)((WTogetherCommon.PlayerParams)localObject3).txvlive_player_params.get();
        localObject4 = ((WTogetherCommon.TxvlivePlayerParams)localObject3).vid.get();
        str4 = ((WTogetherCommon.TxvlivePlayerParams)localObject3).livepid.get();
        str1 = null;
        str2 = null;
        j = 4;
        localObject3 = localObject1;
        localObject6 = null;
        localObject5 = localObject2;
        str3 = null;
        l = 0L;
        localObject1 = str4;
        localObject2 = paramVideoInfoRsp;
        paramVideoInfoRsp = (WTogetherCommon.VideoInfoRsp)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        localObject4 = localObject6;
      }
      else if (k == 2)
      {
        localObject4 = ((WTogetherCommon.TxPlayerParams)((WTogetherCommon.PlayerParams)localObject3).tx_player_params.get()).vid.get();
        str1 = null;
        str2 = null;
        j = 3;
        localObject6 = null;
        localObject5 = localObject2;
        str3 = null;
        str4 = null;
        localObject2 = paramVideoInfoRsp;
        localObject3 = localObject1;
        l = 0L;
        paramVideoInfoRsp = str4;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        localObject4 = localObject6;
      }
      else
      {
        localObject4 = ((WTogetherCommon.TxPlayerParams)((WTogetherCommon.PlayerParams)localObject3).tx_player_params.get()).vid.get();
        str1 = null;
        str2 = null;
        j = 3;
        localObject6 = null;
        localObject5 = localObject2;
        str3 = null;
        str4 = null;
        localObject2 = paramVideoInfoRsp;
        localObject3 = localObject1;
        l = 0L;
        paramVideoInfoRsp = str4;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        localObject4 = localObject6;
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      if (this.jdField_c_of_type_Int != 0) {
        return this.jdField_c_of_type_Int;
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
        } while (!TextUtils.isEmpty(this.d));
        return false;
      } while ((!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.g)) && (!TextUtils.isEmpty(this.h)));
      return false;
    } while ((!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.g)) && (!TextUtils.isEmpty(this.h)) && (!TextUtils.isEmpty(this.i)));
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
      return this.f + "_" + this.i;
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
      return this.jdField_a_of_type_Int + "_" + this.f + "_" + this.i;
    }
    return this.jdField_a_of_type_Int + "_" + this.d;
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
              if (TextUtils.equals(this.d, paramObject.d))
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
    return bool1;
  }
  
  public String toString()
  {
    return "WTFileInfo{videoSrcType: " + this.jdField_a_of_type_Int + ", uuid: " + this.jdField_b_of_type_JavaLangString + ", fileId: " + this.jdField_c_of_type_JavaLangString + ", fileName: " + this.jdField_a_of_type_JavaLangString + ", url: " + this.d + ", cookie: " + this.e + ", vid: " + this.f + ", platForm: " + this.g + ", sdtForm: " + this.h + ", livePid: " + this.i + ", mediaFormat: " + this.jdField_a_of_type_Long + ", seq: " + this.jdField_b_of_type_Int + ", videoSrcTypeExtra: " + this.jdField_c_of_type_Int + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.data.WTFileInfo
 * JD-Core Version:    0.7.0.1
 */