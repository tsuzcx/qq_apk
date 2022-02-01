import android.view.View;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class aylj
  implements bjoe
{
  aylj(ayli paramayli, aykn paramaykn) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
      for (;;)
      {
        this.jdField_a_of_type_Ayli.a.jdField_a_of_type_Bjnw.e();
        return;
        this.jdField_a_of_type_Ayli.a.jdField_a_of_type_Aykm.a(ayli.a(this.jdField_a_of_type_Ayli), this.jdField_a_of_type_Aykn.a);
      }
    }
    paramView = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Ayli.a).get(Long.valueOf(ayli.a(this.jdField_a_of_type_Ayli)));
    if (paramView == null)
    {
      this.jdField_a_of_type_Ayli.a.jdField_a_of_type_Bjnw.e();
      return;
    }
    paramInt = 0;
    label115:
    if (paramInt < paramView.personalityLabelPhotos.size()) {
      if (((PersonalityLabelPhoto)paramView.personalityLabelPhotos.get(paramInt)).uniseq == this.jdField_a_of_type_Aykn.a.uniseq) {
        paramView.personalityLabelPhotos.remove(paramInt);
      }
    }
    for (;;)
    {
      if (paramInt < 0)
      {
        this.jdField_a_of_type_Ayli.a.jdField_a_of_type_Bjnw.e();
        return;
        paramInt += 1;
        break label115;
      }
      paramView.photoCount -= 1;
      PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Ayli.a, ayli.a(this.jdField_a_of_type_Ayli), paramView);
      this.jdField_a_of_type_Ayli.a.jdField_a_of_type_Aykm.b(ayli.a(this.jdField_a_of_type_Ayli), this.jdField_a_of_type_Aykn.a);
      break;
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aylj
 * JD-Core Version:    0.7.0.1
 */