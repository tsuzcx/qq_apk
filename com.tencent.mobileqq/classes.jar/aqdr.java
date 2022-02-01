import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class aqdr
  extends aptq<aqdp>
{
  public static String a;
  private WeakReference<bkzj> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "{\n    \"switch\":1,\n    \"match\":[\n        {\n            \"key\":\"花木兰\",\n            \"resUrl\":\"https://d3g.qq.com/sngapp/app/update/20191028162616_9505/libai_dae.zip\",\n            \"md5\":\"52b1ab75bbd04aef4eb889cc6b625dad\"\n        },\n        {\n            \"key\":\"miku\",\n            \"resUrl\":\"https://d3g.qq.com/sngapp/app/update/20191029174146_1019/miku_fbx.zip\",\n            \"md5\":\"f957c6847f06e485a021ed81d5b5024a\"\n        },\n        {\n            \"key\":\"莓莓蛋糕\",\n            \"resUrl\":\"https://d3g.qq.com/sngapp/app/update/20191107111004_5856/cake_dae.zip\",\n            \"md5\":\"4fe9009093acbea20a65f281958879eb\"\n        }\n    ],\n    \"blackList\":\"SLA-AL00\"\n}";
  }
  
  private void a(boolean paramBoolean, aqdp paramaqdp, String paramString1, String paramString2)
  {
    blad.a().b(paramaqdp);
    if (this.jdField_a_of_type_MqqUtilWeakReference == null)
    {
      QLog.e("VipARConfProcessor", 1, "load config listener = null");
      return;
    }
    bkzj localbkzj = (bkzj)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localbkzj == null)
    {
      QLog.e("VipARConfProcessor", 1, "load config vipARConfigListener = null");
      return;
    }
    if (paramBoolean)
    {
      paramString2 = paramaqdp;
      if (paramaqdp == null) {
        paramString2 = new aqdp();
      }
      QLog.i("VipARConfProcessor", 1, "notifyListener isSuccess : " + paramBoolean + " refer  = " + paramString1 + " data  = " + paramString2.toString());
      localbkzj.a(paramString2);
      return;
    }
    QLog.i("VipARConfProcessor", 1, "notifyListener fail :  refer  = " + paramString1 + " error = " + paramString2);
    localbkzj.a(paramString2);
  }
  
  @NonNull
  public aqdp a(int paramInt)
  {
    QLog.e("VipARConfProcessor", 1, "migrateOldOrDefaultContent: " + paramInt);
    return new aqdp();
  }
  
  @Nullable
  public aqdp a(aptx[] paramArrayOfaptx)
  {
    if (paramArrayOfaptx != null) {
      try
      {
        if (paramArrayOfaptx.length > 0)
        {
          int j = paramArrayOfaptx.length;
          int i = 0;
          while (i < j)
          {
            aptx localaptx = paramArrayOfaptx[i];
            if (localaptx != null)
            {
              aqdp localaqdp = aqdp.a(localaptx.jdField_a_of_type_JavaLangString);
              if (QLog.isColorLevel()) {
                QLog.d("VipARConfProcessor", 2, "onParsed " + localaptx.jdField_a_of_type_JavaLangString);
              }
              if (localaqdp != null) {
                return localaqdp;
              }
            }
            i += 1;
          }
        }
        return new aqdp();
      }
      catch (Exception paramArrayOfaptx)
      {
        paramArrayOfaptx.printStackTrace();
        QLog.e("VipARConfProcessor", 1, "onParsed Exception = " + paramArrayOfaptx.getMessage());
      }
    }
  }
  
  public void a(aqdp paramaqdp)
  {
    if ((QLog.isColorLevel()) && (paramaqdp != null)) {
      QLog.i("VipARConfProcessor", 2, "onUpdate: " + paramaqdp.toString());
    }
    if (paramaqdp != null) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, paramaqdp, "onUpdate", " error bean = null");
      return;
    }
  }
  
  public Class<aqdp> clazz()
  {
    return aqdp.class;
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
 * Qualified Name:     aqdr
 * JD-Core Version:    0.7.0.1
 */