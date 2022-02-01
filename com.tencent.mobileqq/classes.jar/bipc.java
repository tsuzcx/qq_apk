import android.database.Cursor;
import android.os.Parcel;

final class bipc
  implements biuy<bipb>
{
  public int a()
  {
    return 0;
  }
  
  public bipb a(Cursor paramCursor)
  {
    Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("data"));
    if (localObject == null) {
      return null;
    }
    paramCursor = Parcel.obtain();
    paramCursor.unmarshall((byte[])localObject, 0, localObject.length);
    paramCursor.setDataPosition(0);
    localObject = new bipb();
    ((bipb)localObject).a(paramCursor);
    paramCursor.recycle();
    return localObject;
  }
  
  public String a()
  {
    return null;
  }
  
  public biuz[] a()
  {
    return new biuz[] { new biuz("groupId", "INTEGER UNIQUE"), new biuz("data", "BLOB") };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bipc
 * JD-Core Version:    0.7.0.1
 */