import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awfw
  extends awgq
{
  public awfw()
  {
    this.a = 12;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    boolean bool = true;
    paramBoolean = true;
    paramawge = (ConversationInfo)paramawge;
    if (paramawgp == null)
    {
      paramawge.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawge.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      paramawge.lastread = paramCursor.getLong(paramCursor.getColumnIndex("lastread"));
      paramawge.unreadCount = paramCursor.getInt(paramCursor.getColumnIndex("unreadCount"));
      paramawge.unreadMark = paramCursor.getInt(paramCursor.getColumnIndex("unreadMark"));
      paramawge.unreadGiftCount = paramCursor.getInt(paramCursor.getColumnIndex("unreadGiftCount"));
      paramawge.extInt1 = paramCursor.getInt(paramCursor.getColumnIndex("extInt1"));
      paramawge.extInt2 = paramCursor.getInt(paramCursor.getColumnIndex("extInt2"));
      paramawge.extInt3 = paramCursor.getInt(paramCursor.getColumnIndex("extInt3"));
      paramawge.extString = paramCursor.getString(paramCursor.getColumnIndex("extString"));
      paramawge.extData = paramCursor.getBlob(paramCursor.getColumnIndex("extData"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isImax"))) {}
      for (;;)
      {
        paramawge.isImax = paramBoolean;
        return paramawge;
        paramBoolean = false;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramawgp.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label677;
      }
      paramawgp.a(new NoColumnError("type", Integer.TYPE));
      label312:
      i = paramCursor.getColumnIndex("lastread");
      if (i != -1) {
        break label692;
      }
      paramawgp.a(new NoColumnError("lastread", Long.TYPE));
      label347:
      i = paramCursor.getColumnIndex("unreadCount");
      if (i != -1) {
        break label707;
      }
      paramawgp.a(new NoColumnError("unreadCount", Integer.TYPE));
      label382:
      i = paramCursor.getColumnIndex("unreadMark");
      if (i != -1) {
        break label722;
      }
      paramawgp.a(new NoColumnError("unreadMark", Integer.TYPE));
      label417:
      i = paramCursor.getColumnIndex("unreadGiftCount");
      if (i != -1) {
        break label737;
      }
      paramawgp.a(new NoColumnError("unreadGiftCount", Integer.TYPE));
      label452:
      i = paramCursor.getColumnIndex("extInt1");
      if (i != -1) {
        break label752;
      }
      paramawgp.a(new NoColumnError("extInt1", Integer.TYPE));
      label487:
      i = paramCursor.getColumnIndex("extInt2");
      if (i != -1) {
        break label767;
      }
      paramawgp.a(new NoColumnError("extInt2", Integer.TYPE));
      label522:
      i = paramCursor.getColumnIndex("extInt3");
      if (i != -1) {
        break label782;
      }
      paramawgp.a(new NoColumnError("extInt3", Integer.TYPE));
      label557:
      i = paramCursor.getColumnIndex("extString");
      if (i != -1) {
        break label797;
      }
      paramawgp.a(new NoColumnError("extString", String.class));
      label591:
      i = paramCursor.getColumnIndex("extData");
      if (i != -1) {
        break label812;
      }
      paramawgp.a(new NoColumnError("extData", [B.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("isImax");
      if (i != -1) {
        break label827;
      }
      paramawgp.a(new NoColumnError("isImax", Boolean.TYPE));
      return paramawge;
      paramawge.uin = paramCursor.getString(i);
      break;
      label677:
      paramawge.type = paramCursor.getInt(i);
      break label312;
      label692:
      paramawge.lastread = paramCursor.getLong(i);
      break label347;
      label707:
      paramawge.unreadCount = paramCursor.getInt(i);
      break label382;
      label722:
      paramawge.unreadMark = paramCursor.getInt(i);
      break label417;
      label737:
      paramawge.unreadGiftCount = paramCursor.getInt(i);
      break label452;
      label752:
      paramawge.extInt1 = paramCursor.getInt(i);
      break label487;
      label767:
      paramawge.extInt2 = paramCursor.getInt(i);
      break label522;
      label782:
      paramawge.extInt3 = paramCursor.getInt(i);
      break label557;
      label797:
      paramawge.extString = paramCursor.getString(i);
      break label591;
      label812:
      paramawge.extData = paramCursor.getBlob(i);
    }
    label827:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramawge.isImax = paramBoolean;
      return paramawge;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,type INTEGER ,lastread INTEGER ,unreadCount INTEGER ,unreadMark INTEGER ,unreadGiftCount INTEGER ,extInt1 INTEGER ,extInt2 INTEGER ,extInt3 INTEGER ,extString TEXT ,extData BLOB ,isImax INTEGER,UNIQUE(uin,type) ON CONFLICT FAIL)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (ConversationInfo)paramawge;
    paramContentValues.put("uin", paramawge.uin);
    paramContentValues.put("type", Integer.valueOf(paramawge.type));
    paramContentValues.put("lastread", Long.valueOf(paramawge.lastread));
    paramContentValues.put("unreadCount", Integer.valueOf(paramawge.unreadCount));
    paramContentValues.put("unreadMark", Integer.valueOf(paramawge.unreadMark));
    paramContentValues.put("unreadGiftCount", Integer.valueOf(paramawge.unreadGiftCount));
    paramContentValues.put("extInt1", Integer.valueOf(paramawge.extInt1));
    paramContentValues.put("extInt2", Integer.valueOf(paramawge.extInt2));
    paramContentValues.put("extInt3", Integer.valueOf(paramawge.extInt3));
    paramContentValues.put("extString", paramawge.extString);
    paramContentValues.put("extData", paramawge.extData);
    paramContentValues.put("isImax", Boolean.valueOf(paramawge.isImax));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awfw
 * JD-Core Version:    0.7.0.1
 */