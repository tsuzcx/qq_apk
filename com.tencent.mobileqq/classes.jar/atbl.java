import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingView;
import com.tencent.qphone.base.util.QLog;

class atbl
  implements betn
{
  private long jdField_a_of_type_Long;
  
  atbl(atbj paramatbj, Context paramContext) {}
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, "onCloseClick");
    }
    if (atbj.a(this.jdField_a_of_type_Atbj) == null) {
      return true;
    }
    if (atbj.a(this.jdField_a_of_type_Atbj).isIsAdm())
    {
      atbd.a(this.jdField_a_of_type_AndroidContentContext, 5, atbj.a(this.jdField_a_of_type_Atbj).getCurUin());
      return true;
    }
    azmj.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_quit_member", 0, 0, atbj.a(this.jdField_a_of_type_Atbj).getCurUin(), "", "", "");
    this.jdField_a_of_type_Atbj.b();
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    if ((atbj.a(this.jdField_a_of_type_Atbj) == null) || (atbj.a(this.jdField_a_of_type_Atbj) == null)) {
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
    paramInt1 = atbj.a(this.jdField_a_of_type_Atbj).a();
    if (paramInt1 == 1)
    {
      ball.a(this.jdField_a_of_type_AndroidContentContext, 1, atbj.a(this.jdField_a_of_type_Atbj).getBigUrl(), null, new Bundle(), atbj.a(this.jdField_a_of_type_Atbj).getCurType());
      this.jdField_a_of_type_Atbj.a(atbj.a(this.jdField_a_of_type_Atbj).getCurUin(), atbj.a(this.jdField_a_of_type_Atbj).getCurType(), false);
    }
    for (;;)
    {
      return true;
      if (paramInt1 == 2)
      {
        atbj.a(this.jdField_a_of_type_Atbj).a(atbj.a(this.jdField_a_of_type_Atbj).getSmallUrl());
        azmj.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh", 0, 0, atbj.a(this.jdField_a_of_type_Atbj).getCurUin(), "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbl
 * JD-Core Version:    0.7.0.1
 */