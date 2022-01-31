import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.widget.XEditTextEx;

public class bifp
  extends bifz
  implements View.OnClickListener
{
  protected ViewStub a;
  protected TextView a;
  protected bisg a;
  protected String a;
  
  public bifp(@NonNull bigb parambigb)
  {
    super(parambigb);
  }
  
  private void d()
  {
    k();
    if (this.jdField_a_of_type_Bisg.a() != 0)
    {
      this.jdField_a_of_type_Bisg.a(0);
      this.jdField_a_of_type_Bisg.a.requestFocus();
      beex.a(this.jdField_a_of_type_Bisg.a);
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Bisg != null) && (this.jdField_a_of_type_Bisg.a() == 0))
    {
      this.jdField_a_of_type_Bisg.a(4);
      beex.b(this.jdField_a_of_type_Bisg.a);
      this.jdField_a_of_type_Bisg.a.clearFocus();
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Bisg == null)
    {
      this.jdField_a_of_type_Bisg = new bisg(this.jdField_a_of_type_AndroidViewViewStub.inflate());
      this.jdField_a_of_type_Bisg.a(new bifr(this));
      this.jdField_a_of_type_Bisg.b(new bifs(this));
    }
  }
  
  @Nullable
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131296568));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new bifq(this));
  }
  
  public void a(int paramInt, @NonNull bitz parambitz)
  {
    super.a(paramInt, parambitz);
    parambitz.a.videoLabel = a();
    bigb localbigb;
    String str;
    if (!TextUtils.isEmpty(a()))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localbigb = this.jdField_a_of_type_Bigb;
        str = a();
        if (!this.jdField_a_of_type_Bigb.a()) {
          break label89;
        }
      }
    }
    label89:
    for (parambitz = "2";; parambitz = "1")
    {
      localbigb.a("pub_tag", 0, 0, new String[] { "1", str, parambitz });
      return;
      paramInt = 0;
      break;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Bisg != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Bisg.a() == 0)
      {
        this.jdField_a_of_type_Bigb.a(0);
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
 * Qualified Name:     bifp
 * JD-Core Version:    0.7.0.1
 */