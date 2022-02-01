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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;
import java.util.Iterator;

public class bdru
  extends bdnv
{
  private static final int s = Color.rgb(255, 221, 227);
  
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
        arrayOfGradientDrawable[k].setCornerRadius(AIOUtils.dp2px(14.0F, paramResources));
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
      i = AIOUtils.dp2px(14.0F, paramView.getResources());
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
      localObject1 = a(paramView.getResources(), s, (float[])localObject1);
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
    bdrv localbdrv;
    label148:
    Object localObject1;
    Object localObject2;
    if ((paramView != null) && ((paramView instanceof LinearLayout)) && (((LinearLayout)paramView).getChildCount() == 2) && ((((LinearLayout)paramView).getChildAt(0).getTag() instanceof bdrv)))
    {
      localLinearLayout = (LinearLayout)paramView;
      localbdrv = (bdrv)localLinearLayout.getChildAt(0).getTag();
      if (localbdrv.jdField_a_of_type_AndroidViewView != null) {
        localbdrv.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      if (localbdrv.jdField_b_of_type_AndroidViewView != null) {
        localbdrv.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      if (localbdrv.c != null) {
        localbdrv.c.setVisibility(8);
      }
      if (localbdrv.d != null) {
        localbdrv.d.setVisibility(8);
      }
      paramView = null;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (!localIterator.hasNext()) {
        break label708;
      }
      localObject1 = (bdnu)localIterator.next();
      ((bdnu)localObject1).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      localObject2 = ((bdnu)localObject1).jdField_a_of_type_JavaLangString;
      if (!"title".equals(localObject2)) {
        break label447;
      }
      if ((localObject1 instanceof StructMsgItemTitle))
      {
        ((StructMsgItemTitle)localObject1).a(a(), 0);
        ((StructMsgItemTitle)localObject1).a(true);
      }
      localObject1 = ((bdnu)localObject1).a(paramContext, localbdrv.jdField_a_of_type_AndroidViewView, paramBundle);
      localObject2 = (TextView)((View)localObject1).findViewById(2131380210);
      if (localObject2 != null) {
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
      }
      if (localbdrv.jdField_a_of_type_AndroidViewView != null) {
        break label435;
      }
      localbdrv.jdField_a_of_type_AndroidViewView = ((View)localObject1);
      localbdrv.jdField_b_of_type_AndroidViewViewGroup.addView((View)localObject1);
    }
    for (;;)
    {
      break label148;
      localbdrv = new bdrv();
      localbdrv.jdField_b_of_type_AndroidViewViewGroup = new LinearLayout(paramContext);
      ((LinearLayout)localbdrv.jdField_b_of_type_AndroidViewViewGroup).setOrientation(1);
      paramView = new LinearLayout.LayoutParams(0, -2);
      paramView.weight = 1.0F;
      paramView.gravity = 16;
      paramView.setMargins(AIOUtils.dp2px(15.0F, localResources), 0, 0, 0);
      localbdrv.jdField_a_of_type_AndroidViewViewGroup = new LinearLayout(paramContext);
      localbdrv.jdField_a_of_type_AndroidViewViewGroup.setTag(localbdrv);
      localbdrv.jdField_a_of_type_AndroidViewViewGroup.addView(localbdrv.jdField_b_of_type_AndroidViewViewGroup, paramView);
      localLinearLayout = a(paramContext);
      localLinearLayout.addView(localbdrv.jdField_a_of_type_AndroidViewViewGroup, new LinearLayout.LayoutParams(-1, AIOUtils.dp2px(75.0F, localResources)));
      break;
      label435:
      localbdrv.jdField_a_of_type_AndroidViewView.setVisibility(0);
      continue;
      label447:
      if ("summary".equals(localObject2))
      {
        localObject1 = ((bdnu)localObject1).a(paramContext, localbdrv.jdField_b_of_type_AndroidViewView, paramBundle);
        if (localbdrv.jdField_b_of_type_AndroidViewView == null)
        {
          localbdrv.jdField_b_of_type_AndroidViewView = ((View)localObject1);
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject2).setMargins(0, AIOUtils.dp2px(4.0F, localResources), 0, 0);
          localbdrv.jdField_b_of_type_AndroidViewViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        }
        for (;;)
        {
          break;
          localbdrv.jdField_b_of_type_AndroidViewView.setVisibility(0);
        }
      }
      if (("picture".equals(localObject2)) || ("video".equals(localObject2)))
      {
        int i = AIOUtils.dp2px(50.0F, localResources);
        localObject1 = ((bdnu)localObject1).a(paramContext, localbdrv.c, paramBundle);
        if (localbdrv.c == null)
        {
          localbdrv.c = ((View)localObject1);
          localObject2 = new LinearLayout.LayoutParams(i, i);
          i = AIOUtils.dp2px(12.0F, localResources);
          int j = AIOUtils.dp2px(10.0F, localResources);
          ((LinearLayout.LayoutParams)localObject2).setMargins(j, i, j, i);
          ((LinearLayout.LayoutParams)localObject2).gravity = 16;
          localbdrv.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        }
        for (;;)
        {
          break;
          localbdrv.c.setVisibility(0);
        }
      }
      if ("remark".equals(localObject2))
      {
        paramView = ((bdnu)localObject1).a(paramContext, localbdrv.d, paramBundle);
        continue;
        label708:
        if (localbdrv.jdField_b_of_type_AndroidViewView != null) {
          localbdrv.jdField_b_of_type_AndroidViewView.bringToFront();
        }
        if (paramView != null)
        {
          if (localbdrv.d == null)
          {
            localbdrv.d = paramView;
            localLinearLayout.addView(paramView, new LinearLayout.LayoutParams(-1, AIOUtils.dp2px(25.0F, localResources)));
            float f = AIOUtils.dp2px(14.0F, localResources);
            paramView.setBackgroundDrawable(a(localResources, -1, new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f }));
            paramView.setPadding(AIOUtils.dp2px(12.0F, localResources), AIOUtils.dp2px(5.0F, localResources), 0, 0);
          }
        }
        else {
          return localLinearLayout;
        }
        localbdrv.d.setVisibility(0);
        return localLinearLayout;
      }
    }
  }
  
  public String b()
  {
    return "Layout7";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdru
 * JD-Core Version:    0.7.0.1
 */