import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public class asoh
{
  int jdField_a_of_type_Int = 1;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new asom(this);
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  List<ImageView> jdField_a_of_type_JavaUtilList = new ArrayList();
  volatile boolean jdField_a_of_type_Boolean;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  
  public asoh(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    a(paramInt);
  }
  
  private boolean a(int paramInt)
  {
    int i = 0;
    if (!b(paramInt)) {
      return false;
    }
    Object localObject = BaseApplicationImpl.getContext();
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setLayerType(1, null);
      }
      if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() <= 0)) {
        break label344;
      }
      paramInt = i;
      while (paramInt < this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount())
      {
        localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(paramInt);
        if ((localObject instanceof ImageView))
        {
          localObject = (ImageView)localObject;
          ((ImageView)localObject).setVisibility(8);
          this.jdField_a_of_type_JavaUtilList.add(localObject);
        }
        paramInt += 1;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate((Context)localObject, 2131561154, null));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367827));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367831));
      continue;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate((Context)localObject, 2131561176, null));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367827));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367828));
      continue;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate((Context)localObject, 2131561175, null));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367827));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367828));
      continue;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate((Context)localObject, 2131561163, null));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367827));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367832));
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    label344:
    return true;
  }
  
  private void b(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      QLog.e("MatchViewHolder", 0, "updateData _ uins is null ");
    }
    int j;
    QQAppInterface localQQAppInterface;
    label189:
    Object localObject;
    label225:
    do
    {
      do
      {
        return;
        if (!a(this.jdField_c_of_type_JavaUtilList, paramArrayList)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MatchViewHolder", 0, "updateData return for same data");
      return;
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.addAll(paramArrayList);
      this.jdField_c_of_type_JavaUtilList.clear();
      this.jdField_c_of_type_JavaUtilList.addAll(paramArrayList);
      j = this.jdField_b_of_type_JavaUtilList.size();
      if (QLog.isColorLevel()) {
        QLog.d("MatchViewHolder", 0, "updateData _ infoListSize = " + j);
      }
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      int i;
      ImageView localImageView;
      if (j > 0)
      {
        i = 1;
        if (i == 0) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        int k = this.jdField_a_of_type_JavaUtilList.size();
        i = 0;
        if (i >= k) {
          continue;
        }
        localImageView = (ImageView)this.jdField_a_of_type_JavaUtilList.get(i);
        if (i >= j) {
          break label325;
        }
        localObject = (String)paramArrayList.get(i);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label349;
        }
        if (localQQAppInterface == null) {
          break label331;
        }
        Drawable localDrawable = bgmo.a(true);
        localObject = aoch.a(localQQAppInterface, 1, (String)localObject, 4, localDrawable, localDrawable);
        ((aoch)localObject).mutate();
        localDrawable = localImageView.getDrawable();
        if ((localDrawable != null) && (localDrawable != localObject) && ((localDrawable instanceof aoch))) {
          ((aoch)localDrawable).b();
        }
        localImageView.setImageDrawable((Drawable)localObject);
        localImageView.setVisibility(0);
      }
      for (;;)
      {
        i += 1;
        break label189;
        i = 0;
        break;
        localObject = null;
        break label225;
        localImageView.setImageDrawable(bgmo.a(true));
        localImageView.setVisibility(0);
        continue;
        localImageView.setVisibility(8);
      }
    } while (j <= this.jdField_a_of_type_JavaUtilList.size());
    label325:
    label331:
    label349:
    paramArrayList = (String)this.jdField_b_of_type_JavaUtilList.get(this.jdField_b_of_type_JavaUtilList.size() - 1);
    if (localQQAppInterface != null)
    {
      localObject = bgmo.a(true);
      aoch.a(localQQAppInterface, 1, paramArrayList, 4, (Drawable)localObject, (Drawable)localObject);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
    return;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt > 0) && (paramInt <= 4);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MatchViewHolder", 0, "setUinList uins = 0");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MatchViewHolder", 0, "setUinList uins = " + paramArrayList);
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(2)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    }
    paramArrayList = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2, paramArrayList);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramArrayList);
  }
  
  boolean a(List<String> paramList1, List<String> paramList2)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int j = paramList1.size();
    int i;
    if (j == paramList2.size())
    {
      if (j <= 0) {
        break label97;
      }
      i = 0;
      bool2 = bool1;
      if (i >= j) {
        break label97;
      }
      String str1 = (String)paramList1.get(i);
      String str2 = (String)paramList2.get(i);
      if ((TextUtils.isEmpty(str1)) || (str1.equals(str2))) {
        break label132;
      }
      bool1 = false;
    }
    label132:
    for (;;)
    {
      i += 1;
      break;
      bool2 = false;
      label97:
      if (QLog.isColorLevel()) {
        QLog.d("MatchViewHolder", 0, "checkListEqual _ result = " + bool2);
      }
      return bool2;
    }
  }
  
  void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_b_of_type_AndroidWidgetImageView == null)) {
      QLog.d("MatchViewHolder", 0, "startAnimation headFirst headLast null");
    }
    Object localObject1;
    do
    {
      return;
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } while (localObject1 == null);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_c_of_type_AndroidWidgetImageView);
    }
    Object localObject2 = BaseApplicationImpl.getContext();
    this.jdField_c_of_type_AndroidWidgetImageView = new ImageView((Context)localObject2);
    this.jdField_c_of_type_AndroidWidgetImageView.setLayerType(1, null);
    if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3)) {}
    for (int i = afur.a(2.0F, ((Context)localObject2).getResources());; i = afur.a(1.0F, ((Context)localObject2).getResources()))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setPadding(i, i, i, i);
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130845127);
      localObject2 = new RelativeLayout.LayoutParams(this.jdField_a_of_type_AndroidWidgetImageView.getWidth(), this.jdField_a_of_type_AndroidWidgetImageView.getHeight());
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131367827);
      ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131367827);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
      if (this.jdField_b_of_type_JavaUtilList.size() > 0) {}
      try
      {
        localObject2 = (String)this.jdField_b_of_type_JavaUtilList.remove(this.jdField_b_of_type_JavaUtilList.size() - 1);
        if (QLog.isColorLevel()) {
          QLog.d("MatchViewHolder", 0, "startAnimation targetUin = " + (String)localObject2);
        }
        this.jdField_b_of_type_JavaUtilList.add(0, localObject2);
        Drawable localDrawable = bgmo.a(true);
        localObject1 = aoch.a((AppInterface)localObject1, 1, (String)localObject2, 4, localDrawable, localDrawable);
        ((aoch)localObject1).mutate();
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        localObject1 = new ScaleAnimation(1.0F, 1.2F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
        ((ScaleAnimation)localObject1).setDuration(500);
        ((ScaleAnimation)localObject1).setFillAfter(true);
        ((ScaleAnimation)localObject1).setAnimationListener(new asoi(this));
        this.jdField_c_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject1);
        return;
      }
      catch (Exception localException)
      {
        QLog.d("MatchViewHolder", 1, "startAnimation Exception!", localException);
      }
    }
  }
  
  void c()
  {
    int k = 0;
    int i = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
    Object localObject1 = BaseApplicationImpl.getContext();
    int j = i - ((Context)localObject1).getResources().getDimensionPixelSize(2131298100);
    if (this.jdField_a_of_type_Int == 2)
    {
      j = ((Context)localObject1).getResources().getDimensionPixelSize(2131298108);
      i -= ((Context)localObject1).getResources().getDimensionPixelSize(2131298106);
    }
    for (;;)
    {
      Object localObject2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetImageView, "translationX", new float[] { 0.0F, j });
      Object localObject3 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetImageView, "alpha", new float[] { 1.0F, 0.0F });
      ((ObjectAnimator)localObject2).setDuration(300);
      ((ObjectAnimator)localObject3).setDuration(300);
      localObject1 = new AnimatorSet();
      ((AnimatorSet)localObject1).playTogether(new Animator[] { localObject2, localObject3 });
      localObject3 = new asok(this, (AnimatorSet)localObject1);
      localObject2 = new ArrayList();
      if (this.jdField_a_of_type_JavaUtilList.size() > 1)
      {
        j = 0;
        for (;;)
        {
          if (j < this.jdField_a_of_type_JavaUtilList.size() - 1)
          {
            TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, i, 0.0F, 0.0F);
            localTranslateAnimation.setDuration(300);
            localTranslateAnimation.setFillAfter(true);
            ((List)localObject2).add(localTranslateAnimation);
            j += 1;
            continue;
            if (this.jdField_a_of_type_Int != 3) {
              break label374;
            }
            j = ((Context)localObject1).getResources().getDimensionPixelSize(2131298111);
            i -= ((Context)localObject1).getResources().getDimensionPixelSize(2131298109);
            break;
          }
        }
        ((TranslateAnimation)((List)localObject2).get(0)).setAnimationListener((Animation.AnimationListener)localObject3);
        i = k;
        while (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          localObject3 = (ImageView)this.jdField_a_of_type_JavaUtilList.get(i);
          ((ImageView)localObject3).clearAnimation();
          ((ImageView)localObject3).startAnimation((Animation)((List)localObject2).get(i));
          i += 1;
        }
      }
      ((AnimatorSet)localObject1).start();
      return;
      label374:
      i = j;
    }
  }
  
  public void d()
  {
    a();
    this.jdField_a_of_type_AndroidOsHandler$Callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asoh
 * JD-Core Version:    0.7.0.1
 */