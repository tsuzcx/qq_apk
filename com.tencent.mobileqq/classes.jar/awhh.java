import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awhh
  extends awgq
{
  public awhh()
  {
    this.a = 3;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    paramawge = (TroopAssistantData)paramawge;
    if (paramawgp == null)
    {
      paramawge.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramawge.lastmsgtime = paramCursor.getLong(paramCursor.getColumnIndex("lastmsgtime"));
      paramawge.lastdrafttime = paramCursor.getLong(paramCursor.getColumnIndex("lastdrafttime"));
      return paramawge;
    }
    int i = paramCursor.getColumnIndex("troopUin");
    if (i == -1)
    {
      paramawgp.a(new NoColumnError("troopUin", String.class));
      i = paramCursor.getColumnIndex("lastmsgtime");
      if (i != -1) {
        break label187;
      }
      paramawgp.a(new NoColumnError("lastmsgtime", Long.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("lastdrafttime");
      if (i != -1) {
        break label202;
      }
      paramawgp.a(new NoColumnError("lastdrafttime", Long.TYPE));
      return paramawge;
      paramawge.troopUin = paramCursor.getString(i);
      break;
      label187:
      paramawge.lastmsgtime = paramCursor.getLong(i);
    }
    label202:
    paramawge.lastdrafttime = paramCursor.getLong(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopUin TEXT UNIQUE ,lastmsgtime INTEGER ,lastdrafttime INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (TroopAssistantData)paramawge;
    paramContentValues.put("troopUin", paramawge.troopUin);
    paramContentValues.put("lastmsgtime", Long.valueOf(paramawge.lastmsgtime));
    paramContentValues.put("lastdrafttime", Long.valueOf(paramawge.lastdrafttime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awhh
 * JD-Core Version:    0.7.0.1
 */