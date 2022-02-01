import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import androidx.core.util.Pools.Pool;
import com.tencent.mobileqq.gamecenter.media.DanmakuLayout;
import com.tencent.mobileqq.text.QQText;

public class avdg
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = -1L;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  avde jdField_a_of_type_Avde;
  boolean jdField_a_of_type_Boolean = true;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long;
  float c;
  public int c;
  
  private avdg(DanmakuLayout paramDanmakuLayout)
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramDanmakuLayout.getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
  }
  
  private long a(float paramFloat)
  {
    if (paramFloat < 40.0F) {
      return 4000L;
    }
    if (paramFloat <= 50.0F) {
      return 4500L;
    }
    if (paramFloat <= 130.0F) {
      return 5000L;
    }
    return 6000L;
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_Float == 0.0F)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(new QQText(this.jdField_a_of_type_Avde.jdField_a_of_type_JavaLangString, 3, 16, -1));
      this.jdField_a_of_type_AndroidWidgetTextView.measure(0, 0);
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
      this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredHeight();
      this.jdField_c_of_type_Float = (this.jdField_b_of_type_Int + DanmakuLayout.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaDanmakuLayout));
      if (this.jdField_a_of_type_Avde.jdField_b_of_type_Double != 0.0D) {
        break label122;
      }
    }
    label122:
    for (this.jdField_b_of_type_Long = a(this.jdField_b_of_type_Int);; this.jdField_b_of_type_Long = ((this.jdField_a_of_type_Avde.jdField_b_of_type_Double * 1000.0D)))
    {
      this.jdField_b_of_type_Float = (this.jdField_c_of_type_Float / (float)this.jdField_b_of_type_Long);
      return;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Avde = null;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    if (this.jdField_a_of_type_AndroidWidgetTextView.getParent() != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaDanmakuLayout.removeView(this.jdField_a_of_type_AndroidWidgetTextView);
    }
    DanmakuLayout.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaDanmakuLayout).release(this);
  }
  
  public void a(avde paramavde)
  {
    this.jdField_a_of_type_Avde = paramavde;
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, DanmakuLayout.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaDanmakuLayout));
    if (this.jdField_a_of_type_Avde.jdField_b_of_type_Int != 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(this.jdField_a_of_type_Avde.jdField_b_of_type_Int);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Avde.jdField_a_of_type_Int);
  }
  
  boolean a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Long == -1L) {
      this.jdField_a_of_type_Long = paramLong;
    }
    b();
    float f;
    int i;
    if (this.jdField_b_of_type_Long != 0L)
    {
      f = (float)(paramLong - this.jdField_a_of_type_Long) / (float)this.jdField_b_of_type_Long;
      if (f < 1.0F) {
        break label158;
      }
      i = 1;
      label54:
      if (i != 0) {
        break label164;
      }
    }
    label158:
    label164:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Float = (Math.max(Math.min(f, 1.0F), 0.0F) * this.jdField_c_of_type_Float);
      this.jdField_a_of_type_Int = ((int)(DanmakuLayout.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaDanmakuLayout) - this.jdField_a_of_type_Float));
      this.jdField_a_of_type_AndroidWidgetTextView.layout(this.jdField_a_of_type_Int, paramInt, this.jdField_a_of_type_Int + this.jdField_b_of_type_Int, this.jdField_c_of_type_Int + paramInt);
      return this.jdField_a_of_type_Boolean;
      if (paramLong < this.jdField_a_of_type_Long) {}
      for (f = 0.0F;; f = 1.0F) {
        break;
      }
      i = 0;
      break label54;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdg
 * JD-Core Version:    0.7.0.1
 */