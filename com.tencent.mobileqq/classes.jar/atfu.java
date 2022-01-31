import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingView;
import com.tencent.qphone.base.util.QLog;

class atfu
  implements bexw
{
  private long jdField_a_of_type_Long;
  
  atfu(atfs paramatfs, Context paramContext) {}
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, "onCloseClick");
    }
    if (atfs.a(this.jdField_a_of_type_Atfs) == null) {
      return true;
    }
    if (atfs.a(this.jdField_a_of_type_Atfs).isIsAdm())
    {
      atfm.a(this.jdField_a_of_type_AndroidContentContext, 5, atfs.a(this.jdField_a_of_type_Atfs).getCurUin());
      return true;
    }
    azqs.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_quit_member", 0, 0, atfs.a(this.jdField_a_of_type_Atfs).getCurUin(), "", "", "");
    this.jdField_a_of_type_Atfs.b();
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    if ((atfs.a(this.jdField_a_of_type_Atfs) == null) || (atfs.a(this.jdField_a_of_type_Atfs) == null)) {
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
    paramInt1 = atfs.a(this.jdField_a_of_type_Atfs).a();
    if (paramInt1 == 1)
    {
      bapu.a(this.jdField_a_of_type_AndroidContentContext, 1, atfs.a(this.jdField_a_of_type_Atfs).getBigUrl(), null, new Bundle(), atfs.a(this.jdField_a_of_type_Atfs).getCurType());
      this.jdField_a_of_type_Atfs.a(atfs.a(this.jdField_a_of_type_Atfs).getCurUin(), atfs.a(this.jdField_a_of_type_Atfs).getCurType(), false);
    }
    for (;;)
    {
      return true;
      if (paramInt1 == 2)
      {
        atfs.a(this.jdField_a_of_type_Atfs).a(atfs.a(this.jdField_a_of_type_Atfs).getSmallUrl());
        azqs.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh", 0, 0, atfs.a(this.jdField_a_of_type_Atfs).getCurUin(), "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atfu
 * JD-Core Version:    0.7.0.1
 */