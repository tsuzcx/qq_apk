import java.util.ArrayList;

public class bafb
{
  public static boolean a;
  public ArrayList<Integer> a;
  
  public bafb()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_Boolean = false;
  }
  
  /* Error */
  public static bafb a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 29	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 14	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 15	java/util/ArrayList:<init>	()V
    //   16: astore 5
    //   18: new 31	org/json/JSONObject
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 34	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   26: astore_0
    //   27: aload_0
    //   28: ldc 36
    //   30: iconst_0
    //   31: invokevirtual 40	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   34: istore_1
    //   35: aload_0
    //   36: ldc 42
    //   38: invokevirtual 46	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   41: astore_0
    //   42: iload_1
    //   43: istore_3
    //   44: aload_0
    //   45: ifnull +54 -> 99
    //   48: iload_1
    //   49: istore_3
    //   50: aload_0
    //   51: invokevirtual 52	org/json/JSONArray:length	()I
    //   54: ifle +45 -> 99
    //   57: iconst_0
    //   58: istore_2
    //   59: iload_1
    //   60: istore_3
    //   61: iload_2
    //   62: aload_0
    //   63: invokevirtual 52	org/json/JSONArray:length	()I
    //   66: if_icmpge +33 -> 99
    //   69: aload 5
    //   71: aload_0
    //   72: iload_2
    //   73: invokevirtual 56	org/json/JSONArray:getInt	(I)I
    //   76: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   79: invokevirtual 66	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   82: pop
    //   83: iload_2
    //   84: iconst_1
    //   85: iadd
    //   86: istore_2
    //   87: goto -28 -> 59
    //   90: astore_0
    //   91: iconst_0
    //   92: istore_1
    //   93: aload_0
    //   94: invokevirtual 69	org/json/JSONException:printStackTrace	()V
    //   97: iload_1
    //   98: istore_3
    //   99: new 2	bafb
    //   102: dup
    //   103: invokespecial 70	bafb:<init>	()V
    //   106: astore_0
    //   107: aload_0
    //   108: ifnull +22 -> 130
    //   111: iload_3
    //   112: iconst_1
    //   113: if_icmpne +19 -> 132
    //   116: iconst_1
    //   117: istore 4
    //   119: iload 4
    //   121: putstatic 19	bafb:jdField_a_of_type_Boolean	Z
    //   124: aload_0
    //   125: aload 5
    //   127: putfield 17	bafb:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   130: aload_0
    //   131: areturn
    //   132: iconst_0
    //   133: istore 4
    //   135: goto -16 -> 119
    //   138: astore_0
    //   139: goto -46 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramString	java.lang.String
    //   34	64	1	i	int
    //   58	29	2	j	int
    //   43	71	3	k	int
    //   117	17	4	bool	boolean
    //   16	110	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   18	35	90	org/json/JSONException
    //   35	42	138	org/json/JSONException
    //   50	57	138	org/json/JSONException
    //   61	83	138	org/json/JSONException
  }
  
  public boolean a(int paramInt)
  {
    return (true == jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bafb
 * JD-Core Version:    0.7.0.1
 */