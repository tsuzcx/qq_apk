import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;

public final class asji
  implements Parcelable.Creator<InterestTagInfo>
{
  public InterestTagInfo a(Parcel paramParcel)
  {
    return new InterestTagInfo(paramParcel);
  }
  
  public InterestTagInfo[] a(int paramInt)
  {
    return new InterestTagInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asji
 * JD-Core Version:    0.7.0.1
 */