import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awcy
  extends awch
{
  public awcy()
  {
    this.a = 3;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    paramawbv = (TroopAssistantData)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramawbv.lastmsgtime = paramCursor.getLong(paramCursor.getColumnIndex("lastmsgtime"));
      paramawbv.lastdrafttime = paramCursor.getLong(paramCursor.getColumnIndex("lastdrafttime"));
      return paramawbv;
    }
    int i = paramCursor.getColumnIndex("troopUin");
    if (i == -1)
    {
      paramawcg.a(new NoColumnError("troopUin", String.class));
      i = paramCursor.getColumnIndex("lastmsgtime");
      if (i != -1) {
        break label187;
      }
      paramawcg.a(new NoColumnError("lastmsgtime", Long.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("lastdrafttime");
      if (i != -1) {
        break label202;
      }
      paramawcg.a(new NoColumnError("lastdrafttime", Long.TYPE));
      return paramawbv;
      paramawbv.troopUin = paramCursor.getString(i);
      break;
      label187:
      paramawbv.lastmsgtime = paramCursor.getLong(i);
    }
    label202:
    paramawbv.lastdrafttime = paramCursor.getLong(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopUin TEXT UNIQUE ,lastmsgtime INTEGER ,lastdrafttime INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (TroopAssistantData)paramawbv;
    paramContentValues.put("troopUin", paramawbv.troopUin);
    paramContentValues.put("lastmsgtime", Long.valueOf(paramawbv.lastmsgtime));
    paramContentValues.put("lastdrafttime", Long.valueOf(paramawbv.lastdrafttime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awcy
 * JD-Core Version:    0.7.0.1
 */