package com.tencent.mobileqq.activity.aio.anim.config;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class TroopDragonKingAnimEntryConfig
{
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  
  public TroopDragonKingAnimEntryConfig()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
  }
  
  /* Error */
  public static TroopDragonKingAnimEntryConfig a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +38 -> 41
    //   6: new 31	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   13: astore 5
    //   15: aload 5
    //   17: ldc 34
    //   19: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 5
    //   25: aload_0
    //   26: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 40
    //   32: iconst_2
    //   33: aload 5
    //   35: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_0
    //   42: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   45: ifeq +5 -> 50
    //   48: aconst_null
    //   49: areturn
    //   50: new 16	java/util/ArrayList
    //   53: dup
    //   54: invokespecial 17	java/util/ArrayList:<init>	()V
    //   57: astore 5
    //   59: iconst_0
    //   60: istore 4
    //   62: new 56	org/json/JSONObject
    //   65: dup
    //   66: aload_0
    //   67: invokespecial 59	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   70: astore_0
    //   71: aload_0
    //   72: ldc 61
    //   74: iconst_0
    //   75: invokevirtual 65	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   78: istore_1
    //   79: aload_0
    //   80: ldc 67
    //   82: invokevirtual 71	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   85: astore_0
    //   86: iload_1
    //   87: istore_3
    //   88: aload_0
    //   89: ifnull +58 -> 147
    //   92: iload_1
    //   93: istore_3
    //   94: aload_0
    //   95: invokevirtual 77	org/json/JSONArray:length	()I
    //   98: ifle +49 -> 147
    //   101: iconst_0
    //   102: istore_2
    //   103: iload_1
    //   104: istore_3
    //   105: iload_2
    //   106: aload_0
    //   107: invokevirtual 77	org/json/JSONArray:length	()I
    //   110: if_icmpge +37 -> 147
    //   113: aload 5
    //   115: aload_0
    //   116: iload_2
    //   117: invokevirtual 81	org/json/JSONArray:getInt	(I)I
    //   120: invokestatic 87	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   123: invokevirtual 91	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   126: pop
    //   127: iload_2
    //   128: iconst_1
    //   129: iadd
    //   130: istore_2
    //   131: goto -28 -> 103
    //   134: astore_0
    //   135: goto +6 -> 141
    //   138: astore_0
    //   139: iconst_0
    //   140: istore_1
    //   141: aload_0
    //   142: invokevirtual 94	org/json/JSONException:printStackTrace	()V
    //   145: iload_1
    //   146: istore_3
    //   147: new 2	com/tencent/mobileqq/activity/aio/anim/config/TroopDragonKingAnimEntryConfig
    //   150: dup
    //   151: invokespecial 95	com/tencent/mobileqq/activity/aio/anim/config/TroopDragonKingAnimEntryConfig:<init>	()V
    //   154: astore_0
    //   155: iload_3
    //   156: iconst_1
    //   157: if_icmpne +6 -> 163
    //   160: iconst_1
    //   161: istore 4
    //   163: aload_0
    //   164: iload 4
    //   166: putfield 14	com/tencent/mobileqq/activity/aio/anim/config/TroopDragonKingAnimEntryConfig:jdField_a_of_type_Boolean	Z
    //   169: aload_0
    //   170: aload 5
    //   172: putfield 19	com/tencent/mobileqq/activity/aio/anim/config/TroopDragonKingAnimEntryConfig:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   175: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq +62 -> 240
    //   181: new 31	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   188: astore 5
    //   190: aload 5
    //   192: ldc 97
    //   194: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 5
    //   200: aload_0
    //   201: getfield 14	com/tencent/mobileqq/activity/aio/anim/config/TroopDragonKingAnimEntryConfig:jdField_a_of_type_Boolean	Z
    //   204: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 5
    //   210: ldc 102
    //   212: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 5
    //   218: aload_0
    //   219: getfield 19	com/tencent/mobileqq/activity/aio/anim/config/TroopDragonKingAnimEntryConfig:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   222: invokevirtual 103	java/util/ArrayList:toString	()Ljava/lang/String;
    //   225: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: ldc 40
    //   231: iconst_2
    //   232: aload 5
    //   234: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: aload_0
    //   241: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	paramString	String
    //   78	68	1	i	int
    //   102	29	2	j	int
    //   87	71	3	k	int
    //   60	105	4	bool	boolean
    //   13	220	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   79	86	134	org/json/JSONException
    //   94	101	134	org/json/JSONException
    //   105	127	134	org/json/JSONException
    //   62	79	138	org/json/JSONException
  }
  
  public boolean a(String paramString)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopDragonKingAnimEntryConfig.config", 2, "isDragKingEntry : troopUin null");
      }
      return false;
    }
    if (paramString.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopDragonKingAnimEntryConfig.config", 2, "isDragKingEntry : troopUin empty");
      }
      return false;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopDragonKingAnimEntryConfig.config", 2, "isDragKingEntry : true");
      }
      return true;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return false;
    }
    paramString = paramString.substring(paramString.length() - 1);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((String)this.jdField_a_of_type_JavaUtilArrayList.get(i)).equals(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopDragonKingAnimEntryConfig.config", 2, "isDragKingEntry : gray true!");
        }
        return true;
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopDragonKingAnimEntryConfig.config", 2, "isDragKingEntry: gray false!");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.config.TroopDragonKingAnimEntryConfig
 * JD-Core Version:    0.7.0.1
 */