import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.qq.im.story.SessionWrap;

public final class bhzm
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhzm
 * JD-Core Version:    0.7.0.1
 */