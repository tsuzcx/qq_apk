package com.tencent.mobileqq.activity.aio;

import aeub;
import aezn;
import aezy;
import ahiu;
import amsw;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListAdapter;
import bcef;
import bcin;
import bdvp;
import bfzg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.ShortcutRouterActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.lang.reflect.Field;
import java.util.List;
import mqq.os.MqqHandler;
import znt;

public final class AIOUtils
{
  public static final int AIO_AFTER_FINISH = 8;
  public static final int AIO_MSG_MENU_ADD_TO_COLLECTION = 5;
  public static final int AIO_MSG_MENU_ADD_TO_EMOTION = 1;
  public static final int AIO_MSG_MENU_ADD_TO_PC = 2;
  public static final int AIO_MSG_MENU_ADD_TO_WEIYUN = 3;
  public static final int AIO_ON_CTEATE = 2;
  public static final int AIO_ON_DESTROY = 9;
  public static final int AIO_ON_FINISH = 7;
  public static final int AIO_ON_NEWINTENT = 1;
  public static final int AIO_ON_PAUSE = 5;
  public static final int AIO_ON_RESUEME = 4;
  public static final int AIO_ON_START = 3;
  public static final int AIO_ON_STOP = 6;
  private static String HOMGMILTE = "HM NOTE 1LTETD";
  private static String NOBIA_NX507J = "NX507J";
  private static String OPPO_MODEL;
  public static final int THUMB_MARKET_FACE_MAX_SIZE = 100;
  public static volatile boolean hasSetSwitch;
  public static volatile boolean isForbidChatBubbleFun;
  public static volatile boolean isForbidChatBubbleFunForAIOOpen;
  public static volatile boolean isForbidChatFontFun;
  public static volatile boolean isForbidChatFontFunForAIOOpen;
  public static volatile boolean isForbidHeadPendantFun;
  public static volatile boolean isForbidHeadPendantFunForAIOOpen;
  public static volatile boolean isForbidPokeMessageAnimationPlay;
  public static volatile boolean isForbidSignatureTemplateFun;
  public static volatile boolean isForbidSignatureTemplateFunForAIOOpen;
  public static volatile boolean isForbidTipsShow;
  public static volatile boolean isForbidUneditRevokeMsg;
  public static boolean isUserOperatedInAIO;
  public static volatile boolean logcatDBOperation;
  private static Boolean needGetField;
  public static volatile int pokeAnimatingCount;
  public static volatile int pokeEmoAnimatingCount;
  private static boolean sAioMsgMenuDPCInited;
  private static SparseIntArray sAioMsgMenuDPCs = new SparseIntArray();
  private static ThreadLocal<char[]> stringBuilderCharBuffer;
  private static Field stringBuilderValueField;
  public static volatile boolean traceviewSwitch;
  
  static
  {
    needGetField = Boolean.valueOf(true);
    stringBuilderCharBuffer = new AIOUtils.1();
    OPPO_MODEL = "OPPO;R7Plusm;22|OPPO;R7007;18|OPPO;R2017;18|OPPO;N5117;18|OPPO;A33;22|OPPO;OPPO A33;22";
  }
  
  public static boolean beforeEnterAIO(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean, Intent paramIntent)
  {
    bfzg.a(null, "AIO_doOnCreate_BeforeEnterCost");
    if (!paramQQAppInterface.isLogin())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setClass(paramBaseActivity, LoginActivity.class);
      paramQQAppInterface.addFlags(262144);
      paramBaseActivity.startActivity(paramQQAppInterface);
      paramBaseActivity.finish();
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
          } while (bdvp.a(paramBaseActivity, paramQQAppInterface, paramIntent));
          if (paramBoolean)
          {
            if (isValidChat(paramBaseActivity, paramQQAppInterface, paramIntent)) {
              break label207;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.AIOUtils", 2, " isValidChat 1 false");
            }
            paramBaseActivity.finish();
            return true;
          }
          if (!paramBaseActivity.isFinishing()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.aio.AIOUtils", 2, "onNewIntent isFinishing");
        return true;
        if (!znt.a().a(paramIntent, paramBaseActivity, paramQQAppInterface)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.aio.AIOUtils", 2, "onNewIntent ThridApp to chatactivity");
      return true;
      Bundle localBundle = paramIntent.getExtras();
      if ((localBundle == null) || (!localBundle.getBoolean("back_from_emojimall", false))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.aio.AIOUtils", 2, "onNewIntent KEY_EMOJIMALL_CLOSE_BACK to chatactivity");
    return true;
    if (!isValidChat(paramBaseActivity, paramQQAppInterface, paramIntent))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.AIOUtils", 2, " isValidChat 2 false");
      }
      paramBaseActivity.finish();
      return true;
    }
    label207:
    bfzg.a("AIO_doOnCreate_BeforeEnterCost", null);
    return false;
  }
  
  @Deprecated
  public static void catchedExceptionInRelease(String paramString1, String paramString2, Exception paramException)
  {
    QLog.e(paramString1, 1, paramString2, paramException);
  }
  
  public static void catchedExceptionInReleaseV2(String paramString1, String paramString2, RuntimeException paramRuntimeException)
  {
    QLog.e(paramString1, 1, paramString2, paramRuntimeException);
  }
  
  public static final int dp2px(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static final int dp2pxByRound(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(Math.round(paramResources.getDisplayMetrics().density) * paramFloat);
  }
  
  public static void expandViewTouchDelegate(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {
      return;
    }
    ((View)paramView.getParent()).post(new AIOUtils.3(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public static ChatMessage findMessage(long paramLong, ListAdapter paramListAdapter)
  {
    Object localObject;
    if (paramListAdapter == null)
    {
      localObject = null;
      return localObject;
    }
    int i = paramListAdapter.getCount() - 1;
    for (;;)
    {
      if (i <= 0) {
        break label68;
      }
      localObject = paramListAdapter.getItem(i);
      if ((localObject instanceof ChatMessage))
      {
        ChatMessage localChatMessage = (ChatMessage)localObject;
        localObject = localChatMessage;
        if (localChatMessage.uniseq == paramLong) {
          break;
        }
      }
      i -= 1;
    }
    label68:
    return null;
  }
  
  public static int findMessagePosition(long paramLong, ListAdapter paramListAdapter)
  {
    int j;
    if (paramListAdapter == null)
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramListAdapter.getCount()) {
        break label62;
      }
      Object localObject = paramListAdapter.getItem(i);
      if ((localObject instanceof ChatMessage))
      {
        j = i;
        if (((ChatMessage)localObject).uniseq == paramLong) {
          break;
        }
      }
      i += 1;
    }
    label62:
    return -1;
  }
  
  public static int getAIOMsgMenuDpcConfig(int paramInt)
  {
    int i = 0;
    long l = 0L;
    int j = getDefaultValue(paramInt);
    if (QLog.isColorLevel()) {
      l = SystemClock.uptimeMillis();
    }
    for (;;)
    {
      try
      {
        if (sAioMsgMenuDPCInited) {
          return getVisibilityFromCache(paramInt);
        }
        Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1");
        if (QLog.isColorLevel()) {
          QLog.d("AIOUtils", 2, "aioConfig:" + (String)localObject);
        }
        localObject = ((String)localObject).split("\\|");
        if (localObject.length > 1)
        {
          localObject = localObject[1].split(",");
          if (localObject != null)
          {
            int k = localObject.length;
            if (i < k)
            {
              String[] arrayOfString = localObject[i].split("=");
              if ((arrayOfString == null) || (arrayOfString.length <= 1)) {
                break label285;
              }
              int m = Integer.valueOf(arrayOfString[0]).intValue();
              int n = Integer.valueOf(arrayOfString[1]).intValue();
              sAioMsgMenuDPCs.put(m, n);
              break label285;
            }
          }
        }
        sAioMsgMenuDPCInited = true;
        i = getVisibilityFromCache(paramInt);
      }
      catch (Exception localException)
      {
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("AIOUtils", 2, "AIOTime getAIOMsgMenuState dpc exception", localException);
        i = j;
        continue;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("AIOUtils", 2, "AIOTime initAIOMsgMenuState|" + paramInt + "|" + i + "|" + (SystemClock.uptimeMillis() - l));
        return i;
      }
      return i;
      label285:
      i += 1;
    }
  }
  
  private static int getDefaultValue(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      return 1;
    }
    return 0;
  }
  
  public static final Object getHolder(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if ((paramView.getParent() == null) || ((paramView.getParent() instanceof ListView))) {
      return paramView.getTag();
    }
    return getHolder((View)paramView.getParent());
  }
  
  @Deprecated
  public static final ChatMessage getMessage(View paramView)
  {
    paramView = (aezy)getHolder(paramView);
    if (paramView != null) {
      return paramView.a;
    }
    return null;
  }
  
  public static final View getViewByPostion(ListView paramListView, int paramInt)
  {
    if ((paramInt >= paramListView.getFirstVisiblePosition()) && (paramInt <= paramListView.getLastVisiblePosition())) {
      return paramListView.getChildAt(paramInt - paramListView.getFirstVisiblePosition());
    }
    return null;
  }
  
  private static int getVisibilityFromCache(int paramInt)
  {
    int j = getDefaultValue(paramInt);
    try
    {
      i = sAioMsgMenuDPCs.get(paramInt, j);
      if (QLog.isColorLevel()) {
        QLog.d("AIOUtils", 2, "AIOTime getVisibilityFromCache|" + sAioMsgMenuDPCs.toString() + "|" + paramInt + "|" + i);
      }
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = j;
        if (QLog.isColorLevel())
        {
          QLog.e("AIOUtils", 2, "AIOTime getAIOMsgMenuState dpc exception", localException);
          i = j;
        }
      }
    }
  }
  
  public static boolean isFolder(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    return (paramContext.hasSystemFeature("com.sec.feature.folder_type")) && (paramContext.hasSystemFeature("com.sec.feature.dual_lcd"));
  }
  
  public static boolean isHardKeyBoardDisplay(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().hardKeyboardHidden == 1;
  }
  
  public static boolean isRubbishSamsun()
  {
    return (isSamsungPhone()) && (isFolder(BaseApplicationImpl.getContext())) && (!isHardKeyBoardDisplay(BaseApplicationImpl.getContext()));
  }
  
  public static boolean isSamsungPhone()
  {
    return Build.MANUFACTURER.equalsIgnoreCase("Samsung");
  }
  
  protected static boolean isShouldPreload(BaseChatPie paramBaseChatPie, aezn paramaezn, ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1;
    int j;
    if (paramChatMessage == null)
    {
      paramaezn = paramaezn.a();
      bool1 = bool2;
      if (paramaezn != null)
      {
        bool1 = bool2;
        if (paramaezn.size() > 0)
        {
          j = paramaezn.size();
          if (aeub.jdField_a_of_type_Int <= 1) {
            break label115;
          }
          i = aeub.jdField_a_of_type_Int;
          if (j <= i) {
            break label121;
          }
          j = i;
          label61:
          if (!(paramBaseChatPie instanceof ahiu)) {
            break label162;
          }
        }
      }
    }
    label140:
    label162:
    for (int i = 1;; i = 0)
    {
      j -= 1;
      label76:
      bool1 = bool2;
      if (j > -1)
      {
        paramBaseChatPie = (ChatMessage)paramaezn.get(j);
        if (i == 0) {
          break label124;
        }
        if (!aeub.a(paramBaseChatPie)) {
          break label140;
        }
        bool1 = true;
      }
      label115:
      label121:
      label124:
      do
      {
        return bool1;
        i = 10;
        break;
        break label61;
        if ((!paramBaseChatPie.isread) && (aeub.a(paramBaseChatPie))) {
          return true;
        }
        j -= 1;
        break label76;
        bool1 = bool2;
      } while (!aeub.a(paramChatMessage));
      return true;
    }
  }
  
  private static boolean isValidChat(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    try
    {
      String str = paramIntent.getStringExtra("uin");
      int i = paramIntent.getIntExtra("uintype", -1);
      if (str == null) {
        return false;
      }
      if (i == -1)
      {
        QQToast.a(paramBaseActivity, paramBaseActivity.getString(2131718434), 0).b(paramBaseActivity.getTitleBarHeight());
        return false;
      }
      if (paramIntent.hasExtra("account"))
      {
        bcef.b(paramQQAppInterface, "CliOper", "", "", "Fast_launch", "Fast_launch_msg", 0, 0, "1", "", "", "");
        if (!((amsw)paramQQAppInterface.getManager(51)).b(str))
        {
          paramIntent.removeExtra("account");
          paramIntent.putExtra("shotcut_forward", ChatActivity.class.getName());
          paramIntent.setClassName(paramBaseActivity, ShortcutRouterActivity.class.getName());
          paramBaseActivity.startActivity(paramIntent);
          return false;
        }
      }
      if ((paramIntent.getBooleanExtra("shortcut", false)) && (!((amsw)paramQQAppInterface.getManager(51)).b(str)))
      {
        QQToast.a(paramBaseActivity.getApplicationContext(), paramBaseActivity.getString(2131718435), 0).b(paramBaseActivity.getTitleBarHeight());
        return false;
      }
      return true;
    }
    catch (RuntimeException paramBaseActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.AIOUtils", 2, "RuntimeException isValidChat beforeEnterAIO.");
      }
    }
    return false;
  }
  
  public static boolean needForceRelease()
  {
    if (NOBIA_NX507J.equalsIgnoreCase(Build.MODEL)) {}
    while (HOMGMILTE.equalsIgnoreCase(Build.MODEL)) {
      return true;
    }
    String str = Build.MANUFACTURER + ";" + Build.MODEL + ";" + Build.VERSION.SDK_INT;
    String[] arrayOfString = OPPO_MODEL.split("\\|");
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label104;
      }
      if (arrayOfString[i].equalsIgnoreCase(str)) {
        break;
      }
      i += 1;
    }
    label104:
    return false;
  }
  
  public static StringBuilder obtainStringBuilder()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      if (needGetField.booleanValue())
      {
        stringBuilderValueField = StringBuilder.class.getSuperclass().getDeclaredField("value");
        stringBuilderValueField.setAccessible(true);
        needGetField = Boolean.valueOf(false);
      }
      if (stringBuilderValueField != null) {
        stringBuilderValueField.set(localStringBuilder, stringBuilderCharBuffer.get());
      }
      return localStringBuilder;
    }
    catch (Exception localException) {}
    return localStringBuilder;
  }
  
  public static int openAioToAIOByMT(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Intent paramIntent)
  {
    if ((paramIntent.getBooleanExtra("open_chatfragment", false)) && ((paramFragmentActivity instanceof SplashActivity)))
    {
      Fragment localFragment = paramFragmentActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if ((localFragment != null) && (localFragment.isVisible()))
      {
        if (beforeEnterAIO(paramFragmentActivity, paramQQAppInterface, false, paramIntent)) {
          return 2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "openAIO by MT");
        }
        paramQQAppInterface = (ChatFragment)localFragment;
        paramIntent.putExtra("isBack2Root", true);
        paramFragmentActivity.setIntent(paramIntent);
        paramQQAppInterface.a(3);
        paramQQAppInterface.onPause();
        paramQQAppInterface.onStop();
        paramQQAppInterface.d();
        paramQQAppInterface.onStart();
        paramQQAppInterface.onResume();
        return 1;
      }
    }
    return 0;
  }
  
  public static int parseInt(bcin parambcin, String paramString)
  {
    parambcin = parambcin.a(paramString);
    if (TextUtils.isEmpty(parambcin)) {}
    do
    {
      return 0;
      try
      {
        int i = Integer.parseInt(parambcin);
        return i;
      }
      catch (Exception parambcin) {}
    } while (!QLog.isColorLevel());
    QLog.d("StructMsg", 2, parambcin.getMessage());
    return 0;
  }
  
  public static void postDelayedChatPieMessage(String paramString, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3, Object paramObject, int paramInt4)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
    } while (paramQQAppInterface == null);
    if (QLog.isColorLevel()) {
      QLog.d(paramString, 2, new Object[] { "postDelayedChatPieMessage MSG: ", Integer.valueOf(paramInt1), " arg1: ", Integer.valueOf(paramInt2), "arg2: ", Integer.valueOf(paramInt3), "obj: ", String.valueOf(paramObject) });
    }
    paramQQAppInterface.removeMessages(paramInt1);
    paramQQAppInterface.sendMessageDelayed(paramQQAppInterface.obtainMessage(paramInt1, paramInt2, paramInt3, paramObject), paramInt4);
  }
  
  public static final void preStartQWebIfNeed(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, aezn paramaezn, ChatMessage paramChatMessage)
  {
    
    if (aeub.jdField_a_of_type_Int <= 0) {
      return;
    }
    preStartQWebIfNeedReal(paramQQAppInterface, isShouldPreload(paramBaseChatPie, paramaezn, paramChatMessage));
  }
  
  public static void preStartQWebIfNeedReal(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramBoolean) {
      ((WebProcessManager)paramQQAppInterface.getManager(13)).a(1, new AIOUtils.2());
    }
  }
  
  protected static void preStartQWebParseParams()
  {
    boolean bool = true;
    Object localObject;
    if (aeub.jdField_a_of_type_Int == -1)
    {
      localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_gifplay.name());
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length > 3) {
          if ((!localObject[0].equals("1")) || (!localObject[1].equals("1"))) {
            break label112;
          }
        }
      }
    }
    for (;;)
    {
      aeub.b = bool;
      if (!"0".equals(localObject[3])) {}
      try
      {
        i = Integer.parseInt(localObject[3]);
        if (aeub.jdField_a_of_type_Boolean)
        {
          aeub.jdField_a_of_type_Int = i;
          if (aeub.jdField_a_of_type_Int == -1) {
            aeub.jdField_a_of_type_Int = 0;
          }
          return;
          label112:
          bool = false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i = 0;
          continue;
          i = 0;
        }
      }
    }
  }
  
  public static void printColorLevelLog(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, "AIOTime " + paramString2 + "|" + paramInt1 + "|" + paramInt2);
    }
  }
  
  public static final float px2dp(int paramInt, Resources paramResources)
  {
    if (paramInt == 0) {
      return 0.0F;
    }
    return paramInt / paramResources.getDisplayMetrics().density;
  }
  
  public static void setIsNotLoadSuit(boolean paramBoolean)
  {
    isForbidHeadPendantFunForAIOOpen = paramBoolean;
    isForbidSignatureTemplateFunForAIOOpen = paramBoolean;
    isForbidChatBubbleFunForAIOOpen = paramBoolean;
    isForbidPokeMessageAnimationPlay = paramBoolean;
    isForbidUneditRevokeMsg = paramBoolean;
  }
  
  public static Intent setOpenAIOIntent(Intent paramIntent, int[] paramArrayOfInt)
  {
    paramIntent.putExtra("open_chatfragment", true);
    paramIntent.addFlags(67108864);
    if (paramArrayOfInt != null)
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      if (i < j)
      {
        switch (paramArrayOfInt[i])
        {
        }
        for (;;)
        {
          i += 1;
          break;
          paramIntent.putExtra("open_chatfragment_withanim", true);
          continue;
          paramIntent.addFlags(268435456);
        }
      }
    }
    return paramIntent;
  }
  
  public static void setViewDrawable(View paramView, Drawable paramDrawable)
  {
    if ((paramDrawable == null) || (paramView == null)) {
      return;
    }
    Rect localRect = new Rect();
    paramDrawable.getPadding(localRect);
    int i = paramView.getPaddingTop();
    int j = localRect.top;
    int k = paramView.getPaddingLeft();
    int m = localRect.left;
    int n = paramView.getPaddingRight();
    int i1 = localRect.right;
    int i2 = paramView.getPaddingBottom();
    int i3 = localRect.bottom;
    paramView.setBackgroundDrawable(paramDrawable);
    paramView.setPadding(k + m, i + j, n + i1, i3 + i2);
  }
  
  public static void setViewDrawalbe(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    int i = paramView.getPaddingTop();
    int j = paramView.getPaddingLeft();
    int k = paramView.getPaddingRight();
    int m = paramView.getPaddingBottom();
    paramView.setBackgroundResource(paramInt);
    paramView.setPadding(j, i, k, m);
  }
  
  public static Runnable showDelayView(View paramView, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable.getStatus() == 0) || (paramURLDrawable.getStatus() == 4)) {}
    for (int i = 1;; i = 0)
    {
      AIOUtils.4 local4 = null;
      if (i != 0)
      {
        local4 = new AIOUtils.4(paramURLDrawable, paramView);
        paramView.postDelayed(local4, 200L);
      }
      return local4;
    }
  }
  
  public static void showKeyboard(View paramView)
  {
    if (paramView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.XPanelContainer", 2, "showKeyboard failed, view is null ");
      }
    }
    label386:
    for (;;)
    {
      return;
      InputMethodManager localInputMethodManager;
      if (paramView.requestFocus())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.XPanelContainer", 2, " requestFocus success ");
        }
        boolean bool = paramView.hasFocus();
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.XPanelContainer", 2, " hasFocus " + bool);
        }
        localInputMethodManager = (InputMethodManager)paramView.getContext().getSystemService("input_method");
        if (!localInputMethodManager.showSoftInput(paramView, 0)) {
          break label177;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.XPanelContainer", 2, " showSoftInput success ");
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label386;
        }
        QLog.d("Q.aio.XPanelContainer", 2, " imm.isActive() = " + localInputMethodManager.isActive());
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.aio.XPanelContainer", 2, " requestFocus fail ");
        break;
        label177:
        if (QLog.isColorLevel()) {
          QLog.e("Q.aio.XPanelContainer", 2, " showSoftInput fail ");
        }
        try
        {
          Object localObject2 = localInputMethodManager.getClass();
          Object localObject1 = ((Class)localObject2).getDeclaredField("mServedView");
          localObject2 = ((Class)localObject2).getDeclaredField("mNextServedView");
          ((Field)localObject1).setAccessible(true);
          ((Field)localObject2).setAccessible(true);
          localObject1 = ((Field)localObject1).get(localInputMethodManager);
          localObject2 = ((Field)localObject2).get(localInputMethodManager);
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.XPanelContainer", 2, " showSoftInput fail mNextServedObject = " + localObject2 + " mServedObject" + localObject1 + " messageInputer = " + paramView);
          }
          if ((localObject1 != null) && (localObject1 != paramView) && ((localObject1 instanceof View)))
          {
            localInputMethodManager.hideSoftInputFromWindow(((View)localObject1).getWindowToken(), 0);
            paramView.requestFocusFromTouch();
            paramView.requestFocus();
            if ((!localInputMethodManager.showSoftInput(paramView, 0)) && (QLog.isColorLevel())) {
              QLog.d("Q.aio.XPanelContainer", 2, " try showSoftInput fail ");
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.XPanelContainer", 2, " try showSoftInput end");
            }
          }
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
        }
      }
    }
  }
  
  public static final float sp2TextSize(int paramInt1, int paramInt2, Resources paramResources)
  {
    return TypedValue.applyDimension(paramInt1, paramInt2, paramResources.getDisplayMetrics());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOUtils
 * JD-Core Version:    0.7.0.1
 */