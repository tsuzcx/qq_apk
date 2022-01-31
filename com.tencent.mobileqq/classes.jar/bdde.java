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

public class bdde
{
  private static final HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private String jdField_a_of_type_JavaLangString;
  
  public bdde(Context paramContext, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences(paramString1 + "_" + paramString2, 4);
  }
  
  public List<bddh> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = bddk.a().a().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Integer localInteger = (Integer)jdField_a_of_type_JavaUtilHashMap.get(str);
      if ((localInteger == null) || (localInteger.intValue() != 1))
      {
        int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(str, 1);
        if (i == 2)
        {
          if ((paramInt & 0x2) == 2) {
            localArrayList.add(new bddh(str, 2));
          }
        }
        else if (i == 1)
        {
          if ((paramInt & 0x1) == 1) {
            localArrayList.add(new bddh(str, 1));
          }
        }
        else if ((paramInt & 0x4) == 4) {
          localArrayList.add(new bddh(str, 4));
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("authority_synchronized", true).commit();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    a(paramString, paramBoolean, new bddf(this));
  }
  
  public void a(String paramString, boolean paramBoolean, AsyncResult paramAsyncResult)
  {
    int j = 1;
    int k = 2;
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramBoolean) {
        break label138;
      }
    }
    ChannelProxy localChannelProxy;
    label138:
    for (int i = 2;; i = 4)
    {
      localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(paramString, i).commit();
      if (!paramString.startsWith("setting")) {
        break;
      }
      paramAsyncResult = new bddp();
      paramAsyncResult.jdField_a_of_type_JavaLangString = paramString;
      localObject = bddk.a().a(paramString);
      if (localObject != null) {
        paramString = ((bddj)localObject).c;
      }
      paramAsyncResult.b = paramString;
      i = k;
      if (paramBoolean) {
        i = 1;
      }
      paramAsyncResult.jdField_a_of_type_Int = i;
      localChannelProxy.updateUserSetting(this.jdField_a_of_type_JavaLangString, paramAsyncResult, new bddg(this));
      return;
    }
    Object localObject = new bddn();
    ((bddn)localObject).jdField_a_of_type_JavaLangString = paramString;
    bddj localbddj = bddk.a().a(paramString);
    if (localbddj != null) {
      paramString = localbddj.c;
    }
    ((bddn)localObject).b = paramString;
    if (paramBoolean) {}
    for (i = j;; i = 2)
    {
      ((bddn)localObject).jdField_a_of_type_Int = i;
      localChannelProxy.setAuth(this.jdField_a_of_type_JavaLangString, (bddn)localObject, paramAsyncResult);
      return;
    }
  }
  
  public void a(List<bddn> paramList, List<bddp> paramList1)
  {
    int j = 0;
    int i;
    Object localObject;
    if (paramList != null)
    {
      i = 0;
      if (i < paramList.size())
      {
        localObject = (bddn)paramList.get(i);
        String str = ((bddn)localObject).jdField_a_of_type_JavaLangString;
        int k = ((bddn)localObject).jdField_a_of_type_Int;
        if (k == 1) {
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(str, 2).commit();
        }
        for (;;)
        {
          i += 1;
          break;
          if (k == 2) {
            this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(str, 4).commit();
          }
        }
      }
    }
    if (paramList1 != null)
    {
      i = j;
      if (i < paramList1.size())
      {
        paramList = (bddp)paramList1.get(i);
        localObject = paramList.jdField_a_of_type_JavaLangString;
        j = paramList.jdField_a_of_type_Int;
        if (j == 1) {
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt((String)localObject, 2).commit();
        }
        for (;;)
        {
          i += 1;
          break;
          if (j == 2) {
            this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt((String)localObject, 4).commit();
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("authority_synchronized", false);
  }
  
  public boolean a(String paramString)
  {
    return 2 == (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramString, 1) & 0x2);
  }
  
  public boolean b(String paramString)
  {
    paramString = (Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    return (paramString != null) && (paramString.intValue() == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdde
 * JD-Core Version:    0.7.0.1
 */