import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awcs
  extends awch
{
  public awcs()
  {
    this.a = 9;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    paramawbv = (Setting)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawbv.headImgTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("headImgTimestamp"));
      paramawbv.systemHeadID = paramCursor.getShort(paramCursor.getColumnIndex("systemHeadID"));
      paramawbv.bFaceFlags = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bFaceFlags")));
      paramawbv.bUsrType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bUsrType")));
      paramawbv.bHeadType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bHeadType")));
      paramawbv.url = paramCursor.getString(paramCursor.getColumnIndex("url"));
      paramawbv.bSourceType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSourceType")));
      paramawbv.updateTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("updateTimestamp"));
      return paramawbv;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramawcg.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("headImgTimestamp");
      if (i != -1) {
        break label508;
      }
      paramawcg.a(new NoColumnError("headImgTimestamp", Long.TYPE));
      label247:
      i = paramCursor.getColumnIndex("systemHeadID");
      if (i != -1) {
        break label523;
      }
      paramawcg.a(new NoColumnError("systemHeadID", Short.TYPE));
      label282:
      i = paramCursor.getColumnIndex("bFaceFlags");
      if (i != -1) {
        break label538;
      }
      paramawcg.a(new NoColumnError("bFaceFlags", Byte.TYPE));
      label317:
      i = paramCursor.getColumnIndex("bUsrType");
      if (i != -1) {
        break label554;
      }
      paramawcg.a(new NoColumnError("bUsrType", Byte.TYPE));
      label352:
      i = paramCursor.getColumnIndex("bHeadType");
      if (i != -1) {
        break label570;
      }
      paramawcg.a(new NoColumnError("bHeadType", Byte.TYPE));
      label387:
      i = paramCursor.getColumnIndex("url");
      if (i != -1) {
        break label586;
      }
      paramawcg.a(new NoColumnError("url", String.class));
      label421:
      i = paramCursor.getColumnIndex("bSourceType");
      if (i != -1) {
        break label601;
      }
      paramawcg.a(new NoColumnError("bSourceType", Byte.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("updateTimestamp");
      if (i != -1) {
        break label617;
      }
      paramawcg.a(new NoColumnError("updateTimestamp", Long.TYPE));
      return paramawbv;
      paramawbv.uin = paramCursor.getString(i);
      break;
      label508:
      paramawbv.headImgTimestamp = paramCursor.getLong(i);
      break label247;
      label523:
      paramawbv.systemHeadID = paramCursor.getShort(i);
      break label282;
      label538:
      paramawbv.bFaceFlags = ((byte)paramCursor.getShort(i));
      break label317;
      label554:
      paramawbv.bUsrType = ((byte)paramCursor.getShort(i));
      break label352;
      label570:
      paramawbv.bHeadType = ((byte)paramCursor.getShort(i));
      break label387;
      label586:
      paramawbv.url = paramCursor.getString(i);
      break label421;
      label601:
      paramawbv.bSourceType = ((byte)paramCursor.getShort(i));
    }
    label617:
    paramawbv.updateTimestamp = paramCursor.getLong(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,headImgTimestamp INTEGER ,systemHeadID INTEGER ,bFaceFlags INTEGER ,bUsrType INTEGER ,bHeadType INTEGER ,url TEXT ,bSourceType INTEGER ,updateTimestamp INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (Setting)paramawbv;
    paramContentValues.put("uin", paramawbv.uin);
    paramContentValues.put("headImgTimestamp", Long.valueOf(paramawbv.headImgTimestamp));
    paramContentValues.put("systemHeadID", Short.valueOf(paramawbv.systemHeadID));
    paramContentValues.put("bFaceFlags", Byte.valueOf(paramawbv.bFaceFlags));
    paramContentValues.put("bUsrType", Byte.valueOf(paramawbv.bUsrType));
    paramContentValues.put("bHeadType", Byte.valueOf(paramawbv.bHeadType));
    paramContentValues.put("url", paramawbv.url);
    paramContentValues.put("bSourceType", Byte.valueOf(paramawbv.bSourceType));
    paramContentValues.put("updateTimestamp", Long.valueOf(paramawbv.updateTimestamp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awcs
 * JD-Core Version:    0.7.0.1
 */