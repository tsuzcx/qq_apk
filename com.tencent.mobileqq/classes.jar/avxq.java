import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingView;
import com.tencent.qphone.base.util.QLog;

class avxq
  implements biwp
{
  private long jdField_a_of_type_Long;
  
  avxq(avxo paramavxo, Context paramContext) {}
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, "onCloseClick");
    }
    if (avxo.a(this.jdField_a_of_type_Avxo) == null) {
      return true;
    }
    if (avxo.a(this.jdField_a_of_type_Avxo).isIsAdm())
    {
      avxi.a(this.jdField_a_of_type_AndroidContentContext, 5, avxo.a(this.jdField_a_of_type_Avxo).getCurUin());
      return true;
    }
    bdla.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_quit_member", 0, 0, avxo.a(this.jdField_a_of_type_Avxo).getCurUin(), "", "", "");
    this.jdField_a_of_type_Avxo.b();
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    if ((avxo.a(this.jdField_a_of_type_Avxo) == null) || (avxo.a(this.jdField_a_of_type_Avxo) == null)) {
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
    paramInt1 = avxo.a(this.jdField_a_of_type_Avxo).a();
    if (paramInt1 == 1)
    {
      beki.a(this.jdField_a_of_type_AndroidContentContext, 1, avxo.a(this.jdField_a_of_type_Avxo).getBigUrl(), null, new Bundle(), avxo.a(this.jdField_a_of_type_Avxo).getCurType());
      this.jdField_a_of_type_Avxo.a(avxo.a(this.jdField_a_of_type_Avxo).getCurUin(), avxo.a(this.jdField_a_of_type_Avxo).getCurType(), false);
    }
    for (;;)
    {
      return true;
      if (paramInt1 == 2)
      {
        avxo.a(this.jdField_a_of_type_Avxo).a(avxo.a(this.jdField_a_of_type_Avxo).getSmallUrl());
        bdla.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh", 0, 0, avxo.a(this.jdField_a_of_type_Avxo).getCurUin(), "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avxq
 * JD-Core Version:    0.7.0.1
 */