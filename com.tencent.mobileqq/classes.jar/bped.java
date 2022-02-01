import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

public class bped
  extends bpen
  implements View.OnClickListener
{
  protected ViewStub a;
  protected TextView a;
  protected bpqn a;
  protected String a;
  
  public bped(@NonNull bpep parambpep)
  {
    super(parambpep);
  }
  
  private void d()
  {
    k();
    if (this.jdField_a_of_type_Bpqn.a() != 0)
    {
      this.jdField_a_of_type_Bpqn.a(0);
      this.jdField_a_of_type_Bpqn.a.requestFocus();
      bkft.a(this.jdField_a_of_type_Bpqn.a);
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Bpqn != null) && (this.jdField_a_of_type_Bpqn.a() == 0))
    {
      this.jdField_a_of_type_Bpqn.a(4);
      bkft.b(this.jdField_a_of_type_Bpqn.a);
      this.jdField_a_of_type_Bpqn.a.clearFocus();
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Bpqn == null)
    {
      this.jdField_a_of_type_Bpqn = new bpqn(this.jdField_a_of_type_AndroidViewViewStub.inflate());
      this.jdField_a_of_type_Bpqn.a(new bpef(this));
      this.jdField_a_of_type_Bpqn.b(new bpeg(this));
    }
  }
  
  @Nullable
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131362174));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new bpee(this));
  }
  
  public void a(int paramInt, @NonNull bpsf parambpsf)
  {
    super.a(paramInt, parambpsf);
    parambpsf.a.videoLabel = a();
    bpep localbpep;
    String str;
    if (!TextUtils.isEmpty(a()))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localbpep = this.jdField_a_of_type_Bpep;
        str = a();
        if (!this.jdField_a_of_type_Bpep.a()) {
          break label89;
        }
      }
    }
    label89:
    for (parambpsf = "2";; parambpsf = "1")
    {
      localbpep.a("pub_tag", 0, 0, new String[] { "1", str, parambpsf });
      return;
      paramInt = 0;
      break;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Bpqn != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Bpqn.a() == 0)
      {
        this.jdField_a_of_type_Bpep.a(0);
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
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bped
 * JD-Core Version:    0.7.0.1
 */