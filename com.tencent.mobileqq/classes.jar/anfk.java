import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.model.ARRelationShip;

public final class anfk
  implements Parcelable.Creator<ARRelationShip>
{
  public ARRelationShip a(Parcel paramParcel)
  {
    return new ARRelationShip(paramParcel);
  }
  
  public ARRelationShip[] a(int paramInt)
  {
    return new ARRelationShip[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfk
 * JD-Core Version:    0.7.0.1
 */