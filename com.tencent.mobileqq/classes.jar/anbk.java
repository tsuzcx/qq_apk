import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class anbk
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
  
  public static anbk a(ampi[] paramArrayOfampi)
  {
    boolean bool2 = false;
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0)) {
      return null;
    }
    anbk localanbk = new anbk();
    for (;;)
    {
      try
      {
        paramArrayOfampi = new JSONObject(paramArrayOfampi[0].jdField_a_of_type_JavaLangString);
        if (paramArrayOfampi.has("TIMDocs"))
        {
          paramArrayOfampi = paramArrayOfampi.getJSONObject("TIMDocs");
          if (paramArrayOfampi.has("autoImportToSharedDocSwitch"))
          {
            if (paramArrayOfampi.getInt("autoImportToSharedDocSwitch") != 1) {
              break label571;
            }
            bool1 = true;
            localanbk.jdField_a_of_type_Boolean = bool1;
          }
          if (paramArrayOfampi.has("openWithSharedDocInTimSwitch"))
          {
            if (paramArrayOfampi.getInt("openWithSharedDocInTimSwitch") != 1) {
              break label576;
            }
            bool1 = true;
            localanbk.jdField_b_of_type_Boolean = bool1;
          }
          if (paramArrayOfampi.has("openFileInTimSwitch"))
          {
            if (paramArrayOfampi.getInt("openFileInTimSwitch") != 1) {
              break label581;
            }
            bool1 = true;
            localanbk.jdField_c_of_type_Boolean = bool1;
          }
          if (paramArrayOfampi.has("aioSwitch"))
          {
            if (paramArrayOfampi.getInt("aioSwitch") != 1) {
              break label586;
            }
            bool1 = true;
            localanbk.jdField_d_of_type_Boolean = bool1;
          }
          if (paramArrayOfampi.has("fileViewerMenuSwitch"))
          {
            if (paramArrayOfampi.getInt("fileViewerMenuSwitch") != 1) {
              break label591;
            }
            bool1 = true;
            localanbk.jdField_e_of_type_Boolean = bool1;
          }
          if (paramArrayOfampi.has("openFileInTimEntry")) {
            localanbk.jdField_a_of_type_Int = paramArrayOfampi.getInt("openFileInTimEntry");
          }
          if (paramArrayOfampi.has("androidURL")) {
            localanbk.jdField_a_of_type_JavaLangString = paramArrayOfampi.getString("androidURL");
          }
          if (paramArrayOfampi.has("insertGrayTipAfterOpenWithSharedDocInTim"))
          {
            if (paramArrayOfampi.getInt("insertGrayTipAfterOpenWithSharedDocInTim") != 1) {
              break label596;
            }
            bool1 = true;
            localanbk.jdField_f_of_type_Boolean = bool1;
          }
          if (paramArrayOfampi.has("timVersion")) {
            localanbk.jdField_b_of_type_Int = paramArrayOfampi.getInt("timVersion");
          }
          if (paramArrayOfampi.has("saveTipLine0")) {
            localanbk.jdField_b_of_type_JavaLangString = paramArrayOfampi.getString("saveTipLine0");
          }
          if (paramArrayOfampi.has("saveTipLine1")) {
            localanbk.jdField_c_of_type_JavaLangString = paramArrayOfampi.getString("saveTipLine1");
          }
          if (paramArrayOfampi.has("saveAndCloseTipLine0")) {
            localanbk.jdField_d_of_type_JavaLangString = paramArrayOfampi.getString("saveAndCloseTipLine0");
          }
          if (paramArrayOfampi.has("saveAndCloseTipLine1")) {
            localanbk.jdField_e_of_type_JavaLangString = paramArrayOfampi.getString("saveAndCloseTipLine1");
          }
          if (paramArrayOfampi.has("saveTipCount")) {
            localanbk.jdField_c_of_type_Int = paramArrayOfampi.getInt("saveTipCount");
          }
          if (paramArrayOfampi.has("contentEditedTipLine0")) {
            localanbk.jdField_f_of_type_JavaLangString = paramArrayOfampi.getString("contentEditedTipLine0");
          }
          if (paramArrayOfampi.has("contentEditedTipLine1")) {
            localanbk.jdField_g_of_type_JavaLangString = paramArrayOfampi.getString("contentEditedTipLine1");
          }
          if (paramArrayOfampi.has("contentEditedTipCount")) {
            localanbk.jdField_d_of_type_Int = paramArrayOfampi.getInt("contentEditedTipCount");
          }
          if (paramArrayOfampi.has("docListEntryInFileSwitch"))
          {
            if (paramArrayOfampi.getInt("docListEntryInFileSwitch") != 1) {
              break label601;
            }
            bool1 = true;
            localanbk.jdField_g_of_type_Boolean = bool1;
          }
          if (paramArrayOfampi.has("hideDocAuthoritySettingEntry"))
          {
            bool1 = bool2;
            if (paramArrayOfampi.getInt("hideDocAuthoritySettingEntry") == 1) {
              bool1 = true;
            }
            localanbk.jdField_h_of_type_Boolean = bool1;
          }
          if (paramArrayOfampi.has("docListUrl")) {
            localanbk.jdField_h_of_type_JavaLangString = paramArrayOfampi.getString("docListUrl");
          }
          if (paramArrayOfampi.has("editSupport"))
          {
            paramArrayOfampi = paramArrayOfampi.getJSONObject("editSupport");
            Iterator localIterator = paramArrayOfampi.keys();
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              localanbk.jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(paramArrayOfampi.getLong(str)));
              continue;
            }
          }
        }
        return localanbk;
      }
      catch (JSONException paramArrayOfampi)
      {
        QLog.e("TencentDocConvertConfigBean", 1, paramArrayOfampi.getLocalizedMessage(), paramArrayOfampi);
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
 * Qualified Name:     anbk
 * JD-Core Version:    0.7.0.1
 */