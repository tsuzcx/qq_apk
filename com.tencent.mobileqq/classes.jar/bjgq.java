import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.KingCardInfo;

public final class bjgq
  implements Parcelable.Creator<KingCardInfo>
{
  public KingCardInfo a(Parcel paramParcel)
  {
    return new KingCardInfo(paramParcel);
  }
  
  public KingCardInfo[] a(int paramInt)
  {
    return new KingCardInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjgq
 * JD-Core Version:    0.7.0.1
 */