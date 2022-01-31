import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class anbp
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
  
  public static anbp a(amph[] paramArrayOfamph)
  {
    boolean bool2 = false;
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0)) {
      return null;
    }
    anbp localanbp = new anbp();
    for (;;)
    {
      try
      {
        paramArrayOfamph = new JSONObject(paramArrayOfamph[0].jdField_a_of_type_JavaLangString);
        if (paramArrayOfamph.has("TIMDocs"))
        {
          paramArrayOfamph = paramArrayOfamph.getJSONObject("TIMDocs");
          if (paramArrayOfamph.has("autoImportToSharedDocSwitch"))
          {
            if (paramArrayOfamph.getInt("autoImportToSharedDocSwitch") != 1) {
              break label571;
            }
            bool1 = true;
            localanbp.jdField_a_of_type_Boolean = bool1;
          }
          if (paramArrayOfamph.has("openWithSharedDocInTimSwitch"))
          {
            if (paramArrayOfamph.getInt("openWithSharedDocInTimSwitch") != 1) {
              break label576;
            }
            bool1 = true;
            localanbp.jdField_b_of_type_Boolean = bool1;
          }
          if (paramArrayOfamph.has("openFileInTimSwitch"))
          {
            if (paramArrayOfamph.getInt("openFileInTimSwitch") != 1) {
              break label581;
            }
            bool1 = true;
            localanbp.jdField_c_of_type_Boolean = bool1;
          }
          if (paramArrayOfamph.has("aioSwitch"))
          {
            if (paramArrayOfamph.getInt("aioSwitch") != 1) {
              break label586;
            }
            bool1 = true;
            localanbp.jdField_d_of_type_Boolean = bool1;
          }
          if (paramArrayOfamph.has("fileViewerMenuSwitch"))
          {
            if (paramArrayOfamph.getInt("fileViewerMenuSwitch") != 1) {
              break label591;
            }
            bool1 = true;
            localanbp.jdField_e_of_type_Boolean = bool1;
          }
          if (paramArrayOfamph.has("openFileInTimEntry")) {
            localanbp.jdField_a_of_type_Int = paramArrayOfamph.getInt("openFileInTimEntry");
          }
          if (paramArrayOfamph.has("androidURL")) {
            localanbp.jdField_a_of_type_JavaLangString = paramArrayOfamph.getString("androidURL");
          }
          if (paramArrayOfamph.has("insertGrayTipAfterOpenWithSharedDocInTim"))
          {
            if (paramArrayOfamph.getInt("insertGrayTipAfterOpenWithSharedDocInTim") != 1) {
              break label596;
            }
            bool1 = true;
            localanbp.jdField_f_of_type_Boolean = bool1;
          }
          if (paramArrayOfamph.has("timVersion")) {
            localanbp.jdField_b_of_type_Int = paramArrayOfamph.getInt("timVersion");
          }
          if (paramArrayOfamph.has("saveTipLine0")) {
            localanbp.jdField_b_of_type_JavaLangString = paramArrayOfamph.getString("saveTipLine0");
          }
          if (paramArrayOfamph.has("saveTipLine1")) {
            localanbp.jdField_c_of_type_JavaLangString = paramArrayOfamph.getString("saveTipLine1");
          }
          if (paramArrayOfamph.has("saveAndCloseTipLine0")) {
            localanbp.jdField_d_of_type_JavaLangString = paramArrayOfamph.getString("saveAndCloseTipLine0");
          }
          if (paramArrayOfamph.has("saveAndCloseTipLine1")) {
            localanbp.jdField_e_of_type_JavaLangString = paramArrayOfamph.getString("saveAndCloseTipLine1");
          }
          if (paramArrayOfamph.has("saveTipCount")) {
            localanbp.jdField_c_of_type_Int = paramArrayOfamph.getInt("saveTipCount");
          }
          if (paramArrayOfamph.has("contentEditedTipLine0")) {
            localanbp.jdField_f_of_type_JavaLangString = paramArrayOfamph.getString("contentEditedTipLine0");
          }
          if (paramArrayOfamph.has("contentEditedTipLine1")) {
            localanbp.jdField_g_of_type_JavaLangString = paramArrayOfamph.getString("contentEditedTipLine1");
          }
          if (paramArrayOfamph.has("contentEditedTipCount")) {
            localanbp.jdField_d_of_type_Int = paramArrayOfamph.getInt("contentEditedTipCount");
          }
          if (paramArrayOfamph.has("docListEntryInFileSwitch"))
          {
            if (paramArrayOfamph.getInt("docListEntryInFileSwitch") != 1) {
              break label601;
            }
            bool1 = true;
            localanbp.jdField_g_of_type_Boolean = bool1;
          }
          if (paramArrayOfamph.has("hideDocAuthoritySettingEntry"))
          {
            bool1 = bool2;
            if (paramArrayOfamph.getInt("hideDocAuthoritySettingEntry") == 1) {
              bool1 = true;
            }
            localanbp.jdField_h_of_type_Boolean = bool1;
          }
          if (paramArrayOfamph.has("docListUrl")) {
            localanbp.jdField_h_of_type_JavaLangString = paramArrayOfamph.getString("docListUrl");
          }
          if (paramArrayOfamph.has("editSupport"))
          {
            paramArrayOfamph = paramArrayOfamph.getJSONObject("editSupport");
            Iterator localIterator = paramArrayOfamph.keys();
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              localanbp.jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(paramArrayOfamph.getLong(str)));
              continue;
            }
          }
        }
        return localanbp;
      }
      catch (JSONException paramArrayOfamph)
      {
        QLog.e("TencentDocConvertConfigBean", 1, paramArrayOfamph.getLocalizedMessage(), paramArrayOfamph);
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
 * Qualified Name:     anbp
 * JD-Core Version:    0.7.0.1
 */