import android.os.Handler;
import com.tencent.mobileqq.mediafocus.MediaFocusController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class atxn
  implements atxi
{
  private final atxo jdField_a_of_type_Atxo = new atxo(this);
  private MediaFocusController jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final HashMap<String, atxr> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final HashMap<String, Integer> b = new HashMap();
  
  public static final atxn a()
  {
    return atxq.a();
  }
  
  private atxr a(String paramString)
  {
    return (atxr)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  private String a(atxr paramatxr)
  {
    if (paramatxr == null) {
      return new String(toString());
    }
    return new String(toString() + paramatxr.toString());
  }
  
  private void a(atxr paramatxr)
  {
    String str;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController == null) {
        this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController = new MediaFocusController(this);
      }
      str = a(paramatxr);
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
    this.jdField_a_of_type_JavaUtilHashMap.put(str, paramatxr);
  }
  
  private boolean a(atxr paramatxr, boolean paramBoolean)
  {
    boolean bool = true;
    label130:
    label145:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        paramatxr = a(paramatxr);
        if (!paramBoolean)
        {
          this.b.remove(paramatxr);
          this.jdField_a_of_type_JavaUtilHashMap.remove(paramatxr);
          return true;
        }
        if (!this.b.containsKey(paramatxr)) {
          break label130;
        }
        int i = ((Integer)this.b.get(paramatxr)).intValue();
        if (i > 1)
        {
          this.b.put(paramatxr, Integer.valueOf(i - 1));
          paramBoolean = false;
          break label145;
          return paramBoolean;
        }
      }
      this.b.remove(paramatxr);
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramatxr);
      paramBoolean = true;
      break label145;
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramatxr);
      paramBoolean = bool;
    }
  }
  
  public int a(int paramInt, atxr paramatxr)
  {
    if ((paramInt < 1) || (paramInt > 3))
    {
      QLog.e("MediaFocusManager", 1, new Object[] { "requestMediaFocus denied, Invalid type:", Integer.valueOf(paramInt) });
      return 1;
    }
    if (QLog.isColorLevel()) {
      if (paramatxr != null) {
        break label97;
      }
    }
    label97:
    for (String str = "null";; str = paramatxr.toString())
    {
      QLog.d("MediaFocusManager", 2, new Object[] { "requestMediaFocus focusType:", Integer.valueOf(paramInt), " ,listener:", str });
      a(paramatxr);
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(paramInt, a(paramatxr));
    }
  }
  
  public int a(atxr paramatxr)
  {
    if (QLog.isColorLevel()) {
      if (paramatxr != null) {
        break label61;
      }
    }
    label61:
    for (String str = "null";; str = paramatxr.toString())
    {
      QLog.d("MediaFocusManager", 2, new Object[] { "abandonMediaFocus! listener:", str });
      if ((!a(paramatxr, true)) || (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController == null)) {
        break;
      }
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(a(paramatxr));
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
    paramString = this.jdField_a_of_type_Atxo.a().obtainMessage(paramInt, paramString);
    this.jdField_a_of_type_Atxo.a().sendMessage(paramString);
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController != null) {
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(paramString1, paramString2);
    }
    return false;
  }
  
  public int b(atxr paramatxr)
  {
    if (QLog.isColorLevel()) {
      if (paramatxr != null) {
        break label61;
      }
    }
    label61:
    for (String str = "null";; str = paramatxr.toString())
    {
      QLog.d("MediaFocusManager", 2, new Object[] { "abandonMediaFocusForce! listener:", str });
      if ((!a(paramatxr, false)) || (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController == null)) {
        break;
      }
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.a(a(paramatxr));
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atxn
 * JD-Core Version:    0.7.0.1
 */