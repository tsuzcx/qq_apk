import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;

public final class beqz
  implements Parcelable.Creator<EntryModel>
{
  public EntryModel a(Parcel paramParcel)
  {
    return new EntryModel(paramParcel, null);
  }
  
  public EntryModel[] a(int paramInt)
  {
    return new EntryModel[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beqz
 * JD-Core Version:    0.7.0.1
 */