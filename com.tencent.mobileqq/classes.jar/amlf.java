import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoAttribute;

public final class amlf
  implements Parcelable.Creator<SosoInterface.SosoAttribute>
{
  public SosoInterface.SosoAttribute a(Parcel paramParcel)
  {
    return new SosoInterface.SosoAttribute(paramParcel);
  }
  
  public SosoInterface.SosoAttribute[] a(int paramInt)
  {
    return new SosoInterface.SosoAttribute[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amlf
 * JD-Core Version:    0.7.0.1
 */