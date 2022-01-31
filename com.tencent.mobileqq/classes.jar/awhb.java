import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awhb
  extends awgq
{
  public awhb()
  {
    this.a = 9;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    paramawge = (Setting)paramawge;
    if (paramawgp == null)
    {
      paramawge.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawge.headImgTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("headImgTimestamp"));
      paramawge.systemHeadID = paramCursor.getShort(paramCursor.getColumnIndex("systemHeadID"));
      paramawge.bFaceFlags = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bFaceFlags")));
      paramawge.bUsrType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bUsrType")));
      paramawge.bHeadType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bHeadType")));
      paramawge.url = paramCursor.getString(paramCursor.getColumnIndex("url"));
      paramawge.bSourceType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSourceType")));
      paramawge.updateTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("updateTimestamp"));
      return paramawge;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramawgp.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("headImgTimestamp");
      if (i != -1) {
        break label508;
      }
      paramawgp.a(new NoColumnError("headImgTimestamp", Long.TYPE));
      label247:
      i = paramCursor.getColumnIndex("systemHeadID");
      if (i != -1) {
        break label523;
      }
      paramawgp.a(new NoColumnError("systemHeadID", Short.TYPE));
      label282:
      i = paramCursor.getColumnIndex("bFaceFlags");
      if (i != -1) {
        break label538;
      }
      paramawgp.a(new NoColumnError("bFaceFlags", Byte.TYPE));
      label317:
      i = paramCursor.getColumnIndex("bUsrType");
      if (i != -1) {
        break label554;
      }
      paramawgp.a(new NoColumnError("bUsrType", Byte.TYPE));
      label352:
      i = paramCursor.getColumnIndex("bHeadType");
      if (i != -1) {
        break label570;
      }
      paramawgp.a(new NoColumnError("bHeadType", Byte.TYPE));
      label387:
      i = paramCursor.getColumnIndex("url");
      if (i != -1) {
        break label586;
      }
      paramawgp.a(new NoColumnError("url", String.class));
      label421:
      i = paramCursor.getColumnIndex("bSourceType");
      if (i != -1) {
        break label601;
      }
      paramawgp.a(new NoColumnError("bSourceType", Byte.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("updateTimestamp");
      if (i != -1) {
        break label617;
      }
      paramawgp.a(new NoColumnError("updateTimestamp", Long.TYPE));
      return paramawge;
      paramawge.uin = paramCursor.getString(i);
      break;
      label508:
      paramawge.headImgTimestamp = paramCursor.getLong(i);
      break label247;
      label523:
      paramawge.systemHeadID = paramCursor.getShort(i);
      break label282;
      label538:
      paramawge.bFaceFlags = ((byte)paramCursor.getShort(i));
      break label317;
      label554:
      paramawge.bUsrType = ((byte)paramCursor.getShort(i));
      break label352;
      label570:
      paramawge.bHeadType = ((byte)paramCursor.getShort(i));
      break label387;
      label586:
      paramawge.url = paramCursor.getString(i);
      break label421;
      label601:
      paramawge.bSourceType = ((byte)paramCursor.getShort(i));
    }
    label617:
    paramawge.updateTimestamp = paramCursor.getLong(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,headImgTimestamp INTEGER ,systemHeadID INTEGER ,bFaceFlags INTEGER ,bUsrType INTEGER ,bHeadType INTEGER ,url TEXT ,bSourceType INTEGER ,updateTimestamp INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (Setting)paramawge;
    paramContentValues.put("uin", paramawge.uin);
    paramContentValues.put("headImgTimestamp", Long.valueOf(paramawge.headImgTimestamp));
    paramContentValues.put("systemHeadID", Short.valueOf(paramawge.systemHeadID));
    paramContentValues.put("bFaceFlags", Byte.valueOf(paramawge.bFaceFlags));
    paramContentValues.put("bUsrType", Byte.valueOf(paramawge.bUsrType));
    paramContentValues.put("bHeadType", Byte.valueOf(paramawge.bHeadType));
    paramContentValues.put("url", paramawge.url);
    paramContentValues.put("bSourceType", Byte.valueOf(paramawge.bSourceType));
    paramContentValues.put("updateTimestamp", Long.valueOf(paramawge.updateTimestamp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awhb
 * JD-Core Version:    0.7.0.1
 */