import com.tencent.qq.effect.engine.QEffectEngine.JsonConvert;

public class bdhr
  implements QEffectEngine.JsonConvert
{
  public <T> T parseArray(String paramString, Class paramClass)
  {
    return avyx.a(paramString, new bdhs(this).getClass().getGenericSuperclass());
  }
  
  public <T> T parseObject(String paramString, Class paramClass)
  {
    return avyx.a(paramString, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdhr
 * JD-Core Version:    0.7.0.1
 */