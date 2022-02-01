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
  public static int h = 3;
  public int a;
  public String b;
  public int c;
  public int d;
  public int e;
  public String f;
  public int g;
  public ArrayList<ArVideoResourceInfo> i = new ArrayList();
  public ArFeatureInfo j;
  public ArModelResource k;
  public ArAwardInfo l;
  public ArWebInfo m;
  public int n;
  public ARRelationShip o;
  public boolean p = false;
  public ArLBSActivity q;
  public ARTransferDoorConfigInfo r = null;
  
  public ArCloudConfigInfo() {}
  
  protected ArCloudConfigInfo(Parcel paramParcel)
  {
    this.p = true;
    QLog.i("ArCloudConfigInfo", 1, "readParcel  start ");
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readString();
    this.g = paramParcel.readInt();
    try
    {
      this.i = new ArrayList();
      paramParcel.readList(this.i, ArVideoResourceInfo.class.getClassLoader());
      this.j = ((ArFeatureInfo)paramParcel.readParcelable(ArFeatureInfo.class.getClassLoader()));
      this.k = ((ArModelResource)paramParcel.readParcelable(ArModelResource.class.getClassLoader()));
      this.l = ((ArAwardInfo)paramParcel.readParcelable(ArAwardInfo.class.getClassLoader()));
      this.m = ((ArWebInfo)paramParcel.readParcelable(ArWebInfo.class.getClassLoader()));
    }
    catch (Exception localException)
    {
      this.p = false;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("ArVideoResourceInfo read fail= ");
      localStringBuilder2.append(localException.getMessage());
      QLog.i("ArCloudConfigInfo", 1, localStringBuilder2.toString());
    }
    StringBuilder localStringBuilder1;
    try
    {
      if (19 <= h)
      {
        this.n = paramParcel.readInt();
        this.o = ((ARRelationShip)paramParcel.readParcelable(ARRelationShip.class.getClassLoader()));
        if (20 <= h) {
          this.q = ((ArLBSActivity)paramParcel.readParcelable(ArLBSActivity.class.getClassLoader()));
        }
      }
    }
    catch (Exception paramParcel)
    {
      this.p = false;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("readParcel failed. msg = ");
      localStringBuilder1.append(paramParcel.getMessage());
      QLog.i("ArCloudConfigInfo", 1, localStringBuilder1.toString());
    }
    try
    {
      paramParcel = new StringBuilder();
      paramParcel.append("readParcel  businessId = ");
      paramParcel.append(this.a);
      paramParcel.append(",  sDKVersion = ");
      paramParcel.append(this.b);
      paramParcel.append(",  closeCache = ");
      paramParcel.append(this.c);
      paramParcel.append(",  trackMode = ");
      paramParcel.append(this.d);
      paramParcel.append(",  type = ");
      paramParcel.append(this.e);
      paramParcel.append(",  picId = ");
      paramParcel.append(this.f);
      paramParcel.append(",  mArFeatureInfo = ");
      paramParcel.append(this.j);
      paramParcel.append(",  modelResource = ");
      paramParcel.append(this.k);
      paramParcel.append(",  mArWebInfo = ");
      paramParcel.append(this.m);
      paramParcel.append(", mArLBSActivity = ");
      paramParcel.append(this.q);
      QLog.i("ArCloudConfigInfo", 1, paramParcel.toString());
    }
    catch (Exception paramParcel)
    {
      this.p = false;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("IQLog");
      localStringBuilder1.append(paramParcel.getMessage());
      QLog.i("ArCloudConfigInfo", 1, localStringBuilder1.toString());
    }
    paramParcel = new StringBuilder();
    paramParcel.append("readParcel  end flag = ");
    paramParcel.append(this.p);
    paramParcel.append("  VersionCode :");
    paramParcel.append(h);
    QLog.i("ArCloudConfigInfo", 1, paramParcel.toString());
  }
  
  public boolean a()
  {
    return this.e == 100;
  }
  
  public boolean b()
  {
    return (this.n == 1) && (this.e == 7);
  }
  
  public boolean c()
  {
    return this.e == 8;
  }
  
  public boolean d()
  {
    return this.d == 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    return this.a == 1;
  }
  
  public boolean f()
  {
    return (this.e != 6) && ((!e()) || (this.g != 0));
  }
  
  public boolean g()
  {
    ArWebInfo localArWebInfo = this.m;
    if (localArWebInfo == null) {
      return false;
    }
    return localArWebInfo.b;
  }
  
  public boolean h()
  {
    ArWebInfo localArWebInfo = this.m;
    boolean bool = false;
    if (localArWebInfo == null) {
      return false;
    }
    if (((this.a == 1) && (this.g == 1)) || (!TextUtils.isEmpty(this.m.c))) {
      bool = true;
    }
    return bool;
  }
  
  public boolean i()
  {
    return this.d == 2;
  }
  
  public boolean j()
  {
    return this.d == 1;
  }
  
  public boolean k()
  {
    ArWebInfo localArWebInfo = this.m;
    boolean bool2 = false;
    if (localArWebInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (TextUtils.isEmpty(localArWebInfo.c))
    {
      bool1 = bool2;
      if (this.a != 1)
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
    localStringBuffer.append(this.j);
    localStringBuffer.append('\'');
    localStringBuffer.append(", modelResource=");
    localStringBuffer.append(this.k);
    localStringBuffer.append(", mIsRelationShip=");
    localStringBuffer.append(this.n);
    localStringBuffer.append(", mArLBSActivity = ");
    localStringBuffer.append(this.q);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    QLog.i("ArCloudConfigInfo", 1, "writeToParcel  start ");
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.g);
    try
    {
      paramParcel.writeList(this.i);
      paramParcel.writeParcelable(this.j, paramInt);
      paramParcel.writeParcelable(this.k, paramInt);
      paramParcel.writeParcelable(this.l, paramInt);
      paramParcel.writeParcelable(this.m, paramInt);
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
      paramParcel.writeInt(this.n);
      paramParcel.writeParcelable(this.o, paramInt);
      paramParcel.writeParcelable(this.q, paramInt);
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
      paramParcel.append(this.a);
      paramParcel.append(",  sDKVersion = ");
      paramParcel.append(this.b);
      paramParcel.append(",  closeCache = ");
      paramParcel.append(this.c);
      paramParcel.append(",  trackMode = ");
      paramParcel.append(this.d);
      paramParcel.append(",  type = ");
      paramParcel.append(this.e);
      paramParcel.append(",  picId = ");
      paramParcel.append(this.f);
      paramParcel.append(",  mArFeatureInfo = ");
      paramParcel.append(this.j);
      paramParcel.append(",  modelResource = ");
      paramParcel.append(this.k);
      paramParcel.append(",  mArWebInfo = ");
      paramParcel.append(this.m);
      paramParcel.append(", mArLBSActivity = ");
      paramParcel.append(this.q);
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
    paramParcel.append(h);
    QLog.i("ArCloudConfigInfo", 1, paramParcel.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo
 * JD-Core Version:    0.7.0.1
 */