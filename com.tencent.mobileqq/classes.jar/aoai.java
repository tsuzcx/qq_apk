import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmotionPanelDataBuilder.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aoai
{
  private static aoai a;
  
  public static aoai a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aoai();
      }
      return a;
    }
    finally {}
  }
  
  public List<aoah> a(QQAppInterface paramQQAppInterface, int paramInt1, EmoticonPackage paramEmoticonPackage, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelDataBuilder", 2, "getEmotionPanelData panelType = " + paramInt1);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (askd)paramQQAppInterface.getManager(14);
    switch (paramInt1)
    {
    }
    Emoticon localEmoticon;
    label603:
    for (;;)
    {
      return localArrayList;
      return aocp.a(paramQQAppInterface, paramInt3);
      localArrayList.add(new aoah());
      return localArrayList;
      paramQQAppInterface = ((ansr)paramQQAppInterface.getManager(149)).b();
      paramEmoticonPackage = new anyc();
      paramEmoticonPackage.h = "favEdit";
      localArrayList.add(paramEmoticonPackage);
      if (paramInt2 != 1024)
      {
        paramEmoticonPackage = new anyc();
        paramEmoticonPackage.h = "funny_pic";
        localArrayList.add(paramEmoticonPackage);
      }
      if (paramQQAppInterface != null)
      {
        if (paramQQAppInterface.size() > ansp.jdField_a_of_type_Int)
        {
          localArrayList.addAll(new ArrayList(paramQQAppInterface.subList(0, ansp.jdField_a_of_type_Int)));
          return localArrayList;
        }
        localArrayList.addAll(paramQQAppInterface);
        return localArrayList;
        paramQQAppInterface = ((anrz)paramQQAppInterface.getManager(333)).b();
        paramEmoticonPackage = new anxq();
        paramEmoticonPackage.h = "cameraEdit";
        localArrayList.add(paramEmoticonPackage);
        paramEmoticonPackage = new anxq();
        paramEmoticonPackage.h = "cameraJump";
        localArrayList.add(paramEmoticonPackage);
        if (paramQQAppInterface != null)
        {
          if (paramQQAppInterface.size() > anrp.jdField_a_of_type_Int)
          {
            localArrayList.addAll(new ArrayList(paramQQAppInterface.subList(0, anrp.jdField_a_of_type_Int)));
            return localArrayList;
          }
          localArrayList.addAll(paramQQAppInterface);
          return localArrayList;
          paramQQAppInterface = new aobk(paramQQAppInterface.getCurrentAccountUin());
          paramQQAppInterface.h = "push";
          paramEmoticonPackage = ((askd)localObject1).b(0);
          localArrayList.add(paramQQAppInterface);
          localArrayList.addAll(paramEmoticonPackage);
          return localArrayList;
          paramQQAppInterface = ((askd)localObject1).a(true, paramInt3, paramBoolean);
          if (paramQQAppInterface != null)
          {
            localArrayList.addAll(paramQQAppInterface);
            return localArrayList;
            if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {
              return null;
            }
            localObject1 = ((askd)localObject1).a(paramEmoticonPackage.epId, true);
            if (paramEmoticonPackage.jobType == 4) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if (localObject1 == null) {
                break label603;
              }
              paramInt3 = ((List)localObject1).size();
              paramInt2 = 0;
              while (paramInt2 < paramInt3)
              {
                localEmoticon = (Emoticon)((List)localObject1).get(paramInt2);
                if (paramInt1 == 0) {
                  break label605;
                }
                localObject2 = new aocb(paramQQAppInterface.getCurrentAccountUin());
                ((aocb)localObject2).jdField_c_of_type_Int = 10;
                ((aocb)localObject2).jdField_a_of_type_Int = paramEmoticonPackage.type;
                ((aocb)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticon = localEmoticon;
                localArrayList.add(localObject2);
                paramInt2 += 1;
              }
              break;
            }
          }
        }
      }
    }
    label605:
    Object localObject2 = new aobk(paramQQAppInterface.getCurrentAccountUin());
    ((aobk)localObject2).jdField_c_of_type_Int = 6;
    ((aobk)localObject2).j = paramEmoticonPackage.type;
    ((aobk)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticon = localEmoticon;
    if (paramEmoticonPackage.isAPNG == 2) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((aobk)localObject2).jdField_c_of_type_Boolean = paramBoolean;
      localArrayList.add(localObject2);
      break;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, EmoticonPackage paramEmoticonPackage, int paramInt2, int paramInt3, boolean paramBoolean, aoaj paramaoaj)
  {
    if (paramaoaj == null) {
      return;
    }
    ThreadManager.post(new EmotionPanelDataBuilder.1(this, paramQQAppInterface, paramInt1, paramEmoticonPackage, paramInt2, paramInt3, paramBoolean, paramaoaj), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoai
 * JD-Core Version:    0.7.0.1
 */