import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import java.util.concurrent.ConcurrentHashMap;

public class bbfx
{
  public ConcurrentHashMap<String, bbfm> a = new ConcurrentHashMap(10);
  
  public bbfm a(SVHwEncoder paramSVHwEncoder, SessionInfo paramSessionInfo, int paramInt)
  {
    paramSVHwEncoder = new bbfm(paramSVHwEncoder, paramSessionInfo, paramInt);
    this.a.put(paramSVHwEncoder.a, paramSVHwEncoder);
    bbfr.a("VideoCompoundController", "newProcessor, key = " + paramSVHwEncoder.a);
    return paramSVHwEncoder;
  }
  
  public bbfm a(String paramString)
  {
    bbfr.a("VideoCompoundController", "findProcessor, key = " + paramString);
    if ((!this.a.isEmpty()) && (paramString != null) && (this.a.containsKey(paramString))) {
      return (bbfm)this.a.get(paramString);
    }
    return null;
  }
  
  public boolean a(String paramString)
  {
    bbfr.a("VideoCompoundController", "removeProcessor, key = " + paramString);
    if (paramString == null) {}
    while (this.a.remove(paramString) == null) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfx
 * JD-Core Version:    0.7.0.1
 */