import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class bkzh
{
  public static long a;
  public static boolean a;
  
  public static bkzn a(int paramInt1, int paramInt2)
  {
    bkzn localbkzn = new bkzn();
    localbkzn.jdField_a_of_type_Int = paramInt1;
    localbkzn.jdField_b_of_type_Int = paramInt2;
    return localbkzn;
  }
  
  public static bkzn a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, int paramInt)
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
    return new bkyj(paramQQAppInterface);
  }
  
  public static void a(bkzn parambkzn, QQAppInterface paramQQAppInterface)
  {
    if (parambkzn == null)
    {
      aune.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(parambkzn.jdField_b_of_type_Int, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      aune.b("ShortVideoBusiManager", "launch", "error,busiInterface == null,req.busiType:" + parambkzn.jdField_b_of_type_Int);
      return;
    }
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBaseShortVideoOprerator.jdField_a_of_type_Bkzn = parambkzn;
    localBaseShortVideoOprerator.jdField_a_of_type_JavaLangString = parambkzn.jdField_a_of_type_JavaLangString;
    localBaseShortVideoOprerator.jdField_b_of_type_JavaLangString = parambkzn.jdField_b_of_type_JavaLangString;
    localBaseShortVideoOprerator.a(parambkzn.jdField_a_of_type_Bkzv);
    aune.a("ShortVideoBusiManager", "launch", "cmd:" + ShortVideoUtils.c(parambkzn.jdField_a_of_type_Int) + ", reqBusiType" + parambkzn.jdField_b_of_type_Int + ", uuid:" + parambkzn.jdField_a_of_type_JavaLangString);
    switch (parambkzn.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(parambkzn.jdField_a_of_type_Bkzr);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(parambkzn.jdField_a_of_type_Bkzi);
      return;
    case 1: 
      localBaseShortVideoOprerator.a(parambkzn.jdField_a_of_type_Bkzr);
      return;
    case 3: 
      localBaseShortVideoOprerator.a(parambkzn.jdField_a_of_type_Bkzj);
      return;
    case 4: 
      localBaseShortVideoOprerator.a(parambkzn.jdField_a_of_type_Bkzj);
      return;
    }
    localBaseShortVideoOprerator.a(parambkzn.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkzh
 * JD-Core Version:    0.7.0.1
 */