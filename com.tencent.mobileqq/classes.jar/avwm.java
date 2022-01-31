import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;

public class avwm
  extends avxb
{
  private SparseArray<avwo> a = new SparseArray();
  private Handler jdField_b_of_type_AndroidOsHandler = new avwn(this, a());
  private String jdField_b_of_type_JavaLangString;
  
  public avwm(Context paramContext)
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
  
  private avwo a(int paramInt)
  {
    avwo localavwo2 = (avwo)this.a.get(paramInt);
    avwo localavwo1 = localavwo2;
    if (localavwo2 == null)
    {
      localavwo1 = new avwo(paramInt, this.jdField_b_of_type_JavaLangString);
      this.a.put(paramInt, localavwo1);
    }
    return localavwo1;
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage().sendToTarget();
  }
  
  public void a(int paramInt)
  {
    avwo.a(a(paramInt));
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    avwo localavwo = (avwo)this.a.get(paramInt);
    String str;
    if (localavwo != null)
    {
      paramInt = avxd.a(paramLong1, paramLong2);
      str = null;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      avwo.b(localavwo, str);
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
    avwo localavwo = (avwo)this.a.get(paramInt);
    if (localavwo != null) {
      avwo.d(localavwo, paramString);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    avwo localavwo = (avwo)this.a.get(paramInt);
    if (localavwo != null) {
      avwo.a(localavwo, paramBoolean);
    }
  }
  
  public void b(int paramInt)
  {
    avwo localavwo = (avwo)this.a.get(paramInt);
    if ((localavwo != null) && (avwo.a(localavwo))) {
      avwo.b(localavwo);
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    avwo localavwo = (avwo)this.a.get(paramInt);
    if (localavwo != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (String str = "dynamic";; str = "static")
    {
      avwo.c(localavwo, str);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    avwo localavwo = (avwo)this.a.get(paramInt);
    if ((localavwo != null) && (avwo.a(localavwo))) {
      avwo.c(localavwo);
    }
  }
  
  public void d(int paramInt)
  {
    avwo localavwo = (avwo)this.a.get(paramInt);
    if ((localavwo != null) && (avwo.a(localavwo))) {
      avwo.a(localavwo, "sender");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avwm
 * JD-Core Version:    0.7.0.1
 */