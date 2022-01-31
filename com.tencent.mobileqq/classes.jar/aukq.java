import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukq
  extends auky
{
  public aukq()
  {
    this.a = 3;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    paramaukm = (ExpiredPushBanner)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.cid = paramCursor.getLong(paramCursor.getColumnIndex("cid"));
      paramaukm.md5 = paramCursor.getString(paramCursor.getColumnIndex("md5"));
      paramaukm.endtime = paramCursor.getLong(paramCursor.getColumnIndex("endtime"));
      return paramaukm;
    }
    int i = paramCursor.getColumnIndex("cid");
    if (i == -1)
    {
      paramaukx.a(new NoColumnError("cid", Long.TYPE));
      i = paramCursor.getColumnIndex("md5");
      if (i != -1) {
        break label187;
      }
      paramaukx.a(new NoColumnError("md5", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("endtime");
      if (i != -1) {
        break label202;
      }
      paramaukx.a(new NoColumnError("endtime", Long.TYPE));
      return paramaukm;
      paramaukm.cid = paramCursor.getLong(i);
      break;
      label187:
      paramaukm.md5 = paramCursor.getString(i);
    }
    label202:
    paramaukm.endtime = paramCursor.getLong(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,cid INTEGER UNIQUE ,md5 TEXT ,endtime INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (ExpiredPushBanner)paramaukm;
    paramContentValues.put("cid", Long.valueOf(paramaukm.cid));
    paramContentValues.put("md5", paramaukm.md5);
    paramContentValues.put("endtime", Long.valueOf(paramaukm.endtime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukq
 * JD-Core Version:    0.7.0.1
 */