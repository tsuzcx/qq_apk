import android.media.AudioManager;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class auac
  implements View.OnClickListener
{
  auac(auaa paramauaa) {}
  
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
      if (auaa.a(this.a) != null)
      {
        boolean bool2 = auaa.a(this.a).isPlaying();
        if (bool2)
        {
          auaa.a(this.a).removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
          audy.a("0X8004BE5");
          this.a.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(auaa.a(this.a));
          auaa.a(this.a);
          label130:
          localObject = this.a.jdField_a_of_type_Aubg;
          if (bool2) {
            break label171;
          }
        }
        for (;;)
        {
          ((aubg)localObject).d(bool1);
          break;
          auaa.b(this.a);
          auaa.c(this.a);
          break label130;
          label171:
          bool1 = false;
        }
        Object localObject = this.a.jdField_a_of_type_Atxa.b();
        auaa.a(this.a, (ArrayList[])localObject);
        String str = this.a.a() + "(" + FileUtil.filesizeToString(this.a.jdField_a_of_type_Atxa.c()) + ")";
        this.a.a((ArrayList[])localObject, str);
        continue;
        this.a.n();
        continue;
        int i = this.a.jdField_a_of_type_Atxa.i();
        int j = this.a.jdField_a_of_type_Atxa.h();
        if ((i == 6) && (j == 1) && (this.a.jdField_a_of_type_Atxa.a() != null)) {
          this.a.jdField_a_of_type_Atxa.a().a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auac
 * JD-Core Version:    0.7.0.1
 */