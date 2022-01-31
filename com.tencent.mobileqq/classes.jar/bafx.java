import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.teamwork.DocsGrayTipsInfo;

public final class bafx
  implements Parcelable.Creator<DocsGrayTipsInfo>
{
  public DocsGrayTipsInfo a(Parcel paramParcel)
  {
    return new DocsGrayTipsInfo(paramParcel);
  }
  
  public DocsGrayTipsInfo[] a(int paramInt)
  {
    return new DocsGrayTipsInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafx
 * JD-Core Version:    0.7.0.1
 */