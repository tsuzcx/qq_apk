import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class auki
  extends auky
{
  public auki()
  {
    this.a = 7;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    paramaukm = (DiscussionMemberInfo)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.discussionUin = paramCursor.getString(paramCursor.getColumnIndex("discussionUin"));
      paramaukm.memberUin = paramCursor.getString(paramCursor.getColumnIndex("memberUin"));
      paramaukm.memberName = paramCursor.getString(paramCursor.getColumnIndex("memberName"));
      paramaukm.flag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("flag")));
      paramaukm.dataTime = paramCursor.getLong(paramCursor.getColumnIndex("dataTime"));
      paramaukm.inteRemark = paramCursor.getString(paramCursor.getColumnIndex("inteRemark"));
      paramaukm.inteRemarkSource = paramCursor.getLong(paramCursor.getColumnIndex("inteRemarkSource"));
      return paramaukm;
    }
    int i = paramCursor.getColumnIndex("discussionUin");
    if (i == -1)
    {
      paramaukx.a(new NoColumnError("discussionUin", String.class));
      i = paramCursor.getColumnIndex("memberUin");
      if (i != -1) {
        break label397;
      }
      paramaukx.a(new NoColumnError("memberUin", String.class));
      label207:
      i = paramCursor.getColumnIndex("memberName");
      if (i != -1) {
        break label412;
      }
      paramaukx.a(new NoColumnError("memberName", String.class));
      label241:
      i = paramCursor.getColumnIndex("flag");
      if (i != -1) {
        break label427;
      }
      paramaukx.a(new NoColumnError("flag", Byte.TYPE));
      label276:
      i = paramCursor.getColumnIndex("dataTime");
      if (i != -1) {
        break label443;
      }
      paramaukx.a(new NoColumnError("dataTime", Long.TYPE));
      label311:
      i = paramCursor.getColumnIndex("inteRemark");
      if (i != -1) {
        break label458;
      }
      paramaukx.a(new NoColumnError("inteRemark", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("inteRemarkSource");
      if (i != -1) {
        break label473;
      }
      paramaukx.a(new NoColumnError("inteRemarkSource", Long.TYPE));
      return paramaukm;
      paramaukm.discussionUin = paramCursor.getString(i);
      break;
      label397:
      paramaukm.memberUin = paramCursor.getString(i);
      break label207;
      label412:
      paramaukm.memberName = paramCursor.getString(i);
      break label241;
      label427:
      paramaukm.flag = ((byte)paramCursor.getShort(i));
      break label276;
      label443:
      paramaukm.dataTime = paramCursor.getLong(i);
      break label311;
      label458:
      paramaukm.inteRemark = paramCursor.getString(i);
    }
    label473:
    paramaukm.inteRemarkSource = paramCursor.getLong(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,discussionUin TEXT ,memberUin TEXT ,memberName TEXT ,flag INTEGER ,dataTime INTEGER ,inteRemark TEXT ,inteRemarkSource INTEGER,UNIQUE(discussionUin,memberUin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (DiscussionMemberInfo)paramaukm;
    paramContentValues.put("discussionUin", paramaukm.discussionUin);
    paramContentValues.put("memberUin", paramaukm.memberUin);
    paramContentValues.put("memberName", paramaukm.memberName);
    paramContentValues.put("flag", Byte.valueOf(paramaukm.flag));
    paramContentValues.put("dataTime", Long.valueOf(paramaukm.dataTime));
    paramContentValues.put("inteRemark", paramaukm.inteRemark);
    paramContentValues.put("inteRemarkSource", Long.valueOf(paramaukm.inteRemarkSource));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auki
 * JD-Core Version:    0.7.0.1
 */