import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atmg
  extends atna
{
  public atmg()
  {
    this.a = 12;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    boolean bool = true;
    paramBoolean = true;
    paramatmo = (ConversationInfo)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramatmo.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      paramatmo.lastread = paramCursor.getLong(paramCursor.getColumnIndex("lastread"));
      paramatmo.unreadCount = paramCursor.getInt(paramCursor.getColumnIndex("unreadCount"));
      paramatmo.unreadMark = paramCursor.getInt(paramCursor.getColumnIndex("unreadMark"));
      paramatmo.unreadGiftCount = paramCursor.getInt(paramCursor.getColumnIndex("unreadGiftCount"));
      paramatmo.extInt1 = paramCursor.getInt(paramCursor.getColumnIndex("extInt1"));
      paramatmo.extInt2 = paramCursor.getInt(paramCursor.getColumnIndex("extInt2"));
      paramatmo.extInt3 = paramCursor.getInt(paramCursor.getColumnIndex("extInt3"));
      paramatmo.extString = paramCursor.getString(paramCursor.getColumnIndex("extString"));
      paramatmo.extData = paramCursor.getBlob(paramCursor.getColumnIndex("extData"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isImax"))) {}
      for (;;)
      {
        paramatmo.isImax = paramBoolean;
        return paramatmo;
        paramBoolean = false;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramatmz.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label677;
      }
      paramatmz.a(new NoColumnError("type", Integer.TYPE));
      label312:
      i = paramCursor.getColumnIndex("lastread");
      if (i != -1) {
        break label692;
      }
      paramatmz.a(new NoColumnError("lastread", Long.TYPE));
      label347:
      i = paramCursor.getColumnIndex("unreadCount");
      if (i != -1) {
        break label707;
      }
      paramatmz.a(new NoColumnError("unreadCount", Integer.TYPE));
      label382:
      i = paramCursor.getColumnIndex("unreadMark");
      if (i != -1) {
        break label722;
      }
      paramatmz.a(new NoColumnError("unreadMark", Integer.TYPE));
      label417:
      i = paramCursor.getColumnIndex("unreadGiftCount");
      if (i != -1) {
        break label737;
      }
      paramatmz.a(new NoColumnError("unreadGiftCount", Integer.TYPE));
      label452:
      i = paramCursor.getColumnIndex("extInt1");
      if (i != -1) {
        break label752;
      }
      paramatmz.a(new NoColumnError("extInt1", Integer.TYPE));
      label487:
      i = paramCursor.getColumnIndex("extInt2");
      if (i != -1) {
        break label767;
      }
      paramatmz.a(new NoColumnError("extInt2", Integer.TYPE));
      label522:
      i = paramCursor.getColumnIndex("extInt3");
      if (i != -1) {
        break label782;
      }
      paramatmz.a(new NoColumnError("extInt3", Integer.TYPE));
      label557:
      i = paramCursor.getColumnIndex("extString");
      if (i != -1) {
        break label797;
      }
      paramatmz.a(new NoColumnError("extString", String.class));
      label591:
      i = paramCursor.getColumnIndex("extData");
      if (i != -1) {
        break label812;
      }
      paramatmz.a(new NoColumnError("extData", [B.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("isImax");
      if (i != -1) {
        break label827;
      }
      paramatmz.a(new NoColumnError("isImax", Boolean.TYPE));
      return paramatmo;
      paramatmo.uin = paramCursor.getString(i);
      break;
      label677:
      paramatmo.type = paramCursor.getInt(i);
      break label312;
      label692:
      paramatmo.lastread = paramCursor.getLong(i);
      break label347;
      label707:
      paramatmo.unreadCount = paramCursor.getInt(i);
      break label382;
      label722:
      paramatmo.unreadMark = paramCursor.getInt(i);
      break label417;
      label737:
      paramatmo.unreadGiftCount = paramCursor.getInt(i);
      break label452;
      label752:
      paramatmo.extInt1 = paramCursor.getInt(i);
      break label487;
      label767:
      paramatmo.extInt2 = paramCursor.getInt(i);
      break label522;
      label782:
      paramatmo.extInt3 = paramCursor.getInt(i);
      break label557;
      label797:
      paramatmo.extString = paramCursor.getString(i);
      break label591;
      label812:
      paramatmo.extData = paramCursor.getBlob(i);
    }
    label827:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramatmo.isImax = paramBoolean;
      return paramatmo;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,type INTEGER ,lastread INTEGER ,unreadCount INTEGER ,unreadMark INTEGER ,unreadGiftCount INTEGER ,extInt1 INTEGER ,extInt2 INTEGER ,extInt3 INTEGER ,extString TEXT ,extData BLOB ,isImax INTEGER,UNIQUE(uin,type) ON CONFLICT FAIL)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (ConversationInfo)paramatmo;
    paramContentValues.put("uin", paramatmo.uin);
    paramContentValues.put("type", Integer.valueOf(paramatmo.type));
    paramContentValues.put("lastread", Long.valueOf(paramatmo.lastread));
    paramContentValues.put("unreadCount", Integer.valueOf(paramatmo.unreadCount));
    paramContentValues.put("unreadMark", Integer.valueOf(paramatmo.unreadMark));
    paramContentValues.put("unreadGiftCount", Integer.valueOf(paramatmo.unreadGiftCount));
    paramContentValues.put("extInt1", Integer.valueOf(paramatmo.extInt1));
    paramContentValues.put("extInt2", Integer.valueOf(paramatmo.extInt2));
    paramContentValues.put("extInt3", Integer.valueOf(paramatmo.extInt3));
    paramContentValues.put("extString", paramatmo.extString);
    paramContentValues.put("extData", paramatmo.extData);
    paramContentValues.put("isImax", Boolean.valueOf(paramatmo.isImax));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atmg
 * JD-Core Version:    0.7.0.1
 */