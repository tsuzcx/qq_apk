import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime.Status;

public class arfp
{
  public azkt a = new azkt(new ArrayList(), new azib(), new ArrayList(), "", new azib());
  
  public static arfp a(String paramString)
  {
    arfp localarfp = new arfp();
    try
    {
      localarfp.a = azks.a(paramString);
      QLog.d("OnlineAutoStatusConfProcessor", 1, "confBean = " + localarfp.toString());
      return localarfp;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("OnlineAutoStatusConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    }
    return localarfp;
  }
  
  public azib a(AppRuntime.Status paramStatus, long paramLong)
  {
    if (!azin.a(this.a.jdField_a_of_type_Azib))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "getAutoStatusItem is smartItem inValid : onlineStatusIDValue=", Long.valueOf(paramLong) });
      }
      paramStatus = null;
    }
    azku localazku;
    do
    {
      return paramStatus;
      if ((this.a.jdField_b_of_type_Azib.jdField_a_of_type_MqqAppAppRuntime$Status == paramStatus) && (paramLong == this.a.jdField_b_of_type_Azib.jdField_a_of_type_Long))
      {
        if (azin.b(this.a.jdField_b_of_type_Azib))
        {
          if (QLog.isColorLevel()) {
            QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "getAutoStatusItem smartStatusOnEarth Valid: onlineStatusIDValue=", Long.valueOf(paramLong) });
          }
          return this.a.jdField_b_of_type_Azib;
        }
        return null;
      }
      Iterator localIterator = this.a.a(true).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localazku = (azku)localIterator.next();
      } while ((paramStatus != localazku.jdField_a_of_type_MqqAppAppRuntime$Status) || (paramLong != localazku.jdField_a_of_type_Long));
      if (QLog.isColorLevel()) {
        QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "getAutoStatusItem item is hide:", Boolean.valueOf(localazku.jdField_a_of_type_Boolean), " onlineStatusIDValue= ", Long.valueOf(paramLong) });
      }
      paramStatus = localazku;
    } while (!localazku.jdField_a_of_type_Boolean);
    return this.a.jdField_b_of_type_Azib;
    return null;
  }
  
  public azkx a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.a.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      azkx localazkx = (azkx)localIterator.next();
      if (paramString.equals(localazkx.jdField_a_of_type_JavaLangString)) {
        return localazkx;
      }
    }
    return null;
  }
  
  public boolean a()
  {
    boolean bool2 = this.a.a(true).isEmpty();
    boolean bool1;
    if ((this.a.jdField_a_of_type_Azib != null) && (this.a.jdField_a_of_type_Azib.jdField_a_of_type_Long == 0L))
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
  
  public azib b(AppRuntime.Status paramStatus, long paramLong)
  {
    if (!azin.a(this.a.jdField_a_of_type_Azib))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "getAutoStatusItemWithHide is smartItem inValid : onlineStatusIDValue=", Long.valueOf(paramLong) });
      }
      return null;
    }
    if ((this.a.jdField_b_of_type_Azib.jdField_a_of_type_MqqAppAppRuntime$Status == paramStatus) && (paramLong == this.a.jdField_b_of_type_Azib.jdField_a_of_type_Long))
    {
      if (azin.b(this.a.jdField_b_of_type_Azib))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "getAutoStatusItemWithHide smartStatusOnEarth Valid: onlineStatusIDValue=", Long.valueOf(paramLong) });
        }
        return this.a.jdField_b_of_type_Azib;
      }
      return null;
    }
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      azku localazku = (azku)localIterator.next();
      if ((paramStatus == localazku.jdField_a_of_type_MqqAppAppRuntime$Status) && (paramLong == localazku.jdField_a_of_type_Long)) {
        return localazku;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arfp
 * JD-Core Version:    0.7.0.1
 */