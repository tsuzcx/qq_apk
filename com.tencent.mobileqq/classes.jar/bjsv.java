import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import java.util.List;

public class bjsv
  extends PopupWindow
  implements View.OnClickListener, Animation.AnimationListener
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private bjsy jdField_a_of_type_Bjsy;
  private bjsz jdField_a_of_type_Bjsz;
  private bjta jdField_a_of_type_Bjta;
  public boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  private bjsv(Activity paramActivity, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramView, paramInt1, paramInt2, paramBoolean);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    b();
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    return paramContext.getResources().getDimensionPixelSize(paramInt);
  }
  
  private static int a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int j = a(paramContext, 2131298808) * paramInt + a(paramContext, 2131298806);
    int i = j;
    if (paramBoolean) {
      i = j + (paramInt - 1) * 1;
    }
    return i;
  }
  
  private static View a(Activity paramActivity, List<bjsy> paramList)
  {
    View localView = LayoutInflater.from(paramActivity).inflate(2131562709, null);
    BounceScrollView localBounceScrollView = (BounceScrollView)localView.findViewById(2131363689);
    localBounceScrollView.setVerticalScrollBarEnabled(false);
    localBounceScrollView.mScrollFlag = 1;
    a(paramActivity, paramList, (LinearLayout)localBounceScrollView.findViewById(2131365073));
    return localView;
  }
  
  private static View a(Activity paramActivity, List<bjsy> paramList, boolean paramBoolean, int paramInt)
  {
    View localView = LayoutInflater.from(paramActivity).inflate(2131562709, null);
    Object localObject1 = (BounceScrollView)localView.findViewById(2131363689);
    if (paramInt != -1) {
      ((BounceScrollView)localObject1).setBackgroundResource(paramInt);
    }
    LinearLayout localLinearLayout = (LinearLayout)((BounceScrollView)localObject1).findViewById(2131365073);
    ((BounceScrollView)localObject1).setVerticalScrollBarEnabled(false);
    ((BounceScrollView)localObject1).mScrollFlag = 1;
    new LinearLayout.LayoutParams(-1, 1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, a(paramActivity, 2131298808));
    paramInt = 0;
    bjsy localbjsy;
    Object localObject2;
    if (paramInt < paramList.size())
    {
      localbjsy = (bjsy)paramList.get(paramInt);
      if (paramInt == 0)
      {
        localObject2 = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2131562708, null);
        localObject1 = null;
      }
    }
    for (;;)
    {
      Object localObject3 = (ImageView)((LinearLayout)localObject2).findViewById(2131368601);
      TextView localTextView = (TextView)((LinearLayout)localObject2).findViewById(2131378537);
      if (localbjsy.jdField_a_of_type_ComTencentImageURLDrawable != null)
      {
        ((ImageView)localObject3).setImageDrawable(localbjsy.jdField_a_of_type_ComTencentImageURLDrawable);
        label173:
        if ((localbjsy.jdField_b_of_type_Int == 0) && (localbjsy.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
        {
          ((ImageView)localObject3).setVisibility(8);
          ((LinearLayout)localObject2).setPadding(0, 0, 0, 0);
        }
        localTextView.setText(localbjsy.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(localbjsy.jdField_b_of_type_JavaLangString)) {
          localTextView.setTextColor(Color.parseColor(localbjsy.jdField_b_of_type_JavaLangString));
        }
        if (localbjsy.jdField_a_of_type_Float > 0.0F) {
          localTextView.setTextSize(localbjsy.jdField_a_of_type_Float);
        }
        if (TextUtils.isEmpty(localbjsy.c)) {
          break label485;
        }
        ((LinearLayout)localObject2).setContentDescription(localbjsy.c + amtj.a(2131707449));
        label301:
        if (localObject1 != null) {
          localLinearLayout.addView((View)localObject1);
        }
        ((LinearLayout)localObject2).setTag(localbjsy);
        if (localbjsy.jdField_a_of_type_Int > 0) {
          ((LinearLayout)localObject2).setId(localbjsy.jdField_a_of_type_Int);
        }
        localLinearLayout.addView((View)localObject2, localLayoutParams);
        paramInt += 1;
        break;
        if (paramInt == paramList.size() - 1)
        {
          localObject1 = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2131562706, null);
          if (!paramBoolean) {
            break label528;
          }
          localObject3 = a(paramActivity);
          localObject2 = localObject1;
          localObject1 = localObject3;
          continue;
        }
        if (!paramBoolean) {
          break label522;
        }
      }
      label522:
      for (localObject1 = a(paramActivity);; localObject1 = null)
      {
        localObject2 = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2131562707, null);
        break;
        if (localbjsy.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null)
        {
          ((ImageView)localObject3).setImageDrawable(localbjsy.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
          break label173;
        }
        if (localbjsy.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
        {
          ((ImageView)localObject3).setImageDrawable(localbjsy.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label173;
        }
        ((ImageView)localObject3).setImageResource(localbjsy.jdField_b_of_type_Int);
        break label173;
        label485:
        ((LinearLayout)localObject2).setContentDescription(localbjsy.jdField_a_of_type_JavaLangString + amtj.a(2131707445));
        break label301;
        return localView;
      }
      label528:
      localObject3 = null;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public static final View a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -1);
    localLayoutParams.height = 1;
    paramContext.setBackgroundColor(Color.parseColor("#DEDFE0"));
    paramContext.setLayoutParams(localLayoutParams);
    return paramContext;
  }
  
  public static bjsv a(Activity paramActivity, List<bjsy> paramList, bjsz parambjsz)
  {
    return a(paramActivity, paramList, parambjsz, null);
  }
  
  public static bjsv a(Activity paramActivity, List<bjsy> paramList, bjsz parambjsz, bjta parambjta)
  {
    return a(paramActivity, paramList, parambjsz, parambjta, 0);
  }
  
  public static bjsv a(Activity paramActivity, List<bjsy> paramList, bjsz parambjsz, bjta parambjta, int paramInt)
  {
    return a(paramActivity, paramList, parambjsz, parambjta, paramInt, false);
  }
  
  public static bjsv a(Activity paramActivity, List<bjsy> paramList, bjsz parambjsz, bjta parambjta, int paramInt, boolean paramBoolean)
  {
    return a(paramActivity, paramList, parambjsz, parambjta, paramInt, paramBoolean, -1, 2131755030);
  }
  
  public static bjsv a(Activity paramActivity, List<bjsy> paramList, bjsz parambjsz, bjta parambjta, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      throw new IllegalArgumentException("parameter items can not be null or zero-length array.");
    }
    int i = a(paramActivity, paramList.size(), paramBoolean);
    if (paramInt1 <= 0) {
      paramInt1 = a(paramActivity, 2131298807);
    }
    for (;;)
    {
      paramActivity = new bjsv(paramActivity, a(paramActivity, paramList, paramBoolean, paramInt2), paramInt1, i, true);
      paramActivity.setAnimationStyle(paramInt3);
      paramActivity.setBackgroundDrawable(new ColorDrawable(0));
      paramActivity.setOutsideTouchable(false);
      if (Build.VERSION.SDK_INT >= 9) {
        a(paramActivity, 1002);
      }
      if (AppSetting.c) {
        a(paramActivity);
      }
      paramActivity.a(paramActivity.getContentView());
      paramActivity.jdField_b_of_type_Int = i;
      paramActivity.jdField_a_of_type_Bjsz = parambjsz;
      paramActivity.jdField_a_of_type_Bjta = parambjta;
      paramActivity.jdField_b_of_type_Boolean = paramBoolean;
      return paramActivity;
    }
  }
  
  private static void a(Activity paramActivity, List<bjsy> paramList, LinearLayout paramLinearLayout)
  {
    a(paramActivity, paramList, paramLinearLayout, false);
  }
  
  private static void a(Activity paramActivity, List<bjsy> paramList, LinearLayout paramLinearLayout, boolean paramBoolean)
  {
    int i = 0;
    if (i < paramList.size())
    {
      bjsy localbjsy = (bjsy)paramList.get(i);
      LinearLayout.LayoutParams localLayoutParams;
      Object localObject;
      label68:
      ImageView localImageView;
      if (i == 0)
      {
        localLayoutParams = new LinearLayout.LayoutParams(-1, AIOUtils.dp2px(62.0F, paramActivity.getResources()));
        localObject = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2131562705, null);
        localImageView = (ImageView)((LinearLayout)localObject).findViewById(2131368601);
        TextView localTextView = (TextView)((LinearLayout)localObject).findViewById(2131378537);
        if (localbjsy.jdField_a_of_type_ComTencentImageURLDrawable == null) {
          break label392;
        }
        localImageView.setImageDrawable(localbjsy.jdField_a_of_type_ComTencentImageURLDrawable);
        label110:
        if ((localbjsy.jdField_b_of_type_Int == 0) && (localbjsy.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
        {
          localImageView.setVisibility(8);
          ((LinearLayout)localObject).setPadding(0, 0, 0, 0);
        }
        localTextView.setText(localbjsy.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(localbjsy.jdField_b_of_type_JavaLangString)) {
          localTextView.setTextColor(Color.parseColor(localbjsy.jdField_b_of_type_JavaLangString));
        }
        if (localbjsy.jdField_a_of_type_Float > 0.0F) {
          localTextView.setTextSize(localbjsy.jdField_a_of_type_Float);
        }
        if (TextUtils.isEmpty(localbjsy.c)) {
          break label447;
        }
        ((LinearLayout)localObject).setContentDescription(localbjsy.c + amtj.a(2131707448));
      }
      for (;;)
      {
        ((LinearLayout)localObject).setTag(localbjsy);
        if (localbjsy.jdField_a_of_type_Int > 0) {
          ((LinearLayout)localObject).setId(localbjsy.jdField_a_of_type_Int);
        }
        paramLinearLayout.addView((View)localObject, localLayoutParams);
        i += 1;
        break;
        if (i == paramList.size() - 1)
        {
          localLayoutParams = new LinearLayout.LayoutParams(-1, AIOUtils.dp2px(62.0F, paramActivity.getResources()));
          localObject = LayoutInflater.from(paramActivity);
          if (paramBoolean) {}
          for (int j = 2131562704;; j = 2131562703)
          {
            localObject = (LinearLayout)((LayoutInflater)localObject).inflate(j, null);
            break;
          }
        }
        localLayoutParams = new LinearLayout.LayoutParams(-1, AIOUtils.dp2px(52.0F, paramActivity.getResources()));
        localObject = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2131562704, null);
        break label68;
        label392:
        if (localbjsy.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null)
        {
          localImageView.setImageDrawable(localbjsy.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
          break label110;
        }
        if (localbjsy.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
        {
          localImageView.setImageDrawable(localbjsy.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label110;
        }
        localImageView.setImageResource(localbjsy.jdField_b_of_type_Int);
        break label110;
        label447:
        ((LinearLayout)localObject).setContentDescription(localbjsy.jdField_a_of_type_JavaLangString + amtj.a(2131707446));
      }
    }
  }
  
  private void a(View paramView)
  {
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof bjsy))) {
      paramView.setOnClickListener(this);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        a(paramView.getChildAt(i));
        i += 1;
      }
    }
  }
  
  public static void a(PopupWindow paramPopupWindow)
  {
    int i = 0;
    if (!AppSetting.c) {}
    for (;;)
    {
      return;
      Method[] arrayOfMethod = PopupWindow.class.getMethods();
      int j = arrayOfMethod.length;
      while (i < j)
      {
        Method localMethod = arrayOfMethod[i];
        if (localMethod.getName().equals("setTouchModal")) {
          try
          {
            localMethod.invoke(paramPopupWindow, new Object[] { Boolean.valueOf(false) });
            return;
          }
          catch (Exception paramPopupWindow)
          {
            paramPopupWindow.printStackTrace();
            return;
          }
        }
        i += 1;
      }
    }
  }
  
  public static void a(PopupWindow paramPopupWindow, int paramInt)
  {
    int i = 0;
    Method[] arrayOfMethod = PopupWindow.class.getMethods();
    int j = arrayOfMethod.length;
    for (;;)
    {
      Method localMethod;
      if (i < j)
      {
        localMethod = arrayOfMethod[i];
        if (!localMethod.getName().equals("setWindowLayoutType")) {}
      }
      else
      {
        try
        {
          localMethod.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
          return;
        }
        catch (Exception paramPopupWindow)
        {
          paramPopupWindow.printStackTrace();
          return;
        }
      }
      i += 1;
    }
  }
  
  public static int b(Context paramContext, int paramInt)
  {
    int i = paramInt - 2;
    if (i > 0) {}
    for (paramInt = i * AIOUtils.dp2px(52.0F, paramContext.getResources()) + AIOUtils.dp2px(62.0F, paramContext.getResources()) * 2;; paramInt = AIOUtils.dp2px(62.0F, paramContext.getResources()) * paramInt) {
      return paramInt + a(paramContext, 2131298806);
    }
  }
  
  public static bjsv b(Activity paramActivity, List<bjsy> paramList, bjsz parambjsz, bjta parambjta)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      throw new IllegalArgumentException("parameter items can not be null or zero-length array.");
    }
    int j = b(paramActivity, paramList.size());
    if (amvi.a()) {}
    for (int i = a(paramActivity, 2131298802);; i = a(paramActivity, 2131298801))
    {
      paramActivity = new bjsv(paramActivity, a(paramActivity, paramList), i, j, true);
      paramActivity.setAnimationStyle(2131755030);
      paramActivity.setBackgroundDrawable(new ColorDrawable(0));
      paramActivity.setOutsideTouchable(false);
      a(paramActivity, 1002);
      if (AppSetting.c) {
        a(paramActivity);
      }
      paramActivity.a(paramActivity.getContentView());
      paramActivity.jdField_b_of_type_Int = j;
      paramActivity.jdField_a_of_type_Bjsz = parambjsz;
      paramActivity.jdField_a_of_type_Bjta = parambjta;
      paramActivity.jdField_b_of_type_Boolean = false;
      return paramActivity;
    }
  }
  
  private void b()
  {
    int j = -1;
    int i;
    if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 1000;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = -3;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 40;
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
        localLayoutParams.flags |= 0x4000000;
      }
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = -1;
      i = j;
      if (this.jdField_a_of_type_AndroidAppActivity.getWindow() != null)
      {
        i = j;
        if (this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView() != null)
        {
          i = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getHeight();
          if (i > 0) {
            break label245;
          }
          i = j;
        }
      }
    }
    label245:
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = i;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 2131755331;
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165494));
        this.jdField_a_of_type_AndroidViewView.setContentDescription(amtj.a(2131707447));
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(new bjsw(this));
      }
      if ((AppSetting.c) && (Build.VERSION.SDK_INT >= 14)) {
        getContentView().setAccessibilityDelegate(new bjsx(this));
      }
      return;
    }
  }
  
  public void a()
  {
    if ((Build.VERSION.SDK_INT < 9) && (isShowing())) {
      dismiss();
    }
  }
  
  public void dismiss()
  {
    try
    {
      if (ImmersiveUtils.a(this.jdField_a_of_type_AndroidAppActivity)) {
        ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).removeView(this.jdField_a_of_type_AndroidViewView);
      }
      while (Build.VERSION.SDK_INT >= 11)
      {
        super.dismiss();
        if ((this.jdField_a_of_type_Bjsz != null) && (this.jdField_a_of_type_Bjsy != null)) {
          this.jdField_a_of_type_Bjsz.a(this.jdField_a_of_type_Bjsy);
        }
        this.jdField_a_of_type_Bjsy = null;
        if (this.jdField_a_of_type_Bjta != null) {
          this.jdField_a_of_type_Bjta.a();
        }
        return;
        this.jdField_a_of_type_AndroidAppActivity.getWindowManager().removeView(this.jdField_a_of_type_AndroidViewView);
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PopupMenuDialog", 2, localException.toString());
          }
        }
      } while ((!isShowing()) || ((this.jdField_a_of_type_AndroidViewAnimationAnimation != null) && (!this.jdField_a_of_type_AndroidViewAnimationAnimation.hasEnded())));
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidAppActivity, 2130772328);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      }
      getContentView().startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PopupMenuDialog", 2, "onAnimationEnd");
    }
    if ((this.jdField_a_of_type_Bjsz != null) && (this.jdField_a_of_type_Bjsy != null)) {
      this.jdField_a_of_type_Bjsz.a(this.jdField_a_of_type_Bjsy);
    }
    this.jdField_a_of_type_Bjsy = null;
    if (this.jdField_a_of_type_Bjta != null) {
      this.jdField_a_of_type_Bjta.a();
    }
    super.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PopupMenuDialog", 2, "onAnimationStart");
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bjsy = ((bjsy)paramView.getTag());
    dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    int j = getMaxAvailableHeight(paramView, paramInt2);
    if (j != this.jdField_a_of_type_Int)
    {
      int i = 0;
      if (j < this.jdField_b_of_type_Int) {
        i = (1 - a(this.jdField_a_of_type_AndroidAppActivity, 2131298806) + j) / (a(this.jdField_a_of_type_AndroidAppActivity, 2131298808) + 1);
      }
      if (i <= 0) {
        break label130;
      }
      setHeight(a(this.jdField_a_of_type_AndroidAppActivity, i, this.jdField_b_of_type_Boolean));
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = j;
      try
      {
        if (ImmersiveUtils.a(this.jdField_a_of_type_AndroidAppActivity)) {
          ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
        }
        for (;;)
        {
          super.showAsDropDown(paramView, paramInt1, paramInt2);
          return;
          label130:
          setHeight(this.jdField_b_of_type_Int);
          break;
          this.jdField_a_of_type_AndroidAppActivity.getWindowManager().addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PopupMenuDialog", 2, localException.toString());
          }
        }
      }
    }
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (ImmersiveUtils.a(this.jdField_a_of_type_AndroidAppActivity)) {
        ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      }
      for (;;)
      {
        super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
        return;
        this.jdField_a_of_type_AndroidAppActivity.getWindowManager().addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PopupMenuDialog", 2, localException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjsv
 * JD-Core Version:    0.7.0.1
 */