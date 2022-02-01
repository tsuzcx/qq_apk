import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class bcne
{
  private bggs a;
  
  public void a()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, ETTextView paramETTextView, int paramInt)
  {
    if ((bcoo.a()) && (((Boolean)bfyz.b(BaseApplicationImpl.context, paramQQAppInterface.getCurrentAccountUin(), "key_alphabetic_font_switch_status_", Boolean.valueOf(false))).booleanValue()))
    {
      paramETTextView.isParsingMagicFont = false;
      float f = 1.25F * paramInt;
      if (this.a == null)
      {
        this.a = new bggs(paramQQAppInterface, 10416);
        paramQQAppInterface = new bcnf(this, this.a, paramQQAppInterface, 1);
        paramQQAppInterface.a(paramETTextView, f, true);
        paramQQAppInterface.a(-1);
        this.a.a(paramQQAppInterface);
      }
      for (;;)
      {
        return true;
        ((bghn)this.a.a()).a(paramETTextView, f, true);
        ((bghn)this.a.a()).a(10416, 1);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcne
 * JD-Core Version:    0.7.0.1
 */