import android.view.View;

public class blqq
  implements zwo
{
  private float jdField_a_of_type_Float = 0.8F;
  private zwi jdField_a_of_type_Zwi = zwi.a(1);
  private float jdField_b_of_type_Float = 0.2F;
  private zwi jdField_b_of_type_Zwi = zwi.b(1);
  
  public void a(View paramView, float paramFloat)
  {
    this.jdField_a_of_type_Zwi.a(paramView);
    this.jdField_b_of_type_Zwi.a(paramView);
    float f1 = Math.abs(paramFloat);
    float f2 = this.jdField_a_of_type_Float;
    f1 = (1.0F - f1) * this.jdField_b_of_type_Float + f2;
    paramView.setScaleX(f1);
    paramView.setScaleY(f1);
    View localView1 = paramView.findViewById(2131380685);
    View localView2 = paramView.findViewById(2131380699);
    if (localView1 != null) {
      localView1.setAlpha(Math.abs(paramFloat));
    }
    if (localView2 != null) {
      localView2.setAlpha(Math.abs(paramFloat));
    }
    bmbx.a("AECircleScaleTransformer", "position: " + paramFloat + " view: " + paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqq
 * JD-Core Version:    0.7.0.1
 */