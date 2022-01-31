import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aulp
  extends auky
{
  public aulp()
  {
    this.a = 3;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    paramaukm = (TroopAssistantData)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramaukm.lastmsgtime = paramCursor.getLong(paramCursor.getColumnIndex("lastmsgtime"));
      paramaukm.lastdrafttime = paramCursor.getLong(paramCursor.getColumnIndex("lastdrafttime"));
      return paramaukm;
    }
    int i = paramCursor.getColumnIndex("troopUin");
    if (i == -1)
    {
      paramaukx.a(new NoColumnError("troopUin", String.class));
      i = paramCursor.getColumnIndex("lastmsgtime");
      if (i != -1) {
        break label187;
      }
      paramaukx.a(new NoColumnError("lastmsgtime", Long.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("lastdrafttime");
      if (i != -1) {
        break label202;
      }
      paramaukx.a(new NoColumnError("lastdrafttime", Long.TYPE));
      return paramaukm;
      paramaukm.troopUin = paramCursor.getString(i);
      break;
      label187:
      paramaukm.lastmsgtime = paramCursor.getLong(i);
    }
    label202:
    paramaukm.lastdrafttime = paramCursor.getLong(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopUin TEXT UNIQUE ,lastmsgtime INTEGER ,lastdrafttime INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (TroopAssistantData)paramaukm;
    paramContentValues.put("troopUin", paramaukm.troopUin);
    paramContentValues.put("lastmsgtime", Long.valueOf(paramaukm.lastmsgtime));
    paramContentValues.put("lastdrafttime", Long.valueOf(paramaukm.lastdrafttime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aulp
 * JD-Core Version:    0.7.0.1
 */