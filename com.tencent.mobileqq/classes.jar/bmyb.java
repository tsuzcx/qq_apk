import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aekit.plugin.core.AIParam;
import com.tencent.aekit.plugin.core.IDetect;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class bmyb
  extends IDetect
{
  private List<String> a = Arrays.asList(new String[] { "NONE" });
  
  public void clear() {}
  
  public Object detect(AIInput paramAIInput, AIParam paramAIParam)
  {
    if (paramAIParam != null)
    {
      paramAIInput = paramAIParam.getModuleParam(AEDetectorType.VOICE_RECOGNIZE.value);
      if ((paramAIInput != null) && (paramAIInput.size() > 0))
      {
        paramAIParam = paramAIInput.get("extrawords");
        if ((paramAIParam instanceof String))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add((String)paramAIParam);
          bnrh.b("-AELimishowTrigger", "触发事件：" + (String)localArrayList.get(0));
          paramAIInput.clear();
          return localArrayList;
        }
      }
    }
    return this.a;
  }
  
  public String getModuleName()
  {
    return AEDetectorType.VOICE_RECOGNIZE.value;
  }
  
  public String getModuleType()
  {
    return AEDetectorType.VOICE_RECOGNIZE.value;
  }
  
  public boolean init()
  {
    return true;
  }
  
  public boolean onModuleInstall(String paramString1, String paramString2)
  {
    return true;
  }
  
  public void onModuleUninstall() {}
  
  public void updateAIAttr(AIAttr paramAIAttr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyb
 * JD-Core Version:    0.7.0.1
 */