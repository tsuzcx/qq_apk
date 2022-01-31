import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.statistics.Reporting;

public class awco
  extends awch
{
  public awco()
  {
    this.a = 6;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    paramawbv = (Reporting)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.mTag = paramCursor.getString(paramCursor.getColumnIndex("mTag"));
      paramawbv.mDetail = paramCursor.getString(paramCursor.getColumnIndex("mDetail"));
      paramawbv.mCount = paramCursor.getInt(paramCursor.getColumnIndex("mCount"));
      paramawbv.mLockedCount = paramCursor.getInt(paramCursor.getColumnIndex("mLockedCount"));
      paramawbv.mSeqKey = paramCursor.getInt(paramCursor.getColumnIndex("mSeqKey"));
      paramawbv.mDetailHashCode = paramCursor.getInt(paramCursor.getColumnIndex("mDetailHashCode"));
      return paramawbv;
    }
    int i = paramCursor.getColumnIndex("mTag");
    if (i == -1)
    {
      paramawcg.a(new NoColumnError("mTag", String.class));
      i = paramCursor.getColumnIndex("mDetail");
      if (i != -1) {
        break label345;
      }
      paramawcg.a(new NoColumnError("mDetail", String.class));
      label188:
      i = paramCursor.getColumnIndex("mCount");
      if (i != -1) {
        break label360;
      }
      paramawcg.a(new NoColumnError("mCount", Integer.TYPE));
      label223:
      i = paramCursor.getColumnIndex("mLockedCount");
      if (i != -1) {
        break label375;
      }
      paramawcg.a(new NoColumnError("mLockedCount", Integer.TYPE));
      label258:
      i = paramCursor.getColumnIndex("mSeqKey");
      if (i != -1) {
        break label390;
      }
      paramawcg.a(new NoColumnError("mSeqKey", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("mDetailHashCode");
      if (i != -1) {
        break label405;
      }
      paramawcg.a(new NoColumnError("mDetailHashCode", Integer.TYPE));
      return paramawbv;
      paramawbv.mTag = paramCursor.getString(i);
      break;
      label345:
      paramawbv.mDetail = paramCursor.getString(i);
      break label188;
      label360:
      paramawbv.mCount = paramCursor.getInt(i);
      break label223;
      label375:
      paramawbv.mLockedCount = paramCursor.getInt(i);
      break label258;
      label390:
      paramawbv.mSeqKey = paramCursor.getInt(i);
    }
    label405:
    paramawbv.mDetailHashCode = paramCursor.getInt(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,mTag TEXT ,mDetail TEXT ,mCount INTEGER ,mLockedCount INTEGER ,mSeqKey INTEGER ,mDetailHashCode INTEGER,UNIQUE(mTag, mDetail) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (Reporting)paramawbv;
    paramContentValues.put("mTag", paramawbv.mTag);
    paramContentValues.put("mDetail", paramawbv.mDetail);
    paramContentValues.put("mCount", Integer.valueOf(paramawbv.mCount));
    paramContentValues.put("mLockedCount", Integer.valueOf(paramawbv.mLockedCount));
    paramContentValues.put("mSeqKey", Integer.valueOf(paramawbv.mSeqKey));
    paramContentValues.put("mDetailHashCode", Integer.valueOf(paramawbv.mDetailHashCode));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awco
 * JD-Core Version:    0.7.0.1
 */