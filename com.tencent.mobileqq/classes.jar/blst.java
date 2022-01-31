import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.qq.im.capture.data.QIMBeautyItem;

public final class blst
  implements Parcelable.Creator<QIMBeautyItem>
{
  public QIMBeautyItem a(Parcel paramParcel)
  {
    return new QIMBeautyItem(paramParcel);
  }
  
  public QIMBeautyItem[] a(int paramInt)
  {
    return new QIMBeautyItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blst
 * JD-Core Version:    0.7.0.1
 */