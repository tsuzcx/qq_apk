import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aunf
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
    if ((localPhotoSendParams == null) || (TextUtils.isEmpty(localPhotoSendParams.rawMd5)) || (TextUtils.isEmpty(localPhotoSendParams.thumbPath)) || (!bbdj.b(localPhotoSendParams.thumbPath)) || (TextUtils.isEmpty(localPhotoSendParams.rawDownloadUrl)) || (TextUtils.isEmpty(str1)))
    {
      a("picPreSendProcess sendParams error, friendUin:" + str1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PicAioQzonePreSendMgr", 2, "picPreSendProcess params friendUin:" + str1 + ", uinType:" + i + ", sendParams:" + localPhotoSendParams.toString());
    }
    ayyn localayyn = new ayyn();
    ayyw localayyw;
    switch (i)
    {
    default: 
      localayyw = new ayyw();
      localayyw.jdField_c_of_type_JavaLangString = str2;
      localayyw.jdField_d_of_type_JavaLangString = str1;
      localayyw.jdField_e_of_type_JavaLangString = str2;
      localayyw.jdField_a_of_type_Long = localPhotoSendParams.fileSize;
      localayyw.jdField_a_of_type_ArrayOfByte = bbdm.a(localPhotoSendParams.rawMd5);
      localayyw.jdField_a_of_type_JavaLangString = (localPhotoSendParams.rawMd5 + ".jpg");
      localayyw.jdField_c_of_type_Int = localPhotoSendParams.rawWidth;
      localayyw.jdField_d_of_type_Int = localPhotoSendParams.rawHeight;
      localayyw.jdField_a_of_type_Int = 1000;
      localayyw.jdField_e_of_type_Int = 3;
      localayyw.jdField_b_of_type_JavaLangString = localPhotoSendParams.rawDownloadUrl;
    }
    for (paramBundle = "c2c_pic_up"; TextUtils.isEmpty(paramBundle); paramBundle = "grp_pic_up")
    {
      a("picPreSendProcess protoKey=null!");
      return;
      localayyw = new ayyw();
      localayyw.jdField_c_of_type_JavaLangString = str2;
      localayyw.jdField_d_of_type_JavaLangString = str1;
      localayyw.jdField_e_of_type_JavaLangString = str2;
      localayyw.jdField_a_of_type_Long = localPhotoSendParams.fileSize;
      localayyw.jdField_a_of_type_ArrayOfByte = bbdm.a(localPhotoSendParams.rawMd5);
      localayyw.jdField_a_of_type_JavaLangString = (localPhotoSendParams.rawMd5 + ".jpg");
      localayyw.jdField_c_of_type_Int = localPhotoSendParams.rawWidth;
      localayyw.jdField_d_of_type_Int = localPhotoSendParams.rawHeight;
      localayyw.jdField_a_of_type_Int = 1000;
      localayyw.jdField_b_of_type_Int = 1045;
      localayyw.f = 1;
      localayyw.jdField_e_of_type_Int = 3;
      localayyw.jdField_b_of_type_JavaLangString = localPhotoSendParams.rawDownloadUrl;
    }
    localayyn.jdField_a_of_type_JavaUtilList.add(localayyw);
    localayyn.jdField_a_of_type_JavaLangString = paramBundle;
    localayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = paramQQAppInterface.getProtoReqManager();
    localayyn.jdField_a_of_type_Ayzu = new aung(str2, str1, localPhotoSendParams);
    ayzt.a(localayyn);
  }
  
  private static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PicAioQzonePreSendMgr", 2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aunf
 * JD-Core Version:    0.7.0.1
 */