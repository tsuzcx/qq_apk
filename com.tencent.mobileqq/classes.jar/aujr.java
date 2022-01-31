import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.content.FileProvider;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class aujr
  implements AdapterView.OnItemClickListener, auqb
{
  public static String a;
  public static String b = "0X8007F0A ";
  public static String c = "0X8007F0B ";
  public static String d = "0X8007F0C ";
  public static String e = "0X8007F0D ";
  public static String f = "0X8007F0E ";
  public static String g = "0X8007F0F ";
  public static String h = "0X8007F10 ";
  public static String i = "0X800A77E";
  private static String j;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  bfah jdField_a_of_type_Bfah;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected ShareActionSheetBuilder a;
  protected MqqHandler a;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = alof.aX + "TempMail" + File.separator;
    j = alud.a(2131700507);
  }
  
  public aujr(QQAppInterface paramQQAppInterface, Context paramContext, Activity paramActivity, BaseChatPie paramBaseChatPie, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public static String a(MessageForPic paramMessageForPic)
  {
    URL localURL = bayu.a(paramMessageForPic, 131075);
    if (baqn.a(localURL.toString()) != null) {
      return baqn.d(localURL.toString());
    }
    localURL = bayu.a(paramMessageForPic, 1);
    if (baqn.a(localURL.toString()) != null) {
      return baqn.d(localURL.toString());
    }
    paramMessageForPic = bayu.a(paramMessageForPic, 65537);
    if (baqn.a(paramMessageForPic.toString()) != null) {
      return baqn.d(paramMessageForPic.toString());
    }
    return null;
  }
  
  public static String a(MessageForPic paramMessageForPic, List<String> paramList1, List<String> paramList2)
  {
    String str1 = a(paramMessageForPic);
    if (str1 == null)
    {
      QLog.e("AIOShareActionSheet", 1, new Object[] { "getPicMsgPath null, ", paramMessageForPic.getUserLogString() });
      return null;
    }
    paramList1.add(str1);
    String str2 = new File(str1).getName();
    paramMessageForPic = "";
    if (str2.indexOf(".") == -1) {
      paramMessageForPic = bdhb.b(str1);
    }
    paramMessageForPic = alud.a(2131700511) + paramList1.size() + "." + paramMessageForPic;
    paramList1 = paramMessageForPic + alud.a(2131700506);
    paramList2.add(paramMessageForPic);
    return paramList1;
  }
  
  public Uri a(String paramString)
  {
    paramString = new File(jdField_a_of_type_JavaLangString + paramString);
    if (Build.VERSION.SDK_INT >= 24) {
      return FileProvider.getUriForFile(this.jdField_a_of_type_AndroidContentContext, "com.tencent.mobileqq.fileprovider", paramString);
    }
    return Uri.fromFile(paramString);
  }
  
  public String a(MessageForStructing paramMessageForStructing)
  {
    String str = paramMessageForStructing.getSummaryMsg();
    if ((paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))
    {
      Object localObject2 = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
      paramMessageForStructing = ((StructMsgForGeneralShare)localObject2).mContentSummary;
      Object localObject1 = paramMessageForStructing;
      if (paramMessageForStructing == null)
      {
        localObject1 = paramMessageForStructing;
        if (((StructMsgForGeneralShare)localObject2).mStructMsgItemLists != null)
        {
          localObject2 = ((StructMsgForGeneralShare)localObject2).mStructMsgItemLists.iterator();
          for (;;)
          {
            localObject1 = paramMessageForStructing;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            Object localObject3 = (azus)((Iterator)localObject2).next();
            localObject1 = paramMessageForStructing;
            if ((localObject3 instanceof azxl))
            {
              localObject3 = (azxl)localObject3;
              localObject1 = paramMessageForStructing;
              if (((azxl)localObject3).a != null)
              {
                localObject3 = ((azxl)localObject3).a.iterator();
                for (;;)
                {
                  localObject1 = paramMessageForStructing;
                  if (!((Iterator)localObject3).hasNext()) {
                    break;
                  }
                  localObject1 = (azus)((Iterator)localObject3).next();
                  if ((localObject1 instanceof azzm)) {
                    paramMessageForStructing = ((azzm)localObject1).Y;
                  }
                }
              }
            }
            paramMessageForStructing = (MessageForStructing)localObject1;
          }
        }
      }
      if (localObject1 != null) {
        return str + (String)localObject1;
      }
    }
    return str;
  }
  
  public void a() {}
  
  public void a(aupy paramaupy) {}
  
  public void a(aupy paramaupy, int paramInt) {}
  
  public void a(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList)
  {
    if (paramArrayList.isEmpty()) {}
    Intent localIntent;
    label302:
    do
    {
      for (;;)
      {
        return;
        localIntent = new Intent("android.intent.action.SEND_MULTIPLE");
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_ac");
        localIntent.setType("message/rfc822");
        a(paramMap, paramArrayList, localIntent);
        for (;;)
        {
          Object localObject;
          try
          {
            paramArrayList = this.jdField_a_of_type_AndroidContentContext.getPackageManager().queryIntentActivities(localIntent, 0);
            if (paramArrayList.isEmpty()) {
              break;
            }
            paramMap = new ArrayList();
            paramArrayList = paramArrayList.iterator();
            if (!paramArrayList.hasNext()) {
              break label302;
            }
            localObject = (ResolveInfo)paramArrayList.next();
            if ((!((ResolveInfo)localObject).activityInfo.packageName.toLowerCase().contains("mail")) && (!((ResolveInfo)localObject).activityInfo.name.toLowerCase().contains("mail"))) {
              continue;
            }
            if (((ResolveInfo)localObject).activityInfo.packageName.equals("com.tencent.androidqqmail"))
            {
              if (((ResolveInfo)localObject).activityInfo.name.contains("LaunchComposeNote")) {
                continue;
              }
              localObject = new ComponentName(((ResolveInfo)localObject).activityInfo.applicationInfo.packageName, ((ResolveInfo)localObject).activityInfo.name);
              localIntent.setPackage(null);
              localIntent.setComponent((ComponentName)localObject);
              paramMap.add((Intent)localIntent.clone());
              continue;
            }
            if (((ResolveInfo)localObject).activityInfo.packageName.contains("bluetooth")) {
              continue;
            }
          }
          catch (Exception paramMap)
          {
            QLog.e("AIOShareActionSheet", 1, "realSendToMail error_2, ", paramMap);
            return;
          }
          if (!((ResolveInfo)localObject).activityInfo.name.contains("bluetooth"))
          {
            localIntent.setComponent(null);
            localIntent.setPackage(((ResolveInfo)localObject).activityInfo.packageName);
          }
        }
        try
        {
          paramArrayList = Intent.createChooser((Intent)paramMap.remove(0), alud.a(2131700505));
          if (paramArrayList != null)
          {
            paramArrayList.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])paramMap.toArray(new Parcelable[0]));
            paramArrayList.putExtra("big_brother_source_key", "biz_src_jc_ac");
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramArrayList);
            return;
          }
        }
        catch (Exception paramMap)
        {
          QLog.e("AIOShareActionSheet", 1, "realSendToMail error_1, ", paramMap);
        }
      }
    } while (!(paramMap instanceof ClassCastException));
    paramMap = new ArrayList();
    paramMap.add(localIntent.getCharSequenceExtra("android.intent.extra.TEXT"));
    localIntent.removeExtra("android.intent.extra.TEXT");
    localIntent.putCharSequenceArrayListExtra("android.intent.extra.TEXT", paramMap);
    this.jdField_a_of_type_AndroidContentContext.startActivity(Intent.createChooser(localIntent, alud.a(2131700503)));
  }
  
  /* Error */
  public void a(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokevirtual 409	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   5: checkcast 411	com/tencent/mobileqq/data/ChatMessage
    //   8: astore 6
    //   10: ldc 161
    //   12: astore 5
    //   14: aload 6
    //   16: getfield 414	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   19: ifne +725 -> 744
    //   22: aload_0
    //   23: getfield 103	aujr:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   26: ldc_w 415
    //   29: invokevirtual 418	android/content/Context:getString	(I)Ljava/lang/String;
    //   32: iconst_2
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: getfield 101	aujr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: aload 6
    //   44: getfield 421	com/tencent/mobileqq/data/ChatMessage:selfuin	Ljava/lang/String;
    //   47: invokestatic 426	bdgc:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: aload_0
    //   54: getfield 101	aujr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   57: aload 6
    //   59: getfield 429	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   62: invokestatic 426	bdgc:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   65: aastore
    //   66: invokestatic 433	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   69: astore 5
    //   71: aload_3
    //   72: ldc_w 435
    //   75: aload 5
    //   77: invokevirtual 274	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   80: pop
    //   81: getstatic 56	aujr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   84: iconst_1
    //   85: invokestatic 438	bdhb:a	(Ljava/lang/String;Z)V
    //   88: new 47	java/io/File
    //   91: dup
    //   92: getstatic 56	aujr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   95: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   98: astore 7
    //   100: aload 7
    //   102: invokevirtual 441	java/io/File:isDirectory	()Z
    //   105: ifeq +17 -> 122
    //   108: aload 7
    //   110: invokevirtual 444	java/io/File:exists	()Z
    //   113: ifne +9 -> 122
    //   116: aload 7
    //   118: invokevirtual 447	java/io/File:mkdirs	()Z
    //   121: pop
    //   122: new 247	java/util/ArrayList
    //   125: dup
    //   126: invokespecial 297	java/util/ArrayList:<init>	()V
    //   129: astore 12
    //   131: new 247	java/util/ArrayList
    //   134: dup
    //   135: invokespecial 297	java/util/ArrayList:<init>	()V
    //   138: astore 10
    //   140: new 247	java/util/ArrayList
    //   143: dup
    //   144: invokespecial 297	java/util/ArrayList:<init>	()V
    //   147: astore 13
    //   149: new 247	java/util/ArrayList
    //   152: dup
    //   153: invokespecial 297	java/util/ArrayList:<init>	()V
    //   156: astore 11
    //   158: new 31	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   165: getstatic 56	aujr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   168: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: getstatic 64	aujr:j	Ljava/lang/String;
    //   174: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 448	bdhb:a	(Ljava/lang/String;)Ljava/io/File;
    //   183: pop
    //   184: new 450	java/io/BufferedWriter
    //   187: dup
    //   188: new 452	java/io/FileWriter
    //   191: dup
    //   192: new 31	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   199: getstatic 56	aujr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   202: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: getstatic 64	aujr:j	Ljava/lang/String;
    //   208: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokespecial 453	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   217: invokespecial 456	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   220: astore 8
    //   222: new 31	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   229: astore 14
    //   231: aload 14
    //   233: ldc_w 458
    //   236: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 14
    //   242: ldc_w 460
    //   245: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload 5
    //   250: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: ldc_w 462
    //   256: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 8
    //   262: new 31	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   269: aload 5
    //   271: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc_w 464
    //   277: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokevirtual 467	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   286: new 469	java/text/SimpleDateFormat
    //   289: dup
    //   290: ldc 161
    //   292: getstatic 475	java/util/Locale:SIMPLIFIED_CHINESE	Ljava/util/Locale;
    //   295: invokespecial 478	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   298: astore 15
    //   300: aload 15
    //   302: ldc_w 480
    //   305: invokevirtual 483	java/text/SimpleDateFormat:applyPattern	(Ljava/lang/String;)V
    //   308: aload 15
    //   310: aload 6
    //   312: getfield 487	com/tencent/mobileqq/data/ChatMessage:time	J
    //   315: ldc2_w 488
    //   318: lmul
    //   319: invokestatic 495	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   322: invokevirtual 498	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   325: astore 6
    //   327: aload 14
    //   329: ldc_w 500
    //   332: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload 6
    //   337: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: ldc_w 502
    //   343: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 8
    //   349: new 31	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   356: ldc_w 504
    //   359: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload 6
    //   364: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: ldc_w 506
    //   370: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokevirtual 467	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   379: iconst_0
    //   380: istore 4
    //   382: iload 4
    //   384: aload_2
    //   385: invokevirtual 507	java/util/ArrayList:size	()I
    //   388: if_icmpge +841 -> 1229
    //   391: aload_2
    //   392: iload 4
    //   394: invokevirtual 409	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   397: checkcast 411	com/tencent/mobileqq/data/ChatMessage
    //   400: astore 16
    //   402: aconst_null
    //   403: astore 5
    //   405: aload 16
    //   407: instanceof 509
    //   410: ifeq +445 -> 855
    //   413: aload 16
    //   415: checkcast 509	com/tencent/mobileqq/data/MessageForText
    //   418: astore 5
    //   420: aload 5
    //   422: getfield 513	com/tencent/mobileqq/data/MessageForText:sb	Ljava/lang/CharSequence;
    //   425: ifnull +420 -> 845
    //   428: aload 5
    //   430: getfield 513	com/tencent/mobileqq/data/MessageForText:sb	Ljava/lang/CharSequence;
    //   433: invokeinterface 516 1 0
    //   438: astore 5
    //   440: aload 5
    //   442: astore 7
    //   444: aload 5
    //   446: invokestatic 521	banh:a	(Ljava/lang/String;)Z
    //   449: ifeq +1189 -> 1638
    //   452: aload 5
    //   454: invokestatic 522	banh:d	(Ljava/lang/String;)Ljava/lang/String;
    //   457: astore 7
    //   459: goto +1179 -> 1638
    //   462: aload 6
    //   464: astore 7
    //   466: aload 5
    //   468: ifnull +259 -> 727
    //   471: aload 15
    //   473: ldc_w 480
    //   476: invokevirtual 483	java/text/SimpleDateFormat:applyPattern	(Ljava/lang/String;)V
    //   479: aload 15
    //   481: aload 16
    //   483: getfield 487	com/tencent/mobileqq/data/ChatMessage:time	J
    //   486: ldc2_w 488
    //   489: lmul
    //   490: invokestatic 495	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   493: invokevirtual 498	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   496: astore 9
    //   498: aload 6
    //   500: astore 7
    //   502: aload 9
    //   504: aload 6
    //   506: invokevirtual 325	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   509: ifne +59 -> 568
    //   512: aload 14
    //   514: ldc_w 500
    //   517: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload 9
    //   522: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: ldc_w 502
    //   528: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload 8
    //   534: new 31	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   541: ldc_w 504
    //   544: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: aload 9
    //   549: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: ldc_w 506
    //   555: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokevirtual 467	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   564: aload 9
    //   566: astore 7
    //   568: aload 15
    //   570: ldc_w 524
    //   573: invokevirtual 483	java/text/SimpleDateFormat:applyPattern	(Ljava/lang/String;)V
    //   576: aload 15
    //   578: aload 16
    //   580: getfield 487	com/tencent/mobileqq/data/ChatMessage:time	J
    //   583: ldc2_w 488
    //   586: lmul
    //   587: invokestatic 495	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   590: invokevirtual 498	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   593: astore 6
    //   595: aload 14
    //   597: ldc_w 526
    //   600: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: aload_1
    //   604: aload 16
    //   606: getfield 529	com/tencent/mobileqq/data/ChatMessage:senderuin	Ljava/lang/String;
    //   609: invokeinterface 534 2 0
    //   614: checkcast 165	java/lang/String
    //   617: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: ldc_w 536
    //   623: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: aload 6
    //   628: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: ldc_w 538
    //   634: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: pop
    //   638: aload 14
    //   640: aload 5
    //   642: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: ldc_w 540
    //   648: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: pop
    //   652: aload 8
    //   654: new 31	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   661: aload_1
    //   662: aload 16
    //   664: getfield 529	com/tencent/mobileqq/data/ChatMessage:senderuin	Ljava/lang/String;
    //   667: invokeinterface 534 2 0
    //   672: checkcast 165	java/lang/String
    //   675: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: ldc_w 542
    //   681: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: aload 6
    //   686: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: ldc_w 544
    //   692: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   698: invokevirtual 467	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   701: aload 8
    //   703: new 31	java/lang/StringBuilder
    //   706: dup
    //   707: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   710: aload 5
    //   712: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: ldc_w 546
    //   718: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   724: invokevirtual 467	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   727: aload 7
    //   729: astore 5
    //   731: iload 4
    //   733: iconst_1
    //   734: iadd
    //   735: istore 4
    //   737: aload 5
    //   739: astore 6
    //   741: goto -359 -> 382
    //   744: aload 6
    //   746: getfield 414	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   749: iconst_1
    //   750: if_icmpne +40 -> 790
    //   753: aload_0
    //   754: getfield 103	aujr:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   757: ldc_w 547
    //   760: invokevirtual 418	android/content/Context:getString	(I)Ljava/lang/String;
    //   763: iconst_1
    //   764: anewarray 4	java/lang/Object
    //   767: dup
    //   768: iconst_0
    //   769: aload_0
    //   770: getfield 101	aujr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   773: aload 6
    //   775: getfield 429	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   778: invokestatic 549	bdgc:g	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   781: aastore
    //   782: invokestatic 433	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   785: astore 5
    //   787: goto -716 -> 71
    //   790: aload 6
    //   792: getfield 414	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   795: sipush 3000
    //   798: if_icmpne -727 -> 71
    //   801: aload_0
    //   802: getfield 103	aujr:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   805: ldc_w 547
    //   808: invokevirtual 418	android/content/Context:getString	(I)Ljava/lang/String;
    //   811: iconst_1
    //   812: anewarray 4	java/lang/Object
    //   815: dup
    //   816: iconst_0
    //   817: aload_0
    //   818: getfield 101	aujr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   821: aload_0
    //   822: getfield 101	aujr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   825: invokevirtual 555	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   828: aload 6
    //   830: getfield 429	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   833: invokestatic 558	bdgc:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   836: aastore
    //   837: invokestatic 433	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   840: astore 5
    //   842: goto -771 -> 71
    //   845: aload 5
    //   847: getfield 561	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   850: astore 5
    //   852: goto -412 -> 440
    //   855: aload 16
    //   857: instanceof 139
    //   860: ifeq +20 -> 880
    //   863: aload 16
    //   865: checkcast 139	com/tencent/mobileqq/data/MessageForPic
    //   868: aload 12
    //   870: aload 13
    //   872: invokestatic 563	aujr:a	(Lcom/tencent/mobileqq/data/MessageForPic;Ljava/util/List;Ljava/util/List;)Ljava/lang/String;
    //   875: astore 5
    //   877: goto -415 -> 462
    //   880: aload 16
    //   882: instanceof 565
    //   885: ifeq +135 -> 1020
    //   888: aload 16
    //   890: checkcast 565	com/tencent/mobileqq/data/MessageForShortVideo
    //   893: invokestatic 570	com/tencent/mobileqq/shortvideo/ShortVideoUtils:c	(Lcom/tencent/mobileqq/data/MessageForShortVideo;)Ljava/lang/String;
    //   896: astore 5
    //   898: aload 5
    //   900: ifnonnull +34 -> 934
    //   903: ldc 135
    //   905: iconst_1
    //   906: iconst_2
    //   907: anewarray 4	java/lang/Object
    //   910: dup
    //   911: iconst_0
    //   912: ldc_w 572
    //   915: aastore
    //   916: dup
    //   917: iconst_1
    //   918: aload 16
    //   920: invokevirtual 573	com/tencent/mobileqq/data/ChatMessage:getUserLogString	()Ljava/lang/String;
    //   923: aastore
    //   924: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   927: aload 6
    //   929: astore 5
    //   931: goto -200 -> 731
    //   934: aload 10
    //   936: aload 5
    //   938: invokeinterface 153 2 0
    //   943: pop
    //   944: new 31	java/lang/StringBuilder
    //   947: dup
    //   948: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   951: ldc_w 574
    //   954: invokestatic 62	alud:a	(I)Ljava/lang/String;
    //   957: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: aload 10
    //   962: invokeinterface 178 1 0
    //   967: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   970: ldc_w 576
    //   973: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   979: astore 7
    //   981: new 31	java/lang/StringBuilder
    //   984: dup
    //   985: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   988: aload 7
    //   990: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: ldc_w 577
    //   996: invokestatic 62	alud:a	(I)Ljava/lang/String;
    //   999: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1005: astore 5
    //   1007: aload 11
    //   1009: aload 7
    //   1011: invokeinterface 153 2 0
    //   1016: pop
    //   1017: goto -555 -> 462
    //   1020: aload 16
    //   1022: instanceof 579
    //   1025: ifne +11 -> 1036
    //   1028: aload 16
    //   1030: instanceof 581
    //   1033: ifeq +22 -> 1055
    //   1036: aload 16
    //   1038: aload 12
    //   1040: aload 13
    //   1042: invokestatic 585	com/tencent/mobileqq/data/MessageForMixedMsg:getTextFromMixedMsgForMail	(Lcom/tencent/mobileqq/data/ChatMessage;Ljava/util/List;Ljava/util/List;)Ljava/lang/CharSequence;
    //   1045: invokeinterface 516 1 0
    //   1050: astore 5
    //   1052: goto -590 -> 462
    //   1055: aload 16
    //   1057: instanceof 208
    //   1060: ifeq -598 -> 462
    //   1063: aload 16
    //   1065: checkcast 208	com/tencent/mobileqq/data/MessageForStructing
    //   1068: astore 7
    //   1070: aload 7
    //   1072: getfield 215	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1075: ifnull +557 -> 1632
    //   1078: aload 7
    //   1080: getfield 215	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1083: instanceof 587
    //   1086: ifeq +36 -> 1122
    //   1089: aload 7
    //   1091: getfield 215	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1094: checkcast 587	com/tencent/mobileqq/structmsg/StructMsgForHypertext
    //   1097: iconst_0
    //   1098: invokevirtual 591	com/tencent/mobileqq/structmsg/StructMsgForHypertext:getSpannableString	(Z)Landroid/text/SpannableStringBuilder;
    //   1101: invokevirtual 594	android/text/SpannableStringBuilder:toString	()Ljava/lang/String;
    //   1104: astore 5
    //   1106: aload 5
    //   1108: ifnonnull +518 -> 1626
    //   1111: ldc_w 595
    //   1114: invokestatic 62	alud:a	(I)Ljava/lang/String;
    //   1117: astore 5
    //   1119: goto -657 -> 462
    //   1122: ldc_w 597
    //   1125: aload 7
    //   1127: getfield 215	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1130: getfield 602	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgAction	Ljava/lang/String;
    //   1133: invokevirtual 325	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1136: ifeq +14 -> 1150
    //   1139: ldc_w 603
    //   1142: invokestatic 62	alud:a	(I)Ljava/lang/String;
    //   1145: astore 5
    //   1147: goto -41 -> 1106
    //   1150: aload 7
    //   1152: getfield 215	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1155: getfield 606	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1158: bipush 32
    //   1160: if_icmpne +14 -> 1174
    //   1163: aload_0
    //   1164: aload 7
    //   1166: invokevirtual 608	aujr:a	(Lcom/tencent/mobileqq/data/MessageForStructing;)Ljava/lang/String;
    //   1169: astore 5
    //   1171: goto -65 -> 1106
    //   1174: aload 7
    //   1176: invokevirtual 211	com/tencent/mobileqq/data/MessageForStructing:getSummaryMsg	()Ljava/lang/String;
    //   1179: astore 5
    //   1181: aload 7
    //   1183: getfield 215	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1186: getfield 611	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgUrl	Ljava/lang/String;
    //   1189: ifnull +440 -> 1629
    //   1192: new 31	java/lang/StringBuilder
    //   1195: dup
    //   1196: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   1199: aload 5
    //   1201: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: ldc_w 544
    //   1207: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1210: aload 7
    //   1212: getfield 215	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1215: getfield 611	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgUrl	Ljava/lang/String;
    //   1218: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1224: astore 5
    //   1226: goto -120 -> 1106
    //   1229: aload 14
    //   1231: ldc_w 613
    //   1234: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: pop
    //   1238: aload_3
    //   1239: ldc_w 388
    //   1242: aload 14
    //   1244: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1247: invokestatic 619	android/text/Html:fromHtml	(Ljava/lang/String;)Landroid/text/Spanned;
    //   1250: invokevirtual 622	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/CharSequence;)Landroid/content/Intent;
    //   1253: pop
    //   1254: aload 8
    //   1256: invokevirtual 625	java/io/BufferedWriter:flush	()V
    //   1259: aload 8
    //   1261: ifnull +8 -> 1269
    //   1264: aload 8
    //   1266: invokevirtual 628	java/io/BufferedWriter:close	()V
    //   1269: new 247	java/util/ArrayList
    //   1272: dup
    //   1273: invokespecial 297	java/util/ArrayList:<init>	()V
    //   1276: astore_1
    //   1277: aload_1
    //   1278: aload_0
    //   1279: getstatic 64	aujr:j	Ljava/lang/String;
    //   1282: invokevirtual 630	aujr:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   1285: invokevirtual 393	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1288: pop
    //   1289: aload 12
    //   1291: invokeinterface 296 1 0
    //   1296: ifne +169 -> 1465
    //   1299: aload 12
    //   1301: invokeinterface 228 1 0
    //   1306: astore_2
    //   1307: aload_2
    //   1308: invokeinterface 234 1 0
    //   1313: ifeq +152 -> 1465
    //   1316: aload_2
    //   1317: invokeinterface 238 1 0
    //   1322: checkcast 165	java/lang/String
    //   1325: astore 5
    //   1327: aload 5
    //   1329: new 31	java/lang/StringBuilder
    //   1332: dup
    //   1333: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   1336: getstatic 56	aujr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1339: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1342: aload 13
    //   1344: aload 12
    //   1346: aload 5
    //   1348: invokeinterface 633 2 0
    //   1353: invokeinterface 634 2 0
    //   1358: checkcast 165	java/lang/String
    //   1361: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1364: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1367: invokestatic 637	bdhb:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1370: ifeq -63 -> 1307
    //   1373: aload_1
    //   1374: aload_0
    //   1375: aload 13
    //   1377: aload 12
    //   1379: aload 5
    //   1381: invokeinterface 633 2 0
    //   1386: invokeinterface 634 2 0
    //   1391: checkcast 165	java/lang/String
    //   1394: invokevirtual 630	aujr:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   1397: invokevirtual 393	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1400: pop
    //   1401: goto -94 -> 1307
    //   1404: astore_1
    //   1405: aload_1
    //   1406: invokevirtual 640	java/io/IOException:printStackTrace	()V
    //   1409: goto -140 -> 1269
    //   1412: astore_2
    //   1413: aconst_null
    //   1414: astore_1
    //   1415: ldc 135
    //   1417: iconst_1
    //   1418: ldc_w 642
    //   1421: aload_2
    //   1422: invokestatic 354	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1425: aload_1
    //   1426: ifnull -157 -> 1269
    //   1429: aload_1
    //   1430: invokevirtual 628	java/io/BufferedWriter:close	()V
    //   1433: goto -164 -> 1269
    //   1436: astore_1
    //   1437: aload_1
    //   1438: invokevirtual 640	java/io/IOException:printStackTrace	()V
    //   1441: goto -172 -> 1269
    //   1444: astore_1
    //   1445: aconst_null
    //   1446: astore_2
    //   1447: aload_2
    //   1448: ifnull +7 -> 1455
    //   1451: aload_2
    //   1452: invokevirtual 628	java/io/BufferedWriter:close	()V
    //   1455: aload_1
    //   1456: athrow
    //   1457: astore_2
    //   1458: aload_2
    //   1459: invokevirtual 640	java/io/IOException:printStackTrace	()V
    //   1462: goto -7 -> 1455
    //   1465: aload 10
    //   1467: invokeinterface 296 1 0
    //   1472: ifne +108 -> 1580
    //   1475: aload 10
    //   1477: invokeinterface 228 1 0
    //   1482: astore_2
    //   1483: aload_2
    //   1484: invokeinterface 234 1 0
    //   1489: ifeq +91 -> 1580
    //   1492: aload_2
    //   1493: invokeinterface 238 1 0
    //   1498: checkcast 165	java/lang/String
    //   1501: astore 5
    //   1503: aload 5
    //   1505: new 31	java/lang/StringBuilder
    //   1508: dup
    //   1509: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   1512: getstatic 56	aujr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1515: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1518: aload 11
    //   1520: aload 10
    //   1522: aload 5
    //   1524: invokeinterface 633 2 0
    //   1529: invokeinterface 634 2 0
    //   1534: checkcast 165	java/lang/String
    //   1537: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1540: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1543: invokestatic 637	bdhb:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1546: ifeq -63 -> 1483
    //   1549: aload_1
    //   1550: aload_0
    //   1551: aload 11
    //   1553: aload 10
    //   1555: aload 5
    //   1557: invokeinterface 633 2 0
    //   1562: invokeinterface 634 2 0
    //   1567: checkcast 165	java/lang/String
    //   1570: invokevirtual 630	aujr:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   1573: invokevirtual 393	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1576: pop
    //   1577: goto -94 -> 1483
    //   1580: aload_3
    //   1581: ldc_w 644
    //   1584: aload_1
    //   1585: invokevirtual 647	android/content/Intent:putParcelableArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   1588: pop
    //   1589: getstatic 191	android/os/Build$VERSION:SDK_INT	I
    //   1592: bipush 24
    //   1594: if_icmplt +9 -> 1603
    //   1597: aload_3
    //   1598: iconst_1
    //   1599: invokevirtual 651	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1602: pop
    //   1603: return
    //   1604: astore_1
    //   1605: aload 8
    //   1607: astore_2
    //   1608: goto -161 -> 1447
    //   1611: astore_3
    //   1612: aload_1
    //   1613: astore_2
    //   1614: aload_3
    //   1615: astore_1
    //   1616: goto -169 -> 1447
    //   1619: astore_2
    //   1620: aload 8
    //   1622: astore_1
    //   1623: goto -208 -> 1415
    //   1626: goto -1164 -> 462
    //   1629: goto -523 -> 1106
    //   1632: aconst_null
    //   1633: astore 5
    //   1635: goto -529 -> 1106
    //   1638: aload 7
    //   1640: astore 5
    //   1642: goto -1180 -> 462
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1645	0	this	aujr
    //   0	1645	1	paramMap	Map<String, String>
    //   0	1645	2	paramArrayList	ArrayList<ChatMessage>
    //   0	1645	3	paramIntent	Intent
    //   380	356	4	k	int
    //   12	1629	5	localObject1	Object
    //   8	920	6	localObject2	Object
    //   98	1541	7	localObject3	Object
    //   220	1401	8	localBufferedWriter	java.io.BufferedWriter
    //   496	69	9	str	String
    //   138	1416	10	localArrayList1	ArrayList
    //   156	1396	11	localArrayList2	ArrayList
    //   129	1249	12	localArrayList3	ArrayList
    //   147	1229	13	localArrayList4	ArrayList
    //   229	1014	14	localStringBuilder	StringBuilder
    //   298	279	15	localSimpleDateFormat	SimpleDateFormat
    //   400	664	16	localChatMessage	ChatMessage
    // Exception table:
    //   from	to	target	type
    //   1264	1269	1404	java/io/IOException
    //   158	222	1412	java/lang/Throwable
    //   1429	1433	1436	java/io/IOException
    //   158	222	1444	finally
    //   1451	1455	1457	java/io/IOException
    //   222	379	1604	finally
    //   382	402	1604	finally
    //   405	440	1604	finally
    //   444	459	1604	finally
    //   471	498	1604	finally
    //   502	564	1604	finally
    //   568	727	1604	finally
    //   845	852	1604	finally
    //   855	877	1604	finally
    //   880	898	1604	finally
    //   903	927	1604	finally
    //   934	1017	1604	finally
    //   1020	1036	1604	finally
    //   1036	1052	1604	finally
    //   1055	1106	1604	finally
    //   1111	1119	1604	finally
    //   1122	1147	1604	finally
    //   1150	1171	1604	finally
    //   1174	1226	1604	finally
    //   1229	1259	1604	finally
    //   1415	1425	1611	finally
    //   222	379	1619	java/lang/Throwable
    //   382	402	1619	java/lang/Throwable
    //   405	440	1619	java/lang/Throwable
    //   444	459	1619	java/lang/Throwable
    //   471	498	1619	java/lang/Throwable
    //   502	564	1619	java/lang/Throwable
    //   568	727	1619	java/lang/Throwable
    //   845	852	1619	java/lang/Throwable
    //   855	877	1619	java/lang/Throwable
    //   880	898	1619	java/lang/Throwable
    //   903	927	1619	java/lang/Throwable
    //   934	1017	1619	java/lang/Throwable
    //   1020	1036	1619	java/lang/Throwable
    //   1036	1052	1619	java/lang/Throwable
    //   1055	1106	1619	java/lang/Throwable
    //   1111	1119	1619	java/lang/Throwable
    //   1122	1147	1619	java/lang/Throwable
    //   1150	1171	1619	java/lang/Throwable
    //   1174	1226	1619	java/lang/Throwable
    //   1229	1259	1619	java/lang/Throwable
  }
  
  public boolean a()
  {
    Iterator localIterator = aupg.a().a.entrySet().iterator();
    boolean bool2 = false;
    if (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      bool1 = bool2;
      if (((Boolean)((Map.Entry)localObject).getValue()).booleanValue())
      {
        localObject = (ChatMessage)((Map.Entry)localObject).getKey();
        bool2 |= alse.a((MessageRecord)localObject);
        if (amlb.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject)) {}
      }
    }
    while (bool2)
    {
      Object localObject;
      do
      {
        do
        {
          return false;
          bool1 = bool2;
          if (!(localObject instanceof MessageForTroopFile)) {
            break;
          }
          localObject = (MessageForTroopFile)localObject;
          localObject = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForTroopFile)localObject);
        } while (localObject == null);
        bool1 = bool2;
        if (((bbtn)localObject).b == 8) {
          break;
        }
        bool1 = bool2;
        if (((bbtn)localObject).b == 9) {
          break;
        }
        bool1 = bool2;
        if (((bbtn)localObject).b == 6) {
          break;
        }
        bool1 = bool2;
        if (((bbtn)localObject).b == 7) {
          break;
        }
        if (((bbtn)localObject).b == 11)
        {
          bool1 = bool2;
          if (arso.a(((bbtn)localObject).jdField_a_of_type_JavaLangString)) {
            break;
          }
        }
      } while (((bbtn)localObject).b != 10);
      boolean bool1 = bool2;
      bool2 = bool1;
      break;
    }
    return true;
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    if (((paramChatMessage instanceof MessageForPic)) && (alse.a(paramChatMessage))) {
      return false;
    }
    if (((paramChatMessage instanceof MessageForTroopFile)) || ((paramChatMessage instanceof MessageForQQStoryComment)) || ((paramChatMessage instanceof MessageForArkApp))) {
      return false;
    }
    if ((paramChatMessage instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramChatMessage;
      if ((localMessageForStructing.structingMsg != null) && ("viewMultiMsg".equals(localMessageForStructing.structingMsg.mMsgAction))) {
        return true;
      }
    }
    else if (((paramChatMessage instanceof MessageForPic)) && (ahbf.a((MessageForPic)paramChatMessage)))
    {
      return false;
    }
    return amlb.a(paramChatMessage);
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    int k;
    if (aepi.a(2) == 0)
    {
      k = 1;
      if (aepi.a(3) != 0) {
        break label455;
      }
    }
    label455:
    for (int m = 1;; m = 0)
    {
      Object localObject = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = paramContext.getString(2131696893);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130838921;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 9;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
      localArrayList.add(localObject);
      localObject = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = paramContext.getString(2131696879);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839128;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 25;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
      localArrayList.add(localObject);
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = paramContext.getString(2131692997);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839739;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 50;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
        localArrayList.add(localObject);
      }
      localObject = new ArrayList();
      if (k != 0)
      {
        localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
        localActionSheetItem.label = paramContext.getString(2131696881);
        localActionSheetItem.icon = 2130839161;
        localActionSheetItem.iconNeedBg = true;
        localActionSheetItem.action = 26;
        localActionSheetItem.argus = "";
        ((ArrayList)localObject).add(localActionSheetItem);
      }
      if (m != 0)
      {
        localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
        localActionSheetItem.label = paramContext.getString(2131696896);
        localActionSheetItem.icon = 2130839299;
        localActionSheetItem.iconNeedBg = true;
        localActionSheetItem.action = 27;
        localActionSheetItem.argus = "";
        ((ArrayList)localObject).add(localActionSheetItem);
      }
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
      localActionSheetItem.label = paramContext.getString(2131696877);
      localActionSheetItem.icon = 2130838913;
      localActionSheetItem.iconNeedBg = true;
      localActionSheetItem.action = 28;
      localActionSheetItem.argus = "";
      ((ArrayList)localObject).add(localActionSheetItem);
      localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
      localActionSheetItem.label = paramContext.getString(2131696872);
      localActionSheetItem.icon = 2130839707;
      localActionSheetItem.iconNeedBg = true;
      localActionSheetItem.action = 47;
      localActionSheetItem.argus = "";
      ((ArrayList)localObject).add(localActionSheetItem);
      return (List[])new ArrayList[] { localArrayList, localObject };
      k = 0;
      break;
    }
  }
  
  public void b()
  {
    Iterator localIterator = aupg.a().a().iterator();
    ChatMessage localChatMessage;
    int k;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localChatMessage = (ChatMessage)localIterator.next();
      k = afpy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
    } while ((!(localChatMessage instanceof MessageForPic)) || (k != 1) || (bdil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForPic)localChatMessage, false)));
    for (boolean bool = true;; bool = false)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null) || (this.jdField_a_of_type_Boolean != bool))
      {
        this.jdField_a_of_type_Boolean = bool;
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.jdField_a_of_type_AndroidAppActivity);
        k = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 4.0F);
        int m = this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.getIconMarginLeftRight();
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setIconMarginLeftRight(Math.max(k, m));
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131720052));
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a(this.jdField_a_of_type_AndroidContentContext));
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(this);
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("ShareActionSheet", 2, "actionSheet.show exception=", localException);
        return;
      }
    }
  }
  
  public void b(aupy paramaupy) {}
  
  public void b(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int k = 0;
    ChatMessage localChatMessage;
    Object localObject1;
    Object localObject2;
    if (k < paramArrayList.size())
    {
      localChatMessage = (ChatMessage)paramArrayList.get(k);
      if ((localChatMessage instanceof MessageForText))
      {
        localObject1 = (MessageForText)localChatMessage;
        if (((MessageForText)localObject1).sb != null)
        {
          localObject2 = ((MessageForText)localObject1).sb.toString();
          label64:
          localObject1 = localObject2;
          if (banh.a((String)localObject2)) {
            localObject1 = banh.d((String)localObject2);
          }
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject2 = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
          ((SimpleDateFormat)localObject2).applyPattern("HH:mm:ss");
          localObject2 = ((SimpleDateFormat)localObject2).format(Long.valueOf(localChatMessage.time * 1000L));
          localStringBuilder.append((String)paramMap.get(localChatMessage.senderuin)).append(" ").append((String)localObject2).append("\n").append((String)localObject1).append("\n");
          if (k != paramArrayList.size() - 1) {
            localStringBuilder.append("\n");
          }
        }
        k += 1;
        break;
        localObject2 = ((MessageForText)localObject1).msg;
        break label64;
        if ((localChatMessage instanceof MessageForPic))
        {
          localObject1 = alud.a(2131700504);
        }
        else if ((localChatMessage instanceof MessageForShortVideo))
        {
          localObject1 = alud.a(2131700508);
        }
        else
        {
          if ((!(localChatMessage instanceof MessageForMixedMsg)) && (!(localChatMessage instanceof MessageForLongMsg))) {
            break label282;
          }
          localObject1 = MessageForMixedMsg.getTextFromMixedMsg(localChatMessage).toString();
        }
      }
      label282:
      if ((localChatMessage instanceof MessageForStructing))
      {
        localObject1 = (MessageForStructing)localChatMessage;
        if (((MessageForStructing)localObject1).structingMsg == null) {
          break label520;
        }
        if ((((MessageForStructing)localObject1).structingMsg instanceof StructMsgForHypertext)) {
          localObject2 = ((StructMsgForHypertext)((MessageForStructing)localObject1).structingMsg).getSpannableString(false).toString();
        }
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = alud.a(2131700510);
      break;
      if (((MessageForStructing)localObject1).structingMsg.mMsgServiceID == 32)
      {
        localObject2 = a((MessageForStructing)localObject1);
      }
      else
      {
        localObject2 = ((MessageForStructing)localObject1).getSummaryMsg();
        if (((MessageForStructing)localObject1).structingMsg.mMsgUrl != null)
        {
          localObject2 = (String)localObject2 + "\n" + ((MessageForStructing)localObject1).structingMsg.mMsgUrl;
          continue;
          if (((localChatMessage instanceof MessageForArkFlashChat)) && (localChatMessage.msg != null))
          {
            localObject1 = localChatMessage.msg;
            break;
            ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", localStringBuilder.toString()));
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694625, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
            return;
          }
          localObject1 = null;
          break;
        }
        continue;
        label520:
        localObject2 = null;
      }
    }
  }
  
  public boolean b()
  {
    Iterator localIterator = aupg.a().a.entrySet().iterator();
    boolean bool2 = false;
    if (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      bool1 = bool2;
      if (((Boolean)((Map.Entry)localObject).getValue()).booleanValue())
      {
        localObject = (ChatMessage)((Map.Entry)localObject).getKey();
        bool2 |= alse.a((MessageRecord)localObject);
        if (amlb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject)) {}
      }
    }
    while (bool2)
    {
      Object localObject;
      do
      {
        return false;
        bool1 = bool2;
        if (!(localObject instanceof MessageForTroopFile)) {
          break;
        }
        localObject = (MessageForTroopFile)localObject;
      } while (bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForTroopFile)localObject) == null);
      boolean bool1 = bool2;
      bool2 = bool1;
      break;
    }
    return true;
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    if (((paramChatMessage instanceof MessageForPic)) && (alse.a(paramChatMessage))) {
      return false;
    }
    if (((paramChatMessage instanceof MessageForTroopFile)) || ((paramChatMessage instanceof MessageForQQStoryComment)) || ((paramChatMessage instanceof MessageForArkApp))) {
      return false;
    }
    if (((paramChatMessage instanceof MessageForPic)) && (ahbf.a((MessageForPic)paramChatMessage))) {
      return false;
    }
    return amlb.a(paramChatMessage);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    }
    if (this.jdField_a_of_type_Bfah != null) {
      WXShareHelper.a().b(this.jdField_a_of_type_Bfah);
    }
  }
  
  public boolean c()
  {
    if (!bdin.d(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131692398, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      return false;
    }
    Object localObject1 = aupg.a().a();
    if (((List)localObject1).size() == 0)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131698782, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      return false;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int k = 0;
    Object localObject2;
    if (k < ((List)localObject1).size())
    {
      localObject2 = (ChatMessage)((List)localObject1).get(k);
      if ((localObject2 instanceof MessageForTroopFile)) {
        localArrayList1.add((MessageForTroopFile)localObject2);
      }
      for (;;)
      {
        k += 1;
        break;
        if ((localObject2 instanceof MessageForFile)) {
          localArrayList2.add((MessageForFile)localObject2);
        }
      }
    }
    if (localArrayList1.size() > 0)
    {
      localObject1 = localArrayList1.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageForTroopFile)((Iterator)localObject1).next();
        bcnt.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject2);
      }
    }
    MessageForFile localMessageForFile;
    FileManagerEntity localFileManagerEntity;
    if (localArrayList2.size() > 0)
    {
      localObject1 = new ArrayList();
      localObject2 = localArrayList2.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localMessageForFile = (MessageForFile)((Iterator)localObject2).next();
        localFileManagerEntity = arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
        if ((localFileManagerEntity.cloudType != 0) && (localFileManagerEntity.cloudType != 2)) {
          ((ArrayList)localObject1).add(localMessageForFile);
        }
      }
      if (((ArrayList)localObject1).size() == 0)
      {
        arri.a(2131692748);
        return false;
      }
      if (((ArrayList)localObject1).size() != 1) {
        break label416;
      }
      localObject1 = (MessageForFile)((ArrayList)localObject1).get(0);
      localObject2 = arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject1);
      if (localObject2 == null)
      {
        arri.a(2131692748);
        return false;
      }
      if (((FileManagerEntity)localObject2).status == 16)
      {
        arri.a(2131692941);
        return false;
      }
      arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject1, BaseActivity.sTopActivity);
    }
    while ((localArrayList1.size() == 0) && (localArrayList2.size() == 0))
    {
      arri.a(2131692749);
      return false;
      label416:
      localObject2 = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localMessageForFile = (MessageForFile)((Iterator)localObject1).next();
        localFileManagerEntity = arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
        if ((localFileManagerEntity != null) && (localFileManagerEntity.status != 16)) {
          ((List)localObject2).add(localMessageForFile);
        }
      }
      if (((List)localObject2).size() == 0)
      {
        arri.a(2131692748);
        return false;
      }
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageForFile)((Iterator)localObject1).next();
        arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject2, BaseActivity.sTopActivity);
      }
    }
    return true;
  }
  
  public boolean d()
  {
    Iterator localIterator = aupg.a().a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Boolean)localEntry.getValue()).booleanValue()) && (!a((ChatMessage)localEntry.getKey()))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean e()
  {
    List localList = aupg.a().a();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (!a(localChatMessage)) {
        localArrayList.add(localChatMessage);
      }
    }
    localList.removeAll(localArrayList);
    if (localList.isEmpty())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694619, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      return false;
    }
    ((affj)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(1)).a(localList, 3);
    return true;
  }
  
  public boolean f()
  {
    Iterator localIterator = aupg.a().a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Boolean)localEntry.getValue()).booleanValue()) && (!b((ChatMessage)localEntry.getKey()))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean g()
  {
    List localList = aupg.a().a();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (!b(localChatMessage)) {
        localArrayList.add(localChatMessage);
      }
    }
    localList.removeAll(localArrayList);
    if (localList.isEmpty())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694624, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      return false;
    }
    ((affj)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(1)).a(localList, 4);
    return true;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
      switch (((bdmy)paramAdapterView).a.action)
      {
      default: 
        return;
      case 9: 
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", e, e, 0, 0, "", "", "", "");
        paramInt = -1;
        if (!WXShareHelper.a().a()) {
          paramInt = 2131694570;
        }
        while (paramInt != -1)
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_AndroidContentContext.getString(paramInt), 0).a();
          return;
          if (!WXShareHelper.a().b()) {
            paramInt = 2131721492;
          }
        }
        if (this.jdField_a_of_type_Bfah != null) {
          this.jdField_a_of_type_Bfah = new aujs(this);
        }
        WXShareHelper.a().a(this.jdField_a_of_type_Bfah);
        ((affj)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(1)).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aeqo, true);
        return;
      case 25: 
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", f, f, 0, 0, "", "", "", "");
        if (!d())
        {
          bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131694617)).setPositiveButton(17039370, new aujw(this)).setNegativeButton(17039360, new aujv(this)).show();
          return;
        }
        break;
      }
    } while ((aupg.a().a().isEmpty()) || (!e()));
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false, null, false);
    return;
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", i, i, 0, 0, "", "", "", "");
    paramView = aupg.a().a();
    paramAdapterView = new ArrayList();
    paramView = paramView.iterator();
    paramInt = 0;
    label413:
    Object localObject1;
    int k;
    if (paramView.hasNext())
    {
      localObject1 = (ChatMessage)paramView.next();
      k = afpy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject1);
      if (((localObject1 instanceof MessageForPic)) && (k == 1))
      {
        if (bdil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForPic)localObject1, false)) {
          break label1246;
        }
        paramAdapterView.add((MessageForPic)((ChatMessage)localObject1).deepCopyByReflect());
      }
    }
    label1246:
    for (;;)
    {
      break label413;
      paramInt = 1;
      continue;
      if (paramAdapterView.isEmpty())
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131719326), 0).a();
        return;
      }
      paramView = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      k = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if (paramInt != 0) {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131719326), 0).a();
      }
      axza.a(this.jdField_a_of_type_AndroidAppActivity, paramView, (String)localObject1, (String)localObject2, k, paramAdapterView, 102);
      return;
      if (!b())
      {
        bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131694628)).setPositiveButton(17039370, new aujy(this)).setNegativeButton(17039360, new aujx(this)).show();
        return;
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067F7", "0X80067F7", 0, 0, "", "", "", "");
      if (!c()) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false, null, false);
      return;
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", g, g, 0, 0, "", "", "", "");
      if (!a())
      {
        bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131694626)).setPositiveButton(17039370, new auka(this)).setNegativeButton(17039360, new aujz(this)).show();
        return;
      }
      if (!bkjn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_MqqOsMqqHandler)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false, null, false);
      return;
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", h, h, 0, 0, "", "", "", "");
      if (!f())
      {
        bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131694623)).setPositiveButton(17039370, new aukc(this)).setNegativeButton(17039360, new aukb(this)).show();
        return;
      }
      if ((aupg.a().a().isEmpty()) || (!g())) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false, null, false);
      return;
      paramAdapterView = new aupt(this.jdField_a_of_type_AndroidAppActivity);
      paramView = (auqc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(324);
      if ((paramView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aeqo == null)) {
        break;
      }
      localObject1 = new ArrayList();
      localObject2 = aupg.a().a.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        if (((Boolean)localEntry.getValue()).booleanValue()) {
          ((List)localObject1).add(localEntry.getKey());
        }
      }
      localObject1 = aupx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aeqo.a, this);
      if ((localObject1 == null) || (((List)localObject1).isEmpty()))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131719325), 0).a();
        return;
      }
      if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_AndroidAppActivity))
      {
        CheckPermission.requestStorePermission(this.jdField_a_of_type_AndroidAppActivity, null);
        return;
      }
      paramView.a(new aujt(this, paramAdapterView, paramView, (List)localObject1));
      paramView.a((List)localObject1, true);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
        break;
      }
      paramView.a((List)localObject1, 1, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aujr
 * JD-Core Version:    0.7.0.1
 */