import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.DiscoverTab;

public final class bhel
  implements Parcelable.Creator<DiscoverTab>
{
  public DiscoverTab a(Parcel paramParcel)
  {
    return new DiscoverTab(paramParcel);
  }
  
  public DiscoverTab[] a(int paramInt)
  {
    return new DiscoverTab[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhel
 * JD-Core Version:    0.7.0.1
 */