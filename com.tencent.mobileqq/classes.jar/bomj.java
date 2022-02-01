import android.view.View;

public class bomj
  implements abab
{
  private float jdField_a_of_type_Float = 0.8F;
  private aazv jdField_a_of_type_Aazv = aazv.a(1);
  private float jdField_b_of_type_Float = 0.2F;
  private aazv jdField_b_of_type_Aazv = aazv.b(1);
  
  public void a(View paramView, float paramFloat)
  {
    this.jdField_a_of_type_Aazv.a(paramView);
    this.jdField_b_of_type_Aazv.a(paramView);
    float f1 = Math.abs(paramFloat);
    float f2 = this.jdField_a_of_type_Float;
    f1 = (1.0F - f1) * this.jdField_b_of_type_Float + f2;
    paramView.setScaleX(f1);
    paramView.setScaleY(f1);
    View localView1 = paramView.findViewById(2131380959);
    View localView2 = paramView.findViewById(2131380973);
    if (localView1 != null) {
      localView1.setAlpha(Math.abs(paramFloat));
    }
    if (localView2 != null) {
      localView2.setAlpha(Math.abs(paramFloat));
    }
    bpam.a("AECircleScaleTransformer", "position: " + paramFloat + " view: " + paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bomj
 * JD-Core Version:    0.7.0.1
 */