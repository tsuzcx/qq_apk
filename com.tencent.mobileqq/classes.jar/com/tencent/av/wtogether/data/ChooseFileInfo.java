package com.tencent.av.wtogether.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.HexUtil;
import trpc.qq_av_together.common.WTogetherCommon.DirectUrlInfo;
import trpc.qq_av_together.common.WTogetherCommon.ForwardReq;
import trpc.qq_av_together.common.WTogetherCommon.VideoInfoReq;

public class ChooseFileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ChooseFileInfo> CREATOR = new ChooseFileInfo.1();
  public int a;
  public int b;
  public long c;
  public long d;
  public int e;
  public String f;
  public String g;
  public String h;
  public long i;
  public long j;
  public String k = null;
  public String l = null;
  public String m = null;
  public String n = null;
  public int o = 0;
  public int p = 0;
  
  public ChooseFileInfo(int paramInt)
  {
    this.b = paramInt;
  }
  
  protected ChooseFileInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readLong();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readLong();
    this.j = paramParcel.readLong();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.n = paramParcel.readString();
    this.o = paramParcel.readInt();
    this.p = paramParcel.readInt();
  }
  
  public WTogetherCommon.VideoInfoReq a()
  {
    WTogetherCommon.VideoInfoReq localVideoInfoReq = new WTogetherCommon.VideoInfoReq();
    int i1 = this.b;
    if ((i1 != 0) && (i1 != 1))
    {
      if (i1 == 2)
      {
        localObject = new WTogetherCommon.DirectUrlInfo();
        if (this.k != null) {
          ((WTogetherCommon.DirectUrlInfo)localObject).file_name.set(this.k);
        }
        if (this.l != null) {
          ((WTogetherCommon.DirectUrlInfo)localObject).url.set(this.l);
        }
        if (this.m != null) {
          ((WTogetherCommon.DirectUrlInfo)localObject).cookie.set(this.m);
        }
        ((WTogetherCommon.DirectUrlInfo)localObject).media_format.set(this.p);
        localVideoInfoReq.video_src_type.set(1);
        localVideoInfoReq.direct_url_info.set((MessageMicro)localObject);
        return localVideoInfoReq;
      }
      localVideoInfoReq.video_src_type.set(2);
      localVideoInfoReq.online_resource_id.set(this.n);
      return localVideoInfoReq;
    }
    Object localObject = new WTogetherCommon.ForwardReq();
    ((WTogetherCommon.ForwardReq)localObject).src_uin.set(this.c);
    ((WTogetherCommon.ForwardReq)localObject).src_group.set(this.d);
    ((WTogetherCommon.ForwardReq)localObject).src_svcid.set(this.e);
    if (this.f != null) {
      ((WTogetherCommon.ForwardReq)localObject).src_parentfolder.set(ByteStringMicro.copyFrom(this.f.getBytes()));
    }
    if (this.g != null) {
      ((WTogetherCommon.ForwardReq)localObject).src_uuid.set(ByteStringMicro.copyFrom(this.g.getBytes()));
    }
    if (this.h != null) {
      ((WTogetherCommon.ForwardReq)localObject).file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.h)));
    }
    ((WTogetherCommon.ForwardReq)localObject).dst_uin.set(this.i);
    ((WTogetherCommon.ForwardReq)localObject).file_size.set(this.j);
    if (this.k != null) {
      ((WTogetherCommon.ForwardReq)localObject).file_name.set(this.k);
    }
    ((WTogetherCommon.ForwardReq)localObject).client_type.set(104);
    localVideoInfoReq.video_src_type.set(0);
    localVideoInfoReq.forward_req.set((MessageMicro)localObject);
    return localVideoInfoReq;
  }
  
  public int b()
  {
    int i1 = this.b;
    if (i1 == 0) {
      return 1;
    }
    if (i1 == 1) {
      return 2;
    }
    return 3;
  }
  
  public String c()
  {
    int i1 = this.b;
    if (i1 == 0) {
      return this.k;
    }
    if (i1 == 1) {
      return this.k;
    }
    if (i1 == 4) {
      return this.k;
    }
    return "";
  }
  
  public String d()
  {
    int i1 = this.b;
    if (i1 == 0) {
      return this.g;
    }
    if (i1 == 1) {
      return this.g;
    }
    if (i1 == 4) {
      return this.n;
    }
    return "";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    if ((this.b == 4) && (!TextUtils.isEmpty(this.n)))
    {
      localObject = this.n.split("@");
      if (localObject.length >= 2)
      {
        localObject = localObject[(localObject.length - 1)];
        break label47;
      }
    }
    Object localObject = "0";
    label47:
    if (TextUtils.isDigitsOnly((CharSequence)localObject)) {
      return localObject;
    }
    return "0";
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ChooseFileInfo))
    {
      paramObject = (ChooseFileInfo)paramObject;
      if (paramObject == this) {}
      int i1;
      do
      {
        return true;
        i1 = this.b;
      } while ((i1 == paramObject.b) && ((i1 != 0) && (i1 != 1) ? i1 == 2 ? (!TextUtils.equals(this.l, paramObject.l)) || (!TextUtils.equals(this.m, paramObject.m)) || (!TextUtils.equals(this.k, paramObject.k)) : i1 == 4 ? (!TextUtils.equals(this.n, paramObject.n)) || (!TextUtils.equals(this.k, paramObject.k)) : (TextUtils.equals(this.g, paramObject.g)) || (TextUtils.equals(this.k, paramObject.k)) || (TextUtils.equals(this.l, paramObject.l)) || (TextUtils.equals(this.m, paramObject.m)) || (TextUtils.equals(this.n, paramObject.n)) : (TextUtils.equals(this.g, paramObject.g)) && (TextUtils.equals(this.k, paramObject.k))));
    }
    return false;
  }
  
  public String f()
  {
    int i1 = this.a;
    if (i1 == 1) {
      return "1";
    }
    if (i1 == 3) {
      return "2";
    }
    if (i1 == 4) {
      return "3";
    }
    return "0";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChooseFile{entrance: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", type: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", srcUin: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", srcGroup: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", busId: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", parentFolder: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", uuid: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", fileMD5: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", destUin: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", fileSize: ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", fileName: ");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", url: ");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", cookie: ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", matchId: ");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", isPay: ");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", mediaFormat: ");
    localStringBuilder.append(this.p);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeLong(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeLong(this.i);
    paramParcel.writeLong(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeInt(this.o);
    paramParcel.writeInt(this.p);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.data.ChooseFileInfo
 * JD-Core Version:    0.7.0.1
 */