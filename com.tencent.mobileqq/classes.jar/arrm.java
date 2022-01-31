import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;

public final class arrm
  implements Parcelable.Creator<ListenTogetherSession>
{
  public ListenTogetherSession a(Parcel paramParcel)
  {
    return new ListenTogetherSession(paramParcel, null);
  }
  
  public ListenTogetherSession[] a(int paramInt)
  {
    return new ListenTogetherSession[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arrm
 * JD-Core Version:    0.7.0.1
 */