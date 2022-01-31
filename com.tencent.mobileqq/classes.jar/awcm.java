import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awcm
  extends awch
{
  public awcm()
  {
    this.a = 16;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    paramawbv = (QQOperationViopTipTask)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.taskid = paramCursor.getInt(paramCursor.getColumnIndex("taskid"));
      paramawbv.uinType = paramCursor.getInt(paramCursor.getColumnIndex("uinType"));
      paramawbv.tipType = paramCursor.getInt(paramCursor.getColumnIndex("tipType"));
      paramawbv.adwords = paramCursor.getString(paramCursor.getColumnIndex("adwords"));
      paramawbv.clickableWord = paramCursor.getString(paramCursor.getColumnIndex("clickableWord"));
      paramawbv.linkOffset = paramCursor.getInt(paramCursor.getColumnIndex("linkOffset"));
      paramawbv.url = paramCursor.getString(paramCursor.getColumnIndex("url"));
      paramawbv.limitDayAIOCount = paramCursor.getInt(paramCursor.getColumnIndex("limitDayAIOCount"));
      paramawbv.limitDayAIOShowCount = paramCursor.getInt(paramCursor.getColumnIndex("limitDayAIOShowCount"));
      paramawbv.limitTotalAIOCount = paramCursor.getInt(paramCursor.getColumnIndex("limitTotalAIOCount"));
      paramawbv.limitTotalShowCount = paramCursor.getInt(paramCursor.getColumnIndex("limitTotalShowCount"));
      paramawbv.keywordString = paramCursor.getString(paramCursor.getColumnIndex("keywordString"));
      paramawbv.begin = paramCursor.getString(paramCursor.getColumnIndex("begin"));
      paramawbv.end = paramCursor.getString(paramCursor.getColumnIndex("end"));
      paramawbv.frequencyTime = paramCursor.getInt(paramCursor.getColumnIndex("frequencyTime"));
      paramawbv.frequencyMessage = paramCursor.getInt(paramCursor.getColumnIndex("frequencyMessage"));
      return paramawbv;
    }
    int i = paramCursor.getColumnIndex("taskid");
    if (i == -1)
    {
      paramawcg.a(new NoColumnError("taskid", Integer.TYPE));
      i = paramCursor.getColumnIndex("uinType");
      if (i != -1) {
        break label871;
      }
      paramawcg.a(new NoColumnError("uinType", Integer.TYPE));
      label370:
      i = paramCursor.getColumnIndex("tipType");
      if (i != -1) {
        break label886;
      }
      paramawcg.a(new NoColumnError("tipType", Integer.TYPE));
      label405:
      i = paramCursor.getColumnIndex("adwords");
      if (i != -1) {
        break label901;
      }
      paramawcg.a(new NoColumnError("adwords", String.class));
      label439:
      i = paramCursor.getColumnIndex("clickableWord");
      if (i != -1) {
        break label916;
      }
      paramawcg.a(new NoColumnError("clickableWord", String.class));
      label473:
      i = paramCursor.getColumnIndex("linkOffset");
      if (i != -1) {
        break label931;
      }
      paramawcg.a(new NoColumnError("linkOffset", Integer.TYPE));
      label508:
      i = paramCursor.getColumnIndex("url");
      if (i != -1) {
        break label946;
      }
      paramawcg.a(new NoColumnError("url", String.class));
      label542:
      i = paramCursor.getColumnIndex("limitDayAIOCount");
      if (i != -1) {
        break label961;
      }
      paramawcg.a(new NoColumnError("limitDayAIOCount", Integer.TYPE));
      label577:
      i = paramCursor.getColumnIndex("limitDayAIOShowCount");
      if (i != -1) {
        break label976;
      }
      paramawcg.a(new NoColumnError("limitDayAIOShowCount", Integer.TYPE));
      label612:
      i = paramCursor.getColumnIndex("limitTotalAIOCount");
      if (i != -1) {
        break label991;
      }
      paramawcg.a(new NoColumnError("limitTotalAIOCount", Integer.TYPE));
      label647:
      i = paramCursor.getColumnIndex("limitTotalShowCount");
      if (i != -1) {
        break label1006;
      }
      paramawcg.a(new NoColumnError("limitTotalShowCount", Integer.TYPE));
      label682:
      i = paramCursor.getColumnIndex("keywordString");
      if (i != -1) {
        break label1021;
      }
      paramawcg.a(new NoColumnError("keywordString", String.class));
      label716:
      i = paramCursor.getColumnIndex("begin");
      if (i != -1) {
        break label1036;
      }
      paramawcg.a(new NoColumnError("begin", String.class));
      label750:
      i = paramCursor.getColumnIndex("end");
      if (i != -1) {
        break label1051;
      }
      paramawcg.a(new NoColumnError("end", String.class));
      label784:
      i = paramCursor.getColumnIndex("frequencyTime");
      if (i != -1) {
        break label1066;
      }
      paramawcg.a(new NoColumnError("frequencyTime", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("frequencyMessage");
      if (i != -1) {
        break label1081;
      }
      paramawcg.a(new NoColumnError("frequencyMessage", Integer.TYPE));
      return paramawbv;
      paramawbv.taskid = paramCursor.getInt(i);
      break;
      label871:
      paramawbv.uinType = paramCursor.getInt(i);
      break label370;
      label886:
      paramawbv.tipType = paramCursor.getInt(i);
      break label405;
      label901:
      paramawbv.adwords = paramCursor.getString(i);
      break label439;
      label916:
      paramawbv.clickableWord = paramCursor.getString(i);
      break label473;
      label931:
      paramawbv.linkOffset = paramCursor.getInt(i);
      break label508;
      label946:
      paramawbv.url = paramCursor.getString(i);
      break label542;
      label961:
      paramawbv.limitDayAIOCount = paramCursor.getInt(i);
      break label577;
      label976:
      paramawbv.limitDayAIOShowCount = paramCursor.getInt(i);
      break label612;
      label991:
      paramawbv.limitTotalAIOCount = paramCursor.getInt(i);
      break label647;
      label1006:
      paramawbv.limitTotalShowCount = paramCursor.getInt(i);
      break label682;
      label1021:
      paramawbv.keywordString = paramCursor.getString(i);
      break label716;
      label1036:
      paramawbv.begin = paramCursor.getString(i);
      break label750;
      label1051:
      paramawbv.end = paramCursor.getString(i);
      break label784;
      label1066:
      paramawbv.frequencyTime = paramCursor.getInt(i);
    }
    label1081:
    paramawbv.frequencyMessage = paramCursor.getInt(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,taskid INTEGER ,uinType INTEGER ,tipType INTEGER ,adwords TEXT ,clickableWord TEXT ,linkOffset INTEGER ,url TEXT ,limitDayAIOCount INTEGER ,limitDayAIOShowCount INTEGER ,limitTotalAIOCount INTEGER ,limitTotalShowCount INTEGER ,keywordString TEXT ,begin TEXT ,end TEXT ,frequencyTime INTEGER ,frequencyMessage INTEGER,UNIQUE(taskid) ON CONFLICT REPLACE)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (QQOperationViopTipTask)paramawbv;
    paramContentValues.put("taskid", Integer.valueOf(paramawbv.taskid));
    paramContentValues.put("uinType", Integer.valueOf(paramawbv.uinType));
    paramContentValues.put("tipType", Integer.valueOf(paramawbv.tipType));
    paramContentValues.put("adwords", paramawbv.adwords);
    paramContentValues.put("clickableWord", paramawbv.clickableWord);
    paramContentValues.put("linkOffset", Integer.valueOf(paramawbv.linkOffset));
    paramContentValues.put("url", paramawbv.url);
    paramContentValues.put("limitDayAIOCount", Integer.valueOf(paramawbv.limitDayAIOCount));
    paramContentValues.put("limitDayAIOShowCount", Integer.valueOf(paramawbv.limitDayAIOShowCount));
    paramContentValues.put("limitTotalAIOCount", Integer.valueOf(paramawbv.limitTotalAIOCount));
    paramContentValues.put("limitTotalShowCount", Integer.valueOf(paramawbv.limitTotalShowCount));
    paramContentValues.put("keywordString", paramawbv.keywordString);
    paramContentValues.put("begin", paramawbv.begin);
    paramContentValues.put("end", paramawbv.end);
    paramContentValues.put("frequencyTime", Integer.valueOf(paramawbv.frequencyTime));
    paramContentValues.put("frequencyMessage", Integer.valueOf(paramawbv.frequencyMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awcm
 * JD-Core Version:    0.7.0.1
 */