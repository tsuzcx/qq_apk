import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;

public class axon
  extends axpc
{
  private SparseArray<axop> a = new SparseArray();
  private Handler jdField_b_of_type_AndroidOsHandler = new axoo(this, a());
  private String jdField_b_of_type_JavaLangString;
  
  public axon(Context paramContext)
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
  
  private axop a(int paramInt)
  {
    axop localaxop2 = (axop)this.a.get(paramInt);
    axop localaxop1 = localaxop2;
    if (localaxop2 == null)
    {
      localaxop1 = new axop(paramInt, this.jdField_b_of_type_JavaLangString);
      this.a.put(paramInt, localaxop1);
    }
    return localaxop1;
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage().sendToTarget();
  }
  
  public void a(int paramInt)
  {
    axop.a(a(paramInt));
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    axop localaxop = (axop)this.a.get(paramInt);
    String str;
    if (localaxop != null)
    {
      paramInt = axpe.a(paramLong1, paramLong2);
      str = null;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      axop.b(localaxop, str);
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
    axop localaxop = (axop)this.a.get(paramInt);
    if (localaxop != null) {
      axop.d(localaxop, paramString);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    axop localaxop = (axop)this.a.get(paramInt);
    if (localaxop != null) {
      axop.a(localaxop, paramBoolean);
    }
  }
  
  public void b(int paramInt)
  {
    axop localaxop = (axop)this.a.get(paramInt);
    if ((localaxop != null) && (axop.a(localaxop))) {
      axop.b(localaxop);
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    axop localaxop = (axop)this.a.get(paramInt);
    if (localaxop != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (String str = "dynamic";; str = "static")
    {
      axop.c(localaxop, str);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    axop localaxop = (axop)this.a.get(paramInt);
    if ((localaxop != null) && (axop.a(localaxop))) {
      axop.c(localaxop);
    }
  }
  
  public void d(int paramInt)
  {
    axop localaxop = (axop)this.a.get(paramInt);
    if ((localaxop != null) && (axop.a(localaxop))) {
      axop.a(localaxop, "sender");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axon
 * JD-Core Version:    0.7.0.1
 */