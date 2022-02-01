import android.view.View;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class azwu
  implements bliz
{
  azwu(azwt paramazwt, azvy paramazvy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
      for (;;)
      {
        this.jdField_a_of_type_Azwt.a.jdField_a_of_type_Blir.e();
        return;
        this.jdField_a_of_type_Azwt.a.jdField_a_of_type_Azvx.a(azwt.a(this.jdField_a_of_type_Azwt), this.jdField_a_of_type_Azvy.a);
      }
    }
    paramView = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Azwt.a).get(Long.valueOf(azwt.a(this.jdField_a_of_type_Azwt)));
    if (paramView == null)
    {
      this.jdField_a_of_type_Azwt.a.jdField_a_of_type_Blir.e();
      return;
    }
    paramInt = 0;
    label115:
    if (paramInt < paramView.personalityLabelPhotos.size()) {
      if (((PersonalityLabelPhoto)paramView.personalityLabelPhotos.get(paramInt)).uniseq == this.jdField_a_of_type_Azvy.a.uniseq) {
        paramView.personalityLabelPhotos.remove(paramInt);
      }
    }
    for (;;)
    {
      if (paramInt < 0)
      {
        this.jdField_a_of_type_Azwt.a.jdField_a_of_type_Blir.e();
        return;
        paramInt += 1;
        break label115;
      }
      paramView.photoCount -= 1;
      PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Azwt.a, azwt.a(this.jdField_a_of_type_Azwt), paramView);
      this.jdField_a_of_type_Azwt.a.jdField_a_of_type_Azvx.b(azwt.a(this.jdField_a_of_type_Azwt), this.jdField_a_of_type_Azvy.a);
      break;
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azwu
 * JD-Core Version:    0.7.0.1
 */