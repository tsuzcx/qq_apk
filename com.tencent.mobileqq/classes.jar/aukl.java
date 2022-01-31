import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukl
  extends auky
{
  public aukl()
  {
    this.a = 3;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramaukm = (EmoticonTab)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.epId = paramCursor.getString(paramCursor.getColumnIndex("epId"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("aioHave")))
      {
        paramBoolean = true;
        paramaukm.aioHave = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("kandianHave"))) {
          break label92;
        }
      }
      label92:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramaukm.kandianHave = paramBoolean;
        return paramaukm;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("epId");
    if (i == -1) {
      paramaukx.a(new NoColumnError("epId", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("aioHave");
      if (i != -1) {
        break;
      }
      paramaukx.a(new NoColumnError("aioHave", Boolean.TYPE));
      i = paramCursor.getColumnIndex("kandianHave");
      if (i != -1) {
        break label245;
      }
      paramaukx.a(new NoColumnError("kandianHave", Boolean.TYPE));
      return paramaukm;
      paramaukm.epId = paramCursor.getString(i);
    }
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramaukm.aioHave = paramBoolean;
      break;
    }
    label245:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramaukm.kandianHave = paramBoolean;
      return paramaukm;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,epId TEXT UNIQUE ,aioHave INTEGER ,kandianHave INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (EmoticonTab)paramaukm;
    paramContentValues.put("epId", paramaukm.epId);
    paramContentValues.put("aioHave", Boolean.valueOf(paramaukm.aioHave));
    paramContentValues.put("kandianHave", Boolean.valueOf(paramaukm.kandianHave));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukl
 * JD-Core Version:    0.7.0.1
 */