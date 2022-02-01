package com.tencent.mobileqq.ar.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorConfigInfo;
import com.tencent.mobileqq.ar.model.ARRelationShip;
import com.tencent.mobileqq.ar.model.ArAwardInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ArCloudConfigInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ArCloudConfigInfo> CREATOR = new ArCloudConfigInfo.1();
  public static int f = 3;
  public int a;
  public ARTransferDoorConfigInfo a;
  public ARRelationShip a;
  public ArAwardInfo a;
  public ArFeatureInfo a;
  public ArLBSActivity a;
  public ArModelResource a;
  public ArWebInfo a;
  public String a;
  public ArrayList<ArVideoResourceInfo> a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e;
  public int g;
  
  public ArCloudConfigInfo()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo = null;
  }
  
  protected ArCloudConfigInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo = null;
    this.jdField_a_of_type_Boolean = true;
    QLog.i("ArCloudConfigInfo", 1, "readParcel  start ");
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.e = paramParcel.readInt();
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      paramParcel.readList(this.jdField_a_of_type_JavaUtilArrayList, ArVideoResourceInfo.class.getClassLoader());
      this.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo = ((ArFeatureInfo)paramParcel.readParcelable(ArFeatureInfo.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentMobileqqArModelArModelResource = ((ArModelResource)paramParcel.readParcelable(ArModelResource.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo = ((ArAwardInfo)paramParcel.readParcelable(ArAwardInfo.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo = ((ArWebInfo)paramParcel.readParcelable(ArWebInfo.class.getClassLoader()));
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_Boolean = false;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("ArVideoResourceInfo read fail= ");
      localStringBuilder2.append(localException.getMessage());
      QLog.i("ArCloudConfigInfo", 1, localStringBuilder2.toString());
    }
    StringBuilder localStringBuilder1;
    try
    {
      if (19 <= f)
      {
        this.g = paramParcel.readInt();
        this.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip = ((ARRelationShip)paramParcel.readParcelable(ARRelationShip.class.getClassLoader()));
        if (20 <= f) {
          this.jdField_a_of_type_ComTencentMobileqqArModelArLBSActivity = ((ArLBSActivity)paramParcel.readParcelable(ArLBSActivity.class.getClassLoader()));
        }
      }
    }
    catch (Exception paramParcel)
    {
      this.jdField_a_of_type_Boolean = false;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("readParcel failed. msg = ");
      localStringBuilder1.append(paramParcel.getMessage());
      QLog.i("ArCloudConfigInfo", 1, localStringBuilder1.toString());
    }
    try
    {
      paramParcel = new StringBuilder();
      paramParcel.append("readParcel  businessId = ");
      paramParcel.append(this.jdField_a_of_type_Int);
      paramParcel.append(",  sDKVersion = ");
      paramParcel.append(this.jdField_a_of_type_JavaLangString);
      paramParcel.append(",  closeCache = ");
      paramParcel.append(this.jdField_b_of_type_Int);
      paramParcel.append(",  trackMode = ");
      paramParcel.append(this.c);
      paramParcel.append(",  type = ");
      paramParcel.append(this.d);
      paramParcel.append(",  picId = ");
      paramParcel.append(this.jdField_b_of_type_JavaLangString);
      paramParcel.append(",  mArFeatureInfo = ");
      paramParcel.append(this.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo);
      paramParcel.append(",  modelResource = ");
      paramParcel.append(this.jdField_a_of_type_ComTencentMobileqqArModelArModelResource);
      paramParcel.append(",  mArWebInfo = ");
      paramParcel.append(this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo);
      paramParcel.append(", mArLBSActivity = ");
      paramParcel.append(this.jdField_a_of_type_ComTencentMobileqqArModelArLBSActivity);
      QLog.i("ArCloudConfigInfo", 1, paramParcel.toString());
    }
    catch (Exception paramParcel)
    {
      this.jdField_a_of_type_Boolean = false;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("IQLog");
      localStringBuilder1.append(paramParcel.getMessage());
      QLog.i("ArCloudConfigInfo", 1, localStringBuilder1.toString());
    }
    paramParcel = new StringBuilder();
    paramParcel.append("readParcel  end flag = ");
    paramParcel.append(this.jdField_a_of_type_Boolean);
    paramParcel.append("  VersionCode :");
    paramParcel.append(f);
    QLog.i("ArCloudConfigInfo", 1, paramParcel.toString());
  }
  
  public boolean a()
  {
    return this.d == 100;
  }
  
  public boolean b()
  {
    return (this.g == 1) && (this.d == 7);
  }
  
  public boolean c()
  {
    return this.d == 8;
  }
  
  public boolean d()
  {
    return this.c == 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public boolean f()
  {
    return (this.d != 6) && ((!e()) || (this.e != 0));
  }
  
  public boolean g()
  {
    ArWebInfo localArWebInfo = this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo;
    if (localArWebInfo == null) {
      return false;
    }
    return localArWebInfo.b;
  }
  
  public boolean h()
  {
    ArWebInfo localArWebInfo = this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo;
    boolean bool = false;
    if (localArWebInfo == null) {
      return false;
    }
    if (((this.jdField_a_of_type_Int == 1) && (this.e == 1)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString))) {
      bool = true;
    }
    return bool;
  }
  
  public boolean i()
  {
    return this.c == 2;
  }
  
  public boolean j()
  {
    return this.c == 1;
  }
  
  public boolean k()
  {
    ArWebInfo localArWebInfo = this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo;
    boolean bool2 = false;
    if (localArWebInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (TextUtils.isEmpty(localArWebInfo.jdField_a_of_type_JavaLangString))
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Int != 1)
      {
        bool1 = bool2;
        if (!d()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ArCloudConfigInfo{");
    localStringBuffer.append("mArFeatureInfo='");
    localStringBuffer.append(this.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo);
    localStringBuffer.append('\'');
    localStringBuffer.append(", modelResource=");
    localStringBuffer.append(this.jdField_a_of_type_ComTencentMobileqqArModelArModelResource);
    localStringBuffer.append(", mIsRelationShip=");
    localStringBuffer.append(this.g);
    localStringBuffer.append(", mArLBSActivity = ");
    localStringBuffer.append(this.jdField_a_of_type_ComTencentMobileqqArModelArLBSActivity);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    QLog.i("ArCloudConfigInfo", 1, "writeToParcel  start ");
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.e);
    try
    {
      paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqArModelArModelResource, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo, paramInt);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("writeList  fail= ");
      localStringBuilder2.append(localException.getMessage());
      QLog.i("ArCloudConfigInfo", 1, localStringBuilder2.toString());
    }
    StringBuilder localStringBuilder1;
    try
    {
      paramParcel.writeInt(this.g);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqArModelArLBSActivity, paramInt);
    }
    catch (Exception paramParcel)
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("writeToParcel failed. msg = ");
      localStringBuilder1.append(paramParcel.getMessage());
      QLog.i("ArCloudConfigInfo", 1, localStringBuilder1.toString());
    }
    try
    {
      paramParcel = new StringBuilder();
      paramParcel.append("writeToParcel  businessId = ");
      paramParcel.append(this.jdField_a_of_type_Int);
      paramParcel.append(",  sDKVersion = ");
      paramParcel.append(this.jdField_a_of_type_JavaLangString);
      paramParcel.append(",  closeCache = ");
      paramParcel.append(this.jdField_b_of_type_Int);
      paramParcel.append(",  trackMode = ");
      paramParcel.append(this.c);
      paramParcel.append(",  type = ");
      paramParcel.append(this.d);
      paramParcel.append(",  picId = ");
      paramParcel.append(this.jdField_b_of_type_JavaLangString);
      paramParcel.append(",  mArFeatureInfo = ");
      paramParcel.append(this.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo);
      paramParcel.append(",  modelResource = ");
      paramParcel.append(this.jdField_a_of_type_ComTencentMobileqqArModelArModelResource);
      paramParcel.append(",  mArWebInfo = ");
      paramParcel.append(this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo);
      paramParcel.append(", mArLBSActivity = ");
      paramParcel.append(this.jdField_a_of_type_ComTencentMobileqqArModelArLBSActivity);
      QLog.i("ArCloudConfigInfo", 1, paramParcel.toString());
    }
    catch (Exception paramParcel)
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("IQLog");
      localStringBuilder1.append(paramParcel.getMessage());
      QLog.i("ArCloudConfigInfo", 1, localStringBuilder1.toString());
    }
    paramParcel = new StringBuilder();
    paramParcel.append("writeToParcel  end VersionCode");
    paramParcel.append(f);
    QLog.i("ArCloudConfigInfo", 1, paramParcel.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo
 * JD-Core Version:    0.7.0.1
 */