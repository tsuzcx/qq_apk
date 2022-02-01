import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.together.writetogether.statemachine.EditorState;
import java.util.List;

class beoo
  extends bepm<EditorState>
{
  beoo(beoh parambeoh, EditorState paramEditorState, List paramList)
  {
    super(paramEditorState, paramList);
  }
  
  public void a(EditorState paramEditorState)
  {
    super.a(paramEditorState);
    if (bemv.a(beoh.a(this.a), beoh.a(this.a)))
    {
      beoh.a(this.a).a(false, false);
      return;
    }
    beoh.a(this.a).a(EditorState.CLOSED_BY_ADMIN, beoh.a(this.a).getString(2131719380));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beoo
 * JD-Core Version:    0.7.0.1
 */