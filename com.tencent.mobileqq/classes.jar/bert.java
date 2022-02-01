import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.together.writetogether.data.OpenDocParam;
import com.tencent.mobileqq.togetherui.writetogether.WriteTogetherEditorFragment;
import com.tencent.mobileqq.widget.QQToast;

public class bert
  extends benp
{
  public bert(WriteTogetherEditorFragment paramWriteTogetherEditorFragment) {}
  
  public void a(int paramInt, boolean paramBoolean, beoo parambeoo)
  {
    super.a(paramInt, paramBoolean, parambeoo);
    WriteTogetherEditorFragment.a(this.a, paramBoolean, parambeoo);
  }
  
  public void a(int paramInt, boolean paramBoolean, OpenDocParam paramOpenDocParam)
  {
    super.a(paramInt, paramBoolean, paramOpenDocParam);
    WriteTogetherEditorFragment.a(this.a, paramBoolean, paramOpenDocParam);
  }
  
  public void a(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    super.a(paramInt, paramBoolean, paramArrayOfObject);
    WriteTogetherEditorFragment.a(this.a, false);
    WriteTogetherEditorFragment.b(this.a, paramBoolean);
    WriteTogetherEditorFragment.a(this.a);
    if (!paramBoolean) {
      QQToast.a(WriteTogetherEditorFragment.a(this.a), WriteTogetherEditorFragment.a(this.a).getResources().getString(2131720171), 0).a();
    }
    if (paramBoolean)
    {
      this.a.getActivity().setResult(15);
      this.a.getActivity().finish();
      WriteTogetherEditorFragment.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bert
 * JD-Core Version:    0.7.0.1
 */