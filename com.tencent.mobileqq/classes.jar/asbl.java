import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class asbl
{
  private static final asbn jdField_a_of_type_Asbn = new asbn(null);
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("(?<=\\[).*?(?=\\])");
  private int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private ArrayList<asbe> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public asbl(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private int a(String paramString)
  {
    int j = 0;
    paramString = paramString.split("\\:");
    int i = j;
    try
    {
      if (paramString.length == 2)
      {
        i = j;
        if ("offset".equalsIgnoreCase(paramString[0])) {
          i = Integer.parseInt(paramString[1].trim());
        }
      }
      return i;
    }
    catch (Exception paramString)
    {
      Log.e("ParsingLrc", paramString.toString());
    }
    return 0;
  }
  
  private long a(String paramString)
  {
    paramString = paramString.split("\\:|\\.");
    if (paramString.length < 2) {}
    do
    {
      return -1L;
      if (paramString.length == 2) {}
      int i;
      int j;
      int k;
      try
      {
        if ((this.jdField_a_of_type_Int == 0) && (paramString[0].equalsIgnoreCase("offset")))
        {
          this.jdField_a_of_type_Int = Integer.parseInt(paramString[1]);
          return -1L;
        }
        i = Integer.parseInt(paramString[0]);
        j = Integer.parseInt(paramString[1]);
        if ((i < 0) || (j < 0) || (j >= 60)) {
          throw new RuntimeException(ajya.a(2131707892));
        }
        return (i * 60 + j) * 1000L;
      }
      catch (Exception paramString) {}
    } while (paramString.length != 3);
    try
    {
      i = Integer.parseInt(paramString[0]);
      j = Integer.parseInt(paramString[1]);
      k = Integer.parseInt(paramString[2]);
      if ((i < 0) || (j < 0) || (j >= 60) || (k < 0) || (k > 99)) {
        throw new RuntimeException(ajya.a(2131707893));
      }
    }
    catch (Exception paramString)
    {
      return -1L;
    }
    return (i * 60 + j) * 1000L + k * 10;
    return -1L;
  }
  
  private void a(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return;
    }
    Object localObject2 = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    ArrayList localArrayList = new ArrayList();
    int i = -1;
    int j = -1;
    label36:
    Object localObject1;
    if (((Matcher)localObject2).find())
    {
      localObject1 = ((Matcher)localObject2).group();
      if (localObject1 != null) {
        break label455;
      }
      localObject1 = "";
    }
    label455:
    for (;;)
    {
      for (;;)
      {
        int k = paramString.indexOf("[" + (String)localObject1 + "]");
        long l;
        if ((j != -1) && (k - j > i + 2))
        {
          String str = paramString.substring(i + j + 2, k);
          Iterator localIterator = localArrayList.iterator();
          while (localIterator.hasNext())
          {
            l = a((String)localIterator.next());
            if (l != -1L)
            {
              asbe localasbe = new asbe();
              localasbe.jdField_a_of_type_JavaLangString = str;
              localasbe.jdField_a_of_type_Long = l;
              this.jdField_a_of_type_JavaUtilArrayList.add(localasbe);
            }
          }
          localArrayList.clear();
        }
        localArrayList.add(localObject1);
        i = ((String)localObject1).length();
        j = k;
        break label36;
        if (localArrayList.isEmpty()) {
          break;
        }
        j = i + 2 + j;
        i = j;
        try
        {
          if (j > paramString.length()) {
            i = paramString.length();
          }
          paramString = paramString.substring(i).trim();
          if ((paramString.length() == 0) && (this.jdField_a_of_type_Int == 0))
          {
            paramString = localArrayList.iterator();
            while (paramString.hasNext())
            {
              i = a((String)paramString.next());
              if (i != 2147483647) {
                this.jdField_a_of_type_Int = i;
              }
            }
            return;
          }
          localObject1 = localArrayList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            l = a((String)((Iterator)localObject1).next());
            if ((l != -1L) && (paramString.length() > 0))
            {
              localObject2 = new asbe();
              ((asbe)localObject2).jdField_a_of_type_JavaLangString = paramString;
              ((asbe)localObject2).jdField_a_of_type_Long = l;
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
            }
          }
        }
        catch (Exception paramString)
        {
          Log.e("ParsingLrc", paramString.toString());
          return;
          return;
        }
        finally
        {
          if (localArrayList != null) {
            localArrayList.clear();
          }
        }
      }
    }
  }
  
  /* Error */
  public asbc a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	asbl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4: ifnonnull +7 -> 11
    //   7: aconst_null
    //   8: astore_2
    //   9: aload_2
    //   10: areturn
    //   11: aload_0
    //   12: getfield 42	asbl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +64 -> 81
    //   20: new 182	java/io/BufferedReader
    //   23: dup
    //   24: new 184	java/io/StringReader
    //   27: dup
    //   28: aload_2
    //   29: invokespecial 185	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   32: invokespecial 188	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   35: astore_3
    //   36: aload_3
    //   37: invokevirtual 191	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore_2
    //   41: aload_2
    //   42: ifnull +41 -> 83
    //   45: aload_0
    //   46: aload_2
    //   47: invokevirtual 63	java/lang/String:trim	()Ljava/lang/String;
    //   50: invokespecial 193	asbl:a	(Ljava/lang/String;)V
    //   53: goto -17 -> 36
    //   56: astore 4
    //   58: aload_3
    //   59: astore_2
    //   60: aload 4
    //   62: astore_3
    //   63: ldc 70
    //   65: aload_3
    //   66: invokevirtual 73	java/lang/Exception:toString	()Ljava/lang/String;
    //   69: invokestatic 79	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   72: pop
    //   73: aload_2
    //   74: ifnull +7 -> 81
    //   77: aload_2
    //   78: invokevirtual 196	java/io/BufferedReader:close	()V
    //   81: aconst_null
    //   82: areturn
    //   83: aload_0
    //   84: getfield 40	asbl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   87: getstatic 31	asbl:jdField_a_of_type_Asbn	Lasbn;
    //   90: invokestatic 202	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   93: iconst_0
    //   94: istore_1
    //   95: iload_1
    //   96: aload_0
    //   97: getfield 40	asbl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   100: invokevirtual 205	java/util/ArrayList:size	()I
    //   103: if_icmpge +95 -> 198
    //   106: iload_1
    //   107: aload_0
    //   108: getfield 40	asbl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   111: invokevirtual 205	java/util/ArrayList:size	()I
    //   114: iconst_1
    //   115: isub
    //   116: if_icmpge +51 -> 167
    //   119: aload_0
    //   120: getfield 40	asbl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   123: iload_1
    //   124: invokevirtual 209	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   127: checkcast 154	asbe
    //   130: aload_0
    //   131: getfield 40	asbl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   134: iload_1
    //   135: iconst_1
    //   136: iadd
    //   137: invokevirtual 209	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   140: checkcast 154	asbe
    //   143: getfield 159	asbe:jdField_a_of_type_Long	J
    //   146: aload_0
    //   147: getfield 40	asbl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   150: iload_1
    //   151: invokevirtual 209	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   154: checkcast 154	asbe
    //   157: getfield 159	asbe:jdField_a_of_type_Long	J
    //   160: lsub
    //   161: putfield 212	asbe:b	J
    //   164: goto +130 -> 294
    //   167: aload_0
    //   168: getfield 40	asbl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   171: iload_1
    //   172: invokevirtual 209	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   175: checkcast 154	asbe
    //   178: ldc2_w 213
    //   181: putfield 212	asbe:b	J
    //   184: goto +110 -> 294
    //   187: astore_2
    //   188: aload_3
    //   189: ifnull +7 -> 196
    //   192: aload_3
    //   193: invokevirtual 196	java/io/BufferedReader:close	()V
    //   196: aload_2
    //   197: athrow
    //   198: new 216	asbc
    //   201: dup
    //   202: iconst_1
    //   203: aload_0
    //   204: getfield 86	asbl:jdField_a_of_type_Int	I
    //   207: aload_0
    //   208: getfield 40	asbl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   211: invokespecial 219	asbc:<init>	(IILjava/util/ArrayList;)V
    //   214: astore 4
    //   216: aload 4
    //   218: astore_2
    //   219: aload_3
    //   220: ifnull -211 -> 9
    //   223: aload_3
    //   224: invokevirtual 196	java/io/BufferedReader:close	()V
    //   227: aload 4
    //   229: areturn
    //   230: astore_2
    //   231: ldc 70
    //   233: aload_2
    //   234: invokevirtual 220	java/io/IOException:toString	()Ljava/lang/String;
    //   237: invokestatic 79	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   240: pop
    //   241: aload 4
    //   243: areturn
    //   244: astore_2
    //   245: ldc 70
    //   247: aload_2
    //   248: invokevirtual 220	java/io/IOException:toString	()Ljava/lang/String;
    //   251: invokestatic 79	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   254: pop
    //   255: goto -174 -> 81
    //   258: astore_3
    //   259: ldc 70
    //   261: aload_3
    //   262: invokevirtual 220	java/io/IOException:toString	()Ljava/lang/String;
    //   265: invokestatic 79	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   268: pop
    //   269: goto -73 -> 196
    //   272: astore_2
    //   273: aconst_null
    //   274: astore_3
    //   275: goto -87 -> 188
    //   278: astore 4
    //   280: aload_2
    //   281: astore_3
    //   282: aload 4
    //   284: astore_2
    //   285: goto -97 -> 188
    //   288: astore_3
    //   289: aconst_null
    //   290: astore_2
    //   291: goto -228 -> 63
    //   294: iload_1
    //   295: iconst_1
    //   296: iadd
    //   297: istore_1
    //   298: goto -203 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	asbl
    //   94	204	1	i	int
    //   8	70	2	localObject1	Object
    //   187	10	2	localObject2	Object
    //   218	1	2	localObject3	Object
    //   230	4	2	localIOException1	java.io.IOException
    //   244	4	2	localIOException2	java.io.IOException
    //   272	9	2	localObject4	Object
    //   284	7	2	localObject5	Object
    //   35	189	3	localObject6	Object
    //   258	4	3	localIOException3	java.io.IOException
    //   274	8	3	localObject7	Object
    //   288	1	3	localException1	Exception
    //   56	5	4	localException2	Exception
    //   214	28	4	localasbc	asbc
    //   278	5	4	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   36	41	56	java/lang/Exception
    //   45	53	56	java/lang/Exception
    //   83	93	56	java/lang/Exception
    //   95	164	56	java/lang/Exception
    //   167	184	56	java/lang/Exception
    //   198	216	56	java/lang/Exception
    //   36	41	187	finally
    //   45	53	187	finally
    //   83	93	187	finally
    //   95	164	187	finally
    //   167	184	187	finally
    //   198	216	187	finally
    //   223	227	230	java/io/IOException
    //   77	81	244	java/io/IOException
    //   192	196	258	java/io/IOException
    //   20	36	272	finally
    //   63	73	278	finally
    //   20	36	288	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asbl
 * JD-Core Version:    0.7.0.1
 */