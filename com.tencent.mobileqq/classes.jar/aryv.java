import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.ui.HeadSetView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;

public class aryv
  extends BaseAdapter
  implements baxz
{
  private Context jdField_a_of_type_AndroidContentContext;
  private arxj jdField_a_of_type_Arxj;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final HeadSetView jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView;
  private final HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private List<String> jdField_a_of_type_JavaUtilList;
  
  public aryv(QQAppInterface paramQQAppInterface, Context paramContext, HorizontalListView paramHorizontalListView, HeadSetView paramHeadSetView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView = paramHeadSetView;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  protected static final <T extends View> T a(View paramView, int paramInt)
  {
    return paramView.findViewById(paramInt);
  }
  
  private void b(@NonNull List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(arxj paramarxj)
  {
    this.jdField_a_of_type_Arxj = paramarxj;
    this.jdField_a_of_type_Arxj.a(this);
  }
  
  public void a(@NonNull List<String> paramList)
  {
    if ((this.jdField_a_of_type_JavaUtilList.equals(paramList)) && (QLog.isColorLevel())) {
      QLog.d("HeadAdapter", 2, new Object[] { "notifyDataSetChangedAdvance: invoked. same list, ", " newHeadSetList: ", paramList, " headSetList: ", this.jdField_a_of_type_JavaUtilList });
    }
    b(paramList);
    if (this.jdField_a_of_type_JavaUtilList.size() <= this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView.a()) {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(1);
    }
    for (;;)
    {
      super.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(0);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Arxj == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = (String)getItem(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559171, null);
      paramViewGroup = new aryx(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("HeadAdapter", 2, new Object[] { "getView: invoked. ", " position: ", Integer.valueOf(paramInt) });
      }
      paramViewGroup.jdField_a_of_type_JavaLangString = str;
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramView.setOnClickListener(new aryw(this, str));
      Bitmap localBitmap2 = this.jdField_a_of_type_Arxj.a(paramViewGroup.jdField_a_of_type_JavaLangString);
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null) {
        localBitmap1 = bbef.a();
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
      aryf.a(paramView, bbcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 0) + "正在共享位置");
      return paramView;
      paramViewGroup = (aryx)paramView.getTag();
      paramViewGroup.jdField_a_of_type_JavaLangString = str;
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramInt2 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount();
    paramInt1 = 0;
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(paramInt1).getTag();
        if (!(localObject instanceof aryx)) {
          break label87;
        }
        localObject = (aryx)localObject;
        if ((paramString == null) || (!paramString.equals(((aryx)localObject).jdField_a_of_type_JavaLangString))) {
          break label87;
        }
        if (paramBitmap != null)
        {
          paramString = this.jdField_a_of_type_Arxj.a(paramString);
          if (paramString != null) {
            ((aryx)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString);
          }
        }
      }
      return;
      label87:
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aryv
 * JD-Core Version:    0.7.0.1
 */