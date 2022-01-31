import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;

public final class ayeq
  implements Parcelable.Creator<TeamWorkFileImportInfo>
{
  public TeamWorkFileImportInfo a(Parcel paramParcel)
  {
    return new TeamWorkFileImportInfo(paramParcel);
  }
  
  public TeamWorkFileImportInfo[] a(int paramInt)
  {
    return new TeamWorkFileImportInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayeq
 * JD-Core Version:    0.7.0.1
 */