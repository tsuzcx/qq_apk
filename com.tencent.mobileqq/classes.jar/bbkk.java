import java.util.HashMap;

public class bbkk
  extends bbkj
{
  public HashMap<String, String> a(String paramString)
  {
    if ("ShortVideo.Save".equals(paramString))
    {
      paramString = new HashMap();
      paramString.put("param_uinType", this.b + "");
      paramString.put("param_GroupMemberCount", this.c + "");
      paramString.put("param_age", this.d + "");
      paramString.put("param_gender", this.e + "");
      paramString.put("param_shortVideoType", this.f + "");
      paramString.put("param_reportHour", this.g + "");
      paramString.put("param_netType", this.h + "");
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkk
 * JD-Core Version:    0.7.0.1
 */