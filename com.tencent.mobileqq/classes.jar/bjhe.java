import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.WeishiFeedInfo;

public final class bjhe
  implements Parcelable.Creator<WeishiFeedInfo>
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjhe
 * JD-Core Version:    0.7.0.1
 */