import android.database.Cursor;
import android.os.Parcel;

final class bbzx
  implements bcfu<bbzw>
{
  public int a()
  {
    return 0;
  }
  
  public bbzw a(Cursor paramCursor)
  {
    Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("data"));
    if (localObject == null) {
      return null;
    }
    paramCursor = Parcel.obtain();
    paramCursor.unmarshall((byte[])localObject, 0, localObject.length);
    paramCursor.setDataPosition(0);
    localObject = new bbzw();
    ((bbzw)localObject).a(paramCursor);
    paramCursor.recycle();
    return localObject;
  }
  
  public String a()
  {
    return null;
  }
  
  public bcfv[] a()
  {
    return new bcfv[] { new bcfv("groupId", "INTEGER UNIQUE"), new bcfv("data", "BLOB") };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbzx
 * JD-Core Version:    0.7.0.1
 */