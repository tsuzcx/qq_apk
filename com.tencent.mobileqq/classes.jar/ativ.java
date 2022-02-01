import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.regex.Pattern;

public class ativ
  extends atiw
{
  public ativ(Pattern paramPattern)
  {
    super(paramPattern);
  }
  
  public static String a(String paramString)
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "EmotionURL", "https://qzonestyle.gtimg.cn/qzone/em/$id@2x.gif#kp=1").replace("$id", paramString);
  }
  
  public HashMap<String, Object> a(int paramInt, boolean paramBoolean, CharSequence paramCharSequence)
  {
    paramCharSequence = new HashMap();
    try
    {
      paramCharSequence.put("emojiUrl", a(this.a.substring(4, this.a.indexOf("[/em]"))));
      paramCharSequence.put("nodeType", Integer.valueOf(atit.e));
      paramCharSequence.put("displayWidth", Double.valueOf(20.0D));
      paramCharSequence.put("displayHeight", Double.valueOf(20.0D));
      return paramCharSequence;
    }
    catch (Exception localException)
    {
      QLog.d(atit.a, 1, localException.getMessage());
    }
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ativ
 * JD-Core Version:    0.7.0.1
 */