import android.graphics.Bitmap;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.1;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.2;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.3;
import com.tencent.mobileqq.wxapi.WXShareHelper;

public class auuk
  implements AdapterView.OnItemClickListener
{
  auuk(auuj paramauuj) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_Bbjq.a().isShowing()) {
      this.a.jdField_a_of_type_Bbjq.a().dismiss();
    }
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131720917;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        wij.a(1, paramInt);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131720918;
        }
      }
      else
      {
        if ((this.a.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.a.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
        {
          wij.a(1, 2131699292);
          return;
        }
        this.a.jdField_a_of_type_Auum.a(true);
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
 * Qualified Name:     auuk
 * JD-Core Version:    0.7.0.1
 */