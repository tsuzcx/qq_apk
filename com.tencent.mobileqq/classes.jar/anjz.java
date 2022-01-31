import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmotionPanelDataBuilder.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class anjz
{
  private static anjz a;
  
  public static anjz a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new anjz();
      }
      return a;
    }
    finally {}
  }
  
  public List<anjy> a(QQAppInterface paramQQAppInterface, int paramInt1, EmoticonPackage paramEmoticonPackage, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelDataBuilder", 2, "getEmotionPanelData panelType = " + paramInt1);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (arnz)paramQQAppInterface.getManager(14);
    switch (paramInt1)
    {
    }
    Emoticon localEmoticon;
    label603:
    for (;;)
    {
      return localArrayList;
      return anmf.a(paramQQAppInterface, paramInt3);
      localArrayList.add(new anjy());
      return localArrayList;
      paramQQAppInterface = ((ancg)paramQQAppInterface.getManager(149)).b();
      paramEmoticonPackage = new anht();
      paramEmoticonPackage.h = "favEdit";
      localArrayList.add(paramEmoticonPackage);
      if (paramInt2 != 1024)
      {
        paramEmoticonPackage = new anht();
        paramEmoticonPackage.h = "funny_pic";
        localArrayList.add(paramEmoticonPackage);
      }
      if (paramQQAppInterface != null)
      {
        if (paramQQAppInterface.size() > ance.jdField_a_of_type_Int)
        {
          localArrayList.addAll(new ArrayList(paramQQAppInterface.subList(0, ance.jdField_a_of_type_Int)));
          return localArrayList;
        }
        localArrayList.addAll(paramQQAppInterface);
        return localArrayList;
        paramQQAppInterface = ((anbo)paramQQAppInterface.getManager(333)).b();
        paramEmoticonPackage = new anhh();
        paramEmoticonPackage.h = "cameraEdit";
        localArrayList.add(paramEmoticonPackage);
        paramEmoticonPackage = new anhh();
        paramEmoticonPackage.h = "cameraJump";
        localArrayList.add(paramEmoticonPackage);
        if (paramQQAppInterface != null)
        {
          if (paramQQAppInterface.size() > anbe.jdField_a_of_type_Int)
          {
            localArrayList.addAll(new ArrayList(paramQQAppInterface.subList(0, anbe.jdField_a_of_type_Int)));
            return localArrayList;
          }
          localArrayList.addAll(paramQQAppInterface);
          return localArrayList;
          paramQQAppInterface = new anla(paramQQAppInterface.getCurrentAccountUin());
          paramQQAppInterface.h = "push";
          paramEmoticonPackage = ((arnz)localObject1).b(0);
          localArrayList.add(paramQQAppInterface);
          localArrayList.addAll(paramEmoticonPackage);
          return localArrayList;
          paramQQAppInterface = ((arnz)localObject1).a(true, paramInt3, paramBoolean);
          if (paramQQAppInterface != null)
          {
            localArrayList.addAll(paramQQAppInterface);
            return localArrayList;
            if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {
              return null;
            }
            localObject1 = ((arnz)localObject1).a(paramEmoticonPackage.epId, true);
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
                localObject2 = new anlr(paramQQAppInterface.getCurrentAccountUin());
                ((anlr)localObject2).jdField_c_of_type_Int = 10;
                ((anlr)localObject2).jdField_a_of_type_Int = paramEmoticonPackage.type;
                ((anlr)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticon = localEmoticon;
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
    Object localObject2 = new anla(paramQQAppInterface.getCurrentAccountUin());
    ((anla)localObject2).jdField_c_of_type_Int = 6;
    ((anla)localObject2).j = paramEmoticonPackage.type;
    ((anla)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticon = localEmoticon;
    if (paramEmoticonPackage.isAPNG == 2) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((anla)localObject2).jdField_c_of_type_Boolean = paramBoolean;
      localArrayList.add(localObject2);
      break;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, EmoticonPackage paramEmoticonPackage, int paramInt2, int paramInt3, boolean paramBoolean, anka paramanka)
  {
    if (paramanka == null) {
      return;
    }
    ThreadManager.post(new EmotionPanelDataBuilder.1(this, paramQQAppInterface, paramInt1, paramEmoticonPackage, paramInt2, paramInt3, paramBoolean, paramanka), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anjz
 * JD-Core Version:    0.7.0.1
 */