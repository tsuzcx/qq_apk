import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.troop.data.InviteToGroupInfo.UinInfo;

public final class bbpa
  implements Parcelable.Creator<InviteToGroupInfo.UinInfo>
{
  public InviteToGroupInfo.UinInfo a(Parcel paramParcel)
  {
    return new InviteToGroupInfo.UinInfo(paramParcel);
  }
  
  public InviteToGroupInfo.UinInfo[] a(int paramInt)
  {
    return new InviteToGroupInfo.UinInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpa
 * JD-Core Version:    0.7.0.1
 */