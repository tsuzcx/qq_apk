import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

public class apsi
  extends aprq
{
  public static int a(QQAppInterface paramQQAppInterface, apsm paramapsm)
  {
    if (paramapsm == null) {
      return -1;
    }
    int i = paramapsm.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelConstans", 2, "getPanelType type = " + i);
    }
    switch (i)
    {
    case 5: 
    default: 
      return -1;
    case 4: 
      return 4;
    case 7: 
      return 1;
    case 9: 
      return 5;
    case 8: 
      return 3;
    case 6: 
      return a(paramQQAppInterface, paramapsm, false);
    case 10: 
      return a(paramQQAppInterface, paramapsm, true);
    }
    return 13;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, apsm paramapsm, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramapsm == null))
    {
      QLog.e("EmotionPanelConstans", 1, "getEmotionPanelType app or panelinfo is null");
      return -1;
    }
    EmoticonPackage localEmoticonPackage = paramapsm.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
    if (localEmoticonPackage == null)
    {
      QLog.e("EmotionPanelConstans", 1, "getEmotionPanelType emotionPkg is null; type = " + paramapsm.jdField_a_of_type_Int);
      return -1;
    }
    boolean bool = apro.a(localEmoticonPackage);
    int i = localEmoticonPackage.status;
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelConstans", 2, "getEmotionPanelType epid = " + localEmoticonPackage.epId + "status = " + i + ";shouldUpdate = " + bool);
    }
    if ((!localEmoticonPackage.valid) || (i == 3) || (!a(paramQQAppInterface, localEmoticonPackage)))
    {
      if (i == 2) {
        return 12;
      }
      return 7;
    }
    if (bool)
    {
      if (paramBoolean) {
        return 9;
      }
      return 8;
    }
    if (i != 2) {
      return 7;
    }
    if (paramBoolean) {
      return 2;
    }
    return 6;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage == null) || (paramQQAppInterface == null)) {
      return false;
    }
    int i = ((alxl)paramQQAppInterface.a(13)).g();
    if (paramEmoticonPackage.mobileFeetype == 4) {
      return (i == 1) || (i == 3);
    }
    if (paramEmoticonPackage.mobileFeetype == 5) {
      return i == 3;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsi
 * JD-Core Version:    0.7.0.1
 */