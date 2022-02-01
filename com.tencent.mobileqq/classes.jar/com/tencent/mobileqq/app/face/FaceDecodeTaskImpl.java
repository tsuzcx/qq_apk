package com.tencent.mobileqq.app.face;

import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.utils.AvatarUtil;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IDiscussionHandlerService;
import com.tencent.mobileqq.troop.api.IHotChatService;
import com.tencent.mobileqq.troop.api.ITroopHandlerService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class FaceDecodeTaskImpl
  extends FaceDecodeTask
{
  private static final String TAG = "Q.qqhead.FaceDecodeTaskImpl";
  AppInterface app;
  
  public FaceDecodeTaskImpl(AppInterface paramAppInterface, FaceInfo paramFaceInfo, DecodeCompletionListener paramDecodeCompletionListener)
  {
    super(paramAppInterface, paramFaceInfo, paramDecodeCompletionListener);
    this.app = paramAppInterface;
  }
  
  /* Error */
  protected void doDecodeBitmap()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   4: getstatic 35	com/tencent/mobileqq/app/face/FaceInfo:p	I
    //   7: invokevirtual 39	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   10: aload_0
    //   11: invokevirtual 43	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:isFaceNotNeedDecode	()Z
    //   14: istore_2
    //   15: iload_2
    //   16: ifeq +81 -> 97
    //   19: aload_0
    //   20: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   23: getstatic 46	com/tencent/mobileqq/app/face/FaceInfo:q	I
    //   26: invokevirtual 39	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   29: getstatic 50	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:handler	Lmqq/os/MqqHandler;
    //   32: ifnull +64 -> 96
    //   35: getstatic 50	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:handler	Lmqq/os/MqqHandler;
    //   38: getstatic 50	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:handler	Lmqq/os/MqqHandler;
    //   41: getstatic 53	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:EVENT_TASK_COMPLETED	I
    //   44: aload_0
    //   45: invokevirtual 59	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   48: invokevirtual 63	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   51: pop
    //   52: return
    //   53: astore_3
    //   54: new 65	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   61: astore 4
    //   63: aload 4
    //   65: ldc 69
    //   67: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 4
    //   73: aload_0
    //   74: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   77: getfield 75	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   80: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: ldc 8
    //   86: iconst_1
    //   87: aload 4
    //   89: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: aload_3
    //   93: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   96: return
    //   97: aload_0
    //   98: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   101: getfield 87	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_Int	I
    //   104: istore_1
    //   105: iload_1
    //   106: bipush 101
    //   108: if_icmpeq +193 -> 301
    //   111: aload_0
    //   112: getfield 16	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:app	Lcom/tencent/common/app/AppInterface;
    //   115: ldc 89
    //   117: ldc 91
    //   119: invokevirtual 97	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   122: checkcast 89	com/tencent/mobileqq/avatar/api/IQQAvatarDataService
    //   125: aload_0
    //   126: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   129: getfield 87	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_Int	I
    //   132: aload_0
    //   133: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   136: getfield 75	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   139: aload_0
    //   140: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   143: getfield 100	com/tencent/mobileqq/app/face/FaceInfo:jdField_b_of_type_Int	I
    //   146: invokeinterface 104 4 0
    //   151: astore_3
    //   152: aload_3
    //   153: ifnull +38 -> 191
    //   156: aload_3
    //   157: getfield 110	android/util/Pair:first	Ljava/lang/Object;
    //   160: checkcast 112	java/lang/Boolean
    //   163: invokevirtual 115	java/lang/Boolean:booleanValue	()Z
    //   166: ifeq +25 -> 191
    //   169: aload_0
    //   170: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   173: iconst_1
    //   174: putfield 118	com/tencent/mobileqq/app/face/FaceInfo:jdField_b_of_type_Byte	B
    //   177: aload_0
    //   178: getfield 16	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:app	Lcom/tencent/common/app/AppInterface;
    //   181: aload_0
    //   182: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   185: invokestatic 124	com/tencent/mobileqq/app/face/FaceDecoder:requestDownloadFace	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/app/face/FaceInfo;)V
    //   188: goto +113 -> 301
    //   191: aload_0
    //   192: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   195: getfield 127	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_Boolean	Z
    //   198: ifeq +103 -> 301
    //   201: aload_3
    //   202: ifnull +99 -> 301
    //   205: aload_0
    //   206: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   209: getfield 87	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_Int	I
    //   212: iconst_1
    //   213: if_icmpeq +15 -> 228
    //   216: aload_0
    //   217: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   220: getfield 87	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_Int	I
    //   223: bipush 32
    //   225: if_icmpne +76 -> 301
    //   228: aload_0
    //   229: getfield 16	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:app	Lcom/tencent/common/app/AppInterface;
    //   232: ldc 129
    //   234: ldc 91
    //   236: invokevirtual 97	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   239: checkcast 129	com/tencent/mobileqq/avatar/api/IQQDynamicAvatarService
    //   242: aload_0
    //   243: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   246: aload_3
    //   247: getfield 132	android/util/Pair:second	Ljava/lang/Object;
    //   250: checkcast 134	com/tencent/mobileqq/data/Setting
    //   253: aload_0
    //   254: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   257: getfield 87	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_Int	I
    //   260: invokeinterface 138 4 0
    //   265: ifeq +36 -> 301
    //   268: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq +11 -> 282
    //   274: ldc 8
    //   276: iconst_2
    //   277: ldc 143
    //   279: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: aload_0
    //   283: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   286: iconst_1
    //   287: putfield 118	com/tencent/mobileqq/app/face/FaceInfo:jdField_b_of_type_Byte	B
    //   290: aload_0
    //   291: getfield 16	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:app	Lcom/tencent/common/app/AppInterface;
    //   294: aload_0
    //   295: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   298: invokestatic 124	com/tencent/mobileqq/app/face/FaceDecoder:requestDownloadFace	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/app/face/FaceInfo;)V
    //   301: aload_0
    //   302: aload_0
    //   303: getfield 16	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:app	Lcom/tencent/common/app/AppInterface;
    //   306: ldc 149
    //   308: ldc 91
    //   310: invokevirtual 97	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   313: checkcast 149	com/tencent/mobileqq/avatar/api/IQQAvatarCompatibleService
    //   316: aload_0
    //   317: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   320: getfield 87	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_Int	I
    //   323: aload_0
    //   324: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   327: getfield 75	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   330: aload_0
    //   331: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   334: getfield 152	com/tencent/mobileqq/app/face/FaceInfo:c	I
    //   337: i2b
    //   338: aload_0
    //   339: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   342: getfield 155	com/tencent/mobileqq/app/face/FaceInfo:d	I
    //   345: iconst_0
    //   346: aload_0
    //   347: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   350: invokevirtual 158	com/tencent/mobileqq/app/face/FaceInfo:a	()B
    //   353: aload_0
    //   354: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   357: getfield 100	com/tencent/mobileqq/app/face/FaceInfo:jdField_b_of_type_Int	I
    //   360: invokeinterface 162 8 0
    //   365: putfield 166	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:bitmap	Landroid/graphics/Bitmap;
    //   368: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   371: ifeq +47 -> 418
    //   374: aload_0
    //   375: getfield 166	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:bitmap	Landroid/graphics/Bitmap;
    //   378: ifnonnull +40 -> 418
    //   381: new 65	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   388: astore_3
    //   389: aload_3
    //   390: ldc 168
    //   392: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload_3
    //   397: aload_0
    //   398: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   401: getfield 75	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   404: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: ldc 8
    //   410: iconst_2
    //   411: aload_3
    //   412: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: aload_0
    //   419: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   422: getstatic 46	com/tencent/mobileqq/app/face/FaceInfo:q	I
    //   425: invokevirtual 39	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   428: getstatic 50	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:handler	Lmqq/os/MqqHandler;
    //   431: ifnull +248 -> 679
    //   434: getstatic 50	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:handler	Lmqq/os/MqqHandler;
    //   437: getstatic 50	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:handler	Lmqq/os/MqqHandler;
    //   440: getstatic 53	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:EVENT_TASK_COMPLETED	I
    //   443: aload_0
    //   444: invokevirtual 59	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   447: invokevirtual 63	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   450: pop
    //   451: return
    //   452: astore_3
    //   453: new 65	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   460: astore 4
    //   462: goto +184 -> 646
    //   465: astore_3
    //   466: goto +214 -> 680
    //   469: astore_3
    //   470: new 65	java/lang/StringBuilder
    //   473: dup
    //   474: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   477: astore 4
    //   479: aload 4
    //   481: ldc 172
    //   483: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload 4
    //   489: aload_0
    //   490: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   493: getfield 75	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   496: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: ldc 8
    //   502: iconst_1
    //   503: aload 4
    //   505: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: aload_3
    //   509: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   512: aload_0
    //   513: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   516: getstatic 46	com/tencent/mobileqq/app/face/FaceInfo:q	I
    //   519: invokevirtual 39	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   522: getstatic 50	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:handler	Lmqq/os/MqqHandler;
    //   525: ifnull +154 -> 679
    //   528: getstatic 50	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:handler	Lmqq/os/MqqHandler;
    //   531: getstatic 50	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:handler	Lmqq/os/MqqHandler;
    //   534: getstatic 53	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:EVENT_TASK_COMPLETED	I
    //   537: aload_0
    //   538: invokevirtual 59	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   541: invokevirtual 63	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   544: pop
    //   545: return
    //   546: astore_3
    //   547: new 65	java/lang/StringBuilder
    //   550: dup
    //   551: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   554: astore 4
    //   556: goto +90 -> 646
    //   559: astore_3
    //   560: new 65	java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   567: astore 4
    //   569: aload 4
    //   571: ldc 174
    //   573: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload 4
    //   579: aload_0
    //   580: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   583: getfield 75	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   586: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: ldc 8
    //   592: iconst_1
    //   593: aload 4
    //   595: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: aload_3
    //   599: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   602: aload_0
    //   603: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   606: getstatic 46	com/tencent/mobileqq/app/face/FaceInfo:q	I
    //   609: invokevirtual 39	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   612: getstatic 50	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:handler	Lmqq/os/MqqHandler;
    //   615: ifnull +64 -> 679
    //   618: getstatic 50	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:handler	Lmqq/os/MqqHandler;
    //   621: getstatic 50	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:handler	Lmqq/os/MqqHandler;
    //   624: getstatic 53	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:EVENT_TASK_COMPLETED	I
    //   627: aload_0
    //   628: invokevirtual 59	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   631: invokevirtual 63	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   634: pop
    //   635: return
    //   636: astore_3
    //   637: new 65	java/lang/StringBuilder
    //   640: dup
    //   641: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   644: astore 4
    //   646: aload 4
    //   648: ldc 69
    //   650: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: pop
    //   654: aload 4
    //   656: aload_0
    //   657: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   660: getfield 75	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   663: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: pop
    //   667: ldc 8
    //   669: iconst_1
    //   670: aload 4
    //   672: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: aload_3
    //   676: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   679: return
    //   680: aload_0
    //   681: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   684: getstatic 46	com/tencent/mobileqq/app/face/FaceInfo:q	I
    //   687: invokevirtual 39	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   690: getstatic 50	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:handler	Lmqq/os/MqqHandler;
    //   693: ifnull +68 -> 761
    //   696: getstatic 50	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:handler	Lmqq/os/MqqHandler;
    //   699: getstatic 50	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:handler	Lmqq/os/MqqHandler;
    //   702: getstatic 53	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:EVENT_TASK_COMPLETED	I
    //   705: aload_0
    //   706: invokevirtual 59	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   709: invokevirtual 63	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   712: pop
    //   713: goto +48 -> 761
    //   716: astore 4
    //   718: new 65	java/lang/StringBuilder
    //   721: dup
    //   722: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   725: astore 5
    //   727: aload 5
    //   729: ldc 69
    //   731: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload 5
    //   737: aload_0
    //   738: getfield 29	com/tencent/mobileqq/app/face/FaceDecodeTaskImpl:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   741: getfield 75	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   744: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: ldc 8
    //   750: iconst_1
    //   751: aload 5
    //   753: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   756: aload 4
    //   758: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   761: aload_3
    //   762: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	763	0	this	FaceDecodeTaskImpl
    //   104	5	1	i	int
    //   14	2	2	bool	boolean
    //   53	40	3	localException1	java.lang.Exception
    //   151	261	3	localObject1	Object
    //   452	1	3	localException2	java.lang.Exception
    //   465	1	3	localObject2	Object
    //   469	40	3	localThrowable	java.lang.Throwable
    //   546	1	3	localException3	java.lang.Exception
    //   559	40	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   636	126	3	localException4	java.lang.Exception
    //   61	610	4	localStringBuilder1	StringBuilder
    //   716	41	4	localException5	java.lang.Exception
    //   725	27	5	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   29	52	53	java/lang/Exception
    //   428	451	452	java/lang/Exception
    //   10	15	465	finally
    //   97	105	465	finally
    //   111	152	465	finally
    //   156	188	465	finally
    //   191	201	465	finally
    //   205	228	465	finally
    //   228	282	465	finally
    //   282	301	465	finally
    //   301	418	465	finally
    //   470	512	465	finally
    //   560	602	465	finally
    //   10	15	469	java/lang/Throwable
    //   97	105	469	java/lang/Throwable
    //   111	152	469	java/lang/Throwable
    //   156	188	469	java/lang/Throwable
    //   191	201	469	java/lang/Throwable
    //   205	228	469	java/lang/Throwable
    //   228	282	469	java/lang/Throwable
    //   282	301	469	java/lang/Throwable
    //   301	418	469	java/lang/Throwable
    //   522	545	546	java/lang/Exception
    //   10	15	559	java/lang/OutOfMemoryError
    //   97	105	559	java/lang/OutOfMemoryError
    //   111	152	559	java/lang/OutOfMemoryError
    //   156	188	559	java/lang/OutOfMemoryError
    //   191	201	559	java/lang/OutOfMemoryError
    //   205	228	559	java/lang/OutOfMemoryError
    //   228	282	559	java/lang/OutOfMemoryError
    //   282	301	559	java/lang/OutOfMemoryError
    //   301	418	559	java/lang/OutOfMemoryError
    //   612	635	636	java/lang/Exception
    //   690	713	716	java/lang/Exception
  }
  
  protected boolean isExpired()
  {
    return this.app == null;
  }
  
  public boolean isFaceNotNeedDecode()
  {
    if ((this.faceInfo.jdField_a_of_type_Int != 101) && (this.faceInfo.jdField_a_of_type_Int != 1001))
    {
      if ((this.faceInfo.jdField_a_of_type_Int == 4) || (this.faceInfo.jdField_a_of_type_Int == 113))
      {
        localObject = (IHotChatService)this.app.getRuntimeService(IHotChatService.class, "");
        if (((IHotChatService)localObject).isHotChat(this.faceInfo.jdField_a_of_type_JavaLangString))
        {
          IQQAvatarDataService localIQQAvatarDataService = (IQQAvatarDataService)this.app.getRuntimeService(IQQAvatarDataService.class, "");
          String str = localIQQAvatarDataService.getFaceBitmapCacheKey(this.faceInfo.jdField_a_of_type_Int, this.faceInfo.jdField_a_of_type_JavaLangString, (byte)this.faceInfo.c, this.faceInfo.jdField_b_of_type_Int, this.faceInfo.d, false);
          this.bitmap = localIQQAvatarDataService.getBitmapFromCache(str);
          if (this.bitmap == null)
          {
            int i = ((IHotChatService)localObject).getHotChatDrawableID(this.faceInfo.jdField_a_of_type_JavaLangString, this.app);
            this.bitmap = BaseImageUtil.a(BaseApplication.getContext().getResources(), i);
            localIQQAvatarDataService.putBitmapToCache(str, this.bitmap, (byte)1);
          }
          return true;
        }
        if (!((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).hasSetTroopHead(this.faceInfo.jdField_a_of_type_JavaLangString))
        {
          this.bitmap = ((ITroopHandlerService)this.app.getRuntimeService(ITroopHandlerService.class, "")).getGroupFaceIcon(this.faceInfo.jdField_a_of_type_JavaLangString, false);
          this.needDownload = false;
          return true;
        }
      }
      localObject = (IQQAvatarDataService)this.app.getRuntimeService(IQQAvatarDataService.class, "");
      if ((Setting)((IQQAvatarDataService)localObject).getQQHeadSetting(this.faceInfo.jdField_a_of_type_Int, this.faceInfo.jdField_a_of_type_JavaLangString, this.faceInfo.jdField_b_of_type_Int).second == null)
      {
        this.needDownload = true;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("doDecodeBitmap, needdown-settingNull, faceInfo=");
          ((StringBuilder)localObject).append(this.faceInfo.toString());
          QLog.d("Q.qqhead.FaceDecodeTaskImpl", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
      this.needDownload = (((IQQAvatarDataService)localObject).isFaceFileExist(this.faceInfo.jdField_a_of_type_Int, this.faceInfo.jdField_a_of_type_JavaLangString, this.faceInfo.jdField_b_of_type_Int, this.faceInfo.d) ^ true);
      if (this.needDownload)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("doDecodeBitmap, needdown-fileNotExit, faceInfo=");
          ((StringBuilder)localObject).append(this.faceInfo.toString());
          QLog.d("Q.qqhead.FaceDecodeTaskImpl", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
      return false;
    }
    Object localObject = (IDiscussionHandlerService)this.app.getRuntimeService(IDiscussionHandlerService.class, "");
    if (this.faceInfo.jdField_a_of_type_Int == 1001) {
      this.bitmap = ((IDiscussionHandlerService)localObject).getDiscussionFaceIcon(AvatarUtil.c(this.faceInfo.jdField_a_of_type_JavaLangString), false);
    } else {
      this.bitmap = ((IDiscussionHandlerService)localObject).getDiscussionFaceIcon(this.faceInfo.jdField_a_of_type_JavaLangString, false);
    }
    this.needDownload = false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDecodeTaskImpl
 * JD-Core Version:    0.7.0.1
 */