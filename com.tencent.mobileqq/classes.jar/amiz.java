import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;
import java.util.Comparator;

public class amiz
  implements Comparator<ColorNote>
{
  public amiz(ColorNoteSettingFragment paramColorNoteSettingFragment) {}
  
  public int a(ColorNote paramColorNote1, ColorNote paramColorNote2)
  {
    return -(int)(paramColorNote1.getTime() - paramColorNote2.getTime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amiz
 * JD-Core Version:    0.7.0.1
 */