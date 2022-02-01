import com.tencent.mobileqq.together.writetogether.statemachine.EditorState;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class bepw
  extends beql<EditorState>
{
  public bepw(EditorState paramEditorState, List<EditorState> paramList)
  {
    super(paramList, localList);
  }
  
  public void a(EditorState paramEditorState)
  {
    bepg.a(this.c).b(false);
    if (QLog.isColorLevel()) {
      QLog.d("EditorStateMachineContr", 2, "[onEnter] enter: " + this.a + ", lastState: " + paramEditorState);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepw
 * JD-Core Version:    0.7.0.1
 */