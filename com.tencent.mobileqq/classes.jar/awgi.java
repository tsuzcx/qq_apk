import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awgi
  extends awgq
{
  public awgi()
  {
    this.a = 3;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    paramawge = (ExpiredPushBanner)paramawge;
    if (paramawgp == null)
    {
      paramawge.cid = paramCursor.getLong(paramCursor.getColumnIndex("cid"));
      paramawge.md5 = paramCursor.getString(paramCursor.getColumnIndex("md5"));
      paramawge.endtime = paramCursor.getLong(paramCursor.getColumnIndex("endtime"));
      return paramawge;
    }
    int i = paramCursor.getColumnIndex("cid");
    if (i == -1)
    {
      paramawgp.a(new NoColumnError("cid", Long.TYPE));
      i = paramCursor.getColumnIndex("md5");
      if (i != -1) {
        break label187;
      }
      paramawgp.a(new NoColumnError("md5", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("endtime");
      if (i != -1) {
        break label202;
      }
      paramawgp.a(new NoColumnError("endtime", Long.TYPE));
      return paramawge;
      paramawge.cid = paramCursor.getLong(i);
      break;
      label187:
      paramawge.md5 = paramCursor.getString(i);
    }
    label202:
    paramawge.endtime = paramCursor.getLong(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,cid INTEGER UNIQUE ,md5 TEXT ,endtime INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (ExpiredPushBanner)paramawge;
    paramContentValues.put("cid", Long.valueOf(paramawge.cid));
    paramContentValues.put("md5", paramawge.md5);
    paramContentValues.put("endtime", Long.valueOf(paramawge.endtime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awgi
 * JD-Core Version:    0.7.0.1
 */