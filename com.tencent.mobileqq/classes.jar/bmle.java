import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public abstract interface bmle
{
  public abstract int delete(Uri paramUri, String paramString, String[] paramArrayOfString);
  
  public abstract Uri insert(Uri paramUri, ContentValues paramContentValues);
  
  public abstract Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2);
  
  public abstract int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bmle
 * JD-Core Version:    0.7.0.1
 */