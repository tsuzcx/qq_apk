import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukv
  extends aula
{
  public aukv()
  {
    this.a = 7;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    paramauko = (Groups)paramauko;
    if (paramaukz == null)
    {
      paramauko.group_name = paramCursor.getString(paramCursor.getColumnIndex("group_name"));
      paramauko.group_id = paramCursor.getInt(paramCursor.getColumnIndex("group_id"));
      paramauko.group_friend_count = paramCursor.getInt(paramCursor.getColumnIndex("group_friend_count"));
      paramauko.group_online_friend_count = paramCursor.getInt(paramCursor.getColumnIndex("group_online_friend_count"));
      paramauko.seqid = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("seqid")));
      paramauko.sqqOnLine_count = paramCursor.getInt(paramCursor.getColumnIndex("sqqOnLine_count"));
      paramauko.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
      return paramauko;
    }
    int i = paramCursor.getColumnIndex("group_name");
    if (i == -1)
    {
      paramaukz.a(new NoColumnError("group_name", String.class));
      i = paramCursor.getColumnIndex("group_id");
      if (i != -1) {
        break label400;
      }
      paramaukz.a(new NoColumnError("group_id", Integer.TYPE));
      label208:
      i = paramCursor.getColumnIndex("group_friend_count");
      if (i != -1) {
        break label415;
      }
      paramaukz.a(new NoColumnError("group_friend_count", Integer.TYPE));
      label243:
      i = paramCursor.getColumnIndex("group_online_friend_count");
      if (i != -1) {
        break label430;
      }
      paramaukz.a(new NoColumnError("group_online_friend_count", Integer.TYPE));
      label278:
      i = paramCursor.getColumnIndex("seqid");
      if (i != -1) {
        break label445;
      }
      paramaukz.a(new NoColumnError("seqid", Byte.TYPE));
      label313:
      i = paramCursor.getColumnIndex("sqqOnLine_count");
      if (i != -1) {
        break label461;
      }
      paramaukz.a(new NoColumnError("sqqOnLine_count", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label476;
      }
      paramaukz.a(new NoColumnError("datetime", Long.TYPE));
      return paramauko;
      paramauko.group_name = paramCursor.getString(i);
      break;
      label400:
      paramauko.group_id = paramCursor.getInt(i);
      break label208;
      label415:
      paramauko.group_friend_count = paramCursor.getInt(i);
      break label243;
      label430:
      paramauko.group_online_friend_count = paramCursor.getInt(i);
      break label278;
      label445:
      paramauko.seqid = ((byte)paramCursor.getShort(i));
      break label313;
      label461:
      paramauko.sqqOnLine_count = paramCursor.getInt(i);
    }
    label476:
    paramauko.datetime = paramCursor.getLong(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,group_name TEXT ,group_id INTEGER UNIQUE ,group_friend_count INTEGER ,group_online_friend_count INTEGER ,seqid INTEGER ,sqqOnLine_count INTEGER ,datetime INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (Groups)paramauko;
    paramContentValues.put("group_name", paramauko.group_name);
    paramContentValues.put("group_id", Integer.valueOf(paramauko.group_id));
    paramContentValues.put("group_friend_count", Integer.valueOf(paramauko.group_friend_count));
    paramContentValues.put("group_online_friend_count", Integer.valueOf(paramauko.group_online_friend_count));
    paramContentValues.put("seqid", Byte.valueOf(paramauko.seqid));
    paramContentValues.put("sqqOnLine_count", Integer.valueOf(paramauko.sqqOnLine_count));
    paramContentValues.put("datetime", Long.valueOf(paramauko.datetime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukv
 * JD-Core Version:    0.7.0.1
 */