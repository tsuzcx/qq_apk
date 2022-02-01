import android.os.Handler;
import com.tencent.mobileqq.mediafocus.MediaFocusController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class awvk
  implements awvf
{
  private final awvl jdField_a_of_type_Awvl = new awvl(this);
  private MediaFocusController jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final HashMap<String, awvo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final HashMap<String, Integer> b = new HashMap();
  
  public static final awvk a()
  {
    return awvn.a();
  }
  
  private awvo a(String paramString)
  {
    return (awvo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  private String a(awvo paramawvo)
  {
    if (paramawvo == null) {
      return new String(toString());
    }
    return new String(toString() + paramawvo.toString());
  }
  
  private void a(awvo paramawvo)
  {
    String str;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController == null) {
        this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController = new MediaFocusController(this);
      }
      str = a(paramawvo);
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
    this.jdField_a_of_type_JavaUtilHashMap.put(str, paramawvo);
  }
  
  private boolean a(awvo paramawvo, boolean paramBoolean)
  {
    boolean bool = true;
    label130:
    label145:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        paramawvo = a(paramawvo);
        if (!paramBoolean)
        {
          this.b.remove(paramawvo);
          this.jdField_a_of_type_JavaUtilHashMap.remove(paramawvo);
          return true;
        }
        if (!this.b.containsKey(paramawvo)) {
          break label130;
        }
        int i = ((Integer)this.b.get(paramawvo)).intValue();
        if (i > 1)
        {
          this.b.put(paramawvo, Integer.valueOf(i - 1));
          paramBoolean = false;
          break label145;
          return paramBoolean;
        }
      }
      this.b.remove(paramawvo);
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramawvo);
      paramBoolean = true;
      break label145;
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramawvo);
      paramBoolean = bool;
    }
  }
  
  public int a(int paramInt, awvo paramawvo)
  {
    if ((paramInt < 1) || (paramInt > 3))
    {
      QLog.e("MediaFocusManager", 1, new Object[] { "requestMediaFocus denied, Invalid type:", Integer.valueOf(paramInt) });
      return 1;
    }
    if (QLog.isColorLevel()) {
      if (paramawvo != null) {
        break label97;
      }
    }
    label97:
    for (String str = "null";; str = paramawvo.toString())
    {
      QLog.d("MediaFocusManager", 2, new Object[] { "requestMediaFocus focusType:", Integer.valueOf(paramInt), " ,listener:", str });
      a(paramawvo);
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(paramInt, a(paramawvo));
    }
  }
  
  public int a(awvo paramawvo)
  {
    if (QLog.isColorLevel()) {
      if (paramawvo != null) {
        break label61;
      }
    }
    label61:
    for (String str = "null";; str = paramawvo.toString())
    {
      QLog.d("MediaFocusManager", 2, new Object[] { "abandonMediaFocus! listener:", str });
      if ((!a(paramawvo, true)) || (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController == null)) {
        break;
      }
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(a(paramawvo));
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
    paramString = this.jdField_a_of_type_Awvl.a().obtainMessage(paramInt, paramString);
    this.jdField_a_of_type_Awvl.a().sendMessage(paramString);
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController != null) {
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(paramString1, paramString2);
    }
    return false;
  }
  
  public int b(awvo paramawvo)
  {
    if (QLog.isColorLevel()) {
      if (paramawvo != null) {
        break label61;
      }
    }
    label61:
    for (String str = "null";; str = paramawvo.toString())
    {
      QLog.d("MediaFocusManager", 2, new Object[] { "abandonMediaFocusForce! listener:", str });
      if ((!a(paramawvo, false)) || (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController == null)) {
        break;
      }
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(a(paramawvo));
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvk
 * JD-Core Version:    0.7.0.1
 */