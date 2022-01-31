import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;

public class avxj
  extends avxd
{
  public final ArrayList<avxi> a = new ArrayList();
  
  public avxj(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    LinearLayout localLinearLayout = (LinearLayout)a(paramInt);
    localLinearLayout.setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    paramInt = azvv.a(paramViewGroup.getContext(), 13.5F);
    localLayoutParams.rightMargin = paramInt;
    localLayoutParams.leftMargin = paramInt;
    localLinearLayout.setLayoutParams(localLayoutParams);
    localLinearLayout.setBackgroundDrawable(null);
  }
  
  public void a(avpd paramavpd)
  {
    int i = 3;
    this.a.clear();
    LinearLayout localLinearLayout = (LinearLayout)a(this.c);
    localLinearLayout.removeAllViews();
    if ((paramavpd.a == null) || (paramavpd.a.size() == 0)) {}
    int j;
    int k;
    label90:
    do
    {
      return;
      localObject = localLinearLayout.getContext();
      j = paramavpd.a.size();
      if (j >= 3) {
        break;
      }
      k = (((Context)localObject).getResources().getDisplayMetrics().widthPixels - azvv.a((Context)localObject, 27.0F)) / i;
      i = 0;
    } while (i >= j);
    Object localObject = (avpc)paramavpd.a.get(i);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, -2);
    switch (((avpc)localObject).a)
    {
    }
    for (localObject = null;; localObject = new avxk((ViewGroup)a(), 0))
    {
      if (localObject != null)
      {
        ((avxi)localObject).a().setLayoutParams(localLayoutParams);
        localLinearLayout.addView(((avxi)localObject).a());
        this.a.add(localObject);
      }
      i += 1;
      break label90;
      i = paramavpd.a.size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avxj
 * JD-Core Version:    0.7.0.1
 */