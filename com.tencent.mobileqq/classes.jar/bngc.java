import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.remote.RecvMsg;

public final class bngc
  implements Parcelable.Creator<RecvMsg>
{
  public RecvMsg a(Parcel paramParcel)
  {
    return new RecvMsg(paramParcel);
  }
  
  public RecvMsg[] a(int paramInt)
  {
    return new RecvMsg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngc
 * JD-Core Version:    0.7.0.1
 */