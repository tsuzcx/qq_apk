import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.vas.ui.VasPagView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.libpag.PAGView;

final class bibd
  implements Function1<View, Unit>
{
  bibd(String paramString1, String paramString2, bibe parambibe, VasPagView paramVasPagView) {}
  
  private boolean a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    bibb.a(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Bibe.jdField_a_of_type_Int);
    int i = bibb.b(this.jdField_a_of_type_JavaLangString, this.b);
    int j;
    if ((i != this.jdField_a_of_type_Bibe.jdField_a_of_type_Int) || (bibb.c(this.jdField_a_of_type_JavaLangString, this.b) != 0) || ((this.b == "setting") && (bibb.b() != this.jdField_a_of_type_JavaLangString)))
    {
      j = 1;
      if ((j == 0) || (i == -2) || (this.jdField_a_of_type_Bibe.jdField_a_of_type_Int == bibb.b(this.jdField_a_of_type_JavaLangString, "setting")) || (this.jdField_a_of_type_Bibe.jdField_a_of_type_Int == bibb.b(this.jdField_a_of_type_JavaLangString, "card"))) {
        break label429;
      }
      if (this.jdField_a_of_type_Bibe.jdField_a_of_type_Int != i) {
        break label289;
      }
      i = 0;
    }
    for (;;)
    {
      label139:
      String str1 = "nochange";
      if (i == 1) {
        str1 = "up";
      }
      String str2;
      for (;;)
      {
        str2 = bibf.a().a(this.jdField_a_of_type_Bibe.jdField_a_of_type_JavaLangString) + "/qqvalue/level_" + this.jdField_a_of_type_Bibe.b + "/" + str1;
        str1 = str2 + "/qqvalue.pag";
        str2 = str2 + "/number.ttf";
        if ((paramView.getLayoutParams().width > 0) && (j == 0)) {
          break label419;
        }
        if (((PAGView)paramView).getFile() == null) {
          break label322;
        }
        this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView.a();
        return true;
        j = 0;
        break;
        label289:
        if (this.jdField_a_of_type_Bibe.jdField_a_of_type_Int > i)
        {
          i = 1;
          break label139;
        }
        i = -1;
        break label139;
        if (i == -1) {
          str1 = "down";
        }
      }
      label322:
      if (bibb.a((PAGView)paramView, this.jdField_a_of_type_JavaLangString, str2, str1, this.b))
      {
        bibb.c(this.jdField_a_of_type_JavaLangString, this.b, i);
        bibb.b(this.jdField_a_of_type_JavaLangString, this.b, bibb.a(this.jdField_a_of_type_JavaLangString, this.b));
        bibb.jdField_a_of_type_JavaLangString = this.b;
        if (this.b == "setting") {
          bibb.a(this.jdField_a_of_type_JavaLangString);
        }
        paramLayoutParams.width = AIOUtils.dp2px(42.0F, paramView.getResources());
        paramView.postInvalidate();
      }
      for (;;)
      {
        label419:
        return false;
        paramLayoutParams.width = 0;
      }
      label429:
      i = 0;
    }
  }
  
  public Unit a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams == null) {
      return Unit.INSTANCE;
    }
    localLayoutParams.height = AIOUtils.dp2px(15.0F, paramView.getResources());
    if ((paramView instanceof PAGView))
    {
      if (a(paramView, localLayoutParams)) {
        return Unit.INSTANCE;
      }
    }
    else {
      localLayoutParams.width = 0;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bibd
 * JD-Core Version:    0.7.0.1
 */