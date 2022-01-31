import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopRemindSettingData;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atnu
  extends atna
{
  public atnu()
  {
    this.a = 2;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    paramatmo = (TroopRemindSettingData)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramatmo.isOpenState = paramCursor.getInt(paramCursor.getColumnIndex("isOpenState"));
      return paramatmo;
    }
    int i = paramCursor.getColumnIndex("troopUin");
    if (i == -1) {
      paramatmz.a(new NoColumnError("troopUin", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("isOpenState");
      if (i != -1) {
        break;
      }
      paramatmz.a(new NoColumnError("isOpenState", Integer.TYPE));
      return paramatmo;
      paramatmo.troopUin = paramCursor.getString(i);
    }
    paramatmo.isOpenState = paramCursor.getInt(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopUin TEXT UNIQUE ,isOpenState INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (TroopRemindSettingData)paramatmo;
    paramContentValues.put("troopUin", paramatmo.troopUin);
    paramContentValues.put("isOpenState", Integer.valueOf(paramatmo.isOpenState));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atnu
 * JD-Core Version:    0.7.0.1
 */