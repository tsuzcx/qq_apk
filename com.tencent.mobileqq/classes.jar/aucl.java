import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ocr.data.TranslateResult;

public final class aucl
  implements Parcelable.Creator<TranslateResult>
{
  public TranslateResult a(Parcel paramParcel)
  {
    return new TranslateResult(paramParcel);
  }
  
  public TranslateResult[] a(int paramInt)
  {
    return new TranslateResult[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aucl
 * JD-Core Version:    0.7.0.1
 */