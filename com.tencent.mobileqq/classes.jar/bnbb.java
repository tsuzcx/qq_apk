import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.WeishiUserInfo;

public final class bnbb
  implements Parcelable.Creator<WeishiUserInfo>
{
  public WeishiUserInfo a(Parcel paramParcel)
  {
    WeishiUserInfo localWeishiUserInfo = new WeishiUserInfo();
    localWeishiUserInfo.uin = paramParcel.readLong();
    localWeishiUserInfo.nickName = paramParcel.readString();
    localWeishiUserInfo.logo = paramParcel.readString();
    return localWeishiUserInfo;
  }
  
  public WeishiUserInfo[] a(int paramInt)
  {
    return new WeishiUserInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbb
 * JD-Core Version:    0.7.0.1
 */