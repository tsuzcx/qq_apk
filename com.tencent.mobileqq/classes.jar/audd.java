import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;

public final class audd
  implements Parcelable.Creator<MsgBackupUserData>
{
  public MsgBackupUserData a(Parcel paramParcel)
  {
    return new MsgBackupUserData(paramParcel);
  }
  
  public MsgBackupUserData[] a(int paramInt)
  {
    return new MsgBackupUserData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     audd
 * JD-Core Version:    0.7.0.1
 */