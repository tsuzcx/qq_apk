import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentTDocFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

public class aqmx
  extends aroh
{
  public aqmx(QfileRecentTDocFileTabView paramQfileRecentTDocFileTabView) {}
  
  public void a() {}
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e()
  {
    Object localObject = aqxj.b();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (aqxh.a(((FileManagerEntity)((Iterator)localObject).next()).Uuid)) {
          azmj.b(QfileRecentTDocFileTabView.b(this.a), "dc00898", "", "", "0X800A08C", "0X800A08C", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void f() {}
  
  public void g()
  {
    this.a.a.a().G();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqmx
 * JD-Core Version:    0.7.0.1
 */