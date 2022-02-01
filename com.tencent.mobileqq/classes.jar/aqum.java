import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class aqum
  extends aqkz<aquk>
{
  public static String a;
  private WeakReference<bmsu> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "{\n    \"switch\":1,\n    \"match\":[\n        {\n            \"key\":\"花木兰\",\n            \"resUrl\":\"https://d3g.qq.com/sngapp/app/update/20191028162616_9505/libai_dae.zip\",\n            \"md5\":\"52b1ab75bbd04aef4eb889cc6b625dad\"\n        },\n        {\n            \"key\":\"miku\",\n            \"resUrl\":\"https://d3g.qq.com/sngapp/app/update/20191029174146_1019/miku_fbx.zip\",\n            \"md5\":\"f957c6847f06e485a021ed81d5b5024a\"\n        },\n        {\n            \"key\":\"莓莓蛋糕\",\n            \"resUrl\":\"https://d3g.qq.com/sngapp/app/update/20191107111004_5856/cake_dae.zip\",\n            \"md5\":\"4fe9009093acbea20a65f281958879eb\"\n        }\n    ],\n    \"blackList\":\"SLA-AL00\"\n}";
  }
  
  private void a(boolean paramBoolean, aquk paramaquk, String paramString1, String paramString2)
  {
    bmto.a().b(paramaquk);
    if (this.jdField_a_of_type_MqqUtilWeakReference == null)
    {
      QLog.e("VipARConfProcessor", 1, "load config listener = null");
      return;
    }
    bmsu localbmsu = (bmsu)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localbmsu == null)
    {
      QLog.e("VipARConfProcessor", 1, "load config vipARConfigListener = null");
      return;
    }
    if (paramBoolean)
    {
      paramString2 = paramaquk;
      if (paramaquk == null) {
        paramString2 = new aquk();
      }
      QLog.i("VipARConfProcessor", 1, "notifyListener isSuccess : " + paramBoolean + " refer  = " + paramString1 + " data  = " + paramString2.toString());
      localbmsu.a(paramString2);
      return;
    }
    QLog.i("VipARConfProcessor", 1, "notifyListener fail :  refer  = " + paramString1 + " error = " + paramString2);
    localbmsu.a(paramString2);
  }
  
  @NonNull
  public aquk a(int paramInt)
  {
    QLog.e("VipARConfProcessor", 1, "migrateOldOrDefaultContent: " + paramInt);
    return new aquk();
  }
  
  @Nullable
  public aquk a(aqlg[] paramArrayOfaqlg)
  {
    if (paramArrayOfaqlg != null) {
      try
      {
        if (paramArrayOfaqlg.length > 0)
        {
          int j = paramArrayOfaqlg.length;
          int i = 0;
          while (i < j)
          {
            aqlg localaqlg = paramArrayOfaqlg[i];
            if (localaqlg != null)
            {
              aquk localaquk = aquk.a(localaqlg.jdField_a_of_type_JavaLangString);
              if (QLog.isColorLevel()) {
                QLog.d("VipARConfProcessor", 2, "onParsed " + localaqlg.jdField_a_of_type_JavaLangString);
              }
              if (localaquk != null) {
                return localaquk;
              }
            }
            i += 1;
          }
        }
        return new aquk();
      }
      catch (Exception paramArrayOfaqlg)
      {
        paramArrayOfaqlg.printStackTrace();
        QLog.e("VipARConfProcessor", 1, "onParsed Exception = " + paramArrayOfaqlg.getMessage());
      }
    }
  }
  
  public void a(aquk paramaquk)
  {
    if ((QLog.isColorLevel()) && (paramaquk != null)) {
      QLog.i("VipARConfProcessor", 2, "onUpdate: " + paramaquk.toString());
    }
    if (paramaquk != null) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, paramaquk, "onUpdate", " error bean = null");
      return;
    }
  }
  
  public Class<aquk> clazz()
  {
    return aquk.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.e("VipARConfProcessor", 1, "onReqFailed: " + paramInt);
    a(false, null, "onReqFailed", " failCode = " + paramInt);
  }
  
  public int type()
  {
    return 499;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqum
 * JD-Core Version:    0.7.0.1
 */