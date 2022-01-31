import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awcq
  extends awch
{
  public awcq()
  {
    this.a = 2;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    paramawbv = (RoamSetting)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.path = paramCursor.getString(paramCursor.getColumnIndex("path"));
      paramawbv.value = paramCursor.getString(paramCursor.getColumnIndex("value"));
      return paramawbv;
    }
    int i = paramCursor.getColumnIndex("path");
    if (i == -1) {
      paramawcg.a(new NoColumnError("path", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("value");
      if (i != -1) {
        break;
      }
      paramawcg.a(new NoColumnError("value", String.class));
      return paramawbv;
      paramawbv.path = paramCursor.getString(i);
    }
    paramawbv.value = paramCursor.getString(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,path TEXT UNIQUE ,value TEXT)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (RoamSetting)paramawbv;
    paramContentValues.put("path", paramawbv.path);
    paramContentValues.put("value", paramawbv.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awcq
 * JD-Core Version:    0.7.0.1
 */