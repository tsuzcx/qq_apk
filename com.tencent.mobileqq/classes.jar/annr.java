import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class annr
{
  private annn jdField_a_of_type_Annn;
  private ayav jdField_a_of_type_Ayav;
  private PeakAppInterface jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface;
  
  private ArrayList<String> a(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      ArrayList localArrayList = new ArrayList();
      int j = paramArrayOfString.length;
      int i = 0;
      for (;;)
      {
        localObject = localArrayList;
        if (i >= j) {
          break;
        }
        localObject = paramArrayOfString[i];
        if ((((String)localObject).endsWith("_New")) && ((((String)localObject).startsWith("mr_friend_")) || (((String)localObject).startsWith("mr_troop_")) || (((String)localObject).startsWith("mr_discusssion_")))) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
    }
    Object localObject = null;
    return localObject;
  }
  
  private void a(String paramString, List<? extends Entity> paramList)
  {
    if (this.jdField_a_of_type_Annn != null) {
      this.jdField_a_of_type_Annn.a(paramString, paramList);
    }
  }
  
  public AppInterface a()
  {
    AppInterface localAppInterface = QQStoryContext.a();
    if ((localAppInterface instanceof PeakAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)localAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface;
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +8 -> 12
    //   7: ldc 68
    //   9: astore_3
    //   10: aload_3
    //   11: areturn
    //   12: new 70	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   19: ldc 73
    //   21: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 57	annr:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   28: invokevirtual 81	com/tencent/mobileqq/app/PeakAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   31: invokestatic 87	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   34: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   37: ldc 92
    //   39: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 101	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   52: astore_1
    //   53: invokestatic 107	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   56: invokevirtual 113	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   59: aload_1
    //   60: iconst_1
    //   61: anewarray 21	java/lang/String
    //   64: dup
    //   65: iconst_0
    //   66: ldc 115
    //   68: aastore
    //   69: aconst_null
    //   70: aconst_null
    //   71: aconst_null
    //   72: invokevirtual 121	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   75: astore_1
    //   76: aload_1
    //   77: ifnull +161 -> 238
    //   80: aload_1
    //   81: astore_2
    //   82: aload_1
    //   83: invokeinterface 127 1 0
    //   88: ifeq +150 -> 238
    //   91: aload_1
    //   92: astore_2
    //   93: aload_1
    //   94: aload_1
    //   95: ldc 115
    //   97: invokeinterface 131 2 0
    //   102: invokeinterface 135 2 0
    //   107: astore_3
    //   108: aload_1
    //   109: astore_2
    //   110: aload_3
    //   111: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: ifne +124 -> 238
    //   117: aload_1
    //   118: astore_2
    //   119: new 21	java/lang/String
    //   122: dup
    //   123: aload_3
    //   124: invokevirtual 139	java/lang/String:getBytes	()[B
    //   127: ldc 141
    //   129: invokespecial 144	java/lang/String:<init>	([BLjava/lang/String;)V
    //   132: invokestatic 149	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore_3
    //   136: aload_3
    //   137: astore_2
    //   138: aload_2
    //   139: astore_3
    //   140: aload_1
    //   141: ifnull -131 -> 10
    //   144: aload_1
    //   145: invokeinterface 152 1 0
    //   150: aload_2
    //   151: areturn
    //   152: astore_3
    //   153: aconst_null
    //   154: astore_1
    //   155: aload_1
    //   156: astore_2
    //   157: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +33 -> 193
    //   163: aload_1
    //   164: astore_2
    //   165: ldc 159
    //   167: iconst_2
    //   168: new 70	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   175: ldc 161
    //   177: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_3
    //   181: invokevirtual 164	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   184: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aload_1
    //   194: astore_2
    //   195: aload_3
    //   196: invokevirtual 171	java/lang/Throwable:printStackTrace	()V
    //   199: aload_1
    //   200: ifnull +35 -> 235
    //   203: aload_1
    //   204: invokeinterface 152 1 0
    //   209: ldc 68
    //   211: areturn
    //   212: astore_1
    //   213: aconst_null
    //   214: astore_2
    //   215: aload_2
    //   216: ifnull +9 -> 225
    //   219: aload_2
    //   220: invokeinterface 152 1 0
    //   225: aload_1
    //   226: athrow
    //   227: astore_1
    //   228: goto -13 -> 215
    //   231: astore_3
    //   232: goto -77 -> 155
    //   235: ldc 68
    //   237: areturn
    //   238: ldc 68
    //   240: astore_2
    //   241: goto -103 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	annr
    //   0	244	1	paramString	String
    //   81	160	2	localObject1	Object
    //   9	131	3	localObject2	Object
    //   152	44	3	localThrowable1	java.lang.Throwable
    //   231	1	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   12	76	152	java/lang/Throwable
    //   12	76	212	finally
    //   82	91	227	finally
    //   93	108	227	finally
    //   110	117	227	finally
    //   119	136	227	finally
    //   157	163	227	finally
    //   165	193	227	finally
    //   195	199	227	finally
    //   82	91	231	java/lang/Throwable
    //   93	108	231	java/lang/Throwable
    //   110	117	231	java/lang/Throwable
    //   119	136	231	java/lang/Throwable
  }
  
  /* Error */
  public String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +10 -> 14
    //   7: aload_2
    //   8: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +8 -> 19
    //   14: ldc 68
    //   16: astore_3
    //   17: aload_3
    //   18: areturn
    //   19: new 70	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   26: ldc 174
    //   28: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_0
    //   32: getfield 57	annr:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   35: invokevirtual 81	com/tencent/mobileqq/app/PeakAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   38: invokestatic 87	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   41: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: ldc 92
    //   46: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc 92
    //   55: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_2
    //   59: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 101	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   68: astore_1
    //   69: invokestatic 107	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   72: invokevirtual 113	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   75: aload_1
    //   76: iconst_2
    //   77: anewarray 21	java/lang/String
    //   80: dup
    //   81: iconst_0
    //   82: ldc 176
    //   84: aastore
    //   85: dup
    //   86: iconst_1
    //   87: ldc 178
    //   89: aastore
    //   90: aconst_null
    //   91: aconst_null
    //   92: aconst_null
    //   93: invokevirtual 121	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   96: astore_2
    //   97: aload_2
    //   98: ifnull +211 -> 309
    //   101: aload_2
    //   102: astore_1
    //   103: aload_2
    //   104: invokeinterface 127 1 0
    //   109: ifeq +200 -> 309
    //   112: aload_2
    //   113: astore_1
    //   114: aload_2
    //   115: aload_2
    //   116: ldc 178
    //   118: invokeinterface 131 2 0
    //   123: invokeinterface 135 2 0
    //   128: astore_3
    //   129: aload_2
    //   130: astore_1
    //   131: aload_3
    //   132: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   135: ifne +38 -> 173
    //   138: aload_2
    //   139: astore_1
    //   140: new 21	java/lang/String
    //   143: dup
    //   144: aload_3
    //   145: invokevirtual 139	java/lang/String:getBytes	()[B
    //   148: ldc 141
    //   150: invokespecial 144	java/lang/String:<init>	([BLjava/lang/String;)V
    //   153: invokestatic 149	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   156: astore_3
    //   157: aload_3
    //   158: astore_1
    //   159: aload_1
    //   160: astore_3
    //   161: aload_2
    //   162: ifnull -145 -> 17
    //   165: aload_2
    //   166: invokeinterface 152 1 0
    //   171: aload_1
    //   172: areturn
    //   173: aload_2
    //   174: astore_1
    //   175: aload_2
    //   176: aload_2
    //   177: ldc 176
    //   179: invokeinterface 131 2 0
    //   184: invokeinterface 135 2 0
    //   189: astore_3
    //   190: aload_2
    //   191: astore_1
    //   192: aload_3
    //   193: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   196: ifne +113 -> 309
    //   199: aload_2
    //   200: astore_1
    //   201: new 21	java/lang/String
    //   204: dup
    //   205: aload_3
    //   206: invokevirtual 139	java/lang/String:getBytes	()[B
    //   209: ldc 141
    //   211: invokespecial 144	java/lang/String:<init>	([BLjava/lang/String;)V
    //   214: invokestatic 149	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   217: astore_3
    //   218: aload_3
    //   219: astore_1
    //   220: goto -61 -> 159
    //   223: astore_3
    //   224: aconst_null
    //   225: astore_2
    //   226: aload_2
    //   227: astore_1
    //   228: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq +33 -> 264
    //   234: aload_2
    //   235: astore_1
    //   236: ldc 159
    //   238: iconst_2
    //   239: new 70	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   246: ldc 180
    //   248: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload_3
    //   252: invokevirtual 164	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   255: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: aload_2
    //   265: astore_1
    //   266: aload_3
    //   267: invokevirtual 171	java/lang/Throwable:printStackTrace	()V
    //   270: aload_2
    //   271: ifnull +35 -> 306
    //   274: aload_2
    //   275: invokeinterface 152 1 0
    //   280: ldc 68
    //   282: areturn
    //   283: astore_2
    //   284: aconst_null
    //   285: astore_1
    //   286: aload_1
    //   287: ifnull +9 -> 296
    //   290: aload_1
    //   291: invokeinterface 152 1 0
    //   296: aload_2
    //   297: athrow
    //   298: astore_2
    //   299: goto -13 -> 286
    //   302: astore_3
    //   303: goto -77 -> 226
    //   306: ldc 68
    //   308: areturn
    //   309: ldc 68
    //   311: astore_1
    //   312: goto -153 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	annr
    //   0	315	1	paramString1	String
    //   0	315	2	paramString2	String
    //   16	203	3	str	String
    //   223	44	3	localThrowable1	java.lang.Throwable
    //   302	1	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   19	97	223	java/lang/Throwable
    //   19	97	283	finally
    //   103	112	298	finally
    //   114	129	298	finally
    //   131	138	298	finally
    //   140	157	298	finally
    //   175	190	298	finally
    //   192	199	298	finally
    //   201	218	298	finally
    //   228	234	298	finally
    //   236	264	298	finally
    //   266	270	298	finally
    //   103	112	302	java/lang/Throwable
    //   114	129	302	java/lang/Throwable
    //   131	138	302	java/lang/Throwable
    //   140	157	302	java/lang/Throwable
    //   175	190	302	java/lang/Throwable
    //   192	199	302	java/lang/Throwable
    //   201	218	302	java/lang/Throwable
  }
  
  public ArrayList<String> a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageDataManager", 2, "getMessageTableNames");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface != null) {
      try
      {
        ArrayList localArrayList = a(this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.a().getAllTableNameFromDB());
        return localArrayList;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MessageDataManager", 2, "getMessageTableNames exception = " + localException.getMessage());
        }
      }
    }
    return null;
  }
  
  /* Error */
  protected List<? extends Entity> a(Class<? extends Entity> paramClass, String paramString, android.database.Cursor paramCursor, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 57	annr:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   4: ifnull +437 -> 441
    //   7: aload_0
    //   8: getfield 203	annr:jdField_a_of_type_Ayav	Layav;
    //   11: ifnonnull +14 -> 25
    //   14: aload_0
    //   15: new 205	ayav
    //   18: dup
    //   19: invokespecial 206	ayav:<init>	()V
    //   22: putfield 203	annr:jdField_a_of_type_Ayav	Layav;
    //   25: aload_3
    //   26: ifnull +415 -> 441
    //   29: aload_3
    //   30: invokeinterface 127 1 0
    //   35: ifeq +406 -> 441
    //   38: aload_0
    //   39: getfield 203	annr:jdField_a_of_type_Ayav	Layav;
    //   42: aload_1
    //   43: aload_2
    //   44: aload_3
    //   45: invokevirtual 209	ayav:a	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;)Lcom/tencent/mobileqq/persistence/Entity;
    //   48: astore 8
    //   50: aload_0
    //   51: getfield 43	annr:jdField_a_of_type_Annn	Lannn;
    //   54: ifnull +15 -> 69
    //   57: aload_0
    //   58: getfield 43	annr:jdField_a_of_type_Annn	Lannn;
    //   61: aload_2
    //   62: aload 8
    //   64: invokeinterface 212 3 0
    //   69: aload_3
    //   70: invokeinterface 127 1 0
    //   75: ifeq +366 -> 441
    //   78: aload_3
    //   79: invokeinterface 216 1 0
    //   84: istore 4
    //   86: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +38 -> 127
    //   92: ldc 159
    //   94: iconst_2
    //   95: new 70	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   102: ldc 218
    //   104: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_2
    //   108: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 220
    //   113: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: iload 4
    //   118: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: aconst_null
    //   128: astore 8
    //   130: aload 8
    //   132: astore 9
    //   134: iload 4
    //   136: istore 6
    //   138: aload 8
    //   140: astore 11
    //   142: aload_0
    //   143: getfield 203	annr:jdField_a_of_type_Ayav	Layav;
    //   146: ifnull +281 -> 427
    //   149: aload 8
    //   151: astore 9
    //   153: aload_0
    //   154: getfield 203	annr:jdField_a_of_type_Ayav	Layav;
    //   157: aload_1
    //   158: aload_2
    //   159: aload_3
    //   160: invokevirtual 209	ayav:a	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;)Lcom/tencent/mobileqq/persistence/Entity;
    //   163: astore 11
    //   165: iload 4
    //   167: istore 5
    //   169: aload 8
    //   171: astore 10
    //   173: aload 11
    //   175: ifnull +62 -> 237
    //   178: iload 4
    //   180: istore 5
    //   182: aload 8
    //   184: astore 10
    //   186: aload 8
    //   188: ifnonnull +35 -> 223
    //   191: iload 4
    //   193: istore 5
    //   195: iload 4
    //   197: sipush 1000
    //   200: if_icmple +8 -> 208
    //   203: sipush 1000
    //   206: istore 5
    //   208: aload 8
    //   210: astore 9
    //   212: new 16	java/util/ArrayList
    //   215: dup
    //   216: iload 5
    //   218: invokespecial 226	java/util/ArrayList:<init>	(I)V
    //   221: astore 10
    //   223: aload 10
    //   225: astore 9
    //   227: aload 10
    //   229: aload 11
    //   231: invokeinterface 229 2 0
    //   236: pop
    //   237: iload 5
    //   239: istore 6
    //   241: aload 10
    //   243: astore 11
    //   245: aload 10
    //   247: ifnull +180 -> 427
    //   250: aload 10
    //   252: astore 9
    //   254: iload 5
    //   256: istore 6
    //   258: aload 10
    //   260: astore 11
    //   262: aload 10
    //   264: invokeinterface 232 1 0
    //   269: sipush 1000
    //   272: if_icmpne +155 -> 427
    //   275: aload 10
    //   277: astore 9
    //   279: iload 5
    //   281: istore 6
    //   283: aload 10
    //   285: astore 11
    //   287: aload_0
    //   288: getfield 43	annr:jdField_a_of_type_Annn	Lannn;
    //   291: ifnull +136 -> 427
    //   294: aload 10
    //   296: astore 9
    //   298: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq +32 -> 333
    //   304: aload 10
    //   306: astore 9
    //   308: ldc 159
    //   310: iconst_2
    //   311: new 70	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   318: ldc 234
    //   320: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: aload_2
    //   324: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: aload 10
    //   335: astore 9
    //   337: aload_0
    //   338: aload_2
    //   339: aload 10
    //   341: invokespecial 235	annr:a	(Ljava/lang/String;Ljava/util/List;)V
    //   344: aload 10
    //   346: astore 9
    //   348: aload 10
    //   350: invokeinterface 238 1 0
    //   355: iload 5
    //   357: istore 4
    //   359: aconst_null
    //   360: astore 8
    //   362: aload_3
    //   363: invokeinterface 241 1 0
    //   368: istore 7
    //   370: iload 7
    //   372: ifne +66 -> 438
    //   375: aload 8
    //   377: astore_2
    //   378: aload_2
    //   379: areturn
    //   380: astore 9
    //   382: iload 5
    //   384: istore 4
    //   386: goto -24 -> 362
    //   389: astore_1
    //   390: aconst_null
    //   391: astore 8
    //   393: aload 8
    //   395: astore_2
    //   396: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   399: ifeq -21 -> 378
    //   402: ldc 159
    //   404: iconst_2
    //   405: aload_1
    //   406: invokestatic 247	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   409: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   412: aload 8
    //   414: areturn
    //   415: astore_1
    //   416: aload 9
    //   418: astore 8
    //   420: goto -27 -> 393
    //   423: astore_1
    //   424: goto -31 -> 393
    //   427: aload 11
    //   429: astore 8
    //   431: iload 6
    //   433: istore 4
    //   435: goto -73 -> 362
    //   438: goto -308 -> 130
    //   441: aconst_null
    //   442: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	this	annr
    //   0	443	1	paramClass	Class<? extends Entity>
    //   0	443	2	paramString	String
    //   0	443	3	paramCursor	android.database.Cursor
    //   0	443	4	paramInt	int
    //   167	216	5	i	int
    //   136	296	6	j	int
    //   368	3	7	bool	boolean
    //   48	382	8	localObject1	Object
    //   132	215	9	localObject2	Object
    //   380	37	9	localThrowable	java.lang.Throwable
    //   171	178	10	localObject3	Object
    //   140	288	11	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   212	223	380	java/lang/Throwable
    //   7	25	389	java/lang/Exception
    //   29	69	389	java/lang/Exception
    //   69	127	389	java/lang/Exception
    //   142	149	415	java/lang/Exception
    //   153	165	415	java/lang/Exception
    //   212	223	415	java/lang/Exception
    //   227	237	415	java/lang/Exception
    //   262	275	415	java/lang/Exception
    //   287	294	415	java/lang/Exception
    //   298	304	415	java/lang/Exception
    //   308	333	415	java/lang/Exception
    //   337	344	415	java/lang/Exception
    //   348	355	415	java/lang/Exception
    //   362	370	423	java/lang/Exception
  }
  
  public List<MessageRecord> a(Class<? extends Entity> paramClass, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    paramString1 = a(paramClass, paramString1, paramString2, paramString3, paramArrayOfString, 1);
    if (paramString1 != null)
    {
      paramClass = paramString1;
      if (!paramString1.isEmpty()) {}
    }
    else
    {
      paramClass = null;
    }
    return paramClass;
  }
  
  /* Error */
  public List<? extends Entity> a(Class<? extends Entity> paramClass, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aload 8
    //   8: astore 7
    //   10: aload_0
    //   11: getfield 57	annr:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   14: ifnull +104 -> 118
    //   17: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +29 -> 49
    //   23: ldc 159
    //   25: iconst_2
    //   26: new 70	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 257
    //   36: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_2
    //   40: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: iload 6
    //   51: iconst_1
    //   52: if_icmpne +69 -> 121
    //   55: aload_0
    //   56: getfield 57	annr:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   59: invokevirtual 188	com/tencent/mobileqq/app/PeakAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   62: astore 7
    //   64: aload 7
    //   66: aload_2
    //   67: aload_3
    //   68: aload 4
    //   70: aload 5
    //   72: invokevirtual 261	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   75: astore_2
    //   76: aload 9
    //   78: astore 4
    //   80: aload_2
    //   81: ifnull +19 -> 100
    //   84: aload_2
    //   85: astore 4
    //   87: aload_0
    //   88: aload_1
    //   89: aload_3
    //   90: aload_2
    //   91: iload 6
    //   93: invokevirtual 263	annr:a	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;I)Ljava/util/List;
    //   96: astore_1
    //   97: aload_1
    //   98: astore 4
    //   100: aload 4
    //   102: astore 7
    //   104: aload_2
    //   105: ifnull +13 -> 118
    //   108: aload_2
    //   109: invokeinterface 152 1 0
    //   114: aload 4
    //   116: astore 7
    //   118: aload 7
    //   120: areturn
    //   121: iload 6
    //   123: iconst_2
    //   124: if_icmpne +15 -> 139
    //   127: aload_0
    //   128: getfield 57	annr:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   131: invokevirtual 266	com/tencent/mobileqq/app/PeakAppInterface:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   134: astore 7
    //   136: goto -72 -> 64
    //   139: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +30 -> 172
    //   145: ldc 159
    //   147: iconst_2
    //   148: new 70	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   155: ldc_w 268
    //   158: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: iload 6
    //   163: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload 8
    //   174: astore 7
    //   176: iconst_0
    //   177: ifeq -59 -> 118
    //   180: new 270	java/lang/NullPointerException
    //   183: dup
    //   184: invokespecial 271	java/lang/NullPointerException:<init>	()V
    //   187: athrow
    //   188: astore_1
    //   189: aconst_null
    //   190: astore_2
    //   191: aload_2
    //   192: astore 4
    //   194: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq +16 -> 213
    //   200: aload_2
    //   201: astore 4
    //   203: ldc 159
    //   205: iconst_2
    //   206: aload_1
    //   207: invokestatic 247	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   210: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: aload 8
    //   215: astore 7
    //   217: aload_2
    //   218: ifnull -100 -> 118
    //   221: aload_2
    //   222: invokeinterface 152 1 0
    //   227: aconst_null
    //   228: areturn
    //   229: astore_1
    //   230: aconst_null
    //   231: astore 4
    //   233: aload 4
    //   235: ifnull +10 -> 245
    //   238: aload 4
    //   240: invokeinterface 152 1 0
    //   245: aload_1
    //   246: athrow
    //   247: astore_1
    //   248: goto -15 -> 233
    //   251: astore_1
    //   252: goto -61 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	annr
    //   0	255	1	paramClass	Class<? extends Entity>
    //   0	255	2	paramString1	String
    //   0	255	3	paramString2	String
    //   0	255	4	paramString3	String
    //   0	255	5	paramArrayOfString	String[]
    //   0	255	6	paramInt	int
    //   8	208	7	localObject1	Object
    //   1	213	8	localObject2	Object
    //   4	73	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   17	49	188	java/lang/Exception
    //   55	64	188	java/lang/Exception
    //   64	76	188	java/lang/Exception
    //   127	136	188	java/lang/Exception
    //   139	172	188	java/lang/Exception
    //   17	49	229	finally
    //   55	64	229	finally
    //   64	76	229	finally
    //   127	136	229	finally
    //   139	172	229	finally
    //   87	97	247	finally
    //   194	200	247	finally
    //   203	213	247	finally
    //   87	97	251	java/lang/Exception
  }
  
  public List<RecentUser> a(Class<? extends Entity> paramClass, String paramString, String[] paramArrayOfString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface != null)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.a().rawQuery(paramClass, paramString, paramArrayOfString);
      if (paramString != null)
      {
        paramClass = paramString;
        if (!paramString.isEmpty()) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.e("MessageDataManager", 2, "getRecentUserList list is empty");
        }
        paramClass = null;
      }
      return paramClass;
    }
    return null;
  }
  
  public void a()
  {
    a(null);
    if (this.jdField_a_of_type_Ayav != null)
    {
      this.jdField_a_of_type_Ayav.a();
      this.jdField_a_of_type_Ayav = null;
    }
  }
  
  /* Error */
  public void a(int paramInt, java.util.HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: invokestatic 107	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8: invokevirtual 113	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   11: new 70	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 291
    //   21: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 57	annr:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   28: invokevirtual 81	com/tencent/mobileqq/app/PeakAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   31: invokestatic 87	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   34: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   37: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 101	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   43: iconst_3
    //   44: anewarray 21	java/lang/String
    //   47: dup
    //   48: iconst_0
    //   49: ldc_w 293
    //   52: aastore
    //   53: dup
    //   54: iconst_1
    //   55: ldc_w 295
    //   58: aastore
    //   59: dup
    //   60: iconst_2
    //   61: ldc_w 297
    //   64: aastore
    //   65: aconst_null
    //   66: aconst_null
    //   67: aconst_null
    //   68: invokevirtual 121	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   71: astore 8
    //   73: aload 8
    //   75: ifnull +108 -> 183
    //   78: aload 8
    //   80: astore 7
    //   82: aload 8
    //   84: invokeinterface 127 1 0
    //   89: ifeq +94 -> 183
    //   92: aload 8
    //   94: astore 7
    //   96: aload 8
    //   98: ldc_w 293
    //   101: invokeinterface 131 2 0
    //   106: istore_3
    //   107: aload 8
    //   109: astore 7
    //   111: aload 8
    //   113: ldc_w 295
    //   116: invokeinterface 131 2 0
    //   121: istore 4
    //   123: aload 8
    //   125: astore 7
    //   127: aload 8
    //   129: ldc_w 297
    //   132: invokeinterface 131 2 0
    //   137: istore 5
    //   139: aload 8
    //   141: astore 7
    //   143: aload 8
    //   145: iload_3
    //   146: invokeinterface 135 2 0
    //   151: astore 9
    //   153: aload 8
    //   155: astore 7
    //   157: aload 9
    //   159: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   162: ifeq +34 -> 196
    //   165: aload 8
    //   167: astore 7
    //   169: aload 8
    //   171: invokeinterface 241 1 0
    //   176: istore 6
    //   178: iload 6
    //   180: ifne -41 -> 139
    //   183: aload 8
    //   185: ifnull -181 -> 4
    //   188: aload 8
    //   190: invokeinterface 152 1 0
    //   195: return
    //   196: aload 8
    //   198: astore 7
    //   200: new 21	java/lang/String
    //   203: dup
    //   204: aload 9
    //   206: invokevirtual 139	java/lang/String:getBytes	()[B
    //   209: ldc 141
    //   211: invokespecial 144	java/lang/String:<init>	([BLjava/lang/String;)V
    //   214: invokestatic 149	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   217: astore 11
    //   219: aload 8
    //   221: astore 7
    //   223: aload 8
    //   225: iload 4
    //   227: invokeinterface 135 2 0
    //   232: astore 9
    //   234: aload 8
    //   236: astore 7
    //   238: aload 9
    //   240: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   243: ifne +124 -> 367
    //   246: aload 8
    //   248: astore 7
    //   250: new 21	java/lang/String
    //   253: dup
    //   254: aload 9
    //   256: invokevirtual 139	java/lang/String:getBytes	()[B
    //   259: ldc 141
    //   261: invokespecial 144	java/lang/String:<init>	([BLjava/lang/String;)V
    //   264: invokestatic 149	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   267: astore 9
    //   269: aload 8
    //   271: astore 7
    //   273: aload_2
    //   274: new 70	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   281: aload 11
    //   283: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: iload_1
    //   287: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   290: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: aload 9
    //   295: invokevirtual 303	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   298: pop
    //   299: goto -134 -> 165
    //   302: astore_2
    //   303: aload 8
    //   305: astore 7
    //   307: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq +36 -> 346
    //   313: aload 8
    //   315: astore 7
    //   317: ldc 159
    //   319: iconst_2
    //   320: new 70	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   327: ldc_w 305
    //   330: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload_2
    //   334: invokevirtual 164	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   337: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: aload 8
    //   348: astore 7
    //   350: aload_2
    //   351: invokevirtual 171	java/lang/Throwable:printStackTrace	()V
    //   354: aload 8
    //   356: ifnull -352 -> 4
    //   359: aload 8
    //   361: invokeinterface 152 1 0
    //   366: return
    //   367: aload 8
    //   369: astore 7
    //   371: aload 8
    //   373: iload 5
    //   375: invokeinterface 135 2 0
    //   380: astore 9
    //   382: aload 8
    //   384: astore 7
    //   386: aload 9
    //   388: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   391: ifne -226 -> 165
    //   394: aload 8
    //   396: astore 7
    //   398: new 21	java/lang/String
    //   401: dup
    //   402: aload 9
    //   404: invokevirtual 139	java/lang/String:getBytes	()[B
    //   407: ldc 141
    //   409: invokespecial 144	java/lang/String:<init>	([BLjava/lang/String;)V
    //   412: invokestatic 149	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   415: astore 10
    //   417: aload 10
    //   419: astore 9
    //   421: aload 8
    //   423: astore 7
    //   425: aload 10
    //   427: invokevirtual 308	java/lang/String:length	()I
    //   430: iconst_1
    //   431: if_icmple +47 -> 478
    //   434: aload 10
    //   436: astore 9
    //   438: aload 8
    //   440: astore 7
    //   442: aload 10
    //   444: aload 10
    //   446: invokevirtual 308	java/lang/String:length	()I
    //   449: iconst_1
    //   450: isub
    //   451: invokevirtual 312	java/lang/String:charAt	(I)C
    //   454: bipush 10
    //   456: if_icmpne +22 -> 478
    //   459: aload 8
    //   461: astore 7
    //   463: aload 10
    //   465: iconst_0
    //   466: aload 10
    //   468: invokevirtual 308	java/lang/String:length	()I
    //   471: iconst_1
    //   472: isub
    //   473: invokevirtual 316	java/lang/String:substring	(II)Ljava/lang/String;
    //   476: astore 9
    //   478: aload 8
    //   480: astore 7
    //   482: aload_2
    //   483: new 70	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   490: aload 11
    //   492: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: iload_1
    //   496: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   499: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: aload 9
    //   504: invokevirtual 303	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   507: pop
    //   508: goto -343 -> 165
    //   511: astore_2
    //   512: aload 7
    //   514: ifnull +10 -> 524
    //   517: aload 7
    //   519: invokeinterface 152 1 0
    //   524: aload_2
    //   525: athrow
    //   526: astore_2
    //   527: aconst_null
    //   528: astore 7
    //   530: goto -18 -> 512
    //   533: astore_2
    //   534: aconst_null
    //   535: astore 8
    //   537: goto -234 -> 303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	540	0	this	annr
    //   0	540	1	paramInt	int
    //   0	540	2	paramHashMap	java.util.HashMap<String, String>
    //   106	40	3	i	int
    //   121	105	4	j	int
    //   137	237	5	k	int
    //   176	3	6	bool	boolean
    //   80	449	7	localCursor1	android.database.Cursor
    //   71	465	8	localCursor2	android.database.Cursor
    //   151	352	9	localObject	Object
    //   415	52	10	str1	String
    //   217	274	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   82	92	302	java/lang/Throwable
    //   96	107	302	java/lang/Throwable
    //   111	123	302	java/lang/Throwable
    //   127	139	302	java/lang/Throwable
    //   143	153	302	java/lang/Throwable
    //   157	165	302	java/lang/Throwable
    //   169	178	302	java/lang/Throwable
    //   200	219	302	java/lang/Throwable
    //   223	234	302	java/lang/Throwable
    //   238	246	302	java/lang/Throwable
    //   250	269	302	java/lang/Throwable
    //   273	299	302	java/lang/Throwable
    //   371	382	302	java/lang/Throwable
    //   386	394	302	java/lang/Throwable
    //   398	417	302	java/lang/Throwable
    //   425	434	302	java/lang/Throwable
    //   442	459	302	java/lang/Throwable
    //   463	478	302	java/lang/Throwable
    //   482	508	302	java/lang/Throwable
    //   82	92	511	finally
    //   96	107	511	finally
    //   111	123	511	finally
    //   127	139	511	finally
    //   143	153	511	finally
    //   157	165	511	finally
    //   169	178	511	finally
    //   200	219	511	finally
    //   223	234	511	finally
    //   238	246	511	finally
    //   250	269	511	finally
    //   273	299	511	finally
    //   307	313	511	finally
    //   317	346	511	finally
    //   350	354	511	finally
    //   371	382	511	finally
    //   386	394	511	finally
    //   398	417	511	finally
    //   425	434	511	finally
    //   442	459	511	finally
    //   463	478	511	finally
    //   482	508	511	finally
    //   5	73	526	finally
    //   5	73	533	java/lang/Throwable
  }
  
  public void a(annn paramannn)
  {
    this.jdField_a_of_type_Annn = paramannn;
  }
  
  public ArrayList<String> b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageDataManager", 2, "getMessageSlowTableNames");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface != null) {
      try
      {
        ArrayList localArrayList = a(this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.b().getAllTableNameFromDB());
        return localArrayList;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MessageDataManager", 2, "getMessageSlowTableNames exception = " + localException.getMessage());
        }
      }
    }
    return null;
  }
  
  public List<MessageRecord> b(Class<? extends Entity> paramClass, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageDataManager", 2, "getMessageSlowTableRecord");
    }
    paramString1 = a(paramClass, paramString1, paramString2, paramString3, paramArrayOfString, 2);
    if (paramString1 != null)
    {
      paramClass = paramString1;
      if (!paramString1.isEmpty()) {}
    }
    else
    {
      paramClass = null;
    }
    return paramClass;
  }
  
  /* Error */
  public void b(int paramInt, java.util.HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: invokestatic 107	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8: invokevirtual 113	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   11: new 70	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 325
    //   21: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 57	annr:jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface	Lcom/tencent/mobileqq/app/PeakAppInterface;
    //   28: invokevirtual 81	com/tencent/mobileqq/app/PeakAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   31: invokestatic 87	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   34: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   37: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 101	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   43: iconst_2
    //   44: anewarray 21	java/lang/String
    //   47: dup
    //   48: iconst_0
    //   49: ldc_w 327
    //   52: aastore
    //   53: dup
    //   54: iconst_1
    //   55: ldc_w 329
    //   58: aastore
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokevirtual 121	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore 7
    //   67: aload 7
    //   69: ifnull +92 -> 161
    //   72: aload 7
    //   74: astore 6
    //   76: aload 7
    //   78: invokeinterface 127 1 0
    //   83: ifeq +78 -> 161
    //   86: aload 7
    //   88: astore 6
    //   90: aload 7
    //   92: ldc_w 327
    //   95: invokeinterface 131 2 0
    //   100: istore_3
    //   101: aload 7
    //   103: astore 6
    //   105: aload 7
    //   107: ldc_w 329
    //   110: invokeinterface 131 2 0
    //   115: istore 4
    //   117: aload 7
    //   119: astore 6
    //   121: aload 7
    //   123: iload_3
    //   124: invokeinterface 135 2 0
    //   129: astore 8
    //   131: aload 7
    //   133: astore 6
    //   135: aload 8
    //   137: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   140: ifeq +34 -> 174
    //   143: aload 7
    //   145: astore 6
    //   147: aload 7
    //   149: invokeinterface 241 1 0
    //   154: istore 5
    //   156: iload 5
    //   158: ifne -41 -> 117
    //   161: aload 7
    //   163: ifnull -159 -> 4
    //   166: aload 7
    //   168: invokeinterface 152 1 0
    //   173: return
    //   174: aload 7
    //   176: astore 6
    //   178: new 21	java/lang/String
    //   181: dup
    //   182: aload 8
    //   184: invokevirtual 139	java/lang/String:getBytes	()[B
    //   187: ldc 141
    //   189: invokespecial 144	java/lang/String:<init>	([BLjava/lang/String;)V
    //   192: invokestatic 149	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   195: astore 8
    //   197: aload 7
    //   199: astore 6
    //   201: aload 7
    //   203: iload 4
    //   205: invokeinterface 135 2 0
    //   210: astore 9
    //   212: aload 7
    //   214: astore 6
    //   216: aload 9
    //   218: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   221: ifne -78 -> 143
    //   224: aload 7
    //   226: astore 6
    //   228: new 21	java/lang/String
    //   231: dup
    //   232: aload 9
    //   234: invokevirtual 139	java/lang/String:getBytes	()[B
    //   237: ldc 141
    //   239: invokespecial 144	java/lang/String:<init>	([BLjava/lang/String;)V
    //   242: invokestatic 149	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   245: astore 9
    //   247: aload 7
    //   249: astore 6
    //   251: aload_2
    //   252: new 70	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   259: aload 8
    //   261: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: iload_1
    //   265: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: aload 9
    //   273: invokevirtual 303	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   276: pop
    //   277: goto -134 -> 143
    //   280: astore_2
    //   281: aload 7
    //   283: astore 6
    //   285: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +36 -> 324
    //   291: aload 7
    //   293: astore 6
    //   295: ldc 159
    //   297: iconst_2
    //   298: new 70	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   305: ldc_w 331
    //   308: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload_2
    //   312: invokevirtual 164	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   315: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: aload 7
    //   326: astore 6
    //   328: aload_2
    //   329: invokevirtual 171	java/lang/Throwable:printStackTrace	()V
    //   332: aload 7
    //   334: ifnull -330 -> 4
    //   337: aload 7
    //   339: invokeinterface 152 1 0
    //   344: return
    //   345: astore_2
    //   346: aconst_null
    //   347: astore 6
    //   349: aload 6
    //   351: ifnull +10 -> 361
    //   354: aload 6
    //   356: invokeinterface 152 1 0
    //   361: aload_2
    //   362: athrow
    //   363: astore_2
    //   364: goto -15 -> 349
    //   367: astore_2
    //   368: aconst_null
    //   369: astore 7
    //   371: goto -90 -> 281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	this	annr
    //   0	374	1	paramInt	int
    //   0	374	2	paramHashMap	java.util.HashMap<String, String>
    //   100	24	3	i	int
    //   115	89	4	j	int
    //   154	3	5	bool	boolean
    //   74	281	6	localCursor1	android.database.Cursor
    //   65	305	7	localCursor2	android.database.Cursor
    //   129	131	8	str1	String
    //   210	62	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   76	86	280	java/lang/Throwable
    //   90	101	280	java/lang/Throwable
    //   105	117	280	java/lang/Throwable
    //   121	131	280	java/lang/Throwable
    //   135	143	280	java/lang/Throwable
    //   147	156	280	java/lang/Throwable
    //   178	197	280	java/lang/Throwable
    //   201	212	280	java/lang/Throwable
    //   216	224	280	java/lang/Throwable
    //   228	247	280	java/lang/Throwable
    //   251	277	280	java/lang/Throwable
    //   5	67	345	finally
    //   76	86	363	finally
    //   90	101	363	finally
    //   105	117	363	finally
    //   121	131	363	finally
    //   135	143	363	finally
    //   147	156	363	finally
    //   178	197	363	finally
    //   201	212	363	finally
    //   216	224	363	finally
    //   228	247	363	finally
    //   251	277	363	finally
    //   285	291	363	finally
    //   295	324	363	finally
    //   328	332	363	finally
    //   5	67	367	java/lang/Throwable
  }
  
  public List<MessageRecord> c(Class<? extends Entity> paramClass, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageDataManager", 2, "getMultiMessage");
    }
    paramString1 = a(paramClass, paramString1, paramString2, paramString3, paramArrayOfString, 1);
    if (paramString1 != null)
    {
      paramClass = paramString1;
      if (!paramString1.isEmpty()) {}
    }
    else
    {
      paramClass = null;
    }
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     annr
 * JD-Core Version:    0.7.0.1
 */