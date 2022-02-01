import android.media.AudioManager;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class asvv
  implements View.OnClickListener
{
  asvv(asvt paramasvt) {}
  
  public void onClick(View paramView)
  {
    boolean bool1 = true;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (asvt.a(this.a) != null)
      {
        boolean bool2 = asvt.a(this.a).isPlaying();
        if (bool2)
        {
          asvt.a(this.a).removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
          aszr.a("0X8004BE5");
          this.a.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(asvt.a(this.a));
          asvt.a(this.a);
          label130:
          localObject = this.a.jdField_a_of_type_Aswz;
          if (bool2) {
            break label171;
          }
        }
        for (;;)
        {
          ((aswz)localObject).d(bool1);
          break;
          asvt.b(this.a);
          asvt.c(this.a);
          break label130;
          label171:
          bool1 = false;
        }
        Object localObject = this.a.jdField_a_of_type_Asst.b();
        asvt.a(this.a, (ArrayList[])localObject);
        String str = this.a.a() + "(" + FileUtil.filesizeToString(this.a.jdField_a_of_type_Asst.c()) + ")";
        this.a.a((ArrayList[])localObject, str);
        continue;
        this.a.n();
        continue;
        int i = this.a.jdField_a_of_type_Asst.i();
        int j = this.a.jdField_a_of_type_Asst.h();
        if ((i == 6) && (j == 1) && (this.a.jdField_a_of_type_Asst.a() != null)) {
          this.a.jdField_a_of_type_Asst.a().a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvv
 * JD-Core Version:    0.7.0.1
 */