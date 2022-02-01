import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAllFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

public class asxw
  extends atwn
{
  public asxw(QfileRecentAllFileTabView paramQfileRecentAllFileTabView) {}
  
  public void a()
  {
    this.a.a.a().b();
  }
  
  public void b()
  {
    this.a.a.a().o();
  }
  
  public void c()
  {
    this.a.a.a().p();
  }
  
  public void d()
  {
    this.a.a.a().q();
    Object localObject = athc.b();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (atha.a(((FileManagerEntity)((Iterator)localObject).next()).Uuid)) {
          bcst.b(QfileRecentAllFileTabView.b(this.a), "dc00898", "", "", "0X800A087", "0X800A087", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void e()
  {
    this.a.a.a().r();
  }
  
  public void f()
  {
    this.a.a.a().E();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxw
 * JD-Core Version:    0.7.0.1
 */