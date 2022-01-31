import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import mqq.util.WeakReference;

class anvv
  extends VasQuickUpdateManager.CallBacker
{
  anvv(anvu paramanvu) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    paramString2 = (QQAppInterface)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
    if (paramString2 == null) {}
    while (!"emoji_app_vip_emoji_aio_android_config.json".equals(paramString1)) {
      return;
    }
    ((VasQuickUpdateManager)paramString2.getManager(184)).removeCallBacker(this.a.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    paramString1 = VasQuickUpdateManager.getJSONFromLocal(paramString2, "emoji_app_vip_emoji_aio_android_config.json", false, null);
    this.a.a(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anvv
 * JD-Core Version:    0.7.0.1
 */