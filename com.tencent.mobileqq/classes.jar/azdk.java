import java.util.concurrent.atomic.AtomicLong;

class azdk
  implements azfz
{
  azdk(azdj paramazdj) {}
  
  public int a()
  {
    return 1920000;
  }
  
  public void a(long paramLong)
  {
    azeu.a("AudioNewController", "onRecordFinish, Duration:" + paramLong + ", CacheSize:" + azdj.a(this.a).a());
    if (paramLong > 0L) {
      azdj.a(this.a).set(paramLong);
    }
  }
  
  public void a(String paramString)
  {
    azeu.a("AudioNewController", paramString);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (paramLong > 0L) {
      azdj.a(this.a).set(paramLong);
    }
    int i = azdj.a(this.a, paramArrayOfByte);
    azdj.a(this.a, azdj.a(this.a), i);
  }
  
  public int b()
  {
    return 60000;
  }
  
  public void b(long paramLong)
  {
    azeu.a("AudioNewController", "IRecordEventListener, onRecordStart:" + paramLong);
    azdj.b(this.a, azdj.a(this.a), b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdk
 * JD-Core Version:    0.7.0.1
 */