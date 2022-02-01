import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil.UpdateFriendStatusItem;

public final class anwx
  implements Parcelable.Creator<FriendsStatusUtil.UpdateFriendStatusItem>
{
  public FriendsStatusUtil.UpdateFriendStatusItem a(Parcel paramParcel)
  {
    return new FriendsStatusUtil.UpdateFriendStatusItem(paramParcel);
  }
  
  public FriendsStatusUtil.UpdateFriendStatusItem[] a(int paramInt)
  {
    return new FriendsStatusUtil.UpdateFriendStatusItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anwx
 * JD-Core Version:    0.7.0.1
 */