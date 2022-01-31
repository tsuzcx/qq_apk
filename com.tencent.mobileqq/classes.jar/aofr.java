import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.wiget.FeedBannerItemGradientLinearLayout;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class aofr
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aofs(this);
  Handler jdField_a_of_type_AndroidOsHandler;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private aofg jdField_a_of_type_Aofg;
  private aoiw jdField_a_of_type_Aoiw;
  List<ImageView> jdField_a_of_type_JavaUtilList;
  volatile boolean jdField_a_of_type_Boolean;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  ImageView d;
  ImageView e;
  ImageView f;
  ImageView g;
  
  public aofr(View paramView, aoiw paramaoiw, aofg paramaofg, Activity paramActivity)
  {
    super(paramView);
    this.jdField_a_of_type_Aofg = paramaofg;
    this.jdField_a_of_type_Aoiw = paramaoiw;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364692);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_Int = actn.a(4.0F, paramActivity.getResources());
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367414));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367377));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367378));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367379));
    this.d = ((ImageView)paramView.findViewById(2131367380));
    this.e = ((ImageView)paramView.findViewById(2131367381));
    this.f = ((ImageView)paramView.findViewById(2131367382));
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount())
    {
      paramaoiw = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(i);
      paramaoiw.setVisibility(8);
      this.jdField_a_of_type_JavaUtilList.add(paramaoiw);
      i += 1;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377350));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377351));
    if ((this.jdField_a_of_type_AndroidViewView instanceof RoundCorneredRelativeLayout))
    {
      paramView = (RoundCorneredRelativeLayout)this.jdField_a_of_type_AndroidViewView;
      i = bbkx.a(5.0F);
      paramView.setRadius(i, i, i, i);
    }
    ((FeedBannerItemGradientLinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367133)).a(bbkx.a(24.0F), -20771, -31578);
    paramView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364801);
    paramaoiw = Drawable.createFromPath(aojh.a(1));
    if (paramaoiw != null) {
      paramView.setImageDrawable(paramaoiw);
    }
    paramView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371896);
    paramaoiw = this.jdField_a_of_type_AndroidViewView.findViewById(2131367155);
    paramaofg = this.jdField_a_of_type_AndroidViewView.findViewById(2131362806);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new aoft(this, paramView, paramaoiw, paramaofg));
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_c_of_type_JavaUtilList != null) {
      this.jdField_c_of_type_JavaUtilList.clear();
    }
  }
  
  void a(aofo paramaofo)
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(paramaofo.jdField_a_of_type_JavaUtilList);
    if (a(this.jdField_c_of_type_JavaUtilList, (List)localObject)) {
      if (QLog.isColorLevel()) {
        QLog.d("MatchViewHolder", 0, "updateData return for same data");
      }
    }
    int j;
    QQAppInterface localQQAppInterface;
    label193:
    label234:
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.addAll((Collection)localObject);
      this.jdField_c_of_type_JavaUtilList.clear();
      this.jdField_c_of_type_JavaUtilList.addAll((Collection)localObject);
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
          break label328;
        }
        localObject = (String)paramaofo.jdField_a_of_type_JavaUtilList.get(i);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label352;
        }
        if (localQQAppInterface == null) {
          break label334;
        }
        Drawable localDrawable = bbdr.a(true);
        localObject = baxt.a(localQQAppInterface, 1, (String)localObject, 4, localDrawable, localDrawable);
        localDrawable = localImageView.getDrawable();
        if ((localDrawable != null) && (localDrawable != localObject) && ((localDrawable instanceof baxt))) {
          ((baxt)localDrawable).a();
        }
        localImageView.setImageDrawable((Drawable)localObject);
        localImageView.setVisibility(0);
      }
      for (;;)
      {
        i += 1;
        break label193;
        i = 0;
        break;
        localObject = null;
        break label234;
        localImageView.setImageDrawable(bbdr.a(true));
        localImageView.setVisibility(0);
        continue;
        localImageView.setVisibility(8);
      }
    } while (j <= 6);
    label328:
    label334:
    label352:
    paramaofo = (String)this.jdField_b_of_type_JavaUtilList.get(this.jdField_b_of_type_JavaUtilList.size() - 1);
    if (localQQAppInterface != null)
    {
      localObject = bbdr.a(true);
      baxt.a(localQQAppInterface, 1, paramaofo, 4, (Drawable)localObject, (Drawable)localObject);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
    return;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void a(aofr paramaofr, aofo paramaofo, int paramInt)
  {
    int i = paramaofo.jdField_a_of_type_JavaUtilList.size();
    String str = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131698967), new Object[] { Integer.valueOf(paramaofo.c) });
    if (QLog.isColorLevel()) {
      QLog.d("MatchViewHolder", 0, "bindView infoListSize = " + i + ",onlineNum = " + paramaofo.c);
    }
    if (paramaofo.c > 0) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(2)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    }
    paramaofo = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2, paramaofo);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramaofo);
    if ((paramaofr.jdField_b_of_type_AndroidViewView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)paramaofr.jdField_b_of_type_AndroidViewView.getLayoutParams()).topMargin = paramInt;
      paramaofr.jdField_b_of_type_AndroidViewView.requestLayout();
    }
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
        break label133;
      }
      bool1 = false;
    }
    label133:
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
    if (this.g != null)
    {
      this.g.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.g);
    }
    this.g = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
    int i = actn.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.g.setPadding(i, i, i, i);
    this.g.setBackgroundResource(2130844308);
    Object localObject2 = new RelativeLayout.LayoutParams(this.jdField_a_of_type_AndroidWidgetImageView.getWidth(), this.jdField_a_of_type_AndroidWidgetImageView.getHeight());
    ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131367377);
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131367377);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.g, (ViewGroup.LayoutParams)localObject2);
    try
    {
      localObject2 = (String)this.jdField_b_of_type_JavaUtilList.remove(this.jdField_b_of_type_JavaUtilList.size() - 1);
      if (QLog.isColorLevel()) {
        QLog.d("MatchViewHolder", 0, "startAnimation targetUin = " + (String)localObject2);
      }
      this.jdField_b_of_type_JavaUtilList.add(0, localObject2);
      Drawable localDrawable = bbdr.a(true);
      localObject1 = baxt.a((AppInterface)localObject1, 1, (String)localObject2, 4, localDrawable, localDrawable);
      this.g.setImageDrawable((Drawable)localObject1);
      localObject1 = new ScaleAnimation(1.0F, 1.2F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
      ((ScaleAnimation)localObject1).setDuration(500);
      ((ScaleAnimation)localObject1).setFillAfter(true);
      ((ScaleAnimation)localObject1).setAnimationListener(new aofu(this));
      this.g.startAnimation((Animation)localObject1);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MatchViewHolder", 1, "startAnimation Exception!", localException);
    }
  }
  
  void c()
  {
    int j = this.jdField_a_of_type_AndroidWidgetImageView.getWidth() - actn.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    Object localObject1 = ObjectAnimator.ofFloat(this.f, "translationX", new float[] { 0.0F, j });
    Object localObject2 = ObjectAnimator.ofFloat(this.f, "alpha", new float[] { 1.0F, 0.0F });
    ((ObjectAnimator)localObject1).setDuration(300);
    ((ObjectAnimator)localObject2).setDuration(300);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObject1, localObject2 });
    localObject2 = new aofw(this, localAnimatorSet);
    localObject1 = new ArrayList();
    int i = 0;
    while (i < 5)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, j, 0.0F, 0.0F);
      localTranslateAnimation.setDuration(300);
      localTranslateAnimation.setFillAfter(true);
      ((List)localObject1).add(localTranslateAnimation);
      i += 1;
    }
    ((TranslateAnimation)((List)localObject1).get(0)).setAnimationListener((Animation.AnimationListener)localObject2);
    i = 0;
    while (i < 5)
    {
      localObject2 = (ImageView)this.jdField_a_of_type_JavaUtilList.get(i);
      ((ImageView)localObject2).clearAnimation();
      ((ImageView)localObject2).startAnimation((Animation)((List)localObject1).get(i));
      i += 1;
    }
    localAnimatorSet.start();
  }
  
  public void onClick(View paramView)
  {
    long l;
    if (this.jdField_a_of_type_Aoiw != null)
    {
      l = System.currentTimeMillis();
      if ((paramView.getId() == 2131363578) || (l - this.jdField_a_of_type_Aoiw.a() >= 500L)) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Aoiw.a(l);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    this.jdField_a_of_type_Aoiw.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aofr
 * JD-Core Version:    0.7.0.1
 */