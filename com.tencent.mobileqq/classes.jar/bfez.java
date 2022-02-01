import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bfez
{
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  
  public bfez()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
  }
  
  /* Error */
  public static bfez a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 31
    //   8: iconst_2
    //   9: new 33	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   16: ldc 36
    //   18: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: aload_0
    //   32: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifeq +5 -> 40
    //   38: aconst_null
    //   39: areturn
    //   40: new 14	java/util/ArrayList
    //   43: dup
    //   44: invokespecial 15	java/util/ArrayList:<init>	()V
    //   47: astore 5
    //   49: new 56	org/json/JSONObject
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 59	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   57: astore_0
    //   58: aload_0
    //   59: ldc 61
    //   61: iconst_0
    //   62: invokevirtual 65	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   65: istore_1
    //   66: aload_0
    //   67: ldc 67
    //   69: invokevirtual 71	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   72: astore_0
    //   73: iload_1
    //   74: istore_3
    //   75: aload_0
    //   76: ifnull +54 -> 130
    //   79: iload_1
    //   80: istore_3
    //   81: aload_0
    //   82: invokevirtual 77	org/json/JSONArray:length	()I
    //   85: ifle +45 -> 130
    //   88: iconst_0
    //   89: istore_2
    //   90: iload_1
    //   91: istore_3
    //   92: iload_2
    //   93: aload_0
    //   94: invokevirtual 77	org/json/JSONArray:length	()I
    //   97: if_icmpge +33 -> 130
    //   100: aload 5
    //   102: aload_0
    //   103: iload_2
    //   104: invokevirtual 81	org/json/JSONArray:getInt	(I)I
    //   107: invokestatic 87	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   110: invokevirtual 91	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   113: pop
    //   114: iload_2
    //   115: iconst_1
    //   116: iadd
    //   117: istore_2
    //   118: goto -28 -> 90
    //   121: astore_0
    //   122: iconst_0
    //   123: istore_1
    //   124: aload_0
    //   125: invokevirtual 94	org/json/JSONException:printStackTrace	()V
    //   128: iload_1
    //   129: istore_3
    //   130: new 2	bfez
    //   133: dup
    //   134: invokespecial 95	bfez:<init>	()V
    //   137: astore_0
    //   138: iload_3
    //   139: iconst_1
    //   140: if_icmpne +69 -> 209
    //   143: iconst_1
    //   144: istore 4
    //   146: aload_0
    //   147: iload 4
    //   149: putfield 19	bfez:jdField_a_of_type_Boolean	Z
    //   152: aload_0
    //   153: aload 5
    //   155: putfield 17	bfez:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   158: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +46 -> 207
    //   164: ldc 31
    //   166: iconst_2
    //   167: new 33	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   174: ldc 97
    //   176: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_0
    //   180: getfield 19	bfez:jdField_a_of_type_Boolean	Z
    //   183: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   186: ldc 102
    //   188: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_0
    //   192: getfield 17	bfez:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   195: invokevirtual 103	java/util/ArrayList:toString	()Ljava/lang/String;
    //   198: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aload_0
    //   208: areturn
    //   209: iconst_0
    //   210: istore 4
    //   212: goto -66 -> 146
    //   215: astore_0
    //   216: goto -92 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	paramString	String
    //   65	64	1	i	int
    //   89	29	2	j	int
    //   74	67	3	k	int
    //   144	67	4	bool	boolean
    //   47	107	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   49	66	121	org/json/JSONException
    //   66	73	215	org/json/JSONException
    //   81	88	215	org/json/JSONException
    //   92	114	215	org/json/JSONException
  }
  
  public boolean a(String paramString)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopActiveRankingConfig", 2, "isShowEntry : troopUin null");
      }
    }
    do
    {
      do
      {
        do
        {
          return false;
          if (!paramString.isEmpty()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("TroopActiveRankingConfig", 2, "isShowEntry : troopUin empty");
        return false;
        if (this.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopActiveRankingConfig", 2, "isShowEntry : true");
          }
          return true;
        }
      } while (this.jdField_a_of_type_JavaUtilArrayList.isEmpty());
      paramString = paramString.substring(paramString.length() - 1);
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((String)this.jdField_a_of_type_JavaUtilArrayList.get(i)).equals(paramString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopActiveRankingConfig", 2, "isShowEntry : gray true!");
          }
          return true;
        }
        i += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopActiveRankingConfig", 2, "isShowEntry: gray false!");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfez
 * JD-Core Version:    0.7.0.1
 */