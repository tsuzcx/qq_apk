import android.database.Cursor;
import android.os.Parcel;
import com.tencent.open.component.cache.database.DbCacheData.DbCreator;
import com.tencent.open.component.cache.database.DbCacheData.Structure;

final class bjgr
  implements DbCacheData.DbCreator<bjgq>
{
  public bjgq a(Cursor paramCursor)
  {
    Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("data"));
    if (localObject == null) {
      return null;
    }
    paramCursor = Parcel.obtain();
    paramCursor.unmarshall((byte[])localObject, 0, localObject.length);
    paramCursor.setDataPosition(0);
    localObject = new bjgq();
    ((bjgq)localObject).a(paramCursor);
    paramCursor.recycle();
    return localObject;
  }
  
  public String sortOrder()
  {
    return null;
  }
  
  public DbCacheData.Structure[] structure()
  {
    return new DbCacheData.Structure[] { new DbCacheData.Structure("groupId", "INTEGER UNIQUE"), new DbCacheData.Structure("data", "BLOB") };
  }
  
  public int version()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjgr
 * JD-Core Version:    0.7.0.1
 */