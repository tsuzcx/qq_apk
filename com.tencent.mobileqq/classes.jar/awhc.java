import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ShieldListInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awhc
  extends awgq
{
  public awhc()
  {
    this.a = 4;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    paramawge = (ShieldListInfo)paramawge;
    if (paramawgp == null)
    {
      paramawge.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawge.flags = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      paramawge.source_id = paramCursor.getInt(paramCursor.getColumnIndex("source_id"));
      paramawge.source_sub_id = paramCursor.getInt(paramCursor.getColumnIndex("source_sub_id"));
      return paramawge;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramawgp.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("flags");
      if (i != -1) {
        break label240;
      }
      paramawgp.a(new NoColumnError("flags", Integer.TYPE));
      label153:
      i = paramCursor.getColumnIndex("source_id");
      if (i != -1) {
        break label255;
      }
      paramawgp.a(new NoColumnError("source_id", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("source_sub_id");
      if (i != -1) {
        break label270;
      }
      paramawgp.a(new NoColumnError("source_sub_id", Integer.TYPE));
      return paramawge;
      paramawge.uin = paramCursor.getString(i);
      break;
      label240:
      paramawge.flags = paramCursor.getInt(i);
      break label153;
      label255:
      paramawge.source_id = paramCursor.getInt(i);
    }
    label270:
    paramawge.source_sub_id = paramCursor.getInt(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,flags INTEGER ,source_id INTEGER ,source_sub_id INTEGER,UNIQUE(uin) ON CONFLICT REPLACE)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (ShieldListInfo)paramawge;
    paramContentValues.put("uin", paramawge.uin);
    paramContentValues.put("flags", Integer.valueOf(paramawge.flags));
    paramContentValues.put("source_id", Integer.valueOf(paramawge.source_id));
    paramContentValues.put("source_sub_id", Integer.valueOf(paramawge.source_sub_id));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awhc
 * JD-Core Version:    0.7.0.1
 */