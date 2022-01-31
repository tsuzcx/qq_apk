import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukn
  extends aula
{
  public aukn()
  {
    this.a = 3;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramauko = (EmoticonTab)paramauko;
    if (paramaukz == null)
    {
      paramauko.epId = paramCursor.getString(paramCursor.getColumnIndex("epId"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("aioHave")))
      {
        paramBoolean = true;
        paramauko.aioHave = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("kandianHave"))) {
          break label92;
        }
      }
      label92:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramauko.kandianHave = paramBoolean;
        return paramauko;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("epId");
    if (i == -1) {
      paramaukz.a(new NoColumnError("epId", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("aioHave");
      if (i != -1) {
        break;
      }
      paramaukz.a(new NoColumnError("aioHave", Boolean.TYPE));
      i = paramCursor.getColumnIndex("kandianHave");
      if (i != -1) {
        break label245;
      }
      paramaukz.a(new NoColumnError("kandianHave", Boolean.TYPE));
      return paramauko;
      paramauko.epId = paramCursor.getString(i);
    }
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramauko.aioHave = paramBoolean;
      break;
    }
    label245:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramauko.kandianHave = paramBoolean;
      return paramauko;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,epId TEXT UNIQUE ,aioHave INTEGER ,kandianHave INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (EmoticonTab)paramauko;
    paramContentValues.put("epId", paramauko.epId);
    paramContentValues.put("aioHave", Boolean.valueOf(paramauko.aioHave));
    paramContentValues.put("kandianHave", Boolean.valueOf(paramauko.kandianHave));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukn
 * JD-Core Version:    0.7.0.1
 */