import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.persistence.NoColumnError;

public class auke
  extends aula
{
  public auke()
  {
    this.a = 2;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    paramauko = (CommonlyUsedTroop)paramauko;
    if (paramaukz == null)
    {
      paramauko.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramauko.addedTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("addedTimestamp"));
      return paramauko;
    }
    int i = paramCursor.getColumnIndex("troopUin");
    if (i == -1) {
      paramaukz.a(new NoColumnError("troopUin", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("addedTimestamp");
      if (i != -1) {
        break;
      }
      paramaukz.a(new NoColumnError("addedTimestamp", Long.TYPE));
      return paramauko;
      paramauko.troopUin = paramCursor.getString(i);
    }
    paramauko.addedTimestamp = paramCursor.getLong(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopUin TEXT UNIQUE ,addedTimestamp INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (CommonlyUsedTroop)paramauko;
    paramContentValues.put("troopUin", paramauko.troopUin);
    paramContentValues.put("addedTimestamp", Long.valueOf(paramauko.addedTimestamp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auke
 * JD-Core Version:    0.7.0.1
 */