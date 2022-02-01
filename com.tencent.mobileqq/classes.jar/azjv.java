import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class azjv
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  
  public azjv(QzonePhotoView paramQzonePhotoView) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_a_of_type_Long) < 1000L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Long = l;
      if ((paramView != null) && ((paramView.getTag() instanceof azde)))
      {
        Object localObject = (azde)paramView.getTag();
        if (localObject != null)
        {
          int i = ((azde)localObject).a;
          localObject = QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView).a.a;
          switch (i)
          {
          default: 
            break;
          case 25: 
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.a, "CliOper", "", "", "card_mall", "0X80066C4", 0, 0, "2", "", "", "");
            if (QLog.isColorLevel()) {
              QLog.i("ProfileCard.QzonePhotoView", 2, "View.OnClickListener click type is photo wall view");
            }
            QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView, QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjv
 * JD-Core Version:    0.7.0.1
 */