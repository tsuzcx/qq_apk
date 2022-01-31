import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awgz
  extends awgq
{
  public awgz()
  {
    this.a = 2;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    paramawge = (RoamSetting)paramawge;
    if (paramawgp == null)
    {
      paramawge.path = paramCursor.getString(paramCursor.getColumnIndex("path"));
      paramawge.value = paramCursor.getString(paramCursor.getColumnIndex("value"));
      return paramawge;
    }
    int i = paramCursor.getColumnIndex("path");
    if (i == -1) {
      paramawgp.a(new NoColumnError("path", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("value");
      if (i != -1) {
        break;
      }
      paramawgp.a(new NoColumnError("value", String.class));
      return paramawge;
      paramawge.path = paramCursor.getString(i);
    }
    paramawge.value = paramCursor.getString(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,path TEXT UNIQUE ,value TEXT)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (RoamSetting)paramawge;
    paramContentValues.put("path", paramawge.path);
    paramContentValues.put("value", paramawge.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awgz
 * JD-Core Version:    0.7.0.1
 */