import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ayxj
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
    if ((localPhotoSendParams == null) || (TextUtils.isEmpty(localPhotoSendParams.rawMd5)) || (TextUtils.isEmpty(localPhotoSendParams.thumbPath)) || (!bgmg.b(localPhotoSendParams.thumbPath)) || (TextUtils.isEmpty(localPhotoSendParams.rawDownloadUrl)) || (TextUtils.isEmpty(str1)))
    {
      a("picPreSendProcess sendParams error, friendUin:" + str1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PicAioQzonePreSendMgr", 2, "picPreSendProcess params friendUin:" + str1 + ", uinType:" + i + ", sendParams:" + localPhotoSendParams.toString());
    }
    bebv localbebv = new bebv();
    bece localbece;
    switch (i)
    {
    default: 
      localbece = new bece();
      localbece.jdField_c_of_type_JavaLangString = str2;
      localbece.jdField_d_of_type_JavaLangString = str1;
      localbece.jdField_e_of_type_JavaLangString = str2;
      localbece.jdField_a_of_type_Long = localPhotoSendParams.fileSize;
      localbece.jdField_a_of_type_ArrayOfByte = bgmj.a(localPhotoSendParams.rawMd5);
      localbece.jdField_a_of_type_JavaLangString = (localPhotoSendParams.rawMd5 + ".jpg");
      localbece.jdField_c_of_type_Int = localPhotoSendParams.rawWidth;
      localbece.jdField_d_of_type_Int = localPhotoSendParams.rawHeight;
      localbece.jdField_a_of_type_Int = 1000;
      localbece.jdField_e_of_type_Int = 3;
      localbece.jdField_b_of_type_JavaLangString = localPhotoSendParams.rawDownloadUrl;
    }
    for (paramBundle = "c2c_pic_up"; TextUtils.isEmpty(paramBundle); paramBundle = "grp_pic_up")
    {
      a("picPreSendProcess protoKey=null!");
      return;
      localbece = new bece();
      localbece.jdField_c_of_type_JavaLangString = str2;
      localbece.jdField_d_of_type_JavaLangString = str1;
      localbece.jdField_e_of_type_JavaLangString = str2;
      localbece.jdField_a_of_type_Long = localPhotoSendParams.fileSize;
      localbece.jdField_a_of_type_ArrayOfByte = bgmj.a(localPhotoSendParams.rawMd5);
      localbece.jdField_a_of_type_JavaLangString = (localPhotoSendParams.rawMd5 + ".jpg");
      localbece.jdField_c_of_type_Int = localPhotoSendParams.rawWidth;
      localbece.jdField_d_of_type_Int = localPhotoSendParams.rawHeight;
      localbece.jdField_a_of_type_Int = 1000;
      localbece.jdField_b_of_type_Int = 1045;
      localbece.f = 1;
      localbece.jdField_e_of_type_Int = 3;
      localbece.jdField_b_of_type_JavaLangString = localPhotoSendParams.rawDownloadUrl;
    }
    localbebv.jdField_a_of_type_JavaUtilList.add(localbece);
    localbebv.jdField_a_of_type_JavaLangString = paramBundle;
    localbebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = paramQQAppInterface.getProtoReqManager();
    localbebv.jdField_a_of_type_Bedc = new ayxk(str2, str1, localPhotoSendParams);
    bedb.a(localbebv);
  }
  
  private static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PicAioQzonePreSendMgr", 2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxj
 * JD-Core Version:    0.7.0.1
 */