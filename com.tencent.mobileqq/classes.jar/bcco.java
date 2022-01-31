import android.view.View;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

class bcco
  implements TouchWebView.OnScrollChangedListener
{
  int jdField_a_of_type_Int = 0;
  
  bcco(bccj parambccj) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, "-->onScrollChanged:" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4);
    }
    if (ImmersiveUtils.isSupporImmersive() == 1) {}
    for (paramInt1 = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());; paramInt1 = 0)
    {
      paramInt1 = paramInt1 + baxn.a(BaseApplicationImpl.getApplication(), 50.0F) + 180;
      if (Math.abs(paramInt2 - this.jdField_a_of_type_Int) > 20) {
        if (paramInt2 < paramInt1 / 3) {
          this.jdField_a_of_type_Bccj.a.t = true;
        }
      }
      while (paramInt2 >= paramInt1 / 3) {
        for (;;)
        {
          this.jdField_a_of_type_Int = paramInt2;
          this.jdField_a_of_type_Bccj.g();
          return;
          if (paramInt2 >= paramInt1) {
            this.jdField_a_of_type_Bccj.a.t = false;
          }
        }
      }
      this.jdField_a_of_type_Bccj.a.t = true;
      this.jdField_a_of_type_Int = paramInt2;
      this.jdField_a_of_type_Bccj.g();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcco
 * JD-Core Version:    0.7.0.1
 */