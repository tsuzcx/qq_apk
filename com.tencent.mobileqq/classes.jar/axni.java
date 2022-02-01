import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity;
import com.tencent.mobileqq.ocr.view.MaskView;

public class axni
  implements SurfaceHolder.Callback
{
  public axni(ScanOcrActivity paramScanOcrActivity) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    ScanOcrActivity.a(this.a, paramSurfaceHolder);
    if (ScanOcrActivity.a(this.a) == null)
    {
      ScanOcrActivity.a(this.a, new axmo(this.a, this.a.jdField_a_of_type_Axmt, ScanOcrActivity.a(this.a)));
      ScanOcrActivity.a(this.a).a(this.a.jdField_a_of_type_Int);
      ScanOcrActivity.a(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.a());
      if (ScanOcrActivity.a(this.a)) {
        ScanOcrActivity.a(this.a).a();
      }
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axni
 * JD-Core Version:    0.7.0.1
 */