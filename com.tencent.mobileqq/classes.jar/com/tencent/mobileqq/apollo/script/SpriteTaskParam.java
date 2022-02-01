package com.tencent.mobileqq.apollo.script;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class SpriteTaskParam
  implements Parcelable
{
  public static final Parcelable.Creator<SpriteTaskParam> CREATOR = new SpriteTaskParam.1();
  public boolean A;
  public float B;
  public boolean C;
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public long h;
  public int i;
  public String j;
  public String k;
  public boolean l;
  public int m;
  public float n = 0.0F;
  public String o;
  public int p;
  public boolean q;
  public ArrayList<Integer> r;
  public ArrayList<Integer> s;
  public String t;
  public ISpriteBridge u;
  public int v;
  public int w;
  public String x;
  public int y;
  public int z;
  
  public SpriteTaskParam()
  {
    this.v = 1;
    this.A = false;
    this.B = 0.1F;
    this.C = true;
  }
  
  protected SpriteTaskParam(Parcel paramParcel)
  {
    boolean bool2 = true;
    this.v = 1;
    this.A = false;
    this.B = 0.1F;
    this.C = true;
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readLong();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    boolean bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.l = bool1;
    this.m = paramParcel.readInt();
    this.n = paramParcel.readFloat();
    this.o = paramParcel.readString();
    this.p = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.q = bool1;
    this.t = paramParcel.readString();
    this.v = paramParcel.readInt();
    this.x = paramParcel.readString();
    this.y = paramParcel.readInt();
    this.z = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.A = bool1;
    this.B = paramParcel.readFloat();
  }
  
  public Boolean a()
  {
    int i1 = this.e;
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("SpriteTaskParam{");
    localStringBuffer.append("mTaskId=");
    localStringBuffer.append(this.a);
    localStringBuffer.append(", mStatus=");
    localStringBuffer.append(this.b);
    localStringBuffer.append(", mActionType=");
    localStringBuffer.append(this.c);
    localStringBuffer.append(", mSubType=");
    localStringBuffer.append(this.d);
    localStringBuffer.append(", mSpriteNum=");
    localStringBuffer.append(this.e);
    localStringBuffer.append(", mActionId=");
    localStringBuffer.append(this.f);
    localStringBuffer.append(", mFromWhere=");
    localStringBuffer.append(this.g);
    localStringBuffer.append(", mMsgId=");
    localStringBuffer.append(this.h);
    localStringBuffer.append(", mAioType=");
    localStringBuffer.append(this.i);
    localStringBuffer.append(", mSenderUin='");
    localStringBuffer.append(this.j);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mRecvUin='");
    localStringBuffer.append(this.k);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mIsSend=");
    localStringBuffer.append(this.l);
    localStringBuffer.append(", mAudioId=");
    localStringBuffer.append(this.m);
    localStringBuffer.append(", mAudioStartTime=");
    localStringBuffer.append(this.n);
    localStringBuffer.append(", mInputText='");
    localStringBuffer.append(this.o);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mInterruptWay=");
    localStringBuffer.append(this.p);
    localStringBuffer.append(", mTextIsBarrage=");
    localStringBuffer.append(this.q);
    localStringBuffer.append(", mActionList=");
    localStringBuffer.append(this.r);
    localStringBuffer.append(", mBackgroundActionList=");
    localStringBuffer.append(this.s);
    localStringBuffer.append(", mExtendJson='");
    localStringBuffer.append(this.t);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mBridgeImp=");
    localStringBuffer.append(this.u);
    localStringBuffer.append(", mRscType=");
    localStringBuffer.append(this.v);
    localStringBuffer.append(", mActionJs='");
    localStringBuffer.append(this.x);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mNeedRecordFrame='");
    localStringBuffer.append(this.A);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mFrameTime='");
    localStringBuffer.append(this.B);
    localStringBuffer.append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeLong(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeByte((byte)this.l);
    paramParcel.writeInt(this.m);
    paramParcel.writeFloat(this.n);
    paramParcel.writeString(this.o);
    paramParcel.writeInt(this.p);
    paramParcel.writeByte((byte)this.q);
    paramParcel.writeString(this.t);
    paramParcel.writeInt(this.v);
    paramParcel.writeString(this.x);
    paramParcel.writeInt(this.y);
    paramParcel.writeInt(this.z);
    paramParcel.writeByte((byte)this.A);
    paramParcel.writeFloat(this.B);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteTaskParam
 * JD-Core Version:    0.7.0.1
 */