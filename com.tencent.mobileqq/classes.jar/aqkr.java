import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.businessCard.data.BusinessCard;

public final class aqkr
  implements Parcelable.Creator<BusinessCard>
{
  public BusinessCard a(Parcel paramParcel)
  {
    return new BusinessCard(paramParcel);
  }
  
  public BusinessCard[] a(int paramInt)
  {
    return new BusinessCard[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqkr
 * JD-Core Version:    0.7.0.1
 */