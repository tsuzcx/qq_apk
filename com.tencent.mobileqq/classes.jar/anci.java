import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.statistics.QIMReportController;
import com.tencent.mobileqq.statistics.reportitem.QIMReadWriteReportItem;
import com.tencent.widget.BubblePopupWindow;
import dov.com.tencent.biz.qqstory.takevideo.DataReporter;
import dov.com.tencent.biz.qqstory.takevideo.DataReporter.Destination;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoButton;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoUi;
import mqq.app.AppRuntime;

public class anci
  implements CompoundButton.OnCheckedChangeListener
{
  public anci(EditVideoButton paramEditVideoButton, Intent paramIntent) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton.a(EditVideoButton.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton), paramBoolean);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton.e = paramBoolean;
    if (paramBoolean)
    {
      if ((EditVideoButton.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton) == null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton.jdField_a_of_type_Boolean = false;
        BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).edit().putBoolean("showFlashPic", false).commit();
        EditVideoButton.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton, new BubblePopupWindow(-2, -2));
        paramCompoundButton = new TextView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a());
        i = AIOUtils.a(10.0F, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton.a());
        paramCompoundButton.setPadding(i, 0, i, 0);
        paramCompoundButton.setTextColor(-1);
        paramCompoundButton.setText("选中的图片每人只能查看一次");
        paramCompoundButton.setTextSize(15.0F);
        EditVideoButton.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton).a(paramCompoundButton);
        EditVideoButton.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton).a(false);
        EditVideoButton.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton).b(EditVideoButton.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton));
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton.b) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton.b = false;
      }
    }
    while ((EditVideoButton.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton) == null) || (!EditVideoButton.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton).b()))
    {
      return;
      int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", 0);
      Object localObject = DataReporter.a().a(i);
      paramCompoundButton = (CompoundButton)localObject;
      if (localObject == null) {
        paramCompoundButton = DataReporter.Destination.UNKNOWN;
      }
      localObject = new QIMReadWriteReportItem();
      ((QIMReadWriteReportItem)localObject).d = "0X800894C";
      ((QIMReadWriteReportItem)localObject).g = paramCompoundButton.toString();
      ((QIMReadWriteReportItem)localObject).f = "3";
      QIMReportController.b(null, (QIMReadWriteReportItem)localObject);
      return;
    }
    EditVideoButton.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anci
 * JD-Core Version:    0.7.0.1
 */