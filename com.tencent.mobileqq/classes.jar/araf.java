import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class araf
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
  
  public static araf a(aqlg[] paramArrayOfaqlg)
  {
    boolean bool2 = false;
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0)) {
      return null;
    }
    araf localaraf = new araf();
    for (;;)
    {
      try
      {
        paramArrayOfaqlg = new JSONObject(paramArrayOfaqlg[0].jdField_a_of_type_JavaLangString);
        if (paramArrayOfaqlg.has("TIMDocs"))
        {
          paramArrayOfaqlg = paramArrayOfaqlg.getJSONObject("TIMDocs");
          if (paramArrayOfaqlg.has("autoImportToSharedDocSwitch"))
          {
            if (paramArrayOfaqlg.getInt("autoImportToSharedDocSwitch") != 1) {
              break label571;
            }
            bool1 = true;
            localaraf.jdField_a_of_type_Boolean = bool1;
          }
          if (paramArrayOfaqlg.has("openWithSharedDocInTimSwitch"))
          {
            if (paramArrayOfaqlg.getInt("openWithSharedDocInTimSwitch") != 1) {
              break label576;
            }
            bool1 = true;
            localaraf.jdField_b_of_type_Boolean = bool1;
          }
          if (paramArrayOfaqlg.has("openFileInTimSwitch"))
          {
            if (paramArrayOfaqlg.getInt("openFileInTimSwitch") != 1) {
              break label581;
            }
            bool1 = true;
            localaraf.jdField_c_of_type_Boolean = bool1;
          }
          if (paramArrayOfaqlg.has("aioSwitch"))
          {
            if (paramArrayOfaqlg.getInt("aioSwitch") != 1) {
              break label586;
            }
            bool1 = true;
            localaraf.jdField_d_of_type_Boolean = bool1;
          }
          if (paramArrayOfaqlg.has("fileViewerMenuSwitch"))
          {
            if (paramArrayOfaqlg.getInt("fileViewerMenuSwitch") != 1) {
              break label591;
            }
            bool1 = true;
            localaraf.jdField_e_of_type_Boolean = bool1;
          }
          if (paramArrayOfaqlg.has("openFileInTimEntry")) {
            localaraf.jdField_a_of_type_Int = paramArrayOfaqlg.getInt("openFileInTimEntry");
          }
          if (paramArrayOfaqlg.has("androidURL")) {
            localaraf.jdField_a_of_type_JavaLangString = paramArrayOfaqlg.getString("androidURL");
          }
          if (paramArrayOfaqlg.has("insertGrayTipAfterOpenWithSharedDocInTim"))
          {
            if (paramArrayOfaqlg.getInt("insertGrayTipAfterOpenWithSharedDocInTim") != 1) {
              break label596;
            }
            bool1 = true;
            localaraf.jdField_f_of_type_Boolean = bool1;
          }
          if (paramArrayOfaqlg.has("timVersion")) {
            localaraf.jdField_b_of_type_Int = paramArrayOfaqlg.getInt("timVersion");
          }
          if (paramArrayOfaqlg.has("saveTipLine0")) {
            localaraf.jdField_b_of_type_JavaLangString = paramArrayOfaqlg.getString("saveTipLine0");
          }
          if (paramArrayOfaqlg.has("saveTipLine1")) {
            localaraf.jdField_c_of_type_JavaLangString = paramArrayOfaqlg.getString("saveTipLine1");
          }
          if (paramArrayOfaqlg.has("saveAndCloseTipLine0")) {
            localaraf.jdField_d_of_type_JavaLangString = paramArrayOfaqlg.getString("saveAndCloseTipLine0");
          }
          if (paramArrayOfaqlg.has("saveAndCloseTipLine1")) {
            localaraf.jdField_e_of_type_JavaLangString = paramArrayOfaqlg.getString("saveAndCloseTipLine1");
          }
          if (paramArrayOfaqlg.has("saveTipCount")) {
            localaraf.jdField_c_of_type_Int = paramArrayOfaqlg.getInt("saveTipCount");
          }
          if (paramArrayOfaqlg.has("contentEditedTipLine0")) {
            localaraf.jdField_f_of_type_JavaLangString = paramArrayOfaqlg.getString("contentEditedTipLine0");
          }
          if (paramArrayOfaqlg.has("contentEditedTipLine1")) {
            localaraf.jdField_g_of_type_JavaLangString = paramArrayOfaqlg.getString("contentEditedTipLine1");
          }
          if (paramArrayOfaqlg.has("contentEditedTipCount")) {
            localaraf.jdField_d_of_type_Int = paramArrayOfaqlg.getInt("contentEditedTipCount");
          }
          if (paramArrayOfaqlg.has("docListEntryInFileSwitch"))
          {
            if (paramArrayOfaqlg.getInt("docListEntryInFileSwitch") != 1) {
              break label601;
            }
            bool1 = true;
            localaraf.jdField_g_of_type_Boolean = bool1;
          }
          if (paramArrayOfaqlg.has("hideDocAuthoritySettingEntry"))
          {
            bool1 = bool2;
            if (paramArrayOfaqlg.getInt("hideDocAuthoritySettingEntry") == 1) {
              bool1 = true;
            }
            localaraf.jdField_h_of_type_Boolean = bool1;
          }
          if (paramArrayOfaqlg.has("docListUrl")) {
            localaraf.jdField_h_of_type_JavaLangString = paramArrayOfaqlg.getString("docListUrl");
          }
          if (paramArrayOfaqlg.has("editSupport"))
          {
            paramArrayOfaqlg = paramArrayOfaqlg.getJSONObject("editSupport");
            Iterator localIterator = paramArrayOfaqlg.keys();
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              localaraf.jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(paramArrayOfaqlg.getLong(str)));
              continue;
            }
          }
        }
        return localaraf;
      }
      catch (JSONException paramArrayOfaqlg)
      {
        QLog.e("TencentDocConvertConfigBean", 1, paramArrayOfaqlg.getLocalizedMessage(), paramArrayOfaqlg);
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
 * Qualified Name:     araf
 * JD-Core Version:    0.7.0.1
 */