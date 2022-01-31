import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ShieldListInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atnm
  extends atna
{
  public atnm()
  {
    this.a = 4;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    paramatmo = (ShieldListInfo)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramatmo.flags = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      paramatmo.source_id = paramCursor.getInt(paramCursor.getColumnIndex("source_id"));
      paramatmo.source_sub_id = paramCursor.getInt(paramCursor.getColumnIndex("source_sub_id"));
      return paramatmo;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramatmz.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("flags");
      if (i != -1) {
        break label240;
      }
      paramatmz.a(new NoColumnError("flags", Integer.TYPE));
      label153:
      i = paramCursor.getColumnIndex("source_id");
      if (i != -1) {
        break label255;
      }
      paramatmz.a(new NoColumnError("source_id", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("source_sub_id");
      if (i != -1) {
        break label270;
      }
      paramatmz.a(new NoColumnError("source_sub_id", Integer.TYPE));
      return paramatmo;
      paramatmo.uin = paramCursor.getString(i);
      break;
      label240:
      paramatmo.flags = paramCursor.getInt(i);
      break label153;
      label255:
      paramatmo.source_id = paramCursor.getInt(i);
    }
    label270:
    paramatmo.source_sub_id = paramCursor.getInt(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,flags INTEGER ,source_id INTEGER ,source_sub_id INTEGER,UNIQUE(uin) ON CONFLICT REPLACE)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (ShieldListInfo)paramatmo;
    paramContentValues.put("uin", paramatmo.uin);
    paramContentValues.put("flags", Integer.valueOf(paramatmo.flags));
    paramContentValues.put("source_id", Integer.valueOf(paramatmo.source_id));
    paramContentValues.put("source_sub_id", Integer.valueOf(paramatmo.source_sub_id));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atnm
 * JD-Core Version:    0.7.0.1
 */