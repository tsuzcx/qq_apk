import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.statistics.Reporting;

public class aulh
  extends aula
{
  public aulh()
  {
    this.a = 6;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    paramauko = (Reporting)paramauko;
    if (paramaukz == null)
    {
      paramauko.mTag = paramCursor.getString(paramCursor.getColumnIndex("mTag"));
      paramauko.mDetail = paramCursor.getString(paramCursor.getColumnIndex("mDetail"));
      paramauko.mCount = paramCursor.getInt(paramCursor.getColumnIndex("mCount"));
      paramauko.mLockedCount = paramCursor.getInt(paramCursor.getColumnIndex("mLockedCount"));
      paramauko.mSeqKey = paramCursor.getInt(paramCursor.getColumnIndex("mSeqKey"));
      paramauko.mDetailHashCode = paramCursor.getInt(paramCursor.getColumnIndex("mDetailHashCode"));
      return paramauko;
    }
    int i = paramCursor.getColumnIndex("mTag");
    if (i == -1)
    {
      paramaukz.a(new NoColumnError("mTag", String.class));
      i = paramCursor.getColumnIndex("mDetail");
      if (i != -1) {
        break label345;
      }
      paramaukz.a(new NoColumnError("mDetail", String.class));
      label188:
      i = paramCursor.getColumnIndex("mCount");
      if (i != -1) {
        break label360;
      }
      paramaukz.a(new NoColumnError("mCount", Integer.TYPE));
      label223:
      i = paramCursor.getColumnIndex("mLockedCount");
      if (i != -1) {
        break label375;
      }
      paramaukz.a(new NoColumnError("mLockedCount", Integer.TYPE));
      label258:
      i = paramCursor.getColumnIndex("mSeqKey");
      if (i != -1) {
        break label390;
      }
      paramaukz.a(new NoColumnError("mSeqKey", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("mDetailHashCode");
      if (i != -1) {
        break label405;
      }
      paramaukz.a(new NoColumnError("mDetailHashCode", Integer.TYPE));
      return paramauko;
      paramauko.mTag = paramCursor.getString(i);
      break;
      label345:
      paramauko.mDetail = paramCursor.getString(i);
      break label188;
      label360:
      paramauko.mCount = paramCursor.getInt(i);
      break label223;
      label375:
      paramauko.mLockedCount = paramCursor.getInt(i);
      break label258;
      label390:
      paramauko.mSeqKey = paramCursor.getInt(i);
    }
    label405:
    paramauko.mDetailHashCode = paramCursor.getInt(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,mTag TEXT ,mDetail TEXT ,mCount INTEGER ,mLockedCount INTEGER ,mSeqKey INTEGER ,mDetailHashCode INTEGER,UNIQUE(mTag, mDetail) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (Reporting)paramauko;
    paramContentValues.put("mTag", paramauko.mTag);
    paramContentValues.put("mDetail", paramauko.mDetail);
    paramContentValues.put("mCount", Integer.valueOf(paramauko.mCount));
    paramContentValues.put("mLockedCount", Integer.valueOf(paramauko.mLockedCount));
    paramContentValues.put("mSeqKey", Integer.valueOf(paramauko.mSeqKey));
    paramContentValues.put("mDetailHashCode", Integer.valueOf(paramauko.mDetailHashCode));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aulh
 * JD-Core Version:    0.7.0.1
 */