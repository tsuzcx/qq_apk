import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.weiyun.transmission.db.JobDbWrapper;

public class bkls
{
  public static int a(String paramString)
  {
    JobDbWrapper localJobDbWrapper = JobDbManager.getInstance().openJobDb(true);
    if (localJobDbWrapper == null) {
      return 0;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("valid_flag", Integer.valueOf(0));
    int i = localJobDbWrapper.update("download", localContentValues, "uid=? AND state = 4", new String[] { paramString });
    JobDbManager.getInstance().closeJobDb(localJobDbWrapper);
    return i;
  }
  
  private static bklr a(Cursor paramCursor)
  {
    bklr localbklr = new bklr();
    localbklr.jdField_a_of_type_Long = paramCursor.getLong(0);
    localbklr.jdField_a_of_type_JavaLangString = paramCursor.getString(1);
    localbklr.jdField_b_of_type_JavaLangString = paramCursor.getString(2);
    localbklr.jdField_c_of_type_JavaLangString = paramCursor.getString(3);
    localbklr.jdField_d_of_type_JavaLangString = paramCursor.getString(4);
    localbklr.jdField_e_of_type_JavaLangString = paramCursor.getString(5);
    localbklr.jdField_b_of_type_Long = paramCursor.getLong(6);
    localbklr.f = paramCursor.getString(7);
    localbklr.jdField_c_of_type_Long = paramCursor.getLong(8);
    localbklr.g = paramCursor.getString(9);
    localbklr.jdField_a_of_type_Int = paramCursor.getInt(10);
    localbklr.jdField_b_of_type_Int = paramCursor.getInt(11);
    localbklr.h = paramCursor.getString(12);
    localbklr.jdField_d_of_type_Long = paramCursor.getLong(13);
    localbklr.jdField_e_of_type_Long = paramCursor.getLong(14);
    localbklr.i = paramCursor.getString(15);
    localbklr.j = paramCursor.getString(16);
    localbklr.k = paramCursor.getString(17);
    localbklr.l = paramCursor.getString(18);
    return localbklr;
  }
  
  /* Error */
  public static java.util.ArrayList<bklr> a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 126	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 127	java/util/ArrayList:<init>	()V
    //   9: astore_2
    //   10: invokestatic 12	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   13: iconst_1
    //   14: invokevirtual 16	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   17: astore_3
    //   18: aload_3
    //   19: ifnonnull +5 -> 24
    //   22: aload_2
    //   23: areturn
    //   24: new 129	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   31: ldc 132
    //   33: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc 138
    //   38: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 24
    //   43: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc 140
    //   48: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: astore 4
    //   53: aload_3
    //   54: ldc 36
    //   56: getstatic 145	bklt:a	[Ljava/lang/String;
    //   59: aload 4
    //   61: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: iconst_1
    //   65: anewarray 40	java/lang/String
    //   68: dup
    //   69: iconst_0
    //   70: aload_0
    //   71: aastore
    //   72: aconst_null
    //   73: aconst_null
    //   74: ldc 151
    //   76: invokevirtual 155	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   79: astore_0
    //   80: aload_0
    //   81: ifnull +38 -> 119
    //   84: aload_0
    //   85: invokeinterface 159 1 0
    //   90: ifeq +29 -> 119
    //   93: aload_2
    //   94: aload_0
    //   95: invokestatic 161	bkls:a	(Landroid/database/Cursor;)Lbklr;
    //   98: invokevirtual 165	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   101: pop
    //   102: goto -18 -> 84
    //   105: astore_1
    //   106: aload_0
    //   107: invokestatic 171	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   110: invokestatic 12	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   113: aload_3
    //   114: invokevirtual 50	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   117: aload_2
    //   118: areturn
    //   119: aload_0
    //   120: invokestatic 171	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   123: goto -13 -> 110
    //   126: astore_0
    //   127: aload_1
    //   128: invokestatic 171	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   131: aload_0
    //   132: athrow
    //   133: astore_2
    //   134: aload_0
    //   135: astore_1
    //   136: aload_2
    //   137: astore_0
    //   138: goto -11 -> 127
    //   141: astore_0
    //   142: aconst_null
    //   143: astore_0
    //   144: goto -38 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramString	String
    //   1	1	1	localObject1	Object
    //   105	23	1	localThrowable	java.lang.Throwable
    //   135	1	1	str	String
    //   9	109	2	localArrayList	java.util.ArrayList
    //   133	4	2	localObject2	Object
    //   17	97	3	localJobDbWrapper	JobDbWrapper
    //   51	9	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   84	102	105	java/lang/Throwable
    //   24	80	126	finally
    //   84	102	133	finally
    //   24	80	141	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkls
 * JD-Core Version:    0.7.0.1
 */