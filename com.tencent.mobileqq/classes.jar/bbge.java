import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.qphone.base.util.QLog;

public class bbge
  extends amle
{
  public bbge(TroopBarReplyActivity paramTroopBarReplyActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, BaseActivity paramBaseActivity, bcgo parambcgo)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "onLocationFinish() errCode=" + paramInt);
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      double d1 = paramSosoLbsInfo.a.a;
      double d2 = paramSosoLbsInfo.a.b;
      TroopBarPublishLocationSelectActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (int)(d1 * 1000000.0D), (int)(d2 * 1000000.0D), 0, true, this.jdField_a_of_type_Bcgo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbge
 * JD-Core Version:    0.7.0.1
 */