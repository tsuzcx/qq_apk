import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter.1.1;
import java.util.ArrayList;
import java.util.List;

public class bknu
  extends syu<tng, tot>
{
  bknu(bknt parambknt) {}
  
  public void a(@NonNull tng paramtng, @Nullable tot paramtot, @NonNull ErrorMessage paramErrorMessage)
  {
    veg.b("EditVideoTagPresenter", "refresh onCmdRespond.");
    if ((paramErrorMessage.isSuccess()) && (paramtot != null))
    {
      veg.a("EditVideoTagPresenter", "refresh onCmdRespond, refresh success:[%s]", paramtot.toString());
      paramtng = paramtot.jdField_a_of_type_JavaUtilList;
      if (paramtng.contains(bknt.a(this.a)))
      {
        int i = paramtng.indexOf(bknt.a(this.a));
        bknt.a(this.a, (vvg)paramtng.get(i));
        bknt.a(this.a).clear();
        bknt.a(this.a).addAll(paramtng);
        paramtng = new ArrayList(bknt.a(this.a));
        bknt.a(this.a, paramtot.jdField_a_of_type_JavaLangString);
        bknt.a(this.a, paramtot.b);
        ThreadManager.executeOnSubThread(new EditVideoTagPresenter.1.1(this, paramtng));
      }
    }
    for (;;)
    {
      bknt.a(this.a).a(paramErrorMessage.errorCode, bknt.a(this.a), this.a.a());
      return;
      bknt.a(this.a, null);
      break;
      veg.e("EditVideoTagPresenter", "refresh onCmdRespond, failed:[%s]", new Object[] { paramErrorMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bknu
 * JD-Core Version:    0.7.0.1
 */