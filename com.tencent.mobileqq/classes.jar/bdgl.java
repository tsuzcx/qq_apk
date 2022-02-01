import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;

class bdgl
  implements aldq
{
  bdgl(bdgh parambdgh, String paramString, long paramLong, int paramInt) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.GetSoTaskAsync", 2, "[downRFiles] download resCode=" + paramInt + ",pathRes=" + paramPathResult);
    }
    this.jdField_a_of_type_Bdgh.jdField_a_of_type_Int = paramPathResult.subErrCode;
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      bdgh.a(this.jdField_a_of_type_Bdgh, paramPathResult.folderPath, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
      return;
    }
    bdgh.a(this.jdField_a_of_type_Bdgh, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdgl
 * JD-Core Version:    0.7.0.1
 */