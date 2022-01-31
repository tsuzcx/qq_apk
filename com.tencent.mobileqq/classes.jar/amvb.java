import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.WeishiFeedInfo;

public final class amvb
  implements Parcelable.Creator
{
  public WeishiFeedInfo a(Parcel paramParcel)
  {
    return new WeishiFeedInfo(paramParcel);
  }
  
  public WeishiFeedInfo[] a(int paramInt)
  {
    return new WeishiFeedInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvb
 * JD-Core Version:    0.7.0.1
 */