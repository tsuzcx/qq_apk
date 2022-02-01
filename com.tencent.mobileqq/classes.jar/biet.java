import android.view.View;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

class biet
  implements TouchWebView.OnScrollChangedListener
{
  int jdField_a_of_type_Int = 0;
  
  biet(bieo parambieo) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, "-->onScrollChanged:" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4);
    }
    if (ImmersiveUtils.isSupporImmersive() == 1) {}
    for (paramInt1 = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());; paramInt1 = 0)
    {
      paramInt1 = paramInt1 + DisplayUtil.dip2px(BaseApplicationImpl.getApplication(), 50.0F) + 180;
      if (Math.abs(paramInt2 - this.jdField_a_of_type_Int) > 20) {
        if (paramInt2 < paramInt1 / 3) {
          this.jdField_a_of_type_Bieo.mUIStyle.needTitlebarTranslucent = true;
        }
      }
      while (paramInt2 >= paramInt1 / 3) {
        for (;;)
        {
          this.jdField_a_of_type_Int = paramInt2;
          this.jdField_a_of_type_Bieo.updateTitleBarUI();
          return;
          if (paramInt2 >= paramInt1) {
            this.jdField_a_of_type_Bieo.mUIStyle.needTitlebarTranslucent = false;
          }
        }
      }
      this.jdField_a_of_type_Bieo.mUIStyle.needTitlebarTranslucent = true;
      this.jdField_a_of_type_Int = paramInt2;
      this.jdField_a_of_type_Bieo.updateTitleBarUI();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biet
 * JD-Core Version:    0.7.0.1
 */