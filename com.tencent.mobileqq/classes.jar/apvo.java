import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gallery.model.video.AIOFileVideoData;
import com.tencent.mobileqq.gallery.presenter.AIOGalleryBasePresenter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import java.io.File;
import java.util.Locale;
import mqq.os.MqqHandler;

class apvo
  implements AdapterView.OnItemClickListener
{
  apvo(apvm paramapvm, AIOFileVideoData paramAIOFileVideoData) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    this.jdField_a_of_type_Apvm.jdField_a_of_type_Bahv.b();
    switch (((baia)paramAdapterView).a.c)
    {
    case 55: 
    case 56: 
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 65: 
    case 66: 
    default: 
      paramInt = -1;
    }
    for (;;)
    {
      awqx.b(null, "dc00898", "", "", "0X8009EFA", "0X8009EFA", paramInt, 0, "", "", "", "");
      return;
      int i = 1;
      paramInt = i;
      if (this.jdField_a_of_type_Apvm.jdField_a_of_type_Aptk.e())
      {
        paramAdapterView = this.jdField_a_of_type_Apvm.jdField_a_of_type_Aptk.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_a_of_type_Int, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_b_of_type_Int == 1) {}
        for (boolean bool = true;; bool = false)
        {
          aptu.a(this.jdField_a_of_type_Apvm.jdField_a_of_type_AndroidAppActivity, paramAdapterView, bool);
          paramInt = i;
          break;
        }
        if (!this.jdField_a_of_type_Apvm.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.e()) {
          break;
        }
        this.jdField_a_of_type_Apvm.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.b(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_a_of_type_Long);
        awqx.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
        bbmy.a(this.jdField_a_of_type_Apvm.jdField_a_of_type_AndroidAppActivity, 2, this.jdField_a_of_type_Apvm.jdField_a_of_type_AndroidAppActivity.getString(2131627117), 0).a();
        paramInt = -1;
        continue;
        i = 5;
        paramInt = i;
        if (this.jdField_a_of_type_Apvm.jdField_a_of_type_Aptk.e())
        {
          this.jdField_a_of_type_Apvm.jdField_a_of_type_Aptk.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_a_of_type_Long);
          bbmy.a(this.jdField_a_of_type_Apvm.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apvm.jdField_a_of_type_AndroidAppActivity.getString(2131627191), 0).a();
          paramInt = i;
          continue;
          paramInt = 2;
          if (new apta().a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData))
          {
            paramAdapterView = new File(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.c);
            paramView = new StringBuilder().append(paramAdapterView.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4";
            ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(paramAdapterView.getAbsolutePath(), this.jdField_a_of_type_Apvm.jdField_a_of_type_Aptk.a, paramView, false));
          }
          else
          {
            paramAdapterView = new Bundle();
            float f = 0.0F;
            if (agfb.class.isInstance(this.jdField_a_of_type_Apvm.jdField_a_of_type_Agez)) {
              f = ((agfb)this.jdField_a_of_type_Apvm.jdField_a_of_type_Agez).a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_a_of_type_Long);
            }
            paramAdapterView.putFloat("progress", f);
            this.jdField_a_of_type_Apvm.jdField_a_of_type_Agez.h();
            this.jdField_a_of_type_Apvm.jdField_a_of_type_Aptk.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_a_of_type_Long, 13, paramAdapterView);
            this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.n = true;
            this.jdField_a_of_type_Apvm.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_a_of_type_Int);
            this.jdField_a_of_type_Apvm.j();
            continue;
            i = 3;
            paramInt = i;
            if (this.jdField_a_of_type_Apvm.jdField_a_of_type_Aptk.e())
            {
              this.jdField_a_of_type_Apvm.jdField_a_of_type_Aptk.c(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_a_of_type_Long);
              paramInt = i;
              continue;
              paramView = this.jdField_a_of_type_Apvm.jdField_a_of_type_Apsx.a();
              paramAdapterView = paramView;
              if (TextUtils.isEmpty(paramView)) {
                paramAdapterView = this.jdField_a_of_type_Apvm.jdField_a_of_type_Apsx.c();
              }
              aptv.a(this.jdField_a_of_type_Apvm.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apvm.jdField_a_of_type_Apsx.a(), this.jdField_a_of_type_Apvm.jdField_a_of_type_Apsx.c(), paramAdapterView, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.d, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_b_of_type_Int, false);
              paramInt = 6;
              continue;
              paramInt = 11;
              apck.b(this.jdField_a_of_type_Apvm.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.c);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apvo
 * JD-Core Version:    0.7.0.1
 */