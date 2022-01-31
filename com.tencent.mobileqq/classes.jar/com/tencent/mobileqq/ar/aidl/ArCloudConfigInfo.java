package com.tencent.mobileqq.ar.aidl;

import amos;
import amun;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
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
  public static final Parcelable.Creator<ArCloudConfigInfo> CREATOR = new amun();
  public static int f = 3;
  public int a;
  public amos a;
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
  }
  
  public ArCloudConfigInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
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
    catch (Exception paramParcel)
    {
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
        try
        {
          for (;;)
          {
            QLog.i("ArCloudConfigInfo", 1, "readParcel  businessId = " + this.jdField_a_of_type_Int + ",  sDKVersion = " + this.jdField_a_of_type_JavaLangString + ",  closeCache = " + this.jdField_b_of_type_Int + ",  trackMode = " + this.c + ",  type = " + this.d + ",  picId = " + this.jdField_b_of_type_JavaLangString + ",  mArFeatureInfo = " + this.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo + ",  modelResource = " + this.jdField_a_of_type_ComTencentMobileqqArModelArModelResource + ",  mArWebInfo = " + this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo + ", mArLBSActivity = " + this.jdField_a_of_type_ComTencentMobileqqArModelArLBSActivity);
            QLog.i("ArCloudConfigInfo", 1, "readParcel  end flag = " + this.jdField_a_of_type_Boolean + "  VersionCode :" + f);
            return;
            localException = localException;
            this.jdField_a_of_type_Boolean = false;
            QLog.i("ArCloudConfigInfo", 1, "ArVideoResourceInfo read fail= " + localException.getMessage());
            continue;
            paramParcel = paramParcel;
            this.jdField_a_of_type_Boolean = false;
            QLog.i("ArCloudConfigInfo", 1, "readParcel failed. msg = " + paramParcel.getMessage());
          }
        }
        catch (Exception paramParcel)
        {
          for (;;)
          {
            this.jdField_a_of_type_Boolean = false;
            QLog.i("ArCloudConfigInfo", 1, "IQLog" + paramParcel.getMessage());
          }
        }
      }
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.b;
  }
  
  public boolean h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo == null) {}
    while (((this.jdField_a_of_type_Int != 1) || (this.e != 1)) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    return true;
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
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo == null) {
      return false;
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Int != 1) && (!d())) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ArCloudConfigInfo{");
    localStringBuffer.append("mArFeatureInfo='").append(this.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo).append('\'');
    localStringBuffer.append(", modelResource=").append(this.jdField_a_of_type_ComTencentMobileqqArModelArModelResource);
    localStringBuffer.append(", mIsRelationShip=").append(this.g);
    localStringBuffer.append(", mArLBSActivity = ").append(this.jdField_a_of_type_ComTencentMobileqqArModelArLBSActivity);
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
    catch (Exception paramParcel)
    {
      try
      {
        paramParcel.writeInt(this.g);
        paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip, paramInt);
        paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqArModelArLBSActivity, paramInt);
      }
      catch (Exception paramParcel)
      {
        try
        {
          for (;;)
          {
            QLog.i("ArCloudConfigInfo", 1, "writeToParcel  businessId = " + this.jdField_a_of_type_Int + ",  sDKVersion = " + this.jdField_a_of_type_JavaLangString + ",  closeCache = " + this.jdField_b_of_type_Int + ",  trackMode = " + this.c + ",  type = " + this.d + ",  picId = " + this.jdField_b_of_type_JavaLangString + ",  mArFeatureInfo = " + this.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo + ",  modelResource = " + this.jdField_a_of_type_ComTencentMobileqqArModelArModelResource + ",  mArWebInfo = " + this.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo + ", mArLBSActivity = " + this.jdField_a_of_type_ComTencentMobileqqArModelArLBSActivity);
            QLog.i("ArCloudConfigInfo", 1, "writeToParcel  end VersionCode" + f);
            return;
            localException = localException;
            QLog.i("ArCloudConfigInfo", 1, "writeList  fail= " + localException.getMessage());
            continue;
            paramParcel = paramParcel;
            QLog.i("ArCloudConfigInfo", 1, "writeToParcel failed. msg = " + paramParcel.getMessage());
          }
        }
        catch (Exception paramParcel)
        {
          for (;;)
          {
            QLog.i("ArCloudConfigInfo", 1, "IQLog" + paramParcel.getMessage());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo
 * JD-Core Version:    0.7.0.1
 */