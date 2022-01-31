import com.dataline.activities.PrinterActivity;
import com.tencent.mobileqq.app.DataLineObserver;

public class ck
  extends DataLineObserver
{
  public ck(PrinterActivity paramPrinterActivity) {}
  
  protected void a(Object paramObject, boolean paramBoolean)
  {
    if ((paramBoolean) && (PrinterActivity.a(this.a))) {
      PrinterActivity.a(this.a, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ck
 * JD-Core Version:    0.7.0.1
 */