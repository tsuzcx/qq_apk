import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.widget.ScrollView;
import java.lang.ref.WeakReference;

class biai
  implements View.OnLayoutChangeListener
{
  final int jdField_a_of_type_Int;
  final WeakReference<ScrollView> jdField_a_of_type_JavaLangRefWeakReference;
  
  private biai(ScrollView paramScrollView, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramScrollView);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    ScrollView localScrollView = (ScrollView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localScrollView != null) && (paramInt4 - paramInt2 > paramInt8 - paramInt6))
    {
      localScrollView.smoothScrollTo(0, this.jdField_a_of_type_Int);
      paramView.removeOnLayoutChangeListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biai
 * JD-Core Version:    0.7.0.1
 */