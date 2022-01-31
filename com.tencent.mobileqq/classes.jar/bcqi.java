import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController.1;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;
import com.tencent.mobileqq.troopgift.TroopGiftToPersonalSurfaceView;
import com.tencent.qphone.base.util.QLog;

public class bcqi
  implements View.OnClickListener, TopGestureLayout.OnGestureListener
{
  public int a;
  private long jdField_a_of_type_Long;
  protected aizl a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  public Drawable a;
  public Handler a;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  public ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private attr jdField_a_of_type_Attr;
  private baaa jdField_a_of_type_Baaa;
  private baae jdField_a_of_type_Baae = new bcql(this);
  private bcjt jdField_a_of_type_Bcjt = new bcqk(this);
  public bcqt a;
  private bcqu jdField_a_of_type_Bcqu;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  public TopGestureLayout a;
  private MessageForDeliverGiftTips jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips;
  public SpriteGLView a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new TroopGiftAnimationController.1(this);
  public Drawable b;
  
  public bcqi(BaseChatPie paramBaseChatPie, Activity paramActivity, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAnimationController", 2, "initMagicfaceView begins");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      if (!paramBoolean) {
        break label109;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)View.inflate(BaseApplicationImpl.getContext(), 2131560506, null));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setOnFlingGesture(this);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = ((SpriteGLView)this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131378446));
      if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView instanceof TroopGiftToPersonalSurfaceView)) {
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131378444));
      }
      try
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846643);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        return;
        label109:
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)View.inflate(BaseApplicationImpl.getContext(), 2131560507, null));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("TroopGiftAnimationController", 2, "mStopBtn setImage failed", localException);
        }
      }
    }
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public Drawable a(String paramString, bcxc parambcxc)
  {
    Object localObject1 = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = (aloz)((AppInterface)localObject1).getManager(51);
    HotChatManager localHotChatManager = (HotChatManager)((AppInterface)localObject1).getManager(60);
    int i;
    int j;
    label74:
    int k;
    if ((localHotChatManager != null) && (localHotChatManager.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin)))
    {
      i = 1;
      if ((localObject2 == null) || (!((aloz)localObject2).b(paramString))) {
        break label130;
      }
      j = 1;
      k = this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.istroop;
      if (!paramString.equals("80000000")) {
        break label136;
      }
      paramString = BaseApplicationImpl.getApplication().getResources().getDrawable(2130843228);
      parambcxc = URLDrawable.getDrawable(nav.a(nav.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips).b), paramString, paramString);
    }
    label130:
    label136:
    do
    {
      return parambcxc;
      i = 0;
      break;
      j = 0;
      break label74;
      if (((k != 1010) && (k != 1001) && (k != 10002) && ((i == 0) || ((j != 0) && (!paramString.equals(((AppInterface)localObject1).getCurrentAccountUin()))))) || (localObject2 == null) || (((aloz)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin))) {
        break label252;
      }
      localObject1 = bcxb.a((AppInterface)localObject1, 200, paramString, 3, parambcxc, true);
      parambcxc = (bcxc)localObject1;
    } while (!QLog.isColorLevel());
    QLog.d("TroopGiftAnimationController", 2, "getFaceDrawable, uin = " + paramString);
    return localObject1;
    label252:
    localObject2 = bcxb.a(1, 3);
    return bcxb.a((AppInterface)localObject1, 1, String.valueOf(paramString), 3, (Drawable)localObject2, (Drawable)localObject2, parambcxc);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bcqt != null)
    {
      this.jdField_a_of_type_Bcqt.a();
      this.jdField_a_of_type_Bcqt = null;
      this.jdField_a_of_type_Baaa = null;
    }
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.isToAll())) {
      if (this.jdField_a_of_type_Int >= 4) {
        alsy.a("cartoon", "clk_close", this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, "", "", "");
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips == null) || (this.jdField_a_of_type_Int >= 4))
    {
      b();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
      for (str = "0";; str = "1")
      {
        azmj.b(null, "dc00899", "Grp_flower", "", "forall", "Clk_close", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, "" + bckh.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips), str, "" + mwu.a(localAppInterface, localAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin));
        break;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
    for (String str = "0";; str = "1")
    {
      azmj.b(null, "dc00899", "Grp_flower", "", "video_mall", "Clk_comctn_close", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, "" + bckh.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips), str, "" + mwu.a(localAppInterface, localAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin));
      break;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, attr paramattr)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftAnimationController", 2, "startSendGiftHeadAnimation");
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null);
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAnimationController", 2, "创建头像时间 = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAnimationController", 2, "sendFlowerSurfaceView show");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView instanceof TroopGiftToPersonalSurfaceView))
    {
      ((TroopGiftToPersonalSurfaceView)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(new bcqm(this));
      if ((!this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.isToAll()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.animationBrief))) {
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.animationBrief, this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.giftCount, paramInt, paramattr);
      }
    }
    label155:
    while (QLog.isColorLevel())
    {
      QLog.d("TroopGiftAnimationController", 2, "endstartSendGiftHeadAnimation");
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView instanceof TroopGiftToAllSurfaceView))
      {
        this.jdField_a_of_type_Bcqu = new bcqu(this);
        ((TroopGiftToAllSurfaceView)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(this.jdField_a_of_type_Bcqu);
        String str;
        label218:
        AppInterface localAppInterface;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
        {
          str = "0";
          localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if (this.jdField_a_of_type_Int < 4) {
            break label375;
          }
          alsy.a("cartoon", "exp_cartoon", this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, bckh.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips) + "", "", "");
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.showButton)
          {
            ((TroopGiftToAllSurfaceView)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(this.jdField_a_of_type_Baae);
            if (this.jdField_a_of_type_Int >= 4)
            {
              alsy.a("cartoon", "exp_inter", this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, bckh.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips) + "", "", "");
              break;
              str = "1";
              break label218;
              label375:
              azmj.b(null, "dc00899", "Grp_flower", "", "forall", "exp_anime", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, "" + bckh.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips), str, "" + mwu.a(localAppInterface, localAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin));
              continue;
            }
            azmj.b(null, "dc00899", "Grp_flower", "", "forall", "exp_grab", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, "" + bckh.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips), str, "" + mwu.a(localAppInterface, localAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin));
            break;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.resultType != 0) {
          break label647;
        }
      }
    }
    label647:
    for (paramInt = paramattr.m;; paramInt = paramattr.n)
    {
      ((TroopGiftToAllSurfaceView)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.resultText, paramInt, bcwh.a(this.jdField_a_of_type_AndroidAppActivity, 16.0F));
      break label155;
      break;
    }
  }
  
  public void a(long paramLong)
  {
    if (paramLong == 0L)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
  }
  
  public void a(aizl paramaizl)
  {
    if (this.jdField_a_of_type_Aizl != null) {
      this.jdField_a_of_type_Aizl.a();
    }
    this.jdField_a_of_type_Aizl = paramaizl;
  }
  
  public void a(baaa parambaaa)
  {
    this.jdField_a_of_type_Baaa = parambaaa;
  }
  
  public void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAnimationController", 2, "play TroopGiftAnimation Start,packageId:" + bckh.b(paramMessageForDeliverGiftTips));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agmy))
    {
      int i = ((agmy)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).j();
      if (i == 2) {
        if (QLog.isColorLevel()) {
          QLog.d("TroopGiftAnimationController", 2, "playMaigcface return.Current hotchatTabMode:" + i);
        }
      }
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips = paramMessageForDeliverGiftTips;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopGiftAnimationController", 2, "find troopAnimationLayout");
      return;
      Emoticon localEmoticon = new Emoticon();
      localEmoticon.epId = bckh.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips);
      this.jdField_a_of_type_Attr = atuj.a(localEmoticon, 1, 2, paramMessageForDeliverGiftTips.animationType);
      if (this.jdField_a_of_type_Attr != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftAnimationController", 2, "find actionGlobaData");
      }
    } while (this.jdField_a_of_type_Baaa == null);
    this.jdField_a_of_type_Baaa.a();
    this.jdField_a_of_type_Baaa = null;
    return;
    if (this.jdField_a_of_type_AndroidViewWindowManager == null) {
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window"));
    }
    a(paramMessageForDeliverGiftTips.isToAll());
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.setVisibility(0);
    ThreadManager.post(new TroopGiftAnimationController.5(this, paramMessageForDeliverGiftTips), 8, null, true);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, attr paramattr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAnimationController", 2, "startSendFlowerTip");
    }
    if ((TextUtils.isEmpty(paramString)) || (paramInt1 <= 0)) {}
    for (;;)
    {
      return;
      String str = "×" + paramInt1;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
      if ((paramattr == null) || (paramattr.e))
      {
        localSpannableStringBuilder.append(str);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(255, 238, 33)), paramString.length(), paramString.length() + str.length(), 18);
        localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(bcwh.c(this.jdField_a_of_type_AndroidAppActivity, 17.0F)), paramString.length(), paramString.length() + 1, 18);
        AbsoluteSizeSpan localAbsoluteSizeSpan = new AbsoluteSizeSpan(bcwh.c(this.jdField_a_of_type_AndroidAppActivity, 19.0F));
        paramInt1 = paramString.length();
        int i = paramString.length();
        localSpannableStringBuilder.setSpan(localAbsoluteSizeSpan, paramInt1 + 1, str.length() + i, 18);
        label203:
        if (this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation == null)
        {
          this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
          this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(500L);
        }
        paramString = new RelativeLayout.LayoutParams(-2, (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131297904));
        paramString.addRule(14);
        paramString.setMargins(bcwh.a(this.jdField_a_of_type_AndroidAppActivity, 10.0F), paramInt2, bcwh.a(this.jdField_a_of_type_AndroidAppActivity, 10.0F), 0);
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          break label552;
        }
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 15.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130843468);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131167192));
        this.jdField_a_of_type_AndroidWidgetTextView.setPadding(bcwh.a(this.jdField_a_of_type_AndroidAppActivity, 30.0F), this.jdField_a_of_type_AndroidWidgetTextView.getPaddingTop(), bcwh.a(this.jdField_a_of_type_AndroidAppActivity, 30.0F), this.jdField_a_of_type_AndroidWidgetTextView.getPaddingBottom());
        label419:
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramString);
        if (paramattr == null) {
          break label563;
        }
      }
      try
      {
        if (paramattr.g != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.getBackground().setColorFilter(new LightingColorFilter(-16777216, Color.parseColor(paramattr.g)));
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TroopGiftAnimationController", 2, "startSendFlowerTip Success");
          return;
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(255, 238, 33)), paramString.length(), paramString.length(), 18);
          break label203;
          label552:
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramString);
          break label419;
          label563:
          this.jdField_a_of_type_AndroidWidgetTextView.getBackground().setColorFilter(null);
        }
      }
      catch (IllegalArgumentException paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(".troop.send_gift", 2, "parse detail strip bg clor failed. Color value is " + paramattr.g, paramString);
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView != null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.n();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.removeAllViews();
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = null;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = null;
      this.jdField_a_of_type_Bcqu = null;
      this.jdField_a_of_type_AndroidWidgetImageView = null;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.hasFetchButFailed = false;
        azmj.b(null, "P_CliOper", "BizTechReport", "troop_gift_animation", "", "play_success", 0, (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, bckh.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips), "", "");
      }
      if (this.jdField_a_of_type_Baaa != null) {
        this.jdField_a_of_type_Baaa.a();
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof bcxb))) {
        ((bcxb)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).a();
      }
      if ((this.b != null) && ((this.b instanceof bcxb)))
      {
        ((bcxb)this.b).a();
        if (this.jdField_a_of_type_Aizl != null)
        {
          this.jdField_a_of_type_Aizl.a();
          this.jdField_a_of_type_Aizl = null;
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e(".troop.send_gift", 2, "closeGiftAnimation exception ", localException);
          continue;
          if ((this.b instanceof URLDrawable))
          {
            ((URLDrawable)this.b).cancelDownload();
            ((URLDrawable)this.b).setDownloadListener(null);
            ((URLDrawable)this.b).setURLDrawableListener(null);
          }
        }
      }
    }
  }
  
  public void c()
  {
    b();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void flingLToR()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie))) {
      ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).bv();
    }
  }
  
  public void flingRToL() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcqi
 * JD-Core Version:    0.7.0.1
 */