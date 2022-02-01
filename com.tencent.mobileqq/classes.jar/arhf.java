import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.IntimateInfo.CommonTroopInfo;

public final class arhf
  implements Parcelable.Creator<IntimateInfo.CommonTroopInfo>
{
  public IntimateInfo.CommonTroopInfo a(Parcel paramParcel)
  {
    return new IntimateInfo.CommonTroopInfo(paramParcel);
  }
  
  public IntimateInfo.CommonTroopInfo[] a(int paramInt)
  {
    return new IntimateInfo.CommonTroopInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arhf
 * JD-Core Version:    0.7.0.1
 */