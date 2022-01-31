import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.intervideo.IVPluginInfo;

public final class arei
  implements Parcelable.Creator<IVPluginInfo>
{
  public IVPluginInfo a(Parcel paramParcel)
  {
    return new IVPluginInfo(paramParcel);
  }
  
  public IVPluginInfo[] a(int paramInt)
  {
    return new IVPluginInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arei
 * JD-Core Version:    0.7.0.1
 */