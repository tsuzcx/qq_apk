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

public class atua
  extends BaseAdapter
  implements bdbc
{
  private Context jdField_a_of_type_AndroidContentContext;
  private atso jdField_a_of_type_Atso;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final HeadSetView jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView;
  private final HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private List<String> jdField_a_of_type_JavaUtilList;
  
  public atua(QQAppInterface paramQQAppInterface, Context paramContext, HorizontalListView paramHorizontalListView, HeadSetView paramHeadSetView)
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
  
  public void a(atso paramatso)
  {
    this.jdField_a_of_type_Atso = paramatso;
    this.jdField_a_of_type_Atso.a(this);
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
    if (this.jdField_a_of_type_Atso == null) {
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
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559213, null);
      paramViewGroup = new atuc(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("HeadAdapter", 2, new Object[] { "getView: invoked. ", " position: ", Integer.valueOf(paramInt) });
      }
      paramViewGroup.jdField_a_of_type_JavaLangString = str;
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramView.setOnClickListener(new atub(this, str));
      Bitmap localBitmap2 = this.jdField_a_of_type_Atso.a(paramViewGroup.jdField_a_of_type_JavaLangString);
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null) {
        localBitmap1 = bdhj.a();
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
      attk.a(paramView, bdgc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 0) + "正在共享位置");
      return paramView;
      paramViewGroup = (atuc)paramView.getTag();
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
        if (!(localObject instanceof atuc)) {
          break label87;
        }
        localObject = (atuc)localObject;
        if ((paramString == null) || (!paramString.equals(((atuc)localObject).jdField_a_of_type_JavaLangString))) {
          break label87;
        }
        if (paramBitmap != null)
        {
          paramString = this.jdField_a_of_type_Atso.a(paramString);
          if (paramString != null) {
            ((atuc)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString);
          }
        }
      }
      return;
      label87:
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atua
 * JD-Core Version:    0.7.0.1
 */