import android.view.View;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class auub
  implements bfph
{
  auub(auua paramauua, aute paramaute) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
      for (;;)
      {
        this.jdField_a_of_type_Auua.a.jdField_a_of_type_Bfpc.e();
        return;
        this.jdField_a_of_type_Auua.a.jdField_a_of_type_Autd.a(auua.a(this.jdField_a_of_type_Auua), this.jdField_a_of_type_Aute.a);
      }
    }
    paramView = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Auua.a).get(Long.valueOf(auua.a(this.jdField_a_of_type_Auua)));
    if (paramView == null)
    {
      this.jdField_a_of_type_Auua.a.jdField_a_of_type_Bfpc.e();
      return;
    }
    paramInt = 0;
    label115:
    if (paramInt < paramView.personalityLabelPhotos.size()) {
      if (((PersonalityLabelPhoto)paramView.personalityLabelPhotos.get(paramInt)).uniseq == this.jdField_a_of_type_Aute.a.uniseq) {
        paramView.personalityLabelPhotos.remove(paramInt);
      }
    }
    for (;;)
    {
      if (paramInt < 0)
      {
        this.jdField_a_of_type_Auua.a.jdField_a_of_type_Bfpc.e();
        return;
        paramInt += 1;
        break label115;
      }
      paramView.photoCount -= 1;
      PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Auua.a, auua.a(this.jdField_a_of_type_Auua), paramView);
      this.jdField_a_of_type_Auua.a.jdField_a_of_type_Autd.b(auua.a(this.jdField_a_of_type_Auua), this.jdField_a_of_type_Aute.a);
      break;
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auub
 * JD-Core Version:    0.7.0.1
 */