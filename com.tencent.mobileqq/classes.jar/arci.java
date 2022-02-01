import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime.Status;

public class arci
{
  public azen a = new azen(new ArrayList(), new azbu(), new ArrayList(), "", new azbu());
  
  public static arci a(String paramString)
  {
    arci localarci = new arci();
    try
    {
      localarci.a = azem.a(paramString);
      QLog.d("OnlineAutoStatusConfProcessor", 1, "confBean = " + localarci.toString());
      return localarci;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("OnlineAutoStatusConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    }
    return localarci;
  }
  
  public azbu a(AppRuntime.Status paramStatus, long paramLong)
  {
    if (!azch.a(this.a.jdField_a_of_type_Azbu))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "getAutoStatusItem is smartItem inValid : onlineStatusIDValue=", Long.valueOf(paramLong) });
      }
      paramStatus = null;
    }
    azeo localazeo;
    do
    {
      return paramStatus;
      if ((this.a.jdField_b_of_type_Azbu.jdField_a_of_type_MqqAppAppRuntime$Status == paramStatus) && (paramLong == this.a.jdField_b_of_type_Azbu.jdField_a_of_type_Long))
      {
        if (azch.b(this.a.jdField_b_of_type_Azbu))
        {
          if (QLog.isColorLevel()) {
            QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "getAutoStatusItem smartStatusOnEarth Valid: onlineStatusIDValue=", Long.valueOf(paramLong) });
          }
          return this.a.jdField_b_of_type_Azbu;
        }
        return null;
      }
      Iterator localIterator = this.a.a(true).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localazeo = (azeo)localIterator.next();
      } while ((paramStatus != localazeo.jdField_a_of_type_MqqAppAppRuntime$Status) || (paramLong != localazeo.jdField_a_of_type_Long));
      if (QLog.isColorLevel()) {
        QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "getAutoStatusItem item is hide:", Boolean.valueOf(localazeo.b), " onlineStatusIDValue= ", Long.valueOf(paramLong) });
      }
      paramStatus = localazeo;
    } while (!localazeo.b);
    return this.a.jdField_b_of_type_Azbu;
    return null;
  }
  
  public azer a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.a.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      azer localazer = (azer)localIterator.next();
      if (paramString.equals(localazer.jdField_a_of_type_JavaLangString)) {
        return localazer;
      }
    }
    return null;
  }
  
  public boolean a()
  {
    boolean bool2 = this.a.a(true).isEmpty();
    boolean bool1;
    if ((this.a.jdField_a_of_type_Azbu != null) && (this.a.jdField_a_of_type_Azbu.jdField_a_of_type_Long == 0L))
    {
      bool1 = true;
      boolean bool3 = this.a.jdField_b_of_type_JavaUtilList.isEmpty();
      boolean bool4 = TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineAutoStatusBean", 2, new Object[] { "configExists: invoked. ", " weatherJumpEmpty: ", Boolean.valueOf(bool4), " weatherEmpty: ", Boolean.valueOf(bool3), " smartEntranceEmpty: ", Boolean.valueOf(bool1), " statusEmpty: ", Boolean.valueOf(bool2) });
      }
      if ((!bool2) || (!bool1) || (!bool3) || (!bool4)) {
        break label173;
      }
    }
    label173:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label178;
      }
      return true;
      bool1 = false;
      break;
    }
    label178:
    return false;
  }
  
  public azbu b(AppRuntime.Status paramStatus, long paramLong)
  {
    if (!azch.a(this.a.jdField_a_of_type_Azbu))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "getAutoStatusItemWithHide is smartItem inValid : onlineStatusIDValue=", Long.valueOf(paramLong) });
      }
      return null;
    }
    if ((this.a.jdField_b_of_type_Azbu.jdField_a_of_type_MqqAppAppRuntime$Status == paramStatus) && (paramLong == this.a.jdField_b_of_type_Azbu.jdField_a_of_type_Long))
    {
      if (azch.b(this.a.jdField_b_of_type_Azbu))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "getAutoStatusItemWithHide smartStatusOnEarth Valid: onlineStatusIDValue=", Long.valueOf(paramLong) });
        }
        return this.a.jdField_b_of_type_Azbu;
      }
      return null;
    }
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      azeo localazeo = (azeo)localIterator.next();
      if ((paramStatus == localazeo.jdField_a_of_type_MqqAppAppRuntime$Status) && (paramLong == localazeo.jdField_a_of_type_Long)) {
        return localazeo;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arci
 * JD-Core Version:    0.7.0.1
 */