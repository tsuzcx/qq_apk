import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo.MiniApp;

public final class aqco
  implements Parcelable.Creator<MiniAppRecommInfo.MiniApp>
{
  public MiniAppRecommInfo.MiniApp a(Parcel paramParcel)
  {
    return new MiniAppRecommInfo.MiniApp(paramParcel);
  }
  
  public MiniAppRecommInfo.MiniApp[] a(int paramInt)
  {
    return new MiniAppRecommInfo.MiniApp[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqco
 * JD-Core Version:    0.7.0.1
 */