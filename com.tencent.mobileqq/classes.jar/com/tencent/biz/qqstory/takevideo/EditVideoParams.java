package com.tencent.biz.qqstory.takevideo;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import vhm;

public class EditVideoParams
  implements Parcelable
{
  public static final Parcelable.Creator<EditVideoParams> CREATOR = new vhm();
  public int a;
  public final Bundle a;
  public EditVideoParams.EditSource a;
  public final int b;
  
  public EditVideoParams(int paramInt1, int paramInt2, EditVideoParams.EditSource paramEditSource, Bundle paramBundle)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource = paramEditSource;
    if (paramBundle == null)
    {
      this.jdField_a_of_type_AndroidOsBundle = new Bundle();
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public EditVideoParams(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource = ((EditVideoParams.EditSource)paramParcel.readParcelable(EditVideoParams.EditSource.class.getClassLoader()));
    this.jdField_a_of_type_AndroidOsBundle = paramParcel.readBundle(getClass().getClassLoader());
  }
  
  public static Bundle a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 101: 
    case 10004: 
      localBundle = new Bundle();
      localBundle.putInt("qq_sub_business_id", 101);
      return localBundle;
    case 104: 
    case 10010: 
      localBundle = new Bundle();
      localBundle.putInt("qq_sub_business_id", 104);
      return localBundle;
    case 102: 
    case 10009: 
      localBundle = new Bundle();
      localBundle.putInt("qq_sub_business_id", 102);
      return localBundle;
    case 103: 
      localBundle = new Bundle();
      localBundle.putInt("qq_sub_business_id", 103);
      return localBundle;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("qq_sub_business_id", 11);
    return localBundle;
  }
  
  public double a(String paramString, double paramDouble)
  {
    double d = paramDouble;
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      d = this.jdField_a_of_type_AndroidOsBundle.getDouble(paramString, paramDouble);
    }
    return d;
  }
  
  public int a()
  {
    int j = 6;
    int k = this.jdField_a_of_type_Int;
    int i = k;
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      if (k == 2) {
        i = this.jdField_a_of_type_AndroidOsBundle.getInt("qq_sub_business_id");
      }
      do
      {
        return i;
        i = k;
        if (k != 6) {
          break;
        }
        k = this.jdField_a_of_type_AndroidOsBundle.getInt("qq_sub_business_id", -999);
        i = j;
      } while (k == -999);
      i = k;
    }
    return i;
  }
  
  public int a(String paramString, int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      i = this.jdField_a_of_type_AndroidOsBundle.getInt(paramString, paramInt);
    }
    return i;
  }
  
  public long a(String paramString, long paramLong)
  {
    long l = paramLong;
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      l = this.jdField_a_of_type_AndroidOsBundle.getLong(paramString, paramLong);
    }
    return l;
  }
  
  public String a()
  {
    Object localObject;
    switch (this.jdField_a_of_type_Int)
    {
    case 7: 
    case 8: 
    case 9: 
    default: 
      localObject = "Unknown Business id " + this.jdField_a_of_type_Int;
    }
    String str;
    do
    {
      return localObject;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource == null) {
        return "Can not find edit source";
      }
      str = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b();
      localObject = str;
    } while (str != null);
    return null;
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      return this.jdField_a_of_type_AndroidOsBundle.getString(paramString);
    }
    return null;
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) || ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource));
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean(paramString, paramBoolean);
    }
    return bool;
  }
  
  public byte[] a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      return this.jdField_a_of_type_AndroidOsBundle.getByteArray(paramString);
    }
    return null;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return 99;
    }
    return this.jdField_a_of_type_AndroidOsBundle.getInt("entrance_type", 99);
  }
  
  public boolean b()
  {
    return ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)) || ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) || ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource));
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return 1;
    }
    return this.jdField_a_of_type_AndroidOsBundle.getInt("expect_fragment_count", 1);
  }
  
  public boolean c()
  {
    return ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)) || ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) || ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource));
  }
  
  public boolean d()
  {
    return ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) || ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource;
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeGifSource;
  }
  
  public boolean g()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return false;
    }
    return this.jdField_a_of_type_AndroidOsBundle.getBoolean("enable_hw_encode");
  }
  
  public boolean h()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return true;
    }
    return this.jdField_a_of_type_AndroidOsBundle.getBoolean("extra_enable_revert", true);
  }
  
  public boolean i()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return true;
    }
    return this.jdField_a_of_type_AndroidOsBundle.getBoolean("extra_enable_slow", true);
  }
  
  public String toString()
  {
    return "EditVideoParams{mBusinessId=" + this.jdField_a_of_type_Int + ", mEnableMasks=" + this.b + ", mEditSource=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource + ", entranceType=" + b() + ", mExtra=" + this.jdField_a_of_type_AndroidOsBundle + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource, paramInt);
    paramParcel.writeBundle(this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoParams
 * JD-Core Version:    0.7.0.1
 */