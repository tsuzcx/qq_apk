import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.plugin.PluginRecord;

public final class anep
  implements Parcelable.Creator
{
  public PluginRecord a(Parcel paramParcel)
  {
    return new PluginRecord(paramParcel);
  }
  
  public PluginRecord[] a(int paramInt)
  {
    return new PluginRecord[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anep
 * JD-Core Version:    0.7.0.1
 */