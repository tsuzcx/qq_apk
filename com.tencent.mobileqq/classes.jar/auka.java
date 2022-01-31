import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Ability;
import com.tencent.mobileqq.persistence.NoColumnError;

public class auka
  extends auky
{
  public auka()
  {
    this.a = 2;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    paramaukm = (Ability)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramaukm.flags = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      return paramaukm;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1) {
      paramaukx.a(new NoColumnError("uin", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("flags");
      if (i != -1) {
        break;
      }
      paramaukx.a(new NoColumnError("flags", Integer.TYPE));
      return paramaukm;
      paramaukm.uin = paramCursor.getString(i);
    }
    paramaukm.flags = paramCursor.getInt(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,flags INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (Ability)paramaukm;
    paramContentValues.put("uin", paramaukm.uin);
    paramContentValues.put("flags", Integer.valueOf(paramaukm.flags));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auka
 * JD-Core Version:    0.7.0.1
 */