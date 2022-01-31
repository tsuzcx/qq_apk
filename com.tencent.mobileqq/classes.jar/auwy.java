import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.mobileqq.richmedia.dc.DataReport.ReportTask;

public class auwy
  extends auxk
{
  private auxa a;
  private boolean b;
  
  public auwy(Context paramContext)
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
      auxa localauxa = new auxa(null);
      auxa.a(localauxa, paramBoolean);
      auxa.a(localauxa, SystemClock.uptimeMillis());
      this.a = localauxa;
    }
  }
  
  public void b()
  {
    if ((this.a != null) && (!this.b)) {
      auxa.b(this.a, SystemClock.uptimeMillis());
    }
  }
  
  public void c()
  {
    if ((this.a != null) && (!this.b)) {
      auxa.c(this.a, SystemClock.uptimeMillis());
    }
  }
  
  public void d()
  {
    if ((this.a != null) && (!this.b)) {
      auxa.b(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     auwy
 * JD-Core Version:    0.7.0.1
 */