import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class arpw
{
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString = "https://eim.connect.qq.com/guide/install.html?install=1";
  private Map<String, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString = "";
  private boolean jdField_e_of_type_Boolean;
  private String jdField_f_of_type_JavaLangString = "";
  private boolean jdField_f_of_type_Boolean;
  private String jdField_g_of_type_JavaLangString = "";
  private boolean jdField_g_of_type_Boolean;
  private String jdField_h_of_type_JavaLangString = "";
  private boolean jdField_h_of_type_Boolean;
  
  public static arpw a(araj[] paramArrayOfaraj)
  {
    boolean bool2 = false;
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
      return null;
    }
    arpw localarpw = new arpw();
    for (;;)
    {
      try
      {
        paramArrayOfaraj = new JSONObject(paramArrayOfaraj[0].jdField_a_of_type_JavaLangString);
        if (paramArrayOfaraj.has("TIMDocs"))
        {
          paramArrayOfaraj = paramArrayOfaraj.getJSONObject("TIMDocs");
          if (paramArrayOfaraj.has("autoImportToSharedDocSwitch"))
          {
            if (paramArrayOfaraj.getInt("autoImportToSharedDocSwitch") != 1) {
              break label571;
            }
            bool1 = true;
            localarpw.jdField_a_of_type_Boolean = bool1;
          }
          if (paramArrayOfaraj.has("openWithSharedDocInTimSwitch"))
          {
            if (paramArrayOfaraj.getInt("openWithSharedDocInTimSwitch") != 1) {
              break label576;
            }
            bool1 = true;
            localarpw.jdField_b_of_type_Boolean = bool1;
          }
          if (paramArrayOfaraj.has("openFileInTimSwitch"))
          {
            if (paramArrayOfaraj.getInt("openFileInTimSwitch") != 1) {
              break label581;
            }
            bool1 = true;
            localarpw.jdField_c_of_type_Boolean = bool1;
          }
          if (paramArrayOfaraj.has("aioSwitch"))
          {
            if (paramArrayOfaraj.getInt("aioSwitch") != 1) {
              break label586;
            }
            bool1 = true;
            localarpw.jdField_d_of_type_Boolean = bool1;
          }
          if (paramArrayOfaraj.has("fileViewerMenuSwitch"))
          {
            if (paramArrayOfaraj.getInt("fileViewerMenuSwitch") != 1) {
              break label591;
            }
            bool1 = true;
            localarpw.jdField_e_of_type_Boolean = bool1;
          }
          if (paramArrayOfaraj.has("openFileInTimEntry")) {
            localarpw.jdField_a_of_type_Int = paramArrayOfaraj.getInt("openFileInTimEntry");
          }
          if (paramArrayOfaraj.has("androidURL")) {
            localarpw.jdField_a_of_type_JavaLangString = paramArrayOfaraj.getString("androidURL");
          }
          if (paramArrayOfaraj.has("insertGrayTipAfterOpenWithSharedDocInTim"))
          {
            if (paramArrayOfaraj.getInt("insertGrayTipAfterOpenWithSharedDocInTim") != 1) {
              break label596;
            }
            bool1 = true;
            localarpw.jdField_f_of_type_Boolean = bool1;
          }
          if (paramArrayOfaraj.has("timVersion")) {
            localarpw.jdField_b_of_type_Int = paramArrayOfaraj.getInt("timVersion");
          }
          if (paramArrayOfaraj.has("saveTipLine0")) {
            localarpw.jdField_b_of_type_JavaLangString = paramArrayOfaraj.getString("saveTipLine0");
          }
          if (paramArrayOfaraj.has("saveTipLine1")) {
            localarpw.jdField_c_of_type_JavaLangString = paramArrayOfaraj.getString("saveTipLine1");
          }
          if (paramArrayOfaraj.has("saveAndCloseTipLine0")) {
            localarpw.jdField_d_of_type_JavaLangString = paramArrayOfaraj.getString("saveAndCloseTipLine0");
          }
          if (paramArrayOfaraj.has("saveAndCloseTipLine1")) {
            localarpw.jdField_e_of_type_JavaLangString = paramArrayOfaraj.getString("saveAndCloseTipLine1");
          }
          if (paramArrayOfaraj.has("saveTipCount")) {
            localarpw.jdField_c_of_type_Int = paramArrayOfaraj.getInt("saveTipCount");
          }
          if (paramArrayOfaraj.has("contentEditedTipLine0")) {
            localarpw.jdField_f_of_type_JavaLangString = paramArrayOfaraj.getString("contentEditedTipLine0");
          }
          if (paramArrayOfaraj.has("contentEditedTipLine1")) {
            localarpw.jdField_g_of_type_JavaLangString = paramArrayOfaraj.getString("contentEditedTipLine1");
          }
          if (paramArrayOfaraj.has("contentEditedTipCount")) {
            localarpw.jdField_d_of_type_Int = paramArrayOfaraj.getInt("contentEditedTipCount");
          }
          if (paramArrayOfaraj.has("docListEntryInFileSwitch"))
          {
            if (paramArrayOfaraj.getInt("docListEntryInFileSwitch") != 1) {
              break label601;
            }
            bool1 = true;
            localarpw.jdField_g_of_type_Boolean = bool1;
          }
          if (paramArrayOfaraj.has("hideDocAuthoritySettingEntry"))
          {
            bool1 = bool2;
            if (paramArrayOfaraj.getInt("hideDocAuthoritySettingEntry") == 1) {
              bool1 = true;
            }
            localarpw.jdField_h_of_type_Boolean = bool1;
          }
          if (paramArrayOfaraj.has("docListUrl")) {
            localarpw.jdField_h_of_type_JavaLangString = paramArrayOfaraj.getString("docListUrl");
          }
          if (paramArrayOfaraj.has("editSupport"))
          {
            paramArrayOfaraj = paramArrayOfaraj.getJSONObject("editSupport");
            Iterator localIterator = paramArrayOfaraj.keys();
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              localarpw.jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(paramArrayOfaraj.getLong(str)));
              continue;
            }
          }
        }
        return localarpw;
      }
      catch (JSONException paramArrayOfaraj)
      {
        QLog.e("TencentDocConvertConfigBean", 1, paramArrayOfaraj.getLocalizedMessage(), paramArrayOfaraj);
      }
      label571:
      boolean bool1 = false;
      continue;
      label576:
      bool1 = false;
      continue;
      label581:
      bool1 = false;
      continue;
      label586:
      bool1 = false;
      continue;
      label591:
      bool1 = false;
      continue;
      label596:
      bool1 = false;
      continue;
      label601:
      bool1 = false;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public Map<String, Long> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int d()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public String d()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public boolean d()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public String e()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public boolean e()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public String f()
  {
    return this.jdField_f_of_type_JavaLangString;
  }
  
  public String g()
  {
    return this.jdField_g_of_type_JavaLangString;
  }
  
  public String h()
  {
    return this.jdField_h_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arpw
 * JD-Core Version:    0.7.0.1
 */