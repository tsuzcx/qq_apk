import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Ability;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awbj
  extends awch
{
  public awbj()
  {
    this.a = 2;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    paramawbv = (Ability)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawbv.flags = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      return paramawbv;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1) {
      paramawcg.a(new NoColumnError("uin", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("flags");
      if (i != -1) {
        break;
      }
      paramawcg.a(new NoColumnError("flags", Integer.TYPE));
      return paramawbv;
      paramawbv.uin = paramCursor.getString(i);
    }
    paramawbv.flags = paramCursor.getInt(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,flags INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (Ability)paramawbv;
    paramContentValues.put("uin", paramawbv.uin);
    paramContentValues.put("flags", Integer.valueOf(paramawbv.flags));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awbj
 * JD-Core Version:    0.7.0.1
 */