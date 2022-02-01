package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.Intent;
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
import com.tencent.biz.thridappshare.ThridAppShareHelper;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ShortcutRouterActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.troop.blocktroop.TroopBlockUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.lang.reflect.Field;
import java.util.List;
import mqq.os.MqqHandler;

public final class AIOUtils
{
  public static volatile int a;
  private static SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray;
  private static Boolean jdField_a_of_type_JavaLangBoolean;
  private static String jdField_a_of_type_JavaLangString;
  private static ThreadLocal<char[]> jdField_a_of_type_JavaLangThreadLocal;
  private static Field jdField_a_of_type_JavaLangReflectField;
  public static volatile boolean a;
  public static volatile int b;
  private static String b;
  public static volatile boolean b;
  private static String c;
  public static volatile boolean c;
  public static volatile boolean d;
  public static volatile boolean e;
  public static volatile boolean f;
  public static volatile boolean g;
  public static volatile boolean h;
  public static volatile boolean i;
  public static volatile boolean j;
  public static volatile boolean k;
  public static volatile boolean l;
  public static volatile boolean m;
  public static volatile boolean n;
  public static boolean o;
  private static boolean p;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Boolean = false;
    d = false;
    e = false;
    f = false;
    g = false;
    h = false;
    i = false;
    j = false;
    k = false;
    l = false;
    m = false;
    n = false;
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 0;
    o = false;
    p = false;
    jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    jdField_a_of_type_JavaLangThreadLocal = new AIOUtils.1();
    jdField_a_of_type_JavaLangString = "OPPO;R7Plusm;22|OPPO;R7007;18|OPPO;R2017;18|OPPO;N5117;18|OPPO;A33;22|OPPO;OPPO A33;22";
    jdField_b_of_type_JavaLangString = "HM NOTE 1LTETD";
    jdField_c_of_type_JavaLangString = "NX507J";
  }
  
  public static final float a(int paramInt1, int paramInt2, Resources paramResources)
  {
    return TypedValue.applyDimension(paramInt1, paramInt2, paramResources.getDisplayMetrics());
  }
  
  public static final float a(int paramInt, Resources paramResources)
  {
    if (paramInt == 0) {
      return 0.0F;
    }
    return paramInt / paramResources.getDisplayMetrics().density;
  }
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static int a(int paramInt)
  {
    long l1 = 0L;
    int i2 = c(paramInt);
    if (QLog.isColorLevel()) {
      l1 = SystemClock.uptimeMillis();
    }
    for (;;)
    {
      int i1;
      try
      {
        if (p) {
          return b(paramInt);
        }
        Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1");
        if (QLog.isColorLevel()) {
          QLog.d("AIOUtils", 2, "aioConfig:" + (String)localObject);
        }
        localObject = ((String)localObject).split("\\|");
        if (localObject.length > 1)
        {
          localObject = localObject[1].split(",");
          if (localObject != null)
          {
            int i3 = localObject.length;
            i1 = 0;
            if (i1 < i3)
            {
              String[] arrayOfString = localObject[i1].split("=");
              if ((arrayOfString == null) || (arrayOfString.length <= 1)) {
                break label278;
              }
              int i4 = Integer.valueOf(arrayOfString[0]).intValue();
              int i5 = Integer.valueOf(arrayOfString[1]).intValue();
              jdField_a_of_type_AndroidUtilSparseIntArray.put(i4, i5);
              break label278;
            }
          }
        }
        p = true;
        i1 = b(paramInt);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("AIOUtils", 2, "AIOTime getAIOMsgMenuState dpc exception", localException);
        i1 = i2;
        continue;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("AIOUtils", 2, "AIOTime initAIOMsgMenuState|" + paramInt + "|" + i1 + "|" + (SystemClock.uptimeMillis() - l1));
        return i1;
      }
      return i1;
      label278:
      i1 += 1;
    }
  }
  
  public static int a(long paramLong, ListAdapter paramListAdapter)
  {
    int i2;
    if (paramListAdapter == null)
    {
      i2 = -1;
      return i2;
    }
    int i1 = 0;
    for (;;)
    {
      if (i1 >= paramListAdapter.getCount()) {
        break label62;
      }
      Object localObject = paramListAdapter.getItem(i1);
      if ((localObject instanceof ChatMessage))
      {
        i2 = i1;
        if (((ChatMessage)localObject).uniseq == paramLong) {
          break;
        }
      }
      i1 += 1;
    }
    label62:
    return -1;
  }
  
  public static int a(Context paramContext)
  {
    return paramContext.getResources().getDimensionPixelSize(2131299166);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Intent paramIntent)
  {
    if ((paramIntent.getBooleanExtra("open_chatfragment", false)) && ((paramFragmentActivity instanceof SplashActivity)))
    {
      Fragment localFragment = paramFragmentActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if ((localFragment != null) && (localFragment.isVisible()))
      {
        if (a(paramFragmentActivity, paramQQAppInterface, false, paramIntent)) {
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
  
  public static int a(StructMsgNode paramStructMsgNode, String paramString)
  {
    paramStructMsgNode = paramStructMsgNode.a(paramString);
    if (TextUtils.isEmpty(paramStructMsgNode)) {}
    do
    {
      return 0;
      try
      {
        int i1 = Integer.parseInt(paramStructMsgNode);
        return i1;
      }
      catch (Exception paramStructMsgNode) {}
    } while (!QLog.isColorLevel());
    QLog.d("StructMsg", 2, paramStructMsgNode.getMessage());
    return 0;
  }
  
  public static Intent a(Intent paramIntent, int[] paramArrayOfInt)
  {
    paramIntent.putExtra("open_chatfragment", true);
    paramIntent.addFlags(67108864);
    if (paramArrayOfInt != null)
    {
      int i2 = paramArrayOfInt.length;
      int i1 = 0;
      if (i1 < i2)
      {
        switch (paramArrayOfInt[i1])
        {
        }
        for (;;)
        {
          i1 += 1;
          break;
          paramIntent.putExtra("open_chatfragment_withanim", true);
          continue;
          paramIntent.addFlags(268435456);
        }
      }
    }
    return paramIntent;
  }
  
  public static final View a(ListView paramListView, int paramInt)
  {
    if ((paramInt >= paramListView.getFirstVisiblePosition()) && (paramInt <= paramListView.getLastVisiblePosition())) {
      return paramListView.getChildAt(paramInt - paramListView.getFirstVisiblePosition());
    }
    return null;
  }
  
  public static ChatMessage a(long paramLong, ListAdapter paramListAdapter)
  {
    Object localObject;
    if (paramListAdapter == null)
    {
      localObject = null;
      return localObject;
    }
    int i1 = paramListAdapter.getCount() - 1;
    for (;;)
    {
      if (i1 <= 0) {
        break label68;
      }
      localObject = paramListAdapter.getItem(i1);
      if ((localObject instanceof ChatMessage))
      {
        ChatMessage localChatMessage = (ChatMessage)localObject;
        localObject = localChatMessage;
        if (localChatMessage.uniseq == paramLong) {
          break;
        }
      }
      i1 -= 1;
    }
    label68:
    return null;
  }
  
  @Deprecated
  public static final ChatMessage a(View paramView)
  {
    paramView = (ChatItemBuilder.BaseHolder)a(paramView);
    if (paramView != null) {
      return paramView.a;
    }
    return null;
  }
  
  public static final Object a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if ((paramView.getParent() == null) || ((paramView.getParent() instanceof ListView))) {
      return paramView.getTag();
    }
    return a((View)paramView.getParent());
  }
  
  public static Runnable a(View paramView, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable.getStatus() == 0) || (paramURLDrawable.getStatus() == 4)) {}
    for (int i1 = 1;; i1 = 0)
    {
      AIOUtils.4 local4 = null;
      if (i1 != 0)
      {
        local4 = new AIOUtils.4(paramURLDrawable, paramView);
        paramView.postDelayed(local4, 200L);
      }
      return local4;
    }
  }
  
  public static StringBuilder a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      if (jdField_a_of_type_JavaLangBoolean.booleanValue())
      {
        jdField_a_of_type_JavaLangReflectField = StringBuilder.class.getSuperclass().getDeclaredField("value");
        jdField_a_of_type_JavaLangReflectField.setAccessible(true);
        jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      }
      if (jdField_a_of_type_JavaLangReflectField != null) {
        jdField_a_of_type_JavaLangReflectField.set(localStringBuilder, jdField_a_of_type_JavaLangThreadLocal.get());
      }
      return localStringBuilder;
    }
    catch (Exception localException) {}
    return localStringBuilder;
  }
  
  protected static void a()
  {
    Object localObject;
    boolean bool;
    if (WebAccelerator.jdField_a_of_type_Int == -1)
    {
      localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_gifplay.name());
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length > 3)
        {
          if ((!localObject[0].equals("1")) || (!localObject[1].equals("1"))) {
            break label118;
          }
          bool = true;
        }
      }
    }
    for (;;)
    {
      WebAccelerator.jdField_b_of_type_Boolean = bool;
      if (!"0".equals(localObject[3])) {}
      try
      {
        i1 = Integer.parseInt(localObject[3]);
        if (WebAccelerator.jdField_a_of_type_Boolean)
        {
          WebAccelerator.jdField_a_of_type_Int = i1;
          if (WebAccelerator.jdField_a_of_type_Int == -1) {
            WebAccelerator.jdField_a_of_type_Int = 0;
          }
          return;
          label118:
          bool = false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i1 = 0;
          continue;
          i1 = 0;
        }
      }
    }
  }
  
  public static void a(View paramView)
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
  
  public static void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    int i1 = paramView.getPaddingTop();
    int i2 = paramView.getPaddingLeft();
    int i3 = paramView.getPaddingRight();
    int i4 = paramView.getPaddingBottom();
    paramView.setBackgroundResource(paramInt);
    paramView.setPadding(i2, i1, i3, i4);
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {
      return;
    }
    ((View)paramView.getParent()).post(new AIOUtils.3(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public static void a(View paramView, Drawable paramDrawable)
  {
    if ((paramDrawable == null) || (paramView == null)) {
      return;
    }
    Rect localRect = new Rect();
    paramDrawable.getPadding(localRect);
    int i1 = paramView.getPaddingTop();
    int i2 = localRect.top;
    int i3 = paramView.getPaddingLeft();
    int i4 = localRect.left;
    int i5 = paramView.getPaddingRight();
    int i6 = localRect.right;
    int i7 = paramView.getPaddingBottom();
    int i8 = localRect.bottom;
    paramView.setBackgroundDrawable(paramDrawable);
    paramView.setPadding(i3 + i4, i1 + i2, i5 + i6, i8 + i7);
  }
  
  public static final void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ChatAdapter1 paramChatAdapter1, ChatMessage paramChatMessage)
  {
    
    if (WebAccelerator.jdField_a_of_type_Int <= 0) {
      return;
    }
    a(paramQQAppInterface, a(paramBaseChatPie, paramChatAdapter1, paramChatMessage));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramBoolean) {
      ((IWebProcessManagerService)paramQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "")).startWebProcess(1, new AIOUtils.2());
    }
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3, Object paramObject, int paramInt4)
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
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, "AIOTime " + paramString2 + "|" + paramInt1 + "|" + paramInt2);
    }
  }
  
  @Deprecated
  public static void a(String paramString1, String paramString2, Exception paramException)
  {
    QLog.e(paramString1, 1, paramString2, paramException);
  }
  
  public static void a(String paramString1, String paramString2, RuntimeException paramRuntimeException)
  {
    QLog.e(paramString1, 1, paramString2, paramRuntimeException);
  }
  
  public static void a(boolean paramBoolean)
  {
    i = paramBoolean;
    j = paramBoolean;
    k = paramBoolean;
    l = paramBoolean;
    n = paramBoolean;
  }
  
  public static boolean a()
  {
    if (jdField_c_of_type_JavaLangString.equalsIgnoreCase(Build.MODEL)) {}
    while (jdField_b_of_type_JavaLangString.equalsIgnoreCase(Build.MODEL)) {
      return true;
    }
    String str = Build.MANUFACTURER + ";" + Build.MODEL + ";" + Build.VERSION.SDK_INT;
    String[] arrayOfString = jdField_a_of_type_JavaLangString.split("\\|");
    int i2 = arrayOfString.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        break label103;
      }
      if (arrayOfString[i1].equalsIgnoreCase(str)) {
        break;
      }
      i1 += 1;
    }
    label103:
    return false;
  }
  
  protected static boolean a(BaseChatPie paramBaseChatPie, ChatAdapter1 paramChatAdapter1, ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1;
    int i2;
    if (paramChatMessage == null)
    {
      paramChatAdapter1 = paramChatAdapter1.a();
      bool1 = bool2;
      if (paramChatAdapter1 != null)
      {
        bool1 = bool2;
        if (paramChatAdapter1.size() > 0)
        {
          i2 = paramChatAdapter1.size();
          if (WebAccelerator.jdField_a_of_type_Int <= 1) {
            break label115;
          }
          i1 = WebAccelerator.jdField_a_of_type_Int;
          if (i2 <= i1) {
            break label121;
          }
          i2 = i1;
          label61:
          if (!(paramBaseChatPie instanceof PublicAccountChatPie)) {
            break label162;
          }
        }
      }
    }
    label140:
    label162:
    for (int i1 = 1;; i1 = 0)
    {
      i2 -= 1;
      label76:
      bool1 = bool2;
      if (i2 > -1)
      {
        paramBaseChatPie = (ChatMessage)paramChatAdapter1.get(i2);
        if (i1 == 0) {
          break label124;
        }
        if (!WebAccelerator.a(paramBaseChatPie)) {
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
        i1 = 10;
        break;
        break label61;
        if ((!paramBaseChatPie.isread) && (WebAccelerator.a(paramBaseChatPie))) {
          return true;
        }
        i2 -= 1;
        break label76;
        bool1 = bool2;
      } while (!WebAccelerator.a(paramChatMessage));
      return true;
    }
  }
  
  private static boolean a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    try
    {
      String str = paramIntent.getStringExtra("uin");
      int i1 = paramIntent.getIntExtra("uintype", -1);
      if (str == null) {
        return false;
      }
      if (i1 == -1)
      {
        QQToast.a(paramBaseActivity, paramBaseActivity.getString(2131719345), 0).b(paramBaseActivity.getTitleBarHeight());
        return false;
      }
      if (paramIntent.hasExtra("account"))
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "Fast_launch", "Fast_launch_msg", 0, 0, "1", "", "", "");
        if (!((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(str))
        {
          paramIntent.removeExtra("account");
          paramIntent.putExtra("shotcut_forward", ChatActivity.class.getName());
          paramIntent.setClassName(paramBaseActivity, ShortcutRouterActivity.class.getName());
          paramBaseActivity.startActivity(paramIntent);
          return false;
        }
      }
      if ((paramIntent.getBooleanExtra("shortcut", false)) && (!((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(str)))
      {
        QQToast.a(paramBaseActivity.getApplicationContext(), paramBaseActivity.getString(2131719346), 0).b(paramBaseActivity.getTitleBarHeight());
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
  
  public static boolean a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean, Intent paramIntent)
  {
    StartupTracker.a(null, "AIO_doOnCreate_BeforeEnterCost");
    if (!paramQQAppInterface.isLogin())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.addFlags(262144);
      RouteUtils.a(paramBaseActivity, paramQQAppInterface, "/base/login");
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
          } while (TroopBlockUtils.a(paramBaseActivity, paramQQAppInterface, paramIntent));
          if (paramBoolean)
          {
            if (a(paramBaseActivity, paramQQAppInterface, paramIntent)) {
              break label215;
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
        if (!ThridAppShareHelper.a().a(paramIntent, paramBaseActivity, paramQQAppInterface)) {
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
    if (!a(paramBaseActivity, paramQQAppInterface, paramIntent))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.AIOUtils", 2, " isValidChat 2 false");
      }
      paramBaseActivity.finish();
      return true;
    }
    label215:
    StartupTracker.a("AIO_doOnCreate_BeforeEnterCost", null);
    return false;
  }
  
  public static final int b(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(Math.round(paramResources.getDisplayMetrics().density) * paramFloat);
  }
  
  private static int b(int paramInt)
  {
    int i2 = c(paramInt);
    try
    {
      i1 = jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt, i2);
      if (QLog.isColorLevel()) {
        QLog.d("AIOUtils", 2, "AIOTime getVisibilityFromCache|" + jdField_a_of_type_AndroidUtilSparseIntArray.toString() + "|" + paramInt + "|" + i1);
      }
      return i1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.e("AIOUtils", 2, "AIOTime getAIOMsgMenuState dpc exception", localException);
          i1 = i2;
        }
      }
    }
  }
  
  private static int c(int paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOUtils
 * JD-Core Version:    0.7.0.1
 */