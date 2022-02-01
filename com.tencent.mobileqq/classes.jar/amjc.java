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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;

public class amjc
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener
{
  private int jdField_a_of_type_Int = 0;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  public View.OnClickListener a;
  aofu jdField_a_of_type_Aofu = new amjh(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new amjg(this);
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<amji> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  public View.OnClickListener b;
  private ArrayList<String> b;
  
  public amjc(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, ListView paramListView, String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new amjd(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new amje(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(paramQQAppInterface);
    paramListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
  }
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    Object localObject;
    switch (getItemViewType(paramInt))
    {
    default: 
      return null;
    case 0: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561572, null);
      if (paramViewGroup != null)
      {
        localObject = (TextView)paramViewGroup.findViewById(2131369987);
        if (localObject != null)
        {
          ((TextView)localObject).setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getText(2131719787));
          ((TextView)localObject).setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getText(2131719787));
        }
        return paramViewGroup;
      }
      break;
    case 2: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561571, null);
    case 1: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561573, null);
      if (paramViewGroup != null)
      {
        localObject = new amjj(this);
        ((amjj)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368063));
        ((amjj)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131371803));
        ((amjj)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365538));
        Button localButton = (Button)paramViewGroup.findViewById(2131362157);
        ((amjj)localObject).jdField_a_of_type_AndroidWidgetButton = localButton;
        ((amjj)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131371913));
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
    amji localamji;
    do
    {
      do
      {
        do
        {
          return;
          localObject = getItem(paramInt);
        } while (!(localObject instanceof amji));
        localamji = (amji)localObject;
      } while (paramView == null);
      paramView = paramView.getTag();
    } while ((paramView == null) || (!(paramView instanceof amjj)));
    amjj localamjj = (amjj)paramView;
    String str = String.valueOf(localamji.a.a());
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, str);
    paramView = (View)localObject;
    if (localObject == null)
    {
      localObject = bheg.a();
      paramView = (View)localObject;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(str, 1, false);
        paramView = (View)localObject;
      }
    }
    localamjj.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
    localamjj.jdField_a_of_type_AndroidWidgetTextView.setText(localamji.a.a());
    localamjj.jdField_b_of_type_AndroidWidgetTextView.setText(localamji.a.b());
    localamjj.jdField_a_of_type_JavaLangString = str;
    localamjj.jdField_a_of_type_AndroidWidgetButton.setTag(str);
    localamjj.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(localamji.a.a());
    localamjj.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(localamji.a.b());
    paramView = (bgls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    if (paramView != null) {}
    for (boolean bool = paramView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, this.jdField_a_of_type_JavaLangString);; bool = false)
    {
      if (bool) {
        localamjj.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      while (this.jdField_b_of_type_JavaUtilArrayList.contains(str))
      {
        localamjj.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        localamjj.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693680));
        return;
        localamjj.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      localamjj.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      localamjj.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131689550));
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
        if ((localObject != null) && ((localObject instanceof amjj)))
        {
          localObject = (amjj)localObject;
          if ((paramString != null) && (TextUtils.equals(paramString, ((amjj)localObject).jdField_a_of_type_JavaLangString))) {
            ((amjj)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
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
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131691426);
    switch (paramInt)
    {
    }
    for (;;)
    {
      QQToast.a(BaseApplication.getContext(), 0, str, 1).a();
      return;
      str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131692583);
      continue;
      str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131692584);
      continue;
      str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131691421);
      continue;
      str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131692030);
    }
  }
  
  public void a(AppInterface paramAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    }
  }
  
  public void a(ArrayList<bglr> paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      int i = 0;
      while (i < paramArrayList.size())
      {
        amji localamji = new amji(this, (bglr)paramArrayList.get(i));
        this.jdField_a_of_type_JavaUtilArrayList.add(localamji);
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
 * Qualified Name:     amjc
 * JD-Core Version:    0.7.0.1
 */