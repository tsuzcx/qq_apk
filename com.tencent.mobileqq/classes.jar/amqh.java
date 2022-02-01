import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.adapter.RobotAdapter.5;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;

public class amqh
  extends BaseAdapter
  implements aoog
{
  private int jdField_a_of_type_Int = 0;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  public View.OnClickListener a;
  aojs jdField_a_of_type_Aojs = new amqm(this);
  private aoof jdField_a_of_type_Aoof;
  private blih jdField_a_of_type_Blih = new amql(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<amqn> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  public View.OnClickListener b;
  private ArrayList<String> b;
  
  public amqh(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, ListView paramListView, String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new amqi(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new amqj(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(paramQQAppInterface);
    paramListView.setOnScrollListener(this.jdField_a_of_type_Blih);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aojs);
  }
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    Object localObject;
    switch (getItemViewType(paramInt))
    {
    default: 
      return null;
    case 0: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561630, null);
      if (paramViewGroup != null)
      {
        localObject = (TextView)paramViewGroup.findViewById(2131369828);
        if (localObject != null)
        {
          ((TextView)localObject).setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getText(2131719079));
          ((TextView)localObject).setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getText(2131719079));
        }
        return paramViewGroup;
      }
      break;
    case 2: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561629, null);
    case 1: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561631, null);
      if (paramViewGroup != null)
      {
        localObject = new amqo(this);
        ((amqo)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367895));
        ((amqo)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131371647));
        ((amqo)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365413));
        Button localButton = (Button)paramViewGroup.findViewById(2131362153);
        ((amqo)localObject).jdField_a_of_type_AndroidWidgetButton = localButton;
        ((amqo)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131371761));
        paramViewGroup.setTag(localObject);
        paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      }
      return paramViewGroup;
    }
    return paramViewGroup;
  }
  
  private void a(int paramInt, View paramView)
  {
    switch (getItemViewType(paramInt))
    {
    }
    amqn localamqn;
    do
    {
      do
      {
        do
        {
          return;
          localObject = getItem(paramInt);
        } while (!(localObject instanceof amqn));
        localamqn = (amqn)localObject;
      } while (paramView == null);
      paramView = paramView.getTag();
    } while ((paramView == null) || (!(paramView instanceof amqo)));
    amqo localamqo = (amqo)paramView;
    String str = String.valueOf(localamqn.a.a());
    Object localObject = this.jdField_a_of_type_Aoof.a(1, str);
    paramView = (View)localObject;
    if (localObject == null)
    {
      localObject = bhmq.a();
      paramView = (View)localObject;
      if (!this.jdField_a_of_type_Aoof.a())
      {
        this.jdField_a_of_type_Aoof.a(str, 1, false);
        paramView = (View)localObject;
      }
    }
    localamqo.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
    localamqo.jdField_a_of_type_AndroidWidgetTextView.setText(localamqn.a.a());
    localamqo.jdField_b_of_type_AndroidWidgetTextView.setText(localamqn.a.b());
    localamqo.jdField_a_of_type_JavaLangString = str;
    localamqo.jdField_a_of_type_AndroidWidgetButton.setTag(str);
    localamqo.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(localamqn.a.a());
    localamqo.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(localamqn.a.b());
    paramView = (bgty)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    if (paramView != null) {}
    for (boolean bool = paramView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, this.jdField_a_of_type_JavaLangString);; bool = false)
    {
      if (bool) {
        localamqo.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      while (this.jdField_b_of_type_JavaUtilArrayList.contains(str))
      {
        localamqo.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        localamqo.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693404));
        return;
        localamqo.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      localamqo.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      localamqo.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131689551));
      return;
    }
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
        if ((localObject != null) && ((localObject instanceof amqo)))
        {
          localObject = (amqo)localObject;
          if ((paramString != null) && (TextUtils.equals(paramString, ((amqo)localObject).jdField_a_of_type_JavaLangString))) {
            ((amqo)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new RobotAdapter.5(this, paramString, paramBoolean, paramInt));
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aoof.d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aojs);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131691303);
    switch (paramInt)
    {
    }
    for (;;)
    {
      QQToast.a(BaseApplication.getContext(), 0, str, 1).a();
      return;
      str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131692433);
      continue;
      str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131692434);
      continue;
      str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131691298);
      continue;
      str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131691894);
    }
  }
  
  public void a(AppInterface paramAppInterface)
  {
    if (this.jdField_a_of_type_Aoof == null)
    {
      this.jdField_a_of_type_Aoof = new aoof(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramAppInterface);
      this.jdField_a_of_type_Aoof.a(this);
    }
  }
  
  public void a(ArrayList<bgtx> paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      int i = 0;
      while (i < paramArrayList.size())
      {
        amqn localamqn = new amqn(this, (bgtx)paramArrayList.get(i));
        this.jdField_a_of_type_JavaUtilArrayList.add(localamqn);
        i += 1;
      }
      QLog.d("RobotAdapter", 2, "setData arrayList" + paramArrayList.size());
      super.notifyDataSetChanged();
      return;
    }
    QLog.e("RobotAdapter", 2, "setData null");
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        return 2;
      }
      return this.jdField_a_of_type_JavaUtilArrayList.size() + 1;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (paramInt >= 1)) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      if (paramInt != 0) {}
    }
    while (paramInt == 0)
    {
      return 0;
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = a(paramInt, paramViewGroup);
    }
    for (;;)
    {
      a(paramInt, paramView);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    a(paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqh
 * JD-Core Version:    0.7.0.1
 */