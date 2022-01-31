import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.statistics.Reporting;

public class awgx
  extends awgq
{
  public awgx()
  {
    this.a = 6;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    paramawge = (Reporting)paramawge;
    if (paramawgp == null)
    {
      paramawge.mTag = paramCursor.getString(paramCursor.getColumnIndex("mTag"));
      paramawge.mDetail = paramCursor.getString(paramCursor.getColumnIndex("mDetail"));
      paramawge.mCount = paramCursor.getInt(paramCursor.getColumnIndex("mCount"));
      paramawge.mLockedCount = paramCursor.getInt(paramCursor.getColumnIndex("mLockedCount"));
      paramawge.mSeqKey = paramCursor.getInt(paramCursor.getColumnIndex("mSeqKey"));
      paramawge.mDetailHashCode = paramCursor.getInt(paramCursor.getColumnIndex("mDetailHashCode"));
      return paramawge;
    }
    int i = paramCursor.getColumnIndex("mTag");
    if (i == -1)
    {
      paramawgp.a(new NoColumnError("mTag", String.class));
      i = paramCursor.getColumnIndex("mDetail");
      if (i != -1) {
        break label345;
      }
      paramawgp.a(new NoColumnError("mDetail", String.class));
      label188:
      i = paramCursor.getColumnIndex("mCount");
      if (i != -1) {
        break label360;
      }
      paramawgp.a(new NoColumnError("mCount", Integer.TYPE));
      label223:
      i = paramCursor.getColumnIndex("mLockedCount");
      if (i != -1) {
        break label375;
      }
      paramawgp.a(new NoColumnError("mLockedCount", Integer.TYPE));
      label258:
      i = paramCursor.getColumnIndex("mSeqKey");
      if (i != -1) {
        break label390;
      }
      paramawgp.a(new NoColumnError("mSeqKey", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("mDetailHashCode");
      if (i != -1) {
        break label405;
      }
      paramawgp.a(new NoColumnError("mDetailHashCode", Integer.TYPE));
      return paramawge;
      paramawge.mTag = paramCursor.getString(i);
      break;
      label345:
      paramawge.mDetail = paramCursor.getString(i);
      break label188;
      label360:
      paramawge.mCount = paramCursor.getInt(i);
      break label223;
      label375:
      paramawge.mLockedCount = paramCursor.getInt(i);
      break label258;
      label390:
      paramawge.mSeqKey = paramCursor.getInt(i);
    }
    label405:
    paramawge.mDetailHashCode = paramCursor.getInt(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,mTag TEXT ,mDetail TEXT ,mCount INTEGER ,mLockedCount INTEGER ,mSeqKey INTEGER ,mDetailHashCode INTEGER,UNIQUE(mTag, mDetail) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (Reporting)paramawge;
    paramContentValues.put("mTag", paramawge.mTag);
    paramContentValues.put("mDetail", paramawge.mDetail);
    paramContentValues.put("mCount", Integer.valueOf(paramawge.mCount));
    paramContentValues.put("mLockedCount", Integer.valueOf(paramawge.mLockedCount));
    paramContentValues.put("mSeqKey", Integer.valueOf(paramawge.mSeqKey));
    paramContentValues.put("mDetailHashCode", Integer.valueOf(paramawge.mDetailHashCode));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awgx
 * JD-Core Version:    0.7.0.1
 */