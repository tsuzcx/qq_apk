import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;

public class auwv
  extends auxk
{
  private SparseArray<auwx> a = new SparseArray();
  private Handler jdField_b_of_type_AndroidOsHandler = new auww(this, a());
  private String jdField_b_of_type_JavaLangString;
  
  public auwv(Context paramContext)
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
  
  private auwx a(int paramInt)
  {
    auwx localauwx2 = (auwx)this.a.get(paramInt);
    auwx localauwx1 = localauwx2;
    if (localauwx2 == null)
    {
      localauwx1 = new auwx(paramInt, this.jdField_b_of_type_JavaLangString);
      this.a.put(paramInt, localauwx1);
    }
    return localauwx1;
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage().sendToTarget();
  }
  
  public void a(int paramInt)
  {
    auwx.a(a(paramInt));
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    auwx localauwx = (auwx)this.a.get(paramInt);
    String str;
    if (localauwx != null)
    {
      paramInt = auxm.a(paramLong1, paramLong2);
      str = null;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      auwx.b(localauwx, str);
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
    auwx localauwx = (auwx)this.a.get(paramInt);
    if (localauwx != null) {
      auwx.d(localauwx, paramString);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    auwx localauwx = (auwx)this.a.get(paramInt);
    if (localauwx != null) {
      auwx.a(localauwx, paramBoolean);
    }
  }
  
  public void b(int paramInt)
  {
    auwx localauwx = (auwx)this.a.get(paramInt);
    if ((localauwx != null) && (auwx.a(localauwx))) {
      auwx.b(localauwx);
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    auwx localauwx = (auwx)this.a.get(paramInt);
    if (localauwx != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (String str = "dynamic";; str = "static")
    {
      auwx.c(localauwx, str);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    auwx localauwx = (auwx)this.a.get(paramInt);
    if ((localauwx != null) && (auwx.a(localauwx))) {
      auwx.c(localauwx);
    }
  }
  
  public void d(int paramInt)
  {
    auwx localauwx = (auwx)this.a.get(paramInt);
    if ((localauwx != null) && (auwx.a(localauwx))) {
      auwx.a(localauwx, "sender");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     auwv
 * JD-Core Version:    0.7.0.1
 */