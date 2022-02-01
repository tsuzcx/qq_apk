import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.together.writetogether.statemachine.EditorState;
import java.util.List;

class bdik
  extends bdji<EditorState>
{
  bdik(bdid parambdid, EditorState paramEditorState, List paramList)
  {
    super(paramEditorState, paramList);
  }
  
  public void a(EditorState paramEditorState)
  {
    super.a(paramEditorState);
    if (bdgn.a(bdid.a(this.a), bdid.a(this.a)))
    {
      bdid.a(this.a).a(false, false);
      return;
    }
    bdid.a(this.a).a(EditorState.CLOSED_BY_ADMIN, bdid.a(this.a).getString(2131719699));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdik
 * JD-Core Version:    0.7.0.1
 */