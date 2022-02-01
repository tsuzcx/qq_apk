import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.redtouch.RedDisplayInfo;
import com.tencent.mobileqq.redtouch.RedTypeInfo;

public final class bbas
  implements Parcelable.Creator<RedDisplayInfo>
{
  public RedDisplayInfo a(Parcel paramParcel)
  {
    RedDisplayInfo localRedDisplayInfo = new RedDisplayInfo();
    localRedDisplayInfo.a = paramParcel.readArrayList(RedTypeInfo.class.getClassLoader());
    RedDisplayInfo.a(localRedDisplayInfo, (RedTypeInfo)paramParcel.readSerializable());
    return localRedDisplayInfo;
  }
  
  public RedDisplayInfo[] a(int paramInt)
  {
    return new RedDisplayInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbas
 * JD-Core Version:    0.7.0.1
 */