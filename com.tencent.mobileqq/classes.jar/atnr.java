import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atnr
  extends atna
{
  public atnr()
  {
    this.a = 3;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    paramatmo = (TroopAssistantData)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramatmo.lastmsgtime = paramCursor.getLong(paramCursor.getColumnIndex("lastmsgtime"));
      paramatmo.lastdrafttime = paramCursor.getLong(paramCursor.getColumnIndex("lastdrafttime"));
      return paramatmo;
    }
    int i = paramCursor.getColumnIndex("troopUin");
    if (i == -1)
    {
      paramatmz.a(new NoColumnError("troopUin", String.class));
      i = paramCursor.getColumnIndex("lastmsgtime");
      if (i != -1) {
        break label187;
      }
      paramatmz.a(new NoColumnError("lastmsgtime", Long.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("lastdrafttime");
      if (i != -1) {
        break label202;
      }
      paramatmz.a(new NoColumnError("lastdrafttime", Long.TYPE));
      return paramatmo;
      paramatmo.troopUin = paramCursor.getString(i);
      break;
      label187:
      paramatmo.lastmsgtime = paramCursor.getLong(i);
    }
    label202:
    paramatmo.lastdrafttime = paramCursor.getLong(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopUin TEXT UNIQUE ,lastmsgtime INTEGER ,lastdrafttime INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (TroopAssistantData)paramatmo;
    paramContentValues.put("troopUin", paramatmo.troopUin);
    paramContentValues.put("lastmsgtime", Long.valueOf(paramatmo.lastmsgtime));
    paramContentValues.put("lastdrafttime", Long.valueOf(paramatmo.lastdrafttime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atnr
 * JD-Core Version:    0.7.0.1
 */