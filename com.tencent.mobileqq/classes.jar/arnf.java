import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class arnf
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
  
  public static arnf a(aqxa[] paramArrayOfaqxa)
  {
    boolean bool2 = false;
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
      return null;
    }
    arnf localarnf = new arnf();
    for (;;)
    {
      try
      {
        paramArrayOfaqxa = new JSONObject(paramArrayOfaqxa[0].jdField_a_of_type_JavaLangString);
        if (paramArrayOfaqxa.has("TIMDocs"))
        {
          paramArrayOfaqxa = paramArrayOfaqxa.getJSONObject("TIMDocs");
          if (paramArrayOfaqxa.has("autoImportToSharedDocSwitch"))
          {
            if (paramArrayOfaqxa.getInt("autoImportToSharedDocSwitch") != 1) {
              break label571;
            }
            bool1 = true;
            localarnf.jdField_a_of_type_Boolean = bool1;
          }
          if (paramArrayOfaqxa.has("openWithSharedDocInTimSwitch"))
          {
            if (paramArrayOfaqxa.getInt("openWithSharedDocInTimSwitch") != 1) {
              break label576;
            }
            bool1 = true;
            localarnf.jdField_b_of_type_Boolean = bool1;
          }
          if (paramArrayOfaqxa.has("openFileInTimSwitch"))
          {
            if (paramArrayOfaqxa.getInt("openFileInTimSwitch") != 1) {
              break label581;
            }
            bool1 = true;
            localarnf.jdField_c_of_type_Boolean = bool1;
          }
          if (paramArrayOfaqxa.has("aioSwitch"))
          {
            if (paramArrayOfaqxa.getInt("aioSwitch") != 1) {
              break label586;
            }
            bool1 = true;
            localarnf.jdField_d_of_type_Boolean = bool1;
          }
          if (paramArrayOfaqxa.has("fileViewerMenuSwitch"))
          {
            if (paramArrayOfaqxa.getInt("fileViewerMenuSwitch") != 1) {
              break label591;
            }
            bool1 = true;
            localarnf.jdField_e_of_type_Boolean = bool1;
          }
          if (paramArrayOfaqxa.has("openFileInTimEntry")) {
            localarnf.jdField_a_of_type_Int = paramArrayOfaqxa.getInt("openFileInTimEntry");
          }
          if (paramArrayOfaqxa.has("androidURL")) {
            localarnf.jdField_a_of_type_JavaLangString = paramArrayOfaqxa.getString("androidURL");
          }
          if (paramArrayOfaqxa.has("insertGrayTipAfterOpenWithSharedDocInTim"))
          {
            if (paramArrayOfaqxa.getInt("insertGrayTipAfterOpenWithSharedDocInTim") != 1) {
              break label596;
            }
            bool1 = true;
            localarnf.jdField_f_of_type_Boolean = bool1;
          }
          if (paramArrayOfaqxa.has("timVersion")) {
            localarnf.jdField_b_of_type_Int = paramArrayOfaqxa.getInt("timVersion");
          }
          if (paramArrayOfaqxa.has("saveTipLine0")) {
            localarnf.jdField_b_of_type_JavaLangString = paramArrayOfaqxa.getString("saveTipLine0");
          }
          if (paramArrayOfaqxa.has("saveTipLine1")) {
            localarnf.jdField_c_of_type_JavaLangString = paramArrayOfaqxa.getString("saveTipLine1");
          }
          if (paramArrayOfaqxa.has("saveAndCloseTipLine0")) {
            localarnf.jdField_d_of_type_JavaLangString = paramArrayOfaqxa.getString("saveAndCloseTipLine0");
          }
          if (paramArrayOfaqxa.has("saveAndCloseTipLine1")) {
            localarnf.jdField_e_of_type_JavaLangString = paramArrayOfaqxa.getString("saveAndCloseTipLine1");
          }
          if (paramArrayOfaqxa.has("saveTipCount")) {
            localarnf.jdField_c_of_type_Int = paramArrayOfaqxa.getInt("saveTipCount");
          }
          if (paramArrayOfaqxa.has("contentEditedTipLine0")) {
            localarnf.jdField_f_of_type_JavaLangString = paramArrayOfaqxa.getString("contentEditedTipLine0");
          }
          if (paramArrayOfaqxa.has("contentEditedTipLine1")) {
            localarnf.jdField_g_of_type_JavaLangString = paramArrayOfaqxa.getString("contentEditedTipLine1");
          }
          if (paramArrayOfaqxa.has("contentEditedTipCount")) {
            localarnf.jdField_d_of_type_Int = paramArrayOfaqxa.getInt("contentEditedTipCount");
          }
          if (paramArrayOfaqxa.has("docListEntryInFileSwitch"))
          {
            if (paramArrayOfaqxa.getInt("docListEntryInFileSwitch") != 1) {
              break label601;
            }
            bool1 = true;
            localarnf.jdField_g_of_type_Boolean = bool1;
          }
          if (paramArrayOfaqxa.has("hideDocAuthoritySettingEntry"))
          {
            bool1 = bool2;
            if (paramArrayOfaqxa.getInt("hideDocAuthoritySettingEntry") == 1) {
              bool1 = true;
            }
            localarnf.jdField_h_of_type_Boolean = bool1;
          }
          if (paramArrayOfaqxa.has("docListUrl")) {
            localarnf.jdField_h_of_type_JavaLangString = paramArrayOfaqxa.getString("docListUrl");
          }
          if (paramArrayOfaqxa.has("editSupport"))
          {
            paramArrayOfaqxa = paramArrayOfaqxa.getJSONObject("editSupport");
            Iterator localIterator = paramArrayOfaqxa.keys();
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              localarnf.jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(paramArrayOfaqxa.getLong(str)));
              continue;
            }
          }
        }
        return localarnf;
      }
      catch (JSONException paramArrayOfaqxa)
      {
        QLog.e("TencentDocConvertConfigBean", 1, paramArrayOfaqxa.getLocalizedMessage(), paramArrayOfaqxa);
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
 * Qualified Name:     arnf
 * JD-Core Version:    0.7.0.1
 */