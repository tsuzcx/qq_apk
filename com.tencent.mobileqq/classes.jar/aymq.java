import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioMsgNavigateBar.2;
import com.tencent.mobileqq.troop.data.TroopAioMsgNavigateBar.3;
import com.tencent.mobileqq.troop.data.TroopAioMsgNavigateBar.4;
import com.tencent.mobileqq.troop.data.TroopAioMsgNavigateBar.5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.URLThemeImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class aymq
  extends ayly
  implements View.OnClickListener, Animation.AnimationListener
{
  public static long a;
  protected float a;
  public Handler a;
  protected Animation a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLThemeImageView jdField_a_of_type_ComTencentWidgetURLThemeImageView;
  public Object a;
  public String a;
  public List<Long> a;
  public AtomicBoolean a;
  public long b;
  View jdField_b_of_type_AndroidViewView;
  protected Animation b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public Object b;
  public String b;
  public boolean b;
  public long c;
  View c;
  protected Animation c;
  public String c;
  protected boolean c;
  public int d;
  public long d;
  public String d;
  boolean d;
  public int e;
  String e;
  public boolean e;
  protected int f;
  protected boolean f;
  protected int g;
  public boolean g;
  
  static
  {
    jdField_a_of_type_Long = 2147483647L;
  }
  
  public aymq()
  {
    this.jdField_b_of_type_Long = jdField_a_of_type_Long;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_d_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidOsHandler = new aymr(this, Looper.getMainLooper());
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  public static int a(RelativeLayout paramRelativeLayout, int... paramVarArgs)
  {
    int i = 0;
    if (paramVarArgs == null) {
      return 0;
    }
    int m = 0;
    int j = 0;
    if (i < paramVarArgs.length)
    {
      View localView = paramRelativeLayout.findViewById(paramVarArgs[i]);
      int k = m;
      int n = j;
      if (localView != null)
      {
        if (localView.getVisibility() == 0) {
          break label69;
        }
        n = j;
        k = m;
      }
      for (;;)
      {
        i += 1;
        m = k;
        j = n;
        break;
        label69:
        int i1 = localView.getBottom();
        k = m;
        n = j;
        if (i1 >= j)
        {
          k = paramVarArgs[i];
          n = i1;
        }
      }
    }
    return m;
  }
  
  private int a(int... paramVarArgs)
  {
    return a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramVarArgs);
  }
  
  private void a(String paramString)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    if (this.jdField_a_of_type_ComTencentWidgetURLThemeImageView == null) {
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView = ((URLThemeImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131311895));
    }
    if (this.jdField_e_of_type_Int == 24)
    {
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageResource(2130838345);
      return;
    }
    if (this.jdField_e_of_type_Int == 100)
    {
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageResource(2130846375);
      return;
    }
    Object localObject2;
    if ((this.jdField_e_of_type_Int != 1) && (!TextUtils.isEmpty(paramString)))
    {
      if ((!paramString.equals(this.jdField_e_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.getVisibility() == 0))
      {
        this.jdField_e_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable(azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString));
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setVisibility(0);
      localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.getLayoutParams();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
      {
        int i = azvv.a(this.jdField_a_of_type_AndroidContentContext, 30.0F);
        ((LinearLayout.LayoutParams)localObject1).height = i;
        ((LinearLayout.LayoutParams)localObject1).width = i;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        localObject2 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
        if ((localObject2 == null) || (!((HotChatManager)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (localObject1 == null) || (((ajjj)localObject1).b(paramString))) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable(azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, paramString, true));
        label276:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          localLayoutParams.leftMargin = azvv.a(this.jdField_a_of_type_AndroidContentContext, 7.0F);
        }
        label303:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
          break label624;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
        return;
        ((LinearLayout.LayoutParams)localObject1).setMargins(azvv.a(this.jdField_a_of_type_AndroidContentContext, 2.5F), azvv.a(this.jdField_a_of_type_AndroidContentContext, 2.5F), 0, azvv.a(this.jdField_a_of_type_AndroidContentContext, 2.5F));
      }
      if (this.jdField_e_of_type_Int == 22)
      {
        localObject1 = this.jdField_b_of_type_AndroidViewView.getTag();
        if (!(localObject1 instanceof aylz)) {
          break label626;
        }
        long l = ((aylz)localObject1).jdField_a_of_type_Long;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l, 0L);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = (MessageRecord)((List)localObject1).get(0);
          label453:
          if ((localObject1 == null) || (!mnf.a((MessageRecord)localObject1))) {
            break label626;
          }
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842960);
        }
      }
    }
    label624:
    label626:
    for (Object localObject1 = URLDrawable.getDrawable(mnf.a(mnf.a((MessageRecord)localObject1).b), (Drawable)localObject2, (Drawable)localObject2);; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString);
      }
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable((Drawable)localObject2);
      break label276;
      localObject1 = null;
      break label453;
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable(azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString));
      break label276;
      if (this.jdField_e_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable(null);
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageResource(2130849323);
        break label303;
      }
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
        break label303;
      }
      localLayoutParams.leftMargin = azvv.a(this.jdField_a_of_type_AndroidContentContext, 14.0F);
      break label303;
      break;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 17) || (paramInt == 11) || (paramInt == 100);
  }
  
  private void b(int paramInt)
  {
    arom localarom;
    if (this.jdField_a_of_type_Boolean)
    {
      localarom = (arom)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if (localarom != null) {
        break label25;
      }
    }
    label25:
    label65:
    do
    {
      return;
      break label65;
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        localarom.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_Int);
      }
      for (;;)
      {
        if (paramInt != 0) {
          break label171;
        }
        this.jdField_e_of_type_Int = -1;
        if ((this.jdField_b_of_type_AndroidViewView == null) || (this.jdField_b_of_type_AndroidViewAnimationAnimation == null) || (this.jdField_c_of_type_AndroidViewView == null) || (this.jdField_c_of_type_AndroidViewView.getVisibility() != 0)) {
          break;
        }
        this.jdField_b_of_type_AndroidViewView.clearAnimation();
        this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          localarom.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000, this.jdField_e_of_type_Int);
        }
      }
    } while (!b());
    label171:
    if ((this.jdField_f_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))
    {
      setChanged();
      notifyObservers(this.jdField_b_of_type_AndroidViewView.getTag());
    }
    f();
  }
  
  private void i()
  {
    this.jdField_f_of_type_Boolean = false;
    if ((this.jdField_c_of_type_AndroidViewView.getVisibility() == 8) && (this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewAnimationAnimation != null))
    {
      this.jdField_a_of_type_Float = 0.0F;
      this.jdField_b_of_type_AndroidViewView.clearAnimation();
      this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_e_of_type_Int != 1) {
        break label201;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
        break label128;
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_Dis", "", "Grp_AIO", "Appear_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
    label128:
    label201:
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_new_msg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          return;
          if (this.jdField_e_of_type_Int == 4)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_file", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            return;
          }
          if (this.jdField_e_of_type_Int == 3)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_album", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            return;
          }
          if (this.jdField_e_of_type_Int == 23)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_atme", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_at", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            return;
          }
          if (this.jdField_e_of_type_Int == 17)
          {
            if (((aylz)this.jdField_b_of_type_AndroidViewView.getTag()).jdField_a_of_type_Boolean)
            {
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_hongbao", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_hongbao", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              return;
            }
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_sf", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_special_focus", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            return;
          }
          if (this.jdField_e_of_type_Int == 14)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_atall", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_at_all", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            return;
          }
          if (this.jdField_e_of_type_Int == 6)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_homework", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            return;
          }
          if (this.jdField_e_of_type_Int == 22)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {}
            for (localObject = "Grp_Dis_replyMsg";; localObject = "Grp_AIO")
            {
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", (String)localObject, "", "notice_center_new", "exp_reply", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              return;
            }
          }
          if (this.jdField_e_of_type_Int == 19)
          {
            bcad.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2013", "0", false);
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_join_team", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            return;
          }
          if (this.jdField_e_of_type_Int == 26)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_gift", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            return;
          }
        } while (this.jdField_e_of_type_Int != 20);
        localObject = (aylz)this.jdField_b_of_type_AndroidViewView.getTag();
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((aylz)localObject).jdField_b_of_type_Long);
      } while ((localObject == null) || (!(localObject instanceof MessageForArkApp)));
      localObject = ((MessageForArkApp)localObject).ark_app_message;
    } while (localObject == null);
    alep.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ArkAppMessage)localObject).appName, "AIOMsgRemindShow", 0, 0, 0L, 0L, 0L, "", "");
  }
  
  private void j()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new TroopAioMsgNavigateBar.3(this));
      return;
    }
    i();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      arom localarom = (arom)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if (localarom != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          return localarom.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          return localarom.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
        }
      }
    }
    return -1;
  }
  
  public View a()
  {
    return this.jdField_c_of_type_AndroidViewView;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Boolean = false;
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new TroopAioMsgNavigateBar.5(this, paramInt));
      return;
    }
    b(paramInt);
  }
  
  public void a(int paramInt, String paramString1, Object paramObject, String paramString2)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    if (this.jdField_c_of_type_AndroidViewView == null)
    {
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131494718, null);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_c_of_type_AndroidViewView) == -1)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = azvv.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
      localLayoutParams.addRule(11);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView, localLayoutParams);
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    int i = a(new int[] { 2131312048, 2131307242, 2131307330, 2131307325 });
    if (i > 0) {
      localLayoutParams.addRule(3, i);
    }
    if (this.jdField_b_of_type_AndroidViewView == null) {
      this.jdField_b_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131311893);
    }
    this.jdField_c_of_type_AndroidViewView.setBackgroundResource(17170445);
    this.jdField_b_of_type_AndroidViewView.setTag(paramObject);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131311898));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131311897));
    if (paramInt == 1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      a(paramString2);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131311894));
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130843178);
      if (paramInt != 1) {
        break label549;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100543));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100543));
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130849371);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      return;
      if (paramInt == 11)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ajjy.a(2131649370));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131649381));
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 13.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 13.0F);
        break;
      }
      if (paramInt == 100)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131633815);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        break;
      }
      if (paramInt == 24)
      {
        paramObject = ajjy.a(2131649369);
        float f1 = this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(paramObject);
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth((int)f1);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(babh.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString2));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      label549:
      if (paramInt == 24)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100541));
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838346);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100542));
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100542));
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130849372);
      }
    }
  }
  
  public void a(long paramLong)
  {
    if ((paramLong > this.jdField_b_of_type_Long) && (this.jdField_d_of_type_Int > 0)) {
      this.jdField_d_of_type_Int -= 1;
    }
    f();
  }
  
  public void a(List<ChatMessage> paramList)
  {
    if ((paramList == null) || (!c())) {}
    while (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i = 0;
    for (;;)
    {
      Object localObject;
      try
      {
        if (i < paramList.size())
        {
          localObject = (ChatMessage)paramList.get(i);
          if (!this.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(((ChatMessage)localObject).shmsgseq))) {
            break label345;
          }
          this.jdField_a_of_type_JavaUtilList.remove(Long.valueOf(((ChatMessage)localObject).shmsgseq));
          break label345;
        }
        i = this.jdField_a_of_type_JavaUtilList.size();
        if (i == 0) {
          break label333;
        }
        paramList = (aylz)this.jdField_b_of_type_AndroidViewView.getTag();
        if ((paramList == null) || ((!paramList.jdField_a_of_type_Boolean) && (!paramList.jdField_b_of_type_Boolean))) {
          break label193;
        }
        if (paramList.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131653426));
          return;
        }
      }
      finally {}
      if (paramList.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131653443));
        continue;
        label193:
        Resources localResources;
        if ((paramList != null) && (paramList.c == 17))
        {
          localObject = this.jdField_a_of_type_AndroidWidgetTextView;
          localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
          if (i > 99) {}
          for (paramList = "99+";; paramList = Integer.valueOf(i))
          {
            ((TextView)localObject).setText(localResources.getString(2131628808, new Object[] { paramList }));
            break;
          }
        }
        if ((paramList != null) && (paramList.c == 100))
        {
          localObject = this.jdField_b_of_type_AndroidWidgetTextView;
          localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
          if (i > 99) {}
          for (paramList = "99+";; paramList = Integer.valueOf(i))
          {
            ((TextView)localObject).setText(localResources.getString(2131633818, new Object[] { paramList }));
            break;
          }
          label333:
          this.jdField_f_of_type_Boolean = false;
          h();
          continue;
          label345:
          i += 1;
        }
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() != 8);
  }
  
  public boolean b()
  {
    Object localObject = (arom)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      this.jdField_e_of_type_Int = ((arom)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    while (this.jdField_e_of_type_Int == 24)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        this.jdField_e_of_type_Int = ((arom)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
      }
    }
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Int <= 0))
    {
      QLog.e("TroopAioMsgNavigateBar", 1, "[isNeedToShowNavigateBar] exception " + this.jdField_a_of_type_Boolean + " " + this.jdField_b_of_type_Boolean + " " + this.jdField_d_of_type_Int);
      return false;
    }
    boolean bool;
    if (this.jdField_e_of_type_Int == 1)
    {
      if ((this.jdField_d_of_type_Int < 15) || (this.jdField_d_of_type_Int > 200)) {
        break label474;
      }
      bool = true;
    }
    for (;;)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("navigateType:").append(this.jdField_e_of_type_Int).append("|isNeedToShow:").append(bool);
        if (!c()) {
          break label468;
        }
      }
      label468:
      for (localObject = ", |mMulNativigateSeqList size:" + this.jdField_a_of_type_JavaUtilList.size();; localObject = "")
      {
        QLog.d("TroopAioMsgNavigateBar.troop.special_msg", 2, (String)localObject);
        return bool;
        if ((this.jdField_e_of_type_Int != 23) && (this.jdField_e_of_type_Int != 14) && (this.jdField_e_of_type_Int != 17) && (this.jdField_e_of_type_Int != 100) && (this.jdField_e_of_type_Int != 11) && (this.jdField_e_of_type_Int != 6) && (this.jdField_e_of_type_Int != 26) && (this.jdField_e_of_type_Int != 18) && (this.jdField_e_of_type_Int != 22) && (this.jdField_e_of_type_Int != 21) && (this.jdField_e_of_type_Int != 4) && (this.jdField_e_of_type_Int != 3) && (this.jdField_e_of_type_Int != 19) && (this.jdField_e_of_type_Int != 5) && (this.jdField_e_of_type_Int != 10) && (this.jdField_e_of_type_Int != 13) && (this.jdField_e_of_type_Int != 20) && (this.jdField_e_of_type_Int != 24)) {
          break label474;
        }
        bool = true;
        break;
      }
      label474:
      bool = false;
    }
  }
  
  protected void c()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("TroopAioMsgNavigateBar.troop.special_msg", 2, "onInit==>mUnreadCount:" + this.jdField_d_of_type_Int + "|mTroopLastReadSeq:" + this.jdField_b_of_type_Long);
    }
    Object localObject;
    if (!((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = (arom)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
        break label352;
      }
      ((arom)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1, this.jdField_b_of_type_Long, "", 0);
    }
    for (;;)
    {
      localObject = new DisplayMetrics();
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      this.jdField_f_of_type_Int = ((DisplayMetrics)localObject).heightPixels;
      this.jdField_g_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131166713));
      this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(500L);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(500L);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.jdField_c_of_type_AndroidViewAnimationAnimation = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
      this.jdField_c_of_type_AndroidViewAnimationAnimation.setDuration(500L);
      this.jdField_c_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
      return;
      label352:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        ((arom)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000, 1, this.jdField_b_of_type_Long, "", 0);
      }
    }
  }
  
  public boolean c()
  {
    return (a(this.jdField_e_of_type_Int)) && (this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty());
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    }
    Object localObject = (arom)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      ((arom)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView != null))
      {
        this.jdField_b_of_type_AndroidViewView.clearAnimation();
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        localObject = (ViewGroup)this.jdField_c_of_type_AndroidViewView.getParent();
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.jdField_c_of_type_AndroidViewView);
        }
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        ((arom)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000, 0);
      }
    }
  }
  
  public void e()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0))
    {
      Object localObject = (aylz)this.jdField_b_of_type_AndroidViewView.getTag();
      if (localObject != null)
      {
        long l2 = ((aylz)localObject).jdField_a_of_type_Long;
        long l1 = l2;
        if (((aylz)localObject).jdField_b_of_type_Long != 0L)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((aylz)localObject).jdField_b_of_type_Long);
          l1 = l2;
          if (localObject != null) {
            l1 = ((MessageRecord)localObject).shmsgseq;
          }
        }
        if (l1 > 0L)
        {
          int i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
          localObject = (ChatMessage)this.jdField_a_of_type_Acka.getItem(i);
          if ((localObject != null) && (((ChatMessage)localObject).shmsgseq <= l1)) {
            h();
          }
        }
      }
    }
  }
  
  public void f()
  {
    ThreadManager.post(new TroopAioMsgNavigateBar.2(this), 8, null, true);
  }
  
  protected void g()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      a(this.jdField_e_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangObject, this.jdField_d_of_type_JavaLangString);
      j();
      b();
      awqx.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "qq_vip", "0X800A8FB", 0, 1, 0, "", "", "", "");
      return;
    }
    if ((this.jdField_e_of_type_Int == 23) || (this.jdField_e_of_type_Int == 14) || (this.jdField_e_of_type_Int == 17) || (this.jdField_e_of_type_Int == 100) || (this.jdField_e_of_type_Int == 11) || (this.jdField_e_of_type_Int == 6) || (this.jdField_e_of_type_Int == 21) || (this.jdField_e_of_type_Int == 18) || (this.jdField_e_of_type_Int == 5) || (this.jdField_e_of_type_Int == 4) || (this.jdField_e_of_type_Int == 3) || (this.jdField_e_of_type_Int == 13) || (this.jdField_e_of_type_Int == 20)) {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
      {
        setChanged();
        notifyObservers(aylz.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int));
        if (QLog.isColorLevel()) {
          QLog.d("TroopAioMsgNavigateBar.troop.special_msg", 2, "notifyUi==>navigateType:" + this.jdField_e_of_type_Int + "|navigateSeq:" + this.jdField_c_of_type_Long);
        }
      }
    }
    for (;;)
    {
      h();
      return;
      if ((this.jdField_e_of_type_Int == 22) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))
      {
        setChanged();
        MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
        if (localMessageRecord != null) {
          notifyObservers(aylz.a(this.jdField_e_of_type_Int, localMessageRecord.shmsgseq, this.jdField_d_of_type_Int));
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopAioMsgNavigateBar.troop.special_msg", 2, "notifyUi==>navigateType:" + this.jdField_e_of_type_Int + "|navigateSeq:" + this.jdField_c_of_type_Long);
        }
      }
    }
  }
  
  public void h()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new TroopAioMsgNavigateBar.4(this));
      return;
    }
    b(-1);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_c_of_type_AndroidViewView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_b_of_type_AndroidViewView == null) || (paramAnimation == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class).obtainMessage(68).sendToTarget();
    if (paramAnimation.equals(this.jdField_b_of_type_AndroidViewAnimationAnimation))
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof AioPushData)))
      {
        paramAnimation = (AioPushData)this.jdField_a_of_type_JavaLangObject;
        if (!paramAnimation.isShow)
        {
          bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clk_active", 0, 0, new String[] { String.valueOf(paramAnimation.busId), paramAnimation.actId });
          HotChatCenterFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramAnimation, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          return;
        }
        this.jdField_a_of_type_JavaLangObject = null;
      }
      if ((this.jdField_f_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))
      {
        setChanged();
        notifyObservers(this.jdField_b_of_type_AndroidViewView.getTag());
      }
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("TroopAioMsgNavigateBar", 4, "TroopAioMsgNavigateBar onClick v == null");
      }
    }
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131296690: 
        h();
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null);
    awqx.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "qq_vip", "0X800A8FC", 0, 1, 0, "", "", "", "");
    this.jdField_f_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800621C", "0X800621C", 0, 0, "", "", "", "");
    }
    if (this.jdField_e_of_type_Int == 1) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_Dis", "", "Grp_AIO", "Clk_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      }
    }
    for (;;)
    {
      h();
      return;
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_new_msg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      continue;
      if (this.jdField_e_of_type_Int != 23) {
        break;
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_atme", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_at", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
    int i;
    if (a(this.jdField_e_of_type_Int))
    {
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
        break label2026;
      }
      if (this.jdField_e_of_type_Boolean) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "Clk_owner", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      }
      if (!(this.jdField_b_of_type_AndroidViewView.getTag() instanceof aylz)) {
        break label2026;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      aylz localaylz = (aylz)this.jdField_b_of_type_AndroidViewView.getTag();
      for (;;)
      {
        int j;
        Object localObject;
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          i = this.jdField_a_of_type_JavaUtilList.size();
          localaylz.jdField_a_of_type_Long = ((Long)this.jdField_a_of_type_JavaUtilList.remove(0)).longValue();
          j = this.jdField_a_of_type_JavaUtilList.size();
          if (QLog.isColorLevel())
          {
            if (this.jdField_e_of_type_Int == 17) {
              QLog.d("TroopAioMsgNavigateBar.troop.special_msg.special_attention", 2, "sizeAfterClick:" + j + ", mArrowImageRotated:" + this.jdField_d_of_type_Boolean);
            }
          }
          else
          {
            if (j != 0)
            {
              if (!this.jdField_d_of_type_Boolean)
              {
                this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
                this.jdField_d_of_type_Boolean = true;
              }
              paramView = null;
              if (this.jdField_a_of_type_ComTencentWidgetURLThemeImageView != null)
              {
                long l = ((Long)this.jdField_a_of_type_JavaUtilList.get(0)).longValue();
                localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
                paramView = (View)localObject;
                if (localObject != null)
                {
                  a(((MessageRecord)localObject).senderuin);
                  if (this.jdField_e_of_type_Int != 17) {
                    break label950;
                  }
                  this.jdField_b_of_type_AndroidWidgetTextView.setText(babh.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((MessageRecord)localObject).senderuin));
                  paramView = (View)localObject;
                }
              }
              if (!MessageForQQWalletMsg.isRedPacketMsg(paramView)) {
                break label1007;
              }
              paramView = (MessageForQQWalletMsg)paramView;
              if ((paramView.messageType != 7) && (paramView.messageType != 8)) {
                break label981;
              }
              this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131653443));
              localaylz.jdField_b_of_type_Boolean = true;
            }
            if ((i == 1) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("TroopAioMsgNavigateBar", 2, "onClick notify");
            }
            setChanged();
            notifyObservers(localaylz);
            return;
          }
        }
        if (this.jdField_e_of_type_Int == 11)
        {
          QLog.d("TroopAioMsgNavigateBar.troop.special_msg.confess_to_me", 2, "sizeAfterClick:" + j + ", mArrowImageRotated:" + this.jdField_d_of_type_Boolean);
        }
        else if (this.jdField_e_of_type_Int == 100)
        {
          QLog.d("TroopAioMsgNavigateBar.troop.special_msg.keyword", 2, "sizeAfterClick:" + j + ", mArrowImageRotated:" + this.jdField_d_of_type_Boolean);
          continue;
          label950:
          paramView = (View)localObject;
          if (this.jdField_e_of_type_Int == 11)
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(ajjy.a(2131649375));
            paramView = (View)localObject;
            continue;
            label981:
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131653426));
            localaylz.jdField_a_of_type_Boolean = true;
            continue;
            label1007:
            Resources localResources;
            if (this.jdField_e_of_type_Int == 17)
            {
              localaylz.jdField_a_of_type_Boolean = false;
              localObject = this.jdField_a_of_type_AndroidWidgetTextView;
              localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
              if (j > 99) {}
              for (paramView = "99+";; paramView = Integer.valueOf(j))
              {
                ((TextView)localObject).setText(localResources.getString(2131628808, new Object[] { paramView }));
                break;
              }
            }
            if (this.jdField_e_of_type_Int == 100)
            {
              localaylz.jdField_a_of_type_Boolean = false;
              localObject = this.jdField_b_of_type_AndroidWidgetTextView;
              localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
              if (j > 99) {}
              for (paramView = "99+";; paramView = Integer.valueOf(j))
              {
                ((TextView)localObject).setText(localResources.getString(2131633818, new Object[] { paramView }));
                break;
              }
            }
            if (this.jdField_e_of_type_Int == 11)
            {
              localaylz.jdField_a_of_type_Boolean = false;
              this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131649373));
            }
          }
        }
      }
      if (!localaylz.jdField_a_of_type_Boolean) {
        break label2021;
      }
      i = 1;
    }
    for (;;)
    {
      label1192:
      if (i != 0)
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_hongbao", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_hongbao", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_sf", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_special_focus", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      break;
      if (this.jdField_e_of_type_Int == 14)
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_atall", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_at_all", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 26)
      {
        if (mnf.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
        for (i = 2;; i = 1)
        {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_topmsgcue", i, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_gift", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          break;
        }
      }
      if (this.jdField_e_of_type_Int == 21)
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_calendar", "", "notice", "Clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 22)
      {
        MessageForReplyText.reportReplyMsg(null, "AIOchat", "Clk_topmsgcue_reply", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {}
        for (paramView = "Grp_Dis_replyMsg";; paramView = "Grp_AIO")
        {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", paramView, "", "notice_center_new", "clk_reply", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          break;
        }
      }
      if (this.jdField_e_of_type_Int == 6)
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_homework", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 19)
      {
        bcad.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2014", "0", false);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_join_team", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 4)
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_file", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 3)
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_album", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 20)
      {
        paramView = (aylz)this.jdField_b_of_type_AndroidViewView.getTag();
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView.jdField_b_of_type_Long);
        if ((paramView == null) || (!(paramView instanceof MessageForArkApp))) {
          break;
        }
        paramView = ((MessageForArkApp)paramView).ark_app_message;
        if (paramView == null) {
          break;
        }
        alep.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.appName, "AIOMsgRemindClick", 0, 0, 0L, 0L, 0L, "", "");
        break;
      }
      if ((this.jdField_e_of_type_Int != 24) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.d("TroopAioMsgNavigateBar", 2, "[onClick] into page");
      break;
      label2021:
      i = 0;
      break label1192;
      label2026:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aymq
 * JD-Core Version:    0.7.0.1
 */