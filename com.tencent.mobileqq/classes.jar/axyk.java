import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.util.StateSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;
import java.util.Iterator;

public class axyk
  extends axuq
{
  private static final int o = Color.rgb(255, 221, 227);
  
  private StateListDrawable a(Resources paramResources, int paramInt, float[] paramArrayOfFloat)
  {
    GradientDrawable[] arrayOfGradientDrawable = new GradientDrawable[2];
    int k = Color.red(paramInt);
    int i = Color.green(paramInt);
    int j = Color.blue(paramInt);
    paramInt = k;
    k = 0;
    if (k < arrayOfGradientDrawable.length)
    {
      arrayOfGradientDrawable[k] = new GradientDrawable();
      arrayOfGradientDrawable[k].setShape(0);
      int m = paramInt - (k << 5);
      paramInt = m;
      if (m < 0) {
        paramInt = 0;
      }
      m = i - (k << 5);
      i = m;
      if (m < 0) {
        i = 0;
      }
      m = j - (k << 5);
      j = m;
      if (m < 0) {
        j = 0;
      }
      arrayOfGradientDrawable[k].setColor(Color.rgb(paramInt, i, j));
      if (paramArrayOfFloat != null) {
        arrayOfGradientDrawable[k].setCornerRadii(paramArrayOfFloat);
      }
      for (;;)
      {
        k += 1;
        break;
        arrayOfGradientDrawable[k].setCornerRadius(actj.a(14.0F, paramResources));
      }
    }
    paramResources = new StateListDrawable();
    paramArrayOfFloat = arrayOfGradientDrawable[1];
    paramResources.addState(new int[] { 16842919, 16842910 }, paramArrayOfFloat);
    paramResources.addState(StateSet.WILD_CARD, arrayOfGradientDrawable[0]);
    return paramResources;
  }
  
  private LinearLayout a(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    a(paramContext);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setOrientation(1);
    return paramContext;
  }
  
  @TargetApi(16)
  public void a(View paramView)
  {
    int i;
    Object localObject1;
    if (paramView != null)
    {
      i = actj.a(14.0F, paramView.getResources());
      Object localObject2 = null;
      localObject1 = localObject2;
      switch (a())
      {
      default: 
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject1 = a(paramView.getResources(), o, (float[])localObject1);
      if (Build.VERSION.SDK_INT >= 16) {
        break;
      }
      paramView.setBackgroundDrawable((Drawable)localObject1);
      return;
      localObject1 = new float[8];
      continue;
      localObject1 = new float[8];
      localObject1[0] = i;
      localObject1[1] = i;
      localObject1[2] = i;
      localObject1[3] = i;
      localObject1[4] = 0.0F;
      localObject1[5] = 0.0F;
      localObject1[6] = 0.0F;
      localObject1[7] = 0.0F;
      continue;
      localObject1 = new float[8];
      localObject1[0] = 0.0F;
      localObject1[1] = 0.0F;
      localObject1[2] = 0.0F;
      localObject1[3] = 0.0F;
      localObject1[4] = i;
      localObject1[5] = i;
      localObject1[6] = i;
      localObject1[7] = i;
    }
    paramView.setBackground((Drawable)localObject1);
  }
  
  protected int b()
  {
    return 7;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Resources localResources = paramContext.getResources();
    LinearLayout localLinearLayout;
    axyl localaxyl;
    label148:
    Object localObject1;
    Object localObject2;
    if ((paramView != null) && ((paramView instanceof LinearLayout)) && (((LinearLayout)paramView).getChildCount() == 2) && ((((LinearLayout)paramView).getChildAt(0).getTag() instanceof axyl)))
    {
      localLinearLayout = (LinearLayout)paramView;
      localaxyl = (axyl)localLinearLayout.getChildAt(0).getTag();
      if (localaxyl.jdField_a_of_type_AndroidViewView != null) {
        localaxyl.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      if (localaxyl.jdField_b_of_type_AndroidViewView != null) {
        localaxyl.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      if (localaxyl.c != null) {
        localaxyl.c.setVisibility(8);
      }
      if (localaxyl.d != null) {
        localaxyl.d.setVisibility(8);
      }
      paramView = null;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (!localIterator.hasNext()) {
        break label707;
      }
      localObject1 = (axup)localIterator.next();
      ((axup)localObject1).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      localObject2 = ((axup)localObject1).jdField_a_of_type_JavaLangString;
      if (!"title".equals(localObject2)) {
        break label447;
      }
      if ((localObject1 instanceof StructMsgItemTitle))
      {
        ((StructMsgItemTitle)localObject1).a(a(), 0);
        ((StructMsgItemTitle)localObject1).a(true);
      }
      localObject1 = ((axup)localObject1).a(paramContext, localaxyl.jdField_a_of_type_AndroidViewView, paramBundle);
      localObject2 = (TextView)((View)localObject1).findViewById(2131378383);
      if (localObject2 != null) {
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
      }
      if (localaxyl.jdField_a_of_type_AndroidViewView != null) {
        break label435;
      }
      localaxyl.jdField_a_of_type_AndroidViewView = ((View)localObject1);
      localaxyl.jdField_b_of_type_AndroidViewViewGroup.addView((View)localObject1);
    }
    for (;;)
    {
      break label148;
      localaxyl = new axyl();
      localaxyl.jdField_b_of_type_AndroidViewViewGroup = new LinearLayout(paramContext);
      ((LinearLayout)localaxyl.jdField_b_of_type_AndroidViewViewGroup).setOrientation(1);
      paramView = new LinearLayout.LayoutParams(0, -2);
      paramView.weight = 1.0F;
      paramView.gravity = 16;
      paramView.setMargins(actj.a(15.0F, localResources), 0, 0, 0);
      localaxyl.jdField_a_of_type_AndroidViewViewGroup = new LinearLayout(paramContext);
      localaxyl.jdField_a_of_type_AndroidViewViewGroup.setTag(localaxyl);
      localaxyl.jdField_a_of_type_AndroidViewViewGroup.addView(localaxyl.jdField_b_of_type_AndroidViewViewGroup, paramView);
      localLinearLayout = a(paramContext);
      localLinearLayout.addView(localaxyl.jdField_a_of_type_AndroidViewViewGroup, new LinearLayout.LayoutParams(-1, actj.a(75.0F, localResources)));
      break;
      label435:
      localaxyl.jdField_a_of_type_AndroidViewView.setVisibility(0);
      continue;
      label447:
      if ("summary".equals(localObject2))
      {
        localObject1 = ((axup)localObject1).a(paramContext, localaxyl.jdField_b_of_type_AndroidViewView, paramBundle);
        if (localaxyl.jdField_b_of_type_AndroidViewView == null)
        {
          localaxyl.jdField_b_of_type_AndroidViewView = ((View)localObject1);
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject2).setMargins(0, actj.a(4.0F, localResources), 0, 0);
          localaxyl.jdField_b_of_type_AndroidViewViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        }
        for (;;)
        {
          break;
          localaxyl.jdField_b_of_type_AndroidViewView.setVisibility(0);
        }
      }
      if (("picture".equals(localObject2)) || ("video".equals(localObject2)))
      {
        int i = actj.a(50.0F, localResources);
        localObject1 = ((axup)localObject1).a(paramContext, localaxyl.c, paramBundle);
        if (localaxyl.c == null)
        {
          localaxyl.c = ((View)localObject1);
          localObject2 = new LinearLayout.LayoutParams(i, i);
          i = actj.a(12.0F, localResources);
          int j = actj.a(10.0F, localResources);
          ((LinearLayout.LayoutParams)localObject2).setMargins(j, i, j, i);
          ((LinearLayout.LayoutParams)localObject2).gravity = 16;
          localaxyl.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        }
        for (;;)
        {
          break;
          localaxyl.c.setVisibility(0);
        }
      }
      if ("remark".equals(localObject2))
      {
        paramView = ((axup)localObject1).a(paramContext, localaxyl.d, paramBundle);
        continue;
        label707:
        if (localaxyl.jdField_b_of_type_AndroidViewView != null) {
          localaxyl.jdField_b_of_type_AndroidViewView.bringToFront();
        }
        if (paramView != null)
        {
          if (localaxyl.d == null)
          {
            localaxyl.d = paramView;
            localLinearLayout.addView(paramView, new LinearLayout.LayoutParams(-1, actj.a(25.0F, localResources)));
            float f = actj.a(14.0F, localResources);
            paramView.setBackgroundDrawable(a(localResources, -1, new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f }));
            paramView.setPadding(actj.a(12.0F, localResources), actj.a(5.0F, localResources), 0, 0);
          }
        }
        else {
          return localLinearLayout;
        }
        localaxyl.d.setVisibility(0);
        return localLinearLayout;
      }
    }
  }
  
  public String b()
  {
    return "Layout7";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axyk
 * JD-Core Version:    0.7.0.1
 */