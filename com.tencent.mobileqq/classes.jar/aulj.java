import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aulj
  extends auky
{
  public aulj()
  {
    this.a = 9;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    paramaukm = (Setting)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramaukm.headImgTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("headImgTimestamp"));
      paramaukm.systemHeadID = paramCursor.getShort(paramCursor.getColumnIndex("systemHeadID"));
      paramaukm.bFaceFlags = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bFaceFlags")));
      paramaukm.bUsrType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bUsrType")));
      paramaukm.bHeadType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bHeadType")));
      paramaukm.url = paramCursor.getString(paramCursor.getColumnIndex("url"));
      paramaukm.bSourceType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSourceType")));
      paramaukm.updateTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("updateTimestamp"));
      return paramaukm;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramaukx.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("headImgTimestamp");
      if (i != -1) {
        break label508;
      }
      paramaukx.a(new NoColumnError("headImgTimestamp", Long.TYPE));
      label247:
      i = paramCursor.getColumnIndex("systemHeadID");
      if (i != -1) {
        break label523;
      }
      paramaukx.a(new NoColumnError("systemHeadID", Short.TYPE));
      label282:
      i = paramCursor.getColumnIndex("bFaceFlags");
      if (i != -1) {
        break label538;
      }
      paramaukx.a(new NoColumnError("bFaceFlags", Byte.TYPE));
      label317:
      i = paramCursor.getColumnIndex("bUsrType");
      if (i != -1) {
        break label554;
      }
      paramaukx.a(new NoColumnError("bUsrType", Byte.TYPE));
      label352:
      i = paramCursor.getColumnIndex("bHeadType");
      if (i != -1) {
        break label570;
      }
      paramaukx.a(new NoColumnError("bHeadType", Byte.TYPE));
      label387:
      i = paramCursor.getColumnIndex("url");
      if (i != -1) {
        break label586;
      }
      paramaukx.a(new NoColumnError("url", String.class));
      label421:
      i = paramCursor.getColumnIndex("bSourceType");
      if (i != -1) {
        break label601;
      }
      paramaukx.a(new NoColumnError("bSourceType", Byte.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("updateTimestamp");
      if (i != -1) {
        break label617;
      }
      paramaukx.a(new NoColumnError("updateTimestamp", Long.TYPE));
      return paramaukm;
      paramaukm.uin = paramCursor.getString(i);
      break;
      label508:
      paramaukm.headImgTimestamp = paramCursor.getLong(i);
      break label247;
      label523:
      paramaukm.systemHeadID = paramCursor.getShort(i);
      break label282;
      label538:
      paramaukm.bFaceFlags = ((byte)paramCursor.getShort(i));
      break label317;
      label554:
      paramaukm.bUsrType = ((byte)paramCursor.getShort(i));
      break label352;
      label570:
      paramaukm.bHeadType = ((byte)paramCursor.getShort(i));
      break label387;
      label586:
      paramaukm.url = paramCursor.getString(i);
      break label421;
      label601:
      paramaukm.bSourceType = ((byte)paramCursor.getShort(i));
    }
    label617:
    paramaukm.updateTimestamp = paramCursor.getLong(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,headImgTimestamp INTEGER ,systemHeadID INTEGER ,bFaceFlags INTEGER ,bUsrType INTEGER ,bHeadType INTEGER ,url TEXT ,bSourceType INTEGER ,updateTimestamp INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (Setting)paramaukm;
    paramContentValues.put("uin", paramaukm.uin);
    paramContentValues.put("headImgTimestamp", Long.valueOf(paramaukm.headImgTimestamp));
    paramContentValues.put("systemHeadID", Short.valueOf(paramaukm.systemHeadID));
    paramContentValues.put("bFaceFlags", Byte.valueOf(paramaukm.bFaceFlags));
    paramContentValues.put("bUsrType", Byte.valueOf(paramaukm.bUsrType));
    paramContentValues.put("bHeadType", Byte.valueOf(paramaukm.bHeadType));
    paramContentValues.put("url", paramaukm.url);
    paramContentValues.put("bSourceType", Byte.valueOf(paramaukm.bSourceType));
    paramContentValues.put("updateTimestamp", Long.valueOf(paramaukm.updateTimestamp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aulj
 * JD-Core Version:    0.7.0.1
 */