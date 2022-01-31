import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.multicard.MultiCardCustomLayout;
import com.tencent.mobileqq.multicard.MultiCardFragment;
import com.tencent.mobileqq.multicard.MultiCardRootLayout;

public class auje
{
  public float a;
  public int a;
  public ViewGroup.LayoutParams a;
  public auip a;
  public MultiCardCustomLayout a;
  public MultiCardRootLayout a;
  public float b;
  public int b;
  public int c;
  
  public auje(MultiCardFragment paramMultiCardFragment, MultiCardRootLayout paramMultiCardRootLayout, MultiCardCustomLayout paramMultiCardCustomLayout, auip paramauip, auir paramauir)
  {
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout = paramMultiCardRootLayout;
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout = paramMultiCardCustomLayout;
    this.jdField_a_of_type_Auip = paramauip;
    if (this.jdField_a_of_type_Auip != null) {
      this.jdField_a_of_type_Auip.a(paramauir);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.a(false);
      this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getScaleX();
      this.jdField_b_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getScaleY();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.getLayoutParams();
      Object localObject = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.getLocationOnScreen((int[])localObject);
      this.jdField_b_of_type_Int = localObject[0];
      this.c = localObject[1];
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.a(true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.findViewById(2131370849);
      if (localObject != null)
      {
        this.jdField_a_of_type_Int = ((View)localObject).getVisibility();
        ((View)localObject).setVisibility(8);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout != null)) {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout);
    }
    if (this.jdField_a_of_type_Auip != null) {
      this.jdField_a_of_type_Auip.b(0);
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != null))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout);
      }
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.a(false);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setScaleX(1.0F);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout.setScaleY(1.0F);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.a(true);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.addView(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomLayout, 0);
    }
    if (this.jdField_a_of_type_Auip != null) {
      this.jdField_a_of_type_Auip.b(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auje
 * JD-Core Version:    0.7.0.1
 */