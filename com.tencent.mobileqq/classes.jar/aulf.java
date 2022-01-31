import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.statistics.Reporting;

public class aulf
  extends auky
{
  public aulf()
  {
    this.a = 6;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    paramaukm = (Reporting)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.mTag = paramCursor.getString(paramCursor.getColumnIndex("mTag"));
      paramaukm.mDetail = paramCursor.getString(paramCursor.getColumnIndex("mDetail"));
      paramaukm.mCount = paramCursor.getInt(paramCursor.getColumnIndex("mCount"));
      paramaukm.mLockedCount = paramCursor.getInt(paramCursor.getColumnIndex("mLockedCount"));
      paramaukm.mSeqKey = paramCursor.getInt(paramCursor.getColumnIndex("mSeqKey"));
      paramaukm.mDetailHashCode = paramCursor.getInt(paramCursor.getColumnIndex("mDetailHashCode"));
      return paramaukm;
    }
    int i = paramCursor.getColumnIndex("mTag");
    if (i == -1)
    {
      paramaukx.a(new NoColumnError("mTag", String.class));
      i = paramCursor.getColumnIndex("mDetail");
      if (i != -1) {
        break label345;
      }
      paramaukx.a(new NoColumnError("mDetail", String.class));
      label188:
      i = paramCursor.getColumnIndex("mCount");
      if (i != -1) {
        break label360;
      }
      paramaukx.a(new NoColumnError("mCount", Integer.TYPE));
      label223:
      i = paramCursor.getColumnIndex("mLockedCount");
      if (i != -1) {
        break label375;
      }
      paramaukx.a(new NoColumnError("mLockedCount", Integer.TYPE));
      label258:
      i = paramCursor.getColumnIndex("mSeqKey");
      if (i != -1) {
        break label390;
      }
      paramaukx.a(new NoColumnError("mSeqKey", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("mDetailHashCode");
      if (i != -1) {
        break label405;
      }
      paramaukx.a(new NoColumnError("mDetailHashCode", Integer.TYPE));
      return paramaukm;
      paramaukm.mTag = paramCursor.getString(i);
      break;
      label345:
      paramaukm.mDetail = paramCursor.getString(i);
      break label188;
      label360:
      paramaukm.mCount = paramCursor.getInt(i);
      break label223;
      label375:
      paramaukm.mLockedCount = paramCursor.getInt(i);
      break label258;
      label390:
      paramaukm.mSeqKey = paramCursor.getInt(i);
    }
    label405:
    paramaukm.mDetailHashCode = paramCursor.getInt(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,mTag TEXT ,mDetail TEXT ,mCount INTEGER ,mLockedCount INTEGER ,mSeqKey INTEGER ,mDetailHashCode INTEGER,UNIQUE(mTag, mDetail) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (Reporting)paramaukm;
    paramContentValues.put("mTag", paramaukm.mTag);
    paramContentValues.put("mDetail", paramaukm.mDetail);
    paramContentValues.put("mCount", Integer.valueOf(paramaukm.mCount));
    paramContentValues.put("mLockedCount", Integer.valueOf(paramaukm.mLockedCount));
    paramContentValues.put("mSeqKey", Integer.valueOf(paramaukm.mSeqKey));
    paramContentValues.put("mDetailHashCode", Integer.valueOf(paramaukm.mDetailHashCode));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aulf
 * JD-Core Version:    0.7.0.1
 */