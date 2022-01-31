import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class behf
{
  private static final HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public behf(Context paramContext, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  private SharedPreferences a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getSharedPreferences(this.jdField_a_of_type_JavaLangString + "_" + this.b, 4);
  }
  
  public int a(String paramString)
  {
    return a().getInt(paramString, 1);
  }
  
  public List<behi> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = behl.a().a().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Integer localInteger = (Integer)jdField_a_of_type_JavaUtilHashMap.get(str);
      if ((localInteger == null) || (localInteger.intValue() != 1))
      {
        int i = a().getInt(str, 1);
        if (i == 2)
        {
          if ((paramInt & 0x2) == 2) {
            localArrayList.add(new behi(str, 2));
          }
        }
        else if (i == 1)
        {
          if ((paramInt & 0x1) == 1) {
            localArrayList.add(new behi(str, 1));
          }
        }
        else if ((paramInt & 0x4) == 4) {
          localArrayList.add(new behi(str, 4));
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    a().edit().putBoolean("authority_synchronized", true).commit();
  }
  
  public void a(String paramString)
  {
    a().edit().putInt(paramString, 2).commit();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    a(paramString, paramBoolean, new behg(this));
  }
  
  public void a(String paramString, boolean paramBoolean, AsyncResult paramAsyncResult)
  {
    int j = 1;
    int i = 1;
    ChannelProxy localChannelProxy;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramBoolean) {
        break label110;
      }
      a(paramString);
      localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      if (!paramString.startsWith("setting")) {
        break label124;
      }
      paramAsyncResult = new behq();
      paramAsyncResult.jdField_a_of_type_JavaLangString = paramString;
      localObject = behl.a().a(paramString);
      if (localObject != null) {
        paramString = ((behk)localObject).c;
      }
      paramAsyncResult.b = paramString;
      if (!paramBoolean) {
        break label118;
      }
    }
    for (;;)
    {
      paramAsyncResult.jdField_a_of_type_Int = i;
      localChannelProxy.updateUserSetting(this.jdField_a_of_type_JavaLangString, paramAsyncResult, new behh(this));
      return;
      label110:
      b(paramString);
      break;
      label118:
      i = 2;
    }
    label124:
    Object localObject = new beho();
    ((beho)localObject).jdField_a_of_type_JavaLangString = paramString;
    behk localbehk = behl.a().a(paramString);
    if (localbehk != null) {
      paramString = localbehk.c;
    }
    ((beho)localObject).b = paramString;
    if (paramBoolean) {}
    for (i = j;; i = 2)
    {
      ((beho)localObject).jdField_a_of_type_Int = i;
      localChannelProxy.setAuth(this.jdField_a_of_type_JavaLangString, (beho)localObject, paramAsyncResult);
      return;
    }
  }
  
  public void a(List<beho> paramList, List<behq> paramList1)
  {
    int j = 0;
    int i;
    Object localObject;
    if (paramList != null)
    {
      i = 0;
      if (i < paramList.size())
      {
        localObject = (beho)paramList.get(i);
        String str = ((beho)localObject).jdField_a_of_type_JavaLangString;
        int k = ((beho)localObject).jdField_a_of_type_Int;
        if (k == 1) {
          a().edit().putInt(str, 2).commit();
        }
        for (;;)
        {
          i += 1;
          break;
          if (k == 2) {
            a().edit().putInt(str, 4).commit();
          }
        }
      }
    }
    if (paramList1 != null)
    {
      i = j;
      if (i < paramList1.size())
      {
        paramList = (behq)paramList1.get(i);
        localObject = paramList.jdField_a_of_type_JavaLangString;
        j = paramList.jdField_a_of_type_Int;
        if (j == 1) {
          a().edit().putInt((String)localObject, 2).commit();
        }
        for (;;)
        {
          i += 1;
          break;
          if (j == 2) {
            a().edit().putInt((String)localObject, 4).commit();
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return a().getBoolean("authority_synchronized", false);
  }
  
  public boolean a(String paramString)
  {
    return 2 == (a().getInt(paramString, 1) & 0x2);
  }
  
  public void b()
  {
    besl.b("AuthState", "clear all auth ");
    SharedPreferences localSharedPreferences = a();
    Iterator localIterator = behl.a().a().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localSharedPreferences.edit().putInt(str, 1).commit();
    }
    localSharedPreferences.edit().putBoolean("authority_synchronized", true).commit();
  }
  
  public void b(String paramString)
  {
    a().edit().putInt(paramString, 4).commit();
  }
  
  public boolean b(String paramString)
  {
    paramString = (Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    return (paramString != null) && (paramString.intValue() == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     behf
 * JD-Core Version:    0.7.0.1
 */