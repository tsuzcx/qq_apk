import android.app.Dialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew;
import com.tencent.mobileqq.widget.ParticipleView;
import java.util.List;

public class aubb
  extends aylg
{
  public aubb(OCRResultFragmentNew paramOCRResultFragmentNew) {}
  
  protected void a(boolean paramBoolean, List<String> paramList)
  {
    super.a(paramBoolean, paramList);
    if (OCRResultFragmentNew.a(this.a) != null)
    {
      OCRResultFragmentNew.a(this.a).setOnCancelListener(null);
      OCRResultFragmentNew.a(this.a).dismiss();
    }
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0))
    {
      this.a.a.setParticipleItems(paramList);
      this.a.a.a();
      OCRResultFragmentNew.a(this.a, 2);
      return;
    }
    bcql.a(BaseApplicationImpl.getContext(), 1, ajya.a(2131707834), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubb
 * JD-Core Version:    0.7.0.1
 */