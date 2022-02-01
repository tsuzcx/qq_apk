import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.location.ui.HeadSetView;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;

public class avhc
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private avfq jdField_a_of_type_Avfq;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final HeadSetView jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView;
  private final HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private List<String> jdField_a_of_type_JavaUtilList;
  
  public avhc(QQAppInterface paramQQAppInterface, Context paramContext, HorizontalListView paramHorizontalListView, HeadSetView paramHeadSetView)
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
  
  public void a(avfq paramavfq)
  {
    this.jdField_a_of_type_Avfq = paramavfq;
    this.jdField_a_of_type_Avfq.a(this);
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
    if (this.jdField_a_of_type_Avfq == null) {
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
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559299, null);
      paramView = new avhe(localView);
      if (QLog.isColorLevel()) {
        QLog.d("HeadAdapter", 2, new Object[] { "getView: invoked. ", " position: ", Integer.valueOf(paramInt) });
      }
      paramView.jdField_a_of_type_JavaLangString = str;
      localView.setTag(paramView);
    }
    for (;;)
    {
      localView.setOnClickListener(new avhd(this, str));
      Bitmap localBitmap = this.jdField_a_of_type_Avfq.a(paramView.jdField_a_of_type_JavaLangString);
      Object localObject = localBitmap;
      if (localBitmap == null) {
        localObject = bfvo.a();
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      avgm.a(localView, ContactUtils.getNick(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 0) + "正在共享位置");
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (avhe)paramView.getTag();
      ((avhe)localObject).jdField_a_of_type_JavaLangString = str;
      localView = paramView;
      paramView = (View)localObject;
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
        if (!(localObject instanceof avhe)) {
          break label87;
        }
        localObject = (avhe)localObject;
        if ((paramString == null) || (!paramString.equals(((avhe)localObject).jdField_a_of_type_JavaLangString))) {
          break label87;
        }
        if (paramBitmap != null)
        {
          paramString = this.jdField_a_of_type_Avfq.a(paramString);
          if (paramString != null) {
            ((avhe)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString);
          }
        }
      }
      return;
      label87:
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avhc
 * JD-Core Version:    0.7.0.1
 */