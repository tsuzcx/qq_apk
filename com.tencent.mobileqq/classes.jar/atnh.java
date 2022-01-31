import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.statistics.Reporting;

public class atnh
  extends atna
{
  public atnh()
  {
    this.a = 6;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    paramatmo = (Reporting)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.mTag = paramCursor.getString(paramCursor.getColumnIndex("mTag"));
      paramatmo.mDetail = paramCursor.getString(paramCursor.getColumnIndex("mDetail"));
      paramatmo.mCount = paramCursor.getInt(paramCursor.getColumnIndex("mCount"));
      paramatmo.mLockedCount = paramCursor.getInt(paramCursor.getColumnIndex("mLockedCount"));
      paramatmo.mSeqKey = paramCursor.getInt(paramCursor.getColumnIndex("mSeqKey"));
      paramatmo.mDetailHashCode = paramCursor.getInt(paramCursor.getColumnIndex("mDetailHashCode"));
      return paramatmo;
    }
    int i = paramCursor.getColumnIndex("mTag");
    if (i == -1)
    {
      paramatmz.a(new NoColumnError("mTag", String.class));
      i = paramCursor.getColumnIndex("mDetail");
      if (i != -1) {
        break label345;
      }
      paramatmz.a(new NoColumnError("mDetail", String.class));
      label188:
      i = paramCursor.getColumnIndex("mCount");
      if (i != -1) {
        break label360;
      }
      paramatmz.a(new NoColumnError("mCount", Integer.TYPE));
      label223:
      i = paramCursor.getColumnIndex("mLockedCount");
      if (i != -1) {
        break label375;
      }
      paramatmz.a(new NoColumnError("mLockedCount", Integer.TYPE));
      label258:
      i = paramCursor.getColumnIndex("mSeqKey");
      if (i != -1) {
        break label390;
      }
      paramatmz.a(new NoColumnError("mSeqKey", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("mDetailHashCode");
      if (i != -1) {
        break label405;
      }
      paramatmz.a(new NoColumnError("mDetailHashCode", Integer.TYPE));
      return paramatmo;
      paramatmo.mTag = paramCursor.getString(i);
      break;
      label345:
      paramatmo.mDetail = paramCursor.getString(i);
      break label188;
      label360:
      paramatmo.mCount = paramCursor.getInt(i);
      break label223;
      label375:
      paramatmo.mLockedCount = paramCursor.getInt(i);
      break label258;
      label390:
      paramatmo.mSeqKey = paramCursor.getInt(i);
    }
    label405:
    paramatmo.mDetailHashCode = paramCursor.getInt(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,mTag TEXT ,mDetail TEXT ,mCount INTEGER ,mLockedCount INTEGER ,mSeqKey INTEGER ,mDetailHashCode INTEGER,UNIQUE(mTag, mDetail) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (Reporting)paramatmo;
    paramContentValues.put("mTag", paramatmo.mTag);
    paramContentValues.put("mDetail", paramatmo.mDetail);
    paramContentValues.put("mCount", Integer.valueOf(paramatmo.mCount));
    paramContentValues.put("mLockedCount", Integer.valueOf(paramatmo.mLockedCount));
    paramContentValues.put("mSeqKey", Integer.valueOf(paramatmo.mSeqKey));
    paramContentValues.put("mDetailHashCode", Integer.valueOf(paramatmo.mDetailHashCode));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atnh
 * JD-Core Version:    0.7.0.1
 */