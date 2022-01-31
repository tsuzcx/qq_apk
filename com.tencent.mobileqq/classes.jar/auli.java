import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.persistence.NoColumnError;

public class auli
  extends auky
{
  public auli()
  {
    this.a = 8;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    paramaukm = (SearchHistory)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.key = paramCursor.getString(paramCursor.getColumnIndex("key"));
      paramaukm.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      paramaukm.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramaukm.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramaukm.displayName = paramCursor.getString(paramCursor.getColumnIndex("displayName"));
      paramaukm.extralInfo = paramCursor.getString(paramCursor.getColumnIndex("extralInfo"));
      paramaukm.count = paramCursor.getInt(paramCursor.getColumnIndex("count"));
      paramaukm.time = paramCursor.getLong(paramCursor.getColumnIndex("time"));
      return paramaukm;
    }
    int i = paramCursor.getColumnIndex("key");
    if (i == -1)
    {
      paramaukx.a(new NoColumnError("key", String.class));
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label448;
      }
      paramaukx.a(new NoColumnError("type", Integer.TYPE));
      label225:
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label463;
      }
      paramaukx.a(new NoColumnError("uin", String.class));
      label259:
      i = paramCursor.getColumnIndex("troopUin");
      if (i != -1) {
        break label478;
      }
      paramaukx.a(new NoColumnError("troopUin", String.class));
      label293:
      i = paramCursor.getColumnIndex("displayName");
      if (i != -1) {
        break label493;
      }
      paramaukx.a(new NoColumnError("displayName", String.class));
      label327:
      i = paramCursor.getColumnIndex("extralInfo");
      if (i != -1) {
        break label508;
      }
      paramaukx.a(new NoColumnError("extralInfo", String.class));
      label361:
      i = paramCursor.getColumnIndex("count");
      if (i != -1) {
        break label523;
      }
      paramaukx.a(new NoColumnError("count", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("time");
      if (i != -1) {
        break label538;
      }
      paramaukx.a(new NoColumnError("time", Long.TYPE));
      return paramaukm;
      paramaukm.key = paramCursor.getString(i);
      break;
      label448:
      paramaukm.type = paramCursor.getInt(i);
      break label225;
      label463:
      paramaukm.uin = paramCursor.getString(i);
      break label259;
      label478:
      paramaukm.troopUin = paramCursor.getString(i);
      break label293;
      label493:
      paramaukm.displayName = paramCursor.getString(i);
      break label327;
      label508:
      paramaukm.extralInfo = paramCursor.getString(i);
      break label361;
      label523:
      paramaukm.count = paramCursor.getInt(i);
    }
    label538:
    paramaukm.time = paramCursor.getLong(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,key TEXT UNIQUE ,type INTEGER ,uin TEXT ,troopUin TEXT ,displayName TEXT ,extralInfo TEXT ,count INTEGER ,time INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (SearchHistory)paramaukm;
    paramContentValues.put("key", paramaukm.key);
    paramContentValues.put("type", Integer.valueOf(paramaukm.type));
    paramContentValues.put("uin", paramaukm.uin);
    paramContentValues.put("troopUin", paramaukm.troopUin);
    paramContentValues.put("displayName", paramaukm.displayName);
    paramContentValues.put("extralInfo", paramaukm.extralInfo);
    paramContentValues.put("count", Integer.valueOf(paramaukm.count));
    paramContentValues.put("time", Long.valueOf(paramaukm.time));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auli
 * JD-Core Version:    0.7.0.1
 */