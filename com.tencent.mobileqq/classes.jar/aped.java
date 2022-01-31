import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import com.tencent.mobileqq.widget.ShaderAnimLayout;

public class aped
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private bcnd jdField_a_of_type_Bcnd;
  private Object jdField_a_of_type_JavaLangObject;
  
  public aped(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(bcnd parambcnd)
  {
    this.jdField_a_of_type_Bcnd = parambcnd;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public boolean a(int paramInt, View paramView, ShaderAnimLayout paramShaderAnimLayout, Button paramButton, Object paramObject)
  {
    boolean bool = false;
    if (paramShaderAnimLayout != null)
    {
      if ((this.jdField_a_of_type_JavaLangObject != null) && (this.jdField_a_of_type_JavaLangObject.equals(paramObject)))
      {
        bool = true;
        paramShaderAnimLayout.a();
        if (this.jdField_a_of_type_Bcnd != null) {
          this.jdField_a_of_type_Bcnd.setMotionView(paramView, paramInt);
        }
        paramButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramButton.setTag(Integer.valueOf(paramInt));
      }
    }
    else {
      return bool;
    }
    paramShaderAnimLayout.d();
    paramButton.setOnClickListener(null);
    paramButton.setTag(null);
    return false;
  }
  
  public int getCount()
  {
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aped
 * JD-Core Version:    0.7.0.1
 */