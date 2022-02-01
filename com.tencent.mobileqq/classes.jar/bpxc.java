import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

public class bpxc
  extends bpau
{
  private View a;
  
  public bpxc(@NonNull bpep parambpep)
  {
    super(parambpep);
  }
  
  public void a()
  {
    super.a();
    this.a = a(2131375318);
    ((Button)a(2131366811)).setOnClickListener(new bpxd(this));
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
 * Qualified Name:     bpxc
 * JD-Core Version:    0.7.0.1
 */