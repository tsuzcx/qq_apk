import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class bagm
  extends CardObserver
{
  public bagm(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void onGetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2 != this.a.d.a()))
    {
      this.a.d.setOnCheckedChangeListener(null);
      this.a.d.setChecked(paramBoolean2);
      this.a.d.setOnCheckedChangeListener(this.a);
    }
  }
  
  public void onImpeach(boolean paramBoolean, String paramString)
  {
    if (!this.a.a.a.equals(paramString)) {
      return;
    }
    this.a.f();
    if (paramBoolean)
    {
      this.a.a(2131690720, 2);
      return;
    }
    this.a.a(2131690718, 1);
  }
  
  public void onSetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2 != this.a.d.a()))
    {
      this.a.d.setOnCheckedChangeListener(null);
      this.a.d.setChecked(paramBoolean2);
      this.a.d.setOnCheckedChangeListener(this.a);
    }
  }
  
  public void onSetDetailInfo(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if (((paramBoolean) && (paramInt == 0)) || ((!paramBoolean) && (paramInt == 34))) {
      return;
    }
    this.a.a(2131694891, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagm
 * JD-Core Version:    0.7.0.1
 */