import android.view.View;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class azeh
  implements bkhw
{
  azeh(azeg paramazeg, azdl paramazdl) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
      for (;;)
      {
        this.jdField_a_of_type_Azeg.a.jdField_a_of_type_Bkho.e();
        return;
        this.jdField_a_of_type_Azeg.a.jdField_a_of_type_Azdk.a(azeg.a(this.jdField_a_of_type_Azeg), this.jdField_a_of_type_Azdl.a);
      }
    }
    paramView = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Azeg.a).get(Long.valueOf(azeg.a(this.jdField_a_of_type_Azeg)));
    if (paramView == null)
    {
      this.jdField_a_of_type_Azeg.a.jdField_a_of_type_Bkho.e();
      return;
    }
    paramInt = 0;
    label115:
    if (paramInt < paramView.personalityLabelPhotos.size()) {
      if (((PersonalityLabelPhoto)paramView.personalityLabelPhotos.get(paramInt)).uniseq == this.jdField_a_of_type_Azdl.a.uniseq) {
        paramView.personalityLabelPhotos.remove(paramInt);
      }
    }
    for (;;)
    {
      if (paramInt < 0)
      {
        this.jdField_a_of_type_Azeg.a.jdField_a_of_type_Bkho.e();
        return;
        paramInt += 1;
        break label115;
      }
      paramView.photoCount -= 1;
      PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Azeg.a, azeg.a(this.jdField_a_of_type_Azeg), paramView);
      this.jdField_a_of_type_Azeg.a.jdField_a_of_type_Azdk.b(azeg.a(this.jdField_a_of_type_Azeg), this.jdField_a_of_type_Azdl.a);
      break;
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azeh
 * JD-Core Version:    0.7.0.1
 */