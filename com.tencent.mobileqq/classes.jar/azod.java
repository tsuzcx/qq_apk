import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;
import com.tencent.mobileqq.statistics.Reporting;

public class azod
  extends OGAbstractDao
{
  public azod()
  {
    this.columnLen = 6;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (Reporting)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.mTag = paramCursor.getString(paramCursor.getColumnIndex("mTag"));
      paramEntity.mDetail = paramCursor.getString(paramCursor.getColumnIndex("mDetail"));
      paramEntity.mCount = paramCursor.getInt(paramCursor.getColumnIndex("mCount"));
      paramEntity.mLockedCount = paramCursor.getInt(paramCursor.getColumnIndex("mLockedCount"));
      paramEntity.mSeqKey = paramCursor.getInt(paramCursor.getColumnIndex("mSeqKey"));
      paramEntity.mDetailHashCode = paramCursor.getInt(paramCursor.getColumnIndex("mDetailHashCode"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("mTag");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mTag", String.class));
      i = paramCursor.getColumnIndex("mDetail");
      if (i != -1) {
        break label345;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mDetail", String.class));
      label188:
      i = paramCursor.getColumnIndex("mCount");
      if (i != -1) {
        break label360;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mCount", Integer.TYPE));
      label223:
      i = paramCursor.getColumnIndex("mLockedCount");
      if (i != -1) {
        break label375;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mLockedCount", Integer.TYPE));
      label258:
      i = paramCursor.getColumnIndex("mSeqKey");
      if (i != -1) {
        break label390;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mSeqKey", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("mDetailHashCode");
      if (i != -1) {
        break label405;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mDetailHashCode", Integer.TYPE));
      return paramEntity;
      paramEntity.mTag = paramCursor.getString(i);
      break;
      label345:
      paramEntity.mDetail = paramCursor.getString(i);
      break label188;
      label360:
      paramEntity.mCount = paramCursor.getInt(i);
      break label223;
      label375:
      paramEntity.mLockedCount = paramCursor.getInt(i);
      break label258;
      label390:
      paramEntity.mSeqKey = paramCursor.getInt(i);
    }
    label405:
    paramEntity.mDetailHashCode = paramCursor.getInt(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (Reporting)paramEntity;
    paramContentValues.put("mTag", paramEntity.mTag);
    paramContentValues.put("mDetail", paramEntity.mDetail);
    paramContentValues.put("mCount", Integer.valueOf(paramEntity.mCount));
    paramContentValues.put("mLockedCount", Integer.valueOf(paramEntity.mLockedCount));
    paramContentValues.put("mSeqKey", Integer.valueOf(paramEntity.mSeqKey));
    paramContentValues.put("mDetailHashCode", Integer.valueOf(paramEntity.mDetailHashCode));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,mTag TEXT ,mDetail TEXT ,mCount INTEGER ,mLockedCount INTEGER ,mSeqKey INTEGER ,mDetailHashCode INTEGER,UNIQUE(mTag, mDetail) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azod
 * JD-Core Version:    0.7.0.1
 */