import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class aohl
  implements alqc
{
  public aohl(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "onGetConfig | mDialogType = " + this.a.j + ", isSuccess = " + paramBoolean + ", resultCode = " + paramInt);
    }
    if ((this.a.j == 1) || (this.a.j == 2))
    {
      if (paramBoolean) {
        break label110;
      }
      this.a.a();
      QQToast.a(this.a, 2131691082, 0).b(this.a.getTitleBarHeight());
    }
    label110:
    while (paramInt != 2) {
      return;
    }
    this.a.a();
    this.a.a(this.a.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aohl
 * JD-Core Version:    0.7.0.1
 */