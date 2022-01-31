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
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.data.TroopAioMsgNavigateBar.2;
import com.tencent.mobileqq.troop.data.TroopAioMsgNavigateBar.4;
import com.tencent.mobileqq.troop.data.TroopAioMsgNavigateBar.5;
import com.tencent.mobileqq.troop.data.TroopAioMsgNavigateBar.6;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.URLThemeImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class azng
  extends azmo
  implements View.OnClickListener, Animation.AnimationListener, Observer
{
  protected static long a;
  protected float a;
  Handler jdField_a_of_type_AndroidOsHandler = new aznh(this, Looper.getMainLooper());
  protected Animation a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected azpa a;
  private azpe jdField_a_of_type_Azpe;
  URLThemeImageView jdField_a_of_type_ComTencentWidgetURLThemeImageView;
  protected Object a;
  String jdField_a_of_type_JavaLangString;
  protected List<Long> a;
  public AtomicBoolean a;
  protected long b;
  View jdField_b_of_type_AndroidViewView;
  protected Animation b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  Object jdField_b_of_type_JavaLangObject;
  protected String b;
  protected boolean b;
  protected long c;
  View jdField_c_of_type_AndroidViewView;
  protected Animation c;
  Object jdField_c_of_type_JavaLangObject;
  String jdField_c_of_type_JavaLangString;
  protected boolean c;
  protected int d;
  protected long d;
  String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean = false;
  protected int e;
  String e;
  protected boolean e;
  protected int f;
  protected boolean f;
  protected int g;
  boolean g;
  
  static
  {
    jdField_a_of_type_Long = 2147483647L;
  }
  
  public azng()
  {
    this.jdField_b_of_type_Long = jdField_a_of_type_Long;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_d_of_type_Long = -1L;
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
  
  private MessageRecord a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Acut != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
        localObject1 = (MessageRecord)this.jdField_a_of_type_Acut.getItem(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
      }
    }
    return localObject1;
  }
  
  private void a(String paramString)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    if (this.jdField_a_of_type_ComTencentWidgetURLThemeImageView == null) {
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView = ((URLThemeImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377716));
    }
    if (this.jdField_e_of_type_Int == 24)
    {
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageResource(2130838353);
      return;
    }
    if (this.jdField_e_of_type_Int == 100)
    {
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageResource(2130846562);
      return;
    }
    if (this.jdField_e_of_type_Int == 102)
    {
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageResource(2130849609);
      return;
    }
    if (this.jdField_e_of_type_Int == 101)
    {
      bbkx.b(this.jdField_a_of_type_ComTencentWidgetURLThemeImageView, 0);
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageResource(2130838187);
      return;
    }
    Object localObject2;
    if ((this.jdField_e_of_type_Int != 1) && (!TextUtils.isEmpty(paramString)))
    {
      if ((!paramString.equals(this.jdField_e_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.getVisibility() == 0))
      {
        this.jdField_e_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable(baxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString));
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setVisibility(0);
      localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.getLayoutParams();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
      {
        int i = bawz.a(this.jdField_a_of_type_AndroidContentContext, 30.0F);
        ((LinearLayout.LayoutParams)localObject1).height = i;
        ((LinearLayout.LayoutParams)localObject1).width = i;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        localObject2 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
        if ((localObject2 == null) || (!((HotChatManager)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (localObject1 == null) || (((ajxn)localObject1).b(paramString))) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable(baxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, paramString, true));
        label322:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          localLayoutParams.leftMargin = bawz.a(this.jdField_a_of_type_AndroidContentContext, 7.0F);
        }
        label349:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
          break label671;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
        return;
        ((LinearLayout.LayoutParams)localObject1).setMargins(bawz.a(this.jdField_a_of_type_AndroidContentContext, 2.5F), bawz.a(this.jdField_a_of_type_AndroidContentContext, 2.5F), 0, bawz.a(this.jdField_a_of_type_AndroidContentContext, 2.5F));
      }
      if (this.jdField_e_of_type_Int == 22)
      {
        localObject1 = this.jdField_b_of_type_AndroidViewView.getTag();
        if (!(localObject1 instanceof azmp)) {
          break label673;
        }
        long l = ((azmp)localObject1).jdField_a_of_type_Long;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l, 0L);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = (MessageRecord)((List)localObject1).get(0);
          label499:
          if ((localObject1 == null) || (!mye.a((MessageRecord)localObject1))) {
            break label673;
          }
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843043);
        }
      }
    }
    label671:
    label673:
    for (Object localObject1 = URLDrawable.getDrawable(mye.a(mye.a((MessageRecord)localObject1).b), (Drawable)localObject2, (Drawable)localObject2);; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = baxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString);
      }
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable((Drawable)localObject2);
      break label322;
      localObject1 = null;
      break label499;
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable(baxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString));
      break label322;
      if (this.jdField_e_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable(null);
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageResource(2130849558);
        break label349;
      }
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
        break label349;
      }
      localLayoutParams.leftMargin = bawz.a(this.jdField_a_of_type_AndroidContentContext, 14.0F);
      break label349;
      break;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 17) || (paramInt == 11) || (paramInt == 100);
  }
  
  private void b(int paramInt)
  {
    askq localaskq;
    if (this.jdField_a_of_type_Boolean)
    {
      localaskq = (askq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if (localaskq != null) {
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
        localaskq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_Int);
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
          localaskq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000, this.jdField_e_of_type_Int);
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
  
  private void j()
  {
    if ((this.jdField_e_of_type_Int != 102) || (!this.jdField_g_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(101);
      return;
    }
    try
    {
      m();
      return;
    }
    finally {}
  }
  
  private void k()
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
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_Dis", "", "Grp_AIO", "Appear_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
    label128:
    label201:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_new_msg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              return;
              if (this.jdField_e_of_type_Int == 4)
              {
                axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_file", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                return;
              }
              if (this.jdField_e_of_type_Int == 3)
              {
                axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_album", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                return;
              }
              if (this.jdField_e_of_type_Int == 23)
              {
                axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_atme", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_at", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                return;
              }
              if (this.jdField_e_of_type_Int == 17)
              {
                if (((azmp)this.jdField_b_of_type_AndroidViewView.getTag()).jdField_a_of_type_Boolean)
                {
                  axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_hongbao", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                  axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_hongbao", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                  return;
                }
                axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_sf", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_special_focus", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                return;
              }
              if (this.jdField_e_of_type_Int == 14)
              {
                axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_atall", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_at_all", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                return;
              }
              if (this.jdField_e_of_type_Int == 6)
              {
                axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_homework", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                return;
              }
              if (this.jdField_e_of_type_Int == 22)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {}
                for (localObject = "Grp_Dis_replyMsg";; localObject = "Grp_AIO")
                {
                  axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", (String)localObject, "", "notice_center_new", "exp_reply", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                  return;
                }
              }
              if (this.jdField_e_of_type_Int == 19)
              {
                bded.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2013", "0", false);
                axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_join_team", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                return;
              }
              if (this.jdField_e_of_type_Int == 26)
              {
                axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_gift", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                return;
              }
              if (this.jdField_e_of_type_Int != 20) {
                break;
              }
              localObject = (azmp)this.jdField_b_of_type_AndroidViewView.getTag();
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((azmp)localObject).jdField_b_of_type_Long);
            } while ((localObject == null) || (!(localObject instanceof MessageForArkApp)));
            localObject = ((MessageForArkApp)localObject).ark_app_message;
          } while (localObject == null);
          altd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ArkAppMessage)localObject).appName, "AIOMsgRemindShow", 0, 0, 0L, 0L, 0L, "", "");
          return;
          if (this.jdField_e_of_type_Int == 101)
          {
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AA10", "0X800AA10", 0, 0, "", "", "", "");
            return;
          }
        } while (this.jdField_e_of_type_Int != 102);
        localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      } while (localObject == null);
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while (localObject == null);
    boolean bool = this.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_AndroidContentContext.getString(2131697883));
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    long l = ((TroopInfo)localObject).dwGroupClassExt;
    if (bool) {}
    for (Object localObject = "2";; localObject = "1")
    {
      axqw.b(localQQAppInterface, "dc00898", "", "", "", "0X800AACB", 0, 1, 0, str, String.valueOf(l), (String)localObject, "");
      return;
    }
  }
  
  private void l()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new TroopAioMsgNavigateBar.4(this));
      return;
    }
    k();
  }
  
  private void m()
  {
    QLog.d("TroopAioMsgNavigateBar", 2, "showTroopNotifyBar troopNotifyData:" + this.jdField_a_of_type_Azpe + " navigateType:" + this.jdField_e_of_type_Int + " mFIsShow:" + this.jdField_g_of_type_Boolean);
    if ((this.jdField_a_of_type_Azpe != null) && (this.jdField_e_of_type_Int == 102) && (this.jdField_g_of_type_Boolean))
    {
      if (!a()) {
        break label92;
      }
      this.jdField_a_of_type_Azpe = null;
    }
    label92:
    do
    {
      return;
      bool2 = false;
      bool1 = bool2;
      Object localObject;
      if (this.jdField_g_of_type_Boolean)
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_Azpe.jdField_b_of_type_Boolean)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_JavaLangObject != null)
          {
            bool1 = bool2;
            if ((this.jdField_a_of_type_JavaLangObject instanceof MessageForArkApp))
            {
              localObject = (MessageForArkApp)this.jdField_a_of_type_JavaLangObject;
              bool1 = bool2;
              if (((MessageForArkApp)localObject).ark_app_message != null)
              {
                bool1 = bool2;
                if (!((MessageForArkApp)localObject).ark_app_message.appName.equals("com.tencent.mannounce")) {}
              }
            }
          }
        }
      }
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.d("TroopAioMsgNavigateBar", 2, "showTroopNotifyBar ark.ark_app_message.metaList:" + ((MessageForArkApp)localObject).ark_app_message.metaList);
          QLog.d("TroopAioMsgNavigateBar", 2, "showTroopNotifyBar troopNotifyData confirmRequired:" + this.jdField_a_of_type_Azpe.jdField_c_of_type_Boolean + " fid:" + this.jdField_a_of_type_Azpe.jdField_a_of_type_JavaLangString + " isShowTipWindow:" + this.jdField_a_of_type_Azpe.jdField_b_of_type_Boolean);
        }
        localObject = new JSONObject(((MessageForArkApp)localObject).ark_app_message.metaList).optJSONObject("mannounce");
        if ((localObject == null) || (!((JSONObject)localObject).optString("fid").equals(this.jdField_a_of_type_Azpe.jdField_a_of_type_JavaLangString))) {
          break label513;
        }
        localObject = (MessageRecord)this.jdField_a_of_type_Acut.getItem(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
        if (localObject == null) {
          break label513;
        }
        long l = ((MessageRecord)localObject).shmsgseq;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
        if ((localObject == null) || (((MessageRecord)localObject).shmsgseq >= l)) {
          break label513;
        }
        if (this.jdField_a_of_type_Azpe.jdField_c_of_type_Boolean) {
          this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getString(2131697883);
        }
        bool1 = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("TroopAioMsgNavigateBar", 1, "[showTroopNotifyBar] ", localException);
          bool1 = bool2;
          continue;
          i();
          continue;
          bool1 = false;
        }
      }
      this.jdField_g_of_type_Boolean = bool1;
      if (!this.jdField_g_of_type_Boolean) {
        break;
      }
      h();
      this.jdField_a_of_type_Azpe = null;
    } while (!QLog.isColorLevel());
    QLog.d("TroopAioMsgNavigateBar", 2, "showTroopNotifyBar mFIsShow:" + this.jdField_g_of_type_Boolean);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      askq localaskq = (askq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if (localaskq != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          return localaskq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          return localaskq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
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
      new Handler(Looper.getMainLooper()).post(new TroopAioMsgNavigateBar.6(this, paramInt));
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
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560290, null);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_c_of_type_AndroidViewView) == -1)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = bawz.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
      localLayoutParams.addRule(11);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView, localLayoutParams);
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    int i = a(new int[] { 2131377870, 2131372953, 2131373040, 2131373035 });
    if (i > 0) {
      localLayoutParams.addRule(3, i);
    }
    if (this.jdField_b_of_type_AndroidViewView == null) {
      this.jdField_b_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131377714);
    }
    this.jdField_c_of_type_AndroidViewView.setBackgroundResource(17170445);
    this.jdField_b_of_type_AndroidViewView.setTag(paramObject);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377719));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377718));
    if (paramInt == 1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      a(paramString2);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377715));
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130843261);
      if (paramInt != 1) {
        break label583;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166133));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166133));
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130849606);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      return;
      if (paramInt == 11)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ajyc.a(2131715160));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajyc.a(2131715171));
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 13.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 13.0F);
        break;
      }
      if (paramInt == 100)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699601);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        break;
      }
      if (paramInt == 102)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
      }
      if (paramInt == 24)
      {
        paramObject = ajyc.a(2131715159);
        float f1 = this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(paramObject);
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth((int)f1);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bbcl.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString2));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      label583:
      if (paramInt == 24)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166131));
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838354);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166132));
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166132));
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130849607);
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
        paramList = (azmp)this.jdField_b_of_type_AndroidViewView.getTag();
        if ((paramList == null) || ((!paramList.jdField_a_of_type_Boolean) && (!paramList.jdField_b_of_type_Boolean))) {
          break label193;
        }
        if (paramList.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131719255));
          return;
        }
      }
      finally {}
      if (paramList.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131719272));
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
            ((TextView)localObject).setText(localResources.getString(2131694469, new Object[] { paramList }));
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
            ((TextView)localObject).setText(localResources.getString(2131699604, new Object[] { paramList }));
            break;
          }
          label333:
          this.jdField_f_of_type_Boolean = false;
          i();
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
    boolean bool = true;
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Int <= 0))
    {
      QLog.e("TroopAioMsgNavigateBar", 1, "[isNeedToShowNavigateBar] exception " + this.jdField_a_of_type_Boolean + " " + this.jdField_b_of_type_Boolean + " " + this.jdField_d_of_type_Int);
      bool = false;
      return bool;
    }
    int i = -1;
    Object localObject = (askq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      i = ((askq)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      label121:
      if (i == 24) {
        break label293;
      }
      if (i != 1) {
        break label295;
      }
      if ((this.jdField_d_of_type_Int < 15) || (this.jdField_d_of_type_Int > 200)) {
        break label423;
      }
      bool = true;
    }
    for (;;)
    {
      label153:
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("navigateType:").append(i).append("|isNeedToShow:").append(bool);
        if (!c()) {
          break label417;
        }
      }
      label417:
      for (localObject = ", |mMulNativigateSeqList size:" + this.jdField_a_of_type_JavaUtilList.size();; localObject = "")
      {
        QLog.d("TroopAioMsgNavigateBar.troop.special_msg", 2, (String)localObject);
        return bool;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
          break label121;
        }
        i = ((askq)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
        break label121;
        label293:
        break;
        label295:
        if ((i != 23) && (i != 14) && (i != 17) && (i != 100) && (i != 11) && (i != 6) && (i != 26) && (i != 18) && (i != 22) && (i != 21) && (i != 4) && (i != 3) && (i != 19) && (i != 5) && (i != 10) && (i != 13) && (i != 20) && (i != 24) && (i != 102) && (i != 101)) {
          break label423;
        }
        bool = true;
        break label153;
      }
      label423:
      bool = false;
    }
  }
  
  protected void c()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Azpe = null;
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("TroopAioMsgNavigateBar.troop.special_msg", 2, "onInit==>mUnreadCount:" + this.jdField_d_of_type_Int + "|mTroopLastReadSeq:" + this.jdField_b_of_type_Long);
    }
    Object localObject;
    if (!((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = (askq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
        break label404;
      }
      ((askq)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1, this.jdField_b_of_type_Long, "", 0, null);
    }
    for (;;)
    {
      localObject = new DisplayMetrics();
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      this.jdField_f_of_type_Int = ((DisplayMetrics)localObject).heightPixels;
      this.jdField_g_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131297802));
      this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(500L);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(500L);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.jdField_c_of_type_AndroidViewAnimationAnimation = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
      this.jdField_c_of_type_AndroidViewAnimationAnimation.setDuration(500L);
      this.jdField_c_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
      localObject = (askq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      try
      {
        this.jdField_a_of_type_Azpa = ((askq)localObject).a(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)), true);
        this.jdField_a_of_type_Azpa.addObserver(this);
        return;
      }
      catch (Exception localException)
      {
        label404:
        while (!QLog.isColorLevel()) {}
        QLog.e("TroopAioMsgNavigateBar", 2, localException.toString());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        ((askq)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000, 1, this.jdField_b_of_type_Long, "", 0, null);
      }
    }
  }
  
  protected boolean c()
  {
    return (a(this.jdField_e_of_type_Int)) && (this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty());
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    }
    Object localObject = (askq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      ((askq)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Azpe = null;
      if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView != null))
      {
        this.jdField_b_of_type_AndroidViewView.clearAnimation();
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        localObject = (ViewGroup)this.jdField_c_of_type_AndroidViewView.getParent();
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.jdField_c_of_type_AndroidViewView);
        }
      }
      this.jdField_a_of_type_Azpa.deleteObserver(this);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        ((askq)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000, 0);
      }
    }
  }
  
  public void e()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0))
    {
      Object localObject = (azmp)this.jdField_b_of_type_AndroidViewView.getTag();
      if (localObject != null)
      {
        long l2 = ((azmp)localObject).jdField_a_of_type_Long;
        long l1 = l2;
        if (((azmp)localObject).jdField_b_of_type_Long != 0L)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((azmp)localObject).jdField_b_of_type_Long);
          l1 = l2;
          if (localObject != null) {
            l1 = ((MessageRecord)localObject).shmsgseq;
          }
        }
        if (l1 > 0L)
        {
          int i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
          localObject = (ChatMessage)this.jdField_a_of_type_Acut.getItem(i);
          if ((localObject != null) && (((ChatMessage)localObject).shmsgseq <= l1)) {
            i();
          }
        }
      }
    }
  }
  
  public void f()
  {
    ThreadManager.post(new TroopAioMsgNavigateBar.2(this), 8, null, true);
  }
  
  public void g()
  {
    this.jdField_b_of_type_Boolean = true;
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    this.jdField_b_of_type_JavaLangObject = null;
    ??? = (askq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
    Object localObject2;
    long l1;
    long l2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      this.jdField_e_of_type_Int = ((askq)???).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangObject = ((askq)???).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (localObject2 != null)
      {
        localObject2 = ((TroopManager)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject2 != null) && (((TroopInfo)localObject2).hasOrgs())) {
          this.jdField_e_of_type_Boolean = true;
        }
      }
      this.jdField_a_of_type_JavaUtilList = ((askq)???).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_Int);
      if (!c()) {
        break label802;
      }
      this.jdField_d_of_type_Long = ((askq)???).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (this.jdField_d_of_type_Long != -1L) {
        Collections.sort(this.jdField_a_of_type_JavaUtilList, new azni(this));
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        this.jdField_c_of_type_Long = ((Long)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).longValue();
      }
      if (this.jdField_e_of_type_Boolean)
      {
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (??? != null)
        {
          l1 = ((QQMessageFacade.Message)???).shmsgseq;
          l2 = this.jdField_c_of_type_Long;
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "his_owner", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", l1 - l2 + "");
        }
      }
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (this.jdField_a_of_type_Acut == null)) {
        break label524;
      }
      localObject2 = (ChatMessage)this.jdField_a_of_type_Acut.getItem(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
      if (localObject2 == null) {
        break label524;
      }
    }
    label524:
    label802:
    label1454:
    label1729:
    for (;;)
    {
      int i;
      Object localObject8;
      Object localObject7;
      azmp localazmp;
      Object localObject6;
      Object localObject5;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        i = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (i >= 0)
        {
          if (((ChatMessage)localObject2).shmsgseq <= ((Long)this.jdField_a_of_type_JavaUtilList.get(i)).longValue()) {
            this.jdField_a_of_type_JavaUtilList.remove(i);
          }
          i -= 1;
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
            break;
          }
          this.jdField_e_of_type_Int = ((askq)???).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
          break;
        }
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        l1 = jdField_a_of_type_Long;
        localObject8 = a();
        if (localObject8 == null) {
          break label4028;
        }
        l1 = ((MessageRecord)localObject8).shmsgseq;
        localObject7 = "";
        localObject2 = null;
        localazmp = null;
        localObject6 = "";
        if (this.jdField_e_of_type_Int != 1) {
          break label1030;
        }
        if (this.jdField_b_of_type_Long < l1) {
          break label889;
        }
        i = 0;
        if (i == 0) {
          break label4011;
        }
        ??? = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698056), new Object[] { Integer.valueOf(this.jdField_d_of_type_Int) });
        localObject2 = azmp.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
        bool1 = true;
        localObject5 = localObject6;
        bool2 = bool1;
        if (c())
        {
          bool2 = bool1;
          if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
            bool2 = false;
          }
        }
        this.jdField_g_of_type_Boolean = bool2;
        this.jdField_c_of_type_JavaLangString = ((String)???);
        this.jdField_c_of_type_JavaLangObject = localObject2;
        this.jdField_d_of_type_JavaLangString = ((String)localObject5);
        if (QLog.isColorLevel())
        {
          if ("[showNavigateBarIfNeeded] navigateType[" + this.jdField_e_of_type_Int + "], isTroopNotify[" + this.jdField_e_of_type_Int != "102], mFIsShow[" + this.jdField_g_of_type_Boolean + "] ") {
            break label3989;
          }
          bool1 = true;
          QLog.d("TroopAioMsgNavigateBar", 2, new Object[] { Boolean.valueOf(bool1) });
        }
        return;
      }
      label1606:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        this.jdField_c_of_type_Long = ((askq)???).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      } else {
        label1362:
        label1623:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
        {
          this.jdField_c_of_type_Long = ((askq)???).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
          continue;
          label889:
          if (this.jdField_d_of_type_Int < 30)
          {
            ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            if (??? != null)
            {
              long l3 = ((QQMessageFacade.Message)???).shmsgseq;
              for (l2 = 0L;; l2 += 1L)
              {
                if (l2 >= this.jdField_d_of_type_Int) {
                  break label4023;
                }
                ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l3);
                if ((??? != null) && (((MessageRecord)???).msgtype != -2058) && (((MessageRecord)???).shmsgseq < l1))
                {
                  i = 1;
                  break;
                }
                l3 -= 1L;
              }
            }
          }
          else
          {
            i = 1;
            continue;
            if (this.jdField_e_of_type_Int == 23)
            {
              localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
              if ((localObject5 == null) || (((MessageRecord)localObject5).shmsgseq >= l1)) {
                break label4000;
              }
              ??? = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697505);
              localObject4 = azmp.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
              localObject5 = ((MessageRecord)localObject5).senderuin;
              bool1 = true;
            }
            for (;;)
            {
              break;
              if (this.jdField_e_of_type_Int == 14)
              {
                localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                localObject4 = localazmp;
                ??? = localObject7;
                bool1 = bool2;
                localObject5 = localObject6;
                if (localObject8 == null) {
                  break;
                }
                localObject4 = localazmp;
                ??? = localObject7;
                bool1 = bool2;
                localObject5 = localObject6;
                if (((MessageRecord)localObject8).shmsgseq >= l1) {
                  break;
                }
                ??? = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697503);
                localObject4 = azmp.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                localObject5 = ((MessageRecord)localObject8).senderuin;
                bool1 = true;
                break;
              }
              if ((this.jdField_e_of_type_Int == 17) || (this.jdField_e_of_type_Int == 100))
              {
                localObject4 = azmp.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
                {
                  localObject5 = this.jdField_a_of_type_AndroidContentContext.getResources();
                  if (this.jdField_e_of_type_Int == 17)
                  {
                    i = 2131694469;
                    if (this.jdField_a_of_type_JavaUtilList.size() <= 99) {
                      break label1606;
                    }
                    ??? = "99+";
                    ??? = ((Resources)localObject5).getString(i, new Object[] { ??? });
                    if (!this.jdField_e_of_type_Boolean) {
                      break label3997;
                    }
                    if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
                      break label1623;
                    }
                    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "focus", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                  }
                }
              }
              for (;;)
              {
                if (MessageForQQWalletMsg.isRedPacketMsg((MessageRecord)localObject7))
                {
                  ??? = (MessageForQQWalletMsg)localObject7;
                  if ((((MessageForQQWalletMsg)???).messageType == 7) || (((MessageForQQWalletMsg)???).messageType == 8))
                  {
                    ??? = this.jdField_a_of_type_AndroidContentContext.getString(2131719272);
                    ((azmp)localObject4).jdField_b_of_type_Boolean = true;
                  }
                }
                for (;;)
                {
                  localObject5 = localObject6;
                  if (localObject7 != null) {
                    localObject5 = ((MessageRecord)localObject7).senderuin;
                  }
                  if (QLog.isColorLevel())
                  {
                    localObject6 = new StringBuilder().append("需要定位的第一条消息是否已经拉到本地：");
                    if (localObject7 == null) {
                      break label1729;
                    }
                  }
                  for (bool1 = true;; bool1 = false)
                  {
                    QLog.d("TroopAioMsgNavigateBar.troop.special_msg.special_attention", 2, bool1);
                    bool1 = bool3;
                    if (localObject8 != null)
                    {
                      bool1 = bool3;
                      if (this.jdField_c_of_type_Long < ((MessageRecord)localObject8).shmsgseq) {
                        bool1 = true;
                      }
                    }
                    break;
                    i = 2131699604;
                    break label1362;
                    ??? = Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size());
                    break label1381;
                    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "msg_owner", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList.size() + "", "", "");
                    break label1454;
                    ??? = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719718);
                    break label1454;
                    ??? = this.jdField_a_of_type_AndroidContentContext.getString(2131719255);
                    ((azmp)localObject4).jdField_a_of_type_Boolean = true;
                    break label1510;
                  }
                  if (this.jdField_e_of_type_Int == 11)
                  {
                    localazmp = azmp.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                    ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
                    {
                      localObject7 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698700);
                      if (??? != null) {
                        localObject6 = ((MessageRecord)???).senderuin;
                      }
                      if (QLog.isColorLevel())
                      {
                        localObject4 = new StringBuilder().append("需要定位的第一条消息是否已经拉到本地：");
                        if (??? == null) {
                          break label1961;
                        }
                      }
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      QLog.d("TroopAioMsgNavigateBar.troop.special_msg.confess_to_me", 2, bool1);
                      localObject4 = localazmp;
                      ??? = localObject7;
                      bool1 = bool2;
                      localObject5 = localObject6;
                      if (localObject8 == null) {
                        break;
                      }
                      localObject4 = localazmp;
                      ??? = localObject7;
                      bool1 = bool2;
                      localObject5 = localObject6;
                      if (this.jdField_c_of_type_Long >= ((MessageRecord)localObject8).shmsgseq) {
                        break;
                      }
                      bool1 = true;
                      localObject4 = localazmp;
                      ??? = localObject7;
                      localObject5 = localObject6;
                      break;
                      localObject7 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698700);
                      break label1824;
                    }
                  }
                  if (this.jdField_e_of_type_Int == 6)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697684);
                    localObject4 = azmp.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  if (this.jdField_e_of_type_Int == 26)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697924);
                    localObject4 = azmp.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    if (mye.a((MessageRecord)localObject8)) {}
                    for (i = 2;; i = 1)
                    {
                      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_topmsgcue", i, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                      break;
                    }
                  }
                  if (this.jdField_e_of_type_Int == 18)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697568);
                    localObject4 = azmp.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  if (this.jdField_e_of_type_Int == 21)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    if ((StructMsgForGeneralShare)axuy.a(((MessageRecord)localObject8).msgData) == null) {
                      if (QLog.isColorLevel()) {
                        QLog.d("TroopAioMsgNavigateBar", 2, "showNavigateBarIfNeeded() :calendarMsg getStructMsg is null");
                      }
                    }
                    for (??? = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697536);; ??? = StructMsgForGeneralShare.remindBrief)
                    {
                      localObject4 = azmp.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                      localObject5 = ((MessageRecord)localObject8).senderuin;
                      bool1 = true;
                      this.jdField_a_of_type_JavaLangString = StructMsgForGeneralShare.eventType;
                      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_calendar", "", "notice", "exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "", "");
                      break;
                    }
                  }
                  if (this.jdField_e_of_type_Int == 22)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697932);
                    localObject4 = azmp.a(this.jdField_e_of_type_Int, ((MessageRecord)localObject8).shmsgseq, this.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    MessageForReplyText.reportReplyMsg(null, "AIOchat", "Appear_topmsgcue_reply", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
                    break;
                  }
                  if (this.jdField_e_of_type_Int == 3)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.jdField_a_of_type_AndroidContentContext.getString(2131697854);
                    localObject4 = azmp.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  if (this.jdField_e_of_type_Int == 4)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.jdField_a_of_type_AndroidContentContext.getString(2131697855);
                    localObject4 = azmp.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  if (this.jdField_e_of_type_Int == 5)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.jdField_a_of_type_AndroidContentContext.getString(2131697700);
                    localObject4 = azmp.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                    localObject5 = "";
                    bool1 = true;
                    break;
                  }
                  if (this.jdField_e_of_type_Int == 19)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.jdField_a_of_type_AndroidContentContext.getString(2131692927);
                    localObject4 = azmp.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  if (this.jdField_e_of_type_Int == 13)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.jdField_a_of_type_AndroidContentContext.getString(2131698516);
                    localObject4 = azmp.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  if (this.jdField_e_of_type_Int == 20)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (!(localObject8 instanceof MessageForArkApp)) {
                      break;
                    }
                    ??? = aluc.a((MessageForArkApp)localObject8);
                    localObject4 = azmp.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  if (this.jdField_e_of_type_Int == 24)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
                    ajyf localajyf = (ajyf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255);
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localajyf == null) {
                      break;
                    }
                    localObject8 = localajyf.a((String)localObject8);
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((HotChatItemData)localObject8).mGameId <= 0) {
                      break;
                    }
                    localObject4 = HotChatCenterFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((HotChatItemData)localObject8).mHotChatCode, ((HotChatItemData)localObject8).mGameId);
                    if (localObject4 != null)
                    {
                      ??? = ((AioPushData)localObject4).wording;
                      bool1 = true;
                      this.jdField_b_of_type_JavaLangObject = localObject4;
                    }
                    for (;;)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("TroopAioMsgNavigateBar", 2, "[showNavigateBarIfNeeded] for " + ((HotChatItemData)localObject8).mHotChatCode + " " + ((HotChatItemData)localObject8).mGameId);
                      }
                      localObject4 = localazmp;
                      localObject5 = localObject6;
                      break;
                      bool1 = false;
                      ??? = localObject7;
                    }
                  }
                  if (this.jdField_e_of_type_Int == 101)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (!(localObject8 instanceof MessageForArkApp)) {
                      break;
                    }
                    localObject4 = localazmp;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.jdField_a_of_type_AndroidContentContext.getString(2131699609);
                    localObject4 = azmp.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  localObject4 = localazmp;
                  ??? = localObject7;
                  bool1 = bool2;
                  localObject5 = localObject6;
                  if (this.jdField_e_of_type_Int != 102) {
                    break;
                  }
                  localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                  localObject4 = localazmp;
                  ??? = localObject7;
                  bool1 = bool2;
                  localObject5 = localObject6;
                  if (localObject8 == null) {
                    break;
                  }
                  localObject4 = localazmp;
                  ??? = localObject7;
                  bool1 = bool2;
                  localObject5 = localObject6;
                  if (((MessageRecord)localObject8).shmsgseq >= l1) {
                    break;
                  }
                  ??? = this.jdField_a_of_type_AndroidContentContext.getString(2131697871);
                  localObject4 = azmp.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                  localObject5 = ((MessageRecord)localObject8).senderuin;
                  bool1 = true;
                  break;
                  bool1 = false;
                  break label775;
                }
              }
              localObject5 = "";
              ??? = localObject7;
            }
            Object localObject4 = null;
            ??? = "";
            bool1 = false;
            continue;
          }
          label1381:
          label1510:
          i = 0;
        }
      }
    }
  }
  
  protected void h()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      a(this.jdField_e_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_JavaLangObject, this.jdField_d_of_type_JavaLangString);
      l();
      b();
      axqw.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "qq_vip", "0X800A8FB", 0, 1, 0, "", "", "", "");
      return;
    }
    if ((this.jdField_e_of_type_Int == 23) || (this.jdField_e_of_type_Int == 14) || (this.jdField_e_of_type_Int == 17) || (this.jdField_e_of_type_Int == 100) || (this.jdField_e_of_type_Int == 11) || (this.jdField_e_of_type_Int == 6) || (this.jdField_e_of_type_Int == 21) || (this.jdField_e_of_type_Int == 18) || (this.jdField_e_of_type_Int == 5) || (this.jdField_e_of_type_Int == 4) || (this.jdField_e_of_type_Int == 3) || (this.jdField_e_of_type_Int == 13) || (this.jdField_e_of_type_Int == 20) || (this.jdField_e_of_type_Int == 101) || (this.jdField_e_of_type_Int == 102)) {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
      {
        setChanged();
        notifyObservers(azmp.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int));
        if (QLog.isColorLevel()) {
          QLog.d("TroopAioMsgNavigateBar.troop.special_msg", 2, "notifyUi==>navigateType:" + this.jdField_e_of_type_Int + "|navigateSeq:" + this.jdField_c_of_type_Long);
        }
      }
    }
    for (;;)
    {
      i();
      return;
      if ((this.jdField_e_of_type_Int == 22) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))
      {
        setChanged();
        MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
        if (localMessageRecord != null) {
          notifyObservers(azmp.a(this.jdField_e_of_type_Int, localMessageRecord.shmsgseq, this.jdField_d_of_type_Int));
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopAioMsgNavigateBar.troop.special_msg", 2, "notifyUi==>navigateType:" + this.jdField_e_of_type_Int + "|navigateSeq:" + this.jdField_c_of_type_Long);
        }
      }
    }
  }
  
  public void i()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new TroopAioMsgNavigateBar.5(this));
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
      if ((this.jdField_b_of_type_JavaLangObject != null) && ((this.jdField_b_of_type_JavaLangObject instanceof AioPushData)))
      {
        paramAnimation = (AioPushData)this.jdField_b_of_type_JavaLangObject;
        if (!paramAnimation.isShow)
        {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clk_active", 0, 0, new String[] { String.valueOf(paramAnimation.busId), paramAnimation.actId });
          HotChatCenterFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramAnimation, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          return;
        }
        this.jdField_b_of_type_JavaLangObject = null;
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
      case 2131362231: 
        i();
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null);
    axqw.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "qq_vip", "0X800A8FC", 0, 1, 0, "", "", "", "");
    this.jdField_f_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800621C", "0X800621C", 0, 0, "", "", "", "");
    }
    if (this.jdField_e_of_type_Int == 1) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_Dis", "", "Grp_AIO", "Clk_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      }
    }
    for (;;)
    {
      i();
      return;
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_new_msg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      continue;
      if (this.jdField_e_of_type_Int != 23) {
        break;
      }
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_atme", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_at", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
    int i;
    long l;
    Object localObject1;
    if (a(this.jdField_e_of_type_Int))
    {
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
        break label2199;
      }
      if (this.jdField_e_of_type_Boolean) {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "Clk_owner", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      }
      if (!(this.jdField_b_of_type_AndroidViewView.getTag() instanceof azmp)) {
        break label2199;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      azmp localazmp = (azmp)this.jdField_b_of_type_AndroidViewView.getTag();
      for (;;)
      {
        int j;
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          i = this.jdField_a_of_type_JavaUtilList.size();
          localazmp.jdField_a_of_type_Long = ((Long)this.jdField_a_of_type_JavaUtilList.remove(0)).longValue();
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
                l = ((Long)this.jdField_a_of_type_JavaUtilList.get(0)).longValue();
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
                paramView = (View)localObject1;
                if (localObject1 != null)
                {
                  a(((MessageRecord)localObject1).senderuin);
                  if (this.jdField_e_of_type_Int != 17) {
                    break label950;
                  }
                  this.jdField_b_of_type_AndroidWidgetTextView.setText(bbcl.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((MessageRecord)localObject1).senderuin));
                  paramView = (View)localObject1;
                }
              }
              if (!MessageForQQWalletMsg.isRedPacketMsg(paramView)) {
                break label1007;
              }
              paramView = (MessageForQQWalletMsg)paramView;
              if ((paramView.messageType != 7) && (paramView.messageType != 8)) {
                break label981;
              }
              this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131719272));
              localazmp.jdField_b_of_type_Boolean = true;
            }
            if ((i == 1) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("TroopAioMsgNavigateBar", 2, "onClick notify");
            }
            setChanged();
            notifyObservers(localazmp);
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
          paramView = (View)localObject1;
          if (this.jdField_e_of_type_Int == 11)
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(ajyc.a(2131715165));
            paramView = (View)localObject1;
            continue;
            label981:
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131719255));
            localazmp.jdField_a_of_type_Boolean = true;
            continue;
            label1007:
            Resources localResources;
            if (this.jdField_e_of_type_Int == 17)
            {
              localazmp.jdField_a_of_type_Boolean = false;
              localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
              localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
              if (j > 99) {}
              for (paramView = "99+";; paramView = Integer.valueOf(j))
              {
                ((TextView)localObject1).setText(localResources.getString(2131694469, new Object[] { paramView }));
                break;
              }
            }
            if (this.jdField_e_of_type_Int == 100)
            {
              localazmp.jdField_a_of_type_Boolean = false;
              localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
              localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
              if (j > 99) {}
              for (paramView = "99+";; paramView = Integer.valueOf(j))
              {
                ((TextView)localObject1).setText(localResources.getString(2131699604, new Object[] { paramView }));
                break;
              }
            }
            if (this.jdField_e_of_type_Int == 11)
            {
              localazmp.jdField_a_of_type_Boolean = false;
              this.jdField_a_of_type_AndroidWidgetTextView.setText(ajyc.a(2131715163));
            }
          }
        }
      }
      if (!localazmp.jdField_a_of_type_Boolean) {
        break label2194;
      }
      i = 1;
    }
    for (;;)
    {
      label1192:
      if (i != 0)
      {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_hongbao", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_hongbao", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_sf", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_special_focus", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      break;
      if (this.jdField_e_of_type_Int == 14)
      {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_atall", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_at_all", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 26)
      {
        if (mye.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
        for (i = 2;; i = 1)
        {
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_topmsgcue", i, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_gift", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          break;
        }
      }
      if (this.jdField_e_of_type_Int == 21)
      {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_calendar", "", "notice", "Clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 22)
      {
        MessageForReplyText.reportReplyMsg(null, "AIOchat", "Clk_topmsgcue_reply", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {}
        for (paramView = "Grp_Dis_replyMsg";; paramView = "Grp_AIO")
        {
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", paramView, "", "notice_center_new", "clk_reply", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          break;
        }
      }
      if (this.jdField_e_of_type_Int == 6)
      {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_homework", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 19)
      {
        bded.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2014", "0", false);
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_join_team", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 4)
      {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_file", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 3)
      {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_album", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 20)
      {
        paramView = (azmp)this.jdField_b_of_type_AndroidViewView.getTag();
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView.jdField_b_of_type_Long);
        if ((paramView == null) || (!(paramView instanceof MessageForArkApp))) {
          break;
        }
        paramView = ((MessageForArkApp)paramView).ark_app_message;
        if (paramView == null) {
          break;
        }
        altd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.appName, "AIOMsgRemindClick", 0, 0, 0L, 0L, 0L, "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 24)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TroopAioMsgNavigateBar", 2, "[onClick] into page");
        break;
      }
      if (this.jdField_e_of_type_Int == 102)
      {
        paramView = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        if (paramView == null) {
          break;
        }
        paramView = paramView.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (paramView == null) {
          break;
        }
        boolean bool = this.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_AndroidContentContext.getString(2131697883));
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        ??? = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        l = paramView.dwGroupClassExt;
        if (bool) {}
        for (paramView = "2";; paramView = "1")
        {
          axqw.b((QQAppInterface)localObject1, "dc00898", "", "", "", "0X800AACC", 0, 1, 0, (String)???, String.valueOf(l), paramView, "");
          break;
        }
      }
      if (this.jdField_e_of_type_Int != 101) {
        break;
      }
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AA11", "0X800AA11", 0, 0, "", "", "", "");
      break;
      label2194:
      i = 0;
      break label1192;
      label2199:
      i = 0;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAioMsgNavigateBar", 2, "troopNotify update");
    }
    if ((paramObject instanceof Integer))
    {
      paramObservable = (Integer)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("TroopAioMsgNavigateBar", 2, "update. notifyType = " + paramObservable);
      }
      if ((paramObservable.intValue() == 1007) || (paramObservable.intValue() == 1011))
      {
        if (this.jdField_a_of_type_Azpa.b != null) {
          try
          {
            this.jdField_a_of_type_Azpe = azpe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Azpa.b);
            m();
            return;
          }
          finally {}
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopAioMsgNavigateBar", 2, "update. mNewNorNotice = null!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azng
 * JD-Core Version:    0.7.0.1
 */