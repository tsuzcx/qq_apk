import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.CoverCacheData.PackageInfo;

public final class anbw
  implements Parcelable.Creator
{
  public CoverCacheData.PackageInfo a(Parcel paramParcel)
  {
    CoverCacheData.PackageInfo localPackageInfo = new CoverCacheData.PackageInfo();
    if (paramParcel != null)
    {
      localPackageInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
      localPackageInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
      localPackageInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
      localPackageInfo.jdField_a_of_type_Int = paramParcel.readInt();
      localPackageInfo.jdField_b_of_type_Int = paramParcel.readInt();
      localPackageInfo.jdField_c_of_type_Int = paramParcel.readInt();
      localPackageInfo.d = paramParcel.readString();
    }
    return localPackageInfo;
  }
  
  public CoverCacheData.PackageInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbw
 * JD-Core Version:    0.7.0.1
 */