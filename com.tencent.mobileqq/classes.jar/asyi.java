import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentTDocFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

public class asyi
  extends atwn
{
  public asyi(QfileRecentTDocFileTabView paramQfileRecentTDocFileTabView) {}
  
  public void a() {}
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    Object localObject = athc.b();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (atha.a(((FileManagerEntity)((Iterator)localObject).next()).Uuid)) {
          bcst.b(QfileRecentTDocFileTabView.b(this.a), "dc00898", "", "", "0X800A08C", "0X800A08C", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void e() {}
  
  public void f()
  {
    this.a.a.a().E();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyi
 * JD-Core Version:    0.7.0.1
 */