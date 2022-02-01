import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.resourcesgrab.ResourceGrabFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class balg
  implements View.OnClickListener
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private List<baky> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean;
  
  balg(List<baky> paramList, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ResourceNameOnClickListener", 2, "ResourceNameOnClickListener onLongClick");
    }
    Object localObject1 = null;
    if ((paramView.getContext() instanceof Activity)) {
      localObject1 = (Activity)paramView.getContext();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = BaseActivity.sTopActivity;
    }
    if ((localObject2 instanceof FragmentActivity))
    {
      localObject1 = ((FragmentActivity)localObject2).getSupportFragmentManager().findFragmentByTag("ResourceGrabFragment");
      if ((localObject1 instanceof ResourceGrabFragment))
      {
        localObject1 = (ResourceGrabFragment)localObject1;
        localObject2 = (balb)axbe.a((ViewModelStoreOwner)localObject1).get(balb.class);
        ((ResourceGrabFragment)localObject1).a(this.jdField_a_of_type_JavaUtilList);
        if (((ResourceGrabFragment)localObject1).a()) {
          ((balb)localObject2).a(this.jdField_a_of_type_JavaUtilList);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     balg
 * JD-Core Version:    0.7.0.1
 */