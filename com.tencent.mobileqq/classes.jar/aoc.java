import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import com.qq.im.poi.LbsPackInfo;
import com.qq.im.poi.LbsStrangerPoiDialog;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader.FaceObserver;
import com.tencent.qphone.base.util.QLog;

public class aoc
  implements NonMainAppHeadLoader.FaceObserver
{
  public aoc(LbsStrangerPoiDialog paramLbsStrangerPoiDialog) {}
  
  public void onFaceUpdate(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramBitmap != null) && (this.a.jdField_a_of_type_ComQqImPoiLbsPackInfo != null) && (paramString1.equals(Long.valueOf(this.a.jdField_a_of_type_ComQqImPoiLbsPackInfo.a))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LbsPack", 2, "LbsStrangerPoiDialog onFaceUpdate uin:" + paramString1);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(101);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aoc
 * JD-Core Version:    0.7.0.1
 */