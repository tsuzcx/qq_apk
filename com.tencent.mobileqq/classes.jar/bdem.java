import android.database.Cursor;
import android.os.Parcel;

final class bdem
  implements bdkk<bdel>
{
  public int a()
  {
    return 0;
  }
  
  public bdel a(Cursor paramCursor)
  {
    Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("data"));
    if (localObject == null) {
      return null;
    }
    paramCursor = Parcel.obtain();
    paramCursor.unmarshall((byte[])localObject, 0, localObject.length);
    paramCursor.setDataPosition(0);
    localObject = new bdel();
    ((bdel)localObject).a(paramCursor);
    paramCursor.recycle();
    return localObject;
  }
  
  public String a()
  {
    return null;
  }
  
  public bdkl[] a()
  {
    return new bdkl[] { new bdkl("groupId", "INTEGER UNIQUE"), new bdkl("data", "BLOB") };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdem
 * JD-Core Version:    0.7.0.1
 */