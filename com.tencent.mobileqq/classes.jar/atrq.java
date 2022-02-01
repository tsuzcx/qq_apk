import android.media.AudioManager;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class atrq
  implements View.OnClickListener
{
  atrq(atro paramatro) {}
  
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
      if (atro.a(this.a) != null)
      {
        boolean bool2 = atro.a(this.a).isPlaying();
        if (bool2)
        {
          atro.a(this.a).removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
          atvm.a("0X8004BE5");
          this.a.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(atro.a(this.a));
          atro.a(this.a);
          label130:
          localObject = this.a.jdField_a_of_type_Atsu;
          if (bool2) {
            break label171;
          }
        }
        for (;;)
        {
          ((atsu)localObject).d(bool1);
          break;
          atro.b(this.a);
          atro.c(this.a);
          break label130;
          label171:
          bool1 = false;
        }
        Object localObject = this.a.jdField_a_of_type_Atoo.b();
        atro.a(this.a, (ArrayList[])localObject);
        String str = this.a.a() + "(" + atwl.a(this.a.jdField_a_of_type_Atoo.c()) + ")";
        this.a.a((ArrayList[])localObject, str);
        continue;
        this.a.n();
        continue;
        int i = this.a.jdField_a_of_type_Atoo.i();
        int j = this.a.jdField_a_of_type_Atoo.h();
        if ((i == 6) && (j == 1) && (this.a.jdField_a_of_type_Atoo.a() != null)) {
          this.a.jdField_a_of_type_Atoo.a().a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atrq
 * JD-Core Version:    0.7.0.1
 */