import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.widget.XEditTextEx;

public class bmmx
  extends bmnh
  implements View.OnClickListener
{
  protected ViewStub a;
  protected TextView a;
  protected bmzh a;
  protected String a;
  
  public bmmx(@NonNull bmnj parambmnj)
  {
    super(parambmnj);
  }
  
  private void d()
  {
    k();
    if (this.jdField_a_of_type_Bmzh.a() != 0)
    {
      this.jdField_a_of_type_Bmzh.a(0);
      this.jdField_a_of_type_Bmzh.a.requestFocus();
      bhsj.a(this.jdField_a_of_type_Bmzh.a);
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Bmzh != null) && (this.jdField_a_of_type_Bmzh.a() == 0))
    {
      this.jdField_a_of_type_Bmzh.a(4);
      bhsj.b(this.jdField_a_of_type_Bmzh.a);
      this.jdField_a_of_type_Bmzh.a.clearFocus();
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Bmzh == null)
    {
      this.jdField_a_of_type_Bmzh = new bmzh(this.jdField_a_of_type_AndroidViewViewStub.inflate());
      this.jdField_a_of_type_Bmzh.a(new bmmz(this));
      this.jdField_a_of_type_Bmzh.b(new bmna(this));
    }
  }
  
  @Nullable
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131362113));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new bmmy(this));
  }
  
  public void a(int paramInt, @NonNull bnaz parambnaz)
  {
    super.a(paramInt, parambnaz);
    parambnaz.a.videoLabel = a();
    bmnj localbmnj;
    String str;
    if (!TextUtils.isEmpty(a()))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localbmnj = this.jdField_a_of_type_Bmnj;
        str = a();
        if (!this.jdField_a_of_type_Bmnj.a()) {
          break label89;
        }
      }
    }
    label89:
    for (parambnaz = "2";; parambnaz = "1")
    {
      localbmnj.a("pub_tag", 0, 0, new String[] { "1", str, parambnaz });
      return;
      paramInt = 0;
      break;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Bmzh != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Bmzh.a() == 0)
      {
        this.jdField_a_of_type_Bmnj.a(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmx
 * JD-Core Version:    0.7.0.1
 */