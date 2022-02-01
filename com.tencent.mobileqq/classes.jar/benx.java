import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.together.writetogether.data.EditUserHistory;

public final class benx
  implements Parcelable.Creator<EditUserHistory>
{
  public EditUserHistory a(Parcel paramParcel)
  {
    return new EditUserHistory(paramParcel);
  }
  
  public EditUserHistory[] a(int paramInt)
  {
    return new EditUserHistory[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     benx
 * JD-Core Version:    0.7.0.1
 */