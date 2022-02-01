import java.util.HashMap;
import org.json.JSONObject;

public class aqtv
{
  private HashMap<String, aqtw> a = new HashMap();
  
  public aqtv()
  {
    aqtw localaqtw = new aqtw();
    localaqtw.a(true);
    localaqtw.a("pages/detail/detail");
    this.a.put("s_qq_mini_importing", localaqtw);
  }
  
  public static aqtv a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0)) {
      return null;
    }
    for (;;)
    {
      aqtv localaqtv;
      int i;
      JSONObject localJSONObject;
      try
      {
        localaqtv = new aqtv();
        i = 0;
        if (i >= paramArrayOfaqlg.length) {
          break label516;
        }
        localJSONObject = new JSONObject(paramArrayOfaqlg[i].a);
        if (localJSONObject.has("MiniCodeConfigAioMsg"))
        {
          localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioMsg");
          localaqtv.a.put("docs_miniapp_config_aio_msg", aqtw.a(localJSONObject));
        }
        else if (localJSONObject.has("MiniCodeConfigAioEdit"))
        {
          localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioEdit");
          localaqtv.a.put("docs_miniapp_config_aio_edit", aqtw.a(localJSONObject));
        }
      }
      catch (Exception paramArrayOfaqlg)
      {
        paramArrayOfaqlg.printStackTrace();
        return null;
      }
      if (localJSONObject.has("MiniCodeConfigBottomEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigBottomEdit");
        localaqtv.a.put("docs_miniapp_config_bottom_edit", aqtw.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigMyFile"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigMyFile");
        localaqtv.a.put("docs_miniapp_config_my_file", aqtw.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigTroopFile"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigTroopFile");
        localaqtv.a.put("docs_miniapp_config_troop_file", aqtw.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigGrayBar"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigGrayBar");
        localaqtv.a.put("docs_miniapp_config_gray_bar", aqtw.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigMenuEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigMenuEdit");
        localaqtv.a.put("docs_miniapp_config_menu_edit", aqtw.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigDownloadEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigDownloadEdit");
        localaqtv.a.put("docs_miniapp_config_download_edit", aqtw.a(localJSONObject));
      }
      else if (localJSONObject.has("docs_miniapp_config_online_preview"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("docs_miniapp_config_online_preview");
        localaqtv.a.put("docs_miniapp_config_online_preview", aqtw.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigTemplateList"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigTemplateList");
        localaqtv.a.put("docs_miniapp_config_templatelist", aqtw.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigOcrSave"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigOcrSave");
        localaqtv.a.put("docs_miniapp_config_ocr_save", aqtw.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigUrl2Doc"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigUrl2Doc");
        localaqtv.a.put("docs_miniapp_config_url_2_doc", aqtw.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigAioArkH5"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioArkH5");
        localaqtv.a.put("docs_miniapp_config_aio_ark_h5", aqtw.a(localJSONObject));
        break label518;
        label516:
        return localaqtv;
      }
      label518:
      i += 1;
    }
  }
  
  public HashMap<String, aqtw> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqtv
 * JD-Core Version:    0.7.0.1
 */