import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.persistence.NoColumnError;

public class auld
  extends auky
{
  public auld()
  {
    this.a = 16;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    paramaukm = (QQOperationViopTipTask)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.taskid = paramCursor.getInt(paramCursor.getColumnIndex("taskid"));
      paramaukm.uinType = paramCursor.getInt(paramCursor.getColumnIndex("uinType"));
      paramaukm.tipType = paramCursor.getInt(paramCursor.getColumnIndex("tipType"));
      paramaukm.adwords = paramCursor.getString(paramCursor.getColumnIndex("adwords"));
      paramaukm.clickableWord = paramCursor.getString(paramCursor.getColumnIndex("clickableWord"));
      paramaukm.linkOffset = paramCursor.getInt(paramCursor.getColumnIndex("linkOffset"));
      paramaukm.url = paramCursor.getString(paramCursor.getColumnIndex("url"));
      paramaukm.limitDayAIOCount = paramCursor.getInt(paramCursor.getColumnIndex("limitDayAIOCount"));
      paramaukm.limitDayAIOShowCount = paramCursor.getInt(paramCursor.getColumnIndex("limitDayAIOShowCount"));
      paramaukm.limitTotalAIOCount = paramCursor.getInt(paramCursor.getColumnIndex("limitTotalAIOCount"));
      paramaukm.limitTotalShowCount = paramCursor.getInt(paramCursor.getColumnIndex("limitTotalShowCount"));
      paramaukm.keywordString = paramCursor.getString(paramCursor.getColumnIndex("keywordString"));
      paramaukm.begin = paramCursor.getString(paramCursor.getColumnIndex("begin"));
      paramaukm.end = paramCursor.getString(paramCursor.getColumnIndex("end"));
      paramaukm.frequencyTime = paramCursor.getInt(paramCursor.getColumnIndex("frequencyTime"));
      paramaukm.frequencyMessage = paramCursor.getInt(paramCursor.getColumnIndex("frequencyMessage"));
      return paramaukm;
    }
    int i = paramCursor.getColumnIndex("taskid");
    if (i == -1)
    {
      paramaukx.a(new NoColumnError("taskid", Integer.TYPE));
      i = paramCursor.getColumnIndex("uinType");
      if (i != -1) {
        break label871;
      }
      paramaukx.a(new NoColumnError("uinType", Integer.TYPE));
      label370:
      i = paramCursor.getColumnIndex("tipType");
      if (i != -1) {
        break label886;
      }
      paramaukx.a(new NoColumnError("tipType", Integer.TYPE));
      label405:
      i = paramCursor.getColumnIndex("adwords");
      if (i != -1) {
        break label901;
      }
      paramaukx.a(new NoColumnError("adwords", String.class));
      label439:
      i = paramCursor.getColumnIndex("clickableWord");
      if (i != -1) {
        break label916;
      }
      paramaukx.a(new NoColumnError("clickableWord", String.class));
      label473:
      i = paramCursor.getColumnIndex("linkOffset");
      if (i != -1) {
        break label931;
      }
      paramaukx.a(new NoColumnError("linkOffset", Integer.TYPE));
      label508:
      i = paramCursor.getColumnIndex("url");
      if (i != -1) {
        break label946;
      }
      paramaukx.a(new NoColumnError("url", String.class));
      label542:
      i = paramCursor.getColumnIndex("limitDayAIOCount");
      if (i != -1) {
        break label961;
      }
      paramaukx.a(new NoColumnError("limitDayAIOCount", Integer.TYPE));
      label577:
      i = paramCursor.getColumnIndex("limitDayAIOShowCount");
      if (i != -1) {
        break label976;
      }
      paramaukx.a(new NoColumnError("limitDayAIOShowCount", Integer.TYPE));
      label612:
      i = paramCursor.getColumnIndex("limitTotalAIOCount");
      if (i != -1) {
        break label991;
      }
      paramaukx.a(new NoColumnError("limitTotalAIOCount", Integer.TYPE));
      label647:
      i = paramCursor.getColumnIndex("limitTotalShowCount");
      if (i != -1) {
        break label1006;
      }
      paramaukx.a(new NoColumnError("limitTotalShowCount", Integer.TYPE));
      label682:
      i = paramCursor.getColumnIndex("keywordString");
      if (i != -1) {
        break label1021;
      }
      paramaukx.a(new NoColumnError("keywordString", String.class));
      label716:
      i = paramCursor.getColumnIndex("begin");
      if (i != -1) {
        break label1036;
      }
      paramaukx.a(new NoColumnError("begin", String.class));
      label750:
      i = paramCursor.getColumnIndex("end");
      if (i != -1) {
        break label1051;
      }
      paramaukx.a(new NoColumnError("end", String.class));
      label784:
      i = paramCursor.getColumnIndex("frequencyTime");
      if (i != -1) {
        break label1066;
      }
      paramaukx.a(new NoColumnError("frequencyTime", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("frequencyMessage");
      if (i != -1) {
        break label1081;
      }
      paramaukx.a(new NoColumnError("frequencyMessage", Integer.TYPE));
      return paramaukm;
      paramaukm.taskid = paramCursor.getInt(i);
      break;
      label871:
      paramaukm.uinType = paramCursor.getInt(i);
      break label370;
      label886:
      paramaukm.tipType = paramCursor.getInt(i);
      break label405;
      label901:
      paramaukm.adwords = paramCursor.getString(i);
      break label439;
      label916:
      paramaukm.clickableWord = paramCursor.getString(i);
      break label473;
      label931:
      paramaukm.linkOffset = paramCursor.getInt(i);
      break label508;
      label946:
      paramaukm.url = paramCursor.getString(i);
      break label542;
      label961:
      paramaukm.limitDayAIOCount = paramCursor.getInt(i);
      break label577;
      label976:
      paramaukm.limitDayAIOShowCount = paramCursor.getInt(i);
      break label612;
      label991:
      paramaukm.limitTotalAIOCount = paramCursor.getInt(i);
      break label647;
      label1006:
      paramaukm.limitTotalShowCount = paramCursor.getInt(i);
      break label682;
      label1021:
      paramaukm.keywordString = paramCursor.getString(i);
      break label716;
      label1036:
      paramaukm.begin = paramCursor.getString(i);
      break label750;
      label1051:
      paramaukm.end = paramCursor.getString(i);
      break label784;
      label1066:
      paramaukm.frequencyTime = paramCursor.getInt(i);
    }
    label1081:
    paramaukm.frequencyMessage = paramCursor.getInt(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,taskid INTEGER ,uinType INTEGER ,tipType INTEGER ,adwords TEXT ,clickableWord TEXT ,linkOffset INTEGER ,url TEXT ,limitDayAIOCount INTEGER ,limitDayAIOShowCount INTEGER ,limitTotalAIOCount INTEGER ,limitTotalShowCount INTEGER ,keywordString TEXT ,begin TEXT ,end TEXT ,frequencyTime INTEGER ,frequencyMessage INTEGER,UNIQUE(taskid) ON CONFLICT REPLACE)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (QQOperationViopTipTask)paramaukm;
    paramContentValues.put("taskid", Integer.valueOf(paramaukm.taskid));
    paramContentValues.put("uinType", Integer.valueOf(paramaukm.uinType));
    paramContentValues.put("tipType", Integer.valueOf(paramaukm.tipType));
    paramContentValues.put("adwords", paramaukm.adwords);
    paramContentValues.put("clickableWord", paramaukm.clickableWord);
    paramContentValues.put("linkOffset", Integer.valueOf(paramaukm.linkOffset));
    paramContentValues.put("url", paramaukm.url);
    paramContentValues.put("limitDayAIOCount", Integer.valueOf(paramaukm.limitDayAIOCount));
    paramContentValues.put("limitDayAIOShowCount", Integer.valueOf(paramaukm.limitDayAIOShowCount));
    paramContentValues.put("limitTotalAIOCount", Integer.valueOf(paramaukm.limitTotalAIOCount));
    paramContentValues.put("limitTotalShowCount", Integer.valueOf(paramaukm.limitTotalShowCount));
    paramContentValues.put("keywordString", paramaukm.keywordString);
    paramContentValues.put("begin", paramaukm.begin);
    paramContentValues.put("end", paramaukm.end);
    paramContentValues.put("frequencyTime", Integer.valueOf(paramaukm.frequencyTime));
    paramContentValues.put("frequencyMessage", Integer.valueOf(paramaukm.frequencyMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auld
 * JD-Core Version:    0.7.0.1
 */