import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public class bgfg
  extends bgfc<bgfh, bgej>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  
  public bgfg(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public bgfh a(ViewGroup paramViewGroup)
  {
    return new bgfh(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(View paramView, bgfh parambgfh) {}
  
  public void a(bgfh parambgfh, bgej parambgej, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgfg
 * JD-Core Version:    0.7.0.1
 */