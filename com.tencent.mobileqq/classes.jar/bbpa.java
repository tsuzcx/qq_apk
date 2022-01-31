import android.os.Handler;
import com.tencent.mobileqq.widget.WebViewProgressBar;

public class bbpa
{
  private byte jdField_a_of_type_Byte = -1;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new bbpc(this);
  protected WebViewProgressBar a;
  public boolean a;
  private byte jdField_b_of_type_Byte = 6;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 255;
  private boolean jdField_b_of_type_Boolean;
  private float c;
  private float d;
  private float e;
  
  public bbpa()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  private long a(long paramLong)
  {
    long l = paramLong;
    if (paramLong > 30L) {
      l = 30L;
    }
    return l;
  }
  
  public byte a()
  {
    return this.jdField_b_of_type_Byte;
  }
  
  public float a()
  {
    return this.e;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void a()
  {
    int j = bbpb.a(0).b();
    int i = j;
    if (j <= 0) {
      i = bbpb.a(0).a();
    }
    this.c = (20.0F / i);
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_b_of_type_Byte = 0;
    this.e = this.d;
    this.jdField_b_of_type_Int = 255;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(0);
    }
    e();
  }
  
  public void a(byte paramByte)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      switch (paramByte)
      {
      default: 
        return;
      }
    } while (this.jdField_a_of_type_Byte == 0);
    this.jdField_a_of_type_Byte = 0;
    a();
    return;
    b();
    return;
    if ((this.jdField_a_of_type_Byte == 0) || (this.jdField_a_of_type_Byte == 1)) {
      c();
    }
    this.jdField_a_of_type_Byte = 2;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(WebViewProgressBar paramWebViewProgressBar)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = paramWebViewProgressBar;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean == this.jdField_a_of_type_Boolean) {}
    while (paramBoolean) {
      return;
    }
    if (this.jdField_a_of_type_Byte != 2) {
      a((byte)2);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(8);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public byte b()
  {
    return this.jdField_a_of_type_Byte;
  }
  
  public void b()
  {
    bbpb.a(0).a();
    int j = bbpb.a(1).b();
    int i = j;
    if (j <= 0) {
      i = bbpb.a(1).a();
    }
    this.c = (60.0F / i);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Byte = 2;
    this.jdField_a_of_type_Byte = 1;
    e();
  }
  
  public void c()
  {
    bbpb.a(1).a();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Byte = 5;
    this.c = 0.1333333F;
    if (this.jdField_b_of_type_Float <= 60.0F) {
      this.c = ((40.0F + (60.0F - this.jdField_b_of_type_Float) * 0.5F) / 300.0F);
    }
    for (this.jdField_a_of_type_Float = 0.8166667F;; this.jdField_a_of_type_Float = (245.0F * this.c / (100.0F - this.jdField_b_of_type_Float)))
    {
      e();
      return;
    }
  }
  
  public void d()
  {
    this.jdField_b_of_type_Byte = 6;
    this.jdField_b_of_type_Float = 0.0F;
    this.d = ((int)(this.jdField_b_of_type_Float * this.jdField_a_of_type_Int / 100.0F));
    this.jdField_b_of_type_Int = 255;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void e()
  {
    long l1;
    if (this.jdField_b_of_type_Byte != 6)
    {
      l1 = System.currentTimeMillis();
      if (this.jdField_b_of_type_Float < 100.0F) {
        break label66;
      }
      d();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(200);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(200, 20L);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.invalidate();
      }
      return;
      label66:
      long l2;
      float f;
      switch (this.jdField_b_of_type_Byte)
      {
      default: 
        break;
      case 0: 
        l2 = a(l1 - this.jdField_a_of_type_Long);
        f = this.jdField_b_of_type_Float;
        this.jdField_b_of_type_Float = ((float)l2 * this.c + f);
        this.jdField_a_of_type_Long = l1;
        if (this.jdField_b_of_type_Float >= 20.0F)
        {
          this.jdField_a_of_type_Long = l1;
          this.jdField_b_of_type_Byte = 1;
          this.c /= 5.0F;
        }
        this.e = (this.jdField_a_of_type_Int * this.jdField_b_of_type_Float / 100.0F);
        break;
      case 1: 
        l2 = a(l1 - this.jdField_a_of_type_Long);
        f = this.jdField_b_of_type_Float;
        this.jdField_b_of_type_Float = ((float)l2 * this.c + f);
        this.jdField_a_of_type_Long = l1;
        if (this.jdField_b_of_type_Float >= 98.0F)
        {
          this.jdField_a_of_type_Long = l1;
          this.jdField_b_of_type_Byte = 4;
          this.jdField_b_of_type_Float = 98.0F;
          this.c = 0.0F;
        }
        this.e = (this.jdField_a_of_type_Int * this.jdField_b_of_type_Float / 100.0F);
        break;
      case 2: 
        l2 = a(l1 - this.jdField_a_of_type_Long);
        f = this.jdField_b_of_type_Float;
        this.jdField_b_of_type_Float = ((float)l2 * this.c + f);
        this.jdField_a_of_type_Long = l1;
        if (this.jdField_b_of_type_Float >= 80.0F)
        {
          this.jdField_a_of_type_Long = l1;
          this.jdField_b_of_type_Byte = 3;
          this.c /= 20.0F;
        }
        this.e = (this.jdField_a_of_type_Int * this.jdField_b_of_type_Float / 100.0F);
        break;
      case 3: 
        l2 = a(l1 - this.jdField_a_of_type_Long);
        f = this.jdField_b_of_type_Float;
        this.jdField_b_of_type_Float = ((float)l2 * this.c + f);
        this.jdField_a_of_type_Long = l1;
        if (this.jdField_b_of_type_Float >= 98.0F)
        {
          this.jdField_a_of_type_Long = l1;
          this.jdField_b_of_type_Byte = 4;
          this.c = 0.0F;
        }
        this.e = (this.jdField_a_of_type_Int * this.jdField_b_of_type_Float / 100.0F);
        break;
      case 5: 
        l2 = a(l1 - this.jdField_a_of_type_Long);
        this.jdField_b_of_type_Float += (float)l2 * this.c;
        this.jdField_a_of_type_Long = l1;
        this.e = (this.jdField_a_of_type_Int * this.jdField_b_of_type_Float / 100.0F);
        if (this.jdField_b_of_type_Boolean)
        {
          if (this.e >= this.jdField_a_of_type_Int) {
            this.e = this.jdField_a_of_type_Int;
          }
        }
        else
        {
          this.jdField_b_of_type_Int -= (int)((float)l2 * this.jdField_a_of_type_Float);
          if (this.jdField_b_of_type_Int <= 0)
          {
            d();
            this.jdField_b_of_type_Int = 0;
          }
        }
        break;
      case 4: 
        this.e = (this.jdField_a_of_type_Int * this.jdField_b_of_type_Float / 100.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbpa
 * JD-Core Version:    0.7.0.1
 */