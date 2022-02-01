import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class bqgk
{
  public static long a;
  public static boolean a;
  
  public static bqgq a(int paramInt1, int paramInt2)
  {
    bqgq localbqgq = new bqgq();
    localbqgq.jdField_a_of_type_Int = paramInt1;
    localbqgq.jdField_b_of_type_Int = paramInt2;
    return localbqgq;
  }
  
  public static bqgq a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, int paramInt)
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
    return new bqfq(paramQQAppInterface);
  }
  
  public static void a(bqgq parambqgq, QQAppInterface paramQQAppInterface)
  {
    if (parambqgq == null)
    {
      ayxi.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(parambqgq.jdField_b_of_type_Int, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      ayxi.b("ShortVideoBusiManager", "launch", "error,busiInterface == null,req.busiType:" + parambqgq.jdField_b_of_type_Int);
      return;
    }
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBaseShortVideoOprerator.jdField_a_of_type_Bqgq = parambqgq;
    localBaseShortVideoOprerator.jdField_a_of_type_JavaLangString = parambqgq.jdField_a_of_type_JavaLangString;
    localBaseShortVideoOprerator.jdField_b_of_type_JavaLangString = parambqgq.jdField_b_of_type_JavaLangString;
    localBaseShortVideoOprerator.a(parambqgq.jdField_a_of_type_Bqgw);
    ayxi.a("ShortVideoBusiManager", "launch", "cmd:" + ShortVideoUtils.c(parambqgq.jdField_a_of_type_Int) + ", reqBusiType" + parambqgq.jdField_b_of_type_Int + ", uuid:" + parambqgq.jdField_a_of_type_JavaLangString);
    switch (parambqgq.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(parambqgq.jdField_a_of_type_Bqgs);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(parambqgq.jdField_a_of_type_Bqgl);
      return;
    case 1: 
      localBaseShortVideoOprerator.a(parambqgq.jdField_a_of_type_Bqgs);
      return;
    case 3: 
      localBaseShortVideoOprerator.a(parambqgq.jdField_a_of_type_Bqgm);
      return;
    case 4: 
      localBaseShortVideoOprerator.a(parambqgq.jdField_a_of_type_Bqgm);
      return;
    }
    localBaseShortVideoOprerator.a(parambqgq.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqgk
 * JD-Core Version:    0.7.0.1
 */