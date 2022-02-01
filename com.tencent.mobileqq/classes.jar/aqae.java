import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;

public final class aqae
  implements Parcelable.Creator<CardOCRInfo>
{
  public CardOCRInfo a(Parcel paramParcel)
  {
    return new CardOCRInfo(paramParcel);
  }
  
  public CardOCRInfo[] a(int paramInt)
  {
    return new CardOCRInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqae
 * JD-Core Version:    0.7.0.1
 */