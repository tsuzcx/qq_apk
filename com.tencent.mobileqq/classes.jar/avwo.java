import android.app.Dialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew;
import com.tencent.mobileqq.widget.ParticipleView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class avwo
  extends banl
{
  public avwo(OCRResultFragmentNew paramOCRResultFragmentNew) {}
  
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
    QQToast.a(BaseApplicationImpl.getContext(), 1, alud.a(2131708218), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avwo
 * JD-Core Version:    0.7.0.1
 */