import android.arch.lifecycle.ViewModel;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.BaseConstantState;
import com.tencent.theme.SkinData;
import com.tencent.theme.SkinEngine;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class bbfe
  extends ViewModel
{
  private bbev jdField_a_of_type_Bbev;
  private final bbfj[] jdField_a_of_type_ArrayOfBbfj = { new bbfh(), new bbfi(), new bbfk() };
  
  private View.OnClickListener a(View paramView)
  {
    try
    {
      Object localObject = View.class.getDeclaredMethod("getListenerInfo", new Class[0]);
      if (!((Method)localObject).isAccessible()) {
        ((Method)localObject).setAccessible(true);
      }
      paramView = ((Method)localObject).invoke(paramView, new Object[0]);
      localObject = paramView.getClass().getDeclaredField("mOnClickListener");
      ((Field)localObject).setAccessible(true);
      paramView = (View.OnClickListener)((Field)localObject).get(paramView);
      return paramView;
    }
    catch (Throwable paramView)
    {
      QLog.d("ResourceGrabViewModel", 1, paramView, new Object[0]);
    }
    return null;
  }
  
  private List<bbfb> a(List<bbfb> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      HashSet localHashSet = new HashSet();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bbfb localbbfb = (bbfb)paramList.next();
        if (!localHashSet.contains(localbbfb.jdField_a_of_type_ComTencentThemeSkinData.mFileName)) {
          localArrayList.add(localbbfb);
        }
        localHashSet.add(localbbfb.jdField_a_of_type_ComTencentThemeSkinData.mFileName);
      }
    }
    return localArrayList;
  }
  
  private void a(Drawable paramDrawable, List<bbfb> paramList, int paramInt)
  {
    if ((paramDrawable != null) && (paramDrawable.getConstantState() != null) && (paramList != null))
    {
      paramDrawable = paramDrawable.getConstantState();
      if (!(paramDrawable instanceof BaseConstantState)) {
        break label81;
      }
      paramList.add(new bbfb(paramInt, ((BaseConstantState)paramDrawable).skinData));
      if (QLog.isColorLevel()) {
        QLog.d("ResourceGrabViewModel", 2, "getFileNameByConstantState BaseConstantState resourceNames -> " + paramList);
      }
    }
    for (;;)
    {
      return;
      label81:
      if ((paramDrawable instanceof DrawableContainer.DrawableContainerState))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ResourceGrabViewModel", 2, "getFileNameByConstantState DrawableContainerState");
        }
        paramDrawable = ((DrawableContainer.DrawableContainerState)paramDrawable).getChildren();
        int j = paramDrawable.length;
        int i = 0;
        while (i < j)
        {
          Drawable localDrawable = paramDrawable[i];
          if (localDrawable != null) {
            a(localDrawable, paramList, paramInt);
          }
          i += 1;
        }
      }
    }
  }
  
  private void a(View paramView, View.OnClickListener paramOnClickListener)
  {
    if ((paramOnClickListener instanceof bbfg))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ResourceGrabViewModel", 2, "recovery onClick listener");
      }
      paramOnClickListener = (bbfg)paramOnClickListener;
      paramView.setOnClickListener(paramOnClickListener.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setClickable(paramOnClickListener.jdField_a_of_type_Boolean);
    }
  }
  
  private void a(View paramView, List<bbfb> paramList)
  {
    int i = 0;
    a(paramView.getBackground(), paramList, 0);
    bbfj[] arrayOfbbfj = this.jdField_a_of_type_ArrayOfBbfj;
    int j = arrayOfbbfj.length;
    while (i < j)
    {
      Object localObject = arrayOfbbfj[i];
      if (localObject != null)
      {
        localObject = ((bbfj)localObject).a(paramView);
        if ((localObject != null) && (((List)localObject).size() > 0)) {
          paramList.addAll((Collection)localObject);
        }
      }
      i += 1;
    }
  }
  
  private void a(View paramView, List<bbfb> paramList, View.OnClickListener paramOnClickListener)
  {
    if (!(paramOnClickListener instanceof bbfg))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ResourceGrabViewModel", 2, "doReplace onClick listener");
      }
      paramView.setOnClickListener(new bbfg(paramList, paramOnClickListener, paramView.isClickable()));
      paramView.setClickable(true);
    }
  }
  
  private void a(HashSet<String> paramHashSet)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramHashSet = paramHashSet.iterator();
      while (paramHashSet.hasNext()) {
        localArrayList.add(new FileInfo((String)paramHashSet.next()));
      }
      ((ansr)BaseActivity.sTopActivity.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(localArrayList);
    }
    catch (Exception paramHashSet)
    {
      QLog.d("ResourceGrabViewModel", 2, paramHashSet, new Object[0]);
      return;
    }
  }
  
  public String a(List<bbfb> paramList)
  {
    paramList = a(paramList);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rootPath: ").append(SkinEngine.getInstances().getSkinRootPath()).append("\n");
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      bbfb localbbfb = (bbfb)paramList.get(i);
      if (localbbfb != null)
      {
        localStringBuilder.append(this.jdField_a_of_type_Bbev.a(localbbfb.jdField_a_of_type_Int)).append(":").append(localbbfb.jdField_a_of_type_ComTencentThemeSkinData.mFileName);
        if (i != j - 1) {
          localStringBuilder.append("\n");
        }
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabViewModel", 2, localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bbev == null)
    {
      this.jdField_a_of_type_Bbev = new bbev();
      this.jdField_a_of_type_Bbev.a();
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Object localObject;
    if ((paramView instanceof ViewGroup))
    {
      localObject = (ViewGroup)paramView;
      int j = ((ViewGroup)localObject).getChildCount();
      int i = 0;
      while (i < j)
      {
        a(((ViewGroup)localObject).getChildAt(i), paramBoolean);
        i += 1;
      }
    }
    View.OnClickListener localOnClickListener;
    try
    {
      localObject = new ArrayList();
      a(paramView, (List)localObject);
      if (((List)localObject).isEmpty()) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ResourceGrabViewModel", 2, "doReplaceOnclickListener success fileName: " + localObject + ", view: " + paramView);
      }
      localOnClickListener = a(paramView);
      if (!paramBoolean)
      {
        a(paramView, localOnClickListener);
        return;
      }
    }
    catch (Throwable paramView)
    {
      QLog.d("ResourceGrabViewModel", 1, paramView, new Object[0]);
      return;
    }
    a(paramView, (List)localObject, localOnClickListener);
  }
  
  void a(List<bbfb> paramList)
  {
    this.jdField_a_of_type_Bbev.a(paramList, new bbff(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfe
 * JD-Core Version:    0.7.0.1
 */