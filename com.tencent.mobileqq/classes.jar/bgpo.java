import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;

public class bgpo
  extends bgpa
{
  public bgpo(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void setBodyLayoutNoMargin()
  {
    this.rootView.setPadding(0, 0, 0, 0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams();
    localLayoutParams.setMargins(0, 0, 0, 0);
    this.bodyLayout.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgpo
 * JD-Core Version:    0.7.0.1
 */