import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;

public class bbjq
  extends bbkf
{
  private SparseArray<bbjs> a = new SparseArray();
  private Handler jdField_b_of_type_AndroidOsHandler = new bbjr(this, a());
  private String jdField_b_of_type_JavaLangString;
  
  public bbjq(Context paramContext)
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
  
  private bbjs a(int paramInt)
  {
    bbjs localbbjs2 = (bbjs)this.a.get(paramInt);
    bbjs localbbjs1 = localbbjs2;
    if (localbbjs2 == null)
    {
      localbbjs1 = new bbjs(paramInt, this.jdField_b_of_type_JavaLangString);
      this.a.put(paramInt, localbbjs1);
    }
    return localbbjs1;
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage().sendToTarget();
  }
  
  public void a(int paramInt)
  {
    bbjs.a(a(paramInt));
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    bbjs localbbjs = (bbjs)this.a.get(paramInt);
    String str;
    if (localbbjs != null)
    {
      paramInt = bbkh.a(paramLong1, paramLong2);
      str = null;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      bbjs.b(localbbjs, str);
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
    bbjs localbbjs = (bbjs)this.a.get(paramInt);
    if (localbbjs != null) {
      bbjs.d(localbbjs, paramString);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    bbjs localbbjs = (bbjs)this.a.get(paramInt);
    if (localbbjs != null) {
      bbjs.a(localbbjs, paramBoolean);
    }
  }
  
  public void b(int paramInt)
  {
    bbjs localbbjs = (bbjs)this.a.get(paramInt);
    if ((localbbjs != null) && (bbjs.a(localbbjs))) {
      bbjs.b(localbbjs);
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    bbjs localbbjs = (bbjs)this.a.get(paramInt);
    if (localbbjs != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (String str = "dynamic";; str = "static")
    {
      bbjs.c(localbbjs, str);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    bbjs localbbjs = (bbjs)this.a.get(paramInt);
    if ((localbbjs != null) && (bbjs.a(localbbjs))) {
      bbjs.c(localbbjs);
    }
  }
  
  public void d(int paramInt)
  {
    bbjs localbbjs = (bbjs)this.a.get(paramInt);
    if ((localbbjs != null) && (bbjs.a(localbbjs))) {
      bbjs.a(localbbjs, "sender");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbjq
 * JD-Core Version:    0.7.0.1
 */