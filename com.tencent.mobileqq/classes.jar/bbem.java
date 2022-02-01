import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import java.util.concurrent.ConcurrentHashMap;

public class bbem
{
  public ConcurrentHashMap<String, bbeb> a = new ConcurrentHashMap(10);
  
  public bbeb a(SVHwEncoder paramSVHwEncoder, SessionInfo paramSessionInfo, int paramInt)
  {
    paramSVHwEncoder = new bbeb(paramSVHwEncoder, paramSessionInfo, paramInt);
    this.a.put(paramSVHwEncoder.a, paramSVHwEncoder);
    bbeg.a("VideoCompoundController", "newProcessor, key = " + paramSVHwEncoder.a);
    return paramSVHwEncoder;
  }
  
  public bbeb a(String paramString)
  {
    bbeg.a("VideoCompoundController", "findProcessor, key = " + paramString);
    if ((!this.a.isEmpty()) && (paramString != null) && (this.a.containsKey(paramString))) {
      return (bbeb)this.a.get(paramString);
    }
    return null;
  }
  
  public boolean a(String paramString)
  {
    bbeg.a("VideoCompoundController", "removeProcessor, key = " + paramString);
    if (paramString == null) {}
    while (this.a.remove(paramString) == null) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbem
 * JD-Core Version:    0.7.0.1
 */