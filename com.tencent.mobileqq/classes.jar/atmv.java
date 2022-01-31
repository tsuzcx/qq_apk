import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atmv
  extends atna
{
  public atmv()
  {
    this.a = 7;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    paramatmo = (Groups)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.group_name = paramCursor.getString(paramCursor.getColumnIndex("group_name"));
      paramatmo.group_id = paramCursor.getInt(paramCursor.getColumnIndex("group_id"));
      paramatmo.group_friend_count = paramCursor.getInt(paramCursor.getColumnIndex("group_friend_count"));
      paramatmo.group_online_friend_count = paramCursor.getInt(paramCursor.getColumnIndex("group_online_friend_count"));
      paramatmo.seqid = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("seqid")));
      paramatmo.sqqOnLine_count = paramCursor.getInt(paramCursor.getColumnIndex("sqqOnLine_count"));
      paramatmo.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
      return paramatmo;
    }
    int i = paramCursor.getColumnIndex("group_name");
    if (i == -1)
    {
      paramatmz.a(new NoColumnError("group_name", String.class));
      i = paramCursor.getColumnIndex("group_id");
      if (i != -1) {
        break label400;
      }
      paramatmz.a(new NoColumnError("group_id", Integer.TYPE));
      label208:
      i = paramCursor.getColumnIndex("group_friend_count");
      if (i != -1) {
        break label415;
      }
      paramatmz.a(new NoColumnError("group_friend_count", Integer.TYPE));
      label243:
      i = paramCursor.getColumnIndex("group_online_friend_count");
      if (i != -1) {
        break label430;
      }
      paramatmz.a(new NoColumnError("group_online_friend_count", Integer.TYPE));
      label278:
      i = paramCursor.getColumnIndex("seqid");
      if (i != -1) {
        break label445;
      }
      paramatmz.a(new NoColumnError("seqid", Byte.TYPE));
      label313:
      i = paramCursor.getColumnIndex("sqqOnLine_count");
      if (i != -1) {
        break label461;
      }
      paramatmz.a(new NoColumnError("sqqOnLine_count", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label476;
      }
      paramatmz.a(new NoColumnError("datetime", Long.TYPE));
      return paramatmo;
      paramatmo.group_name = paramCursor.getString(i);
      break;
      label400:
      paramatmo.group_id = paramCursor.getInt(i);
      break label208;
      label415:
      paramatmo.group_friend_count = paramCursor.getInt(i);
      break label243;
      label430:
      paramatmo.group_online_friend_count = paramCursor.getInt(i);
      break label278;
      label445:
      paramatmo.seqid = ((byte)paramCursor.getShort(i));
      break label313;
      label461:
      paramatmo.sqqOnLine_count = paramCursor.getInt(i);
    }
    label476:
    paramatmo.datetime = paramCursor.getLong(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,group_name TEXT ,group_id INTEGER UNIQUE ,group_friend_count INTEGER ,group_online_friend_count INTEGER ,seqid INTEGER ,sqqOnLine_count INTEGER ,datetime INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (Groups)paramatmo;
    paramContentValues.put("group_name", paramatmo.group_name);
    paramContentValues.put("group_id", Integer.valueOf(paramatmo.group_id));
    paramContentValues.put("group_friend_count", Integer.valueOf(paramatmo.group_friend_count));
    paramContentValues.put("group_online_friend_count", Integer.valueOf(paramatmo.group_online_friend_count));
    paramContentValues.put("seqid", Byte.valueOf(paramatmo.seqid));
    paramContentValues.put("sqqOnLine_count", Integer.valueOf(paramatmo.sqqOnLine_count));
    paramContentValues.put("datetime", Long.valueOf(paramatmo.datetime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atmv
 * JD-Core Version:    0.7.0.1
 */