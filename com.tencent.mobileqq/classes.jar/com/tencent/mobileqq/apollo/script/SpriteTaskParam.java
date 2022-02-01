package com.tencent.mobileqq.apollo.script;

import ambb;
import ambe;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class SpriteTaskParam
  implements Parcelable
{
  public static final Parcelable.Creator<SpriteTaskParam> CREATOR = new ambb();
  public float a;
  public int a;
  public long a;
  public ambe a;
  public Bundle a;
  public String a;
  public ArrayList<Integer> a;
  public boolean a;
  public int b;
  public String b;
  public ArrayList<Integer> b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k = 1;
  public int l;
  public int m;
  public int n;
  
  public SpriteTaskParam()
  {
    this.jdField_a_of_type_Float = 0.0F;
  }
  
  public SpriteTaskParam(Parcel paramParcel)
  {
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.h = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      this.i = paramParcel.readInt();
      this.jdField_a_of_type_Float = paramParcel.readFloat();
      this.jdField_c_of_type_JavaLangString = paramParcel.readString();
      this.j = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label210;
      }
    }
    label210:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      this.jdField_d_of_type_JavaLangString = paramParcel.readString();
      this.k = paramParcel.readInt();
      this.jdField_e_of_type_JavaLangString = paramParcel.readString();
      this.m = paramParcel.readInt();
      this.n = paramParcel.readInt();
      return;
      bool1 = false;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("SpriteTaskParam{");
    localStringBuffer.append("mTaskId=").append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", mStatus=").append(this.jdField_b_of_type_Int);
    localStringBuffer.append(", mActionType=").append(this.jdField_c_of_type_Int);
    localStringBuffer.append(", mSubType=").append(this.jdField_d_of_type_Int);
    localStringBuffer.append(", mSpriteNum=").append(this.jdField_e_of_type_Int);
    localStringBuffer.append(", mActionId=").append(this.f);
    localStringBuffer.append(", mFromWhere=").append(this.g);
    localStringBuffer.append(", mMsgId=").append(this.jdField_a_of_type_Long);
    localStringBuffer.append(", mAioType=").append(this.h);
    localStringBuffer.append(", mSenderUin='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", mRecvUin='").append(this.jdField_b_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", mIsSend=").append(this.jdField_a_of_type_Boolean);
    localStringBuffer.append(", mAudioId=").append(this.i);
    localStringBuffer.append(", mAudioStartTime=").append(this.jdField_a_of_type_Float);
    localStringBuffer.append(", mInputText='").append(this.jdField_c_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", mInterruptWay=").append(this.j);
    localStringBuffer.append(", mTextIsBarrage=").append(this.jdField_b_of_type_Boolean);
    localStringBuffer.append(", mActionList=").append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuffer.append(", mBackgroundActionList=").append(this.jdField_b_of_type_JavaUtilArrayList);
    localStringBuffer.append(", mExtendJson='").append(this.jdField_d_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", mBridgeImp=").append(this.jdField_a_of_type_Ambe);
    localStringBuffer.append(", mRscType=").append(this.k);
    localStringBuffer.append(", mActionJs='").append(this.jdField_e_of_type_JavaLangString).append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.h);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.i);
      paramParcel.writeFloat(this.jdField_a_of_type_Float);
      paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
      paramParcel.writeInt(this.j);
      if (!this.jdField_b_of_type_Boolean) {
        break label198;
      }
    }
    label198:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
      paramParcel.writeInt(this.k);
      paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
      paramParcel.writeInt(this.m);
      paramParcel.writeInt(this.n);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteTaskParam
 * JD-Core Version:    0.7.0.1
 */