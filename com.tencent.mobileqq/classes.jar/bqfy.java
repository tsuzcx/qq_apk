import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

public class bqfy
  extends bqgi
  implements View.OnClickListener
{
  protected ViewStub a;
  protected TextView a;
  protected bqsi a;
  protected String a;
  
  public bqfy(@NonNull bqgk parambqgk)
  {
    super(parambqgk);
  }
  
  private void d()
  {
    k();
    if (this.jdField_a_of_type_Bqsi.a() != 0)
    {
      this.jdField_a_of_type_Bqsi.a(0);
      this.jdField_a_of_type_Bqsi.a.requestFocus();
      blgx.a(this.jdField_a_of_type_Bqsi.a);
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Bqsi != null) && (this.jdField_a_of_type_Bqsi.a() == 0))
    {
      this.jdField_a_of_type_Bqsi.a(4);
      blgx.b(this.jdField_a_of_type_Bqsi.a);
      this.jdField_a_of_type_Bqsi.a.clearFocus();
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Bqsi == null)
    {
      this.jdField_a_of_type_Bqsi = new bqsi(this.jdField_a_of_type_AndroidViewViewStub.inflate());
      this.jdField_a_of_type_Bqsi.a(new bqga(this));
      this.jdField_a_of_type_Bqsi.b(new bqgb(this));
    }
  }
  
  @Nullable
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131362180));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new bqfz(this));
  }
  
  public void a(int paramInt, @NonNull bqua parambqua)
  {
    super.a(paramInt, parambqua);
    parambqua.a.videoLabel = a();
    bqgk localbqgk;
    String str;
    if (!TextUtils.isEmpty(a()))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localbqgk = this.jdField_a_of_type_Bqgk;
        str = a();
        if (!this.jdField_a_of_type_Bqgk.a()) {
          break label89;
        }
      }
    }
    label89:
    for (parambqua = "2";; parambqua = "1")
    {
      localbqgk.a("pub_tag", 0, 0, new String[] { "1", str, parambqua });
      return;
      paramInt = 0;
      break;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Bqsi != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Bqsi.a() == 0)
      {
        this.jdField_a_of_type_Bqgk.a(0);
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
 * Qualified Name:     bqfy
 * JD-Core Version:    0.7.0.1
 */