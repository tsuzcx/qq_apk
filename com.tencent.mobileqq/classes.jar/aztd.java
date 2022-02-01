import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.profile.lifeachivement.LifeAchivementPanelView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class aztd
  implements azsw
{
  public aztd(LifeAchivementPanelView paramLifeAchivementPanelView) {}
  
  public void a(View paramView, int paramInt)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("LifeAchivementPanelView", 2, "onClickAchivement position = " + paramInt);
    }
    paramView = this.a.jdField_a_of_type_Azsr.a(paramInt);
    if (paramView != null)
    {
      if (paramView.jdField_a_of_type_Int == 2)
      {
        azsy.a(LifeAchivementPanelView.c(this.a), this.a.jdField_a_of_type_JavaLangString);
        if (LifeAchivementPanelView.a(this.a)) {
          i = 1;
        }
        bdla.b(null, "", "", "", "0X800AE59", "0X800AE59", i, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    if (paramView.jdField_a_of_type_Int == 1)
    {
      azsy.a(LifeAchivementPanelView.d(this.a));
      bdla.b(null, "", "", "", "0X800AE54", "0X800AE54", 2, 0, "", "", "", "");
      return;
    }
    azsy.a(LifeAchivementPanelView.e(this.a), this.a.jdField_a_of_type_JavaLangString, paramView.b);
    if (LifeAchivementPanelView.a(this.a)) {
      i = 1;
    }
    bdla.b(null, "", "", "", "0X800AE58", "0X800AE58", i, 0, "", "", "", "");
  }
  
  public void b(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LifeAchivementPanelView", 2, "onClickPraise position = " + paramInt + ",isSelf = " + LifeAchivementPanelView.a(this.a) + ",isFriend = " + LifeAchivementPanelView.b(this.a));
    }
    azsy.a(paramView);
    if ((!LifeAchivementPanelView.a(this.a)) && (!LifeAchivementPanelView.b(this.a))) {
      QQToast.a(LifeAchivementPanelView.f(this.a), paramView.getResources().getString(2131698601), 0).a();
    }
    do
    {
      return;
      paramView = this.a.jdField_a_of_type_Azsr.a(paramInt);
      if (paramView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("LifeAchivementPanelView", 2, "onClickPraise return for null data");
    return;
    if (paramView.jdField_a_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      LifeAchivementPanelView.a(this.a, paramView, paramInt, i);
      if (this.a.jdField_a_of_type_Anri != null) {
        this.a.jdField_a_of_type_Anri.a(this.a.jdField_a_of_type_Long, paramView.b, i);
      }
      if (LifeAchivementPanelView.a(this.a)) {}
      for (paramInt = 1;; paramInt = 2)
      {
        bdla.b(null, "", "", "", "0X800AE56", "0X800AE56", paramInt, 0, "", "", "", "");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aztd
 * JD-Core Version:    0.7.0.1
 */