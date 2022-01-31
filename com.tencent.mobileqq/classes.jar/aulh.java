import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aulh
  extends auky
{
  public aulh()
  {
    this.a = 2;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    paramaukm = (RoamSetting)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.path = paramCursor.getString(paramCursor.getColumnIndex("path"));
      paramaukm.value = paramCursor.getString(paramCursor.getColumnIndex("value"));
      return paramaukm;
    }
    int i = paramCursor.getColumnIndex("path");
    if (i == -1) {
      paramaukx.a(new NoColumnError("path", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("value");
      if (i != -1) {
        break;
      }
      paramaukx.a(new NoColumnError("value", String.class));
      return paramaukm;
      paramaukm.path = paramCursor.getString(i);
    }
    paramaukm.value = paramCursor.getString(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,path TEXT UNIQUE ,value TEXT)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (RoamSetting)paramaukm;
    paramContentValues.put("path", paramaukm.path);
    paramContentValues.put("value", paramaukm.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aulh
 * JD-Core Version:    0.7.0.1
 */