import java.util.HashMap;
import org.json.JSONObject;

public class aort
{
  private HashMap<String, aoru> a = new HashMap();
  
  public aort()
  {
    aoru localaoru = new aoru();
    localaoru.a(true);
    localaoru.a("pages/detail/detail");
    this.a.put("s_qq_mini_importing", localaoru);
  }
  
  public static aort a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0)) {
      return null;
    }
    for (;;)
    {
      aort localaort;
      int i;
      JSONObject localJSONObject;
      try
      {
        localaort = new aort();
        i = 0;
        if (i >= paramArrayOfaoko.length) {
          break label516;
        }
        localJSONObject = new JSONObject(paramArrayOfaoko[i].a);
        if (localJSONObject.has("MiniCodeConfigAioMsg"))
        {
          localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioMsg");
          localaort.a.put("docs_miniapp_config_aio_msg", aoru.a(localJSONObject));
        }
        else if (localJSONObject.has("MiniCodeConfigAioEdit"))
        {
          localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioEdit");
          localaort.a.put("docs_miniapp_config_aio_edit", aoru.a(localJSONObject));
        }
      }
      catch (Exception paramArrayOfaoko)
      {
        paramArrayOfaoko.printStackTrace();
        return null;
      }
      if (localJSONObject.has("MiniCodeConfigBottomEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigBottomEdit");
        localaort.a.put("docs_miniapp_config_bottom_edit", aoru.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigMyFile"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigMyFile");
        localaort.a.put("docs_miniapp_config_my_file", aoru.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigTroopFile"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigTroopFile");
        localaort.a.put("docs_miniapp_config_troop_file", aoru.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigGrayBar"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigGrayBar");
        localaort.a.put("docs_miniapp_config_gray_bar", aoru.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigMenuEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigMenuEdit");
        localaort.a.put("docs_miniapp_config_menu_edit", aoru.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigDownloadEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigDownloadEdit");
        localaort.a.put("docs_miniapp_config_download_edit", aoru.a(localJSONObject));
      }
      else if (localJSONObject.has("docs_miniapp_config_online_preview"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("docs_miniapp_config_online_preview");
        localaort.a.put("docs_miniapp_config_online_preview", aoru.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigTemplateList"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigTemplateList");
        localaort.a.put("docs_miniapp_config_templatelist", aoru.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigOcrSave"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigOcrSave");
        localaort.a.put("docs_miniapp_config_ocr_save", aoru.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigUrl2Doc"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigUrl2Doc");
        localaort.a.put("docs_miniapp_config_url_2_doc", aoru.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigAioArkH5"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioArkH5");
        localaort.a.put("docs_miniapp_config_aio_ark_h5", aoru.a(localJSONObject));
        break label518;
        label516:
        return localaort;
      }
      label518:
      i += 1;
    }
  }
  
  public HashMap<String, aoru> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aort
 * JD-Core Version:    0.7.0.1
 */