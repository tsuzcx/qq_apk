import android.view.View;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class awpw
  implements bhuk
{
  awpw(awpv paramawpv, awoz paramawoz) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
      for (;;)
      {
        this.jdField_a_of_type_Awpv.a.jdField_a_of_type_Bhuf.e();
        return;
        this.jdField_a_of_type_Awpv.a.jdField_a_of_type_Awoy.a(awpv.a(this.jdField_a_of_type_Awpv), this.jdField_a_of_type_Awoz.a);
      }
    }
    paramView = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Awpv.a).get(Long.valueOf(awpv.a(this.jdField_a_of_type_Awpv)));
    if (paramView == null)
    {
      this.jdField_a_of_type_Awpv.a.jdField_a_of_type_Bhuf.e();
      return;
    }
    paramInt = 0;
    label115:
    if (paramInt < paramView.personalityLabelPhotos.size()) {
      if (((PersonalityLabelPhoto)paramView.personalityLabelPhotos.get(paramInt)).uniseq == this.jdField_a_of_type_Awoz.a.uniseq) {
        paramView.personalityLabelPhotos.remove(paramInt);
      }
    }
    for (;;)
    {
      if (paramInt < 0)
      {
        this.jdField_a_of_type_Awpv.a.jdField_a_of_type_Bhuf.e();
        return;
        paramInt += 1;
        break label115;
      }
      paramView.photoCount -= 1;
      PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Awpv.a, awpv.a(this.jdField_a_of_type_Awpv), paramView);
      this.jdField_a_of_type_Awpv.a.jdField_a_of_type_Awoy.b(awpv.a(this.jdField_a_of_type_Awpv), this.jdField_a_of_type_Awoz.a);
      break;
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awpw
 * JD-Core Version:    0.7.0.1
 */