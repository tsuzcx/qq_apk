import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.troopgift.TroopGiftActionButton;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.3;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.5;
import com.tencent.qphone.base.util.QLog;

public class barx
{
  public int a;
  protected SoundPool a;
  public Handler a;
  public ViewGroup a;
  public TroopChatPie a;
  protected MessageForDeliverGiftTips a;
  public SpriteVideoView a;
  public TroopGiftActionButton a;
  public boolean a;
  protected int b;
  
  public barx()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(5, 3, 0);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TroopInteractGiftAnimationController", 2, QLog.getStackTraceString(localUnsatisfiedLinkError));
      return;
    }
    catch (ExceptionInInitializerError localExceptionInInitializerError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TroopInteractGiftAnimationController", 2, QLog.getStackTraceString(localExceptionInInitializerError));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TroopInteractGiftAnimationController", 2, QLog.getStackTraceString(localException));
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopInteractGiftAnimationController", 2, "TroopInteractGiftAnimationController: dismissAnimation" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactId);
      }
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.n();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new TroopInteractGiftAnimationController.5(this));
    } while (this.jdField_a_of_type_AndroidMediaSoundPool == null);
    this.jdField_a_of_type_AndroidMediaSoundPool.unload(this.b);
  }
  
  public void a(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.c.findViewById(2131364076));
  }
  
  public void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) {
      ((bakt)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(113)).a(paramMessageForDeliverGiftTips.frienduin, paramMessageForDeliverGiftTips.interactId, paramMessageForDeliverGiftTips.animationPackageId, new basl(this, paramMessageForDeliverGiftTips));
    }
  }
  
  public void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips, long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopInteractGiftAnimationController.3(this, paramMessageForDeliverGiftTips), l);
  }
  
  protected void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) {
      ((bakt)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(113)).a(paramString1, paramString2, paramInt1, paramInt2, new bask(this, paramInt2, paramString2, paramMessageForDeliverGiftTips, paramBoolean));
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips, String paramString, boolean paramBoolean, aycb paramaycb)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips = paramMessageForDeliverGiftTips;
    if (QLog.isColorLevel()) {
      QLog.d("TroopInteractGiftAnimationController", 2, "TroopInteractGiftAnimationController: showAnimation" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactId);
    }
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null) {
      this.b = this.jdField_a_of_type_AndroidMediaSoundPool.load(balg.a(paramString) + "sound.wav", 1);
    }
    ThreadManager.post(new TroopInteractGiftAnimationController.1(this, paramString, paramMessageForDeliverGiftTips, paramBoolean, paramaycb, (bakt)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(113)), 8, null, true);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton != null;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null)
    {
      AudioManager localAudioManager = (AudioManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_AndroidContentContext.getSystemService("audio");
      float f = localAudioManager.getStreamMaxVolume(3);
      f = localAudioManager.getStreamVolume(3) / f;
      this.jdField_a_of_type_AndroidMediaSoundPool.play(this.b, f, f, 1, 0, 1.0F);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     barx
 * JD-Core Version:    0.7.0.1
 */