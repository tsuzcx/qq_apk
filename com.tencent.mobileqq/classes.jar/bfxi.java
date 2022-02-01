import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.List;

public class bfxi
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
      return new bfxj();
    }
    return new bfxk(paramContext, paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong, Context paramContext)
  {
    if ((paramContext == null) || (paramQQAppInterface == null)) {}
    label590:
    for (;;)
    {
      return;
      Object localObject2 = (bfxg)aqxe.a().a(669);
      if (localObject2 != null)
      {
        Object localObject1 = ((bfxg)localObject2).a(paramInt);
        if (localObject1 == null) {
          localObject1 = ((bfxg)localObject2).a(paramContext);
        }
        for (;;)
        {
          if ((localObject1 == null) || (((bfxl)localObject1).jdField_a_of_type_JavaUtilList == null) || (((bfxl)localObject1).jdField_a_of_type_JavaUtilList.size() == 0)) {
            break label590;
          }
          String str1 = ((bfxl)localObject1).jdField_a_of_type_JavaLangString;
          localObject2 = ((bfxl)localObject1).b;
          Object localObject3 = Calendar.getInstance();
          ((Calendar)localObject3).setTimeInMillis(paramLong);
          int i = ((Calendar)localObject3).get(3);
          int j = ((Calendar)localObject3).get(5);
          String str2 = ((String)localObject2).replace("$M$", String.valueOf(i)).replace("$d$", String.valueOf(j));
          bfxm localbfxm = (bfxm)((bfxl)localObject1).jdField_a_of_type_JavaUtilList.get(0);
          if (localbfxm == null) {
            break;
          }
          if (!TextUtils.isEmpty(localbfxm.jdField_a_of_type_JavaLangString)) {}
          for (boolean bool3 = true;; bool3 = false)
          {
            if ((!TextUtils.isEmpty(localbfxm.b)) && (!TextUtils.isEmpty(localbfxm.c)) && (localbfxm.b.equals("web"))) {}
            for (localObject3 = localbfxm.c;; localObject3 = "")
            {
              boolean bool2 = false;
              boolean bool1 = false;
              if (((bfxl)localObject1).jdField_a_of_type_JavaUtilList.size() > 1)
              {
                localObject1 = (bfxm)((bfxl)localObject1).jdField_a_of_type_JavaUtilList.get(1);
                if (localObject1 != null)
                {
                  if (!TextUtils.isEmpty(((bfxm)localObject1).jdField_a_of_type_JavaLangString)) {
                    bool1 = true;
                  }
                  bool2 = bool1;
                  if (!TextUtils.isEmpty(((bfxm)localObject1).b))
                  {
                    bool2 = bool1;
                    if (!TextUtils.isEmpty(((bfxm)localObject1).c))
                    {
                      bool2 = bool1;
                      if (((bfxm)localObject1).b.equals("web")) {
                        localObject2 = ((bfxm)localObject1).c;
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
                  bhdj.a(paramContext, 230, str1, str2, localbfxm.jdField_a_of_type_JavaLangString, ((bfxm)localObject1).jdField_a_of_type_JavaLangString, a(bool1, (String)localObject2, paramContext), a(bool3, (String)localObject3, paramContext)).show();
                  bdla.b(paramQQAppInterface, "dc00898", "", "", "0X800B340", "0X800B340", 0, 0, "", "", "", "");
                  return;
                }
                if (!bool3) {
                  break;
                }
                localObject1 = bhdj.a(paramContext, 230);
                if (localObject1 == null) {
                  break;
                }
                ((QQCustomDialog)localObject1).setTitle(str1);
                ((QQCustomDialog)localObject1).setMessage(str2);
                ((QQCustomDialog)localObject1).setNegativeButton(localbfxm.jdField_a_of_type_JavaLangString, a(bool3, (String)localObject3, paramContext));
                ((QQCustomDialog)localObject1).show();
                bdla.b(paramQQAppInterface, "dc00898", "", "", "0X800B340", "0X800B340", 0, 0, "", "", "", "");
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
 * Qualified Name:     bfxi
 * JD-Core Version:    0.7.0.1
 */