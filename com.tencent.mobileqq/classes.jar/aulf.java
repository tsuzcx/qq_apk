import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aulf
  extends aula
{
  public aulf()
  {
    this.a = 16;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    paramauko = (QQOperationViopTipTask)paramauko;
    if (paramaukz == null)
    {
      paramauko.taskid = paramCursor.getInt(paramCursor.getColumnIndex("taskid"));
      paramauko.uinType = paramCursor.getInt(paramCursor.getColumnIndex("uinType"));
      paramauko.tipType = paramCursor.getInt(paramCursor.getColumnIndex("tipType"));
      paramauko.adwords = paramCursor.getString(paramCursor.getColumnIndex("adwords"));
      paramauko.clickableWord = paramCursor.getString(paramCursor.getColumnIndex("clickableWord"));
      paramauko.linkOffset = paramCursor.getInt(paramCursor.getColumnIndex("linkOffset"));
      paramauko.url = paramCursor.getString(paramCursor.getColumnIndex("url"));
      paramauko.limitDayAIOCount = paramCursor.getInt(paramCursor.getColumnIndex("limitDayAIOCount"));
      paramauko.limitDayAIOShowCount = paramCursor.getInt(paramCursor.getColumnIndex("limitDayAIOShowCount"));
      paramauko.limitTotalAIOCount = paramCursor.getInt(paramCursor.getColumnIndex("limitTotalAIOCount"));
      paramauko.limitTotalShowCount = paramCursor.getInt(paramCursor.getColumnIndex("limitTotalShowCount"));
      paramauko.keywordString = paramCursor.getString(paramCursor.getColumnIndex("keywordString"));
      paramauko.begin = paramCursor.getString(paramCursor.getColumnIndex("begin"));
      paramauko.end = paramCursor.getString(paramCursor.getColumnIndex("end"));
      paramauko.frequencyTime = paramCursor.getInt(paramCursor.getColumnIndex("frequencyTime"));
      paramauko.frequencyMessage = paramCursor.getInt(paramCursor.getColumnIndex("frequencyMessage"));
      return paramauko;
    }
    int i = paramCursor.getColumnIndex("taskid");
    if (i == -1)
    {
      paramaukz.a(new NoColumnError("taskid", Integer.TYPE));
      i = paramCursor.getColumnIndex("uinType");
      if (i != -1) {
        break label871;
      }
      paramaukz.a(new NoColumnError("uinType", Integer.TYPE));
      label370:
      i = paramCursor.getColumnIndex("tipType");
      if (i != -1) {
        break label886;
      }
      paramaukz.a(new NoColumnError("tipType", Integer.TYPE));
      label405:
      i = paramCursor.getColumnIndex("adwords");
      if (i != -1) {
        break label901;
      }
      paramaukz.a(new NoColumnError("adwords", String.class));
      label439:
      i = paramCursor.getColumnIndex("clickableWord");
      if (i != -1) {
        break label916;
      }
      paramaukz.a(new NoColumnError("clickableWord", String.class));
      label473:
      i = paramCursor.getColumnIndex("linkOffset");
      if (i != -1) {
        break label931;
      }
      paramaukz.a(new NoColumnError("linkOffset", Integer.TYPE));
      label508:
      i = paramCursor.getColumnIndex("url");
      if (i != -1) {
        break label946;
      }
      paramaukz.a(new NoColumnError("url", String.class));
      label542:
      i = paramCursor.getColumnIndex("limitDayAIOCount");
      if (i != -1) {
        break label961;
      }
      paramaukz.a(new NoColumnError("limitDayAIOCount", Integer.TYPE));
      label577:
      i = paramCursor.getColumnIndex("limitDayAIOShowCount");
      if (i != -1) {
        break label976;
      }
      paramaukz.a(new NoColumnError("limitDayAIOShowCount", Integer.TYPE));
      label612:
      i = paramCursor.getColumnIndex("limitTotalAIOCount");
      if (i != -1) {
        break label991;
      }
      paramaukz.a(new NoColumnError("limitTotalAIOCount", Integer.TYPE));
      label647:
      i = paramCursor.getColumnIndex("limitTotalShowCount");
      if (i != -1) {
        break label1006;
      }
      paramaukz.a(new NoColumnError("limitTotalShowCount", Integer.TYPE));
      label682:
      i = paramCursor.getColumnIndex("keywordString");
      if (i != -1) {
        break label1021;
      }
      paramaukz.a(new NoColumnError("keywordString", String.class));
      label716:
      i = paramCursor.getColumnIndex("begin");
      if (i != -1) {
        break label1036;
      }
      paramaukz.a(new NoColumnError("begin", String.class));
      label750:
      i = paramCursor.getColumnIndex("end");
      if (i != -1) {
        break label1051;
      }
      paramaukz.a(new NoColumnError("end", String.class));
      label784:
      i = paramCursor.getColumnIndex("frequencyTime");
      if (i != -1) {
        break label1066;
      }
      paramaukz.a(new NoColumnError("frequencyTime", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("frequencyMessage");
      if (i != -1) {
        break label1081;
      }
      paramaukz.a(new NoColumnError("frequencyMessage", Integer.TYPE));
      return paramauko;
      paramauko.taskid = paramCursor.getInt(i);
      break;
      label871:
      paramauko.uinType = paramCursor.getInt(i);
      break label370;
      label886:
      paramauko.tipType = paramCursor.getInt(i);
      break label405;
      label901:
      paramauko.adwords = paramCursor.getString(i);
      break label439;
      label916:
      paramauko.clickableWord = paramCursor.getString(i);
      break label473;
      label931:
      paramauko.linkOffset = paramCursor.getInt(i);
      break label508;
      label946:
      paramauko.url = paramCursor.getString(i);
      break label542;
      label961:
      paramauko.limitDayAIOCount = paramCursor.getInt(i);
      break label577;
      label976:
      paramauko.limitDayAIOShowCount = paramCursor.getInt(i);
      break label612;
      label991:
      paramauko.limitTotalAIOCount = paramCursor.getInt(i);
      break label647;
      label1006:
      paramauko.limitTotalShowCount = paramCursor.getInt(i);
      break label682;
      label1021:
      paramauko.keywordString = paramCursor.getString(i);
      break label716;
      label1036:
      paramauko.begin = paramCursor.getString(i);
      break label750;
      label1051:
      paramauko.end = paramCursor.getString(i);
      break label784;
      label1066:
      paramauko.frequencyTime = paramCursor.getInt(i);
    }
    label1081:
    paramauko.frequencyMessage = paramCursor.getInt(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,taskid INTEGER ,uinType INTEGER ,tipType INTEGER ,adwords TEXT ,clickableWord TEXT ,linkOffset INTEGER ,url TEXT ,limitDayAIOCount INTEGER ,limitDayAIOShowCount INTEGER ,limitTotalAIOCount INTEGER ,limitTotalShowCount INTEGER ,keywordString TEXT ,begin TEXT ,end TEXT ,frequencyTime INTEGER ,frequencyMessage INTEGER,UNIQUE(taskid) ON CONFLICT REPLACE)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (QQOperationViopTipTask)paramauko;
    paramContentValues.put("taskid", Integer.valueOf(paramauko.taskid));
    paramContentValues.put("uinType", Integer.valueOf(paramauko.uinType));
    paramContentValues.put("tipType", Integer.valueOf(paramauko.tipType));
    paramContentValues.put("adwords", paramauko.adwords);
    paramContentValues.put("clickableWord", paramauko.clickableWord);
    paramContentValues.put("linkOffset", Integer.valueOf(paramauko.linkOffset));
    paramContentValues.put("url", paramauko.url);
    paramContentValues.put("limitDayAIOCount", Integer.valueOf(paramauko.limitDayAIOCount));
    paramContentValues.put("limitDayAIOShowCount", Integer.valueOf(paramauko.limitDayAIOShowCount));
    paramContentValues.put("limitTotalAIOCount", Integer.valueOf(paramauko.limitTotalAIOCount));
    paramContentValues.put("limitTotalShowCount", Integer.valueOf(paramauko.limitTotalShowCount));
    paramContentValues.put("keywordString", paramauko.keywordString);
    paramContentValues.put("begin", paramauko.begin);
    paramContentValues.put("end", paramauko.end);
    paramContentValues.put("frequencyTime", Integer.valueOf(paramauko.frequencyTime));
    paramContentValues.put("frequencyMessage", Integer.valueOf(paramauko.frequencyMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aulf
 * JD-Core Version:    0.7.0.1
 */