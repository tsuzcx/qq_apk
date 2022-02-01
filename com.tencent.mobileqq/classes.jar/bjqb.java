import android.database.Cursor;
import android.os.Parcel;

final class bjqb
  implements bjvx<bjqa>
{
  public int a()
  {
    return 0;
  }
  
  public bjqa a(Cursor paramCursor)
  {
    Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("data"));
    if (localObject == null) {
      return null;
    }
    paramCursor = Parcel.obtain();
    paramCursor.unmarshall((byte[])localObject, 0, localObject.length);
    paramCursor.setDataPosition(0);
    localObject = new bjqa();
    ((bjqa)localObject).a(paramCursor);
    paramCursor.recycle();
    return localObject;
  }
  
  public String a()
  {
    return null;
  }
  
  public bjvy[] a()
  {
    return new bjvy[] { new bjvy("groupId", "INTEGER UNIQUE"), new bjvy("data", "BLOB") };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjqb
 * JD-Core Version:    0.7.0.1
 */