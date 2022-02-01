import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmotionPanelDataBuilder.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aspr
{
  private static aspr a;
  
  public static aspr a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aspr();
      }
      return a;
    }
    finally {}
  }
  
  public List<aspq> a(QQAppInterface paramQQAppInterface, int paramInt1, EmoticonPackage paramEmoticonPackage, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelDataBuilder", 2, "getEmotionPanelData panelType = " + paramInt1);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (axfj)paramQQAppInterface.getManager(14);
    switch (paramInt1)
    {
    }
    Emoticon localEmoticon;
    label603:
    for (;;)
    {
      return localArrayList;
      return assj.a(paramQQAppInterface, paramInt3);
      localArrayList.add(new aspq());
      return localArrayList;
      paramQQAppInterface = ((ashc)paramQQAppInterface.getManager(149)).b();
      paramEmoticonPackage = new asmu();
      paramEmoticonPackage.i = "favEdit";
      localArrayList.add(paramEmoticonPackage);
      if (paramInt2 != 1024)
      {
        paramEmoticonPackage = new asmu();
        paramEmoticonPackage.i = "funny_pic";
        localArrayList.add(paramEmoticonPackage);
      }
      if (paramQQAppInterface != null)
      {
        if (paramQQAppInterface.size() > asha.jdField_a_of_type_Int)
        {
          localArrayList.addAll(new ArrayList(paramQQAppInterface.subList(0, asha.jdField_a_of_type_Int)));
          return localArrayList;
        }
        localArrayList.addAll(paramQQAppInterface);
        return localArrayList;
        paramQQAppInterface = ((asgf)paramQQAppInterface.getManager(333)).b();
        paramEmoticonPackage = new asmg();
        paramEmoticonPackage.i = "cameraEdit";
        localArrayList.add(paramEmoticonPackage);
        paramEmoticonPackage = new asmg();
        paramEmoticonPackage.i = "cameraJump";
        localArrayList.add(paramEmoticonPackage);
        if (paramQQAppInterface != null)
        {
          if (paramQQAppInterface.size() > asfv.jdField_a_of_type_Int)
          {
            localArrayList.addAll(new ArrayList(paramQQAppInterface.subList(0, asfv.jdField_a_of_type_Int)));
            return localArrayList;
          }
          localArrayList.addAll(paramQQAppInterface);
          return localArrayList;
          paramQQAppInterface = new asre(paramQQAppInterface.getCurrentAccountUin());
          paramQQAppInterface.i = "push";
          paramEmoticonPackage = ((axfj)localObject1).b(0);
          localArrayList.add(paramQQAppInterface);
          localArrayList.addAll(paramEmoticonPackage);
          return localArrayList;
          paramQQAppInterface = ((axfj)localObject1).a(true, paramInt3, paramBoolean);
          if (paramQQAppInterface != null)
          {
            localArrayList.addAll(paramQQAppInterface);
            return localArrayList;
            if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {
              return null;
            }
            localObject1 = ((axfj)localObject1).a(paramEmoticonPackage.epId, true);
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
                localObject2 = new asrv(paramQQAppInterface.getCurrentAccountUin());
                ((asrv)localObject2).jdField_c_of_type_Int = 10;
                ((asrv)localObject2).jdField_a_of_type_Int = paramEmoticonPackage.type;
                ((asrv)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticon = localEmoticon;
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
    Object localObject2 = new asre(paramQQAppInterface.getCurrentAccountUin());
    ((asre)localObject2).jdField_c_of_type_Int = 6;
    ((asre)localObject2).j = paramEmoticonPackage.type;
    ((asre)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticon = localEmoticon;
    if (paramEmoticonPackage.isAPNG == 2) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((asre)localObject2).jdField_c_of_type_Boolean = paramBoolean;
      localArrayList.add(localObject2);
      break;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, EmoticonPackage paramEmoticonPackage, int paramInt2, int paramInt3, boolean paramBoolean, asps paramasps)
  {
    if (paramasps == null) {
      return;
    }
    ThreadManager.post(new EmotionPanelDataBuilder.1(this, paramQQAppInterface, paramInt1, paramEmoticonPackage, paramInt2, paramInt3, paramBoolean, paramasps), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspr
 * JD-Core Version:    0.7.0.1
 */