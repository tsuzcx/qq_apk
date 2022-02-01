import android.content.Context;
import com.tencent.mobileqq.together.writetogether.statemachine.UserState;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Collections;

public class bdiu
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bdhg jdField_a_of_type_Bdhg;
  private bdht jdField_a_of_type_Bdht;
  private bdjh<UserState> jdField_a_of_type_Bdjh;
  private bdkh jdField_a_of_type_Bdkh;
  
  public bdiu(Context paramContext, int paramInt, bdkh parambdkh, bdht parambdht)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bdkh = parambdkh;
    this.jdField_a_of_type_Bdht = parambdht;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Bdkh.f();
    bcef.b(null, "dc00898", "", "", "0X800B2D8", "0X800B2D8", 0, 0, "", "", "", "");
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bdjh.a() != UserState.ALERT) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("UserStateMachineControl", 2, "showAlertWording");
    }
    this.jdField_a_of_type_Bdkh.a(paramBoolean);
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("UserStateMachineControl", 2, "showAvailableWording");
    }
    this.jdField_a_of_type_Bdkh.e();
  }
  
  public UserState a()
  {
    return (UserState)this.jdField_a_of_type_Bdjh.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Bdjh.a(paramInt);
  }
  
  public void a(bdhg parambdhg)
  {
    this.jdField_a_of_type_Bdhg = parambdhg;
    this.jdField_a_of_type_Bdjh = new bdjh(UserState.INACTIVATED, "UserStateMachineControl");
    this.jdField_a_of_type_Bdjh.a(new bdji(UserState.COMMIT_WHILE_ALERT, Arrays.asList(new UserState[] { UserState.ALERT, UserState.NET_AVAIL, UserState.COMMIT_ERR })));
    this.jdField_a_of_type_Bdjh.a(new bdji(UserState.ACCEPT_WHILE_ALERT, Arrays.asList(new UserState[] { UserState.COMMIT_WHILE_ALERT, UserState.NET_AVAIL })));
    this.jdField_a_of_type_Bdjh.a(new bdji(UserState.INACTIVATED, Collections.singletonList(UserState.INACTIVATED)));
    this.jdField_a_of_type_Bdjh.a(new bdiv(this, UserState.ALERT, Arrays.asList(new UserState[] { UserState.NEW_USER_HINT, UserState.INACTIVATED, UserState.ROOM_AVAILABLE, UserState.LAST_EDIT })));
    this.jdField_a_of_type_Bdjh.a(new bdiz(this, UserState.NEW_DOC, Arrays.asList(new UserState[] { UserState.ALERT, UserState.INACTIVATED, UserState.CHARACTERS_OVERSIZE })));
    this.jdField_a_of_type_Bdjh.a(new bdja(this, UserState.LAST_EDIT, Arrays.asList(new UserState[] { UserState.ALERT, UserState.INACTIVATED, UserState.NET_AVAIL, UserState.COMMIT_ERR })));
    this.jdField_a_of_type_Bdjh.a(new bdjb(this, UserState.LAST_SAVE, Arrays.asList(new UserState[] { UserState.SAVING, UserState.ACCEPT_WHILE_ALERT, UserState.NET_AVAIL, UserState.COMMIT_ERR })));
    this.jdField_a_of_type_Bdjh.a(new bdjc(this, UserState.SAVING, Arrays.asList(new UserState[] { UserState.CHARACTERS_OVERSIZE, UserState.LAST_EDIT, UserState.LAST_SAVE, UserState.COMMIT_WHILE_ALERT, UserState.NET_AVAIL })));
    this.jdField_a_of_type_Bdjh.a(new bdjd(this, UserState.ROOM_FULL, Arrays.asList(new UserState[] { UserState.INACTIVATED, UserState.NET_AVAIL, UserState.LAST_EDIT, UserState.LAST_SAVE, UserState.CHARACTERS_OVERSIZE, UserState.SAVING })));
    this.jdField_a_of_type_Bdjh.a(new bdje(this, UserState.ROOM_AVAILABLE, Arrays.asList(new UserState[] { UserState.ROOM_FULL, UserState.NET_AVAIL })));
    this.jdField_a_of_type_Bdjh.a(new bdji(UserState.CHARACTERS_OVERSIZE, Arrays.asList(new UserState[] { UserState.CHARACTERS_OVERSIZE, UserState.LAST_EDIT, UserState.LAST_SAVE, UserState.NET_AVAIL, UserState.COMMIT_ERR, UserState.NEW_DOC, UserState.SAVING, UserState.ALERT })));
    this.jdField_a_of_type_Bdjh.a(new bdji(UserState.NEW_USER_HINT, Arrays.asList(new UserState[] { UserState.INACTIVATED, UserState.NET_AVAIL })));
    this.jdField_a_of_type_Bdjh.a(new bdjf(this, UserState.NET_ERR, Arrays.asList(new UserState[] { UserState.ROOM_AVAILABLE, UserState.LAST_EDIT, UserState.LAST_SAVE, UserState.CHARACTERS_OVERSIZE, UserState.SAVING, UserState.COMMIT_WHILE_ALERT, UserState.ACCEPT_WHILE_ALERT })));
    this.jdField_a_of_type_Bdjh.a(new bdjg(this, UserState.NET_AVAIL, Collections.singletonList(UserState.NET_ERR)));
    this.jdField_a_of_type_Bdjh.a(new bdiw(this, UserState.COMMIT_ERR, Collections.singletonList(UserState.SAVING)));
    this.jdField_a_of_type_Bdjh.a(new bdix(this, UserState.SANCTION, Collections.singletonList(UserState.INACTIVATED)));
    this.jdField_a_of_type_Bdjh.a(new bdiy(this, UserState.GAG, Arrays.asList(new UserState[] { UserState.SAVING, UserState.COMMIT_WHILE_ALERT })));
  }
  
  public void a(UserState paramUserState)
  {
    this.jdField_a_of_type_Bdjh.a(paramUserState);
  }
  
  public void a(UserState paramUserState, String paramString)
  {
    this.jdField_a_of_type_Bdjh.a(paramUserState, paramString);
  }
  
  public UserState b()
  {
    return (UserState)this.jdField_a_of_type_Bdjh.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdiu
 * JD-Core Version:    0.7.0.1
 */