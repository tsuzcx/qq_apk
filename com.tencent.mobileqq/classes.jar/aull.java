import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aull
  extends aula
{
  public aull()
  {
    this.a = 9;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    paramauko = (Setting)paramauko;
    if (paramaukz == null)
    {
      paramauko.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramauko.headImgTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("headImgTimestamp"));
      paramauko.systemHeadID = paramCursor.getShort(paramCursor.getColumnIndex("systemHeadID"));
      paramauko.bFaceFlags = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bFaceFlags")));
      paramauko.bUsrType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bUsrType")));
      paramauko.bHeadType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bHeadType")));
      paramauko.url = paramCursor.getString(paramCursor.getColumnIndex("url"));
      paramauko.bSourceType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSourceType")));
      paramauko.updateTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("updateTimestamp"));
      return paramauko;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramaukz.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("headImgTimestamp");
      if (i != -1) {
        break label508;
      }
      paramaukz.a(new NoColumnError("headImgTimestamp", Long.TYPE));
      label247:
      i = paramCursor.getColumnIndex("systemHeadID");
      if (i != -1) {
        break label523;
      }
      paramaukz.a(new NoColumnError("systemHeadID", Short.TYPE));
      label282:
      i = paramCursor.getColumnIndex("bFaceFlags");
      if (i != -1) {
        break label538;
      }
      paramaukz.a(new NoColumnError("bFaceFlags", Byte.TYPE));
      label317:
      i = paramCursor.getColumnIndex("bUsrType");
      if (i != -1) {
        break label554;
      }
      paramaukz.a(new NoColumnError("bUsrType", Byte.TYPE));
      label352:
      i = paramCursor.getColumnIndex("bHeadType");
      if (i != -1) {
        break label570;
      }
      paramaukz.a(new NoColumnError("bHeadType", Byte.TYPE));
      label387:
      i = paramCursor.getColumnIndex("url");
      if (i != -1) {
        break label586;
      }
      paramaukz.a(new NoColumnError("url", String.class));
      label421:
      i = paramCursor.getColumnIndex("bSourceType");
      if (i != -1) {
        break label601;
      }
      paramaukz.a(new NoColumnError("bSourceType", Byte.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("updateTimestamp");
      if (i != -1) {
        break label617;
      }
      paramaukz.a(new NoColumnError("updateTimestamp", Long.TYPE));
      return paramauko;
      paramauko.uin = paramCursor.getString(i);
      break;
      label508:
      paramauko.headImgTimestamp = paramCursor.getLong(i);
      break label247;
      label523:
      paramauko.systemHeadID = paramCursor.getShort(i);
      break label282;
      label538:
      paramauko.bFaceFlags = ((byte)paramCursor.getShort(i));
      break label317;
      label554:
      paramauko.bUsrType = ((byte)paramCursor.getShort(i));
      break label352;
      label570:
      paramauko.bHeadType = ((byte)paramCursor.getShort(i));
      break label387;
      label586:
      paramauko.url = paramCursor.getString(i);
      break label421;
      label601:
      paramauko.bSourceType = ((byte)paramCursor.getShort(i));
    }
    label617:
    paramauko.updateTimestamp = paramCursor.getLong(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,headImgTimestamp INTEGER ,systemHeadID INTEGER ,bFaceFlags INTEGER ,bUsrType INTEGER ,bHeadType INTEGER ,url TEXT ,bSourceType INTEGER ,updateTimestamp INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (Setting)paramauko;
    paramContentValues.put("uin", paramauko.uin);
    paramContentValues.put("headImgTimestamp", Long.valueOf(paramauko.headImgTimestamp));
    paramContentValues.put("systemHeadID", Short.valueOf(paramauko.systemHeadID));
    paramContentValues.put("bFaceFlags", Byte.valueOf(paramauko.bFaceFlags));
    paramContentValues.put("bUsrType", Byte.valueOf(paramauko.bUsrType));
    paramContentValues.put("bHeadType", Byte.valueOf(paramauko.bHeadType));
    paramContentValues.put("url", paramauko.url);
    paramContentValues.put("bSourceType", Byte.valueOf(paramauko.bSourceType));
    paramContentValues.put("updateTimestamp", Long.valueOf(paramauko.updateTimestamp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aull
 * JD-Core Version:    0.7.0.1
 */