import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aoxf
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
  
  public static aoxf a(aoko[] paramArrayOfaoko)
  {
    boolean bool2 = false;
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0)) {
      return null;
    }
    aoxf localaoxf = new aoxf();
    for (;;)
    {
      try
      {
        paramArrayOfaoko = new JSONObject(paramArrayOfaoko[0].jdField_a_of_type_JavaLangString);
        if (paramArrayOfaoko.has("TIMDocs"))
        {
          paramArrayOfaoko = paramArrayOfaoko.getJSONObject("TIMDocs");
          if (paramArrayOfaoko.has("autoImportToSharedDocSwitch"))
          {
            if (paramArrayOfaoko.getInt("autoImportToSharedDocSwitch") != 1) {
              break label571;
            }
            bool1 = true;
            localaoxf.jdField_a_of_type_Boolean = bool1;
          }
          if (paramArrayOfaoko.has("openWithSharedDocInTimSwitch"))
          {
            if (paramArrayOfaoko.getInt("openWithSharedDocInTimSwitch") != 1) {
              break label576;
            }
            bool1 = true;
            localaoxf.jdField_b_of_type_Boolean = bool1;
          }
          if (paramArrayOfaoko.has("openFileInTimSwitch"))
          {
            if (paramArrayOfaoko.getInt("openFileInTimSwitch") != 1) {
              break label581;
            }
            bool1 = true;
            localaoxf.jdField_c_of_type_Boolean = bool1;
          }
          if (paramArrayOfaoko.has("aioSwitch"))
          {
            if (paramArrayOfaoko.getInt("aioSwitch") != 1) {
              break label586;
            }
            bool1 = true;
            localaoxf.jdField_d_of_type_Boolean = bool1;
          }
          if (paramArrayOfaoko.has("fileViewerMenuSwitch"))
          {
            if (paramArrayOfaoko.getInt("fileViewerMenuSwitch") != 1) {
              break label591;
            }
            bool1 = true;
            localaoxf.jdField_e_of_type_Boolean = bool1;
          }
          if (paramArrayOfaoko.has("openFileInTimEntry")) {
            localaoxf.jdField_a_of_type_Int = paramArrayOfaoko.getInt("openFileInTimEntry");
          }
          if (paramArrayOfaoko.has("androidURL")) {
            localaoxf.jdField_a_of_type_JavaLangString = paramArrayOfaoko.getString("androidURL");
          }
          if (paramArrayOfaoko.has("insertGrayTipAfterOpenWithSharedDocInTim"))
          {
            if (paramArrayOfaoko.getInt("insertGrayTipAfterOpenWithSharedDocInTim") != 1) {
              break label596;
            }
            bool1 = true;
            localaoxf.jdField_f_of_type_Boolean = bool1;
          }
          if (paramArrayOfaoko.has("timVersion")) {
            localaoxf.jdField_b_of_type_Int = paramArrayOfaoko.getInt("timVersion");
          }
          if (paramArrayOfaoko.has("saveTipLine0")) {
            localaoxf.jdField_b_of_type_JavaLangString = paramArrayOfaoko.getString("saveTipLine0");
          }
          if (paramArrayOfaoko.has("saveTipLine1")) {
            localaoxf.jdField_c_of_type_JavaLangString = paramArrayOfaoko.getString("saveTipLine1");
          }
          if (paramArrayOfaoko.has("saveAndCloseTipLine0")) {
            localaoxf.jdField_d_of_type_JavaLangString = paramArrayOfaoko.getString("saveAndCloseTipLine0");
          }
          if (paramArrayOfaoko.has("saveAndCloseTipLine1")) {
            localaoxf.jdField_e_of_type_JavaLangString = paramArrayOfaoko.getString("saveAndCloseTipLine1");
          }
          if (paramArrayOfaoko.has("saveTipCount")) {
            localaoxf.jdField_c_of_type_Int = paramArrayOfaoko.getInt("saveTipCount");
          }
          if (paramArrayOfaoko.has("contentEditedTipLine0")) {
            localaoxf.jdField_f_of_type_JavaLangString = paramArrayOfaoko.getString("contentEditedTipLine0");
          }
          if (paramArrayOfaoko.has("contentEditedTipLine1")) {
            localaoxf.jdField_g_of_type_JavaLangString = paramArrayOfaoko.getString("contentEditedTipLine1");
          }
          if (paramArrayOfaoko.has("contentEditedTipCount")) {
            localaoxf.jdField_d_of_type_Int = paramArrayOfaoko.getInt("contentEditedTipCount");
          }
          if (paramArrayOfaoko.has("docListEntryInFileSwitch"))
          {
            if (paramArrayOfaoko.getInt("docListEntryInFileSwitch") != 1) {
              break label601;
            }
            bool1 = true;
            localaoxf.jdField_g_of_type_Boolean = bool1;
          }
          if (paramArrayOfaoko.has("hideDocAuthoritySettingEntry"))
          {
            bool1 = bool2;
            if (paramArrayOfaoko.getInt("hideDocAuthoritySettingEntry") == 1) {
              bool1 = true;
            }
            localaoxf.jdField_h_of_type_Boolean = bool1;
          }
          if (paramArrayOfaoko.has("docListUrl")) {
            localaoxf.jdField_h_of_type_JavaLangString = paramArrayOfaoko.getString("docListUrl");
          }
          if (paramArrayOfaoko.has("editSupport"))
          {
            paramArrayOfaoko = paramArrayOfaoko.getJSONObject("editSupport");
            Iterator localIterator = paramArrayOfaoko.keys();
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              localaoxf.jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(paramArrayOfaoko.getLong(str)));
              continue;
            }
          }
        }
        return localaoxf;
      }
      catch (JSONException paramArrayOfaoko)
      {
        QLog.e("TencentDocConvertConfigBean", 1, paramArrayOfaoko.getLocalizedMessage(), paramArrayOfaoko);
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
 * Qualified Name:     aoxf
 * JD-Core Version:    0.7.0.1
 */