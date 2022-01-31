import ProfileLogic.QC.setUserProfileRsp;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.profile.CoverDetailFragment;

public class ausm
  extends akfy
{
  public ausm(CoverDetailFragment paramCoverDetailFragment) {}
  
  public void e(boolean paramBoolean, Object paramObject)
  {
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if (localFragmentActivity == null) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while (!(paramObject instanceof setUserProfileRsp));
      int i = ((setUserProfileRsp)paramObject).ret;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard.CoverDetailFragment", 0, "onDefaultCardRsp: [setUserProfileRsp] ret=" + i);
      }
      if (i == 0)
      {
        paramObject = new Intent();
        paramObject.putExtra("cover_id_key", CoverDetailFragment.a(this.a));
        localFragmentActivity.setResult(-1, paramObject);
        localFragmentActivity.finish();
        return;
      }
      CoverDetailFragment.a(this.a, localFragmentActivity);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard.CoverDetailFragment", 0, "onDefaultCardRsp: isSuccess=false, cmd=" + paramObject);
      }
    } while (!"profilelogic.setUserProfile".equals(paramObject));
    CoverDetailFragment.a(this.a, localFragmentActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ausm
 * JD-Core Version:    0.7.0.1
 */