import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.open.downloadnew.common.NoticeParam;

public final class bfqc
  implements Parcelable.Creator<NoticeParam>
{
  public NoticeParam a(Parcel paramParcel)
  {
    return new NoticeParam(paramParcel);
  }
  
  public NoticeParam[] a(int paramInt)
  {
    return new NoticeParam[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfqc
 * JD-Core Version:    0.7.0.1
 */