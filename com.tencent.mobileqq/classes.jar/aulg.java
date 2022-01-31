import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aulg
  extends aula
{
  public aulg()
  {
    this.a = 5;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    paramauko = (QZoneCover)paramauko;
    if (paramaukz == null)
    {
      paramauko.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramauko.type = paramCursor.getString(paramCursor.getColumnIndex("type"));
      paramauko.jigsaw = paramCursor.getInt(paramCursor.getColumnIndex("jigsaw"));
      paramauko.vCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vCoverInfo"));
      paramauko.vPhotoInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vPhotoInfo"));
      return paramauko;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramaukz.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label290;
      }
      paramaukz.a(new NoColumnError("type", String.class));
      label170:
      i = paramCursor.getColumnIndex("jigsaw");
      if (i != -1) {
        break label305;
      }
      paramaukz.a(new NoColumnError("jigsaw", Integer.TYPE));
      label205:
      i = paramCursor.getColumnIndex("vCoverInfo");
      if (i != -1) {
        break label320;
      }
      paramaukz.a(new NoColumnError("vCoverInfo", [B.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("vPhotoInfo");
      if (i != -1) {
        break label335;
      }
      paramaukz.a(new NoColumnError("vPhotoInfo", [B.class));
      return paramauko;
      paramauko.uin = paramCursor.getString(i);
      break;
      label290:
      paramauko.type = paramCursor.getString(i);
      break label170;
      label305:
      paramauko.jigsaw = paramCursor.getInt(i);
      break label205;
      label320:
      paramauko.vCoverInfo = paramCursor.getBlob(i);
    }
    label335:
    paramauko.vPhotoInfo = paramCursor.getBlob(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,type TEXT ,jigsaw INTEGER ,vCoverInfo BLOB ,vPhotoInfo BLOB)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (QZoneCover)paramauko;
    paramContentValues.put("uin", paramauko.uin);
    paramContentValues.put("type", paramauko.type);
    paramContentValues.put("jigsaw", Integer.valueOf(paramauko.jigsaw));
    paramContentValues.put("vCoverInfo", paramauko.vCoverInfo);
    paramContentValues.put("vPhotoInfo", paramauko.vPhotoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aulg
 * JD-Core Version:    0.7.0.1
 */