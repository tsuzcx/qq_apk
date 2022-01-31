import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awhd
  extends awgq
{
  public awhd()
  {
    this.a = 9;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    paramawge = (Stranger)paramawge;
    if (paramawgp == null)
    {
      paramawge.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawge.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramawge.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramawge.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramawge.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
      paramawge.groupName = paramCursor.getString(paramCursor.getColumnIndex("groupName"));
      paramawge.login = paramCursor.getString(paramCursor.getColumnIndex("login"));
      paramawge.loginId = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("loginId")));
      paramawge.time = paramCursor.getLong(paramCursor.getColumnIndex("time"));
      return paramawge;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramawgp.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label504;
      }
      paramawgp.a(new NoColumnError("name", String.class));
      label245:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label519;
      }
      paramawgp.a(new NoColumnError("age", Byte.TYPE));
      label280:
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label535;
      }
      paramawgp.a(new NoColumnError("remark", String.class));
      label314:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label550;
      }
      paramawgp.a(new NoColumnError("gender", Byte.TYPE));
      label349:
      i = paramCursor.getColumnIndex("groupName");
      if (i != -1) {
        break label566;
      }
      paramawgp.a(new NoColumnError("groupName", String.class));
      label383:
      i = paramCursor.getColumnIndex("login");
      if (i != -1) {
        break label581;
      }
      paramawgp.a(new NoColumnError("login", String.class));
      label417:
      i = paramCursor.getColumnIndex("loginId");
      if (i != -1) {
        break label596;
      }
      paramawgp.a(new NoColumnError("loginId", Byte.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("time");
      if (i != -1) {
        break label612;
      }
      paramawgp.a(new NoColumnError("time", Long.TYPE));
      return paramawge;
      paramawge.uin = paramCursor.getString(i);
      break;
      label504:
      paramawge.name = paramCursor.getString(i);
      break label245;
      label519:
      paramawge.age = ((byte)paramCursor.getShort(i));
      break label280;
      label535:
      paramawge.remark = paramCursor.getString(i);
      break label314;
      label550:
      paramawge.gender = ((byte)paramCursor.getShort(i));
      break label349;
      label566:
      paramawge.groupName = paramCursor.getString(i);
      break label383;
      label581:
      paramawge.login = paramCursor.getString(i);
      break label417;
      label596:
      paramawge.loginId = ((byte)paramCursor.getShort(i));
    }
    label612:
    paramawge.time = paramCursor.getLong(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,name TEXT ,age INTEGER ,remark TEXT ,gender INTEGER ,groupName TEXT ,login TEXT ,loginId INTEGER ,time INTEGER,UNIQUE(uin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (Stranger)paramawge;
    paramContentValues.put("uin", paramawge.uin);
    paramContentValues.put("name", paramawge.name);
    paramContentValues.put("age", Byte.valueOf(paramawge.age));
    paramContentValues.put("remark", paramawge.remark);
    paramContentValues.put("gender", Byte.valueOf(paramawge.gender));
    paramContentValues.put("groupName", paramawge.groupName);
    paramContentValues.put("login", paramawge.login);
    paramContentValues.put("loginId", Byte.valueOf(paramawge.loginId));
    paramContentValues.put("time", Long.valueOf(paramawge.time));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awhd
 * JD-Core Version:    0.7.0.1
 */