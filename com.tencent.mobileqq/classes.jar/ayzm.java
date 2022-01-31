import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ayzm
  implements SharedPreferences.Editor
{
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private boolean jdField_a_of_type_Boolean;
  
  public ayzm(ayzl paramayzl) {}
  
  private void a()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = ayzl.a(this.jdField_a_of_type_Ayzl).edit();
    if ((ayzl.a(this.jdField_a_of_type_Ayzl) != null) && (ayzl.a(this.jdField_a_of_type_Ayzl).size() > 0))
    {
      Iterator localIterator = ayzl.a(this.jdField_a_of_type_Ayzl).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = ayzl.a(this.jdField_a_of_type_Ayzl).get(str);
        if ((localObject instanceof Long)) {
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, ((Long)localObject).longValue());
        } else if ((localObject instanceof String)) {
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString(str, (String)localObject);
        } else if ((localObject instanceof Boolean)) {
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean(str, ((Boolean)localObject).booleanValue());
        } else if ((localObject instanceof Integer)) {
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt(str, ((Integer)localObject).intValue());
        } else if ((localObject instanceof Float)) {
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putFloat(str, ((Float)localObject).floatValue());
        }
      }
    }
  }
  
  @TargetApi(9)
  public void apply()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (Build.VERSION.SDK_INT < 9) {
        try
        {
          a();
          if (this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit())
          {
            ayzl.a(this.jdField_a_of_type_Ayzl).clear();
            return;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(ayzl.a(), 2, "AsyncEditor commit fail!");
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (QLog.isColorLevel()) {
            QLog.w(ayzl.a(), 2, "commit OutOfMemoryError ! ", localOutOfMemoryError);
          }
          this.jdField_a_of_type_Boolean = true;
          return;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.w(ayzl.a(), 2, "commit Exception ! ", localException);
          }
          this.jdField_a_of_type_Boolean = true;
          return;
        }
      } else {
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
      }
    }
  }
  
  public SharedPreferences.Editor clear()
  {
    this.jdField_a_of_type_Boolean = true;
    ayzl.a(this.jdField_a_of_type_Ayzl).clear();
    return this;
  }
  
  public boolean commit()
  {
    boolean bool1;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      try
      {
        a();
        boolean bool2 = this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
        if (bool2)
        {
          ayzl.a(this.jdField_a_of_type_Ayzl).clear();
          return bool2;
        }
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          return bool1;
        }
        QLog.d(ayzl.a(), 2, "AsyncEditor commit fail!");
        return bool2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.w(ayzl.a(), 2, "commit OutOfMemoryError ! ", localOutOfMemoryError);
        }
        this.jdField_a_of_type_Boolean = true;
        return false;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.w(ayzl.a(), 2, "commit Exception ! ", localException);
        }
        this.jdField_a_of_type_Boolean = true;
        return false;
      }
    }
    else
    {
      bool1 = false;
    }
    return bool1;
  }
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    ayzl.a(this.jdField_a_of_type_Ayzl).put(paramString, Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    this.jdField_a_of_type_Boolean = true;
    ayzl.a(this.jdField_a_of_type_Ayzl).put(paramString, Float.valueOf(paramFloat));
    return this;
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    ayzl.a(this.jdField_a_of_type_Ayzl).put(paramString, Integer.valueOf(paramInt));
    return this;
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    ayzl.a(this.jdField_a_of_type_Ayzl).put(paramString, Long.valueOf(paramLong));
    return this;
  }
  
  public SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Boolean = true;
    ayzl.a(this.jdField_a_of_type_Ayzl).put(paramString1, paramString2);
    return this;
  }
  
  @Deprecated
  public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
  {
    return this;
  }
  
  public SharedPreferences.Editor remove(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    ayzl.a(this.jdField_a_of_type_Ayzl).remove(paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayzm
 * JD-Core Version:    0.7.0.1
 */