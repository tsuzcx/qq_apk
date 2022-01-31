package com.tencent.mobileqq.ark;

import aaxa;
import aaxb;
import aaxc;
import aaxd;
import aaxe;
import aaxg;
import aaxh;
import aaxi;
import aaxj;
import aaxk;
import aaxl;
import aaxn;
import aaxp;
import aaxq;
import aaxr;
import aaxs;
import aaxt;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkContextInfo;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.statistics.ArkAppReportController;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import com.tencent.wordsegment.SemanticItem;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class ArkRecommendController
  implements ArkRecommendLogic.SemanticAnalysisResult
{
  public static int a;
  public static long a;
  public static String a;
  private static final SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
  public static ArrayList a;
  public static HashMap a;
  public static int b;
  public static String b;
  public static HashMap b;
  public static int c;
  public static String c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  public static int i;
  public static int j;
  public static int k;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aaxa(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private ArkAiAppPanel jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel;
  private ArkAiScrollBar jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar;
  private ArkRecommendLogic jdField_a_of_type_ComTencentMobileqqArkArkRecommendLogic;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public WeakReference a;
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  private Runnable jdField_b_of_type_JavaLangRunnable = new aaxg(this);
  private boolean jdField_b_of_type_Boolean;
  private Runnable c;
  public int h;
  
  static
  {
    jdField_a_of_type_Int = 5;
    jdField_b_of_type_Int = 3;
    jdField_c_of_type_Int = 1;
    d = 3;
    e = 3;
    f = 10;
    g = 1;
    i = 1;
    j = 3;
    jdField_a_of_type_JavaLangString = "今天的天气";
    jdField_b_of_type_JavaLangString = "发送想搜的关键词";
    k = 1;
    jdField_a_of_type_Long = 10000L;
  }
  
  public ArkRecommendController(BaseChatPie paramBaseChatPie)
  {
    this.jdField_c_of_type_JavaLangRunnable = new aaxh(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    ArkAppCenter.a(false);
  }
  
  private static String a()
  {
    if (!TextUtils.isEmpty(ArkAiAppCenter.jdField_b_of_type_JavaLangString)) {
      return ArkAiAppCenter.jdField_b_of_type_JavaLangString;
    }
    return BaseActivity.sTopActivity.getString(2131438814);
  }
  
  public static String a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return "";
    }
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    return SharePreferenceUtils.a(paramContext, "ark_switch_state_" + paramQQAppInterface).toString();
  }
  
  private void a(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, RecommendCommonMessage paramRecommendCommonMessage, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, ArkRecommendController.AttachAppHolder paramAttachAppHolder, boolean paramBoolean, int paramInt)
  {
    a(paramContext, paramSessionInfo, paramQQAppInterface, paramRecommendCommonMessage, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener, paramAttachAppHolder, paramBoolean, true, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramRecommendCommonMessage, 1);
    }
  }
  
  public static void a(Context paramContext, String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    SharePreferenceUtils.a(paramContext, "ark_switch_state_" + paramQQAppInterface, paramString);
  }
  
  public static void a(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface)
  {
    ArkAppCenter localArkAppCenter = (ArkAppCenter)paramQQAppInterface.getManager(120);
    if (localArkAppCenter != null) {
      localArkAppCenter.a().a(paramQQAppInterface, false);
    }
    if (paramBaseChatPie != null) {
      paramBaseChatPie.b(131072);
    }
  }
  
  private void a(ArkAiInfo paramArkAiInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (paramArkAiInfo == null) || (TextUtils.isEmpty(paramArkAiInfo.h))) {
      if (QLog.isColorLevel()) {
        QLog.d("ArkRecommendController", 2, "showKeywordGrayTip mChatPie or ArkAiInfo is null");
      }
    }
    ArkAiAppCenter.ArkAiKeywordConfig localArkAiKeywordConfig;
    do
    {
      int m;
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
                if ((ArkAiAppCenter.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (ArkAiAppCenter.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("ArkRecommendController", 2, "showKeywordGrayTip ark keyword config is null");
              return;
              if ((ArkAiAppCenter.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramArkAiInfo.h)) && (ArkAiAppCenter.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramArkAiInfo.h) != null)) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("ArkRecommendController", 2, "showKeywordGrayTip ark keyword config not match ArkAiInfo context=" + paramArkAiInfo.h);
            return;
            localArkAiKeywordConfig = (ArkAiAppCenter.ArkAiKeywordConfig)ArkAiAppCenter.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramArkAiInfo.h);
            if ((paramArkAiInfo.h.equals(localArkAiKeywordConfig.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localArkAiKeywordConfig.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(localArkAiKeywordConfig.d))) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("ArkRecommendController", 2, "showKeywordGrayTip ark keyword config para is invalid");
          return;
          paramArkAiInfo = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          localObject = jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(SharedPreUtils.a(BaseApplicationImpl.getApplication(), paramArkAiInfo, localArkAiKeywordConfig.jdField_b_of_type_JavaLangString)));
          if (!jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(System.currentTimeMillis())).equals(localObject)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ArkRecommendController", 2, "showKeywordGrayTip gray tip shown today for type=" + localArkAiKeywordConfig.jdField_b_of_type_JavaLangString);
        return;
        m = SharedPreUtils.c(BaseApplicationImpl.getApplication(), paramArkAiInfo, localArkAiKeywordConfig.jdField_b_of_type_JavaLangString);
        if (m < 3) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ArkRecommendController", 2, "showKeywordGrayTip gray tip shown max times for type=" + localArkAiKeywordConfig.jdField_b_of_type_JavaLangString);
      return;
      Object localObject = new UniteGrayTipParam(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramArkAiInfo, localArkAiKeywordConfig.d, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5020, 2555907, MessageCache.a());
      MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
      localMessageForUniteGrayTip.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UniteGrayTipParam)localObject);
      UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForUniteGrayTip);
      SharedPreUtils.a(BaseApplicationImpl.getApplication(), paramArkAiInfo, localArkAiKeywordConfig.jdField_b_of_type_JavaLangString, System.currentTimeMillis());
      SharedPreUtils.c(BaseApplicationImpl.getApplication(), paramArkAiInfo, localArkAiKeywordConfig.jdField_b_of_type_JavaLangString, m + 1);
    } while (!QLog.isColorLevel());
    QLog.d("ArkRecommendController", 2, "showKeywordGrayTip success wording = " + localArkAiKeywordConfig.d);
  }
  
  public static void a(QQCustomDialog paramQQCustomDialog, boolean paramBoolean)
  {
    paramQQCustomDialog = (TextView)paramQQCustomDialog.findViewById(2131362776);
    paramQQCustomDialog.setGravity(17);
    paramQQCustomDialog.setGravity(16);
    String str = ArkAiAppCenter.jdField_a_of_type_JavaLangString;
    Object localObject = a();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (!TextUtils.isEmpty(str))
      {
        localObject = (String)localObject + "点击了解详情。";
        int m = TextUtils.lastIndexOf((CharSequence)localObject, '了');
        int n = TextUtils.lastIndexOf((CharSequence)localObject, '情');
        localObject = new SpannableString((CharSequence)localObject);
        ((SpannableString)localObject).setSpan(new aaxt(new aaxb(paramBoolean, str)), m, n + 1, 33);
        paramQQCustomDialog.setText((CharSequence)localObject);
        paramQQCustomDialog.setMovementMethod(LinkMovementMethod.getInstance());
        return;
      }
      paramQQCustomDialog.setText((CharSequence)localObject);
      return;
    }
    paramQQCustomDialog.setText(BaseActivity.sTopActivity.getString(2131438814));
  }
  
  private void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    int m = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (paramCharSequence == null)) {}
    do
    {
      Editable localEditable;
      do
      {
        return;
        localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
        int n = paramCharSequence.toString().indexOf(jdField_b_of_type_JavaLangString);
        if (n >= 0) {
          localEditable.delete(n, jdField_b_of_type_JavaLangString.length() + n);
        }
        paramCharSequence = (ArkAtBabyQSpan.ArkBabyQHintSpan[])localEditable.getSpans(0, paramCharSequence.length(), ArkAtBabyQSpan.ArkBabyQHintSpan.class);
      } while ((paramCharSequence == null) || (paramCharSequence.length <= 0));
      while (m < paramCharSequence.length)
      {
        localEditable.removeSpan(paramCharSequence[m]);
        m += 1;
      }
    } while (!paramBoolean);
    ArkAppDataReport.d(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void a(boolean paramBoolean1, ArkAiAppPanel paramArkAiAppPanel, List paramList, int paramInt1, boolean paramBoolean2, Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, RecommendCommonMessage paramRecommendCommonMessage, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, ArkRecommendController.AttachAppHolder paramAttachAppHolder, boolean paramBoolean3, int paramInt2)
  {
    if (paramBoolean1) {
      paramArkAiAppPanel.a(paramList, paramInt1, null);
    }
    while (!paramBoolean2) {
      return;
    }
    a(paramContext, paramSessionInfo, paramQQAppInterface, paramRecommendCommonMessage, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener, paramAttachAppHolder, paramBoolean3, paramInt2);
  }
  
  public static boolean a(SessionInfo paramSessionInfo)
  {
    return (paramSessionInfo != null) && (((paramSessionInfo.jdField_a_of_type_Int == 0) && (!AppConstants.au.equals(paramSessionInfo.jdField_a_of_type_JavaLangString))) || (paramSessionInfo.jdField_a_of_type_Int == 1000) || (paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 1022) || (paramSessionInfo.jdField_a_of_type_Int == 1001) || (paramSessionInfo.jdField_a_of_type_Int == 1020) || (paramSessionInfo.jdField_a_of_type_Int == 10002));
  }
  
  private static boolean a(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.isSendFromLocal()) && ((paramChatMessage.extraflag == 32768) || (paramChatMessage.extraflag == 32772));
  }
  
  public static boolean a(Node paramNode, JSONObject paramJSONObject)
  {
    boolean bool = true;
    if (paramNode == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        String str = paramNode.getNodeName();
        NodeList localNodeList = paramNode.getChildNodes();
        JSONObject localJSONObject = new JSONObject();
        int m = 0;
        int i1;
        for (int n = 0;; n = i1)
        {
          if (m < localNodeList.getLength())
          {
            Node localNode = localNodeList.item(m);
            if ((localNode instanceof Element))
            {
              a(localNode, localJSONObject);
              i1 = 1;
            }
            else
            {
              i1 = n;
              if ((localNode instanceof Text))
              {
                paramJSONObject.put(str, paramNode.getFirstChild().getNodeValue());
                i1 = n;
              }
            }
          }
          else
          {
            if (n == 0) {
              break;
            }
            paramJSONObject.put(str, localJSONObject);
            return true;
          }
          m += 1;
        }
        return false;
      }
      catch (Exception paramNode) {}
    }
  }
  
  private void b(String paramString, LinkedHashMap paramLinkedHashMap, ArrayList paramArrayList)
  {
    ArkAppCenter.b("ArkRecommendController", String.format(Locale.CHINA, "showBubble, context=%s, app-info-size=%d", new Object[] { paramString, Integer.valueOf(paramArrayList.size()) }));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArkRecommendController", 2, "showBubble.mChatPie is null");
      }
    }
    int m;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar != null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar = new ArkAiScrollBar(this);
        if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar.a()) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar = null;
      } while (!QLog.isColorLevel());
      QLog.d("ArkRecommendController", 2, "showBubble.mScrollBar.init.false");
      return;
      paramString = (ArkAiInfo)paramArrayList.get(0);
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar.a(paramArrayList, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar.b();
      ArkAppDataReport.g(null, paramString.jdField_a_of_type_JavaLangString, paramString.g, paramString.jdField_b_of_type_Int);
      if (!this.jdField_b_of_type_Boolean) {
        ArkAppDataReport.n(null, paramString.jdField_a_of_type_JavaLangString);
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      m = SharedPreUtils.at(BaseApplicationImpl.getApplication(), paramString);
      paramLinkedHashMap = SharedPreUtils.i(BaseApplicationImpl.getApplication(), paramString);
      if (QLog.isColorLevel()) {
        QLog.d("ArkRecommendController", 2, "showKeywordGrayTip closeCount=" + m + "closeSwitch=" + paramLinkedHashMap);
      }
    } while ((m != 0) || (!paramLinkedHashMap.equals("true")));
    if (QLog.isColorLevel()) {
      QLog.d("ArkRecommendController", 2, "showKeywordGrayTip close gray tip");
    }
    paramLinkedHashMap = new UniteGrayTipParam(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131438829), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5020, 2555906, MessageCache.a());
    paramArrayList = new MessageForUniteGrayTip();
    paramArrayList.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinkedHashMap);
    UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList);
    SharedPreUtils.J(BaseApplicationImpl.getApplication(), paramString, 1);
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendLogic != null) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null)) {
      return;
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    Object localObject2;
    Object localObject1;
    if ((this.h == 1) || (this.h == 3000))
    {
      localObject2 = localSessionInfo.jdField_b_of_type_JavaLangString;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localSessionInfo.jdField_a_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendLogic = new ArkRecommendLogic((String)localObject1, this.h);
      this.jdField_a_of_type_Boolean = true;
      return;
      if ((this.h != 0) && (this.h != 2) && (this.h != 1000) && (this.h != 10004) && (this.h != 1004) && (this.h != 1003) && (this.h != 2016) && (this.h != 1011) && (this.h != 1001) && (this.h != 1002) && (this.h != 1029) && (this.h != 1006) && (this.h != 1022)) {
        break;
      }
      localObject1 = localSessionInfo.jdField_a_of_type_JavaLangString;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localSessionInfo.f;
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localSessionInfo.e;
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel != null) {
      return this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel.a();
    }
    return null;
  }
  
  public BaseChatPie a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  }
  
  public ArkRecommendController.AttachAppHolder a(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, ArkRecommendController.AttachAppHolder paramAttachAppHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if ((!(paramChatMessage instanceof RecommendCommonMessage)) || (!ArkAiAppCenter.c) || (ArkAiAppCenter.d) || (((RecommendCommonMessage)paramChatMessage).isArkAtBabyQMsg()) || (!((RecommendCommonMessage)paramChatMessage).hasAiData()) || (a(paramChatMessage)))
    {
      if (paramAttachAppHolder == null) {
        paramContext = null;
      }
      do
      {
        return paramContext;
        paramAttachAppHolder.jdField_a_of_type_Boolean = false;
        if (paramAttachAppHolder.jdField_a_of_type_AndroidWidgetImageView != null) {
          paramAttachAppHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if (paramAttachAppHolder.jdField_a_of_type_AndroidViewView != null) {
          paramAttachAppHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
        if (paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView != null)
        {
          paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.setVisibility(8);
          if (QLog.isColorLevel()) {
            QLog.d("ArkRecommendController", 2, "getAttachButton set ark list gone at point 1");
          }
        }
        paramContext = paramAttachAppHolder;
      } while (!QLog.isColorLevel());
      QLog.d("ArkRecommendController", 2, "getAttachButton return holder direct");
      return paramAttachAppHolder;
    }
    paramBaseChatItemLayout.clearAnimation();
    boolean bool = paramChatMessage.isSend();
    RecommendCommonMessage localRecommendCommonMessage = (RecommendCommonMessage)paramChatMessage;
    ArkRecommendController.AttachAppHolder localAttachAppHolder = paramAttachAppHolder;
    if (paramAttachAppHolder == null) {
      localAttachAppHolder = new ArkRecommendController.AttachAppHolder();
    }
    Object localObject1;
    int m;
    Object localObject2;
    int n;
    label311:
    label335:
    Object localObject3;
    Object localObject4;
    if (localAttachAppHolder.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      paramAttachAppHolder = new ImageView(paramContext);
      localAttachAppHolder.jdField_a_of_type_AndroidWidgetImageView = paramAttachAppHolder;
      paramAttachAppHolder.setImageDrawable(paramContext.getResources().getDrawable(2130838201));
      paramBaseChatItemLayout.addView(paramAttachAppHolder);
      a(localRecommendCommonMessage, localAttachAppHolder);
      localObject1 = paramContext.getResources();
      m = AIOUtils.a(24.0F, (Resources)localObject1);
      localObject2 = new RelativeLayout.LayoutParams(m, m);
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131361877);
      n = paramView.getMeasuredHeight();
      if (n > 0) {
        break label837;
      }
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.a(16.0F, (Resources)localObject1);
      if (!localRecommendCommonMessage.isSend()) {
        break label852;
      }
      ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131361877);
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 0);
      paramAttachAppHolder.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localAttachAppHolder.jdField_a_of_type_Boolean = true;
      if (paramAttachAppHolder.getVisibility() == 0)
      {
        localObject1 = localRecommendCommonMessage.mOldAppInfo.appName;
        localObject2 = localRecommendCommonMessage.mOldAppInfo.appView;
        localObject3 = localRecommendCommonMessage.mOldAppInfo.keyword;
        if (localRecommendCommonMessage.mContextList.size() <= 0) {
          break label918;
        }
        localObject4 = (RecommendCommonMessage.ArkContextInfo)localRecommendCommonMessage.mContextList.get(0);
        if ((localObject4 == null) || (((RecommendCommonMessage.ArkContextInfo)localObject4).contextAppInfoList.size() <= 0)) {
          break label918;
        }
        localObject4 = (RecommendCommonMessage.ArkMsgAppInfo)((RecommendCommonMessage.ArkContextInfo)localObject4).contextAppInfoList.get(0);
        if (localObject4 == null) {
          break label918;
        }
        localObject1 = ((RecommendCommonMessage.ArkMsgAppInfo)localObject4).appName;
        localObject2 = ((RecommendCommonMessage.ArkMsgAppInfo)localObject4).appView;
        localObject3 = ((RecommendCommonMessage.ArkMsgAppInfo)localObject4).keyword;
      }
    }
    label918:
    for (;;)
    {
      if (!localRecommendCommonMessage.mHasReportShowIconEach)
      {
        ArkAppDataReport.c(null, (String)localObject1, localRecommendCommonMessage.mEchoType, localRecommendCommonMessage.mContextMatchType, (String)localObject3);
        if (4 == localRecommendCommonMessage.mEchoType) {
          ArkAppDataReport.c(null, (String)localObject1, 0, localRecommendCommonMessage.mContextMatchType, (String)localObject3);
        }
        localObject3 = (ArkAppHandler)paramQQAppInterface.a(95);
        if (localRecommendCommonMessage.isFromArkServer)
        {
          m = 2;
          label538:
          localObject4 = localRecommendCommonMessage.arkServerExtraInfo;
          String str1 = localRecommendCommonMessage.arkServerMsgId;
          String str2 = localRecommendCommonMessage.msg;
          if (!"1".equals(localRecommendCommonMessage.getExtInfoFromExtStr("ark_text_analysis_flag"))) {
            break label878;
          }
          n = 1;
          label579:
          ((ArkAppHandler)localObject3).a(m, 2, 1, (String)localObject4, str1, (String)localObject1, (String)localObject2, str2, n, 0);
          localRecommendCommonMessage.mHasReportShowIconEach = true;
        }
      }
      else
      {
        if ((localAttachAppHolder.jdField_a_of_type_AndroidViewView != null) && (!((RecommendCommonMessage)paramChatMessage).mIsShow)) {
          localAttachAppHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
        if ((localAttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView != null) && (!((RecommendCommonMessage)paramChatMessage).mIsShow))
        {
          localAttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.setVisibility(8);
          if (QLog.isColorLevel()) {
            QLog.d("ArkRecommendController", 2, "getAttachButton set ark list gone at point 2");
          }
        }
        paramAttachAppHolder.setFocusable(true);
        paramAttachAppHolder.setFocusableInTouchMode(true);
        if (AppSetting.jdField_b_of_type_Boolean)
        {
          if (!localRecommendCommonMessage.mIsShow) {
            break label884;
          }
          paramAttachAppHolder.setContentDescription("点击收拢");
        }
      }
      for (;;)
      {
        paramAttachAppHolder.setOnTouchListener(new aaxc(this, paramAttachAppHolder, localRecommendCommonMessage, paramContext, paramView, localAttachAppHolder, paramBaseChatItemLayout, paramSessionInfo, paramQQAppInterface, paramOnLongClickAndTouchListener, bool, paramChatMessage));
        if (QLog.isColorLevel()) {
          QLog.d("ArkRecommendController", 2, "getAttachButton msg.mIsShow after=" + localRecommendCommonMessage.mIsShow);
        }
        if (!localRecommendCommonMessage.mIsShow) {
          break label895;
        }
        a(localRecommendCommonMessage, localAttachAppHolder);
        localAttachAppHolder.jdField_a_of_type_Boolean = false;
        return a(paramContext, paramSessionInfo, paramQQAppInterface, localRecommendCommonMessage, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener, localAttachAppHolder, bool, false, -1);
        paramAttachAppHolder = localAttachAppHolder.jdField_a_of_type_AndroidWidgetImageView;
        break;
        label837:
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((n - m) / 2);
        break label311;
        label852:
        ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131361877);
        ((RelativeLayout.LayoutParams)localObject2).addRule(0, 0);
        break label335;
        m = 100;
        break label538;
        label878:
        n = 0;
        break label579;
        label884:
        paramAttachAppHolder.setContentDescription("点击展开");
      }
      label895:
      paramContext = localAttachAppHolder;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(localRecommendCommonMessage, 1);
      return localAttachAppHolder;
    }
  }
  
  protected ArkRecommendController.AttachAppHolder a(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, RecommendCommonMessage paramRecommendCommonMessage, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, ArkRecommendController.AttachAppHolder paramAttachAppHolder, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i3 = paramRecommendCommonMessage.mContextList.size();
    Object localObject1;
    label218:
    int m;
    if (i3 > 0)
    {
      paramView = paramContext.getResources();
      paramQQAppInterface = new RelativeLayout.LayoutParams(-1, -2);
      paramQQAppInterface.addRule(3, 2131361877);
      paramQQAppInterface.width = -1;
      paramQQAppInterface.height = (BaseChatItemLayout.d + AIOUtils.a(70.0F, paramView));
      paramQQAppInterface.leftMargin = 0;
      paramBaseChatItemLayout.setPadding(0, BaseChatItemLayout.u, 0, BaseChatItemLayout.h + BaseChatItemLayout.k);
      localObject1 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getLayoutParams();
      if (paramBoolean1)
      {
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = BaseChatItemLayout.n;
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
        {
          localObject1 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = BaseChatItemLayout.s;
          paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if ((paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null) && (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() != 8))
        {
          localObject1 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
          if (!paramBoolean1) {
            break label619;
          }
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = BaseChatItemLayout.t;
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        i4 = BaseChatItemLayout.n * 2 + AIOUtils.a(40.0F, paramView) + paramView.getDimensionPixelSize(2131558619);
        i5 = paramView.getDimensionPixelSize(2131558622);
        n = BaseChatItemLayout.jdField_c_of_type_Int - i4 - BaseChatItemLayout.d - i5;
        if (!paramBoolean1) {
          break label671;
        }
        m = n;
        label287:
        if (!paramBoolean1) {
          break label681;
        }
        n = i4 - i5;
        label299:
        if (paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView != null) {
          break label684;
        }
        paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView = new ArkHorizontalListView(paramContext);
        paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.d = (BaseChatItemLayout.jdField_c_of_type_Int / 4);
        paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.setDividerWidth(i5);
        paramContext = new ArkHorizontalListViewAdapter(paramContext, paramSessionInfo, paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView, paramOnLongClickAndTouchListener);
        paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.setAdapter(paramContext);
        paramBaseChatItemLayout.addView(paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView, paramQQAppInterface);
      }
      for (;;)
      {
        paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.setIsSend(paramBoolean1);
        paramContext.a(m, n);
        paramSessionInfo = new int[i3];
        n = 0;
        if (n >= i3) {
          break label1048;
        }
        paramQQAppInterface = (RecommendCommonMessage.ArkContextInfo)paramRecommendCommonMessage.mContextList.get(n);
        i1 = paramQQAppInterface.contextAppInfoList.size();
        if (QLog.isColorLevel()) {
          QLog.d("ArkRecommendController", 2, "getAttachArkView contextSize=" + i3 + ", contextIndex=" + n + ", keyword=" + paramQQAppInterface.keyword + ", contextAppInfoSize=" + i1);
        }
        if (i1 <= 0) {
          break label1009;
        }
        i6 = paramQQAppInterface.getArkCardSize();
        paramSessionInfo[n] = i6;
        i2 = 0;
        for (i1 = 0; i2 < n; i1 = i7 + i1)
        {
          i7 = paramSessionInfo[i2];
          i2 += 1;
        }
        if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
        {
          m = AIOUtils.a(30.0F, paramView);
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = (BaseChatItemLayout.s + m);
          paramQQAppInterface.leftMargin = (m - BaseChatItemLayout.s);
          break;
        }
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = BaseChatItemLayout.n;
        break;
        label619:
        if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
        {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = (AIOUtils.a(25.0F, paramView) + BaseChatItemLayout.s);
          break label218;
        }
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = BaseChatItemLayout.s;
        break label218;
        label671:
        m = i4 - i5;
        break label287;
        label681:
        break label299;
        label684:
        paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.setLayoutParams(paramQQAppInterface);
        paramContext = (ArkHorizontalListViewAdapter)paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.a();
      }
      if (n == i3 - 1)
      {
        paramContext.a(paramContext.a() - i1 - paramSessionInfo[n]);
        paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.setVisibility(0);
      }
      i2 = 0;
      if (i2 < i6)
      {
        paramView = paramQQAppInterface.getAppInfoByPosition(i2);
        paramBaseChatItemLayout = (ArkAdapterItemForTextMsg)paramContext.b(i1 + i2);
        if (paramBaseChatItemLayout == null)
        {
          paramBaseChatItemLayout = new ArkAdapterItemForTextMsg();
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo = paramView;
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage = paramRecommendCommonMessage;
          paramBaseChatItemLayout.jdField_a_of_type_Int = n;
          paramBaseChatItemLayout.jdField_b_of_type_Int = i2;
          paramContext.a(paramBaseChatItemLayout);
        }
        for (;;)
        {
          i2 += 1;
          break;
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo = paramView;
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage = paramRecommendCommonMessage;
          paramBaseChatItemLayout.jdField_a_of_type_Int = n;
          paramBaseChatItemLayout.jdField_b_of_type_Int = i2;
          paramContext.b(i1 + i2, paramBaseChatItemLayout);
        }
      }
      if ((n == i3 - 1) && (paramBoolean2))
      {
        i2 = 0;
        i1 = 0;
        while (i1 < paramInt)
        {
          i2 += paramSessionInfo[i1];
          i1 += 1;
        }
        if (paramBoolean1) {
          paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.setRestoreX((i2 + 1) * (BaseChatItemLayout.d + i5) + m - (BaseChatItemLayout.jdField_c_of_type_Int - i4));
        }
      }
      for (;;)
      {
        n += 1;
        break;
        paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.setRestoreX(i2 * (BaseChatItemLayout.d + i5) + i5 + m - i4);
        continue;
        if (paramInt == -2)
        {
          paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.setRestoreX(0);
          continue;
          label1009:
          RecommendCommonMessage.getAppInfosByContext(paramQQAppInterface, new aaxd(this, paramSessionInfo, n, i3, paramContext, paramAttachAppHolder, paramQQAppInterface, paramRecommendCommonMessage, paramBoolean2, paramInt, paramBoolean1, i5, m, i4));
        }
      }
      label1048:
      paramRecommendCommonMessage.mIsShow = true;
      paramRecommendCommonMessage.saveRecommendMsg(this.jdField_a_of_type_JavaLangRefWeakReference, this.h, false);
      if (paramAttachAppHolder.jdField_a_of_type_AndroidViewView != null) {
        paramAttachAppHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      if (paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView != null) {
        paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setVisibility(8);
      }
    }
    while (TextUtils.isEmpty(paramRecommendCommonMessage.mOldAppInfo.appName))
    {
      int i4;
      int i5;
      int n;
      int i1;
      int i6;
      int i2;
      int i7;
      return paramAttachAppHolder;
    }
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131361877);
    label1169:
    View localView;
    if (paramRecommendCommonMessage.isSend())
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131361877);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = BaseChatItemLayout.n;
      if (paramAttachAppHolder.jdField_a_of_type_AndroidViewView != null) {
        break label1595;
      }
      localView = LayoutInflater.from(paramContext).inflate(2130968741, null);
      paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)localView.findViewById(2131363312));
      paramQQAppInterface = paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
      localObject1 = paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
      paramQQAppInterface.setBorderType(3);
      paramQQAppInterface.setClipRadiusTop(4.0F);
      paramQQAppInterface.setClipRadius(14.0F);
      ((View)localObject1).setTag(paramAttachAppHolder);
      localView.setPadding(0, 0, 0, BaseChatItemLayout.h);
      localView.findViewById(2131363311).setPadding(0, 0, 0, 0);
      paramAttachAppHolder.jdField_a_of_type_AndroidViewView = localView;
      localView.setVisibility(8);
      paramBaseChatItemLayout.addView(localView, (ViewGroup.LayoutParams)localObject2);
    }
    for (;;)
    {
      ArkAioContainerWrapper localArkAioContainerWrapper = paramRecommendCommonMessage.mOldAppInfo.mArkContainer;
      localObject2 = localArkAioContainerWrapper;
      if (localArkAioContainerWrapper == null)
      {
        localObject2 = new ArkAioContainerWrapper();
        ((ArkAioContainerWrapper)localObject2).a = new ArkAppMessage.Config();
        ((ArkAioContainerWrapper)localObject2).a.autoSize = Integer.valueOf(1);
        paramRecommendCommonMessage.mOldAppInfo.mArkContainer = ((ArkAioContainerWrapper)localObject2);
      }
      ((ArkAioContainerWrapper)localObject2).a(paramRecommendCommonMessage.mOldAppInfo.appName, paramRecommendCommonMessage.mOldAppInfo.appView, paramRecommendCommonMessage.mOldAppInfo.appVer, paramRecommendCommonMessage.mOldAppInfo.meta, paramContext.getResources().getDisplayMetrics().scaledDensity, paramRecommendCommonMessage, paramSessionInfo);
      paramInt = BaseChatItemLayout.d - BaseChatItemLayout.n - BaseChatItemLayout.o;
      m = AIOUtils.a(163.0F, paramView.getResources());
      ((ArkAioContainerWrapper)localObject2).setFixSize(paramInt, -1);
      ((ArkAioContainerWrapper)localObject2).setHintSize(paramInt, m);
      ((ArkAioContainerWrapper)localObject2).a(paramInt, m);
      paramContext = new aaxe(this, paramBoolean2, (View)localObject1, paramBaseChatItemLayout, localView);
      paramQQAppInterface.initArkView(paramRecommendCommonMessage.mOldAppInfo.mArkContainer);
      paramQQAppInterface.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramQQAppInterface.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramQQAppInterface.setLoadCallback(paramContext);
      paramRecommendCommonMessage.mIsShow = true;
      paramRecommendCommonMessage.saveRecommendMsg(this.jdField_a_of_type_JavaLangRefWeakReference, this.h, false);
      if (paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView == null) {
        break;
      }
      paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.setVisibility(8);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ArkRecommendController", 2, "getAttachArkView set ark list gone as old version");
      return paramAttachAppHolder;
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131361877);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = BaseChatItemLayout.n;
      break label1169;
      label1595:
      paramQQAppInterface = paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
      localObject1 = paramAttachAppHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
      localView = paramAttachAppHolder.jdField_a_of_type_AndroidViewView;
      localView.setVisibility(8);
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
  }
  
  public ArrayList a(LinkedHashMap paramLinkedHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      SemanticItem localSemanticItem = new SemanticItem();
      localSemanticItem.key = str;
      localSemanticItem.value = ((String)paramLinkedHashMap.get(str));
      localArrayList.add(localSemanticItem);
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar.e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel != null)
    {
      if ((paramInt2 == 22) || (paramInt1 != 22)) {
        break label41;
      }
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel.a();
    }
    label41:
    while ((paramInt2 != 22) || (paramInt1 == 22)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel.b();
  }
  
  public void a(int paramInt, String paramString1, ChatMessage paramChatMessage, String paramString2)
  {
    if ((paramChatMessage == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || (TextUtils.isEmpty(paramString1)) || (ArkAiAppCenter.f) || (paramInt <= 0) || ((paramInt == 4) && (TextUtils.isEmpty(paramString2)))) {
      if (QLog.isColorLevel()) {
        QLog.d("ArkRecommendController", 2, "showArkAtBabyQGrayTip param is invalid or disable");
      }
    }
    String str1;
    String str2;
    String str3;
    int m;
    String str4;
    int n;
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
              do
              {
                return;
                if (!"1".equals(paramChatMessage.getExtInfoFromExtStr(MessageConstants.f))) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("ArkRecommendController", 2, "showArkAtBabyQGrayTip this message has show ark babyq gray tip and return");
              return;
              str1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
              str2 = jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(System.currentTimeMillis()));
              str3 = jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(SharedPreUtils.a(BaseApplicationImpl.getApplication(), str1, 0)));
              m = SharedPreUtils.c(BaseApplicationImpl.getApplication(), str1, 0);
              if ((!str2.equals(str3)) || (m < k)) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("ArkRecommendController", 2, "showArkAtBabyQGrayTip today has been total limit count=" + m);
            return;
            str4 = jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(SharedPreUtils.a(BaseApplicationImpl.getApplication(), str1, paramInt)));
            n = SharedPreUtils.c(BaseApplicationImpl.getApplication(), str1, paramInt);
            localUniteGrayTipParam = null;
            if (paramInt != 4) {
              break label732;
            }
            if ((jdField_b_of_type_JavaUtilHashMap != null) && (jdField_b_of_type_JavaUtilHashMap.size() > 0)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("ArkRecommendController", 2, "showArkAtBabyQGrayTip type4 config is null");
          return;
          if ((jdField_b_of_type_JavaUtilHashMap.containsKey(paramString2)) && (jdField_b_of_type_JavaUtilHashMap.get(paramString2) != null)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ArkRecommendController", 2, "showArkAtBabyQGrayTip type4 config not contain keyword = " + paramString2);
        return;
        paramString2 = (ArkRecommendController.ArkAtBabyqGrayTipConfig)jdField_b_of_type_JavaUtilHashMap.get(paramString2);
        if (!TextUtils.isEmpty(paramString2.jdField_a_of_type_JavaLangString)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ArkRecommendController", 2, "showArkAtBabyQGrayTip type4 config tip text is null");
      return;
      if ((!str2.equals(str4)) || (n < paramString2.jdField_b_of_type_Int)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ArkRecommendController", 2, "showArkAtBabyQGrayTip type4 has been limit count=" + n);
    return;
    paramString2 = paramString2.jdField_a_of_type_JavaLangString;
    label450:
    UniteGrayTipParam localUniteGrayTipParam = new UniteGrayTipParam(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str1, paramString2, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5020, 2555907, MessageCache.a());
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_action", 23);
    ((Bundle)localObject).putString("textColor", "#12B7F5");
    ((Bundle)localObject).putString("key_action_DATA", paramString1);
    ((Bundle)localObject).putString("key_a_action_DATA", String.valueOf(paramInt));
    int i1 = paramString2.indexOf("@babyQ");
    localUniteGrayTipParam.a(i1, "@babyQ".length() + i1, (Bundle)localObject);
    localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localUniteGrayTipParam);
    UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject);
    SharedPreUtils.a(BaseApplicationImpl.getApplication(), str1, 0, System.currentTimeMillis());
    SharedPreUtils.a(BaseApplicationImpl.getApplication(), str1, paramInt, System.currentTimeMillis());
    if (str2.equals(str3))
    {
      SharedPreUtils.e(BaseApplicationImpl.getApplication(), str1, 0, m + 1);
      label653:
      if (!str2.equals(str4)) {
        break label949;
      }
      SharedPreUtils.e(BaseApplicationImpl.getApplication(), str1, paramInt, n + 1);
    }
    for (;;)
    {
      paramChatMessage.saveExtInfoToExtStr(MessageConstants.f, "1");
      ArkAppDataReport.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramInt);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ArkRecommendController", 2, "showArkAtBabyQGrayTip success tip=" + paramString2);
      return;
      label732:
      paramString2 = localUniteGrayTipParam;
      if (paramInt <= 0) {
        break label450;
      }
      if ((jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_JavaUtilHashMap.size() <= 0))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ArkRecommendController", 2, "showArkAtBabyQGrayTip config is null");
        return;
      }
      if ((!jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) || (jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)) == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ArkRecommendController", 2, "showArkAtBabyQGrayTip config not contain type = " + paramInt);
        return;
      }
      paramString2 = (ArkRecommendController.ArkAtBabyqGrayTipConfig)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      if (TextUtils.isEmpty(paramString2.jdField_a_of_type_JavaLangString))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ArkRecommendController", 2, "showArkAtBabyQGrayTip config tip text is null");
        return;
      }
      if ((str2.equals(str4)) && (n >= paramString2.jdField_b_of_type_Int))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ArkRecommendController", 2, "showArkAtBabyQGrayTip has been limit count=" + n);
        return;
      }
      paramString2 = paramString2.jdField_a_of_type_JavaLangString;
      break label450;
      SharedPreUtils.e(BaseApplicationImpl.getApplication(), str1, 0, 1);
      break label653;
      label949:
      SharedPreUtils.e(BaseApplicationImpl.getApplication(), str1, paramInt, 1);
    }
  }
  
  public void a(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, RecommendCommonMessage paramRecommendCommonMessage, ArkRecommendController.AttachAppHolder paramAttachAppHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, int paramInt)
  {
    if (NetworkUtil.g(paramContext))
    {
      int m = View.MeasureSpec.makeMeasureSpec(0, 0);
      paramView.measure(m, m);
      paramAttachAppHolder.jdField_a_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("ArkRecommendController", 2, "attchArkViewByHighLight click ark underline");
      }
      a(paramContext, paramSessionInfo, paramQQAppInterface, paramRecommendCommonMessage, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener, paramAttachAppHolder, paramRecommendCommonMessage.isSend(), paramInt);
      return;
    }
    ChatActivityUtils.a(paramContext, 2131434811, 1);
  }
  
  public void a(ArkMessageServerLogic.SearchArkBabyQInfo paramSearchArkBabyQInfo, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext == null) || (paramSessionInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkRecommendController", 2, "onFinishedBabyQTextAnalysis param is invalid");
      }
      return;
    }
    MessageForArkBabyqReply localMessageForArkBabyqReply = new MessageForArkBabyqReply();
    if ((paramSearchArkBabyQInfo == null) || (paramSearchArkBabyQInfo.jdField_a_of_type_JavaUtilArrayList == null) || (paramSearchArkBabyQInfo.jdField_a_of_type_JavaUtilArrayList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkRecommendController", 2, "onFinishedBabyQTextAnalysis invalid SearchArkBabyQInfo=" + paramSearchArkBabyQInfo);
      }
      localMessageForArkBabyqReply.mArkBabyqReplyCardList = null;
      if (paramBoolean)
      {
        localMessageForArkBabyqReply.babyqReplyText = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131438834);
        localMessageForArkBabyqReply.isFailed = paramBoolean;
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo, localMessageForArkBabyqReply, true, true);
        return;
      }
      if (TextUtils.isEmpty(jdField_c_of_type_JavaLangString)) {}
      for (paramSearchArkBabyQInfo = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131438832);; paramSearchArkBabyQInfo = jdField_c_of_type_JavaLangString)
      {
        localMessageForArkBabyqReply.babyqReplyText = paramSearchArkBabyQInfo;
        break;
      }
    }
    localMessageForArkBabyqReply.babyqReplyText = paramSearchArkBabyQInfo.jdField_b_of_type_JavaLangString;
    localMessageForArkBabyqReply.arkSearchType = paramSearchArkBabyQInfo.jdField_a_of_type_Int;
    localMessageForArkBabyqReply.arkMsgId = paramSearchArkBabyQInfo.jdField_a_of_type_JavaLangString;
    localMessageForArkBabyqReply.mArkBabyqReplyCardList = new ArrayList();
    Iterator localIterator = paramSearchArkBabyQInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      paramSearchArkBabyQInfo = (ArkAiInfo)localIterator.next();
      ArkBabyqCardInfo localArkBabyqCardInfo = new ArkBabyqCardInfo(localMessageForArkBabyqReply);
      localArkBabyqCardInfo.appName = paramSearchArkBabyQInfo.jdField_a_of_type_JavaLangString;
      localArkBabyqCardInfo.appView = paramSearchArkBabyQInfo.jdField_b_of_type_JavaLangString;
      localArkBabyqCardInfo.appMinVersion = paramSearchArkBabyQInfo.jdField_c_of_type_JavaLangString;
      localArkBabyqCardInfo.metaList = paramSearchArkBabyQInfo.f;
      localArkBabyqCardInfo.extra = paramSearchArkBabyQInfo.i;
      try
      {
        paramSearchArkBabyQInfo = new JSONObject();
      }
      catch (JSONException paramSearchArkBabyQInfo)
      {
        try
        {
          paramSearchArkBabyQInfo.put("forward", 1);
          paramSearchArkBabyQInfo.put("autosize", 1);
          paramSearchArkBabyQInfo.put("type", "card");
          for (;;)
          {
            label361:
            localArkBabyqCardInfo.config = paramSearchArkBabyQInfo.toString();
            localMessageForArkBabyqReply.mArkBabyqReplyCardList.add(localArkBabyqCardInfo);
            break;
            paramSearchArkBabyQInfo = paramSearchArkBabyQInfo;
            paramSearchArkBabyQInfo = null;
          }
        }
        catch (JSONException localJSONException)
        {
          break label361;
        }
      }
    }
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if ((!ArkAiAppCenter.c) || (ArkAiAppCenter.d) || ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendLogic == null)) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (ArkAiAppCenter.jdField_a_of_type_Int != 1)) {}
    label40:
    Object localObject1;
    do
    {
      do
      {
        do
        {
          break label40;
          do
          {
            return;
          } while ((paramChatMessage.msg == null) || (paramChatMessage.msg.length() > 80));
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
          this.h = ((SessionInfo)localObject1).jdField_a_of_type_Int;
          localObject2 = ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString;
        } while (((!TextUtils.isEmpty(paramChatMessage.frienduin)) && (!paramChatMessage.frienduin.equals(localObject2))) || (!(paramChatMessage instanceof RecommendCommonMessage)));
        localObject1 = (RecommendCommonMessage)paramChatMessage;
        if (paramChatMessage.isFlowMessage)
        {
          ((RecommendCommonMessage)localObject1).mIsMsgParsedByAi = true;
          ((RecommendCommonMessage)localObject1).saveRecommendMsg(this.jdField_a_of_type_JavaLangRefWeakReference, this.h, true);
          return;
        }
      } while ((((RecommendCommonMessage)localObject1).isArkAtBabyQMsg()) || (paramChatMessage.msg.startsWith("@babyQ")) || (TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("ark_text_analysis_flag"))));
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject2, this.h, false);
      int m = ((List)localObject2).size() - 1;
      while (m > 0)
      {
        ChatMessage localChatMessage = (ChatMessage)((List)localObject2).get(m);
        if (paramChatMessage.uniseq == localChatMessage.uniseq)
        {
          localObject2 = (ChatMessage)((List)localObject2).get(m - 1);
          if ((localObject2 == null) || (!paramChatMessage.msg.equals(((ChatMessage)localObject2).msg))) {
            break;
          }
          ((RecommendCommonMessage)localObject1).mIsMsgParsedByAi = true;
          ((RecommendCommonMessage)localObject1).saveRecommendMsg(this.jdField_a_of_type_JavaLangRefWeakReference, this.h, true);
          return;
        }
        m -= 1;
      }
      ((RecommendCommonMessage)localObject1).parse();
    } while (((RecommendCommonMessage)localObject1).mIsMsgParsedByAi);
    ((RecommendCommonMessage)localObject1).mIsMsgParsedByAi = true;
    ((RecommendCommonMessage)localObject1).saveRecommendMsg(this.jdField_a_of_type_JavaLangRefWeakReference, this.h, true);
    j();
    ArkRecommendLogic.a().post(new aaxj(this, (RecommendCommonMessage)localObject1));
  }
  
  public void a(ChatMessage paramChatMessage, SessionInfo paramSessionInfo)
  {
    if ((ArkAiAppCenter.f) || ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendLogic == null)) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (paramSessionInfo == null)) {}
    label31:
    RecommendCommonMessage localRecommendCommonMessage;
    do
    {
      do
      {
        do
        {
          break label31;
          do
          {
            return;
          } while ((paramChatMessage.msg == null) || (paramChatMessage.msg.length() > 80) || (!(paramChatMessage instanceof RecommendCommonMessage)));
          localRecommendCommonMessage = (RecommendCommonMessage)paramChatMessage;
        } while ((!localRecommendCommonMessage.isArkAtBabyQMsg()) && (!paramChatMessage.msg.startsWith("@babyQ")));
        if (QLog.isColorLevel()) {
          QLog.d("ArkRecommendController", 2, "analyseAtBabyQMessage content=" + Utils.a(paramChatMessage.msg) + ", extraflag=" + paramChatMessage.extraflag);
        }
      } while ((!paramChatMessage.isSend()) || (paramChatMessage.extraflag == 32768) || (paramChatMessage.extraflag == 32772));
      localRecommendCommonMessage.parse();
    } while (localRecommendCommonMessage.mIsMsgParsedByAi);
    this.h = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    localRecommendCommonMessage.mIsMsgParsedByAi = true;
    localRecommendCommonMessage.saveRecommendMsg(this.jdField_a_of_type_JavaLangRefWeakReference, this.h, true);
    j();
    ArkRecommendLogic.a().post(new aaxk(this, paramChatMessage, paramSessionInfo));
  }
  
  public void a(RecommendCommonMessage paramRecommendCommonMessage, ArkAiInfo paramArkAiInfo, RecommendCommonMessage.ArkContextInfo paramArkContextInfo, String paramString)
  {
    if ((ArkAiAppCenter.jdField_a_of_type_Int == 1) && ("0".equals(paramRecommendCommonMessage.getExtInfoFromExtStr("ark_text_analysis_flag"))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkRecommendController", 2, "onFinishedAnalysis and trigger ark server passive search.");
      }
      a(paramRecommendCommonMessage);
      return;
    }
    ArkAppCenter.a().postToMainThread(new aaxn(this, paramRecommendCommonMessage, paramArkContextInfo, paramArkAiInfo, paramString));
  }
  
  public void a(RecommendCommonMessage paramRecommendCommonMessage, ArkMessageServerLogic.ArkPassiveSearchInfo paramArkPassiveSearchInfo)
  {
    if ((paramArkPassiveSearchInfo == null) || (paramArkPassiveSearchInfo.jdField_a_of_type_JavaUtilArrayList == null) || (paramArkPassiveSearchInfo.jdField_a_of_type_JavaUtilArrayList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkRecommendController", 2, "onFinishedPassiveSearch invalid result.");
      }
      return;
    }
    Iterator localIterator = paramArkPassiveSearchInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
    if (localIterator.hasNext())
    {
      ArkAiInfo localArkAiInfo = (ArkAiInfo)localIterator.next();
      RecommendCommonMessage.ArkContextInfo localArkContextInfo = new RecommendCommonMessage.ArkContextInfo();
      localArkContextInfo.context = localArkAiInfo.h;
      localArkContextInfo.semantic = localArkAiInfo.jdField_a_of_type_JavaUtilLinkedHashMap;
      if (TextUtils.isEmpty(paramRecommendCommonMessage.arkServerExtraInfo)) {
        paramRecommendCommonMessage.arkServerExtraInfo = localArkAiInfo.i;
      }
      Object localObject1;
      int n;
      int m;
      if (!TextUtils.isEmpty(localArkAiInfo.e))
      {
        localObject1 = localArkAiInfo.e.split("\\|");
        n = localObject1.length;
        m = 0;
      }
      for (;;)
      {
        Object localObject2;
        if (m < n)
        {
          localObject2 = localObject1[m];
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).length() > 2))
          {
            localObject2 = ((String)localObject2).substring(1, ((String)localObject2).length() - 1);
            localObject2 = (String)localArkAiInfo.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject2);
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              localArkContextInfo.keyword = ((String)localObject2);
            }
          }
        }
        else
        {
          if (TextUtils.isEmpty(localArkContextInfo.keyword))
          {
            localObject1 = localArkAiInfo.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (String)((Iterator)localObject1).next();
              localObject2 = (String)localArkAiInfo.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject2);
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                localArkContextInfo.keyword = ((String)localObject2);
              }
            }
          }
          paramRecommendCommonMessage.mContextList.add(localArkContextInfo);
          break;
        }
        m += 1;
      }
    }
    paramRecommendCommonMessage.isFromArkServer = true;
    paramRecommendCommonMessage.arkServerMsgId = paramArkPassiveSearchInfo.jdField_a_of_type_JavaLangString;
    paramRecommendCommonMessage.saveRecommendMsg(this.jdField_a_of_type_JavaLangRefWeakReference, this.h, false);
    if (QLog.isColorLevel()) {
      QLog.d("ArkRecommendController", 2, "onFinishedPassiveSearch msg hasAiData=" + paramRecommendCommonMessage.hasAiData());
    }
    ArkAppCenter.a().postToMainThread(new aaxp(this, paramRecommendCommonMessage));
  }
  
  protected void a(RecommendCommonMessage paramRecommendCommonMessage, ArkRecommendController.AttachAppHolder paramAttachAppHolder)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilSet.add(paramAttachAppHolder);
      paramAttachAppHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramAttachAppHolder = new aaxs(paramRecommendCommonMessage, paramAttachAppHolder, this.jdField_a_of_type_JavaLangRefWeakReference, this.h);
      if (!TextUtils.isEmpty(paramRecommendCommonMessage.mIconAppPath)) {
        break;
      }
      if (paramRecommendCommonMessage.mContextList.size() > 0)
      {
        RecommendCommonMessage.getAppInfosByContextList(paramRecommendCommonMessage.mContextList, paramAttachAppHolder);
        return;
      }
    } while (TextUtils.isEmpty(paramRecommendCommonMessage.mOldAppInfo.appName));
    if (TextUtils.isEmpty(paramRecommendCommonMessage.mOldAppInfo.appPath))
    {
      ((ArkAppCenter)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(120)).a().a(paramRecommendCommonMessage.mOldAppInfo.appName, paramRecommendCommonMessage.mOldAppInfo.appVer, paramAttachAppHolder);
      return;
    }
    paramAttachAppHolder.a(paramRecommendCommonMessage.mOldAppInfo.appPath);
    return;
    paramAttachAppHolder.a(paramRecommendCommonMessage.mIconAppPath);
  }
  
  public void a(QQCustomDialog paramQQCustomDialog, Context paramContext1, List paramList, int paramInt1, ArkAiAppPanel paramArkAiAppPanel, boolean paramBoolean1, boolean paramBoolean2, Context paramContext2, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, RecommendCommonMessage paramRecommendCommonMessage, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, ArkRecommendController.AttachAppHolder paramAttachAppHolder, boolean paramBoolean3, int paramInt2)
  {
    paramQQCustomDialog.setContentView(2130968842);
    ((TextView)paramQQCustomDialog.findViewById(2131364034)).setText(BaseActivity.sTopActivity.getString(2131438813));
    a(paramQQCustomDialog, true);
    paramQQCustomDialog.setCanceledOnTouchOutside(false);
    if ((paramQQAppInterface == null) && (QLog.isColorLevel())) {
      QLog.d("ArkDialog", 2, "appinterface is Empty");
    }
    paramQQCustomDialog.setNegativeButton(2131438812, new aaxq(this, paramQQCustomDialog, paramQQAppInterface, paramContext1));
    paramQQCustomDialog.setPositiveButton(2131438811, new aaxr(this, paramQQCustomDialog, paramBoolean1, paramArkAiAppPanel, paramList, paramInt1, paramBoolean2, paramContext2, paramSessionInfo, paramQQAppInterface, paramRecommendCommonMessage, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener, paramAttachAppHolder, paramBoolean3, paramInt2, paramContext1));
    try
    {
      paramQQCustomDialog.show();
      ArkAppReportController.a(paramQQAppInterface, "", "__global__", "ArkAlertDialogShow", 0L, 0L, 0L, 0L, 0L, "", "");
      return;
    }
    catch (Exception paramQQCustomDialog)
    {
      ArkAppCenter.b("ArkDialog", String.format("Dialog show failed, err=%s", new Object[] { paramQQCustomDialog.getMessage() }));
      a(paramBoolean1, paramArkAiAppPanel, paramList, paramInt1, paramBoolean2, paramContext2, paramSessionInfo, paramQQAppInterface, paramRecommendCommonMessage, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener, paramAttachAppHolder, paramBoolean3, paramInt2);
      a(paramContext1, "error", paramQQAppInterface);
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if ((!ArkAiAppCenter.c) || (ArkAiAppCenter.e) || ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendLogic == null)) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null)) {}
    while ((paramCharSequence == null) || (paramCharSequence.length() > 80) || ((a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (paramCharSequence.toString().startsWith("@babyQ")))) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ArkAppCenter.a().removeTaskInMainThread(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = new aaxl(this);
    ArkAppCenter.a().postToMainThreadDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  public void a(String paramString, LinkedHashMap paramLinkedHashMap, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkRecommendController", 2, "onFinishedInstantTextAnalysis.appInfos.invalid!!");
      }
      return;
    }
    ArrayList localArrayList = paramArrayList;
    if (paramArrayList.size() > e) {
      localArrayList = new ArrayList(paramArrayList.subList(0, e));
    }
    b(paramString, paramLinkedHashMap, localArrayList);
    a((ArkAiInfo)localArrayList.get(0));
  }
  
  public void a(List paramList)
  {
    if ((!ArkAiAppCenter.c) || (ArkAiAppCenter.d) || ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendLogic == null)) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    this.h = ((SessionInfo)localObject).jdField_a_of_type_Int;
    localObject = ((SessionInfo)localObject).jdField_a_of_type_JavaLangString;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    paramList = null;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        if ((localChatMessage.msg != null) && (localChatMessage.msg.length() <= 80) && (!localChatMessage.isFlowMessage)) {
          if (localChatMessage.msg.equals(paramList))
          {
            paramList = localChatMessage.msg;
          }
          else
          {
            paramList = localChatMessage.msg;
            if (((TextUtils.isEmpty(localChatMessage.frienduin)) || (localChatMessage.frienduin.equals(localObject))) && ((localChatMessage instanceof RecommendCommonMessage)))
            {
              RecommendCommonMessage localRecommendCommonMessage = (RecommendCommonMessage)localChatMessage;
              if (!localRecommendCommonMessage.isArkAtBabyQMsg()) {
                if ((!localChatMessage.msg.startsWith("@babyQ")) && ((ArkAiAppCenter.jdField_a_of_type_Int != 1) || ("0".equals(localChatMessage.getExtInfoFromExtStr("ark_text_analysis_flag")))))
                {
                  localRecommendCommonMessage.parse();
                  if (!localRecommendCommonMessage.mIsMsgParsedByAi)
                  {
                    localArrayList.add(localRecommendCommonMessage);
                    if (ArkAiAppCenter.jdField_a_of_type_Int == 0)
                    {
                      localRecommendCommonMessage.mIsMsgParsedByAi = true;
                      localRecommendCommonMessage.saveRecommendMsg(this.jdField_a_of_type_JavaLangRefWeakReference, this.h, true);
                    }
                  }
                }
              }
            }
          }
        }
      }
      else
      {
        if (localArrayList.size() <= 0) {
          break;
        }
        j();
        ArkRecommendLogic.a().post(new aaxi(this, localArrayList));
        return;
      }
    }
  }
  
  public void a(List paramList, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkRecommendController", 2, "showAppPanel.mChatPie is null");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel == null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel = new ArkAiAppPanel(a());
    }
    if (ArkAiAppCenter.l)
    {
      a(paramList, paramInt, true, false, null, null, (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null, null, null, null, null, false, -2);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel.a(paramList, paramInt, null);
  }
  
  public void a(List paramList, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, RecommendCommonMessage paramRecommendCommonMessage, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, ArkRecommendController.AttachAppHolder paramAttachAppHolder, boolean paramBoolean3, int paramInt2)
  {
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    if ((paramQQAppInterface == null) && (QLog.isColorLevel())) {
      QLog.d("ArkDialog", 2, "appinterface is Empty");
    }
    if (TextUtils.isEmpty(a(localBaseActivity, paramQQAppInterface)))
    {
      if (BaseActivity.sTopActivity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = new QQCustomDialog(BaseActivity.sTopActivity, 2131624516);
        a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog, localBaseActivity, paramList, paramInt1, this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel, paramBoolean1, paramBoolean2, paramContext, paramSessionInfo, paramQQAppInterface, paramRecommendCommonMessage, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener, paramAttachAppHolder, paramBoolean3, paramInt2);
      }
      return;
    }
    a(paramBoolean1, this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel, paramList, paramInt1, paramBoolean2, paramContext, paramSessionInfo, paramQQAppInterface, paramRecommendCommonMessage, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener, paramAttachAppHolder, paramBoolean3, paramInt2);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar != null) && (this.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar.c());
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      ArkRecommendController.AttachAppHolder localAttachAppHolder = (ArkRecommendController.AttachAppHolder)localIterator.next();
      switch (localAttachAppHolder.jdField_a_of_type_Int)
      {
      default: 
        break;
      case 1: 
        localAttachAppHolder.jdField_a_of_type_Int = 3;
        break;
      case 2: 
        localAttachAppHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localAttachAppHolder.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130838201));
        ArkAppCenter.a(localAttachAppHolder.jdField_a_of_type_JavaLangString);
        localAttachAppHolder.jdField_a_of_type_JavaLangString = null;
      }
    }
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_JavaUtilSet = null;
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel.c();
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar.d();
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar = null;
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ArkAppCenter.a().removeTaskInMainThread(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
  }
  
  public void b(CharSequence paramCharSequence)
  {
    int m = 0;
    if ((ArkAiAppCenter.f) || (paramCharSequence == null) || (paramCharSequence.length() <= 0)) {
      break label21;
    }
    label21:
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (!a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
      return;
    }
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    if ((paramCharSequence.charAt(0) == '@') || (paramCharSequence.charAt(0) == 65312))
    {
      if (paramCharSequence.length() == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.post(this.jdField_b_of_type_JavaLangRunnable);
        ArkAppDataReport.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      for (;;)
      {
        if (!paramCharSequence.toString().equals("@babyQ" + jdField_b_of_type_JavaLangString)) {
          a(paramCharSequence, paramCharSequence.toString().startsWith("@babyQ"));
        }
        if (paramCharSequence.length() >= "@babyQ".length()) {
          break;
        }
        paramCharSequence = (ArkAtBabyQSpan[])localEditable.getSpans(0, paramCharSequence.length(), ArkAtBabyQSpan.class);
        if ((paramCharSequence == null) || (paramCharSequence.length <= 0)) {
          break;
        }
        while (m < paramCharSequence.length)
        {
          localEditable.removeSpan(paramCharSequence[m]);
          m += 1;
        }
        break label21;
        if ("@babyQ".equalsIgnoreCase(paramCharSequence.toString()))
        {
          h();
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.post(this.jdField_c_of_type_JavaLangRunnable);
          ArkAppDataReport.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        else if ((paramCharSequence.length() < "@babyQ".length()) && (!"@babyQ".startsWith(paramCharSequence.toString().toLowerCase())))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.postDelayed(this.jdField_c_of_type_JavaLangRunnable, jdField_a_of_type_Long);
        }
      }
    }
    ArkAtBabyQSpan[] arrayOfArkAtBabyQSpan = (ArkAtBabyQSpan[])localEditable.getSpans(0, paramCharSequence.length(), ArkAtBabyQSpan.class);
    if ((arrayOfArkAtBabyQSpan != null) && (arrayOfArkAtBabyQSpan.length > 0))
    {
      m = 0;
      while (m < arrayOfArkAtBabyQSpan.length)
      {
        localEditable.removeSpan(arrayOfArkAtBabyQSpan[m]);
        m += 1;
      }
    }
    a(paramCharSequence, false);
  }
  
  public void c()
  {
    ArkAppCenter.b("ArkRecommendController", "showRecommendBar");
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar.b();
    }
  }
  
  public void d()
  {
    ArkAppCenter.b("ArkRecommendController", "dismissRecommendBar");
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar.a();
    }
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendLogic.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar.c();
    }
  }
  
  public void f()
  {
    int m = 0;
    long l;
    String str;
    int i1;
    int i2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!ArkAiAppCenter.f) && (a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)))
    {
      l = System.currentTimeMillis();
      str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      i1 = SharedPreUtils.as(BaseApplicationImpl.getApplication(), str);
      i2 = SharedPreUtils.ar(BaseApplicationImpl.getApplication(), str);
      if ((i1 < j) || (i2 < i)) {
        break label105;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArkRecommendController", 2, "addArkBabyQGuideTip total count has been limit");
      }
    }
    label105:
    int n;
    label476:
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(SharedPreUtils.b(BaseApplicationImpl.getApplication(), str)));
        if (!jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(l)).equals(localObject)) {
          break label476;
        }
        if (i2 < i) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ArkRecommendController", 2, "addArkBabyQGuideTip count per day has been limit");
      return;
      n = 1;
      if (this.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources();
        ((Resources)localObject).getDisplayMetrics();
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(((Resources)localObject).getString(2131438830));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 16.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130838190);
          this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
          this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
          int i3 = AIOUtils.a(10.0F, (Resources)localObject);
          this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i3, i3, i3, AIOUtils.a(17.0F, (Resources)localObject));
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(9);
          localLayoutParams.addRule(2, 2131363494);
          localLayoutParams.leftMargin = AIOUtils.a(8.0F, (Resources)localObject);
          localLayoutParams.bottomMargin = AIOUtils.a(3.0F, (Resources)localObject);
          localLayoutParams.width = AIOUtils.a(244.0F, (Resources)localObject);
          localLayoutParams.height = AIOUtils.a(70.0F, (Resources)localObject);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint("@babyQ " + jdField_a_of_type_JavaLangString);
          SharedPreUtils.b(BaseApplicationImpl.getApplication(), str, l);
          if (m == 0) {
            break label571;
          }
          SharedPreUtils.I(BaseApplicationImpl.getApplication(), str, i1 + 1);
          SharedPreUtils.H(BaseApplicationImpl.getApplication(), str, 1);
          return;
          if (i1 >= j)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ArkRecommendController", 2, "addArkBabyQGuideTip day count has been limit");
            return;
          }
          n = 0;
          m = 1;
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ArkRecommendController", 2, "addArkBabyQGuideTip exception=" + localException);
          continue;
        }
        if (this.jdField_a_of_type_AndroidWidgetTextView.getParent() == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().addView(this.jdField_a_of_type_AndroidWidgetTextView);
        }
      }
    } while (n == 0);
    label571:
    SharedPreUtils.H(BaseApplicationImpl.getApplication(), str, i2 + 1);
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == this.jdField_a_of_type_AndroidWidgetTextView.getParent()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().removeView(this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidWidgetTextView = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(null);
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      return;
    }
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    if (localEditable.length() <= 0)
    {
      localObject = (ArkAtBabyQSpan[])localEditable.getSpans(0, localEditable.length(), ArkAtBabyQSpan.class);
      int m;
      if ((localObject != null) && (localObject.length > 0))
      {
        m = 0;
        while (m < localObject.length)
        {
          localEditable.removeSpan(localObject[m]);
          m += 1;
        }
      }
      localObject = (ArkAtBabyQSpan.ArkBabyQHintSpan[])localEditable.getSpans(0, localEditable.length(), ArkAtBabyQSpan.ArkBabyQHintSpan.class);
      if ((localObject != null) && (localObject.length > 0))
      {
        m = 0;
        while (m < localObject.length)
        {
          localEditable.removeSpan(localObject[m]);
          m += 1;
        }
      }
    }
    Object localObject = ArkAtBabyQSpan.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    if (localObject != null) {
      localEditable.replace(0, ((SpannableString)localObject).length(), (CharSequence)localObject);
    }
    localObject = ArkAtBabyQSpan.ArkBabyQHintSpan.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    if (localObject != null) {
      localEditable.append((CharSequence)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection("@babyQ".length());
  }
  
  public void i()
  {
    int m = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.post(this.jdField_c_of_type_JavaLangRunnable);
      Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
      a(localEditable, false);
      ArkAtBabyQSpan[] arrayOfArkAtBabyQSpan = (ArkAtBabyQSpan[])localEditable.getSpans(0, localEditable.length(), ArkAtBabyQSpan.class);
      if ((arrayOfArkAtBabyQSpan != null) && (arrayOfArkAtBabyQSpan.length > 0)) {
        while (m < arrayOfArkAtBabyQSpan.length)
        {
          localEditable.removeSpan(arrayOfArkAtBabyQSpan[m]);
          m += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkRecommendController
 * JD-Core Version:    0.7.0.1
 */