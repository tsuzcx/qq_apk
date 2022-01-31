import android.os.AsyncTask;
import cooperation.dingdong.DingdongPluginManager;

public class amsh
  extends AsyncTask
{
  public amsh(DingdongPluginManager paramDingdongPluginManager, int paramInt, amsi paramamsi) {}
  
  /* Error */
  protected java.lang.Void a(com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.ScheduleMoreSummaryData... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	amsh:jdField_a_of_type_CooperationDingdongDingdongPluginManager	Lcooperation/dingdong/DingdongPluginManager;
    //   4: invokestatic 26	cooperation/dingdong/DingdongPluginManager:a	(Lcooperation/dingdong/DingdongPluginManager;)Ljava/util/HashMap;
    //   7: astore 4
    //   9: aload 4
    //   11: monitorenter
    //   12: aload_1
    //   13: iconst_0
    //   14: aaload
    //   15: astore_1
    //   16: aload_0
    //   17: getfield 12	amsh:jdField_a_of_type_CooperationDingdongDingdongPluginManager	Lcooperation/dingdong/DingdongPluginManager;
    //   20: invokestatic 29	cooperation/dingdong/DingdongPluginManager:a	(Lcooperation/dingdong/DingdongPluginManager;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   23: invokevirtual 35	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   26: new 37	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   33: aload_0
    //   34: getfield 12	amsh:jdField_a_of_type_CooperationDingdongDingdongPluginManager	Lcooperation/dingdong/DingdongPluginManager;
    //   37: invokestatic 29	cooperation/dingdong/DingdongPluginManager:a	(Lcooperation/dingdong/DingdongPluginManager;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   40: invokevirtual 42	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   43: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc 48
    //   48: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: iconst_0
    //   55: invokevirtual 57	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   58: aload_1
    //   59: getfield 62	com/tencent/mobileqq/app/utils/DingdongPluginBizObserver$ScheduleMoreSummaryData:a	Lcooperation/dingdong/DingdongPluginDataFactory$ScheduleSummaryData;
    //   62: getfield 68	cooperation/dingdong/DingdongPluginDataFactory$ScheduleSummaryData:id	Ljava/lang/String;
    //   65: lconst_0
    //   66: invokeinterface 74 4 0
    //   71: lstore_2
    //   72: lload_2
    //   73: lconst_0
    //   74: lcmp
    //   75: ifne +16 -> 91
    //   78: aload_0
    //   79: getfield 14	amsh:jdField_a_of_type_Int	I
    //   82: aload_1
    //   83: invokestatic 80	cooperation/dingdong/DingdongCalendarSyncUtil:b	(ILcom/tencent/mobileqq/app/utils/DingdongPluginBizObserver$ScheduleMoreSummaryData;)V
    //   86: aload 4
    //   88: monitorexit
    //   89: aconst_null
    //   90: areturn
    //   91: lload_2
    //   92: lconst_0
    //   93: lcmp
    //   94: ifle +15 -> 109
    //   97: lload_2
    //   98: aload_0
    //   99: getfield 16	amsh:jdField_a_of_type_Amsi	Lamsi;
    //   102: getfield 85	amsi:b	J
    //   105: lcmp
    //   106: ifgt -20 -> 86
    //   109: aload_0
    //   110: getfield 14	amsh:jdField_a_of_type_Int	I
    //   113: aload_1
    //   114: invokestatic 80	cooperation/dingdong/DingdongCalendarSyncUtil:b	(ILcom/tencent/mobileqq/app/utils/DingdongPluginBizObserver$ScheduleMoreSummaryData;)V
    //   117: goto -31 -> 86
    //   120: astore_1
    //   121: aload 4
    //   123: monitorexit
    //   124: aload_1
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	amsh
    //   0	126	1	paramVarArgs	com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.ScheduleMoreSummaryData[]
    //   71	27	2	l	long
    //   7	115	4	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   16	72	120	finally
    //   78	86	120	finally
    //   86	89	120	finally
    //   97	109	120	finally
    //   109	117	120	finally
    //   121	124	120	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsh
 * JD-Core Version:    0.7.0.1
 */