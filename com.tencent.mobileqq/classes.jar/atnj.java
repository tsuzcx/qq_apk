import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atnj
  extends atna
{
  public atnj()
  {
    this.a = 2;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    paramatmo = (RoamSetting)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.path = paramCursor.getString(paramCursor.getColumnIndex("path"));
      paramatmo.value = paramCursor.getString(paramCursor.getColumnIndex("value"));
      return paramatmo;
    }
    int i = paramCursor.getColumnIndex("path");
    if (i == -1) {
      paramatmz.a(new NoColumnError("path", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("value");
      if (i != -1) {
        break;
      }
      paramatmz.a(new NoColumnError("value", String.class));
      return paramatmo;
      paramatmo.path = paramCursor.getString(i);
    }
    paramatmo.value = paramCursor.getString(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,path TEXT UNIQUE ,value TEXT)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (RoamSetting)paramatmo;
    paramContentValues.put("path", paramatmo.path);
    paramContentValues.put("value", paramatmo.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atnj
 * JD-Core Version:    0.7.0.1
 */