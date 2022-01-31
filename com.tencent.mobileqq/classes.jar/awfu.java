import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awfu
  extends awgq
{
  public awfu()
  {
    this.a = 2;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    paramawge = (CommonlyUsedTroop)paramawge;
    if (paramawgp == null)
    {
      paramawge.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramawge.addedTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("addedTimestamp"));
      return paramawge;
    }
    int i = paramCursor.getColumnIndex("troopUin");
    if (i == -1) {
      paramawgp.a(new NoColumnError("troopUin", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("addedTimestamp");
      if (i != -1) {
        break;
      }
      paramawgp.a(new NoColumnError("addedTimestamp", Long.TYPE));
      return paramawge;
      paramawge.troopUin = paramCursor.getString(i);
    }
    paramawge.addedTimestamp = paramCursor.getLong(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopUin TEXT UNIQUE ,addedTimestamp INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (CommonlyUsedTroop)paramawge;
    paramContentValues.put("troopUin", paramawge.troopUin);
    paramContentValues.put("addedTimestamp", Long.valueOf(paramawge.addedTimestamp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awfu
 * JD-Core Version:    0.7.0.1
 */