import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.model.UserAuthScope;

public final class bdnk
  implements Parcelable.Creator<UserAuthScope>
{
  public UserAuthScope a(Parcel paramParcel)
  {
    return new UserAuthScope(paramParcel);
  }
  
  public UserAuthScope[] a(int paramInt)
  {
    return new UserAuthScope[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdnk
 * JD-Core Version:    0.7.0.1
 */