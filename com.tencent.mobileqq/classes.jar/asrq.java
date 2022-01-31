import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class asrq
{
  public QQAppInterface a;
  private String jdField_a_of_type_JavaLangString;
  private List<asrl> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, asrk> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Map<String, String> b = new HashMap();
  
  public asrq(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static asrq a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardContext", 2, "create() called with: app = [" + paramQQAppInterface + "]");
    }
    return new asrq(paramQQAppInterface, paramString);
  }
  
  public int a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        return 0;
      }
      int i = this.jdField_a_of_type_JavaUtilList.size();
      return i;
    }
    finally {}
  }
  
  public asrk a(int paramInt)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilMap == null) || (paramInt < 0) || (this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
        return null;
      }
      asrl localasrl = (asrl)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localasrl != null)
      {
        asrk localasrk = (asrk)this.jdField_a_of_type_JavaUtilMap.get(localasrl.a());
        if ((localasrk != null) && (TextUtils.isEmpty(localasrk.b()))) {
          localasrk.a((String)this.b.get(localasrl.a()));
        }
        return localasrk;
      }
    }
    finally {}
    return null;
  }
  
  public asrl a(int paramInt)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilList.size())) {
        return null;
      }
      asrl localasrl = (asrl)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      return localasrl;
    }
    finally {}
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = (String)this.b.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  public ArrayList<Long> a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	asrq:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 28	asrq:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   13: invokeinterface 74 1 0
    //   18: iload_1
    //   19: if_icmple +11 -> 30
    //   22: iload_1
    //   23: iflt +7 -> 30
    //   26: iload_2
    //   27: ifgt +7 -> 34
    //   30: aload_0
    //   31: monitorexit
    //   32: aconst_null
    //   33: areturn
    //   34: iload_2
    //   35: istore_3
    //   36: iload_1
    //   37: iload_2
    //   38: iadd
    //   39: aload_0
    //   40: getfield 28	asrq:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   43: invokeinterface 74 1 0
    //   48: if_icmple +15 -> 63
    //   51: aload_0
    //   52: getfield 28	asrq:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   55: invokeinterface 74 1 0
    //   60: iload_1
    //   61: isub
    //   62: istore_3
    //   63: new 25	java/util/ArrayList
    //   66: dup
    //   67: invokespecial 26	java/util/ArrayList:<init>	()V
    //   70: astore 4
    //   72: iload_1
    //   73: istore_2
    //   74: iload_2
    //   75: iload_1
    //   76: iload_3
    //   77: iadd
    //   78: if_icmpge +45 -> 123
    //   81: aload_0
    //   82: getfield 28	asrq:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   85: iload_2
    //   86: invokeinterface 79 2 0
    //   91: checkcast 81	asrl
    //   94: invokevirtual 83	asrl:a	()Ljava/lang/String;
    //   97: astore 5
    //   99: aload 4
    //   101: aload 5
    //   103: invokestatic 114	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   106: invokevirtual 118	java/lang/Long:longValue	()J
    //   109: invokestatic 121	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   112: invokevirtual 125	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   115: pop
    //   116: iload_2
    //   117: iconst_1
    //   118: iadd
    //   119: istore_2
    //   120: goto -46 -> 74
    //   123: aload_0
    //   124: monitorexit
    //   125: aload 4
    //   127: areturn
    //   128: astore 4
    //   130: aload_0
    //   131: monitorexit
    //   132: aload 4
    //   134: athrow
    //   135: astore 5
    //   137: goto -21 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	asrq
    //   0	140	1	paramInt1	int
    //   0	140	2	paramInt2	int
    //   35	43	3	i	int
    //   70	56	4	localArrayList	ArrayList
    //   128	5	4	localObject	Object
    //   97	5	5	str	String
    //   135	1	5	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	22	128	finally
    //   30	32	128	finally
    //   36	63	128	finally
    //   63	72	128	finally
    //   81	99	128	finally
    //   99	116	128	finally
    //   123	125	128	finally
    //   130	132	128	finally
    //   99	116	135	java/lang/Exception
  }
  
  public List<asrl> a(List<Long> paramList)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = String.valueOf((Long)paramList.next());
        localArrayList.add(new asrl(str, bbcz.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, str)));
      }
      return localArrayList;
    }
    return null;
  }
  
  public Map<String, asrk> a(Map<Long, IntimateInfo> paramMap)
  {
    if (paramMap != null)
    {
      HashMap localHashMap = new HashMap();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localHashMap.put(String.valueOf(localEntry.getKey()), new asrk((IntimateInfo)localEntry.getValue()));
      }
      return localHashMap;
    }
    return null;
  }
  
  public void a(List<asrl> paramList, Map<String, asrk> paramMap, Map<String, String> paramMap1)
  {
    if (paramList != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      if (paramMap != null) {
        this.jdField_a_of_type_JavaUtilMap.putAll(paramMap);
      }
      if (paramMap1 != null) {
        this.b.putAll(paramMap1);
      }
      return;
    }
    finally {}
  }
  
  public Map<String, String> b(Map<Long, String> paramMap)
  {
    if (paramMap != null)
    {
      HashMap localHashMap = new HashMap();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localHashMap.put(String.valueOf(localEntry.getKey()), localEntry.getValue());
      }
      return localHashMap;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asrq
 * JD-Core Version:    0.7.0.1
 */