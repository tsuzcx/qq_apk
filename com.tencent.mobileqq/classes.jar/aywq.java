import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;

public class aywq
  extends aywk
{
  public final ArrayList<aywp> a = new ArrayList();
  
  public aywq(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    LinearLayout localLinearLayout = (LinearLayout)a(paramInt);
    localLinearLayout.setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    paramInt = bdaq.a(paramViewGroup.getContext(), 13.5F);
    localLayoutParams.rightMargin = paramInt;
    localLayoutParams.leftMargin = paramInt;
    localLinearLayout.setLayoutParams(localLayoutParams);
    localLinearLayout.setBackgroundDrawable(null);
  }
  
  public void a(ayok paramayok)
  {
    int i = 3;
    this.a.clear();
    LinearLayout localLinearLayout = (LinearLayout)a(this.c);
    localLinearLayout.removeAllViews();
    if ((paramayok.a == null) || (paramayok.a.size() == 0)) {}
    int j;
    int k;
    label90:
    do
    {
      return;
      localObject = localLinearLayout.getContext();
      j = paramayok.a.size();
      if (j >= 3) {
        break;
      }
      k = (((Context)localObject).getResources().getDisplayMetrics().widthPixels - bdaq.a((Context)localObject, 27.0F)) / i;
      i = 0;
    } while (i >= j);
    Object localObject = (ayoj)paramayok.a.get(i);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, -2);
    switch (((ayoj)localObject).a)
    {
    }
    for (localObject = null;; localObject = new aywr((ViewGroup)a(), 0))
    {
      if (localObject != null)
      {
        ((aywp)localObject).a().setLayoutParams(localLayoutParams);
        localLinearLayout.addView(((aywp)localObject).a());
        this.a.add(localObject);
      }
      i += 1;
      break label90;
      i = paramayok.a.size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywq
 * JD-Core Version:    0.7.0.1
 */