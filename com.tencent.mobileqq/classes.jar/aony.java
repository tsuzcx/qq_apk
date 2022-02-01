import com.tencent.ark.open.ArkView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aony
{
  private List<ArkView> a = new ArrayList();
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ArkView localArkView = (ArkView)localIterator.next();
      if (localArkView != null) {
        localArkView.onDestroy();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkCollector", 2, this.a.size() + " ArkViews onDestroy");
    }
    this.a.clear();
  }
  
  public void a(ArkView paramArkView)
  {
    this.a.add(paramArkView);
  }
  
  public void b()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ArkView localArkView = (ArkView)localIterator.next();
      if (localArkView != null) {
        localArkView.onPause();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkCollector", 2, this.a.size() + " ArkViews onPause");
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ArkView localArkView = (ArkView)localIterator.next();
      if (localArkView != null) {
        localArkView.onResume();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkCollector", 2, this.a.size() + " ArkViews onResume");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aony
 * JD-Core Version:    0.7.0.1
 */