import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.widget.XEditTextEx;

public class bjwk
  extends bjwu
  implements View.OnClickListener
{
  protected ViewStub a;
  protected TextView a;
  protected bkiu a;
  protected String a;
  
  public bjwk(@NonNull bjww parambjww)
  {
    super(parambjww);
  }
  
  private void d()
  {
    k();
    if (this.jdField_a_of_type_Bkiu.a() != 0)
    {
      this.jdField_a_of_type_Bkiu.a(0);
      this.jdField_a_of_type_Bkiu.a.requestFocus();
      bfmr.a(this.jdField_a_of_type_Bkiu.a);
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Bkiu != null) && (this.jdField_a_of_type_Bkiu.a() == 0))
    {
      this.jdField_a_of_type_Bkiu.a(4);
      bfmr.b(this.jdField_a_of_type_Bkiu.a);
      this.jdField_a_of_type_Bkiu.a.clearFocus();
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Bkiu == null)
    {
      this.jdField_a_of_type_Bkiu = new bkiu(this.jdField_a_of_type_AndroidViewViewStub.inflate());
      this.jdField_a_of_type_Bkiu.a(new bjwm(this));
      this.jdField_a_of_type_Bkiu.b(new bjwn(this));
    }
  }
  
  @Nullable
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131362109));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new bjwl(this));
  }
  
  public void a(int paramInt, @NonNull bkkm parambkkm)
  {
    super.a(paramInt, parambkkm);
    parambkkm.a.videoLabel = a();
    bjww localbjww;
    String str;
    if (!TextUtils.isEmpty(a()))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localbjww = this.jdField_a_of_type_Bjww;
        str = a();
        if (!this.jdField_a_of_type_Bjww.a()) {
          break label89;
        }
      }
    }
    label89:
    for (parambkkm = "2";; parambkkm = "1")
    {
      localbjww.a("pub_tag", 0, 0, new String[] { "1", str, parambkkm });
      return;
      paramInt = 0;
      break;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Bkiu != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Bkiu.a() == 0)
      {
        this.jdField_a_of_type_Bjww.a(0);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      j();
      return;
    case 0: 
      j();
      return;
    }
    d();
  }
  
  public void g() {}
  
  public void onClick(View paramView)
  {
    paramView.getId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjwk
 * JD-Core Version:    0.7.0.1
 */