package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ShortVideoPTVItemBuilder$EncodeTask
  extends AsyncTask<Void, Void, Integer>
{
  MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  String jdField_a_of_type_JavaLangString;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  String jdField_b_of_type_JavaLangString;
  WeakReference<QQAppInterface> jdField_b_of_type_JavaLangRefWeakReference;
  
  public ShortVideoPTVItemBuilder$EncodeTask(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
  }
  
  /* Error */
  protected Integer a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/tencent/mobileqq/activity/aio/item/ShortVideoPTVItemBuilder$EncodeTask:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   4: astore 4
    //   6: bipush 7
    //   8: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   11: astore_1
    //   12: aload 4
    //   14: ifnull +343 -> 357
    //   17: aload 4
    //   19: invokevirtual 42	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   22: ifnonnull +5 -> 27
    //   25: aload_1
    //   26: areturn
    //   27: aload_0
    //   28: getfield 24	com/tencent/mobileqq/activity/aio/item/ShortVideoPTVItemBuilder$EncodeTask:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   31: invokevirtual 42	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   34: checkcast 44	android/content/Context
    //   37: astore 4
    //   39: aload_0
    //   40: getfield 28	com/tencent/mobileqq/activity/aio/item/ShortVideoPTVItemBuilder$EncodeTask:jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo	Lcom/tencent/mobileqq/data/MessageForShortVideo;
    //   43: astore 5
    //   45: aload 5
    //   47: ifnonnull +5 -> 52
    //   50: aload_1
    //   51: areturn
    //   52: aload 5
    //   54: getfield 49	com/tencent/mobileqq/data/MessageForShortVideo:videoFileName	Ljava/lang/String;
    //   57: invokestatic 55	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   60: ifeq +22 -> 82
    //   63: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +11 -> 77
    //   69: ldc 63
    //   71: iconst_2
    //   72: ldc 65
    //   74: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: iconst_5
    //   78: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: areturn
    //   82: invokestatic 73	com/tencent/mobileqq/utils/LogTag:a	()V
    //   85: new 75	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread
    //   88: dup
    //   89: aload 4
    //   91: new 77	com/tencent/mobileqq/activity/aio/item/ShortVideoPTVItemBuilder$EncodeHandler
    //   94: dup
    //   95: invokestatic 83	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   98: invokespecial 86	com/tencent/mobileqq/activity/aio/item/ShortVideoPTVItemBuilder$EncodeHandler:<init>	(Landroid/os/Looper;)V
    //   101: aload 5
    //   103: getfield 89	com/tencent/mobileqq/data/MessageForShortVideo:mVideoFileSourceDir	Ljava/lang/String;
    //   106: aconst_null
    //   107: aconst_null
    //   108: invokespecial 92	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:<init>	(Landroid/content/Context;Landroid/os/Handler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   111: astore_1
    //   112: aload_1
    //   113: invokevirtual 95	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:run	()V
    //   116: aload_1
    //   117: getfield 98	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:mTargetFilePath	Ljava/lang/String;
    //   120: astore 6
    //   122: ldc 63
    //   124: ldc 100
    //   126: invokestatic 103	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload 6
    //   131: invokestatic 55	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   134: ifne +9 -> 143
    //   137: bipush 8
    //   139: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   142: areturn
    //   143: new 105	java/io/File
    //   146: dup
    //   147: aload 6
    //   149: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   152: astore 4
    //   154: aload 4
    //   156: invokevirtual 112	java/io/File:length	()J
    //   159: lstore_2
    //   160: lload_2
    //   161: lconst_0
    //   162: lcmp
    //   163: ifne +23 -> 186
    //   166: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +11 -> 180
    //   172: ldc 63
    //   174: iconst_2
    //   175: ldc 114
    //   177: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: bipush 8
    //   182: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   185: areturn
    //   186: aconst_null
    //   187: astore_1
    //   188: new 116	java/io/FileInputStream
    //   191: dup
    //   192: aload 4
    //   194: invokespecial 119	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   197: astore 4
    //   199: aload 4
    //   201: lload_2
    //   202: invokestatic 125	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   205: invokestatic 131	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   208: astore 4
    //   210: aload 4
    //   212: astore_1
    //   213: aload 4
    //   215: invokestatic 137	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   218: ifeq +57 -> 275
    //   221: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   224: ifeq +35 -> 259
    //   227: new 139	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   234: astore_1
    //   235: aload_1
    //   236: ldc 142
    //   238: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_1
    //   243: aload 4
    //   245: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: ldc 63
    //   251: iconst_2
    //   252: aload_1
    //   253: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: iconst_5
    //   260: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   263: areturn
    //   264: astore_1
    //   265: goto +90 -> 355
    //   268: astore 4
    //   270: aload 4
    //   272: invokevirtual 153	java/io/FileNotFoundException:printStackTrace	()V
    //   275: aload_0
    //   276: aload_1
    //   277: putfield 155	com/tencent/mobileqq/activity/aio/item/ShortVideoPTVItemBuilder$EncodeTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   280: aload_0
    //   281: aload 6
    //   283: putfield 157	com/tencent/mobileqq/activity/aio/item/ShortVideoPTVItemBuilder$EncodeTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   286: aload 5
    //   288: lload_2
    //   289: l2i
    //   290: putfield 161	com/tencent/mobileqq/data/MessageForShortVideo:videoFileSize	I
    //   293: aload 5
    //   295: getfield 164	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   298: invokestatic 55	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   301: ifeq +49 -> 350
    //   304: aload 5
    //   306: getfield 167	com/tencent/mobileqq/data/MessageForShortVideo:thumbMD5	Ljava/lang/String;
    //   309: ldc 169
    //   311: invokestatic 174	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   314: astore_1
    //   315: aload_1
    //   316: aload 5
    //   318: getfield 164	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   321: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   324: ifne +26 -> 350
    //   327: aload_1
    //   328: aload 5
    //   330: getfield 164	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   333: invokestatic 184	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   336: ifne +8 -> 344
    //   339: iconst_5
    //   340: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   343: areturn
    //   344: aload 5
    //   346: aload_1
    //   347: putfield 164	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   350: iconst_1
    //   351: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   354: areturn
    //   355: aload_1
    //   356: athrow
    //   357: aload_1
    //   358: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	EncodeTask
    //   0	359	1	paramVarArgs	Void[]
    //   159	130	2	l	long
    //   4	240	4	localObject	Object
    //   268	3	4	localFileNotFoundException	java.io.FileNotFoundException
    //   43	302	5	localMessageForShortVideo	MessageForShortVideo
    //   120	162	6	str	String
    // Exception table:
    //   from	to	target	type
    //   188	199	264	finally
    //   270	275	264	finally
    //   188	199	268	java/io/FileNotFoundException
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    Object localObject1;
    if (paramInteger.intValue() == 1)
    {
      localObject1 = this.jdField_b_of_type_JavaLangRefWeakReference;
      if (localObject1 != null)
      {
        paramInteger = (QQAppInterface)((WeakReference)localObject1).get();
        if (paramInteger != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
          ((MessageForShortVideo)localObject1).md5 = this.jdField_a_of_type_JavaLangString;
          Object localObject2 = SVUtils.a((MessageForShortVideo)localObject1, "mp4");
          if (!this.jdField_b_of_type_JavaLangString.equals(localObject2))
          {
            FileUtils.rename(this.jdField_b_of_type_JavaLangString, (String)localObject2);
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("onPostExecute destVideoPath ");
              localStringBuilder.append((String)localObject2);
              QLog.i("ShortVideoPTVItemBuilder", 2, localStringBuilder.toString());
            }
          }
          ((MessageForShortVideo)localObject1).videoFileName = ((String)localObject2);
          ((MessageForShortVideo)localObject1).serial();
          paramInteger.getMessageFacade().a(((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).istroop, ((MessageForShortVideo)localObject1).uniseq, ((MessageForShortVideo)localObject1).msgData);
          localObject2 = SVBusiUtil.a(0, 3);
          localObject1 = ShortVideoBusiManager.a(localObject1, (ShortVideoReq)localObject2);
          ((ShortVideoUploadInfo)localObject1).b = false;
          ((ShortVideoReq)localObject2).a((ShortVideoUploadInfo)localObject1);
          ShortVideoBusiManager.a((ShortVideoReq)localObject2, paramInteger);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "QQAppInterface is null...");
        }
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Error code ");
      ((StringBuilder)localObject1).append(paramInteger);
      QLog.i("ShortVideoPTVItemBuilder", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder.EncodeTask
 * JD-Core Version:    0.7.0.1
 */