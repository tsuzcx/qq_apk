import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopRemindSettingData;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awdb
  extends awch
{
  public awdb()
  {
    this.a = 2;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    paramawbv = (TroopRemindSettingData)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramawbv.isOpenState = paramCursor.getInt(paramCursor.getColumnIndex("isOpenState"));
      return paramawbv;
    }
    int i = paramCursor.getColumnIndex("troopUin");
    if (i == -1) {
      paramawcg.a(new NoColumnError("troopUin", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("isOpenState");
      if (i != -1) {
        break;
      }
      paramawcg.a(new NoColumnError("isOpenState", Integer.TYPE));
      return paramawbv;
      paramawbv.troopUin = paramCursor.getString(i);
    }
    paramawbv.isOpenState = paramCursor.getInt(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopUin TEXT UNIQUE ,isOpenState INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (TroopRemindSettingData)paramawbv;
    paramContentValues.put("troopUin", paramawbv.troopUin);
    paramContentValues.put("isOpenState", Integer.valueOf(paramawbv.isOpenState));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awdb
 * JD-Core Version:    0.7.0.1
 */