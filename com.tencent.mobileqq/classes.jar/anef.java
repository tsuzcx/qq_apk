import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.widget.RedTouchExtendButton.RedInfo;

public final class anef
  implements Parcelable.Creator
{
  public RedTouchExtendButton.RedInfo a(Parcel paramParcel)
  {
    return new RedTouchExtendButton.RedInfo(paramParcel);
  }
  
  public RedTouchExtendButton.RedInfo[] a(int paramInt)
  {
    return new RedTouchExtendButton.RedInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anef
 * JD-Core Version:    0.7.0.1
 */