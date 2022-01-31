import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;
import com.tencent.weiyun.utils.IOUtils;

public class bklj
  implements Handler.Callback
{
  private final bklk jdField_a_of_type_Bklk;
  private final ReleaseLooperHandler jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler;
  
  public bklj(bklk parambklk, ReleaseLooperHandler paramReleaseLooperHandler)
  {
    this.jdField_a_of_type_Bklk = parambklk;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler = paramReleaseLooperHandler;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.addCallback(this);
  }
  
  /* Error */
  private String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore_2
    //   8: invokestatic 34	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   11: iconst_1
    //   12: invokevirtual 38	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   15: astore 7
    //   17: aload 7
    //   19: ifnonnull +5 -> 24
    //   22: aconst_null
    //   23: areturn
    //   24: iconst_4
    //   25: invokestatic 44	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   28: astore_3
    //   29: new 46	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   36: ldc 49
    //   38: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 55
    //   43: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc 57
    //   48: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc 59
    //   53: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore 4
    //   61: aload 7
    //   63: ldc 64
    //   65: iconst_1
    //   66: anewarray 66	java/lang/String
    //   69: dup
    //   70: iconst_0
    //   71: ldc 68
    //   73: aastore
    //   74: aload 4
    //   76: iconst_2
    //   77: anewarray 66	java/lang/String
    //   80: dup
    //   81: iconst_0
    //   82: aload_1
    //   83: aastore
    //   84: dup
    //   85: iconst_1
    //   86: aload_3
    //   87: aastore
    //   88: aconst_null
    //   89: aconst_null
    //   90: ldc 70
    //   92: invokevirtual 76	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   95: astore_3
    //   96: aload_3
    //   97: ifnull +237 -> 334
    //   100: aload_3
    //   101: invokeinterface 82 1 0
    //   106: ifeq +228 -> 334
    //   109: aload_3
    //   110: iconst_0
    //   111: invokeinterface 85 2 0
    //   116: astore_2
    //   117: aload_3
    //   118: invokestatic 91	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   121: aload_2
    //   122: astore_3
    //   123: aload_2
    //   124: invokestatic 97	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifeq +148 -> 275
    //   130: aload 5
    //   132: astore_3
    //   133: aload 6
    //   135: astore 4
    //   137: iconst_4
    //   138: invokestatic 44	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   141: astore 8
    //   143: aload 5
    //   145: astore_3
    //   146: aload 6
    //   148: astore 4
    //   150: new 46	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   157: ldc 99
    //   159: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 55
    //   164: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc 57
    //   169: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc 59
    //   174: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: astore 9
    //   182: aload 5
    //   184: astore_3
    //   185: aload 6
    //   187: astore 4
    //   189: aload 7
    //   191: ldc 101
    //   193: iconst_1
    //   194: anewarray 66	java/lang/String
    //   197: dup
    //   198: iconst_0
    //   199: ldc 68
    //   201: aastore
    //   202: aload 9
    //   204: iconst_2
    //   205: anewarray 66	java/lang/String
    //   208: dup
    //   209: iconst_0
    //   210: aload_1
    //   211: aastore
    //   212: dup
    //   213: iconst_1
    //   214: aload 8
    //   216: aastore
    //   217: aconst_null
    //   218: aconst_null
    //   219: ldc 70
    //   221: invokevirtual 76	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   224: astore 5
    //   226: aload_2
    //   227: astore_1
    //   228: aload 5
    //   230: ifnull +38 -> 268
    //   233: aload_2
    //   234: astore_1
    //   235: aload 5
    //   237: astore_3
    //   238: aload 5
    //   240: astore 4
    //   242: aload 5
    //   244: invokeinterface 82 1 0
    //   249: ifeq +19 -> 268
    //   252: aload 5
    //   254: astore_3
    //   255: aload 5
    //   257: astore 4
    //   259: aload 5
    //   261: iconst_0
    //   262: invokeinterface 85 2 0
    //   267: astore_1
    //   268: aload 5
    //   270: invokestatic 91	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   273: aload_1
    //   274: astore_3
    //   275: invokestatic 34	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   278: aload 7
    //   280: invokevirtual 105	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   283: aload_3
    //   284: areturn
    //   285: astore_2
    //   286: aconst_null
    //   287: astore_2
    //   288: aload_2
    //   289: invokestatic 91	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   292: aconst_null
    //   293: astore_2
    //   294: goto -173 -> 121
    //   297: astore_1
    //   298: aload_2
    //   299: invokestatic 91	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   302: aload_1
    //   303: athrow
    //   304: astore_1
    //   305: aload_3
    //   306: invokestatic 91	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   309: aload_2
    //   310: astore_3
    //   311: goto -36 -> 275
    //   314: astore_1
    //   315: aload 4
    //   317: invokestatic 91	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   320: aload_1
    //   321: athrow
    //   322: astore_1
    //   323: aload_3
    //   324: astore_2
    //   325: goto -27 -> 298
    //   328: astore_2
    //   329: aload_3
    //   330: astore_2
    //   331: goto -43 -> 288
    //   334: aconst_null
    //   335: astore_2
    //   336: goto -219 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	this	bklj
    //   0	339	1	paramString	String
    //   7	227	2	str1	String
    //   285	1	2	localThrowable1	java.lang.Throwable
    //   287	38	2	localObject1	Object
    //   328	1	2	localThrowable2	java.lang.Throwable
    //   330	6	2	localObject2	Object
    //   28	302	3	localObject3	Object
    //   59	257	4	localObject4	Object
    //   1	268	5	localCursor	android.database.Cursor
    //   4	182	6	localObject5	Object
    //   15	264	7	localJobDbWrapper	com.tencent.weiyun.transmission.db.JobDbWrapper
    //   141	74	8	str2	String
    //   180	23	9	str3	String
    // Exception table:
    //   from	to	target	type
    //   24	96	285	java/lang/Throwable
    //   24	96	297	finally
    //   137	143	304	java/lang/Throwable
    //   150	182	304	java/lang/Throwable
    //   189	226	304	java/lang/Throwable
    //   242	252	304	java/lang/Throwable
    //   259	268	304	java/lang/Throwable
    //   137	143	314	finally
    //   150	182	314	finally
    //   189	226	314	finally
    //   242	252	314	finally
    //   259	268	314	finally
    //   100	117	322	finally
    //   100	117	328	java/lang/Throwable
  }
  
  private void b(bkkp parambkkp)
  {
    boolean bool = true;
    if (parambkkp == null) {}
    Object localObject;
    do
    {
      String str2;
      String str3;
      String str4;
      do
      {
        do
        {
          do
          {
            long l1;
            long l2;
            do
            {
              do
              {
                return;
                str2 = parambkkp.d();
                str3 = parambkkp.a().c;
                str4 = parambkkp.b();
                l1 = parambkkp.a().a;
                l2 = parambkkp.a().b;
              } while (parambkkp.d());
              if ((!TextUtils.isEmpty(str2)) && (TextUtils.equals(str3, IOUtils.getFileSha1(str2))))
              {
                this.jdField_a_of_type_Bklk.a(parambkkp.a(), true, false, false, str2);
                return;
              }
            } while (parambkkp.d());
            if (!IOUtils.ensureStorageSpace(str4, l1 - l2))
            {
              this.jdField_a_of_type_Bklk.a(parambkkp.a(), false, false, true, "");
              return;
            }
          } while (parambkkp.d());
          if (!IOUtils.ensureWritable(str4))
          {
            this.jdField_a_of_type_Bklk.a(parambkkp.a(), false, true, false, "");
            return;
          }
        } while (parambkkp.d());
        localObject = IOUtils.ensureFilePath(str4, parambkkp.a().b);
      } while (parambkkp.d());
      String str1 = a(str3);
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.equals(str2, str1)) && (TextUtils.equals(str3, IOUtils.getFileSha1(str1))))
      {
        if (TextUtils.equals(str4, IOUtils.getParentDir(str1))) {
          localObject = str1;
        }
        for (;;)
        {
          this.jdField_a_of_type_Bklk.a(parambkkp.a(), bool, false, false, (String)localObject);
          return;
          bool = IOUtils.copyFileAndNotifyOS(WeiyunTransmissionGlobal.getInstance().getContext(), str1, (String)localObject);
        }
      }
    } while (parambkkp.d());
    this.jdField_a_of_type_Bklk.a(parambkkp.a(), false, false, false, (String)localObject);
  }
  
  public void a(bkkp parambkkp)
  {
    if (parambkkp == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.sendMessage(Message.obtain(null, 11, parambkkp));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 11)
    {
      b((bkkp)paramMessage.obj);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bklj
 * JD-Core Version:    0.7.0.1
 */