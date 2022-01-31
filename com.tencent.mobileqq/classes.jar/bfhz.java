import android.database.Cursor;
import android.os.Parcel;

final class bfhz
  implements bfjh<bfhy>
{
  public int a()
  {
    return 1;
  }
  
  public bfhy a(Cursor paramCursor)
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
      paramCursor = new bfhy(str1, str2, l1, l2, (String)localObject);
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
  
  public bfji[] a()
  {
    return new bfji[] { new bfji("urlKey", "TEXT"), new bfji("ETag", "TEXT"), new bfji("lastModify", "INTEGER"), new bfji("cacheTime", "INTEGER"), new bfji("response", "BLOB") };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfhz
 * JD-Core Version:    0.7.0.1
 */