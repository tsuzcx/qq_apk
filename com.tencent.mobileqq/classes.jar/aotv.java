import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentTDocFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

public class aotv
  extends apvd
{
  public aotv(QfileRecentTDocFileTabView paramQfileRecentTDocFileTabView) {}
  
  public void a() {}
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e()
  {
    Object localObject = apeh.b();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (apef.a(((FileManagerEntity)((Iterator)localObject).next()).Uuid)) {
          axqw.b(QfileRecentTDocFileTabView.b(this.a), "dc00898", "", "", "0X800A08C", "0X800A08C", 0, 0, "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aotv
 * JD-Core Version:    0.7.0.1
 */