import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopRemindSettingData;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aulu
  extends aula
{
  public aulu()
  {
    this.a = 2;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    paramauko = (TroopRemindSettingData)paramauko;
    if (paramaukz == null)
    {
      paramauko.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramauko.isOpenState = paramCursor.getInt(paramCursor.getColumnIndex("isOpenState"));
      return paramauko;
    }
    int i = paramCursor.getColumnIndex("troopUin");
    if (i == -1) {
      paramaukz.a(new NoColumnError("troopUin", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("isOpenState");
      if (i != -1) {
        break;
      }
      paramaukz.a(new NoColumnError("isOpenState", Integer.TYPE));
      return paramauko;
      paramauko.troopUin = paramCursor.getString(i);
    }
    paramauko.isOpenState = paramCursor.getInt(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopUin TEXT UNIQUE ,isOpenState INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (TroopRemindSettingData)paramauko;
    paramContentValues.put("troopUin", paramauko.troopUin);
    paramContentValues.put("isOpenState", Integer.valueOf(paramauko.isOpenState));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aulu
 * JD-Core Version:    0.7.0.1
 */