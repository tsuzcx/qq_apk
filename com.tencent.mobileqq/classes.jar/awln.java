import android.view.View;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class awln
  implements bhqd
{
  awln(awlm paramawlm, awkq paramawkq) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
      for (;;)
      {
        this.jdField_a_of_type_Awlm.a.jdField_a_of_type_Bhpy.e();
        return;
        this.jdField_a_of_type_Awlm.a.jdField_a_of_type_Awkp.a(awlm.a(this.jdField_a_of_type_Awlm), this.jdField_a_of_type_Awkq.a);
      }
    }
    paramView = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Awlm.a).get(Long.valueOf(awlm.a(this.jdField_a_of_type_Awlm)));
    if (paramView == null)
    {
      this.jdField_a_of_type_Awlm.a.jdField_a_of_type_Bhpy.e();
      return;
    }
    paramInt = 0;
    label115:
    if (paramInt < paramView.personalityLabelPhotos.size()) {
      if (((PersonalityLabelPhoto)paramView.personalityLabelPhotos.get(paramInt)).uniseq == this.jdField_a_of_type_Awkq.a.uniseq) {
        paramView.personalityLabelPhotos.remove(paramInt);
      }
    }
    for (;;)
    {
      if (paramInt < 0)
      {
        this.jdField_a_of_type_Awlm.a.jdField_a_of_type_Bhpy.e();
        return;
        paramInt += 1;
        break label115;
      }
      paramView.photoCount -= 1;
      PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Awlm.a, awlm.a(this.jdField_a_of_type_Awlm), paramView);
      this.jdField_a_of_type_Awlm.a.jdField_a_of_type_Awkp.b(awlm.a(this.jdField_a_of_type_Awlm), this.jdField_a_of_type_Awkq.a);
      break;
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awln
 * JD-Core Version:    0.7.0.1
 */