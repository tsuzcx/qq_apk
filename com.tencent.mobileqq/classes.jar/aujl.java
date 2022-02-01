import android.media.AudioManager;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class aujl
  implements View.OnClickListener
{
  aujl(aujj paramaujj) {}
  
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
      if (aujj.a(this.a) != null)
      {
        boolean bool2 = aujj.a(this.a).isPlaying();
        if (bool2)
        {
          aujj.a(this.a).removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
          aunh.a("0X8004BE5");
          this.a.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(aujj.a(this.a));
          aujj.a(this.a);
          label130:
          localObject = this.a.jdField_a_of_type_Aukp;
          if (bool2) {
            break label171;
          }
        }
        for (;;)
        {
          ((aukp)localObject).d(bool1);
          break;
          aujj.b(this.a);
          aujj.c(this.a);
          break label130;
          label171:
          bool1 = false;
        }
        Object localObject = this.a.jdField_a_of_type_Augj.b();
        aujj.a(this.a, (ArrayList[])localObject);
        String str = this.a.a() + "(" + auog.a(this.a.jdField_a_of_type_Augj.c()) + ")";
        this.a.a((ArrayList[])localObject, str);
        continue;
        this.a.n();
        continue;
        int i = this.a.jdField_a_of_type_Augj.i();
        int j = this.a.jdField_a_of_type_Augj.h();
        if ((i == 6) && (j == 1) && (this.a.jdField_a_of_type_Augj.a() != null)) {
          this.a.jdField_a_of_type_Augj.a().a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujl
 * JD-Core Version:    0.7.0.1
 */