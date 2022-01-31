import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopAIONotifyItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.data.TroopAioNotificationBar.1;
import com.tencent.mobileqq.troop.data.TroopAioNotificationBar.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.URLThemeImageView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class bbqf
  extends bbpi
  implements View.OnClickListener, Animation.AnimationListener
{
  protected Animation a;
  protected List<TroopAIONotifyItem> a;
  private View jdField_b_of_type_AndroidViewView;
  protected Animation b;
  private boolean jdField_b_of_type_Boolean;
  private View c;
  protected Animation c;
  
  public bbqf()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewAnimationAnimation != null) && (this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0))
      {
        this.jdField_b_of_type_AndroidViewView.clearAnimation();
        this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      }
    }
  }
  
  private void a(TroopAIONotifyItem paramTroopAIONotifyItem)
  {
    if (paramTroopAIONotifyItem == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAioNotificationBar", 2, "notifyItem : " + paramTroopAIONotifyItem.toString());
    }
    Object localObject1 = (URLThemeImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378312);
    for (;;)
    {
      try
      {
        Object localObject2 = new URL(paramTroopAIONotifyItem.icon);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = bdhj.b();
        localURLDrawableOptions.mLoadingDrawable = localDrawable;
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        localObject2 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
        if (((URLDrawable)localObject2).getStatus() == 2) {
          ((URLDrawable)localObject2).restartDownload();
        }
        ((URLThemeImageView)localObject1).setImageDrawable((Drawable)localObject2);
        ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378315)).setText(paramTroopAIONotifyItem.title);
        localObject1 = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378314);
        ((TextView)localObject1).setText(paramTroopAIONotifyItem.summary);
        if (!TextUtils.isEmpty(paramTroopAIONotifyItem.summary)) {
          break label223;
        }
        ((TextView)localObject1).setVisibility(8);
        ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378311)).setBackgroundResource(2130850080);
        if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label231;
        }
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130850078);
        return;
      }
      catch (MalformedURLException paramTroopAIONotifyItem) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("TroopAioNotificationBar", 2, paramTroopAIONotifyItem.toString());
      return;
      label223:
      ((TextView)localObject1).setVisibility(0);
    }
    label231:
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130850079);
  }
  
  private void f()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new TroopAioNotificationBar.1(this));
      return;
    }
    a(-1);
  }
  
  private void g()
  {
    TroopAIONotifyItem localTroopAIONotifyItem;
    if ((this.jdField_c_of_type_AndroidViewView.getVisibility() == 8) && (this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewAnimationAnimation != null))
    {
      this.jdField_b_of_type_AndroidViewView.clearAnimation();
      this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localTroopAIONotifyItem = (TroopAIONotifyItem)this.jdField_a_of_type_JavaUtilList.get(0);
        if ((localTroopAIONotifyItem != null) && (localTroopAIONotifyItem.hideMode == 1)) {
          bclt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopAIONotifyItem);
        }
        if ((localTroopAIONotifyItem == null) || (localTroopAIONotifyItem.type != 1)) {
          break label182;
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_notice", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "" + localTroopAIONotifyItem.appId, "");
      }
    }
    for (;;)
    {
      b();
      return;
      label182:
      if ((localTroopAIONotifyItem != null) && (localTroopAIONotifyItem.type == 2)) {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_oper_notice", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "" + localTroopAIONotifyItem.appId, "");
      }
    }
  }
  
  public View a()
  {
    return this.jdField_c_of_type_AndroidViewView;
  }
  
  public void a(List<TroopAIONotifyItem> paramList)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList = paramList;
    } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null);
    if (this.jdField_c_of_type_AndroidViewView == null) {
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560397, null);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_c_of_type_AndroidViewView) == -1)
    {
      paramList = new RelativeLayout.LayoutParams(-2, -2);
      paramList.topMargin = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
      paramList.addRule(11);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView, paramList);
    }
    paramList = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    int i = bbqa.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new int[] { 2131378474, 2131373445, 2131373530, 2131373525 });
    if (i > 0) {
      paramList.addRule(3, i);
    }
    if (this.jdField_b_of_type_AndroidViewView == null) {
      this.jdField_b_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131378310);
    }
    this.jdField_c_of_type_AndroidViewView.setBackgroundResource(17170445);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    a((TroopAIONotifyItem)this.jdField_a_of_type_JavaUtilList.get(0));
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130843458);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  boolean a()
  {
    return (this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() != 8);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(500L);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    }
    if (this.jdField_b_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(500L);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    }
    if (this.jdField_c_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_c_of_type_AndroidViewAnimationAnimation = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
      this.jdField_c_of_type_AndroidViewAnimationAnimation.setDuration(500L);
      this.jdField_c_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    }
  }
  
  protected void d()
  {
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      this.jdField_b_of_type_AndroidViewView.clearAnimation();
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      ViewGroup localViewGroup = (ViewGroup)this.jdField_c_of_type_AndroidViewView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this.jdField_c_of_type_AndroidViewView);
      }
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_b_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_c_of_type_AndroidViewAnimationAnimation = null;
  }
  
  public void e()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new TroopAioNotificationBar.2(this));
      return;
    }
    g();
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation.equals(this.jdField_b_of_type_AndroidViewAnimationAnimation))
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      if (QLog.isColorLevel()) {
        QLog.d("TroopAioNotificationBar", 2, "onAnimationEnd: list.size=" + i + ", mArrowImageRotated:" + this.jdField_b_of_type_Boolean);
      }
      this.jdField_b_of_type_AndroidViewView.clearAnimation();
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("TroopAioNotificationBar", 4, "TroopAioMsgNavigateBar onClick v == null");
      }
    }
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131362251: 
        f();
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0));
    paramView = (TroopAIONotifyItem)this.jdField_a_of_type_JavaUtilList.remove(0);
    if (paramView.type == 1)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_notice", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "" + paramView.appId, "");
      if (!paramView.url.startsWith("http")) {
        break label300;
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramView.url);
      syb.a(localIntent, paramView.url);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
    for (;;)
    {
      if (paramView.hideMode == 2) {
        bclt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
      }
      f();
      return;
      if (paramView.type != 2) {
        break;
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_oper_notice", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "" + paramView.appId, "");
      break;
      label300:
      if (paramView.url.startsWith("mqqapi")) {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface instanceof QQAppInterface)) {
          bdib.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView.url).c();
        } else {
          this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).setData(Uri.parse(paramView.url)));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqf
 * JD-Core Version:    0.7.0.1
 */