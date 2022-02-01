import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class ayvw
  extends OGAbstractDao
{
  public ayvw()
  {
    this.columnLen = 9;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (Stranger)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramEntity.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramEntity.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramEntity.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
      paramEntity.groupName = paramCursor.getString(paramCursor.getColumnIndex("groupName"));
      paramEntity.login = paramCursor.getString(paramCursor.getColumnIndex("login"));
      paramEntity.loginId = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("loginId")));
      paramEntity.time = paramCursor.getLong(paramCursor.getColumnIndex("time"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label504;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("name", String.class));
      label245:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label519;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("age", Byte.TYPE));
      label280:
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label535;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("remark", String.class));
      label314:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label550;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("gender", Byte.TYPE));
      label349:
      i = paramCursor.getColumnIndex("groupName");
      if (i != -1) {
        break label566;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("groupName", String.class));
      label383:
      i = paramCursor.getColumnIndex("login");
      if (i != -1) {
        break label581;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("login", String.class));
      label417:
      i = paramCursor.getColumnIndex("loginId");
      if (i != -1) {
        break label596;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("loginId", Byte.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("time");
      if (i != -1) {
        break label612;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("time", Long.TYPE));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label504:
      paramEntity.name = paramCursor.getString(i);
      break label245;
      label519:
      paramEntity.age = ((byte)paramCursor.getShort(i));
      break label280;
      label535:
      paramEntity.remark = paramCursor.getString(i);
      break label314;
      label550:
      paramEntity.gender = ((byte)paramCursor.getShort(i));
      break label349;
      label566:
      paramEntity.groupName = paramCursor.getString(i);
      break label383;
      label581:
      paramEntity.login = paramCursor.getString(i);
      break label417;
      label596:
      paramEntity.loginId = ((byte)paramCursor.getShort(i));
    }
    label612:
    paramEntity.time = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (Stranger)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("name", paramEntity.name);
    paramContentValues.put("age", Byte.valueOf(paramEntity.age));
    paramContentValues.put("remark", paramEntity.remark);
    paramContentValues.put("gender", Byte.valueOf(paramEntity.gender));
    paramContentValues.put("groupName", paramEntity.groupName);
    paramContentValues.put("login", paramEntity.login);
    paramContentValues.put("loginId", Byte.valueOf(paramEntity.loginId));
    paramContentValues.put("time", Long.valueOf(paramEntity.time));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,name TEXT ,age INTEGER ,remark TEXT ,gender INTEGER ,groupName TEXT ,login TEXT ,loginId INTEGER ,time INTEGER,UNIQUE(uin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayvw
 * JD-Core Version:    0.7.0.1
 */