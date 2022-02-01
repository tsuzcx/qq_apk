import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class aznn
  extends OGAbstractDao
{
  public aznn()
  {
    this.columnLen = 7;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (DiscussionMemberInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.discussionUin = paramCursor.getString(paramCursor.getColumnIndex("discussionUin"));
      paramEntity.memberUin = paramCursor.getString(paramCursor.getColumnIndex("memberUin"));
      paramEntity.memberName = paramCursor.getString(paramCursor.getColumnIndex("memberName"));
      paramEntity.flag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("flag")));
      paramEntity.dataTime = paramCursor.getLong(paramCursor.getColumnIndex("dataTime"));
      paramEntity.inteRemark = paramCursor.getString(paramCursor.getColumnIndex("inteRemark"));
      paramEntity.inteRemarkSource = paramCursor.getLong(paramCursor.getColumnIndex("inteRemarkSource"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("discussionUin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("discussionUin", String.class));
      i = paramCursor.getColumnIndex("memberUin");
      if (i != -1) {
        break label397;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("memberUin", String.class));
      label207:
      i = paramCursor.getColumnIndex("memberName");
      if (i != -1) {
        break label412;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("memberName", String.class));
      label241:
      i = paramCursor.getColumnIndex("flag");
      if (i != -1) {
        break label427;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("flag", Byte.TYPE));
      label276:
      i = paramCursor.getColumnIndex("dataTime");
      if (i != -1) {
        break label443;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dataTime", Long.TYPE));
      label311:
      i = paramCursor.getColumnIndex("inteRemark");
      if (i != -1) {
        break label458;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("inteRemark", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("inteRemarkSource");
      if (i != -1) {
        break label473;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("inteRemarkSource", Long.TYPE));
      return paramEntity;
      paramEntity.discussionUin = paramCursor.getString(i);
      break;
      label397:
      paramEntity.memberUin = paramCursor.getString(i);
      break label207;
      label412:
      paramEntity.memberName = paramCursor.getString(i);
      break label241;
      label427:
      paramEntity.flag = ((byte)paramCursor.getShort(i));
      break label276;
      label443:
      paramEntity.dataTime = paramCursor.getLong(i);
      break label311;
      label458:
      paramEntity.inteRemark = paramCursor.getString(i);
    }
    label473:
    paramEntity.inteRemarkSource = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (DiscussionMemberInfo)paramEntity;
    paramContentValues.put("discussionUin", paramEntity.discussionUin);
    paramContentValues.put("memberUin", paramEntity.memberUin);
    paramContentValues.put("memberName", paramEntity.memberName);
    paramContentValues.put("flag", Byte.valueOf(paramEntity.flag));
    paramContentValues.put("dataTime", Long.valueOf(paramEntity.dataTime));
    paramContentValues.put("inteRemark", paramEntity.inteRemark);
    paramContentValues.put("inteRemarkSource", Long.valueOf(paramEntity.inteRemarkSource));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,discussionUin TEXT ,memberUin TEXT ,memberName TEXT ,flag INTEGER ,dataTime INTEGER ,inteRemark TEXT ,inteRemarkSource INTEGER,UNIQUE(discussionUin,memberUin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aznn
 * JD-Core Version:    0.7.0.1
 */