import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.WeishiBottomButton;

public final class bhfr
  implements Parcelable.Creator<WeishiBottomButton>
{
  public WeishiBottomButton a(Parcel paramParcel)
  {
    return new WeishiBottomButton(paramParcel);
  }
  
  public WeishiBottomButton[] a(int paramInt)
  {
    return new WeishiBottomButton[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhfr
 * JD-Core Version:    0.7.0.1
 */