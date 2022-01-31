import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class bnli
{
  public static long a;
  public static boolean a;
  
  public static bnlo a(int paramInt1, int paramInt2)
  {
    bnlo localbnlo = new bnlo();
    localbnlo.jdField_a_of_type_Int = paramInt1;
    localbnlo.jdField_b_of_type_Int = paramInt2;
    return localbnlo;
  }
  
  public static bnlo a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, int paramInt)
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
    return new bnkk(paramQQAppInterface);
  }
  
  public static void a(bnlo parambnlo, QQAppInterface paramQQAppInterface)
  {
    if (parambnlo == null)
    {
      awen.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(parambnlo.jdField_b_of_type_Int, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      awen.b("ShortVideoBusiManager", "launch", "error,busiInterface == null,req.busiType:" + parambnlo.jdField_b_of_type_Int);
      return;
    }
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBaseShortVideoOprerator.jdField_a_of_type_Bnlo = parambnlo;
    localBaseShortVideoOprerator.jdField_a_of_type_JavaLangString = parambnlo.jdField_a_of_type_JavaLangString;
    localBaseShortVideoOprerator.jdField_b_of_type_JavaLangString = parambnlo.jdField_b_of_type_JavaLangString;
    localBaseShortVideoOprerator.a(parambnlo.jdField_a_of_type_Bnlw);
    awen.a("ShortVideoBusiManager", "launch", "cmd:" + ShortVideoUtils.c(parambnlo.jdField_a_of_type_Int) + ", reqBusiType" + parambnlo.jdField_b_of_type_Int + ", uuid:" + parambnlo.jdField_a_of_type_JavaLangString);
    switch (parambnlo.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(parambnlo.jdField_a_of_type_Bnls);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(parambnlo.jdField_a_of_type_Bnlj);
      return;
    case 1: 
      localBaseShortVideoOprerator.a(parambnlo.jdField_a_of_type_Bnls);
      return;
    case 3: 
      localBaseShortVideoOprerator.a(parambnlo.jdField_a_of_type_Bnlk);
      return;
    case 4: 
      localBaseShortVideoOprerator.a(parambnlo.jdField_a_of_type_Bnlk);
      return;
    }
    localBaseShortVideoOprerator.a(parambnlo.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnli
 * JD-Core Version:    0.7.0.1
 */