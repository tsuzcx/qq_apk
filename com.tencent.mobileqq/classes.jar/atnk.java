import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atnk
  extends atna
{
  public atnk()
  {
    this.a = 8;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    paramatmo = (SearchHistory)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.key = paramCursor.getString(paramCursor.getColumnIndex("key"));
      paramatmo.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      paramatmo.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramatmo.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramatmo.displayName = paramCursor.getString(paramCursor.getColumnIndex("displayName"));
      paramatmo.extralInfo = paramCursor.getString(paramCursor.getColumnIndex("extralInfo"));
      paramatmo.count = paramCursor.getInt(paramCursor.getColumnIndex("count"));
      paramatmo.time = paramCursor.getLong(paramCursor.getColumnIndex("time"));
      return paramatmo;
    }
    int i = paramCursor.getColumnIndex("key");
    if (i == -1)
    {
      paramatmz.a(new NoColumnError("key", String.class));
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label448;
      }
      paramatmz.a(new NoColumnError("type", Integer.TYPE));
      label225:
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label463;
      }
      paramatmz.a(new NoColumnError("uin", String.class));
      label259:
      i = paramCursor.getColumnIndex("troopUin");
      if (i != -1) {
        break label478;
      }
      paramatmz.a(new NoColumnError("troopUin", String.class));
      label293:
      i = paramCursor.getColumnIndex("displayName");
      if (i != -1) {
        break label493;
      }
      paramatmz.a(new NoColumnError("displayName", String.class));
      label327:
      i = paramCursor.getColumnIndex("extralInfo");
      if (i != -1) {
        break label508;
      }
      paramatmz.a(new NoColumnError("extralInfo", String.class));
      label361:
      i = paramCursor.getColumnIndex("count");
      if (i != -1) {
        break label523;
      }
      paramatmz.a(new NoColumnError("count", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("time");
      if (i != -1) {
        break label538;
      }
      paramatmz.a(new NoColumnError("time", Long.TYPE));
      return paramatmo;
      paramatmo.key = paramCursor.getString(i);
      break;
      label448:
      paramatmo.type = paramCursor.getInt(i);
      break label225;
      label463:
      paramatmo.uin = paramCursor.getString(i);
      break label259;
      label478:
      paramatmo.troopUin = paramCursor.getString(i);
      break label293;
      label493:
      paramatmo.displayName = paramCursor.getString(i);
      break label327;
      label508:
      paramatmo.extralInfo = paramCursor.getString(i);
      break label361;
      label523:
      paramatmo.count = paramCursor.getInt(i);
    }
    label538:
    paramatmo.time = paramCursor.getLong(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,key TEXT UNIQUE ,type INTEGER ,uin TEXT ,troopUin TEXT ,displayName TEXT ,extralInfo TEXT ,count INTEGER ,time INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (SearchHistory)paramatmo;
    paramContentValues.put("key", paramatmo.key);
    paramContentValues.put("type", Integer.valueOf(paramatmo.type));
    paramContentValues.put("uin", paramatmo.uin);
    paramContentValues.put("troopUin", paramatmo.troopUin);
    paramContentValues.put("displayName", paramatmo.displayName);
    paramContentValues.put("extralInfo", paramatmo.extralInfo);
    paramContentValues.put("count", Integer.valueOf(paramatmo.count));
    paramContentValues.put("time", Long.valueOf(paramatmo.time));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atnk
 * JD-Core Version:    0.7.0.1
 */