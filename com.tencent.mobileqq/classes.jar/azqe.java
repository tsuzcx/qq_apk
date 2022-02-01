import android.view.View;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class azqe
  implements bkzq
{
  azqe(azqd paramazqd, azpi paramazpi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
      for (;;)
      {
        this.jdField_a_of_type_Azqd.a.jdField_a_of_type_Bkzi.e();
        return;
        this.jdField_a_of_type_Azqd.a.jdField_a_of_type_Azph.a(azqd.a(this.jdField_a_of_type_Azqd), this.jdField_a_of_type_Azpi.a);
      }
    }
    paramView = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Azqd.a).get(Long.valueOf(azqd.a(this.jdField_a_of_type_Azqd)));
    if (paramView == null)
    {
      this.jdField_a_of_type_Azqd.a.jdField_a_of_type_Bkzi.e();
      return;
    }
    paramInt = 0;
    label115:
    if (paramInt < paramView.personalityLabelPhotos.size()) {
      if (((PersonalityLabelPhoto)paramView.personalityLabelPhotos.get(paramInt)).uniseq == this.jdField_a_of_type_Azpi.a.uniseq) {
        paramView.personalityLabelPhotos.remove(paramInt);
      }
    }
    for (;;)
    {
      if (paramInt < 0)
      {
        this.jdField_a_of_type_Azqd.a.jdField_a_of_type_Bkzi.e();
        return;
        paramInt += 1;
        break label115;
      }
      paramView.photoCount -= 1;
      PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Azqd.a, azqd.a(this.jdField_a_of_type_Azqd), paramView);
      this.jdField_a_of_type_Azqd.a.jdField_a_of_type_Azph.b(azqd.a(this.jdField_a_of_type_Azqd), this.jdField_a_of_type_Azpi.a);
      break;
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azqe
 * JD-Core Version:    0.7.0.1
 */