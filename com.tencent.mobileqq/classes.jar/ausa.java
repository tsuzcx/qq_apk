import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import java.util.concurrent.ConcurrentHashMap;

public class ausa
{
  public ConcurrentHashMap<String, aurp> a = new ConcurrentHashMap(10);
  
  public aurp a(SVHwEncoder paramSVHwEncoder, SessionInfo paramSessionInfo, int paramInt)
  {
    paramSVHwEncoder = new aurp(paramSVHwEncoder, paramSessionInfo, paramInt);
    this.a.put(paramSVHwEncoder.a, paramSVHwEncoder);
    auru.a("VideoCompoundController", "newProcessor, key = " + paramSVHwEncoder.a);
    return paramSVHwEncoder;
  }
  
  public aurp a(String paramString)
  {
    auru.a("VideoCompoundController", "findProcessor, key = " + paramString);
    if ((!this.a.isEmpty()) && (paramString != null) && (this.a.containsKey(paramString))) {
      return (aurp)this.a.get(paramString);
    }
    return null;
  }
  
  public boolean a(String paramString)
  {
    auru.a("VideoCompoundController", "removeProcessor, key = " + paramString);
    if (paramString == null) {}
    while (this.a.remove(paramString) == null) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ausa
 * JD-Core Version:    0.7.0.1
 */