import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;

public final class atwz
  implements Parcelable.Creator<PadFaceAd>
{
  public PadFaceAd a(Parcel paramParcel)
  {
    return new PadFaceAd(paramParcel);
  }
  
  public PadFaceAd[] a(int paramInt)
  {
    return new PadFaceAd[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atwz
 * JD-Core Version:    0.7.0.1
 */