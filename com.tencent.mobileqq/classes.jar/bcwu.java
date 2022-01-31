import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsController.2;
import com.tencent.mobileqq.trooppiceffects.view.NormalPicView;
import com.tencent.mobileqq.trooppiceffects.view.PhantomPicView;
import com.tencent.mobileqq.trooppiceffects.view.ShakePicView;
import com.tencent.mobileqq.trooppiceffects.view.VideoPicView;
import com.tencent.qphone.base.util.QLog;

public class bcwu
{
  protected Handler a;
  protected ViewGroup a;
  protected bcxg a;
  
  public bcwu(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public static void a(String paramString1, String paramString2)
  {
    azqs.b(null, "dc00899", "show_pic", "", paramString1, paramString2, 0, 0, "", "", "", "");
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bcxg != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      this.jdField_a_of_type_Bcxg.b();
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_Bcxg.a());
      this.jdField_a_of_type_Bcxg = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(int paramInt1, Bitmap paramBitmap, int paramInt2, bcww parambcww)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopPicEffectsController", 2, "showPicEffect");
    }
    if ((this.jdField_a_of_type_Bcxg == null) && (this.jdField_a_of_type_AndroidViewViewGroup != null)) {
      switch (paramInt1)
      {
      default: 
        this.jdField_a_of_type_Bcxg = new NormalPicView(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_Bcxg.a(), -1, paramInt2);
      this.jdField_a_of_type_Bcxg.setBitmap(paramBitmap);
      this.jdField_a_of_type_Bcxg.a();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopPicEffectsController.2(this, parambcww), 6000L);
      return;
      this.jdField_a_of_type_Bcxg = new PhantomPicView(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
      continue;
      this.jdField_a_of_type_Bcxg = new ShakePicView(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
      continue;
      this.jdField_a_of_type_Bcxg = new VideoPicView(this.jdField_a_of_type_AndroidViewViewGroup.getContext(), paramInt1);
    }
  }
  
  public void a(TroopChatPie paramTroopChatPie, MessageForTroopEffectPic paramMessageForTroopEffectPic, boolean paramBoolean)
  {
    awjl localawjl = awjb.a(6, 1536, 1);
    awjd localawjd = paramMessageForTroopEffectPic.getPicDownloadInfo();
    localawjl.a(paramMessageForTroopEffectPic, localawjd);
    localawjl.a(new bcwv(this, localawjd, paramTroopChatPie, paramMessageForTroopEffectPic, paramBoolean));
    awjb.a(localawjl, paramTroopChatPie.a);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcwu
 * JD-Core Version:    0.7.0.1
 */