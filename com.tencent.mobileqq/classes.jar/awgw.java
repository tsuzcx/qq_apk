import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awgw
  extends awgq
{
  public awgw()
  {
    this.a = 5;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    paramawge = (QZoneCover)paramawge;
    if (paramawgp == null)
    {
      paramawge.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawge.type = paramCursor.getString(paramCursor.getColumnIndex("type"));
      paramawge.jigsaw = paramCursor.getInt(paramCursor.getColumnIndex("jigsaw"));
      paramawge.vCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vCoverInfo"));
      paramawge.vPhotoInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vPhotoInfo"));
      return paramawge;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramawgp.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label290;
      }
      paramawgp.a(new NoColumnError("type", String.class));
      label170:
      i = paramCursor.getColumnIndex("jigsaw");
      if (i != -1) {
        break label305;
      }
      paramawgp.a(new NoColumnError("jigsaw", Integer.TYPE));
      label205:
      i = paramCursor.getColumnIndex("vCoverInfo");
      if (i != -1) {
        break label320;
      }
      paramawgp.a(new NoColumnError("vCoverInfo", [B.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("vPhotoInfo");
      if (i != -1) {
        break label335;
      }
      paramawgp.a(new NoColumnError("vPhotoInfo", [B.class));
      return paramawge;
      paramawge.uin = paramCursor.getString(i);
      break;
      label290:
      paramawge.type = paramCursor.getString(i);
      break label170;
      label305:
      paramawge.jigsaw = paramCursor.getInt(i);
      break label205;
      label320:
      paramawge.vCoverInfo = paramCursor.getBlob(i);
    }
    label335:
    paramawge.vPhotoInfo = paramCursor.getBlob(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,type TEXT ,jigsaw INTEGER ,vCoverInfo BLOB ,vPhotoInfo BLOB)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (QZoneCover)paramawge;
    paramContentValues.put("uin", paramawge.uin);
    paramContentValues.put("type", paramawge.type);
    paramContentValues.put("jigsaw", Integer.valueOf(paramawge.jigsaw));
    paramContentValues.put("vCoverInfo", paramawge.vCoverInfo);
    paramContentValues.put("vPhotoInfo", paramawge.vPhotoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awgw
 * JD-Core Version:    0.7.0.1
 */