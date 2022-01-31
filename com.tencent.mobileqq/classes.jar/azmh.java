import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.troop.data.InviteToGroupInfo;

public final class azmh
  implements Parcelable.Creator<InviteToGroupInfo>
{
  public InviteToGroupInfo a(Parcel paramParcel)
  {
    return new InviteToGroupInfo(paramParcel);
  }
  
  public InviteToGroupInfo[] a(int paramInt)
  {
    return new InviteToGroupInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azmh
 * JD-Core Version:    0.7.0.1
 */