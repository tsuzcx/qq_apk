import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class amws
  extends ampb<amwq>
{
  public static String a;
  private WeakReference<bhxq> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "{\n    \"switch\":1,\n    \"match\":[\n        {\n            \"key\":\"花木兰\",\n            \"resUrl\":\"https://d3g.qq.com/sngapp/app/update/20191028162616_9505/libai_dae.zip\",\n            \"md5\":\"52b1ab75bbd04aef4eb889cc6b625dad\"\n        },\n        {\n            \"key\":\"miku\",\n            \"resUrl\":\"https://d3g.qq.com/sngapp/app/update/20191029174146_1019/miku_fbx.zip\",\n            \"md5\":\"f957c6847f06e485a021ed81d5b5024a\"\n        },\n        {\n            \"key\":\"莓莓蛋糕\",\n            \"resUrl\":\"https://d3g.qq.com/sngapp/app/update/20191107111004_5856/cake_dae.zip\",\n            \"md5\":\"4fe9009093acbea20a65f281958879eb\"\n        }\n    ],\n    \"blackList\":\"SLA-AL00\"\n}";
  }
  
  private void a(boolean paramBoolean, amwq paramamwq, String paramString1, String paramString2)
  {
    bhyk.a().b(paramamwq);
    if (this.jdField_a_of_type_MqqUtilWeakReference == null)
    {
      QLog.e("VipARConfProcessor", 1, "load config listener = null");
      return;
    }
    bhxq localbhxq = (bhxq)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localbhxq == null)
    {
      QLog.e("VipARConfProcessor", 1, "load config vipARConfigListener = null");
      return;
    }
    if (paramBoolean)
    {
      paramString2 = paramamwq;
      if (paramamwq == null) {
        paramString2 = new amwq();
      }
      QLog.i("VipARConfProcessor", 1, "notifyListener isSuccess : " + paramBoolean + " refer  = " + paramString1 + " data  = " + paramString2.toString());
      localbhxq.a(paramString2);
      return;
    }
    QLog.i("VipARConfProcessor", 1, "notifyListener fail :  refer  = " + paramString1 + " error = " + paramString2);
    localbhxq.a(paramString2);
  }
  
  public int a()
  {
    return 499;
  }
  
  @NonNull
  public amwq a(int paramInt)
  {
    QLog.e("VipARConfProcessor", 1, "migrateOldOrDefaultContent: " + paramInt);
    return new amwq();
  }
  
  @Nullable
  public amwq a(ampi[] paramArrayOfampi)
  {
    if (paramArrayOfampi != null) {
      try
      {
        if (paramArrayOfampi.length > 0)
        {
          int j = paramArrayOfampi.length;
          int i = 0;
          while (i < j)
          {
            ampi localampi = paramArrayOfampi[i];
            if (localampi != null)
            {
              amwq localamwq = amwq.a(localampi.jdField_a_of_type_JavaLangString);
              if (QLog.isColorLevel()) {
                QLog.d("VipARConfProcessor", 2, "onParsed " + localampi.jdField_a_of_type_JavaLangString);
              }
              if (localamwq != null) {
                return localamwq;
              }
            }
            i += 1;
          }
        }
        return new amwq();
      }
      catch (Exception paramArrayOfampi)
      {
        paramArrayOfampi.printStackTrace();
        QLog.e("VipARConfProcessor", 1, "onParsed Exception = " + paramArrayOfampi.getMessage());
      }
    }
  }
  
  public Class<amwq> a()
  {
    return amwq.class;
  }
  
  public void a(int paramInt)
  {
    QLog.e("VipARConfProcessor", 1, "onReqFailed: " + paramInt);
    a(false, null, "onReqFailed", " failCode = " + paramInt);
  }
  
  public void a(amwq paramamwq)
  {
    if ((QLog.isColorLevel()) && (paramamwq != null)) {
      QLog.i("VipARConfProcessor", 2, "onUpdate: " + paramamwq.toString());
    }
    if (paramamwq != null) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, paramamwq, "onUpdate", " error bean = null");
      return;
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amws
 * JD-Core Version:    0.7.0.1
 */