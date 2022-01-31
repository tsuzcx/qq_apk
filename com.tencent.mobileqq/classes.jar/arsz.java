import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout;
import com.tencent.mobileqq.listentogether.lyrics.FloatTextLayout;
import com.tencent.qphone.base.util.QLog;

class arsz
  extends BroadcastReceiver
{
  arsz(arss paramarss) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getStringExtra("process_name");
    if (QLog.isColorLevel()) {
      QLog.d("LyricsController", 2, "onReceive action: " + paramContext + "  process_name:" + paramIntent);
    }
    int i;
    if ((paramIntent != null) && (paramIntent.contains("openSdk")))
    {
      i = 1;
      if (!"mqq.intent.action.QQ_BACKGROUND".equals(paramContext)) {
        break label246;
      }
      if ((this.a.b) && (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout != null) && (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null) && (this.a.jdField_a_of_type_Arsq.jdField_h_of_type_Boolean))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a.setAlign(this.a.jdField_a_of_type_Arsq.a);
        this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.a.jdField_a_of_type_Arsq.g, this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.g());
        this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.a.jdField_a_of_type_Arsq.jdField_h_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.g());
        this.a.jdField_a_of_type_Arsq.jdField_h_of_type_Boolean = false;
      }
      this.a.a(false);
      this.a.jdField_a_of_type_Boolean = false;
      arss.a(this.a, false);
    }
    label246:
    while (!"mqq.intent.action.QQ_FOREGROUND".equals(paramContext))
    {
      return;
      i = 0;
      break;
    }
    if (i == 0)
    {
      this.a.jdField_a_of_type_Boolean = true;
      this.a.a(true);
      arss.a(this.a, false);
      return;
    }
    if (this.a.b)
    {
      arss.a(this.a, true);
      return;
    }
    this.a.jdField_a_of_type_Boolean = true;
    this.a.jdField_a_of_type_Arsq.f = true;
    arss.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arsz
 * JD-Core Version:    0.7.0.1
 */