import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;

public class annr
  extends Dialog
  implements View.OnClickListener
{
  private anns a;
  
  public annr(@NonNull Context paramContext)
  {
    super(paramContext, 2131755950);
    super.setContentView(2131558655);
    super.setCanceledOnTouchOutside(false);
    super.setCancelable(false);
    super.findViewById(2131363740).setOnClickListener(this);
  }
  
  public void a(anns paramanns)
  {
    this.a = paramanns;
  }
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     annr
 * JD-Core Version:    0.7.0.1
 */