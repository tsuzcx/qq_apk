import android.view.View;

public class bndz
  implements aama
{
  private float jdField_a_of_type_Float = 0.8F;
  private aalu jdField_a_of_type_Aalu = aalu.a(1);
  private float jdField_b_of_type_Float = 0.2F;
  private aalu jdField_b_of_type_Aalu = aalu.b(1);
  
  public void a(View paramView, float paramFloat)
  {
    this.jdField_a_of_type_Aalu.a(paramView);
    this.jdField_b_of_type_Aalu.a(paramView);
    float f1 = Math.abs(paramFloat);
    float f2 = this.jdField_a_of_type_Float;
    f1 = (1.0F - f1) * this.jdField_b_of_type_Float + f2;
    paramView.setScaleX(f1);
    paramView.setScaleY(f1);
    View localView1 = paramView.findViewById(2131381037);
    View localView2 = paramView.findViewById(2131381051);
    if (localView1 != null) {
      localView1.setAlpha(Math.abs(paramFloat));
    }
    if (localView2 != null) {
      localView2.setAlpha(Math.abs(paramFloat));
    }
    bnrh.a("AECircleScaleTransformer", "position: " + paramFloat + " view: " + paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndz
 * JD-Core Version:    0.7.0.1
 */