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
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  public final String g;
  public final String h;
  public final String i;
  public final String j;
  public final int k;
  public final String l;
  public final long m;
  public int n;
  public int o;
  
  protected WTFileInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readInt();
    this.l = paramParcel.readString();
    this.m = paramParcel.readLong();
    this.n = paramParcel.readInt();
    this.o = paramParcel.readInt();
  }
  
  public WTFileInfo(WTogetherCommon.VideoInfoRsp paramVideoInfoRsp)
  {
    int i2 = paramVideoInfoRsp.video_src_type.get();
    int i1 = 3;
    String str = null;
    Object localObject1;
    Object localObject2;
    Object localObject6;
    Object localObject7;
    long l1;
    Object localObject8;
    Object localObject5;
    Object localObject3;
    Object localObject4;
    if (i2 != 0)
    {
      if (i2 != 1)
      {
        if (i2 != 2)
        {
          localObject1 = null;
          localObject2 = localObject1;
          localObject6 = localObject2;
          localObject7 = localObject6;
          l1 = 0L;
          i1 = 1;
          i2 = 0;
        }
        int i4;
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
          i2 = paramVideoInfoRsp.is_pay.get();
          paramVideoInfoRsp = (WTogetherCommon.PlayInfo)paramVideoInfoRsp.play_info.get();
          int i3 = paramVideoInfoRsp.player_mode.get();
          i4 = paramVideoInfoRsp.player_params.type.get();
          paramVideoInfoRsp = (WTogetherCommon.PlayerParams)paramVideoInfoRsp.player_params.get();
          if (i4 != 0) {
            break;
          }
          if (i3 == 0) {
            i1 = 2;
          } else {
            i1 = 1;
          }
          localObject1 = (WTogetherCommon.UrlParams)paramVideoInfoRsp.url_params.get();
          paramVideoInfoRsp = ((WTogetherCommon.UrlParams)localObject1).url.get();
          l1 = ((WTogetherCommon.UrlParams)localObject1).media_format.get();
          localObject1 = localObject2;
          localObject2 = paramVideoInfoRsp;
        }
        if (i4 == 1)
        {
          i1 = 4;
          paramVideoInfoRsp = (WTogetherCommon.TxvlivePlayerParams)paramVideoInfoRsp.txvlive_player_params.get();
          localObject4 = paramVideoInfoRsp.vid.get();
          localObject8 = paramVideoInfoRsp.livepid.get();
        }
        for (localObject5 = null;; localObject5 = localObject1)
        {
          l1 = 0L;
          Object localObject9 = null;
          paramVideoInfoRsp = null;
          localObject3 = null;
          localObject1 = localObject2;
          localObject2 = localObject9;
          break;
          if (i4 == 2)
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
      l1 = ((WTogetherCommon.DirectUrlInfo)localObject4).media_format.get();
      paramVideoInfoRsp = null;
      localObject6 = paramVideoInfoRsp;
      localObject7 = localObject6;
      localObject8 = localObject7;
      i1 = 1;
      i2 = 0;
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
      l1 = 0L;
      i2 = 0;
      localObject3 = localObject8;
      localObject4 = localObject3;
      i1 = 0;
    }
    label519:
    this.a = i1;
    this.b = ((String)localObject1);
    this.c = str;
    this.d = paramVideoInfoRsp;
    this.e = ((String)localObject2);
    this.f = ((String)localObject3);
    this.g = ((String)localObject4);
    this.h = localObject5;
    this.i = ((String)localObject6);
    this.j = ((String)localObject7);
    this.k = i2;
    this.l = ((String)localObject8);
    this.m = l1;
    this.o = 0;
  }
  
  public boolean a()
  {
    int i1 = this.a;
    boolean bool2 = false;
    boolean bool1;
    if (i1 != 0)
    {
      if ((i1 != 1) && (i1 != 2))
      {
        if (i1 != 3)
        {
          if (i1 != 4) {
            return false;
          }
          bool1 = bool2;
          if (TextUtils.isEmpty(this.g)) {
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
          bool1 = bool2;
          if (TextUtils.isEmpty(this.l)) {
            return bool1;
          }
        }
        for (;;)
        {
          return true;
          bool1 = bool2;
          if (TextUtils.isEmpty(this.g)) {
            break;
          }
          bool1 = bool2;
          if (TextUtils.isEmpty(this.i)) {
            break;
          }
          bool1 = bool2;
          if (TextUtils.isEmpty(this.j)) {
            break;
          }
        }
      }
      bool1 = TextUtils.isEmpty(this.e);
    }
    else
    {
      bool1 = TextUtils.isEmpty(this.c);
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
  
  public int b()
  {
    if (this.a == 0)
    {
      int i1 = this.o;
      if (i1 != 0) {
        return i1;
      }
      return 1;
    }
    return 2;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public String d()
  {
    int i1 = this.a;
    if (i1 == 0) {
      return this.c;
    }
    if (i1 == 3) {
      return this.g;
    }
    if (i1 == 4)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.g);
      localStringBuilder.append("_");
      localStringBuilder.append(this.l);
      return localStringBuilder.toString();
    }
    return "0";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    int i1 = this.a;
    if (i1 == 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("_");
      localStringBuilder.append(this.c);
      return localStringBuilder.toString();
    }
    if (i1 == 3)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("_");
      localStringBuilder.append(this.g);
      return localStringBuilder.toString();
    }
    if (i1 == 4)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("_");
      localStringBuilder.append(this.g);
      localStringBuilder.append("_");
      localStringBuilder.append(this.l);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("_");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
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
      if (this.a == paramObject.a)
      {
        bool1 = bool2;
        if (TextUtils.equals(this.c, paramObject.c))
        {
          bool1 = bool2;
          if (TextUtils.equals(this.d, paramObject.d))
          {
            bool1 = bool2;
            if (TextUtils.equals(this.b, paramObject.b))
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
                        if (TextUtils.equals(this.j, paramObject.j))
                        {
                          bool1 = bool2;
                          if (this.k == paramObject.k)
                          {
                            bool1 = bool2;
                            if (TextUtils.equals(this.l, paramObject.l))
                            {
                              bool1 = bool2;
                              if (this.m == paramObject.m) {
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
    localStringBuilder.append(this.a);
    localStringBuilder.append(", uuid: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", fileId: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", fileName: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", url: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", cookie: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", vid: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", cid: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", platForm: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", sdtForm: ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", isPay: ");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", livePid: ");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", mediaFormat: ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", seq: ");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", videoSrcTypeExtra: ");
    localStringBuilder.append(this.o);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeInt(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeLong(this.m);
    paramParcel.writeInt(this.n);
    paramParcel.writeInt(this.o);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.data.WTFileInfo
 * JD-Core Version:    0.7.0.1
 */