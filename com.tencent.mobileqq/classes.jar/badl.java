import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;

public class badl
  extends baea
{
  private SparseArray<badn> a = new SparseArray();
  private Handler jdField_b_of_type_AndroidOsHandler = new badm(this, a());
  private String jdField_b_of_type_JavaLangString;
  
  public badl(Context paramContext)
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
  
  private badn a(int paramInt)
  {
    badn localbadn2 = (badn)this.a.get(paramInt);
    badn localbadn1 = localbadn2;
    if (localbadn2 == null)
    {
      localbadn1 = new badn(paramInt, this.jdField_b_of_type_JavaLangString);
      this.a.put(paramInt, localbadn1);
    }
    return localbadn1;
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage().sendToTarget();
  }
  
  public void a(int paramInt)
  {
    badn.a(a(paramInt));
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    badn localbadn = (badn)this.a.get(paramInt);
    String str;
    if (localbadn != null)
    {
      paramInt = baec.a(paramLong1, paramLong2);
      str = null;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      badn.b(localbadn, str);
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
    badn localbadn = (badn)this.a.get(paramInt);
    if (localbadn != null) {
      badn.d(localbadn, paramString);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    badn localbadn = (badn)this.a.get(paramInt);
    if (localbadn != null) {
      badn.a(localbadn, paramBoolean);
    }
  }
  
  public void b(int paramInt)
  {
    badn localbadn = (badn)this.a.get(paramInt);
    if ((localbadn != null) && (badn.a(localbadn))) {
      badn.b(localbadn);
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    badn localbadn = (badn)this.a.get(paramInt);
    if (localbadn != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (String str = "dynamic";; str = "static")
    {
      badn.c(localbadn, str);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    badn localbadn = (badn)this.a.get(paramInt);
    if ((localbadn != null) && (badn.a(localbadn))) {
      badn.c(localbadn);
    }
  }
  
  public void d(int paramInt)
  {
    badn localbadn = (badn)this.a.get(paramInt);
    if ((localbadn != null) && (badn.a(localbadn))) {
      badn.a(localbadn, "sender");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     badl
 * JD-Core Version:    0.7.0.1
 */