import android.graphics.Bitmap;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.1;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.2;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.3;
import com.tencent.mobileqq.wxapi.WXShareHelper;

public class auui
  implements AdapterView.OnItemClickListener
{
  auui(auuh paramauuh) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_Bbjc.a().isShowing()) {
      this.a.jdField_a_of_type_Bbjc.a().dismiss();
    }
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131720906;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        wim.a(1, paramInt);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131720907;
        }
      }
      else
      {
        if ((this.a.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.a.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
        {
          wim.a(1, 2131699282);
          return;
        }
        this.a.jdField_a_of_type_Auuk.a(true);
        switch ((int)paramLong)
        {
        default: 
          return;
        case 0: 
          ThreadManager.postImmediately(new ShareHelper.1.1(this), null, true);
          return;
        case 1: 
          ThreadManager.postImmediately(new ShareHelper.1.2(this), null, true);
          return;
        }
        ThreadManager.postImmediately(new ShareHelper.1.3(this, paramLong), null, true);
        return;
      }
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auui
 * JD-Core Version:    0.7.0.1
 */