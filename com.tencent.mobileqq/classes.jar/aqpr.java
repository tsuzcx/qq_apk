import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gallery.model.video.AIOFileVideoData;
import com.tencent.mobileqq.gallery.presenter.AIOGalleryBasePresenter;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.startup.step.CheckPermission;
import java.io.File;
import mqq.os.MqqHandler;

class aqpr
  implements bcvg
{
  aqpr(aqpp paramaqpp, AIOFileVideoData paramAIOFileVideoData) {}
  
  public void a(bbjs parambbjs, bcvf parambcvf)
  {
    if (parambbjs == null) {
      return;
    }
    this.jdField_a_of_type_Aqpp.jdField_a_of_type_Bcvf.b();
    int i;
    switch (parambbjs.c)
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
      i = -1;
    }
    for (;;)
    {
      axqy.b(null, "dc00898", "", "", "0X8009EFA", "0X8009EFA", i, 0, "", "", "", "");
      return;
      int j = 1;
      i = j;
      if (this.jdField_a_of_type_Aqpp.jdField_a_of_type_Aqnm.e())
      {
        parambbjs = this.jdField_a_of_type_Aqpp.jdField_a_of_type_Aqnm.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_a_of_type_Int, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_b_of_type_Int == 1) {}
        for (boolean bool = true;; bool = false)
        {
          aqnw.a(this.jdField_a_of_type_Aqpp.jdField_a_of_type_AndroidAppActivity, parambbjs, bool);
          i = j;
          break;
        }
        if (!this.jdField_a_of_type_Aqpp.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.e()) {
          break;
        }
        this.jdField_a_of_type_Aqpp.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.b(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_a_of_type_Long);
        axqy.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
        bcql.a(this.jdField_a_of_type_Aqpp.jdField_a_of_type_AndroidAppActivity, 2, this.jdField_a_of_type_Aqpp.jdField_a_of_type_AndroidAppActivity.getString(2131692756), 0).a();
        i = -1;
        continue;
        j = 5;
        i = j;
        if (this.jdField_a_of_type_Aqpp.jdField_a_of_type_Aqnm.e())
        {
          this.jdField_a_of_type_Aqpp.jdField_a_of_type_Aqnm.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_a_of_type_Long);
          bcql.a(this.jdField_a_of_type_Aqpp.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqpp.jdField_a_of_type_AndroidAppActivity.getString(2131692830), 0).a();
          i = j;
          continue;
          if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_Aqpp.jdField_a_of_type_AndroidAppActivity))
          {
            CheckPermission.requestStorePermission(this.jdField_a_of_type_Aqpp.jdField_a_of_type_AndroidAppActivity, null);
            return;
          }
          i = 2;
          if (new aqmr().a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData))
          {
            parambbjs = new File(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.c);
            parambcvf = apug.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.c);
            ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(parambbjs.getAbsolutePath(), this.jdField_a_of_type_Aqpp.jdField_a_of_type_Aqnm.a, parambcvf, false));
          }
          else
          {
            parambbjs = new Bundle();
            float f = 0.0F;
            if (agqx.class.isInstance(this.jdField_a_of_type_Aqpp.jdField_a_of_type_Agqv)) {
              f = ((agqx)this.jdField_a_of_type_Aqpp.jdField_a_of_type_Agqv).a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_a_of_type_Long);
            }
            parambbjs.putFloat("progress", f);
            this.jdField_a_of_type_Aqpp.jdField_a_of_type_Agqv.h();
            this.jdField_a_of_type_Aqpp.jdField_a_of_type_Aqnm.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_a_of_type_Long, 13, parambbjs);
            this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.n = true;
            this.jdField_a_of_type_Aqpp.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_a_of_type_Int);
            this.jdField_a_of_type_Aqpp.j();
            continue;
            j = 3;
            i = j;
            if (this.jdField_a_of_type_Aqpp.jdField_a_of_type_Aqnm.e())
            {
              this.jdField_a_of_type_Aqpp.jdField_a_of_type_Aqnm.c(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_a_of_type_Long);
              i = j;
              continue;
              parambcvf = this.jdField_a_of_type_Aqpp.jdField_a_of_type_Aqmo.a();
              parambbjs = parambcvf;
              if (TextUtils.isEmpty(parambcvf)) {
                parambbjs = this.jdField_a_of_type_Aqpp.jdField_a_of_type_Aqmo.c();
              }
              aqnx.a(this.jdField_a_of_type_Aqpp.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqpp.jdField_a_of_type_Aqmo.a(), this.jdField_a_of_type_Aqpp.jdField_a_of_type_Aqmo.c(), parambbjs, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.d, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.jdField_b_of_type_Int, false);
              i = 6;
              continue;
              i = 11;
              apug.b(this.jdField_a_of_type_Aqpp.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOFileVideoData.c);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqpr
 * JD-Core Version:    0.7.0.1
 */