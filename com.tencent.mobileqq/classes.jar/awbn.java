import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awbn
  extends awch
{
  public awbn()
  {
    this.a = 12;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    boolean bool = true;
    paramBoolean = true;
    paramawbv = (ConversationInfo)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawbv.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      paramawbv.lastread = paramCursor.getLong(paramCursor.getColumnIndex("lastread"));
      paramawbv.unreadCount = paramCursor.getInt(paramCursor.getColumnIndex("unreadCount"));
      paramawbv.unreadMark = paramCursor.getInt(paramCursor.getColumnIndex("unreadMark"));
      paramawbv.unreadGiftCount = paramCursor.getInt(paramCursor.getColumnIndex("unreadGiftCount"));
      paramawbv.extInt1 = paramCursor.getInt(paramCursor.getColumnIndex("extInt1"));
      paramawbv.extInt2 = paramCursor.getInt(paramCursor.getColumnIndex("extInt2"));
      paramawbv.extInt3 = paramCursor.getInt(paramCursor.getColumnIndex("extInt3"));
      paramawbv.extString = paramCursor.getString(paramCursor.getColumnIndex("extString"));
      paramawbv.extData = paramCursor.getBlob(paramCursor.getColumnIndex("extData"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isImax"))) {}
      for (;;)
      {
        paramawbv.isImax = paramBoolean;
        return paramawbv;
        paramBoolean = false;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramawcg.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label677;
      }
      paramawcg.a(new NoColumnError("type", Integer.TYPE));
      label312:
      i = paramCursor.getColumnIndex("lastread");
      if (i != -1) {
        break label692;
      }
      paramawcg.a(new NoColumnError("lastread", Long.TYPE));
      label347:
      i = paramCursor.getColumnIndex("unreadCount");
      if (i != -1) {
        break label707;
      }
      paramawcg.a(new NoColumnError("unreadCount", Integer.TYPE));
      label382:
      i = paramCursor.getColumnIndex("unreadMark");
      if (i != -1) {
        break label722;
      }
      paramawcg.a(new NoColumnError("unreadMark", Integer.TYPE));
      label417:
      i = paramCursor.getColumnIndex("unreadGiftCount");
      if (i != -1) {
        break label737;
      }
      paramawcg.a(new NoColumnError("unreadGiftCount", Integer.TYPE));
      label452:
      i = paramCursor.getColumnIndex("extInt1");
      if (i != -1) {
        break label752;
      }
      paramawcg.a(new NoColumnError("extInt1", Integer.TYPE));
      label487:
      i = paramCursor.getColumnIndex("extInt2");
      if (i != -1) {
        break label767;
      }
      paramawcg.a(new NoColumnError("extInt2", Integer.TYPE));
      label522:
      i = paramCursor.getColumnIndex("extInt3");
      if (i != -1) {
        break label782;
      }
      paramawcg.a(new NoColumnError("extInt3", Integer.TYPE));
      label557:
      i = paramCursor.getColumnIndex("extString");
      if (i != -1) {
        break label797;
      }
      paramawcg.a(new NoColumnError("extString", String.class));
      label591:
      i = paramCursor.getColumnIndex("extData");
      if (i != -1) {
        break label812;
      }
      paramawcg.a(new NoColumnError("extData", [B.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("isImax");
      if (i != -1) {
        break label827;
      }
      paramawcg.a(new NoColumnError("isImax", Boolean.TYPE));
      return paramawbv;
      paramawbv.uin = paramCursor.getString(i);
      break;
      label677:
      paramawbv.type = paramCursor.getInt(i);
      break label312;
      label692:
      paramawbv.lastread = paramCursor.getLong(i);
      break label347;
      label707:
      paramawbv.unreadCount = paramCursor.getInt(i);
      break label382;
      label722:
      paramawbv.unreadMark = paramCursor.getInt(i);
      break label417;
      label737:
      paramawbv.unreadGiftCount = paramCursor.getInt(i);
      break label452;
      label752:
      paramawbv.extInt1 = paramCursor.getInt(i);
      break label487;
      label767:
      paramawbv.extInt2 = paramCursor.getInt(i);
      break label522;
      label782:
      paramawbv.extInt3 = paramCursor.getInt(i);
      break label557;
      label797:
      paramawbv.extString = paramCursor.getString(i);
      break label591;
      label812:
      paramawbv.extData = paramCursor.getBlob(i);
    }
    label827:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramawbv.isImax = paramBoolean;
      return paramawbv;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,type INTEGER ,lastread INTEGER ,unreadCount INTEGER ,unreadMark INTEGER ,unreadGiftCount INTEGER ,extInt1 INTEGER ,extInt2 INTEGER ,extInt3 INTEGER ,extString TEXT ,extData BLOB ,isImax INTEGER,UNIQUE(uin,type) ON CONFLICT FAIL)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (ConversationInfo)paramawbv;
    paramContentValues.put("uin", paramawbv.uin);
    paramContentValues.put("type", Integer.valueOf(paramawbv.type));
    paramContentValues.put("lastread", Long.valueOf(paramawbv.lastread));
    paramContentValues.put("unreadCount", Integer.valueOf(paramawbv.unreadCount));
    paramContentValues.put("unreadMark", Integer.valueOf(paramawbv.unreadMark));
    paramContentValues.put("unreadGiftCount", Integer.valueOf(paramawbv.unreadGiftCount));
    paramContentValues.put("extInt1", Integer.valueOf(paramawbv.extInt1));
    paramContentValues.put("extInt2", Integer.valueOf(paramawbv.extInt2));
    paramContentValues.put("extInt3", Integer.valueOf(paramawbv.extInt3));
    paramContentValues.put("extString", paramawbv.extString);
    paramContentValues.put("extData", paramawbv.extData);
    paramContentValues.put("isImax", Boolean.valueOf(paramawbv.isImax));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awbn
 * JD-Core Version:    0.7.0.1
 */