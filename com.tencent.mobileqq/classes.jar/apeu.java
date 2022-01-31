import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;

public final class apeu
  implements Parcelable.Creator<ForwardFileInfo>
{
  public ForwardFileInfo a(Parcel paramParcel)
  {
    return new ForwardFileInfo(paramParcel, null);
  }
  
  public ForwardFileInfo[] a(int paramInt)
  {
    return new ForwardFileInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apeu
 * JD-Core Version:    0.7.0.1
 */