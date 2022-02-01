import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class bher
  implements wyv
{
  bher(bheh parambheh) {}
  
  public void a(wuh paramwuh, bisl parambisl)
  {
    if ((parambisl != null) && (parambisl.isShowing())) {
      parambisl.dismiss();
    }
    wyt.a(this.a.a);
    if ((paramwuh != null) && (paramwuh.jdField_a_of_type_Int == 0))
    {
      wyt.a(paramwuh.jdField_a_of_type_JavaLangString, this.a.a);
      bheh.a(this.a);
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131694256, 1).a();
      return;
    }
    this.a.c = "open";
    bheh.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bher
 * JD-Core Version:    0.7.0.1
 */