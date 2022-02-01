import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

final class bhlo
  extends bhyn
{
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    Object localObject2 = parambhyo.a();
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
          QLog.d("ClubContentJsonTask", 2, "Club_jsonDownloadListener key = " + parambhyo.jdField_a_of_type_JavaLangString + ",satatus = " + parambhyo.a() + ",errCode = " + parambhyo.jdField_a_of_type_Int + ",errMsg = " + parambhyo.b);
        }
        Object localObject1 = BaseApplicationImpl.sApplication.getRuntime();
        Object localObject3;
        boolean bool1;
        if ((localObject1 instanceof QQAppInterface))
        {
          localObject1 = (QQAppInterface)localObject1;
          if ((parambhyo.a() != 3) || (parambhyo.jdField_a_of_type_Int != 0)) {
            break label614;
          }
          localObject3 = ((Bundle)localObject2).getString("version_key");
          if (localObject3 != null) {
            bhln.a(BaseApplicationImpl.sApplication.getApplicationContext(), (String)localObject3, ((Bundle)localObject2).getInt("version", 0));
          }
          if ((parambhyo.jdField_a_of_type_JavaLangString == null) || (localObject1 == null)) {
            break label541;
          }
          if (!bhln.c.jdField_a_of_type_JavaLangString.equals(parambhyo.jdField_a_of_type_JavaLangString)) {
            break label384;
          }
          bhln.c.jdField_a_of_type_OrgJsonJSONObject = null;
          bhln.c.a(((QQAppInterface)localObject1).getApplication());
          bool1 = bool2;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentJsonTask", 2, "jsonDownloadListener,ret=" + bool1 + ",file.name:" + parambhyo.jdField_a_of_type_JavaLangString + ",method:" + str1 + ",ifromet:" + str2);
          }
          if (localObject1 != null) {}
          try
          {
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("param_jsonName", parambhyo.jdField_a_of_type_JavaLangString);
            ((HashMap)localObject2).put("param_method", str1);
            ((HashMap)localObject2).put("param_from", str2);
            StatisticCollector.getInstance(((QQAppInterface)localObject1).getApplication().getApplicationContext()).collectPerformance(((QQAppInterface)localObject1).getAccount(), "ClubContentJsonLoaded", bool1, 1L, 0L, (HashMap)localObject2, "", false);
            return;
          }
          catch (Exception parambhyo)
          {
            label384:
            label541:
            label562:
            label609:
            label614:
            parambhyo.printStackTrace();
            return;
          }
          localObject1 = null;
          break;
          if (parambhyo.jdField_a_of_type_JavaLangString.equals(bhln.f.jdField_a_of_type_JavaLangString))
          {
            anvn.a((QQAppInterface)localObject1);
            bool1 = bool2;
          }
          else
          {
            bool1 = bool2;
            if (!parambhyo.jdField_a_of_type_JavaLangString.equals(bhln.b.jdField_a_of_type_JavaLangString)) {
              if (parambhyo.jdField_a_of_type_JavaLangString.equals(bhln.h.jdField_a_of_type_JavaLangString))
              {
                ((bhon)((QQAppInterface)localObject1).getManager(QQManagerFactory.URL_INTECEPT_MANAGER)).a((QQAppInterface)localObject1);
                bool1 = bool2;
              }
              else if (parambhyo.jdField_a_of_type_JavaLangString.equals(bhln.d.jdField_a_of_type_JavaLangString))
              {
                bhln.d.jdField_a_of_type_OrgJsonJSONObject = null;
                bhln.d.a(((QQAppInterface)localObject1).getApplication());
                bool1 = bool2;
              }
              else
              {
                bool1 = bool2;
                if (parambhyo.jdField_a_of_type_JavaLangString.equals(bhln.i.jdField_a_of_type_JavaLangString))
                {
                  localObject2 = (gb)((QQAppInterface)localObject1).getManager(QQManagerFactory.CHAT_FONT_MANAGER);
                  bool1 = bool2;
                  continue;
                  localObject2 = new StringBuilder().append("jsonDownloadListener, app == null:");
                  if (localObject1 == null)
                  {
                    bool1 = true;
                    localObject2 = ((StringBuilder)localObject2).append(bool1).append(",key == null:");
                    if (parambhyo.jdField_a_of_type_JavaLangString != null) {
                      break label609;
                    }
                  }
                  for (bool1 = true;; bool1 = false)
                  {
                    QLog.e("ClubContentJsonTask", 2, bool1);
                    bool1 = bool2;
                    break;
                    bool1 = false;
                    break label562;
                  }
                  QLog.e("ClubContentJsonTask", 1, "ClubContentJsonTask jsondownfail task.key = " + parambhyo.jdField_a_of_type_JavaLangString);
                  if ((parambhyo.jdField_a_of_type_JavaLangString != null) && (parambhyo.jdField_a_of_type_JavaLangString.equals(bhln.g.jdField_a_of_type_JavaLangString)) && (localObject1 != null))
                  {
                    localObject3 = (anxc)((QQAppInterface)localObject1).getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER);
                    localObject2 = "0";
                    if (((anxc)localObject3).a()) {
                      localObject2 = "1";
                    }
                    bdla.b((QQAppInterface)localObject1, "CliOper", "", "", "0X800612B", "0X800612B", 0, 0, (String)localObject2, "0", "", "");
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
  
  public void onProgress(bhyo parambhyo) {}
  
  public boolean onStart(bhyo parambhyo)
  {
    return super.onStart(parambhyo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhlo
 * JD-Core Version:    0.7.0.1
 */