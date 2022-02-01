import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.mobileqq.richmedia.dc.DataReport.ReportTask;

public class bbkd
  extends bbkp
{
  private bbkf a;
  private boolean b;
  
  public bbkd(Context paramContext)
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
      bbkf localbbkf = new bbkf(null);
      bbkf.a(localbbkf, paramBoolean);
      bbkf.a(localbbkf, SystemClock.uptimeMillis());
      this.a = localbbkf;
    }
  }
  
  public void b()
  {
    if ((this.a != null) && (!this.b)) {
      bbkf.b(this.a, SystemClock.uptimeMillis());
    }
  }
  
  public void c()
  {
    if ((this.a != null) && (!this.b)) {
      bbkf.c(this.a, SystemClock.uptimeMillis());
    }
  }
  
  public void d()
  {
    if ((this.a != null) && (!this.b)) {
      bbkf.b(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkd
 * JD-Core Version:    0.7.0.1
 */