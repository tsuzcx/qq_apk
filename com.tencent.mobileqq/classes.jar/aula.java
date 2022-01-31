import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class aula
  extends aukn
{
  public aula(akfv paramakfv, String paramString)
  {
    super(paramakfv, paramString);
  }
  
  public static void a(List<String> paramList, String paramString, Cursor paramCursor, Class paramClass)
  {
    paramClass = auln.a(paramClass);
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
        if (!localField.isAnnotationPresent(aulu.class)) {
          break label178;
        }
        i = 0;
        bool = true;
      }
      for (;;)
      {
        paramList.add(auln.a(paramString, localField.getName(), (String)auln.a.get(localField.getType()), bool, i));
        j += 1;
        break;
        i += 1;
        break label64;
        if (localField.isAnnotationPresent(ault.class))
        {
          i = ((ault)localField.getAnnotation(ault.class)).a();
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
  
  protected ContentValues a(aukm paramaukm)
  {
    System.nanoTime();
    auky localauky = aukz.a().a(paramaukm.getClass());
    if (localauky != null)
    {
      ContentValues localContentValues = new ContentValues(localauky.jdField_a_of_type_Int);
      localauky.a(paramaukm, localContentValues);
      return localContentValues;
    }
    return super.a(paramaukm);
  }
  
  public Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return super.a(paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public aukm a(Class<? extends aukm> paramClass, String paramString, Cursor paramCursor, aukx paramaukx)
  {
    auky localauky = aukz.a().a(paramClass);
    if (localauky != null) {
      if (paramCursor.isBeforeFirst()) {
        paramCursor.moveToFirst();
      }
    }
    try
    {
      if (paramCursor.getColumnIndex("_id") >= 0) {}
      aukm localaukm;
      for (l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));; l = -1L) {
        try
        {
          localaukm = (aukm)paramClass.newInstance();
          if (localaukm == null) {
            break;
          }
          localaukm._id = l;
          paramClass = localaukm;
          if (!localaukm.entityByCursor(paramCursor)) {
            paramClass = localauky.a(localaukm, paramCursor, localauky.jdField_a_of_type_Boolean, paramaukx);
          }
          if ((l != -1L) && (paramString != null)) {}
          for (paramClass._status = 1001;; paramClass._status = 1002)
          {
            paramClass.postRead();
            return paramClass;
          }
          return super.a(paramClass, paramString, paramCursor, paramaukx);
        }
        catch (Exception paramClass)
        {
          if (QLog.isColorLevel()) {
            QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramClass));
          }
          return null;
        }
      }
      return localaukm;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = -1L;
      }
    }
  }
  
  protected void a(aukm paramaukm, boolean paramBoolean)
  {
    super.a(paramaukm, paramBoolean);
  }
  
  public boolean a(aukm paramaukm)
  {
    return super.a(paramaukm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aula
 * JD-Core Version:    0.7.0.1
 */