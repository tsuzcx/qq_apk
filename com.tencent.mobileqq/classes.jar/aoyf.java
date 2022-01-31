import android.app.Activity;
import android.media.AudioManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.Iterator;
import java.util.List;

class aoyf
  implements View.OnClickListener
{
  aoyf(aoyb paramaoyb) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    int i;
    int j;
    do
    {
      do
      {
        return;
      } while (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null);
      if (aoyb.a(this.a))
      {
        aoyb.a(this.a).removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
        apci.a("0X8004BE5");
        this.a.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(aoyb.a(this.a));
        aoyb.a(this.a);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Aozd.d(aoyb.a(this.a));
        return;
        aoyb.b(this.a);
      }
      aoyb.a(this.a);
      paramView = this.a.jdField_a_of_type_Aovk.a();
      if (paramView != null)
      {
        paramView = paramView.iterator();
        while (paramView.hasNext())
        {
          bahx localbahx = (bahx)paramView.next();
          if ((!TextUtils.isEmpty(localbahx.a)) && (localbahx.a.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131626860)))) {
            awqx.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
          }
        }
      }
      this.a.jdField_a_of_type_Aozd.a(this.a.jdField_a_of_type_Aovk.a());
      this.a.jdField_a_of_type_Aozd.e(true);
      return;
      this.a.n();
      return;
      i = this.a.jdField_a_of_type_Aovk.i();
      j = this.a.jdField_a_of_type_Aovk.h();
    } while ((i != 6) || (j != 1) || (this.a.jdField_a_of_type_Aovk.a() == null));
    this.a.jdField_a_of_type_Aovk.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoyf
 * JD-Core Version:    0.7.0.1
 */