import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout;
import com.tencent.mobileqq.listentogether.lyrics.FloatTextLayout;
import com.tencent.qphone.base.util.QLog;

class aqxh
  extends BroadcastReceiver
{
  aqxh(aqxa paramaqxa) {}
  
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
      if ((this.a.b) && (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout != null) && (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null) && (this.a.jdField_a_of_type_Aqwy.jdField_h_of_type_Boolean))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a.setAlign(this.a.jdField_a_of_type_Aqwy.a);
        this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.a.jdField_a_of_type_Aqwy.g, this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.g());
        this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.a.jdField_a_of_type_Aqwy.jdField_h_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.g());
        this.a.jdField_a_of_type_Aqwy.jdField_h_of_type_Boolean = false;
      }
      this.a.a(false);
      this.a.jdField_a_of_type_Boolean = false;
      aqxa.a(this.a, false);
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
      aqxa.a(this.a, false);
      return;
    }
    if (this.a.b)
    {
      aqxa.a(this.a, true);
      return;
    }
    this.a.jdField_a_of_type_Boolean = true;
    this.a.jdField_a_of_type_Aqwy.f = true;
    aqxa.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aqxh
 * JD-Core Version:    0.7.0.1
 */