import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awgl
  extends awgq
{
  public awgl()
  {
    this.a = 7;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    paramawge = (Groups)paramawge;
    if (paramawgp == null)
    {
      paramawge.group_name = paramCursor.getString(paramCursor.getColumnIndex("group_name"));
      paramawge.group_id = paramCursor.getInt(paramCursor.getColumnIndex("group_id"));
      paramawge.group_friend_count = paramCursor.getInt(paramCursor.getColumnIndex("group_friend_count"));
      paramawge.group_online_friend_count = paramCursor.getInt(paramCursor.getColumnIndex("group_online_friend_count"));
      paramawge.seqid = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("seqid")));
      paramawge.sqqOnLine_count = paramCursor.getInt(paramCursor.getColumnIndex("sqqOnLine_count"));
      paramawge.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
      return paramawge;
    }
    int i = paramCursor.getColumnIndex("group_name");
    if (i == -1)
    {
      paramawgp.a(new NoColumnError("group_name", String.class));
      i = paramCursor.getColumnIndex("group_id");
      if (i != -1) {
        break label400;
      }
      paramawgp.a(new NoColumnError("group_id", Integer.TYPE));
      label208:
      i = paramCursor.getColumnIndex("group_friend_count");
      if (i != -1) {
        break label415;
      }
      paramawgp.a(new NoColumnError("group_friend_count", Integer.TYPE));
      label243:
      i = paramCursor.getColumnIndex("group_online_friend_count");
      if (i != -1) {
        break label430;
      }
      paramawgp.a(new NoColumnError("group_online_friend_count", Integer.TYPE));
      label278:
      i = paramCursor.getColumnIndex("seqid");
      if (i != -1) {
        break label445;
      }
      paramawgp.a(new NoColumnError("seqid", Byte.TYPE));
      label313:
      i = paramCursor.getColumnIndex("sqqOnLine_count");
      if (i != -1) {
        break label461;
      }
      paramawgp.a(new NoColumnError("sqqOnLine_count", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label476;
      }
      paramawgp.a(new NoColumnError("datetime", Long.TYPE));
      return paramawge;
      paramawge.group_name = paramCursor.getString(i);
      break;
      label400:
      paramawge.group_id = paramCursor.getInt(i);
      break label208;
      label415:
      paramawge.group_friend_count = paramCursor.getInt(i);
      break label243;
      label430:
      paramawge.group_online_friend_count = paramCursor.getInt(i);
      break label278;
      label445:
      paramawge.seqid = ((byte)paramCursor.getShort(i));
      break label313;
      label461:
      paramawge.sqqOnLine_count = paramCursor.getInt(i);
    }
    label476:
    paramawge.datetime = paramCursor.getLong(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,group_name TEXT ,group_id INTEGER UNIQUE ,group_friend_count INTEGER ,group_online_friend_count INTEGER ,seqid INTEGER ,sqqOnLine_count INTEGER ,datetime INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (Groups)paramawge;
    paramContentValues.put("group_name", paramawge.group_name);
    paramContentValues.put("group_id", Integer.valueOf(paramawge.group_id));
    paramContentValues.put("group_friend_count", Integer.valueOf(paramawge.group_friend_count));
    paramContentValues.put("group_online_friend_count", Integer.valueOf(paramawge.group_online_friend_count));
    paramContentValues.put("seqid", Byte.valueOf(paramawge.seqid));
    paramContentValues.put("sqqOnLine_count", Integer.valueOf(paramawge.sqqOnLine_count));
    paramContentValues.put("datetime", Long.valueOf(paramawge.datetime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awgl
 * JD-Core Version:    0.7.0.1
 */