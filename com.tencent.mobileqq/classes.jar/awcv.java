import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awcv
  extends awch
{
  public awcv()
  {
    this.a = 12;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawbv = (SubAccountInfo)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.subuin = paramCursor.getString(paramCursor.getColumnIndex("subuin"));
      paramawbv.subname = paramCursor.getString(paramCursor.getColumnIndex("subname"));
      paramawbv.trunkuin = paramCursor.getString(paramCursor.getColumnIndex("trunkuin"));
      paramawbv.isbind = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isbind")));
      paramawbv.lasttime = paramCursor.getLong(paramCursor.getColumnIndex("lasttime"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isTop")))
      {
        paramBoolean = true;
        paramawbv.isTop = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hintIsNew"))) {
          break label255;
        }
      }
      label255:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramawbv.hintIsNew = paramBoolean;
        paramawbv.cookie = paramCursor.getBlob(paramCursor.getColumnIndex("cookie"));
        paramawbv.status = paramCursor.getInt(paramCursor.getColumnIndex("status"));
        paramawbv.serverErrorType = paramCursor.getInt(paramCursor.getColumnIndex("serverErrorType"));
        paramawbv.serverErrorMsg = paramCursor.getString(paramCursor.getColumnIndex("serverErrorMsg"));
        paramawbv.lastCleanQZoneMessageTime = paramCursor.getLong(paramCursor.getColumnIndex("lastCleanQZoneMessageTime"));
        return paramawbv;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("subuin");
    if (i == -1)
    {
      paramawcg.a(new NoColumnError("subuin", String.class));
      i = paramCursor.getColumnIndex("subname");
      if (i != -1) {
        break label692;
      }
      paramawcg.a(new NoColumnError("subname", String.class));
      label328:
      i = paramCursor.getColumnIndex("trunkuin");
      if (i != -1) {
        break label707;
      }
      paramawcg.a(new NoColumnError("trunkuin", String.class));
      label362:
      i = paramCursor.getColumnIndex("isbind");
      if (i != -1) {
        break label722;
      }
      paramawcg.a(new NoColumnError("isbind", Byte.TYPE));
      label397:
      i = paramCursor.getColumnIndex("lasttime");
      if (i != -1) {
        break label738;
      }
      paramawcg.a(new NoColumnError("lasttime", Long.TYPE));
      label432:
      i = paramCursor.getColumnIndex("isTop");
      if (i != -1) {
        break label753;
      }
      paramawcg.a(new NoColumnError("isTop", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hintIsNew");
      if (i != -1) {
        break label780;
      }
      paramawcg.a(new NoColumnError("hintIsNew", Boolean.TYPE));
      i = paramCursor.getColumnIndex("cookie");
      if (i != -1) {
        break label808;
      }
      paramawcg.a(new NoColumnError("cookie", [B.class));
      label536:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label823;
      }
      paramawcg.a(new NoColumnError("status", Integer.TYPE));
      label571:
      i = paramCursor.getColumnIndex("serverErrorType");
      if (i != -1) {
        break label838;
      }
      paramawcg.a(new NoColumnError("serverErrorType", Integer.TYPE));
      label606:
      i = paramCursor.getColumnIndex("serverErrorMsg");
      if (i != -1) {
        break label853;
      }
      paramawcg.a(new NoColumnError("serverErrorMsg", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("lastCleanQZoneMessageTime");
      if (i != -1) {
        break label868;
      }
      paramawcg.a(new NoColumnError("lastCleanQZoneMessageTime", Long.TYPE));
      return paramawbv;
      paramawbv.subuin = paramCursor.getString(i);
      break;
      label692:
      paramawbv.subname = paramCursor.getString(i);
      break label328;
      label707:
      paramawbv.trunkuin = paramCursor.getString(i);
      break label362;
      label722:
      paramawbv.isbind = ((byte)paramCursor.getShort(i));
      break label397;
      label738:
      paramawbv.lasttime = paramCursor.getLong(i);
      break label432;
      label753:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isTop = paramBoolean;
        break;
      }
      label780:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramawbv.hintIsNew = paramBoolean;
        break;
      }
      label808:
      paramawbv.cookie = paramCursor.getBlob(i);
      break label536;
      label823:
      paramawbv.status = paramCursor.getInt(i);
      break label571;
      label838:
      paramawbv.serverErrorType = paramCursor.getInt(i);
      break label606;
      label853:
      paramawbv.serverErrorMsg = paramCursor.getString(i);
    }
    label868:
    paramawbv.lastCleanQZoneMessageTime = paramCursor.getLong(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,subuin TEXT ,subname TEXT ,trunkuin TEXT ,isbind INTEGER ,lasttime INTEGER ,isTop INTEGER ,hintIsNew INTEGER ,cookie BLOB ,status INTEGER ,serverErrorType INTEGER ,serverErrorMsg TEXT ,lastCleanQZoneMessageTime INTEGER,UNIQUE(subuin,trunkuin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (SubAccountInfo)paramawbv;
    paramContentValues.put("subuin", paramawbv.subuin);
    paramContentValues.put("subname", paramawbv.subname);
    paramContentValues.put("trunkuin", paramawbv.trunkuin);
    paramContentValues.put("isbind", Byte.valueOf(paramawbv.isbind));
    paramContentValues.put("lasttime", Long.valueOf(paramawbv.lasttime));
    paramContentValues.put("isTop", Boolean.valueOf(paramawbv.isTop));
    paramContentValues.put("hintIsNew", Boolean.valueOf(paramawbv.hintIsNew));
    paramContentValues.put("cookie", paramawbv.cookie);
    paramContentValues.put("status", Integer.valueOf(paramawbv.status));
    paramContentValues.put("serverErrorType", Integer.valueOf(paramawbv.serverErrorType));
    paramContentValues.put("serverErrorMsg", paramawbv.serverErrorMsg);
    paramContentValues.put("lastCleanQZoneMessageTime", Long.valueOf(paramawbv.lastCleanQZoneMessageTime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awcv
 * JD-Core Version:    0.7.0.1
 */