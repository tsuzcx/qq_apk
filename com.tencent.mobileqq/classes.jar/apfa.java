import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;

public final class apfa
  implements Parcelable.Creator<WeiYunFileInfo>
{
  public WeiYunFileInfo a(Parcel paramParcel)
  {
    return new WeiYunFileInfo(paramParcel);
  }
  
  public WeiYunFileInfo[] a(int paramInt)
  {
    return new WeiYunFileInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apfa
 * JD-Core Version:    0.7.0.1
 */