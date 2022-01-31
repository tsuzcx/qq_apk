import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ShieldListInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awct
  extends awch
{
  public awct()
  {
    this.a = 4;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    paramawbv = (ShieldListInfo)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawbv.flags = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      paramawbv.source_id = paramCursor.getInt(paramCursor.getColumnIndex("source_id"));
      paramawbv.source_sub_id = paramCursor.getInt(paramCursor.getColumnIndex("source_sub_id"));
      return paramawbv;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramawcg.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("flags");
      if (i != -1) {
        break label240;
      }
      paramawcg.a(new NoColumnError("flags", Integer.TYPE));
      label153:
      i = paramCursor.getColumnIndex("source_id");
      if (i != -1) {
        break label255;
      }
      paramawcg.a(new NoColumnError("source_id", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("source_sub_id");
      if (i != -1) {
        break label270;
      }
      paramawcg.a(new NoColumnError("source_sub_id", Integer.TYPE));
      return paramawbv;
      paramawbv.uin = paramCursor.getString(i);
      break;
      label240:
      paramawbv.flags = paramCursor.getInt(i);
      break label153;
      label255:
      paramawbv.source_id = paramCursor.getInt(i);
    }
    label270:
    paramawbv.source_sub_id = paramCursor.getInt(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,flags INTEGER ,source_id INTEGER ,source_sub_id INTEGER,UNIQUE(uin) ON CONFLICT REPLACE)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (ShieldListInfo)paramawbv;
    paramContentValues.put("uin", paramawbv.uin);
    paramContentValues.put("flags", Integer.valueOf(paramawbv.flags));
    paramContentValues.put("source_id", Integer.valueOf(paramawbv.source_id));
    paramContentValues.put("source_sub_id", Integer.valueOf(paramawbv.source_sub_id));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awct
 * JD-Core Version:    0.7.0.1
 */