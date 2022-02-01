import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class bpqy
{
  public static long a;
  public static boolean a;
  
  public static bprf a(int paramInt1, int paramInt2)
  {
    bprf localbprf = new bprf();
    localbprf.jdField_a_of_type_Int = paramInt1;
    localbprf.jdField_b_of_type_Int = paramInt2;
    return localbprf;
  }
  
  public static bprf a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, int paramInt)
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
    return new bpqk(paramQQAppInterface);
  }
  
  public static void a(bprf parambprf, QQAppInterface paramQQAppInterface)
  {
    if (parambprf == null)
    {
      azjq.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(parambprf.jdField_b_of_type_Int, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      azjq.b("ShortVideoBusiManager", "launch", "error,busiInterface == null,req.busiType:" + parambprf.jdField_b_of_type_Int);
      return;
    }
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBaseShortVideoOprerator.jdField_a_of_type_Bprf = parambprf;
    localBaseShortVideoOprerator.jdField_a_of_type_JavaLangString = parambprf.jdField_a_of_type_JavaLangString;
    localBaseShortVideoOprerator.jdField_b_of_type_JavaLangString = parambprf.jdField_b_of_type_JavaLangString;
    localBaseShortVideoOprerator.a(parambprf.jdField_a_of_type_Bprl);
    azjq.a("ShortVideoBusiManager", "launch", "cmd:" + ShortVideoUtils.c(parambprf.jdField_a_of_type_Int) + ", reqBusiType" + parambprf.jdField_b_of_type_Int + ", uuid:" + parambprf.jdField_a_of_type_JavaLangString);
    switch (parambprf.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(parambprf.jdField_a_of_type_Bprh);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(parambprf.jdField_a_of_type_Bpqz);
      return;
    case 1: 
      localBaseShortVideoOprerator.a(parambprf.jdField_a_of_type_Bprh);
      return;
    case 3: 
      localBaseShortVideoOprerator.a(parambprf.jdField_a_of_type_Bpra);
      return;
    case 4: 
      localBaseShortVideoOprerator.a(parambprf.jdField_a_of_type_Bpra);
      return;
    }
    localBaseShortVideoOprerator.a(parambprf.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpqy
 * JD-Core Version:    0.7.0.1
 */