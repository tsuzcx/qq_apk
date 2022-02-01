import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime.Status;

public class apzf
{
  public axyb a = new axyb(new ArrayList(), new axvj(), new ArrayList(), "", new axvj());
  
  public static apzf a(String paramString)
  {
    apzf localapzf = new apzf();
    try
    {
      localapzf.a = axya.a(paramString);
      QLog.d("OnlineAutoStatusConfProcessor", 1, "confBean = " + localapzf.toString());
      return localapzf;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("OnlineAutoStatusConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    }
    return localapzf;
  }
  
  public axvj a(AppRuntime.Status paramStatus, long paramLong)
  {
    if (!axvv.a(this.a.jdField_a_of_type_Axvj))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "getAutoStatusItem is smartItem inValid : onlineStatusIDValue=", Long.valueOf(paramLong) });
      }
      paramStatus = null;
    }
    axyc localaxyc;
    do
    {
      return paramStatus;
      if ((this.a.jdField_b_of_type_Axvj.jdField_a_of_type_MqqAppAppRuntime$Status == paramStatus) && (paramLong == this.a.jdField_b_of_type_Axvj.jdField_a_of_type_Long))
      {
        if (axvv.b(this.a.jdField_b_of_type_Axvj))
        {
          if (QLog.isColorLevel()) {
            QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "getAutoStatusItem smartStatusOnEarth Valid: onlineStatusIDValue=", Long.valueOf(paramLong) });
          }
          return this.a.jdField_b_of_type_Axvj;
        }
        return null;
      }
      Iterator localIterator = this.a.a(true).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localaxyc = (axyc)localIterator.next();
      } while ((paramStatus != localaxyc.jdField_a_of_type_MqqAppAppRuntime$Status) || (paramLong != localaxyc.jdField_a_of_type_Long));
      if (QLog.isColorLevel()) {
        QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "getAutoStatusItem item is hide:", Boolean.valueOf(localaxyc.jdField_a_of_type_Boolean), " onlineStatusIDValue= ", Long.valueOf(paramLong) });
      }
      paramStatus = localaxyc;
    } while (!localaxyc.jdField_a_of_type_Boolean);
    return this.a.jdField_b_of_type_Axvj;
    return null;
  }
  
  public axyf a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.a.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      axyf localaxyf = (axyf)localIterator.next();
      if (paramString.equals(localaxyf.jdField_a_of_type_JavaLangString)) {
        return localaxyf;
      }
    }
    return null;
  }
  
  public boolean a()
  {
    boolean bool2 = this.a.a(true).isEmpty();
    boolean bool1;
    if ((this.a.jdField_a_of_type_Axvj != null) && (this.a.jdField_a_of_type_Axvj.jdField_a_of_type_Long == 0L))
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
  
  public axvj b(AppRuntime.Status paramStatus, long paramLong)
  {
    if (!axvv.a(this.a.jdField_a_of_type_Axvj))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "getAutoStatusItemWithHide is smartItem inValid : onlineStatusIDValue=", Long.valueOf(paramLong) });
      }
      return null;
    }
    if ((this.a.jdField_b_of_type_Axvj.jdField_a_of_type_MqqAppAppRuntime$Status == paramStatus) && (paramLong == this.a.jdField_b_of_type_Axvj.jdField_a_of_type_Long))
    {
      if (axvv.b(this.a.jdField_b_of_type_Axvj))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "getAutoStatusItemWithHide smartStatusOnEarth Valid: onlineStatusIDValue=", Long.valueOf(paramLong) });
        }
        return this.a.jdField_b_of_type_Axvj;
      }
      return null;
    }
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      axyc localaxyc = (axyc)localIterator.next();
      if ((paramStatus == localaxyc.jdField_a_of_type_MqqAppAppRuntime$Status) && (paramLong == localaxyc.jdField_a_of_type_Long)) {
        return localaxyc;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apzf
 * JD-Core Version:    0.7.0.1
 */