import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class ayux
  extends OGAbstractDao
{
  public ayux()
  {
    this.columnLen = 12;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool = true;
    paramBoolean = true;
    paramEntity = (ConversationInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      paramEntity.lastread = paramCursor.getLong(paramCursor.getColumnIndex("lastread"));
      paramEntity.unreadCount = paramCursor.getInt(paramCursor.getColumnIndex("unreadCount"));
      paramEntity.unreadMark = paramCursor.getInt(paramCursor.getColumnIndex("unreadMark"));
      paramEntity.unreadGiftCount = paramCursor.getInt(paramCursor.getColumnIndex("unreadGiftCount"));
      paramEntity.extInt1 = paramCursor.getInt(paramCursor.getColumnIndex("extInt1"));
      paramEntity.extInt2 = paramCursor.getInt(paramCursor.getColumnIndex("extInt2"));
      paramEntity.extInt3 = paramCursor.getInt(paramCursor.getColumnIndex("extInt3"));
      paramEntity.extString = paramCursor.getString(paramCursor.getColumnIndex("extString"));
      paramEntity.extData = paramCursor.getBlob(paramCursor.getColumnIndex("extData"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isImax"))) {}
      for (;;)
      {
        paramEntity.isImax = paramBoolean;
        return paramEntity;
        paramBoolean = false;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label677;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("type", Integer.TYPE));
      label312:
      i = paramCursor.getColumnIndex("lastread");
      if (i != -1) {
        break label692;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastread", Long.TYPE));
      label347:
      i = paramCursor.getColumnIndex("unreadCount");
      if (i != -1) {
        break label707;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("unreadCount", Integer.TYPE));
      label382:
      i = paramCursor.getColumnIndex("unreadMark");
      if (i != -1) {
        break label722;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("unreadMark", Integer.TYPE));
      label417:
      i = paramCursor.getColumnIndex("unreadGiftCount");
      if (i != -1) {
        break label737;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("unreadGiftCount", Integer.TYPE));
      label452:
      i = paramCursor.getColumnIndex("extInt1");
      if (i != -1) {
        break label752;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extInt1", Integer.TYPE));
      label487:
      i = paramCursor.getColumnIndex("extInt2");
      if (i != -1) {
        break label767;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extInt2", Integer.TYPE));
      label522:
      i = paramCursor.getColumnIndex("extInt3");
      if (i != -1) {
        break label782;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extInt3", Integer.TYPE));
      label557:
      i = paramCursor.getColumnIndex("extString");
      if (i != -1) {
        break label797;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extString", String.class));
      label591:
      i = paramCursor.getColumnIndex("extData");
      if (i != -1) {
        break label812;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extData", [B.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("isImax");
      if (i != -1) {
        break label827;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isImax", Boolean.TYPE));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label677:
      paramEntity.type = paramCursor.getInt(i);
      break label312;
      label692:
      paramEntity.lastread = paramCursor.getLong(i);
      break label347;
      label707:
      paramEntity.unreadCount = paramCursor.getInt(i);
      break label382;
      label722:
      paramEntity.unreadMark = paramCursor.getInt(i);
      break label417;
      label737:
      paramEntity.unreadGiftCount = paramCursor.getInt(i);
      break label452;
      label752:
      paramEntity.extInt1 = paramCursor.getInt(i);
      break label487;
      label767:
      paramEntity.extInt2 = paramCursor.getInt(i);
      break label522;
      label782:
      paramEntity.extInt3 = paramCursor.getInt(i);
      break label557;
      label797:
      paramEntity.extString = paramCursor.getString(i);
      break label591;
      label812:
      paramEntity.extData = paramCursor.getBlob(i);
    }
    label827:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramEntity.isImax = paramBoolean;
      return paramEntity;
    }
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (ConversationInfo)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("type", Integer.valueOf(paramEntity.type));
    paramContentValues.put("lastread", Long.valueOf(paramEntity.lastread));
    paramContentValues.put("unreadCount", Integer.valueOf(paramEntity.unreadCount));
    paramContentValues.put("unreadMark", Integer.valueOf(paramEntity.unreadMark));
    paramContentValues.put("unreadGiftCount", Integer.valueOf(paramEntity.unreadGiftCount));
    paramContentValues.put("extInt1", Integer.valueOf(paramEntity.extInt1));
    paramContentValues.put("extInt2", Integer.valueOf(paramEntity.extInt2));
    paramContentValues.put("extInt3", Integer.valueOf(paramEntity.extInt3));
    paramContentValues.put("extString", paramEntity.extString);
    paramContentValues.put("extData", paramEntity.extData);
    paramContentValues.put("isImax", Boolean.valueOf(paramEntity.isImax));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,type INTEGER ,lastread INTEGER ,unreadCount INTEGER ,unreadMark INTEGER ,unreadGiftCount INTEGER ,extInt1 INTEGER ,extInt2 INTEGER ,extInt3 INTEGER ,extString TEXT ,extData BLOB ,isImax INTEGER,UNIQUE(uin,type) ON CONFLICT FAIL)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayux
 * JD-Core Version:    0.7.0.1
 */