import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.event.ExoticEvent;

public final class blxp
  implements Parcelable.Creator<ExoticEvent>
{
  public ExoticEvent a(Parcel paramParcel)
  {
    return new ExoticEvent(paramParcel, null);
  }
  
  public ExoticEvent[] a(int paramInt)
  {
    return new ExoticEvent[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blxp
 * JD-Core Version:    0.7.0.1
 */