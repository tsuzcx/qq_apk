import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.WeishiShareDataInfo;

public final class bhfx
  implements Parcelable.Creator<WeishiShareDataInfo>
{
  public WeishiShareDataInfo a(Parcel paramParcel)
  {
    return new WeishiShareDataInfo(paramParcel);
  }
  
  public WeishiShareDataInfo[] a(int paramInt)
  {
    return new WeishiShareDataInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhfx
 * JD-Core Version:    0.7.0.1
 */