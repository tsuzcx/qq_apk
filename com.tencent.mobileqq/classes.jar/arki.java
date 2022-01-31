import android.os.Handler;
import com.tencent.mobileqq.mediafocus.MediaFocusController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class arki
  implements arkd
{
  private final arkj jdField_a_of_type_Arkj = new arkj(this);
  private MediaFocusController jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final HashMap<String, arkm> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final HashMap<String, Integer> b = new HashMap();
  
  public static final arki a()
  {
    return arkl.a();
  }
  
  private arkm a(String paramString)
  {
    return (arkm)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  private String a(arkm paramarkm)
  {
    if (paramarkm == null) {
      return new String(toString());
    }
    return new String(toString() + paramarkm.toString());
  }
  
  private void a(arkm paramarkm)
  {
    String str;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController == null) {
        this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController = new MediaFocusController(this);
      }
      str = a(paramarkm);
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
    this.jdField_a_of_type_JavaUtilHashMap.put(str, paramarkm);
  }
  
  private boolean a(arkm paramarkm, boolean paramBoolean)
  {
    boolean bool = true;
    label130:
    label145:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        paramarkm = a(paramarkm);
        if (!paramBoolean)
        {
          this.b.remove(paramarkm);
          this.jdField_a_of_type_JavaUtilHashMap.remove(paramarkm);
          return true;
        }
        if (!this.b.containsKey(paramarkm)) {
          break label130;
        }
        int i = ((Integer)this.b.get(paramarkm)).intValue();
        if (i > 1)
        {
          this.b.put(paramarkm, Integer.valueOf(i - 1));
          paramBoolean = false;
          break label145;
          return paramBoolean;
        }
      }
      this.b.remove(paramarkm);
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramarkm);
      paramBoolean = true;
      break label145;
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramarkm);
      paramBoolean = bool;
    }
  }
  
  public int a(int paramInt, arkm paramarkm)
  {
    if ((paramInt < 1) || (paramInt > 3))
    {
      QLog.e("MediaFocusManager", 1, new Object[] { "requestMediaFocus denied, Invalid type:", Integer.valueOf(paramInt) });
      return 1;
    }
    if (QLog.isColorLevel()) {
      if (paramarkm != null) {
        break label97;
      }
    }
    label97:
    for (String str = "null";; str = paramarkm.toString())
    {
      QLog.d("MediaFocusManager", 2, new Object[] { "requestMediaFocus focusType:", Integer.valueOf(paramInt), " ,listener:", str });
      a(paramarkm);
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(paramInt, a(paramarkm));
    }
  }
  
  public int a(arkm paramarkm)
  {
    if (QLog.isColorLevel()) {
      if (paramarkm != null) {
        break label61;
      }
    }
    label61:
    for (String str = "null";; str = paramarkm.toString())
    {
      QLog.d("MediaFocusManager", 2, new Object[] { "abandonMediaFocus! listener:", str });
      if ((!a(paramarkm, true)) || (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController == null)) {
        break;
      }
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(a(paramarkm));
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
    paramString = this.jdField_a_of_type_Arkj.a().obtainMessage(paramInt, paramString);
    this.jdField_a_of_type_Arkj.a().sendMessage(paramString);
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController != null) {
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(paramString1, paramString2);
    }
    return false;
  }
  
  public int b(arkm paramarkm)
  {
    if (QLog.isColorLevel()) {
      if (paramarkm != null) {
        break label61;
      }
    }
    label61:
    for (String str = "null";; str = paramarkm.toString())
    {
      QLog.d("MediaFocusManager", 2, new Object[] { "abandonMediaFocusForce! listener:", str });
      if ((!a(paramarkm, false)) || (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController == null)) {
        break;
      }
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(a(paramarkm));
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arki
 * JD-Core Version:    0.7.0.1
 */