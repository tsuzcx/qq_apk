import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.widget.XEditTextEx;

public class bmil
  extends bmiv
  implements View.OnClickListener
{
  protected ViewStub a;
  protected TextView a;
  protected bmuv a;
  protected String a;
  
  public bmil(@NonNull bmix parambmix)
  {
    super(parambmix);
  }
  
  private void d()
  {
    k();
    if (this.jdField_a_of_type_Bmuv.a() != 0)
    {
      this.jdField_a_of_type_Bmuv.a(0);
      this.jdField_a_of_type_Bmuv.a.requestFocus();
      bhoc.a(this.jdField_a_of_type_Bmuv.a);
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Bmuv != null) && (this.jdField_a_of_type_Bmuv.a() == 0))
    {
      this.jdField_a_of_type_Bmuv.a(4);
      bhoc.b(this.jdField_a_of_type_Bmuv.a);
      this.jdField_a_of_type_Bmuv.a.clearFocus();
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Bmuv == null)
    {
      this.jdField_a_of_type_Bmuv = new bmuv(this.jdField_a_of_type_AndroidViewViewStub.inflate());
      this.jdField_a_of_type_Bmuv.a(new bmin(this));
      this.jdField_a_of_type_Bmuv.b(new bmio(this));
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
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new bmim(this));
  }
  
  public void a(int paramInt, @NonNull bmwn parambmwn)
  {
    super.a(paramInt, parambmwn);
    parambmwn.a.videoLabel = a();
    bmix localbmix;
    String str;
    if (!TextUtils.isEmpty(a()))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localbmix = this.jdField_a_of_type_Bmix;
        str = a();
        if (!this.jdField_a_of_type_Bmix.a()) {
          break label89;
        }
      }
    }
    label89:
    for (parambmwn = "2";; parambmwn = "1")
    {
      localbmix.a("pub_tag", 0, 0, new String[] { "1", str, parambmwn });
      return;
      paramInt = 0;
      break;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Bmuv != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Bmuv.a() == 0)
      {
        this.jdField_a_of_type_Bmix.a(0);
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
 * Qualified Name:     bmil
 * JD-Core Version:    0.7.0.1
 */