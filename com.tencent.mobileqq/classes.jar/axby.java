import android.os.Handler;
import com.tencent.mobileqq.mediafocus.MediaFocusController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class axby
  implements axbt
{
  private final axbz jdField_a_of_type_Axbz = new axbz(this);
  private MediaFocusController jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final HashMap<String, axcc> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final HashMap<String, Integer> b = new HashMap();
  
  public static final axby a()
  {
    return axcb.a();
  }
  
  private axcc a(String paramString)
  {
    return (axcc)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  private String a(axcc paramaxcc)
  {
    if (paramaxcc == null) {
      return new String(toString());
    }
    return new String(toString() + paramaxcc.toString());
  }
  
  private void a(axcc paramaxcc)
  {
    String str;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController == null) {
        this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController = new MediaFocusController(this);
      }
      str = a(paramaxcc);
      if (this.b.containsKey(str))
      {
        int i = ((Integer)this.b.get(str)).intValue();
        this.b.put(str, Integer.valueOf(i + 1));
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {}
      }
      else
      {
        this.b.put(str, Integer.valueOf(1));
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(str, paramaxcc);
  }
  
  private boolean a(axcc paramaxcc, boolean paramBoolean)
  {
    boolean bool = true;
    label130:
    label145:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        paramaxcc = a(paramaxcc);
        if (!paramBoolean)
        {
          this.b.remove(paramaxcc);
          this.jdField_a_of_type_JavaUtilHashMap.remove(paramaxcc);
          return true;
        }
        if (!this.b.containsKey(paramaxcc)) {
          break label130;
        }
        int i = ((Integer)this.b.get(paramaxcc)).intValue();
        if (i > 1)
        {
          this.b.put(paramaxcc, Integer.valueOf(i - 1));
          paramBoolean = false;
          break label145;
          return paramBoolean;
        }
      }
      this.b.remove(paramaxcc);
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramaxcc);
      paramBoolean = true;
      break label145;
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramaxcc);
      paramBoolean = bool;
    }
  }
  
  public int a(int paramInt, axcc paramaxcc)
  {
    if ((paramInt < 1) || (paramInt > 3))
    {
      QLog.e("MediaFocusManager", 1, new Object[] { "requestMediaFocus denied, Invalid type:", Integer.valueOf(paramInt) });
      return 1;
    }
    if (QLog.isColorLevel()) {
      if (paramaxcc != null) {
        break label97;
      }
    }
    label97:
    for (String str = "null";; str = paramaxcc.toString())
    {
      QLog.d("MediaFocusManager", 2, new Object[] { "requestMediaFocus focusType:", Integer.valueOf(paramInt), " ,listener:", str });
      a(paramaxcc);
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(paramInt, a(paramaxcc));
    }
  }
  
  public int a(axcc paramaxcc)
  {
    if (QLog.isColorLevel()) {
      if (paramaxcc != null) {
        break label61;
      }
    }
    label61:
    for (String str = "null";; str = paramaxcc.toString())
    {
      QLog.d("MediaFocusManager", 2, new Object[] { "abandonMediaFocus! listener:", str });
      if ((!a(paramaxcc, true)) || (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController == null)) {
        break;
      }
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(a(paramaxcc));
    }
    return 1;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusManager", 2, new Object[] { "onClear map:", Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()) });
    }
    if ((this.jdField_a_of_type_JavaUtilHashMap.isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a();
      this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController = null;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusManager", 2, new Object[] { "onDispatch focus:", Integer.valueOf(paramInt), " ,id:", paramString });
    }
    paramString = this.jdField_a_of_type_Axbz.a().obtainMessage(paramInt, paramString);
    this.jdField_a_of_type_Axbz.a().sendMessage(paramString);
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController != null) {
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(paramString1, paramString2);
    }
    return false;
  }
  
  public int b(axcc paramaxcc)
  {
    if (QLog.isColorLevel()) {
      if (paramaxcc != null) {
        break label61;
      }
    }
    label61:
    for (String str = "null";; str = paramaxcc.toString())
    {
      QLog.d("MediaFocusManager", 2, new Object[] { "abandonMediaFocusForce! listener:", str });
      if ((!a(paramaxcc, false)) || (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController == null)) {
        break;
      }
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(a(paramaxcc));
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axby
 * JD-Core Version:    0.7.0.1
 */