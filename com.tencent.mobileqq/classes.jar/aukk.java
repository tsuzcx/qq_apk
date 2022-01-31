import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukk
  extends aula
{
  public aukk()
  {
    this.a = 7;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    paramauko = (DiscussionMemberInfo)paramauko;
    if (paramaukz == null)
    {
      paramauko.discussionUin = paramCursor.getString(paramCursor.getColumnIndex("discussionUin"));
      paramauko.memberUin = paramCursor.getString(paramCursor.getColumnIndex("memberUin"));
      paramauko.memberName = paramCursor.getString(paramCursor.getColumnIndex("memberName"));
      paramauko.flag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("flag")));
      paramauko.dataTime = paramCursor.getLong(paramCursor.getColumnIndex("dataTime"));
      paramauko.inteRemark = paramCursor.getString(paramCursor.getColumnIndex("inteRemark"));
      paramauko.inteRemarkSource = paramCursor.getLong(paramCursor.getColumnIndex("inteRemarkSource"));
      return paramauko;
    }
    int i = paramCursor.getColumnIndex("discussionUin");
    if (i == -1)
    {
      paramaukz.a(new NoColumnError("discussionUin", String.class));
      i = paramCursor.getColumnIndex("memberUin");
      if (i != -1) {
        break label397;
      }
      paramaukz.a(new NoColumnError("memberUin", String.class));
      label207:
      i = paramCursor.getColumnIndex("memberName");
      if (i != -1) {
        break label412;
      }
      paramaukz.a(new NoColumnError("memberName", String.class));
      label241:
      i = paramCursor.getColumnIndex("flag");
      if (i != -1) {
        break label427;
      }
      paramaukz.a(new NoColumnError("flag", Byte.TYPE));
      label276:
      i = paramCursor.getColumnIndex("dataTime");
      if (i != -1) {
        break label443;
      }
      paramaukz.a(new NoColumnError("dataTime", Long.TYPE));
      label311:
      i = paramCursor.getColumnIndex("inteRemark");
      if (i != -1) {
        break label458;
      }
      paramaukz.a(new NoColumnError("inteRemark", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("inteRemarkSource");
      if (i != -1) {
        break label473;
      }
      paramaukz.a(new NoColumnError("inteRemarkSource", Long.TYPE));
      return paramauko;
      paramauko.discussionUin = paramCursor.getString(i);
      break;
      label397:
      paramauko.memberUin = paramCursor.getString(i);
      break label207;
      label412:
      paramauko.memberName = paramCursor.getString(i);
      break label241;
      label427:
      paramauko.flag = ((byte)paramCursor.getShort(i));
      break label276;
      label443:
      paramauko.dataTime = paramCursor.getLong(i);
      break label311;
      label458:
      paramauko.inteRemark = paramCursor.getString(i);
    }
    label473:
    paramauko.inteRemarkSource = paramCursor.getLong(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,discussionUin TEXT ,memberUin TEXT ,memberName TEXT ,flag INTEGER ,dataTime INTEGER ,inteRemark TEXT ,inteRemarkSource INTEGER,UNIQUE(discussionUin,memberUin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (DiscussionMemberInfo)paramauko;
    paramContentValues.put("discussionUin", paramauko.discussionUin);
    paramContentValues.put("memberUin", paramauko.memberUin);
    paramContentValues.put("memberName", paramauko.memberName);
    paramContentValues.put("flag", Byte.valueOf(paramauko.flag));
    paramContentValues.put("dataTime", Long.valueOf(paramauko.dataTime));
    paramContentValues.put("inteRemark", paramauko.inteRemark);
    paramContentValues.put("inteRemarkSource", Long.valueOf(paramauko.inteRemarkSource));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukk
 * JD-Core Version:    0.7.0.1
 */