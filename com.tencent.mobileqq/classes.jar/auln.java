import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.persistence.NoColumnError;

public class auln
  extends aula
{
  public auln()
  {
    this.a = 9;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    paramauko = (Stranger)paramauko;
    if (paramaukz == null)
    {
      paramauko.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramauko.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramauko.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramauko.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramauko.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
      paramauko.groupName = paramCursor.getString(paramCursor.getColumnIndex("groupName"));
      paramauko.login = paramCursor.getString(paramCursor.getColumnIndex("login"));
      paramauko.loginId = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("loginId")));
      paramauko.time = paramCursor.getLong(paramCursor.getColumnIndex("time"));
      return paramauko;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramaukz.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label504;
      }
      paramaukz.a(new NoColumnError("name", String.class));
      label245:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label519;
      }
      paramaukz.a(new NoColumnError("age", Byte.TYPE));
      label280:
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label535;
      }
      paramaukz.a(new NoColumnError("remark", String.class));
      label314:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label550;
      }
      paramaukz.a(new NoColumnError("gender", Byte.TYPE));
      label349:
      i = paramCursor.getColumnIndex("groupName");
      if (i != -1) {
        break label566;
      }
      paramaukz.a(new NoColumnError("groupName", String.class));
      label383:
      i = paramCursor.getColumnIndex("login");
      if (i != -1) {
        break label581;
      }
      paramaukz.a(new NoColumnError("login", String.class));
      label417:
      i = paramCursor.getColumnIndex("loginId");
      if (i != -1) {
        break label596;
      }
      paramaukz.a(new NoColumnError("loginId", Byte.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("time");
      if (i != -1) {
        break label612;
      }
      paramaukz.a(new NoColumnError("time", Long.TYPE));
      return paramauko;
      paramauko.uin = paramCursor.getString(i);
      break;
      label504:
      paramauko.name = paramCursor.getString(i);
      break label245;
      label519:
      paramauko.age = ((byte)paramCursor.getShort(i));
      break label280;
      label535:
      paramauko.remark = paramCursor.getString(i);
      break label314;
      label550:
      paramauko.gender = ((byte)paramCursor.getShort(i));
      break label349;
      label566:
      paramauko.groupName = paramCursor.getString(i);
      break label383;
      label581:
      paramauko.login = paramCursor.getString(i);
      break label417;
      label596:
      paramauko.loginId = ((byte)paramCursor.getShort(i));
    }
    label612:
    paramauko.time = paramCursor.getLong(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,name TEXT ,age INTEGER ,remark TEXT ,gender INTEGER ,groupName TEXT ,login TEXT ,loginId INTEGER ,time INTEGER,UNIQUE(uin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (Stranger)paramauko;
    paramContentValues.put("uin", paramauko.uin);
    paramContentValues.put("name", paramauko.name);
    paramContentValues.put("age", Byte.valueOf(paramauko.age));
    paramContentValues.put("remark", paramauko.remark);
    paramContentValues.put("gender", Byte.valueOf(paramauko.gender));
    paramContentValues.put("groupName", paramauko.groupName);
    paramContentValues.put("login", paramauko.login);
    paramContentValues.put("loginId", Byte.valueOf(paramauko.loginId));
    paramContentValues.put("time", Long.valueOf(paramauko.time));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auln
 * JD-Core Version:    0.7.0.1
 */