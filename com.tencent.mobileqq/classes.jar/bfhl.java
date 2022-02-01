import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic.2;
import com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class bfhl
  extends Observable
  implements Observer
{
  protected int a;
  public View a;
  protected Animation.AnimationListener a;
  protected TranslateAnimation a;
  protected ImageView a;
  protected RelativeLayout a;
  protected awne a;
  protected beqr a;
  protected besf a;
  bhxt a;
  protected SessionInfo a;
  protected QQAppInterface a;
  protected String a;
  protected WeakReference<FragmentActivity> a;
  protected boolean a;
  protected TranslateAnimation b;
  protected ImageView b;
  protected RelativeLayout b;
  protected boolean b;
  protected boolean c;
  protected boolean d;
  protected boolean e;
  protected boolean f;
  protected boolean g;
  protected boolean h;
  protected boolean i;
  protected boolean j;
  protected boolean k;
  
  public bfhl(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout, ImageView paramImageView, beqr parambeqr, boolean paramBoolean, Observer paramObserver)
  {
    this.jdField_a_of_type_JavaLangString = "0";
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new bfhm(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFragmentActivity);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_b_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Beqr = parambeqr;
    this.j = paramBoolean;
    this.k = paramQQAppInterface.a(true).b(paramSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Int = paramFragmentActivity.getResources().getDimensionPixelSize(2131299034);
    this.jdField_a_of_type_Awne = ((awne)paramQQAppInterface.getManager(37));
    if (this.jdField_a_of_type_Awne != null) {}
    try
    {
      this.jdField_a_of_type_Besf = this.jdField_a_of_type_Awne.a(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)), true);
      this.jdField_a_of_type_Besf.addObserver(this);
      if (paramObserver != null) {
        addObserver(paramObserver);
      }
      return;
    }
    catch (NumberFormatException paramFragmentActivity)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopFeedsCenterLogic", 2, "NumberFormatException, mSessionInfo.curFriendUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        bcst.b(paramQQAppInterface, "P_CliOper", "BizTechReport", ".troop.notification_center", "TroopFeedsCenterLogic init", "", 0, 0, paramSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      }
    }
  }
  
  private void e(boolean paramBoolean)
  {
    Object localObject = (FragmentActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!paramBoolean) {
            break;
          }
        } while (a());
        if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((BaseActivity)localObject).findViewById(2131369003));
        if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("TroopFeedsCenterLogic", 2, "mRightTitleLayout == null," + localObject.getClass().getName());
      return;
      int m = afur.a(10.0F, ((FragmentActivity)localObject).getResources());
      int n = afur.a(8.0F, ((FragmentActivity)localObject).getResources());
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(((BaseActivity)localObject).getActivity());
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130850388);
      localObject = new RelativeLayout.LayoutParams(m, m);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131368956);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131368956);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, n, 0, 0);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
      return;
    } while ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return this.jdField_a_of_type_AndroidViewView.getHeight();
    }
    return 0;
  }
  
  public void a()
  {
    Object localObject = (FragmentActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Beqr != null) {
        this.jdField_a_of_type_Beqr.d = false;
      }
      if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == null)
      {
        localObject = AnimationUtils.loadInterpolator(((BaseActivity)localObject).getActivity(), 17432582);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_Int * -1);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(250L);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator((Interpolator)localObject);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
      }
    } while (this.i);
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Bhxt = new bhxt(paramQQAppInterface, paramContext, paramString1, paramString2);
    try
    {
      this.jdField_a_of_type_Bhxt.show();
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopFeedsCenterLogic.troop.notification_center", 2, "destory");
    }
    e(false);
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof TroopAioFeedsCenterView)))
    {
      ((TroopAioFeedsCenterView)this.jdField_a_of_type_AndroidViewView).c();
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidViewView != null)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_Beqr != null) {
      this.jdField_a_of_type_Beqr.d = false;
    }
    if (this.jdField_a_of_type_Besf != null)
    {
      this.jdField_a_of_type_Besf.deleteObserver(this);
      this.jdField_a_of_type_Besf.a();
      if (this.jdField_a_of_type_Awne == null) {
        this.jdField_a_of_type_Awne = ((awne)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37));
      }
      this.jdField_a_of_type_Awne.a(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
    }
    if ((this.jdField_a_of_type_Bhxt != null) && (this.jdField_a_of_type_Bhxt.isShowing())) {
      this.jdField_a_of_type_Bhxt.dismiss();
    }
    deleteObservers();
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    a();
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject1 = (FragmentActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null) {
      return;
    }
    this.g = paramBoolean;
    if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_Boolean))
    {
      if (this.g) {
        this.d = false;
      }
      this.c = true;
      d(false);
      bftr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1102858908);
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(0));
    }
    Object localObject2;
    for (this.jdField_a_of_type_JavaLangString = "1";; this.jdField_a_of_type_JavaLangString = "0")
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Beqr != null) {
        this.jdField_a_of_type_Beqr.d = true;
      }
      if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null)
      {
        localObject2 = AnimationUtils.loadInterpolator(((BaseActivity)localObject1).getActivity(), 17432582);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_a_of_type_Int * -1, 0.0F);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(250L);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator((Interpolator)localObject2);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillEnabled(true);
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        break label492;
      }
      localObject2 = (bfsk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
      this.jdField_a_of_type_AndroidViewView = new TroopAioFeedsCenterView(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((bfsk)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this);
      this.jdField_a_of_type_AndroidViewView.setFocusableInTouchMode(true);
      this.jdField_a_of_type_AndroidViewView.setId(2131379168);
      localObject2 = new RelativeLayout.LayoutParams(-1, this.jdField_a_of_type_Int);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ((FragmentActivity)localObject1).getResources().getDimensionPixelSize(2131298998);
      int m = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() - 1;
      while (m >= 0)
      {
        localObject1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(m);
        if ((localObject1 instanceof TroopAioFeedsCenterView))
        {
          ((TroopAioFeedsCenterView)localObject1).c();
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView((View)localObject1);
        }
        m -= 1;
      }
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject2);
    this.c = true;
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    if (this.c) {
      ((TroopAioFeedsCenterView)this.jdField_a_of_type_AndroidViewView).b();
    }
    while (!this.c) {
      if ((this.jdField_a_of_type_Besf != null) && (this.jdField_a_of_type_Besf.a != null) && (this.jdField_a_of_type_Besf.a.size() > 0))
      {
        if (!paramBoolean)
        {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", "", "");
          return;
          label492:
          if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0)
          {
            this.jdField_a_of_type_AndroidViewView.setVisibility(4);
            this.jdField_a_of_type_AndroidViewView.requestLayout();
            this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
            if (this.c) {
              ((TroopAioFeedsCenterView)this.jdField_a_of_type_AndroidViewView).b();
            }
          }
        }
        else
        {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", this.jdField_a_of_type_JavaLangString, "");
        }
      }
      else
      {
        if (!paramBoolean)
        {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", "", "");
          return;
        }
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", this.jdField_a_of_type_JavaLangString, "");
        return;
      }
    }
    this.h = true;
  }
  
  public void d(boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = (FragmentActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localFragmentActivity == null) {
      return;
    }
    if (paramBoolean)
    {
      this.c = true;
      if (!a())
      {
        this.jdField_a_of_type_Boolean = true;
        e(true);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localFragmentActivity.getString(2131696506));
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    e(false);
    this.jdField_b_of_type_Boolean = false;
    if (a())
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localFragmentActivity.getString(2131696505));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(localFragmentActivity.getString(2131696504));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      paramObservable = (Integer)paramObject;
      if (paramObservable.intValue() != 104) {
        break label42;
      }
      this.c = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new TroopFeedsCenterLogic.2(this));
    }
    label42:
    label196:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if ((paramObservable.intValue() != 101) && (paramObservable.intValue() != 103)) {
            break;
          }
          if (this.h)
          {
            if ((this.jdField_a_of_type_Besf == null) || (this.jdField_a_of_type_Besf.a == null) || (this.jdField_a_of_type_Besf.a.size() <= 0)) {
              break label196;
            }
            if (this.g) {
              break label157;
            }
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", "", "");
          }
          while (paramObservable.intValue() == 103)
          {
            this.c = true;
            return;
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", "", "");
            continue;
            if (!this.g) {
              bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", "", "");
            } else {
              bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", "", "");
            }
          }
        }
      } while (((paramObservable.intValue() != 1008) && (paramObservable.intValue() != 1009)) || (this.jdField_a_of_type_Besf.a.size() <= 0));
      paramObject = (TroopFeedItem)this.jdField_a_of_type_Besf.a.get(0);
    } while (((paramObject.type != 5) && (paramObject.type != 19)) || (paramObservable.intValue() != 1009));
    label157:
    d(false);
    bftr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1102858908);
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfhl
 * JD-Core Version:    0.7.0.1
 */