import com.tencent.mobileqq.together.writetogether.statemachine.EditorState;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class bepv
  extends bepw
{
  public bepv(EditorState paramEditorState, List<EditorState> paramList)
  {
    super(paramEditorState, paramList, localList);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (paramInt == 0) {
      QQToast.a(bepg.a(this.b), this.a, 0).a();
    }
  }
  
  public void a(EditorState paramEditorState)
  {
    super.a(paramEditorState);
    bepg.a(this.b).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepv
 * JD-Core Version:    0.7.0.1
 */