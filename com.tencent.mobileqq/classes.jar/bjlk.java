import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.WeishiFeedCommInfo;

public final class bjlk
  implements Parcelable.Creator<WeishiFeedCommInfo>
{
  public WeishiFeedCommInfo a(Parcel paramParcel)
  {
    return new WeishiFeedCommInfo(paramParcel);
  }
  
  public WeishiFeedCommInfo[] a(int paramInt)
  {
    return new WeishiFeedCommInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjlk
 * JD-Core Version:    0.7.0.1
 */