import java.util.HashMap;
import org.json.JSONObject;

public class amga
{
  private HashMap<String, amgb> a = new HashMap();
  
  public amga()
  {
    amgb localamgb = new amgb();
    localamgb.a(true);
    localamgb.a("pages/detail/detail");
    this.a.put("s_qq_mini_importing", localamgb);
  }
  
  public static amga a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0)) {
      return null;
    }
    for (;;)
    {
      amga localamga;
      int i;
      JSONObject localJSONObject;
      try
      {
        localamga = new amga();
        i = 0;
        if (i >= paramArrayOfalzs.length) {
          break label480;
        }
        localJSONObject = new JSONObject(paramArrayOfalzs[i].a);
        if (localJSONObject.has("MiniCodeConfigAioMsg"))
        {
          localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioMsg");
          localamga.a.put("docs_miniapp_config_aio_msg", amgb.a(localJSONObject));
        }
        else if (localJSONObject.has("MiniCodeConfigAioEdit"))
        {
          localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioEdit");
          localamga.a.put("docs_miniapp_config_aio_edit", amgb.a(localJSONObject));
        }
      }
      catch (Exception paramArrayOfalzs)
      {
        paramArrayOfalzs.printStackTrace();
        return null;
      }
      if (localJSONObject.has("MiniCodeConfigBottomEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigBottomEdit");
        localamga.a.put("docs_miniapp_config_bottom_edit", amgb.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigMyFile"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigMyFile");
        localamga.a.put("docs_miniapp_config_my_file", amgb.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigTroopFile"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigTroopFile");
        localamga.a.put("docs_miniapp_config_troop_file", amgb.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigGrayBar"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigGrayBar");
        localamga.a.put("docs_miniapp_config_gray_bar", amgb.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigMenuEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigMenuEdit");
        localamga.a.put("docs_miniapp_config_menu_edit", amgb.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigDownloadEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigDownloadEdit");
        localamga.a.put("docs_miniapp_config_download_edit", amgb.a(localJSONObject));
      }
      else if (localJSONObject.has("docs_miniapp_config_online_preview"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("docs_miniapp_config_online_preview");
        localamga.a.put("docs_miniapp_config_online_preview", amgb.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigTemplateList"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigTemplateList");
        localamga.a.put("docs_miniapp_config_templatelist", amgb.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigOcrSave"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigOcrSave");
        localamga.a.put("docs_miniapp_config_ocr_save", amgb.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigUrl2Doc"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigUrl2Doc");
        localamga.a.put("docs_miniapp_config_url_2_doc", amgb.a(localJSONObject));
        break label482;
        label480:
        return localamga;
      }
      label482:
      i += 1;
    }
  }
  
  public HashMap<String, amgb> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amga
 * JD-Core Version:    0.7.0.1
 */