import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.10;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.13;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.2;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.5;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.6;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.7;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.9;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class azey
  implements Manager
{
  public static int a;
  private static azey jdField_a_of_type_Azey;
  public static final String a;
  public static volatile boolean a;
  public static int b;
  public static String b;
  public static boolean b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  private static boolean g;
  public static String h;
  private static boolean h;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new azez(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AIOShortVideoData jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData;
  public MqqHandler a;
  private long jdField_b_of_type_Long;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private AIOShortVideoData jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData;
  int jdField_c_of_type_Int = 0;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private String i;
  
  static
  {
    jdField_a_of_type_JavaLangString = aljq.aX + "VideoRedbagRes" + File.separator;
    jdField_b_of_type_Int = 1;
    jdField_b_of_type_JavaLangString = "TemplateTips";
    jdField_c_of_type_JavaLangString = "OutRedIconVer";
    jdField_d_of_type_JavaLangString = "OutRedIconAIO";
    jdField_e_of_type_JavaLangString = "OutRedIconPreview";
    jdField_f_of_type_JavaLangString = "OutRedIconPlus1";
    jdField_g_of_type_JavaLangString = "OutRedIconPlus2";
    jdField_h_of_type_JavaLangString = "OutRedIconClose";
  }
  
  public azey(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof PeakAppInterface))
    {
      ((PeakAppInterface)paramAppInterface).jdField_a_of_type_Boolean = true;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      paramAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private RelativeLayout.LayoutParams a(CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable)
  {
    if ((paramCustomFrameAnimationDrawable != null) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      int j = paramCustomFrameAnimationDrawable.getIntrinsicWidth();
      int k = paramCustomFrameAnimationDrawable.getIntrinsicHeight();
      paramCustomFrameAnimationDrawable = new RelativeLayout.LayoutParams(aekt.a(j / 2, this.jdField_a_of_type_AndroidAppActivity.getResources()), aekt.a(k / 2, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      paramCustomFrameAnimationDrawable.addRule(12);
      paramCustomFrameAnimationDrawable.addRule(14);
      return paramCustomFrameAnimationDrawable;
    }
    return null;
  }
  
  public static azey a(AppInterface paramAppInterface)
  {
    if (jdField_a_of_type_Azey == null) {}
    try
    {
      if (jdField_a_of_type_Azey == null) {
        jdField_a_of_type_Azey = new azey(paramAppInterface);
      }
      return jdField_a_of_type_Azey;
    }
    finally {}
  }
  
  /* Error */
  private CustomFrameAnimationDrawable a(String paramString)
  {
    // Byte code:
    //   0: new 48	java/io/File
    //   3: dup
    //   4: new 32	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   11: getstatic 57	azey:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   14: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokespecial 182	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore_1
    //   28: aload_1
    //   29: invokevirtual 186	java/io/File:exists	()Z
    //   32: ifeq +220 -> 252
    //   35: aload_1
    //   36: invokevirtual 190	java/io/File:listFiles	()[Ljava/io/File;
    //   39: astore_1
    //   40: new 192	java/util/ArrayList
    //   43: dup
    //   44: invokespecial 193	java/util/ArrayList:<init>	()V
    //   47: astore 4
    //   49: aload_1
    //   50: ifnull +202 -> 252
    //   53: aload_1
    //   54: arraylength
    //   55: ifle +197 -> 252
    //   58: aload_1
    //   59: arraylength
    //   60: istore_3
    //   61: iconst_0
    //   62: istore_2
    //   63: iload_2
    //   64: iload_3
    //   65: if_icmpge +26 -> 91
    //   68: aload_1
    //   69: iload_2
    //   70: aaload
    //   71: astore 5
    //   73: aload 5
    //   75: ifnull +179 -> 254
    //   78: aload 4
    //   80: aload 5
    //   82: invokeinterface 199 2 0
    //   87: pop
    //   88: goto +166 -> 254
    //   91: aload 4
    //   93: invokeinterface 202 1 0
    //   98: iconst_1
    //   99: if_icmple +129 -> 228
    //   102: aload 4
    //   104: invokestatic 208	java/util/Collections:sort	(Ljava/util/List;)V
    //   107: new 210	android/graphics/BitmapFactory$Options
    //   110: dup
    //   111: invokespecial 211	android/graphics/BitmapFactory$Options:<init>	()V
    //   114: astore_1
    //   115: aload_1
    //   116: iconst_1
    //   117: putfield 214	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   120: aload_1
    //   121: iconst_1
    //   122: putfield 217	android/graphics/BitmapFactory$Options:inMutable	Z
    //   125: aload 4
    //   127: ifnull +125 -> 252
    //   130: aload 4
    //   132: invokeinterface 202 1 0
    //   137: ifle +115 -> 252
    //   140: aload 4
    //   142: iconst_0
    //   143: invokeinterface 221 2 0
    //   148: checkcast 48	java/io/File
    //   151: invokevirtual 224	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   154: aload_1
    //   155: invokestatic 229	bdda:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   158: astore_1
    //   159: new 140	com/tencent/mobileqq/activity/aio/item/CustomFrameAnimationDrawable
    //   162: dup
    //   163: invokestatic 232	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   166: invokevirtual 233	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   169: aload_1
    //   170: aload_0
    //   171: getfield 235	azey:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   174: invokespecial 238	com/tencent/mobileqq/activity/aio/item/CustomFrameAnimationDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Lmqq/os/MqqHandler;)V
    //   177: astore_1
    //   178: iconst_0
    //   179: istore_2
    //   180: iload_2
    //   181: aload 4
    //   183: invokeinterface 202 1 0
    //   188: if_icmpge +62 -> 250
    //   191: aload 4
    //   193: iload_2
    //   194: invokeinterface 221 2 0
    //   199: checkcast 48	java/io/File
    //   202: astore 5
    //   204: aload 5
    //   206: ifnull +15 -> 221
    //   209: aload_1
    //   210: iload_2
    //   211: bipush 40
    //   213: aload 5
    //   215: invokevirtual 224	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   218: invokevirtual 241	com/tencent/mobileqq/activity/aio/item/CustomFrameAnimationDrawable:a	(IILjava/lang/String;)V
    //   221: iload_2
    //   222: iconst_1
    //   223: iadd
    //   224: istore_2
    //   225: goto -45 -> 180
    //   228: invokestatic 243	azey:c	()V
    //   231: goto -124 -> 107
    //   234: astore 4
    //   236: aconst_null
    //   237: astore_1
    //   238: aload 4
    //   240: invokevirtual 246	java/lang/Exception:printStackTrace	()V
    //   243: aload_1
    //   244: areturn
    //   245: astore 4
    //   247: goto -9 -> 238
    //   250: aload_1
    //   251: areturn
    //   252: aconst_null
    //   253: areturn
    //   254: iload_2
    //   255: iconst_1
    //   256: iadd
    //   257: istore_2
    //   258: goto -195 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	azey
    //   0	261	1	paramString	String
    //   62	196	2	j	int
    //   60	6	3	k	int
    //   47	145	4	localArrayList	ArrayList
    //   234	5	4	localException1	Exception
    //   245	1	4	localException2	Exception
    //   71	143	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	49	234	java/lang/Exception
    //   53	61	234	java/lang/Exception
    //   78	88	234	java/lang/Exception
    //   91	107	234	java/lang/Exception
    //   107	125	234	java/lang/Exception
    //   130	178	234	java/lang/Exception
    //   228	231	234	java/lang/Exception
    //   180	204	245	java/lang/Exception
    //   209	221	245	java/lang/Exception
  }
  
  public static void a(Intent paramIntent, Activity paramActivity)
  {
    if ((paramIntent == null) || (paramActivity == null)) {}
    while (!paramIntent.getBooleanExtra("open_chatfragment", false)) {
      return;
    }
    ajgm.a(paramActivity, paramIntent);
  }
  
  public static void a(View paramView, afwt paramafwt, ChatMessage paramChatMessage, Context paramContext)
  {
    if ((paramView == null) || (paramChatMessage == null) || (!(paramView instanceof RelativeLayout)) || (!(paramChatMessage instanceof MessageForShortVideo))) {}
    label213:
    label510:
    for (;;)
    {
      return;
      paramChatMessage = (MessageForShortVideo)paramChatMessage;
      int j;
      if (paramChatMessage.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
        if (paramChatMessage.isSend()) {
          if (paramChatMessage.redBagStat == 0) {
            j = 1;
          }
        }
      }
      for (;;)
      {
        if (paramafwt.f == j) {
          break label510;
        }
        paramafwt.f = j;
        if (j != 0)
        {
          if (paramView.findViewById(2131373415) != null)
          {
            paramView.findViewById(2131373414).setVisibility(0);
            paramafwt = (ImageView)paramView.findViewById(2131373415);
            if (j == 1) {
              paramafwt.setImageResource(2130849112);
            }
            for (;;)
            {
              paramafwt.setVisibility(0);
              paramView = (RelativeLayout.LayoutParams)((ImageView)paramView.findViewById(2131373414)).getLayoutParams();
              if (!paramChatMessage.isSend()) {
                break label213;
              }
              paramView.rightMargin = aekt.a(6.0F, paramContext.getResources());
              paramView.leftMargin = 0;
              return;
              j = 2;
              break;
              j = 3;
              break;
              if (j == 2) {
                paramafwt.setImageResource(2130849113);
              } else if (j == 3) {
                paramafwt.setImageResource(2130849111);
              }
            }
            paramView.rightMargin = 0;
            paramView.leftMargin = aekt.a(6.0F, paramContext.getResources());
            return;
          }
          paramafwt = new ImageView(paramContext);
          paramafwt.setBackgroundDrawable(paramContext.getResources().getDrawable(2130849110));
          paramafwt.setId(2131373414);
          paramafwt.setVisibility(0);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, aekt.a(70.0F, paramContext.getResources()));
          localLayoutParams.addRule(7, 2131371925);
          localLayoutParams.addRule(8, 2131371925);
          if (paramChatMessage.isSend())
          {
            localLayoutParams.rightMargin = aekt.a(6.0F, paramContext.getResources());
            localLayoutParams.leftMargin = 0;
            ((RelativeLayout)paramView).addView(paramafwt, localLayoutParams);
            paramafwt = new ImageView(paramContext);
            if (j != 1) {
              break label441;
            }
            paramafwt.setImageResource(2130849112);
          }
          for (;;)
          {
            paramafwt.setId(2131373415);
            paramafwt.setVisibility(0);
            paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
            paramChatMessage.addRule(8, 2131371925);
            paramChatMessage.addRule(14);
            ((RelativeLayout)paramView).addView(paramafwt, paramChatMessage);
            return;
            localLayoutParams.rightMargin = 0;
            localLayoutParams.leftMargin = aekt.a(6.0F, paramContext.getResources());
            break;
            if (j == 2) {
              paramafwt.setImageResource(2130849113);
            } else if (j == 3) {
              paramafwt.setImageResource(2130849111);
            }
          }
        }
        if (paramView.findViewById(2131373415) == null) {
          break;
        }
        paramView.findViewById(2131373415).setVisibility(4);
        paramView.findViewById(2131373414).setVisibility(4);
        return;
        j = 0;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), azfi.class);
    localNewIntent.putExtra("action", 1);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((!paramBoolean) && (jdField_b_of_type_Boolean)) {
      return;
    }
    jdField_b_of_type_Boolean = true;
    ThreadManager.post(new RedBagVideoManager.2(paramQQAppInterface), 5, null, true);
  }
  
  public static void a(String paramString)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    String str = localAppRuntime.getAccount();
    localAppRuntime.getApplication().getSharedPreferences(jdField_b_of_type_JavaLangString, 4).edit().putBoolean(paramString + str, true).commit();
    if (QLog.isColorLevel()) {
      QLog.d("RedBagVideoManager", 4, new Object[] { "updateRedBagEntranceStat, entranceType:", paramString });
    }
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = BaseApplicationImpl.sApplication.getRuntime();
      String str = ((AppRuntime)localObject).getAccount();
      localObject = ((AppRuntime)localObject).getApplication().getSharedPreferences(jdField_b_of_type_JavaLangString, 4);
      SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
      if ((paramJSONObject.has("outRedIconShow")) && (paramJSONObject.has("outRedIconVer")) && (paramJSONObject.getInt("outRedIconShow") == 1))
      {
        int j = ((SharedPreferences)localObject).getInt(jdField_c_of_type_JavaLangString, -1);
        int k = paramJSONObject.getInt("outRedIconVer");
        if (k > j)
        {
          localEditor.putBoolean(jdField_d_of_type_JavaLangString + str, false);
          localEditor.putBoolean(jdField_e_of_type_JavaLangString + str, false);
          localEditor.putBoolean(jdField_f_of_type_JavaLangString + str, false);
          localEditor.putBoolean(jdField_g_of_type_JavaLangString + str, false);
          localEditor.putInt(jdField_c_of_type_JavaLangString + str, k);
          localEditor.putInt(jdField_c_of_type_JavaLangString, k);
          localEditor.remove(jdField_h_of_type_JavaLangString);
          localEditor.commit();
        }
      }
      else if (((SharedPreferences)localObject).getInt(jdField_c_of_type_JavaLangString, -1) > -1)
      {
        localEditor.putBoolean(jdField_h_of_type_JavaLangString, true);
        localEditor.commit();
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("RedBagVideoManager", 1, "checkRedBagEntranceConfig, ", paramJSONObject);
    }
  }
  
  public static boolean a()
  {
    if (!jdField_h_of_type_Boolean)
    {
      jdField_h_of_type_Boolean = true;
      bool1 = axld.a();
      boolean bool2 = azgk.c();
      if ((!bool1) || (!bool2)) {
        break label61;
      }
    }
    label61:
    for (boolean bool1 = true;; bool1 = false)
    {
      jdField_g_of_type_Boolean = bool1;
      QLog.d("RedBagVideoManager", 1, new Object[] { "RedBagVideoManager init, support: ", Boolean.valueOf(jdField_g_of_type_Boolean) });
      return jdField_g_of_type_Boolean;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 10000) || (paramInt == 10007) || (paramInt == 10003) || (paramInt == 10004);
  }
  
  public static boolean a(String paramString)
  {
    if (!a()) {
      QLog.d("RedBagVideoManager", 1, "checkRedBagEntranceConfig, not support");
    }
    SharedPreferences localSharedPreferences;
    do
    {
      return true;
      localObject = BaseApplicationImpl.sApplication.getRuntime();
      localSharedPreferences = ((AppRuntime)localObject).getApplication().getSharedPreferences(jdField_b_of_type_JavaLangString, 4);
    } while (localSharedPreferences.contains(jdField_h_of_type_JavaLangString));
    Object localObject = ((AppRuntime)localObject).getAccount();
    int j = localSharedPreferences.getInt(jdField_c_of_type_JavaLangString, -1);
    if (localSharedPreferences.getInt(jdField_c_of_type_JavaLangString + (String)localObject, -1) != j)
    {
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      localEditor.putBoolean(jdField_d_of_type_JavaLangString + (String)localObject, false);
      localEditor.putBoolean(jdField_e_of_type_JavaLangString + (String)localObject, false);
      localEditor.putBoolean(jdField_f_of_type_JavaLangString + (String)localObject, false);
      localEditor.putBoolean(jdField_g_of_type_JavaLangString + (String)localObject, false);
      localEditor.putInt(jdField_c_of_type_JavaLangString + (String)localObject, j);
      localEditor.commit();
    }
    return localSharedPreferences.getBoolean(paramString + (String)localObject, true);
  }
  
  private static String b(String paramString)
  {
    try
    {
      str1 = awiz.a(paramString);
      paramString = str1;
      str1 = paramString;
      if (paramString == null) {
        str1 = "";
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      String str1;
      paramString = new File(paramString);
      bool = paramString.exists();
      if (!bool) {
        break label81;
      }
      for (;;)
      {
        try
        {
          paramString = bhli.a(paramString);
          if (paramString == null) {
            continue;
          }
        }
        catch (IOException paramString)
        {
          paramString = null;
          continue;
        }
        str2 = paramString;
        if (paramString != null) {
          break;
        }
        return "";
        paramString = "";
      }
    }
    finally
    {
      if (0 != 0) {
        break label79;
      }
      return "";
      label79:
      return null;
    }
    return str1;
    for (;;)
    {
      boolean bool;
      String str2;
      label81:
      paramString = null;
    }
  }
  
  private void b(AIOShortVideoData paramAIOShortVideoData)
  {
    if (paramAIOShortVideoData == null) {
      return;
    }
    if (paramAIOShortVideoData.h == 0)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData = paramAIOShortVideoData;
      new azfg(this).execute(new String[] { paramAIOShortVideoData.jdField_c_of_type_JavaLangString });
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      if (!this.jdField_e_of_type_Boolean) {
        n();
      }
    }
  }
  
  private static boolean b(String paramString, QQAppInterface paramQQAppInterface)
  {
    File localFile = new File(jdField_a_of_type_JavaLangString);
    if (localFile.exists())
    {
      if (!localFile.isDirectory()) {
        localFile.delete();
      }
    }
    else {
      return false;
    }
    if (bdiv.c(paramQQAppInterface.getApp()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedBagVideoManager", 2, "checkLocalResFiles : isResDamaged !");
      }
      bdcs.a(jdField_a_of_type_JavaLangString, false);
      return false;
    }
    if ((localFile.listFiles() == null) || (localFile.listFiles().length == 0))
    {
      bdcs.a(jdField_a_of_type_JavaLangString, false);
      return false;
    }
    paramQQAppInterface = new File(jdField_a_of_type_JavaLangString + "videoRedbagResInfo");
    if ((paramQQAppInterface.exists()) && (!paramQQAppInterface.isDirectory()))
    {
      try
      {
        paramQQAppInterface = bdcs.b(paramQQAppInterface);
        if ((QLog.isColorLevel()) && (paramString != null) && (paramQQAppInterface != null)) {
          QLog.d("RedBagVideoManager", 2, "checkLocalResFiles: md5Record = " + paramQQAppInterface + ", md5 = " + paramString);
        }
        if ((paramQQAppInterface == null) || (paramString == null) || (paramQQAppInterface.length() == 0) || (paramString.length() == 0) || (!paramString.equals(paramQQAppInterface)))
        {
          bdcs.a(jdField_a_of_type_JavaLangString, false);
          return false;
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        bdcs.a(jdField_a_of_type_JavaLangString, false);
        return false;
      }
      return true;
    }
    bdcs.a(jdField_a_of_type_JavaLangString, false);
    return false;
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!paramString1.exists()) {}
    try
    {
      paramString1.createNewFile();
      bool1 = bool2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          label39:
          paramString1.close();
          return bool2;
        }
        catch (IOException paramString1) {}
        localIOException = localIOException;
        bool1 = false;
      }
    }
    try
    {
      paramString1 = new FileOutputStream(paramString1, false);
      bool2 = bool1;
    }
    catch (FileNotFoundException paramString1)
    {
      bool2 = false;
      paramString1 = null;
      break label39;
    }
    bool1 = bool2;
    if (paramString1 != null) {}
    try
    {
      paramString1.write(paramString2.getBytes());
      bool1 = bool2;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        bool1 = false;
      }
    }
    bool2 = bool1;
    if (paramString1 != null) {}
    try
    {
      paramString1.flush();
      bool2 = bool1;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        bool2 = false;
      }
    }
    if (paramString1 != null) {}
    return false;
  }
  
  public static void c()
  {
    try
    {
      if (!jdField_a_of_type_Boolean) {
        bdiv.e(BaseApplication.getContext(), true);
      }
      return;
    }
    finally {}
  }
  
  private void c(AIOShortVideoData paramAIOShortVideoData)
  {
    if (paramAIOShortVideoData == null) {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130849114);
      this.jdField_c_of_type_AndroidWidgetImageView.getBackground().setAlpha(255);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if (paramAIOShortVideoData.h == 0)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849123);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      g();
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      paramAIOShortVideoData = a("host_shang");
      if (paramAIOShortVideoData == null) {
        break label207;
      }
      paramAIOShortVideoData.h();
      paramAIOShortVideoData.a();
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramAIOShortVideoData);
      if (a(paramAIOShortVideoData) != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(a(paramAIOShortVideoData));
      }
      paramAIOShortVideoData.c();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler();
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RedBagVideoManager.7(this), 120L);
      break;
      label207:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849124);
      c();
    }
  }
  
  private static void c(String paramString)
  {
    String str = jdField_a_of_type_JavaLangString;
    try
    {
      bdcs.a(paramString, str, false);
      if (QLog.isColorLevel()) {
        QLog.d("RedBagVideoManager", 2, "[unzip] success: " + paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("RedBagVideoManager", 2, "[unzip]", paramString);
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null)) {}
    Object localObject;
    do
    {
      for (;;)
      {
        return;
        localObject = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString().trim();
        if (!alpo.a(2131713669).trim().equals(localObject)) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.i == 0) {
          ajlj.b("", "0X8008CEE");
        }
        while (this.jdField_a_of_type_AndroidAppActivity != null)
        {
          localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("https://mqq.tenpay.com/mqq/hongbao/video.html?fid=");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_c_of_type_JavaLangString);
          localStringBuilder.append("&_wv=2098179&_wvNb=e62555&_wvNt=FFFFFF&_wvSb=1");
          ((Intent)localObject).putExtra("url", localStringBuilder.toString());
          this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
          return;
          ajlj.b("", "0X8008CEF");
        }
      }
    } while (!alpo.a(2131713667).trim().equals(localObject));
    ajlj.b("", "0X80088E6");
    j();
    a();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    }
  }
  
  private void f()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      return;
    }
    CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = a("host_lights");
    if (localCustomFrameAnimationDrawable != null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localCustomFrameAnimationDrawable);
      if (a(localCustomFrameAnimationDrawable) != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(a(localCustomFrameAnimationDrawable));
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      localCustomFrameAnimationDrawable.c();
      return;
    }
    c();
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131713666));
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131166863));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130849115, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(5);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.bringToFront();
      ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetTextView, "alpha", new float[] { 0.0F, 1.0F }).setDuration(180L).start();
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131713670));
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFF68987"));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.bringToFront();
      ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetTextView, "alpha", new float[] { 0.0F, 1.0F }).setDuration(180L).start();
    }
  }
  
  private void i()
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130849114);
      this.jdField_c_of_type_AndroidWidgetImageView.getBackground().setAlpha(255);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      ObjectAnimator.ofFloat(this.jdField_c_of_type_AndroidWidgetImageView.getBackground(), "alpha", new float[] { 0.53F, 1.0F }).setDuration(180L).start();
    }
    CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = a("guest_chuchang");
    if (localCustomFrameAnimationDrawable != null)
    {
      localCustomFrameAnimationDrawable.h();
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localCustomFrameAnimationDrawable);
      if (a(localCustomFrameAnimationDrawable) != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(a(localCustomFrameAnimationDrawable));
      }
      localCustomFrameAnimationDrawable.c();
      localCustomFrameAnimationDrawable.a(new azff(this));
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler();
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RedBagVideoManager.9(this), 880L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler();
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RedBagVideoManager.10(this), 1120L);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849118);
      k();
      c();
    }
  }
  
  private void j()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849118);
    k();
    m();
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidAppActivity == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131713668));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131166864));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(16.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(aekt.a(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), aekt.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), aekt.a(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), aekt.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130849119);
    this.jdField_a_of_type_AndroidWidgetTextView.bringToFront();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetTextView, "alpha", new float[] { 0.0F, 1.0F }).setDuration(180L).start();
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = a("guest_changzhu");
    if (localCustomFrameAnimationDrawable != null)
    {
      localCustomFrameAnimationDrawable.h();
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localCustomFrameAnimationDrawable);
      if (a(localCustomFrameAnimationDrawable) != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(a(localCustomFrameAnimationDrawable));
      }
      localCustomFrameAnimationDrawable.c();
      this.jdField_c_of_type_Int = 0;
      localCustomFrameAnimationDrawable.a(new azfa(this, localCustomFrameAnimationDrawable));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849118);
    c();
  }
  
  private void m()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      return;
    }
    CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = a("guest_lights");
    if (localCustomFrameAnimationDrawable != null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localCustomFrameAnimationDrawable);
      if (a(localCustomFrameAnimationDrawable) != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(a(localCustomFrameAnimationDrawable));
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      localCustomFrameAnimationDrawable.c();
      return;
    }
    c();
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130849114);
      this.jdField_c_of_type_AndroidWidgetImageView.getBackground().setAlpha(255);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_e_of_type_Boolean = true;
    CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = a("guest_yidashang");
    if (localCustomFrameAnimationDrawable != null)
    {
      localCustomFrameAnimationDrawable.h();
      localCustomFrameAnimationDrawable.a();
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localCustomFrameAnimationDrawable);
      if (a(localCustomFrameAnimationDrawable) != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(a(localCustomFrameAnimationDrawable));
      }
      localCustomFrameAnimationDrawable.c();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      h();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849122);
      c();
    }
  }
  
  public ImageView a(Activity paramActivity, ViewGroup paramViewGroup, String paramString)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.i = paramString;
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("RedBagVideoManager");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    paramString = new ImageView(paramActivity);
    paramString.setId(2131373465);
    Object localObject = new RelativeLayout.LayoutParams(-1, aekt.a(180.0F, paramActivity.getResources()));
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    paramViewGroup.addView(paramString, (ViewGroup.LayoutParams)localObject);
    this.jdField_c_of_type_AndroidWidgetImageView = paramString;
    paramString = new ImageView(paramActivity);
    paramString.setId(2131373468);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    paramViewGroup.addView(paramString, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView = paramString;
    paramString.setOnTouchListener(new azfd(this));
    localObject = new ImageView(paramActivity);
    ((ImageView)localObject).setId(2131373467);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(14);
    paramViewGroup.addView((View)localObject, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject);
    localObject = new TextView(paramActivity);
    ((TextView)localObject).setId(2131373466);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(14);
    localLayoutParams.bottomMargin = aekt.a(10.0F, paramActivity.getResources());
    paramViewGroup.addView((View)localObject, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    ((TextView)localObject).bringToFront();
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new azfe(this));
    e();
    return paramString;
  }
  
  public void a()
  {
    ThreadManager.post(new RedBagVideoManager.5(this), 5, null, true);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == -1)
    {
      this.jdField_f_of_type_Boolean = true;
      ajlj.b("", "0X80088E7");
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = a("guest_send");
      if ((localCustomFrameAnimationDrawable == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {
        break label131;
      }
      localCustomFrameAnimationDrawable.h();
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localCustomFrameAnimationDrawable);
      if (a(localCustomFrameAnimationDrawable) != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(a(localCustomFrameAnimationDrawable));
      }
      localCustomFrameAnimationDrawable.c();
      localCustomFrameAnimationDrawable.a(new azfb(this));
    }
    for (;;)
    {
      ThreadManager.post(new RedBagVideoManager.13(this), 5, null, true);
      return;
      label131:
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849122);
      }
      this.jdField_f_of_type_Boolean = false;
      c();
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("RedBagVideoManager", 2, "jumpToVideoPreview");
      }
      Bundle localBundle = bkik.a(null, paramActivity.getClass().getName(), 10004, 8);
      xlb.a().a(paramActivity, localBundle, 9010);
    }
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    String str1 = ((AppRuntime)localObject).getAccount();
    String str2 = ((TicketManager)((AppRuntime)localObject).getManager(2)).getSkey(str1);
    if (str2 == null)
    {
      QLog.e("RedBagVideoManager", 1, "gotoRedbag, skey is null");
      return;
    }
    int j;
    if (paramInt == 1) {
      j = 3;
    }
    for (;;)
    {
      localObject = new JSONObject();
      for (;;)
      {
        try
        {
          ((JSONObject)localObject).put("skey", str2);
          ((JSONObject)localObject).put("skey_type", 2);
          if ((paramInt != 1) && (paramInt != 3000)) {
            continue;
          }
          ((JSONObject)localObject).put("recv_uin", paramString5);
          ((JSONObject)localObject).put("grab_uin_list", paramString1);
          ((JSONObject)localObject).put("recv_name", paramString2);
          ((JSONObject)localObject).put("bus_type", 1);
          ((JSONObject)localObject).put("channel", 32768);
          ((JSONObject)localObject).put("feedsid", paramString4);
          ((JSONObject)localObject).put("recv_type", j);
          ((JSONObject)localObject).put("hb_from", "video_reward");
        }
        catch (JSONException paramString1)
        {
          paramString1.printStackTrace();
          continue;
          j = 1;
        }
        paramString1 = new Intent(paramActivity, SendHbActivity.class);
        paramString1.putExtra("userId", str1);
        if (paramString3 != null) {
          paramString1.putExtra("userName", paramString3);
        }
        paramString1.putExtra("app_info", "appid#0|bargainor_id#0|channel#spredpacket");
        paramString1.putExtra("come_from", 2);
        paramString1.putExtra("extra_data", ((JSONObject)localObject).toString());
        paramString1.setFlags(536870912);
        paramActivity.startActivityForResult(paramString1, 10002);
        return;
        if (paramInt != 3000) {
          continue;
        }
        j = 2;
        break;
        ((JSONObject)localObject).put("recv_uin", paramString1);
      }
    }
  }
  
  public void a(AppInterface paramAppInterface)
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedBagVideoManager", 4, "onDestroy");
      }
      paramAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
  }
  
  public void a(AIORichMediaData paramAIORichMediaData)
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (paramAIORichMediaData == null)) {}
    do
    {
      do
      {
        return;
        if (!(paramAIORichMediaData instanceof AIOShortVideoData)) {
          break label73;
        }
        paramAIORichMediaData = (AIOShortVideoData)paramAIORichMediaData;
        if (paramAIORichMediaData.e != LocalMediaInfo.REDBAG_TYPE_GET) {
          break label73;
        }
        if (paramAIORichMediaData.i != 0) {
          break;
        }
      } while ((paramAIORichMediaData.h == 0) || (this.jdField_e_of_type_Boolean));
      n();
      return;
    } while (this.jdField_d_of_type_Boolean);
    c(paramAIORichMediaData);
    return;
    label73:
    e();
  }
  
  public void a(AIOShortVideoData paramAIOShortVideoData)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(null);
    }
    e();
    if (paramAIOShortVideoData != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData = paramAIOShortVideoData;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      paramString2 = VideoRedbagData.queryRewardMsgUniseq(paramString2);
      if (!paramString2.isEmpty())
      {
        paramString2 = paramString2.iterator();
        while (paramString2.hasNext())
        {
          long l = ((Long)paramString2.next()).longValue();
          MessageRecord localMessageRecord = ((QQAppInterface)localObject).a().b(paramString1, paramInt, l);
          if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForShortVideo)))
          {
            MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
            if (localMessageForShortVideo.redBagStat == 0)
            {
              localMessageForShortVideo.redBagStat = 1;
              localMessageForShortVideo.serial();
              ((QQAppInterface)localObject).a().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq, localMessageRecord.msgData);
            }
          }
        }
      }
    }
  }
  
  public void b()
  {
    e();
    try
    {
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_a_of_type_AndroidOsHandlerThread != null) {
        this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
    }
    catch (Exception localException)
    {
      label49:
      break label49;
    }
    this.jdField_a_of_type_AndroidOsHandlerThread = null;
    this.jdField_a_of_type_MqqOsMqqHandler = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.i = null;
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetImageView = null;
    this.jdField_c_of_type_AndroidWidgetImageView = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
  }
  
  public void b(AIORichMediaData paramAIORichMediaData)
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (paramAIORichMediaData == null)) {}
    while (this.jdField_f_of_type_Boolean) {
      return;
    }
    if ((paramAIORichMediaData instanceof AIOShortVideoData))
    {
      AIOShortVideoData localAIOShortVideoData = (AIOShortVideoData)paramAIORichMediaData;
      if (localAIOShortVideoData.e == LocalMediaInfo.REDBAG_TYPE_GET)
      {
        if (localAIOShortVideoData.i > 0) {
          c(localAIOShortVideoData);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_AndroidOsHandler == null) {
            this.jdField_a_of_type_AndroidOsHandler = new Handler();
          }
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RedBagVideoManager.6(this, paramAIORichMediaData), localAIOShortVideoData.a * 1000);
          return;
          b(localAIOShortVideoData);
        }
      }
    }
    e();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azey
 * JD-Core Version:    0.7.0.1
 */