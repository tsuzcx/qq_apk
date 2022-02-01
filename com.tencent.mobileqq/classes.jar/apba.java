import com.tencent.qphone.base.util.QLog;

public class apba
{
  private static apba a;
  
  public static apba a()
  {
    if (a == null) {
      a = new apba();
    }
    return a;
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARDebugReport", 2, String.format("AR_选图_单帧耗时 timeCost=%sms", new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARDebugReport", 2, String.format("AR_选图_启动累计耗时 timeCost=%sms", new Object[] { Long.valueOf(paramLong2 - paramLong1) }));
    }
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARDebugReport", 2, String.format("AR_识别_单帧耗时 timeCost=%sms", new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARDebugReport", 2, String.format("AR_追踪_单帧耗时 timeCost=%sms", new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public void d(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARDebugReport", 2, String.format("人脸_特征提取_单帧耗时 time cost=%sms", new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public void e(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARDebugReport", 2, String.format("人脸_追踪_单帧耗时 time cost=%sms", new Object[] { Long.valueOf(paramLong) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apba
 * JD-Core Version:    0.7.0.1
 */