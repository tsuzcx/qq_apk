import android.database.Cursor;
import android.os.Parcel;

final class bdjb
  implements bdkk<bdja>
{
  public int a()
  {
    return 1;
  }
  
  public bdja a(Cursor paramCursor)
  {
    try
    {
      String str1 = paramCursor.getString(paramCursor.getColumnIndex("urlKey"));
      String str2 = paramCursor.getString(paramCursor.getColumnIndex("ETag"));
      long l1 = paramCursor.getLong(paramCursor.getColumnIndex("lastModify"));
      long l2 = paramCursor.getLong(paramCursor.getColumnIndex("cacheTime"));
      Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("response"));
      paramCursor = Parcel.obtain();
      paramCursor.unmarshall((byte[])localObject, 0, localObject.length);
      paramCursor.setDataPosition(0);
      localObject = paramCursor.readString();
      paramCursor.recycle();
      paramCursor = new bdja(str1, str2, l1, l2, (String)localObject);
      return paramCursor;
    }
    catch (Exception paramCursor)
    {
      paramCursor.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    return null;
  }
  
  public bdkl[] a()
  {
    return new bdkl[] { new bdkl("urlKey", "TEXT"), new bdkl("ETag", "TEXT"), new bdkl("lastModify", "INTEGER"), new bdkl("cacheTime", "INTEGER"), new bdkl("response", "BLOB") };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdjb
 * JD-Core Version:    0.7.0.1
 */