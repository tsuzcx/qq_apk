import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin.2;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin.4;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin.5;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class ayls
  extends aylz
{
  private static ayls jdField_a_of_type_Ayls;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private bbqb jdField_a_of_type_Bbqb = new aylu(this);
  private ChatFragment jdField_a_of_type_ComTencentMobileqqActivityChatFragment;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AIOMusicSkin.5(this);
  private ConcurrentHashMap<Integer, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e = arrl.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "is_first_show_atmosphere", true, false);
  private boolean f;
  
  public static ayls a()
  {
    if (jdField_a_of_type_Ayls == null) {}
    try
    {
      if (jdField_a_of_type_Ayls == null) {
        jdField_a_of_type_Ayls = new ayls();
      }
      return jdField_a_of_type_Ayls;
    }
    finally {}
  }
  
  private void a(View paramView)
  {
    a(paramView, true);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {}
    label74:
    label203:
    do
    {
      do
      {
        return;
        paramView = paramView.getRootView();
        b(paramView, 2131375327, 2130849026);
        b(paramView, 2131368742, 2130849040, 2130849044);
        b(paramView, 2131368429, 2130849040, 2130849044);
        Object localObject1 = paramView.findViewById(2131375327);
        Object localObject2;
        if (localObject1 != null)
        {
          if (this.jdField_a_of_type_Int == 1)
          {
            a((View)localObject1, 2131368436, 2130848777, 2130848778);
            a((View)localObject1, 2131368441, 2130849057, 2130849058);
          }
        }
        else
        {
          if (!c()) {
            break label515;
          }
          a(paramView, 2131372914, 2130848880, 2130848881);
          a(paramView, 2131372904, 2130848837, 2130848838);
          a(paramView, 2131372917, 2130848886, 2130848887);
          a(paramView, 2131372896, 2130848818, 2130848819);
          a(paramView, 2131372886, 2130848808, 2130848809);
          a(paramView, 2131372909, 2130848857, 2130848858);
          a(paramView, 2131372893, 2130837970, 2130837971);
          a(paramView, 2131372897, 2130837998, 2130838000);
          a(paramView, 2131372907, 2130838011, 2130838012);
          a(paramView, 2131372880, 2130848788, 2130848789);
          localObject1 = paramView.findViewById(2131368186);
          if (localObject1 != null) {
            a((View)localObject1, a(((View)localObject1).getContext(), 2130848771));
          }
          localObject2 = (TextView)paramView.findViewById(2131366883);
          if ((localObject2 != null) && (!axmt.b()))
          {
            i = ((TextView)localObject2).getPaddingTop();
            int j = ((TextView)localObject2).getPaddingLeft();
            int k = ((TextView)localObject2).getPaddingRight();
            int m = ((TextView)localObject2).getPaddingBottom();
            a(paramView, 2131366883, 2130848919, 2130848920, 2130848916);
            ((TextView)localObject2).setPadding(j, i, k, m);
          }
          localObject2 = paramView.findViewById(2131368187);
          if (localObject1 != null) {
            a((View)localObject2, a(((View)localObject1).getContext(), 2130848770));
          }
          b(paramView, 2131371243, 2130848820);
          a(paramView, 2131368186, 2131166947);
          a(paramView, 2131377350, 2131166851);
          a(paramView, 2131368464, 2131166851);
          localObject2 = paramView.findViewById(2131363311);
          if (localObject2 != null)
          {
            if (!c()) {
              break label548;
            }
            i = 8;
            ((View)localObject2).setVisibility(i);
          }
          localObject2 = paramView.findViewById(2131378793);
          View localView = paramView.findViewById(2131368187);
          if ((localObject2 != null) && (localView != null) && (localView.getVisibility() == 0)) {
            if (!c()) {
              break label553;
            }
          }
        }
        for (int i = 8;; i = 0)
        {
          ((View)localObject2).setVisibility(i);
          if (paramBoolean) {
            b(paramView.getContext());
          }
          if (!c()) {
            break label558;
          }
          localObject1 = b(((View)localObject1).getContext(), 2130848963);
          paramView = paramView.findViewById(2131362189);
          if (paramView == null) {
            break;
          }
          paramView.setBackgroundDrawable((Drawable)localObject1);
          return;
          a((View)localObject1, 2131368436, 2130848761, 2130848764);
          break label74;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.a() == null)) {
            break label203;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.a().a.a();
          break label203;
          i = 0;
          break label394;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment == null);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.a();
    } while (paramView == null);
    label394:
    label548:
    label553:
    label558:
    paramView.N();
    label515:
  }
  
  private static boolean b(int paramInt)
  {
    boolean bool = true;
    Object localObject = BaseApplicationImpl.getContext();
    if (localObject == null)
    {
      QLog.e("AIOMusicSkin", 1, "isThemeExists: context is null");
      return false;
    }
    bbss localbbss = bbss.a;
    localObject = localbbss.getDir((Context)localObject, localbbss.getScid(paramInt));
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("AIOMusicSkin", 1, "isThemeExists: path empty, id=" + paramInt);
      return false;
    }
    int i = ThemeUtil.getFileNumInFile(new File((String)localObject));
    QLog.e("AIOMusicSkin", 1, "isThemeExists: fileNum = " + i + ", id=" + paramInt);
    if (i > 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void a()
  {
    if (a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment, this.jdField_a_of_type_Int)) {
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(this.jdField_c_of_type_Int)) != null) && (c()))
    {
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        this.jdField_c_of_type_Boolean = true;
        a((String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(this.jdField_c_of_type_Int)));
        a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
        a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
        return;
      }
      ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null))
    {
      QLog.e("AIOMusicSkin", 1, "updateAnim: null root");
      return;
    }
    ImageView localImageView = (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131370589);
    if (localImageView == null)
    {
      QLog.e("AIOMusicSkin", 1, "updateAnim: null view");
      return;
    }
    if ((!c()) || (!this.jdField_c_of_type_Boolean) || (a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment, this.jdField_a_of_type_Int)))
    {
      localImageView.setVisibility(8);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOMusicSkin", 2, "updateAnim: last=" + this.jdField_b_of_type_Int + " cur=" + paramInt);
    }
    if (this.jdField_b_of_type_Int != paramInt) {}
    bbni localbbni1;
    for (int i = 1;; i = 0)
    {
      this.jdField_b_of_type_Int = paramInt;
      localImageView.setVisibility(0);
      bbni localbbni2 = (bbni)localImageView.getTag();
      localbbni1 = localbbni2;
      if (localbbni2 == null)
      {
        localbbni1 = new bbni(localImageView);
        localImageView.setTag(localbbni1);
      }
      switch (paramInt)
      {
      default: 
        localbbni1.a();
        return;
      }
    }
    if (i != 0) {
      localbbni1.a(a("play.png"), 1);
    }
    localbbni1.a(a("playing.png"), 0);
    return;
    if (i != 0) {
      localbbni1.a(a("pause.png"), 1);
    }
    localbbni1.a(a("pausing.png"), 0);
  }
  
  public void a(Context paramContext)
  {
    View localView;
    if ((this.e) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null))
    {
      this.e = false;
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131370569);
      if (localView != null) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    TextView localTextView = new TextView(paramContext);
    localTextView.setPadding(20, 0, 20, 0);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(localTextView);
    localTextView.setText(paramContext.getResources().getString(2131693831));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(2131755811);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(2);
    paramContext = new int[2];
    localView.getLocationOnScreen(paramContext);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.d(true);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(localView, paramContext[0] + localView.getWidth() / 2, paramContext[1] + localView.getHeight());
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a().setOnClickListener(new aylt(this));
    arrl.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "is_first_show_atmosphere", false, false);
    axqw.b(null, "dc00898", "", "", "qq_vip", "0X800A5B9", 1, 0, "", "", "", "");
  }
  
  public void a(Context paramContext, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOMusicSkin", 2, "setMusicBarSkin uin:" + this.jdField_b_of_type_JavaLangString + "  type:" + this.jdField_a_of_type_Int + " mIsUserSkin:" + this.jdField_a_of_type_Boolean);
    }
    QLog.i("AIOMusicSkin", 1, "setMusicBarSkin mIsUserSkin:" + this.jdField_a_of_type_Boolean + " mIsShowSkin:" + this.jdField_c_of_type_Boolean);
    if (paramView == null) {
      return;
    }
    paramContext = paramView.getRootView();
    b(paramContext, 2131369316, 2130849182, 2130849183);
    a(paramContext, 2131373494, 2130843993, 2130843994);
    a(paramContext, 2131370569, 2130843987, 2130843988);
    a(paramContext, 2131370587, 2131166838);
    a(paramContext, 2131370590, 2131166836);
    a(paramContext, 2131370586, 2131166838);
    paramView = (CircleProgress)paramContext.findViewById(2131370584);
    if (paramView != null)
    {
      ColorStateList localColorStateList = a(paramContext.getContext(), 2131166837);
      paramView.setBgAndProgressColor(100, a(paramContext.getContext(), 2131166839).getDefaultColor(), 100, localColorStateList.getDefaultColor());
    }
    paramContext = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString);
    if (paramContext != null)
    {
      a(paramContext.g);
      return;
    }
    a(3);
  }
  
  public void a(ChatFragment paramChatFragment, String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment = paramChatFragment;
    if ((paramInt == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.a() instanceof aemf)) && (((aemf)this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.a()).F())) {
      return;
    }
    a(paramString, paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment != null) && (this.jdField_a_of_type_Boolean)) {
      b(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.getActivity());
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 1)
    {
      this.jdField_b_of_type_Boolean = a(paramString);
      paramString = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a(paramInt, paramString);
      if ((paramString == null) || (paramString.jdField_b_of_type_Int <= 0) || (paramString.g == 3) || (paramString.h != 2) || (a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment, this.jdField_a_of_type_Int))) {
        break label236;
      }
      this.jdField_a_of_type_Boolean = true;
      if ((paramString.jdField_b_of_type_Int != this.jdField_c_of_type_Int) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        a(null);
        this.jdField_c_of_type_Int = paramString.jdField_b_of_type_Int;
        axqw.b(null, "dc00898", "", "", "qq_vip", "0X800A5BB", 1, 0, "", "", "", "");
      }
      a();
      label154:
      if (paramString != null) {
        if (!b()) {
          break label309;
        }
      }
    }
    label309:
    for (paramInt = 1;; paramInt = 2)
    {
      axqw.b(null, "dc00898", "", "", "qq_vip", "0X800A5BE", paramInt, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("AIOMusicSkin", 2, "updateState, session:" + paramString);
      }
      return;
      this.jdField_b_of_type_Boolean = true;
      break;
      label236:
      if ((paramString != null) && (paramString.jdField_b_of_type_Int == 0)) {
        axqw.b(null, "dc00898", "", "", "qq_vip", "0X800A5BB", 2, 0, "", "", "", "");
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label154;
      }
      a(null);
      this.jdField_a_of_type_Boolean = false;
      ThreadManagerV2.getUIHandlerV2().post(new AIOMusicSkin.2(this));
      break label154;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getApp().getSharedPreferences(paramString, 0).edit().putBoolean("music_skin_enabled", paramBoolean).commit();
    QLog.d("AIOMusicSkin", 1, "setEnabled old: " + this.jdField_b_of_type_Boolean + " new: " + paramBoolean);
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (!paramBoolean) {
      axqw.b(null, "dc00898", "", "", "qq_vip", "0X800A5BC", 0, 0, "", "", "", "");
    }
    a();
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public boolean a(ChatFragment paramChatFragment, int paramInt)
  {
    if (paramChatFragment == null) {
      return true;
    }
    if ((paramInt == 1) && ((paramChatFragment.a() instanceof aemf)))
    {
      if ((((aemf)paramChatFragment.a()).F()) || (axmt.b())) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return axmt.b();
  }
  
  public boolean a(String paramString)
  {
    if (this.d) {
      return true;
    }
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getApp().getSharedPreferences(paramString, 0).getBoolean("music_skin_enabled", true);
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void b(Context paramContext)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact == null) || (a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment, this.jdField_a_of_type_Int))) {
      return;
    }
    if (!c())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.a();
      return;
    }
    this.f = true;
    paramContext = a(paramContext, 2131166910);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(paramContext.getDefaultColor());
  }
  
  public void b(Context paramContext, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOMusicSkin", 2, "setAIOSkin uin:" + this.jdField_b_of_type_JavaLangString + "  type:" + this.jdField_a_of_type_Int + " mIsUserSkin:" + this.jdField_a_of_type_Boolean + " mIsShowSkin:" + this.jdField_c_of_type_Boolean + " enable:" + this.jdField_b_of_type_Boolean);
    }
    QLog.i("AIOMusicSkin", 1, "setAIOSkin mIsUserSkin:" + this.jdField_a_of_type_Boolean + " mIsShowSkin:" + this.jdField_c_of_type_Boolean);
    if ((!this.jdField_c_of_type_Boolean) || (!c()) || (a(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment, this.jdField_a_of_type_Int)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment != null) && (!paramContext.equals(this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_AndroidContentContext)))) {}
    do
    {
      return;
      a(paramView);
    } while ((!this.jdField_c_of_type_Boolean) || (!c()) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)));
    a(paramContext);
  }
  
  public void b(String paramString, int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    BaseApplicationImpl.sImageCache.evictAll();
    if (TextUtils.isEmpty(paramString))
    {
      a(paramString);
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      a();
      return;
      a(paramString);
      this.jdField_a_of_type_Boolean = true;
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    ThreadManagerV2.getUIHandlerV2().post(new AIOMusicSkin.4(this, paramBoolean));
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Int > 0;
  }
  
  public void c()
  {
    this.f = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment = null;
    if (QLog.isColorLevel()) {
      QLog.i("AIOMusicSkin", 2, "leave uin:" + this.jdField_b_of_type_JavaLangString + "  type:" + this.jdField_a_of_type_Int);
    }
    QLog.i("AIOMusicSkin", 1, "leave");
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
    axqw.b(null, "dc00898", "", "", "qq_vip", "0X800A5BF", 0, 0, String.valueOf((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L), "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayls
 * JD-Core Version:    0.7.0.1
 */