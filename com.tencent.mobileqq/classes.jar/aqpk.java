import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class aqpk
  extends aqpd
{
  aqpk(aqph paramaqph) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((aqph.a(this.a) != null) && (paramBoolean2 != aqph.a(this.a).a()))
      {
        aqph.a(this.a).setOnCheckedChangeListener(null);
        aqph.a(this.a).setChecked(paramBoolean2);
        aqph.a(this.a).setOnCheckedChangeListener(this.a);
      }
      return;
    }
    paramString = QQToast.a(BaseApplication.getContext(), 1, 2131690565, 0);
    paramString.b(paramString.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpk
 * JD-Core Version:    0.7.0.1
 */