import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awcc
  extends awch
{
  public awcc()
  {
    this.a = 7;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    paramawbv = (Groups)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.group_name = paramCursor.getString(paramCursor.getColumnIndex("group_name"));
      paramawbv.group_id = paramCursor.getInt(paramCursor.getColumnIndex("group_id"));
      paramawbv.group_friend_count = paramCursor.getInt(paramCursor.getColumnIndex("group_friend_count"));
      paramawbv.group_online_friend_count = paramCursor.getInt(paramCursor.getColumnIndex("group_online_friend_count"));
      paramawbv.seqid = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("seqid")));
      paramawbv.sqqOnLine_count = paramCursor.getInt(paramCursor.getColumnIndex("sqqOnLine_count"));
      paramawbv.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
      return paramawbv;
    }
    int i = paramCursor.getColumnIndex("group_name");
    if (i == -1)
    {
      paramawcg.a(new NoColumnError("group_name", String.class));
      i = paramCursor.getColumnIndex("group_id");
      if (i != -1) {
        break label400;
      }
      paramawcg.a(new NoColumnError("group_id", Integer.TYPE));
      label208:
      i = paramCursor.getColumnIndex("group_friend_count");
      if (i != -1) {
        break label415;
      }
      paramawcg.a(new NoColumnError("group_friend_count", Integer.TYPE));
      label243:
      i = paramCursor.getColumnIndex("group_online_friend_count");
      if (i != -1) {
        break label430;
      }
      paramawcg.a(new NoColumnError("group_online_friend_count", Integer.TYPE));
      label278:
      i = paramCursor.getColumnIndex("seqid");
      if (i != -1) {
        break label445;
      }
      paramawcg.a(new NoColumnError("seqid", Byte.TYPE));
      label313:
      i = paramCursor.getColumnIndex("sqqOnLine_count");
      if (i != -1) {
        break label461;
      }
      paramawcg.a(new NoColumnError("sqqOnLine_count", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label476;
      }
      paramawcg.a(new NoColumnError("datetime", Long.TYPE));
      return paramawbv;
      paramawbv.group_name = paramCursor.getString(i);
      break;
      label400:
      paramawbv.group_id = paramCursor.getInt(i);
      break label208;
      label415:
      paramawbv.group_friend_count = paramCursor.getInt(i);
      break label243;
      label430:
      paramawbv.group_online_friend_count = paramCursor.getInt(i);
      break label278;
      label445:
      paramawbv.seqid = ((byte)paramCursor.getShort(i));
      break label313;
      label461:
      paramawbv.sqqOnLine_count = paramCursor.getInt(i);
    }
    label476:
    paramawbv.datetime = paramCursor.getLong(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,group_name TEXT ,group_id INTEGER UNIQUE ,group_friend_count INTEGER ,group_online_friend_count INTEGER ,seqid INTEGER ,sqqOnLine_count INTEGER ,datetime INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (Groups)paramawbv;
    paramContentValues.put("group_name", paramawbv.group_name);
    paramContentValues.put("group_id", Integer.valueOf(paramawbv.group_id));
    paramContentValues.put("group_friend_count", Integer.valueOf(paramawbv.group_friend_count));
    paramContentValues.put("group_online_friend_count", Integer.valueOf(paramawbv.group_online_friend_count));
    paramContentValues.put("seqid", Byte.valueOf(paramawbv.seqid));
    paramContentValues.put("sqqOnLine_count", Integer.valueOf(paramawbv.sqqOnLine_count));
    paramContentValues.put("datetime", Long.valueOf(paramawbv.datetime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awcc
 * JD-Core Version:    0.7.0.1
 */