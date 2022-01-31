import common.qzone.component.cache.common.SoftHashMap;

public class amqd
  extends amqc
{
  amqd(SoftHashMap paramSoftHashMap)
  {
    super(paramSoftHashMap);
  }
  
  public Object next()
  {
    return a().getKey();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     amqd
 * JD-Core Version:    0.7.0.1
 */