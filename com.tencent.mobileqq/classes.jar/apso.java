import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo.QQEmoConfigItem;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class apso
  extends QQSysAndEmojiResInfo
  implements apsn
{
  private int a;
  private int b;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    int j = -1;
    int i = j;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      i = j;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        i = Integer.parseInt(((QQSysAndEmojiResInfo.QQEmoConfigItem)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).QSid);
      }
    }
    return i;
  }
  
  public Drawable a(int paramInt)
  {
    int i = apsp.a(paramInt);
    for (;;)
    {
      try
      {
        localURL1 = new URL("qqsys_emoji", "host_qqsys_static", String.format("s%d.png", new Object[] { Integer.valueOf(i) }));
        localURL2 = localURL1;
        localURL2 = localURL1;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("QQSysFaceResInfo", 2, "getDrawable url:" + localURL1.toString());
            localURL2 = localURL1;
          }
          return a(localURL2, null, false, String.valueOf(paramInt));
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          URL localURL1;
          URL localURL2;
          break label90;
        }
        localMalformedURLException1 = localMalformedURLException1;
        localURL1 = null;
      }
      label90:
      if (QLog.isColorLevel())
      {
        QLog.d("QQSysFaceResInfo", 2, "getDrawable ,", localMalformedURLException1);
        localURL2 = localURL1;
      }
    }
  }
  
  public String a(int paramInt)
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        str1 = ((QQSysAndEmojiResInfo.QQEmoConfigItem)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).QDes;
      }
    }
    return str1;
  }
  
  public void a()
  {
    Object localObject = a();
    if (localObject != null)
    {
      JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("sysface");
      if (localJSONArray != null)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        if (this.jdField_b_of_type_JavaUtilHashMap == null) {
          this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
        }
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_b_of_type_JavaUtilHashMap.clear();
        long l = System.currentTimeMillis();
        int i = 0;
        for (;;)
        {
          if (i >= localJSONArray.length()) {
            break label283;
          }
          localObject = null;
          try
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            localObject = localJSONObject;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
          localObject = (QQSysAndEmojiResInfo.QQEmoConfigItem)atgx.a((JSONObject)localObject, QQSysAndEmojiResInfo.QQEmoConfigItem.class);
          try
          {
            int j = Integer.parseInt(((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject).AQLid);
            int k = Integer.parseInt(((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject).QSid);
            this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(j), localObject);
            this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(k), Integer.valueOf(j));
            if (!a((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject)) {
              this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(j));
            }
            if (j > this.jdField_a_of_type_Int) {
              this.jdField_a_of_type_Int = j;
            }
            if (k > this.jdField_b_of_type_Int) {
              this.jdField_b_of_type_Int = k;
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            for (;;)
            {
              QLog.d("QQSysFaceResInfo", 1, new Object[] { "error occur in sysface AQLid:", ((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject).AQLid });
            }
          }
          i += 1;
        }
        label283:
        if (QLog.isColorLevel()) {
          QLog.d("QQSysFaceResInfo", 2, new Object[] { "sysface configItem:", Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()), ", orderlist:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), ", maxLid:", Integer.valueOf(this.jdField_a_of_type_Int), ", maxSid:", Integer.valueOf(this.jdField_b_of_type_Int), ", cost:", Long.valueOf(System.currentTimeMillis() - l) });
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    a(a(paramInt), paramInt);
    a(b(paramInt), paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = a(paramInt1);
    paramInt1 = i;
    if (i == 0) {
      paramInt1 = 1000;
    }
    azqs.b(null, "dc00898", "", "", "0X800A7A2", "0X800A7A2", paramInt1, 0, String.valueOf(paramInt2), "", "", "");
  }
  
  /* Error */
  public Drawable b(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iload_1
    //   4: invokestatic 54	apsp:a	(I)I
    //   7: istore_2
    //   8: new 56	java/net/URL
    //   11: dup
    //   12: ldc 58
    //   14: ldc 226
    //   16: ldc 228
    //   18: iconst_1
    //   19: anewarray 64	java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: iload_2
    //   25: invokestatic 27	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: aastore
    //   29: invokestatic 70	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   32: invokespecial 73	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   35: astore_3
    //   36: aload_3
    //   37: astore 4
    //   39: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +34 -> 76
    //   45: ldc 81
    //   47: iconst_2
    //   48: new 83	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   55: ldc 230
    //   57: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_3
    //   61: invokevirtual 94	java/net/URL:toString	()Ljava/lang/String;
    //   64: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: aload_3
    //   74: astore 4
    //   76: aload 6
    //   78: astore_3
    //   79: iload_1
    //   80: getstatic 233	bamd:jdField_a_of_type_Int	I
    //   83: if_icmpge +8 -> 91
    //   86: iload_1
    //   87: invokestatic 234	apsp:a	(I)Landroid/graphics/drawable/Drawable;
    //   90: astore_3
    //   91: aload_0
    //   92: aload 4
    //   94: aload_3
    //   95: iconst_1
    //   96: iload_1
    //   97: invokestatic 236	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   100: invokevirtual 105	apso:a	(Ljava/net/URL;Landroid/graphics/drawable/Drawable;ZLjava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   103: areturn
    //   104: astore 5
    //   106: aconst_null
    //   107: astore_3
    //   108: aload_3
    //   109: astore 4
    //   111: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq -38 -> 76
    //   117: ldc 81
    //   119: iconst_2
    //   120: ldc 238
    //   122: aload 5
    //   124: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   127: aload_3
    //   128: astore 4
    //   130: goto -54 -> 76
    //   133: astore 5
    //   135: goto -27 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	apso
    //   0	138	1	paramInt	int
    //   7	18	2	i	int
    //   35	93	3	localObject1	Object
    //   37	92	4	localObject2	Object
    //   104	19	5	localMalformedURLException1	MalformedURLException
    //   133	1	5	localMalformedURLException2	MalformedURLException
    //   1	76	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   8	36	104	java/net/MalformedURLException
    //   39	73	133	java/net/MalformedURLException
  }
  
  public void b()
  {
    this.jdField_a_of_type_Apsm = new apsm(this);
  }
  
  public boolean b(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)))) {
      return "1".equals(((QQSysAndEmojiResInfo.QQEmoConfigItem)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).isStatic);
    }
    return bamd.b[paramInt] == bamd.jdField_a_of_type_ArrayOfInt[paramInt];
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if ((localInteger.intValue() >= 260) && (!"-1".equals(((QQSysAndEmojiResInfo.QQEmoConfigItem)this.jdField_a_of_type_JavaUtilHashMap.get(localInteger)).QSid))) {
          ((URLDrawable)a(localInteger.intValue())).downloadImediatly();
        }
      }
    }
  }
  
  public boolean c(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)))) {
      return "1".equals(((QQSysAndEmojiResInfo.QQEmoConfigItem)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).isCMEmoji);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apso
 * JD-Core Version:    0.7.0.1
 */