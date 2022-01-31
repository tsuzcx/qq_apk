import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsShareMsg;

public class arxu
  extends aryh
{
  private boolean o;
  
  public arxu(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public boolean a()
  {
    super.a();
    this.b = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
    this.o = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_ec_live_share", false);
    if ((this.b > 0L) && (!this.o)) {
      zbj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.b, 0L, this.jdField_a_of_type_MqqObserverBusinessObserver);
    }
    G();
    Object localObject = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
    ((Bundle)localObject).putInt("req_type", 1);
    localObject = azqu.a((Bundle)localObject);
    if ((localObject != null) && ((localObject instanceof AbsShareMsg))) {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject);
    }
    H();
    return true;
  }
  
  protected boolean a(bdfq parambdfq)
  {
    if (this.o)
    {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("struct_share_key_source_name");
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceIcon = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("struct_share_key_source_icon");
    }
    if ((parambdfq != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null))
    {
      this.jdField_a_of_type_Aryq = new aryq(this, this.jdField_a_of_type_AndroidAppActivity);
      parambdfq.addView(this.jdField_a_of_type_Aryq.a());
      parambdfq.adjustMessageTopBottomMargin(0.0F, 10.0F);
      a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, parambdfq);
    }
    return false;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Bdfq.setMessage("");
  }
  
  protected boolean c()
  {
    I();
    return true;
  }
  
  protected void d()
  {
    if (this.d)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.d = false;
    }
    super.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxu
 * JD-Core Version:    0.7.0.1
 */