import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.apollo.ApolloResManager.ApolloDressInfo;

public final class amoc
  implements Parcelable.Creator<ApolloResManager.ApolloDressInfo>
{
  public ApolloResManager.ApolloDressInfo a(Parcel paramParcel)
  {
    return new ApolloResManager.ApolloDressInfo(paramParcel);
  }
  
  public ApolloResManager.ApolloDressInfo[] a(int paramInt)
  {
    return new ApolloResManager.ApolloDressInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amoc
 * JD-Core Version:    0.7.0.1
 */