package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;

public class PasterParcelData
  implements Parcelable
{
  public static final Parcelable.Creator<PasterParcelData> CREATOR = new PasterParcelData.1();
  public static int a = 1;
  public static int b = 2;
  public int c;
  public PointF d;
  public float e = 1.0F;
  public float f = 0.0F;
  public float g = 0.0F;
  public float h = 0.0F;
  public float i;
  public float j;
  public RectF k;
  public String l;
  public String m;
  public String n;
  public String o;
  public int p;
  public String q;
  public int r;
  public int s;
  public int t;
  public String u;
  public SegmentKeeper v = new SegmentKeeper();
  
  protected PasterParcelData(Parcel paramParcel)
  {
    this.c = paramParcel.readInt();
    this.d = ((PointF)paramParcel.readParcelable(PointF.class.getClassLoader()));
    this.e = paramParcel.readFloat();
    this.f = paramParcel.readFloat();
    this.g = paramParcel.readFloat();
    this.h = paramParcel.readFloat();
    this.i = paramParcel.readFloat();
    this.j = paramParcel.readFloat();
    this.k = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.n = paramParcel.readString();
    this.p = paramParcel.readInt();
    this.q = paramParcel.readString();
    this.r = paramParcel.readInt();
    this.s = paramParcel.readInt();
    this.t = paramParcel.readInt();
    this.u = paramParcel.readString();
    this.o = paramParcel.readString();
    this.v = ((SegmentKeeper)paramParcel.readParcelable(SegmentKeeper.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @TargetApi(13)
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.c);
    paramParcel.writeParcelable(this.d, 0);
    paramParcel.writeFloat(this.e);
    paramParcel.writeFloat(this.f);
    paramParcel.writeFloat(this.g);
    paramParcel.writeFloat(this.h);
    paramParcel.writeFloat(this.i);
    paramParcel.writeFloat(this.j);
    paramParcel.writeParcelable(this.k, 0);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeInt(this.p);
    paramParcel.writeString(this.q);
    paramParcel.writeInt(this.r);
    paramParcel.writeInt(this.s);
    paramParcel.writeInt(this.t);
    paramParcel.writeString(this.u);
    paramParcel.writeString(this.o);
    paramParcel.writeParcelable(this.v, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.PasterParcelData
 * JD-Core Version:    0.7.0.1
 */