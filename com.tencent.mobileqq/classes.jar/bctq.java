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

public class bctq
  implements Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bctp jdField_a_of_type_Bctp;
  private bcts jdField_a_of_type_Bcts;
  protected bepp a;
  private SilkStreamPlayer jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer;
  private TicketManager jdField_a_of_type_MqqManagerTicketManager;
  
  public bctq(AppInterface paramAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_MqqManagerTicketManager = ((TicketManager)paramAppInterface.getManager(2));
    this.jdField_a_of_type_AndroidOsHandler = new bhow(this);
    this.jdField_a_of_type_Bctp = new bctr(this);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Bepp == null) {
      this.jdField_a_of_type_Bepp = new bepp(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
    }
    if (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing()) {
      this.jdField_a_of_type_Bepp.show();
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {
      this.jdField_a_of_type_Bepp.dismiss();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.b();
    }
    if (this.jdField_a_of_type_Bcts != null) {
      this.jdField_a_of_type_Bcts.b();
    }
  }
  
  public void a(bcts parambcts)
  {
    this.jdField_a_of_type_Bcts = parambcts;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (!bdee.g(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, alpo.a(2131716214), 1).a();
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer = new SilkStreamPlayer(this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2, this.jdField_a_of_type_MqqManagerTicketManager.getSkey(paramString2));
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a(this.jdField_a_of_type_Bctp);
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a(paramString3);
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a();
    } while (this.jdField_a_of_type_Bcts == null);
    this.jdField_a_of_type_Bcts.a();
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
    this.jdField_a_of_type_Bcts = null;
    this.jdField_a_of_type_Bctp = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bctq
 * JD-Core Version:    0.7.0.1
 */