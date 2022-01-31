import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atnl
  extends atna
{
  public atnl()
  {
    this.a = 9;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    paramatmo = (Setting)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramatmo.headImgTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("headImgTimestamp"));
      paramatmo.systemHeadID = paramCursor.getShort(paramCursor.getColumnIndex("systemHeadID"));
      paramatmo.bFaceFlags = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bFaceFlags")));
      paramatmo.bUsrType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bUsrType")));
      paramatmo.bHeadType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bHeadType")));
      paramatmo.url = paramCursor.getString(paramCursor.getColumnIndex("url"));
      paramatmo.bSourceType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSourceType")));
      paramatmo.updateTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("updateTimestamp"));
      return paramatmo;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramatmz.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("headImgTimestamp");
      if (i != -1) {
        break label508;
      }
      paramatmz.a(new NoColumnError("headImgTimestamp", Long.TYPE));
      label247:
      i = paramCursor.getColumnIndex("systemHeadID");
      if (i != -1) {
        break label523;
      }
      paramatmz.a(new NoColumnError("systemHeadID", Short.TYPE));
      label282:
      i = paramCursor.getColumnIndex("bFaceFlags");
      if (i != -1) {
        break label538;
      }
      paramatmz.a(new NoColumnError("bFaceFlags", Byte.TYPE));
      label317:
      i = paramCursor.getColumnIndex("bUsrType");
      if (i != -1) {
        break label554;
      }
      paramatmz.a(new NoColumnError("bUsrType", Byte.TYPE));
      label352:
      i = paramCursor.getColumnIndex("bHeadType");
      if (i != -1) {
        break label570;
      }
      paramatmz.a(new NoColumnError("bHeadType", Byte.TYPE));
      label387:
      i = paramCursor.getColumnIndex("url");
      if (i != -1) {
        break label586;
      }
      paramatmz.a(new NoColumnError("url", String.class));
      label421:
      i = paramCursor.getColumnIndex("bSourceType");
      if (i != -1) {
        break label601;
      }
      paramatmz.a(new NoColumnError("bSourceType", Byte.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("updateTimestamp");
      if (i != -1) {
        break label617;
      }
      paramatmz.a(new NoColumnError("updateTimestamp", Long.TYPE));
      return paramatmo;
      paramatmo.uin = paramCursor.getString(i);
      break;
      label508:
      paramatmo.headImgTimestamp = paramCursor.getLong(i);
      break label247;
      label523:
      paramatmo.systemHeadID = paramCursor.getShort(i);
      break label282;
      label538:
      paramatmo.bFaceFlags = ((byte)paramCursor.getShort(i));
      break label317;
      label554:
      paramatmo.bUsrType = ((byte)paramCursor.getShort(i));
      break label352;
      label570:
      paramatmo.bHeadType = ((byte)paramCursor.getShort(i));
      break label387;
      label586:
      paramatmo.url = paramCursor.getString(i);
      break label421;
      label601:
      paramatmo.bSourceType = ((byte)paramCursor.getShort(i));
    }
    label617:
    paramatmo.updateTimestamp = paramCursor.getLong(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,headImgTimestamp INTEGER ,systemHeadID INTEGER ,bFaceFlags INTEGER ,bUsrType INTEGER ,bHeadType INTEGER ,url TEXT ,bSourceType INTEGER ,updateTimestamp INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (Setting)paramatmo;
    paramContentValues.put("uin", paramatmo.uin);
    paramContentValues.put("headImgTimestamp", Long.valueOf(paramatmo.headImgTimestamp));
    paramContentValues.put("systemHeadID", Short.valueOf(paramatmo.systemHeadID));
    paramContentValues.put("bFaceFlags", Byte.valueOf(paramatmo.bFaceFlags));
    paramContentValues.put("bUsrType", Byte.valueOf(paramatmo.bUsrType));
    paramContentValues.put("bHeadType", Byte.valueOf(paramatmo.bHeadType));
    paramContentValues.put("url", paramatmo.url);
    paramContentValues.put("bSourceType", Byte.valueOf(paramatmo.bSourceType));
    paramContentValues.put("updateTimestamp", Long.valueOf(paramatmo.updateTimestamp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atnl
 * JD-Core Version:    0.7.0.1
 */