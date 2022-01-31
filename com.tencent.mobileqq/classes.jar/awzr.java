import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.service.lbs.BusinessBuff;

public final class awzr
  implements Parcelable.Creator<BusinessBuff>
{
  public BusinessBuff a(Parcel paramParcel)
  {
    return new BusinessBuff(paramParcel);
  }
  
  public BusinessBuff[] a(int paramInt)
  {
    return new BusinessBuff[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awzr
 * JD-Core Version:    0.7.0.1
 */