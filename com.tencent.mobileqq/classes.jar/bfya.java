import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bfya
{
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  /* Error */
  public static bfya a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +28 -> 34
    //   9: ldc 30
    //   11: iconst_2
    //   12: new 32	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   19: ldc 35
    //   21: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 47	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifeq +5 -> 43
    //   41: aconst_null
    //   42: areturn
    //   43: new 15	java/util/ArrayList
    //   46: dup
    //   47: invokespecial 16	java/util/ArrayList:<init>	()V
    //   50: astore 8
    //   52: new 55	org/json/JSONObject
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 58	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   60: astore_0
    //   61: aload_0
    //   62: ldc 60
    //   64: iconst_0
    //   65: invokevirtual 64	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   68: istore_2
    //   69: aload_0
    //   70: ldc 66
    //   72: iconst_0
    //   73: invokevirtual 64	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   76: istore_1
    //   77: aload_0
    //   78: ldc 68
    //   80: invokevirtual 72	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   83: astore_0
    //   84: iload_1
    //   85: istore 5
    //   87: iload_2
    //   88: istore_3
    //   89: aload_0
    //   90: ifnull +70 -> 160
    //   93: iload_1
    //   94: istore 5
    //   96: iload_2
    //   97: istore_3
    //   98: aload_0
    //   99: invokevirtual 78	org/json/JSONArray:length	()I
    //   102: ifle +58 -> 160
    //   105: iconst_0
    //   106: istore 4
    //   108: iload_1
    //   109: istore 5
    //   111: iload_2
    //   112: istore_3
    //   113: iload 4
    //   115: aload_0
    //   116: invokevirtual 78	org/json/JSONArray:length	()I
    //   119: if_icmpge +41 -> 160
    //   122: aload 8
    //   124: aload_0
    //   125: iload 4
    //   127: invokevirtual 82	org/json/JSONArray:getInt	(I)I
    //   130: invokestatic 88	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   133: invokevirtual 92	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   136: pop
    //   137: iload 4
    //   139: iconst_1
    //   140: iadd
    //   141: istore 4
    //   143: goto -35 -> 108
    //   146: astore_0
    //   147: iconst_0
    //   148: istore_2
    //   149: iconst_0
    //   150: istore_1
    //   151: aload_0
    //   152: invokevirtual 95	org/json/JSONException:printStackTrace	()V
    //   155: iload_2
    //   156: istore_3
    //   157: iload_1
    //   158: istore 5
    //   160: new 2	bfya
    //   163: dup
    //   164: invokespecial 96	bfya:<init>	()V
    //   167: astore_0
    //   168: iload_3
    //   169: ifeq +96 -> 265
    //   172: iconst_1
    //   173: istore 6
    //   175: aload_0
    //   176: iload 6
    //   178: putfield 98	bfya:jdField_a_of_type_Boolean	Z
    //   181: iload 5
    //   183: ifeq +88 -> 271
    //   186: iload 7
    //   188: istore 6
    //   190: aload_0
    //   191: iload 6
    //   193: putfield 100	bfya:b	Z
    //   196: aload_0
    //   197: aload 8
    //   199: putfield 18	bfya:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   202: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +58 -> 263
    //   208: ldc 30
    //   210: iconst_2
    //   211: new 32	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   218: ldc 102
    //   220: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_0
    //   224: getfield 98	bfya:jdField_a_of_type_Boolean	Z
    //   227: invokevirtual 105	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   230: ldc 107
    //   232: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_0
    //   236: getfield 100	bfya:b	Z
    //   239: invokevirtual 105	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   242: ldc 109
    //   244: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_0
    //   248: getfield 18	bfya:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   251: invokevirtual 110	java/util/ArrayList:toString	()Ljava/lang/String;
    //   254: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 47	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: aload_0
    //   264: areturn
    //   265: iconst_0
    //   266: istore 6
    //   268: goto -93 -> 175
    //   271: iconst_0
    //   272: istore 6
    //   274: goto -84 -> 190
    //   277: astore_0
    //   278: iconst_0
    //   279: istore_1
    //   280: goto -129 -> 151
    //   283: astore_0
    //   284: goto -133 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	paramString	String
    //   76	204	1	i	int
    //   68	88	2	j	int
    //   88	81	3	k	int
    //   106	36	4	m	int
    //   85	97	5	n	int
    //   173	100	6	bool1	boolean
    //   1	186	7	bool2	boolean
    //   50	148	8	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   52	69	146	org/json/JSONException
    //   69	77	277	org/json/JSONException
    //   77	84	283	org/json/JSONException
    //   98	105	283	org/json/JSONException
    //   113	137	283	org/json/JSONException
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean a(String paramString)
  {
    boolean bool1 = false;
    boolean bool2;
    if (TextUtils.isEmpty(paramString))
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopLuckyCharacterConfig", 2, "isGrayTroop : troopUin error");
        bool2 = bool1;
      }
      return bool2;
    }
    bool1 = this.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopLuckyCharacterConfig", 2, "isGrayTroop : true");
      }
      return bool1;
    }
    paramString = paramString.substring(paramString.length() - 1);
    int i = 0;
    label73:
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (((String)this.jdField_a_of_type_JavaUtilArrayList.get(i)).equals(paramString)) {
        bool1 = true;
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopLuckyCharacterConfig", 2, "isGrayTroop : " + bool1);
      return bool1;
      i += 1;
      break label73;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfya
 * JD-Core Version:    0.7.0.1
 */