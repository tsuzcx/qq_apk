import android.os.Handler;
import com.tencent.mobileqq.mediafocus.MediaFocusController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class asgn
  implements asgi
{
  private final asgo jdField_a_of_type_Asgo = new asgo(this);
  private MediaFocusController jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final HashMap<String, asgr> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final HashMap<String, Integer> b = new HashMap();
  
  public static final asgn a()
  {
    return asgq.a();
  }
  
  private asgr a(String paramString)
  {
    return (asgr)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  private String a(asgr paramasgr)
  {
    if (paramasgr == null) {
      return new String(toString());
    }
    return new String(toString() + paramasgr.toString());
  }
  
  private void a(asgr paramasgr)
  {
    String str;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController == null) {
        this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController = new MediaFocusController(this);
      }
      str = a(paramasgr);
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
    this.jdField_a_of_type_JavaUtilHashMap.put(str, paramasgr);
  }
  
  private boolean a(asgr paramasgr, boolean paramBoolean)
  {
    boolean bool = true;
    label130:
    label145:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        paramasgr = a(paramasgr);
        if (!paramBoolean)
        {
          this.b.remove(paramasgr);
          this.jdField_a_of_type_JavaUtilHashMap.remove(paramasgr);
          return true;
        }
        if (!this.b.containsKey(paramasgr)) {
          break label130;
        }
        int i = ((Integer)this.b.get(paramasgr)).intValue();
        if (i > 1)
        {
          this.b.put(paramasgr, Integer.valueOf(i - 1));
          paramBoolean = false;
          break label145;
          return paramBoolean;
        }
      }
      this.b.remove(paramasgr);
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramasgr);
      paramBoolean = true;
      break label145;
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramasgr);
      paramBoolean = bool;
    }
  }
  
  public int a(int paramInt, asgr paramasgr)
  {
    if ((paramInt < 1) || (paramInt > 3))
    {
      QLog.e("MediaFocusManager", 1, new Object[] { "requestMediaFocus denied, Invalid type:", Integer.valueOf(paramInt) });
      return 1;
    }
    if (QLog.isColorLevel()) {
      if (paramasgr != null) {
        break label97;
      }
    }
    label97:
    for (String str = "null";; str = paramasgr.toString())
    {
      QLog.d("MediaFocusManager", 2, new Object[] { "requestMediaFocus focusType:", Integer.valueOf(paramInt), " ,listener:", str });
      a(paramasgr);
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(paramInt, a(paramasgr));
    }
  }
  
  public int a(asgr paramasgr)
  {
    if (QLog.isColorLevel()) {
      if (paramasgr != null) {
        break label61;
      }
    }
    label61:
    for (String str = "null";; str = paramasgr.toString())
    {
      QLog.d("MediaFocusManager", 2, new Object[] { "abandonMediaFocus! listener:", str });
      if ((!a(paramasgr, true)) || (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController == null)) {
        break;
      }
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(a(paramasgr));
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
    paramString = this.jdField_a_of_type_Asgo.a().obtainMessage(paramInt, paramString);
    this.jdField_a_of_type_Asgo.a().sendMessage(paramString);
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController != null) {
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(paramString1, paramString2);
    }
    return false;
  }
  
  public int b(asgr paramasgr)
  {
    if (QLog.isColorLevel()) {
      if (paramasgr != null) {
        break label61;
      }
    }
    label61:
    for (String str = "null";; str = paramasgr.toString())
    {
      QLog.d("MediaFocusManager", 2, new Object[] { "abandonMediaFocusForce! listener:", str });
      if ((!a(paramasgr, false)) || (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController == null)) {
        break;
      }
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(a(paramasgr));
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asgn
 * JD-Core Version:    0.7.0.1
 */