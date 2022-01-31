import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.persistence.NoColumnError;

public class auks
  extends aula
{
  public auks()
  {
    this.a = 3;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    paramauko = (ExpiredPushBanner)paramauko;
    if (paramaukz == null)
    {
      paramauko.cid = paramCursor.getLong(paramCursor.getColumnIndex("cid"));
      paramauko.md5 = paramCursor.getString(paramCursor.getColumnIndex("md5"));
      paramauko.endtime = paramCursor.getLong(paramCursor.getColumnIndex("endtime"));
      return paramauko;
    }
    int i = paramCursor.getColumnIndex("cid");
    if (i == -1)
    {
      paramaukz.a(new NoColumnError("cid", Long.TYPE));
      i = paramCursor.getColumnIndex("md5");
      if (i != -1) {
        break label187;
      }
      paramaukz.a(new NoColumnError("md5", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("endtime");
      if (i != -1) {
        break label202;
      }
      paramaukz.a(new NoColumnError("endtime", Long.TYPE));
      return paramauko;
      paramauko.cid = paramCursor.getLong(i);
      break;
      label187:
      paramauko.md5 = paramCursor.getString(i);
    }
    label202:
    paramauko.endtime = paramCursor.getLong(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,cid INTEGER UNIQUE ,md5 TEXT ,endtime INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (ExpiredPushBanner)paramauko;
    paramContentValues.put("cid", Long.valueOf(paramauko.cid));
    paramContentValues.put("md5", paramauko.md5);
    paramContentValues.put("endtime", Long.valueOf(paramauko.endtime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auks
 * JD-Core Version:    0.7.0.1
 */