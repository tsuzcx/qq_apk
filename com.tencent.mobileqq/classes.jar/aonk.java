import java.util.HashMap;
import org.json.JSONObject;

public class aonk
{
  private HashMap<String, aonl> a = new HashMap();
  
  public aonk()
  {
    aonl localaonl = new aonl();
    localaonl.a(true);
    localaonl.a("pages/detail/detail");
    this.a.put("s_qq_mini_importing", localaonl);
  }
  
  public static aonk a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0)) {
      return null;
    }
    for (;;)
    {
      aonk localaonk;
      int i;
      JSONObject localJSONObject;
      try
      {
        localaonk = new aonk();
        i = 0;
        if (i >= paramArrayOfaogf.length) {
          break label516;
        }
        localJSONObject = new JSONObject(paramArrayOfaogf[i].a);
        if (localJSONObject.has("MiniCodeConfigAioMsg"))
        {
          localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioMsg");
          localaonk.a.put("docs_miniapp_config_aio_msg", aonl.a(localJSONObject));
        }
        else if (localJSONObject.has("MiniCodeConfigAioEdit"))
        {
          localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioEdit");
          localaonk.a.put("docs_miniapp_config_aio_edit", aonl.a(localJSONObject));
        }
      }
      catch (Exception paramArrayOfaogf)
      {
        paramArrayOfaogf.printStackTrace();
        return null;
      }
      if (localJSONObject.has("MiniCodeConfigBottomEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigBottomEdit");
        localaonk.a.put("docs_miniapp_config_bottom_edit", aonl.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigMyFile"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigMyFile");
        localaonk.a.put("docs_miniapp_config_my_file", aonl.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigTroopFile"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigTroopFile");
        localaonk.a.put("docs_miniapp_config_troop_file", aonl.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigGrayBar"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigGrayBar");
        localaonk.a.put("docs_miniapp_config_gray_bar", aonl.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigMenuEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigMenuEdit");
        localaonk.a.put("docs_miniapp_config_menu_edit", aonl.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigDownloadEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigDownloadEdit");
        localaonk.a.put("docs_miniapp_config_download_edit", aonl.a(localJSONObject));
      }
      else if (localJSONObject.has("docs_miniapp_config_online_preview"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("docs_miniapp_config_online_preview");
        localaonk.a.put("docs_miniapp_config_online_preview", aonl.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigTemplateList"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigTemplateList");
        localaonk.a.put("docs_miniapp_config_templatelist", aonl.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigOcrSave"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigOcrSave");
        localaonk.a.put("docs_miniapp_config_ocr_save", aonl.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigUrl2Doc"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigUrl2Doc");
        localaonk.a.put("docs_miniapp_config_url_2_doc", aonl.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigAioArkH5"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioArkH5");
        localaonk.a.put("docs_miniapp_config_aio_ark_h5", aonl.a(localJSONObject));
        break label518;
        label516:
        return localaonk;
      }
      label518:
      i += 1;
    }
  }
  
  public HashMap<String, aonl> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aonk
 * JD-Core Version:    0.7.0.1
 */