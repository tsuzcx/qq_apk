import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class ansh
  implements wka
{
  ansh(ansg paramansg) {}
  
  public void a(wfm paramwfm, bhht parambhht)
  {
    if ((parambhht != null) && (parambhht.isShowing())) {
      parambhht.dismiss();
    }
    wjy.a(this.a.a);
    if ((paramwfm != null) && (paramwfm.jdField_a_of_type_Int == 0))
    {
      wjy.a(paramwfm.jdField_a_of_type_JavaLangString, this.a.a);
      ansg.a(this.a);
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131694065, 1).a();
      return;
    }
    this.a.c = "open";
    ansg.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ansh
 * JD-Core Version:    0.7.0.1
 */