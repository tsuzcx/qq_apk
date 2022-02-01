import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class aqlx
  extends aqlq
{
  aqlx(aqlu paramaqlu) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((aqlu.a(this.a) != null) && (paramBoolean2 != aqlu.a(this.a).a()))
      {
        aqlu.a(this.a).setOnCheckedChangeListener(null);
        aqlu.a(this.a).setChecked(paramBoolean2);
        aqlu.a(this.a).setOnCheckedChangeListener(this.a);
      }
      return;
    }
    paramString = QQToast.a(BaseApplication.getContext(), 1, 2131690682, 0);
    paramString.b(paramString.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqlx
 * JD-Core Version:    0.7.0.1
 */