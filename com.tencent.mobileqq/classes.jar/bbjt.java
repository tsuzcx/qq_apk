import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.mobileqq.richmedia.dc.DataReport.ReportTask;

public class bbjt
  extends bbkf
{
  private bbjv a;
  private boolean b;
  
  public bbjt(Context paramContext)
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
      bbjv localbbjv = new bbjv(null);
      bbjv.a(localbbjv, paramBoolean);
      bbjv.a(localbbjv, SystemClock.uptimeMillis());
      this.a = localbbjv;
    }
  }
  
  public void b()
  {
    if ((this.a != null) && (!this.b)) {
      bbjv.b(this.a, SystemClock.uptimeMillis());
    }
  }
  
  public void c()
  {
    if ((this.a != null) && (!this.b)) {
      bbjv.c(this.a, SystemClock.uptimeMillis());
    }
  }
  
  public void d()
  {
    if ((this.a != null) && (!this.b)) {
      bbjv.b(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbjt
 * JD-Core Version:    0.7.0.1
 */