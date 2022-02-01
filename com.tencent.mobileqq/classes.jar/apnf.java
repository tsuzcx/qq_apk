import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;
import java.util.Comparator;

public class apnf
  implements Comparator<ColorNote>
{
  public apnf(ColorNoteSettingFragment paramColorNoteSettingFragment) {}
  
  public int a(ColorNote paramColorNote1, ColorNote paramColorNote2)
  {
    return -(int)(paramColorNote1.getTime() - paramColorNote2.getTime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apnf
 * JD-Core Version:    0.7.0.1
 */