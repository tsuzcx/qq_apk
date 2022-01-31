import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aulo
  extends aula
{
  public aulo()
  {
    this.a = 12;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramauko = (SubAccountInfo)paramauko;
    if (paramaukz == null)
    {
      paramauko.subuin = paramCursor.getString(paramCursor.getColumnIndex("subuin"));
      paramauko.subname = paramCursor.getString(paramCursor.getColumnIndex("subname"));
      paramauko.trunkuin = paramCursor.getString(paramCursor.getColumnIndex("trunkuin"));
      paramauko.isbind = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isbind")));
      paramauko.lasttime = paramCursor.getLong(paramCursor.getColumnIndex("lasttime"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isTop")))
      {
        paramBoolean = true;
        paramauko.isTop = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hintIsNew"))) {
          break label255;
        }
      }
      label255:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramauko.hintIsNew = paramBoolean;
        paramauko.cookie = paramCursor.getBlob(paramCursor.getColumnIndex("cookie"));
        paramauko.status = paramCursor.getInt(paramCursor.getColumnIndex("status"));
        paramauko.serverErrorType = paramCursor.getInt(paramCursor.getColumnIndex("serverErrorType"));
        paramauko.serverErrorMsg = paramCursor.getString(paramCursor.getColumnIndex("serverErrorMsg"));
        paramauko.lastCleanQZoneMessageTime = paramCursor.getLong(paramCursor.getColumnIndex("lastCleanQZoneMessageTime"));
        return paramauko;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("subuin");
    if (i == -1)
    {
      paramaukz.a(new NoColumnError("subuin", String.class));
      i = paramCursor.getColumnIndex("subname");
      if (i != -1) {
        break label692;
      }
      paramaukz.a(new NoColumnError("subname", String.class));
      label328:
      i = paramCursor.getColumnIndex("trunkuin");
      if (i != -1) {
        break label707;
      }
      paramaukz.a(new NoColumnError("trunkuin", String.class));
      label362:
      i = paramCursor.getColumnIndex("isbind");
      if (i != -1) {
        break label722;
      }
      paramaukz.a(new NoColumnError("isbind", Byte.TYPE));
      label397:
      i = paramCursor.getColumnIndex("lasttime");
      if (i != -1) {
        break label738;
      }
      paramaukz.a(new NoColumnError("lasttime", Long.TYPE));
      label432:
      i = paramCursor.getColumnIndex("isTop");
      if (i != -1) {
        break label753;
      }
      paramaukz.a(new NoColumnError("isTop", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hintIsNew");
      if (i != -1) {
        break label780;
      }
      paramaukz.a(new NoColumnError("hintIsNew", Boolean.TYPE));
      i = paramCursor.getColumnIndex("cookie");
      if (i != -1) {
        break label808;
      }
      paramaukz.a(new NoColumnError("cookie", [B.class));
      label536:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label823;
      }
      paramaukz.a(new NoColumnError("status", Integer.TYPE));
      label571:
      i = paramCursor.getColumnIndex("serverErrorType");
      if (i != -1) {
        break label838;
      }
      paramaukz.a(new NoColumnError("serverErrorType", Integer.TYPE));
      label606:
      i = paramCursor.getColumnIndex("serverErrorMsg");
      if (i != -1) {
        break label853;
      }
      paramaukz.a(new NoColumnError("serverErrorMsg", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("lastCleanQZoneMessageTime");
      if (i != -1) {
        break label868;
      }
      paramaukz.a(new NoColumnError("lastCleanQZoneMessageTime", Long.TYPE));
      return paramauko;
      paramauko.subuin = paramCursor.getString(i);
      break;
      label692:
      paramauko.subname = paramCursor.getString(i);
      break label328;
      label707:
      paramauko.trunkuin = paramCursor.getString(i);
      break label362;
      label722:
      paramauko.isbind = ((byte)paramCursor.getShort(i));
      break label397;
      label738:
      paramauko.lasttime = paramCursor.getLong(i);
      break label432;
      label753:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isTop = paramBoolean;
        break;
      }
      label780:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramauko.hintIsNew = paramBoolean;
        break;
      }
      label808:
      paramauko.cookie = paramCursor.getBlob(i);
      break label536;
      label823:
      paramauko.status = paramCursor.getInt(i);
      break label571;
      label838:
      paramauko.serverErrorType = paramCursor.getInt(i);
      break label606;
      label853:
      paramauko.serverErrorMsg = paramCursor.getString(i);
    }
    label868:
    paramauko.lastCleanQZoneMessageTime = paramCursor.getLong(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,subuin TEXT ,subname TEXT ,trunkuin TEXT ,isbind INTEGER ,lasttime INTEGER ,isTop INTEGER ,hintIsNew INTEGER ,cookie BLOB ,status INTEGER ,serverErrorType INTEGER ,serverErrorMsg TEXT ,lastCleanQZoneMessageTime INTEGER,UNIQUE(subuin,trunkuin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (SubAccountInfo)paramauko;
    paramContentValues.put("subuin", paramauko.subuin);
    paramContentValues.put("subname", paramauko.subname);
    paramContentValues.put("trunkuin", paramauko.trunkuin);
    paramContentValues.put("isbind", Byte.valueOf(paramauko.isbind));
    paramContentValues.put("lasttime", Long.valueOf(paramauko.lasttime));
    paramContentValues.put("isTop", Boolean.valueOf(paramauko.isTop));
    paramContentValues.put("hintIsNew", Boolean.valueOf(paramauko.hintIsNew));
    paramContentValues.put("cookie", paramauko.cookie);
    paramContentValues.put("status", Integer.valueOf(paramauko.status));
    paramContentValues.put("serverErrorType", Integer.valueOf(paramauko.serverErrorType));
    paramContentValues.put("serverErrorMsg", paramauko.serverErrorMsg);
    paramContentValues.put("lastCleanQZoneMessageTime", Long.valueOf(paramauko.lastCleanQZoneMessageTime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aulo
 * JD-Core Version:    0.7.0.1
 */