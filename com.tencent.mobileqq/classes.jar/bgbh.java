import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;

public class bgbh
  extends LinearLayout
{
  public bgbh(QQCustomMenuNoIconLayout paramQQCustomMenuNoIconLayout, Context paramContext)
  {
    super(paramContext);
    setOrientation(0);
  }
  
  private void a(boolean paramBoolean)
  {
    View localView = new View(QQCustomMenuNoIconLayout.a(this.a));
    Resources localResources = QQCustomMenuNoIconLayout.a(this.a).getResources();
    if (paramBoolean)
    {
      i = 2131165804;
      localView.setBackgroundColor(localResources.getColor(i));
      addView(localView, new LinearLayout.LayoutParams(1, -1));
      localView = new View(QQCustomMenuNoIconLayout.a(this.a));
      localResources = QQCustomMenuNoIconLayout.a(this.a).getResources();
      if (!paramBoolean) {
        break label123;
      }
    }
    label123:
    for (int i = 2131165805;; i = 2131165807)
    {
      localView.setBackgroundColor(localResources.getColor(i));
      addView(localView, new LinearLayout.LayoutParams(1, -1));
      return;
      i = 2131165806;
      break;
    }
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramView.setLayoutParams(paramLayoutParams);
    addView(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgbh
 * JD-Core Version:    0.7.0.1
 */