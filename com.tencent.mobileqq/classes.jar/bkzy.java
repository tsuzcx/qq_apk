import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class bkzy
{
  public static long a;
  public static boolean a;
  
  public static blae a(int paramInt1, int paramInt2)
  {
    blae localblae = new blae();
    localblae.jdField_a_of_type_Int = paramInt1;
    localblae.jdField_b_of_type_Int = paramInt2;
    return localblae;
  }
  
  public static blae a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, int paramInt)
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
    return new bkza(paramQQAppInterface);
  }
  
  public static void a(blae paramblae, QQAppInterface paramQQAppInterface)
  {
    if (paramblae == null)
    {
      aung.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(paramblae.jdField_b_of_type_Int, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      aung.b("ShortVideoBusiManager", "launch", "error,busiInterface == null,req.busiType:" + paramblae.jdField_b_of_type_Int);
      return;
    }
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBaseShortVideoOprerator.jdField_a_of_type_Blae = paramblae;
    localBaseShortVideoOprerator.jdField_a_of_type_JavaLangString = paramblae.jdField_a_of_type_JavaLangString;
    localBaseShortVideoOprerator.jdField_b_of_type_JavaLangString = paramblae.jdField_b_of_type_JavaLangString;
    localBaseShortVideoOprerator.a(paramblae.jdField_a_of_type_Blam);
    aung.a("ShortVideoBusiManager", "launch", "cmd:" + ShortVideoUtils.c(paramblae.jdField_a_of_type_Int) + ", reqBusiType" + paramblae.jdField_b_of_type_Int + ", uuid:" + paramblae.jdField_a_of_type_JavaLangString);
    switch (paramblae.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(paramblae.jdField_a_of_type_Blai);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(paramblae.jdField_a_of_type_Bkzz);
      return;
    case 1: 
      localBaseShortVideoOprerator.a(paramblae.jdField_a_of_type_Blai);
      return;
    case 3: 
      localBaseShortVideoOprerator.a(paramblae.jdField_a_of_type_Blaa);
      return;
    case 4: 
      localBaseShortVideoOprerator.a(paramblae.jdField_a_of_type_Blaa);
      return;
    }
    localBaseShortVideoOprerator.a(paramblae.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkzy
 * JD-Core Version:    0.7.0.1
 */