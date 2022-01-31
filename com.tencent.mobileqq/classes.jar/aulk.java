import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ShieldListInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aulk
  extends auky
{
  public aulk()
  {
    this.a = 4;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    paramaukm = (ShieldListInfo)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramaukm.flags = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      paramaukm.source_id = paramCursor.getInt(paramCursor.getColumnIndex("source_id"));
      paramaukm.source_sub_id = paramCursor.getInt(paramCursor.getColumnIndex("source_sub_id"));
      return paramaukm;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramaukx.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("flags");
      if (i != -1) {
        break label240;
      }
      paramaukx.a(new NoColumnError("flags", Integer.TYPE));
      label153:
      i = paramCursor.getColumnIndex("source_id");
      if (i != -1) {
        break label255;
      }
      paramaukx.a(new NoColumnError("source_id", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("source_sub_id");
      if (i != -1) {
        break label270;
      }
      paramaukx.a(new NoColumnError("source_sub_id", Integer.TYPE));
      return paramaukm;
      paramaukm.uin = paramCursor.getString(i);
      break;
      label240:
      paramaukm.flags = paramCursor.getInt(i);
      break label153;
      label255:
      paramaukm.source_id = paramCursor.getInt(i);
    }
    label270:
    paramaukm.source_sub_id = paramCursor.getInt(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,flags INTEGER ,source_id INTEGER ,source_sub_id INTEGER,UNIQUE(uin) ON CONFLICT REPLACE)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (ShieldListInfo)paramaukm;
    paramContentValues.put("uin", paramaukm.uin);
    paramContentValues.put("flags", Integer.valueOf(paramaukm.flags));
    paramContentValues.put("source_id", Integer.valueOf(paramaukm.source_id));
    paramContentValues.put("source_sub_id", Integer.valueOf(paramaukm.source_sub_id));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aulk
 * JD-Core Version:    0.7.0.1
 */