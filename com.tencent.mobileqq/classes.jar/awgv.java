import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awgv
  extends awgq
{
  public awgv()
  {
    this.a = 16;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    paramawge = (QQOperationViopTipTask)paramawge;
    if (paramawgp == null)
    {
      paramawge.taskid = paramCursor.getInt(paramCursor.getColumnIndex("taskid"));
      paramawge.uinType = paramCursor.getInt(paramCursor.getColumnIndex("uinType"));
      paramawge.tipType = paramCursor.getInt(paramCursor.getColumnIndex("tipType"));
      paramawge.adwords = paramCursor.getString(paramCursor.getColumnIndex("adwords"));
      paramawge.clickableWord = paramCursor.getString(paramCursor.getColumnIndex("clickableWord"));
      paramawge.linkOffset = paramCursor.getInt(paramCursor.getColumnIndex("linkOffset"));
      paramawge.url = paramCursor.getString(paramCursor.getColumnIndex("url"));
      paramawge.limitDayAIOCount = paramCursor.getInt(paramCursor.getColumnIndex("limitDayAIOCount"));
      paramawge.limitDayAIOShowCount = paramCursor.getInt(paramCursor.getColumnIndex("limitDayAIOShowCount"));
      paramawge.limitTotalAIOCount = paramCursor.getInt(paramCursor.getColumnIndex("limitTotalAIOCount"));
      paramawge.limitTotalShowCount = paramCursor.getInt(paramCursor.getColumnIndex("limitTotalShowCount"));
      paramawge.keywordString = paramCursor.getString(paramCursor.getColumnIndex("keywordString"));
      paramawge.begin = paramCursor.getString(paramCursor.getColumnIndex("begin"));
      paramawge.end = paramCursor.getString(paramCursor.getColumnIndex("end"));
      paramawge.frequencyTime = paramCursor.getInt(paramCursor.getColumnIndex("frequencyTime"));
      paramawge.frequencyMessage = paramCursor.getInt(paramCursor.getColumnIndex("frequencyMessage"));
      return paramawge;
    }
    int i = paramCursor.getColumnIndex("taskid");
    if (i == -1)
    {
      paramawgp.a(new NoColumnError("taskid", Integer.TYPE));
      i = paramCursor.getColumnIndex("uinType");
      if (i != -1) {
        break label871;
      }
      paramawgp.a(new NoColumnError("uinType", Integer.TYPE));
      label370:
      i = paramCursor.getColumnIndex("tipType");
      if (i != -1) {
        break label886;
      }
      paramawgp.a(new NoColumnError("tipType", Integer.TYPE));
      label405:
      i = paramCursor.getColumnIndex("adwords");
      if (i != -1) {
        break label901;
      }
      paramawgp.a(new NoColumnError("adwords", String.class));
      label439:
      i = paramCursor.getColumnIndex("clickableWord");
      if (i != -1) {
        break label916;
      }
      paramawgp.a(new NoColumnError("clickableWord", String.class));
      label473:
      i = paramCursor.getColumnIndex("linkOffset");
      if (i != -1) {
        break label931;
      }
      paramawgp.a(new NoColumnError("linkOffset", Integer.TYPE));
      label508:
      i = paramCursor.getColumnIndex("url");
      if (i != -1) {
        break label946;
      }
      paramawgp.a(new NoColumnError("url", String.class));
      label542:
      i = paramCursor.getColumnIndex("limitDayAIOCount");
      if (i != -1) {
        break label961;
      }
      paramawgp.a(new NoColumnError("limitDayAIOCount", Integer.TYPE));
      label577:
      i = paramCursor.getColumnIndex("limitDayAIOShowCount");
      if (i != -1) {
        break label976;
      }
      paramawgp.a(new NoColumnError("limitDayAIOShowCount", Integer.TYPE));
      label612:
      i = paramCursor.getColumnIndex("limitTotalAIOCount");
      if (i != -1) {
        break label991;
      }
      paramawgp.a(new NoColumnError("limitTotalAIOCount", Integer.TYPE));
      label647:
      i = paramCursor.getColumnIndex("limitTotalShowCount");
      if (i != -1) {
        break label1006;
      }
      paramawgp.a(new NoColumnError("limitTotalShowCount", Integer.TYPE));
      label682:
      i = paramCursor.getColumnIndex("keywordString");
      if (i != -1) {
        break label1021;
      }
      paramawgp.a(new NoColumnError("keywordString", String.class));
      label716:
      i = paramCursor.getColumnIndex("begin");
      if (i != -1) {
        break label1036;
      }
      paramawgp.a(new NoColumnError("begin", String.class));
      label750:
      i = paramCursor.getColumnIndex("end");
      if (i != -1) {
        break label1051;
      }
      paramawgp.a(new NoColumnError("end", String.class));
      label784:
      i = paramCursor.getColumnIndex("frequencyTime");
      if (i != -1) {
        break label1066;
      }
      paramawgp.a(new NoColumnError("frequencyTime", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("frequencyMessage");
      if (i != -1) {
        break label1081;
      }
      paramawgp.a(new NoColumnError("frequencyMessage", Integer.TYPE));
      return paramawge;
      paramawge.taskid = paramCursor.getInt(i);
      break;
      label871:
      paramawge.uinType = paramCursor.getInt(i);
      break label370;
      label886:
      paramawge.tipType = paramCursor.getInt(i);
      break label405;
      label901:
      paramawge.adwords = paramCursor.getString(i);
      break label439;
      label916:
      paramawge.clickableWord = paramCursor.getString(i);
      break label473;
      label931:
      paramawge.linkOffset = paramCursor.getInt(i);
      break label508;
      label946:
      paramawge.url = paramCursor.getString(i);
      break label542;
      label961:
      paramawge.limitDayAIOCount = paramCursor.getInt(i);
      break label577;
      label976:
      paramawge.limitDayAIOShowCount = paramCursor.getInt(i);
      break label612;
      label991:
      paramawge.limitTotalAIOCount = paramCursor.getInt(i);
      break label647;
      label1006:
      paramawge.limitTotalShowCount = paramCursor.getInt(i);
      break label682;
      label1021:
      paramawge.keywordString = paramCursor.getString(i);
      break label716;
      label1036:
      paramawge.begin = paramCursor.getString(i);
      break label750;
      label1051:
      paramawge.end = paramCursor.getString(i);
      break label784;
      label1066:
      paramawge.frequencyTime = paramCursor.getInt(i);
    }
    label1081:
    paramawge.frequencyMessage = paramCursor.getInt(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,taskid INTEGER ,uinType INTEGER ,tipType INTEGER ,adwords TEXT ,clickableWord TEXT ,linkOffset INTEGER ,url TEXT ,limitDayAIOCount INTEGER ,limitDayAIOShowCount INTEGER ,limitTotalAIOCount INTEGER ,limitTotalShowCount INTEGER ,keywordString TEXT ,begin TEXT ,end TEXT ,frequencyTime INTEGER ,frequencyMessage INTEGER,UNIQUE(taskid) ON CONFLICT REPLACE)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (QQOperationViopTipTask)paramawge;
    paramContentValues.put("taskid", Integer.valueOf(paramawge.taskid));
    paramContentValues.put("uinType", Integer.valueOf(paramawge.uinType));
    paramContentValues.put("tipType", Integer.valueOf(paramawge.tipType));
    paramContentValues.put("adwords", paramawge.adwords);
    paramContentValues.put("clickableWord", paramawge.clickableWord);
    paramContentValues.put("linkOffset", Integer.valueOf(paramawge.linkOffset));
    paramContentValues.put("url", paramawge.url);
    paramContentValues.put("limitDayAIOCount", Integer.valueOf(paramawge.limitDayAIOCount));
    paramContentValues.put("limitDayAIOShowCount", Integer.valueOf(paramawge.limitDayAIOShowCount));
    paramContentValues.put("limitTotalAIOCount", Integer.valueOf(paramawge.limitTotalAIOCount));
    paramContentValues.put("limitTotalShowCount", Integer.valueOf(paramawge.limitTotalShowCount));
    paramContentValues.put("keywordString", paramawge.keywordString);
    paramContentValues.put("begin", paramawge.begin);
    paramContentValues.put("end", paramawge.end);
    paramContentValues.put("frequencyTime", Integer.valueOf(paramawge.frequencyTime));
    paramContentValues.put("frequencyMessage", Integer.valueOf(paramawge.frequencyMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awgv
 * JD-Core Version:    0.7.0.1
 */