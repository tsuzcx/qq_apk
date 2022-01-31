import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;

public class axsw
  extends axtl
{
  private SparseArray<axsy> a = new SparseArray();
  private Handler jdField_b_of_type_AndroidOsHandler = new axsx(this, a());
  private String jdField_b_of_type_JavaLangString;
  
  public axsw(Context paramContext)
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
  
  private axsy a(int paramInt)
  {
    axsy localaxsy2 = (axsy)this.a.get(paramInt);
    axsy localaxsy1 = localaxsy2;
    if (localaxsy2 == null)
    {
      localaxsy1 = new axsy(paramInt, this.jdField_b_of_type_JavaLangString);
      this.a.put(paramInt, localaxsy1);
    }
    return localaxsy1;
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage().sendToTarget();
  }
  
  public void a(int paramInt)
  {
    axsy.a(a(paramInt));
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    axsy localaxsy = (axsy)this.a.get(paramInt);
    String str;
    if (localaxsy != null)
    {
      paramInt = axtn.a(paramLong1, paramLong2);
      str = null;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      axsy.b(localaxsy, str);
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
    axsy localaxsy = (axsy)this.a.get(paramInt);
    if (localaxsy != null) {
      axsy.d(localaxsy, paramString);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    axsy localaxsy = (axsy)this.a.get(paramInt);
    if (localaxsy != null) {
      axsy.a(localaxsy, paramBoolean);
    }
  }
  
  public void b(int paramInt)
  {
    axsy localaxsy = (axsy)this.a.get(paramInt);
    if ((localaxsy != null) && (axsy.a(localaxsy))) {
      axsy.b(localaxsy);
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    axsy localaxsy = (axsy)this.a.get(paramInt);
    if (localaxsy != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (String str = "dynamic";; str = "static")
    {
      axsy.c(localaxsy, str);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    axsy localaxsy = (axsy)this.a.get(paramInt);
    if ((localaxsy != null) && (axsy.a(localaxsy))) {
      axsy.c(localaxsy);
    }
  }
  
  public void d(int paramInt)
  {
    axsy localaxsy = (axsy)this.a.get(paramInt);
    if ((localaxsy != null) && (axsy.a(localaxsy))) {
      axsy.a(localaxsy, "sender");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axsw
 * JD-Core Version:    0.7.0.1
 */