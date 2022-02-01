import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;

public class bcom
  extends bcog
{
  public final ArrayList<bcol> a = new ArrayList();
  
  public bcom(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    LinearLayout localLinearLayout = (LinearLayout)a(paramInt);
    localLinearLayout.setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    paramInt = bhgr.a(paramViewGroup.getContext(), 13.5F);
    localLayoutParams.rightMargin = paramInt;
    localLayoutParams.leftMargin = paramInt;
    localLinearLayout.setLayoutParams(localLayoutParams);
    localLinearLayout.setBackgroundDrawable(null);
  }
  
  public void a(bcgh parambcgh)
  {
    int i = 3;
    this.a.clear();
    LinearLayout localLinearLayout = (LinearLayout)a(this.c);
    localLinearLayout.removeAllViews();
    if ((parambcgh.a == null) || (parambcgh.a.size() == 0)) {}
    int j;
    int k;
    label90:
    do
    {
      return;
      localObject = localLinearLayout.getContext();
      j = parambcgh.a.size();
      if (j >= 3) {
        break;
      }
      k = (((Context)localObject).getResources().getDisplayMetrics().widthPixels - bhgr.a((Context)localObject, 27.0F)) / i;
      i = 0;
    } while (i >= j);
    Object localObject = (bcgg)parambcgh.a.get(i);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, -2);
    switch (((bcgg)localObject).a)
    {
    }
    for (localObject = null;; localObject = new bcon((ViewGroup)a(), 0))
    {
      if (localObject != null)
      {
        ((bcol)localObject).a().setLayoutParams(localLayoutParams);
        localLinearLayout.addView(((bcol)localObject).a());
        this.a.add(localObject);
      }
      i += 1;
      break label90;
      i = parambcgh.a.size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcom
 * JD-Core Version:    0.7.0.1
 */