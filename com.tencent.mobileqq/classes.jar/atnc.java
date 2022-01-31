import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class atnc
  extends atmp
{
  public atnc(ajrl paramajrl, String paramString)
  {
    super(paramajrl, paramString);
  }
  
  public static void a(List<String> paramList, String paramString, Cursor paramCursor, Class paramClass)
  {
    paramClass = atnp.a(paramClass);
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
        if (!localField.isAnnotationPresent(atnw.class)) {
          break label178;
        }
        i = 0;
        bool = true;
      }
      for (;;)
      {
        paramList.add(atnp.a(paramString, localField.getName(), (String)atnp.a.get(localField.getType()), bool, i));
        j += 1;
        break;
        i += 1;
        break label64;
        if (localField.isAnnotationPresent(atnv.class))
        {
          i = ((atnv)localField.getAnnotation(atnv.class)).a();
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
  
  protected ContentValues a(atmo paramatmo)
  {
    System.nanoTime();
    atna localatna = atnb.a().a(paramatmo.getClass());
    if (localatna != null)
    {
      ContentValues localContentValues = new ContentValues(localatna.jdField_a_of_type_Int);
      localatna.a(paramatmo, localContentValues);
      return localContentValues;
    }
    return super.a(paramatmo);
  }
  
  public Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return super.a(paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public atmo a(Class<? extends atmo> paramClass, String paramString, Cursor paramCursor, atmz paramatmz)
  {
    atna localatna = atnb.a().a(paramClass);
    if (localatna != null) {
      if (paramCursor.isBeforeFirst()) {
        paramCursor.moveToFirst();
      }
    }
    try
    {
      if (paramCursor.getColumnIndex("_id") >= 0) {}
      atmo localatmo;
      for (l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));; l = -1L) {
        try
        {
          localatmo = (atmo)paramClass.newInstance();
          if (localatmo == null) {
            break;
          }
          localatmo._id = l;
          paramClass = localatmo;
          if (!localatmo.entityByCursor(paramCursor)) {
            paramClass = localatna.a(localatmo, paramCursor, localatna.jdField_a_of_type_Boolean, paramatmz);
          }
          if ((l != -1L) && (paramString != null)) {}
          for (paramClass._status = 1001;; paramClass._status = 1002)
          {
            paramClass.postRead();
            return paramClass;
          }
          return super.a(paramClass, paramString, paramCursor, paramatmz);
        }
        catch (Exception paramClass)
        {
          if (QLog.isColorLevel()) {
            QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramClass));
          }
          return null;
        }
      }
      return localatmo;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = -1L;
      }
    }
  }
  
  protected void a(atmo paramatmo, boolean paramBoolean)
  {
    super.a(paramatmo, paramBoolean);
  }
  
  public boolean a(atmo paramatmo)
  {
    return super.a(paramatmo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atnc
 * JD-Core Version:    0.7.0.1
 */