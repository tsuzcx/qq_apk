import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Ability;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awfs
  extends awgq
{
  public awfs()
  {
    this.a = 2;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    paramawge = (Ability)paramawge;
    if (paramawgp == null)
    {
      paramawge.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawge.flags = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      return paramawge;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1) {
      paramawgp.a(new NoColumnError("uin", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("flags");
      if (i != -1) {
        break;
      }
      paramawgp.a(new NoColumnError("flags", Integer.TYPE));
      return paramawge;
      paramawge.uin = paramCursor.getString(i);
    }
    paramawge.flags = paramCursor.getInt(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,flags INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (Ability)paramawge;
    paramContentValues.put("uin", paramawge.uin);
    paramContentValues.put("flags", Integer.valueOf(paramawge.flags));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awfs
 * JD-Core Version:    0.7.0.1
 */