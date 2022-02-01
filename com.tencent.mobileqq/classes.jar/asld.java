import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo.QQEmoConfigItem;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class asld
  extends QQSysAndEmojiResInfo
  implements aslc
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
    int i = asle.a(paramInt);
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
    Object localObject1 = a();
    if (localObject1 != null)
    {
      JSONArray localJSONArray = ((JSONObject)localObject1).optJSONArray("sysface");
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
        if (this.c == null) {
          this.c = new HashMap();
        }
        if (this.d == null) {
          this.d = new HashMap();
        }
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_b_of_type_JavaUtilHashMap.clear();
        this.c.clear();
        this.d.clear();
        long l = System.currentTimeMillis();
        int i = 0;
        QQSysAndEmojiResInfo.QQEmoConfigItem localQQEmoConfigItem;
        for (;;)
        {
          if (i >= localJSONArray.length()) {
            break label437;
          }
          localObject1 = null;
          try
          {
            localObject2 = localJSONArray.getJSONObject(i);
            localObject1 = localObject2;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              Object localObject2;
              localJSONException.printStackTrace();
            }
          }
          localQQEmoConfigItem = (QQSysAndEmojiResInfo.QQEmoConfigItem)awfy.a((JSONObject)localObject1, QQSysAndEmojiResInfo.QQEmoConfigItem.class);
          try
          {
            int j = Integer.parseInt(localQQEmoConfigItem.AQLid);
            int k = Integer.parseInt(localQQEmoConfigItem.QSid);
            if (!TextUtils.isEmpty(localQQEmoConfigItem.EMCode))
            {
              String str = "[em]e" + localQQEmoConfigItem.EMCode + "[/em]";
              localObject2 = localQQEmoConfigItem.QDes;
              localObject1 = localObject2;
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject1 = localObject2;
                if (((String)localObject2).equals("/吃瓜")) {
                  localObject1 = "/chigua";
                }
              }
              this.c.put(localObject1, str);
              this.d.put(str, Integer.valueOf(j));
            }
            this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(j), localQQEmoConfigItem);
            this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(k), Integer.valueOf(j));
            if (!a(localQQEmoConfigItem)) {
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
              QLog.d("QQSysFaceResInfo", 1, new Object[] { "error occur in sysface AQLid:", localQQEmoConfigItem.AQLid });
            }
          }
          i += 1;
        }
        label437:
        if (QLog.isColorLevel()) {
          QLog.d("QQSysFaceResInfo", 2, new Object[] { "sysface configItem:", Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()), ", orderlist:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), ", maxLid:", Integer.valueOf(this.jdField_a_of_type_Int), ", maxSid:", Integer.valueOf(this.jdField_b_of_type_Int), ", costTime = [", Long.valueOf(System.currentTimeMillis() - l), "]" });
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
    bdll.b(null, "dc00898", "", "", "0X800A7A2", "0X800A7A2", paramInt1, 0, String.valueOf(paramInt2), "", "", "");
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    String str = asky.a(2, String.format("/s%d.png", new Object[] { Integer.valueOf(paramInt) }));
    if (!TextUtils.isEmpty(str)) {
      bool = new File(str).exists();
    }
    return bool;
  }
  
  /* Error */
  public Drawable b(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iload_1
    //   4: invokestatic 54	asle:a	(I)I
    //   7: istore_2
    //   8: new 56	java/net/URL
    //   11: dup
    //   12: ldc 58
    //   14: ldc_w 269
    //   17: ldc_w 271
    //   20: iconst_1
    //   21: anewarray 64	java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: iload_2
    //   27: invokestatic 27	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: aastore
    //   31: invokestatic 70	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   34: invokespecial 73	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   37: astore_3
    //   38: aload_3
    //   39: astore 4
    //   41: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +35 -> 79
    //   47: ldc 81
    //   49: iconst_2
    //   50: new 83	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   57: ldc_w 273
    //   60: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_3
    //   64: invokevirtual 94	java/net/URL:toString	()Ljava/lang/String;
    //   67: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_3
    //   77: astore 4
    //   79: aload 6
    //   81: astore_3
    //   82: iload_1
    //   83: getstatic 276	begd:jdField_a_of_type_Int	I
    //   86: if_icmpge +8 -> 94
    //   89: iload_1
    //   90: invokestatic 277	asle:a	(I)Landroid/graphics/drawable/Drawable;
    //   93: astore_3
    //   94: aload_0
    //   95: aload 4
    //   97: aload_3
    //   98: iconst_1
    //   99: iload_1
    //   100: invokestatic 279	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   103: invokevirtual 105	asld:a	(Ljava/net/URL;Landroid/graphics/drawable/Drawable;ZLjava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   106: areturn
    //   107: astore 5
    //   109: aconst_null
    //   110: astore_3
    //   111: aload_3
    //   112: astore 4
    //   114: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq -38 -> 79
    //   120: ldc 81
    //   122: iconst_2
    //   123: ldc_w 281
    //   126: aload 5
    //   128: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   131: aload_3
    //   132: astore 4
    //   134: goto -55 -> 79
    //   137: astore 5
    //   139: goto -28 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	asld
    //   0	142	1	paramInt	int
    //   7	20	2	i	int
    //   37	95	3	localObject1	Object
    //   39	94	4	localObject2	Object
    //   107	20	5	localMalformedURLException1	MalformedURLException
    //   137	1	5	localMalformedURLException2	MalformedURLException
    //   1	79	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   8	38	107	java/net/MalformedURLException
    //   41	76	137	java/net/MalformedURLException
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aslb = new aslb(this);
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
      return "1".equals(((QQSysAndEmojiResInfo.QQEmoConfigItem)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).isStatic);
    }
    return begd.b[paramInt] == begd.jdField_a_of_type_ArrayOfInt[paramInt];
  }
  
  public boolean d(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)))) {
      return "1".equals(((QQSysAndEmojiResInfo.QQEmoConfigItem)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).isCMEmoji);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asld
 * JD-Core Version:    0.7.0.1
 */