import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atmk
  extends atna
{
  public atmk()
  {
    this.a = 7;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    paramatmo = (DiscussionMemberInfo)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.discussionUin = paramCursor.getString(paramCursor.getColumnIndex("discussionUin"));
      paramatmo.memberUin = paramCursor.getString(paramCursor.getColumnIndex("memberUin"));
      paramatmo.memberName = paramCursor.getString(paramCursor.getColumnIndex("memberName"));
      paramatmo.flag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("flag")));
      paramatmo.dataTime = paramCursor.getLong(paramCursor.getColumnIndex("dataTime"));
      paramatmo.inteRemark = paramCursor.getString(paramCursor.getColumnIndex("inteRemark"));
      paramatmo.inteRemarkSource = paramCursor.getLong(paramCursor.getColumnIndex("inteRemarkSource"));
      return paramatmo;
    }
    int i = paramCursor.getColumnIndex("discussionUin");
    if (i == -1)
    {
      paramatmz.a(new NoColumnError("discussionUin", String.class));
      i = paramCursor.getColumnIndex("memberUin");
      if (i != -1) {
        break label397;
      }
      paramatmz.a(new NoColumnError("memberUin", String.class));
      label207:
      i = paramCursor.getColumnIndex("memberName");
      if (i != -1) {
        break label412;
      }
      paramatmz.a(new NoColumnError("memberName", String.class));
      label241:
      i = paramCursor.getColumnIndex("flag");
      if (i != -1) {
        break label427;
      }
      paramatmz.a(new NoColumnError("flag", Byte.TYPE));
      label276:
      i = paramCursor.getColumnIndex("dataTime");
      if (i != -1) {
        break label443;
      }
      paramatmz.a(new NoColumnError("dataTime", Long.TYPE));
      label311:
      i = paramCursor.getColumnIndex("inteRemark");
      if (i != -1) {
        break label458;
      }
      paramatmz.a(new NoColumnError("inteRemark", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("inteRemarkSource");
      if (i != -1) {
        break label473;
      }
      paramatmz.a(new NoColumnError("inteRemarkSource", Long.TYPE));
      return paramatmo;
      paramatmo.discussionUin = paramCursor.getString(i);
      break;
      label397:
      paramatmo.memberUin = paramCursor.getString(i);
      break label207;
      label412:
      paramatmo.memberName = paramCursor.getString(i);
      break label241;
      label427:
      paramatmo.flag = ((byte)paramCursor.getShort(i));
      break label276;
      label443:
      paramatmo.dataTime = paramCursor.getLong(i);
      break label311;
      label458:
      paramatmo.inteRemark = paramCursor.getString(i);
    }
    label473:
    paramatmo.inteRemarkSource = paramCursor.getLong(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,discussionUin TEXT ,memberUin TEXT ,memberName TEXT ,flag INTEGER ,dataTime INTEGER ,inteRemark TEXT ,inteRemarkSource INTEGER,UNIQUE(discussionUin,memberUin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (DiscussionMemberInfo)paramatmo;
    paramContentValues.put("discussionUin", paramatmo.discussionUin);
    paramContentValues.put("memberUin", paramatmo.memberUin);
    paramContentValues.put("memberName", paramatmo.memberName);
    paramContentValues.put("flag", Byte.valueOf(paramatmo.flag));
    paramContentValues.put("dataTime", Long.valueOf(paramatmo.dataTime));
    paramContentValues.put("inteRemark", paramatmo.inteRemark);
    paramContentValues.put("inteRemarkSource", Long.valueOf(paramatmo.inteRemarkSource));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atmk
 * JD-Core Version:    0.7.0.1
 */