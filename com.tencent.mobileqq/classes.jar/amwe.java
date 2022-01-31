import java.util.HashMap;
import org.json.JSONObject;

public class amwe
{
  private HashMap<String, amwf> a = new HashMap();
  
  public amwe()
  {
    amwf localamwf = new amwf();
    localamwf.a(true);
    localamwf.a("pages/detail/detail");
    this.a.put("s_qq_mini_importing", localamwf);
  }
  
  public static amwe a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0)) {
      return null;
    }
    for (;;)
    {
      amwe localamwe;
      int i;
      JSONObject localJSONObject;
      try
      {
        localamwe = new amwe();
        i = 0;
        if (i >= paramArrayOfampi.length) {
          break label516;
        }
        localJSONObject = new JSONObject(paramArrayOfampi[i].a);
        if (localJSONObject.has("MiniCodeConfigAioMsg"))
        {
          localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioMsg");
          localamwe.a.put("docs_miniapp_config_aio_msg", amwf.a(localJSONObject));
        }
        else if (localJSONObject.has("MiniCodeConfigAioEdit"))
        {
          localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioEdit");
          localamwe.a.put("docs_miniapp_config_aio_edit", amwf.a(localJSONObject));
        }
      }
      catch (Exception paramArrayOfampi)
      {
        paramArrayOfampi.printStackTrace();
        return null;
      }
      if (localJSONObject.has("MiniCodeConfigBottomEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigBottomEdit");
        localamwe.a.put("docs_miniapp_config_bottom_edit", amwf.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigMyFile"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigMyFile");
        localamwe.a.put("docs_miniapp_config_my_file", amwf.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigTroopFile"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigTroopFile");
        localamwe.a.put("docs_miniapp_config_troop_file", amwf.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigGrayBar"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigGrayBar");
        localamwe.a.put("docs_miniapp_config_gray_bar", amwf.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigMenuEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigMenuEdit");
        localamwe.a.put("docs_miniapp_config_menu_edit", amwf.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigDownloadEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigDownloadEdit");
        localamwe.a.put("docs_miniapp_config_download_edit", amwf.a(localJSONObject));
      }
      else if (localJSONObject.has("docs_miniapp_config_online_preview"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("docs_miniapp_config_online_preview");
        localamwe.a.put("docs_miniapp_config_online_preview", amwf.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigTemplateList"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigTemplateList");
        localamwe.a.put("docs_miniapp_config_templatelist", amwf.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigOcrSave"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigOcrSave");
        localamwe.a.put("docs_miniapp_config_ocr_save", amwf.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigUrl2Doc"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigUrl2Doc");
        localamwe.a.put("docs_miniapp_config_url_2_doc", amwf.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigAioArkH5"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioArkH5");
        localamwe.a.put("docs_miniapp_config_aio_ark_h5", amwf.a(localJSONObject));
        break label518;
        label516:
        return localamwe;
      }
      label518:
      i += 1;
    }
  }
  
  public HashMap<String, amwf> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amwe
 * JD-Core Version:    0.7.0.1
 */