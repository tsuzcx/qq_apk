import android.view.View;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class atwb
  implements begw
{
  atwb(atwa paramatwa, atve paramatve) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
      for (;;)
      {
        this.jdField_a_of_type_Atwa.a.jdField_a_of_type_Begr.e();
        return;
        this.jdField_a_of_type_Atwa.a.jdField_a_of_type_Atvd.a(atwa.a(this.jdField_a_of_type_Atwa), this.jdField_a_of_type_Atve.a);
      }
    }
    paramView = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Atwa.a).get(Long.valueOf(atwa.a(this.jdField_a_of_type_Atwa)));
    if (paramView == null)
    {
      this.jdField_a_of_type_Atwa.a.jdField_a_of_type_Begr.e();
      return;
    }
    paramInt = 0;
    label115:
    if (paramInt < paramView.personalityLabelPhotos.size()) {
      if (((PersonalityLabelPhoto)paramView.personalityLabelPhotos.get(paramInt)).uniseq == this.jdField_a_of_type_Atve.a.uniseq) {
        paramView.personalityLabelPhotos.remove(paramInt);
      }
    }
    for (;;)
    {
      if (paramInt < 0)
      {
        this.jdField_a_of_type_Atwa.a.jdField_a_of_type_Begr.e();
        return;
        paramInt += 1;
        break label115;
      }
      paramView.photoCount -= 1;
      PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Atwa.a, atwa.a(this.jdField_a_of_type_Atwa), paramView);
      this.jdField_a_of_type_Atwa.a.jdField_a_of_type_Atvd.b(atwa.a(this.jdField_a_of_type_Atwa), this.jdField_a_of_type_Atve.a);
      break;
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atwb
 * JD-Core Version:    0.7.0.1
 */