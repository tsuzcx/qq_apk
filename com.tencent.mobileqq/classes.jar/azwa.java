import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;

public final class azwa
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azwa
 * JD-Core Version:    0.7.0.1
 */