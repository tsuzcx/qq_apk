import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingView;
import com.tencent.qphone.base.util.QLog;

class arkx
  implements bcue
{
  private long jdField_a_of_type_Long;
  
  arkx(arkv paramarkv, Context paramContext) {}
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, "onCloseClick");
    }
    if (arkv.a(this.jdField_a_of_type_Arkv) == null) {
      return true;
    }
    if (arkv.a(this.jdField_a_of_type_Arkv).isIsAdm())
    {
      arkp.a(this.jdField_a_of_type_AndroidContentContext, 5, arkv.a(this.jdField_a_of_type_Arkv).getCurUin());
      return true;
    }
    axqy.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_quit_member", 0, 0, arkv.a(this.jdField_a_of_type_Arkv).getCurUin(), "", "", "");
    this.jdField_a_of_type_Arkv.b();
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    if ((arkv.a(this.jdField_a_of_type_Arkv) == null) || (arkv.a(this.jdField_a_of_type_Arkv) == null)) {
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
    paramInt1 = arkv.a(this.jdField_a_of_type_Arkv).a();
    if (paramInt1 == 1)
    {
      aynp.a(this.jdField_a_of_type_AndroidContentContext, 1, arkv.a(this.jdField_a_of_type_Arkv).getBigUrl(), null, new Bundle(), arkv.a(this.jdField_a_of_type_Arkv).getCurType());
      this.jdField_a_of_type_Arkv.a(arkv.a(this.jdField_a_of_type_Arkv).getCurUin(), arkv.a(this.jdField_a_of_type_Arkv).getCurType(), false);
    }
    for (;;)
    {
      return true;
      if (paramInt1 == 2)
      {
        arkv.a(this.jdField_a_of_type_Arkv).a(arkv.a(this.jdField_a_of_type_Arkv).getSmallUrl());
        axqy.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh", 0, 0, arkv.a(this.jdField_a_of_type_Arkv).getCurUin(), "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arkx
 * JD-Core Version:    0.7.0.1
 */