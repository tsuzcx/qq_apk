import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;

public class aypz
{
  AsyncTask<Integer, Void, Bundle> jdField_a_of_type_AndroidOsAsyncTask;
  Handler jdField_a_of_type_AndroidOsHandler;
  String jdField_a_of_type_JavaLangString;
  WeakReference<NearbyPeopleProfileActivity> jdField_a_of_type_JavaLangRefWeakReference;
  NewIntent jdField_a_of_type_MqqAppNewIntent;
  public String b;
  public String c;
  public String d;
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localActivity == null);
    if (this.jdField_a_of_type_MqqAppNewIntent != null)
    {
      this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
      this.jdField_a_of_type_MqqAppNewIntent = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d(getClass().getSimpleName(), 2, "lauchApp time out");
    }
    bjva.a(localActivity, "com.guagua.qiqi", bcqt.a("pt=$PT$&at=$AT$&openid=$OPID$&pf=$PF$"), 335544320);
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    NearbyPeopleProfileActivity localNearbyPeopleProfileActivity;
    do
    {
      do
      {
        return;
        localNearbyPeopleProfileActivity = (NearbyPeopleProfileActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      } while (localNearbyPeopleProfileActivity == null);
      if (paramInt == 2) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      if (!TextUtils.isEmpty(this.d)) {
        break;
      }
    } while (this.jdField_a_of_type_AndroidOsAsyncTask != null);
    this.jdField_a_of_type_AndroidOsAsyncTask = new ayqa(this);
    this.jdField_a_of_type_AndroidOsAsyncTask.execute(new Integer[] { Integer.valueOf(paramInt) });
    return;
    Bundle localBundle = new Bundle();
    localBundle.putString(bjwo.b, this.c);
    localBundle.putString(bjwo.j, this.d);
    localBundle.putString(bjwo.f, this.b);
    localBundle.putInt(bjwo.k, paramInt);
    localBundle.putString(bjwo.i, "ANDROIDQQ.MSG.QIQI");
    localBundle.putString(bjwo.l, "");
    localBundle.putBoolean(bjwo.x, false);
    localBundle.putBoolean(bjwo.g, true);
    localBundle.putBoolean(bjwo.h, false);
    bjwk.a(localNearbyPeopleProfileActivity, localBundle, "biz_src_yyb", null, 0);
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (paramLong == 0L)) {}
    NearbyPeopleProfileActivity localNearbyPeopleProfileActivity;
    do
    {
      return;
      localNearbyPeopleProfileActivity = (NearbyPeopleProfileActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localNearbyPeopleProfileActivity == null);
    QQAppInterface localQQAppInterface = localNearbyPeopleProfileActivity.app;
    String str = ((TicketManager)localQQAppInterface.getManager(2)).getSkey(localQQAppInterface.getAccount());
    this.jdField_a_of_type_JavaLangString = ("pt=$PT$&at=$AT$&openid=$OPID$&pf=$PF$&roomid=" + paramLong);
    a(localQQAppInterface, localNearbyPeopleProfileActivity, "1101674847", "com.guagua.qiqi", str, 335544320);
  }
  
  /* Error */
  public void a(com.tencent.common.app.AppInterface paramAppInterface, android.content.Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 10
    //   3: new 216	ayqb
    //   6: dup
    //   7: aload_0
    //   8: aload 4
    //   10: aload_2
    //   11: iload 6
    //   13: invokespecial 219	ayqb:<init>	(Laypz;Ljava/lang/String;Landroid/content/Context;I)V
    //   16: astore 14
    //   18: aload_0
    //   19: getfield 28	aypz:jdField_a_of_type_MqqAppNewIntent	Lmqq/app/NewIntent;
    //   22: ifnonnull +17 -> 39
    //   25: aload_0
    //   26: new 30	mqq/app/NewIntent
    //   29: dup
    //   30: aload_2
    //   31: ldc 221
    //   33: invokespecial 224	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   36: putfield 28	aypz:jdField_a_of_type_MqqAppNewIntent	Lmqq/app/NewIntent;
    //   39: new 226	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest
    //   42: dup
    //   43: invokespecial 227	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:<init>	()V
    //   46: astore 15
    //   48: aload_1
    //   49: invokevirtual 232	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   52: invokestatic 238	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   55: lstore 8
    //   57: aload 15
    //   59: getfield 242	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:uin	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   62: lload 8
    //   64: invokevirtual 247	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   67: aload_3
    //   68: invokestatic 238	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   71: lstore 8
    //   73: aload 15
    //   75: getfield 250	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:client_id	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   78: lload 8
    //   80: invokevirtual 247	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   83: aload 15
    //   85: getfield 254	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:pf	Lcom/tencent/mobileqq/pb/PBStringField;
    //   88: ldc 148
    //   90: invokevirtual 259	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   93: aload_2
    //   94: invokestatic 262	bjva:a	(Landroid/content/Context;)Ljava/lang/String;
    //   97: astore_3
    //   98: aload 15
    //   100: getfield 265	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:qqv	Lcom/tencent/mobileqq/pb/PBStringField;
    //   103: aload_3
    //   104: invokevirtual 259	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   107: aload 15
    //   109: getfield 268	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:sdkp	Lcom/tencent/mobileqq/pb/PBStringField;
    //   112: ldc_w 269
    //   115: invokevirtual 259	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   118: getstatic 274	android/os/Build:DISPLAY	Ljava/lang/String;
    //   121: astore_3
    //   122: aload 15
    //   124: getfield 277	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:os	Lcom/tencent/mobileqq/pb/PBStringField;
    //   127: aload_3
    //   128: invokevirtual 259	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   131: aload 15
    //   133: getfield 280	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:skey	Lcom/tencent/mobileqq/pb/PBStringField;
    //   136: aload 5
    //   138: invokevirtual 259	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   141: ldc 148
    //   143: astore_3
    //   144: aload_1
    //   145: instanceof 175
    //   148: ifeq +11 -> 159
    //   151: aload_1
    //   152: checkcast 175	com/tencent/mobileqq/app/QQAppInterface
    //   155: invokevirtual 282	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   158: astore_3
    //   159: aload 15
    //   161: getfield 285	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:vkey	Lcom/tencent/mobileqq/pb/PBStringField;
    //   164: aload_3
    //   165: invokevirtual 259	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   168: aload_0
    //   169: getfield 205	aypz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   172: invokestatic 288	bcqt:a	(Ljava/lang/String;)I
    //   175: istore 7
    //   177: iload 7
    //   179: ifne +28 -> 207
    //   182: aload_2
    //   183: aload 4
    //   185: aload_0
    //   186: getfield 205	aypz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   189: invokestatic 64	bcqt:a	(Ljava/lang/String;)Landroid/os/Bundle;
    //   192: iload 6
    //   194: invokestatic 70	bjva:a	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;I)Z
    //   197: pop
    //   198: return
    //   199: astore 12
    //   201: lconst_0
    //   202: lstore 8
    //   204: goto -147 -> 57
    //   207: aload 15
    //   209: getfield 292	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:flags	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   212: iload 7
    //   214: invokevirtual 296	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   217: ldc 148
    //   219: astore 5
    //   221: aload 5
    //   223: astore_3
    //   224: aload_2
    //   225: invokevirtual 302	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   228: aload 4
    //   230: bipush 64
    //   232: invokevirtual 308	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   235: getfield 314	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   238: astore 16
    //   240: aload 5
    //   242: astore_3
    //   243: aload 16
    //   245: ifnull +78 -> 323
    //   248: aload 5
    //   250: astore 12
    //   252: aload 5
    //   254: astore_3
    //   255: ldc_w 316
    //   258: invokestatic 322	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   261: astore 13
    //   263: aload 5
    //   265: astore 12
    //   267: aload 5
    //   269: astore_3
    //   270: aload 13
    //   272: aload 16
    //   274: iconst_0
    //   275: aaload
    //   276: invokevirtual 328	android/content/pm/Signature:toByteArray	()[B
    //   279: invokevirtual 332	java/security/MessageDigest:update	([B)V
    //   282: aload 5
    //   284: astore 12
    //   286: aload 5
    //   288: astore_3
    //   289: aload 13
    //   291: invokevirtual 335	java/security/MessageDigest:digest	()[B
    //   294: invokestatic 340	bhml:a	([B)Ljava/lang/String;
    //   297: astore 5
    //   299: aload 5
    //   301: invokevirtual 345	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   304: astore_3
    //   305: aload_3
    //   306: astore 5
    //   308: aload 5
    //   310: astore 12
    //   312: aload 5
    //   314: astore_3
    //   315: aload 13
    //   317: invokevirtual 348	java/security/MessageDigest:reset	()V
    //   320: aload 5
    //   322: astore_3
    //   323: aload_3
    //   324: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   327: ifeq +65 -> 392
    //   330: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   333: ifeq +17 -> 350
    //   336: aload_0
    //   337: invokevirtual 44	java/lang/Object:getClass	()Ljava/lang/Class;
    //   340: invokevirtual 50	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   343: iconst_2
    //   344: ldc_w 350
    //   347: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   350: aload_2
    //   351: aload 4
    //   353: aload_0
    //   354: getfield 205	aypz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   357: invokestatic 64	bcqt:a	(Ljava/lang/String;)Landroid/os/Bundle;
    //   360: iload 6
    //   362: invokestatic 70	bjva:a	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;I)Z
    //   365: pop
    //   366: return
    //   367: astore 13
    //   369: aload 12
    //   371: astore 5
    //   373: aload 5
    //   375: astore_3
    //   376: aload 13
    //   378: invokevirtual 353	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   381: aload 5
    //   383: astore_3
    //   384: goto -61 -> 323
    //   387: astore 5
    //   389: goto -66 -> 323
    //   392: aload 15
    //   394: getfield 356	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:apk_sign	Lcom/tencent/mobileqq/pb/PBStringField;
    //   397: aload_3
    //   398: invokevirtual 259	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   401: aload_0
    //   402: getfield 28	aypz:jdField_a_of_type_MqqAppNewIntent	Lmqq/app/NewIntent;
    //   405: ldc_w 358
    //   408: ldc_w 360
    //   411: invokevirtual 364	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   414: pop
    //   415: aload_0
    //   416: getfield 28	aypz:jdField_a_of_type_MqqAppNewIntent	Lmqq/app/NewIntent;
    //   419: ldc_w 366
    //   422: aload 15
    //   424: invokevirtual 367	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:toByteArray	()[B
    //   427: invokevirtual 370	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   430: pop
    //   431: aload_0
    //   432: getfield 28	aypz:jdField_a_of_type_MqqAppNewIntent	Lmqq/app/NewIntent;
    //   435: aload 14
    //   437: invokevirtual 34	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   440: aload_1
    //   441: aload_0
    //   442: getfield 28	aypz:jdField_a_of_type_MqqAppNewIntent	Lmqq/app/NewIntent;
    //   445: invokevirtual 374	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   448: aload_0
    //   449: getfield 76	aypz:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   452: bipush 6
    //   454: ldc2_w 375
    //   457: invokevirtual 380	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   460: pop
    //   461: return
    //   462: astore_1
    //   463: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   466: ifeq -268 -> 198
    //   469: aload_0
    //   470: invokevirtual 44	java/lang/Object:getClass	()Ljava/lang/Class;
    //   473: invokevirtual 50	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   476: iconst_2
    //   477: aload_1
    //   478: invokevirtual 383	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   481: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   484: return
    //   485: astore_3
    //   486: lload 10
    //   488: lstore 8
    //   490: goto -417 -> 73
    //   493: astore_3
    //   494: aload 5
    //   496: astore_3
    //   497: goto -174 -> 323
    //   500: astore 13
    //   502: goto -129 -> 373
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	505	0	this	aypz
    //   0	505	1	paramAppInterface	com.tencent.common.app.AppInterface
    //   0	505	2	paramContext	android.content.Context
    //   0	505	3	paramString1	String
    //   0	505	4	paramString2	String
    //   0	505	5	paramString3	String
    //   0	505	6	paramInt	int
    //   175	38	7	i	int
    //   55	434	8	l1	long
    //   1	486	10	l2	long
    //   199	1	12	localException	java.lang.Exception
    //   250	120	12	str	String
    //   261	55	13	localMessageDigest	java.security.MessageDigest
    //   367	10	13	localNoSuchAlgorithmException1	java.security.NoSuchAlgorithmException
    //   500	1	13	localNoSuchAlgorithmException2	java.security.NoSuchAlgorithmException
    //   16	420	14	localayqb	ayqb
    //   46	377	15	localAuthorizeRequest	com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeRequest
    //   238	35	16	arrayOfSignature	android.content.pm.Signature[]
    // Exception table:
    //   from	to	target	type
    //   48	57	199	java/lang/Exception
    //   255	263	367	java/security/NoSuchAlgorithmException
    //   270	282	367	java/security/NoSuchAlgorithmException
    //   289	299	367	java/security/NoSuchAlgorithmException
    //   315	320	367	java/security/NoSuchAlgorithmException
    //   224	240	387	java/lang/Exception
    //   255	263	387	java/lang/Exception
    //   270	282	387	java/lang/Exception
    //   289	299	387	java/lang/Exception
    //   315	320	387	java/lang/Exception
    //   376	381	387	java/lang/Exception
    //   415	431	462	java/lang/Exception
    //   67	73	485	java/lang/Exception
    //   299	305	493	java/lang/Exception
    //   299	305	500	java/security/NoSuchAlgorithmException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypz
 * JD-Core Version:    0.7.0.1
 */