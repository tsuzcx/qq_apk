import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.together.writetogether.data.OpenDocParam;
import com.tencent.mobileqq.together.writetogether.view.WriteTogetherEditorFragment;
import com.tencent.mobileqq.widget.QQToast;

public class beqf
  extends bemu
{
  public beqf(WriteTogetherEditorFragment paramWriteTogetherEditorFragment) {}
  
  public void a(int paramInt, boolean paramBoolean, bent parambent)
  {
    super.a(paramInt, paramBoolean, parambent);
    WriteTogetherEditorFragment.a(this.a, paramBoolean, parambent);
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
      QQToast.a(WriteTogetherEditorFragment.a(this.a), WriteTogetherEditorFragment.a(this.a).getResources().getString(2131719397), 0).a();
    }
    if (paramBoolean)
    {
      this.a.getActivity().setResult(15);
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqf
 * JD-Core Version:    0.7.0.1
 */