import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awcr
  extends awch
{
  public awcr()
  {
    this.a = 8;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    paramawbv = (SearchHistory)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.key = paramCursor.getString(paramCursor.getColumnIndex("key"));
      paramawbv.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      paramawbv.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawbv.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramawbv.displayName = paramCursor.getString(paramCursor.getColumnIndex("displayName"));
      paramawbv.extralInfo = paramCursor.getString(paramCursor.getColumnIndex("extralInfo"));
      paramawbv.count = paramCursor.getInt(paramCursor.getColumnIndex("count"));
      paramawbv.time = paramCursor.getLong(paramCursor.getColumnIndex("time"));
      return paramawbv;
    }
    int i = paramCursor.getColumnIndex("key");
    if (i == -1)
    {
      paramawcg.a(new NoColumnError("key", String.class));
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label448;
      }
      paramawcg.a(new NoColumnError("type", Integer.TYPE));
      label225:
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label463;
      }
      paramawcg.a(new NoColumnError("uin", String.class));
      label259:
      i = paramCursor.getColumnIndex("troopUin");
      if (i != -1) {
        break label478;
      }
      paramawcg.a(new NoColumnError("troopUin", String.class));
      label293:
      i = paramCursor.getColumnIndex("displayName");
      if (i != -1) {
        break label493;
      }
      paramawcg.a(new NoColumnError("displayName", String.class));
      label327:
      i = paramCursor.getColumnIndex("extralInfo");
      if (i != -1) {
        break label508;
      }
      paramawcg.a(new NoColumnError("extralInfo", String.class));
      label361:
      i = paramCursor.getColumnIndex("count");
      if (i != -1) {
        break label523;
      }
      paramawcg.a(new NoColumnError("count", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("time");
      if (i != -1) {
        break label538;
      }
      paramawcg.a(new NoColumnError("time", Long.TYPE));
      return paramawbv;
      paramawbv.key = paramCursor.getString(i);
      break;
      label448:
      paramawbv.type = paramCursor.getInt(i);
      break label225;
      label463:
      paramawbv.uin = paramCursor.getString(i);
      break label259;
      label478:
      paramawbv.troopUin = paramCursor.getString(i);
      break label293;
      label493:
      paramawbv.displayName = paramCursor.getString(i);
      break label327;
      label508:
      paramawbv.extralInfo = paramCursor.getString(i);
      break label361;
      label523:
      paramawbv.count = paramCursor.getInt(i);
    }
    label538:
    paramawbv.time = paramCursor.getLong(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,key TEXT UNIQUE ,type INTEGER ,uin TEXT ,troopUin TEXT ,displayName TEXT ,extralInfo TEXT ,count INTEGER ,time INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (SearchHistory)paramawbv;
    paramContentValues.put("key", paramawbv.key);
    paramContentValues.put("type", Integer.valueOf(paramawbv.type));
    paramContentValues.put("uin", paramawbv.uin);
    paramContentValues.put("troopUin", paramawbv.troopUin);
    paramContentValues.put("displayName", paramawbv.displayName);
    paramContentValues.put("extralInfo", paramawbv.extralInfo);
    paramContentValues.put("count", Integer.valueOf(paramawbv.count));
    paramContentValues.put("time", Long.valueOf(paramawbv.time));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awcr
 * JD-Core Version:    0.7.0.1
 */