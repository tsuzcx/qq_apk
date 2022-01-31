import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class amlg
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
  
  public static amlg a(alzs[] paramArrayOfalzs)
  {
    boolean bool2 = false;
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0)) {
      return null;
    }
    amlg localamlg = new amlg();
    for (;;)
    {
      try
      {
        paramArrayOfalzs = new JSONObject(paramArrayOfalzs[0].jdField_a_of_type_JavaLangString);
        if (paramArrayOfalzs.has("TIMDocs"))
        {
          paramArrayOfalzs = paramArrayOfalzs.getJSONObject("TIMDocs");
          if (paramArrayOfalzs.has("autoImportToSharedDocSwitch"))
          {
            if (paramArrayOfalzs.getInt("autoImportToSharedDocSwitch") != 1) {
              break label571;
            }
            bool1 = true;
            localamlg.jdField_a_of_type_Boolean = bool1;
          }
          if (paramArrayOfalzs.has("openWithSharedDocInTimSwitch"))
          {
            if (paramArrayOfalzs.getInt("openWithSharedDocInTimSwitch") != 1) {
              break label576;
            }
            bool1 = true;
            localamlg.jdField_b_of_type_Boolean = bool1;
          }
          if (paramArrayOfalzs.has("openFileInTimSwitch"))
          {
            if (paramArrayOfalzs.getInt("openFileInTimSwitch") != 1) {
              break label581;
            }
            bool1 = true;
            localamlg.jdField_c_of_type_Boolean = bool1;
          }
          if (paramArrayOfalzs.has("aioSwitch"))
          {
            if (paramArrayOfalzs.getInt("aioSwitch") != 1) {
              break label586;
            }
            bool1 = true;
            localamlg.jdField_d_of_type_Boolean = bool1;
          }
          if (paramArrayOfalzs.has("fileViewerMenuSwitch"))
          {
            if (paramArrayOfalzs.getInt("fileViewerMenuSwitch") != 1) {
              break label591;
            }
            bool1 = true;
            localamlg.jdField_e_of_type_Boolean = bool1;
          }
          if (paramArrayOfalzs.has("openFileInTimEntry")) {
            localamlg.jdField_a_of_type_Int = paramArrayOfalzs.getInt("openFileInTimEntry");
          }
          if (paramArrayOfalzs.has("androidURL")) {
            localamlg.jdField_a_of_type_JavaLangString = paramArrayOfalzs.getString("androidURL");
          }
          if (paramArrayOfalzs.has("insertGrayTipAfterOpenWithSharedDocInTim"))
          {
            if (paramArrayOfalzs.getInt("insertGrayTipAfterOpenWithSharedDocInTim") != 1) {
              break label596;
            }
            bool1 = true;
            localamlg.jdField_f_of_type_Boolean = bool1;
          }
          if (paramArrayOfalzs.has("timVersion")) {
            localamlg.jdField_b_of_type_Int = paramArrayOfalzs.getInt("timVersion");
          }
          if (paramArrayOfalzs.has("saveTipLine0")) {
            localamlg.jdField_b_of_type_JavaLangString = paramArrayOfalzs.getString("saveTipLine0");
          }
          if (paramArrayOfalzs.has("saveTipLine1")) {
            localamlg.jdField_c_of_type_JavaLangString = paramArrayOfalzs.getString("saveTipLine1");
          }
          if (paramArrayOfalzs.has("saveAndCloseTipLine0")) {
            localamlg.jdField_d_of_type_JavaLangString = paramArrayOfalzs.getString("saveAndCloseTipLine0");
          }
          if (paramArrayOfalzs.has("saveAndCloseTipLine1")) {
            localamlg.jdField_e_of_type_JavaLangString = paramArrayOfalzs.getString("saveAndCloseTipLine1");
          }
          if (paramArrayOfalzs.has("saveTipCount")) {
            localamlg.jdField_c_of_type_Int = paramArrayOfalzs.getInt("saveTipCount");
          }
          if (paramArrayOfalzs.has("contentEditedTipLine0")) {
            localamlg.jdField_f_of_type_JavaLangString = paramArrayOfalzs.getString("contentEditedTipLine0");
          }
          if (paramArrayOfalzs.has("contentEditedTipLine1")) {
            localamlg.jdField_g_of_type_JavaLangString = paramArrayOfalzs.getString("contentEditedTipLine1");
          }
          if (paramArrayOfalzs.has("contentEditedTipCount")) {
            localamlg.jdField_d_of_type_Int = paramArrayOfalzs.getInt("contentEditedTipCount");
          }
          if (paramArrayOfalzs.has("docListEntryInFileSwitch"))
          {
            if (paramArrayOfalzs.getInt("docListEntryInFileSwitch") != 1) {
              break label601;
            }
            bool1 = true;
            localamlg.jdField_g_of_type_Boolean = bool1;
          }
          if (paramArrayOfalzs.has("hideDocAuthoritySettingEntry"))
          {
            bool1 = bool2;
            if (paramArrayOfalzs.getInt("hideDocAuthoritySettingEntry") == 1) {
              bool1 = true;
            }
            localamlg.jdField_h_of_type_Boolean = bool1;
          }
          if (paramArrayOfalzs.has("docListUrl")) {
            localamlg.jdField_h_of_type_JavaLangString = paramArrayOfalzs.getString("docListUrl");
          }
          if (paramArrayOfalzs.has("editSupport"))
          {
            paramArrayOfalzs = paramArrayOfalzs.getJSONObject("editSupport");
            Iterator localIterator = paramArrayOfalzs.keys();
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              localamlg.jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(paramArrayOfalzs.getLong(str)));
              continue;
            }
          }
        }
        return localamlg;
      }
      catch (JSONException paramArrayOfalzs)
      {
        QLog.e("TencentDocConvertConfigBean", 1, paramArrayOfalzs.getLocalizedMessage(), paramArrayOfalzs);
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
 * Qualified Name:     amlg
 * JD-Core Version:    0.7.0.1
 */