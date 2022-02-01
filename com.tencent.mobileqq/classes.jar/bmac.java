import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qqdataline.ipc.MessageRecordParcel;

public final class bmac
  implements Parcelable.Creator<MessageRecordParcel>
{
  public MessageRecordParcel a(Parcel paramParcel)
  {
    return MessageRecordParcel.a(paramParcel);
  }
  
  public MessageRecordParcel[] a(int paramInt)
  {
    return new MessageRecordParcel[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmac
 * JD-Core Version:    0.7.0.1
 */