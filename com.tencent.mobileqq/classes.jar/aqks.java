import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.businessCard.data.CardMobileInfo;

public final class aqks
  implements Parcelable.Creator<CardMobileInfo>
{
  public CardMobileInfo a(Parcel paramParcel)
  {
    return new CardMobileInfo(paramParcel);
  }
  
  public CardMobileInfo[] a(int paramInt)
  {
    return new CardMobileInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqks
 * JD-Core Version:    0.7.0.1
 */