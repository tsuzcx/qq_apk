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
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.ListAdapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.thridappshare.ThridAppShareHelper;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ShortcutRouterActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
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
import com.tencent.mobileqq.troop.temporaryban.api.ITemporarilyBannedTroopUtilApi;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.lang.reflect.Field;
import java.util.List;
import mqq.os.MqqHandler;

public final class AIOUtils
  extends BaseAIOUtils
{
  public static volatile boolean a = false;
  public static volatile boolean b = false;
  public static volatile boolean c = false;
  public static volatile boolean d = false;
  public static volatile boolean e = false;
  public static volatile boolean f = false;
  public static volatile boolean g = false;
  public static volatile boolean h = false;
  public static volatile boolean i = false;
  public static volatile boolean j = false;
  public static volatile boolean k = false;
  public static volatile boolean l = false;
  public static volatile boolean m = false;
  public static volatile boolean n = false;
  public static volatile int o = 0;
  public static volatile int p = 0;
  public static boolean q = false;
  private static boolean r = false;
  private static SparseIntArray s = new SparseIntArray();
  private static Field t;
  private static Boolean u = Boolean.valueOf(true);
  private static ThreadLocal<char[]> v = new AIOUtils.1();
  private static String w = "OPPO;R7Plusm;22|OPPO;R7007;18|OPPO;R2017;18|OPPO;N5117;18|OPPO;A33;22|OPPO;OPPO A33;22";
  private static String x = "HM NOTE 1LTETD";
  private static String y = "NX507J";
  
  public static final float a(int paramInt1, int paramInt2, Resources paramResources)
  {
    return TypedValue.applyDimension(paramInt1, paramInt2, paramResources.getDisplayMetrics());
  }
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * Math.round(paramResources.getDisplayMetrics().density));
  }
  
  public static int a(int paramInt)
  {
    int i2 = c(paramInt);
    long l1;
    if (QLog.isColorLevel()) {
      l1 = SystemClock.uptimeMillis();
    } else {
      l1 = 0L;
    }
    for (;;)
    {
      int i1;
      try
      {
        if (r) {
          return b(paramInt);
        }
        Object localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1");
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("aioConfig:");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("AIOUtils", 2, ((StringBuilder)localObject2).toString());
        }
        localObject1 = ((String)localObject1).split("\\|");
        if (localObject1.length > 1)
        {
          localObject1 = localObject1[1].split(",");
          if (localObject1 != null)
          {
            int i3 = localObject1.length;
            i1 = 0;
            if (i1 < i3)
            {
              localObject2 = localObject1[i1].split("=");
              if ((localObject2 == null) || (localObject2.length <= 1)) {
                break label313;
              }
              int i4 = Integer.valueOf(localObject2[0]).intValue();
              int i5 = Integer.valueOf(localObject2[1]).intValue();
              s.put(i4, i5);
              break label313;
            }
          }
        }
        r = true;
        i1 = b(paramInt);
      }
      catch (Exception localException)
      {
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.i("AIOUtils", 2, "AIOTime getAIOMsgMenuState dpc exception", localException);
          i1 = i2;
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("AIOTime initAIOMsgMenuState|");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("|");
        localStringBuilder.append(i1);
        localStringBuilder.append("|");
        localStringBuilder.append(SystemClock.uptimeMillis() - l1);
        QLog.d("AIOUtils", 2, localStringBuilder.toString());
      }
      return i1;
      label313:
      i1 += 1;
    }
  }
  
  public static int a(long paramLong, ListAdapter paramListAdapter)
  {
    if (paramListAdapter == null) {
      return -1;
    }
    int i1 = 0;
    while (i1 < paramListAdapter.getCount())
    {
      Object localObject = paramListAdapter.getItem(i1);
      if (((localObject instanceof ChatMessage)) && (((ChatMessage)localObject).uniseq == paramLong)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public static int a(Context paramContext)
  {
    return paramContext.getResources().getDimensionPixelSize(2131299920);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Intent paramIntent)
  {
    int i2 = 0;
    int i1 = i2;
    if (paramIntent.getBooleanExtra("open_chatfragment", false))
    {
      i1 = i2;
      if ((paramBaseActivity instanceof SplashActivity))
      {
        Fragment localFragment = paramBaseActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
        i1 = i2;
        if (localFragment != null)
        {
          i1 = i2;
          if (localFragment.isVisible())
          {
            if (a(paramBaseActivity, paramQQAppInterface, false, paramIntent)) {
              return 2;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.BaseChatPie", 2, "openAIO by MT");
            }
            paramQQAppInterface = (ChatFragment)localFragment;
            paramIntent.putExtra("isBack2Root", true);
            paramBaseActivity.setIntent(paramIntent);
            paramQQAppInterface.a(3);
            paramQQAppInterface.onPause();
            paramQQAppInterface.onStop();
            paramQQAppInterface.l();
            paramQQAppInterface.onStart();
            paramQQAppInterface.onResume();
            i1 = 1;
          }
        }
      }
    }
    return i1;
  }
  
  public static int a(StructMsgNode paramStructMsgNode, String paramString)
  {
    paramStructMsgNode = paramStructMsgNode.a(paramString);
    if (TextUtils.isEmpty(paramStructMsgNode)) {
      return 0;
    }
    try
    {
      int i1 = Integer.parseInt(paramStructMsgNode);
      return i1;
    }
    catch (Exception paramStructMsgNode)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, paramStructMsgNode.getMessage());
      }
    }
    return 0;
  }
  
  public static final View a(ListView paramListView, int paramInt)
  {
    if ((paramInt >= paramListView.getFirstVisiblePosition()) && (paramInt <= paramListView.getLastVisiblePosition())) {
      return paramListView.getChildAt(paramInt - paramListView.getFirstVisiblePosition());
    }
    return null;
  }
  
  @Deprecated
  public static final ChatMessage a(View paramView)
  {
    paramView = (ChatItemBuilder.BaseHolder)b(paramView);
    if (paramView != null) {
      return paramView.q;
    }
    return null;
  }
  
  public static StringBuilder a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      if (u.booleanValue())
      {
        t = StringBuilder.class.getSuperclass().getDeclaredField("value");
        t.setAccessible(true);
        u = Boolean.valueOf(false);
      }
      if (t != null) {
        t.set(localStringBuilder, v.get());
      }
      return localStringBuilder;
    }
    catch (Exception localException) {}
    return localStringBuilder;
  }
  
  public static void a(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setCallback(null);
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
  
  public static void a(View paramView, Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if (paramView == null) {
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
      paramView.setPadding(i3 + i4, i1 + i2, i5 + i6, i7 + i8);
    }
  }
  
  public static final void a(QQAppInterface paramQQAppInterface, int paramInt, List<ChatMessage> paramList, ChatMessage paramChatMessage)
  {
    
    if (WebAccelerator.c <= 0) {
      return;
    }
    a(paramQQAppInterface, a(paramInt, paramList, paramChatMessage));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramBoolean) {
      ((IWebProcessManagerService)paramQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "")).startWebProcess(1, new AIOUtils.2());
    }
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3, Object paramObject, int paramInt4)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
    if (paramQQAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(paramString, 2, new Object[] { "postDelayedChatPieMessage MSG: ", Integer.valueOf(paramInt1), " arg1: ", Integer.valueOf(paramInt2), "arg2: ", Integer.valueOf(paramInt3), "obj: ", String.valueOf(paramObject) });
      }
      paramQQAppInterface.removeMessages(paramInt1);
      paramQQAppInterface.sendMessageDelayed(paramQQAppInterface.obtainMessage(paramInt1, paramInt2, paramInt3, paramObject), paramInt4);
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AIOTime ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("|");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("|");
      localStringBuilder.append(paramInt2);
      QLog.d(paramString1, 2, localStringBuilder.toString());
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
  
  protected static boolean a(int paramInt, List<ChatMessage> paramList, ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramChatMessage == null)
    {
      bool1 = bool2;
      if (paramList != null)
      {
        bool1 = bool2;
        if (paramList.size() > 0)
        {
          int i3 = paramList.size();
          if (WebAccelerator.c > 1) {
            i1 = WebAccelerator.c;
          } else {
            i1 = 10;
          }
          int i2 = i3;
          if (i3 > i1) {
            i2 = i1;
          }
          if (paramInt == 1008) {
            paramInt = 1;
          } else {
            paramInt = 0;
          }
          int i1 = i2 - 1;
          for (;;)
          {
            bool1 = bool2;
            if (i1 <= -1) {
              break label157;
            }
            paramChatMessage = (ChatMessage)paramList.get(i1);
            if (paramInt != 0 ? !WebAccelerator.a(paramChatMessage) : (!paramChatMessage.isread) && (WebAccelerator.a(paramChatMessage))) {
              break;
            }
            i1 -= 1;
          }
        }
      }
    }
    else
    {
      bool1 = bool2;
      if (WebAccelerator.a(paramChatMessage)) {
        bool1 = true;
      }
    }
    label157:
    return bool1;
  }
  
  private static boolean a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    try
    {
      str = paramIntent.getStringExtra("uin");
      int i1 = paramIntent.getIntExtra("uintype", -1);
      if (str == null) {
        return false;
      }
      if (i1 == -1)
      {
        QQToast.makeText(paramBaseActivity, paramBaseActivity.getString(2131916599), 0).show(paramBaseActivity.getTitleBarHeight());
        return false;
      }
      if (paramIntent.hasExtra("account"))
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "Fast_launch", "Fast_launch_msg", 0, 0, "1", "", "", "");
        if (!((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(str))
        {
          paramIntent.removeExtra("account");
          paramIntent.putExtra("shotcut_forward", ChatActivity.class.getName());
          paramIntent.setClassName(paramBaseActivity, ShortcutRouterActivity.class.getName());
          paramBaseActivity.startActivity(paramIntent);
          return false;
        }
      }
    }
    catch (RuntimeException paramBaseActivity)
    {
      String str;
      label209:
      label212:
      break label212;
    }
    try
    {
      if ((paramIntent.getBooleanExtra("shortcut", false)) && (!((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(str)))
      {
        QQToast.makeText(paramBaseActivity.getApplicationContext(), paramBaseActivity.getString(2131916600), 0).show(paramBaseActivity.getTitleBarHeight());
        return false;
      }
      return true;
    }
    catch (RuntimeException paramBaseActivity)
    {
      break label209;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.AIOUtils", 2, "RuntimeException isValidChat beforeEnterAIO.");
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
      return true;
    }
    if (((ITemporarilyBannedTroopUtilApi)QRoute.api(ITemporarilyBannedTroopUtilApi.class)).checkTemporarilyBannedTroop(paramBaseActivity, paramQQAppInterface, paramIntent)) {
      return true;
    }
    if (TroopBlockUtils.a(paramBaseActivity, paramQQAppInterface, paramIntent)) {
      return true;
    }
    if (paramBoolean)
    {
      if (!a(paramBaseActivity, paramQQAppInterface, paramIntent))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.AIOUtils", 2, " isValidChat 1 false");
        }
        paramBaseActivity.finish();
        return true;
      }
    }
    else
    {
      if (paramBaseActivity.isFinishing())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.AIOUtils", 2, "onNewIntent isFinishing");
        }
        return true;
      }
      if (ThridAppShareHelper.a().a(paramIntent, paramBaseActivity, paramQQAppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.AIOUtils", 2, "onNewIntent ThridApp to chatactivity");
        }
        return true;
      }
      Bundle localBundle = paramIntent.getExtras();
      if ((localBundle != null) && (localBundle.getBoolean("back_from_emojimall", false)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.AIOUtils", 2, "onNewIntent KEY_EMOJIMALL_CLOSE_BACK to chatactivity");
        }
        return true;
      }
      if (!a(paramBaseActivity, paramQQAppInterface, paramIntent))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.AIOUtils", 2, " isValidChat 2 false");
        }
        paramBaseActivity.finish();
        return true;
      }
    }
    StartupTracker.a("AIO_doOnCreate_BeforeEnterCost", null);
    return false;
  }
  
  private static int b(int paramInt)
  {
    int i2 = c(paramInt);
    int i1;
    try
    {
      i1 = s.get(paramInt, i2);
    }
    catch (Exception localException)
    {
      i1 = i2;
      if (QLog.isColorLevel())
      {
        QLog.e("AIOUtils", 2, "AIOTime getAIOMsgMenuState dpc exception", localException);
        i1 = i2;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AIOTime getVisibilityFromCache|");
      localStringBuilder.append(s.toString());
      localStringBuilder.append("|");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("|");
      localStringBuilder.append(i1);
      QLog.d("AIOUtils", 2, localStringBuilder.toString());
    }
    return i1;
  }
  
  public static ChatMessage b(long paramLong, ListAdapter paramListAdapter)
  {
    if (paramListAdapter == null) {
      return null;
    }
    int i1 = paramListAdapter.getCount() - 1;
    while (i1 > 0)
    {
      Object localObject = paramListAdapter.getItem(i1);
      if ((localObject instanceof ChatMessage))
      {
        localObject = (ChatMessage)localObject;
        if (((ChatMessage)localObject).uniseq == paramLong) {
          return localObject;
        }
      }
      i1 -= 1;
    }
    return null;
  }
  
  public static final Object b(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if ((paramView.getParent() != null) && (!(paramView.getParent() instanceof ListView))) {
      return b((View)paramView.getParent());
    }
    return paramView.getTag();
  }
  
  protected static void b()
  {
    Object localObject;
    if (WebAccelerator.c == -1)
    {
      localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_gifplay.name());
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length > 3)
        {
          boolean bool2 = localObject[0].equals("1");
          boolean bool1 = true;
          if ((!bool2) || (!localObject[1].equals("1"))) {
            bool1 = false;
          }
          WebAccelerator.d = bool1;
          if ("0".equals(localObject[3])) {}
        }
      }
    }
    try
    {
      i1 = Integer.parseInt(localObject[3]);
    }
    catch (Exception localException)
    {
      int i1;
      label106:
      break label106;
    }
    i1 = 0;
    if (!WebAccelerator.b) {
      i1 = 0;
    }
    WebAccelerator.c = i1;
    if (WebAccelerator.c == -1) {
      WebAccelerator.c = 0;
    }
  }
  
  private static int c(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
    {
      if (paramInt != 5) {}
      return 1;
    }
    return 0;
  }
  
  public static boolean c()
  {
    if (y.equalsIgnoreCase(Build.MODEL)) {
      return true;
    }
    if (x.equalsIgnoreCase(Build.MODEL)) {
      return true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append(Build.MODEL);
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
    localObject = ((StringBuilder)localObject).toString();
    String[] arrayOfString = w.split("\\|");
    int i2 = arrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (arrayOfString[i1].equalsIgnoreCase((String)localObject)) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public static boolean d()
  {
    if ((BaseActivity.sTopActivity instanceof BaseActivity))
    {
      localObject = (ChatFragment)BaseActivity.sTopActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).k();
        if (((localObject instanceof BaseTroopChatPie)) && (((BaseChatPie)localObject).bb() >= 2))
        {
          localObject = ((BaseChatPie)localObject).ae();
          break label66;
        }
      }
    }
    Object localObject = "";
    label66:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isInAIO] curPieUin = ");
    localStringBuilder.append((String)localObject);
    QLog.i("AIOUtils", 2, localStringBuilder.toString());
    return TextUtils.isEmpty((CharSequence)localObject) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOUtils
 * JD-Core Version:    0.7.0.1
 */