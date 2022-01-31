import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atnf
  extends atna
{
  public atnf()
  {
    this.a = 16;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    paramatmo = (QQOperationViopTipTask)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.taskid = paramCursor.getInt(paramCursor.getColumnIndex("taskid"));
      paramatmo.uinType = paramCursor.getInt(paramCursor.getColumnIndex("uinType"));
      paramatmo.tipType = paramCursor.getInt(paramCursor.getColumnIndex("tipType"));
      paramatmo.adwords = paramCursor.getString(paramCursor.getColumnIndex("adwords"));
      paramatmo.clickableWord = paramCursor.getString(paramCursor.getColumnIndex("clickableWord"));
      paramatmo.linkOffset = paramCursor.getInt(paramCursor.getColumnIndex("linkOffset"));
      paramatmo.url = paramCursor.getString(paramCursor.getColumnIndex("url"));
      paramatmo.limitDayAIOCount = paramCursor.getInt(paramCursor.getColumnIndex("limitDayAIOCount"));
      paramatmo.limitDayAIOShowCount = paramCursor.getInt(paramCursor.getColumnIndex("limitDayAIOShowCount"));
      paramatmo.limitTotalAIOCount = paramCursor.getInt(paramCursor.getColumnIndex("limitTotalAIOCount"));
      paramatmo.limitTotalShowCount = paramCursor.getInt(paramCursor.getColumnIndex("limitTotalShowCount"));
      paramatmo.keywordString = paramCursor.getString(paramCursor.getColumnIndex("keywordString"));
      paramatmo.begin = paramCursor.getString(paramCursor.getColumnIndex("begin"));
      paramatmo.end = paramCursor.getString(paramCursor.getColumnIndex("end"));
      paramatmo.frequencyTime = paramCursor.getInt(paramCursor.getColumnIndex("frequencyTime"));
      paramatmo.frequencyMessage = paramCursor.getInt(paramCursor.getColumnIndex("frequencyMessage"));
      return paramatmo;
    }
    int i = paramCursor.getColumnIndex("taskid");
    if (i == -1)
    {
      paramatmz.a(new NoColumnError("taskid", Integer.TYPE));
      i = paramCursor.getColumnIndex("uinType");
      if (i != -1) {
        break label871;
      }
      paramatmz.a(new NoColumnError("uinType", Integer.TYPE));
      label370:
      i = paramCursor.getColumnIndex("tipType");
      if (i != -1) {
        break label886;
      }
      paramatmz.a(new NoColumnError("tipType", Integer.TYPE));
      label405:
      i = paramCursor.getColumnIndex("adwords");
      if (i != -1) {
        break label901;
      }
      paramatmz.a(new NoColumnError("adwords", String.class));
      label439:
      i = paramCursor.getColumnIndex("clickableWord");
      if (i != -1) {
        break label916;
      }
      paramatmz.a(new NoColumnError("clickableWord", String.class));
      label473:
      i = paramCursor.getColumnIndex("linkOffset");
      if (i != -1) {
        break label931;
      }
      paramatmz.a(new NoColumnError("linkOffset", Integer.TYPE));
      label508:
      i = paramCursor.getColumnIndex("url");
      if (i != -1) {
        break label946;
      }
      paramatmz.a(new NoColumnError("url", String.class));
      label542:
      i = paramCursor.getColumnIndex("limitDayAIOCount");
      if (i != -1) {
        break label961;
      }
      paramatmz.a(new NoColumnError("limitDayAIOCount", Integer.TYPE));
      label577:
      i = paramCursor.getColumnIndex("limitDayAIOShowCount");
      if (i != -1) {
        break label976;
      }
      paramatmz.a(new NoColumnError("limitDayAIOShowCount", Integer.TYPE));
      label612:
      i = paramCursor.getColumnIndex("limitTotalAIOCount");
      if (i != -1) {
        break label991;
      }
      paramatmz.a(new NoColumnError("limitTotalAIOCount", Integer.TYPE));
      label647:
      i = paramCursor.getColumnIndex("limitTotalShowCount");
      if (i != -1) {
        break label1006;
      }
      paramatmz.a(new NoColumnError("limitTotalShowCount", Integer.TYPE));
      label682:
      i = paramCursor.getColumnIndex("keywordString");
      if (i != -1) {
        break label1021;
      }
      paramatmz.a(new NoColumnError("keywordString", String.class));
      label716:
      i = paramCursor.getColumnIndex("begin");
      if (i != -1) {
        break label1036;
      }
      paramatmz.a(new NoColumnError("begin", String.class));
      label750:
      i = paramCursor.getColumnIndex("end");
      if (i != -1) {
        break label1051;
      }
      paramatmz.a(new NoColumnError("end", String.class));
      label784:
      i = paramCursor.getColumnIndex("frequencyTime");
      if (i != -1) {
        break label1066;
      }
      paramatmz.a(new NoColumnError("frequencyTime", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("frequencyMessage");
      if (i != -1) {
        break label1081;
      }
      paramatmz.a(new NoColumnError("frequencyMessage", Integer.TYPE));
      return paramatmo;
      paramatmo.taskid = paramCursor.getInt(i);
      break;
      label871:
      paramatmo.uinType = paramCursor.getInt(i);
      break label370;
      label886:
      paramatmo.tipType = paramCursor.getInt(i);
      break label405;
      label901:
      paramatmo.adwords = paramCursor.getString(i);
      break label439;
      label916:
      paramatmo.clickableWord = paramCursor.getString(i);
      break label473;
      label931:
      paramatmo.linkOffset = paramCursor.getInt(i);
      break label508;
      label946:
      paramatmo.url = paramCursor.getString(i);
      break label542;
      label961:
      paramatmo.limitDayAIOCount = paramCursor.getInt(i);
      break label577;
      label976:
      paramatmo.limitDayAIOShowCount = paramCursor.getInt(i);
      break label612;
      label991:
      paramatmo.limitTotalAIOCount = paramCursor.getInt(i);
      break label647;
      label1006:
      paramatmo.limitTotalShowCount = paramCursor.getInt(i);
      break label682;
      label1021:
      paramatmo.keywordString = paramCursor.getString(i);
      break label716;
      label1036:
      paramatmo.begin = paramCursor.getString(i);
      break label750;
      label1051:
      paramatmo.end = paramCursor.getString(i);
      break label784;
      label1066:
      paramatmo.frequencyTime = paramCursor.getInt(i);
    }
    label1081:
    paramatmo.frequencyMessage = paramCursor.getInt(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,taskid INTEGER ,uinType INTEGER ,tipType INTEGER ,adwords TEXT ,clickableWord TEXT ,linkOffset INTEGER ,url TEXT ,limitDayAIOCount INTEGER ,limitDayAIOShowCount INTEGER ,limitTotalAIOCount INTEGER ,limitTotalShowCount INTEGER ,keywordString TEXT ,begin TEXT ,end TEXT ,frequencyTime INTEGER ,frequencyMessage INTEGER,UNIQUE(taskid) ON CONFLICT REPLACE)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (QQOperationViopTipTask)paramatmo;
    paramContentValues.put("taskid", Integer.valueOf(paramatmo.taskid));
    paramContentValues.put("uinType", Integer.valueOf(paramatmo.uinType));
    paramContentValues.put("tipType", Integer.valueOf(paramatmo.tipType));
    paramContentValues.put("adwords", paramatmo.adwords);
    paramContentValues.put("clickableWord", paramatmo.clickableWord);
    paramContentValues.put("linkOffset", Integer.valueOf(paramatmo.linkOffset));
    paramContentValues.put("url", paramatmo.url);
    paramContentValues.put("limitDayAIOCount", Integer.valueOf(paramatmo.limitDayAIOCount));
    paramContentValues.put("limitDayAIOShowCount", Integer.valueOf(paramatmo.limitDayAIOShowCount));
    paramContentValues.put("limitTotalAIOCount", Integer.valueOf(paramatmo.limitTotalAIOCount));
    paramContentValues.put("limitTotalShowCount", Integer.valueOf(paramatmo.limitTotalShowCount));
    paramContentValues.put("keywordString", paramatmo.keywordString);
    paramContentValues.put("begin", paramatmo.begin);
    paramContentValues.put("end", paramatmo.end);
    paramContentValues.put("frequencyTime", Integer.valueOf(paramatmo.frequencyTime));
    paramContentValues.put("frequencyMessage", Integer.valueOf(paramatmo.frequencyMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atnf
 * JD-Core Version:    0.7.0.1
 */