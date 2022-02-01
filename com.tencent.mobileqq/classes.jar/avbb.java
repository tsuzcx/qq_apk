import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpic.HotPicData;

public final class avbb
  implements Parcelable.Creator<HotPicData>
{
  public HotPicData a(Parcel paramParcel)
  {
    return new HotPicData(paramParcel);
  }
  
  public HotPicData[] a(int paramInt)
  {
    return new HotPicData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbb
 * JD-Core Version:    0.7.0.1
 */