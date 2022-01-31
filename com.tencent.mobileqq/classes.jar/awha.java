import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awha
  extends awgq
{
  public awha()
  {
    this.a = 8;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    paramawge = (SearchHistory)paramawge;
    if (paramawgp == null)
    {
      paramawge.key = paramCursor.getString(paramCursor.getColumnIndex("key"));
      paramawge.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      paramawge.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawge.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramawge.displayName = paramCursor.getString(paramCursor.getColumnIndex("displayName"));
      paramawge.extralInfo = paramCursor.getString(paramCursor.getColumnIndex("extralInfo"));
      paramawge.count = paramCursor.getInt(paramCursor.getColumnIndex("count"));
      paramawge.time = paramCursor.getLong(paramCursor.getColumnIndex("time"));
      return paramawge;
    }
    int i = paramCursor.getColumnIndex("key");
    if (i == -1)
    {
      paramawgp.a(new NoColumnError("key", String.class));
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label448;
      }
      paramawgp.a(new NoColumnError("type", Integer.TYPE));
      label225:
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label463;
      }
      paramawgp.a(new NoColumnError("uin", String.class));
      label259:
      i = paramCursor.getColumnIndex("troopUin");
      if (i != -1) {
        break label478;
      }
      paramawgp.a(new NoColumnError("troopUin", String.class));
      label293:
      i = paramCursor.getColumnIndex("displayName");
      if (i != -1) {
        break label493;
      }
      paramawgp.a(new NoColumnError("displayName", String.class));
      label327:
      i = paramCursor.getColumnIndex("extralInfo");
      if (i != -1) {
        break label508;
      }
      paramawgp.a(new NoColumnError("extralInfo", String.class));
      label361:
      i = paramCursor.getColumnIndex("count");
      if (i != -1) {
        break label523;
      }
      paramawgp.a(new NoColumnError("count", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("time");
      if (i != -1) {
        break label538;
      }
      paramawgp.a(new NoColumnError("time", Long.TYPE));
      return paramawge;
      paramawge.key = paramCursor.getString(i);
      break;
      label448:
      paramawge.type = paramCursor.getInt(i);
      break label225;
      label463:
      paramawge.uin = paramCursor.getString(i);
      break label259;
      label478:
      paramawge.troopUin = paramCursor.getString(i);
      break label293;
      label493:
      paramawge.displayName = paramCursor.getString(i);
      break label327;
      label508:
      paramawge.extralInfo = paramCursor.getString(i);
      break label361;
      label523:
      paramawge.count = paramCursor.getInt(i);
    }
    label538:
    paramawge.time = paramCursor.getLong(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,key TEXT UNIQUE ,type INTEGER ,uin TEXT ,troopUin TEXT ,displayName TEXT ,extralInfo TEXT ,count INTEGER ,time INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (SearchHistory)paramawge;
    paramContentValues.put("key", paramawge.key);
    paramContentValues.put("type", Integer.valueOf(paramawge.type));
    paramContentValues.put("uin", paramawge.uin);
    paramContentValues.put("troopUin", paramawge.troopUin);
    paramContentValues.put("displayName", paramawge.displayName);
    paramContentValues.put("extralInfo", paramawge.extralInfo);
    paramContentValues.put("count", Integer.valueOf(paramawge.count));
    paramContentValues.put("time", Long.valueOf(paramawge.time));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awha
 * JD-Core Version:    0.7.0.1
 */