import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class brhv
{
  public static long a;
  public static boolean a;
  
  public static bric a(int paramInt1, int paramInt2)
  {
    bric localbric = new bric();
    localbric.jdField_a_of_type_Int = paramInt1;
    localbric.jdField_b_of_type_Int = paramInt2;
    return localbric;
  }
  
  public static bric a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, int paramInt)
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
    return new brhb(paramQQAppInterface);
  }
  
  public static void a(bric parambric, QQAppInterface paramQQAppInterface)
  {
    if (parambric == null)
    {
      azpw.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(parambric.jdField_b_of_type_Int, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      azpw.b("ShortVideoBusiManager", "launch", "error,busiInterface == null,req.busiType:" + parambric.jdField_b_of_type_Int);
      return;
    }
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBaseShortVideoOprerator.jdField_a_of_type_Bric = parambric;
    localBaseShortVideoOprerator.jdField_a_of_type_JavaLangString = parambric.jdField_a_of_type_JavaLangString;
    localBaseShortVideoOprerator.jdField_b_of_type_JavaLangString = parambric.jdField_b_of_type_JavaLangString;
    localBaseShortVideoOprerator.a(parambric.jdField_a_of_type_Brii);
    azpw.a("ShortVideoBusiManager", "launch", "cmd:" + ShortVideoUtils.c(parambric.jdField_a_of_type_Int) + ", reqBusiType" + parambric.jdField_b_of_type_Int + ", uuid:" + parambric.jdField_a_of_type_JavaLangString);
    switch (parambric.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(parambric.jdField_a_of_type_Brie);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(parambric.jdField_a_of_type_Brhw);
      return;
    case 1: 
      localBaseShortVideoOprerator.a(parambric.jdField_a_of_type_Brie);
      return;
    case 3: 
      localBaseShortVideoOprerator.a(parambric.jdField_a_of_type_Brhx);
      return;
    case 4: 
      localBaseShortVideoOprerator.a(parambric.jdField_a_of_type_Brhx);
      return;
    }
    localBaseShortVideoOprerator.a(parambric.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brhv
 * JD-Core Version:    0.7.0.1
 */