import java.util.HashMap;
import org.json.JSONObject;

public class aqda
{
  private HashMap<String, aqdb> a = new HashMap();
  
  public aqda()
  {
    aqdb localaqdb = new aqdb();
    localaqdb.a(true);
    localaqdb.a("pages/detail/detail");
    this.a.put("s_qq_mini_importing", localaqdb);
  }
  
  public static aqda a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0)) {
      return null;
    }
    for (;;)
    {
      aqda localaqda;
      int i;
      JSONObject localJSONObject;
      try
      {
        localaqda = new aqda();
        i = 0;
        if (i >= paramArrayOfaptx.length) {
          break label516;
        }
        localJSONObject = new JSONObject(paramArrayOfaptx[i].a);
        if (localJSONObject.has("MiniCodeConfigAioMsg"))
        {
          localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioMsg");
          localaqda.a.put("docs_miniapp_config_aio_msg", aqdb.a(localJSONObject));
        }
        else if (localJSONObject.has("MiniCodeConfigAioEdit"))
        {
          localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioEdit");
          localaqda.a.put("docs_miniapp_config_aio_edit", aqdb.a(localJSONObject));
        }
      }
      catch (Exception paramArrayOfaptx)
      {
        paramArrayOfaptx.printStackTrace();
        return null;
      }
      if (localJSONObject.has("MiniCodeConfigBottomEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigBottomEdit");
        localaqda.a.put("docs_miniapp_config_bottom_edit", aqdb.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigMyFile"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigMyFile");
        localaqda.a.put("docs_miniapp_config_my_file", aqdb.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigTroopFile"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigTroopFile");
        localaqda.a.put("docs_miniapp_config_troop_file", aqdb.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigGrayBar"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigGrayBar");
        localaqda.a.put("docs_miniapp_config_gray_bar", aqdb.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigMenuEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigMenuEdit");
        localaqda.a.put("docs_miniapp_config_menu_edit", aqdb.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigDownloadEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigDownloadEdit");
        localaqda.a.put("docs_miniapp_config_download_edit", aqdb.a(localJSONObject));
      }
      else if (localJSONObject.has("docs_miniapp_config_online_preview"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("docs_miniapp_config_online_preview");
        localaqda.a.put("docs_miniapp_config_online_preview", aqdb.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigTemplateList"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigTemplateList");
        localaqda.a.put("docs_miniapp_config_templatelist", aqdb.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigOcrSave"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigOcrSave");
        localaqda.a.put("docs_miniapp_config_ocr_save", aqdb.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigUrl2Doc"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigUrl2Doc");
        localaqda.a.put("docs_miniapp_config_url_2_doc", aqdb.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigAioArkH5"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioArkH5");
        localaqda.a.put("docs_miniapp_config_aio_ark_h5", aqdb.a(localJSONObject));
        break label518;
        label516:
        return localaqda;
      }
      label518:
      i += 1;
    }
  }
  
  public HashMap<String, aqdb> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqda
 * JD-Core Version:    0.7.0.1
 */