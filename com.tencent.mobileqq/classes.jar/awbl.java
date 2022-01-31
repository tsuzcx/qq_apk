import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awbl
  extends awch
{
  public awbl()
  {
    this.a = 2;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    paramawbv = (CommonlyUsedTroop)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramawbv.addedTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("addedTimestamp"));
      return paramawbv;
    }
    int i = paramCursor.getColumnIndex("troopUin");
    if (i == -1) {
      paramawcg.a(new NoColumnError("troopUin", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("addedTimestamp");
      if (i != -1) {
        break;
      }
      paramawcg.a(new NoColumnError("addedTimestamp", Long.TYPE));
      return paramawbv;
      paramawbv.troopUin = paramCursor.getString(i);
    }
    paramawbv.addedTimestamp = paramCursor.getLong(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopUin TEXT UNIQUE ,addedTimestamp INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (CommonlyUsedTroop)paramawbv;
    paramContentValues.put("troopUin", paramawbv.troopUin);
    paramContentValues.put("addedTimestamp", Long.valueOf(paramawbv.addedTimestamp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awbl
 * JD-Core Version:    0.7.0.1
 */