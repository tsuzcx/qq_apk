import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atmn
  extends atna
{
  public atmn()
  {
    this.a = 3;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramatmo = (EmoticonTab)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.epId = paramCursor.getString(paramCursor.getColumnIndex("epId"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("aioHave")))
      {
        paramBoolean = true;
        paramatmo.aioHave = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("kandianHave"))) {
          break label92;
        }
      }
      label92:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramatmo.kandianHave = paramBoolean;
        return paramatmo;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("epId");
    if (i == -1) {
      paramatmz.a(new NoColumnError("epId", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("aioHave");
      if (i != -1) {
        break;
      }
      paramatmz.a(new NoColumnError("aioHave", Boolean.TYPE));
      i = paramCursor.getColumnIndex("kandianHave");
      if (i != -1) {
        break label245;
      }
      paramatmz.a(new NoColumnError("kandianHave", Boolean.TYPE));
      return paramatmo;
      paramatmo.epId = paramCursor.getString(i);
    }
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramatmo.aioHave = paramBoolean;
      break;
    }
    label245:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramatmo.kandianHave = paramBoolean;
      return paramatmo;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,epId TEXT UNIQUE ,aioHave INTEGER ,kandianHave INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (EmoticonTab)paramatmo;
    paramContentValues.put("epId", paramatmo.epId);
    paramContentValues.put("aioHave", Boolean.valueOf(paramatmo.aioHave));
    paramContentValues.put("kandianHave", Boolean.valueOf(paramatmo.kandianHave));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atmn
 * JD-Core Version:    0.7.0.1
 */