import android.app.Activity;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

final class bggo
  implements bggm
{
  bggo(NavBarAIO paramNavBarAIO, ImageView paramImageView1, ImageView paramImageView2, boolean paramBoolean, QQAppInterface paramQQAppInterface, String paramString, Activity paramActivity) {}
  
  public void a(List<bggs> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeft(0, 0);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      this.b.setOnTouchListener(null);
      return;
    }
    if (paramList.size() > 1) {
      Collections.sort(paramList, new bggp(this));
    }
    axtj localaxtj = bggn.a((bggs)paramList.get(0));
    if (paramList.size() > 1)
    {
      paramList = bggn.a((bggs)paramList.get(1));
      label99:
      bggq localbggq = new bggq(this);
      if (localaxtj == null) {
        break label203;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(localaxtj);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(localbggq);
      label128:
      if (paramList == null) {
        break label214;
      }
      this.b.setTag(paramList);
      this.b.setOnTouchListener(localbggq);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeftForMutualMark(localaxtj, paramList);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopHonor.utils", 2, "updateAIOTitleTroopHonorInteractiveIcon one:" + localaxtj + " two:" + paramList);
      return;
      paramList = null;
      break label99;
      label203:
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      break label128;
      label214:
      this.b.setOnTouchListener(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggo
 * JD-Core Version:    0.7.0.1
 */