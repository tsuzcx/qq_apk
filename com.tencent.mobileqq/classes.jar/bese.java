import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.model.PreCacheInfo;

public final class bese
  implements Parcelable.Creator<PreCacheInfo>
{
  public PreCacheInfo a(Parcel paramParcel)
  {
    PreCacheInfo localPreCacheInfo = new PreCacheInfo();
    localPreCacheInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localPreCacheInfo.b = paramParcel.readString();
    localPreCacheInfo.jdField_a_of_type_Long = paramParcel.readLong();
    return localPreCacheInfo;
  }
  
  public PreCacheInfo[] a(int paramInt)
  {
    return new PreCacheInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bese
 * JD-Core Version:    0.7.0.1
 */