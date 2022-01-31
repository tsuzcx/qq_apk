import java.util.HashMap;

public class avxa
  extends avxc
{
  public int a;
  public long a;
  public boolean a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public HashMap<String, String> a(String paramString)
  {
    if ("actStreamingVideoPlay".equalsIgnoreCase(paramString))
    {
      paramString = new HashMap();
      paramString.put("StreamingVideoSupport", String.valueOf(this.jdField_a_of_type_Boolean));
      paramString.put("FirstBufferTime", String.valueOf(this.jdField_a_of_type_Int));
      paramString.put("PlayProgress", String.valueOf(this.b));
      paramString.put("LoadProgress", String.valueOf(this.c));
      paramString.put("FileDuration", String.valueOf(this.d));
      paramString.put("FileLen", String.valueOf(this.e));
      paramString.put("param_seekTimes", String.valueOf(this.f));
      paramString.put("PlayResult", String.valueOf(this.g));
      paramString.put("param_playTimeCost", String.valueOf(this.jdField_a_of_type_Long));
      return paramString;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("supportProgressive ").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("playReadyTime ").append(this.jdField_a_of_type_Int);
    localStringBuilder.append("exitPlayProgress ").append(this.b);
    localStringBuilder.append("exitCacheProgress ").append(this.c);
    localStringBuilder.append("durationTime ").append(this.d);
    localStringBuilder.append("fileSize ").append(this.e);
    localStringBuilder.append("seekTimes ").append(this.f);
    localStringBuilder.append("playResult ").append(this.g);
    localStringBuilder.append("playTimeCost").append(this.jdField_a_of_type_Long);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avxa
 * JD-Core Version:    0.7.0.1
 */