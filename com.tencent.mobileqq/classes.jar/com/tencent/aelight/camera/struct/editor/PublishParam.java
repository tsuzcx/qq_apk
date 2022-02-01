package com.tencent.aelight.camera.struct.editor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public class PublishParam
  implements Parcelable
{
  public static final Parcelable.Creator<PublishParam> CREATOR = new PublishParam.1();
  public static final String a = "com.tencent.aelight.camera.struct.editor.PublishParam";
  public final int A;
  public final int B;
  public int C;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  public final String g;
  public final int h;
  public final int i;
  public final long j;
  public final int k;
  public final int l;
  public final int m;
  public final int n;
  public final int o;
  public final String p;
  public final String q;
  public final int r;
  public final int s;
  public final String t;
  public final String u;
  public final String v;
  public final String w;
  public final int x;
  public final int y;
  public final String z;
  
  protected PublishParam(Parcel paramParcel)
  {
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readLong();
    this.k = paramParcel.readInt();
    this.l = paramParcel.readInt();
    this.m = paramParcel.readInt();
    this.n = paramParcel.readInt();
    this.o = paramParcel.readInt();
    this.p = paramParcel.readString();
    this.q = paramParcel.readString();
    this.r = paramParcel.readInt();
    this.s = paramParcel.readInt();
    this.t = paramParcel.readString();
    this.u = paramParcel.readString();
    this.v = paramParcel.readString();
    this.w = paramParcel.readString();
    this.x = paramParcel.readInt();
    this.y = paramParcel.readInt();
    this.z = paramParcel.readString();
    this.A = paramParcel.readInt();
    this.B = paramParcel.readInt();
    paramParcel = a();
    if (paramParcel == null) {
      return;
    }
    throw new RuntimeException(paramParcel);
  }
  
  public PublishParam(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString7, String paramString8, int paramInt8, int paramInt9, String paramString9, String paramString10, String paramString11, String paramString12, int paramInt10, boolean paramBoolean, String paramString13, int paramInt11, int paramInt12) {}
  
  protected String a()
  {
    if ((!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.c))) {
      return null;
    }
    return "both fakeVid and thumbPath should not be empty";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PublishParam{fakeVid='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thumbPath='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", doodlePath='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoLabel='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoDoodleDescription='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoAddress='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoWidth=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", videoHeight=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", videoDuration=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", videoMaxrate=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", videoMinrate=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", isEdited=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", saveMode=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", recordFrames=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", atDoodlePath='");
    localStringBuilder.append(this.p);
    localStringBuilder.append('\'');
    localStringBuilder.append(", atJsonData='");
    localStringBuilder.append(this.q);
    localStringBuilder.append('\'');
    localStringBuilder.append(", hwEncodeRecordVideo='");
    localStringBuilder.append(this.s);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoFilePath='");
    localStringBuilder.append(this.t);
    localStringBuilder.append('\'');
    localStringBuilder.append(", audioFilePath='");
    localStringBuilder.append(this.u);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mosaicFilePath='");
    localStringBuilder.append(this.w);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoCount=");
    localStringBuilder.append(this.x);
    localStringBuilder.append("', videoLocateDescription='");
    localStringBuilder.append(this.z);
    localStringBuilder.append('\'');
    localStringBuilder.append(", localVideoLongitude='");
    localStringBuilder.append(this.A);
    localStringBuilder.append('\'');
    localStringBuilder.append(", localVideoLatitude=");
    localStringBuilder.append(this.B);
    localStringBuilder.append("'");
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeLong(this.j);
    paramParcel.writeInt(this.k);
    paramParcel.writeInt(this.l);
    paramParcel.writeInt(this.m);
    paramParcel.writeInt(this.n);
    paramParcel.writeInt(this.o);
    paramParcel.writeString(this.p);
    paramParcel.writeString(this.q);
    paramParcel.writeInt(this.r);
    paramParcel.writeInt(this.s);
    paramParcel.writeString(this.t);
    paramParcel.writeString(this.u);
    paramParcel.writeString(this.v);
    paramParcel.writeString(this.w);
    paramParcel.writeInt(this.x);
    paramParcel.writeInt(this.y);
    paramParcel.writeString(this.z);
    paramParcel.writeInt(this.A);
    paramParcel.writeInt(this.B);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.struct.editor.PublishParam
 * JD-Core Version:    0.7.0.1
 */