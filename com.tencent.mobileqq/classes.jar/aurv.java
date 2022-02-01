import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingView;
import com.tencent.qphone.base.util.QLog;

class aurv
  implements bhlz
{
  private long jdField_a_of_type_Long;
  
  aurv(aurt paramaurt, Context paramContext) {}
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, "onCloseClick");
    }
    if (aurt.a(this.jdField_a_of_type_Aurt) == null) {
      return true;
    }
    if (aurt.a(this.jdField_a_of_type_Aurt).isIsAdm())
    {
      aurn.a(this.jdField_a_of_type_AndroidContentContext, 5, aurt.a(this.jdField_a_of_type_Aurt).getCurUin());
      return true;
    }
    bcef.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_quit_member", 0, 0, aurt.a(this.jdField_a_of_type_Aurt).getCurUin(), "", "", "");
    this.jdField_a_of_type_Aurt.b();
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    if ((aurt.a(this.jdField_a_of_type_Aurt) == null) || (aurt.a(this.jdField_a_of_type_Aurt) == null)) {
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
    paramInt1 = aurt.a(this.jdField_a_of_type_Aurt).a();
    if (paramInt1 == 1)
    {
      bddg.a(this.jdField_a_of_type_AndroidContentContext, 1, aurt.a(this.jdField_a_of_type_Aurt).getBigUrl(), null, new Bundle(), aurt.a(this.jdField_a_of_type_Aurt).getCurType());
      this.jdField_a_of_type_Aurt.a(aurt.a(this.jdField_a_of_type_Aurt).getCurUin(), aurt.a(this.jdField_a_of_type_Aurt).getCurType(), false);
    }
    for (;;)
    {
      return true;
      if (paramInt1 == 2)
      {
        aurt.a(this.jdField_a_of_type_Aurt).a(aurt.a(this.jdField_a_of_type_Aurt).getSmallUrl());
        bcef.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh", 0, 0, aurt.a(this.jdField_a_of_type_Aurt).getCurUin(), "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aurv
 * JD-Core Version:    0.7.0.1
 */