import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import java.util.HashMap;

public class aukg
  implements Cursor
{
  private Cursor jdField_a_of_type_AndroidDatabaseCursor;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  
  public aukg(Cursor paramCursor)
  {
    this.jdField_a_of_type_AndroidDatabaseCursor = paramCursor;
  }
  
  public void close()
  {
    this.jdField_a_of_type_AndroidDatabaseCursor.close();
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    this.jdField_a_of_type_AndroidDatabaseCursor.copyStringToBuffer(paramInt, paramCharArrayBuffer);
  }
  
  public void deactivate()
  {
    this.jdField_a_of_type_AndroidDatabaseCursor.deactivate();
  }
  
  public byte[] getBlob(int paramInt)
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.getBlob(paramInt);
  }
  
  public int getColumnCount()
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.getColumnCount();
  }
  
  public int getColumnIndex(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      String[] arrayOfString = getColumnNames();
      HashMap localHashMap = new HashMap(arrayOfString.length);
      int i = 0;
      int j = arrayOfString.length;
      while (i < j)
      {
        localHashMap.put(arrayOfString[i], Integer.valueOf(i));
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilHashMap = localHashMap;
    }
    paramString = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return -1;
  }
  
  public int getColumnIndexOrThrow(String paramString)
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.getColumnIndexOrThrow(paramString);
  }
  
  public String getColumnName(int paramInt)
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.getColumnName(paramInt);
  }
  
  public String[] getColumnNames()
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.getColumnNames();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.getCount();
  }
  
  public double getDouble(int paramInt)
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.getDouble(paramInt);
  }
  
  public Bundle getExtras()
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.getExtras();
  }
  
  public float getFloat(int paramInt)
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.getFloat(paramInt);
  }
  
  public int getInt(int paramInt)
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.getInt(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.getLong(paramInt);
  }
  
  public Uri getNotificationUri()
  {
    return null;
  }
  
  public int getPosition()
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.getPosition();
  }
  
  public short getShort(int paramInt)
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.getShort(paramInt);
  }
  
  public String getString(int paramInt)
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.getString(paramInt);
  }
  
  @TargetApi(11)
  public int getType(int paramInt)
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.getType(paramInt);
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.getWantsAllOnMoveCalls();
  }
  
  public boolean isAfterLast()
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.isAfterLast();
  }
  
  public boolean isBeforeFirst()
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.isBeforeFirst();
  }
  
  public boolean isClosed()
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.isClosed();
  }
  
  public boolean isFirst()
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.isFirst();
  }
  
  public boolean isLast()
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.isLast();
  }
  
  public boolean isNull(int paramInt)
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.isNull(paramInt);
  }
  
  public boolean move(int paramInt)
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.move(paramInt);
  }
  
  public boolean moveToFirst()
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.moveToFirst();
  }
  
  public boolean moveToLast()
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.moveToLast();
  }
  
  public boolean moveToNext()
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.moveToNext();
  }
  
  public boolean moveToPosition(int paramInt)
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.moveToPosition(paramInt);
  }
  
  public boolean moveToPrevious()
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.moveToPrevious();
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver)
  {
    this.jdField_a_of_type_AndroidDatabaseCursor.registerContentObserver(paramContentObserver);
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.jdField_a_of_type_AndroidDatabaseCursor.registerDataSetObserver(paramDataSetObserver);
  }
  
  @Deprecated
  public boolean requery()
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.requery();
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    return this.jdField_a_of_type_AndroidDatabaseCursor.respond(paramBundle);
  }
  
  public void setExtras(Bundle paramBundle) {}
  
  public void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri)
  {
    this.jdField_a_of_type_AndroidDatabaseCursor.setNotificationUri(paramContentResolver, paramUri);
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    this.jdField_a_of_type_AndroidDatabaseCursor.unregisterContentObserver(paramContentObserver);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.jdField_a_of_type_AndroidDatabaseCursor.unregisterDataSetObserver(paramDataSetObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukg
 * JD-Core Version:    0.7.0.1
 */