import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class argy
  extends aqwt<argw>
{
  public static String a;
  private WeakReference<bmln> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "{\n    \"switch\":1,\n    \"match\":[\n        {\n            \"key\":\"花木兰\",\n            \"resUrl\":\"https://d3g.qq.com/sngapp/app/update/20191028162616_9505/libai_dae.zip\",\n            \"md5\":\"52b1ab75bbd04aef4eb889cc6b625dad\"\n        },\n        {\n            \"key\":\"miku\",\n            \"resUrl\":\"https://d3g.qq.com/sngapp/app/update/20191029174146_1019/miku_fbx.zip\",\n            \"md5\":\"f957c6847f06e485a021ed81d5b5024a\"\n        },\n        {\n            \"key\":\"莓莓蛋糕\",\n            \"resUrl\":\"https://d3g.qq.com/sngapp/app/update/20191107111004_5856/cake_dae.zip\",\n            \"md5\":\"4fe9009093acbea20a65f281958879eb\"\n        }\n    ],\n    \"blackList\":\"SLA-AL00\"\n}";
  }
  
  private void a(boolean paramBoolean, argw paramargw, String paramString1, String paramString2)
  {
    bmmh.a().b(paramargw);
    if (this.jdField_a_of_type_MqqUtilWeakReference == null)
    {
      QLog.e("VipARConfProcessor", 1, "load config listener = null");
      return;
    }
    bmln localbmln = (bmln)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localbmln == null)
    {
      QLog.e("VipARConfProcessor", 1, "load config vipARConfigListener = null");
      return;
    }
    if (paramBoolean)
    {
      paramString2 = paramargw;
      if (paramargw == null) {
        paramString2 = new argw();
      }
      QLog.i("VipARConfProcessor", 1, "notifyListener isSuccess : " + paramBoolean + " refer  = " + paramString1 + " data  = " + paramString2.toString());
      localbmln.a(paramString2);
      return;
    }
    QLog.i("VipARConfProcessor", 1, "notifyListener fail :  refer  = " + paramString1 + " error = " + paramString2);
    localbmln.a(paramString2);
  }
  
  @NonNull
  public argw a(int paramInt)
  {
    QLog.e("VipARConfProcessor", 1, "migrateOldOrDefaultContent: " + paramInt);
    return new argw();
  }
  
  @Nullable
  public argw a(aqxa[] paramArrayOfaqxa)
  {
    if (paramArrayOfaqxa != null) {
      try
      {
        if (paramArrayOfaqxa.length > 0)
        {
          int j = paramArrayOfaqxa.length;
          int i = 0;
          while (i < j)
          {
            aqxa localaqxa = paramArrayOfaqxa[i];
            if (localaqxa != null)
            {
              argw localargw = argw.a(localaqxa.jdField_a_of_type_JavaLangString);
              if (QLog.isColorLevel()) {
                QLog.d("VipARConfProcessor", 2, "onParsed " + localaqxa.jdField_a_of_type_JavaLangString);
              }
              if (localargw != null) {
                return localargw;
              }
            }
            i += 1;
          }
        }
        return new argw();
      }
      catch (Exception paramArrayOfaqxa)
      {
        paramArrayOfaqxa.printStackTrace();
        QLog.e("VipARConfProcessor", 1, "onParsed Exception = " + paramArrayOfaqxa.getMessage());
      }
    }
  }
  
  public void a(argw paramargw)
  {
    if ((QLog.isColorLevel()) && (paramargw != null)) {
      QLog.i("VipARConfProcessor", 2, "onUpdate: " + paramargw.toString());
    }
    if (paramargw != null) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, paramargw, "onUpdate", " error bean = null");
      return;
    }
  }
  
  public Class<argw> clazz()
  {
    return argw.class;
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
 * Qualified Name:     argy
 * JD-Core Version:    0.7.0.1
 */