import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import java.util.Comparator;

public class azpl
  implements Comparator<PersonalityLabelInfo>
{
  public azpl(PersonalityLabel paramPersonalityLabel) {}
  
  public int a(PersonalityLabelInfo paramPersonalityLabelInfo1, PersonalityLabelInfo paramPersonalityLabelInfo2)
  {
    return -(int)(paramPersonalityLabelInfo1.modTime - paramPersonalityLabelInfo2.modTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpl
 * JD-Core Version:    0.7.0.1
 */