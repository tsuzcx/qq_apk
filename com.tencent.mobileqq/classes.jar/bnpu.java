import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class bnpu
{
  public static long a;
  public static boolean a;
  
  public static bnqa a(int paramInt1, int paramInt2)
  {
    bnqa localbnqa = new bnqa();
    localbnqa.jdField_a_of_type_Int = paramInt1;
    localbnqa.jdField_b_of_type_Int = paramInt2;
    return localbnqa;
  }
  
  public static bnqa a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, int paramInt)
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
    return new bnow(paramQQAppInterface);
  }
  
  public static void a(bnqa parambnqa, QQAppInterface paramQQAppInterface)
  {
    if (parambnqa == null)
    {
      awiw.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(parambnqa.jdField_b_of_type_Int, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      awiw.b("ShortVideoBusiManager", "launch", "error,busiInterface == null,req.busiType:" + parambnqa.jdField_b_of_type_Int);
      return;
    }
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBaseShortVideoOprerator.jdField_a_of_type_Bnqa = parambnqa;
    localBaseShortVideoOprerator.jdField_a_of_type_JavaLangString = parambnqa.jdField_a_of_type_JavaLangString;
    localBaseShortVideoOprerator.jdField_b_of_type_JavaLangString = parambnqa.jdField_b_of_type_JavaLangString;
    localBaseShortVideoOprerator.a(parambnqa.jdField_a_of_type_Bnqi);
    awiw.a("ShortVideoBusiManager", "launch", "cmd:" + ShortVideoUtils.c(parambnqa.jdField_a_of_type_Int) + ", reqBusiType" + parambnqa.jdField_b_of_type_Int + ", uuid:" + parambnqa.jdField_a_of_type_JavaLangString);
    switch (parambnqa.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(parambnqa.jdField_a_of_type_Bnqe);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(parambnqa.jdField_a_of_type_Bnpv);
      return;
    case 1: 
      localBaseShortVideoOprerator.a(parambnqa.jdField_a_of_type_Bnqe);
      return;
    case 3: 
      localBaseShortVideoOprerator.a(parambnqa.jdField_a_of_type_Bnpw);
      return;
    case 4: 
      localBaseShortVideoOprerator.a(parambnqa.jdField_a_of_type_Bnpw);
      return;
    }
    localBaseShortVideoOprerator.a(parambnqa.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpu
 * JD-Core Version:    0.7.0.1
 */