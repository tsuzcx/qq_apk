import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.remote.SendMsg;

public final class bjqt
  implements Parcelable.Creator<SendMsg>
{
  public SendMsg a(Parcel paramParcel)
  {
    return new SendMsg(paramParcel);
  }
  
  public SendMsg[] a(int paramInt)
  {
    return new SendMsg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjqt
 * JD-Core Version:    0.7.0.1
 */