import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukg
  extends aula
{
  public aukg()
  {
    this.a = 12;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    boolean bool = true;
    paramBoolean = true;
    paramauko = (ConversationInfo)paramauko;
    if (paramaukz == null)
    {
      paramauko.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramauko.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      paramauko.lastread = paramCursor.getLong(paramCursor.getColumnIndex("lastread"));
      paramauko.unreadCount = paramCursor.getInt(paramCursor.getColumnIndex("unreadCount"));
      paramauko.unreadMark = paramCursor.getInt(paramCursor.getColumnIndex("unreadMark"));
      paramauko.unreadGiftCount = paramCursor.getInt(paramCursor.getColumnIndex("unreadGiftCount"));
      paramauko.extInt1 = paramCursor.getInt(paramCursor.getColumnIndex("extInt1"));
      paramauko.extInt2 = paramCursor.getInt(paramCursor.getColumnIndex("extInt2"));
      paramauko.extInt3 = paramCursor.getInt(paramCursor.getColumnIndex("extInt3"));
      paramauko.extString = paramCursor.getString(paramCursor.getColumnIndex("extString"));
      paramauko.extData = paramCursor.getBlob(paramCursor.getColumnIndex("extData"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isImax"))) {}
      for (;;)
      {
        paramauko.isImax = paramBoolean;
        return paramauko;
        paramBoolean = false;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramaukz.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label677;
      }
      paramaukz.a(new NoColumnError("type", Integer.TYPE));
      label312:
      i = paramCursor.getColumnIndex("lastread");
      if (i != -1) {
        break label692;
      }
      paramaukz.a(new NoColumnError("lastread", Long.TYPE));
      label347:
      i = paramCursor.getColumnIndex("unreadCount");
      if (i != -1) {
        break label707;
      }
      paramaukz.a(new NoColumnError("unreadCount", Integer.TYPE));
      label382:
      i = paramCursor.getColumnIndex("unreadMark");
      if (i != -1) {
        break label722;
      }
      paramaukz.a(new NoColumnError("unreadMark", Integer.TYPE));
      label417:
      i = paramCursor.getColumnIndex("unreadGiftCount");
      if (i != -1) {
        break label737;
      }
      paramaukz.a(new NoColumnError("unreadGiftCount", Integer.TYPE));
      label452:
      i = paramCursor.getColumnIndex("extInt1");
      if (i != -1) {
        break label752;
      }
      paramaukz.a(new NoColumnError("extInt1", Integer.TYPE));
      label487:
      i = paramCursor.getColumnIndex("extInt2");
      if (i != -1) {
        break label767;
      }
      paramaukz.a(new NoColumnError("extInt2", Integer.TYPE));
      label522:
      i = paramCursor.getColumnIndex("extInt3");
      if (i != -1) {
        break label782;
      }
      paramaukz.a(new NoColumnError("extInt3", Integer.TYPE));
      label557:
      i = paramCursor.getColumnIndex("extString");
      if (i != -1) {
        break label797;
      }
      paramaukz.a(new NoColumnError("extString", String.class));
      label591:
      i = paramCursor.getColumnIndex("extData");
      if (i != -1) {
        break label812;
      }
      paramaukz.a(new NoColumnError("extData", [B.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("isImax");
      if (i != -1) {
        break label827;
      }
      paramaukz.a(new NoColumnError("isImax", Boolean.TYPE));
      return paramauko;
      paramauko.uin = paramCursor.getString(i);
      break;
      label677:
      paramauko.type = paramCursor.getInt(i);
      break label312;
      label692:
      paramauko.lastread = paramCursor.getLong(i);
      break label347;
      label707:
      paramauko.unreadCount = paramCursor.getInt(i);
      break label382;
      label722:
      paramauko.unreadMark = paramCursor.getInt(i);
      break label417;
      label737:
      paramauko.unreadGiftCount = paramCursor.getInt(i);
      break label452;
      label752:
      paramauko.extInt1 = paramCursor.getInt(i);
      break label487;
      label767:
      paramauko.extInt2 = paramCursor.getInt(i);
      break label522;
      label782:
      paramauko.extInt3 = paramCursor.getInt(i);
      break label557;
      label797:
      paramauko.extString = paramCursor.getString(i);
      break label591;
      label812:
      paramauko.extData = paramCursor.getBlob(i);
    }
    label827:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramauko.isImax = paramBoolean;
      return paramauko;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,type INTEGER ,lastread INTEGER ,unreadCount INTEGER ,unreadMark INTEGER ,unreadGiftCount INTEGER ,extInt1 INTEGER ,extInt2 INTEGER ,extInt3 INTEGER ,extString TEXT ,extData BLOB ,isImax INTEGER,UNIQUE(uin,type) ON CONFLICT FAIL)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (ConversationInfo)paramauko;
    paramContentValues.put("uin", paramauko.uin);
    paramContentValues.put("type", Integer.valueOf(paramauko.type));
    paramContentValues.put("lastread", Long.valueOf(paramauko.lastread));
    paramContentValues.put("unreadCount", Integer.valueOf(paramauko.unreadCount));
    paramContentValues.put("unreadMark", Integer.valueOf(paramauko.unreadMark));
    paramContentValues.put("unreadGiftCount", Integer.valueOf(paramauko.unreadGiftCount));
    paramContentValues.put("extInt1", Integer.valueOf(paramauko.extInt1));
    paramContentValues.put("extInt2", Integer.valueOf(paramauko.extInt2));
    paramContentValues.put("extInt3", Integer.valueOf(paramauko.extInt3));
    paramContentValues.put("extString", paramauko.extString);
    paramContentValues.put("extData", paramauko.extData);
    paramContentValues.put("isImax", Boolean.valueOf(paramauko.isImax));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukg
 * JD-Core Version:    0.7.0.1
 */