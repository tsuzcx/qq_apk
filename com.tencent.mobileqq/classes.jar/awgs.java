import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class awgs
  extends awgf
{
  public awgs(ambz paramambz, String paramString)
  {
    super(paramambz, paramString);
  }
  
  public static void a(List<String> paramList, String paramString, Cursor paramCursor, Class paramClass)
  {
    paramClass = awhf.a(paramClass);
    int j;
    Field localField;
    if (paramCursor.moveToFirst())
    {
      paramCursor = SecurityUtile.b(paramCursor.getString(0)).split(",");
      int k = paramClass.size();
      j = 0;
      if (j < k)
      {
        localField = (Field)paramClass.get(j);
        i = 1;
        label64:
        if (i >= paramCursor.length) {
          break label221;
        }
        String str = paramCursor[i].trim().split(" ")[0];
        if (!localField.getName().equals(str)) {}
      }
    }
    label178:
    label221:
    for (int i = 1;; i = 0)
    {
      boolean bool;
      if (i == 0)
      {
        if (!localField.isAnnotationPresent(awhm.class)) {
          break label178;
        }
        i = 0;
        bool = true;
      }
      for (;;)
      {
        paramList.add(awhf.a(paramString, localField.getName(), (String)awhf.a.get(localField.getType()), bool, i));
        j += 1;
        break;
        i += 1;
        break label64;
        if (localField.isAnnotationPresent(awhl.class))
        {
          i = ((awhl)localField.getAnnotation(awhl.class)).a();
          bool = true;
        }
        else
        {
          i = 0;
          bool = false;
        }
      }
    }
  }
  
  protected ContentValues a(awge paramawge)
  {
    System.nanoTime();
    awgq localawgq = awgr.a().a(paramawge.getClass());
    if (localawgq != null)
    {
      ContentValues localContentValues = new ContentValues(localawgq.jdField_a_of_type_Int);
      localawgq.a(paramawge, localContentValues);
      return localContentValues;
    }
    return super.a(paramawge);
  }
  
  public Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return super.a(paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public awge a(Class<? extends awge> paramClass, String paramString, Cursor paramCursor, awgp paramawgp)
  {
    awgq localawgq = awgr.a().a(paramClass);
    if (localawgq != null) {
      if (paramCursor.isBeforeFirst()) {
        paramCursor.moveToFirst();
      }
    }
    try
    {
      if (paramCursor.getColumnIndex("_id") >= 0) {}
      awge localawge;
      for (l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));; l = -1L) {
        try
        {
          localawge = (awge)paramClass.newInstance();
          if (localawge == null) {
            break;
          }
          localawge._id = l;
          paramClass = localawge;
          if (!localawge.entityByCursor(paramCursor)) {
            paramClass = localawgq.a(localawge, paramCursor, localawgq.jdField_a_of_type_Boolean, paramawgp);
          }
          if ((l != -1L) && (paramString != null)) {}
          for (paramClass._status = 1001;; paramClass._status = 1002)
          {
            paramClass.postRead();
            return paramClass;
          }
          return super.a(paramClass, paramString, paramCursor, paramawgp);
        }
        catch (Exception paramClass)
        {
          if (QLog.isColorLevel()) {
            QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramClass));
          }
          return null;
        }
      }
      return localawge;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = -1L;
      }
    }
  }
  
  protected void a(awge paramawge, boolean paramBoolean)
  {
    super.a(paramawge, paramBoolean);
  }
  
  public boolean a(awge paramawge)
  {
    return super.a(paramawge);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awgs
 * JD-Core Version:    0.7.0.1
 */