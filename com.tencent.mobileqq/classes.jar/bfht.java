import android.database.Cursor;
import android.os.Parcel;

final class bfht
  implements bfnq<bfhs>
{
  public int a()
  {
    return 0;
  }
  
  public bfhs a(Cursor paramCursor)
  {
    Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("data"));
    if (localObject == null) {
      return null;
    }
    paramCursor = Parcel.obtain();
    paramCursor.unmarshall((byte[])localObject, 0, localObject.length);
    paramCursor.setDataPosition(0);
    localObject = new bfhs();
    ((bfhs)localObject).a(paramCursor);
    paramCursor.recycle();
    return localObject;
  }
  
  public String a()
  {
    return null;
  }
  
  public bfnr[] a()
  {
    return new bfnr[] { new bfnr("groupId", "INTEGER UNIQUE"), new bfnr("data", "BLOB") };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfht
 * JD-Core Version:    0.7.0.1
 */