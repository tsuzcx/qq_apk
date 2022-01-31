import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atng
  extends atna
{
  public atng()
  {
    this.a = 5;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    paramatmo = (QZoneCover)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramatmo.type = paramCursor.getString(paramCursor.getColumnIndex("type"));
      paramatmo.jigsaw = paramCursor.getInt(paramCursor.getColumnIndex("jigsaw"));
      paramatmo.vCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vCoverInfo"));
      paramatmo.vPhotoInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vPhotoInfo"));
      return paramatmo;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramatmz.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label290;
      }
      paramatmz.a(new NoColumnError("type", String.class));
      label170:
      i = paramCursor.getColumnIndex("jigsaw");
      if (i != -1) {
        break label305;
      }
      paramatmz.a(new NoColumnError("jigsaw", Integer.TYPE));
      label205:
      i = paramCursor.getColumnIndex("vCoverInfo");
      if (i != -1) {
        break label320;
      }
      paramatmz.a(new NoColumnError("vCoverInfo", [B.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("vPhotoInfo");
      if (i != -1) {
        break label335;
      }
      paramatmz.a(new NoColumnError("vPhotoInfo", [B.class));
      return paramatmo;
      paramatmo.uin = paramCursor.getString(i);
      break;
      label290:
      paramatmo.type = paramCursor.getString(i);
      break label170;
      label305:
      paramatmo.jigsaw = paramCursor.getInt(i);
      break label205;
      label320:
      paramatmo.vCoverInfo = paramCursor.getBlob(i);
    }
    label335:
    paramatmo.vPhotoInfo = paramCursor.getBlob(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,type TEXT ,jigsaw INTEGER ,vCoverInfo BLOB ,vPhotoInfo BLOB)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (QZoneCover)paramatmo;
    paramContentValues.put("uin", paramatmo.uin);
    paramContentValues.put("type", paramatmo.type);
    paramContentValues.put("jigsaw", Integer.valueOf(paramatmo.jigsaw));
    paramContentValues.put("vCoverInfo", paramatmo.vCoverInfo);
    paramContentValues.put("vPhotoInfo", paramatmo.vPhotoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atng
 * JD-Core Version:    0.7.0.1
 */