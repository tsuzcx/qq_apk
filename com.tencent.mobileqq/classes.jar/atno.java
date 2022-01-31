import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atno
  extends atna
{
  public atno()
  {
    this.a = 12;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramatmo = (SubAccountInfo)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.subuin = paramCursor.getString(paramCursor.getColumnIndex("subuin"));
      paramatmo.subname = paramCursor.getString(paramCursor.getColumnIndex("subname"));
      paramatmo.trunkuin = paramCursor.getString(paramCursor.getColumnIndex("trunkuin"));
      paramatmo.isbind = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isbind")));
      paramatmo.lasttime = paramCursor.getLong(paramCursor.getColumnIndex("lasttime"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isTop")))
      {
        paramBoolean = true;
        paramatmo.isTop = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hintIsNew"))) {
          break label255;
        }
      }
      label255:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramatmo.hintIsNew = paramBoolean;
        paramatmo.cookie = paramCursor.getBlob(paramCursor.getColumnIndex("cookie"));
        paramatmo.status = paramCursor.getInt(paramCursor.getColumnIndex("status"));
        paramatmo.serverErrorType = paramCursor.getInt(paramCursor.getColumnIndex("serverErrorType"));
        paramatmo.serverErrorMsg = paramCursor.getString(paramCursor.getColumnIndex("serverErrorMsg"));
        paramatmo.lastCleanQZoneMessageTime = paramCursor.getLong(paramCursor.getColumnIndex("lastCleanQZoneMessageTime"));
        return paramatmo;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("subuin");
    if (i == -1)
    {
      paramatmz.a(new NoColumnError("subuin", String.class));
      i = paramCursor.getColumnIndex("subname");
      if (i != -1) {
        break label692;
      }
      paramatmz.a(new NoColumnError("subname", String.class));
      label328:
      i = paramCursor.getColumnIndex("trunkuin");
      if (i != -1) {
        break label707;
      }
      paramatmz.a(new NoColumnError("trunkuin", String.class));
      label362:
      i = paramCursor.getColumnIndex("isbind");
      if (i != -1) {
        break label722;
      }
      paramatmz.a(new NoColumnError("isbind", Byte.TYPE));
      label397:
      i = paramCursor.getColumnIndex("lasttime");
      if (i != -1) {
        break label738;
      }
      paramatmz.a(new NoColumnError("lasttime", Long.TYPE));
      label432:
      i = paramCursor.getColumnIndex("isTop");
      if (i != -1) {
        break label753;
      }
      paramatmz.a(new NoColumnError("isTop", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hintIsNew");
      if (i != -1) {
        break label780;
      }
      paramatmz.a(new NoColumnError("hintIsNew", Boolean.TYPE));
      i = paramCursor.getColumnIndex("cookie");
      if (i != -1) {
        break label808;
      }
      paramatmz.a(new NoColumnError("cookie", [B.class));
      label536:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label823;
      }
      paramatmz.a(new NoColumnError("status", Integer.TYPE));
      label571:
      i = paramCursor.getColumnIndex("serverErrorType");
      if (i != -1) {
        break label838;
      }
      paramatmz.a(new NoColumnError("serverErrorType", Integer.TYPE));
      label606:
      i = paramCursor.getColumnIndex("serverErrorMsg");
      if (i != -1) {
        break label853;
      }
      paramatmz.a(new NoColumnError("serverErrorMsg", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("lastCleanQZoneMessageTime");
      if (i != -1) {
        break label868;
      }
      paramatmz.a(new NoColumnError("lastCleanQZoneMessageTime", Long.TYPE));
      return paramatmo;
      paramatmo.subuin = paramCursor.getString(i);
      break;
      label692:
      paramatmo.subname = paramCursor.getString(i);
      break label328;
      label707:
      paramatmo.trunkuin = paramCursor.getString(i);
      break label362;
      label722:
      paramatmo.isbind = ((byte)paramCursor.getShort(i));
      break label397;
      label738:
      paramatmo.lasttime = paramCursor.getLong(i);
      break label432;
      label753:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isTop = paramBoolean;
        break;
      }
      label780:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramatmo.hintIsNew = paramBoolean;
        break;
      }
      label808:
      paramatmo.cookie = paramCursor.getBlob(i);
      break label536;
      label823:
      paramatmo.status = paramCursor.getInt(i);
      break label571;
      label838:
      paramatmo.serverErrorType = paramCursor.getInt(i);
      break label606;
      label853:
      paramatmo.serverErrorMsg = paramCursor.getString(i);
    }
    label868:
    paramatmo.lastCleanQZoneMessageTime = paramCursor.getLong(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,subuin TEXT ,subname TEXT ,trunkuin TEXT ,isbind INTEGER ,lasttime INTEGER ,isTop INTEGER ,hintIsNew INTEGER ,cookie BLOB ,status INTEGER ,serverErrorType INTEGER ,serverErrorMsg TEXT ,lastCleanQZoneMessageTime INTEGER,UNIQUE(subuin,trunkuin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (SubAccountInfo)paramatmo;
    paramContentValues.put("subuin", paramatmo.subuin);
    paramContentValues.put("subname", paramatmo.subname);
    paramContentValues.put("trunkuin", paramatmo.trunkuin);
    paramContentValues.put("isbind", Byte.valueOf(paramatmo.isbind));
    paramContentValues.put("lasttime", Long.valueOf(paramatmo.lasttime));
    paramContentValues.put("isTop", Boolean.valueOf(paramatmo.isTop));
    paramContentValues.put("hintIsNew", Boolean.valueOf(paramatmo.hintIsNew));
    paramContentValues.put("cookie", paramatmo.cookie);
    paramContentValues.put("status", Integer.valueOf(paramatmo.status));
    paramContentValues.put("serverErrorType", Integer.valueOf(paramatmo.serverErrorType));
    paramContentValues.put("serverErrorMsg", paramatmo.serverErrorMsg);
    paramContentValues.put("lastCleanQZoneMessageTime", Long.valueOf(paramatmo.lastCleanQZoneMessageTime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atno
 * JD-Core Version:    0.7.0.1
 */