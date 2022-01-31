import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awga
  extends awgq
{
  public awga()
  {
    this.a = 7;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    paramawge = (DiscussionMemberInfo)paramawge;
    if (paramawgp == null)
    {
      paramawge.discussionUin = paramCursor.getString(paramCursor.getColumnIndex("discussionUin"));
      paramawge.memberUin = paramCursor.getString(paramCursor.getColumnIndex("memberUin"));
      paramawge.memberName = paramCursor.getString(paramCursor.getColumnIndex("memberName"));
      paramawge.flag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("flag")));
      paramawge.dataTime = paramCursor.getLong(paramCursor.getColumnIndex("dataTime"));
      paramawge.inteRemark = paramCursor.getString(paramCursor.getColumnIndex("inteRemark"));
      paramawge.inteRemarkSource = paramCursor.getLong(paramCursor.getColumnIndex("inteRemarkSource"));
      return paramawge;
    }
    int i = paramCursor.getColumnIndex("discussionUin");
    if (i == -1)
    {
      paramawgp.a(new NoColumnError("discussionUin", String.class));
      i = paramCursor.getColumnIndex("memberUin");
      if (i != -1) {
        break label397;
      }
      paramawgp.a(new NoColumnError("memberUin", String.class));
      label207:
      i = paramCursor.getColumnIndex("memberName");
      if (i != -1) {
        break label412;
      }
      paramawgp.a(new NoColumnError("memberName", String.class));
      label241:
      i = paramCursor.getColumnIndex("flag");
      if (i != -1) {
        break label427;
      }
      paramawgp.a(new NoColumnError("flag", Byte.TYPE));
      label276:
      i = paramCursor.getColumnIndex("dataTime");
      if (i != -1) {
        break label443;
      }
      paramawgp.a(new NoColumnError("dataTime", Long.TYPE));
      label311:
      i = paramCursor.getColumnIndex("inteRemark");
      if (i != -1) {
        break label458;
      }
      paramawgp.a(new NoColumnError("inteRemark", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("inteRemarkSource");
      if (i != -1) {
        break label473;
      }
      paramawgp.a(new NoColumnError("inteRemarkSource", Long.TYPE));
      return paramawge;
      paramawge.discussionUin = paramCursor.getString(i);
      break;
      label397:
      paramawge.memberUin = paramCursor.getString(i);
      break label207;
      label412:
      paramawge.memberName = paramCursor.getString(i);
      break label241;
      label427:
      paramawge.flag = ((byte)paramCursor.getShort(i));
      break label276;
      label443:
      paramawge.dataTime = paramCursor.getLong(i);
      break label311;
      label458:
      paramawge.inteRemark = paramCursor.getString(i);
    }
    label473:
    paramawge.inteRemarkSource = paramCursor.getLong(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,discussionUin TEXT ,memberUin TEXT ,memberName TEXT ,flag INTEGER ,dataTime INTEGER ,inteRemark TEXT ,inteRemarkSource INTEGER,UNIQUE(discussionUin,memberUin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (DiscussionMemberInfo)paramawge;
    paramContentValues.put("discussionUin", paramawge.discussionUin);
    paramContentValues.put("memberUin", paramawge.memberUin);
    paramContentValues.put("memberName", paramawge.memberName);
    paramContentValues.put("flag", Byte.valueOf(paramawge.flag));
    paramContentValues.put("dataTime", Long.valueOf(paramawge.dataTime));
    paramContentValues.put("inteRemark", paramawge.inteRemark);
    paramContentValues.put("inteRemarkSource", Long.valueOf(paramawge.inteRemarkSource));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awga
 * JD-Core Version:    0.7.0.1
 */