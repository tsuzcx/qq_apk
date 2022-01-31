import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class bjiw
{
  public static long a;
  public static boolean a;
  
  public static bjjc a(int paramInt1, int paramInt2)
  {
    bjjc localbjjc = new bjjc();
    localbjjc.jdField_a_of_type_Int = paramInt1;
    localbjjc.jdField_b_of_type_Int = paramInt2;
    return localbjjc;
  }
  
  public static bjjc a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoBusiManager", 2, "createShortVideoReqByMsg expired");
      }
      return null;
    }
    paramQQAppInterface = a(2, paramMessageForShortVideo.busiType);
    paramQQAppInterface.a(paramMessageForShortVideo);
    return paramQQAppInterface;
  }
  
  static BaseShortVideoOprerator a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    switch (paramInt)
    {
    case 1: 
    case 4: 
    default: 
      return null;
    }
    return new bjhy(paramQQAppInterface);
  }
  
  public static void a(bjjc parambjjc, QQAppInterface paramQQAppInterface)
  {
    if (parambjjc == null)
    {
      atpg.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(parambjjc.jdField_b_of_type_Int, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      atpg.b("ShortVideoBusiManager", "launch", "error,busiInterface == null,req.busiType:" + parambjjc.jdField_b_of_type_Int);
      return;
    }
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBaseShortVideoOprerator.jdField_a_of_type_Bjjc = parambjjc;
    localBaseShortVideoOprerator.jdField_a_of_type_JavaLangString = parambjjc.jdField_a_of_type_JavaLangString;
    localBaseShortVideoOprerator.jdField_b_of_type_JavaLangString = parambjjc.jdField_b_of_type_JavaLangString;
    localBaseShortVideoOprerator.a(parambjjc.jdField_a_of_type_Bjjk);
    atpg.a("ShortVideoBusiManager", "launch", "cmd:" + ShortVideoUtils.c(parambjjc.jdField_a_of_type_Int) + ", reqBusiType" + parambjjc.jdField_b_of_type_Int + ", uuid:" + parambjjc.jdField_a_of_type_JavaLangString);
    switch (parambjjc.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(parambjjc.jdField_a_of_type_Bjjg);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(parambjjc.jdField_a_of_type_Bjix);
      return;
    case 1: 
      localBaseShortVideoOprerator.a(parambjjc.jdField_a_of_type_Bjjg);
      return;
    case 3: 
      localBaseShortVideoOprerator.a(parambjjc.jdField_a_of_type_Bjiy);
      return;
    case 4: 
      localBaseShortVideoOprerator.a(parambjjc.jdField_a_of_type_Bjiy);
      return;
    }
    localBaseShortVideoOprerator.a(parambjjc.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjiw
 * JD-Core Version:    0.7.0.1
 */