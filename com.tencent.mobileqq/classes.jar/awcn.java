import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awcn
  extends awch
{
  public awcn()
  {
    this.a = 5;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    paramawbv = (QZoneCover)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawbv.type = paramCursor.getString(paramCursor.getColumnIndex("type"));
      paramawbv.jigsaw = paramCursor.getInt(paramCursor.getColumnIndex("jigsaw"));
      paramawbv.vCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vCoverInfo"));
      paramawbv.vPhotoInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vPhotoInfo"));
      return paramawbv;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramawcg.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label290;
      }
      paramawcg.a(new NoColumnError("type", String.class));
      label170:
      i = paramCursor.getColumnIndex("jigsaw");
      if (i != -1) {
        break label305;
      }
      paramawcg.a(new NoColumnError("jigsaw", Integer.TYPE));
      label205:
      i = paramCursor.getColumnIndex("vCoverInfo");
      if (i != -1) {
        break label320;
      }
      paramawcg.a(new NoColumnError("vCoverInfo", [B.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("vPhotoInfo");
      if (i != -1) {
        break label335;
      }
      paramawcg.a(new NoColumnError("vPhotoInfo", [B.class));
      return paramawbv;
      paramawbv.uin = paramCursor.getString(i);
      break;
      label290:
      paramawbv.type = paramCursor.getString(i);
      break label170;
      label305:
      paramawbv.jigsaw = paramCursor.getInt(i);
      break label205;
      label320:
      paramawbv.vCoverInfo = paramCursor.getBlob(i);
    }
    label335:
    paramawbv.vPhotoInfo = paramCursor.getBlob(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,type TEXT ,jigsaw INTEGER ,vCoverInfo BLOB ,vPhotoInfo BLOB)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (QZoneCover)paramawbv;
    paramContentValues.put("uin", paramawbv.uin);
    paramContentValues.put("type", paramawbv.type);
    paramContentValues.put("jigsaw", Integer.valueOf(paramawbv.jigsaw));
    paramContentValues.put("vCoverInfo", paramawbv.vCoverInfo);
    paramContentValues.put("vPhotoInfo", paramawbv.vPhotoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awcn
 * JD-Core Version:    0.7.0.1
 */