import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopRemindSettingData;
import com.tencent.mobileqq.persistence.NoColumnError;

public class auls
  extends auky
{
  public auls()
  {
    this.a = 2;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    paramaukm = (TroopRemindSettingData)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramaukm.isOpenState = paramCursor.getInt(paramCursor.getColumnIndex("isOpenState"));
      return paramaukm;
    }
    int i = paramCursor.getColumnIndex("troopUin");
    if (i == -1) {
      paramaukx.a(new NoColumnError("troopUin", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("isOpenState");
      if (i != -1) {
        break;
      }
      paramaukx.a(new NoColumnError("isOpenState", Integer.TYPE));
      return paramaukm;
      paramaukm.troopUin = paramCursor.getString(i);
    }
    paramaukm.isOpenState = paramCursor.getInt(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopUin TEXT UNIQUE ,isOpenState INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (TroopRemindSettingData)paramaukm;
    paramContentValues.put("troopUin", paramaukm.troopUin);
    paramContentValues.put("isOpenState", Integer.valueOf(paramaukm.isOpenState));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auls
 * JD-Core Version:    0.7.0.1
 */