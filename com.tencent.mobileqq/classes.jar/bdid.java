import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.together.writetogether.statemachine.EditorState;
import java.util.Arrays;
import java.util.Collections;

public class bdid
  implements bdhc
{
  private andd jdField_a_of_type_Andd = new bdie(this);
  private bdhb jdField_a_of_type_Bdhb;
  private bdjh<EditorState> jdField_a_of_type_Bdjh;
  private bdjp jdField_a_of_type_Bdjp;
  private bdjq jdField_a_of_type_Bdjq;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public bdid(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, bdjq parambdjq)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Bdjq = parambdjq;
    paramBaseActivity.addObserver(this.jdField_a_of_type_Andd);
  }
  
  public EditorState a()
  {
    return (EditorState)this.jdField_a_of_type_Bdjh.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bdjh = new bdjh(EditorState.UNLOADED, "EditorStateMachineContr");
    this.jdField_a_of_type_Bdjh.a(new bdiq(this, EditorState.UNLOADED, Collections.singletonList(EditorState.OPEN_BY_ADMIN)));
    this.jdField_a_of_type_Bdjh.a(new bdig(this, EditorState.CREATING, Arrays.asList(new EditorState[] { EditorState.UNLOADED, EditorState.NET_AVAIL })));
    this.jdField_a_of_type_Bdjh.a(new bdiq(this, EditorState.READY, Arrays.asList(new EditorState[] { EditorState.UNLOADED, EditorState.NET_AVAIL, EditorState.ROOM_FULL, EditorState.OPEN_BY_ADMIN })));
    this.jdField_a_of_type_Bdjh.a(new bdih(this, EditorState.LIMITED, Arrays.asList(new EditorState[] { EditorState.UNLOADED, EditorState.NET_AVAIL })));
    this.jdField_a_of_type_Bdjh.a(new bdii(this, EditorState.GAG_OR_ANONYMOUS_ON_ENTER, Arrays.asList(new EditorState[] { EditorState.UNLOADED, EditorState.NET_AVAIL, EditorState.ROOM_FULL, EditorState.OPEN_BY_ADMIN })));
    this.jdField_a_of_type_Bdjh.a(new bdij(this, EditorState.ACTIVATED, Arrays.asList(new EditorState[] { EditorState.READY, EditorState.NET_AVAIL, EditorState.OPEN_BY_ADMIN })));
    this.jdField_a_of_type_Bdjh.a(new bdik(this, EditorState.NET_ERR, Arrays.asList(new EditorState[] { EditorState.READY, EditorState.ACTIVATED, EditorState.NET_AVAIL, EditorState.CREATING, EditorState.OPEN_BY_ADMIN })));
    this.jdField_a_of_type_Bdjh.a(new bdis(this, EditorState.BLOCKED, Arrays.asList(new EditorState[] { EditorState.READY, EditorState.ACTIVATED, EditorState.UNLOADED, EditorState.NET_AVAIL })));
    this.jdField_a_of_type_Bdjh.a(new bdir(this, EditorState.GAG, Arrays.asList(new EditorState[] { EditorState.READY, EditorState.ACTIVATED, EditorState.UNLOADED, EditorState.NET_AVAIL })));
    this.jdField_a_of_type_Bdjh.a(new bdil(this, EditorState.NET_AVAIL, Collections.singletonList(EditorState.NET_ERR)));
    this.jdField_a_of_type_Bdjh.a(new bdio(this, EditorState.NOT_MEMBER, Arrays.asList(new EditorState[] { EditorState.READY, EditorState.ACTIVATED, EditorState.UNLOADED, EditorState.NET_AVAIL })));
    this.jdField_a_of_type_Bdjh.a(new bdim(this, EditorState.CLOSED_BY_ADMIN, Arrays.asList(new EditorState[] { EditorState.READY, EditorState.ACTIVATED, EditorState.NET_ERR, EditorState.UNLOADED, EditorState.ROOM_FULL, EditorState.OVER_SIZE })));
    this.jdField_a_of_type_Bdjh.a(new bdin(this, EditorState.OPEN_BY_ADMIN, Collections.singletonList(EditorState.CLOSED_BY_ADMIN)));
    this.jdField_a_of_type_Bdjh.a(new bdif(this, EditorState.ROOM_FULL, Arrays.asList(new EditorState[] { EditorState.UNLOADED, EditorState.NET_AVAIL, EditorState.OPEN_BY_ADMIN, EditorState.READY, EditorState.ACTIVATED })));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Bdjh.a(paramInt);
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
  
  public void a(bdjp parambdjp)
  {
    this.jdField_a_of_type_Bdjp = parambdjp;
  }
  
  public void a(EditorState paramEditorState)
  {
    this.jdField_a_of_type_Bdjh.a(paramEditorState);
  }
  
  public void a(EditorState paramEditorState, String paramString)
  {
    this.jdField_a_of_type_Bdjh.a(paramEditorState, paramString);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Bdjp.b();
      this.jdField_a_of_type_Bdhb.a(1, 60000);
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Andd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdid
 * JD-Core Version:    0.7.0.1
 */