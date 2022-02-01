import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;

public class baqx
  extends barm
{
  private SparseArray<baqz> a = new SparseArray();
  private Handler jdField_b_of_type_AndroidOsHandler = new baqy(this, a());
  private String jdField_b_of_type_JavaLangString;
  
  public baqx(Context paramContext)
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
  
  private baqz a(int paramInt)
  {
    baqz localbaqz2 = (baqz)this.a.get(paramInt);
    baqz localbaqz1 = localbaqz2;
    if (localbaqz2 == null)
    {
      localbaqz1 = new baqz(paramInt, this.jdField_b_of_type_JavaLangString);
      this.a.put(paramInt, localbaqz1);
    }
    return localbaqz1;
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage().sendToTarget();
  }
  
  public void a(int paramInt)
  {
    baqz.a(a(paramInt));
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    baqz localbaqz = (baqz)this.a.get(paramInt);
    String str;
    if (localbaqz != null)
    {
      paramInt = baro.a(paramLong1, paramLong2);
      str = null;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      baqz.b(localbaqz, str);
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
    baqz localbaqz = (baqz)this.a.get(paramInt);
    if (localbaqz != null) {
      baqz.d(localbaqz, paramString);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    baqz localbaqz = (baqz)this.a.get(paramInt);
    if (localbaqz != null) {
      baqz.a(localbaqz, paramBoolean);
    }
  }
  
  public void b(int paramInt)
  {
    baqz localbaqz = (baqz)this.a.get(paramInt);
    if ((localbaqz != null) && (baqz.a(localbaqz))) {
      baqz.b(localbaqz);
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    baqz localbaqz = (baqz)this.a.get(paramInt);
    if (localbaqz != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (String str = "dynamic";; str = "static")
    {
      baqz.c(localbaqz, str);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    baqz localbaqz = (baqz)this.a.get(paramInt);
    if ((localbaqz != null) && (baqz.a(localbaqz))) {
      baqz.c(localbaqz);
    }
  }
  
  public void d(int paramInt)
  {
    baqz localbaqz = (baqz)this.a.get(paramInt);
    if ((localbaqz != null) && (baqz.a(localbaqz))) {
      baqz.a(localbaqz, "sender");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baqx
 * JD-Core Version:    0.7.0.1
 */