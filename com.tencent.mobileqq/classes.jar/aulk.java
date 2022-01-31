import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aulk
  extends aula
{
  public aulk()
  {
    this.a = 8;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    paramauko = (SearchHistory)paramauko;
    if (paramaukz == null)
    {
      paramauko.key = paramCursor.getString(paramCursor.getColumnIndex("key"));
      paramauko.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      paramauko.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramauko.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramauko.displayName = paramCursor.getString(paramCursor.getColumnIndex("displayName"));
      paramauko.extralInfo = paramCursor.getString(paramCursor.getColumnIndex("extralInfo"));
      paramauko.count = paramCursor.getInt(paramCursor.getColumnIndex("count"));
      paramauko.time = paramCursor.getLong(paramCursor.getColumnIndex("time"));
      return paramauko;
    }
    int i = paramCursor.getColumnIndex("key");
    if (i == -1)
    {
      paramaukz.a(new NoColumnError("key", String.class));
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label448;
      }
      paramaukz.a(new NoColumnError("type", Integer.TYPE));
      label225:
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label463;
      }
      paramaukz.a(new NoColumnError("uin", String.class));
      label259:
      i = paramCursor.getColumnIndex("troopUin");
      if (i != -1) {
        break label478;
      }
      paramaukz.a(new NoColumnError("troopUin", String.class));
      label293:
      i = paramCursor.getColumnIndex("displayName");
      if (i != -1) {
        break label493;
      }
      paramaukz.a(new NoColumnError("displayName", String.class));
      label327:
      i = paramCursor.getColumnIndex("extralInfo");
      if (i != -1) {
        break label508;
      }
      paramaukz.a(new NoColumnError("extralInfo", String.class));
      label361:
      i = paramCursor.getColumnIndex("count");
      if (i != -1) {
        break label523;
      }
      paramaukz.a(new NoColumnError("count", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("time");
      if (i != -1) {
        break label538;
      }
      paramaukz.a(new NoColumnError("time", Long.TYPE));
      return paramauko;
      paramauko.key = paramCursor.getString(i);
      break;
      label448:
      paramauko.type = paramCursor.getInt(i);
      break label225;
      label463:
      paramauko.uin = paramCursor.getString(i);
      break label259;
      label478:
      paramauko.troopUin = paramCursor.getString(i);
      break label293;
      label493:
      paramauko.displayName = paramCursor.getString(i);
      break label327;
      label508:
      paramauko.extralInfo = paramCursor.getString(i);
      break label361;
      label523:
      paramauko.count = paramCursor.getInt(i);
    }
    label538:
    paramauko.time = paramCursor.getLong(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,key TEXT UNIQUE ,type INTEGER ,uin TEXT ,troopUin TEXT ,displayName TEXT ,extralInfo TEXT ,count INTEGER ,time INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (SearchHistory)paramauko;
    paramContentValues.put("key", paramauko.key);
    paramContentValues.put("type", Integer.valueOf(paramauko.type));
    paramContentValues.put("uin", paramauko.uin);
    paramContentValues.put("troopUin", paramauko.troopUin);
    paramContentValues.put("displayName", paramauko.displayName);
    paramContentValues.put("extralInfo", paramauko.extralInfo);
    paramContentValues.put("count", Integer.valueOf(paramauko.count));
    paramContentValues.put("time", Long.valueOf(paramauko.time));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aulk
 * JD-Core Version:    0.7.0.1
 */