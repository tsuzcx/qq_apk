import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukc
  extends auky
{
  public aukc()
  {
    this.a = 2;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    paramaukm = (CommonlyUsedTroop)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramaukm.addedTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("addedTimestamp"));
      return paramaukm;
    }
    int i = paramCursor.getColumnIndex("troopUin");
    if (i == -1) {
      paramaukx.a(new NoColumnError("troopUin", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("addedTimestamp");
      if (i != -1) {
        break;
      }
      paramaukx.a(new NoColumnError("addedTimestamp", Long.TYPE));
      return paramaukm;
      paramaukm.troopUin = paramCursor.getString(i);
    }
    paramaukm.addedTimestamp = paramCursor.getLong(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopUin TEXT UNIQUE ,addedTimestamp INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (CommonlyUsedTroop)paramaukm;
    paramContentValues.put("troopUin", paramaukm.troopUin);
    paramContentValues.put("addedTimestamp", Long.valueOf(paramaukm.addedTimestamp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukc
 * JD-Core Version:    0.7.0.1
 */