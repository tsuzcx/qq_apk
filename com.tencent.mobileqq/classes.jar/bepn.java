import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.together.writetogether.statemachine.EditorState;
import java.util.List;

class bepn
  extends beql<EditorState>
{
  bepn(bepg parambepg, EditorState paramEditorState, List paramList)
  {
    super(paramEditorState, paramList);
  }
  
  public void a(EditorState paramEditorState)
  {
    super.a(paramEditorState);
    if (benq.a(bepg.a(this.a), bepg.a(this.a)))
    {
      bepg.a(this.a).a(false, false);
      return;
    }
    bepg.a(this.a).a(EditorState.CLOSED_BY_ADMIN, bepg.a(this.a).getString(2131720152));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepn
 * JD-Core Version:    0.7.0.1
 */