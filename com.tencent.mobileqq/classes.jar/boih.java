import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.qq.im.capture.data.TemplateData;

public final class boih
  implements Parcelable.Creator<TemplateData>
{
  public TemplateData a(Parcel paramParcel)
  {
    return new TemplateData(paramParcel);
  }
  
  public TemplateData[] a(int paramInt)
  {
    return new TemplateData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boih
 * JD-Core Version:    0.7.0.1
 */