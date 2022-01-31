import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopRemindSettingData;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awhk
  extends awgq
{
  public awhk()
  {
    this.a = 2;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    paramawge = (TroopRemindSettingData)paramawge;
    if (paramawgp == null)
    {
      paramawge.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramawge.isOpenState = paramCursor.getInt(paramCursor.getColumnIndex("isOpenState"));
      return paramawge;
    }
    int i = paramCursor.getColumnIndex("troopUin");
    if (i == -1) {
      paramawgp.a(new NoColumnError("troopUin", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("isOpenState");
      if (i != -1) {
        break;
      }
      paramawgp.a(new NoColumnError("isOpenState", Integer.TYPE));
      return paramawge;
      paramawge.troopUin = paramCursor.getString(i);
    }
    paramawge.isOpenState = paramCursor.getInt(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopUin TEXT UNIQUE ,isOpenState INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (TroopRemindSettingData)paramawge;
    paramContentValues.put("troopUin", paramawge.troopUin);
    paramContentValues.put("isOpenState", Integer.valueOf(paramawge.isOpenState));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awhk
 * JD-Core Version:    0.7.0.1
 */