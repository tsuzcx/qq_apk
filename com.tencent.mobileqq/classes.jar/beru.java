import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;

public final class beru
  implements Parcelable.Creator<LoginInfo>
{
  public LoginInfo a(Parcel paramParcel)
  {
    LoginInfo localLoginInfo = new LoginInfo();
    LoginInfo.a(localLoginInfo, paramParcel.readInt());
    LoginInfo.a(localLoginInfo, paramParcel.readString());
    LoginInfo.b(localLoginInfo, paramParcel.readString());
    LoginInfo.c(localLoginInfo, paramParcel.readString());
    LoginInfo.d(localLoginInfo, paramParcel.readString());
    LoginInfo.a(localLoginInfo, paramParcel.createByteArray());
    LoginInfo.e(localLoginInfo, paramParcel.readString());
    LoginInfo.f(localLoginInfo, paramParcel.readString());
    return localLoginInfo;
  }
  
  public LoginInfo[] a(int paramInt)
  {
    return new LoginInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beru
 * JD-Core Version:    0.7.0.1
 */