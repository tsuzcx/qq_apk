import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aull
  extends auky
{
  public aull()
  {
    this.a = 9;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    paramaukm = (Stranger)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramaukm.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramaukm.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramaukm.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramaukm.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
      paramaukm.groupName = paramCursor.getString(paramCursor.getColumnIndex("groupName"));
      paramaukm.login = paramCursor.getString(paramCursor.getColumnIndex("login"));
      paramaukm.loginId = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("loginId")));
      paramaukm.time = paramCursor.getLong(paramCursor.getColumnIndex("time"));
      return paramaukm;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramaukx.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label504;
      }
      paramaukx.a(new NoColumnError("name", String.class));
      label245:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label519;
      }
      paramaukx.a(new NoColumnError("age", Byte.TYPE));
      label280:
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label535;
      }
      paramaukx.a(new NoColumnError("remark", String.class));
      label314:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label550;
      }
      paramaukx.a(new NoColumnError("gender", Byte.TYPE));
      label349:
      i = paramCursor.getColumnIndex("groupName");
      if (i != -1) {
        break label566;
      }
      paramaukx.a(new NoColumnError("groupName", String.class));
      label383:
      i = paramCursor.getColumnIndex("login");
      if (i != -1) {
        break label581;
      }
      paramaukx.a(new NoColumnError("login", String.class));
      label417:
      i = paramCursor.getColumnIndex("loginId");
      if (i != -1) {
        break label596;
      }
      paramaukx.a(new NoColumnError("loginId", Byte.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("time");
      if (i != -1) {
        break label612;
      }
      paramaukx.a(new NoColumnError("time", Long.TYPE));
      return paramaukm;
      paramaukm.uin = paramCursor.getString(i);
      break;
      label504:
      paramaukm.name = paramCursor.getString(i);
      break label245;
      label519:
      paramaukm.age = ((byte)paramCursor.getShort(i));
      break label280;
      label535:
      paramaukm.remark = paramCursor.getString(i);
      break label314;
      label550:
      paramaukm.gender = ((byte)paramCursor.getShort(i));
      break label349;
      label566:
      paramaukm.groupName = paramCursor.getString(i);
      break label383;
      label581:
      paramaukm.login = paramCursor.getString(i);
      break label417;
      label596:
      paramaukm.loginId = ((byte)paramCursor.getShort(i));
    }
    label612:
    paramaukm.time = paramCursor.getLong(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,name TEXT ,age INTEGER ,remark TEXT ,gender INTEGER ,groupName TEXT ,login TEXT ,loginId INTEGER ,time INTEGER,UNIQUE(uin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (Stranger)paramaukm;
    paramContentValues.put("uin", paramaukm.uin);
    paramContentValues.put("name", paramaukm.name);
    paramContentValues.put("age", Byte.valueOf(paramaukm.age));
    paramContentValues.put("remark", paramaukm.remark);
    paramContentValues.put("gender", Byte.valueOf(paramaukm.gender));
    paramContentValues.put("groupName", paramaukm.groupName);
    paramContentValues.put("login", paramaukm.login);
    paramContentValues.put("loginId", Byte.valueOf(paramaukm.loginId));
    paramContentValues.put("time", Long.valueOf(paramaukm.time));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aull
 * JD-Core Version:    0.7.0.1
 */