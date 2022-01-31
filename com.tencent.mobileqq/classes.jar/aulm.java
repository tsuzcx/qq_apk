import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ShieldListInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aulm
  extends aula
{
  public aulm()
  {
    this.a = 4;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    paramauko = (ShieldListInfo)paramauko;
    if (paramaukz == null)
    {
      paramauko.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramauko.flags = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      paramauko.source_id = paramCursor.getInt(paramCursor.getColumnIndex("source_id"));
      paramauko.source_sub_id = paramCursor.getInt(paramCursor.getColumnIndex("source_sub_id"));
      return paramauko;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramaukz.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("flags");
      if (i != -1) {
        break label240;
      }
      paramaukz.a(new NoColumnError("flags", Integer.TYPE));
      label153:
      i = paramCursor.getColumnIndex("source_id");
      if (i != -1) {
        break label255;
      }
      paramaukz.a(new NoColumnError("source_id", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("source_sub_id");
      if (i != -1) {
        break label270;
      }
      paramaukz.a(new NoColumnError("source_sub_id", Integer.TYPE));
      return paramauko;
      paramauko.uin = paramCursor.getString(i);
      break;
      label240:
      paramauko.flags = paramCursor.getInt(i);
      break label153;
      label255:
      paramauko.source_id = paramCursor.getInt(i);
    }
    label270:
    paramauko.source_sub_id = paramCursor.getInt(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,flags INTEGER ,source_id INTEGER ,source_sub_id INTEGER,UNIQUE(uin) ON CONFLICT REPLACE)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (ShieldListInfo)paramauko;
    paramContentValues.put("uin", paramauko.uin);
    paramContentValues.put("flags", Integer.valueOf(paramauko.flags));
    paramContentValues.put("source_id", Integer.valueOf(paramauko.source_id));
    paramContentValues.put("source_sub_id", Integer.valueOf(paramauko.source_sub_id));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aulm
 * JD-Core Version:    0.7.0.1
 */