import android.app.Activity;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

final class bcgh
  implements bcgf
{
  bcgh(NavBarAIO paramNavBarAIO, ImageView paramImageView1, ImageView paramImageView2, boolean paramBoolean, QQAppInterface paramQQAppInterface, String paramString, Activity paramActivity) {}
  
  public void a(List<bcgk> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeft(0, 0);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      this.b.setOnTouchListener(null);
      return;
    }
    if (paramList.size() > 1) {
      Collections.sort(paramList, new bcgi(this));
    }
    autj localautj = bcgg.a((bcgk)paramList.get(0));
    if (paramList.size() > 1)
    {
      paramList = bcgg.a((bcgk)paramList.get(1));
      label99:
      bcgj localbcgj = new bcgj(this);
      if (localautj == null) {
        break label203;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(localautj);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(localbcgj);
      label128:
      if (paramList == null) {
        break label214;
      }
      this.b.setTag(paramList);
      this.b.setOnTouchListener(localbcgj);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeftForMutualMark(localautj, paramList);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopHonor.utils", 2, "updateAIOTitleTroopHonorInteractiveIcon one:" + localautj + " two:" + paramList);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcgh
 * JD-Core Version:    0.7.0.1
 */