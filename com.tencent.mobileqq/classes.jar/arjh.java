import java.util.HashMap;
import org.json.JSONObject;

public class arjh
{
  private HashMap<String, arji> a = new HashMap();
  
  public arjh()
  {
    arji localarji = new arji();
    localarji.a(true);
    localarji.a("pages/detail/detail");
    this.a.put("s_qq_mini_importing", localarji);
  }
  
  public static arjh a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
      return null;
    }
    for (;;)
    {
      arjh localarjh;
      int i;
      JSONObject localJSONObject;
      try
      {
        localarjh = new arjh();
        i = 0;
        if (i >= paramArrayOfaraj.length) {
          break label516;
        }
        localJSONObject = new JSONObject(paramArrayOfaraj[i].a);
        if (localJSONObject.has("MiniCodeConfigAioMsg"))
        {
          localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioMsg");
          localarjh.a.put("docs_miniapp_config_aio_msg", arji.a(localJSONObject));
        }
        else if (localJSONObject.has("MiniCodeConfigAioEdit"))
        {
          localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioEdit");
          localarjh.a.put("docs_miniapp_config_aio_edit", arji.a(localJSONObject));
        }
      }
      catch (Exception paramArrayOfaraj)
      {
        paramArrayOfaraj.printStackTrace();
        return null;
      }
      if (localJSONObject.has("MiniCodeConfigBottomEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigBottomEdit");
        localarjh.a.put("docs_miniapp_config_bottom_edit", arji.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigMyFile"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigMyFile");
        localarjh.a.put("docs_miniapp_config_my_file", arji.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigTroopFile"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigTroopFile");
        localarjh.a.put("docs_miniapp_config_troop_file", arji.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigGrayBar"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigGrayBar");
        localarjh.a.put("docs_miniapp_config_gray_bar", arji.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigMenuEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigMenuEdit");
        localarjh.a.put("docs_miniapp_config_menu_edit", arji.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigDownloadEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigDownloadEdit");
        localarjh.a.put("docs_miniapp_config_download_edit", arji.a(localJSONObject));
      }
      else if (localJSONObject.has("docs_miniapp_config_online_preview"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("docs_miniapp_config_online_preview");
        localarjh.a.put("docs_miniapp_config_online_preview", arji.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigTemplateList"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigTemplateList");
        localarjh.a.put("docs_miniapp_config_templatelist", arji.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigOcrSave"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigOcrSave");
        localarjh.a.put("docs_miniapp_config_ocr_save", arji.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigUrl2Doc"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigUrl2Doc");
        localarjh.a.put("docs_miniapp_config_url_2_doc", arji.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigAioArkH5"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioArkH5");
        localarjh.a.put("docs_miniapp_config_aio_ark_h5", arji.a(localJSONObject));
        break label518;
        label516:
        return localarjh;
      }
      label518:
      i += 1;
    }
  }
  
  public HashMap<String, arji> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arjh
 * JD-Core Version:    0.7.0.1
 */