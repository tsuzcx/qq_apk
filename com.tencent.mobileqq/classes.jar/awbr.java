import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awbr
  extends awch
{
  public awbr()
  {
    this.a = 7;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    paramawbv = (DiscussionMemberInfo)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.discussionUin = paramCursor.getString(paramCursor.getColumnIndex("discussionUin"));
      paramawbv.memberUin = paramCursor.getString(paramCursor.getColumnIndex("memberUin"));
      paramawbv.memberName = paramCursor.getString(paramCursor.getColumnIndex("memberName"));
      paramawbv.flag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("flag")));
      paramawbv.dataTime = paramCursor.getLong(paramCursor.getColumnIndex("dataTime"));
      paramawbv.inteRemark = paramCursor.getString(paramCursor.getColumnIndex("inteRemark"));
      paramawbv.inteRemarkSource = paramCursor.getLong(paramCursor.getColumnIndex("inteRemarkSource"));
      return paramawbv;
    }
    int i = paramCursor.getColumnIndex("discussionUin");
    if (i == -1)
    {
      paramawcg.a(new NoColumnError("discussionUin", String.class));
      i = paramCursor.getColumnIndex("memberUin");
      if (i != -1) {
        break label397;
      }
      paramawcg.a(new NoColumnError("memberUin", String.class));
      label207:
      i = paramCursor.getColumnIndex("memberName");
      if (i != -1) {
        break label412;
      }
      paramawcg.a(new NoColumnError("memberName", String.class));
      label241:
      i = paramCursor.getColumnIndex("flag");
      if (i != -1) {
        break label427;
      }
      paramawcg.a(new NoColumnError("flag", Byte.TYPE));
      label276:
      i = paramCursor.getColumnIndex("dataTime");
      if (i != -1) {
        break label443;
      }
      paramawcg.a(new NoColumnError("dataTime", Long.TYPE));
      label311:
      i = paramCursor.getColumnIndex("inteRemark");
      if (i != -1) {
        break label458;
      }
      paramawcg.a(new NoColumnError("inteRemark", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("inteRemarkSource");
      if (i != -1) {
        break label473;
      }
      paramawcg.a(new NoColumnError("inteRemarkSource", Long.TYPE));
      return paramawbv;
      paramawbv.discussionUin = paramCursor.getString(i);
      break;
      label397:
      paramawbv.memberUin = paramCursor.getString(i);
      break label207;
      label412:
      paramawbv.memberName = paramCursor.getString(i);
      break label241;
      label427:
      paramawbv.flag = ((byte)paramCursor.getShort(i));
      break label276;
      label443:
      paramawbv.dataTime = paramCursor.getLong(i);
      break label311;
      label458:
      paramawbv.inteRemark = paramCursor.getString(i);
    }
    label473:
    paramawbv.inteRemarkSource = paramCursor.getLong(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,discussionUin TEXT ,memberUin TEXT ,memberName TEXT ,flag INTEGER ,dataTime INTEGER ,inteRemark TEXT ,inteRemarkSource INTEGER,UNIQUE(discussionUin,memberUin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (DiscussionMemberInfo)paramawbv;
    paramContentValues.put("discussionUin", paramawbv.discussionUin);
    paramContentValues.put("memberUin", paramawbv.memberUin);
    paramContentValues.put("memberName", paramawbv.memberName);
    paramContentValues.put("flag", Byte.valueOf(paramawbv.flag));
    paramContentValues.put("dataTime", Long.valueOf(paramawbv.dataTime));
    paramContentValues.put("inteRemark", paramawbv.inteRemark);
    paramContentValues.put("inteRemarkSource", Long.valueOf(paramawbv.inteRemarkSource));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awbr
 * JD-Core Version:    0.7.0.1
 */