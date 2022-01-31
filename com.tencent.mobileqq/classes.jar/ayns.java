import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
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

public class ayns
{
  private int jdField_a_of_type_Int;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aynx(this);
  Handler jdField_a_of_type_AndroidOsHandler;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  List<ImageView> jdField_a_of_type_JavaUtilList;
  volatile boolean jdField_a_of_type_Boolean;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  ImageView d;
  
  public ayns()
  {
    Object localObject = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_Int = actj.a(4.0F, ((Context)localObject).getResources());
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate((Context)localObject, 2131561135, null));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367377));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367378));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367379));
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount())
    {
      localObject = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(i);
      ((ImageView)localObject).setVisibility(8);
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      i += 1;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
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
          break label319;
        }
        localObject = (String)paramArrayList.get(i);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label343;
        }
        if (localQQAppInterface == null) {
          break label325;
        }
        Drawable localDrawable = bbef.a(true);
        localObject = bayh.a(localQQAppInterface, 1, (String)localObject, 4, localDrawable, localDrawable);
        localDrawable = localImageView.getDrawable();
        if ((localDrawable != null) && (localDrawable != localObject) && ((localDrawable instanceof bayh))) {
          ((bayh)localDrawable).a();
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
        localImageView.setImageDrawable(bbef.a(true));
        localImageView.setVisibility(0);
        continue;
        localImageView.setVisibility(8);
      }
    } while (j <= 3);
    label319:
    label325:
    label343:
    paramArrayList = (String)this.jdField_b_of_type_JavaUtilList.get(3);
    if (localQQAppInterface != null)
    {
      localObject = bbef.a(true);
      bayh.a(localQQAppInterface, 1, paramArrayList, 4, (Drawable)localObject, (Drawable)localObject);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
    return;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
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
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject1 == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.d != null)
    {
      this.d.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.d);
    }
    Object localObject2 = BaseApplicationImpl.getContext();
    this.d = new ImageView((Context)localObject2);
    int i = actj.a(1.0F, ((Context)localObject2).getResources());
    this.d.setPadding(i, i, i, i);
    this.d.setBackgroundResource(2130844309);
    localObject2 = new RelativeLayout.LayoutParams(this.jdField_a_of_type_AndroidWidgetImageView.getWidth(), this.jdField_a_of_type_AndroidWidgetImageView.getHeight());
    ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131367377);
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131367377);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.d, (ViewGroup.LayoutParams)localObject2);
    try
    {
      localObject2 = (String)this.jdField_b_of_type_JavaUtilList.remove(this.jdField_b_of_type_JavaUtilList.size() - 1);
      if (QLog.isColorLevel()) {
        QLog.d("MatchViewHolder", 0, "startAnimation targetUin = " + (String)localObject2);
      }
      this.jdField_b_of_type_JavaUtilList.add(0, localObject2);
      Drawable localDrawable = bbef.a(true);
      localObject1 = bayh.a((AppInterface)localObject1, 1, (String)localObject2, 4, localDrawable, localDrawable);
      this.d.setImageDrawable((Drawable)localObject1);
      localObject1 = new ScaleAnimation(1.0F, 1.2F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
      ((ScaleAnimation)localObject1).setDuration(500);
      ((ScaleAnimation)localObject1).setFillAfter(true);
      ((ScaleAnimation)localObject1).setAnimationListener(new aynt(this));
      this.d.startAnimation((Animation)localObject1);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MatchViewHolder", 1, "startAnimation Exception!", localException);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
    }
  }
  
  void e()
  {
    int j = this.jdField_a_of_type_AndroidWidgetImageView.getWidth() - actj.a(5.0F, BaseApplicationImpl.getContext().getResources());
    Object localObject1 = ObjectAnimator.ofFloat(this.jdField_c_of_type_AndroidWidgetImageView, "translationX", new float[] { 0.0F, j });
    Object localObject2 = ObjectAnimator.ofFloat(this.jdField_c_of_type_AndroidWidgetImageView, "alpha", new float[] { 1.0F, 0.0F });
    ((ObjectAnimator)localObject1).setDuration(300);
    ((ObjectAnimator)localObject2).setDuration(300);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObject1, localObject2 });
    localObject2 = new aynv(this, localAnimatorSet);
    localObject1 = new ArrayList();
    int i = 0;
    while (i < 2)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, j, 0.0F, 0.0F);
      localTranslateAnimation.setDuration(300);
      localTranslateAnimation.setFillAfter(true);
      ((List)localObject1).add(localTranslateAnimation);
      i += 1;
    }
    ((TranslateAnimation)((List)localObject1).get(0)).setAnimationListener((Animation.AnimationListener)localObject2);
    i = 0;
    while (i < 2)
    {
      localObject2 = (ImageView)this.jdField_a_of_type_JavaUtilList.get(i);
      ((ImageView)localObject2).clearAnimation();
      ((ImageView)localObject2).startAnimation((Animation)((List)localObject1).get(i));
      i += 1;
    }
    localAnimatorSet.start();
  }
  
  public void f()
  {
    a();
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_AndroidOsHandler$Callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayns
 * JD-Core Version:    0.7.0.1
 */