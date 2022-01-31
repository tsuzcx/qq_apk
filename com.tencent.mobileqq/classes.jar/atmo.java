import android.database.Cursor;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public abstract class atmo
{
  public static final int DETACHED = 1002;
  public static final int MANAGED = 1001;
  public static final int NEW = 1000;
  public static final int REMOVED = 1003;
  long _id = -1L;
  int _status = 1000;
  
  public atmo deepCopyByReflect()
  {
    try
    {
      atmo localatmo = (atmo)getClass().newInstance();
      if (localatmo != null)
      {
        Field[] arrayOfField = getClass().getFields();
        int j = arrayOfField.length;
        int i = 0;
        while (i < j)
        {
          Field localField = arrayOfField[i];
          if (!localField.isAccessible()) {
            localField.setAccessible(true);
          }
          localField.set(localatmo, localField.get(this));
          i += 1;
        }
        localatmo._status = 1000;
        localatmo.postRead();
      }
      return localatmo;
    }
    catch (Exception localException)
    {
      QLog.d("Entity", 1, " deepCopyByReflect:failed" + getClass().getName() + " exception e: = " + localException.getMessage());
      localException.printStackTrace();
    }
    return null;
  }
  
  protected boolean entityByCursor(Cursor paramCursor)
  {
    return false;
  }
  
  protected Class<? extends atmo> getClassForTable()
  {
    return getClass();
  }
  
  public long getId()
  {
    return this._id;
  }
  
  public int getStatus()
  {
    return this._status;
  }
  
  public String getTableName()
  {
    return getClass().getSimpleName();
  }
  
  protected void postRead() {}
  
  protected void postwrite() {}
  
  protected void prewrite() {}
  
  public void setId(long paramLong)
  {
    this._id = paramLong;
  }
  
  public void setStatus(int paramInt)
  {
    this._status = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atmo
 * JD-Core Version:    0.7.0.1
 */