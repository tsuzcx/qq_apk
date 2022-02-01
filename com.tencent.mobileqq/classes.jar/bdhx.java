import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.together.writetogether.data.OpenDocParam;

public final class bdhx
  implements Parcelable.Creator<OpenDocParam>
{
  public OpenDocParam a(Parcel paramParcel)
  {
    return new OpenDocParam(paramParcel);
  }
  
  public OpenDocParam[] a(int paramInt)
  {
    return new OpenDocParam[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdhx
 * JD-Core Version:    0.7.0.1
 */