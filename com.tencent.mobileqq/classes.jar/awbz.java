import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awbz
  extends awch
{
  public awbz()
  {
    this.a = 3;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    paramawbv = (ExpiredPushBanner)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.cid = paramCursor.getLong(paramCursor.getColumnIndex("cid"));
      paramawbv.md5 = paramCursor.getString(paramCursor.getColumnIndex("md5"));
      paramawbv.endtime = paramCursor.getLong(paramCursor.getColumnIndex("endtime"));
      return paramawbv;
    }
    int i = paramCursor.getColumnIndex("cid");
    if (i == -1)
    {
      paramawcg.a(new NoColumnError("cid", Long.TYPE));
      i = paramCursor.getColumnIndex("md5");
      if (i != -1) {
        break label187;
      }
      paramawcg.a(new NoColumnError("md5", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("endtime");
      if (i != -1) {
        break label202;
      }
      paramawcg.a(new NoColumnError("endtime", Long.TYPE));
      return paramawbv;
      paramawbv.cid = paramCursor.getLong(i);
      break;
      label187:
      paramawbv.md5 = paramCursor.getString(i);
    }
    label202:
    paramawbv.endtime = paramCursor.getLong(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,cid INTEGER UNIQUE ,md5 TEXT ,endtime INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (ExpiredPushBanner)paramawbv;
    paramContentValues.put("cid", Long.valueOf(paramawbv.cid));
    paramContentValues.put("md5", paramawbv.md5);
    paramContentValues.put("endtime", Long.valueOf(paramawbv.endtime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awbz
 * JD-Core Version:    0.7.0.1
 */