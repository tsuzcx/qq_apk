import com.tencent.qq.effect.engine.QEffectEngine.JsonConvert;

public class azoj
  implements QEffectEngine.JsonConvert
{
  public <T> T parseArray(String paramString, Class paramClass)
  {
    return atgx.a(paramString, new azok(this).getClass().getGenericSuperclass());
  }
  
  public <T> T parseObject(String paramString, Class paramClass)
  {
    return atgx.a(paramString, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azoj
 * JD-Core Version:    0.7.0.1
 */