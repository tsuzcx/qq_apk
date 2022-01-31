import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.DynamicPhotoData;

public final class amun
  implements Parcelable.Creator
{
  public DynamicPhotoData a(Parcel paramParcel)
  {
    return new DynamicPhotoData(paramParcel);
  }
  
  public DynamicPhotoData[] a(int paramInt)
  {
    return new DynamicPhotoData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amun
 * JD-Core Version:    0.7.0.1
 */