import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

public class azte
  extends bkxp
{
  int a;
  public Drawable a;
  public SparseArray<Pair<Point, Integer>> a;
  public View a;
  public avlu a;
  public boolean a;
  public Drawable[] a;
  int b = 0;
  
  public azte()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public static Animation a(Animation.AnimationListener paramAnimationListener, float paramFloat1, float paramFloat2)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    localScaleAnimation.setRepeatMode(2);
    localScaleAnimation.setRepeatCount(-1);
    localScaleAnimation.setDuration(750L);
    localAlphaAnimation.setRepeatMode(2);
    localAlphaAnimation.setRepeatCount(-1);
    localAlphaAnimation.setDuration(750L);
    localAlphaAnimation.setAnimationListener(paramAnimationListener);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new aztf());
    return localAnimationSet;
  }
  
  public void a(QQAppInterface paramQQAppInterface, HeartLayout paramHeartLayout, Bitmap paramBitmap, aztj paramaztj, int paramInt1, boolean paramBoolean, int paramInt2, float paramFloat1, float paramFloat2)
  {
    if (bdfk.b())
    {
      if (QLog.isColorLevel()) {
        QLog.i("PraiseManager", 2, "doZanAnim, SimpleUIMode is open now");
      }
      paramHeartLayout.a(paramBitmap, paramFloat1, paramFloat2);
    }
    do
    {
      return;
      PraiseManager localPraiseManager = (PraiseManager)paramQQAppInterface.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
      if ((paramBoolean) && (localPraiseManager.a.get(Integer.valueOf(paramInt1)) == null))
      {
        localPraiseManager.a(paramaztj);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt1, new Pair(new Point((int)paramFloat1, (int)paramFloat2), Integer.valueOf(paramInt2)));
      }
      paramaztj = localPraiseManager.a(paramInt1, paramBoolean, "from_nearby_people");
      if (paramaztj != null)
      {
        if ((paramInt2 == 2) && (paramaztj.c != null))
        {
          if (this.jdField_a_of_type_Avlu != null)
          {
            paramHeartLayout.a(paramaztj, paramaztj.c, paramQQAppInterface, this.jdField_a_of_type_Avlu.a(paramInt2, paramHeartLayout.a), paramFloat1 - DisplayUtil.dip2px(paramHeartLayout.getContext(), 20.0F), paramFloat2 - DisplayUtil.dip2px(paramHeartLayout.getContext(), 120.0F), DisplayUtil.dip2px(paramHeartLayout.getContext(), 75.0F), DisplayUtil.dip2px(paramHeartLayout.getContext(), 65.0F));
            return;
          }
          paramHeartLayout.a(paramaztj, paramaztj.c, paramFloat1, paramFloat2);
          return;
        }
        paramHeartLayout.a(paramaztj, paramaztj.b, paramFloat1, paramFloat2);
        return;
      }
    } while (paramBoolean);
    paramHeartLayout.a(paramBitmap, paramFloat1, paramFloat2);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, Drawable paramDrawable, Resources paramResources)
  {
    Drawable localDrawable2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    Drawable localDrawable1;
    if (paramBoolean2) {
      localDrawable1 = nwh.a(localDrawable2, paramResources.getColor(2131165727));
    }
    while (this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = new Drawable[] { paramDrawable, localDrawable1 };
      return;
      localDrawable1 = localDrawable2;
      if (paramBoolean1) {
        localDrawable1 = nwh.a(localDrawable2, paramResources.getColor(2131165730));
      }
    }
    this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0] = paramDrawable;
    this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1] = localDrawable1;
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_Int % 2 == 0)
    {
      this.b = ((this.b + 1) % this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable.length);
      if (!(this.jdField_a_of_type_AndroidViewView instanceof ImageView)) {
        break label89;
      }
      ((ImageView)this.jdField_a_of_type_AndroidViewView).setImageDrawable(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[this.b]);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int / 2 >= aztg.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_AndroidViewView.clearAnimation();
        this.jdField_a_of_type_Boolean = false;
      }
      return;
      label89:
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[this.b]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azte
 * JD-Core Version:    0.7.0.1
 */