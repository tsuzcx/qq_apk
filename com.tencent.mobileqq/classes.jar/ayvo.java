import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class ayvo
  extends OGAbstractDao
{
  public ayvo()
  {
    this.columnLen = 16;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (QQOperationViopTipTask)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.taskid = paramCursor.getInt(paramCursor.getColumnIndex("taskid"));
      paramEntity.uinType = paramCursor.getInt(paramCursor.getColumnIndex("uinType"));
      paramEntity.tipType = paramCursor.getInt(paramCursor.getColumnIndex("tipType"));
      paramEntity.adwords = paramCursor.getString(paramCursor.getColumnIndex("adwords"));
      paramEntity.clickableWord = paramCursor.getString(paramCursor.getColumnIndex("clickableWord"));
      paramEntity.linkOffset = paramCursor.getInt(paramCursor.getColumnIndex("linkOffset"));
      paramEntity.url = paramCursor.getString(paramCursor.getColumnIndex("url"));
      paramEntity.limitDayAIOCount = paramCursor.getInt(paramCursor.getColumnIndex("limitDayAIOCount"));
      paramEntity.limitDayAIOShowCount = paramCursor.getInt(paramCursor.getColumnIndex("limitDayAIOShowCount"));
      paramEntity.limitTotalAIOCount = paramCursor.getInt(paramCursor.getColumnIndex("limitTotalAIOCount"));
      paramEntity.limitTotalShowCount = paramCursor.getInt(paramCursor.getColumnIndex("limitTotalShowCount"));
      paramEntity.keywordString = paramCursor.getString(paramCursor.getColumnIndex("keywordString"));
      paramEntity.begin = paramCursor.getString(paramCursor.getColumnIndex("begin"));
      paramEntity.end = paramCursor.getString(paramCursor.getColumnIndex("end"));
      paramEntity.frequencyTime = paramCursor.getInt(paramCursor.getColumnIndex("frequencyTime"));
      paramEntity.frequencyMessage = paramCursor.getInt(paramCursor.getColumnIndex("frequencyMessage"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("taskid");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("taskid", Integer.TYPE));
      i = paramCursor.getColumnIndex("uinType");
      if (i != -1) {
        break label871;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uinType", Integer.TYPE));
      label370:
      i = paramCursor.getColumnIndex("tipType");
      if (i != -1) {
        break label886;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tipType", Integer.TYPE));
      label405:
      i = paramCursor.getColumnIndex("adwords");
      if (i != -1) {
        break label901;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("adwords", String.class));
      label439:
      i = paramCursor.getColumnIndex("clickableWord");
      if (i != -1) {
        break label916;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("clickableWord", String.class));
      label473:
      i = paramCursor.getColumnIndex("linkOffset");
      if (i != -1) {
        break label931;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("linkOffset", Integer.TYPE));
      label508:
      i = paramCursor.getColumnIndex("url");
      if (i != -1) {
        break label946;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("url", String.class));
      label542:
      i = paramCursor.getColumnIndex("limitDayAIOCount");
      if (i != -1) {
        break label961;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("limitDayAIOCount", Integer.TYPE));
      label577:
      i = paramCursor.getColumnIndex("limitDayAIOShowCount");
      if (i != -1) {
        break label976;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("limitDayAIOShowCount", Integer.TYPE));
      label612:
      i = paramCursor.getColumnIndex("limitTotalAIOCount");
      if (i != -1) {
        break label991;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("limitTotalAIOCount", Integer.TYPE));
      label647:
      i = paramCursor.getColumnIndex("limitTotalShowCount");
      if (i != -1) {
        break label1006;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("limitTotalShowCount", Integer.TYPE));
      label682:
      i = paramCursor.getColumnIndex("keywordString");
      if (i != -1) {
        break label1021;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("keywordString", String.class));
      label716:
      i = paramCursor.getColumnIndex("begin");
      if (i != -1) {
        break label1036;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("begin", String.class));
      label750:
      i = paramCursor.getColumnIndex("end");
      if (i != -1) {
        break label1051;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("end", String.class));
      label784:
      i = paramCursor.getColumnIndex("frequencyTime");
      if (i != -1) {
        break label1066;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("frequencyTime", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("frequencyMessage");
      if (i != -1) {
        break label1081;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("frequencyMessage", Integer.TYPE));
      return paramEntity;
      paramEntity.taskid = paramCursor.getInt(i);
      break;
      label871:
      paramEntity.uinType = paramCursor.getInt(i);
      break label370;
      label886:
      paramEntity.tipType = paramCursor.getInt(i);
      break label405;
      label901:
      paramEntity.adwords = paramCursor.getString(i);
      break label439;
      label916:
      paramEntity.clickableWord = paramCursor.getString(i);
      break label473;
      label931:
      paramEntity.linkOffset = paramCursor.getInt(i);
      break label508;
      label946:
      paramEntity.url = paramCursor.getString(i);
      break label542;
      label961:
      paramEntity.limitDayAIOCount = paramCursor.getInt(i);
      break label577;
      label976:
      paramEntity.limitDayAIOShowCount = paramCursor.getInt(i);
      break label612;
      label991:
      paramEntity.limitTotalAIOCount = paramCursor.getInt(i);
      break label647;
      label1006:
      paramEntity.limitTotalShowCount = paramCursor.getInt(i);
      break label682;
      label1021:
      paramEntity.keywordString = paramCursor.getString(i);
      break label716;
      label1036:
      paramEntity.begin = paramCursor.getString(i);
      break label750;
      label1051:
      paramEntity.end = paramCursor.getString(i);
      break label784;
      label1066:
      paramEntity.frequencyTime = paramCursor.getInt(i);
    }
    label1081:
    paramEntity.frequencyMessage = paramCursor.getInt(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (QQOperationViopTipTask)paramEntity;
    paramContentValues.put("taskid", Integer.valueOf(paramEntity.taskid));
    paramContentValues.put("uinType", Integer.valueOf(paramEntity.uinType));
    paramContentValues.put("tipType", Integer.valueOf(paramEntity.tipType));
    paramContentValues.put("adwords", paramEntity.adwords);
    paramContentValues.put("clickableWord", paramEntity.clickableWord);
    paramContentValues.put("linkOffset", Integer.valueOf(paramEntity.linkOffset));
    paramContentValues.put("url", paramEntity.url);
    paramContentValues.put("limitDayAIOCount", Integer.valueOf(paramEntity.limitDayAIOCount));
    paramContentValues.put("limitDayAIOShowCount", Integer.valueOf(paramEntity.limitDayAIOShowCount));
    paramContentValues.put("limitTotalAIOCount", Integer.valueOf(paramEntity.limitTotalAIOCount));
    paramContentValues.put("limitTotalShowCount", Integer.valueOf(paramEntity.limitTotalShowCount));
    paramContentValues.put("keywordString", paramEntity.keywordString);
    paramContentValues.put("begin", paramEntity.begin);
    paramContentValues.put("end", paramEntity.end);
    paramContentValues.put("frequencyTime", Integer.valueOf(paramEntity.frequencyTime));
    paramContentValues.put("frequencyMessage", Integer.valueOf(paramEntity.frequencyMessage));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,taskid INTEGER ,uinType INTEGER ,tipType INTEGER ,adwords TEXT ,clickableWord TEXT ,linkOffset INTEGER ,url TEXT ,limitDayAIOCount INTEGER ,limitDayAIOShowCount INTEGER ,limitTotalAIOCount INTEGER ,limitTotalShowCount INTEGER ,keywordString TEXT ,begin TEXT ,end TEXT ,frequencyTime INTEGER ,frequencyMessage INTEGER,UNIQUE(taskid) ON CONFLICT REPLACE)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayvo
 * JD-Core Version:    0.7.0.1
 */