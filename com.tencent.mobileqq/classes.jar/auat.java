import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import com.tencent.mobileqq.widget.ParticipleView;
import java.util.List;

public class auat
  extends aylg
{
  public auat(OCRResultActivity paramOCRResultActivity) {}
  
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
    bcql.a(BaseApplicationImpl.getContext(), 1, ajya.a(2131707834), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auat
 * JD-Core Version:    0.7.0.1
 */