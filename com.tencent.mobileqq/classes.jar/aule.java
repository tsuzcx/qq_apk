import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aule
  extends auky
{
  public aule()
  {
    this.a = 5;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    paramaukm = (QZoneCover)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramaukm.type = paramCursor.getString(paramCursor.getColumnIndex("type"));
      paramaukm.jigsaw = paramCursor.getInt(paramCursor.getColumnIndex("jigsaw"));
      paramaukm.vCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vCoverInfo"));
      paramaukm.vPhotoInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vPhotoInfo"));
      return paramaukm;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramaukx.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label290;
      }
      paramaukx.a(new NoColumnError("type", String.class));
      label170:
      i = paramCursor.getColumnIndex("jigsaw");
      if (i != -1) {
        break label305;
      }
      paramaukx.a(new NoColumnError("jigsaw", Integer.TYPE));
      label205:
      i = paramCursor.getColumnIndex("vCoverInfo");
      if (i != -1) {
        break label320;
      }
      paramaukx.a(new NoColumnError("vCoverInfo", [B.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("vPhotoInfo");
      if (i != -1) {
        break label335;
      }
      paramaukx.a(new NoColumnError("vPhotoInfo", [B.class));
      return paramaukm;
      paramaukm.uin = paramCursor.getString(i);
      break;
      label290:
      paramaukm.type = paramCursor.getString(i);
      break label170;
      label305:
      paramaukm.jigsaw = paramCursor.getInt(i);
      break label205;
      label320:
      paramaukm.vCoverInfo = paramCursor.getBlob(i);
    }
    label335:
    paramaukm.vPhotoInfo = paramCursor.getBlob(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,type TEXT ,jigsaw INTEGER ,vCoverInfo BLOB ,vPhotoInfo BLOB)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (QZoneCover)paramaukm;
    paramContentValues.put("uin", paramaukm.uin);
    paramContentValues.put("type", paramaukm.type);
    paramContentValues.put("jigsaw", Integer.valueOf(paramaukm.jigsaw));
    paramContentValues.put("vCoverInfo", paramaukm.vCoverInfo);
    paramContentValues.put("vPhotoInfo", paramaukm.vPhotoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aule
 * JD-Core Version:    0.7.0.1
 */