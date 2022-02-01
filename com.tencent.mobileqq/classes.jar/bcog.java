import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;

public class bcog
  extends bcoa
{
  public final ArrayList<bcof> a = new ArrayList();
  
  public bcog(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    LinearLayout localLinearLayout = (LinearLayout)a(paramInt);
    localLinearLayout.setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    paramInt = DisplayUtil.dip2px(paramViewGroup.getContext(), 13.5F);
    localLayoutParams.rightMargin = paramInt;
    localLayoutParams.leftMargin = paramInt;
    localLinearLayout.setLayoutParams(localLayoutParams);
    localLinearLayout.setBackgroundDrawable(null);
  }
  
  public void a(bcfz parambcfz)
  {
    int i = 3;
    this.a.clear();
    LinearLayout localLinearLayout = (LinearLayout)a(this.c);
    localLinearLayout.removeAllViews();
    if ((parambcfz.a == null) || (parambcfz.a.size() == 0)) {}
    int j;
    int k;
    label90:
    do
    {
      return;
      localObject = localLinearLayout.getContext();
      j = parambcfz.a.size();
      if (j >= 3) {
        break;
      }
      k = (((Context)localObject).getResources().getDisplayMetrics().widthPixels - DisplayUtil.dip2px((Context)localObject, 27.0F)) / i;
      i = 0;
    } while (i >= j);
    Object localObject = (bcfy)parambcfz.a.get(i);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, -2);
    switch (((bcfy)localObject).a)
    {
    }
    for (localObject = null;; localObject = new bcoh((ViewGroup)a(), 0))
    {
      if (localObject != null)
      {
        ((bcof)localObject).a().setLayoutParams(localLayoutParams);
        localLinearLayout.addView(((bcof)localObject).a());
        this.a.add(localObject);
      }
      i += 1;
      break label90;
      i = parambcfz.a.size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcog
 * JD-Core Version:    0.7.0.1
 */