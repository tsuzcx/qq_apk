import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.qq.im.capture.text.TextParcelData;

public final class blyy
  implements Parcelable.Creator<TextParcelData>
{
  public TextParcelData a(Parcel paramParcel)
  {
    return new TextParcelData(paramParcel);
  }
  
  public TextParcelData[] a(int paramInt)
  {
    return new TextParcelData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blyy
 * JD-Core Version:    0.7.0.1
 */