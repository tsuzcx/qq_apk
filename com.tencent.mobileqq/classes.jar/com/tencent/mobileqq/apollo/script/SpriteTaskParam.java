package com.tencent.mobileqq.apollo.script;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class SpriteTaskParam
  implements Parcelable
{
  public static final Parcelable.Creator<SpriteTaskParam> CREATOR = new SpriteTaskParam.1();
  public float a;
  public int a;
  public long a;
  public ISpriteBridge a;
  public String a;
  public ArrayList<Integer> a;
  public boolean a;
  public float b;
  public int b;
  public String b;
  public ArrayList<Integer> b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  
  public SpriteTaskParam()
  {
    this.jdField_a_of_type_Float = 0.0F;
    this.k = 1;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Float = 0.1F;
    this.jdField_d_of_type_Boolean = true;
  }
  
  protected SpriteTaskParam(Parcel paramParcel)
  {
    this.jdField_a_of_type_Float = 0.0F;
    boolean bool2 = true;
    this.k = 1;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Float = 0.1F;
    this.jdField_d_of_type_Boolean = true;
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
    boolean bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_Boolean = bool1;
    this.i = paramParcel.readInt();
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.j = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_b_of_type_Boolean = bool1;
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.k = paramParcel.readInt();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.m = paramParcel.readInt();
    this.n = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.jdField_c_of_type_Boolean = bool1;
    this.jdField_b_of_type_Float = paramParcel.readFloat();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("SpriteTaskParam{");
    localStringBuffer.append("mTaskId=");
    localStringBuffer.append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", mStatus=");
    localStringBuffer.append(this.jdField_b_of_type_Int);
    localStringBuffer.append(", mActionType=");
    localStringBuffer.append(this.jdField_c_of_type_Int);
    localStringBuffer.append(", mSubType=");
    localStringBuffer.append(this.jdField_d_of_type_Int);
    localStringBuffer.append(", mSpriteNum=");
    localStringBuffer.append(this.jdField_e_of_type_Int);
    localStringBuffer.append(", mActionId=");
    localStringBuffer.append(this.f);
    localStringBuffer.append(", mFromWhere=");
    localStringBuffer.append(this.g);
    localStringBuffer.append(", mMsgId=");
    localStringBuffer.append(this.jdField_a_of_type_Long);
    localStringBuffer.append(", mAioType=");
    localStringBuffer.append(this.h);
    localStringBuffer.append(", mSenderUin='");
    localStringBuffer.append(this.jdField_a_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mRecvUin='");
    localStringBuffer.append(this.jdField_b_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mIsSend=");
    localStringBuffer.append(this.jdField_a_of_type_Boolean);
    localStringBuffer.append(", mAudioId=");
    localStringBuffer.append(this.i);
    localStringBuffer.append(", mAudioStartTime=");
    localStringBuffer.append(this.jdField_a_of_type_Float);
    localStringBuffer.append(", mInputText='");
    localStringBuffer.append(this.jdField_c_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mInterruptWay=");
    localStringBuffer.append(this.j);
    localStringBuffer.append(", mTextIsBarrage=");
    localStringBuffer.append(this.jdField_b_of_type_Boolean);
    localStringBuffer.append(", mActionList=");
    localStringBuffer.append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuffer.append(", mBackgroundActionList=");
    localStringBuffer.append(this.jdField_b_of_type_JavaUtilArrayList);
    localStringBuffer.append(", mExtendJson='");
    localStringBuffer.append(this.jdField_d_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mBridgeImp=");
    localStringBuffer.append(this.jdField_a_of_type_ComTencentMobileqqApolloScriptISpriteBridge);
    localStringBuffer.append(", mRscType=");
    localStringBuffer.append(this.k);
    localStringBuffer.append(", mActionJs='");
    localStringBuffer.append(this.jdField_e_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mNeedRecordFrame='");
    localStringBuffer.append(this.jdField_c_of_type_Boolean);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mFrameTime='");
    localStringBuffer.append(this.jdField_b_of_type_Float);
    localStringBuffer.append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
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
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
    paramParcel.writeInt(this.i);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeInt(this.j);
    paramParcel.writeByte((byte)this.jdField_b_of_type_Boolean);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeInt(this.k);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeInt(this.m);
    paramParcel.writeInt(this.n);
    paramParcel.writeByte((byte)this.jdField_c_of_type_Boolean);
    paramParcel.writeFloat(this.jdField_b_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteTaskParam
 * JD-Core Version:    0.7.0.1
 */