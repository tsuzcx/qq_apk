import android.content.Context;
import com.tencent.mobileqq.together.writetogether.statemachine.UserState;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Collections;

public class bepx
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private beoj jdField_a_of_type_Beoj;
  private beow jdField_a_of_type_Beow;
  private beqk<UserState> jdField_a_of_type_Beqk;
  private berk jdField_a_of_type_Berk;
  
  public bepx(Context paramContext, int paramInt, berk paramberk, beow parambeow)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Berk = paramberk;
    this.jdField_a_of_type_Beow = parambeow;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Berk.f();
    bdla.b(null, "dc00898", "", "", "0X800B2D8", "0X800B2D8", 0, 0, "", "", "", "");
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Beqk.a() != UserState.ALERT) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("UserStateMachineControl", 2, "showAlertWording");
    }
    this.jdField_a_of_type_Berk.a(paramBoolean);
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("UserStateMachineControl", 2, "showAvailableWording");
    }
    this.jdField_a_of_type_Berk.e();
  }
  
  public UserState a()
  {
    return (UserState)this.jdField_a_of_type_Beqk.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Beqk.a(paramInt);
  }
  
  public void a(beoj parambeoj)
  {
    this.jdField_a_of_type_Beoj = parambeoj;
    this.jdField_a_of_type_Beqk = new beqk(UserState.INACTIVATED, "UserStateMachineControl");
    this.jdField_a_of_type_Beqk.a(new beql(UserState.COMMIT_WHILE_ALERT, Arrays.asList(new UserState[] { UserState.ALERT, UserState.NET_AVAIL, UserState.COMMIT_ERR })));
    this.jdField_a_of_type_Beqk.a(new beql(UserState.ACCEPT_WHILE_ALERT, Arrays.asList(new UserState[] { UserState.COMMIT_WHILE_ALERT, UserState.NET_AVAIL })));
    this.jdField_a_of_type_Beqk.a(new beql(UserState.INACTIVATED, Collections.singletonList(UserState.INACTIVATED)));
    this.jdField_a_of_type_Beqk.a(new bepy(this, UserState.ALERT, Arrays.asList(new UserState[] { UserState.NEW_USER_HINT, UserState.INACTIVATED, UserState.ROOM_AVAILABLE, UserState.LAST_EDIT })));
    this.jdField_a_of_type_Beqk.a(new beqc(this, UserState.NEW_DOC, Arrays.asList(new UserState[] { UserState.ALERT, UserState.INACTIVATED, UserState.CHARACTERS_OVERSIZE })));
    this.jdField_a_of_type_Beqk.a(new beqd(this, UserState.LAST_EDIT, Arrays.asList(new UserState[] { UserState.ALERT, UserState.INACTIVATED, UserState.NET_AVAIL, UserState.COMMIT_ERR })));
    this.jdField_a_of_type_Beqk.a(new beqe(this, UserState.LAST_SAVE, Arrays.asList(new UserState[] { UserState.SAVING, UserState.ACCEPT_WHILE_ALERT, UserState.NET_AVAIL, UserState.COMMIT_ERR })));
    this.jdField_a_of_type_Beqk.a(new beqf(this, UserState.SAVING, Arrays.asList(new UserState[] { UserState.CHARACTERS_OVERSIZE, UserState.LAST_EDIT, UserState.LAST_SAVE, UserState.COMMIT_WHILE_ALERT, UserState.NET_AVAIL })));
    this.jdField_a_of_type_Beqk.a(new beqg(this, UserState.ROOM_FULL, Arrays.asList(new UserState[] { UserState.INACTIVATED, UserState.NET_AVAIL, UserState.LAST_EDIT, UserState.LAST_SAVE, UserState.CHARACTERS_OVERSIZE, UserState.SAVING })));
    this.jdField_a_of_type_Beqk.a(new beqh(this, UserState.ROOM_AVAILABLE, Arrays.asList(new UserState[] { UserState.ROOM_FULL, UserState.NET_AVAIL })));
    this.jdField_a_of_type_Beqk.a(new beql(UserState.CHARACTERS_OVERSIZE, Arrays.asList(new UserState[] { UserState.CHARACTERS_OVERSIZE, UserState.LAST_EDIT, UserState.LAST_SAVE, UserState.NET_AVAIL, UserState.COMMIT_ERR, UserState.NEW_DOC, UserState.SAVING, UserState.ALERT })));
    this.jdField_a_of_type_Beqk.a(new beql(UserState.NEW_USER_HINT, Arrays.asList(new UserState[] { UserState.INACTIVATED, UserState.NET_AVAIL })));
    this.jdField_a_of_type_Beqk.a(new beqi(this, UserState.NET_ERR, Arrays.asList(new UserState[] { UserState.ROOM_AVAILABLE, UserState.LAST_EDIT, UserState.LAST_SAVE, UserState.CHARACTERS_OVERSIZE, UserState.SAVING, UserState.COMMIT_WHILE_ALERT, UserState.ACCEPT_WHILE_ALERT })));
    this.jdField_a_of_type_Beqk.a(new beqj(this, UserState.NET_AVAIL, Collections.singletonList(UserState.NET_ERR)));
    this.jdField_a_of_type_Beqk.a(new bepz(this, UserState.COMMIT_ERR, Collections.singletonList(UserState.SAVING)));
    this.jdField_a_of_type_Beqk.a(new beqa(this, UserState.SANCTION, Collections.singletonList(UserState.INACTIVATED)));
    this.jdField_a_of_type_Beqk.a(new beqb(this, UserState.GAG, Arrays.asList(new UserState[] { UserState.SAVING, UserState.COMMIT_WHILE_ALERT })));
  }
  
  public void a(UserState paramUserState)
  {
    this.jdField_a_of_type_Beqk.a(paramUserState);
  }
  
  public void a(UserState paramUserState, String paramString)
  {
    this.jdField_a_of_type_Beqk.a(paramUserState, paramString);
  }
  
  public UserState b()
  {
    return (UserState)this.jdField_a_of_type_Beqk.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepx
 * JD-Core Version:    0.7.0.1
 */