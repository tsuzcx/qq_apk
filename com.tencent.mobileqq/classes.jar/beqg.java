import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.List;

public class beqg
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
      return new beqh();
    }
    return new beqi(paramContext, paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong, Context paramContext)
  {
    if ((paramContext == null) || (paramQQAppInterface == null)) {}
    label590:
    for (;;)
    {
      return;
      Object localObject2 = (beqe)apub.a().a(669);
      if (localObject2 != null)
      {
        Object localObject1 = ((beqe)localObject2).a(paramInt);
        if (localObject1 == null) {
          localObject1 = ((beqe)localObject2).a(paramContext);
        }
        for (;;)
        {
          if ((localObject1 == null) || (((beqj)localObject1).jdField_a_of_type_JavaUtilList == null) || (((beqj)localObject1).jdField_a_of_type_JavaUtilList.size() == 0)) {
            break label590;
          }
          String str1 = ((beqj)localObject1).jdField_a_of_type_JavaLangString;
          localObject2 = ((beqj)localObject1).b;
          Object localObject3 = Calendar.getInstance();
          ((Calendar)localObject3).setTimeInMillis(paramLong);
          int i = ((Calendar)localObject3).get(3);
          int j = ((Calendar)localObject3).get(5);
          String str2 = ((String)localObject2).replace("$M$", String.valueOf(i)).replace("$d$", String.valueOf(j));
          beqk localbeqk = (beqk)((beqj)localObject1).jdField_a_of_type_JavaUtilList.get(0);
          if (localbeqk == null) {
            break;
          }
          if (!TextUtils.isEmpty(localbeqk.jdField_a_of_type_JavaLangString)) {}
          for (boolean bool3 = true;; bool3 = false)
          {
            if ((!TextUtils.isEmpty(localbeqk.b)) && (!TextUtils.isEmpty(localbeqk.c)) && (localbeqk.b.equals("web"))) {}
            for (localObject3 = localbeqk.c;; localObject3 = "")
            {
              boolean bool2 = false;
              boolean bool1 = false;
              if (((beqj)localObject1).jdField_a_of_type_JavaUtilList.size() > 1)
              {
                localObject1 = (beqk)((beqj)localObject1).jdField_a_of_type_JavaUtilList.get(1);
                if (localObject1 != null)
                {
                  if (!TextUtils.isEmpty(((beqk)localObject1).jdField_a_of_type_JavaLangString)) {
                    bool1 = true;
                  }
                  bool2 = bool1;
                  if (!TextUtils.isEmpty(((beqk)localObject1).b))
                  {
                    bool2 = bool1;
                    if (!TextUtils.isEmpty(((beqk)localObject1).c))
                    {
                      bool2 = bool1;
                      if (((beqk)localObject1).b.equals("web")) {
                        localObject2 = ((beqk)localObject1).c;
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
                  bfur.a(paramContext, 230, str1, str2, localbeqk.jdField_a_of_type_JavaLangString, ((beqk)localObject1).jdField_a_of_type_JavaLangString, a(bool1, (String)localObject2, paramContext), a(bool3, (String)localObject3, paramContext)).show();
                  bcef.b(paramQQAppInterface, "dc00898", "", "", "0X800B340", "0X800B340", 0, 0, "", "", "", "");
                  return;
                }
                if (!bool3) {
                  break;
                }
                localObject1 = bfur.a(paramContext, 230);
                if (localObject1 == null) {
                  break;
                }
                ((QQCustomDialog)localObject1).setTitle(str1);
                ((QQCustomDialog)localObject1).setMessage(str2);
                ((QQCustomDialog)localObject1).setNegativeButton(localbeqk.jdField_a_of_type_JavaLangString, a(bool3, (String)localObject3, paramContext));
                ((QQCustomDialog)localObject1).show();
                bcef.b(paramQQAppInterface, "dc00898", "", "", "0X800B340", "0X800B340", 0, 0, "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqg
 * JD-Core Version:    0.7.0.1
 */