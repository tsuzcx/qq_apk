import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import java.util.Comparator;

public class azdo
  implements Comparator<PersonalityLabelInfo>
{
  public azdo(PersonalityLabel paramPersonalityLabel) {}
  
  public int a(PersonalityLabelInfo paramPersonalityLabelInfo1, PersonalityLabelInfo paramPersonalityLabelInfo2)
  {
    return -(int)(paramPersonalityLabelInfo1.modTime - paramPersonalityLabelInfo2.modTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdo
 * JD-Core Version:    0.7.0.1
 */