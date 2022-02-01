import android.content.Context;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class aqoy
  implements aqov
{
  public void launch(Context paramContext, ColorNote paramColorNote)
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
    bmaf.a(paramContext, "", Long.parseLong(str), paramColorNote);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqoy
 * JD-Core Version:    0.7.0.1
 */