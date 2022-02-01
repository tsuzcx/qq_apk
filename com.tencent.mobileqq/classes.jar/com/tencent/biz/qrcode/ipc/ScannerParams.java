package com.tencent.biz.qrcode.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.biz.qrcode.activity.ScannerResult;
import zmw;

public class ScannerParams
  implements Parcelable
{
  public static final Parcelable.Creator<ScannerParams> CREATOR = new zmw();
  public int a;
  public ScannerResult a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  public String e;
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
        break label202;
      }
      bool1 = true;
      label29:
      this.jdField_b_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label207;
      }
      bool1 = true;
      label43:
      this.jdField_c_of_type_Boolean = bool1;
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      this.jdField_b_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label212;
      }
      bool1 = true;
      label73:
      this.jdField_d_of_type_Boolean = bool1;
      this.jdField_c_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label217;
      }
      bool1 = true;
      label95:
      this.jdField_e_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label222;
      }
      bool1 = true;
      label109:
      this.f = bool1;
      if (paramParcel.readByte() == 0) {
        break label227;
      }
      bool1 = true;
      label123:
      this.g = bool1;
      if (paramParcel.readByte() == 0) {
        break label232;
      }
      bool1 = true;
      label137:
      this.h = bool1;
      if (paramParcel.readByte() == 0) {
        break label237;
      }
    }
    label202:
    label207:
    label212:
    label217:
    label222:
    label227:
    label232:
    label237:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.i = bool1;
      this.jdField_a_of_type_Int = paramParcel.readInt();
      this.jdField_d_of_type_JavaLangString = paramParcel.readString();
      this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult = ((ScannerResult)paramParcel.readParcelable(ScannerResult.class.getClassLoader()));
      this.jdField_e_of_type_JavaLangString = paramParcel.readString();
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
    localStringBuilder.append("  isDecodingFile: ").append(this.jdField_d_of_type_Boolean);
    localStringBuilder.append("  toDecodeFilePath: ").append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("  fromQRDecode: ").append(this.jdField_e_of_type_Boolean);
    localStringBuilder.append("  hasCamera: ").append(this.g);
    localStringBuilder.append("  fromQLink: ").append(this.h);
    localStringBuilder.append("  isCameraReadyToUse: ").append(this.i);
    localStringBuilder.append("  detectType: ").append(this.jdField_a_of_type_Int);
    localStringBuilder.append("  preResult: ").append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("  preScanResult: ").append(this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult);
    localStringBuilder.append("  qrPhotoPath: ").append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("} ");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int k = 1;
    if (this.jdField_a_of_type_Boolean)
    {
      j = 1;
      paramParcel.writeByte((byte)j);
      if (!this.jdField_b_of_type_Boolean) {
        break label202;
      }
      j = 1;
      label27:
      paramParcel.writeByte((byte)j);
      if (!this.jdField_c_of_type_Boolean) {
        break label207;
      }
      j = 1;
      label42:
      paramParcel.writeByte((byte)j);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
      if (!this.jdField_d_of_type_Boolean) {
        break label212;
      }
      j = 1;
      label73:
      paramParcel.writeByte((byte)j);
      paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
      if (!this.jdField_e_of_type_Boolean) {
        break label217;
      }
      j = 1;
      label96:
      paramParcel.writeByte((byte)j);
      if (!this.f) {
        break label222;
      }
      j = 1;
      label111:
      paramParcel.writeByte((byte)j);
      if (!this.g) {
        break label227;
      }
      j = 1;
      label126:
      paramParcel.writeByte((byte)j);
      if (!this.h) {
        break label232;
      }
      j = 1;
      label141:
      paramParcel.writeByte((byte)j);
      if (!this.i) {
        break label237;
      }
    }
    label202:
    label207:
    label212:
    label217:
    label222:
    label227:
    label232:
    label237:
    for (int j = k;; j = 0)
    {
      paramParcel.writeByte((byte)j);
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult, paramInt);
      paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
      return;
      j = 0;
      break;
      j = 0;
      break label27;
      j = 0;
      break label42;
      j = 0;
      break label73;
      j = 0;
      break label96;
      j = 0;
      break label111;
      j = 0;
      break label126;
      j = 0;
      break label141;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.ipc.ScannerParams
 * JD-Core Version:    0.7.0.1
 */