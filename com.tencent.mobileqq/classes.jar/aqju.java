import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aqju
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
  
  public static aqju a(aptx[] paramArrayOfaptx)
  {
    boolean bool2 = false;
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0)) {
      return null;
    }
    aqju localaqju = new aqju();
    for (;;)
    {
      try
      {
        paramArrayOfaptx = new JSONObject(paramArrayOfaptx[0].jdField_a_of_type_JavaLangString);
        if (paramArrayOfaptx.has("TIMDocs"))
        {
          paramArrayOfaptx = paramArrayOfaptx.getJSONObject("TIMDocs");
          if (paramArrayOfaptx.has("autoImportToSharedDocSwitch"))
          {
            if (paramArrayOfaptx.getInt("autoImportToSharedDocSwitch") != 1) {
              break label571;
            }
            bool1 = true;
            localaqju.jdField_a_of_type_Boolean = bool1;
          }
          if (paramArrayOfaptx.has("openWithSharedDocInTimSwitch"))
          {
            if (paramArrayOfaptx.getInt("openWithSharedDocInTimSwitch") != 1) {
              break label576;
            }
            bool1 = true;
            localaqju.jdField_b_of_type_Boolean = bool1;
          }
          if (paramArrayOfaptx.has("openFileInTimSwitch"))
          {
            if (paramArrayOfaptx.getInt("openFileInTimSwitch") != 1) {
              break label581;
            }
            bool1 = true;
            localaqju.jdField_c_of_type_Boolean = bool1;
          }
          if (paramArrayOfaptx.has("aioSwitch"))
          {
            if (paramArrayOfaptx.getInt("aioSwitch") != 1) {
              break label586;
            }
            bool1 = true;
            localaqju.jdField_d_of_type_Boolean = bool1;
          }
          if (paramArrayOfaptx.has("fileViewerMenuSwitch"))
          {
            if (paramArrayOfaptx.getInt("fileViewerMenuSwitch") != 1) {
              break label591;
            }
            bool1 = true;
            localaqju.jdField_e_of_type_Boolean = bool1;
          }
          if (paramArrayOfaptx.has("openFileInTimEntry")) {
            localaqju.jdField_a_of_type_Int = paramArrayOfaptx.getInt("openFileInTimEntry");
          }
          if (paramArrayOfaptx.has("androidURL")) {
            localaqju.jdField_a_of_type_JavaLangString = paramArrayOfaptx.getString("androidURL");
          }
          if (paramArrayOfaptx.has("insertGrayTipAfterOpenWithSharedDocInTim"))
          {
            if (paramArrayOfaptx.getInt("insertGrayTipAfterOpenWithSharedDocInTim") != 1) {
              break label596;
            }
            bool1 = true;
            localaqju.jdField_f_of_type_Boolean = bool1;
          }
          if (paramArrayOfaptx.has("timVersion")) {
            localaqju.jdField_b_of_type_Int = paramArrayOfaptx.getInt("timVersion");
          }
          if (paramArrayOfaptx.has("saveTipLine0")) {
            localaqju.jdField_b_of_type_JavaLangString = paramArrayOfaptx.getString("saveTipLine0");
          }
          if (paramArrayOfaptx.has("saveTipLine1")) {
            localaqju.jdField_c_of_type_JavaLangString = paramArrayOfaptx.getString("saveTipLine1");
          }
          if (paramArrayOfaptx.has("saveAndCloseTipLine0")) {
            localaqju.jdField_d_of_type_JavaLangString = paramArrayOfaptx.getString("saveAndCloseTipLine0");
          }
          if (paramArrayOfaptx.has("saveAndCloseTipLine1")) {
            localaqju.jdField_e_of_type_JavaLangString = paramArrayOfaptx.getString("saveAndCloseTipLine1");
          }
          if (paramArrayOfaptx.has("saveTipCount")) {
            localaqju.jdField_c_of_type_Int = paramArrayOfaptx.getInt("saveTipCount");
          }
          if (paramArrayOfaptx.has("contentEditedTipLine0")) {
            localaqju.jdField_f_of_type_JavaLangString = paramArrayOfaptx.getString("contentEditedTipLine0");
          }
          if (paramArrayOfaptx.has("contentEditedTipLine1")) {
            localaqju.jdField_g_of_type_JavaLangString = paramArrayOfaptx.getString("contentEditedTipLine1");
          }
          if (paramArrayOfaptx.has("contentEditedTipCount")) {
            localaqju.jdField_d_of_type_Int = paramArrayOfaptx.getInt("contentEditedTipCount");
          }
          if (paramArrayOfaptx.has("docListEntryInFileSwitch"))
          {
            if (paramArrayOfaptx.getInt("docListEntryInFileSwitch") != 1) {
              break label601;
            }
            bool1 = true;
            localaqju.jdField_g_of_type_Boolean = bool1;
          }
          if (paramArrayOfaptx.has("hideDocAuthoritySettingEntry"))
          {
            bool1 = bool2;
            if (paramArrayOfaptx.getInt("hideDocAuthoritySettingEntry") == 1) {
              bool1 = true;
            }
            localaqju.jdField_h_of_type_Boolean = bool1;
          }
          if (paramArrayOfaptx.has("docListUrl")) {
            localaqju.jdField_h_of_type_JavaLangString = paramArrayOfaptx.getString("docListUrl");
          }
          if (paramArrayOfaptx.has("editSupport"))
          {
            paramArrayOfaptx = paramArrayOfaptx.getJSONObject("editSupport");
            Iterator localIterator = paramArrayOfaptx.keys();
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              localaqju.jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(paramArrayOfaptx.getLong(str)));
              continue;
            }
          }
        }
        return localaqju;
      }
      catch (JSONException paramArrayOfaptx)
      {
        QLog.e("TencentDocConvertConfigBean", 1, paramArrayOfaptx.getLocalizedMessage(), paramArrayOfaptx);
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
 * Qualified Name:     aqju
 * JD-Core Version:    0.7.0.1
 */