import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class bimy
  implements nks
{
  bimy(bimw parambimw) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = this.a.mRuntime.a(this.a.mRuntime.a());
    if (paramBoolean) {
      if (this.a.a)
      {
        if ((localObject != null) && ((localObject instanceof bitr))) {
          ((bitr)localObject).setWarnToastVisible(true, 1, 2131691304);
        }
      }
      else {
        bimw.a(this.a);
      }
    }
    while ((localObject == null) || (!(localObject instanceof bitr))) {
      for (;;)
      {
        return;
        localObject = QQToast.a(BaseApplicationImpl.getContext(), 1, 2131691304, 1);
        ((QQToast)localObject).b(((QQToast)localObject).c());
      }
    }
    ((bitr)localObject).setWarnToastVisible(false, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bimy
 * JD-Core Version:    0.7.0.1
 */