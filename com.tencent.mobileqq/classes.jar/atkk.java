import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.lang.ref.WeakReference;

public class atkk
  implements INetInfoHandler
{
  long jdField_a_of_type_Long = 0L;
  private final WeakReference<QQMusicPlayService> jdField_a_of_type_JavaLangRefWeakReference;
  
  public atkk(QQMusicPlayService paramQQMusicPlayService)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQMusicPlayService);
  }
  
  private void a(int paramInt)
  {
    boolean bool2 = true;
    QQMusicPlayService localQQMusicPlayService = (QQMusicPlayService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQMusicPlayService == null) {}
    while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    boolean bool1 = bool2;
    if (paramInt != 1)
    {
      bool1 = bool2;
      if (paramInt != 2)
      {
        bool1 = bool2;
        if (paramInt != 3) {
          if (paramInt != 6) {
            break label78;
          }
        }
      }
    }
    label78:
    for (bool1 = bool2;; bool1 = false)
    {
      QQMusicPlayService.a(localQQMusicPlayService, bool1);
      return;
    }
  }
  
  public void onNetMobile2None()
  {
    a(4);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    a(3);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    a(1);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    a(2);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    a(6);
  }
  
  public void onNetWifi2None()
  {
    a(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atkk
 * JD-Core Version:    0.7.0.1
 */