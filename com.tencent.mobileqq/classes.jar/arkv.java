import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingView;
import com.tencent.qphone.base.util.QLog;

class arkv
  implements bctp
{
  private long jdField_a_of_type_Long;
  
  arkv(arkt paramarkt, Context paramContext) {}
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, "onCloseClick");
    }
    if (arkt.a(this.jdField_a_of_type_Arkt) == null) {
      return true;
    }
    if (arkt.a(this.jdField_a_of_type_Arkt).isIsAdm())
    {
      arkn.a(this.jdField_a_of_type_AndroidContentContext, 5, arkt.a(this.jdField_a_of_type_Arkt).getCurUin());
      return true;
    }
    axqw.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_quit_member", 0, 0, arkt.a(this.jdField_a_of_type_Arkt).getCurUin(), "", "", "");
    this.jdField_a_of_type_Arkt.b();
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    if ((arkt.a(this.jdField_a_of_type_Arkt) == null) || (arkt.a(this.jdField_a_of_type_Arkt) == null)) {
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
    paramInt1 = arkt.a(this.jdField_a_of_type_Arkt).a();
    if (paramInt1 == 1)
    {
      aynn.a(this.jdField_a_of_type_AndroidContentContext, 1, arkt.a(this.jdField_a_of_type_Arkt).getBigUrl(), null, new Bundle(), arkt.a(this.jdField_a_of_type_Arkt).getCurType());
      this.jdField_a_of_type_Arkt.a(arkt.a(this.jdField_a_of_type_Arkt).getCurUin(), arkt.a(this.jdField_a_of_type_Arkt).getCurType(), false);
    }
    for (;;)
    {
      return true;
      if (paramInt1 == 2)
      {
        arkt.a(this.jdField_a_of_type_Arkt).a(arkt.a(this.jdField_a_of_type_Arkt).getSmallUrl());
        axqw.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh", 0, 0, arkt.a(this.jdField_a_of_type_Arkt).getCurUin(), "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arkv
 * JD-Core Version:    0.7.0.1
 */