import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.widget.XEditTextEx;

public class bjxb
  extends bjxl
  implements View.OnClickListener
{
  protected ViewStub a;
  protected TextView a;
  protected bkjl a;
  protected String a;
  
  public bjxb(@NonNull bjxn parambjxn)
  {
    super(parambjxn);
  }
  
  private void d()
  {
    k();
    if (this.jdField_a_of_type_Bkjl.a() != 0)
    {
      this.jdField_a_of_type_Bkjl.a(0);
      this.jdField_a_of_type_Bkjl.a.requestFocus();
      bfni.a(this.jdField_a_of_type_Bkjl.a);
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Bkjl != null) && (this.jdField_a_of_type_Bkjl.a() == 0))
    {
      this.jdField_a_of_type_Bkjl.a(4);
      bfni.b(this.jdField_a_of_type_Bkjl.a);
      this.jdField_a_of_type_Bkjl.a.clearFocus();
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Bkjl == null)
    {
      this.jdField_a_of_type_Bkjl = new bkjl(this.jdField_a_of_type_AndroidViewViewStub.inflate());
      this.jdField_a_of_type_Bkjl.a(new bjxd(this));
      this.jdField_a_of_type_Bkjl.b(new bjxe(this));
    }
  }
  
  @Nullable
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131362108));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new bjxc(this));
  }
  
  public void a(int paramInt, @NonNull bkld parambkld)
  {
    super.a(paramInt, parambkld);
    parambkld.a.videoLabel = a();
    bjxn localbjxn;
    String str;
    if (!TextUtils.isEmpty(a()))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localbjxn = this.jdField_a_of_type_Bjxn;
        str = a();
        if (!this.jdField_a_of_type_Bjxn.a()) {
          break label89;
        }
      }
    }
    label89:
    for (parambkld = "2";; parambkld = "1")
    {
      localbjxn.a("pub_tag", 0, 0, new String[] { "1", str, parambkld });
      return;
      paramInt = 0;
      break;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Bkjl != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Bkjl.a() == 0)
      {
        this.jdField_a_of_type_Bjxn.a(0);
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
 * Qualified Name:     bjxb
 * JD-Core Version:    0.7.0.1
 */