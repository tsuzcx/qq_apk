import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

final class bdri
  extends bead
{
  public void onDone(beae parambeae)
  {
    super.onDone(parambeae);
    Object localObject2 = parambeae.a();
    String str1 = ((Bundle)localObject2).getString("method");
    if (str1 == null) {
      str1 = "other";
    }
    for (;;)
    {
      String str2 = ((Bundle)localObject2).getString("ifromet");
      if (str2 == null) {
        str2 = "null";
      }
      for (;;)
      {
        boolean bool2 = true;
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentJsonTask", 2, "Club_jsonDownloadListener key = " + parambeae.jdField_a_of_type_JavaLangString + ",satatus = " + parambeae.a() + ",errCode = " + parambeae.jdField_a_of_type_Int + ",errMsg = " + parambeae.b);
        }
        Object localObject1 = BaseApplicationImpl.sApplication.getRuntime();
        Object localObject3;
        boolean bool1;
        if ((localObject1 instanceof QQAppInterface))
        {
          localObject1 = (QQAppInterface)localObject1;
          if ((parambeae.a() != 3) || (parambeae.jdField_a_of_type_Int != 0)) {
            break label613;
          }
          localObject3 = ((Bundle)localObject2).getString("version_key");
          if (localObject3 != null) {
            bdrh.a(BaseApplicationImpl.sApplication.getApplicationContext(), (String)localObject3, ((Bundle)localObject2).getInt("version", 0));
          }
          if ((parambeae.jdField_a_of_type_JavaLangString == null) || (localObject1 == null)) {
            break label540;
          }
          if (!bdrh.c.jdField_a_of_type_JavaLangString.equals(parambeae.jdField_a_of_type_JavaLangString)) {
            break label384;
          }
          bdrh.c.jdField_a_of_type_OrgJsonJSONObject = null;
          bdrh.c.a(((QQAppInterface)localObject1).getApplication());
          bool1 = bool2;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentJsonTask", 2, "jsonDownloadListener,ret=" + bool1 + ",file.name:" + parambeae.jdField_a_of_type_JavaLangString + ",method:" + str1 + ",ifromet:" + str2);
          }
          if (localObject1 != null) {}
          try
          {
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("param_jsonName", parambeae.jdField_a_of_type_JavaLangString);
            ((HashMap)localObject2).put("param_method", str1);
            ((HashMap)localObject2).put("param_from", str2);
            azri.a(((QQAppInterface)localObject1).getApplication().getApplicationContext()).a(((QQAppInterface)localObject1).getAccount(), "ClubContentJsonLoaded", bool1, 1L, 0L, (HashMap)localObject2, "", false);
            return;
          }
          catch (Exception parambeae)
          {
            label384:
            label540:
            label561:
            label608:
            label613:
            parambeae.printStackTrace();
            return;
          }
          localObject1 = null;
          break;
          if (parambeae.jdField_a_of_type_JavaLangString.equals(bdrh.f.jdField_a_of_type_JavaLangString))
          {
            altr.a((QQAppInterface)localObject1);
            bool1 = bool2;
          }
          else
          {
            bool1 = bool2;
            if (!parambeae.jdField_a_of_type_JavaLangString.equals(bdrh.b.jdField_a_of_type_JavaLangString)) {
              if (parambeae.jdField_a_of_type_JavaLangString.equals(bdrh.h.jdField_a_of_type_JavaLangString))
              {
                ((bdtz)((QQAppInterface)localObject1).getManager(150)).a((QQAppInterface)localObject1);
                bool1 = bool2;
              }
              else if (parambeae.jdField_a_of_type_JavaLangString.equals(bdrh.d.jdField_a_of_type_JavaLangString))
              {
                bdrh.d.jdField_a_of_type_OrgJsonJSONObject = null;
                bdrh.d.a(((QQAppInterface)localObject1).getApplication());
                bool1 = bool2;
              }
              else
              {
                bool1 = bool2;
                if (parambeae.jdField_a_of_type_JavaLangString.equals(bdrh.i.jdField_a_of_type_JavaLangString))
                {
                  localObject2 = (fx)((QQAppInterface)localObject1).getManager(42);
                  bool1 = bool2;
                  continue;
                  localObject2 = new StringBuilder().append("jsonDownloadListener, app == null:");
                  if (localObject1 == null)
                  {
                    bool1 = true;
                    localObject2 = ((StringBuilder)localObject2).append(bool1).append(",key == null:");
                    if (parambeae.jdField_a_of_type_JavaLangString != null) {
                      break label608;
                    }
                  }
                  for (bool1 = true;; bool1 = false)
                  {
                    QLog.e("ClubContentJsonTask", 2, bool1);
                    bool1 = bool2;
                    break;
                    bool1 = false;
                    break label561;
                  }
                  QLog.e("ClubContentJsonTask", 1, "ClubContentJsonTask jsondownfail task.key = " + parambeae.jdField_a_of_type_JavaLangString);
                  if ((parambeae.jdField_a_of_type_JavaLangString != null) && (parambeae.jdField_a_of_type_JavaLangString.equals(bdrh.g.jdField_a_of_type_JavaLangString)) && (localObject1 != null))
                  {
                    localObject3 = (alvg)((QQAppInterface)localObject1).getManager(131);
                    localObject2 = "0";
                    if (((alvg)localObject3).a()) {
                      localObject2 = "1";
                    }
                    azqs.b((QQAppInterface)localObject1, "CliOper", "", "", "0X800612B", "0X800612B", 0, 0, (String)localObject2, "0", "", "");
                  }
                  bool1 = false;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onProgress(beae parambeae) {}
  
  public boolean onStart(beae parambeae)
  {
    return super.onStart(parambeae);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdri
 * JD-Core Version:    0.7.0.1
 */