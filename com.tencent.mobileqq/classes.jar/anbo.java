import android.widget.TextView;
import dov.com.tencent.biz.qqstory.takevideo.EditProviderPart;

public class anbo
  implements Runnable
{
  public anbo(EditProviderPart paramEditProviderPart, boolean paramBoolean) {}
  
  public void run()
  {
    if (EditProviderPart.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart) == null) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      EditProviderPart.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart).setVisibility(0);
      return;
    }
    EditProviderPart.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anbo
 * JD-Core Version:    0.7.0.1
 */