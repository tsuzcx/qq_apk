import android.database.Cursor;
import android.os.Parcel;

final class bddx
  implements bdjv<bddw>
{
  public int a()
  {
    return 0;
  }
  
  public bddw a(Cursor paramCursor)
  {
    Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("data"));
    if (localObject == null) {
      return null;
    }
    paramCursor = Parcel.obtain();
    paramCursor.unmarshall((byte[])localObject, 0, localObject.length);
    paramCursor.setDataPosition(0);
    localObject = new bddw();
    ((bddw)localObject).a(paramCursor);
    paramCursor.recycle();
    return localObject;
  }
  
  public String a()
  {
    return null;
  }
  
  public bdjw[] a()
  {
    return new bdjw[] { new bdjw("groupId", "INTEGER UNIQUE"), new bdjw("data", "BLOB") };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bddx
 * JD-Core Version:    0.7.0.1
 */