import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin.3.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class baof
  implements bdts
{
  baof(baoc parambaoc) {}
  
  public void onCompleted(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = bdwl.a.getDir(paramQQAppInterface.getApp().getApplicationContext(), paramString1);
      if ((!TextUtils.isEmpty(paramQQAppInterface)) && (baoc.a(this.a) != null))
      {
        baoc.a(this.a, true);
        this.a.a(paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.i("FloatViewSkin", 2, "onCompleted: mSkinRootPath" + this.a.jdField_a_of_type_JavaLangString);
        }
        if (this.a.jdField_a_of_type_Boolean) {
          ThreadManagerV2.getUIHandlerV2().post(new FloatViewSkin.3.1(this));
        }
      }
    }
  }
  
  public void onProgress(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baof
 * JD-Core Version:    0.7.0.1
 */