import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atme
  extends atna
{
  public atme()
  {
    this.a = 2;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    paramatmo = (CommonlyUsedTroop)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramatmo.addedTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("addedTimestamp"));
      return paramatmo;
    }
    int i = paramCursor.getColumnIndex("troopUin");
    if (i == -1) {
      paramatmz.a(new NoColumnError("troopUin", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("addedTimestamp");
      if (i != -1) {
        break;
      }
      paramatmz.a(new NoColumnError("addedTimestamp", Long.TYPE));
      return paramatmo;
      paramatmo.troopUin = paramCursor.getString(i);
    }
    paramatmo.addedTimestamp = paramCursor.getLong(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopUin TEXT UNIQUE ,addedTimestamp INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (CommonlyUsedTroop)paramatmo;
    paramContentValues.put("troopUin", paramatmo.troopUin);
    paramContentValues.put("addedTimestamp", Long.valueOf(paramatmo.addedTimestamp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atme
 * JD-Core Version:    0.7.0.1
 */