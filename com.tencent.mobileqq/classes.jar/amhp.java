import android.content.Context;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class amhp
  implements amhm
{
  public void a(Context paramContext, ColorNote paramColorNote)
  {
    String str = paramColorNote.getSubType();
    Object localObject = str.split("-");
    if (localObject.length > 0) {
      str = localObject[0];
    }
    if (localObject.length > 1) {
      localObject = localObject[1];
    }
    paramColorNote = paramColorNote.getReserve();
    bgpw.a(paramContext, "", Long.parseLong(str), paramColorNote);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amhp
 * JD-Core Version:    0.7.0.1
 */