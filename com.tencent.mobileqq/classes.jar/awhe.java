import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awhe
  extends awgq
{
  public awhe()
  {
    this.a = 12;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawge = (SubAccountInfo)paramawge;
    if (paramawgp == null)
    {
      paramawge.subuin = paramCursor.getString(paramCursor.getColumnIndex("subuin"));
      paramawge.subname = paramCursor.getString(paramCursor.getColumnIndex("subname"));
      paramawge.trunkuin = paramCursor.getString(paramCursor.getColumnIndex("trunkuin"));
      paramawge.isbind = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isbind")));
      paramawge.lasttime = paramCursor.getLong(paramCursor.getColumnIndex("lasttime"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isTop")))
      {
        paramBoolean = true;
        paramawge.isTop = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hintIsNew"))) {
          break label255;
        }
      }
      label255:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramawge.hintIsNew = paramBoolean;
        paramawge.cookie = paramCursor.getBlob(paramCursor.getColumnIndex("cookie"));
        paramawge.status = paramCursor.getInt(paramCursor.getColumnIndex("status"));
        paramawge.serverErrorType = paramCursor.getInt(paramCursor.getColumnIndex("serverErrorType"));
        paramawge.serverErrorMsg = paramCursor.getString(paramCursor.getColumnIndex("serverErrorMsg"));
        paramawge.lastCleanQZoneMessageTime = paramCursor.getLong(paramCursor.getColumnIndex("lastCleanQZoneMessageTime"));
        return paramawge;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("subuin");
    if (i == -1)
    {
      paramawgp.a(new NoColumnError("subuin", String.class));
      i = paramCursor.getColumnIndex("subname");
      if (i != -1) {
        break label692;
      }
      paramawgp.a(new NoColumnError("subname", String.class));
      label328:
      i = paramCursor.getColumnIndex("trunkuin");
      if (i != -1) {
        break label707;
      }
      paramawgp.a(new NoColumnError("trunkuin", String.class));
      label362:
      i = paramCursor.getColumnIndex("isbind");
      if (i != -1) {
        break label722;
      }
      paramawgp.a(new NoColumnError("isbind", Byte.TYPE));
      label397:
      i = paramCursor.getColumnIndex("lasttime");
      if (i != -1) {
        break label738;
      }
      paramawgp.a(new NoColumnError("lasttime", Long.TYPE));
      label432:
      i = paramCursor.getColumnIndex("isTop");
      if (i != -1) {
        break label753;
      }
      paramawgp.a(new NoColumnError("isTop", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hintIsNew");
      if (i != -1) {
        break label780;
      }
      paramawgp.a(new NoColumnError("hintIsNew", Boolean.TYPE));
      i = paramCursor.getColumnIndex("cookie");
      if (i != -1) {
        break label808;
      }
      paramawgp.a(new NoColumnError("cookie", [B.class));
      label536:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label823;
      }
      paramawgp.a(new NoColumnError("status", Integer.TYPE));
      label571:
      i = paramCursor.getColumnIndex("serverErrorType");
      if (i != -1) {
        break label838;
      }
      paramawgp.a(new NoColumnError("serverErrorType", Integer.TYPE));
      label606:
      i = paramCursor.getColumnIndex("serverErrorMsg");
      if (i != -1) {
        break label853;
      }
      paramawgp.a(new NoColumnError("serverErrorMsg", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("lastCleanQZoneMessageTime");
      if (i != -1) {
        break label868;
      }
      paramawgp.a(new NoColumnError("lastCleanQZoneMessageTime", Long.TYPE));
      return paramawge;
      paramawge.subuin = paramCursor.getString(i);
      break;
      label692:
      paramawge.subname = paramCursor.getString(i);
      break label328;
      label707:
      paramawge.trunkuin = paramCursor.getString(i);
      break label362;
      label722:
      paramawge.isbind = ((byte)paramCursor.getShort(i));
      break label397;
      label738:
      paramawge.lasttime = paramCursor.getLong(i);
      break label432;
      label753:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isTop = paramBoolean;
        break;
      }
      label780:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramawge.hintIsNew = paramBoolean;
        break;
      }
      label808:
      paramawge.cookie = paramCursor.getBlob(i);
      break label536;
      label823:
      paramawge.status = paramCursor.getInt(i);
      break label571;
      label838:
      paramawge.serverErrorType = paramCursor.getInt(i);
      break label606;
      label853:
      paramawge.serverErrorMsg = paramCursor.getString(i);
    }
    label868:
    paramawge.lastCleanQZoneMessageTime = paramCursor.getLong(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,subuin TEXT ,subname TEXT ,trunkuin TEXT ,isbind INTEGER ,lasttime INTEGER ,isTop INTEGER ,hintIsNew INTEGER ,cookie BLOB ,status INTEGER ,serverErrorType INTEGER ,serverErrorMsg TEXT ,lastCleanQZoneMessageTime INTEGER,UNIQUE(subuin,trunkuin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (SubAccountInfo)paramawge;
    paramContentValues.put("subuin", paramawge.subuin);
    paramContentValues.put("subname", paramawge.subname);
    paramContentValues.put("trunkuin", paramawge.trunkuin);
    paramContentValues.put("isbind", Byte.valueOf(paramawge.isbind));
    paramContentValues.put("lasttime", Long.valueOf(paramawge.lasttime));
    paramContentValues.put("isTop", Boolean.valueOf(paramawge.isTop));
    paramContentValues.put("hintIsNew", Boolean.valueOf(paramawge.hintIsNew));
    paramContentValues.put("cookie", paramawge.cookie);
    paramContentValues.put("status", Integer.valueOf(paramawge.status));
    paramContentValues.put("serverErrorType", Integer.valueOf(paramawge.serverErrorType));
    paramContentValues.put("serverErrorMsg", paramawge.serverErrorMsg);
    paramContentValues.put("lastCleanQZoneMessageTime", Long.valueOf(paramawge.lastCleanQZoneMessageTime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awhe
 * JD-Core Version:    0.7.0.1
 */