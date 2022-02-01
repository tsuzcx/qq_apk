import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Transformation;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;

class bgua
  implements bfzz<Integer>
{
  bgua(bgtw parambgtw, View paramView, int paramInt) {}
  
  public void a(bfzt<Integer> parambfzt, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    if (!this.jdField_a_of_type_Bgtw.mUIStyle.mIsAnimating) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewView.getBackground().mutate().setAlpha(paramInteger.intValue());
      this.jdField_a_of_type_Bgtw.mUIStyle.mCurrentAlpha = paramInteger.intValue();
    } while (this.jdField_a_of_type_Bgtw.mUIStyle.mCurrentAlpha != this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bgtw.mUIStyle.mIsAnimating = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgua
 * JD-Core Version:    0.7.0.1
 */