import android.content.Context;
import com.tencent.mobileqq.together.writetogether.statemachine.UserState;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Collections;

public class beoy
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private beno jdField_a_of_type_Beno;
  private beob jdField_a_of_type_Beob;
  private bepl<UserState> jdField_a_of_type_Bepl;
  private bepz jdField_a_of_type_Bepz;
  
  public beoy(Context paramContext, int paramInt, bepz parambepz, beob parambeob)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bepz = parambepz;
    this.jdField_a_of_type_Beob = parambeob;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Bepz.f();
    bdll.b(null, "dc00898", "", "", "0X800B2D8", "0X800B2D8", 0, 0, "", "", "", "");
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bepl.a() != UserState.ALERT) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("UserStateMachineControl", 2, "showAlertWording");
    }
    this.jdField_a_of_type_Bepz.a(paramBoolean);
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("UserStateMachineControl", 2, "showAvailableWording");
    }
    this.jdField_a_of_type_Bepz.e();
  }
  
  public UserState a()
  {
    return (UserState)this.jdField_a_of_type_Bepl.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Bepl.a(paramInt);
  }
  
  public void a(beno parambeno)
  {
    this.jdField_a_of_type_Beno = parambeno;
    this.jdField_a_of_type_Bepl = new bepl(UserState.INACTIVATED, "UserStateMachineControl");
    this.jdField_a_of_type_Bepl.a(new bepm(UserState.COMMIT_WHILE_ALERT, Arrays.asList(new UserState[] { UserState.ALERT, UserState.NET_AVAIL, UserState.COMMIT_ERR })));
    this.jdField_a_of_type_Bepl.a(new bepm(UserState.ACCEPT_WHILE_ALERT, Arrays.asList(new UserState[] { UserState.COMMIT_WHILE_ALERT, UserState.NET_AVAIL })));
    this.jdField_a_of_type_Bepl.a(new bepm(UserState.INACTIVATED, Collections.singletonList(UserState.INACTIVATED)));
    this.jdField_a_of_type_Bepl.a(new beoz(this, UserState.ALERT, Arrays.asList(new UserState[] { UserState.NEW_USER_HINT, UserState.INACTIVATED, UserState.ROOM_AVAILABLE, UserState.LAST_EDIT })));
    this.jdField_a_of_type_Bepl.a(new bepd(this, UserState.NEW_DOC, Arrays.asList(new UserState[] { UserState.ALERT, UserState.INACTIVATED, UserState.CHARACTERS_OVERSIZE })));
    this.jdField_a_of_type_Bepl.a(new bepe(this, UserState.LAST_EDIT, Arrays.asList(new UserState[] { UserState.ALERT, UserState.INACTIVATED, UserState.NET_AVAIL, UserState.COMMIT_ERR })));
    this.jdField_a_of_type_Bepl.a(new bepf(this, UserState.LAST_SAVE, Arrays.asList(new UserState[] { UserState.SAVING, UserState.ACCEPT_WHILE_ALERT, UserState.NET_AVAIL, UserState.COMMIT_ERR })));
    this.jdField_a_of_type_Bepl.a(new bepg(this, UserState.SAVING, Arrays.asList(new UserState[] { UserState.CHARACTERS_OVERSIZE, UserState.LAST_EDIT, UserState.LAST_SAVE, UserState.COMMIT_WHILE_ALERT, UserState.NET_AVAIL })));
    this.jdField_a_of_type_Bepl.a(new beph(this, UserState.ROOM_FULL, Arrays.asList(new UserState[] { UserState.INACTIVATED, UserState.NET_AVAIL, UserState.LAST_EDIT, UserState.LAST_SAVE, UserState.CHARACTERS_OVERSIZE, UserState.SAVING })));
    this.jdField_a_of_type_Bepl.a(new bepi(this, UserState.ROOM_AVAILABLE, Arrays.asList(new UserState[] { UserState.ROOM_FULL, UserState.NET_AVAIL })));
    this.jdField_a_of_type_Bepl.a(new bepm(UserState.CHARACTERS_OVERSIZE, Arrays.asList(new UserState[] { UserState.CHARACTERS_OVERSIZE, UserState.LAST_EDIT, UserState.LAST_SAVE, UserState.NET_AVAIL, UserState.COMMIT_ERR, UserState.NEW_DOC, UserState.SAVING, UserState.ALERT })));
    this.jdField_a_of_type_Bepl.a(new bepm(UserState.NEW_USER_HINT, Arrays.asList(new UserState[] { UserState.INACTIVATED, UserState.NET_AVAIL })));
    this.jdField_a_of_type_Bepl.a(new bepj(this, UserState.NET_ERR, Arrays.asList(new UserState[] { UserState.ROOM_AVAILABLE, UserState.LAST_EDIT, UserState.LAST_SAVE, UserState.CHARACTERS_OVERSIZE, UserState.SAVING, UserState.COMMIT_WHILE_ALERT, UserState.ACCEPT_WHILE_ALERT })));
    this.jdField_a_of_type_Bepl.a(new bepk(this, UserState.NET_AVAIL, Collections.singletonList(UserState.NET_ERR)));
    this.jdField_a_of_type_Bepl.a(new bepa(this, UserState.COMMIT_ERR, Collections.singletonList(UserState.SAVING)));
    this.jdField_a_of_type_Bepl.a(new bepb(this, UserState.SANCTION, Collections.singletonList(UserState.INACTIVATED)));
    this.jdField_a_of_type_Bepl.a(new bepc(this, UserState.GAG, Arrays.asList(new UserState[] { UserState.SAVING, UserState.COMMIT_WHILE_ALERT })));
  }
  
  public void a(UserState paramUserState)
  {
    this.jdField_a_of_type_Bepl.a(paramUserState);
  }
  
  public void a(UserState paramUserState, String paramString)
  {
    this.jdField_a_of_type_Bepl.a(paramUserState, paramString);
  }
  
  public UserState b()
  {
    return (UserState)this.jdField_a_of_type_Bepl.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beoy
 * JD-Core Version:    0.7.0.1
 */