import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class bobg
{
  public static long a;
  public static boolean a;
  
  public static bobn a(int paramInt1, int paramInt2)
  {
    bobn localbobn = new bobn();
    localbobn.jdField_a_of_type_Int = paramInt1;
    localbobn.jdField_b_of_type_Int = paramInt2;
    return localbobn;
  }
  
  public static bobn a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, int paramInt)
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
    return new boas(paramQQAppInterface);
  }
  
  public static void a(bobn parambobn, QQAppInterface paramQQAppInterface)
  {
    if (parambobn == null)
    {
      ayde.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(parambobn.jdField_b_of_type_Int, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      ayde.b("ShortVideoBusiManager", "launch", "error,busiInterface == null,req.busiType:" + parambobn.jdField_b_of_type_Int);
      return;
    }
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBaseShortVideoOprerator.jdField_a_of_type_Bobn = parambobn;
    localBaseShortVideoOprerator.jdField_a_of_type_JavaLangString = parambobn.jdField_a_of_type_JavaLangString;
    localBaseShortVideoOprerator.jdField_b_of_type_JavaLangString = parambobn.jdField_b_of_type_JavaLangString;
    localBaseShortVideoOprerator.a(parambobn.jdField_a_of_type_Bobt);
    ayde.a("ShortVideoBusiManager", "launch", "cmd:" + ShortVideoUtils.c(parambobn.jdField_a_of_type_Int) + ", reqBusiType" + parambobn.jdField_b_of_type_Int + ", uuid:" + parambobn.jdField_a_of_type_JavaLangString);
    switch (parambobn.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(parambobn.jdField_a_of_type_Bobp);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(parambobn.jdField_a_of_type_Bobh);
      return;
    case 1: 
      localBaseShortVideoOprerator.a(parambobn.jdField_a_of_type_Bobp);
      return;
    case 3: 
      localBaseShortVideoOprerator.a(parambobn.jdField_a_of_type_Bobi);
      return;
    case 4: 
      localBaseShortVideoOprerator.a(parambobn.jdField_a_of_type_Bobi);
      return;
    }
    localBaseShortVideoOprerator.a(parambobn.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bobg
 * JD-Core Version:    0.7.0.1
 */