import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukt
  extends auky
{
  public aukt()
  {
    this.a = 7;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    paramaukm = (Groups)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.group_name = paramCursor.getString(paramCursor.getColumnIndex("group_name"));
      paramaukm.group_id = paramCursor.getInt(paramCursor.getColumnIndex("group_id"));
      paramaukm.group_friend_count = paramCursor.getInt(paramCursor.getColumnIndex("group_friend_count"));
      paramaukm.group_online_friend_count = paramCursor.getInt(paramCursor.getColumnIndex("group_online_friend_count"));
      paramaukm.seqid = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("seqid")));
      paramaukm.sqqOnLine_count = paramCursor.getInt(paramCursor.getColumnIndex("sqqOnLine_count"));
      paramaukm.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
      return paramaukm;
    }
    int i = paramCursor.getColumnIndex("group_name");
    if (i == -1)
    {
      paramaukx.a(new NoColumnError("group_name", String.class));
      i = paramCursor.getColumnIndex("group_id");
      if (i != -1) {
        break label400;
      }
      paramaukx.a(new NoColumnError("group_id", Integer.TYPE));
      label208:
      i = paramCursor.getColumnIndex("group_friend_count");
      if (i != -1) {
        break label415;
      }
      paramaukx.a(new NoColumnError("group_friend_count", Integer.TYPE));
      label243:
      i = paramCursor.getColumnIndex("group_online_friend_count");
      if (i != -1) {
        break label430;
      }
      paramaukx.a(new NoColumnError("group_online_friend_count", Integer.TYPE));
      label278:
      i = paramCursor.getColumnIndex("seqid");
      if (i != -1) {
        break label445;
      }
      paramaukx.a(new NoColumnError("seqid", Byte.TYPE));
      label313:
      i = paramCursor.getColumnIndex("sqqOnLine_count");
      if (i != -1) {
        break label461;
      }
      paramaukx.a(new NoColumnError("sqqOnLine_count", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label476;
      }
      paramaukx.a(new NoColumnError("datetime", Long.TYPE));
      return paramaukm;
      paramaukm.group_name = paramCursor.getString(i);
      break;
      label400:
      paramaukm.group_id = paramCursor.getInt(i);
      break label208;
      label415:
      paramaukm.group_friend_count = paramCursor.getInt(i);
      break label243;
      label430:
      paramaukm.group_online_friend_count = paramCursor.getInt(i);
      break label278;
      label445:
      paramaukm.seqid = ((byte)paramCursor.getShort(i));
      break label313;
      label461:
      paramaukm.sqqOnLine_count = paramCursor.getInt(i);
    }
    label476:
    paramaukm.datetime = paramCursor.getLong(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,group_name TEXT ,group_id INTEGER UNIQUE ,group_friend_count INTEGER ,group_online_friend_count INTEGER ,seqid INTEGER ,sqqOnLine_count INTEGER ,datetime INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (Groups)paramaukm;
    paramContentValues.put("group_name", paramaukm.group_name);
    paramContentValues.put("group_id", Integer.valueOf(paramaukm.group_id));
    paramContentValues.put("group_friend_count", Integer.valueOf(paramaukm.group_friend_count));
    paramContentValues.put("group_online_friend_count", Integer.valueOf(paramaukm.group_online_friend_count));
    paramContentValues.put("seqid", Byte.valueOf(paramaukm.seqid));
    paramContentValues.put("sqqOnLine_count", Integer.valueOf(paramaukm.sqqOnLine_count));
    paramContentValues.put("datetime", Long.valueOf(paramaukm.datetime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukt
 * JD-Core Version:    0.7.0.1
 */