import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.qq.im.ae.SessionWrap;

public final class bnes
  implements Parcelable.Creator<SessionWrap>
{
  public SessionWrap a(Parcel paramParcel)
  {
    return new SessionWrap(paramParcel);
  }
  
  public SessionWrap[] a(int paramInt)
  {
    return new SessionWrap[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnes
 * JD-Core Version:    0.7.0.1
 */