import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import java.util.Comparator;

public class awpc
  implements Comparator<PersonalityLabelInfo>
{
  public awpc(PersonalityLabel paramPersonalityLabel) {}
  
  public int a(PersonalityLabelInfo paramPersonalityLabelInfo1, PersonalityLabelInfo paramPersonalityLabelInfo2)
  {
    return -(int)(paramPersonalityLabelInfo1.modTime - paramPersonalityLabelInfo2.modTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awpc
 * JD-Core Version:    0.7.0.1
 */