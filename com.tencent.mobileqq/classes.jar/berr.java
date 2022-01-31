import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;

public final class berr
  implements Parcelable.Creator<ShareChatModel>
{
  public ShareChatModel a(Parcel paramParcel)
  {
    return new ShareChatModel(paramParcel, null);
  }
  
  public ShareChatModel[] a(int paramInt)
  {
    return new ShareChatModel[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     berr
 * JD-Core Version:    0.7.0.1
 */