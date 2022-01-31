import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atnn
  extends atna
{
  public atnn()
  {
    this.a = 9;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    paramatmo = (Stranger)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramatmo.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramatmo.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramatmo.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramatmo.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
      paramatmo.groupName = paramCursor.getString(paramCursor.getColumnIndex("groupName"));
      paramatmo.login = paramCursor.getString(paramCursor.getColumnIndex("login"));
      paramatmo.loginId = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("loginId")));
      paramatmo.time = paramCursor.getLong(paramCursor.getColumnIndex("time"));
      return paramatmo;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramatmz.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label504;
      }
      paramatmz.a(new NoColumnError("name", String.class));
      label245:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label519;
      }
      paramatmz.a(new NoColumnError("age", Byte.TYPE));
      label280:
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label535;
      }
      paramatmz.a(new NoColumnError("remark", String.class));
      label314:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label550;
      }
      paramatmz.a(new NoColumnError("gender", Byte.TYPE));
      label349:
      i = paramCursor.getColumnIndex("groupName");
      if (i != -1) {
        break label566;
      }
      paramatmz.a(new NoColumnError("groupName", String.class));
      label383:
      i = paramCursor.getColumnIndex("login");
      if (i != -1) {
        break label581;
      }
      paramatmz.a(new NoColumnError("login", String.class));
      label417:
      i = paramCursor.getColumnIndex("loginId");
      if (i != -1) {
        break label596;
      }
      paramatmz.a(new NoColumnError("loginId", Byte.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("time");
      if (i != -1) {
        break label612;
      }
      paramatmz.a(new NoColumnError("time", Long.TYPE));
      return paramatmo;
      paramatmo.uin = paramCursor.getString(i);
      break;
      label504:
      paramatmo.name = paramCursor.getString(i);
      break label245;
      label519:
      paramatmo.age = ((byte)paramCursor.getShort(i));
      break label280;
      label535:
      paramatmo.remark = paramCursor.getString(i);
      break label314;
      label550:
      paramatmo.gender = ((byte)paramCursor.getShort(i));
      break label349;
      label566:
      paramatmo.groupName = paramCursor.getString(i);
      break label383;
      label581:
      paramatmo.login = paramCursor.getString(i);
      break label417;
      label596:
      paramatmo.loginId = ((byte)paramCursor.getShort(i));
    }
    label612:
    paramatmo.time = paramCursor.getLong(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,name TEXT ,age INTEGER ,remark TEXT ,gender INTEGER ,groupName TEXT ,login TEXT ,loginId INTEGER ,time INTEGER,UNIQUE(uin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (Stranger)paramatmo;
    paramContentValues.put("uin", paramatmo.uin);
    paramContentValues.put("name", paramatmo.name);
    paramContentValues.put("age", Byte.valueOf(paramatmo.age));
    paramContentValues.put("remark", paramatmo.remark);
    paramContentValues.put("gender", Byte.valueOf(paramatmo.gender));
    paramContentValues.put("groupName", paramatmo.groupName);
    paramContentValues.put("login", paramatmo.login);
    paramContentValues.put("loginId", Byte.valueOf(paramatmo.loginId));
    paramContentValues.put("time", Long.valueOf(paramatmo.time));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atnn
 * JD-Core Version:    0.7.0.1
 */