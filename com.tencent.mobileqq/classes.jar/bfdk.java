import android.database.Cursor;
import android.os.Parcel;

final class bfdk
  implements bfjh<bfdj>
{
  public int a()
  {
    return 0;
  }
  
  public bfdj a(Cursor paramCursor)
  {
    Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("data"));
    if (localObject == null) {
      return null;
    }
    paramCursor = Parcel.obtain();
    paramCursor.unmarshall((byte[])localObject, 0, localObject.length);
    paramCursor.setDataPosition(0);
    localObject = new bfdj();
    ((bfdj)localObject).a(paramCursor);
    paramCursor.recycle();
    return localObject;
  }
  
  public String a()
  {
    return null;
  }
  
  public bfji[] a()
  {
    return new bfji[] { new bfji("groupId", "INTEGER UNIQUE"), new bfji("data", "BLOB") };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfdk
 * JD-Core Version:    0.7.0.1
 */