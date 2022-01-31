import android.graphics.Bitmap;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.1;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.2;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.3;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.wxapi.WXShareHelper;

public class awlw
  implements AdapterView.OnItemClickListener
{
  awlw(awlv paramawlv) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.getActionSheet().isShowing()) {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.getActionSheet().dismiss();
    }
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131721478;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        xxb.a(1, paramInt);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131721479;
        }
      }
      else
      {
        if ((this.a.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.a.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
        {
          xxb.a(1, 2131699638);
          return;
        }
        this.a.jdField_a_of_type_Awly.a(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awlw
 * JD-Core Version:    0.7.0.1
 */