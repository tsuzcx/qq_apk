import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class azni
  extends OGAbstractDao
{
  public azni()
  {
    this.columnLen = 2;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (CommonlyUsedTroop)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramEntity.addedTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("addedTimestamp"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("troopUin");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopUin", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("addedTimestamp");
      if (i != -1) {
        break;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("addedTimestamp", Long.TYPE));
      return paramEntity;
      paramEntity.troopUin = paramCursor.getString(i);
    }
    paramEntity.addedTimestamp = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (CommonlyUsedTroop)paramEntity;
    paramContentValues.put("troopUin", paramEntity.troopUin);
    paramContentValues.put("addedTimestamp", Long.valueOf(paramEntity.addedTimestamp));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopUin TEXT UNIQUE ,addedTimestamp INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azni
 * JD-Core Version:    0.7.0.1
 */