import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atms
  extends atna
{
  public atms()
  {
    this.a = 3;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    paramatmo = (ExpiredPushBanner)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.cid = paramCursor.getLong(paramCursor.getColumnIndex("cid"));
      paramatmo.md5 = paramCursor.getString(paramCursor.getColumnIndex("md5"));
      paramatmo.endtime = paramCursor.getLong(paramCursor.getColumnIndex("endtime"));
      return paramatmo;
    }
    int i = paramCursor.getColumnIndex("cid");
    if (i == -1)
    {
      paramatmz.a(new NoColumnError("cid", Long.TYPE));
      i = paramCursor.getColumnIndex("md5");
      if (i != -1) {
        break label187;
      }
      paramatmz.a(new NoColumnError("md5", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("endtime");
      if (i != -1) {
        break label202;
      }
      paramatmz.a(new NoColumnError("endtime", Long.TYPE));
      return paramatmo;
      paramatmo.cid = paramCursor.getLong(i);
      break;
      label187:
      paramatmo.md5 = paramCursor.getString(i);
    }
    label202:
    paramatmo.endtime = paramCursor.getLong(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,cid INTEGER UNIQUE ,md5 TEXT ,endtime INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (ExpiredPushBanner)paramatmo;
    paramContentValues.put("cid", Long.valueOf(paramatmo.cid));
    paramContentValues.put("md5", paramatmo.md5);
    paramContentValues.put("endtime", Long.valueOf(paramatmo.endtime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atms
 * JD-Core Version:    0.7.0.1
 */