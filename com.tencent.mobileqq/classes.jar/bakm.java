import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class bakm
{
  private bakx jdField_a_of_type_Bakx = (bakx)bakl.a().getManager(QQManagerFactory.VOICE_ASSISTANT_MANAGER);
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  
  public bakm()
  {
    a();
  }
  
  private balb a(balh parambalh)
  {
    balc localbalc;
    if ((parambalh != null) && (!TextUtils.isEmpty(parambalh.d)) && (this.jdField_a_of_type_JavaUtilHashMap != null))
    {
      if (("NO_MATCH".equals(parambalh.d)) && (parambalh.jdField_a_of_type_Boolean))
      {
        bamt.a(parambalh.jdField_b_of_type_JavaLangString);
        return bamr.a(BaseApplicationImpl.getContext().getString(2131720034), true);
      }
      if (TextUtils.isEmpty(parambalh.e)) {
        break label683;
      }
      if (!"跳转页面".equals(parambalh.d)) {
        break label205;
      }
      if (("NO_MATCH".equals(parambalh.e)) || ("不支持此功能".equals(parambalh.e)))
      {
        bamt.b();
        return bamr.a(BaseApplicationImpl.getContext().getString(2131720033), true);
      }
      localbalc = a(parambalh.c);
      if (localbalc != null)
      {
        bamt.a(16, parambalh.jdField_b_of_type_JavaLangString);
        return new balb(localbalc.jdField_a_of_type_Int, localbalc.jdField_a_of_type_JavaLangString, new balf(localbalc.jdField_b_of_type_Int));
      }
      bakl.a("CommandDistributorHelper", "buildCommandInfo JumpSkill content = " + parambalh.c);
    }
    label683:
    for (;;)
    {
      return null;
      label205:
      if ("智能应答".equals(parambalh.d))
      {
        localbalc = a(parambalh.c);
        if (localbalc != null)
        {
          a(parambalh.e, parambalh.jdField_b_of_type_JavaLangString);
          return new balb(localbalc.jdField_a_of_type_Int, localbalc.jdField_a_of_type_JavaLangString);
        }
        bakl.a("CommandDistributorHelper", "buildCommandInfo smartAnswerSkill content = " + parambalh.c);
      }
      else
      {
        try
        {
          int i = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(parambalh.d + parambalh.e)).intValue();
          j = i;
          if (i <= 0) {}
        }
        catch (Exception localException)
        {
          for (;;)
          {
            bakl.a("CommandDistributorHelper", "buildCommandInfo getIntentType exception = " + localException.getMessage());
            int j = 0;
          }
          bamt.a(14, parambalh.jdField_b_of_type_JavaLangString);
          return a(parambalh.e, parambalh.c);
        }
        switch (j)
        {
        default: 
          bakl.a("CommandDistributorHelper", "buildCommandInfo skill = " + parambalh.d + ", intent = " + parambalh.e);
          break;
        case 1: 
        case 2: 
          bamt.a(13, parambalh.jdField_b_of_type_JavaLangString);
          return a(parambalh.jdField_a_of_type_JavaUtilList, parambalh.jdField_b_of_type_JavaUtilList, false);
        case 3: 
          bamt.a(11, parambalh.jdField_b_of_type_JavaLangString);
          return a(parambalh.jdField_a_of_type_JavaUtilList);
        case 4: 
          bamt.a(12, parambalh.jdField_b_of_type_JavaLangString);
          return a(parambalh.jdField_a_of_type_JavaUtilList, parambalh.jdField_b_of_type_JavaUtilList, false);
        case 5: 
          bamt.a(8, parambalh.jdField_b_of_type_JavaLangString);
          return a(parambalh.jdField_a_of_type_JavaUtilList, parambalh.jdField_b_of_type_JavaUtilList, true);
        case 6: 
          bamt.a(10, parambalh.jdField_b_of_type_JavaLangString);
          return a(true);
        case 7: 
          bamt.a(9, parambalh.jdField_b_of_type_JavaLangString);
          return a(false);
        case 8: 
          bamt.a(15, parambalh.jdField_b_of_type_JavaLangString);
          return a(parambalh.c);
        case 9: 
          bamt.a(5, parambalh.jdField_b_of_type_JavaLangString);
          return a(parambalh.jdField_a_of_type_Bali);
        case 10: 
          bamt.a(6, parambalh.jdField_b_of_type_JavaLangString);
          return a(parambalh.c);
        case 11: 
          bamt.a(17, parambalh.jdField_b_of_type_JavaLangString);
          return a(parambalh.c);
          bakl.a("CommandDistributorHelper", "buildCommandInfo skill = " + parambalh.d);
        }
      }
    }
  }
  
  private balb a(bali parambali)
  {
    return bamr.a(parambali);
  }
  
  private balb a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return new balb(paramString.jdField_a_of_type_Int, paramString.jdField_a_of_type_JavaLangString);
    }
    return null;
  }
  
  private balb a(String paramString1, String paramString2)
  {
    paramString2 = a(paramString2);
    if (paramString2 != null) {
      paramString2.jdField_b_of_type_JavaLangString = paramString1;
    }
    return paramString2;
  }
  
  private balb a(List<balj> paramList)
  {
    Object localObject;
    if ((paramList != null) && (!paramList.isEmpty()) && (this.jdField_a_of_type_Bakx != null))
    {
      Iterator localIterator = paramList.iterator();
      do
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (balj)localIterator.next();
        } while ((TextUtils.isEmpty(((balj)localObject).jdField_a_of_type_JavaLangString)) || (!((balj)localObject).jdField_a_of_type_JavaLangString.equals("num")));
        paramList = this.jdField_a_of_type_Bakx.a();
      } while ((TextUtils.isEmpty(((balj)localObject).c)) || (paramList == null) || (paramList.isEmpty()));
    }
    for (;;)
    {
      int j;
      int i;
      try
      {
        j = Integer.parseInt(((balj)localObject).c);
        i = 0;
        localObject = paramList.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label283;
        }
        if (((balm)((Iterator)localObject).next()).a == null) {
          break label280;
        }
        i += 1;
      }
      catch (Exception paramList)
      {
        bakl.a("CommandDistributorHelper", "buildCommandInfo exception = " + paramList.getMessage());
      }
      return bamr.a();
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        localObject = (balm)paramList.next();
        if ((((balm)localObject).a == null) || (j != ((balm)localObject).a.jdField_b_of_type_Int)) {
          continue;
        }
        paramList = ((balm)localObject).a;
        if (paramList != null)
        {
          bamt.c(2);
          return bamr.a(paramList, paramList.jdField_a_of_type_Boolean);
        }
        bakl.a("CommandDistributorHelper", "buildCommandInfo not find friendItemInfo");
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
  
  private balb a(List<balj> paramList, List<balk> paramList1, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramList = (balj)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(paramList.jdField_a_of_type_JavaLangString)) && (paramList.jdField_a_of_type_JavaLangString.equals("voiceCallObject")) && (!TextUtils.isEmpty(paramList.c)) && (paramList1 != null) && (!paramList1.isEmpty()))
        {
          localObject = new ArrayList();
          paramList1 = paramList1.iterator();
          while (paramList1.hasNext())
          {
            balk localbalk = (balk)paramList1.next();
            bald localbald = new bald();
            localbald.jdField_a_of_type_JavaLangString = String.valueOf(localbalk.jdField_a_of_type_Long);
            localbald.jdField_b_of_type_JavaLangString = localbalk.jdField_a_of_type_JavaLangString;
            localbald.jdField_a_of_type_Int = localbalk.jdField_a_of_type_Int;
            localbald.jdField_a_of_type_Boolean = paramBoolean;
            localbald.jdField_a_of_type_Float = localbalk.jdField_a_of_type_Float;
            ((List)localObject).add(localbald);
          }
          return bamr.a(paramList.jdField_b_of_type_JavaLangString, (List)localObject);
        }
      }
    }
    return bamr.a(BaseApplicationImpl.getContext().getString(2131720031));
  }
  
  private balb a(boolean paramBoolean)
  {
    return bamr.a(paramBoolean);
  }
  
  /* Error */
  private balc a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +99 -> 103
    //   7: aload_1
    //   8: invokestatic 298	com/tencent/mobileqq/mini/util/JSONUtil:isJson	(Ljava/lang/String;)Z
    //   11: ifeq +92 -> 103
    //   14: new 300	org/json/JSONObject
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 302	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   22: astore_2
    //   23: new 113	balc
    //   26: dup
    //   27: invokespecial 303	balc:<init>	()V
    //   30: astore_1
    //   31: aload_1
    //   32: aload_2
    //   33: ldc_w 305
    //   36: invokevirtual 308	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   39: putfield 115	balc:jdField_a_of_type_Int	I
    //   42: aload_1
    //   43: aload_2
    //   44: ldc_w 310
    //   47: invokevirtual 308	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   50: putfield 121	balc:jdField_b_of_type_Int	I
    //   53: aload_1
    //   54: aload_2
    //   55: ldc_w 312
    //   58: invokevirtual 315	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: putfield 117	balc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   64: aload_1
    //   65: areturn
    //   66: astore_2
    //   67: aconst_null
    //   68: astore_1
    //   69: ldc 129
    //   71: new 131	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   78: ldc_w 317
    //   81: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_2
    //   85: invokevirtual 318	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   88: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 145	bakl:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload_1
    //   98: areturn
    //   99: astore_2
    //   100: goto -31 -> 69
    //   103: aconst_null
    //   104: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	bakm
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
    this.jdField_a_of_type_JavaUtilHashMap.put("发消息返回", Integer.valueOf(11));
    this.jdField_a_of_type_JavaUtilHashMap.put("结束指令结束会话", Integer.valueOf(8));
    this.jdField_a_of_type_JavaUtilHashMap.put("语音消息确定发送", Integer.valueOf(9));
    this.jdField_a_of_type_JavaUtilHashMap.put("语音消息取消发送", Integer.valueOf(10));
  }
  
  private void a(String paramString1, String paramString2)
  {
    String str;
    int i;
    if (!TextUtils.isEmpty(paramString1))
    {
      str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = "";
      }
      i = 0;
      if (!"功能".equals(paramString1)) {
        break label43;
      }
      i = 1;
    }
    for (;;)
    {
      bamt.a(i, str);
      return;
      label43:
      if ("脏话".equals(paramString1)) {
        i = 2;
      } else if ("你是谁".equals(paramString1)) {
        i = 3;
      } else if ("在干嘛".equals(paramString1)) {
        i = 4;
      }
    }
  }
  
  public void a(balh parambalh)
  {
    parambalh = a(parambalh);
    if (this.jdField_a_of_type_Bakx != null) {
      this.jdField_a_of_type_Bakx.a(parambalh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bakm
 * JD-Core Version:    0.7.0.1
 */