import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.tts.SilkStreamPlayer;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import mqq.manager.TicketManager;

public class bgum
  implements Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bgul jdField_a_of_type_Bgul;
  private bguo jdField_a_of_type_Bguo;
  protected bisl a;
  private SilkStreamPlayer jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer;
  private TicketManager jdField_a_of_type_MqqManagerTicketManager;
  
  public bgum(AppInterface paramAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_MqqManagerTicketManager = ((TicketManager)paramAppInterface.getManager(2));
    this.jdField_a_of_type_AndroidOsHandler = new bkys(this);
    this.jdField_a_of_type_Bgul = new bgun(this);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Bisl == null) {
      this.jdField_a_of_type_Bisl = new bisl(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
    }
    if (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing()) {
      this.jdField_a_of_type_Bisl.show();
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a();
    }
    if (this.jdField_a_of_type_Bgul != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer == null) {
        break label63;
      }
    }
    label63:
    for (String str = this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a();; str = "")
    {
      this.jdField_a_of_type_Bgul.b(str);
      if (this.jdField_a_of_type_Bguo != null) {
        this.jdField_a_of_type_Bguo.b();
      }
      return;
    }
  }
  
  public void a(bguo parambguo)
  {
    this.jdField_a_of_type_Bguo = parambguo;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, anvx.a(2131715196), 1).a();
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer = new SilkStreamPlayer(this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2, this.jdField_a_of_type_MqqManagerTicketManager.getSkey(paramString2));
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a(paramString3);
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a(this.jdField_a_of_type_Bgul, 0, 0);
    } while (this.jdField_a_of_type_Bguo == null);
    this.jdField_a_of_type_Bguo.a();
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
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.b();
    }
    this.jdField_a_of_type_Bguo = null;
    this.jdField_a_of_type_Bgul = null;
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
 * Qualified Name:     bgum
 * JD-Core Version:    0.7.0.1
 */