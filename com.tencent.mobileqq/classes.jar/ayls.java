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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ayls
  implements AdapterView.OnItemClickListener
{
  ayls(aylr paramaylr) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.getActionSheet().isShowing()) {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.getActionSheet().dismiss();
    }
    int i;
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.getInstance().isWXinstalled()) {
        i = 2131719722;
      }
    }
    for (;;)
    {
      if (i != -1) {
        yyi.a(1, i);
      }
      for (;;)
      {
        EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        return;
        if (WXShareHelper.getInstance().isWXsupportApi()) {
          break label233;
        }
        i = 2131719723;
        break;
        if ((this.a.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.a.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
        {
          yyi.a(1, 2131698430);
        }
        else
        {
          this.a.jdField_a_of_type_Aylu.a(true);
          switch ((int)paramLong)
          {
          default: 
            break;
          case 0: 
            ThreadManager.postImmediately(new ShareHelper.1.1(this), null, true);
            break;
          case 1: 
            ThreadManager.postImmediately(new ShareHelper.1.2(this), null, true);
            break;
          case 2: 
          case 3: 
            ThreadManager.postImmediately(new ShareHelper.1.3(this, paramLong), null, true);
          }
        }
      }
      label233:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayls
 * JD-Core Version:    0.7.0.1
 */