import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class aulc
  extends aukp
{
  public aulc(akfu paramakfu, String paramString)
  {
    super(paramakfu, paramString);
  }
  
  public static void a(List<String> paramList, String paramString, Cursor paramCursor, Class paramClass)
  {
    paramClass = aulp.a(paramClass);
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
        if (!localField.isAnnotationPresent(aulw.class)) {
          break label178;
        }
        i = 0;
        bool = true;
      }
      for (;;)
      {
        paramList.add(aulp.a(paramString, localField.getName(), (String)aulp.a.get(localField.getType()), bool, i));
        j += 1;
        break;
        i += 1;
        break label64;
        if (localField.isAnnotationPresent(aulv.class))
        {
          i = ((aulv)localField.getAnnotation(aulv.class)).a();
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
  
  protected ContentValues a(auko paramauko)
  {
    System.nanoTime();
    aula localaula = aulb.a().a(paramauko.getClass());
    if (localaula != null)
    {
      ContentValues localContentValues = new ContentValues(localaula.jdField_a_of_type_Int);
      localaula.a(paramauko, localContentValues);
      return localContentValues;
    }
    return super.a(paramauko);
  }
  
  public Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return super.a(paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public auko a(Class<? extends auko> paramClass, String paramString, Cursor paramCursor, aukz paramaukz)
  {
    aula localaula = aulb.a().a(paramClass);
    if (localaula != null) {
      if (paramCursor.isBeforeFirst()) {
        paramCursor.moveToFirst();
      }
    }
    try
    {
      if (paramCursor.getColumnIndex("_id") >= 0) {}
      auko localauko;
      for (l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));; l = -1L) {
        try
        {
          localauko = (auko)paramClass.newInstance();
          if (localauko == null) {
            break;
          }
          localauko._id = l;
          paramClass = localauko;
          if (!localauko.entityByCursor(paramCursor)) {
            paramClass = localaula.a(localauko, paramCursor, localaula.jdField_a_of_type_Boolean, paramaukz);
          }
          if ((l != -1L) && (paramString != null)) {}
          for (paramClass._status = 1001;; paramClass._status = 1002)
          {
            paramClass.postRead();
            return paramClass;
          }
          return super.a(paramClass, paramString, paramCursor, paramaukz);
        }
        catch (Exception paramClass)
        {
          if (QLog.isColorLevel()) {
            QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramClass));
          }
          return null;
        }
      }
      return localauko;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = -1L;
      }
    }
  }
  
  protected void a(auko paramauko, boolean paramBoolean)
  {
    super.a(paramauko, paramBoolean);
  }
  
  public boolean a(auko paramauko)
  {
    return super.a(paramauko);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aulc
 * JD-Core Version:    0.7.0.1
 */