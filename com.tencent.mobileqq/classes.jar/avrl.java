import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import java.util.concurrent.ConcurrentHashMap;

public class avrl
{
  public ConcurrentHashMap<String, avra> a = new ConcurrentHashMap(10);
  
  public avra a(SVHwEncoder paramSVHwEncoder, SessionInfo paramSessionInfo, int paramInt)
  {
    paramSVHwEncoder = new avra(paramSVHwEncoder, paramSessionInfo, paramInt);
    this.a.put(paramSVHwEncoder.a, paramSVHwEncoder);
    avrf.a("VideoCompoundController", "newProcessor, key = " + paramSVHwEncoder.a);
    return paramSVHwEncoder;
  }
  
  public avra a(String paramString)
  {
    avrf.a("VideoCompoundController", "findProcessor, key = " + paramString);
    if ((!this.a.isEmpty()) && (paramString != null) && (this.a.containsKey(paramString))) {
      return (avra)this.a.get(paramString);
    }
    return null;
  }
  
  public boolean a(String paramString)
  {
    avrf.a("VideoCompoundController", "removeProcessor, key = " + paramString);
    if (paramString == null) {}
    while (this.a.remove(paramString) == null) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avrl
 * JD-Core Version:    0.7.0.1
 */