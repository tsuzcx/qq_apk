import com.tencent.mobileqq.app.QQAppInterface;
import kotlin.Metadata;
import mqq.app.AppRuntime;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuccess", "", "onResult"}, k=3, mv={1, 1, 16})
final class amlw
  implements bimf
{
  amlw(AppRuntime paramAppRuntime, boolean paramBoolean) {}
  
  public final void a(boolean paramBoolean)
  {
    String str;
    int i;
    if (paramBoolean)
    {
      str = "new_folder_prestart_success";
      amlk.a().a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, str);
      amlv.a("preloadWebProcess isSuccess " + paramBoolean + " isWebProcessExist " + this.jdField_a_of_type_Boolean);
      if (paramBoolean) {
        amlv.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
      }
      if (!paramBoolean) {
        break label111;
      }
      i = 0;
      label75:
      if ((i != -4001) || (!this.jdField_a_of_type_Boolean)) {
        break label118;
      }
      i = -4000;
    }
    label111:
    label118:
    for (;;)
    {
      amlv.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, i);
      return;
      str = "new_folder_prestart_fail";
      break;
      i = -4001;
      break label75;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlw
 * JD-Core Version:    0.7.0.1
 */