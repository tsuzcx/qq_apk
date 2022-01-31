import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.CoverCacheData.GameCoverInfo;

public final class ameg
  implements Parcelable.Creator
{
  public CoverCacheData.GameCoverInfo a(Parcel paramParcel)
  {
    CoverCacheData.GameCoverInfo localGameCoverInfo = new CoverCacheData.GameCoverInfo();
    if (paramParcel != null)
    {
      localGameCoverInfo.jdField_a_of_type_Double = paramParcel.readDouble();
      localGameCoverInfo.jdField_b_of_type_Double = paramParcel.readDouble();
      localGameCoverInfo.c = paramParcel.readDouble();
      localGameCoverInfo.d = paramParcel.readDouble();
      localGameCoverInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
      localGameCoverInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
      localGameCoverInfo.jdField_a_of_type_Int = paramParcel.readInt();
    }
    return localGameCoverInfo;
  }
  
  public CoverCacheData.GameCoverInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ameg
 * JD-Core Version:    0.7.0.1
 */