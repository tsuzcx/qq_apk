import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.AutoReplyText;

public final class args
  implements Parcelable.Creator<AutoReplyText>
{
  public AutoReplyText a(Parcel paramParcel)
  {
    return new AutoReplyText(paramParcel);
  }
  
  public AutoReplyText[] a(int paramInt)
  {
    return new AutoReplyText[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     args
 * JD-Core Version:    0.7.0.1
 */