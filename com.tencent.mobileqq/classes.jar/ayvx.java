import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class ayvx
  extends OGAbstractDao
{
  public ayvx()
  {
    this.columnLen = 12;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (SubAccountInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.subuin = paramCursor.getString(paramCursor.getColumnIndex("subuin"));
      paramEntity.subname = paramCursor.getString(paramCursor.getColumnIndex("subname"));
      paramEntity.trunkuin = paramCursor.getString(paramCursor.getColumnIndex("trunkuin"));
      paramEntity.isbind = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isbind")));
      paramEntity.lasttime = paramCursor.getLong(paramCursor.getColumnIndex("lasttime"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isTop")))
      {
        paramBoolean = true;
        paramEntity.isTop = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hintIsNew"))) {
          break label255;
        }
      }
      label255:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.hintIsNew = paramBoolean;
        paramEntity.cookie = paramCursor.getBlob(paramCursor.getColumnIndex("cookie"));
        paramEntity.status = paramCursor.getInt(paramCursor.getColumnIndex("status"));
        paramEntity.serverErrorType = paramCursor.getInt(paramCursor.getColumnIndex("serverErrorType"));
        paramEntity.serverErrorMsg = paramCursor.getString(paramCursor.getColumnIndex("serverErrorMsg"));
        paramEntity.lastCleanQZoneMessageTime = paramCursor.getLong(paramCursor.getColumnIndex("lastCleanQZoneMessageTime"));
        return paramEntity;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("subuin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("subuin", String.class));
      i = paramCursor.getColumnIndex("subname");
      if (i != -1) {
        break label692;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("subname", String.class));
      label328:
      i = paramCursor.getColumnIndex("trunkuin");
      if (i != -1) {
        break label707;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("trunkuin", String.class));
      label362:
      i = paramCursor.getColumnIndex("isbind");
      if (i != -1) {
        break label722;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isbind", Byte.TYPE));
      label397:
      i = paramCursor.getColumnIndex("lasttime");
      if (i != -1) {
        break label738;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lasttime", Long.TYPE));
      label432:
      i = paramCursor.getColumnIndex("isTop");
      if (i != -1) {
        break label753;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isTop", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hintIsNew");
      if (i != -1) {
        break label780;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hintIsNew", Boolean.TYPE));
      i = paramCursor.getColumnIndex("cookie");
      if (i != -1) {
        break label808;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cookie", [B.class));
      label536:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label823;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("status", Integer.TYPE));
      label571:
      i = paramCursor.getColumnIndex("serverErrorType");
      if (i != -1) {
        break label838;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("serverErrorType", Integer.TYPE));
      label606:
      i = paramCursor.getColumnIndex("serverErrorMsg");
      if (i != -1) {
        break label853;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("serverErrorMsg", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("lastCleanQZoneMessageTime");
      if (i != -1) {
        break label868;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastCleanQZoneMessageTime", Long.TYPE));
      return paramEntity;
      paramEntity.subuin = paramCursor.getString(i);
      break;
      label692:
      paramEntity.subname = paramCursor.getString(i);
      break label328;
      label707:
      paramEntity.trunkuin = paramCursor.getString(i);
      break label362;
      label722:
      paramEntity.isbind = ((byte)paramCursor.getShort(i));
      break label397;
      label738:
      paramEntity.lasttime = paramCursor.getLong(i);
      break label432;
      label753:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isTop = paramBoolean;
        break;
      }
      label780:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.hintIsNew = paramBoolean;
        break;
      }
      label808:
      paramEntity.cookie = paramCursor.getBlob(i);
      break label536;
      label823:
      paramEntity.status = paramCursor.getInt(i);
      break label571;
      label838:
      paramEntity.serverErrorType = paramCursor.getInt(i);
      break label606;
      label853:
      paramEntity.serverErrorMsg = paramCursor.getString(i);
    }
    label868:
    paramEntity.lastCleanQZoneMessageTime = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (SubAccountInfo)paramEntity;
    paramContentValues.put("subuin", paramEntity.subuin);
    paramContentValues.put("subname", paramEntity.subname);
    paramContentValues.put("trunkuin", paramEntity.trunkuin);
    paramContentValues.put("isbind", Byte.valueOf(paramEntity.isbind));
    paramContentValues.put("lasttime", Long.valueOf(paramEntity.lasttime));
    paramContentValues.put("isTop", Boolean.valueOf(paramEntity.isTop));
    paramContentValues.put("hintIsNew", Boolean.valueOf(paramEntity.hintIsNew));
    paramContentValues.put("cookie", paramEntity.cookie);
    paramContentValues.put("status", Integer.valueOf(paramEntity.status));
    paramContentValues.put("serverErrorType", Integer.valueOf(paramEntity.serverErrorType));
    paramContentValues.put("serverErrorMsg", paramEntity.serverErrorMsg);
    paramContentValues.put("lastCleanQZoneMessageTime", Long.valueOf(paramEntity.lastCleanQZoneMessageTime));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,subuin TEXT ,subname TEXT ,trunkuin TEXT ,isbind INTEGER ,lasttime INTEGER ,isTop INTEGER ,hintIsNew INTEGER ,cookie BLOB ,status INTEGER ,serverErrorType INTEGER ,serverErrorMsg TEXT ,lastCleanQZoneMessageTime INTEGER,UNIQUE(subuin,trunkuin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayvx
 * JD-Core Version:    0.7.0.1
 */