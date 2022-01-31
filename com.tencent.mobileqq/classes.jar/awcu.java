import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awcu
  extends awch
{
  public awcu()
  {
    this.a = 9;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    paramawbv = (Stranger)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawbv.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramawbv.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramawbv.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramawbv.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
      paramawbv.groupName = paramCursor.getString(paramCursor.getColumnIndex("groupName"));
      paramawbv.login = paramCursor.getString(paramCursor.getColumnIndex("login"));
      paramawbv.loginId = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("loginId")));
      paramawbv.time = paramCursor.getLong(paramCursor.getColumnIndex("time"));
      return paramawbv;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramawcg.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label504;
      }
      paramawcg.a(new NoColumnError("name", String.class));
      label245:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label519;
      }
      paramawcg.a(new NoColumnError("age", Byte.TYPE));
      label280:
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label535;
      }
      paramawcg.a(new NoColumnError("remark", String.class));
      label314:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label550;
      }
      paramawcg.a(new NoColumnError("gender", Byte.TYPE));
      label349:
      i = paramCursor.getColumnIndex("groupName");
      if (i != -1) {
        break label566;
      }
      paramawcg.a(new NoColumnError("groupName", String.class));
      label383:
      i = paramCursor.getColumnIndex("login");
      if (i != -1) {
        break label581;
      }
      paramawcg.a(new NoColumnError("login", String.class));
      label417:
      i = paramCursor.getColumnIndex("loginId");
      if (i != -1) {
        break label596;
      }
      paramawcg.a(new NoColumnError("loginId", Byte.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("time");
      if (i != -1) {
        break label612;
      }
      paramawcg.a(new NoColumnError("time", Long.TYPE));
      return paramawbv;
      paramawbv.uin = paramCursor.getString(i);
      break;
      label504:
      paramawbv.name = paramCursor.getString(i);
      break label245;
      label519:
      paramawbv.age = ((byte)paramCursor.getShort(i));
      break label280;
      label535:
      paramawbv.remark = paramCursor.getString(i);
      break label314;
      label550:
      paramawbv.gender = ((byte)paramCursor.getShort(i));
      break label349;
      label566:
      paramawbv.groupName = paramCursor.getString(i);
      break label383;
      label581:
      paramawbv.login = paramCursor.getString(i);
      break label417;
      label596:
      paramawbv.loginId = ((byte)paramCursor.getShort(i));
    }
    label612:
    paramawbv.time = paramCursor.getLong(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,name TEXT ,age INTEGER ,remark TEXT ,gender INTEGER ,groupName TEXT ,login TEXT ,loginId INTEGER ,time INTEGER,UNIQUE(uin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (Stranger)paramawbv;
    paramContentValues.put("uin", paramawbv.uin);
    paramContentValues.put("name", paramawbv.name);
    paramContentValues.put("age", Byte.valueOf(paramawbv.age));
    paramContentValues.put("remark", paramawbv.remark);
    paramContentValues.put("gender", Byte.valueOf(paramawbv.gender));
    paramContentValues.put("groupName", paramawbv.groupName);
    paramContentValues.put("login", paramawbv.login);
    paramContentValues.put("loginId", Byte.valueOf(paramawbv.loginId));
    paramContentValues.put("time", Long.valueOf(paramawbv.time));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awcu
 * JD-Core Version:    0.7.0.1
 */