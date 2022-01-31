import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;

public final class awks
  implements Parcelable.Creator<PersonalityLabel>
{
  public PersonalityLabel a(Parcel paramParcel)
  {
    return new PersonalityLabel(paramParcel);
  }
  
  public PersonalityLabel[] a(int paramInt)
  {
    return new PersonalityLabel[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awks
 * JD-Core Version:    0.7.0.1
 */