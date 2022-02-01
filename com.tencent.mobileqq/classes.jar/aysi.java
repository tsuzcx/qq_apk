import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import com.tencent.mobileqq.widget.ParticipleView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class aysi
  extends behg
{
  public aysi(OCRResultActivity paramOCRResultActivity) {}
  
  protected void a(boolean paramBoolean, List<String> paramList)
  {
    super.a(paramBoolean, paramList);
    OCRResultActivity.c(this.a);
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0))
    {
      this.a.a.setParticipleItems(paramList);
      this.a.a.a();
      OCRResultActivity.d(this.a);
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, anvx.a(2131707278), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysi
 * JD-Core Version:    0.7.0.1
 */