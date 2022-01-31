import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.share.QZoneShareActivity;

public class bgdb
  implements TextWatcher
{
  public bgdb(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt2 == 1) || (paramInt2 == 2)) && (paramInt3 == 0)) {
      try
      {
        QZoneShareActivity.b(this.a, QZoneShareActivity.a(this.a, paramCharSequence, paramInt1 + paramInt2));
        if (QZoneShareActivity.b(this.a) == -1)
        {
          QZoneShareActivity.f(this.a);
          return;
        }
        QZoneShareActivity.c(this.a, paramInt1);
        QZoneShareActivity.a(this.a, paramCharSequence.toString().substring(QZoneShareActivity.b(this.a), QZoneShareActivity.c(this.a) + paramInt2));
        return;
      }
      catch (Exception paramCharSequence)
      {
        QZoneShareActivity.f(this.a);
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.a.removeTextChangedListener(this);
    if (paramCharSequence == null)
    {
      this.a.a.addTextChangedListener(this);
      QZoneShareActivity.f(this.a);
      return;
    }
    if ((paramInt3 == 1) && (paramInt2 == 0) && (paramCharSequence.toString().substring(paramInt1, paramInt1 + 1).equals("@")))
    {
      this.a.a(false);
      this.a.g = true;
      paramCharSequence = new Intent(BaseApplication.getContext(), SelectMemberActivity.class);
      paramCharSequence.putExtra("param_only_friends", true);
      paramCharSequence.putExtra("param_min", 1);
      this.a.startActivityForResult(paramCharSequence, 1000);
    }
    if (QZoneShareActivity.a(this.a, QZoneShareActivity.a(this.a), false)) {
      this.a.a.getEditableText().delete(QZoneShareActivity.b(this.a), QZoneShareActivity.c(this.a));
    }
    QZoneShareActivity.f(this.a);
    this.a.i();
    this.a.a.addTextChangedListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgdb
 * JD-Core Version:    0.7.0.1
 */