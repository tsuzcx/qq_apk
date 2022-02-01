import com.tencent.mobileqq.together.writetogether.statemachine.EditorState;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class bdiq
  extends bdji<EditorState>
{
  public bdiq(EditorState paramEditorState, List<EditorState> paramList)
  {
    super(paramList, localList);
  }
  
  public void a(EditorState paramEditorState)
  {
    bdid.a(this.b).b(true);
    if (QLog.isColorLevel()) {
      QLog.d("EditorStateMachineContr", 2, "[onEnter] enter: " + this.a + ", lastState: " + paramEditorState);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdiq
 * JD-Core Version:    0.7.0.1
 */