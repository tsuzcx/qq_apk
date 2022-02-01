import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;

class bcnt
  implements akse
{
  bcnt(bcnp parambcnp, String paramString, long paramLong, int paramInt) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.GetSoTaskAsync", 2, "[downRFiles] download resCode=" + paramInt + ",pathRes=" + paramPathResult);
    }
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      bcnp.a(this.jdField_a_of_type_Bcnp, paramPathResult.folderPath, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
      return;
    }
    bcnp.a(this.jdField_a_of_type_Bcnp, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnt
 * JD-Core Version:    0.7.0.1
 */