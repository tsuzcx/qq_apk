import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.ARRelationShipAIOMsg;

public final class aotx
  implements Parcelable.Creator<ARRelationShipAIOMsg>
{
  public ARRelationShipAIOMsg a(Parcel paramParcel)
  {
    return new ARRelationShipAIOMsg(paramParcel);
  }
  
  public ARRelationShipAIOMsg[] a(int paramInt)
  {
    return new ARRelationShipAIOMsg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aotx
 * JD-Core Version:    0.7.0.1
 */