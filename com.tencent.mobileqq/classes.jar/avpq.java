import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenuHelper.2;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class avpq
{
  public static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences(paramContext.getPackageName() + "_preferences", 4);
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 5
    //   9: aload 5
    //   11: astore 4
    //   13: aload 6
    //   15: astore_3
    //   16: invokestatic 41	java/lang/System:currentTimeMillis	()J
    //   19: lstore_1
    //   20: aload 5
    //   22: astore 4
    //   24: aload 6
    //   26: astore_3
    //   27: new 8	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 12	java/lang/StringBuilder:<init>	()V
    //   34: ldc 43
    //   36: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 27	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: astore 7
    //   48: aload 5
    //   50: astore 4
    //   52: aload 6
    //   54: astore_3
    //   55: new 45	java/io/File
    //   58: dup
    //   59: invokestatic 51	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   62: invokevirtual 55	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   65: aload 7
    //   67: invokespecial 58	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   70: astore_0
    //   71: aload 5
    //   73: astore 4
    //   75: aload 6
    //   77: astore_3
    //   78: aload_0
    //   79: invokevirtual 62	java/io/File:isFile	()Z
    //   82: ifeq +19 -> 101
    //   85: aload 5
    //   87: astore 4
    //   89: aload 6
    //   91: astore_3
    //   92: aload_0
    //   93: invokevirtual 65	java/io/File:length	()J
    //   96: lconst_0
    //   97: lcmp
    //   98: ifne +60 -> 158
    //   101: aload 5
    //   103: astore 4
    //   105: aload 6
    //   107: astore_3
    //   108: ldc 67
    //   110: iconst_1
    //   111: new 8	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 12	java/lang/StringBuilder:<init>	()V
    //   118: ldc 69
    //   120: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_0
    //   124: invokevirtual 72	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   127: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 27	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: ldc 80
    //   138: astore_3
    //   139: aload_3
    //   140: astore_0
    //   141: iconst_0
    //   142: ifeq +11 -> 153
    //   145: new 82	java/lang/NullPointerException
    //   148: dup
    //   149: invokespecial 83	java/lang/NullPointerException:<init>	()V
    //   152: athrow
    //   153: ldc 2
    //   155: monitorexit
    //   156: aload_0
    //   157: areturn
    //   158: aload 5
    //   160: astore 4
    //   162: aload 6
    //   164: astore_3
    //   165: invokestatic 51	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   168: aload 7
    //   170: invokevirtual 87	com/tencent/common/app/BaseApplicationImpl:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   173: astore 5
    //   175: aload 5
    //   177: astore 4
    //   179: aload 5
    //   181: astore_3
    //   182: aload_0
    //   183: invokevirtual 65	java/io/File:length	()J
    //   186: l2i
    //   187: newarray byte
    //   189: astore_0
    //   190: aload 5
    //   192: astore 4
    //   194: aload 5
    //   196: astore_3
    //   197: aload 5
    //   199: aload_0
    //   200: invokevirtual 93	java/io/FileInputStream:read	([B)I
    //   203: pop
    //   204: aload 5
    //   206: astore 4
    //   208: aload 5
    //   210: astore_3
    //   211: ldc 67
    //   213: iconst_1
    //   214: new 8	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 12	java/lang/StringBuilder:<init>	()V
    //   221: ldc 95
    //   223: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokestatic 41	java/lang/System:currentTimeMillis	()J
    //   229: lload_1
    //   230: lsub
    //   231: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   234: ldc 100
    //   236: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_0
    //   240: arraylength
    //   241: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: invokevirtual 27	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: aload 5
    //   252: astore 4
    //   254: aload 5
    //   256: astore_3
    //   257: new 105	java/lang/String
    //   260: dup
    //   261: aload_0
    //   262: invokespecial 108	java/lang/String:<init>	([B)V
    //   265: astore 6
    //   267: aload 6
    //   269: astore_0
    //   270: aload 5
    //   272: ifnull -119 -> 153
    //   275: aload 5
    //   277: invokevirtual 111	java/io/FileInputStream:close	()V
    //   280: aload 6
    //   282: astore_0
    //   283: goto -130 -> 153
    //   286: astore_0
    //   287: aload 6
    //   289: astore_0
    //   290: goto -137 -> 153
    //   293: astore_0
    //   294: aload 4
    //   296: astore_3
    //   297: ldc 67
    //   299: iconst_1
    //   300: new 8	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 12	java/lang/StringBuilder:<init>	()V
    //   307: ldc 113
    //   309: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload_0
    //   313: invokevirtual 114	java/lang/Exception:toString	()Ljava/lang/String;
    //   316: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 27	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   325: aload 4
    //   327: ifnull +8 -> 335
    //   330: aload 4
    //   332: invokevirtual 111	java/io/FileInputStream:close	()V
    //   335: ldc 80
    //   337: astore_0
    //   338: goto -185 -> 153
    //   341: astore_0
    //   342: aload_3
    //   343: ifnull +7 -> 350
    //   346: aload_3
    //   347: invokevirtual 111	java/io/FileInputStream:close	()V
    //   350: aload_0
    //   351: athrow
    //   352: astore_0
    //   353: ldc 2
    //   355: monitorexit
    //   356: aload_0
    //   357: athrow
    //   358: astore_0
    //   359: aload_3
    //   360: astore_0
    //   361: goto -208 -> 153
    //   364: astore_0
    //   365: goto -30 -> 335
    //   368: astore_3
    //   369: goto -19 -> 350
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	paramString	String
    //   19	211	1	l	long
    //   15	345	3	localObject	Object
    //   368	1	3	localException	Exception
    //   11	320	4	localFileInputStream1	java.io.FileInputStream
    //   7	269	5	localFileInputStream2	java.io.FileInputStream
    //   4	284	6	str1	String
    //   46	123	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   275	280	286	java/lang/Exception
    //   16	20	293	java/lang/Exception
    //   27	48	293	java/lang/Exception
    //   55	71	293	java/lang/Exception
    //   78	85	293	java/lang/Exception
    //   92	101	293	java/lang/Exception
    //   108	136	293	java/lang/Exception
    //   165	175	293	java/lang/Exception
    //   182	190	293	java/lang/Exception
    //   197	204	293	java/lang/Exception
    //   211	250	293	java/lang/Exception
    //   257	267	293	java/lang/Exception
    //   16	20	341	finally
    //   27	48	341	finally
    //   55	71	341	finally
    //   78	85	341	finally
    //   92	101	341	finally
    //   108	136	341	finally
    //   165	175	341	finally
    //   182	190	341	finally
    //   197	204	341	finally
    //   211	250	341	finally
    //   257	267	341	finally
    //   297	325	341	finally
    //   145	153	352	finally
    //   275	280	352	finally
    //   330	335	352	finally
    //   346	350	352	finally
    //   350	352	352	finally
    //   145	153	358	java/lang/Exception
    //   330	335	364	java/lang/Exception
    //   346	350	368	java/lang/Exception
  }
  
  protected static String a(String paramString1, String paramString2)
  {
    int i;
    if ("pub_voice_clk".equals(paramString2)) {
      i = 1;
    }
    for (;;)
    {
      int j = i;
      if (i != 0)
      {
        if (!"home".equals(paramString1)) {
          break label107;
        }
        j = i;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyPublishMenuHelper", 2, "getReportD1=" + j);
        }
        return j + "";
        if ("pub_txt_clk".equals(paramString2))
        {
          i = 2;
          break;
        }
        if (!"pub_video_clk".equals(paramString2)) {
          break label128;
        }
        i = 3;
        break;
        label107:
        if ("data_card".equals(paramString1)) {
          j = i + 3;
        } else {
          j = 0;
        }
      }
      label128:
      i = 0;
    }
  }
  
  public static ArrayList<avpo> a()
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = (String)aush.a(((AppRuntime)localObject1).getAccount(), "key_nearby_publish_menu", "");
    if (!TextUtils.isEmpty((String)aush.a(((AppRuntime)localObject1).getAccount(), "cike_guide_content", ""))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPublishMenuHelper", 2, "parseMenuItems, menuCfg=" + (String)localObject2 + ", hasDialogCfg=" + bool);
      }
      for (;;)
      {
        try
        {
          localObject1 = new JSONArray((String)localObject2);
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).getJSONObject(i);
            avpo localavpo2 = new avpo();
            localavpo2.jdField_a_of_type_Int = ((JSONObject)localObject2).optInt("id");
            if ((!bool) && (localavpo2.jdField_a_of_type_Int != 1) && (localavpo2.jdField_a_of_type_Int != 2)) {
              break label337;
            }
            localavpo2.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("icon");
            localavpo2.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).optString("title");
            localavpo2.c = ((JSONObject)localObject2).optString("subTitle");
            localavpo2.d = ((JSONObject)localObject2).optString("jumpUrl");
            localArrayList.add(localavpo2);
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NearbyPublishMenuHelper", 2, "handleTakePhotoBack, exp=" + localException.toString());
          }
          if (localArrayList.size() == 0)
          {
            avpo localavpo1 = new avpo();
            localavpo1.jdField_a_of_type_Int = 1;
            localavpo1.jdField_b_of_type_Int = 2130841077;
            localavpo1.jdField_b_of_type_JavaLangString = alpo.a(2131707756);
            localArrayList.add(localavpo1);
            localavpo1 = new avpo();
            localavpo1.jdField_a_of_type_Int = 2;
            localavpo1.jdField_b_of_type_Int = 2130841076;
            localavpo1.jdField_b_of_type_JavaLangString = alpo.a(2131707757);
            localArrayList.add(localavpo1);
          }
          return localArrayList;
        }
        label337:
        i += 1;
      }
    }
  }
  
  protected static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPublishMenuHelper", 2, "selectPic");
    }
    Object localObject = null;
    if ((paramContext instanceof AppActivity)) {
      localObject = (AppActivity)paramContext;
    }
    if (localObject == null) {
      return;
    }
    localObject = new Intent(paramContext, NewPhotoListActivity.class);
    ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramContext.getClass().getName());
    ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    ((Intent)localObject).putExtra("PeakConstants.showGifTypeIcon", true);
    ((Intent)localObject).putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_MODE", true);
    ((Intent)localObject).putExtra("imageSizeLimit", 8388608);
    ((Intent)localObject).putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    ((Intent)localObject).putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    ((Intent)localObject).putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    ((Intent)localObject).putExtra("enter_from", 30);
    paramContext.startActivity((Intent)localObject);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPublishMenuHelper", 2, "onActivityResult, reqCode=" + paramInt1 + ", retCode=" + paramInt2);
    }
    if (paramInt2 == -1)
    {
      if (paramInt1 != 1001) {
        break label138;
      }
      paramIntent = a(paramContext);
      str = paramIntent.getString("camera_photo_path", "");
      QLog.d("NearbyPublishMenuHelper", 1, "camera result, path=" + str);
      paramIntent.edit().remove("camera_photo_path").commit();
      if (!TextUtils.isEmpty(str)) {
        break label128;
      }
    }
    label128:
    label138:
    while (paramInt1 != 1000)
    {
      String str;
      return;
      b(paramContext, "https://nearby.qq.com/nearby-topic/release.html?_bid=3203&from=3&getImageType=2", str);
      return;
    }
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");; paramIntent = null)
    {
      if ((paramIntent != null) && (paramIntent.size() != 0)) {
        break label189;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NearbyPublishMenuHelper", 2, "path is empty return");
      return;
    }
    label189:
    QLog.d("NearbyPublishMenuHelper", 1, "select photo result, path=" + (String)paramIntent.get(0));
    b(paramContext, "https://nearby.qq.com/nearby-topic/release.html?_bid=3203&from=3&getImageType=2", (String)paramIntent.get(0));
  }
  
  public static void a(Context paramContext, avpo paramavpo, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPublishMenuHelper", 2, "handleMenuItemClick：id=" + paramavpo.jdField_a_of_type_Int);
    }
    switch (paramavpo.jdField_a_of_type_Int)
    {
    default: 
      a(paramContext, paramavpo.d);
      return;
    case 1: 
      a(paramContext);
      return;
    case 2: 
      b(paramContext);
      return;
    case 3: 
      a(paramString, "pub_txt_clk");
      a(paramContext, paramString, "pub_txt_clk");
      return;
    case 4: 
      a(paramString, "pub_voice_clk");
      a(paramContext, paramString, "pub_voice_clk");
      return;
    }
    a(paramString, "pub_video_clk");
    a(paramContext, paramString, "pub_video_clk");
  }
  
  public static void a(Context paramContext, String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPublishMenuHelper", 2, "doJump, url=" + paramString);
      }
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (paramString.startsWith("http"))
      {
        Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
        localIntent.putExtra("url", paramString);
        syb.a(localIntent, paramString);
        paramContext.startActivity(localIntent);
        return;
      }
      if (paramString.startsWith("mqqapi"))
      {
        paramContext.startActivity(new Intent(paramContext, JumpActivity.class).setData(Uri.parse(paramString)));
        return;
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("NearbyPublishMenuHelper", 1, "doJump exp=" + paramContext.toString());
      return;
    }
    if (paramString.startsWith("tlitenow")) {
      paramContext.startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse(paramString)));
    }
  }
  
  protected static void a(Context paramContext, String paramString1, String paramString2)
  {
    aupq localaupq = aupq.a(paramContext, BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0);
    if (localaupq != null)
    {
      if (aupq.a(paramContext))
      {
        a(paramContext, localaupq.d);
        return;
      }
      localaupq.f = a(paramString1, paramString2);
      paramContext = new avph(paramContext);
      paramContext.a(localaupq);
      paramContext.show();
      return;
    }
    QLog.d("NearbyPublishMenuHelper", 1, "cikeData == null");
  }
  
  protected static void a(String paramString1, String paramString2)
  {
    new azmo(null).a("dc00899").b("grp_lbs").c(paramString1).d(paramString2).a();
  }
  
  protected static void b(Context paramContext)
  {
    if (lmm.b(BaseApplicationImpl.getContext())) {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPublishMenuHelper", 2, "Camera used return");
      }
    }
    label323:
    label328:
    for (;;)
    {
      return;
      Object localObject1 = new File(bduw.a(aljq.aX + "photo/"));
      if ((!((File)localObject1).exists()) && (!((File)localObject1).mkdirs()))
      {
        QQToast.a(paramContext, 2131719535, 0).a();
        if (QLog.isColorLevel()) {
          QLog.d("NearbyPublishMenuHelper", 2, "sdcard not exist return");
        }
      }
      else
      {
        String str = bduw.a(aljq.aX + "photo/" + System.currentTimeMillis() + ".jpg");
        Intent localIntent = new Intent();
        FileProvider7Helper.setSystemCapture(BaseApplicationImpl.getContext(), new File(str), localIntent);
        if ((paramContext instanceof AppActivity)) {}
        Object localObject2;
        for (localObject1 = (AppActivity)paramContext;; localObject2 = null)
        {
          if (localObject1 == null) {
            break label328;
          }
          if ((Build.VERSION.SDK_INT >= 23) && (((AppActivity)localObject1).checkSelfPermission("android.permission.CAMERA") != 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("NearbyPublishMenuHelper", 2, "requestPermissions");
            }
            ((AppActivity)localObject1).requestPermissions(new avpr(paramContext, str, (AppActivity)localObject1, localIntent), 1, new String[] { "android.permission.CAMERA" });
          }
          for (int i = 1;; i = 0) {
            for (;;)
            {
              if (i != 0) {
                break label323;
              }
              try
              {
                a(paramContext).edit().putString("camera_photo_path", str).commit();
                ((AppActivity)localObject1).startActivityForResult(localIntent, 1001);
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("NearbyPublishMenuHelper", 2, "takePhoto");
                return;
              }
              catch (Exception localException)
              {
                QLog.e("NearbyPublishMenuHelper", 1, localException, new Object[0]);
                QQToast.a(paramContext, 2131690645, 0).a();
                return;
              }
            }
          }
          break;
        }
      }
    }
  }
  
  protected static void b(Context paramContext, String paramString1, String paramString2)
  {
    bepp localbepp = new bepp(paramContext, paramContext.getResources().getDimensionPixelSize(2131298914));
    localbepp.c(2131694217);
    ThreadManager.post(new NearbyPublishMenuHelper.2(localbepp, paramString2, paramContext, paramString1), 5, null, true);
  }
  
  /* Error */
  public static void b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aload 7
    //   11: astore 5
    //   13: aload 6
    //   15: astore 4
    //   17: new 8	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 12	java/lang/StringBuilder:<init>	()V
    //   24: ldc 43
    //   26: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 27	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore_0
    //   37: aload 7
    //   39: astore 5
    //   41: aload 6
    //   43: astore 4
    //   45: aload_1
    //   46: invokestatic 165	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifeq +35 -> 84
    //   52: aload 7
    //   54: astore 5
    //   56: aload 6
    //   58: astore 4
    //   60: invokestatic 51	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   63: aload_0
    //   64: invokevirtual 562	com/tencent/common/app/BaseApplicationImpl:deleteFile	(Ljava/lang/String;)Z
    //   67: pop
    //   68: iconst_0
    //   69: ifeq +11 -> 80
    //   72: new 82	java/lang/NullPointerException
    //   75: dup
    //   76: invokespecial 83	java/lang/NullPointerException:<init>	()V
    //   79: athrow
    //   80: ldc 2
    //   82: monitorexit
    //   83: return
    //   84: aload 7
    //   86: astore 5
    //   88: aload 6
    //   90: astore 4
    //   92: invokestatic 41	java/lang/System:currentTimeMillis	()J
    //   95: lstore_2
    //   96: aload 7
    //   98: astore 5
    //   100: aload 6
    //   102: astore 4
    //   104: invokestatic 51	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   107: aload_0
    //   108: iconst_0
    //   109: invokevirtual 566	com/tencent/common/app/BaseApplicationImpl:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   112: astore_0
    //   113: aload_0
    //   114: astore 5
    //   116: aload_0
    //   117: astore 4
    //   119: aload_0
    //   120: aload_1
    //   121: invokevirtual 570	java/lang/String:getBytes	()[B
    //   124: invokevirtual 575	java/io/FileOutputStream:write	([B)V
    //   127: aload_0
    //   128: astore 5
    //   130: aload_0
    //   131: astore 4
    //   133: aload_0
    //   134: invokevirtual 578	java/io/FileOutputStream:flush	()V
    //   137: aload_0
    //   138: astore 5
    //   140: aload_0
    //   141: astore 4
    //   143: ldc 67
    //   145: iconst_1
    //   146: new 8	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 12	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 580
    //   156: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokestatic 41	java/lang/System:currentTimeMillis	()J
    //   162: lload_2
    //   163: lsub
    //   164: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   167: ldc 100
    //   169: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_1
    //   173: invokevirtual 581	java/lang/String:length	()I
    //   176: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   179: invokevirtual 27	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: aload_0
    //   186: ifnull -106 -> 80
    //   189: aload_0
    //   190: invokevirtual 582	java/io/FileOutputStream:close	()V
    //   193: goto -113 -> 80
    //   196: astore_0
    //   197: goto -117 -> 80
    //   200: astore_0
    //   201: aload 5
    //   203: astore 4
    //   205: ldc 67
    //   207: iconst_1
    //   208: new 8	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 12	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 584
    //   218: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload_0
    //   222: invokevirtual 114	java/lang/Exception:toString	()Ljava/lang/String;
    //   225: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 27	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aload 5
    //   236: ifnull -156 -> 80
    //   239: aload 5
    //   241: invokevirtual 582	java/io/FileOutputStream:close	()V
    //   244: goto -164 -> 80
    //   247: astore_0
    //   248: goto -168 -> 80
    //   251: astore_0
    //   252: aload 4
    //   254: ifnull +8 -> 262
    //   257: aload 4
    //   259: invokevirtual 582	java/io/FileOutputStream:close	()V
    //   262: aload_0
    //   263: athrow
    //   264: astore_0
    //   265: ldc 2
    //   267: monitorexit
    //   268: aload_0
    //   269: athrow
    //   270: astore_0
    //   271: goto -191 -> 80
    //   274: astore_1
    //   275: goto -13 -> 262
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramString1	String
    //   0	278	1	paramString2	String
    //   95	68	2	l	long
    //   15	243	4	localObject1	Object
    //   11	229	5	localObject2	Object
    //   4	97	6	localObject3	Object
    //   7	90	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   189	193	196	java/lang/Exception
    //   17	37	200	java/lang/Exception
    //   45	52	200	java/lang/Exception
    //   60	68	200	java/lang/Exception
    //   92	96	200	java/lang/Exception
    //   104	113	200	java/lang/Exception
    //   119	127	200	java/lang/Exception
    //   133	137	200	java/lang/Exception
    //   143	185	200	java/lang/Exception
    //   239	244	247	java/lang/Exception
    //   17	37	251	finally
    //   45	52	251	finally
    //   60	68	251	finally
    //   92	96	251	finally
    //   104	113	251	finally
    //   119	127	251	finally
    //   133	137	251	finally
    //   143	185	251	finally
    //   205	234	251	finally
    //   72	80	264	finally
    //   189	193	264	finally
    //   239	244	264	finally
    //   257	262	264	finally
    //   262	264	264	finally
    //   72	80	270	java/lang/Exception
    //   257	262	274	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avpq
 * JD-Core Version:    0.7.0.1
 */