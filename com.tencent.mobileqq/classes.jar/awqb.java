import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;

public final class awqb
  implements Parcelable.Creator<PersonalityLabelPhoto>
{
  public PersonalityLabelPhoto a(Parcel paramParcel)
  {
    return new PersonalityLabelPhoto(paramParcel);
  }
  
  public PersonalityLabelPhoto[] a(int paramInt)
  {
    return new PersonalityLabelPhoto[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awqb
 * JD-Core Version:    0.7.0.1
 */