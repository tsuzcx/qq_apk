import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;

public class avwo
  extends avxd
{
  private SparseArray<avwq> a = new SparseArray();
  private Handler jdField_b_of_type_AndroidOsHandler = new avwp(this, a());
  private String jdField_b_of_type_JavaLangString;
  
  public avwo(Context paramContext)
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
  
  private avwq a(int paramInt)
  {
    avwq localavwq2 = (avwq)this.a.get(paramInt);
    avwq localavwq1 = localavwq2;
    if (localavwq2 == null)
    {
      localavwq1 = new avwq(paramInt, this.jdField_b_of_type_JavaLangString);
      this.a.put(paramInt, localavwq1);
    }
    return localavwq1;
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage().sendToTarget();
  }
  
  public void a(int paramInt)
  {
    avwq.a(a(paramInt));
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    avwq localavwq = (avwq)this.a.get(paramInt);
    String str;
    if (localavwq != null)
    {
      paramInt = avxf.a(paramLong1, paramLong2);
      str = null;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      avwq.b(localavwq, str);
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
    avwq localavwq = (avwq)this.a.get(paramInt);
    if (localavwq != null) {
      avwq.d(localavwq, paramString);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    avwq localavwq = (avwq)this.a.get(paramInt);
    if (localavwq != null) {
      avwq.a(localavwq, paramBoolean);
    }
  }
  
  public void b(int paramInt)
  {
    avwq localavwq = (avwq)this.a.get(paramInt);
    if ((localavwq != null) && (avwq.a(localavwq))) {
      avwq.b(localavwq);
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    avwq localavwq = (avwq)this.a.get(paramInt);
    if (localavwq != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (String str = "dynamic";; str = "static")
    {
      avwq.c(localavwq, str);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    avwq localavwq = (avwq)this.a.get(paramInt);
    if ((localavwq != null) && (avwq.a(localavwq))) {
      avwq.c(localavwq);
    }
  }
  
  public void d(int paramInt)
  {
    avwq localavwq = (avwq)this.a.get(paramInt);
    if ((localavwq != null) && (avwq.a(localavwq))) {
      avwq.a(localavwq, "sender");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avwo
 * JD-Core Version:    0.7.0.1
 */