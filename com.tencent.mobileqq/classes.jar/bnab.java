import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.model.CoverCacheData.GameCoverInfo;
import cooperation.qzone.model.CoverCacheData.PackageInfo;

public final class bnab
  implements Parcelable.Creator<CoverCacheData>
{
  public CoverCacheData a(Parcel paramParcel)
  {
    CoverCacheData localCoverCacheData = new CoverCacheData();
    if (paramParcel != null)
    {
      localCoverCacheData.jdField_a_of_type_Long = paramParcel.readLong();
      localCoverCacheData.jdField_a_of_type_JavaLangString = paramParcel.readString();
      localCoverCacheData.jdField_b_of_type_JavaLangString = paramParcel.readString();
      localCoverCacheData.jdField_c_of_type_JavaLangString = paramParcel.readString();
      localCoverCacheData.jdField_a_of_type_JavaUtilHashMap = paramParcel.readHashMap(getClass().getClassLoader());
      localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo = ((CoverCacheData.PackageInfo)paramParcel.readParcelable(getClass().getClassLoader()));
      localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$GameCoverInfo = ((CoverCacheData.GameCoverInfo)paramParcel.readParcelable(getClass().getClassLoader()));
      localCoverCacheData.jdField_a_of_type_JavaUtilArrayList = paramParcel.readArrayList(getClass().getClassLoader());
      localCoverCacheData.jdField_a_of_type_Int = paramParcel.readInt();
      localCoverCacheData.jdField_b_of_type_JavaUtilHashMap = paramParcel.readHashMap(getClass().getClassLoader());
      localCoverCacheData.jdField_c_of_type_JavaUtilHashMap = paramParcel.readHashMap(getClass().getClassLoader());
      localCoverCacheData.jdField_b_of_type_Int = paramParcel.readInt();
    }
    return localCoverCacheData;
  }
  
  public CoverCacheData[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnab
 * JD-Core Version:    0.7.0.1
 */