import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;

public class bbka
  extends bbkp
{
  private SparseArray<bbkc> a = new SparseArray();
  private Handler jdField_b_of_type_AndroidOsHandler = new bbkb(this, a());
  private String jdField_b_of_type_JavaLangString;
  
  public bbka(Context paramContext)
  {
    super(paramContext);
    int i = ((Activity)paramContext).getIntent().getIntExtra("forward_source_uin_type", -1);
    if (i == 0)
    {
      this.jdField_b_of_type_JavaLangString = "c2c";
      return;
    }
    if (i == 1)
    {
      this.jdField_b_of_type_JavaLangString = "grp";
      return;
    }
    if (i == 3000)
    {
      this.jdField_b_of_type_JavaLangString = "dis";
      return;
    }
    this.jdField_b_of_type_JavaLangString = "other";
  }
  
  private bbkc a(int paramInt)
  {
    bbkc localbbkc2 = (bbkc)this.a.get(paramInt);
    bbkc localbbkc1 = localbbkc2;
    if (localbbkc2 == null)
    {
      localbbkc1 = new bbkc(paramInt, this.jdField_b_of_type_JavaLangString);
      this.a.put(paramInt, localbbkc1);
    }
    return localbbkc1;
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage().sendToTarget();
  }
  
  public void a(int paramInt)
  {
    bbkc.a(a(paramInt));
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    bbkc localbbkc = (bbkc)this.a.get(paramInt);
    String str;
    if (localbbkc != null)
    {
      paramInt = bbkr.a(paramLong1, paramLong2);
      str = null;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      bbkc.b(localbbkc, str);
      return;
      str = "long";
      continue;
      str = "small";
      continue;
      str = "mid";
      continue;
      str = "large";
      continue;
      str = "extra";
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    bbkc localbbkc = (bbkc)this.a.get(paramInt);
    if (localbbkc != null) {
      bbkc.d(localbbkc, paramString);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    bbkc localbbkc = (bbkc)this.a.get(paramInt);
    if (localbbkc != null) {
      bbkc.a(localbbkc, paramBoolean);
    }
  }
  
  public void b(int paramInt)
  {
    bbkc localbbkc = (bbkc)this.a.get(paramInt);
    if ((localbbkc != null) && (bbkc.a(localbbkc))) {
      bbkc.b(localbbkc);
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    bbkc localbbkc = (bbkc)this.a.get(paramInt);
    if (localbbkc != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (String str = "dynamic";; str = "static")
    {
      bbkc.c(localbbkc, str);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    bbkc localbbkc = (bbkc)this.a.get(paramInt);
    if ((localbbkc != null) && (bbkc.a(localbbkc))) {
      bbkc.c(localbbkc);
    }
  }
  
  public void d(int paramInt)
  {
    bbkc localbbkc = (bbkc)this.a.get(paramInt);
    if ((localbbkc != null) && (bbkc.a(localbbkc))) {
      bbkc.a(localbbkc, "sender");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbka
 * JD-Core Version:    0.7.0.1
 */