import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class azev
{
  private azfg jdField_a_of_type_Azfg = (azfg)azeu.a().getManager(387);
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  
  public azev()
  {
    a();
  }
  
  private azfk a(azfq paramazfq)
  {
    if ((paramazfq != null) && (!TextUtils.isEmpty(paramazfq.d)) && (this.jdField_a_of_type_JavaUtilHashMap != null))
    {
      if (("NO_MATCH".equals(paramazfq.d)) && (paramazfq.jdField_a_of_type_Boolean))
      {
        azgl.d();
        return azgj.a(BaseApplicationImpl.getContext().getString(2131719581), true);
      }
      if (TextUtils.isEmpty(paramazfq.e)) {
        break label475;
      }
      if (!"跳转页面".equals(paramazfq.d)) {
        break label192;
      }
      if (("NO_MATCH".equals(paramazfq.e)) || ("不支持此功能".equals(paramazfq.e)))
      {
        azgl.c();
        return azgj.a(BaseApplicationImpl.getContext().getString(2131719580), true);
      }
      azfl localazfl = a(paramazfq.c);
      if (localazfl != null) {
        return new azfk(localazfl.jdField_a_of_type_Int, localazfl.jdField_a_of_type_JavaLangString, new azfo(localazfl.jdField_b_of_type_Int));
      }
      azeu.a("CommandDistributorHelper", "buildCommandInfo JumpSkill content = " + paramazfq.c);
    }
    for (;;)
    {
      return null;
      try
      {
        label192:
        int i = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramazfq.d + paramazfq.e)).intValue();
        j = i;
        if (i <= 0) {}
      }
      catch (Exception localException)
      {
        for (;;)
        {
          azeu.a("CommandDistributorHelper", "buildCommandInfo getIntentType exception = " + localException.getMessage());
          int j = 0;
        }
        azgl.b();
        return a(paramazfq.e, paramazfq.c);
      }
      switch (j)
      {
      default: 
        azeu.a("CommandDistributorHelper", "buildCommandInfo skill = " + paramazfq.d + ", intent = " + paramazfq.e);
        break;
      case 1: 
      case 2: 
        return a(paramazfq.jdField_a_of_type_JavaUtilList, paramazfq.b, false);
      case 3: 
        return a(paramazfq.jdField_a_of_type_JavaUtilList);
      case 4: 
        return a(paramazfq.jdField_a_of_type_JavaUtilList, paramazfq.b, false);
      case 5: 
        return a(paramazfq.jdField_a_of_type_JavaUtilList, paramazfq.b, true);
      case 6: 
        return a(true);
      case 7: 
        return a(false);
      case 8: 
        return a(paramazfq.c);
      case 9: 
        return a(paramazfq.jdField_a_of_type_Azfr);
      case 10: 
        return a(paramazfq.c);
        label475:
        azeu.a("CommandDistributorHelper", "buildCommandInfo skill = " + paramazfq.d);
      }
    }
  }
  
  private azfk a(azfr paramazfr)
  {
    return azgj.a(paramazfr);
  }
  
  private azfk a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return new azfk(paramString.jdField_a_of_type_Int, paramString.jdField_a_of_type_JavaLangString);
    }
    return null;
  }
  
  private azfk a(String paramString1, String paramString2)
  {
    paramString2 = a(paramString2);
    if (paramString2 != null) {
      paramString2.jdField_b_of_type_JavaLangString = paramString1;
    }
    return paramString2;
  }
  
  private azfk a(List<azfs> paramList)
  {
    Object localObject;
    if ((paramList != null) && (!paramList.isEmpty()) && (this.jdField_a_of_type_Azfg != null))
    {
      Iterator localIterator = paramList.iterator();
      do
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (azfs)localIterator.next();
        } while ((TextUtils.isEmpty(((azfs)localObject).jdField_a_of_type_JavaLangString)) || (!((azfs)localObject).jdField_a_of_type_JavaLangString.equals("num")));
        paramList = this.jdField_a_of_type_Azfg.a();
      } while ((TextUtils.isEmpty(((azfs)localObject).c)) || (paramList == null) || (paramList.isEmpty()));
    }
    for (;;)
    {
      int j;
      int i;
      try
      {
        j = Integer.parseInt(((azfs)localObject).c);
        i = 0;
        localObject = paramList.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label283;
        }
        if (((azfv)((Iterator)localObject).next()).a == null) {
          break label280;
        }
        i += 1;
      }
      catch (Exception paramList)
      {
        azeu.a("CommandDistributorHelper", "buildCommandInfo exception = " + paramList.getMessage());
      }
      return azgj.a();
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        localObject = (azfv)paramList.next();
        if ((((azfv)localObject).a == null) || (j != ((azfv)localObject).a.jdField_b_of_type_Int)) {
          continue;
        }
        paramList = ((azfv)localObject).a;
        if (paramList != null)
        {
          azgl.c(2);
          return azgj.a(paramList, paramList.jdField_a_of_type_Boolean);
        }
        azeu.a("CommandDistributorHelper", "buildCommandInfo not find friendItemInfo");
        break;
        break;
        return null;
      }
      paramList = null;
      continue;
      label280:
      continue;
      label283:
      if (j > 0) {
        if (j <= i) {}
      }
    }
  }
  
  private azfk a(List<azfs> paramList, List<azft> paramList1, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramList = (azfs)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(paramList.jdField_a_of_type_JavaLangString)) && (paramList.jdField_a_of_type_JavaLangString.equals("voiceCallObject")) && (!TextUtils.isEmpty(paramList.c)) && (paramList1 != null) && (!paramList1.isEmpty()))
        {
          localObject = new ArrayList();
          paramList1 = paramList1.iterator();
          while (paramList1.hasNext())
          {
            azft localazft = (azft)paramList1.next();
            azfm localazfm = new azfm();
            localazfm.jdField_a_of_type_JavaLangString = String.valueOf(localazft.jdField_a_of_type_Long);
            localazfm.jdField_b_of_type_JavaLangString = localazft.jdField_a_of_type_JavaLangString;
            localazfm.jdField_a_of_type_Int = localazft.jdField_a_of_type_Int;
            localazfm.jdField_a_of_type_Boolean = paramBoolean;
            localazfm.jdField_a_of_type_Float = localazft.jdField_a_of_type_Float;
            ((List)localObject).add(localazfm);
          }
          return azgj.a(paramList.jdField_b_of_type_JavaLangString, (List)localObject);
        }
      }
    }
    return azgj.a(BaseApplicationImpl.getContext().getString(2131719578));
  }
  
  private azfk a(boolean paramBoolean)
  {
    return azgj.a(paramBoolean);
  }
  
  /* Error */
  private azfl a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +99 -> 103
    //   7: aload_1
    //   8: invokestatic 286	com/tencent/mobileqq/mini/util/JSONUtil:isJson	(Ljava/lang/String;)Z
    //   11: ifeq +92 -> 103
    //   14: new 288	org/json/JSONObject
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 291	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   22: astore_2
    //   23: new 100	azfl
    //   26: dup
    //   27: invokespecial 292	azfl:<init>	()V
    //   30: astore_1
    //   31: aload_1
    //   32: aload_2
    //   33: ldc_w 294
    //   36: invokevirtual 297	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   39: putfield 103	azfl:jdField_a_of_type_Int	I
    //   42: aload_1
    //   43: aload_2
    //   44: ldc_w 299
    //   47: invokevirtual 297	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   50: putfield 110	azfl:jdField_b_of_type_Int	I
    //   53: aload_1
    //   54: aload_2
    //   55: ldc_w 301
    //   58: invokevirtual 304	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: putfield 105	azfl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   64: aload_1
    //   65: areturn
    //   66: astore_2
    //   67: aconst_null
    //   68: astore_1
    //   69: ldc 118
    //   71: new 120	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   78: ldc_w 306
    //   81: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_2
    //   85: invokevirtual 307	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   88: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 134	azeu:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload_1
    //   98: areturn
    //   99: astore_2
    //   100: goto -31 -> 69
    //   103: aconst_null
    //   104: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	azev
    //   0	105	1	paramString	String
    //   22	33	2	localJSONObject	org.json.JSONObject
    //   66	19	2	localJSONException1	org.json.JSONException
    //   99	1	2	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   14	31	66	org/json/JSONException
    //   31	64	99	org/json/JSONException
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put("发消息发消息", Integer.valueOf(1));
    this.jdField_a_of_type_JavaUtilHashMap.put("发消息发给谁", Integer.valueOf(2));
    this.jdField_a_of_type_JavaUtilHashMap.put("发消息选择第几个", Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilHashMap.put("发消息发消息给某人", Integer.valueOf(4));
    this.jdField_a_of_type_JavaUtilHashMap.put("发消息找某人", Integer.valueOf(5));
    this.jdField_a_of_type_JavaUtilHashMap.put("发消息是的", Integer.valueOf(6));
    this.jdField_a_of_type_JavaUtilHashMap.put("发消息不是", Integer.valueOf(7));
    this.jdField_a_of_type_JavaUtilHashMap.put("结束指令结束会话", Integer.valueOf(8));
    this.jdField_a_of_type_JavaUtilHashMap.put("语音消息确定发送", Integer.valueOf(9));
    this.jdField_a_of_type_JavaUtilHashMap.put("语音消息取消发送", Integer.valueOf(10));
  }
  
  public void a(azfq paramazfq)
  {
    paramazfq = a(paramazfq);
    if (this.jdField_a_of_type_Azfg != null) {
      this.jdField_a_of_type_Azfg.a(paramazfq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azev
 * JD-Core Version:    0.7.0.1
 */