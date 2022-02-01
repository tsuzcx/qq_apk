import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.List;

public class bggy
{
  private static DialogInterface.OnClickListener a(boolean paramBoolean, String paramString, Context paramContext)
  {
    if ((!paramBoolean) || (paramContext == null)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("JoinTroopSecurityTipsHelper", 2, "getBtnListener, isShow = " + paramBoolean + ", jumpUrl = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return new bggz();
    }
    return new bgha(paramContext, paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong, Context paramContext)
  {
    if ((paramContext == null) || (paramQQAppInterface == null)) {}
    label590:
    for (;;)
    {
      return;
      Object localObject2 = (bggw)aran.a().a(669);
      if (localObject2 != null)
      {
        Object localObject1 = ((bggw)localObject2).a(paramInt);
        if (localObject1 == null) {
          localObject1 = ((bggw)localObject2).a(paramContext);
        }
        for (;;)
        {
          if ((localObject1 == null) || (((bghb)localObject1).jdField_a_of_type_JavaUtilList == null) || (((bghb)localObject1).jdField_a_of_type_JavaUtilList.size() == 0)) {
            break label590;
          }
          String str1 = ((bghb)localObject1).jdField_a_of_type_JavaLangString;
          localObject2 = ((bghb)localObject1).b;
          Object localObject3 = Calendar.getInstance();
          ((Calendar)localObject3).setTimeInMillis(paramLong);
          int i = ((Calendar)localObject3).get(3);
          int j = ((Calendar)localObject3).get(5);
          String str2 = ((String)localObject2).replace("$M$", String.valueOf(i)).replace("$d$", String.valueOf(j));
          bghc localbghc = (bghc)((bghb)localObject1).jdField_a_of_type_JavaUtilList.get(0);
          if (localbghc == null) {
            break;
          }
          if (!TextUtils.isEmpty(localbghc.jdField_a_of_type_JavaLangString)) {}
          for (boolean bool3 = true;; bool3 = false)
          {
            if ((!TextUtils.isEmpty(localbghc.b)) && (!TextUtils.isEmpty(localbghc.c)) && (localbghc.b.equals("web"))) {}
            for (localObject3 = localbghc.c;; localObject3 = "")
            {
              boolean bool2 = false;
              boolean bool1 = false;
              if (((bghb)localObject1).jdField_a_of_type_JavaUtilList.size() > 1)
              {
                localObject1 = (bghc)((bghb)localObject1).jdField_a_of_type_JavaUtilList.get(1);
                if (localObject1 != null)
                {
                  if (!TextUtils.isEmpty(((bghc)localObject1).jdField_a_of_type_JavaLangString)) {
                    bool1 = true;
                  }
                  bool2 = bool1;
                  if (!TextUtils.isEmpty(((bghc)localObject1).b))
                  {
                    bool2 = bool1;
                    if (!TextUtils.isEmpty(((bghc)localObject1).c))
                    {
                      bool2 = bool1;
                      if (((bghc)localObject1).b.equals("web")) {
                        localObject2 = ((bghc)localObject1).c;
                      }
                    }
                  }
                }
              }
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("JoinTroopSecurityTipsHelper", 2, "JoinTroopSecurityTipsHelper showTips tId = " + paramInt + ",time = " + paramLong + ",isShowFrist" + bool3 + ",isShowSecond" + bool1);
                }
                if ((bool3) && (bool1))
                {
                  bhlq.a(paramContext, 230, str1, str2, localbghc.jdField_a_of_type_JavaLangString, ((bghc)localObject1).jdField_a_of_type_JavaLangString, a(bool1, (String)localObject2, paramContext), a(bool3, (String)localObject3, paramContext)).show();
                  bdll.b(paramQQAppInterface, "dc00898", "", "", "0X800B340", "0X800B340", 0, 0, "", "", "", "");
                  return;
                }
                if (!bool3) {
                  break;
                }
                localObject1 = bhlq.a(paramContext, 230);
                if (localObject1 == null) {
                  break;
                }
                ((bhpc)localObject1).setTitle(str1);
                ((bhpc)localObject1).setMessage(str2);
                ((bhpc)localObject1).setNegativeButton(localbghc.jdField_a_of_type_JavaLangString, a(bool3, (String)localObject3, paramContext));
                ((bhpc)localObject1).show();
                bdll.b(paramQQAppInterface, "dc00898", "", "", "0X800B340", "0X800B340", 0, 0, "", "", "", "");
                return;
                localObject2 = "";
                bool1 = bool2;
                continue;
                localObject2 = "";
                bool1 = false;
                localObject1 = null;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggy
 * JD-Core Version:    0.7.0.1
 */