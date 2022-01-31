import SummaryCard.TPraiseInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import mqq.os.MqqHandler;

public class amwq
  extends beem
  implements Handler.Callback
{
  public static final int[] a;
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int;
  public amws a;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  aqem jdField_a_of_type_Aqem;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public List<TPraiseInfo> a;
  private Random jdField_a_of_type_JavaUtilRandom;
  public MqqHandler a;
  public boolean a;
  private int jdField_b_of_type_Int;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  public boolean b;
  private int c;
  public boolean c;
  private int d;
  public boolean d;
  private int e;
  private int f;
  private int g;
  private int h = -1;
  private int i = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 10, 25, 45, 60, 75, 100 };
  }
  
  public amwq(Context paramContext, AppInterface paramAppInterface, int paramInt)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new babk(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Double = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Amws = new amws();
  }
  
  public amwq(Context paramContext, AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    this(paramContext, paramAppInterface, paramInt1);
    this.i = paramInt2;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt / 10000 >= 1.0D)
    {
      if (paramInt % 10000 > 1000) {}
      for (DecimalFormat localDecimalFormat = new DecimalFormat("#.#");; localDecimalFormat = new DecimalFormat("#")) {
        return localDecimalFormat.format(paramInt / 10000.0F) + ajjy.a(2131641806);
      }
    }
    return String.valueOf(paramInt);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (!this.jdField_a_of_type_Amws.a()) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_c_of_type_Int == 1) {
      if (this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      }
    }
    for (;;)
    {
      int k;
      label94:
      Object localObject;
      label109:
      int m;
      if (!paramBoolean1)
      {
        this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        paramInt = this.jdField_d_of_type_Int;
        k = paramInt;
        if (localLayoutParams != null)
        {
          localLayoutParams.topMargin = 0;
          k = paramInt;
        }
        if (this.i == 2)
        {
          localObject = a(k);
          if (!(this.jdField_a_of_type_Amws.b instanceof TextView)) {
            break label683;
          }
          ((TextView)this.jdField_a_of_type_Amws.b).setText((CharSequence)localObject);
          label137:
          if (localLayoutParams == null) {
            break label712;
          }
          if (this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
            break label714;
          }
          this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
          return;
          localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Amws.b.getLayoutParams();
        }
      }
      else
      {
        localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidViewView.getLayoutParams();
        if (paramBoolean2) {
          if (this.jdField_c_of_type_Int == 0)
          {
            ((ViewGroup.MarginLayoutParams)localObject).topMargin = ((int)(7.0D * this.jdField_a_of_type_Double));
            label223:
            ((ViewGroup.MarginLayoutParams)localObject).width = ((int)(6.0D * this.jdField_a_of_type_Double + 0.5D));
            ((ViewGroup.MarginLayoutParams)localObject).height = ((int)(6.0D * this.jdField_a_of_type_Double + 0.5D));
            this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            k = this.jdField_d_of_type_Int;
            if (localLayoutParams == null) {
              break label727;
            }
            localLayoutParams.topMargin = 0;
            m = 2130849054;
          }
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidViewView.setBackgroundResource(m);
        this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
        break label94;
        if (this.jdField_c_of_type_Int == 1)
        {
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = ((int)(3.0D * this.jdField_a_of_type_Double + 0.5D));
          break label223;
        }
        if (this.jdField_c_of_type_Int != 2) {
          break label223;
        }
        if ((localObject instanceof RelativeLayout.LayoutParams)) {
          ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
        }
        ((ViewGroup.MarginLayoutParams)localObject).leftMargin = 0;
        break label223;
        int j;
        if (this.jdField_c_of_type_Int == 0)
        {
          j = 2130849063;
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
          label418:
          ((ViewGroup.MarginLayoutParams)localObject).width = -2;
          ((ViewGroup.MarginLayoutParams)localObject).height = -2;
          this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
          if (this.i != 2) {
            break label638;
          }
          this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidWidgetTextView.setText("+" + a(this.e));
        }
        for (;;)
        {
          int n = this.jdField_d_of_type_Int - this.e;
          m = j;
          k = n;
          if (localLayoutParams == null) {
            break;
          }
          localLayoutParams.topMargin = ((int)(15.0D * this.jdField_a_of_type_Double + 0.5D));
          m = j;
          k = n;
          break;
          if (this.jdField_c_of_type_Int == 1)
          {
            j = 2130849057;
            ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
            ((ViewGroup.MarginLayoutParams)localObject).rightMargin = 0;
            break label418;
          }
          if (this.jdField_c_of_type_Int == 2)
          {
            if ((localObject instanceof RelativeLayout.LayoutParams)) {
              ((RelativeLayout.LayoutParams)localObject).addRule(15);
            }
            ((ViewGroup.MarginLayoutParams)localObject).leftMargin = azvv.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), 4.0F);
            j = 2130849063;
            break label418;
          }
          if (this.jdField_c_of_type_Int == 3)
          {
            j = 2130849063;
            break label418;
          }
          j = 2130849057;
          break label418;
          label638:
          this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidWidgetTextView.setText("+" + this.e);
        }
        localObject = String.valueOf(k);
        break label109;
        label683:
        if (!(this.jdField_a_of_type_Amws.b instanceof SingleLineTextView)) {
          break label137;
        }
        ((SingleLineTextView)this.jdField_a_of_type_Amws.b).setText((CharSequence)localObject);
        break label137;
        label712:
        break;
        label714:
        this.jdField_a_of_type_Amws.b.setLayoutParams(localLayoutParams);
        return;
        label727:
        m = 2130849054;
      }
      localLayoutParams = null;
    }
  }
  
  public void a()
  {
    amvy.a("voteAnim", new Object[] { "reset" });
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    if ((this.jdField_a_of_type_Amws.a()) && (!this.jdField_d_of_type_Boolean))
    {
      this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidViewView.clearAnimation();
    }
    a(false, false, 8);
  }
  
  public void a(int paramInt1, int paramInt2, View paramView1, TextView paramTextView, View paramView2, RelativeLayout paramRelativeLayout, HeartLayout paramHeartLayout)
  {
    if ((paramView1 == null) || (paramTextView == null) || (paramView2 == null)) {
      label14:
      return;
    }
    if (paramHeartLayout != null) {
      this.jdField_d_of_type_Boolean = true;
    }
    int k;
    label32:
    int j;
    if (paramInt1 >= 0)
    {
      k = paramInt1;
      if (paramInt2 < 0) {
        break label312;
      }
      j = paramInt2;
      label39:
      if (j <= k) {
        break label321;
      }
      j = k % 20;
    }
    label53:
    label98:
    label874:
    label883:
    for (;;)
    {
      amvy.a("voteAnim", new Object[] { "updateVoteNum", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (j <= 0)
      {
        if (this.jdField_a_of_type_Int != 0) {
          a();
        }
        amvy.a("voteAnim", new Object[] { "updateVoteNum", Integer.valueOf(this.jdField_d_of_type_Int), Integer.valueOf(this.e), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(k), Integer.valueOf(j) });
        this.jdField_d_of_type_Int = k;
        if (j - this.e <= 0) {
          break label572;
        }
      }
      for (paramInt1 = j - this.e;; paramInt1 = 0)
      {
        this.e = j;
        this.jdField_a_of_type_Amws.b = paramView2;
        this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
        this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
        this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidViewView = paramView1;
        this.jdField_a_of_type_Amws.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = paramHeartLayout;
        aqem.a(this.jdField_a_of_type_Amws.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
        switch (this.jdField_a_of_type_Int)
        {
        case 1: 
        default: 
          return;
        case 0: 
          if (this.e <= 0) {
            break label874;
          }
          if (!this.jdField_c_of_type_Boolean) {
            break label593;
          }
          a(true, true, 0);
          return;
          k = this.jdField_d_of_type_Int;
          break label32;
          j = this.e;
          break label39;
          if (j >= 0) {
            break label883;
          }
          j = 0;
          break label53;
          if ((this.jdField_d_of_type_Int != k) || (this.e != j))
          {
            if ((this.i == 2) && (paramView2 != null)) {}
            try
            {
              if (paramView2.getContext() != null)
              {
                Context localContext = paramView2.getContext();
                if (((localContext instanceof NearbyActivity)) && (((NearbyActivity)localContext).a != null) && ((((NearbyActivity)localContext).a instanceof NearbyAppInterface))) {
                  ((NearbyActivity)localContext).a.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
                }
              }
              if ((this.jdField_a_of_type_Int != 1) || (!this.jdField_a_of_type_Amws.a(paramView1, paramTextView, paramView2, paramRelativeLayout, paramHeartLayout))) {
                break label535;
              }
              this.f = paramInt1;
              this.g = paramInt2;
              if ((this.jdField_d_of_type_Boolean) && (!befo.e()))
              {
                a();
                return;
              }
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("NewVote err :FROM_NEARBY_PROFILE_CARD", 2, localThrowable, new Object[0]);
                }
              }
            }
            if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1)) {
              break label14;
            }
            this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 3000L);
            return;
            a();
            break label98;
          }
          if ((this.jdField_a_of_type_Int != 2) || ((!this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))) {
            break label98;
          }
          this.jdField_a_of_type_Int = 3;
          break label98;
        }
      }
      a(true, true, 0);
      return;
      a(true, false, 0);
      return;
      if (this.jdField_d_of_type_Boolean) {}
      for (paramInt2 = 0;; paramInt2 = 4)
      {
        a(true, false, paramInt2);
        j = 1;
        paramInt2 = j;
        if (this.jdField_d_of_type_Boolean) {
          if (paramInt1 > 0)
          {
            paramInt2 = j;
            if (befo.e()) {}
          }
          else
          {
            paramInt2 = 0;
          }
        }
        if (paramInt2 == 0) {
          break;
        }
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
        paramView1 = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0, paramInt1, 0);
        if ((!this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
          break label836;
        }
        paramTextView = (PraiseManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(209);
        paramView2 = new HashSet();
        paramRelativeLayout = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramRelativeLayout.hasNext())
        {
          paramHeartLayout = (TPraiseInfo)paramRelativeLayout.next();
          if (paramHeartLayout.uCustomId > 0L) {
            paramView2.add(Integer.valueOf((int)paramHeartLayout.uCustomId));
          }
        }
      }
      if (paramTextView.a(paramView2, new amwr(this, paramInt1))) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramView1, 1000L);
      }
      for (;;)
      {
        this.jdField_a_of_type_Int = 1;
        this.jdField_b_of_type_Int = 0;
        return;
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramView1, atyt.jdField_b_of_type_Int);
      }
      paramTextView = this.jdField_a_of_type_MqqOsMqqHandler;
      if (this.jdField_d_of_type_Boolean) {}
      for (long l = 1000L;; l = 1500L)
      {
        paramTextView.sendMessageDelayed(paramView1, l);
        break;
      }
      a(false, false, 8);
      return;
    }
  }
  
  protected void b()
  {
    amvy.a("voteAnim", new Object[] { "finishAnim" });
    this.jdField_a_of_type_Int = 2;
    this.jdField_b_of_type_Int = 0;
    if ((this.jdField_a_of_type_Amws.a()) && (!this.jdField_d_of_type_Boolean))
    {
      this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidViewView.clearAnimation();
    }
    a(true, false, 0);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof NearbyAppInterface)) {
        ((NearbyAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a("CliOper", "", "", "0X8004ED7", "0X8004ED7", 0, 0, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", "0X8004ED7", "0X8004ED7", 0, 0, "", "", "", "");
  }
  
  public void c()
  {
    amvy.a("voteAnim", new Object[] { "endAnim", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int) });
    if (this.jdField_a_of_type_Int == 1)
    {
      if (this.jdField_b_of_type_Int == 2) {
        b();
      }
    }
    else {
      return;
    }
    if (this.jdField_b_of_type_Int == 0)
    {
      a();
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    b();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(3))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    float f2 = 0.5F;
    float f1 = 0.0F;
    int k;
    int j;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      if ((this.jdField_a_of_type_Int == 1) && (this.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_Amws.a()))
      {
        this.jdField_b_of_type_Int = 1;
        if (this.jdField_d_of_type_Boolean)
        {
          k = paramMessage.arg1;
          if (k > 0)
          {
            j = k;
            if (k > 20) {
              j = 20;
            }
            if ((this.i == 1) || (this.i == 2))
            {
              if (this.h == -1) {
                this.h = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 0).getInt("profilecard_host_last_newvote_animation_num", 0);
              }
              if ((this.e > 0) && (this.e != this.h))
              {
                this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(3, j, 0).sendToTarget();
                this.h = this.e;
                this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 0).edit().putInt("profilecard_host_last_newvote_animation_num", this.h).commit();
              }
            }
          }
          for (;;)
          {
            amvy.a("voteAnim", new Object[] { "MSG_ANIM_1", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), this.jdField_a_of_type_Amws });
            return false;
            this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(3, j, 0).sendToTarget();
            continue;
            a();
          }
        }
        f1 = 1.0F;
        if (this.jdField_c_of_type_Int != 2) {
          break label1188;
        }
        f1 = 0.5F;
      }
      break;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, f1, 1, f2);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillEnabled(true);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillBefore(true);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(400L);
        label383:
        this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidViewView.clearAnimation();
        this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        if (this.jdField_b_of_type_AndroidViewAnimationAnimation != null) {
          break label510;
        }
        this.jdField_b_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 1.0F);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillEnabled(true);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillBefore(true);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(400L);
      }
      for (;;)
      {
        this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
        this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 1100L);
        break;
        this.jdField_a_of_type_AndroidViewAnimationAnimation.reset();
        break label383;
        label510:
        this.jdField_b_of_type_AndroidViewAnimationAnimation.reset();
      }
      a();
      break;
      a(this.f, this.g, this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_Amws.b, this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Amws.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      return false;
      if ((this.jdField_a_of_type_Int == 1) && (this.jdField_b_of_type_Int == 1))
      {
        this.jdField_b_of_type_Int = 2;
        b();
        return false;
      }
      c();
      return false;
      j = paramMessage.arg1;
      if (j > 0)
      {
        int[] arrayOfInt = new int[2];
        Object localObject2;
        Object localObject1;
        TPraiseInfo localTPraiseInfo;
        long l;
        if (this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
        {
          this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidWidgetRelativeLayout.getLocationInWindow(arrayOfInt);
          paramMessage = this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131306188);
          if (paramMessage != null) {
            f1 = (paramMessage.getWidth() + this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft()) * 0.5F;
          }
          f2 = arrayOfInt[0];
          if (this.jdField_a_of_type_Aqem == null) {
            this.jdField_a_of_type_Aqem = new aqem(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), 2130844958);
          }
          paramMessage = null;
          localObject2 = null;
          localObject1 = paramMessage;
          if (this.jdField_a_of_type_JavaUtilList == null) {
            break label1155;
          }
          localObject1 = paramMessage;
          if (j - 1 >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label1155;
          }
          localTPraiseInfo = (TPraiseInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - j);
          if (localTPraiseInfo != null) {
            break label1067;
          }
          l = 0L;
          label788:
          if (l <= 0L) {
            break label1090;
          }
          localObject2 = ((PraiseManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(209)).a((int)l, true, "from_profile_card");
          localObject1 = localObject2;
          if (localObject2 == null) {
            break label1155;
          }
          if ((localTPraiseInfo.iIsPayed <= 0) || (((atyv)localObject2).c == null)) {
            break label1077;
          }
          paramMessage = ((atyv)localObject2).c;
          localObject1 = localObject2;
        }
        for (;;)
        {
          localObject2 = paramMessage;
          if (paramMessage == null) {
            localObject2 = this.jdField_a_of_type_Aqem.b();
          }
          this.jdField_a_of_type_Amws.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.a((atyv)localObject1, (Bitmap)localObject2, f2 + f1, arrayOfInt[1]);
          int m = j - 1;
          if (m <= 0) {
            break label1160;
          }
          paramMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(3, m, 0);
          if (this.jdField_a_of_type_JavaUtilRandom == null) {
            this.jdField_a_of_type_JavaUtilRandom = new Random();
          }
          k = jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_JavaUtilRandom.nextInt(jdField_a_of_type_ArrayOfInt.length)];
          j = k;
          if (m < 10.0D) {
            j = k * 2;
          }
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramMessage, j);
          return false;
          this.jdField_a_of_type_Amws.b.getLocationInWindow(arrayOfInt);
          if ((this.jdField_a_of_type_Amws.b instanceof SingleLineTextView))
          {
            f1 = ((SingleLineTextView)this.jdField_a_of_type_Amws.b).a() * 0.5F;
            break;
          }
          if (!(this.jdField_a_of_type_Amws.b instanceof TextView)) {
            break;
          }
          f1 = ((TextView)this.jdField_a_of_type_Amws.b).getCompoundPaddingLeft() * 0.5F;
          break;
          label1067:
          l = localTPraiseInfo.uCustomId;
          break label788;
          label1077:
          paramMessage = ((atyv)localObject2).b;
          localObject1 = localObject2;
          continue;
          label1090:
          localObject1 = paramMessage;
          if (localTPraiseInfo != null)
          {
            localObject1 = paramMessage;
            if (localTPraiseInfo.iIsPayed > 0) {
              try
              {
                localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getResources(), 2130841986);
                paramMessage = (Message)localObject1;
                localObject1 = localObject2;
              }
              catch (OutOfMemoryError localOutOfMemoryError)
              {
                QLog.e("NewVoteAnimHelper", 1, localOutOfMemoryError, new Object[0]);
                Message localMessage = paramMessage;
              }
            }
          }
          label1155:
          paramMessage = null;
        }
        label1160:
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 3100L);
        return false;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 100L);
      return false;
      label1188:
      f2 = 1.0F;
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    boolean bool2 = false;
    if (paramAnimation == null) {
      break label6;
    }
    label6:
    while ((paramAnimation != this.jdField_a_of_type_AndroidViewAnimationAnimation) && (paramAnimation != this.jdField_b_of_type_AndroidViewAnimationAnimation)) {
      return;
    }
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramAnimation == this.jdField_b_of_type_AndroidViewAnimationAnimation) {
        bool2 = true;
      }
      amvy.a("voteAnim", new Object[] { "end", Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
      if ((this.jdField_b_of_type_Int != 1) || (this.jdField_a_of_type_Int != 1)) {
        break;
      }
      this.jdField_b_of_type_Int = 2;
      b();
      return;
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((paramAnimation == null) || (!this.jdField_a_of_type_Amws.a())) {}
    do
    {
      return;
      if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation)
      {
        amvy.a("voteAnim", new Object[] { "start", "anim1_1" });
        this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
    } while (paramAnimation != this.jdField_b_of_type_AndroidViewAnimationAnimation);
    amvy.a("voteAnim", new Object[] { "start", "anim1_2" });
    this.jdField_a_of_type_Amws.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     amwq
 * JD-Core Version:    0.7.0.1
 */