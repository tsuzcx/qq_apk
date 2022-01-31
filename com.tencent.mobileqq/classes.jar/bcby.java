import android.app.Activity;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

final class bcby
  implements bcbw
{
  bcby(NavBarAIO paramNavBarAIO, ImageView paramImageView1, ImageView paramImageView2, boolean paramBoolean, QQAppInterface paramQQAppInterface, String paramString, Activity paramActivity) {}
  
  public void a(List<bccb> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeft(0, 0);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      this.b.setOnTouchListener(null);
      return;
    }
    if (paramList.size() > 1) {
      Collections.sort(paramList, new bcbz(this));
    }
    aupa localaupa = bcbx.a((bccb)paramList.get(0));
    if (paramList.size() > 1)
    {
      paramList = bcbx.a((bccb)paramList.get(1));
      label99:
      bcca localbcca = new bcca(this);
      if (localaupa == null) {
        break label203;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(localaupa);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(localbcca);
      label128:
      if (paramList == null) {
        break label214;
      }
      this.b.setTag(paramList);
      this.b.setOnTouchListener(localbcca);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setTitleIconLeftForMutualMark(localaupa, paramList);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopHonor.utils", 2, "updateAIOTitleTroopHonorInteractiveIcon one:" + localaupa + " two:" + paramList);
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
 * Qualified Name:     bcby
 * JD-Core Version:    0.7.0.1
 */