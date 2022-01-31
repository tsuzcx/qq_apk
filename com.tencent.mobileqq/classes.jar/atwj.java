import android.graphics.Bitmap;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.1;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.2;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.3;
import com.tencent.mobileqq.wxapi.WXShareHelper;

public class atwj
  implements AdapterView.OnItemClickListener
{
  atwj(atwi paramatwi) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_Bahv.a().isShowing()) {
      this.a.jdField_a_of_type_Bahv.a().dismiss();
    }
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131655008;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        vvp.a(1, paramInt);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131655009;
        }
      }
      else
      {
        if ((this.a.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.a.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
        {
          vvp.a(1, 2131633521);
          return;
        }
        this.a.jdField_a_of_type_Atwl.a(true);
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
 * Qualified Name:     atwj
 * JD-Core Version:    0.7.0.1
 */