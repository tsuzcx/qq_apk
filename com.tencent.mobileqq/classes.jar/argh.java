import java.util.HashMap;
import org.json.JSONObject;

public class argh
{
  private HashMap<String, argi> a = new HashMap();
  
  public argh()
  {
    argi localargi = new argi();
    localargi.a(true);
    localargi.a("pages/detail/detail");
    this.a.put("s_qq_mini_importing", localargi);
  }
  
  public static argh a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
      return null;
    }
    for (;;)
    {
      argh localargh;
      int i;
      JSONObject localJSONObject;
      try
      {
        localargh = new argh();
        i = 0;
        if (i >= paramArrayOfaqxa.length) {
          break label516;
        }
        localJSONObject = new JSONObject(paramArrayOfaqxa[i].a);
        if (localJSONObject.has("MiniCodeConfigAioMsg"))
        {
          localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioMsg");
          localargh.a.put("docs_miniapp_config_aio_msg", argi.a(localJSONObject));
        }
        else if (localJSONObject.has("MiniCodeConfigAioEdit"))
        {
          localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioEdit");
          localargh.a.put("docs_miniapp_config_aio_edit", argi.a(localJSONObject));
        }
      }
      catch (Exception paramArrayOfaqxa)
      {
        paramArrayOfaqxa.printStackTrace();
        return null;
      }
      if (localJSONObject.has("MiniCodeConfigBottomEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigBottomEdit");
        localargh.a.put("docs_miniapp_config_bottom_edit", argi.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigMyFile"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigMyFile");
        localargh.a.put("docs_miniapp_config_my_file", argi.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigTroopFile"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigTroopFile");
        localargh.a.put("docs_miniapp_config_troop_file", argi.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigGrayBar"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigGrayBar");
        localargh.a.put("docs_miniapp_config_gray_bar", argi.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigMenuEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigMenuEdit");
        localargh.a.put("docs_miniapp_config_menu_edit", argi.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigDownloadEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigDownloadEdit");
        localargh.a.put("docs_miniapp_config_download_edit", argi.a(localJSONObject));
      }
      else if (localJSONObject.has("docs_miniapp_config_online_preview"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("docs_miniapp_config_online_preview");
        localargh.a.put("docs_miniapp_config_online_preview", argi.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigTemplateList"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigTemplateList");
        localargh.a.put("docs_miniapp_config_templatelist", argi.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigOcrSave"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigOcrSave");
        localargh.a.put("docs_miniapp_config_ocr_save", argi.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigUrl2Doc"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigUrl2Doc");
        localargh.a.put("docs_miniapp_config_url_2_doc", argi.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigAioArkH5"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioArkH5");
        localargh.a.put("docs_miniapp_config_aio_ark_h5", argi.a(localJSONObject));
        break label518;
        label516:
        return localargh;
      }
      label518:
      i += 1;
    }
  }
  
  public HashMap<String, argi> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argh
 * JD-Core Version:    0.7.0.1
 */