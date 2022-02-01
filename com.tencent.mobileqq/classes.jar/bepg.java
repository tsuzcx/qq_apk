import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.together.writetogether.statemachine.EditorState;
import java.util.Arrays;
import java.util.Collections;

public class bepg
  implements beof
{
  private aofu jdField_a_of_type_Aofu = new beph(this);
  private beoe jdField_a_of_type_Beoe;
  private beqk<EditorState> jdField_a_of_type_Beqk;
  private beqs jdField_a_of_type_Beqs;
  private beqt jdField_a_of_type_Beqt;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public bepg(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, beqt parambeqt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Beqt = parambeqt;
    paramBaseActivity.addObserver(this.jdField_a_of_type_Aofu);
  }
  
  public EditorState a()
  {
    return (EditorState)this.jdField_a_of_type_Beqk.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Beqk = new beqk(EditorState.UNLOADED, "EditorStateMachineContr");
    this.jdField_a_of_type_Beqk.a(new bept(this, EditorState.UNLOADED, Collections.singletonList(EditorState.OPEN_BY_ADMIN)));
    this.jdField_a_of_type_Beqk.a(new bepj(this, EditorState.CREATING, Arrays.asList(new EditorState[] { EditorState.UNLOADED, EditorState.NET_AVAIL })));
    this.jdField_a_of_type_Beqk.a(new bept(this, EditorState.READY, Arrays.asList(new EditorState[] { EditorState.UNLOADED, EditorState.NET_AVAIL, EditorState.ROOM_FULL, EditorState.OPEN_BY_ADMIN })));
    this.jdField_a_of_type_Beqk.a(new bepk(this, EditorState.LIMITED, Arrays.asList(new EditorState[] { EditorState.UNLOADED, EditorState.NET_AVAIL })));
    this.jdField_a_of_type_Beqk.a(new bepl(this, EditorState.GAG_OR_ANONYMOUS_ON_ENTER, Arrays.asList(new EditorState[] { EditorState.UNLOADED, EditorState.NET_AVAIL, EditorState.ROOM_FULL, EditorState.OPEN_BY_ADMIN })));
    this.jdField_a_of_type_Beqk.a(new bepm(this, EditorState.ACTIVATED, Arrays.asList(new EditorState[] { EditorState.READY, EditorState.NET_AVAIL, EditorState.OPEN_BY_ADMIN })));
    this.jdField_a_of_type_Beqk.a(new bepn(this, EditorState.NET_ERR, Arrays.asList(new EditorState[] { EditorState.READY, EditorState.ACTIVATED, EditorState.NET_AVAIL, EditorState.CREATING, EditorState.OPEN_BY_ADMIN })));
    this.jdField_a_of_type_Beqk.a(new bepv(this, EditorState.BLOCKED, Arrays.asList(new EditorState[] { EditorState.READY, EditorState.ACTIVATED, EditorState.UNLOADED, EditorState.NET_AVAIL })));
    this.jdField_a_of_type_Beqk.a(new bepu(this, EditorState.GAG, Arrays.asList(new EditorState[] { EditorState.READY, EditorState.ACTIVATED, EditorState.UNLOADED, EditorState.NET_AVAIL })));
    this.jdField_a_of_type_Beqk.a(new bepo(this, EditorState.NET_AVAIL, Collections.singletonList(EditorState.NET_ERR)));
    this.jdField_a_of_type_Beqk.a(new bepr(this, EditorState.NOT_MEMBER, Arrays.asList(new EditorState[] { EditorState.READY, EditorState.ACTIVATED, EditorState.UNLOADED, EditorState.NET_AVAIL })));
    this.jdField_a_of_type_Beqk.a(new bepp(this, EditorState.CLOSED_BY_ADMIN, Arrays.asList(new EditorState[] { EditorState.READY, EditorState.ACTIVATED, EditorState.NET_ERR, EditorState.UNLOADED, EditorState.ROOM_FULL, EditorState.OVER_SIZE })));
    this.jdField_a_of_type_Beqk.a(new bepq(this, EditorState.OPEN_BY_ADMIN, Collections.singletonList(EditorState.CLOSED_BY_ADMIN)));
    this.jdField_a_of_type_Beqk.a(new bepi(this, EditorState.ROOM_FULL, Arrays.asList(new EditorState[] { EditorState.UNLOADED, EditorState.NET_AVAIL, EditorState.OPEN_BY_ADMIN, EditorState.READY, EditorState.ACTIVATED })));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Beqk.a(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case -1: 
      a(EditorState.NET_ERR);
      return;
    case 65019: 
      a(EditorState.NOT_MEMBER, paramString);
      return;
    case 65021: 
    case 65022: 
    case 65023: 
      a(EditorState.BLOCKED, paramString);
      return;
    case 65020: 
      a(EditorState.GAG, paramString);
      return;
    case -2: 
      a(EditorState.NET_AVAIL);
      return;
    case 40401: 
      a(EditorState.OVER_SIZE);
      return;
    }
    a(EditorState.ROOM_FULL);
  }
  
  public void a(beqs parambeqs)
  {
    this.jdField_a_of_type_Beqs = parambeqs;
  }
  
  public void a(EditorState paramEditorState)
  {
    this.jdField_a_of_type_Beqk.a(paramEditorState);
  }
  
  public void a(EditorState paramEditorState, String paramString)
  {
    this.jdField_a_of_type_Beqk.a(paramEditorState, paramString);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Beqs.b();
      this.jdField_a_of_type_Beoe.a(1, 60000);
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Aofu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepg
 * JD-Core Version:    0.7.0.1
 */