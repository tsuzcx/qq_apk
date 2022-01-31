import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ocr.data.TranslateResult.Record;

public final class aucm
  implements Parcelable.Creator<TranslateResult.Record>
{
  public TranslateResult.Record a(Parcel paramParcel)
  {
    return new TranslateResult.Record(paramParcel);
  }
  
  public TranslateResult.Record[] a(int paramInt)
  {
    return new TranslateResult.Record[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aucm
 * JD-Core Version:    0.7.0.1
 */