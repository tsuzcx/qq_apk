import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelZan;

public final class aylq
  implements Parcelable.Creator<PersonalityLabelZan>
{
  public PersonalityLabelZan a(Parcel paramParcel)
  {
    return new PersonalityLabelZan(paramParcel);
  }
  
  public PersonalityLabelZan[] a(int paramInt)
  {
    return new PersonalityLabelZan[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aylq
 * JD-Core Version:    0.7.0.1
 */