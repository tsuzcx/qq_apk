import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.troop.data.JoinGroupInfo;

public final class bbpb
  implements Parcelable.Creator<JoinGroupInfo>
{
  public JoinGroupInfo a(Parcel paramParcel)
  {
    return new JoinGroupInfo(paramParcel);
  }
  
  public JoinGroupInfo[] a(int paramInt)
  {
    return new JoinGroupInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpb
 * JD-Core Version:    0.7.0.1
 */