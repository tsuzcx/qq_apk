import android.view.View;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class autz
  implements bfoq
{
  autz(auty paramauty, autc paramautc) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
      for (;;)
      {
        this.jdField_a_of_type_Auty.a.jdField_a_of_type_Bfol.e();
        return;
        this.jdField_a_of_type_Auty.a.jdField_a_of_type_Autb.a(auty.a(this.jdField_a_of_type_Auty), this.jdField_a_of_type_Autc.a);
      }
    }
    paramView = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Auty.a).get(Long.valueOf(auty.a(this.jdField_a_of_type_Auty)));
    if (paramView == null)
    {
      this.jdField_a_of_type_Auty.a.jdField_a_of_type_Bfol.e();
      return;
    }
    paramInt = 0;
    label115:
    if (paramInt < paramView.personalityLabelPhotos.size()) {
      if (((PersonalityLabelPhoto)paramView.personalityLabelPhotos.get(paramInt)).uniseq == this.jdField_a_of_type_Autc.a.uniseq) {
        paramView.personalityLabelPhotos.remove(paramInt);
      }
    }
    for (;;)
    {
      if (paramInt < 0)
      {
        this.jdField_a_of_type_Auty.a.jdField_a_of_type_Bfol.e();
        return;
        paramInt += 1;
        break label115;
      }
      paramView.photoCount -= 1;
      PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Auty.a, auty.a(this.jdField_a_of_type_Auty), paramView);
      this.jdField_a_of_type_Auty.a.jdField_a_of_type_Autb.b(auty.a(this.jdField_a_of_type_Auty), this.jdField_a_of_type_Autc.a);
      break;
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     autz
 * JD-Core Version:    0.7.0.1
 */