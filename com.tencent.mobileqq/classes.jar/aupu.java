import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment.MemberInfo;

public final class aupu
  implements Parcelable.Creator<ReceiptMessageReadMemberListFragment.MemberInfo>
{
  public ReceiptMessageReadMemberListFragment.MemberInfo a(Parcel paramParcel)
  {
    return new ReceiptMessageReadMemberListFragment.MemberInfo(paramParcel);
  }
  
  public ReceiptMessageReadMemberListFragment.MemberInfo[] a(int paramInt)
  {
    return new ReceiptMessageReadMemberListFragment.MemberInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aupu
 * JD-Core Version:    0.7.0.1
 */