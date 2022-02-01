import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

public class bqyx
  extends bqcp
{
  private View a;
  
  public bqyx(@NonNull bqgk parambqgk)
  {
    super(parambqgk);
  }
  
  public void a()
  {
    super.a();
    this.a = a(2131375455);
    ((Button)a(2131366862)).setOnClickListener(new bqyy(this));
  }
  
  protected boolean a(Message paramMessage)
  {
    if (paramMessage.arg1 == 1) {
      this.a.setVisibility(8);
    }
    return super.a(paramMessage);
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    super.a_(paramInt, paramObject);
    paramObject = this.a;
    if ((paramInt == 0) || (paramInt == 7)) {}
    for (paramInt = 0;; paramInt = 8)
    {
      paramObject.setVisibility(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqyx
 * JD-Core Version:    0.7.0.1
 */