import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.io.File;
import java.net.URI;

public class birj
  extends bire<birh>
{
  ImageView a;
  
  private birj(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    paramViewGroup = new RelativeLayout(paramContext);
    paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.a = new ImageView(paramContext);
    this.a.setScaleType(ImageView.ScaleType.FIT_XY);
    paramViewGroup.addView(this.a);
    return paramViewGroup;
  }
  
  public void a(birh parambirh, int paramInt)
  {
    super.a(parambirh, paramInt);
    Object localObject = parambirh.a.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = localObject[0];
      if ((localObject != null) && (((srd)localObject).jdField_a_of_type_Int == 1))
      {
        localObject = ((srd)localObject).jdField_a_of_type_Src;
        if (localObject != null)
        {
          float f = biil.a(this.a.getResources()) / ((src)localObject).d;
          parambirh = new File(parambirh.c, ((src)localObject).jdField_a_of_type_JavaLangString);
          bikl.a().a(this.a, parambirh.toURI().toString(), (int)(((src)localObject).b * f), (int)(((src)localObject).c * f), true);
          parambirh = new RelativeLayout.LayoutParams((int)(((src)localObject).b * f), (int)(((src)localObject).c * f));
          if ((((src)localObject).jdField_a_of_type_Int & 0x1) != 0) {
            parambirh.addRule(9);
          }
          if ((((src)localObject).jdField_a_of_type_Int & 0x2) != 0) {
            parambirh.addRule(10);
          }
          if ((((src)localObject).jdField_a_of_type_Int & 0x4) != 0) {
            parambirh.addRule(11);
          }
          if ((((src)localObject).jdField_a_of_type_Int & 0x8) != 0) {
            parambirh.addRule(12);
          }
          if ((((src)localObject).jdField_a_of_type_Int & 0x10) != 0) {
            parambirh.addRule(14);
          }
          if ((((src)localObject).jdField_a_of_type_Int & 0x20) != 0) {
            parambirh.addRule(15);
          }
          if ((((src)localObject).jdField_a_of_type_Int & 0x40) != 0) {
            parambirh.addRule(13);
          }
          if ((((src)localObject).jdField_a_of_type_ArrayOfInt != null) && (((src)localObject).jdField_a_of_type_ArrayOfInt.length >= 4))
          {
            parambirh.leftMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[0] * f));
            parambirh.topMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[1] * f));
            parambirh.rightMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[2] * f));
            parambirh.bottomMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[3] * f));
          }
          this.a.setLayoutParams(parambirh);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     birj
 * JD-Core Version:    0.7.0.1
 */