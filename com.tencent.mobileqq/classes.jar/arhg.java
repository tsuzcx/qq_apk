import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import mqq.app.AppRuntime;

class arhg
  implements arhl
{
  arhg(arhf paramarhf) {}
  
  public void a()
  {
    AppRuntime localAppRuntime;
    if (this.a.jdField_a_of_type_Int == 1)
    {
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
        awqx.b((QQAppInterface)localAppRuntime, "CliOper", "", "", "MbJieshou", "MbWanchengXiaochu", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, "", "", "");
      }
    }
    do
    {
      return;
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    } while ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface)));
    this.a.jdField_a_of_type_Long = System.currentTimeMillis();
    awqx.b((QQAppInterface)localAppRuntime, "CliOper", "", "", "MbFasong", "MbZhudongChaozuo", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arhg
 * JD-Core Version:    0.7.0.1
 */