import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.tts.SilkStreamPlayer;
import com.tencent.mobileqq.widget.QQToast;
import mqq.manager.TicketManager;

public class bhcj
  implements Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bhci jdField_a_of_type_Bhci;
  private bhcl jdField_a_of_type_Bhcl;
  protected bjbs a;
  private SilkStreamPlayer jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer;
  private TicketManager jdField_a_of_type_MqqManagerTicketManager;
  
  public bhcj(AppInterface paramAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_MqqManagerTicketManager = ((TicketManager)paramAppInterface.getManager(2));
    this.jdField_a_of_type_AndroidOsHandler = new blhq(this);
    this.jdField_a_of_type_Bhci = new bhck(this);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Bjbs == null) {
      this.jdField_a_of_type_Bjbs = new bjbs(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
    }
    if (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing()) {
      this.jdField_a_of_type_Bjbs.show();
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
      this.jdField_a_of_type_Bjbs.dismiss();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.b();
    }
    if (this.jdField_a_of_type_Bhcl != null) {
      this.jdField_a_of_type_Bhcl.b();
    }
  }
  
  public void a(bhcl parambhcl)
  {
    this.jdField_a_of_type_Bhcl = parambhcl;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (!bhnv.g(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, anzj.a(2131714616), 1).a();
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer = new SilkStreamPlayer(this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2, this.jdField_a_of_type_MqqManagerTicketManager.getSkey(paramString2));
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a(this.jdField_a_of_type_Bhci);
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a(paramString3);
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a();
    } while (this.jdField_a_of_type_Bhcl == null);
    this.jdField_a_of_type_Bhcl.a();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a();
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.c();
    }
    this.jdField_a_of_type_Bhcl = null;
    this.jdField_a_of_type_Bhci = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      c();
      continue;
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhcj
 * JD-Core Version:    0.7.0.1
 */