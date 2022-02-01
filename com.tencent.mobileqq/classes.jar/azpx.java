import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class azpx
{
  public static void a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    if ((paramBundle == null) || (paramQQAppInterface == null))
    {
      a("picPreSendProcess bundle=null!");
      return;
    }
    paramBundle.setClassLoader(PhotoSendParams.class.getClassLoader());
    PhotoSendParams localPhotoSendParams = (PhotoSendParams)paramBundle.getParcelable("PhotoConst.photo_send_qzone_pic_file_params");
    String str1 = paramBundle.getString("uin");
    String str2 = paramQQAppInterface.c();
    paramBundle.getString("troop_uin");
    int i = paramBundle.getInt("uintype", 1003);
    if ((localPhotoSendParams == null) || (TextUtils.isEmpty(localPhotoSendParams.rawMd5)) || (TextUtils.isEmpty(localPhotoSendParams.thumbPath)) || (!bhmi.b(localPhotoSendParams.thumbPath)) || (TextUtils.isEmpty(localPhotoSendParams.rawDownloadUrl)) || (TextUtils.isEmpty(str1)))
    {
      a("picPreSendProcess sendParams error, friendUin:" + str1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PicAioQzonePreSendMgr", 2, "picPreSendProcess params friendUin:" + str1 + ", uinType:" + i + ", sendParams:" + localPhotoSendParams.toString());
    }
    bfau localbfau = new bfau();
    bfbd localbfbd;
    switch (i)
    {
    default: 
      localbfbd = new bfbd();
      localbfbd.jdField_c_of_type_JavaLangString = str2;
      localbfbd.jdField_d_of_type_JavaLangString = str1;
      localbfbd.jdField_e_of_type_JavaLangString = str2;
      localbfbd.jdField_a_of_type_Long = localPhotoSendParams.fileSize;
      localbfbd.jdField_a_of_type_ArrayOfByte = bhml.a(localPhotoSendParams.rawMd5);
      localbfbd.jdField_a_of_type_JavaLangString = (localPhotoSendParams.rawMd5 + ".jpg");
      localbfbd.jdField_c_of_type_Int = localPhotoSendParams.rawWidth;
      localbfbd.jdField_d_of_type_Int = localPhotoSendParams.rawHeight;
      localbfbd.jdField_a_of_type_Int = 1000;
      localbfbd.jdField_e_of_type_Int = 3;
      localbfbd.jdField_b_of_type_JavaLangString = localPhotoSendParams.rawDownloadUrl;
    }
    for (paramBundle = "c2c_pic_up"; TextUtils.isEmpty(paramBundle); paramBundle = "grp_pic_up")
    {
      a("picPreSendProcess protoKey=null!");
      return;
      localbfbd = new bfbd();
      localbfbd.jdField_c_of_type_JavaLangString = str2;
      localbfbd.jdField_d_of_type_JavaLangString = str1;
      localbfbd.jdField_e_of_type_JavaLangString = str2;
      localbfbd.jdField_a_of_type_Long = localPhotoSendParams.fileSize;
      localbfbd.jdField_a_of_type_ArrayOfByte = bhml.a(localPhotoSendParams.rawMd5);
      localbfbd.jdField_a_of_type_JavaLangString = (localPhotoSendParams.rawMd5 + ".jpg");
      localbfbd.jdField_c_of_type_Int = localPhotoSendParams.rawWidth;
      localbfbd.jdField_d_of_type_Int = localPhotoSendParams.rawHeight;
      localbfbd.jdField_a_of_type_Int = 1000;
      localbfbd.jdField_b_of_type_Int = 1045;
      localbfbd.f = 1;
      localbfbd.jdField_e_of_type_Int = 3;
      localbfbd.jdField_b_of_type_JavaLangString = localPhotoSendParams.rawDownloadUrl;
    }
    localbfau.jdField_a_of_type_JavaUtilList.add(localbfbd);
    localbfau.jdField_a_of_type_JavaLangString = paramBundle;
    localbfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = paramQQAppInterface.getProtoReqManager();
    localbfau.jdField_a_of_type_Bfcb = new azpy(str2, str1, localPhotoSendParams);
    bfca.a(localbfau);
  }
  
  private static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PicAioQzonePreSendMgr", 2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpx
 * JD-Core Version:    0.7.0.1
 */