import java.util.HashMap;

public class bbjx
  extends bbjz
{
  public long a = 0L;
  public long b;
  
  public bbjx()
  {
    this.jdField_b_of_type_Long = -1L;
  }
  
  public HashMap<String, String> a(String paramString)
  {
    if ("ShortVideo.FullscreenPreview".equals(paramString))
    {
      paramString = new HashMap();
      paramString.put("param_uinType", this.jdField_b_of_type_Int + "");
      paramString.put("param_GroupMemberCount", this.c + "");
      paramString.put("param_age", this.d + "");
      paramString.put("param_gender", this.e + "");
      paramString.put("param_shortVideoType", this.f + "");
      paramString.put("param_duration", this.a + "");
      paramString.put("param_reportHour", this.g + "");
      paramString.put("param_netType", this.h + "");
      paramString.put("param_playTimeCost", this.jdField_b_of_type_Long + "");
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbjx
 * JD-Core Version:    0.7.0.1
 */