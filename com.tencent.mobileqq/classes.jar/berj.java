import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry;

public final class berj
  implements Parcelable.Creator<ApiScopeEntry>
{
  public ApiScopeEntry a(Parcel paramParcel)
  {
    return new ApiScopeEntry(paramParcel);
  }
  
  public ApiScopeEntry[] a(int paramInt)
  {
    return new ApiScopeEntry[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     berj
 * JD-Core Version:    0.7.0.1
 */