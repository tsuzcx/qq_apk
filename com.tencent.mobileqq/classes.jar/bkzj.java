import android.widget.DatePicker;
import android.widget.EditText;
import dov.com.qq.im.ae.camera.ui.watermark.WatermarkEditView;

public class bkzj
  implements bkzi
{
  public bkzj(WatermarkEditView paramWatermarkEditView) {}
  
  public void a()
  {
    WatermarkEditView.a(this.a).setVisibility(8);
  }
  
  public void a(int paramInt, String paramString, EditText paramEditText)
  {
    paramString = paramString.split("-");
    WatermarkEditView.a(this.a).init(Integer.parseInt(paramString[0]), Integer.parseInt(paramString[1]) - 1, Integer.parseInt(paramString[2]), WatermarkEditView.a(this.a));
    WatermarkEditView.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzj
 * JD-Core Version:    0.7.0.1
 */