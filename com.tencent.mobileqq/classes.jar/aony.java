import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class aony
  extends aofy<aonw>
{
  public static String a;
  private WeakReference<bkad> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "{\n    \"switch\":1,\n    \"match\":[\n        {\n            \"key\":\"花木兰\",\n            \"resUrl\":\"https://d3g.qq.com/sngapp/app/update/20191028162616_9505/libai_dae.zip\",\n            \"md5\":\"52b1ab75bbd04aef4eb889cc6b625dad\"\n        },\n        {\n            \"key\":\"miku\",\n            \"resUrl\":\"https://d3g.qq.com/sngapp/app/update/20191029174146_1019/miku_fbx.zip\",\n            \"md5\":\"f957c6847f06e485a021ed81d5b5024a\"\n        },\n        {\n            \"key\":\"莓莓蛋糕\",\n            \"resUrl\":\"https://d3g.qq.com/sngapp/app/update/20191107111004_5856/cake_dae.zip\",\n            \"md5\":\"4fe9009093acbea20a65f281958879eb\"\n        }\n    ],\n    \"blackList\":\"SLA-AL00\"\n}";
  }
  
  private void a(boolean paramBoolean, aonw paramaonw, String paramString1, String paramString2)
  {
    bkax.a().b(paramaonw);
    if (this.jdField_a_of_type_MqqUtilWeakReference == null)
    {
      QLog.e("VipARConfProcessor", 1, "load config listener = null");
      return;
    }
    bkad localbkad = (bkad)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localbkad == null)
    {
      QLog.e("VipARConfProcessor", 1, "load config vipARConfigListener = null");
      return;
    }
    if (paramBoolean)
    {
      paramString2 = paramaonw;
      if (paramaonw == null) {
        paramString2 = new aonw();
      }
      QLog.i("VipARConfProcessor", 1, "notifyListener isSuccess : " + paramBoolean + " refer  = " + paramString1 + " data  = " + paramString2.toString());
      localbkad.a(paramString2);
      return;
    }
    QLog.i("VipARConfProcessor", 1, "notifyListener fail :  refer  = " + paramString1 + " error = " + paramString2);
    localbkad.a(paramString2);
  }
  
  public int a()
  {
    return 499;
  }
  
  @NonNull
  public aonw a(int paramInt)
  {
    QLog.e("VipARConfProcessor", 1, "migrateOldOrDefaultContent: " + paramInt);
    return new aonw();
  }
  
  @Nullable
  public aonw a(aogf[] paramArrayOfaogf)
  {
    if (paramArrayOfaogf != null) {
      try
      {
        if (paramArrayOfaogf.length > 0)
        {
          int j = paramArrayOfaogf.length;
          int i = 0;
          while (i < j)
          {
            aogf localaogf = paramArrayOfaogf[i];
            if (localaogf != null)
            {
              aonw localaonw = aonw.a(localaogf.jdField_a_of_type_JavaLangString);
              if (QLog.isColorLevel()) {
                QLog.d("VipARConfProcessor", 2, "onParsed " + localaogf.jdField_a_of_type_JavaLangString);
              }
              if (localaonw != null) {
                return localaonw;
              }
            }
            i += 1;
          }
        }
        return new aonw();
      }
      catch (Exception paramArrayOfaogf)
      {
        paramArrayOfaogf.printStackTrace();
        QLog.e("VipARConfProcessor", 1, "onParsed Exception = " + paramArrayOfaogf.getMessage());
      }
    }
  }
  
  public Class<aonw> a()
  {
    return aonw.class;
  }
  
  public void a(int paramInt)
  {
    QLog.e("VipARConfProcessor", 1, "onReqFailed: " + paramInt);
    a(false, null, "onReqFailed", " failCode = " + paramInt);
  }
  
  public void a(aonw paramaonw)
  {
    if ((QLog.isColorLevel()) && (paramaonw != null)) {
      QLog.i("VipARConfProcessor", 2, "onUpdate: " + paramaonw.toString());
    }
    if (paramaonw != null) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, paramaonw, "onUpdate", " error bean = null");
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
 * Qualified Name:     aony
 * JD-Core Version:    0.7.0.1
 */