import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Ability;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukc
  extends aula
{
  public aukc()
  {
    this.a = 2;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    paramauko = (Ability)paramauko;
    if (paramaukz == null)
    {
      paramauko.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramauko.flags = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      return paramauko;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1) {
      paramaukz.a(new NoColumnError("uin", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("flags");
      if (i != -1) {
        break;
      }
      paramaukz.a(new NoColumnError("flags", Integer.TYPE));
      return paramauko;
      paramauko.uin = paramCursor.getString(i);
    }
    paramauko.flags = paramCursor.getInt(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,flags INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (Ability)paramauko;
    paramContentValues.put("uin", paramauko.uin);
    paramContentValues.put("flags", Integer.valueOf(paramauko.flags));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukc
 * JD-Core Version:    0.7.0.1
 */