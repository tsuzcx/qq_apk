import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.qq.im.ptv.LWMotionEvent;

public final class bjot
  implements Parcelable.Creator<LWMotionEvent>
{
  public LWMotionEvent a(Parcel paramParcel)
  {
    return new LWMotionEvent(paramParcel, null);
  }
  
  public LWMotionEvent[] a(int paramInt)
  {
    return new LWMotionEvent[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjot
 * JD-Core Version:    0.7.0.1
 */