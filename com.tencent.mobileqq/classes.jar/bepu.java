import com.tencent.mobileqq.together.writetogether.statemachine.EditorState;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class bepu
  extends bepv
{
  public bepu(EditorState paramEditorState, List<EditorState> paramList)
  {
    super(paramEditorState, paramList, localList);
  }
  
  public void a(EditorState paramEditorState)
  {
    super.a(paramEditorState);
    bepg.a(this.jdField_a_of_type_Bepg).a(false, false);
    bepg.a(this.jdField_a_of_type_Bepg).b(false);
    QQToast.a(bepg.a(this.jdField_a_of_type_Bepg), this.jdField_a_of_type_JavaLangString, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepu
 * JD-Core Version:    0.7.0.1
 */