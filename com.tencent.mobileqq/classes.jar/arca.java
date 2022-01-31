import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class arca
  implements INetInfoHandler
{
  arca(arbz paramarbz) {}
  
  public void onNetMobile2None()
  {
    Iterator localIterator = arbz.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((arcc)localIterator.next()).a(5);
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoItemEventManager", 2, "onNetMobile2None onConnClose");
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    paramString = arbz.a(this.a).iterator();
    while (paramString.hasNext()) {
      ((arcc)paramString.next()).a(4);
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoItemEventManager", 2, "onNetMobile2Wifi onConnOK");
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    paramString = arbz.a(this.a).iterator();
    while (paramString.hasNext()) {
      ((arcc)paramString.next()).a(3);
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoItemEventManager", 2, "onNetNone2Mobile onConnOK");
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    paramString = arbz.a(this.a).iterator();
    while (paramString.hasNext()) {
      ((arcc)paramString.next()).a(2);
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoItemEventManager", 2, "onNetNone2Wifi onConnOK");
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    paramString = arbz.a(this.a).iterator();
    while (paramString.hasNext()) {
      ((arcc)paramString.next()).a(1);
    }
  }
  
  public void onNetWifi2None()
  {
    Iterator localIterator = arbz.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((arcc)localIterator.next()).a(0);
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoItemEventManager", 2, "onNetWifi2None onConnClose");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arca
 * JD-Core Version:    0.7.0.1
 */