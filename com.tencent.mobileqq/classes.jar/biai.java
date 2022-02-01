import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class biai
  implements View.OnClickListener
{
  private final WeakReference<ProfileCardMoreInfoView> a;
  
  public biai(ProfileCardMoreInfoView paramProfileCardMoreInfoView)
  {
    this.a = new WeakReference(paramProfileCardMoreInfoView);
  }
  
  public void onClick(View paramView)
  {
    int j = 2;
    Object localObject1 = (ProfileCardMoreInfoView)this.a.get();
    if (localObject1 == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      BaseActivity localBaseActivity = ((ProfileCardMoreInfoView)localObject1).jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      QQAppInterface localQQAppInterface = ((ProfileCardMoreInfoView)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject1 = ((ProfileCardMoreInfoView)localObject1).jdField_a_of_type_Azfe;
      if ((localBaseActivity == null) || (localQQAppInterface == null) || (localObject1 != null))
      {
        Object localObject2 = paramView.getTag();
        if ((localObject2 instanceof azde)) {
          switch (((azde)localObject2).a)
          {
          default: 
            break;
          case 66: 
            bghy.a((azfe)localObject1, localQQAppInterface, localBaseActivity);
            int i = j;
            if (((azfe)localObject1).a != null)
            {
              i = j;
              if (((azfe)localObject1).a.a == 0) {
                i = 1;
              }
            }
            bcst.b(localQQAppInterface, "dc00898", "", "", "0X8009999", "0X8009999", i, 0, "", "", "", "");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biai
 * JD-Core Version:    0.7.0.1
 */