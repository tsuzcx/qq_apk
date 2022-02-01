import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadVideoThumbJob;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

class bmjr
  implements bmjf
{
  bmjr(bmjq parambmjq) {}
  
  public void a(int paramInt)
  {
    JSONObject localJSONObject = this.a.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.a(this.a.jdField_a_of_type_Bmjp.c, this.a.jdField_a_of_type_Int, this.a.b, "uploading", "", 0);
    try
    {
      if (this.a.b == 2)
      {
        float f2 = paramInt / 100.0F * 0.85F + 0.1F;
        f1 = f2;
        if (f2 <= 1.0F) {}
      }
      for (float f1 = 1.0F;; f1 = paramInt / 100.0F)
      {
        localJSONObject.put("progress", f1);
        if (QLog.isDevelopLevel()) {
          QLog.d("TroopHWJsPlugin", 4, "id = " + this.a.jdField_a_of_type_Int + " progress = " + paramInt + " realProgress = " + f1);
        }
        this.a.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.callJs(this.a.jdField_a_of_type_Bmjp.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
        this.a.jdField_a_of_type_Boolean = true;
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHWJsPlugin", 2, "onComplete id = " + this.a.jdField_a_of_type_Int + " url = " + paramString);
    }
    if (this.a.b == 0) {}
    for (int i = 11;; i = 0)
    {
      Object localObject = "uploaded";
      if (this.a.b == 2) {
        localObject = "uploading";
      }
      localObject = this.a.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.a(this.a.jdField_a_of_type_Bmjp.c, this.a.jdField_a_of_type_Int, this.a.b, (String)localObject, paramString, i);
      this.a.jdField_a_of_type_JavaLangString = paramString;
      do
      {
        for (;;)
        {
          try
          {
            ((JSONObject)localObject).put("result", 0);
            if (2 == this.a.b)
            {
              ((JSONObject)localObject).put("progress", 0.949999988079071D);
              if (this.a.b != 2) {
                this.a.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.callJs(this.a.jdField_a_of_type_Bmjp.jdField_a_of_type_JavaLangString, new String[] { ((JSONObject)localObject).toString() });
              }
              this.a.jdField_a_of_type_Boolean = false;
              if (!this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
                break;
              }
              return;
            }
            if (this.a.b == 1)
            {
              ((JSONObject)localObject).put("progress", 1.0D);
              ((JSONObject)localObject).put("size", "[0,400,694,1000]");
              continue;
            }
            if (this.a.b != 0) {
              continue;
            }
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            return;
          }
          ((JSONObject)localObject).put("progress", 1.0D);
        }
      } while (this.a.b != 2);
      paramString = new bmjs(this);
      ThreadManager.postImmediately(new TroopHWJsPlugin.UploadVideoThumbJob(this.a.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin, this.a, paramString, TroopHWJsPlugin.a(this.a.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin)), null, false);
      return;
    }
  }
  
  public void b(int paramInt)
  {
    QLog.d("TroopHWJsPlugin", 1, "upload failed! errorCode = " + paramInt);
    this.a.jdField_a_of_type_Boolean = false;
    JSONObject localJSONObject = this.a.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.a(this.a.jdField_a_of_type_Bmjp.c, this.a.jdField_a_of_type_Int, this.a.b, "uploaded", "", 0);
    try
    {
      localJSONObject.put("result", paramInt);
      this.a.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.callJs(this.a.jdField_a_of_type_Bmjp.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("TroopHWJsPlugin", 1, "upload error!", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjr
 * JD-Core Version:    0.7.0.1
 */