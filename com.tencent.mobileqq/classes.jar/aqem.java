import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.ExtendFriendInfo;

public final class aqem
  implements Parcelable.Creator<ExtendFriendProfileEditFragment.ExtendFriendInfo>
{
  public ExtendFriendProfileEditFragment.ExtendFriendInfo a(Parcel paramParcel)
  {
    return new ExtendFriendProfileEditFragment.ExtendFriendInfo(paramParcel);
  }
  
  public ExtendFriendProfileEditFragment.ExtendFriendInfo[] a(int paramInt)
  {
    return new ExtendFriendProfileEditFragment.ExtendFriendInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqem
 * JD-Core Version:    0.7.0.1
 */