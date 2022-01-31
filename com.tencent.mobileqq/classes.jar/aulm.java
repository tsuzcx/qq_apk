import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aulm
  extends auky
{
  public aulm()
  {
    this.a = 12;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramaukm = (SubAccountInfo)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.subuin = paramCursor.getString(paramCursor.getColumnIndex("subuin"));
      paramaukm.subname = paramCursor.getString(paramCursor.getColumnIndex("subname"));
      paramaukm.trunkuin = paramCursor.getString(paramCursor.getColumnIndex("trunkuin"));
      paramaukm.isbind = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isbind")));
      paramaukm.lasttime = paramCursor.getLong(paramCursor.getColumnIndex("lasttime"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isTop")))
      {
        paramBoolean = true;
        paramaukm.isTop = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hintIsNew"))) {
          break label255;
        }
      }
      label255:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramaukm.hintIsNew = paramBoolean;
        paramaukm.cookie = paramCursor.getBlob(paramCursor.getColumnIndex("cookie"));
        paramaukm.status = paramCursor.getInt(paramCursor.getColumnIndex("status"));
        paramaukm.serverErrorType = paramCursor.getInt(paramCursor.getColumnIndex("serverErrorType"));
        paramaukm.serverErrorMsg = paramCursor.getString(paramCursor.getColumnIndex("serverErrorMsg"));
        paramaukm.lastCleanQZoneMessageTime = paramCursor.getLong(paramCursor.getColumnIndex("lastCleanQZoneMessageTime"));
        return paramaukm;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("subuin");
    if (i == -1)
    {
      paramaukx.a(new NoColumnError("subuin", String.class));
      i = paramCursor.getColumnIndex("subname");
      if (i != -1) {
        break label692;
      }
      paramaukx.a(new NoColumnError("subname", String.class));
      label328:
      i = paramCursor.getColumnIndex("trunkuin");
      if (i != -1) {
        break label707;
      }
      paramaukx.a(new NoColumnError("trunkuin", String.class));
      label362:
      i = paramCursor.getColumnIndex("isbind");
      if (i != -1) {
        break label722;
      }
      paramaukx.a(new NoColumnError("isbind", Byte.TYPE));
      label397:
      i = paramCursor.getColumnIndex("lasttime");
      if (i != -1) {
        break label738;
      }
      paramaukx.a(new NoColumnError("lasttime", Long.TYPE));
      label432:
      i = paramCursor.getColumnIndex("isTop");
      if (i != -1) {
        break label753;
      }
      paramaukx.a(new NoColumnError("isTop", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hintIsNew");
      if (i != -1) {
        break label780;
      }
      paramaukx.a(new NoColumnError("hintIsNew", Boolean.TYPE));
      i = paramCursor.getColumnIndex("cookie");
      if (i != -1) {
        break label808;
      }
      paramaukx.a(new NoColumnError("cookie", [B.class));
      label536:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label823;
      }
      paramaukx.a(new NoColumnError("status", Integer.TYPE));
      label571:
      i = paramCursor.getColumnIndex("serverErrorType");
      if (i != -1) {
        break label838;
      }
      paramaukx.a(new NoColumnError("serverErrorType", Integer.TYPE));
      label606:
      i = paramCursor.getColumnIndex("serverErrorMsg");
      if (i != -1) {
        break label853;
      }
      paramaukx.a(new NoColumnError("serverErrorMsg", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("lastCleanQZoneMessageTime");
      if (i != -1) {
        break label868;
      }
      paramaukx.a(new NoColumnError("lastCleanQZoneMessageTime", Long.TYPE));
      return paramaukm;
      paramaukm.subuin = paramCursor.getString(i);
      break;
      label692:
      paramaukm.subname = paramCursor.getString(i);
      break label328;
      label707:
      paramaukm.trunkuin = paramCursor.getString(i);
      break label362;
      label722:
      paramaukm.isbind = ((byte)paramCursor.getShort(i));
      break label397;
      label738:
      paramaukm.lasttime = paramCursor.getLong(i);
      break label432;
      label753:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isTop = paramBoolean;
        break;
      }
      label780:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramaukm.hintIsNew = paramBoolean;
        break;
      }
      label808:
      paramaukm.cookie = paramCursor.getBlob(i);
      break label536;
      label823:
      paramaukm.status = paramCursor.getInt(i);
      break label571;
      label838:
      paramaukm.serverErrorType = paramCursor.getInt(i);
      break label606;
      label853:
      paramaukm.serverErrorMsg = paramCursor.getString(i);
    }
    label868:
    paramaukm.lastCleanQZoneMessageTime = paramCursor.getLong(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,subuin TEXT ,subname TEXT ,trunkuin TEXT ,isbind INTEGER ,lasttime INTEGER ,isTop INTEGER ,hintIsNew INTEGER ,cookie BLOB ,status INTEGER ,serverErrorType INTEGER ,serverErrorMsg TEXT ,lastCleanQZoneMessageTime INTEGER,UNIQUE(subuin,trunkuin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (SubAccountInfo)paramaukm;
    paramContentValues.put("subuin", paramaukm.subuin);
    paramContentValues.put("subname", paramaukm.subname);
    paramContentValues.put("trunkuin", paramaukm.trunkuin);
    paramContentValues.put("isbind", Byte.valueOf(paramaukm.isbind));
    paramContentValues.put("lasttime", Long.valueOf(paramaukm.lasttime));
    paramContentValues.put("isTop", Boolean.valueOf(paramaukm.isTop));
    paramContentValues.put("hintIsNew", Boolean.valueOf(paramaukm.hintIsNew));
    paramContentValues.put("cookie", paramaukm.cookie);
    paramContentValues.put("status", Integer.valueOf(paramaukm.status));
    paramContentValues.put("serverErrorType", Integer.valueOf(paramaukm.serverErrorType));
    paramContentValues.put("serverErrorMsg", paramaukm.serverErrorMsg);
    paramContentValues.put("lastCleanQZoneMessageTime", Long.valueOf(paramaukm.lastCleanQZoneMessageTime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aulm
 * JD-Core Version:    0.7.0.1
 */