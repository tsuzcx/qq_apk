import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ocr.data.OcrConfig;

public final class avtl
  implements Parcelable.Creator<OcrConfig>
{
  public OcrConfig a(Parcel paramParcel)
  {
    return new OcrConfig(paramParcel);
  }
  
  public OcrConfig[] a(int paramInt)
  {
    return new OcrConfig[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avtl
 * JD-Core Version:    0.7.0.1
 */