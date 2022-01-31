package com.tencent.biz.qrcode.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import otc;

public class ScannerParams
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new otc();
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  public boolean g;
  public boolean h;
  public boolean i;
  
  public ScannerParams() {}
  
  public ScannerParams(Parcel paramParcel)
  {
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label162;
      }
      bool1 = true;
      label29:
      this.jdField_b_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label167;
      }
      bool1 = true;
      label43:
      this.jdField_c_of_type_Boolean = bool1;
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      this.jdField_b_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label172;
      }
      bool1 = true;
      label73:
      this.d = bool1;
      this.jdField_c_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label177;
      }
      bool1 = true;
      label95:
      this.e = bool1;
      if (paramParcel.readByte() == 0) {
        break label182;
      }
      bool1 = true;
      label109:
      this.f = bool1;
      if (paramParcel.readByte() == 0) {
        break label187;
      }
      bool1 = true;
      label123:
      this.g = bool1;
      if (paramParcel.readByte() == 0) {
        break label192;
      }
      bool1 = true;
      label137:
      this.h = bool1;
      if (paramParcel.readByte() == 0) {
        break label197;
      }
    }
    label162:
    label167:
    label172:
    label177:
    label182:
    label187:
    label192:
    label197:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.i = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label29;
      bool1 = false;
      break label43;
      bool1 = false;
      break label73;
      bool1 = false;
      break label95;
      bool1 = false;
      break label109;
      bool1 = false;
      break label123;
      bool1 = false;
      break label137;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScannerParams { scanForResult: ").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("  finishAfterSuccess: ").append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("  isFormPublicAccountNew: ").append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append("  from: ").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("  subFrom: ").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("  isDecodingFile: ").append(this.d);
    localStringBuilder.append("  toDecodeFilePath: ").append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("  fromQRDecode: ").append(this.e);
    localStringBuilder.append("  hasCamera: ").append(this.g);
    localStringBuilder.append("  fromQLink: ").append(this.h);
    localStringBuilder.append("  isCameraReadyToUse: ").append(this.i);
    localStringBuilder.append("} ");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_b_of_type_Boolean) {
        break label167;
      }
      paramInt = 1;
      label26:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_c_of_type_Boolean) {
        break label172;
      }
      paramInt = 1;
      label41:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
      if (!this.d) {
        break label177;
      }
      paramInt = 1;
      label72:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
      if (!this.e) {
        break label182;
      }
      paramInt = 1;
      label95:
      paramParcel.writeByte((byte)paramInt);
      if (!this.f) {
        break label187;
      }
      paramInt = 1;
      label110:
      paramParcel.writeByte((byte)paramInt);
      if (!this.g) {
        break label192;
      }
      paramInt = 1;
      label125:
      paramParcel.writeByte((byte)paramInt);
      if (!this.h) {
        break label197;
      }
      paramInt = 1;
      label140:
      paramParcel.writeByte((byte)paramInt);
      if (!this.i) {
        break label202;
      }
    }
    label167:
    label172:
    label177:
    label182:
    label187:
    label192:
    label197:
    label202:
    for (paramInt = j;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label26;
      paramInt = 0;
      break label41;
      paramInt = 0;
      break label72;
      paramInt = 0;
      break label95;
      paramInt = 0;
      break label110;
      paramInt = 0;
      break label125;
      paramInt = 0;
      break label140;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.ipc.ScannerParams
 * JD-Core Version:    0.7.0.1
 */