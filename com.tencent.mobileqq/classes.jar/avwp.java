import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.mobileqq.richmedia.dc.DataReport.ReportTask;

public class avwp
  extends avxb
{
  private avwr a;
  private boolean b;
  
  public avwp(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    if ((this.a != null) && (!this.b))
    {
      DataReport.ReportTask localReportTask = new DataReport.ReportTask("Pic.AioPreview.Progressive", this.a.a("Pic.AioPreview.Progressive"));
      DataReport.a().a(localReportTask);
      this.b = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.a == null) && (!this.b))
    {
      avwr localavwr = new avwr(null);
      avwr.a(localavwr, paramBoolean);
      avwr.a(localavwr, SystemClock.uptimeMillis());
      this.a = localavwr;
    }
  }
  
  public void b()
  {
    if ((this.a != null) && (!this.b)) {
      avwr.b(this.a, SystemClock.uptimeMillis());
    }
  }
  
  public void c()
  {
    if ((this.a != null) && (!this.b)) {
      avwr.c(this.a, SystemClock.uptimeMillis());
    }
  }
  
  public void d()
  {
    if ((this.a != null) && (!this.b)) {
      avwr.b(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avwp
 * JD-Core Version:    0.7.0.1
 */