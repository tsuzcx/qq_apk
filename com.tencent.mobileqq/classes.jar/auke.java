import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class auke
  extends auky
{
  public auke()
  {
    this.a = 12;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    boolean bool = true;
    paramBoolean = true;
    paramaukm = (ConversationInfo)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramaukm.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      paramaukm.lastread = paramCursor.getLong(paramCursor.getColumnIndex("lastread"));
      paramaukm.unreadCount = paramCursor.getInt(paramCursor.getColumnIndex("unreadCount"));
      paramaukm.unreadMark = paramCursor.getInt(paramCursor.getColumnIndex("unreadMark"));
      paramaukm.unreadGiftCount = paramCursor.getInt(paramCursor.getColumnIndex("unreadGiftCount"));
      paramaukm.extInt1 = paramCursor.getInt(paramCursor.getColumnIndex("extInt1"));
      paramaukm.extInt2 = paramCursor.getInt(paramCursor.getColumnIndex("extInt2"));
      paramaukm.extInt3 = paramCursor.getInt(paramCursor.getColumnIndex("extInt3"));
      paramaukm.extString = paramCursor.getString(paramCursor.getColumnIndex("extString"));
      paramaukm.extData = paramCursor.getBlob(paramCursor.getColumnIndex("extData"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isImax"))) {}
      for (;;)
      {
        paramaukm.isImax = paramBoolean;
        return paramaukm;
        paramBoolean = false;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramaukx.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label677;
      }
      paramaukx.a(new NoColumnError("type", Integer.TYPE));
      label312:
      i = paramCursor.getColumnIndex("lastread");
      if (i != -1) {
        break label692;
      }
      paramaukx.a(new NoColumnError("lastread", Long.TYPE));
      label347:
      i = paramCursor.getColumnIndex("unreadCount");
      if (i != -1) {
        break label707;
      }
      paramaukx.a(new NoColumnError("unreadCount", Integer.TYPE));
      label382:
      i = paramCursor.getColumnIndex("unreadMark");
      if (i != -1) {
        break label722;
      }
      paramaukx.a(new NoColumnError("unreadMark", Integer.TYPE));
      label417:
      i = paramCursor.getColumnIndex("unreadGiftCount");
      if (i != -1) {
        break label737;
      }
      paramaukx.a(new NoColumnError("unreadGiftCount", Integer.TYPE));
      label452:
      i = paramCursor.getColumnIndex("extInt1");
      if (i != -1) {
        break label752;
      }
      paramaukx.a(new NoColumnError("extInt1", Integer.TYPE));
      label487:
      i = paramCursor.getColumnIndex("extInt2");
      if (i != -1) {
        break label767;
      }
      paramaukx.a(new NoColumnError("extInt2", Integer.TYPE));
      label522:
      i = paramCursor.getColumnIndex("extInt3");
      if (i != -1) {
        break label782;
      }
      paramaukx.a(new NoColumnError("extInt3", Integer.TYPE));
      label557:
      i = paramCursor.getColumnIndex("extString");
      if (i != -1) {
        break label797;
      }
      paramaukx.a(new NoColumnError("extString", String.class));
      label591:
      i = paramCursor.getColumnIndex("extData");
      if (i != -1) {
        break label812;
      }
      paramaukx.a(new NoColumnError("extData", [B.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("isImax");
      if (i != -1) {
        break label827;
      }
      paramaukx.a(new NoColumnError("isImax", Boolean.TYPE));
      return paramaukm;
      paramaukm.uin = paramCursor.getString(i);
      break;
      label677:
      paramaukm.type = paramCursor.getInt(i);
      break label312;
      label692:
      paramaukm.lastread = paramCursor.getLong(i);
      break label347;
      label707:
      paramaukm.unreadCount = paramCursor.getInt(i);
      break label382;
      label722:
      paramaukm.unreadMark = paramCursor.getInt(i);
      break label417;
      label737:
      paramaukm.unreadGiftCount = paramCursor.getInt(i);
      break label452;
      label752:
      paramaukm.extInt1 = paramCursor.getInt(i);
      break label487;
      label767:
      paramaukm.extInt2 = paramCursor.getInt(i);
      break label522;
      label782:
      paramaukm.extInt3 = paramCursor.getInt(i);
      break label557;
      label797:
      paramaukm.extString = paramCursor.getString(i);
      break label591;
      label812:
      paramaukm.extData = paramCursor.getBlob(i);
    }
    label827:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramaukm.isImax = paramBoolean;
      return paramaukm;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,type INTEGER ,lastread INTEGER ,unreadCount INTEGER ,unreadMark INTEGER ,unreadGiftCount INTEGER ,extInt1 INTEGER ,extInt2 INTEGER ,extInt3 INTEGER ,extString TEXT ,extData BLOB ,isImax INTEGER,UNIQUE(uin,type) ON CONFLICT FAIL)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (ConversationInfo)paramaukm;
    paramContentValues.put("uin", paramaukm.uin);
    paramContentValues.put("type", Integer.valueOf(paramaukm.type));
    paramContentValues.put("lastread", Long.valueOf(paramaukm.lastread));
    paramContentValues.put("unreadCount", Integer.valueOf(paramaukm.unreadCount));
    paramContentValues.put("unreadMark", Integer.valueOf(paramaukm.unreadMark));
    paramContentValues.put("unreadGiftCount", Integer.valueOf(paramaukm.unreadGiftCount));
    paramContentValues.put("extInt1", Integer.valueOf(paramaukm.extInt1));
    paramContentValues.put("extInt2", Integer.valueOf(paramaukm.extInt2));
    paramContentValues.put("extInt3", Integer.valueOf(paramaukm.extInt3));
    paramContentValues.put("extString", paramaukm.extString);
    paramContentValues.put("extData", paramaukm.extData);
    paramContentValues.put("isImax", Boolean.valueOf(paramaukm.isImax));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auke
 * JD-Core Version:    0.7.0.1
 */