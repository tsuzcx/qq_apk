import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aulj
  extends aula
{
  public aulj()
  {
    this.a = 2;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    paramauko = (RoamSetting)paramauko;
    if (paramaukz == null)
    {
      paramauko.path = paramCursor.getString(paramCursor.getColumnIndex("path"));
      paramauko.value = paramCursor.getString(paramCursor.getColumnIndex("value"));
      return paramauko;
    }
    int i = paramCursor.getColumnIndex("path");
    if (i == -1) {
      paramaukz.a(new NoColumnError("path", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("value");
      if (i != -1) {
        break;
      }
      paramaukz.a(new NoColumnError("value", String.class));
      return paramauko;
      paramauko.path = paramCursor.getString(i);
    }
    paramauko.value = paramCursor.getString(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,path TEXT UNIQUE ,value TEXT)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (RoamSetting)paramauko;
    paramContentValues.put("path", paramauko.path);
    paramContentValues.put("value", paramauko.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aulj
 * JD-Core Version:    0.7.0.1
 */