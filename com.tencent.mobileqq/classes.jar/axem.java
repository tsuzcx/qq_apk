import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.1;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.2;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.3;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.4;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.5;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.7;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.8;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class axem
  extends ajfb
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private ConcurrentHashMap<String, TeamWorkFileImportInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentLinkedQueue<axep> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private volatile boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "docs.qq.com" };
  private ConcurrentHashMap<String, String> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile boolean jdField_b_of_type_Boolean;
  private ConcurrentHashMap<String, TeamWorkFileImportInfo> c = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> d = new ConcurrentHashMap();
  
  public axem(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null) {
      while (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty())
      {
        axep localaxep = (axep)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
        if (localaxep != null)
        {
          if (localaxep.a != null)
          {
            localaxep.a.jdField_k_of_type_Int = localaxep.hashCode();
            QLog.d("TeamWorkFileImportHandler", 2, "current job hashcode: " + localaxep.a.jdField_k_of_type_Int);
          }
          localaxep.a(this.app);
          notifyUI(4, false, localaxep.a);
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Runnable paramRunnable)
  {
    if (this.app == null) {}
    while (((TicketManager)this.app.getManager(2)).GetPskey(this.app.getCurrentAccountUin(), 16L, this.jdField_a_of_type_ArrayOfJavaLangString, new axen(this, paramRunnable)) == null) {
      return;
    }
    ThreadManager.executeOnNetWorkThread(paramRunnable);
  }
  
  private String b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    String str = "";
    if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1) {
      str = paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString + "_" + paramTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString;
    }
    do
    {
      return str;
      if ((paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 3000) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 0)) {
        return paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString + "_" + paramTeamWorkFileImportInfo.jdField_a_of_type_Long + "_" + paramTeamWorkFileImportInfo.jdField_b_of_type_Long;
      }
      if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.c)) {
        return paramTeamWorkFileImportInfo.c;
      }
    } while (TextUtils.isEmpty(paramTeamWorkFileImportInfo.jdField_f_of_type_JavaLangString));
    return paramTeamWorkFileImportInfo.jdField_f_of_type_JavaLangString;
  }
  
  /* Error */
  private boolean b(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: iconst_0
    //   4: istore 7
    //   6: aload_2
    //   7: getfield 189	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   10: invokestatic 194	axhg:a	(Ljava/lang/String;)J
    //   13: lstore 9
    //   15: aload_0
    //   16: getfield 115	axem:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: aload_2
    //   20: getfield 189	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   23: ldc 196
    //   25: lload 9
    //   27: invokestatic 200	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   30: new 92	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   37: ldc 202
    //   39: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_2
    //   43: getfield 158	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_a_of_type_Int	I
    //   46: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: aload_2
    //   50: getfield 204	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_d_of_type_Int	I
    //   53: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: aload_2
    //   57: getfield 207	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   60: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: ldc 156
    //   68: invokestatic 210	axhg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_1
    //   72: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   75: ifne +781 -> 856
    //   78: iload 8
    //   80: istore 6
    //   82: new 212	org/json/JSONObject
    //   85: dup
    //   86: aload_1
    //   87: invokespecial 215	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   90: astore 12
    //   92: iload 8
    //   94: istore 6
    //   96: aload 12
    //   98: ldc 217
    //   100: invokevirtual 221	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   103: istore 4
    //   105: iload 8
    //   107: istore 6
    //   109: aload 12
    //   111: ldc 223
    //   113: invokevirtual 227	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   116: ifeq +821 -> 937
    //   119: iload 8
    //   121: istore 6
    //   123: aload 12
    //   125: ldc 223
    //   127: invokevirtual 231	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   130: astore 11
    //   132: iload 8
    //   134: istore 6
    //   136: ldc 90
    //   138: new 92	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   145: ldc 233
    //   147: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_2
    //   151: getfield 235	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   154: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 241	java/lang/System:currentTimeMillis	()J
    //   163: invokestatic 200	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   166: aload_2
    //   167: getfield 189	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   170: invokestatic 244	axhg:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   173: iload 4
    //   175: tableswitch	default:+769 -> 944, 0:+216->391
    //   193: iconst_5
    //   194: istore 6
    //   196: aload_2
    //   197: iload 4
    //   199: putfield 246	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_f_of_type_Int	I
    //   202: iload 8
    //   204: istore 6
    //   206: aload_2
    //   207: aload 11
    //   209: putfield 249	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   212: iload 8
    //   214: istore 6
    //   216: ldc 90
    //   218: iconst_1
    //   219: new 92	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   226: ldc 251
    //   228: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: iload 4
    //   233: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   236: ldc 253
    //   238: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_2
    //   242: getfield 249	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   245: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: iload 8
    //   256: istore 6
    //   258: ldc 90
    //   260: ldc_w 258
    //   263: aload_2
    //   264: invokevirtual 259	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:toString	()Ljava/lang/String;
    //   267: aload_2
    //   268: getfield 189	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   271: invokestatic 244	axhg:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   274: iload 7
    //   276: istore 5
    //   278: iload 4
    //   280: ifne +332 -> 612
    //   283: iload 5
    //   285: istore 6
    //   287: aload_0
    //   288: getfield 115	axem:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   291: aload_2
    //   292: getfield 189	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   295: ldc_w 261
    //   298: ldc_w 263
    //   301: new 92	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   308: ldc 202
    //   310: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload_2
    //   314: getfield 158	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_a_of_type_Int	I
    //   317: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   320: aload_2
    //   321: getfield 204	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_d_of_type_Int	I
    //   324: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: aload_2
    //   328: getfield 207	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   331: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   334: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: ldc 156
    //   339: invokestatic 210	axhg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   342: iload 5
    //   344: istore 6
    //   346: ldc 90
    //   348: ldc_w 265
    //   351: new 92	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   358: aload_2
    //   359: getfield 246	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_f_of_type_Int	I
    //   362: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   365: ldc_w 267
    //   368: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload_2
    //   372: getfield 249	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   375: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: aload_2
    //   382: getfield 189	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   385: invokestatic 244	axhg:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   388: iload 5
    //   390: ireturn
    //   391: iload 8
    //   393: istore 6
    //   395: aload 12
    //   397: ldc_w 269
    //   400: invokevirtual 273	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   403: astore 14
    //   405: iload 8
    //   407: istore 6
    //   409: aload 14
    //   411: ldc_w 275
    //   414: invokevirtual 231	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   417: astore 13
    //   419: iload 7
    //   421: istore 5
    //   423: iload 8
    //   425: istore 6
    //   427: aload_0
    //   428: getfield 35	axem:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   431: ifnull -153 -> 278
    //   434: iload 7
    //   436: istore 5
    //   438: iload 8
    //   440: istore 6
    //   442: aload 13
    //   444: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   447: ifne -169 -> 278
    //   450: iload 7
    //   452: istore 5
    //   454: iload 8
    //   456: istore 6
    //   458: aload_0
    //   459: getfield 115	axem:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   462: ifnull -184 -> 278
    //   465: iload 8
    //   467: istore 6
    //   469: aload 14
    //   471: ldc_w 277
    //   474: invokevirtual 227	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   477: ifeq +130 -> 607
    //   480: iload 8
    //   482: istore 6
    //   484: aload 14
    //   486: ldc_w 277
    //   489: invokevirtual 221	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   492: istore_3
    //   493: ldc 156
    //   495: astore 12
    //   497: iload 8
    //   499: istore 6
    //   501: aload 14
    //   503: ldc_w 279
    //   506: invokevirtual 227	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   509: ifeq +17 -> 526
    //   512: iload 8
    //   514: istore 6
    //   516: aload 14
    //   518: ldc_w 279
    //   521: invokevirtual 231	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   524: astore 12
    //   526: aload_2
    //   527: iload_3
    //   528: putfield 281	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_h_of_type_Int	I
    //   531: aload_2
    //   532: aload 12
    //   534: putfield 284	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:m	Ljava/lang/String;
    //   537: new 286	android/os/Bundle
    //   540: dup
    //   541: invokespecial 287	android/os/Bundle:<init>	()V
    //   544: astore 12
    //   546: aload 12
    //   548: ldc_w 289
    //   551: aload 13
    //   553: invokevirtual 293	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   556: aload 12
    //   558: ldc_w 295
    //   561: aload_2
    //   562: invokevirtual 299	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   565: aload_0
    //   566: getfield 35	axem:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   569: sipush 8001
    //   572: invokevirtual 303	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   575: astore 14
    //   577: aload 14
    //   579: aload 12
    //   581: invokevirtual 309	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   584: aload_0
    //   585: getfield 35	axem:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   588: aload 14
    //   590: invokevirtual 313	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   593: pop
    //   594: aload_0
    //   595: aload_2
    //   596: aload 13
    //   598: invokevirtual 316	axem:a	(Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;Ljava/lang/String;)V
    //   601: iconst_1
    //   602: istore 5
    //   604: goto -326 -> 278
    //   607: iconst_0
    //   608: istore_3
    //   609: goto -116 -> 493
    //   612: iload 5
    //   614: istore 6
    //   616: aload_0
    //   617: getfield 115	axem:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   620: aload_2
    //   621: getfield 189	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   624: ldc_w 261
    //   627: ldc_w 318
    //   630: new 92	java/lang/StringBuilder
    //   633: dup
    //   634: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   637: ldc_w 320
    //   640: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: iload 4
    //   645: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   648: aload 11
    //   650: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   656: new 92	java/lang/StringBuilder
    //   659: dup
    //   660: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   663: ldc 202
    //   665: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload_2
    //   669: getfield 158	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_a_of_type_Int	I
    //   672: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   675: aload_2
    //   676: getfield 204	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_d_of_type_Int	I
    //   679: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   682: aload_2
    //   683: getfield 207	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   686: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   689: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   692: invokestatic 210	axhg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   695: goto -353 -> 342
    //   698: astore 11
    //   700: ldc 90
    //   702: iconst_1
    //   703: new 92	java/lang/StringBuilder
    //   706: dup
    //   707: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   710: ldc_w 322
    //   713: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: aload 11
    //   718: invokevirtual 323	java/lang/Exception:toString	()Ljava/lang/String;
    //   721: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   727: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   730: ldc 90
    //   732: ldc_w 325
    //   735: aload 11
    //   737: invokevirtual 328	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   740: aload_2
    //   741: getfield 189	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   744: invokestatic 244	axhg:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   747: ldc 90
    //   749: ldc_w 330
    //   752: aload_1
    //   753: aload_2
    //   754: getfield 189	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   757: invokestatic 244	axhg:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   760: ldc 90
    //   762: ldc_w 332
    //   765: aload_2
    //   766: invokevirtual 259	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:toString	()Ljava/lang/String;
    //   769: aload_2
    //   770: getfield 189	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   773: invokestatic 244	axhg:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   776: aload_0
    //   777: getfield 115	axem:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   780: aload_2
    //   781: getfield 189	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   784: ldc_w 261
    //   787: ldc_w 318
    //   790: new 92	java/lang/StringBuilder
    //   793: dup
    //   794: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   797: ldc_w 320
    //   800: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: aload 11
    //   805: invokevirtual 335	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   808: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   814: new 92	java/lang/StringBuilder
    //   817: dup
    //   818: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   821: ldc 202
    //   823: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: aload_2
    //   827: getfield 158	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_a_of_type_Int	I
    //   830: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   833: aload_2
    //   834: getfield 204	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_d_of_type_Int	I
    //   837: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   840: aload_2
    //   841: getfield 207	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   844: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   847: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   850: invokestatic 210	axhg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   853: iload 6
    //   855: ireturn
    //   856: ldc 90
    //   858: ldc_w 325
    //   861: ldc_w 337
    //   864: aload_2
    //   865: getfield 189	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   868: invokestatic 244	axhg:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   871: aload_0
    //   872: getfield 115	axem:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   875: aload_2
    //   876: getfield 189	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   879: ldc_w 261
    //   882: ldc_w 318
    //   885: ldc_w 339
    //   888: new 92	java/lang/StringBuilder
    //   891: dup
    //   892: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   895: ldc 202
    //   897: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: aload_2
    //   901: getfield 158	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_a_of_type_Int	I
    //   904: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   907: aload_2
    //   908: getfield 204	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_d_of_type_Int	I
    //   911: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   914: aload_2
    //   915: getfield 207	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   918: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   921: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   924: invokestatic 210	axhg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   927: iconst_0
    //   928: ireturn
    //   929: astore 11
    //   931: iconst_1
    //   932: istore 6
    //   934: goto -234 -> 700
    //   937: ldc 156
    //   939: astore 11
    //   941: goto -809 -> 132
    //   944: goto -752 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	947	0	this	axem
    //   0	947	1	paramString	String
    //   0	947	2	paramTeamWorkFileImportInfo	TeamWorkFileImportInfo
    //   492	117	3	i	int
    //   103	541	4	j	int
    //   276	337	5	bool1	boolean
    //   80	853	6	bool2	boolean
    //   4	447	7	bool3	boolean
    //   1	512	8	bool4	boolean
    //   13	13	9	l	long
    //   130	519	11	str1	String
    //   698	106	11	localException1	Exception
    //   929	1	11	localException2	Exception
    //   939	1	11	str2	String
    //   90	490	12	localObject1	Object
    //   417	180	13	str3	String
    //   403	186	14	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   82	92	698	java/lang/Exception
    //   96	105	698	java/lang/Exception
    //   109	119	698	java/lang/Exception
    //   123	132	698	java/lang/Exception
    //   136	173	698	java/lang/Exception
    //   196	202	698	java/lang/Exception
    //   206	212	698	java/lang/Exception
    //   216	254	698	java/lang/Exception
    //   258	274	698	java/lang/Exception
    //   287	342	698	java/lang/Exception
    //   346	388	698	java/lang/Exception
    //   395	405	698	java/lang/Exception
    //   409	419	698	java/lang/Exception
    //   427	434	698	java/lang/Exception
    //   442	450	698	java/lang/Exception
    //   458	465	698	java/lang/Exception
    //   469	480	698	java/lang/Exception
    //   484	493	698	java/lang/Exception
    //   501	512	698	java/lang/Exception
    //   516	526	698	java/lang/Exception
    //   616	695	698	java/lang/Exception
    //   526	601	929	java/lang/Exception
  }
  
  private boolean c(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    long l = axhg.a(paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
    axhg.a(this.app, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString, "0X8009E9A", String.valueOf(l), "import_type=" + paramTeamWorkFileImportInfo.jdField_a_of_type_Int + paramTeamWorkFileImportInfo.jdField_d_of_type_Int + paramTeamWorkFileImportInfo.jdField_g_of_type_Int, "");
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2;
    int n;
    String str2;
    boolean bool1;
    label351:
    Object localObject3;
    label415:
    int i;
    int j;
    label699:
    Object localObject2;
    label908:
    Object localObject4;
    label1653:
    int k;
    if (!TextUtils.isEmpty(paramString))
    {
      bool2 = bool4;
      for (;;)
      {
        JSONObject localJSONObject;
        try
        {
          localJSONObject = new JSONObject(paramString);
          bool2 = bool4;
          n = localJSONObject.getInt("ret");
          bool2 = bool4;
          if (localJSONObject.has("msg"))
          {
            bool2 = bool4;
            localJSONObject.getString("msg");
          }
          bool2 = bool4;
          str2 = localJSONObject.getString("error");
          bool2 = bool4;
          axhg.a("TeamWorkFileImportHandler", "addFileImportJob end:" + paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString, String.valueOf(System.currentTimeMillis()), paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
          switch (n)
          {
          case 0: 
            bool2 = bool4;
            paramTeamWorkFileImportInfo.jdField_f_of_type_Int = n;
            bool2 = bool4;
            paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString = str2;
            bool2 = bool4;
            QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResult server ret: " + n + ",error: " + paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString);
            bool2 = bool4;
            axhg.a("TeamWorkFileImportHandler", "import file job fail, import info", paramTeamWorkFileImportInfo.toString(), paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
            bool1 = bool3;
            if (n != 0) {
              break label2711;
            }
            bool2 = bool1;
            axhg.a(this.app, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString, "0X8009E9B", "success", "import_type=" + paramTeamWorkFileImportInfo.jdField_a_of_type_Int + paramTeamWorkFileImportInfo.jdField_d_of_type_Int + paramTeamWorkFileImportInfo.jdField_g_of_type_Int, "");
            bool2 = bool1;
            axhg.a("TeamWorkFileImportHandler", "import result", paramTeamWorkFileImportInfo.jdField_f_of_type_Int + " " + paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
            return bool1;
          }
        }
        catch (Exception localException1) {}
        bool2 = bool4;
        localObject3 = localJSONObject.getString("url");
        bool1 = bool3;
        bool2 = bool4;
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          bool1 = bool3;
          bool2 = bool4;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            bool1 = bool3;
            bool2 = bool4;
            if (this.app != null)
            {
              bool2 = bool4;
              if (localJSONObject.has("urlType"))
              {
                bool2 = bool4;
                i = localJSONObject.getInt("urlType");
                bool2 = bool4;
                j = paramTeamWorkFileImportInfo.jdField_g_of_type_Int;
                bool2 = bool4;
                QLog.e("TeamWorkFileImportHandler", 1, " parseFileImportResult: " + i + ",importOption: " + j);
                bool2 = bool4;
                Object localObject1 = localObject3;
                if (!paramTeamWorkFileImportInfo.c()) {
                  break label2878;
                }
                bool2 = bool4;
                localObject3 = axfs.b((String)localObject3);
                if ((i == 1) || (i == 2))
                {
                  bool2 = bool4;
                  axhg.a(this.app, "0X8009ECF");
                }
                if (i == 2)
                {
                  bool2 = bool4;
                  QLog.w("TeamWorkFileImportHandler", 1, "online preview has edited cache, import again");
                  bool2 = bool4;
                  paramTeamWorkFileImportInfo.jdField_h_of_type_Int = i;
                  bool2 = bool4;
                  paramTeamWorkFileImportInfo.o = ((String)localObject3);
                  bool1 = bool3;
                  continue;
                  QLog.e("TeamWorkFileImportHandler", 1, " --- parseFileImportResult JSONException: " + localException1.toString());
                  awqx.b(this.app, "dc00898", "", "", "0X800906B", "0X800906B", 0, 0, "", "", "", "");
                  axhg.a("TeamWorkFileImportHandler", "parse import file json fail", localException1.getLocalizedMessage(), paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
                  axhg.a("TeamWorkFileImportHandler", "parse import file json fail, param", paramString, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
                  axhg.a("TeamWorkFileImportHandler", "parse import file json fail, import info", paramTeamWorkFileImportInfo.toString(), paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
                  axhg.a(this.app, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString, "0X8009E9B", "fail", "err=" + localException1.getMessage(), "import_type=" + paramTeamWorkFileImportInfo.jdField_a_of_type_Int + paramTeamWorkFileImportInfo.jdField_d_of_type_Int + paramTeamWorkFileImportInfo.jdField_g_of_type_Int);
                  return bool2;
                }
              }
              else
              {
                i = 0;
                continue;
              }
              if (i == 1)
              {
                bool2 = bool4;
                paramTeamWorkFileImportInfo.o = null;
                localObject2 = localObject3;
                localObject3 = "";
                bool2 = bool4;
                if (localJSONObject.has("doc_id"))
                {
                  bool2 = bool4;
                  localObject3 = localJSONObject.getString("doc_id");
                }
                bool2 = bool4;
                if (paramTeamWorkFileImportInfo.jdField_g_of_type_Int == 7)
                {
                  bool2 = bool4;
                  if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1)
                  {
                    bool2 = bool4;
                    if (!TextUtils.isEmpty((CharSequence)localObject3))
                    {
                      bool2 = bool4;
                      a((String)localObject3);
                    }
                    bool2 = bool4;
                    if (!TextUtils.isEmpty((CharSequence)localObject2))
                    {
                      bool2 = bool4;
                      notifyUI(5, true, new Object[] { Integer.valueOf(0) });
                    }
                  }
                }
                bool2 = bool4;
                if (paramTeamWorkFileImportInfo.jdField_g_of_type_Int == 1)
                {
                  bool2 = bool4;
                  notifyUI(6, true, new Object[] { localObject2, localObject3, paramTeamWorkFileImportInfo });
                }
                bool2 = true;
              }
            }
          }
        }
        try
        {
          paramTeamWorkFileImportInfo.jdField_h_of_type_Int = i;
          paramTeamWorkFileImportInfo.m = ((String)localObject3);
          localObject3 = new Bundle();
          ((Bundle)localObject3).putString("url", (String)localObject2);
          ((Bundle)localObject3).putParcelable("fileInfo", paramTeamWorkFileImportInfo);
          localObject4 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8001);
          ((Message)localObject4).setData((Bundle)localObject3);
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject4);
          a(paramTeamWorkFileImportInfo, (String)localObject2);
          if ((j != 1) && (j != 7) && (!paramTeamWorkFileImportInfo.a()) && (!paramTeamWorkFileImportInfo.b())) {
            b(paramTeamWorkFileImportInfo, (String)localObject2);
          }
          awqx.b(this.app, "dc00898", "", "", "0X8009066", "0X8009066", 0, 0, "", "", "", "");
          bool1 = true;
        }
        catch (Exception localException2) {}
        localObject2 = localObject3;
        if (i != 0) {
          break label2878;
        }
        bool2 = bool4;
        localObject2 = localObject3;
        if (TextUtils.isEmpty(paramTeamWorkFileImportInfo.o)) {
          break label2878;
        }
        bool2 = bool4;
        localObject2 = axfs.a((String)localObject3, paramTeamWorkFileImportInfo.o);
        bool2 = bool4;
        QLog.w("TeamWorkFileImportHandler", 1, "append edited url: " + (String)localObject2);
        break label2878;
        localObject3 = "";
        localObject4 = "";
        String str1 = "";
        bool2 = bool4;
        localObject2 = localObject3;
        if (localJSONObject.has("filePath"))
        {
          bool2 = bool4;
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(localJSONObject.getString("filePath")))
          {
            bool2 = bool4;
            localObject2 = localJSONObject.getString("filePath");
          }
        }
        bool2 = bool4;
        localObject3 = localObject4;
        if (localJSONObject.has("md5"))
        {
          bool2 = bool4;
          localObject3 = localObject4;
          if (!TextUtils.isEmpty(localJSONObject.getString("md5")))
          {
            bool2 = bool4;
            localObject3 = localJSONObject.getString("md5");
          }
        }
        bool2 = bool4;
        localObject4 = str1;
        if (localJSONObject.has("fileName"))
        {
          bool2 = bool4;
          localObject4 = str1;
          if (!TextUtils.isEmpty(localJSONObject.getString("fileName")))
          {
            bool2 = bool4;
            localObject4 = localJSONObject.getString("fileName");
          }
        }
        bool2 = bool4;
        str1 = paramTeamWorkFileImportInfo.jdField_g_of_type_JavaLangString;
        bool2 = bool4;
        paramTeamWorkFileImportInfo.i = String.format(axdz.p, new Object[] { URLEncoder.encode(str1, "UTF-8"), URLEncoder.encode((String)localObject3, "UTF-8"), URLEncoder.encode((String)localObject4, "UTF-8"), URLEncoder.encode((String)localObject2, "UTF-8"), "preview" });
        bool2 = bool4;
        paramTeamWorkFileImportInfo.jdField_f_of_type_Int = n;
        bool2 = bool4;
        paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString = str2;
        bool2 = bool4;
        QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResult server ret: " + n + ",error: " + paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString);
        bool1 = bool3;
        continue;
        bool2 = bool4;
        localObject2 = new JSONObject(str2);
        bool2 = bool4;
        if (!((JSONObject)localObject2).has("startRow")) {
          break label2881;
        }
        bool2 = bool4;
        i = ((JSONObject)localObject2).getInt("startRow");
        bool2 = bool4;
        if (!((JSONObject)localObject2).has("endRow")) {
          break label2886;
        }
        bool2 = bool4;
        j = ((JSONObject)localObject2).getInt("endRow");
        label1682:
        bool2 = bool4;
        if (!((JSONObject)localObject2).has("startCol")) {
          break label2892;
        }
        bool2 = bool4;
        k = ((JSONObject)localObject2).getInt("startCol");
        label1711:
        bool2 = bool4;
        if (!((JSONObject)localObject2).has("endCol")) {
          break label2898;
        }
        bool2 = bool4;
      }
    }
    label2711:
    label2878:
    label2881:
    label2886:
    label2892:
    label2898:
    for (int m = ((JSONObject)localObject2).getInt("endCol");; m = 0)
    {
      bool2 = bool4;
      localObject2 = axfs.a(k);
      bool2 = bool4;
      localObject3 = axfs.a(m);
      bool2 = bool4;
      localObject4 = new StringBuilder();
      bool2 = bool4;
      ((StringBuilder)localObject4).append(this.app.getApp().getResources().getString(2131654223));
      if ((i != 0) && (k != 0)) {
        if (i == j)
        {
          bool2 = bool4;
          ((StringBuilder)localObject4).append(this.app.getApp().getResources().getString(2131654219));
          bool2 = bool4;
          ((StringBuilder)localObject4).append("1");
          bool2 = bool4;
          ((StringBuilder)localObject4).append(String.format(this.app.getApp().getResources().getString(2131654225), new Object[] { Integer.valueOf(i) }));
          label1895:
          if (k != m) {
            break label2155;
          }
          bool2 = bool4;
          ((StringBuilder)localObject4).append("\n");
          bool2 = bool4;
          ((StringBuilder)localObject4).append(this.app.getApp().getResources().getString(2131654219));
          bool2 = bool4;
          ((StringBuilder)localObject4).append("2");
          bool2 = bool4;
          ((StringBuilder)localObject4).append(String.format(this.app.getApp().getResources().getString(2131654224), new Object[] { localObject2 }));
        }
      }
      for (;;)
      {
        bool2 = bool4;
        paramTeamWorkFileImportInfo.jdField_f_of_type_Int = n;
        bool2 = bool4;
        paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString = ((StringBuilder)localObject4).toString();
        bool2 = bool4;
        QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResult server ret: " + n + ",error: " + paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString);
        bool1 = bool3;
        break;
        bool2 = bool4;
        ((StringBuilder)localObject4).append(this.app.getApp().getResources().getString(2131654219));
        bool2 = bool4;
        ((StringBuilder)localObject4).append("1");
        bool2 = bool4;
        ((StringBuilder)localObject4).append(String.format(this.app.getApp().getResources().getString(2131654222), new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        break label1895;
        label2155:
        bool2 = bool4;
        ((StringBuilder)localObject4).append("\n");
        bool2 = bool4;
        ((StringBuilder)localObject4).append(this.app.getApp().getResources().getString(2131654219));
        bool2 = bool4;
        ((StringBuilder)localObject4).append("2");
        bool2 = bool4;
        ((StringBuilder)localObject4).append(String.format(this.app.getApp().getResources().getString(2131654221), new Object[] { localObject2, localObject3 }));
        continue;
        if ((i != 0) && (k == 0))
        {
          if (i == j)
          {
            bool2 = bool4;
            ((StringBuilder)localObject4).append(this.app.getApp().getResources().getString(2131654219));
            bool2 = bool4;
            ((StringBuilder)localObject4).append(String.format(this.app.getApp().getResources().getString(2131654225), new Object[] { Integer.valueOf(i) }));
          }
          else
          {
            bool2 = bool4;
            ((StringBuilder)localObject4).append(this.app.getApp().getResources().getString(2131654219));
            bool2 = bool4;
            ((StringBuilder)localObject4).append(String.format(this.app.getApp().getResources().getString(2131654222), new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
          }
        }
        else if ((i == 0) && (k != 0)) {
          if (k == m)
          {
            bool2 = bool4;
            ((StringBuilder)localObject4).append(this.app.getApp().getResources().getString(2131654219));
            bool2 = bool4;
            ((StringBuilder)localObject4).append(String.format(this.app.getApp().getResources().getString(2131654224), new Object[] { localObject2 }));
          }
          else
          {
            bool2 = bool4;
            ((StringBuilder)localObject4).append(this.app.getApp().getResources().getString(2131654219));
            bool2 = bool4;
            ((StringBuilder)localObject4).append(String.format(this.app.getApp().getResources().getString(2131654221), new Object[] { localObject2, localObject3 }));
          }
        }
      }
      bool2 = bool4;
      QLog.i("TeamWorkFileImportHandler", 1, " parseFileImportTendoc: RETCODE_CGI_NO_PUBLIC_CACHE");
      bool2 = bool4;
      notifyUI(7, false, new Object[] { paramTeamWorkFileImportInfo });
      bool2 = bool4;
      paramTeamWorkFileImportInfo.jdField_h_of_type_Int = 0;
      bool1 = bool3;
      break label351;
      bool2 = bool4;
      QLog.i("TeamWorkFileImportHandler", 1, " parseFileImportTendoc: RETCODE_CGI_NO_USER_CACHE");
      bool2 = bool4;
      notifyUI(7, false, new Object[] { paramTeamWorkFileImportInfo });
      bool2 = bool4;
      paramTeamWorkFileImportInfo.jdField_h_of_type_Int = 0;
      bool1 = bool3;
      break label351;
      bool2 = bool4;
      c(paramTeamWorkFileImportInfo);
      bool2 = bool4;
      e(paramTeamWorkFileImportInfo);
      bool2 = bool4;
      notifyUI(5, true, new Object[] { Integer.valueOf(1) });
      bool1 = bool3;
      break label351;
      bool2 = bool1;
      axhg.a(this.app, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString, "0X8009E9B", "fail", "err=" + n + str2, "import_type=" + paramTeamWorkFileImportInfo.jdField_a_of_type_Int + paramTeamWorkFileImportInfo.jdField_d_of_type_Int + paramTeamWorkFileImportInfo.jdField_g_of_type_Int);
      break label415;
      axhg.a("TeamWorkFileImportHandler", "parse import file json fail", "no result string", paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
      axhg.a(this.app, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString, "0X8009E9B", "fail", "err=EMPTY RESULT", "import_type=" + paramTeamWorkFileImportInfo.jdField_a_of_type_Int + paramTeamWorkFileImportInfo.jdField_d_of_type_Int + paramTeamWorkFileImportInfo.jdField_g_of_type_Int);
      return false;
      break label699;
      break;
      break label908;
      i = 0;
      break label1653;
      j = 0;
      break label1682;
      k = 0;
      break label1711;
    }
  }
  
  public String a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return null;
    }
    String str = "";
    if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1) {
      str = paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString + "_" + paramTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString;
    }
    while (axea.a(paramTeamWorkFileImportInfo))
    {
      return (String)this.d.get(str);
      if ((paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 3000) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 0)) {
        str = paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString + "_" + paramTeamWorkFileImportInfo.jdField_a_of_type_Long + "_" + paramTeamWorkFileImportInfo.jdField_b_of_type_Long;
      } else if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.c)) {
        str = paramTeamWorkFileImportInfo.c;
      } else if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.jdField_f_of_type_JavaLangString)) {
        str = paramTeamWorkFileImportInfo.jdField_f_of_type_JavaLangString;
      }
    }
    return (String)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
  }
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null) && (paramTeamWorkFileImportInfo != null))
    {
      axhg.a(paramTeamWorkFileImportInfo);
      if (paramTeamWorkFileImportInfo.jdField_d_of_type_Int != 10) {
        break label94;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new axek(paramTeamWorkFileImportInfo, this.app));
    }
    for (;;)
    {
      a();
      axhg.a(paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
      axhg.a("TeamWorkFileImportHandler", "addFileImportJob start:" + paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString, String.valueOf(System.currentTimeMillis()), paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
      return;
      label94:
      if (paramTeamWorkFileImportInfo.jdField_d_of_type_Int == 6) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new axes(paramTeamWorkFileImportInfo, this.app));
      } else if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new axev(paramTeamWorkFileImportInfo, this.app));
      } else if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 3000) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new axet(paramTeamWorkFileImportInfo, this.app));
      } else if ((paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 6000) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 6003)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new axes(paramTeamWorkFileImportInfo, this.app));
      } else if (paramTeamWorkFileImportInfo.jdField_d_of_type_Int == 12) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new axex(paramTeamWorkFileImportInfo, this.app));
      } else {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new axeq(paramTeamWorkFileImportInfo, this.app));
      }
    }
  }
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    if ((paramString == null) || (paramTeamWorkFileImportInfo == null)) {
      return;
    }
    String str = b(paramTeamWorkFileImportInfo);
    if (axea.a(paramTeamWorkFileImportInfo))
    {
      paramString = axhg.b(paramString);
      this.d.put(str, axhg.a(paramString, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString));
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, axhg.a(paramString, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString));
  }
  
  public void a(String paramString)
  {
    if ((this.app == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(new TeamWorkFileImportHandler.5(this, paramString));
  }
  
  public void a(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, int paramInt)
  {
    if (this.app == null) {
      return;
    }
    a(new TeamWorkFileImportHandler.3(this, paramJSONObject, paramTeamWorkFileImportInfo, paramInt));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    boolean bool2 = true;
    if (paramTeamWorkFileImportInfo == null) {
      return false;
    }
    boolean bool1;
    if (axea.a(paramTeamWorkFileImportInfo)) {
      if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.c)) && (this.c.containsKey(paramTeamWorkFileImportInfo.c))) {
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      paramTeamWorkFileImportInfo = b(paramTeamWorkFileImportInfo);
      bool1 = bool2;
      if (!this.c.containsKey(paramTeamWorkFileImportInfo))
      {
        do
        {
          bool1 = false;
          break;
          if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.c))
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramTeamWorkFileImportInfo.c)) {
              break;
            }
          }
          paramTeamWorkFileImportInfo = b(paramTeamWorkFileImportInfo);
        } while (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramTeamWorkFileImportInfo));
        bool1 = bool2;
      }
    }
  }
  
  public boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, boolean paramBoolean)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.c)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramTeamWorkFileImportInfo.c))) {
      paramBoolean = true;
    }
    for (;;)
    {
      return paramBoolean;
      paramTeamWorkFileImportInfo = b(paramTeamWorkFileImportInfo);
      paramTeamWorkFileImportInfo = (TeamWorkFileImportInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramTeamWorkFileImportInfo);
      if (paramTeamWorkFileImportInfo != null)
      {
        paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean = paramBoolean;
        paramBoolean = true;
      }
      else
      {
        paramBoolean = false;
      }
    }
  }
  
  public boolean a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    long l = axhg.a(paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
    axhg.a(this.app, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString, "0X8009E9A", String.valueOf(l), "import_type=" + paramTeamWorkFileImportInfo.jdField_a_of_type_Int + paramTeamWorkFileImportInfo.jdField_d_of_type_Int + paramTeamWorkFileImportInfo.jdField_g_of_type_Int, "");
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1;
    int n;
    String str2;
    boolean bool2;
    Object localObject1;
    Object localObject2;
    int i;
    label945:
    int j;
    label972:
    int k;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool4;
      for (;;)
      {
        JSONObject localJSONObject;
        try
        {
          localJSONObject = new JSONObject(paramString);
          bool1 = bool4;
          n = localJSONObject.getInt("ret");
          bool1 = bool4;
          if (localJSONObject.has("msg"))
          {
            bool1 = bool4;
            localJSONObject.getString("msg");
          }
          bool1 = bool4;
          str2 = localJSONObject.getString("error");
          switch (n)
          {
          case 0: 
            bool1 = bool4;
            paramTeamWorkFileImportInfo.jdField_f_of_type_Int = n;
            bool1 = bool4;
            paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString = str2;
            bool1 = bool4;
            QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResultForH5 server ret: " + n + ",error: " + paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString);
            bool2 = bool3;
            if (n != 0) {
              break label1850;
            }
            bool1 = bool2;
            axhg.a(this.app, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString, "0X8009E9B", "success", "import_type=" + paramTeamWorkFileImportInfo.jdField_a_of_type_Int + paramTeamWorkFileImportInfo.jdField_d_of_type_Int + paramTeamWorkFileImportInfo.jdField_g_of_type_Int, "");
          }
        }
        catch (Exception paramString)
        {
          QLog.e("TeamWorkFileImportHandler", 1, " --- parseFileImportResultForH5 JSONException: " + paramString.toString());
          axhg.a(this.app, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString, "0X8009E9B", "fail", "err=" + paramString.getMessage(), "import_type=" + paramTeamWorkFileImportInfo.jdField_a_of_type_Int + paramTeamWorkFileImportInfo.jdField_d_of_type_Int + paramTeamWorkFileImportInfo.jdField_g_of_type_Int);
          return bool1;
        }
        bool1 = bool4;
        paramString = localJSONObject.getString("url");
        bool2 = bool3;
        bool1 = bool4;
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          bool2 = bool3;
          bool1 = bool4;
          if (!TextUtils.isEmpty(paramString))
          {
            bool2 = bool3;
            bool1 = bool4;
            if (this.app != null)
            {
              bool3 = true;
              bool2 = true;
              bool1 = bool3;
              localObject1 = new Bundle();
              bool1 = bool3;
              ((Bundle)localObject1).putString("url", paramString);
              bool1 = bool3;
              ((Bundle)localObject1).putParcelable("fileInfo", paramTeamWorkFileImportInfo);
              bool1 = bool3;
              localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8001);
              bool1 = bool3;
              ((Message)localObject2).setData((Bundle)localObject1);
              bool1 = bool3;
              this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
              bool1 = bool3;
              a(paramTeamWorkFileImportInfo, paramString);
              continue;
              localObject1 = "";
              localObject2 = "";
              String str1 = "";
              bool1 = bool4;
              paramString = (String)localObject1;
              if (localJSONObject.has("filePath"))
              {
                bool1 = bool4;
                paramString = (String)localObject1;
                if (!TextUtils.isEmpty(localJSONObject.getString("filePath")))
                {
                  bool1 = bool4;
                  paramString = localJSONObject.getString("filePath");
                }
              }
              bool1 = bool4;
              localObject1 = localObject2;
              if (localJSONObject.has("md5"))
              {
                bool1 = bool4;
                localObject1 = localObject2;
                if (!TextUtils.isEmpty(localJSONObject.getString("md5")))
                {
                  bool1 = bool4;
                  localObject1 = localJSONObject.getString("md5");
                }
              }
              bool1 = bool4;
              localObject2 = str1;
              if (localJSONObject.has("fileName"))
              {
                bool1 = bool4;
                localObject2 = str1;
                if (!TextUtils.isEmpty(localJSONObject.getString("fileName")))
                {
                  bool1 = bool4;
                  localObject2 = localJSONObject.getString("fileName");
                }
              }
              bool1 = bool4;
              str1 = paramTeamWorkFileImportInfo.jdField_g_of_type_JavaLangString;
              bool1 = bool4;
              paramTeamWorkFileImportInfo.i = String.format(axdz.p, new Object[] { URLEncoder.encode(str1, "UTF-8"), URLEncoder.encode((String)localObject1, "UTF-8"), URLEncoder.encode((String)localObject2, "UTF-8"), URLEncoder.encode(paramString, "UTF-8"), "import" });
              bool1 = bool4;
              paramTeamWorkFileImportInfo.jdField_f_of_type_Int = n;
              bool1 = bool4;
              paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString = str2;
              bool1 = bool4;
              QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResultForH5 server ret: " + n + ",error: " + paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString);
              bool2 = bool3;
              continue;
              bool1 = bool4;
              paramString = new JSONObject(str2);
              bool1 = bool4;
              if (!paramString.has("startRow")) {
                break label2000;
              }
              bool1 = bool4;
              i = paramString.getInt("startRow");
              bool1 = bool4;
              if (!paramString.has("endRow")) {
                break label2005;
              }
              bool1 = bool4;
              j = paramString.getInt("endRow");
              bool1 = bool4;
              if (!paramString.has("startCol")) {
                break label2011;
              }
              bool1 = bool4;
              k = paramString.getInt("startCol");
              label999:
              bool1 = bool4;
              if (!paramString.has("endCol")) {
                break label2017;
              }
              bool1 = bool4;
            }
          }
        }
      }
    }
    label1180:
    label1439:
    label1850:
    label1997:
    label2000:
    label2005:
    label2011:
    label2017:
    for (int m = paramString.getInt("endCol");; m = 0)
    {
      bool1 = bool4;
      paramString = axfs.a(k);
      bool1 = bool4;
      localObject1 = axfs.a(m);
      bool1 = bool4;
      localObject2 = new StringBuilder();
      bool1 = bool4;
      ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131654223));
      if ((i != 0) && (k != 0)) {
        if (i == j)
        {
          bool1 = bool4;
          ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131654219));
          bool1 = bool4;
          ((StringBuilder)localObject2).append("1");
          bool1 = bool4;
          ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131654225), new Object[] { Integer.valueOf(i) }));
          if (k != m) {
            break label1439;
          }
          bool1 = bool4;
          ((StringBuilder)localObject2).append("\n");
          bool1 = bool4;
          ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131654219));
          bool1 = bool4;
          ((StringBuilder)localObject2).append("2");
          bool1 = bool4;
          ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131654224), new Object[] { paramString }));
        }
      }
      for (;;)
      {
        bool1 = bool4;
        paramTeamWorkFileImportInfo.jdField_f_of_type_Int = n;
        bool1 = bool4;
        paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
        bool1 = bool4;
        QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResultForH5 server ret: " + n + ",error: " + paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString);
        bool2 = bool3;
        break;
        bool1 = bool4;
        ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131654219));
        bool1 = bool4;
        ((StringBuilder)localObject2).append("1");
        bool1 = bool4;
        ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131654222), new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        break label1180;
        bool1 = bool4;
        ((StringBuilder)localObject2).append("\n");
        bool1 = bool4;
        ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131654219));
        bool1 = bool4;
        ((StringBuilder)localObject2).append("2");
        bool1 = bool4;
        ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131654221), new Object[] { paramString, localObject1 }));
        continue;
        if ((i != 0) && (k == 0))
        {
          if (i == j)
          {
            bool1 = bool4;
            ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131654219));
            bool1 = bool4;
            ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131654225), new Object[] { Integer.valueOf(i) }));
          }
          else
          {
            bool1 = bool4;
            ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131654219));
            bool1 = bool4;
            ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131654222), new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
          }
        }
        else if ((i == 0) && (k != 0)) {
          if (k == m)
          {
            bool1 = bool4;
            ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131654219));
            bool1 = bool4;
            ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131654224), new Object[] { paramString }));
          }
          else
          {
            bool1 = bool4;
            ((StringBuilder)localObject2).append(this.app.getApp().getResources().getString(2131654219));
            bool1 = bool4;
            ((StringBuilder)localObject2).append(String.format(this.app.getApp().getResources().getString(2131654221), new Object[] { paramString, localObject1 }));
          }
        }
      }
      bool1 = bool2;
      axhg.a(this.app, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString, "0X8009E9B", "fail", "err=" + n + str2, "import_type=" + paramTeamWorkFileImportInfo.jdField_a_of_type_Int + paramTeamWorkFileImportInfo.jdField_d_of_type_Int + paramTeamWorkFileImportInfo.jdField_g_of_type_Int);
      break label1997;
      axhg.a(this.app, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString, "0X8009E9B", "fail", "err=EMPTY RESULT", "import_type=" + paramTeamWorkFileImportInfo.jdField_a_of_type_Int + paramTeamWorkFileImportInfo.jdField_d_of_type_Int + paramTeamWorkFileImportInfo.jdField_g_of_type_Int);
      return false;
      break;
      return bool2;
      i = 0;
      break label945;
      j = 0;
      break label972;
      k = 0;
      break label999;
    }
  }
  
  public void b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo != null)
    {
      if (!paramTeamWorkFileImportInfo.jdField_a_of_type_Boolean) {
        break label48;
      }
      if (!axea.a(paramTeamWorkFileImportInfo)) {
        break label33;
      }
      this.c.put(b(paramTeamWorkFileImportInfo), paramTeamWorkFileImportInfo);
    }
    label33:
    label48:
    while (TextUtils.isEmpty(paramTeamWorkFileImportInfo.c))
    {
      return;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(b(paramTeamWorkFileImportInfo), paramTeamWorkFileImportInfo);
      return;
    }
    if (axea.a(paramTeamWorkFileImportInfo))
    {
      this.c.put(paramTeamWorkFileImportInfo.c, paramTeamWorkFileImportInfo);
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramTeamWorkFileImportInfo.c, paramTeamWorkFileImportInfo);
  }
  
  public void b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    if ((paramTeamWorkFileImportInfo == null) || (TextUtils.isEmpty(paramString))) {}
    boolean bool;
    do
    {
      return;
      QLog.d("TeamWorkFileImportHandler", 1, " --- createGrayTips ");
      bool = amlh.a().e();
    } while (((!paramTeamWorkFileImportInfo.jdField_b_of_type_Boolean) && (!paramTeamWorkFileImportInfo.c())) || (!bool));
    if (paramTeamWorkFileImportInfo.c()) {}
    for (String str = String.format(this.app.getApp().getString(2131654245), new Object[] { "\"" + apdh.b(paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString) + "\"" });; str = String.format(this.app.getApp().getString(2131654244), new Object[] { "\"" + apdh.b(paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString) + "\"" }))
    {
      MessageRecord localMessageRecord = awbi.a(-2063);
      long l = awao.a();
      localMessageRecord.init(this.app.getCurrentAccountUin(), paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString, paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString, str, l, -2063, paramTeamWorkFileImportInfo.jdField_a_of_type_Int, l);
      localMessageRecord.isread = true;
      localMessageRecord.saveExtInfoToExtStr("key_team_work_ext_info_new_url", paramString);
      localMessageRecord.saveExtInfoToExtStr("team_work_is_message_convert", Boolean.toString(paramTeamWorkFileImportInfo.jdField_f_of_type_Boolean));
      this.app.a().a(localMessageRecord, this.app.getCurrentAccountUin());
      return;
    }
  }
  
  public void b(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, int paramInt)
  {
    if (this.app == null) {
      return;
    }
    a(new TeamWorkFileImportHandler.8(this, paramTeamWorkFileImportInfo, paramJSONObject, paramInt));
  }
  
  public void c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return;
    }
    String str;
    if (axea.a(paramTeamWorkFileImportInfo)) {
      if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.c)) && (this.c.containsKey(paramTeamWorkFileImportInfo.c)))
      {
        str = paramTeamWorkFileImportInfo.c;
        if (!TextUtils.isEmpty(str)) {
          this.c.remove(str);
        }
      }
    }
    label127:
    for (;;)
    {
      paramTeamWorkFileImportInfo.jdField_k_of_type_Int = 0;
      return;
      str = b(paramTeamWorkFileImportInfo);
      break;
      if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.c)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramTeamWorkFileImportInfo.c))) {}
      for (str = paramTeamWorkFileImportInfo.c;; str = b(paramTeamWorkFileImportInfo))
      {
        if (TextUtils.isEmpty(str)) {
          break label127;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
        break;
      }
    }
  }
  
  public void d(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8002);
      localMessage.obj = paramTeamWorkFileImportInfo;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  public void e(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return;
    }
    String str = b(paramTeamWorkFileImportInfo);
    if (axea.a(paramTeamWorkFileImportInfo))
    {
      this.d.remove(str);
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
  }
  
  public void f(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    a(new TeamWorkFileImportHandler.1(this, paramTeamWorkFileImportInfo));
  }
  
  public void g(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    a(new TeamWorkFileImportHandler.2(this, paramTeamWorkFileImportInfo));
  }
  
  public void h(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    a(new TeamWorkFileImportHandler.4(this, paramTeamWorkFileImportInfo));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        paramMessage = paramMessage.getData();
        TeamWorkFileImportInfo localTeamWorkFileImportInfo = (TeamWorkFileImportInfo)paramMessage.getParcelable("fileInfo");
        String str = paramMessage.getString("url");
        c(localTeamWorkFileImportInfo);
        if (QLog.isDevelopLevel()) {
          QLog.e("TeamWorkFileImportHandler", 1, "MSG_FILE_IMPORT_SUCCESS:" + str);
        }
        paramMessage = str;
        if (localTeamWorkFileImportInfo != null)
        {
          str = axhg.a(str, localTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
          paramMessage = str;
          if (axea.a(localTeamWorkFileImportInfo)) {
            paramMessage = axhg.b(str);
          }
        }
        notifyUI(1, true, new Object[] { paramMessage, localTeamWorkFileImportInfo });
        awqx.b(this.app, "CliOper", "", "", "0X8008FB6", "0X8008FB6", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.i("teamConvert", 2, "convert finish time [" + System.currentTimeMillis() / 1000L + "]");
        }
      } while (!this.jdField_b_of_type_Boolean);
      bbmy.a(BaseApplicationImpl.getApplication(), 2, BaseApplicationImpl.getApplication().getString(2131654230), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131167766));
      return true;
      paramMessage = (TeamWorkFileImportInfo)paramMessage.obj;
      c(paramMessage);
      notifyUI(2, true, paramMessage);
    } while (!QLog.isDevelopLevel());
    QLog.e("TeamWorkFileImportHandler", 1, "MSG_FILE_IMPORT_ERROR:" + paramMessage.jdField_b_of_type_JavaLangString);
    return true;
  }
  
  public void i(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    a(new TeamWorkFileImportHandler.7(this, paramTeamWorkFileImportInfo));
  }
  
  protected Class<? extends ajfe> observerClass()
  {
    return axey.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axem
 * JD-Core Version:    0.7.0.1
 */