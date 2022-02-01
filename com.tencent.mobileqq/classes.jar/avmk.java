import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingView;
import com.tencent.qphone.base.util.QLog;

class avmk
  implements bieu
{
  private long jdField_a_of_type_Long;
  
  avmk(avmi paramavmi, Context paramContext) {}
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, "onCloseClick");
    }
    if (avmi.a(this.jdField_a_of_type_Avmi) == null) {
      return true;
    }
    if (avmi.a(this.jdField_a_of_type_Avmi).isIsAdm())
    {
      avmc.a(this.jdField_a_of_type_AndroidContentContext, 5, avmi.a(this.jdField_a_of_type_Avmi).getCurUin());
      return true;
    }
    bcst.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_quit_member", 0, 0, avmi.a(this.jdField_a_of_type_Avmi).getCurUin(), "", "", "");
    this.jdField_a_of_type_Avmi.b();
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    if ((avmi.a(this.jdField_a_of_type_Avmi) == null) || (avmi.a(this.jdField_a_of_type_Avmi) == null)) {
      return false;
    }
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "click button too frequently pastTime=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
      }
      return true;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramInt1 = avmi.a(this.jdField_a_of_type_Avmi).a();
    if (paramInt1 == 1)
    {
      bdro.a(this.jdField_a_of_type_AndroidContentContext, 1, avmi.a(this.jdField_a_of_type_Avmi).getBigUrl(), null, new Bundle(), avmi.a(this.jdField_a_of_type_Avmi).getCurType());
      this.jdField_a_of_type_Avmi.a(avmi.a(this.jdField_a_of_type_Avmi).getCurUin(), avmi.a(this.jdField_a_of_type_Avmi).getCurType(), false);
    }
    for (;;)
    {
      return true;
      if (paramInt1 == 2)
      {
        avmi.a(this.jdField_a_of_type_Avmi).a(avmi.a(this.jdField_a_of_type_Avmi).getSmallUrl());
        bcst.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh", 0, 0, avmi.a(this.jdField_a_of_type_Avmi).getCurUin(), "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avmk
 * JD-Core Version:    0.7.0.1
 */