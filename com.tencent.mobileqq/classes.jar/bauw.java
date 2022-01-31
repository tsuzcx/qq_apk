import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.tts.SilkStreamPlayer;
import mqq.manager.TicketManager;

public class bauw
  implements Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bauv jdField_a_of_type_Bauv;
  private bauy jdField_a_of_type_Bauy;
  protected bcqf a;
  private SilkStreamPlayer jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer;
  private TicketManager jdField_a_of_type_MqqManagerTicketManager;
  
  public bauw(AppInterface paramAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_MqqManagerTicketManager = ((TicketManager)paramAppInterface.getManager(2));
    this.jdField_a_of_type_AndroidOsHandler = new bfob(this);
    this.jdField_a_of_type_Bauv = new baux(this);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Bcqf == null) {
      this.jdField_a_of_type_Bcqf = new bcqf(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
    }
    if (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing()) {
      this.jdField_a_of_type_Bcqf.show();
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
      this.jdField_a_of_type_Bcqf.dismiss();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.b();
    }
    if (this.jdField_a_of_type_Bauy != null) {
      this.jdField_a_of_type_Bauy.b();
    }
  }
  
  public void a(bauy parambauy)
  {
    this.jdField_a_of_type_Bauy = parambauy;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (!bbfj.g(this.jdField_a_of_type_AndroidContentContext)) {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, ajya.a(2131715842), 1).a();
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer = new SilkStreamPlayer(this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2, this.jdField_a_of_type_MqqManagerTicketManager.getSkey(paramString2));
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a(this.jdField_a_of_type_Bauv);
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a(paramString3);
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a();
    } while (this.jdField_a_of_type_Bauy == null);
    this.jdField_a_of_type_Bauy.a();
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
    this.jdField_a_of_type_Bauy = null;
    this.jdField_a_of_type_Bauv = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bauw
 * JD-Core Version:    0.7.0.1
 */