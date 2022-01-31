import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class awcj
  extends awbw
{
  public awcj(alxk paramalxk, String paramString)
  {
    super(paramalxk, paramString);
  }
  
  public static void a(List<String> paramList, String paramString, Cursor paramCursor, Class paramClass)
  {
    paramClass = awcw.a(paramClass);
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
        if (!localField.isAnnotationPresent(awdd.class)) {
          break label178;
        }
        i = 0;
        bool = true;
      }
      for (;;)
      {
        paramList.add(awcw.a(paramString, localField.getName(), (String)awcw.a.get(localField.getType()), bool, i));
        j += 1;
        break;
        i += 1;
        break label64;
        if (localField.isAnnotationPresent(awdc.class))
        {
          i = ((awdc)localField.getAnnotation(awdc.class)).a();
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
  
  protected ContentValues a(awbv paramawbv)
  {
    System.nanoTime();
    awch localawch = awci.a().a(paramawbv.getClass());
    if (localawch != null)
    {
      ContentValues localContentValues = new ContentValues(localawch.jdField_a_of_type_Int);
      localawch.a(paramawbv, localContentValues);
      return localContentValues;
    }
    return super.a(paramawbv);
  }
  
  public Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return super.a(paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public awbv a(Class<? extends awbv> paramClass, String paramString, Cursor paramCursor, awcg paramawcg)
  {
    awch localawch = awci.a().a(paramClass);
    if (localawch != null) {
      if (paramCursor.isBeforeFirst()) {
        paramCursor.moveToFirst();
      }
    }
    try
    {
      if (paramCursor.getColumnIndex("_id") >= 0) {}
      awbv localawbv;
      for (l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));; l = -1L) {
        try
        {
          localawbv = (awbv)paramClass.newInstance();
          if (localawbv == null) {
            break;
          }
          localawbv._id = l;
          paramClass = localawbv;
          if (!localawbv.entityByCursor(paramCursor)) {
            paramClass = localawch.a(localawbv, paramCursor, localawch.jdField_a_of_type_Boolean, paramawcg);
          }
          if ((l != -1L) && (paramString != null)) {}
          for (paramClass._status = 1001;; paramClass._status = 1002)
          {
            paramClass.postRead();
            return paramClass;
          }
          return super.a(paramClass, paramString, paramCursor, paramawcg);
        }
        catch (Exception paramClass)
        {
          if (QLog.isColorLevel()) {
            QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramClass));
          }
          return null;
        }
      }
      return localawbv;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = -1L;
      }
    }
  }
  
  protected void a(awbv paramawbv, boolean paramBoolean)
  {
    super.a(paramawbv, paramBoolean);
  }
  
  public boolean a(awbv paramawbv)
  {
    return super.a(paramawbv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awcj
 * JD-Core Version:    0.7.0.1
 */