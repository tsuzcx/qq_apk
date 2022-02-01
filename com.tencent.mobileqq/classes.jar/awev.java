import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingView;
import com.tencent.qphone.base.util.QLog;

class awev
  implements bjft
{
  private long jdField_a_of_type_Long;
  
  awev(awet paramawet, Context paramContext) {}
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, "onCloseClick");
    }
    if (awet.a(this.jdField_a_of_type_Awet) == null) {
      return true;
    }
    if (awet.a(this.jdField_a_of_type_Awet).isIsAdm())
    {
      awen.a(this.jdField_a_of_type_AndroidContentContext, 5, awet.a(this.jdField_a_of_type_Awet).getCurUin());
      return true;
    }
    bdll.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_quit_member", 0, 0, awet.a(this.jdField_a_of_type_Awet).getCurUin(), "", "", "");
    this.jdField_a_of_type_Awet.b();
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    if ((awet.a(this.jdField_a_of_type_Awet) == null) || (awet.a(this.jdField_a_of_type_Awet) == null)) {
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
    paramInt1 = awet.a(this.jdField_a_of_type_Awet).a();
    if (paramInt1 == 1)
    {
      bekk.a(this.jdField_a_of_type_AndroidContentContext, 1, awet.a(this.jdField_a_of_type_Awet).getBigUrl(), null, new Bundle(), awet.a(this.jdField_a_of_type_Awet).getCurType());
      this.jdField_a_of_type_Awet.a(awet.a(this.jdField_a_of_type_Awet).getCurUin(), awet.a(this.jdField_a_of_type_Awet).getCurType(), false);
    }
    for (;;)
    {
      return true;
      if (paramInt1 == 2)
      {
        awet.a(this.jdField_a_of_type_Awet).a(awet.a(this.jdField_a_of_type_Awet).getSmallUrl());
        bdll.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh", 0, 0, awet.a(this.jdField_a_of_type_Awet).getCurUin(), "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awev
 * JD-Core Version:    0.7.0.1
 */