import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qbar.QBarResult;

public final class bjuo
  implements Parcelable.Creator<QBarResult>
{
  public QBarResult a(Parcel paramParcel)
  {
    return new QBarResult(paramParcel);
  }
  
  public QBarResult[] a(int paramInt)
  {
    return new QBarResult[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjuo
 * JD-Core Version:    0.7.0.1
 */