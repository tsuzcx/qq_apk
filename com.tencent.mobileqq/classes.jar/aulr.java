import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aulr
  extends aula
{
  public aulr()
  {
    this.a = 3;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    paramauko = (TroopAssistantData)paramauko;
    if (paramaukz == null)
    {
      paramauko.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramauko.lastmsgtime = paramCursor.getLong(paramCursor.getColumnIndex("lastmsgtime"));
      paramauko.lastdrafttime = paramCursor.getLong(paramCursor.getColumnIndex("lastdrafttime"));
      return paramauko;
    }
    int i = paramCursor.getColumnIndex("troopUin");
    if (i == -1)
    {
      paramaukz.a(new NoColumnError("troopUin", String.class));
      i = paramCursor.getColumnIndex("lastmsgtime");
      if (i != -1) {
        break label187;
      }
      paramaukz.a(new NoColumnError("lastmsgtime", Long.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("lastdrafttime");
      if (i != -1) {
        break label202;
      }
      paramaukz.a(new NoColumnError("lastdrafttime", Long.TYPE));
      return paramauko;
      paramauko.troopUin = paramCursor.getString(i);
      break;
      label187:
      paramauko.lastmsgtime = paramCursor.getLong(i);
    }
    label202:
    paramauko.lastdrafttime = paramCursor.getLong(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopUin TEXT UNIQUE ,lastmsgtime INTEGER ,lastdrafttime INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (TroopAssistantData)paramauko;
    paramContentValues.put("troopUin", paramauko.troopUin);
    paramContentValues.put("lastmsgtime", Long.valueOf(paramauko.lastmsgtime));
    paramContentValues.put("lastdrafttime", Long.valueOf(paramauko.lastdrafttime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aulr
 * JD-Core Version:    0.7.0.1
 */