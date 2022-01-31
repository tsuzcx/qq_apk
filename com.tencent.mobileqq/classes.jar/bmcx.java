import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.qq.im.setting.QIMSelectEffectParams;

public final class bmcx
  implements Parcelable.Creator<QIMSelectEffectParams>
{
  public QIMSelectEffectParams a(Parcel paramParcel)
  {
    return new QIMSelectEffectParams(paramParcel);
  }
  
  public QIMSelectEffectParams[] a(int paramInt)
  {
    return new QIMSelectEffectParams[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmcx
 * JD-Core Version:    0.7.0.1
 */