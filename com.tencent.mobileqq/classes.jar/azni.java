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

public class azni
  extends azmq
  implements View.OnClickListener, Animation.AnimationListener, Observer
{
  protected static long a;
  protected float a;
  Handler jdField_a_of_type_AndroidOsHandler = new aznj(this, Looper.getMainLooper());
  protected Animation a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected azpc a;
  private azpg jdField_a_of_type_Azpg;
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
  
  public azni()
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
    if (this.jdField_a_of_type_Acup != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
        localObject1 = (MessageRecord)this.jdField_a_of_type_Acup.getItem(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
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
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageResource(2130846568);
      return;
    }
    if (this.jdField_e_of_type_Int == 102)
    {
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageResource(2130849618);
      return;
    }
    if (this.jdField_e_of_type_Int == 101)
    {
      bbll.b(this.jdField_a_of_type_ComTencentWidgetURLThemeImageView, 0);
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageResource(2130838187);
      return;
    }
    Object localObject2;
    if ((this.jdField_e_of_type_Int != 1) && (!TextUtils.isEmpty(paramString)))
    {
      if ((!paramString.equals(this.jdField_e_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.getVisibility() == 0))
      {
        this.jdField_e_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable(bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString));
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setVisibility(0);
      localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.getLayoutParams();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
      {
        int i = baxn.a(this.jdField_a_of_type_AndroidContentContext, 30.0F);
        ((LinearLayout.LayoutParams)localObject1).height = i;
        ((LinearLayout.LayoutParams)localObject1).width = i;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        localObject2 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
        if ((localObject2 == null) || (!((HotChatManager)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (localObject1 == null) || (((ajxl)localObject1).b(paramString))) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable(bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, paramString, true));
        label322:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          localLayoutParams.leftMargin = baxn.a(this.jdField_a_of_type_AndroidContentContext, 7.0F);
        }
        label349:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
          break label671;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
        return;
        ((LinearLayout.LayoutParams)localObject1).setMargins(baxn.a(this.jdField_a_of_type_AndroidContentContext, 2.5F), baxn.a(this.jdField_a_of_type_AndroidContentContext, 2.5F), 0, baxn.a(this.jdField_a_of_type_AndroidContentContext, 2.5F));
      }
      if (this.jdField_e_of_type_Int == 22)
      {
        localObject1 = this.jdField_b_of_type_AndroidViewView.getTag();
        if (!(localObject1 instanceof azmr)) {
          break label673;
        }
        long l = ((azmr)localObject1).jdField_a_of_type_Long;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l, 0L);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = (MessageRecord)((List)localObject1).get(0);
          label499:
          if ((localObject1 == null) || (!myb.a((MessageRecord)localObject1))) {
            break label673;
          }
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843044);
        }
      }
    }
    label671:
    label673:
    for (Object localObject1 = URLDrawable.getDrawable(myb.a(myb.a((MessageRecord)localObject1).b), (Drawable)localObject2, (Drawable)localObject2);; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString);
      }
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable((Drawable)localObject2);
      break label322;
      localObject1 = null;
      break label499;
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable(bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString));
      break label322;
      if (this.jdField_e_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable(null);
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageResource(2130849567);
        break label349;
      }
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
        break label349;
      }
      localLayoutParams.leftMargin = baxn.a(this.jdField_a_of_type_AndroidContentContext, 14.0F);
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
    asks localasks;
    if (this.jdField_a_of_type_Boolean)
    {
      localasks = (asks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if (localasks != null) {
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
        localasks.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_Int);
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
          localasks.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000, this.jdField_e_of_type_Int);
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
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_Dis", "", "Grp_AIO", "Appear_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
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
              axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_new_msg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              return;
              if (this.jdField_e_of_type_Int == 4)
              {
                axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_file", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                return;
              }
              if (this.jdField_e_of_type_Int == 3)
              {
                axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_album", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                return;
              }
              if (this.jdField_e_of_type_Int == 23)
              {
                axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_atme", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_at", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                return;
              }
              if (this.jdField_e_of_type_Int == 17)
              {
                if (((azmr)this.jdField_b_of_type_AndroidViewView.getTag()).jdField_a_of_type_Boolean)
                {
                  axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_hongbao", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                  axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_hongbao", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                  return;
                }
                axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_sf", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_special_focus", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                return;
              }
              if (this.jdField_e_of_type_Int == 14)
              {
                axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_atall", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_at_all", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                return;
              }
              if (this.jdField_e_of_type_Int == 6)
              {
                axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_homework", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                return;
              }
              if (this.jdField_e_of_type_Int == 22)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {}
                for (localObject = "Grp_Dis_replyMsg";; localObject = "Grp_AIO")
                {
                  axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", (String)localObject, "", "notice_center_new", "exp_reply", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                  return;
                }
              }
              if (this.jdField_e_of_type_Int == 19)
              {
                bdes.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2013", "0", false);
                axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_join_team", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                return;
              }
              if (this.jdField_e_of_type_Int == 26)
              {
                axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_gift", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                return;
              }
              if (this.jdField_e_of_type_Int != 20) {
                break;
              }
              localObject = (azmr)this.jdField_b_of_type_AndroidViewView.getTag();
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((azmr)localObject).jdField_b_of_type_Long);
            } while ((localObject == null) || (!(localObject instanceof MessageForArkApp)));
            localObject = ((MessageForArkApp)localObject).ark_app_message;
          } while (localObject == null);
          altc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ArkAppMessage)localObject).appName, "AIOMsgRemindShow", 0, 0, 0L, 0L, 0L, "", "");
          return;
          if (this.jdField_e_of_type_Int == 101)
          {
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AA10", "0X800AA10", 0, 0, "", "", "", "");
            return;
          }
        } while (this.jdField_e_of_type_Int != 102);
        localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      } while (localObject == null);
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while (localObject == null);
    boolean bool = this.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_AndroidContentContext.getString(2131697893));
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    long l = ((TroopInfo)localObject).dwGroupClassExt;
    if (bool) {}
    for (Object localObject = "2";; localObject = "1")
    {
      axqy.b(localQQAppInterface, "dc00898", "", "", "", "0X800AACB", 0, 1, 0, str, String.valueOf(l), (String)localObject, "");
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
    QLog.d("TroopAioMsgNavigateBar", 2, "showTroopNotifyBar troopNotifyData:" + this.jdField_a_of_type_Azpg + " navigateType:" + this.jdField_e_of_type_Int + " mFIsShow:" + this.jdField_g_of_type_Boolean);
    if ((this.jdField_a_of_type_Azpg != null) && (this.jdField_e_of_type_Int == 102) && (this.jdField_g_of_type_Boolean))
    {
      if (!a()) {
        break label92;
      }
      this.jdField_a_of_type_Azpg = null;
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
        if (!this.jdField_a_of_type_Azpg.jdField_b_of_type_Boolean)
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
          QLog.d("TroopAioMsgNavigateBar", 2, "showTroopNotifyBar troopNotifyData confirmRequired:" + this.jdField_a_of_type_Azpg.jdField_c_of_type_Boolean + " fid:" + this.jdField_a_of_type_Azpg.jdField_a_of_type_JavaLangString + " isShowTipWindow:" + this.jdField_a_of_type_Azpg.jdField_b_of_type_Boolean);
        }
        localObject = new JSONObject(((MessageForArkApp)localObject).ark_app_message.metaList).optJSONObject("mannounce");
        if ((localObject == null) || (!((JSONObject)localObject).optString("fid").equals(this.jdField_a_of_type_Azpg.jdField_a_of_type_JavaLangString))) {
          break label519;
        }
        localObject = (MessageRecord)this.jdField_a_of_type_Acup.getItem(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
        if (localObject == null) {
          break label519;
        }
        long l = ((MessageRecord)localObject).shmsgseq;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
        if ((localObject == null) || (((MessageRecord)localObject).shmsgseq >= l)) {
          break label519;
        }
        if (this.jdField_a_of_type_Azpg.jdField_c_of_type_Boolean) {
          this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getString(2131697893);
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
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(101);
      this.jdField_a_of_type_Azpg = null;
    } while (!QLog.isColorLevel());
    QLog.d("TroopAioMsgNavigateBar", 2, "showTroopNotifyBar mFIsShow:" + this.jdField_g_of_type_Boolean);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      asks localasks = (asks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if (localasks != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          return localasks.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          return localasks.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
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
      localLayoutParams.topMargin = baxn.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
      localLayoutParams.addRule(11);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView, localLayoutParams);
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    int i = a(new int[] { 2131377875, 2131372955, 2131373042, 2131373037 });
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
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130843262);
      if (paramInt != 1) {
        break label583;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166133));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166133));
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130849615);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      return;
      if (paramInt == 11)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131715171));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131715182));
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 13.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 13.0F);
        break;
      }
      if (paramInt == 100)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699612);
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
        paramObject = ajya.a(2131715170);
        float f1 = this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(paramObject);
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth((int)f1);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bbcz.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString2));
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
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130849616);
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
        paramList = (azmr)this.jdField_b_of_type_AndroidViewView.getTag();
        if ((paramList == null) || ((!paramList.jdField_a_of_type_Boolean) && (!paramList.jdField_b_of_type_Boolean))) {
          break label193;
        }
        if (paramList.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131719266));
          return;
        }
      }
      finally {}
      if (paramList.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131719283));
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
            ((TextView)localObject).setText(localResources.getString(2131694470, new Object[] { paramList }));
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
            ((TextView)localObject).setText(localResources.getString(2131699615, new Object[] { paramList }));
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
    Object localObject = (asks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      i = ((asks)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
        i = ((asks)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
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
    this.jdField_a_of_type_Azpg = null;
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("TroopAioMsgNavigateBar.troop.special_msg", 2, "onInit==>mUnreadCount:" + this.jdField_d_of_type_Int + "|mTroopLastReadSeq:" + this.jdField_b_of_type_Long);
    }
    Object localObject;
    if (!((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = (asks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
        break label404;
      }
      ((asks)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1, this.jdField_b_of_type_Long, "", 0, null);
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
      localObject = (asks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      try
      {
        this.jdField_a_of_type_Azpc = ((asks)localObject).a(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)), true);
        this.jdField_a_of_type_Azpc.addObserver(this);
        return;
      }
      catch (Exception localException)
      {
        label404:
        while (!QLog.isColorLevel()) {}
        QLog.e("TroopAioMsgNavigateBar", 2, localException.toString());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        ((asks)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000, 1, this.jdField_b_of_type_Long, "", 0, null);
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
    Object localObject = (asks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      ((asks)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Azpg = null;
      if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView != null))
      {
        this.jdField_b_of_type_AndroidViewView.clearAnimation();
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        localObject = (ViewGroup)this.jdField_c_of_type_AndroidViewView.getParent();
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.jdField_c_of_type_AndroidViewView);
        }
      }
      this.jdField_a_of_type_Azpc.deleteObserver(this);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        ((asks)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000, 0);
      }
    }
  }
  
  public void e()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0))
    {
      Object localObject = (azmr)this.jdField_b_of_type_AndroidViewView.getTag();
      if (localObject != null)
      {
        long l2 = ((azmr)localObject).jdField_a_of_type_Long;
        long l1 = l2;
        if (((azmr)localObject).jdField_b_of_type_Long != 0L)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((azmr)localObject).jdField_b_of_type_Long);
          l1 = l2;
          if (localObject != null) {
            l1 = ((MessageRecord)localObject).shmsgseq;
          }
        }
        if (l1 > 0L)
        {
          int i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
          localObject = (ChatMessage)this.jdField_a_of_type_Acup.getItem(i);
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
    ??? = (asks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
    Object localObject2;
    long l1;
    long l2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      this.jdField_e_of_type_Int = ((asks)???).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangObject = ((asks)???).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (localObject2 != null)
      {
        localObject2 = ((TroopManager)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject2 != null) && (((TroopInfo)localObject2).hasOrgs())) {
          this.jdField_e_of_type_Boolean = true;
        }
      }
      this.jdField_a_of_type_JavaUtilList = ((asks)???).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_Int);
      if (!c()) {
        break label802;
      }
      this.jdField_d_of_type_Long = ((asks)???).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (this.jdField_d_of_type_Long != -1L) {
        Collections.sort(this.jdField_a_of_type_JavaUtilList, new aznk(this));
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
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "his_owner", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", l1 - l2 + "");
        }
      }
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (this.jdField_a_of_type_Acup == null)) {
        break label524;
      }
      localObject2 = (ChatMessage)this.jdField_a_of_type_Acup.getItem(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
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
      azmr localazmr;
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
          this.jdField_e_of_type_Int = ((asks)???).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
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
        localazmr = null;
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
        ??? = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698066), new Object[] { Integer.valueOf(this.jdField_d_of_type_Int) });
        localObject2 = azmr.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
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
        this.jdField_c_of_type_Long = ((asks)???).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      } else {
        label1362:
        label1623:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
        {
          this.jdField_c_of_type_Long = ((asks)???).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
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
              ??? = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697506);
              localObject4 = azmr.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
              localObject5 = ((MessageRecord)localObject5).senderuin;
              bool1 = true;
            }
            for (;;)
            {
              break;
              if (this.jdField_e_of_type_Int == 14)
              {
                localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                localObject4 = localazmr;
                ??? = localObject7;
                bool1 = bool2;
                localObject5 = localObject6;
                if (localObject8 == null) {
                  break;
                }
                localObject4 = localazmr;
                ??? = localObject7;
                bool1 = bool2;
                localObject5 = localObject6;
                if (((MessageRecord)localObject8).shmsgseq >= l1) {
                  break;
                }
                ??? = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697504);
                localObject4 = azmr.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                localObject5 = ((MessageRecord)localObject8).senderuin;
                bool1 = true;
                break;
              }
              if ((this.jdField_e_of_type_Int == 17) || (this.jdField_e_of_type_Int == 100))
              {
                localObject4 = azmr.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
                {
                  localObject5 = this.jdField_a_of_type_AndroidContentContext.getResources();
                  if (this.jdField_e_of_type_Int == 17)
                  {
                    i = 2131694470;
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
                    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "focus", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
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
                    ??? = this.jdField_a_of_type_AndroidContentContext.getString(2131719283);
                    ((azmr)localObject4).jdField_b_of_type_Boolean = true;
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
                    i = 2131699615;
                    break label1362;
                    ??? = Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size());
                    break label1381;
                    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "msg_owner", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList.size() + "", "", "");
                    break label1454;
                    ??? = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719729);
                    break label1454;
                    ??? = this.jdField_a_of_type_AndroidContentContext.getString(2131719266);
                    ((azmr)localObject4).jdField_a_of_type_Boolean = true;
                    break label1510;
                  }
                  if (this.jdField_e_of_type_Int == 11)
                  {
                    localazmr = azmr.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                    ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
                    {
                      localObject7 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698710);
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
                      localObject4 = localazmr;
                      ??? = localObject7;
                      bool1 = bool2;
                      localObject5 = localObject6;
                      if (localObject8 == null) {
                        break;
                      }
                      localObject4 = localazmr;
                      ??? = localObject7;
                      bool1 = bool2;
                      localObject5 = localObject6;
                      if (this.jdField_c_of_type_Long >= ((MessageRecord)localObject8).shmsgseq) {
                        break;
                      }
                      bool1 = true;
                      localObject4 = localazmr;
                      ??? = localObject7;
                      localObject5 = localObject6;
                      break;
                      localObject7 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698710);
                      break label1824;
                    }
                  }
                  if (this.jdField_e_of_type_Int == 6)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697689);
                    localObject4 = azmr.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  if (this.jdField_e_of_type_Int == 26)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697934);
                    localObject4 = azmr.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    if (myb.a((MessageRecord)localObject8)) {}
                    for (i = 2;; i = 1)
                    {
                      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_topmsgcue", i, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                      break;
                    }
                  }
                  if (this.jdField_e_of_type_Int == 18)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697569);
                    localObject4 = azmr.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  if (this.jdField_e_of_type_Int == 21)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    if ((StructMsgForGeneralShare)axva.a(((MessageRecord)localObject8).msgData) == null) {
                      if (QLog.isColorLevel()) {
                        QLog.d("TroopAioMsgNavigateBar", 2, "showNavigateBarIfNeeded() :calendarMsg getStructMsg is null");
                      }
                    }
                    for (??? = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697537);; ??? = StructMsgForGeneralShare.remindBrief)
                    {
                      localObject4 = azmr.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                      localObject5 = ((MessageRecord)localObject8).senderuin;
                      bool1 = true;
                      this.jdField_a_of_type_JavaLangString = StructMsgForGeneralShare.eventType;
                      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_calendar", "", "notice", "exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "", "");
                      break;
                    }
                  }
                  if (this.jdField_e_of_type_Int == 22)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697942);
                    localObject4 = azmr.a(this.jdField_e_of_type_Int, ((MessageRecord)localObject8).shmsgseq, this.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    MessageForReplyText.reportReplyMsg(null, "AIOchat", "Appear_topmsgcue_reply", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
                    break;
                  }
                  if (this.jdField_e_of_type_Int == 3)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.jdField_a_of_type_AndroidContentContext.getString(2131697864);
                    localObject4 = azmr.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  if (this.jdField_e_of_type_Int == 4)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.jdField_a_of_type_AndroidContentContext.getString(2131697865);
                    localObject4 = azmr.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  if (this.jdField_e_of_type_Int == 5)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.jdField_a_of_type_AndroidContentContext.getString(2131697705);
                    localObject4 = azmr.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                    localObject5 = "";
                    bool1 = true;
                    break;
                  }
                  if (this.jdField_e_of_type_Int == 19)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.jdField_a_of_type_AndroidContentContext.getString(2131692928);
                    localObject4 = azmr.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  if (this.jdField_e_of_type_Int == 13)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.jdField_a_of_type_AndroidContentContext.getString(2131698526);
                    localObject4 = azmr.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  if (this.jdField_e_of_type_Int == 20)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (!(localObject8 instanceof MessageForArkApp)) {
                      break;
                    }
                    ??? = alub.a((MessageForArkApp)localObject8);
                    localObject4 = azmr.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  if (this.jdField_e_of_type_Int == 24)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
                    ajyd localajyd = (ajyd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255);
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localajyd == null) {
                      break;
                    }
                    localObject8 = localajyd.a((String)localObject8);
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (localObject8 == null) {
                      break;
                    }
                    localObject4 = localazmr;
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
                      localObject4 = localazmr;
                      localObject5 = localObject6;
                      break;
                      bool1 = false;
                      ??? = localObject7;
                    }
                  }
                  if (this.jdField_e_of_type_Int == 101)
                  {
                    localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (!(localObject8 instanceof MessageForArkApp)) {
                      break;
                    }
                    localObject4 = localazmr;
                    ??? = localObject7;
                    bool1 = bool2;
                    localObject5 = localObject6;
                    if (((MessageRecord)localObject8).shmsgseq >= l1) {
                      break;
                    }
                    ??? = this.jdField_a_of_type_AndroidContentContext.getString(2131699620);
                    localObject4 = azmr.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
                    localObject5 = ((MessageRecord)localObject8).senderuin;
                    bool1 = true;
                    break;
                  }
                  localObject4 = localazmr;
                  ??? = localObject7;
                  bool1 = bool2;
                  localObject5 = localObject6;
                  if (this.jdField_e_of_type_Int != 102) {
                    break;
                  }
                  localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
                  localObject4 = localazmr;
                  ??? = localObject7;
                  bool1 = bool2;
                  localObject5 = localObject6;
                  if (localObject8 == null) {
                    break;
                  }
                  localObject4 = localazmr;
                  ??? = localObject7;
                  bool1 = bool2;
                  localObject5 = localObject6;
                  if (((MessageRecord)localObject8).shmsgseq >= l1) {
                    break;
                  }
                  ??? = this.jdField_a_of_type_AndroidContentContext.getString(2131697881);
                  localObject4 = azmr.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int);
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
      axqy.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "qq_vip", "0X800A8FB", 0, 1, 0, "", "", "", "");
      return;
    }
    if ((this.jdField_e_of_type_Int == 23) || (this.jdField_e_of_type_Int == 14) || (this.jdField_e_of_type_Int == 17) || (this.jdField_e_of_type_Int == 100) || (this.jdField_e_of_type_Int == 11) || (this.jdField_e_of_type_Int == 6) || (this.jdField_e_of_type_Int == 21) || (this.jdField_e_of_type_Int == 18) || (this.jdField_e_of_type_Int == 5) || (this.jdField_e_of_type_Int == 4) || (this.jdField_e_of_type_Int == 3) || (this.jdField_e_of_type_Int == 13) || (this.jdField_e_of_type_Int == 20) || (this.jdField_e_of_type_Int == 101) || (this.jdField_e_of_type_Int == 102)) {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
      {
        setChanged();
        notifyObservers(azmr.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int));
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
          notifyObservers(azmr.a(this.jdField_e_of_type_Int, localMessageRecord.shmsgseq, this.jdField_d_of_type_Int));
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
      case 2131362230: 
        i();
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null);
    axqy.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "qq_vip", "0X800A8FC", 0, 1, 0, "", "", "", "");
    this.jdField_f_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800621C", "0X800621C", 0, 0, "", "", "", "");
    }
    if (this.jdField_e_of_type_Int == 1) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_Dis", "", "Grp_AIO", "Clk_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      }
    }
    for (;;)
    {
      i();
      return;
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_new_msg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      continue;
      if (this.jdField_e_of_type_Int != 23) {
        break;
      }
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_atme", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_at", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
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
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "Clk_owner", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      }
      if (!(this.jdField_b_of_type_AndroidViewView.getTag() instanceof azmr)) {
        break label2199;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      azmr localazmr = (azmr)this.jdField_b_of_type_AndroidViewView.getTag();
      for (;;)
      {
        int j;
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          i = this.jdField_a_of_type_JavaUtilList.size();
          localazmr.jdField_a_of_type_Long = ((Long)this.jdField_a_of_type_JavaUtilList.remove(0)).longValue();
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
                  this.jdField_b_of_type_AndroidWidgetTextView.setText(bbcz.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((MessageRecord)localObject1).senderuin));
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
              this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131719283));
              localazmr.jdField_b_of_type_Boolean = true;
            }
            if ((i == 1) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("TroopAioMsgNavigateBar", 2, "onClick notify");
            }
            setChanged();
            notifyObservers(localazmr);
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
            this.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131715176));
            paramView = (View)localObject1;
            continue;
            label981:
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131719266));
            localazmr.jdField_a_of_type_Boolean = true;
            continue;
            label1007:
            Resources localResources;
            if (this.jdField_e_of_type_Int == 17)
            {
              localazmr.jdField_a_of_type_Boolean = false;
              localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
              localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
              if (j > 99) {}
              for (paramView = "99+";; paramView = Integer.valueOf(j))
              {
                ((TextView)localObject1).setText(localResources.getString(2131694470, new Object[] { paramView }));
                break;
              }
            }
            if (this.jdField_e_of_type_Int == 100)
            {
              localazmr.jdField_a_of_type_Boolean = false;
              localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
              localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
              if (j > 99) {}
              for (paramView = "99+";; paramView = Integer.valueOf(j))
              {
                ((TextView)localObject1).setText(localResources.getString(2131699615, new Object[] { paramView }));
                break;
              }
            }
            if (this.jdField_e_of_type_Int == 11)
            {
              localazmr.jdField_a_of_type_Boolean = false;
              this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131715174));
            }
          }
        }
      }
      if (!localazmr.jdField_a_of_type_Boolean) {
        break label2194;
      }
      i = 1;
    }
    for (;;)
    {
      label1192:
      if (i != 0)
      {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_hongbao", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_hongbao", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_sf", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_special_focus", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      break;
      if (this.jdField_e_of_type_Int == 14)
      {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_atall", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_at_all", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 26)
      {
        if (myb.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
        for (i = 2;; i = 1)
        {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_topmsgcue", i, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_gift", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          break;
        }
      }
      if (this.jdField_e_of_type_Int == 21)
      {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_calendar", "", "notice", "Clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 22)
      {
        MessageForReplyText.reportReplyMsg(null, "AIOchat", "Clk_topmsgcue_reply", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {}
        for (paramView = "Grp_Dis_replyMsg";; paramView = "Grp_AIO")
        {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", paramView, "", "notice_center_new", "clk_reply", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          break;
        }
      }
      if (this.jdField_e_of_type_Int == 6)
      {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_homework", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 19)
      {
        bdes.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2014", "0", false);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_join_team", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 4)
      {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_file", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 3)
      {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_album", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 20)
      {
        paramView = (azmr)this.jdField_b_of_type_AndroidViewView.getTag();
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView.jdField_b_of_type_Long);
        if ((paramView == null) || (!(paramView instanceof MessageForArkApp))) {
          break;
        }
        paramView = ((MessageForArkApp)paramView).ark_app_message;
        if (paramView == null) {
          break;
        }
        altc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.appName, "AIOMsgRemindClick", 0, 0, 0L, 0L, 0L, "", "");
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
        boolean bool = this.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_AndroidContentContext.getString(2131697893));
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        ??? = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        l = paramView.dwGroupClassExt;
        if (bool) {}
        for (paramView = "2";; paramView = "1")
        {
          axqy.b((QQAppInterface)localObject1, "dc00898", "", "", "", "0X800AACC", 0, 1, 0, (String)???, String.valueOf(l), paramView, "");
          break;
        }
      }
      if (this.jdField_e_of_type_Int != 101) {
        break;
      }
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AA11", "0X800AA11", 0, 0, "", "", "", "");
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
        if (this.jdField_a_of_type_Azpc.b != null) {
          try
          {
            this.jdField_a_of_type_Azpg = azpg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Azpc.b);
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
 * Qualified Name:     azni
 * JD-Core Version:    0.7.0.1
 */