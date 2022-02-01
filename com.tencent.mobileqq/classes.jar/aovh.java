import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class aovh
  implements wyv
{
  aovh(aovg paramaovg) {}
  
  public void a(wuh paramwuh, bisl parambisl)
  {
    if ((parambisl != null) && (parambisl.isShowing())) {
      parambisl.dismiss();
    }
    wyt.a(this.a.a);
    if ((paramwuh != null) && (paramwuh.jdField_a_of_type_Int == 0))
    {
      wyt.a(paramwuh.jdField_a_of_type_JavaLangString, this.a.a);
      aovg.a(this.a);
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131694256, 1).a();
      return;
    }
    this.a.c = "open";
    aovg.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aovh
 * JD-Core Version:    0.7.0.1
 */