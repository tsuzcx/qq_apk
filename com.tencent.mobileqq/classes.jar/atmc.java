import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Ability;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atmc
  extends atna
{
  public atmc()
  {
    this.a = 2;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    paramatmo = (Ability)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramatmo.flags = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      return paramatmo;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1) {
      paramatmz.a(new NoColumnError("uin", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("flags");
      if (i != -1) {
        break;
      }
      paramatmz.a(new NoColumnError("flags", Integer.TYPE));
      return paramatmo;
      paramatmo.uin = paramCursor.getString(i);
    }
    paramatmo.flags = paramCursor.getInt(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,flags INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (Ability)paramatmo;
    paramContentValues.put("uin", paramatmo.uin);
    paramContentValues.put("flags", Integer.valueOf(paramatmo.flags));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atmc
 * JD-Core Version:    0.7.0.1
 */