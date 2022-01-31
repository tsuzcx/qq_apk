import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;

public class avxx
  extends ContentObserver
{
  private static final String jdField_a_of_type_JavaLangString = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "_data", "date_added" };
  private ContentResolver jdField_a_of_type_AndroidContentContentResolver;
  private avxy jdField_a_of_type_Avxy;
  
  public avxx(Handler paramHandler, Context paramContext)
  {
    super(paramHandler);
    this.jdField_a_of_type_AndroidContentContentResolver = paramContext.getContentResolver();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentContentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this);
  }
  
  public void a(avxy paramavxy)
  {
    this.jdField_a_of_type_Avxy = paramavxy;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidContentContentResolver.unregisterContentObserver(this);
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    onChange(paramBoolean, null);
  }
  
  public void onChange(boolean paramBoolean, Uri paramUri)
  {
    Cursor localCursor;
    String str;
    long l;
    if (paramUri == null)
    {
      localCursor = this.jdField_a_of_type_AndroidContentContentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, jdField_a_of_type_ArrayOfJavaLangString, null, null, "date_added DESC");
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        str = localCursor.getString(localCursor.getColumnIndex("_data"));
        l = localCursor.getLong(localCursor.getColumnIndex("date_added"));
        if ((Math.abs(System.currentTimeMillis() / 1000L - l) <= 3L) && (str.toLowerCase().contains("screenshot")) && (this.jdField_a_of_type_Avxy != null)) {
          this.jdField_a_of_type_Avxy.a(paramUri);
        }
      }
      if (localCursor != null) {
        localCursor.close();
      }
    }
    do
    {
      do
      {
        return;
      } while (!paramUri.toString().matches(jdField_a_of_type_JavaLangString + "/\\d+"));
      localCursor = this.jdField_a_of_type_AndroidContentContentResolver.query(paramUri, jdField_a_of_type_ArrayOfJavaLangString, null, null, null);
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        str = localCursor.getString(localCursor.getColumnIndex("_data"));
        l = localCursor.getLong(localCursor.getColumnIndex("date_added"));
        if ((Math.abs(System.currentTimeMillis() / 1000L - l) <= 3L) && (str.toLowerCase().contains("screenshot")) && (this.jdField_a_of_type_Avxy != null)) {
          this.jdField_a_of_type_Avxy.a(paramUri);
        }
      }
    } while (localCursor == null);
    localCursor.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avxx
 * JD-Core Version:    0.7.0.1
 */