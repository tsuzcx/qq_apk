import android.os.Handler;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent;
import com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent.ColorScreenLoader;
import com.tencent.qphone.base.util.QLog;

public class bagc
  implements OnCompositionLoadedListener
{
  public bagc(ProfileColorScreenComponent.ColorScreenLoader paramColorScreenLoader) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if ((QLog.isColorLevel()) || (paramLottieComposition == null)) {
      QLog.d("ColorScreenManager", 1, "onCompositionLoaded: composition= " + paramLottieComposition);
    }
    if (paramLottieComposition == null)
    {
      biaa.a(ProfileColorScreenComponent.a(this.a.this$0), "individual_v2_colorscreen_parse_fail", "0", "", Integer.toString(ProfileColorScreenComponent.ColorScreenLoader.a(this.a)), null, null, 0.0F, 0.0F);
      bhzz.a("individual_v2_colorscreen_parse_fail", "id:" + ProfileColorScreenComponent.ColorScreenLoader.a(this.a));
    }
    do
    {
      return;
      ProfileColorScreenComponent.ColorScreenLoader.a(this.a, paramLottieComposition);
    } while (ProfileColorScreenComponent.a(this.a.this$0) == null);
    ProfileColorScreenComponent.a(this.a.this$0).postDelayed(this.a, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagc
 * JD-Core Version:    0.7.0.1
 */