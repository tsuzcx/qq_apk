import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

public class biza
  extends bice
{
  private View a;
  
  public biza(@NonNull bigb parambigb)
  {
    super(parambigb);
  }
  
  public void a()
  {
    super.a();
    this.a = a(2131308369);
    ((Button)a(2131300824)).setOnClickListener(new bizb(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biza
 * JD-Core Version:    0.7.0.1
 */