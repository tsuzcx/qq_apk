import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class baky
  extends anuw
{
  public baky(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  protected void onGetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2 != this.a.d.a()))
    {
      this.a.d.setOnCheckedChangeListener(null);
      this.a.d.setChecked(paramBoolean2);
      this.a.d.setOnCheckedChangeListener(this.a);
    }
  }
  
  protected void onImpeach(boolean paramBoolean, String paramString)
  {
    if (!this.a.a.a.equals(paramString)) {
      return;
    }
    this.a.f();
    if (paramBoolean)
    {
      this.a.a(2131690603, 2);
      return;
    }
    this.a.a(2131690601, 1);
  }
  
  protected void onSetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2 != this.a.d.a()))
    {
      this.a.d.setOnCheckedChangeListener(null);
      this.a.d.setChecked(paramBoolean2);
      this.a.d.setOnCheckedChangeListener(this.a);
    }
  }
  
  protected void onSetDetailInfo(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if (((paramBoolean) && (paramInt == 0)) || ((!paramBoolean) && (paramInt == 34))) {
      return;
    }
    this.a.a(2131694572, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baky
 * JD-Core Version:    0.7.0.1
 */