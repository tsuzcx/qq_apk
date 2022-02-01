import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class azhq
  extends OGAbstractDao
{
  public azhq()
  {
    this.columnLen = 7;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (Groups)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.group_name = paramCursor.getString(paramCursor.getColumnIndex("group_name"));
      paramEntity.group_id = paramCursor.getInt(paramCursor.getColumnIndex("group_id"));
      paramEntity.group_friend_count = paramCursor.getInt(paramCursor.getColumnIndex("group_friend_count"));
      paramEntity.group_online_friend_count = paramCursor.getInt(paramCursor.getColumnIndex("group_online_friend_count"));
      paramEntity.seqid = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("seqid")));
      paramEntity.sqqOnLine_count = paramCursor.getInt(paramCursor.getColumnIndex("sqqOnLine_count"));
      paramEntity.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("group_name");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("group_name", String.class));
      i = paramCursor.getColumnIndex("group_id");
      if (i != -1) {
        break label400;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("group_id", Integer.TYPE));
      label208:
      i = paramCursor.getColumnIndex("group_friend_count");
      if (i != -1) {
        break label415;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("group_friend_count", Integer.TYPE));
      label243:
      i = paramCursor.getColumnIndex("group_online_friend_count");
      if (i != -1) {
        break label430;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("group_online_friend_count", Integer.TYPE));
      label278:
      i = paramCursor.getColumnIndex("seqid");
      if (i != -1) {
        break label445;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("seqid", Byte.TYPE));
      label313:
      i = paramCursor.getColumnIndex("sqqOnLine_count");
      if (i != -1) {
        break label461;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sqqOnLine_count", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label476;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("datetime", Long.TYPE));
      return paramEntity;
      paramEntity.group_name = paramCursor.getString(i);
      break;
      label400:
      paramEntity.group_id = paramCursor.getInt(i);
      break label208;
      label415:
      paramEntity.group_friend_count = paramCursor.getInt(i);
      break label243;
      label430:
      paramEntity.group_online_friend_count = paramCursor.getInt(i);
      break label278;
      label445:
      paramEntity.seqid = ((byte)paramCursor.getShort(i));
      break label313;
      label461:
      paramEntity.sqqOnLine_count = paramCursor.getInt(i);
    }
    label476:
    paramEntity.datetime = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (Groups)paramEntity;
    paramContentValues.put("group_name", paramEntity.group_name);
    paramContentValues.put("group_id", Integer.valueOf(paramEntity.group_id));
    paramContentValues.put("group_friend_count", Integer.valueOf(paramEntity.group_friend_count));
    paramContentValues.put("group_online_friend_count", Integer.valueOf(paramEntity.group_online_friend_count));
    paramContentValues.put("seqid", Byte.valueOf(paramEntity.seqid));
    paramContentValues.put("sqqOnLine_count", Integer.valueOf(paramEntity.sqqOnLine_count));
    paramContentValues.put("datetime", Long.valueOf(paramEntity.datetime));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,group_name TEXT ,group_id INTEGER UNIQUE ,group_friend_count INTEGER ,group_online_friend_count INTEGER ,seqid INTEGER ,sqqOnLine_count INTEGER ,datetime INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azhq
 * JD-Core Version:    0.7.0.1
 */