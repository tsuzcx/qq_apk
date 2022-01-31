import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ocr.data.TranslateResult;

public final class avxy
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avxy
 * JD-Core Version:    0.7.0.1
 */