import android.database.Cursor;
import android.os.Parcel;
import com.tencent.open.component.cache.database.DbCacheData.DbCreator;
import com.tencent.open.component.cache.database.DbCacheData.Structure;

final class bjle
  implements DbCacheData.DbCreator<bjld>
{
  public bjld a(Cursor paramCursor)
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
      paramCursor = new bjld(str1, str2, l1, l2, (String)localObject);
      return paramCursor;
    }
    catch (Exception paramCursor)
    {
      paramCursor.printStackTrace();
    }
    return null;
  }
  
  public String sortOrder()
  {
    return null;
  }
  
  public DbCacheData.Structure[] structure()
  {
    return new DbCacheData.Structure[] { new DbCacheData.Structure("urlKey", "TEXT"), new DbCacheData.Structure("ETag", "TEXT"), new DbCacheData.Structure("lastModify", "INTEGER"), new DbCacheData.Structure("cacheTime", "INTEGER"), new DbCacheData.Structure("response", "BLOB") };
  }
  
  public int version()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjle
 * JD-Core Version:    0.7.0.1
 */