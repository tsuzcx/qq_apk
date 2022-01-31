import java.util.HashMap;
import org.json.JSONObject;

public class amwd
{
  private HashMap<String, amwe> a = new HashMap();
  
  public amwd()
  {
    amwe localamwe = new amwe();
    localamwe.a(true);
    localamwe.a("pages/detail/detail");
    this.a.put("s_qq_mini_importing", localamwe);
  }
  
  public static amwd a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0)) {
      return null;
    }
    for (;;)
    {
      amwd localamwd;
      int i;
      JSONObject localJSONObject;
      try
      {
        localamwd = new amwd();
        i = 0;
        if (i >= paramArrayOfamph.length) {
          break label516;
        }
        localJSONObject = new JSONObject(paramArrayOfamph[i].a);
        if (localJSONObject.has("MiniCodeConfigAioMsg"))
        {
          localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioMsg");
          localamwd.a.put("docs_miniapp_config_aio_msg", amwe.a(localJSONObject));
        }
        else if (localJSONObject.has("MiniCodeConfigAioEdit"))
        {
          localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioEdit");
          localamwd.a.put("docs_miniapp_config_aio_edit", amwe.a(localJSONObject));
        }
      }
      catch (Exception paramArrayOfamph)
      {
        paramArrayOfamph.printStackTrace();
        return null;
      }
      if (localJSONObject.has("MiniCodeConfigBottomEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigBottomEdit");
        localamwd.a.put("docs_miniapp_config_bottom_edit", amwe.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigMyFile"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigMyFile");
        localamwd.a.put("docs_miniapp_config_my_file", amwe.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigTroopFile"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigTroopFile");
        localamwd.a.put("docs_miniapp_config_troop_file", amwe.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigGrayBar"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigGrayBar");
        localamwd.a.put("docs_miniapp_config_gray_bar", amwe.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigMenuEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigMenuEdit");
        localamwd.a.put("docs_miniapp_config_menu_edit", amwe.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigDownloadEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigDownloadEdit");
        localamwd.a.put("docs_miniapp_config_download_edit", amwe.a(localJSONObject));
      }
      else if (localJSONObject.has("docs_miniapp_config_online_preview"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("docs_miniapp_config_online_preview");
        localamwd.a.put("docs_miniapp_config_online_preview", amwe.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigTemplateList"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigTemplateList");
        localamwd.a.put("docs_miniapp_config_templatelist", amwe.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigOcrSave"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigOcrSave");
        localamwd.a.put("docs_miniapp_config_ocr_save", amwe.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigUrl2Doc"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigUrl2Doc");
        localamwd.a.put("docs_miniapp_config_url_2_doc", amwe.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigAioArkH5"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioArkH5");
        localamwd.a.put("docs_miniapp_config_aio_ark_h5", amwe.a(localJSONObject));
        break label518;
        label516:
        return localamwd;
      }
      label518:
      i += 1;
    }
  }
  
  public HashMap<String, amwe> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amwd
 * JD-Core Version:    0.7.0.1
 */