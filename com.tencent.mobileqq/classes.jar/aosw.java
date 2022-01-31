import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aosw
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
  
  public static aosw a(aogf[] paramArrayOfaogf)
  {
    boolean bool2 = false;
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0)) {
      return null;
    }
    aosw localaosw = new aosw();
    for (;;)
    {
      try
      {
        paramArrayOfaogf = new JSONObject(paramArrayOfaogf[0].jdField_a_of_type_JavaLangString);
        if (paramArrayOfaogf.has("TIMDocs"))
        {
          paramArrayOfaogf = paramArrayOfaogf.getJSONObject("TIMDocs");
          if (paramArrayOfaogf.has("autoImportToSharedDocSwitch"))
          {
            if (paramArrayOfaogf.getInt("autoImportToSharedDocSwitch") != 1) {
              break label571;
            }
            bool1 = true;
            localaosw.jdField_a_of_type_Boolean = bool1;
          }
          if (paramArrayOfaogf.has("openWithSharedDocInTimSwitch"))
          {
            if (paramArrayOfaogf.getInt("openWithSharedDocInTimSwitch") != 1) {
              break label576;
            }
            bool1 = true;
            localaosw.jdField_b_of_type_Boolean = bool1;
          }
          if (paramArrayOfaogf.has("openFileInTimSwitch"))
          {
            if (paramArrayOfaogf.getInt("openFileInTimSwitch") != 1) {
              break label581;
            }
            bool1 = true;
            localaosw.jdField_c_of_type_Boolean = bool1;
          }
          if (paramArrayOfaogf.has("aioSwitch"))
          {
            if (paramArrayOfaogf.getInt("aioSwitch") != 1) {
              break label586;
            }
            bool1 = true;
            localaosw.jdField_d_of_type_Boolean = bool1;
          }
          if (paramArrayOfaogf.has("fileViewerMenuSwitch"))
          {
            if (paramArrayOfaogf.getInt("fileViewerMenuSwitch") != 1) {
              break label591;
            }
            bool1 = true;
            localaosw.jdField_e_of_type_Boolean = bool1;
          }
          if (paramArrayOfaogf.has("openFileInTimEntry")) {
            localaosw.jdField_a_of_type_Int = paramArrayOfaogf.getInt("openFileInTimEntry");
          }
          if (paramArrayOfaogf.has("androidURL")) {
            localaosw.jdField_a_of_type_JavaLangString = paramArrayOfaogf.getString("androidURL");
          }
          if (paramArrayOfaogf.has("insertGrayTipAfterOpenWithSharedDocInTim"))
          {
            if (paramArrayOfaogf.getInt("insertGrayTipAfterOpenWithSharedDocInTim") != 1) {
              break label596;
            }
            bool1 = true;
            localaosw.jdField_f_of_type_Boolean = bool1;
          }
          if (paramArrayOfaogf.has("timVersion")) {
            localaosw.jdField_b_of_type_Int = paramArrayOfaogf.getInt("timVersion");
          }
          if (paramArrayOfaogf.has("saveTipLine0")) {
            localaosw.jdField_b_of_type_JavaLangString = paramArrayOfaogf.getString("saveTipLine0");
          }
          if (paramArrayOfaogf.has("saveTipLine1")) {
            localaosw.jdField_c_of_type_JavaLangString = paramArrayOfaogf.getString("saveTipLine1");
          }
          if (paramArrayOfaogf.has("saveAndCloseTipLine0")) {
            localaosw.jdField_d_of_type_JavaLangString = paramArrayOfaogf.getString("saveAndCloseTipLine0");
          }
          if (paramArrayOfaogf.has("saveAndCloseTipLine1")) {
            localaosw.jdField_e_of_type_JavaLangString = paramArrayOfaogf.getString("saveAndCloseTipLine1");
          }
          if (paramArrayOfaogf.has("saveTipCount")) {
            localaosw.jdField_c_of_type_Int = paramArrayOfaogf.getInt("saveTipCount");
          }
          if (paramArrayOfaogf.has("contentEditedTipLine0")) {
            localaosw.jdField_f_of_type_JavaLangString = paramArrayOfaogf.getString("contentEditedTipLine0");
          }
          if (paramArrayOfaogf.has("contentEditedTipLine1")) {
            localaosw.jdField_g_of_type_JavaLangString = paramArrayOfaogf.getString("contentEditedTipLine1");
          }
          if (paramArrayOfaogf.has("contentEditedTipCount")) {
            localaosw.jdField_d_of_type_Int = paramArrayOfaogf.getInt("contentEditedTipCount");
          }
          if (paramArrayOfaogf.has("docListEntryInFileSwitch"))
          {
            if (paramArrayOfaogf.getInt("docListEntryInFileSwitch") != 1) {
              break label601;
            }
            bool1 = true;
            localaosw.jdField_g_of_type_Boolean = bool1;
          }
          if (paramArrayOfaogf.has("hideDocAuthoritySettingEntry"))
          {
            bool1 = bool2;
            if (paramArrayOfaogf.getInt("hideDocAuthoritySettingEntry") == 1) {
              bool1 = true;
            }
            localaosw.jdField_h_of_type_Boolean = bool1;
          }
          if (paramArrayOfaogf.has("docListUrl")) {
            localaosw.jdField_h_of_type_JavaLangString = paramArrayOfaogf.getString("docListUrl");
          }
          if (paramArrayOfaogf.has("editSupport"))
          {
            paramArrayOfaogf = paramArrayOfaogf.getJSONObject("editSupport");
            Iterator localIterator = paramArrayOfaogf.keys();
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              localaosw.jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(paramArrayOfaogf.getLong(str)));
              continue;
            }
          }
        }
        return localaosw;
      }
      catch (JSONException paramArrayOfaogf)
      {
        QLog.e("TencentDocConvertConfigBean", 1, paramArrayOfaogf.getLocalizedMessage(), paramArrayOfaogf);
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
 * Qualified Name:     aosw
 * JD-Core Version:    0.7.0.1
 */