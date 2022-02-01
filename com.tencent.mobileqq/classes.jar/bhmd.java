import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class bhmd
  implements nix
{
  bhmd(bhmb parambhmb) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = this.a.mRuntime.a(this.a.mRuntime.a());
    if (paramBoolean) {
      if (this.a.a)
      {
        if ((localObject != null) && ((localObject instanceof bhsw))) {
          ((bhsw)localObject).setWarnToastVisible(true, 1, 2131691301);
        }
      }
      else {
        bhmb.a(this.a);
      }
    }
    while ((localObject == null) || (!(localObject instanceof bhsw))) {
      for (;;)
      {
        return;
        localObject = QQToast.a(BaseApplicationImpl.getContext(), 1, 2131691301, 1);
        ((QQToast)localObject).b(((QQToast)localObject).c());
      }
    }
    ((bhsw)localObject).setWarnToastVisible(false, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhmd
 * JD-Core Version:    0.7.0.1
 */